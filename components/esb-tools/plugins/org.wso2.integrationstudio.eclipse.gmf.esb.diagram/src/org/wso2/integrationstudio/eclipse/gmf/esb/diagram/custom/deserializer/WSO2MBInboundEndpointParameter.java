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
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__COORDINATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INTERVAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENTIAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONCURRENT_CONSUMERS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_NAME;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_PINNED_SERVERS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_RETRY_DURATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WSO2MB_CONNECTION_URL;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent WSO2MB inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum WSO2MBInboundEndpointParameter {
    INTERVAL_TYPE(InboundEndpointConstants.INTERVAL, INBOUND_ENDPOINT__INTERVAL, true), SEQUENTIAL_TYPE(
            InboundEndpointConstants.SEQUENTIAL, INBOUND_ENDPOINT__SEQUENTIAL,
            false), COORDINATION_TYPE(InboundEndpointConstants.COORDINATION, INBOUND_ENDPOINT__COORDINATION,
                    false), JMS_JAVA_NAMING_FACTORY_INITIAL_TYPE(
                            InboundEndpointConstants.JMS_JAVA_NAMING_FACTORY_INITIAL,
                            INBOUND_ENDPOINT__JAVA_NAMING_FACTORY_INITIAL, true), JMS_CONNECTION_FACTORY_JNDI_NAME_TYPE(
                                    InboundEndpointConstants.JMS_CONNECTION_FACTORY_JNDI_NAME,
                                    INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_JNDI_NAME,
                                    true), JMS_DESTINATION_TYPE(InboundEndpointConstants.JMS_DESTINATION,
                                            INBOUND_ENDPOINT__TRANSPORT_JMS_DESTINATION,
                                            true), JMS_JMS_SPEC_VERSION_TYPE(
                                                    InboundEndpointConstants.JMS_JMS_SPEC_VERSION,
                                                    INBOUND_ENDPOINT__TRANSPORT_JMSJMS_SPEC_VERSION,
                                                    true), JMS_SUBSCRIPTION_DURABLE_TYPE(
                                                            InboundEndpointConstants.JMS_SUBSCRIPTION_DURABLE,
                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_DURABLE,
                                                            true), JMS_DURABLE_SUBSCRIBER_CLIENT_ID_TYPE(
                                                                    InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_CLIENT_ID,
                                                                    true), JMS_MESSAGE_SELECTOR_TYPE(
                                                                            InboundEndpointConstants.JMS_MESSAGE_SELECTOR,
                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_MESSAGE_SELECTOR,
                                                                            true), JMS_RECIEVE_TIMEOUT_TYPE(
                                                                                    InboundEndpointConstants.JMS_RECIEVE_TIMEOUT,
                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_RECEIVE_TIMEOUT,
                                                                                    true), JMS_CONTENT_TYPE_TYPE(
                                                                                            InboundEndpointConstants.JMS_CONTENT_TYPE,
                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE,
                                                                                            true), JMS_REPLY_DESTINATION_TYPE(
                                                                                                    InboundEndpointConstants.JMS_REPLY_DESTINATION,
                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_REPLY_DESTINATION,
                                                                                                    true), JMS_PUB_SUB_NO_LOCAL_TYPE(
                                                                                                            InboundEndpointConstants.JMS_PUB_SUB_NO_LOCAL,
                                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_PUB_SUB_NO_LOCAL,
                                                                                                            true), JMS_DURABLE_SUBSCRIBER_NAME_TYPE(
                                                                                                                    InboundEndpointConstants.JMS_DURABLE_SUBSCRIBER_NAME,
                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_DURABLE_SUBSCRIBER_NAME,
                                                                                                                    true), JMS_CONNECTION_FACTORY_TYPE_TYPE(
                                                                                                                            InboundEndpointConstants.JMS_CONNECTION_FACTORY_TYPE,
                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_CONNECTION_FACTORY_TYPE,
                                                                                                                            false), JMS_SESSION_TRANSACTED_TYPE(
                                                                                                                                    InboundEndpointConstants.JMS_SESSION_TRANSACTED,
                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_TRANSACTED,
                                                                                                                                    false), JMS_SHARED_SUBSCRIPTION(
                                                                                                                                            InboundEndpointConstants.JMS_SHARED_SUBSCRIPTION,
                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_SHARED_SUBSCRIPTION,
                                                                                                                                            false), JMS_SESSION_ACKNOWLEDGEMENT_TYPE(
                                                                                                                                                    InboundEndpointConstants.JMS_SESSION_ACKNOWLEDGEMENT,
                                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_SESSION_ACKNOWLEDGEMENT,
                                                                                                                                                    false), JMS_CACHE_LEVEL_TYPE(
                                                                                                                                                            InboundEndpointConstants.JMS_CACHE_LEVEL,
                                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_CACHE_LEVEL,
                                                                                                                                                            false), JMS_CONTENT_TYPE_PROPERTY_TYPE(
                                                                                                                                                                    InboundEndpointConstants.JMS_CONTENT_TYPE_PROPERTY,
                                                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_CONTENT_TYPE_PROPERTY,
                                                                                                                                                                    true), INBOUND_ENDPOINT_PINNED_SERVERS(
                                                                                                                                                                            InboundEndpointConstants.INBOUND_ENDPOINT_PINNED_SERVERS,
                                                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_PINNED_SERVERS,
                                                                                                                                                                            true), JMS_SUBSCRIPTION_NAME(
                                                                                                                                                                                    InboundEndpointConstants.JMS_SUBSCRIPTION_NAME,
                                                                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_SUBSCRIPTION_NAME,
                                                                                                                                                                                    true), WSO2_MB_CONNECTION_URL(
                                                                                                                                                                                            InboundEndpointConstants.WSO2_MB_CONNECTION_URL,
                                                                                                                                                                                            INBOUND_ENDPOINT__WSO2MB_CONNECTION_URL,
                                                                                                                                                                                            true), WSO2_MB__QUEUE_CONNECTION_URL(
                                                                                                                                                                                                    InboundEndpointConstants.WSO2_MB__QUEUE_CONNECTION_URL,
                                                                                                                                                                                                    INBOUND_ENDPOINT__WSO2MB_CONNECTION_URL,
                                                                                                                                                                                                    true), WSO2_MB_TOPIC_CONNECTION_URL(
                                                                                                                                                                                                            InboundEndpointConstants.WSO2_MB__QUEUE_CONNECTION_URL,
                                                                                                                                                                                                            INBOUND_ENDPOINT__WSO2MB_CONNECTION_URL,
                                                                                                                                                                                                            true), JMS_CONCURRENT_CONSUMERS(
                                                                                                                                                                                                                    InboundEndpointConstants.JMS_CONCURRENT_CONSUMERS,
                                                                                                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_JMS_CONCURRENT_CONSUMERS,
                                                                                                                                                                                                                    true), JMS_RETRY_DURATION(
                                                                                                                                                                                                                            InboundEndpointConstants.JMS_RETRY_DURATION,
                                                                                                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_JMS_RETRY_DURATION,
                                                                                                                                                                                                                            true);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    WSO2MBInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
        } else if (this.name.equals("wso2mb.connection.url")
                && parameterName.equals("connectionfactory.TopicConnectionFactory")) {
            // If the gmf model name is wso2mb.connection.url and the synapse name is
            // connectionfactory.TopicConnectionFactory
            return true;
        } else if (this.name.equals("wso2mb.connection.url")
                && parameterName.equals("connectionfactory.QueueConnectionFactory")) {
            // If the gmf model name is wso2mb.connection.url and the synapse name is
            // connectionfactory.QueueConnectionFactory
            return true;
        } else {
            return false;
        }
    }
}
