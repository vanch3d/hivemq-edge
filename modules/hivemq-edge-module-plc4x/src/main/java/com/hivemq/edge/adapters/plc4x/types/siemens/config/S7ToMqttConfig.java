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
package com.hivemq.edge.adapters.plc4x.types.siemens.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hivemq.adapter.sdk.api.annotations.ModuleConfigField;
import com.hivemq.edge.adapters.plc4x.config.Plc4xToMqttConfig;
import com.hivemq.edge.adapters.plc4x.config.Plc4xToMqttMapping;
import com.hivemq.edge.adapters.plc4x.types.ads.config.ADSToMqttConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class S7ToMqttConfig extends Plc4xToMqttConfig {

    @JsonCreator
    public S7ToMqttConfig(
            @JsonProperty(value = "pollingIntervalMillis") final @Nullable Integer pollingIntervalMillis,
            @JsonProperty(value = "maxPollingErrorsBeforeRemoval") final @Nullable Integer maxPollingErrorsBeforeRemoval,
            @JsonProperty(value = "publishChangedDataOnly") final @Nullable Boolean publishChangedDataOnly) {
        super(pollingIntervalMillis, maxPollingErrorsBeforeRemoval, publishChangedDataOnly);
    }


    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final S7ToMqttConfig that = (S7ToMqttConfig) o;
        return getPollingIntervalMillis() == that.getPollingIntervalMillis() &&
                getMaxPollingErrorsBeforeRemoval() == that.getMaxPollingErrorsBeforeRemoval() &&
                getPublishChangedDataOnly() == that.getPublishChangedDataOnly();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPollingIntervalMillis(),
                getMaxPollingErrorsBeforeRemoval(),
                getPublishChangedDataOnly());
    }
}
