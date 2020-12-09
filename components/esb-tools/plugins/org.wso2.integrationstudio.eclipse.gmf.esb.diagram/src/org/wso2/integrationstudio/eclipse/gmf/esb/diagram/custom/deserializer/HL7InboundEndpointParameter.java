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

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_PORT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE;

import org.eclipse.emf.ecore.EAttribute;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.InboundEndpointConstants;

/**
 * This Enum represent HL7 inbound endpoint parameters with parameter name , related EAttribute and boolean value
 * indicating
 * whether it could hold key attribute
 *
 */
public enum HL7InboundEndpointParameter {
    INBOUND_HL7_PORT_TYPE(InboundEndpointConstants.INBOUND_HL7_PORT, INBOUND_ENDPOINT__INBOUND_HL7_PORT,
            true), INBOUND_HL7_TIMEOUT_TYPE(InboundEndpointConstants.INBOUND_HL7_TIMEOUT,
                    INBOUND_ENDPOINT__INBOUND_HL7_TIME_OUT, true), INBOUND_HL7_MESSAGE_PRE_PROCESSOR_TYPE(
                            InboundEndpointConstants.INBOUND_HL7_MESSAGE_PRE_PROCESSOR,
                            INBOUND_ENDPOINT__INBOUND_HL7_MESSAGE_PRE_PROCESSOR,
                            true), INBOUND_HL7_CHARSET_TYPE(InboundEndpointConstants.INBOUND_HL7_CHARSET,
                                    INBOUND_ENDPOINT__INBOUND_HL7_CHAR_SET,
                                    true), INBOUND_HL7_BUILD_INVALID_MESSAGES_TYPE(
                                            InboundEndpointConstants.INBOUND_HL7_BUILD_INVALID_MESSAGES,
                                            INBOUND_ENDPOINT__INBOUND_HL7_BUILD_INVALID_MESSAGES,
                                            false), INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES_TYPE(
                                                    InboundEndpointConstants.INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES,
                                                    INBOUND_ENDPOINT__INBOUND_HL7_PASS_THROUGH_INVALID_MESSAGES,
                                                    false), INBOUND_HL7_AUTOACK_TYPE(
                                                            InboundEndpointConstants.INBOUND_HL7_AUTOACK,
                                                            INBOUND_ENDPOINT__INBOUND_HL7_AUTO_ACK,
                                                            false), INBOUND_HL7_VALIDATE_MESSAGE_TYPE(
                                                                    InboundEndpointConstants.INBOUND_HL7_VALIDATE_MESSAGE,
                                                                    INBOUND_ENDPOINT__INBOUND_HL7_VALIDATE_MESSAGE,
                                                                    false);

    private final String name;
    private final EAttribute eAttributeValue;
    private final boolean holdsKeyValue;

    HL7InboundEndpointParameter(String name, EAttribute eAttributeValue, boolean holdsKeyValue) {
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
