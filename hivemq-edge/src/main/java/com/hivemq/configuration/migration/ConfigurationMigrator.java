/*
 * Copyright 2019-present HiveMQ GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hivemq.configuration.migration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.adapter.sdk.api.config.legacy.ConfigTagsTuple;
import com.hivemq.adapter.sdk.api.config.legacy.LegacyConfigConversion;
import com.hivemq.adapter.sdk.api.factories.ProtocolAdapterFactory;
import com.hivemq.configuration.entity.HiveMQConfigEntity;
import com.hivemq.configuration.entity.adapter.NorthboundMappingEntity;
import com.hivemq.configuration.entity.adapter.ProtocolAdapterEntity;
import com.hivemq.configuration.entity.adapter.TagEntity;
import com.hivemq.configuration.info.SystemInformation;
import com.hivemq.configuration.ioc.ConfigurationFileProvider;
import com.hivemq.configuration.reader.ConfigurationFile;
import com.hivemq.configuration.reader.LegacyConfigFileReaderWriter;
import com.hivemq.edge.impl.events.EventServiceDelegateImpl;
import com.hivemq.edge.impl.events.InMemoryEventImpl;
import com.hivemq.edge.modules.ModuleLoader;
import com.hivemq.exceptions.UnrecoverableException;
import com.hivemq.protocols.ProtocolAdapterFactoryManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
@Singleton
public class ConfigurationMigrator {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationMigrator.class);
    private final @NotNull ModuleLoader moduleLoader;
    private final @NotNull LegacyConfigFileReaderWriter<LegacyHiveMQConfigEntity, HiveMQConfigEntity>
            legacyConfigFileReaderWriter;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final @NotNull ConfigurationFile configurationFile;

    public static final String XSLT_INPUT = "\n" +
            "<xsl:stylesheet version=\"1.0\"\n" +
            "                xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
            "    <xsl:template match=\"/\">\n" +
            "            <xsl:for-each select=\"/hivemq/protocol-adapters/*[not(starts-with(local-name(),'protocol-adapter'))]\">\n" +
            "                        <xsl:value-of select=\"name()\"/>" +
            "            </xsl:for-each>\n" +
            "    </xsl:template>\n" +
            "</xsl:stylesheet>\n";


    @Inject
    public ConfigurationMigrator(
            final @NotNull SystemInformation systemInformation, final @NotNull ModuleLoader moduleLoader) {
        this(ConfigurationFileProvider.get(systemInformation), moduleLoader);
    }

    @VisibleForTesting
    public ConfigurationMigrator(
            final @NotNull ConfigurationFile configurationFile,
            final @NotNull ModuleLoader moduleLoader) {
        this.moduleLoader = moduleLoader;
        moduleLoader.loadModules();
        this.configurationFile = configurationFile;
        this.legacyConfigFileReaderWriter = new LegacyConfigFileReaderWriter<>(configurationFile,
                LegacyHiveMQConfigEntity.class,
                HiveMQConfigEntity.class);
        objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, false);
    }

    public void migrate() {
        try {
            final EventServiceDelegateImpl eventService = new EventServiceDelegateImpl(new InMemoryEventImpl());
            final Map<String, ProtocolAdapterFactory<?>> factoryMap =
                    ProtocolAdapterFactoryManager.findAllAdapters(moduleLoader, eventService, true);
            migrateIfNeeded(factoryMap).ifPresent(legacyConfigFileReaderWriter::writeConfigToXML);
        } catch (final Exception e) {
            log.error("[CONFIG MIGRATION] An exception was raised during automatic migration of the configuration file.");
            log.debug("Original Exception:", e);
        }
    }

    @VisibleForTesting
    public @NotNull Optional<HiveMQConfigEntity> migrateIfNeeded(final @NotNull Map<String, ProtocolAdapterFactory<?>> factoryMap) {
        try {
            if (!needsMigration(configurationFile)) {
                log.debug("No configuration migration needed.");
                return Optional.empty();
            }

            final LegacyHiveMQConfigEntity legacyHiveMQConfigEntity = legacyConfigFileReaderWriter.readConfigFromXML();
            final Map<String, Object> protocolAdapterConfig = legacyHiveMQConfigEntity.getProtocolAdapterConfig();
            final List<ProtocolAdapterEntity> protocolAdapterEntities = protocolAdapterConfig.entrySet()
                    .stream()
                    .flatMap(entry -> parseProtocolAdapterEntity(entry, factoryMap).stream())
                    .collect(Collectors.toList());

            return Optional.of(legacyHiveMQConfigEntity.to(protocolAdapterEntities));
        } catch (final Exception e) {
            log.error("[CONFIG MIGRATION] An exception was raised during automatic migration of the configuration file.");
            log.debug("Original Exception:", e);
        }
        return Optional.empty();
    }

    private @NotNull List<ProtocolAdapterEntity> parseProtocolAdapterEntity(
            final Map.Entry<String, Object> stringObjectEntry,
            final Map<String, ProtocolAdapterFactory<?>> factoryMap) {
        final String protocolId = stringObjectEntry.getKey();
        final ProtocolAdapterFactory<?> protocolAdapterFactory = factoryMap.get(protocolId);
        if (protocolAdapterFactory == null) {
            // not much we can do here. We do not have the factory to get the necessary information from
            log.error(
                    "[CONFIG MIGRATION] While migration the configuration, no protocol factory for protocolId '{}' was found. This adapter will be skipped and must be migrated by hand.",
                    protocolId);
            return List.of();
        }

        if (protocolAdapterFactory instanceof LegacyConfigConversion) {
            final LegacyConfigConversion adapterFactory = (LegacyConfigConversion) protocolAdapterFactory;
            final Object value = stringObjectEntry.getValue();

            if (value instanceof List) {
                // this means that the config had two adapters with the same protocol id. We need to recursively call and add it to a collection
                final List<ProtocolAdapterEntity> parsedEntries = new ArrayList<>();
                for (final Object adapterEntry : (List) value) {
                    if (adapterEntry instanceof Map) {
                        final List<ProtocolAdapterEntity> parsed =
                                parseProtocolAdapterEntity(new AbstractMap.SimpleEntry<>(protocolId, adapterEntry),
                                        factoryMap);
                        parsedEntries.addAll(parsed);
                    } else {
                        log.error("List contained unexpected object of class '{}', 'Map' was expected",
                                adapterEntry.getClass().getSimpleName());
                        throw new UnrecoverableException(false);
                    }
                }
                return parsedEntries;
            }

            if (!(value instanceof Map)) {
                throw new IllegalArgumentException();
            }


            final ConfigTagsTuple configTagsTuple =
                    adapterFactory.tryConvertLegacyConfig(objectMapper, (Map<String, Object>) value);
            final List<NorthboundMappingEntity> northboundMappingEntities = configTagsTuple.getPollingContexts()
                    .stream()
                    .map(NorthboundMappingEntity::fromPollingContext)
                    .collect(Collectors.toList());

            final List<TagEntity> tagEntities = configTagsTuple.getTags()
                    .stream()
                    .map(tag -> TagEntity.fromAdapterTag(tag, objectMapper))
                    .collect(Collectors.toList());

            // The default tag name of the northbound mapping entity is "ignored" which is not added to the tag entities.
            // We add the default tag name to the tag entities here to avoid failures in further validation.
            final Set<String> tagNameSet = tagEntities.stream().map(TagEntity::getName).collect(Collectors.toSet());
            northboundMappingEntities.stream()
                    .map(NorthboundMappingEntity::getTagName)
                    .filter(tagName -> !tagNameSet.contains(tagName))
                    .forEach(tagName -> {
                        tagNameSet.add(tagName);
                        tagEntities.add(new TagEntity(tagName, "", Map.of()));
                    });

            return List.of(new ProtocolAdapterEntity(configTagsTuple.getAdapterId(),
                    protocolId,
                    protocolAdapterFactory.getInformation().getCurrentConfigVersion(),
                    objectMapper.convertValue(configTagsTuple.getConfig(), new TypeReference<>() {
                    }),
                    northboundMappingEntities,
                    List.of(),
                    tagEntities));
        } else {
            log.error(
                    "[CONFIG MIGRATION] A legacy config for protocolId '{}' was found during migration, but the adapter factory does not implement the necessary interface '{}' for automatic migration.",
                    protocolId,
                    LegacyConfigConversion.class.getSimpleName());
            return List.of();
        }
    }


    @VisibleForTesting
    static boolean needsMigration(final @NotNull ConfigurationFile configurationFile) {
        try {
            final File configFile = configurationFile.file().get();
            final Source xmlSource = new StreamSource(configFile);
            final Source xsltSource =
                    new StreamSource(new ByteArrayInputStream(XSLT_INPUT.getBytes(StandardCharsets.UTF_8)));
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer(xsltSource);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            final StringWriter stringWriter = new StringWriter();
            final StreamResult result = new StreamResult(stringWriter);
            transformer.transform(xmlSource, result);
            return !stringWriter.getBuffer().toString().isBlank();
        } catch (final TransformerException e) {
            log.error(
                    "[CONFIG MIGRATION] Exception while determining whether a config migration is needed. No automatic config migration will happen.");
            log.debug("Original Exception:", e);
            return false;
        }
    }

}
