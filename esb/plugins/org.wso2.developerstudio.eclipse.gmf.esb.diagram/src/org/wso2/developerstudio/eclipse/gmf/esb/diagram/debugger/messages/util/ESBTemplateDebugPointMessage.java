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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.COMMAND_ARGUMENT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATION_COMPONENT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_POSITION_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TEMPLATE_KEY_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TEMPLATE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TEMPLATE_SEQUENCE;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

import com.google.gson.JsonElement;

/**
 * This class is the bean class to represent ESB Template artifacts debug point
 * message from ESB Server Debugger
 * <p>
 * Attribute values this class holding are : <u1>
 * <li>Command</li>
 * <li>Command Argument</li>
 * <li>Mediation Component</li>
 * <li>{@link ESBTemplateBean}</li><u1>
 */
public class ESBTemplateDebugPointMessage extends AbstractESBDebugPointMessage {

    private ESBTemplateBean template;

    public ESBTemplateDebugPointMessage(String command, String commandArguement, String mediationComponent,
            ESBTemplateBean template) {
        super(command, commandArguement, mediationComponent);
        this.setTemplate(template);
    }

    public ESBTemplateDebugPointMessage(EventMessageType event, JsonElement recievedArtifactInfo) {
        super(event.toString(), TEMPLATE_LABEL);
        createTemplateFromJsonElement(recievedArtifactInfo);
    }

    /**
     * Checked whether Mediation Component and template bean are equal or
     * not.But this method doesn't compare whether it's type is differ or not.
     * <p>
     * So though skip points and breakpoints are different debug point types, this method return true if those are for
     * the same mediator.
     */
    public boolean equalsIgnoreType(ESBTemplateDebugPointMessage debugPointMessage) {
        if (getMediationComponent().equals(debugPointMessage.getMediationComponent())
                && getTemplate().equals(debugPointMessage.getTemplate())) {
            return true;
        }
        return false;
    }

    /**
     * Checked whether Mediation Component, Command Argument and template bean
     * are equal or not.
     * <p>
     * Command value is not taken to compare because command attribute contains values related to debug point action
     * "set" or "clear".
     */
    @Override
    public boolean equals(Object debugPointMessage) {
        if (debugPointMessage instanceof ESBTemplateDebugPointMessage) {
            ESBTemplateDebugPointMessage debugPointMessageTemp = (ESBTemplateDebugPointMessage) debugPointMessage;
            if (!(getMediationComponent().equals((debugPointMessageTemp).getMediationComponent())
                    && getCommandArgument().equals((debugPointMessageTemp).getCommandArgument()) && getTemplate()
                    .equals(debugPointMessageTemp.getTemplate()))) {
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
        result = HASHCODE_MULTIPLIER_VALUE * result + getMediationComponent().hashCode()
                + MEDIATION_COMPONENT_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getCommandArgument().hashCode()
                + COMMAND_ARGUMENT_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getTemplate().hashCode() + TEMPLATE_LABEL.hashCode();
        return result;
    }

    @Override
    public ESBMediatorPosition getMediatorPosition() {
        return getTemplate().getMediatorPosition();
    }

    @Override
    public void setMediatorPosition(List<Integer> positionList) {
        getTemplate().setMediatorPosition(new ESBMediatorPosition(positionList));
    }

    @Override
    public String getSequenceType() {
        return TEMPLATE_SEQUENCE;
    }

    private void createTemplateFromJsonElement(JsonElement recievedArtifactInfo) {
        Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo.getAsJsonObject().entrySet();
        String templateKey = null;
        ESBMediatorPosition mediatorPosition = null;
        for (Entry<String, JsonElement> entry : entrySet) {
            if (TEMPLATE_KEY_LABEL.equalsIgnoreCase(entry.getKey())) {
                templateKey = convertJsonElementValueToString(entry.getValue());
            } else if (MEDIATOR_POSITION_LABEL.equalsIgnoreCase(entry.getKey())) {
                mediatorPosition = convertMediatorPositionStringToList(convertJsonElementValueToString(entry.getValue()));
            }
        }
        setTemplate(new ESBTemplateBean(templateKey, mediatorPosition));
    }

    public ESBTemplateBean getTemplate() {
        return template;
    }

    public void setTemplate(ESBTemplateBean template) {
        this.template = template;
    }

}
