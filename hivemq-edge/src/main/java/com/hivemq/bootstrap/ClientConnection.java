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
package com.hivemq.bootstrap;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.SettableFuture;
import com.hivemq.configuration.service.entity.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.hivemq.extension.sdk.api.client.parameter.ClientInformation;
import com.hivemq.extension.sdk.api.client.parameter.ConnectionInformation;
import com.hivemq.extension.sdk.api.packets.auth.ModifiableDefaultPermissions;
import com.hivemq.extensions.client.ClientAuthenticators;
import com.hivemq.extensions.client.ClientAuthorizers;
import com.hivemq.extensions.client.ClientContextImpl;
import com.hivemq.extensions.client.parameter.ConnectionAttributes;
import com.hivemq.extensions.events.client.parameters.ClientEventListeners;
import com.hivemq.mqtt.handler.publish.PublishFlushHandler;
import com.hivemq.mqtt.message.ProtocolVersion;
import com.hivemq.mqtt.message.connect.CONNECT;
import com.hivemq.mqtt.message.connect.MqttWillPublish;
import com.hivemq.mqtt.message.mqtt5.Mqtt5UserProperties;
import com.hivemq.mqtt.message.pool.FreePacketIdRanges;
import com.hivemq.security.auth.SslClientCertificate;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientConnection {

    /**
     * The name of the {@link Channel} attribute which the client connection information is stored in.
     */
    public static final AttributeKey<ClientConnection> CHANNEL_ATTRIBUTE_NAME =
            AttributeKey.valueOf("Client.Connection");

    private final @NotNull Channel channel;
    private final @NotNull PublishFlushHandler publishFlushHandler;
    private volatile @NotNull ClientState clientState = ClientState.CONNECTING;
    private @Nullable ProtocolVersion protocolVersion;
    private @Nullable String clientId;
    private boolean cleanStart;
    private @Nullable ModifiableDefaultPermissions authPermissions;
    private @Nullable Listener connectedListener;
    private @Nullable MqttWillPublish willPublish;
    private @Nullable AtomicInteger inFlightMessageCount;
    private @Nullable Integer clientReceiveMaximum;
    private @Nullable Integer connectKeepAlive;
    private @Nullable Long queueSizeMaximum;
    private @Nullable Long clientSessionExpiryInterval;
    private @Nullable Long connectReceivedTimestamp;
    private @Nullable Long maxPacketSizeSend;
    private @Nullable String[] topicAliasMapping;
    private boolean noSharedSubscription;
    private boolean clientIdAssigned;
    private boolean incomingPublishesSkipRest;
    private boolean incomingPublishesDefaultFailedSkipRest;
    private boolean requestResponseInformation;
    private @Nullable Boolean requestProblemInformation;
    private @Nullable SettableFuture<Void> disconnectFuture;
    private final @NotNull FreePacketIdRanges messageIDPool;

    private @Nullable ConnectionAttributes connectionAttributes;

    private boolean sendWill = true;
    private boolean preventLwt;
    private boolean inFlightMessagesSent;

    private @Nullable SslClientCertificate authCertificate;
    private @Nullable String authSniHostname;
    private @Nullable String authCipherSuite;
    private @Nullable String authProtocol;
    private @Nullable String authUsername;
    private byte @Nullable [] authPassword;
    private @Nullable CONNECT authConnect;
    private @Nullable String authMethod;
    private @Nullable ByteBuffer authData;
    private @Nullable Mqtt5UserProperties authUserProperties;
    private @Nullable ScheduledFuture<?> authFuture;
    private @Nullable Boolean clearPasswordAfterAuth;

    private @Nullable ClientContextImpl extensionClientContext;
    private @Nullable ClientEventListeners extensionClientEventListeners;
    private @Nullable ClientAuthenticators extensionClientAuthenticators;
    private @Nullable ClientAuthorizers extensionClientAuthorizers;
    private @Nullable ClientInformation extensionClientInformation;
    private @Nullable ConnectionInformation extensionConnectionInformation;
    private @NotNull HashMap<String, Object> additionalInformation;

    public ClientConnection(final @NotNull Channel channel, final @NotNull PublishFlushHandler publishFlushHandler) {
        this.channel = channel;
        this.publishFlushHandler = publishFlushHandler;
        messageIDPool = new FreePacketIdRanges();
        this.additionalInformation = new HashMap<>();
    }

    public @NotNull Channel getChannel() {
        return channel;
    }

    public @NotNull PublishFlushHandler getPublishFlushHandler() {
        return publishFlushHandler;
    }

    public @NotNull ClientState getClientState() {
        return clientState;
    }

    public void proposeClientState(final @NotNull ClientState clientState) {
        if (!this.clientState.disconnected()) {
            this.clientState = clientState;
        }
    }

    // ONLY VISIBLE FOR TESTING !!!
    // DO NOT USE IN PROD !!!
    @VisibleForTesting()
    public void setClientStateUnsafe(final @NotNull ClientState clientState) {
        this.clientState = clientState;
    }

    public @Nullable ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(final @Nullable ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public @Nullable String getClientId() {
        return clientId;
    }

    public void setClientId(final @Nullable String clientId) {
        this.clientId = clientId;
    }

    public boolean isCleanStart() {
        return cleanStart;
    }

    public void setCleanStart(final boolean cleanStart) {
        this.cleanStart = cleanStart;
    }

    public @Nullable ModifiableDefaultPermissions getAuthPermissions() {
        return authPermissions;
    }

    public void setAuthPermissions(final @NotNull ModifiableDefaultPermissions authPermissions) {
        this.authPermissions = authPermissions;
    }

    /**
     * This key contains the actual listener a client connected to.
     */
    public @Nullable Listener getConnectedListener() {
        return connectedListener;
    }

    public void setConnectedListener(final @Nullable Listener connectedListener) {
        this.connectedListener = connectedListener;
    }

    public @Nullable MqttWillPublish getWillPublish() {
        return willPublish;
    }

    public void setWillPublish(final @Nullable MqttWillPublish willPublish) {
        this.willPublish = willPublish;
    }

    /**
     * The amount of messages that have been polled but not yet delivered.
     */
    public @Nullable AtomicInteger getInFlightMessageCount() {
        return inFlightMessageCount;
    }

    public void setInFlightMessageCount(final @Nullable AtomicInteger inFlightMessageCount) {
        this.inFlightMessageCount = inFlightMessageCount;
    }

    public @Nullable Integer getClientReceiveMaximum() {
        return clientReceiveMaximum;
    }

    public void setClientReceiveMaximum(final @Nullable Integer clientReceiveMaximum) {
        this.clientReceiveMaximum = clientReceiveMaximum;
    }

    public @Nullable Integer getConnectKeepAlive() {
        return connectKeepAlive;
    }

    public void setConnectKeepAlive(final @Nullable Integer connectKeepAlive) {
        this.connectKeepAlive = connectKeepAlive;
    }

    public @Nullable Long getQueueSizeMaximum() {
        return queueSizeMaximum;
    }

    public void setQueueSizeMaximum(final @Nullable Long queueSizeMaximum) {
        this.queueSizeMaximum = queueSizeMaximum;
    }

    public @NotNull FreePacketIdRanges getMessageIDPool() {
        return messageIDPool;
    }

    /**
     * The amount of messages that have been polled but not yet delivered.
     */
    public int inFlightMessageCount() {
        if (inFlightMessageCount == null) {
            return 0;
        }
        return inFlightMessageCount.get();
    }

    public int decrementInFlightCount() {
        if (inFlightMessageCount == null) {
            return 0;
        }
        return inFlightMessageCount.decrementAndGet();
    }

    public int incrementInFlightCount() {
        if (inFlightMessageCount == null) {
            inFlightMessageCount = new AtomicInteger(0);
        }
        return inFlightMessageCount.incrementAndGet();
    }

    public int incrementInFlightCount(int count) {
        if (inFlightMessageCount == null) {
            inFlightMessageCount = new AtomicInteger(0);
        }
        return inFlightMessageCount.addAndGet(count);
    }

    /**
     * Attribute for storing the client session expiry interval.
     */
    public @Nullable Long getClientSessionExpiryInterval() {
        return clientSessionExpiryInterval;
    }

    public void setClientSessionExpiryInterval(final @Nullable Long clientSessionExpiryInterval) {
        this.clientSessionExpiryInterval = clientSessionExpiryInterval;
    }

    /**
     * The time at which the clients CONNECT message was received by the broker.
     */
    public @Nullable Long getConnectReceivedTimestamp() {
        return connectReceivedTimestamp;
    }

    public void setConnectReceivedTimestamp(final @Nullable Long connectReceivedTimestamp) {
        this.connectReceivedTimestamp = connectReceivedTimestamp;
    }

    public @Nullable Long getMaxPacketSizeSend() {
        return maxPacketSizeSend;
    }

    public void setMaxPacketSizeSend(final @Nullable Long maxPacketSizeSend) {
        this.maxPacketSizeSend = maxPacketSizeSend;
    }

    public @Nullable String[] getTopicAliasMapping() {
        return topicAliasMapping;
    }

    public void setTopicAliasMapping(final @Nullable String[] topicAliasMapping) {
        this.topicAliasMapping = topicAliasMapping;
    }

    /**
     * True if it is guarantied that this client has no shared subscriptions, if false it is unclear.
     */
    public boolean getNoSharedSubscription() {
        return noSharedSubscription;
    }

    public void setNoSharedSubscription(final boolean noSharedSubscription) {
        this.noSharedSubscription = noSharedSubscription;
    }

    public boolean isClientIdAssigned() {
        return clientIdAssigned;
    }

    public void setClientIdAssigned(final boolean clientIdAssigned) {
        this.clientIdAssigned = clientIdAssigned;
    }

    /**
     * True if this client is not allowed to publish any more messages, if false he is allowed to do so.
     */
    public boolean isIncomingPublishesSkipRest() {
        return incomingPublishesSkipRest;
    }

    public void setIncomingPublishesSkipRest(final boolean incomingPublishesSkipRest) {
        this.incomingPublishesSkipRest = incomingPublishesSkipRest;
    }

    /**
     * True if this client is not allowed to publish any more messages by default, if false he is allowed to do so.
     */
    public boolean isIncomingPublishesDefaultFailedSkipRest() {
        return incomingPublishesDefaultFailedSkipRest;
    }

    public void setIncomingPublishesDefaultFailedSkipRest(final boolean incomingPublishesDefaultFailedSkipRest) {
        this.incomingPublishesDefaultFailedSkipRest = incomingPublishesDefaultFailedSkipRest;
    }

    public boolean isRequestResponseInformation() {
        return requestResponseInformation;
    }

    public void setRequestResponseInformation(final boolean requestResponseInformation) {
        this.requestResponseInformation = requestResponseInformation;
    }

    public @Nullable Boolean getRequestProblemInformation() {
        return requestProblemInformation;
    }

    public void setRequestProblemInformation(final @Nullable Boolean requestProblemInformation) {
        this.requestProblemInformation = requestProblemInformation;
    }

    /**
     * This attribute is added during connection. The future is set, when the client disconnect handling is complete.
     */
    public @Nullable SettableFuture<Void> getDisconnectFuture() {
        return disconnectFuture;
    }

    public void setDisconnectFuture(final @Nullable SettableFuture<Void> disconnectFuture) {
        this.disconnectFuture = disconnectFuture;
    }

    /**
     * Attribute for storing connection attributes. It is added only when connection attributes are set.
     */
    public @Nullable ConnectionAttributes getConnectionAttributes() {
        return connectionAttributes;
    }

    public void setConnectionAttributes(final @Nullable ConnectionAttributes connectionAttributes) {
        this.connectionAttributes = connectionAttributes;
    }

    public synchronized @NotNull ConnectionAttributes setConnectionAttributesIfAbsent(
            final @NotNull ConnectionAttributes connectionAttributes) {

        if (this.connectionAttributes == null) {
            this.connectionAttributes = connectionAttributes;
        }
        return this.connectionAttributes;
    }

    public boolean isSendWill() {
        return sendWill;
    }

    public void setSendWill(final boolean sendWill) {
        this.sendWill = sendWill;
    }

    public boolean isPreventLwt() {
        return preventLwt;
    }

    public void setPreventLwt(final boolean preventLwt) {
        this.preventLwt = preventLwt;
    }

    /**
     * This reveres to the in-flight messages in the client queue, not the ones in the ordered topic queue.
     */
    public boolean isInFlightMessagesSent() {
        return inFlightMessagesSent;
    }

    public void setInFlightMessagesSent(final boolean inFlightMessagesSent) {
        this.inFlightMessagesSent = inFlightMessagesSent;
    }

    public boolean isMessagesInFlight() {
        return !inFlightMessagesSent || inFlightMessageCount() > 0;
    }

    public @Nullable SslClientCertificate getAuthCertificate() {
        return authCertificate;
    }

    public void setAuthCertificate(final @Nullable SslClientCertificate authCertificate) {
        this.authCertificate = authCertificate;
    }

    /**
     * This contains the SNI hostname sent by the client if TLS SNI is used.
     */
    public @Nullable String getAuthSniHostname() {
        return authSniHostname;
    }

    public void setAuthSniHostname(final @Nullable String authSniHostname) {
        this.authSniHostname = authSniHostname;
    }

    public @Nullable String getAuthCipherSuite() {
        return authCipherSuite;
    }

    public void setAuthCipherSuite(final @Nullable String authCipherSuite) {
        this.authCipherSuite = authCipherSuite;
    }

    public @Nullable String getAuthProtocol() {
        return authProtocol;
    }

    public void setAuthProtocol(final @Nullable String authProtocol) {
        this.authProtocol = authProtocol;
    }

    public @Nullable String getAuthUsername() {
        return authUsername;
    }

    public void setAuthUsername(final @Nullable String authUsername) {
        this.authUsername = authUsername;
    }

    public byte @Nullable [] getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(final byte @Nullable [] authPassword) {
        this.authPassword = authPassword;
    }

    public @Nullable CONNECT getAuthConnect() {
        return authConnect;
    }

    public void setAuthConnect(final @Nullable CONNECT authConnect) {
        this.authConnect = authConnect;
    }

    public @Nullable String getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(final @Nullable String authMethod) {
        this.authMethod = authMethod;
    }

    public @Nullable ByteBuffer getAuthData() {
        return authData;
    }

    public void setAuthData(final @Nullable ByteBuffer authData) {
        this.authData = authData;
    }

    public @Nullable Mqtt5UserProperties getAuthUserProperties() {
        return authUserProperties;
    }

    public void setAuthUserProperties(final @Nullable Mqtt5UserProperties authUserProperties) {
        this.authUserProperties = authUserProperties;
    }

    public @Nullable ScheduledFuture<?> getAuthFuture() {
        return authFuture;
    }

    public void setAuthFuture(final @Nullable ScheduledFuture<?> authFuture) {
        this.authFuture = authFuture;
    }

    public @Nullable ClientContextImpl getExtensionClientContext() {
        return extensionClientContext;
    }

    public void setExtensionClientContext(final @Nullable ClientContextImpl extensionClientContext) {
        this.extensionClientContext = extensionClientContext;
    }

    public @Nullable ClientEventListeners getExtensionClientEventListeners() {
        return extensionClientEventListeners;
    }

    public void setExtensionClientEventListeners(final @Nullable ClientEventListeners extensionClientEventListeners) {
        this.extensionClientEventListeners = extensionClientEventListeners;
    }

    public @Nullable ClientAuthorizers getExtensionClientAuthorizers() {
        return extensionClientAuthorizers;
    }

    public void setExtensionClientAuthorizers(final @Nullable ClientAuthorizers extensionClientAuthorizers) {
        this.extensionClientAuthorizers = extensionClientAuthorizers;
    }

    public @Nullable ClientInformation getExtensionClientInformation() {
        return extensionClientInformation;
    }

    public void setExtensionClientInformation(final @Nullable ClientInformation extensionClientInformation) {
        this.extensionClientInformation = extensionClientInformation;
    }

    public @Nullable ConnectionInformation getExtensionConnectionInformation() {
        return extensionConnectionInformation;
    }

    public void setExtensionConnectionInformation(final @Nullable ConnectionInformation extensionConnectionInformation) {
        this.extensionConnectionInformation = extensionConnectionInformation;
    }

    public @Nullable ClientAuthenticators getExtensionClientAuthenticators() {
        return extensionClientAuthenticators;
    }

    public void setExtensionClientAuthenticators(final @Nullable ClientAuthenticators extensionClientAuthenticators) {
        this.extensionClientAuthenticators = extensionClientAuthenticators;
    }

    public int getMaxInflightWindow(final int defaultMaxInflightWindow) {
        if (clientReceiveMaximum == null) {
            return defaultMaxInflightWindow;
        }
        return Math.min(clientReceiveMaximum, defaultMaxInflightWindow);
    }

    public @NotNull Optional<String> getChannelIP() {
        final Optional<InetAddress> inetAddress = getChannelAddress();

        return inetAddress.map(InetAddress::getHostAddress);
    }

    public @NotNull Optional<InetAddress> getChannelAddress() {
        final Optional<SocketAddress> socketAddress = Optional.ofNullable(channel.remoteAddress());
        if (socketAddress.isPresent()) {
            final SocketAddress sockAddress = socketAddress.get();
            //If this is not an InetAddress, we're treating this as if there's no address
            if (sockAddress instanceof InetSocketAddress) {
                return Optional.ofNullable(((InetSocketAddress) sockAddress).getAddress());
            }
        }

        return Optional.empty();
    }

    public void setClearPasswordAfterAuth(final @Nullable Boolean clearPasswordAfterAuth) {
        this.clearPasswordAfterAuth = clearPasswordAfterAuth;
    }

    public @NotNull Optional<Boolean> isClearPasswordAfterAuth() {
        return Optional.ofNullable(clearPasswordAfterAuth);
    }

    public void clearPassword(){
        if(authPassword == null) {
            return;
        }
        Arrays.fill(authPassword, (byte) 0);
        authPassword = null;
    }

    public @NotNull HashMap<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public static @NotNull ClientConnection fromChannel(Channel channel) {
        return channel.attr(ClientConnection.CHANNEL_ATTRIBUTE_NAME).get();
    }
}
