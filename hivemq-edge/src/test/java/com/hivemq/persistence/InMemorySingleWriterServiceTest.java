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
package com.hivemq.persistence;

import com.hivemq.configuration.service.InternalConfigurationService;
import com.hivemq.configuration.service.InternalConfigurations;
import com.hivemq.configuration.service.impl.InternalConfigurationServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author Daniel Krüger
 */
public class InMemorySingleWriterServiceTest {

    private @NotNull InMemorySingleWriter singleWriterServiceImpl;
    private final @NotNull InternalConfigurationService
            internalConfigurationService = new InternalConfigurationServiceImpl();
    @Before
    public void setUp() throws Exception {
        InternalConfigurations.PERSISTENCE_SHUTDOWN_GRACE_PERIOD_MSEC.set(200);
        internalConfigurationService.set(InternalConfigurations.PERSISTENCE_BUCKET_COUNT, "64");
        singleWriterServiceImpl = new InMemorySingleWriter(internalConfigurationService);
    }

    @After
    public void tearDown() {
        singleWriterServiceImpl.stop();
    }

    @Test
    public void test_valid_amount_of_queues() {
        assertEquals(1, singleWriterServiceImpl.validAmountOfQueues(1, 64));
        assertEquals(2, singleWriterServiceImpl.validAmountOfQueues(2, 64));
        assertEquals(4, singleWriterServiceImpl.validAmountOfQueues(4, 64));
        assertEquals(8, singleWriterServiceImpl.validAmountOfQueues(5, 64));
        assertEquals(8, singleWriterServiceImpl.validAmountOfQueues(8, 64));
        assertEquals(64, singleWriterServiceImpl.validAmountOfQueues(64, 64));
    }

    @Test
    public void test_getQueues_queuesAreDifferentPerType() {
        final ArrayList<ProducerQueues> queues = new ArrayList<>();

        final ProducerQueues attributeStoreQueue = singleWriterServiceImpl.getAttributeStoreQueue();
        queues.add(attributeStoreQueue);
        final ProducerQueues clientSessionQueue = singleWriterServiceImpl.getClientSessionQueue();
        queues.add(clientSessionQueue);
        final ProducerQueues queuedMessagesQueue = singleWriterServiceImpl.getQueuedMessagesQueue();
        queues.add(queuedMessagesQueue);
        final ProducerQueues retainedMessageQueue = singleWriterServiceImpl.getRetainedMessageQueue();
        queues.add(retainedMessageQueue);
        final ProducerQueues subscriptionQueue = singleWriterServiceImpl.getSubscriptionQueue();
        queues.add(subscriptionQueue);

        for (int i = 0; i < queues.size(); i++) {
            for (int j = 0; j < queues.size(); j++) {
                if (i == j) {
                    continue;
                }
                assertNotSame(queues.get(i), queues.get(j));
            }
        }
    }
}
