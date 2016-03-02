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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_RESOURCE_METHOD_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.COMMAND_ARGUMENT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.HASHCODE_MULTIPLIER_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MAPPING_URL_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATION_COMPONENT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_POSITION_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_TYPE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.URL_MAPPING_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.URI_TEMPLATE_LABEL;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

import com.google.gson.JsonElement;

/**
 * This class is the bean class to represent API artifacts debug point message
 * from ESB Server Debugger
 *
 */
public class ESBAPIDebugPointMessage extends AbstractESBDebugPointMessage {

    private ESBAPISequenceBean sequence;

    public ESBAPIDebugPointMessage(String command, String commandArgument, ESBAPISequenceBean sequence) {
        super(command, commandArgument, SEQUENCE_LABEL);
        this.setSequence(sequence);
    }

    public ESBAPIDebugPointMessage(EventMessageType event, JsonElement recievedArtifactInfo) {
        super(SEQUENCE_LABEL);
        createApiSequenceFromJsonElement(event, recievedArtifactInfo);
    }

    /**
     * Checked whether Mediation Component and API Sequence bean are equal or
     * not.But this method doesn't compare whether it's type is differ or not.
     * <p>
     * So though skip points and breakpoints are different debug point types, this method return true if those are for
     * the same mediator.
     */
    public boolean equalsIgnoreType(ESBAPIDebugPointMessage debugPointMessage) {
        if (getMediationComponent().equals(debugPointMessage.getMediationComponent())
                && getSequence().equals(debugPointMessage.getSequence())) {
            return true;
        }
        return false;
    }

    /**
     * Checked whether Mediation Component, Command Argument and API Sequence
     * bean are equal or not.
     * <p>
     * Command value is not taken to compare because command attribute contains values related to debug point action
     * "set" or "clear".
     */
    @Override
    public boolean equals(Object debugPointMessage) {
        if (debugPointMessage instanceof ESBAPIDebugPointMessage) {
            ESBAPIDebugPointMessage debugPointMessageTemp = (ESBAPIDebugPointMessage) debugPointMessage;
            if (!(getMediationComponent().equals((debugPointMessageTemp).getMediationComponent())
                    && getCommandArgument().equals((debugPointMessageTemp).getCommandArgument()) && getSequence()
                    .equals(debugPointMessageTemp.getSequence()))) {
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
        result = HASHCODE_MULTIPLIER_VALUE * result + getSequence().hashCode() + SEQUENCE_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getCommandArgument().hashCode()
                + COMMAND_ARGUMENT_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getMediationComponent().hashCode()
                + MEDIATION_COMPONENT_LABEL.hashCode();
        return result;
    }

    @Override
    public ESBMediatorPosition getMediatorPosition() {
        return getSequence().getApi().getMediatorPosition();
    }

    @Override
    public void setMediatorPosition(List<Integer> position) {
        getSequence().getApi().setMediatorPosition(new ESBMediatorPosition(position));
    }

    @Override
    public String getSequenceType() {
        return getSequence().getApi().getSequenceType();
    }

    private void createApiSequenceFromJsonElement(EventMessageType event, JsonElement recievedArtifactInfo) {
        setCommandArgument(event.toString());
        Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo.getAsJsonObject().entrySet();
        String method = null;
        String urlTemplate = null;
        String uriMapping = null;
        String apiKey = null;
        JsonElement resourceElement = null;
        ESBMediatorPosition mediatorPosition = null;
        String sequenceType = null;
        for (Entry<String, JsonElement> apiEntry : entrySet) {
            JsonElement apiArtifactInfo = apiEntry.getValue();
            Set<Entry<String, JsonElement>> apiEntrySet = apiArtifactInfo.getAsJsonObject().entrySet();
            for (Entry<String, JsonElement> entry : apiEntrySet) {
                if (API_KEY_LABEL.equalsIgnoreCase(entry.getKey())) {
                    apiKey = convertJsonElementValueToString(entry.getValue());
                } else if (MEDIATOR_POSITION_LABEL.equalsIgnoreCase(entry.getKey())) {
                    mediatorPosition = convertMediatorPositionStringToList(convertJsonElementValueToString(entry
                            .getValue()));
                } else if (SEQUENCE_TYPE_LABEL.equalsIgnoreCase(entry.getKey())) {
                    sequenceType = convertJsonElementValueToString(entry.getValue());
                } else if (API_RESOURCE_LABEL.equalsIgnoreCase(entry.getKey())) {
                    resourceElement = entry.getValue();
                }
            }

        }

        Set<Entry<String, JsonElement>> resourseEntrySet = resourceElement.getAsJsonObject().entrySet();
        for (Entry<String, JsonElement> apiEntry : resourseEntrySet) {
            if (API_RESOURCE_METHOD_LABEL.equals(apiEntry.getKey())) {
                method = convertJsonElementValueToString(apiEntry.getValue());
            } else if (MAPPING_URL_TYPE.equals(apiEntry.getKey())) {
                uriMapping = convertJsonElementValueToString(apiEntry.getValue());
                urlTemplate = uriMapping;
            } else if (URL_MAPPING_LABEL.equals(apiEntry.getKey())) {
                uriMapping = convertJsonElementValueToString(apiEntry.getValue());
            } else if (URI_TEMPLATE_LABEL.equals(apiEntry.getKey())) {
                urlTemplate = convertJsonElementValueToString(apiEntry.getValue());
            }
        }

        ESBAPIResourceBean resource = new ESBAPIResourceBean(method, uriMapping, urlTemplate);

        ESBAPIBean api = new ESBAPIBean(apiKey, resource, sequenceType, mediatorPosition);
        setSequence(new ESBAPISequenceBean(api));
    }

    public ESBAPISequenceBean getSequence() {
        return sequence;
    }

    public void setSequence(ESBAPISequenceBean sequence) {
        this.sequence = sequence;
    }
}
