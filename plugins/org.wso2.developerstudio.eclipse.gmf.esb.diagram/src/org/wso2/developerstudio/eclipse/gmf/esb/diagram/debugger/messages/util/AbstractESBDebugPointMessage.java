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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This is the root bean class to represent ESB artifacts debug points. Every
 * artifact debug point message bean class should extend this class.
 *
 */
public abstract class AbstractESBDebugPointMessage {

    protected static final String EMPTY_STRING = "";
    protected static final String SPACE_STRING = " ";

    protected String command;
    protected String commandArgument;
    protected String mediationComponent;

    public AbstractESBDebugPointMessage(String commandArgument, String mediationComponent) {
        this.commandArgument = commandArgument;
        this.mediationComponent = mediationComponent;
    }

    public AbstractESBDebugPointMessage(String command, String commandArgument, String mediationComponent) {
        this.command = command;
        this.commandArgument = commandArgument;
        this.mediationComponent = mediationComponent;
    }

    public AbstractESBDebugPointMessage(String mediationComponent) {
        this.mediationComponent = mediationComponent;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandArgument() {
        return commandArgument;
    }

    public void setCommandArgument(String commandArgument) {
        this.commandArgument = commandArgument;
    }

    public String getMediationComponent() {
        return mediationComponent;
    }

    public void setMediationComponent(String mediationComponent) {
        this.mediationComponent = mediationComponent;
    }

    /**
     * This method doesn't compare whether it's type is differ or not. Only
     * compare mediation component.
     * 
     * @param debugPointMessage
     * @return
     */
    public boolean equalsIgnoreType(AbstractESBDebugPointMessage debugPointMessage) {
        if (getMediationComponent().equals(debugPointMessage.getMediationComponent())) {
            return true;
        }
        return false;
    }

    /**
     * Checked whether Mediation Component and Command Argument are equal or
     * not.
     * <p>
     * Command value is not taken to compare because command attribute contains values related to debug point action
     * "set" or "clear".
     */
    @Override
    public boolean equals(Object debugPointMessage) {
        if (debugPointMessage instanceof AbstractESBDebugPointMessage) {
            AbstractESBDebugPointMessage debugPointMessageTemp = (AbstractESBDebugPointMessage) debugPointMessage;
            if (!(getMediationComponent().equals((debugPointMessageTemp).getMediationComponent()) && getCommandArgument()
                    .equals((debugPointMessageTemp).getCommandArgument()))) {
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
        return result;
    }

    /**
     * @return {@link ESBMediatorPosition} which has the mediator position of
     *         the Debug Point
     */
    public abstract ESBMediatorPosition getMediatorPosition();

    /**
     * This method set mediator position in the debug point message
     */
    public abstract void setMediatorPosition(List<Integer> position);

    /**
     * @return Sequence Type of the Debug Point message
     */
    public abstract String getSequenceType();

    /**
     * This method convert <code>JsonElement</code> value to <code>String</code> and remove quotation marks of the
     * converted <code>String</code>
     * 
     * @param value
     * @return
     */
    protected String convertJsonElementValueToString(JsonElement value) {
        return value.getAsString();

    }

    /**
     * This method convert Mediator Position <code>String</code> formatted value
     * to a <code>List<<code>Integer</code>></code> format
     * <p>
     * Eg: <code>String</code> format for mediator position is : i {space} j {space} k ...
     * <p>
     * It will be converted to a List of Integers {i,j,k,...}
     * 
     * @param position
     * @return
     */
    protected ESBMediatorPosition convertMediatorPositionStringToList(String position) {
        List<Integer> positionList = new ArrayList<>();
        String[] positionArray = position.replaceAll("\\s+", SPACE_STRING).split(SPACE_STRING);
        for (String positionValue : positionArray) {
            positionList.add(Integer.parseInt(positionValue));
        }
        return new ESBMediatorPosition(positionList);
    }
}
