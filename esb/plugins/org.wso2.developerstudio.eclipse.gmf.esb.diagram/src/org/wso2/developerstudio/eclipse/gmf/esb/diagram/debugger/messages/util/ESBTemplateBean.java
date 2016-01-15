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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This class holds attributes which identifies Template Artifact uniquely and
 * defined in ESB Mediation Debugger communication channel
 * <p>
 * Attribute values this class holding are : <u1>
 * <li>Template Key</li>
 * <li>Mediator Position</li><u1>
 */
public class ESBTemplateBean {

    private String templateKey;
    private ESBMediatorPosition mediatorPosition;

    public ESBTemplateBean(String sequenceKey, ESBMediatorPosition mediatorPosition) {
        this.templateKey = sequenceKey;
        this.mediatorPosition = mediatorPosition;
    }

    @Override
    public boolean equals(Object templateBean) {
        if (templateBean instanceof ESBTemplateBean) {
            ESBTemplateBean templateBeanTemp = (ESBTemplateBean) templateBean;
            if (!(getTemplateKey().equals((templateBeanTemp).getTemplateKey()) && getMediatorPosition().equals(
                    templateBeanTemp.getMediatorPosition()))) {
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
        result = HASHCODE_MULTIPLIER_VALUE * result + getTemplateKey().hashCode() + TEMPLATE_KEY_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getMediatorPosition().hashCode()
                + MEDIATOR_POSITION_LABEL.hashCode();
        return result;
    }

    public String getTemplateKey() {
        return templateKey;
    }

    public void setTemplateKey(String sequenceKey) {
        this.templateKey = sequenceKey;
    }

    public ESBMediatorPosition getMediatorPosition() {
        return mediatorPosition;
    }

    public void setMediatorPosition(ESBMediatorPosition mediatorPosition) {
        this.mediatorPosition = mediatorPosition;
    }

}
