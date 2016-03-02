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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INBOUND_ENDPOINT_KEY_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.INITIAL_HASH_CODE_RESULT_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATION_COMPONENT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MEDIATOR_POSITION_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_TYPE_LABEL;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

import com.google.gson.JsonElement;

/**
 * This class is the bean class to represent ESB Inbound Endpoint artifacts
 * debug point message from ESB Server Debugger
 *
 */
public class ESBInboundEndpointDebugPointMessage extends AbstractESBDebugPointMessage {

    private ESBInboundEndpointSequenceBean sequence;

    public ESBInboundEndpointDebugPointMessage(String command, String commandArgument,
            ESBInboundEndpointSequenceBean sequence) {
        super(command, commandArgument, SEQUENCE_LABEL);
        this.setSeqeunce(sequence);
    }

    public ESBInboundEndpointDebugPointMessage(EventMessageType event, JsonElement recievedArtifactInfo) {
        super(event.toString(), SEQUENCE_LABEL);
        createInboundSequenceFromJsonElement(recievedArtifactInfo);
    }

    /**
     * Checked whether Mediation Component and Inbound Endpoint Sequence bean
     * are equal or not.But this method doesn't compare whether it's type is
     * differ or not.
     * <p>
     * So though skip points and breakpoints are different debug point types, this method return true if those are for
     * the same mediator.
     */
    public boolean equalsIgnoreType(ESBInboundEndpointDebugPointMessage debugPointMessage) {
        if (getMediationComponent().equals(debugPointMessage.getMediationComponent())
                && getSequence().equals(debugPointMessage.getSequence())) {
            return true;
        }
        return false;
    }

    /**
     * Checked whether Mediation Component, Command Argument and Inbound
     * Endpoint Sequence bean are equal or not.
     * <p>
     * Command value is not taken to compare because command attribute contains values related to debug point action
     * "set" or "clear".
     */
    @Override
    public boolean equals(Object debugPointMessage) {
        if (debugPointMessage instanceof ESBInboundEndpointDebugPointMessage) {
            ESBInboundEndpointDebugPointMessage debugPointMessageTemp = (ESBInboundEndpointDebugPointMessage) debugPointMessage;
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
        result = HASHCODE_MULTIPLIER_VALUE * result + getMediationComponent().hashCode()
                + MEDIATION_COMPONENT_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getCommandArgument().hashCode()
                + COMMAND_ARGUMENT_LABEL.hashCode();
        result = HASHCODE_MULTIPLIER_VALUE * result + getSequence().hashCode() + SEQUENCE_LABEL.hashCode();
        return result;
    }

    @Override
    public ESBMediatorPosition getMediatorPosition() {
        return getSequence().getInboundEndpoint().getMediatorPosition();
    }

    @Override
    public void setMediatorPosition(List<Integer> positionList) {
        getSequence().getInboundEndpoint().setMediatorPosition(new ESBMediatorPosition(positionList));
    }

    @Override
    public String getSequenceType() {
        return getSequence().getInboundEndpoint().getSequenceType();
    }

    private void createInboundSequenceFromJsonElement(JsonElement recievedArtifactInfo) {
        Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo.getAsJsonObject().entrySet();
        String inboundKey = null;
        String sequenceType = null;
        ESBMediatorPosition mediatorPosition = null;
        for (Entry<String, JsonElement> inboundEntry : entrySet) {
            JsonElement inboundArtifactInfo = inboundEntry.getValue();
            Set<Entry<String, JsonElement>> inboundEntrySet = inboundArtifactInfo.getAsJsonObject().entrySet();
            for (Entry<String, JsonElement> entry : inboundEntrySet) {
                if (INBOUND_ENDPOINT_KEY_LABEL.equalsIgnoreCase(entry.getKey())) {
                    inboundKey = convertJsonElementValueToString(entry.getValue());
                } else if (MEDIATOR_POSITION_LABEL.equalsIgnoreCase(entry.getKey())) {
                    mediatorPosition = convertMediatorPositionStringToList(convertJsonElementValueToString(entry
                            .getValue()));
                } else if (SEQUENCE_TYPE_LABEL.equalsIgnoreCase(entry.getKey())) {
                    sequenceType = convertJsonElementValueToString(entry.getValue());
                }
            }

        }
        ESBInboundEndpointBean inbound = new ESBInboundEndpointBean(inboundKey, sequenceType, mediatorPosition);
        setSeqeunce(new ESBInboundEndpointSequenceBean(inbound));
    }

    public ESBInboundEndpointSequenceBean getSequence() {
        return sequence;
    }

    public void setSeqeunce(ESBInboundEndpointSequenceBean seqeunce) {
        this.sequence = seqeunce;
    }
}
