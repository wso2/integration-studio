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

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

import com.google.gson.JsonElement;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This class is the bean class to represent ESB Sequence artifacts debug point
 * message from ESB Server Debugger channel
 * <p>
 * Attribute values this class holding are : <u1>
 * <li>Command</li>
 * <li>Command Argument</li>
 * <li>Mediation Component</li>
 * <li>{@link ESBSequenceBean}</li><u1>
 */
public class ESBSequenceDebugPointMessage extends AbstractESBDebugPointMessage {

    private ESBSequenceBean sequence;

    public ESBSequenceDebugPointMessage(String command, String commandArgument, String mediationComponent,
            ESBSequenceBean sequence) {
        super(command, commandArgument, mediationComponent);
        this.sequence = sequence;
    }

    public ESBSequenceDebugPointMessage(EventMessageType event, JsonElement recievedArtifactInfo) {
        super(event.toString(), SEQUENCE_LABEL);
        createSequenceFromJsonElement(recievedArtifactInfo);
    }

    /**
     * Checked whether Mediation Component and Sequence bean are equal or
     * not.But this method doesn't compare whether it's type is differ or not.
     * <p>
     * So though skip points and breakpoints are different debug point types, this method return true if those are for
     * the same mediator.
     */
    public boolean equalsIgnoreType(ESBSequenceDebugPointMessage debugPointMessage) {
        if (getMediationComponent().equals(debugPointMessage.getMediationComponent())
                && getSequence().equals(debugPointMessage.getSequence())) {
            return true;
        }
        return false;
    }

    /**
     * Checked whether Mediation Component, Command Argument and Sequence bean
     * are equal or not.
     * <p>
     * Command value is not taken to compare because command attribute contains values related to debug point action
     * "set" or "clear".
     */
    @Override
    public boolean equals(Object debugPointMessage) {
        if (debugPointMessage instanceof ESBSequenceDebugPointMessage) {
            ESBSequenceDebugPointMessage debugPointMessageTemp = (ESBSequenceDebugPointMessage) debugPointMessage;
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
        return getSequence().getMediatorPosition();
    }

    @Override
    public void setMediatorPosition(List<Integer> positionList) {
        getSequence().setMediatorPosition(new ESBMediatorPosition(positionList));
    }

    @Override
    public String getSequenceType() {
        return getSequence().getSequenceType();
    }

    private void createSequenceFromJsonElement(JsonElement recievedArtifactInfo) {
        Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo.getAsJsonObject().entrySet();
        String sequenceKey = null;
        String sequenceType = null;
        ESBMediatorPosition mediatorPosition = null;
        for (Entry<String, JsonElement> entry : entrySet) {
            if (SEQUENCE_KEY_LABEL.equalsIgnoreCase(entry.getKey())) {
                sequenceKey = convertJsonElementValueToString(entry.getValue());
            } else if (SEQUENCE_TYPE_LABEL.equalsIgnoreCase(entry.getKey())) {
                sequenceType = convertJsonElementValueToString(entry.getValue());
            } else if (MEDIATOR_POSITION_LABEL.equalsIgnoreCase(entry.getKey())) {
                mediatorPosition = convertMediatorPositionStringToList(convertJsonElementValueToString(entry.getValue()));
            }
        }
        setSequence(new ESBSequenceBean(sequenceType, sequenceKey, mediatorPosition));
    }

    public ESBSequenceBean getSequence() {
        return sequence;
    }

    public void setSequence(ESBSequenceBean sequence) {
        this.sequence = sequence;
    }

}
