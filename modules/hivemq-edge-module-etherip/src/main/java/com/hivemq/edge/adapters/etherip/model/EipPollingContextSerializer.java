/*
 * Copyright 2023-present HiveMQ GmbH
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
package com.hivemq.edge.adapters.etherip.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class EipPollingContextSerializer extends JsonSerializer<List<EipToMqttMapping>> {

    @Override
    public void serialize(
            final @NotNull List<EipToMqttMapping> value,
            final @NotNull JsonGenerator gen,
            final @NotNull SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        for (final EipToMqttMapping pollingContext : value) {
            gen.writeStartObject();
            gen.writeObjectField("eipToMqttMapping", pollingContext);
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
