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
import com.hivemq.edge.adapters.plc4x.config.Plc4XSpecificAdapterConfig;
import com.hivemq.edge.adapters.plc4x.config.Plc4xToMqttConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class S7SpecificAdapterConfig extends Plc4XSpecificAdapterConfig<Plc4xToMqttConfig>  {

    private static final int PORT_MIN = 1;
    private static final int PORT_MAX = 65535;

    public enum ControllerType {
        S7_300,
        S7_400,
        S7_1200,
        S7_1500,
        LOGO
    }

    @JsonProperty(value = "port", required = true)
    @ModuleConfigField(title = "Port",
                       description = "The port number on the device you wish to connect to",
                       required = true,
                       numberMin = PORT_MIN,
                       numberMax = PORT_MAX,
                       defaultValue = "102")
    private final int port;

    @JsonProperty(value = "controllerType", required = true)
    @ModuleConfigField(title = "S7 Controller Type",
                       description = "The type of the S7 Controller",
                       required = true,
                       defaultValue = "S7_300")
    private final @NotNull S7SpecificAdapterConfig.ControllerType controllerType;

    @JsonProperty("remoteRack")
    @ModuleConfigField(title = "Remote Rack",
                       description = "Rack value for the remote main CPU (PLC).",
                       defaultValue = "0")
    private final int remoteRack;

    @JsonProperty("remoteRack2")
    @ModuleConfigField(title = "Remote Rack 2",
                       description = "Rack value for the remote secondary CPU (PLC).",
                       defaultValue = "0")
    private final int remoteRack2;

    @JsonProperty("remoteSlot")
    @ModuleConfigField(title = "Remote Slot",
                       description = "Slot value for the remote main CPU (PLC).",
                       defaultValue = "0")
    private final int remoteSlot;

    @JsonProperty("remoteSlot2")
    @ModuleConfigField(title = "Remote Slot 2",
                       description = "Slot value for the remote secondary CPU (PLC).",
                       defaultValue = "0")
    private final int remoteSlot2;

    @JsonProperty("remoteTsap")
    @ModuleConfigField(title = "Remote TSAP",
                       description = "Remote TSAP value. The TSAP (Transport Services Access Point) mechanism is used as a further addressing level in the S7 PLC network. Usually only required for PLC from the LOGO series.",
                       defaultValue = "0")
    private final int remoteTsap;

    @JsonProperty(value = "s7ToMqtt", required = true)
    @ModuleConfigField(title = "S7 To MQTT Config",
                       description = "The configuration for a data stream from S7 to MQTT",
                       required = true)
    private final @Nullable S7ToMqttConfig s7ToMqttConfig;

    @JsonCreator
    public S7SpecificAdapterConfig(
            @JsonProperty(value = "port", required = true) final int port,
            @JsonProperty(value = "host", required = true) final @NotNull String host,
            @JsonProperty(value = "controllerType", required = true) final @NotNull ControllerType controllerType,
            @JsonProperty(value = "remoteRack") final @Nullable Integer remoteRack,
            @JsonProperty(value = "remoteRack2") final @Nullable Integer remoteRack2,
            @JsonProperty(value = "remoteSlot") final @Nullable Integer remoteSlot,
            @JsonProperty(value = "remoteSlot2") final @Nullable Integer remoteSlot2,
            @JsonProperty(value = "remoteTsap") final @Nullable Integer remoteTsap,
            @JsonProperty(value = "s7ToMqtt") final @Nullable S7ToMqttConfig s7ToMqttConfig) {
        super(port, host);
        this.port = port;
        this.controllerType = controllerType;
        this.remoteRack = Objects.requireNonNullElse(remoteRack, 0);
        this.remoteRack2 = Objects.requireNonNullElse(remoteRack2, 0);
        this.remoteSlot = Objects.requireNonNullElse(remoteSlot, 0);
        this.remoteSlot2 = Objects.requireNonNullElse(remoteSlot2, 0);
        this.remoteTsap = Objects.requireNonNullElse(remoteTsap, 0);
        if (s7ToMqttConfig == null) {
            this.s7ToMqttConfig = new S7ToMqttConfig(null, null, null);
        } else {
            this.s7ToMqttConfig = s7ToMqttConfig;
        }

    }

    @Override
    public int getPort() {
        return port;
    }

    public int getRemoteRack() {
        return remoteRack;
    }

    public int getRemoteRack2() {
        return remoteRack2;
    }

    public int getRemoteSlot() {
        return remoteSlot;
    }

    public int getRemoteSlot2() {
        return remoteSlot2;
    }

    public int getRemoteTsap() {
        return remoteTsap;
    }

    public @NotNull ControllerType getControllerType() {
        return controllerType;
    }

    @Override
    public @Nullable Plc4xToMqttConfig getPlc4xToMqttConfig() {
        return s7ToMqttConfig;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final S7SpecificAdapterConfig that = (S7SpecificAdapterConfig) o;
        return getPort() == that.getPort() &&
                getRemoteRack() == that.getRemoteRack() &&
                getRemoteRack2() == that.getRemoteRack2() &&
                getRemoteSlot() == that.getRemoteSlot() &&
                getRemoteSlot2() == that.getRemoteSlot2() &&
                getRemoteTsap() == that.getRemoteTsap() &&
                getControllerType() == that.getControllerType() &&
                Objects.equals(s7ToMqttConfig, that.s7ToMqttConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPort(),
                getControllerType(),
                getRemoteRack(),
                getRemoteRack2(),
                getRemoteSlot(),
                getRemoteSlot2(),
                getRemoteTsap(),
                s7ToMqttConfig);
    }
}
