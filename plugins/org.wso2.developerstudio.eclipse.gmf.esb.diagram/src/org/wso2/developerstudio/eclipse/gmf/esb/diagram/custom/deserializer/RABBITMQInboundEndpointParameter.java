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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__COORDINATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENTIAL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_FACTORY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_ENABLED;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_LOCATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_PASSWORD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_LOCATION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_VERSION;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DELETE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_DURABLE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_FACTORY_HEARTBEAT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_ACK;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_DELETE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DELIVERY_MODE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DURABLE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_EXCLUSIVE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_ROUTING_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_HOST_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PASSWORD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_USER_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_VIRTUAL_HOST;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent Rabbit MQ inbound endpoint parameters with parameter name , related EAttribute and boolean value indicating
 * whether it could hold key attribute
 *
 */
public enum RABBITMQInboundEndpointParameter {
    SEQUENTIAL_TYPE(InboundEndpointConstants.SEQUENTIAL, INBOUND_ENDPOINT__SEQUENTIAL, false),
    COORDINATION_TYPE(InboundEndpointConstants.COORDINATION, INBOUND_ENDPOINT__COORDINATION, false),
    RABBITMQ_CONNECTION_FACTORY_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_FACTORY,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_FACTORY, true),
    RABBITMQ_SERVER_HOST_NAME_TYPE(InboundEndpointConstants.RABBITMQ_SERVER_HOST_NAME,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_HOST_NAME,true),
    RABBITMQ_SERVER_PORT_TYPE(InboundEndpointConstants.RABBITMQ_SERVER_PORT,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PORT, true),
    RABBITMQ_SERVER_USER_NAME_TYPE(InboundEndpointConstants.RABBITMQ_SERVER_USER_NAME,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_USER_NAME,true),
    RABBITMQ_SERVER_PASSWORD_TYPE(InboundEndpointConstants.RABBITMQ_SERVER_PASSWORD,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_PASSWORD, true),
    RABBITMQ_QUEUE_NAME_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_NAME,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_NAME, true),
    RABBITMQ_EXCHANGE_NAME_TYPE(InboundEndpointConstants.RABBITMQ_EXCHANGE_NAME,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_NAME, true),
    RABBITMQ_QUEUE_DURABLE_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_DURABLE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DURABLE, true),
    RABBITMQ_QUEUE_EXCLUSIVE_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_EXCLUSIVE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_EXCLUSIVE,true),
    RABBITMQ_QUEUE_AUTO_DELETE_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_DELETE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_DELETE, true),
    RABBITMQ_QUEUE_AUTO_ACK_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_AUTO_ACK,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_AUTO_ACK,true),
    RABBITMQ_QUEUE_ROUTING_KEY_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_ROUTING_KEY,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_ROUTING_KEY, true),
    RABBITMQ_QUEUE_DELIVERY_MODE_TYPE(InboundEndpointConstants.RABBITMQ_QUEUE_DELIVERY_MODE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_QUEUE_DELIVERY_MODE, true),
    RABBITMQ_EXCHANGE_TYPE_TYPE(InboundEndpointConstants.RABBITMQ_EXCHANGE_TYPE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_TYPE, true),
    RABBITMQ_EXCHANGE_DURABLE_TYPE(InboundEndpointConstants.RABBITMQ_EXCHANGE_DURABLE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_DURABLE,true),
    RABBITMQ_EXCHANGE_AUTO_DELETE_TYPE(InboundEndpointConstants.RABBITMQ_EXCHANGE_AUTO_DELETE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_EXCHANGE_AUTO_DELETE, true),
    RABBITMQ_SERVER_VIRTUAL_HOST_TYPE(InboundEndpointConstants.RABBITMQ_SERVER_VIRTUAL_HOST,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_SERVER_VIRTUAL_HOST, true),
    RABBITMQ_FACTORY_HEARTBEAT_TYPE(InboundEndpointConstants.RABBITMQ_FACTORY_HEARTBEAT,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_FACTORY_HEARTBEAT, true),
    RABBITMQ_CONNECTION_SSL_ENABLED_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_ENABLED,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_ENABLED, true),
    RABBITMQ_CONNECTION_SSL_KEYSTORE_LOCATION_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_LOCATION,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_LOCATION, true),
    RABBITMQ_CONNECTION_SSL_KEYSTORE_TYPE_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_TYPE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_TYPE, true),
    RABBITMQ_CONNECTION_SSL_KEYSTORE_PASSWORD_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_KEYSTORE_PASSWORD,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_KEYSTORE_PASSWORD, true),
    RABBITMQ_CONNECTION_SSL_TRUSTSTORE_LOCATION_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_LOCATION,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_LOCATION, true),
    RABBITMQ_CONNECTION_SSL_TRUSTSTORE_TYPE_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_TYPE,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_TYPE, true),
    RABBITMQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD, true),
    RABBITMQ_CONNECTION_SSL_VERSION_TYPE(InboundEndpointConstants.RABBITMQ_CONNECTION_SSL_VERSION,
            INBOUND_ENDPOINT__TRANSPORT_RABBIT_MQ_CONNECTION_SSL_VERSION, true);
    
    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    RABBITMQInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
