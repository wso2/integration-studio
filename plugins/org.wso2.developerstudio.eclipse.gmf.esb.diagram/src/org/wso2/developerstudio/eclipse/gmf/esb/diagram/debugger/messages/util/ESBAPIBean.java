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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_KEY_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_RESOURCE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_POSITION_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_TYPE_LABEL;

/**
 * This class holds attributes which identifies API Artifact uniquely and
 * defined in ESB Mediation Debugger communication channel
 *
 */
public class ESBAPIBean {

    private String apiKey;
    private ESBAPIResourceBean resource;
    private String sequenceType;
    private ESBMediatorPosition mediatorPosition;

    public ESBAPIBean(String apiKey, ESBAPIResourceBean resourse, String sequenceType,
            ESBMediatorPosition mediatorPosition) {
        this.apiKey = apiKey;
        this.resource = resourse;
        this.sequenceType = sequenceType;
        this.mediatorPosition = mediatorPosition;
    }

    @Override
    public boolean equals(Object apiBean) {
        if (apiBean instanceof ESBAPIBean) {
            ESBAPIBean apiBeanTemp = (ESBAPIBean) apiBean;
            if (!(getApiKey().equals((apiBeanTemp).getApiKey()) && getResourse().equals((apiBeanTemp).getResourse())
                    && getSequenceType().equals((apiBeanTemp).getSequenceType()) && getMediatorPosition().equals(
                    apiBeanTemp.getMediatorPosition()))) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = INITIAL_HASH_CODE_RESULT_VALUE;
        result = HASHCODE_MULTIPLIER_VALUE * result + getApiKey().hashCode() + API_KEY_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getResourse().hashCode() + API_RESOURCE_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getMediatorPosition().hashCode()
                + MEDIATOR_POSITION_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getSequenceType().hashCode() + SEQUENCE_TYPE_LABEL.hashCode();
        return result;

    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ESBAPIResourceBean getResourse() {
        return resource;
    }

    public void setResourse(ESBAPIResourceBean resourse) {
        this.resource = resourse;
    }

    public String getSequenceType() {
        return sequenceType;
    }

    public void setSequenceType(String sequenceType) {
        this.sequenceType = sequenceType;
    }

    public ESBMediatorPosition getMediatorPosition() {
        return mediatorPosition;
    }

    public void setMediatorPosition(ESBMediatorPosition mediatorPosition) {
        this.mediatorPosition = mediatorPosition;
    }
}
