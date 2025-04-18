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
package com.hivemq.mqtt.topic;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.ImmutableIntArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.hivemq.util.Bytes;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class SubscriberWithIdentifiers implements Comparable<SubscriberWithIdentifiers> {

    private final @NotNull String subscriber;
    private int qos;
    private final byte flags;
    private final @Nullable String sharedName;
    private @NotNull ImmutableIntArray subscriptionIdentifiers;
    // The topic filter is only present for shared subscription
    private final @Nullable String topicFilter;

    public SubscriberWithIdentifiers(
            final @NotNull String subscriber,
            final int qos,
            final byte flags,
            final @Nullable String sharedName) {

        checkNotNull(subscriber, "Subscriber must not be null");

        this.subscriber = subscriber;
        this.qos = qos;
        this.flags = flags;
        this.sharedName = sharedName;
        subscriptionIdentifiers = ImmutableIntArray.of();
        topicFilter = null;
    }

    public SubscriberWithIdentifiers(
            final @NotNull String subscriber,
            final int qos, final byte flags,
            final @Nullable String sharedName,
            final @NotNull ImmutableList<Integer> subscriptionIdentifier,
            final @Nullable String topicFilter) {

        checkNotNull(subscriber, "Subscriber must not be null");

        this.subscriber = subscriber;
        this.qos = qos;
        this.flags = flags;
        this.sharedName = sharedName;
        this.subscriptionIdentifiers = ImmutableIntArray.of();
        this.topicFilter = topicFilter;
    }

    public SubscriberWithIdentifiers(final @NotNull SubscriberWithQoS subscriberWithQoS) {
        checkNotNull(subscriberWithQoS, "Subscriber must not be null");

        subscriber = subscriberWithQoS.getSubscriber();
        qos = subscriberWithQoS.getQos();
        flags = subscriberWithQoS.getFlags();
        sharedName = subscriberWithQoS.getSharedName();
        final Integer subscriptionIdentifiers = subscriberWithQoS.getSubscriptionIdentifier();
        this.subscriptionIdentifiers =
                (subscriptionIdentifiers == null) ? ImmutableIntArray.of() : ImmutableIntArray.of(subscriptionIdentifiers);
        topicFilter = subscriberWithQoS.getTopicFilter();
    }

    @Override
    public int compareTo(final SubscriberWithIdentifiers o) {
        final int subscriberCompare = subscriber.compareTo(o.getSubscriber());
        if (subscriberCompare == 0) {
            return Integer.compare(qos, o.getQos());
        }
        return subscriberCompare;
    }

    public @NotNull String getSubscriber() {
        return subscriber;
    }

    public int getQos() {
        return qos;
    }

    public byte getFlags() {
        return flags;
    }

    public @Nullable String getSharedName() {
        return sharedName;
    }

    public @NotNull ImmutableIntArray getSubscriptionIdentifier() {
        return subscriptionIdentifiers;
    }

    public void setSubscriptionIdentifiers(final @NotNull ImmutableIntArray subscriptionIdentifiers) {
        this.subscriptionIdentifiers = subscriptionIdentifiers;
    }

    public void setQos(final int qos) {
        this.qos = qos;
    }

    public boolean isSharedSubscription() {
        return Bytes.isBitSet(flags, SubscriptionFlag.SHARED_SUBSCRIPTION.getFlagIndex());
    }

    public boolean isRetainAsPublished() {
        return Bytes.isBitSet(flags, SubscriptionFlag.RETAIN_AS_PUBLISHED.getFlagIndex());
    }

    public boolean isNoLocal() {
        return Bytes.isBitSet(flags, SubscriptionFlag.NO_LOCAL.getFlagIndex());
    }

    public @Nullable String getTopicFilter() {
        return topicFilter;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SubscriberWithIdentifiers that = (SubscriberWithIdentifiers) o;
        return qos == that.qos &&
                flags == that.flags &&
                Objects.equals(subscriber, that.subscriber) &&
                Objects.equals(sharedName, that.sharedName) &&
                Objects.equals(subscriptionIdentifiers, that.subscriptionIdentifiers) &&
                Objects.equals(topicFilter, that.topicFilter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriber, qos, flags, sharedName, subscriptionIdentifiers, topicFilter);
    }

    @Override
    public String toString() {
        return "SubscriberWithIdentifiers{" +
                "subscriber='" +
                subscriber +
                '\'' +
                ", qos=" +
                qos +
                ", flags=" +
                flags +
                ", sharedName='" +
                sharedName +
                '\'' +
                ", subscriptionIdentifiers=" +
                subscriptionIdentifiers +
                ", topicFilter='" +
                topicFilter +
                '\'' +
                '}';
    }
}
