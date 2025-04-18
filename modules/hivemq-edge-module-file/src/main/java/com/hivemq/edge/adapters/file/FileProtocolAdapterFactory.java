/*
 * Copyright 2023-present HiveMQ GmbH
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.hivemq.edge.adapters.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.adapter.sdk.api.ProtocolAdapter;
import com.hivemq.adapter.sdk.api.ProtocolAdapterInformation;
import com.hivemq.adapter.sdk.api.config.legacy.ConfigTagsTuple;
import com.hivemq.adapter.sdk.api.config.legacy.LegacyConfigConversion;
import com.hivemq.adapter.sdk.api.factories.ProtocolAdapterFactory;
import com.hivemq.adapter.sdk.api.factories.ProtocolAdapterFactoryInput;
import com.hivemq.adapter.sdk.api.model.ProtocolAdapterInput;
import com.hivemq.edge.adapters.file.config.FileSpecificAdapterConfig;
import com.hivemq.edge.adapters.file.config.FileToMqttConfig;
import com.hivemq.edge.adapters.file.config.FileToMqttMapping;
import com.hivemq.edge.adapters.file.config.legacy.LegacyFileAdapterConfig;
import com.hivemq.edge.adapters.file.config.legacy.LegacyFilePollingContext;
import com.hivemq.edge.adapters.file.tag.FileTag;
import com.hivemq.edge.adapters.file.tag.FileTagDefinition;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FileProtocolAdapterFactory
        implements ProtocolAdapterFactory<FileSpecificAdapterConfig>, LegacyConfigConversion {

    private static final @NotNull Logger log = LoggerFactory.getLogger(FileProtocolAdapterFactory.class);

    final boolean writingEnabled;

    public FileProtocolAdapterFactory(final @NotNull ProtocolAdapterFactoryInput input) {
        this.writingEnabled = input.isWritingEnabled();
    }

    @Override
    public @NotNull ProtocolAdapterInformation getInformation() {
        return FileProtocolAdapterInformation.INSTANCE;
    }

    @Override
    public @NotNull ProtocolAdapter createAdapter(
            final @NotNull ProtocolAdapterInformation adapterInformation,
            final @NotNull ProtocolAdapterInput<FileSpecificAdapterConfig> input) {
        return new FilePollingProtocolAdapter(input.getAdapterId(), adapterInformation, input);
    }

    @Override
    @NotNull
    public ConfigTagsTuple tryConvertLegacyConfig(
            @NotNull ObjectMapper objectMapper, @NotNull Map<String, Object> config) {
        final LegacyFileAdapterConfig legacyFileAdapterConfig =
                objectMapper.convertValue(config, LegacyFileAdapterConfig.class);

        final List<FileToMqttMapping> fileToMqttMappings = new ArrayList<>();
        final List<FileTag> tags = new ArrayList<>();
        for (final LegacyFilePollingContext context : legacyFileAdapterConfig.getPollingContexts()) {
            // create tag first
            final String newTagName = legacyFileAdapterConfig.getId() + "-" + UUID.randomUUID();
            tags.add(new FileTag(newTagName,
                    "not set",
                    new FileTagDefinition(context.getFilePath(), context.getContentType())));
            final FileToMqttMapping fileToMqttMapping = new FileToMqttMapping(context.getDestinationMqttTopic(),
                    context.getQos(),
                    context.getMessageHandlingOptions(),
                    context.getIncludeTimestamp(),
                    context.getIncludeTagNames(),
                    context.getUserProperties(),
                    newTagName);
            fileToMqttMappings.add(fileToMqttMapping);
        }

        final FileToMqttConfig fileToMqttConfig =
                new FileToMqttConfig(legacyFileAdapterConfig.getPollingIntervalMillis(),
                        legacyFileAdapterConfig.getMaxPollingErrorsBeforeRemoval(),
                        fileToMqttMappings);

        return new ConfigTagsTuple(legacyFileAdapterConfig.getId(),
                new FileSpecificAdapterConfig(fileToMqttConfig),
                tags,
                fileToMqttMappings);
    }
}
