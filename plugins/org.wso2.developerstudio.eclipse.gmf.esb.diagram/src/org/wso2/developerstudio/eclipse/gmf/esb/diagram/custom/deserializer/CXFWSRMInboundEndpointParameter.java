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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__ENABLE_SSL;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent CXF WS RM inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum CXFWSRMInboundEndpointParameter {
    INBOUND_CXF_RM_HOST_TYPE(InboundEndpointConstants.INBOUND_CXF_RM_HOST, INBOUND_ENDPOINT__INBOUND_CXF_RM_HOST,
            true), INBOUND_CXF_RM_PORT_TYPE(InboundEndpointConstants.INBOUND_CXF_RM_PORT,
                    INBOUND_ENDPOINT__INBOUND_CXF_RM_PORT,
                    true), INBOUND_CXF_RM_CONFIG_FILE_TYPE(InboundEndpointConstants.INBOUND_CXF_RM_CONFIG_FILE,
                            INBOUND_ENDPOINT__INBOUND_CXF_RM_CONFIG_FILE, true), ENABLE_SSL_TYPE(
                                    InboundEndpointConstants.ENABLE_SSL, INBOUND_ENDPOINT__ENABLE_SSL, false);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    CXFWSRMInboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
