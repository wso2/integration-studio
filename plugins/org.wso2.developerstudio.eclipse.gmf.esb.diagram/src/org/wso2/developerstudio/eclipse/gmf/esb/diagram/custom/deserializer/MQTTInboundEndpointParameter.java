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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INTERVAL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__SEQUENTIAL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__CONTENT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent MQTT inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum MQTTInboundEndpointParameter {
    INBOUND_MQTT_SESSION_CLEAN_TYPE(InboundEndpointConstants.INBOUND_MQTT_SESSION_CLEAN,
            INBOUND_ENDPOINT__TRANSPORT_MQTT_SESSION_CLEAN,
            true), INBOUND_MQTT_SUBSCRIPTION_QOS_TYPE(InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_QOS,
                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_QOS,
                    false), SEQUENTIAL_TYPE(InboundEndpointConstants.SEQUENTIAL, INBOUND_ENDPOINT__SEQUENTIAL,
                            false), INBOUND_MQTT_CONNECTION_FACTORY_TYPE(
                                    InboundEndpointConstants.INBOUND_MQTT_CONNECTION_FACTORY,
                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_CONNECTION_FACTORY,
                                    true), INBOUND_MQTT_SERVER_HOST_NAME_TYPE(
                                            InboundEndpointConstants.INBOUND_MQTT_SERVER_HOST_NAME,
                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_HOST_NAME,
                                            true), INBOUND_MQTT_SERVER_PORT_TYPE(
                                                    InboundEndpointConstants.INBOUND_MQTT_SERVER_PORT,
                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SERVER_PORT,
                                                    true), INBOUND_MQTT_TOPIC_NAME_TYPE(
                                                            InboundEndpointConstants.INBOUND_MQTT_TOPIC_NAME,
                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_TOPIC_NAME,
                                                            true), INBOUND_MQTT_SSL_ENABLE_TYPE(
                                                                    InboundEndpointConstants.INBOUND_MQTT_SSL_ENABLE,
                                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_ENABLE,
                                                                    true), INBOUND_MQTT_TEMPORARY_STORE_DIRECTORY_TYPE(
                                                                            InboundEndpointConstants.INBOUND_MQTT_TEMPORARY_STORE_DIRECTORY,
                                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_TEMPORARY_STORE_DIRECTORY,
                                                                            true), INBOUND_MQTT_SUBSCRIPTION_USERNAME_TYPE(
                                                                                    InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_USERNAME,
                                                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_USERNAME,
                                                                                    true), INBOUND_MQTT_SUBSCRIPTION_PASSWORD_TYPE(
                                                                                            InboundEndpointConstants.INBOUND_MQTT_SUBSCRIPTION_PASSWORD,
                                                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_SUBSCRIPTION_PASSWORD,
                                                                                            true), INBOUND_MQTT_CLIENT_ID_TYPE(
                                                                                                    InboundEndpointConstants.INBOUND_MQTT_CLIENT_ID,
                                                                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_CLIENT_ID,
                                                                                                    true), INBOUND_MQTT_CONTENT_TYPE(
                                                                                                            InboundEndpointConstants.INBOUND_MQTT_CONTENT_TYPE,
                                                                                                            INBOUND_ENDPOINT__CONTENT_TYPE,
                                                                                                            true), INBOUND_MQTT_RECONNECTION_INTERVAL_TYPE(
                                                                                                                    InboundEndpointConstants.INBOUND_MQTT_RECONNECTION_INTERVAL,
                                                                                                                    INBOUND_ENDPOINT__INTERVAL,
                                                                                                                    true), INBOUND_MQTT_SSL_KEYSTORE_LOCATION(
                                                                                                                            InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_LOCATION,
                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_LOCATION,
                                                                                                                            false), INBOUND_MQTT_SSL_KEYSTORE_TYPE(
                                                                                                                                    InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_TYPE,
                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_TYPE,
                                                                                                                                    false), INBOUND_MQTT_SSL_KEYSTORE_PASSWORD(
                                                                                                                                            InboundEndpointConstants.INBOUND_MQTT_SSL_KEYSTORE_PASSWORD,
                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_KEYSTORE_PASSWORD,
                                                                                                                                            false), INBOUND_MQTT_SSL_TRUSTSTORE_LOCATION(
                                                                                                                                                    InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_LOCATION,
                                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_LOCATION,
                                                                                                                                                    false), INBOUND_MQTT_SSL_TRUSTSTORE_TYPE(
                                                                                                                                                            InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_TYPE,
                                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_TYPE,
                                                                                                                                                            false), INBOUND_MQTT_SSL_TRUSTSTORE_PASSWORD(
                                                                                                                                                                    InboundEndpointConstants.INBOUND_MQTT_SSL_TRUSTSTORE_PASSWORD,
                                                                                                                                                                    INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_TRUSTSTORE_PASSWORD,
                                                                                                                                                                    false), INBOUND_MQTT_SSL_VERSION(
                                                                                                                                                                            InboundEndpointConstants.INBOUND_MQTT_SSL_VERSION,
                                                                                                                                                                            INBOUND_ENDPOINT__TRANSPORT_MQTT_SSL_VERSION,
                                                                                                                                                                            false);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    MQTTInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
