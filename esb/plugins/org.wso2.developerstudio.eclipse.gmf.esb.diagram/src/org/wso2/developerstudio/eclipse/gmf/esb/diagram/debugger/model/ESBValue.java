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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;

import com.google.gson.JsonElement;

/**
 * This class object holds variable values to be shown in the variables table
 *
 */
public class ESBValue extends ESBDebugElement implements IValue {

    private static final String ENVELOPE_PROPERTY_KEY = "envelope";

    private final String variableValue;
    private List<IVariable> valueChildren;
    private final String variableParent;

    public ESBValue(IDebugTarget debugTarget, String value, String variableContext) {
        super(debugTarget);
        variableValue = value;
        variableParent = variableContext;
    }

    public ESBValue(IDebugTarget target, JsonElement value, String variableContext) throws DebugException {
        super(target);

        variableValue = value.toString();
        variableParent = variableContext;
        if (!value.isJsonNull()) {
            Set<Entry<String, JsonElement>> entrySet = value.getAsJsonObject().entrySet();
            if (valueChildren != null) {
                for (Entry<String, JsonElement> entry : entrySet) {
                    addValueToMatchingChildVariable(entry);
                }
            } else {
                valueChildren = new ArrayList<>();
                for (Entry<String, JsonElement> entry : entrySet) {
                    addNewChildVariable(entry);
                }
            }
        }
    }

    /**
     * @param entry
     * @throws DebugException
     */
    private void addNewChildVariable(Entry<String, JsonElement> entry) throws DebugException {
        String valueString = "";
        ESBVariable esbVariable;
        if (entry.getValue().isJsonPrimitive()) {
            valueString = entry.getValue().getAsString();
            esbVariable = new ESBVariable(getDebugTarget(), entry.getKey(), valueString, variableParent);
        } else {
            esbVariable = new ESBVariable(getDebugTarget(), entry.getKey(), entry.getValue(), variableParent);
        }
        valueChildren.add(esbVariable);
        if (ENVELOPE_PROPERTY_KEY.equalsIgnoreCase(entry.getKey())) {
            OpenEditorUtil.setToolTipMessageOnMediator(entry.getValue().getAsString());
        }
        esbVariable.fireCreationEvent();
    }

    /**
     * @param entry
     * @throws DebugException
     */
    private void addValueToMatchingChildVariable(Entry<String, JsonElement> entry) throws DebugException {
        for (IVariable variable : valueChildren) {
            if (variable.getName().equals(entry.getKey())) {
                variable.setValue(entry.getValue().getAsString());
                ((ESBVariable) variable).fireChangeEvent(DebugEvent.CONTENT);
                if (variable.getName().equalsIgnoreCase(ENVELOPE_PROPERTY_KEY)) {
                    OpenEditorUtil.setToolTipMessageOnMediator(entry.getValue().getAsString());
                }
                break;
            }
        }
    }

    @Override
    public String getReferenceTypeName() throws DebugException {
        return ESBDebuggerConstants.VARIABLE_TYPE;
    }

    /**
     * This method returns the value contains in this ESBValue object.
     */
    @Override
    public String getValueString() throws DebugException {
        return variableValue;
    }

    /**
     * This should return false if the ESBValue is Garbage Collected.
     */
    @Override
    public boolean isAllocated() throws DebugException {
        return true;
    }

    /**
     * This method returns Array of child variables contain in this ESBValue.
     */
    @Override
    public IVariable[] getVariables() throws DebugException {
        return valueChildren.toArray(new IVariable[valueChildren.size()]);
    }

    /**
     * This method returns true if this ESBValue has child variables
     */
    @Override
    public boolean hasVariables() throws DebugException {
        return !(valueChildren == null || valueChildren.isEmpty());
    }

    public List<IVariable> getVariableList() {
        return valueChildren;
    }

    public void addChildVariable(IVariable child) {
        if (valueChildren == null) {
            valueChildren = new ArrayList<IVariable>();
            valueChildren.add(child);
        } else {
            valueChildren.add(child);
        }

    }
}
