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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROXY_KEY_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_TYPE_LABEL;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

import com.google.gson.JsonElement;

/**
 * This class is the bean class to represent ESB Proxy artifacts debug point
 * message from ESB Server Debugger
 *
 */
public class ESBProxyDebugPointMessage extends AbstractESBDebugPointMessage {

    private ESBProxySequenceBean sequence;

    public ESBProxyDebugPointMessage(String command, String commandArgument, ESBProxySequenceBean sequence) {
        super(command, commandArgument, SEQUENCE_LABEL);
        this.setSeqeunce(sequence);
    }

    public ESBProxyDebugPointMessage(EventMessageType event, JsonElement recievedArtifactInfo) {
        super(event.toString(), SEQUENCE_LABEL);
        createProxySequenceFromJsonElement(recievedArtifactInfo);
    }

    /**
     * Checked whether Mediation Component and Proxy Sequence bean are equal or
     * not.But this method doesn't compare whether it's type is differ or not.
     * <p>
     * So though skip points and breakpoints are different debug point types, this method return true if those are for
     * the same mediator.
     */
    public boolean equalsIgnoreType(ESBProxyDebugPointMessage debugPointMessage) {
        if (getMediationComponent().equals(debugPointMessage.getMediationComponent())
                && getSequence().equals(debugPointMessage.getSequence())) {
            return true;
        }
        return false;
    }

    /**
     * Checked whether Mediation Component, Command Argument and Proxy Sequence
     * bean are equal or not.
     * <p>
     * Command value is not taken to compare because command attribute contains values related to debug point action
     * "set" or "clear".
     */
    @Override
    public boolean equals(Object debugPointMessage) {
        if (debugPointMessage instanceof ESBProxyDebugPointMessage) {
            ESBProxyDebugPointMessage debugPointMessageTemp = (ESBProxyDebugPointMessage) debugPointMessage;
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
        return getSequence().getProxy().getMediatorPosition();
    }

    @Override
    public void setMediatorPosition(List<Integer> positionList) {
        getSequence().getProxy().setMediatorPosition(new ESBMediatorPosition(positionList));
    }

    @Override
    public String getSequenceType() {
        return getSequence().getProxy().getSequenceType();
    }

    private void createProxySequenceFromJsonElement(JsonElement recievedArtifactInfo) {
        Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo.getAsJsonObject().entrySet();
        String proxyKey = null;
        String sequenceType = null;
        ESBMediatorPosition mediatorPosition = null;
        for (Entry<String, JsonElement> proxyEntry : entrySet) {
            JsonElement proxyArtifactInfo = proxyEntry.getValue();
            Set<Entry<String, JsonElement>> proxyEntrySet = proxyArtifactInfo.getAsJsonObject().entrySet();
            for (Entry<String, JsonElement> entry : proxyEntrySet) {
                if (PROXY_KEY_LABEL.equalsIgnoreCase(entry.getKey())) {
                    proxyKey = convertJsonElementValueToString(entry.getValue());
                } else if (MEDIATOR_POSITION_LABEL.equalsIgnoreCase(entry.getKey())) {
                    mediatorPosition = convertMediatorPositionStringToList(convertJsonElementValueToString(entry
                            .getValue()));
                } else if (SEQUENCE_TYPE_LABEL.equalsIgnoreCase(entry.getKey())) {
                    sequenceType = convertJsonElementValueToString(entry.getValue());
                }
            }

        }
        ESBProxyBean proxy = new ESBProxyBean(proxyKey, sequenceType, mediatorPosition);
        setSeqeunce(new ESBProxySequenceBean(proxy));
    }

    public ESBProxySequenceBean getSequence() {
        return sequence;
    }

    public void setSeqeunce(ESBProxySequenceBean seqeunce) {
        this.sequence = seqeunce;
    }

}
