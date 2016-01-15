/*
 * Copyright (c) 2015-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYNAPSE_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYNAPSE_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.PropertyChangeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PropertyValueBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonElement;

/**
 * This class represents variables to show in the variable tab.
 *
 */
public class ESBVariable extends ESBDebugElement implements IVariable {

    private final String variableName;
    private ESBValue variableValue;
    private final String variableContext;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    protected ESBVariable(IDebugTarget target, String name, String value, String context) throws DebugException {
        super(target);
        variableName = name;
        variableContext = context;
        setValue(value);
    }

    public ESBVariable(IDebugTarget target, String name, JsonElement value, String context) throws DebugException {
        super(target);
        variableName = name;
        variableContext = context;
        setValue(value);
    }

    /**
     * Sets value of the variable when given as a String object.
     * 
     * @throws DebugException
     */
    public void setValue(JsonElement expression) throws DebugException {
        variableValue = new ESBValue(getDebugTarget(), expression, variableName);
    }

    @Override
    public void setValue(String expression) throws DebugException {
        variableValue = new ESBValue(getDebugTarget(), expression, variableName);
    }

    /**
     * Sets value of the variable when given as a IValue object.
     */
    @Override
    public void setValue(IValue value) {
        variableValue = (ESBValue) value;
    }

    /**
     * Returns whether this variable supports value modification.
     */
    @Override
    public boolean supportsValueModification() {
        try {
            return !variableValue.hasVariables();
        } catch (DebugException e) {
            log.error("Error while trying to check whether variable " + variableValue.toString()
                    + " has child variables", e);
        }
        return false;
    }

    @Override
    public boolean verifyValue(String modifiedValue) {
        PropertyValueBean property = new PropertyValueBean(variableName, modifiedValue);
        PropertyChangeCommand propertyCommand = new PropertyChangeCommand(SET_COMMAND, PROPERTY_VALUE,
                getPropertyContextNameOfUIPropertyName(variableContext), property);
        PropertyChangeRequest propertyChangeRequest = new PropertyChangeRequest(propertyCommand);
        getDebugTarget().fireModelEvent(propertyChangeRequest);
        return true;
    }

    @Override
    public boolean verifyValue(IValue value) throws DebugException {
        return false;
    }

    /**
     * Returns the value of this variable.
     */
    @Override
    public IValue getValue() {
        return variableValue;
    }

    /**
     * Returns the name of this variable.
     */
    @Override
    public String getName() {
        return variableName;
    }

    /**
     * Returns a description of the type of data this variable is declared to
     * reference.
     */
    @Override
    public String getReferenceTypeName() throws DebugException {
        return ESBDebuggerConstants.VARIABLE_TYPE;
    }

    @Override
    public boolean hasValueChanged() throws DebugException {
        return false;
    }

    private String getPropertyContextNameOfUIPropertyName(String name) {
        switch (name) {
        case AXIS2_PROPERTIES_TAG:
            return AXIS2_PROPERTIES_KEY;
        case AXIS2_CLIENT_PROPERTIES_TAG:
            return AXIS2_CLIENT_PROPERTIES_KEY;
        case SYNAPSE_PROPERTIES_TAG:
            return SYNAPSE_PROPERTIES_KEY;
        case TRANSPORT_PROPERTIES_TAG:
            return TRANSPORT_PROPERTIES_KEY;
        case OPERATION_PROPERTIES_TAG:
            return OPERATION_PROPERTIES_KEY;
        }
        return name;
    }

}
