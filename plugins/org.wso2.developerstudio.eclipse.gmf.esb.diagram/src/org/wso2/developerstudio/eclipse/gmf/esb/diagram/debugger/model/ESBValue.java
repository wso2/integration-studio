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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MESSAGE_ENVELOPE_VIEW_PRIMARY_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MESSAGE_ENVELOPE_VIEW_SECONDARY_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.VARIABLE_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views.AcceptedContentAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views.ContentAcceptHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * This class object holds variable values to be shown in the variables table
 *
 */
public class ESBValue extends ESBDebugElement implements IValue {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String ENVELOPE_PROPERTY_KEY = "envelope";
    private static final String EMPTY_STRING = "";
    private static final String ELEMENT_SEPERATOR = ",";

    private final String variableValue;
    private List<IVariable> valueChildren;
    private final String variableParent;
    private final Set<String> tablePropertySet;

    public ESBValue(IDebugTarget debugTarget, String value, String variableContext, Set<String> tablePropertySet) {
        super(debugTarget);
        variableValue = value;
        variableParent = variableContext;
        this.tablePropertySet = tablePropertySet;
    }

    public ESBValue(IDebugTarget target, JsonElement value, String variableContext, Set<String> tablePropertySet)
            throws DebugException {
        super(target);

        variableValue = value.toString();
        variableParent = variableContext;
        this.tablePropertySet = tablePropertySet;
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

    @Override
    public String getReferenceTypeName() throws DebugException {
        return VARIABLE_TYPE;
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

    /**
     * @param entry
     * @throws DebugException
     */
    private void addNewChildVariable(Entry<String, JsonElement> entry) throws DebugException {
        String valueString = "";
        ESBVariable esbVariable;
        if (entry.getValue().isJsonPrimitive()) {
            valueString = entry.getValue().getAsString();
            esbVariable = new ESBVariable(getDebugTarget(), entry.getKey(), valueString, variableParent,
                    tablePropertySet);
        } else {
            if (entry.getValue() instanceof JsonArray) {
                JsonArray jsonArray = entry.getValue().getAsJsonArray();
                for (JsonElement jsonElement : jsonArray) {
                    valueString += jsonElement.getAsString() + ELEMENT_SEPERATOR;
                }
                valueString = valueString.substring(0, valueString.length() - 1);
                esbVariable = new ESBVariable(getDebugTarget(), entry.getKey(), valueString, variableParent,
                        tablePropertySet);
            } else {
                esbVariable = new ESBVariable(getDebugTarget(), entry.getKey(), entry.getValue(), variableParent,
                        tablePropertySet);
            }
        }
        valueChildren.add(esbVariable);
        if (ENVELOPE_PROPERTY_KEY.equalsIgnoreCase(entry.getKey())) {
            String envelopeMessage = entry.getValue().getAsString();
            OpenEditorUtil.setToolTipMessageOnMediator(envelopeMessage);
            try {
                IViewPart envelopeView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
                        MESSAGE_ENVELOPE_VIEW_PRIMARY_ID, MESSAGE_ENVELOPE_VIEW_SECONDARY_ID,
                        IWorkbenchPage.VIEW_VISIBLE);
                if (envelopeView instanceof ContentAcceptHandler) {
                    ((ContentAcceptHandler) envelopeView).acceptContent(envelopeMessage, AcceptedContentAction.ADD);
                }
            } catch (PartInitException e) {
                log.error("Error while updating the Envelope View with new message envelope", e);;
            }
        } else if (isSpecialProperty(entry.getKey())) {
            try {
                IViewPart envelopeView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
                        MESSAGE_ENVELOPE_VIEW_PRIMARY_ID, MESSAGE_ENVELOPE_VIEW_SECONDARY_ID,
                        IWorkbenchPage.VIEW_VISIBLE);
                if (envelopeView instanceof ContentAcceptHandler) {
                    ((ContentAcceptHandler) envelopeView).acceptContent(
                            new String[] { entry.getKey(), entry.getValue().getAsString() }, AcceptedContentAction.ADD);
                }
            } catch (PartInitException e) {
                log.error("Error while updating the Envelope View with new message envelope", e);
            }
        }
        esbVariable.fireCreationEvent();
    }

    private boolean isSpecialProperty(String propertyKey) {
        if (tablePropertySet.contains(propertyKey)) {
            return true;
        } else {
            return false;
        }
    }
}
