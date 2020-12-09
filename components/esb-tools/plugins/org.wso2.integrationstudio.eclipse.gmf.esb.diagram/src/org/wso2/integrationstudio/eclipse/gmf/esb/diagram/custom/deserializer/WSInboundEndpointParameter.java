/*
 * Copyright 2017 WSO2, Inc. (http://wso2.com)
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

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_INBOUND_PORT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_OUTFLOW_DISPATCH_SEQUENCE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_OUTFLOW_DISPATCH_FAULT_SEQUENCE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_BOSS_THREAD_POOL_SIZE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_WORKER_THREAD_POOL_SIZE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_SUBPROTOCOL_HANDLER_CLASS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_PIPELINE_HANDLER_CLASS;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_DEFAULT_CONTENT_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_SHUTDOWN_STATUS_CODE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_SHUTDOWN_STATUS_MESSAGE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__WS_USE_PORT_OFFSET;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent ws inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum WSInboundEndpointParameter {

    INBOUND_ENDPOINT__WS_INBOUND_PORT_TYPE(InboundEndpointConstants.INBOUND_WS_PORT, INBOUND_ENDPOINT__WS_INBOUND_PORT,
            true), INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL_TYPE(
                    InboundEndpointConstants.WS_CLIENT_SIDE_BROADCAST_LEVEL,
                    INBOUND_ENDPOINT__WS_CLIENT_SIDE_BROADCAST_LEVEL,
                    false), INBOUND_ENDPOINT__WS_OUTFLOW_DISPATCH_SEQUENCE_TYPE(
                            InboundEndpointConstants.WS_OUTFLOW_DISPATCH_SEQUENCE,
                            INBOUND_ENDPOINT__WS_OUTFLOW_DISPATCH_SEQUENCE,
                            true), INBOUND_ENDPOINT__WS_OUTFLOW_DISPATCH_FAULT_SEQUENCE_TYPE(
                                    InboundEndpointConstants.WS_OUTFLOW_DISPATCH_FAULT_SEQUENCE,
                                    INBOUND_ENDPOINT__WS_OUTFLOW_DISPATCH_FAULT_SEQUENCE,
                                    true), INBOUND_ENDPOINT__WS_BOSS_THREAD_POOL_SIZE_TYPE(
                                            InboundEndpointConstants.WS_BOSS_THREAD_POOL_SIZE,
                                            INBOUND_ENDPOINT__WS_BOSS_THREAD_POOL_SIZE,
                                            true), INBOUND_ENDPOINT__WS_WORKER_THREAD_POOL_SIZE_TYPE(
                                                    InboundEndpointConstants.WS_WORKER_THREAD_POOL_SIZE,
                                                    INBOUND_ENDPOINT__WS_WORKER_THREAD_POOL_SIZE,
                                                    true), INBOUND_ENDPOINT__WS_SUBPROTOCOL_HANDLER_CLASS_TYPE(
                                                            InboundEndpointConstants.WS_SUBPROTOCOL_HANDLER_CLASS,
                                                            INBOUND_ENDPOINT__WS_SUBPROTOCOL_HANDLER_CLASS,
                                                            true), INBOUND_ENDPOINT__WS_PIPELINE_HANDLER_CLASS_TYPE(
                                                                    InboundEndpointConstants.WS_PIPELINE_HANDLER_CLASS,
                                                                    INBOUND_ENDPOINT__WS_PIPELINE_HANDLER_CLASS,
                                                                    true), INBOUND_ENDPOINT__WS_DEFAULT_CONTENT_TYPE_TYPE(
                                                                            InboundEndpointConstants.WS_DEFAULT_CONTENT_TYPE,
                                                                            INBOUND_ENDPOINT__WS_DEFAULT_CONTENT_TYPE,
                                                                            true), INBOUND_ENDPOINT__WS_SHUTDOWN_STATUS_CODE_TYPE(
                                                                                    InboundEndpointConstants.WS_SHUTDWN_STATUS_CODE,
                                                                                    INBOUND_ENDPOINT__WS_SHUTDOWN_STATUS_CODE,
                                                                                    true), INBOUND_ENDPOINT__WS_SHUTDOWN_STATUS_MESSAGE_TYPE(
                                                                                            InboundEndpointConstants.WS_SHUTDOWN_STATUS_MESSAGE,
                                                                                            INBOUND_ENDPOINT__WS_SHUTDOWN_STATUS_MESSAGE,
                                                                                            true), INBOUND_ENDPOINT__WS_USE_PORT_OFFSET_TYPE(
                                                                                                    InboundEndpointConstants.WS_USE_PORT_OFFSET,
                                                                                                    INBOUND_ENDPOINT__WS_USE_PORT_OFFSET,
                                                                                                    false);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    WSInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
