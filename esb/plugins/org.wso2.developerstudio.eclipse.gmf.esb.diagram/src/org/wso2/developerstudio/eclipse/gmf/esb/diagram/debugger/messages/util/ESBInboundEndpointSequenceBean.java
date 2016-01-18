/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INBOUND_ENDPOINT_LABEL;

;

/**
 * This class holds {@link ESBInboundEndpointBean} which identifies Inbound
 * Endpoint Artifact uniquely and defined in ESB Mediation Debugger
 * communication channel
 *
 */
public class ESBInboundEndpointSequenceBean {

    private ESBInboundEndpointBean inbound;

    public ESBInboundEndpointSequenceBean(ESBInboundEndpointBean inbound) {
        this.inbound = inbound;
    }

    @Override
    public boolean equals(Object inboundSeqBean) {
        if (inboundSeqBean instanceof ESBInboundEndpointSequenceBean) {
            if (getInboundEndpoint().equals(((ESBInboundEndpointSequenceBean) inboundSeqBean).getInboundEndpoint())) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = INITIAL_HASH_CODE_RESULT_VALUE;
        result = HASHCODE_MULTIPLIER_VALUE * result + getInboundEndpoint().hashCode()
                + INBOUND_ENDPOINT_LABEL.hashCode();

        return result;
    }

    public ESBInboundEndpointBean getInboundEndpoint() {
        return inbound;
    }

    public void setInboundEndpoint(ESBInboundEndpointBean inbound) {
        this.inbound = inbound;
    }
}
