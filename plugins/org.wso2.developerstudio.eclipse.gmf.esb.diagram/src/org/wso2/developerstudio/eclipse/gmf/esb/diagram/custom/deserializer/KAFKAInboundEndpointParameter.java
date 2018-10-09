/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__AUTO_COMMIT_ENABLE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__AUTO_OFFSET_RESET;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CLIENT_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CONSUMER_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CONSUMER_TIMEOUT_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CONSUMER_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CONTENT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__COORDINATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__DUAL_COMMIT_ENABLED;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__EXCLUDE_INTERNAL_TOPICS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__FETCH_MESSAGE_MAX_BYTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__FETCH_MIN_BYTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__FETCH_WAIT_MAX_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__GROUP_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INTERVAL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__NUM_CONSUMER_FETCHES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__OFFSETS_CHANNEL_BACKOFF_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__OFFSETS_COMMIT_MAX_RETRIES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__OFFSETS_STORAGE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__PARTITION_ASSIGNMENT_STRATEGY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__QUEUED_MAX_MESSAGE_CHUNKS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__REBALANCE_BACKOFF_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__REBALANCE_MAX_RETRIES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__REFRESH_LEADER_BACKOFF_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENTIAL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_CONSUMER_BROKERS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_CONSUMER_MAX_MESSAGES_TO_READ;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_CONSUMER_PARTITION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_CONSUMER_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SIMPLE_CONSUMER_TOPIC;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SOCKET_RECEIVE_BUFFER_BYTES;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SOCKET_TIMEOUT_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__THREAD_COUNT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPICS_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPIC_FILTER_FROM;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TOPIC_FILTER_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_CONNECT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_CONNECTION_TIMEOUT_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent KAFKA inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum KAFKAInboundEndpointParameter {
    THREAD_COUNT_TYPE(InboundEndpointConstants.THREAD_COUNT, INBOUND_ENDPOINT__THREAD_COUNT, true), CONSUMER_ID_TYPE(
            InboundEndpointConstants.CONSUMER_ID, INBOUND_ENDPOINT__CONSUMER_ID, true), SOCKET_TIMEOUT_MS_TYPE(
                    InboundEndpointConstants.SOCKET_TIMEOUT_MS, INBOUND_ENDPOINT__SOCKET_TIMEOUT_MS,
                    true), SOCKET_RECEIVE_BUFFER_BYTES_TYPE(InboundEndpointConstants.SOCKET_RECEIVE_BUFFER_BYTES,
                            INBOUND_ENDPOINT__SOCKET_RECEIVE_BUFFER_BYTES,
                            true), FETCH_MESSAGE_MAX_BYTES_TYPE(InboundEndpointConstants.FETCH_MESSAGE_MAX_BYTES,
                                    INBOUND_ENDPOINT__FETCH_MESSAGE_MAX_BYTES,
                                    true), NUM_CONSUMER_FETCHES_TYPE(InboundEndpointConstants.NUM_CONSUMER_FETCHES,
                                            INBOUND_ENDPOINT__NUM_CONSUMER_FETCHES,
                                            true), AUTO_COMMIT_ENABLE_TYPE(InboundEndpointConstants.AUTO_COMMIT_ENABLE,
                                                    INBOUND_ENDPOINT__AUTO_COMMIT_ENABLE,
                                                    true), AUTO_COMMIT_INTERVAL_MS_TYPE(
                                                            InboundEndpointConstants.AUTO_COMMIT_INTERVAL_MS,
                                                            INBOUND_ENDPOINT__AUTO_COMMIT_INTERVAL_MS,
                                                            true), QUEUED_MAX_MESSAGE_CHUNKS_TYPE(
                                                                    InboundEndpointConstants.QUEUED_MAX_MESSAGE_CHUNKS,
                                                                    INBOUND_ENDPOINT__QUEUED_MAX_MESSAGE_CHUNKS,
                                                                    true), REBALANCE_MAX_RETRIES_TYPE(
                                                                            InboundEndpointConstants.REBALANCE_MAX_RETRIES,
                                                                            INBOUND_ENDPOINT__REBALANCE_MAX_RETRIES,
                                                                            true), FETCH_MIN_BYTES_TYPE(
                                                                                    InboundEndpointConstants.FETCH_MIN_BYTES,
                                                                                    INBOUND_ENDPOINT__FETCH_MIN_BYTES,
                                                                                    true), FETCH_WAIT_MAX_MS_TYPE(
                                                                                            InboundEndpointConstants.FETCH_WAIT_MAX_MS,
                                                                                            INBOUND_ENDPOINT__FETCH_WAIT_MAX_MS,
                                                                                            true), REBALANCE_BACKOFF_MS_TYPE(
                                                                                                    InboundEndpointConstants.REBALANCE_BACKOFF_MS,
                                                                                                    INBOUND_ENDPOINT__REBALANCE_BACKOFF_MS,
                                                                                                    true), REFRESH_LEADER_BACKOFF_MS_TYPE(
                                                                                                            InboundEndpointConstants.REFRESH_LEADER_BACKOFF_MS,
                                                                                                            INBOUND_ENDPOINT__REFRESH_LEADER_BACKOFF_MS,
                                                                                                            true), AUTO_OFFSET_RESET_TYPE(
                                                                                                                    InboundEndpointConstants.AUTO_OFFSET_RESET,
                                                                                                                    INBOUND_ENDPOINT__AUTO_OFFSET_RESET,
                                                                                                                    true), CONSUMER_TIMEOUT_MS_TYPE(
                                                                                                                            InboundEndpointConstants.CONSUMER_TIMEOUT_MS,
                                                                                                                            INBOUND_ENDPOINT__CONSUMER_TIMEOUT_MS,
                                                                                                                            true), EXCLUDE_INTERNAL_TOPICS_TYPE(
                                                                                                                                    InboundEndpointConstants.EXCLUDE_INTERNAL_TOPICS,
                                                                                                                                    INBOUND_ENDPOINT__EXCLUDE_INTERNAL_TOPICS,
                                                                                                                                    true), PARTITION_ASSIGNMENT_STRATEGY_TYPE(
                                                                                                                                            InboundEndpointConstants.PARTITION_ASSIGNMENT_STRATEGY,
                                                                                                                                            INBOUND_ENDPOINT__PARTITION_ASSIGNMENT_STRATEGY,
                                                                                                                                            true), CLIENT_ID_TYPE(
                                                                                                                                                    InboundEndpointConstants.CLIENT_ID,
                                                                                                                                                    INBOUND_ENDPOINT__CLIENT_ID,
                                                                                                                                                    true), ZOOKEEPER_SESSION_TIMEOUT_MS_TYPE(
                                                                                                                                                            InboundEndpointConstants.ZOOKEEPER_SESSION_TIMEOUT_MS,
                                                                                                                                                            INBOUND_ENDPOINT__ZOOKEEPER_SESSION_TIMEOUT_MS,
                                                                                                                                                            true), ZOOKEEPER_CONNECTION_TIMEOUT_MS_TYPE(
                                                                                                                                                                    InboundEndpointConstants.ZOOKEEPER_CONNECTION_TIMEOUT_MS,
                                                                                                                                                                    INBOUND_ENDPOINT__ZOOKEEPER_CONNECTION_TIMEOUT_MS,
                                                                                                                                                                    true), ZOOKEEPER_SYNC_TIME_MS_TYPE(
                                                                                                                                                                            InboundEndpointConstants.ZOOKEEPER_SYNC_TIME_MS,
                                                                                                                                                                            INBOUND_ENDPOINT__ZOOKEEPER_SYNC_TIME_MS,
                                                                                                                                                                            true), OFFSETS_STORAGE_TYPE(
                                                                                                                                                                                    InboundEndpointConstants.OFFSETS_STORAGE,
                                                                                                                                                                                    INBOUND_ENDPOINT__OFFSETS_STORAGE,
                                                                                                                                                                                    true), OFFSETS_CHANNEL_BACKOFF_MS_TYPE(
                                                                                                                                                                                            InboundEndpointConstants.OFFSETS_CHANNEL_BACKOFF_MS,
                                                                                                                                                                                            INBOUND_ENDPOINT__OFFSETS_CHANNEL_BACKOFF_MS,
                                                                                                                                                                                            true), OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS_TYPE(
                                                                                                                                                                                                    InboundEndpointConstants.OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS,
                                                                                                                                                                                                    INBOUND_ENDPOINT__OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS,
                                                                                                                                                                                                    true), OFFSETS_COMMIT_MAX_RETRIES_TYPE(
                                                                                                                                                                                                            InboundEndpointConstants.OFFSETS_COMMIT_MAX_RETRIES,
                                                                                                                                                                                                            INBOUND_ENDPOINT__OFFSETS_COMMIT_MAX_RETRIES,
                                                                                                                                                                                                            true), DUAL_COMMIT_ENABLED_TYPE(
                                                                                                                                                                                                                    InboundEndpointConstants.DUAL_COMMIT_ENABLED,
                                                                                                                                                                                                                    INBOUND_ENDPOINT__DUAL_COMMIT_ENABLED,
                                                                                                                                                                                                                    true), FILTER_FROM_WHITELIST_TYPE(
                                                                                                                                                                                                                            InboundEndpointConstants.FILTER_FROM_WHITELIST,
                                                                                                                                                                                                                            INBOUND_ENDPOINT__TOPIC_FILTER_FROM,
                                                                                                                                                                                                                            false), FILTER_FROM_BLACKLIST_TYPE(
                                                                                                                                                                                                                                    InboundEndpointConstants.FILTER_FROM_BLACKLIST,
                                                                                                                                                                                                                                    INBOUND_ENDPOINT__TOPIC_FILTER_FROM,
                                                                                                                                                                                                                                    false), CONTENT_TYPE_TYPE(
                                                                                                                                                                                                                                            InboundEndpointConstants.CONTENT_TYPE,
                                                                                                                                                                                                                                            INBOUND_ENDPOINT__CONTENT_TYPE,
                                                                                                                                                                                                                                            true), CONSUMER_TYPE_TYPE(
                                                                                                                                                                                                                                                    InboundEndpointConstants.CONSUMER_TYPE,
                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__CONSUMER_TYPE,
                                                                                                                                                                                                                                                    false), TOPICS_TYPE(
                                                                                                                                                                                                                                                            InboundEndpointConstants.TOPICS,
                                                                                                                                                                                                                                                            INBOUND_ENDPOINT__TOPICS_NAME,
                                                                                                                                                                                                                                                            false), TOPIC_FILTER_TYPE(
                                                                                                                                                                                                                                                                    InboundEndpointConstants.TOPIC_FILTER,
                                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__TOPIC_FILTER_NAME,
                                                                                                                                                                                                                                                                    false), SIMPLE_TOPIC_TYPE(
                                                                                                                                                                                                                                                                            InboundEndpointConstants.SIMPLE_TOPIC,
                                                                                                                                                                                                                                                                            INBOUND_ENDPOINT__SIMPLE_CONSUMER_TOPIC,
                                                                                                                                                                                                                                                                            true), SIMPLE_BROKERS_TYPE(
                                                                                                                                                                                                                                                                                    InboundEndpointConstants.SIMPLE_BROKERS,
                                                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__SIMPLE_CONSUMER_BROKERS,
                                                                                                                                                                                                                                                                                    true), SIMPLE_PORT_TYPE(
                                                                                                                                                                                                                                                                                            InboundEndpointConstants.SIMPLE_PORT,
                                                                                                                                                                                                                                                                                            INBOUND_ENDPOINT__SIMPLE_CONSUMER_PORT,
                                                                                                                                                                                                                                                                                            true), SIMPLE_PARTITION_TYPE(
                                                                                                                                                                                                                                                                                                    InboundEndpointConstants.SIMPLE_PARTITION,
                                                                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__SIMPLE_CONSUMER_PARTITION,
                                                                                                                                                                                                                                                                                                    true), SIMPLE_MAX_MESSAGES_TO_READ_TYPE(
                                                                                                                                                                                                                                                                                                            InboundEndpointConstants.SIMPLE_MAX_MESSAGES_TO_READ,
                                                                                                                                                                                                                                                                                                            INBOUND_ENDPOINT__SIMPLE_CONSUMER_MAX_MESSAGES_TO_READ,
                                                                                                                                                                                                                                                                                                            true), INTERVAL_TYPE(
                                                                                                                                                                                                                                                                                                                    InboundEndpointConstants.INTERVAL,
                                                                                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__INTERVAL,
                                                                                                                                                                                                                                                                                                                    true), SEQUENTIAL_TYPE(
                                                                                                                                                                                                                                                                                                                            InboundEndpointConstants.SEQUENTIAL,
                                                                                                                                                                                                                                                                                                                            INBOUND_ENDPOINT__SEQUENTIAL,
                                                                                                                                                                                                                                                                                                                            false), COORDINATION_TYPE(
                                                                                                                                                                                                                                                                                                                                    InboundEndpointConstants.COORDINATION,
                                                                                                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__COORDINATION,
                                                                                                                                                                                                                                                                                                                                    false), ZOOKEEPER_CONNECT_TYPE(
                                                                                                                                                                                                                                                                                                                                            InboundEndpointConstants.ZOOKEEPER_CONNECT,
                                                                                                                                                                                                                                                                                                                                            INBOUND_ENDPOINT__ZOOKEEPER_CONNECT,
                                                                                                                                                                                                                                                                                                                                            true), GROUP_ID_TYPE(
                                                                                                                                                                                                                                                                                                                                                    InboundEndpointConstants.GROUP_ID,
                                                                                                                                                                                                                                                                                                                                                    INBOUND_ENDPOINT__GROUP_ID,
                                                                                                                                                                                                                                                                                                                                                    true);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    KAFKAInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
        this.name = name;
        this.eAttributeValue = eAttributeValue;
        this.holdsKeyValue = holdsKeyValue;
    }

    public String getName() {
        return name;
    }

    public EAttribute getEAttributeValue() {
        return eAttributeValue;
    }

    public boolean canHoldKeyValue() {
        return holdsKeyValue;
    }

    public boolean isMatchedWithParameterName(String parameterName) {
        if (this.name.equals(parameterName)) {
            return true;
        } else {
            return false;
        }
    }
}
