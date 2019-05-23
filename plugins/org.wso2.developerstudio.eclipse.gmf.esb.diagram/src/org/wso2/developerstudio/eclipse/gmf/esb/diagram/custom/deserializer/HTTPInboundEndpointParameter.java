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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HTTP_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_THREAD_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent http inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum HTTPInboundEndpointParameter {

    INBOUND_HTTP_PORT_TYPE(InboundEndpointConstants.INBOUND_HTTP_PORT, INBOUND_ENDPOINT__INBOUND_HTTP_PORT,
            true), INBOUND_WORKER_POOL_SIZE_CORE_TYPE(InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_CORE,
                    INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_CORE,
                    true), INBOUND_WORKER_POOL_SIZE_MAX_TYPE(InboundEndpointConstants.INBOUND_WORKER_POOL_SIZE_MAX,
                            INBOUND_ENDPOINT__INBOUND_WORKER_POOL_SIZE_MAX,
                            true), INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC_TYPE(
                                    InboundEndpointConstants.INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC,
                                    INBOUND_ENDPOINT__INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC, true), INBOUND_WORKER_POOL_QUEUE_LENGTH_TYPE(
                                            InboundEndpointConstants.INBOUND_WORKER_POOL_QUEUE_LENGTH,
                                            INBOUND_ENDPOINT__INBOUND_WORKER_POOL_QUEUE_LENGTH,
                                            true), INBOUND_THREAD_GROUOP_ID_TYPE(
                                                    InboundEndpointConstants.INBOUND_THREAD_GROUOP_ID,
                                                    INBOUND_ENDPOINT__INBOUND_THREAD_GROUP_ID,
                                                    true), INBOUND_THREAD_ID_TYPE(
                                                            InboundEndpointConstants.INBOUND_THREAD_ID,
                                                            INBOUND_ENDPOINT__INBOUND_THREAD_ID,
                                                            true), DISPATCH_FILTER_PATTERN_TYPE(
                                                                    InboundEndpointConstants.DISPATCH_FILTER_PATTERN,
                                                                    INBOUND_ENDPOINT__DISPATCH_FILTER_PATTERN, true);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    HTTPInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
