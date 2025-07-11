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
package com.hivemq.configuration.entity.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.configuration.entity.EntityValidatable;
import com.hivemq.configuration.entity.adapter.fieldmapping.FieldMappingEntity;
import com.hivemq.edge.api.model.FieldMapping;
import com.hivemq.edge.api.model.Instruction;
import com.hivemq.persistence.mappings.SouthboundMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("unused")
public class SouthboundMappingEntity implements EntityValidatable {

    @XmlElement(name = "topicFilter", required = true)
    private final @NotNull String topicFilter;

    @XmlElement(name = "tagName", required = true)
    private final @NotNull String tagName;

    @XmlElement(name = "fieldMapping", required = true)
    private final @Nullable FieldMappingEntity fieldMapping;

    @XmlElement(name = "fromNorthSchema", required = true)
    private final @NotNull String fromNorthSchema;

    // no-arg constructor for JaxB
    public SouthboundMappingEntity() {
        topicFilter = "";
        tagName = "";
        fieldMapping = null;
        fromNorthSchema = "";
    }

    public SouthboundMappingEntity(
            final @NotNull String tagName,
            final @NotNull String topicFilter,
            final @NotNull FieldMappingEntity fieldMapping,
            final @NotNull String fromNorthSchema) {
        this.tagName = tagName;
        this.topicFilter = topicFilter;
        this.fieldMapping = fieldMapping;
        this.fromNorthSchema = fromNorthSchema;
    }

    public @NotNull String getTagName() {
        return tagName;
    }

    public @NotNull String getTopicFilter() {
        return topicFilter;
    }

    @Override
    public void validate(final @NotNull List<ValidationEvent> validationEvents) {
        EntityValidatable.notEmpty(validationEvents, topicFilter, "topicFilter");
        EntityValidatable.notEmpty(validationEvents, tagName, "tagName");
        EntityValidatable.notEmpty(validationEvents, fromNorthSchema, "fromNorthSchema");
        Optional.ofNullable(fieldMapping).ifPresent(entity -> entity.validate(validationEvents));
    }

    public @NotNull SouthboundMapping toPersistence(final @NotNull ObjectMapper mapper) {
        return new SouthboundMapping(
                this.getTagName(),
                this.getTopicFilter(),
                this.fieldMapping != null ? this.fieldMapping.to(mapper) : null,
                this.fromNorthSchema);
    }

    public @NotNull com.hivemq.edge.api.model.SouthboundMapping toAPi() {
        return com.hivemq.edge.api.model.SouthboundMapping
                .builder()
                .tagName(this.getTagName())
                .topicFilter(this.getTopicFilter())
                .fieldMapping(this.fieldMapping != null ?
                        FieldMapping
                                .builder()
                                .instructions(
                                        this.fieldMapping.getInstructions().stream()
                                            .map(instruction ->
                                                    (Instruction)Instruction
                                                        .builder()
                                                            .destination(instruction.getDestinationFieldName())
                                                            .source(instruction.getSourceFieldName())
                                                        .build()).toList()).build() : null).build();
    }

    public static @NotNull SouthboundMappingEntity fromPersistence(final @NotNull SouthboundMapping southboundMapping) {
        return new SouthboundMappingEntity(
                southboundMapping.getTagName(),
                southboundMapping.getTopicFilter(),
                FieldMappingEntity.from(southboundMapping.getFieldMapping()),
                southboundMapping.getSchema());
    }

    public static @NotNull SouthboundMappingEntity fromApi(final @NotNull com.hivemq.edge.api.model.SouthboundMapping southboundMapping, final @NotNull String schema) {
        return new SouthboundMappingEntity(
                southboundMapping.getTagName(),
                southboundMapping.getTopicFilter(),
                FieldMappingEntity.from(southboundMapping.getFieldMapping()),
                schema);
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SouthboundMappingEntity that = (SouthboundMappingEntity) o;
        return Objects.equals(getTopicFilter(), that.getTopicFilter()) &&
                Objects.equals(getTagName(), that.getTagName()) &&
                Objects.equals(fieldMapping, that.fieldMapping) &&
                Objects.equals(fromNorthSchema, that.fromNorthSchema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopicFilter(), getTagName(), fieldMapping, fromNorthSchema);
    }
}
