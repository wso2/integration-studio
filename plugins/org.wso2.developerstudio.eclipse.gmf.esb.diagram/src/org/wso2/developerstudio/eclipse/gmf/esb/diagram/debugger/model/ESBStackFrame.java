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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_DEBUGGER_EVENT_BROKER_DATA_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MESSAGE_ENVELOPE_VIEW_PRIMARY_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MESSAGE_ENVELOPE_VIEW_SECONDARY_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROPERTY_CHANGE_COMMAND_HANDLER_EVENT_TOPIC;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_STACK_FRAME_WIRE_LOGS_RECEIVED_EVENT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.WIRE_LOG_VIEW_PRIMARY_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.WIRE_LOG_VIEW_SECONDARY_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.AddPropertyToTableDialogRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.ClearPropertyFromTableDialogRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.FetchVariablesRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.PropertyChangeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.TerminateRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.actions.AddPropertyToTableDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.actions.RemovePropertyFromTableDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views.AcceptedContentAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views.ContentAcceptHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views.DefaultPropertyValues;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * This class represents an execution context in a suspended thread. And it
 * contains variables representing visible locals and arguments at the current
 * execution location.
 * 
 */
public class ESBStackFrame extends ESBDebugElement implements IStackFrame, EventHandler {

    private static final String EMPTY_STRING = "";
    private static final String MEDIATION_COMPONENT_WIRELOG_KEY = "mediation-component";
    private static final String API_WIRELOG_KEY = "api";
    private static final String RESOURCE_WIRELOG_KEY = "resource";
    private static final String URL_MAPPING_OLD_WIRELOG_KEY = "url-mapping";
    private static final String URL_MAPPING_OLD_WIRELOG_KEY_TEMPLATE = "uri-template";
    private static final String URL_MAPPING_NEW_WIRELOG_KEY = "mapping";
    private static final String METHOD_WIRELOG_KEY = "method";
    private static final String SEQUENCE_WIRELOG_KEY = "sequence";
    
    private final IThread thread;
    private int lineNumber = 1;
    private List<IVariable> variables = new ArrayList<>();
    private boolean variablesDirty = true;
    private IEventBroker propertyChangeCommandEB;
    private Set<String> tablePropertySet = new HashSet<>();
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private Map<JsonObject, ESBWirelog> wireLogs = new HashMap<JsonObject, ESBWirelog>();

    public ESBStackFrame(IDebugTarget target, IThread thread) {
        super(target);
        this.thread = thread;
        propertyChangeCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
        propertyChangeCommandEB.subscribe(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT, this);
        propertyChangeCommandEB.subscribe(ESB_STACK_FRAME_WIRE_LOGS_RECEIVED_EVENT, this);
        try {
            IViewPart envelopeView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
                    MESSAGE_ENVELOPE_VIEW_PRIMARY_ID, MESSAGE_ENVELOPE_VIEW_SECONDARY_ID, IWorkbenchPage.VIEW_VISIBLE);
            if (envelopeView instanceof ContentAcceptHandler) {
                for (DefaultPropertyValues propertyValue : DefaultPropertyValues.values()) {
                    ((ContentAcceptHandler) envelopeView).acceptContent(
                            new String[] { propertyValue.getPropertyName(), "" }, AcceptedContentAction.ADD);
                    tablePropertySet.add(propertyValue.getPropertyName());
                }
            }
        } catch (PartInitException e) {
            log.error("Error while removing a property from Envelope Property table", e);
        }
    }

    @Override
    public IThread getThread() {
        return thread;
    }

    @Override
    public synchronized IVariable[] getVariables() {
        if (variablesDirty) {
            variablesDirty = false;
            getDebugTarget().fireModelEvent(new FetchVariablesRequest());
        }
        return variables.toArray(new IVariable[variables.size()]);
    }

    @Override
    public boolean hasVariables() {
        return getVariables().length > 0;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public int getCharStart() {
        return -1;
    }

    @Override
    public int getCharEnd() {
        return -1;
    }

    @Override
    public IRegisterGroup[] getRegisterGroups() {
        return new IRegisterGroup[0];
    }

    @Override
    public boolean hasRegisterGroups() {
        return getRegisterGroups().length > 0;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void clearEnvelopeViewPropertyTableValues() {
        try {
            IViewPart envelopeView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
                    MESSAGE_ENVELOPE_VIEW_PRIMARY_ID, MESSAGE_ENVELOPE_VIEW_SECONDARY_ID, IWorkbenchPage.VIEW_VISIBLE);
            for (String propertyKey : tablePropertySet) {
                if (envelopeView instanceof ContentAcceptHandler) {
                    ((ContentAcceptHandler) envelopeView).acceptContent(new String[] { propertyKey, "" },
                            AcceptedContentAction.ADD);
                }
            }
            if (envelopeView instanceof ContentAcceptHandler) {
                ((ContentAcceptHandler) envelopeView).acceptContent(EMPTY_STRING, AcceptedContentAction.ADD);
            }
        } catch (PartInitException e) {
            log.error("Error while updating the Envelope View with cleared variable values", e);
        }
    }

    public void setVariables(PropertyRespondMessage propertyRespondMessage) throws DebugException {
        String name = propertyRespondMessage.getScope();
        if (name.equalsIgnoreCase("wirelogs")) {
            wireLogs.clear();
            JsonArray wireLogsArray = propertyRespondMessage.getPropertyValues().getAsJsonArray();
            for (int i = 0; i < wireLogsArray.size(); i++) {
                JsonObject wireLog = wireLogsArray.get(i).getAsJsonObject();
                JsonObject mediatorId = wireLog.get("mediatorId").getAsJsonObject();
                String requestWireLog = "";
                if (wireLog.get("wireLogEntry").getAsJsonObject().get("requestWireLog") != null) {
                    requestWireLog = wireLog.get("wireLogEntry").getAsJsonObject().get("requestWireLog").getAsString();
                }
                String responseWireLog = "";
                if (wireLog.get("wireLogEntry").getAsJsonObject().get("responseWireLog") != null) {
                    responseWireLog = wireLog.get("wireLogEntry").getAsJsonObject().get("responseWireLog")
                            .getAsString();
                }
                ESBWirelog esbWirelog = new ESBWirelog();
                esbWirelog.setMediatorId(mediatorId);
                esbWirelog.setRequestWireLog(requestWireLog);
                esbWirelog.setResponseWireLog(responseWireLog);
                wireLogs.put(mediatorId, esbWirelog);
            }
            return;
        }
        boolean processed = false;
        for (int index = 0; index < variables.size(); index++) {
            if (variables.get(index).getName().equals(getUITableVariableName(name))) {
                ESBVariable esbVariable = ((ESBVariable) variables.get(index));
                esbVariable.setValue(propertyRespondMessage.getPropertyValues());
                esbVariable.fireChangeEvent(DebugEvent.CONTENT);
                ((ESBValue) esbVariable.getValue()).fireChangeEvent(DebugEvent.CONTENT);
                processed = true;
                break;
            }
        }

        if (!processed) {
            ESBVariable textVariable = new ESBVariable(getDebugTarget(), getUITableVariableName(name),
                    propertyRespondMessage.getPropertyValues().toString(), null, tablePropertySet);
            variables.add(textVariable);
            textVariable.fireCreationEvent();
        }
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .findView("org.eclipse.debug.ui.VariableView");
    }

    @Override
    public synchronized void fireChangeEvent(int detail) {
        variablesDirty = true;
        super.fireChangeEvent(detail);
    }

    @Override
    public String getName() throws DebugException {
        return Messages.ESBStackFrame_ESBDebuggerStackFrameTag;
    }

    private String getUITableVariableName(String name) {
        switch (name) {
        case ESBDebuggerConstants.AXIS2_PROPERTIES_KEY:
            return Messages.ESBStackFrame_Axis2ScopePropertyTag;
        case ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_KEY:
            return Messages.ESBStackFrame_Axis2ClientScopePropertyTag;
        case ESBDebuggerConstants.SYNAPSE_PROPERTIES_KEY:
            return Messages.ESBStackFrame_SynapseScopePropertyTag;
        case ESBDebuggerConstants.TRANSPORT_PROPERTIES_KEY:
            return Messages.ESBStackFrame_TransportScopePropertyTag;
        case ESBDebuggerConstants.OPERATION_PROPERTIES_KEY:
            return Messages.ESBStackFrame_OperationScopePropertyTag;
        }
        return name;
    }

    @Override
    public void handleEvent(Event propertyEvent) {
        Object eventObject = propertyEvent.getProperty(ESB_DEBUGGER_EVENT_BROKER_DATA_NAME);
        if (eventObject instanceof PropertyChangeCommand) {
            PropertyChangeCommand propertyCommand = (PropertyChangeCommand) eventObject;
            PropertyChangeRequest propertyChangeRequest = new PropertyChangeRequest(propertyCommand);
            getDebugTarget().fireModelEvent(propertyChangeRequest);
        } else if (eventObject instanceof FetchVariablesRequest) {
            propertyChangeCommandEB.send(PROPERTY_CHANGE_COMMAND_HANDLER_EVENT_TOPIC, variables);
        } else if (eventObject instanceof AddPropertyToTableDialogRequest) {
            AddPropertyToTableDialog addPropertyDialog = null;
            try {
                addPropertyDialog = new AddPropertyToTableDialog(Display.getDefault().getActiveShell(), variables);
                addPropertyDialog.create();
            } catch (DebugException e) {
                log.error("Error while opening Property add property window : " + e.getMessage(), e);
            }
            PropertyChangeCommand propertyCommandMessage = null;
            if (addPropertyDialog.open() == Window.OK) {
                propertyCommandMessage = addPropertyDialog.getCommandMessage();
                if (propertyCommandMessage.getContext() != null) {
                    String propertyName = propertyCommandMessage.getProperty().getPropertyName();
                    String propertyContext = propertyCommandMessage.getContext();
                    tablePropertySet.add(propertyName);
                    try {
                        String propertyValue = getPropertyValueFromVariableList(propertyName, propertyContext);
                        IViewPart envelopeView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                                .showView(MESSAGE_ENVELOPE_VIEW_PRIMARY_ID, MESSAGE_ENVELOPE_VIEW_SECONDARY_ID,
                                        IWorkbenchPage.VIEW_VISIBLE);
                        if (envelopeView instanceof ContentAcceptHandler) {
                            ((ContentAcceptHandler) envelopeView).acceptContent(new String[] {
                                    propertyCommandMessage.getProperty().getPropertyName(), propertyValue },
                                    AcceptedContentAction.ADD);
                        }
                    } catch (PartInitException | DebugException e) {
                        log.error("Error while updating the Envelope Property View with message properties", e);
                    }
                }
            }
        } else if (eventObject instanceof ClearPropertyFromTableDialogRequest) {
            RemovePropertyFromTableDialog removePropertyDialog = null;
            removePropertyDialog = new RemovePropertyFromTableDialog(Display.getDefault().getActiveShell(),
                    tablePropertySet);
            removePropertyDialog.create();
            PropertyChangeCommand propertyCommandMessage = null;
            if (removePropertyDialog.open() == Window.OK) {
                propertyCommandMessage = removePropertyDialog.getCommandMessage();
                if (propertyCommandMessage.getContext() != null) {
                    tablePropertySet.remove(propertyCommandMessage.getProperty().getPropertyName());
                    try {
                        IViewPart envelopeView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                                .showView(MESSAGE_ENVELOPE_VIEW_PRIMARY_ID, MESSAGE_ENVELOPE_VIEW_SECONDARY_ID,
                                        IWorkbenchPage.VIEW_VISIBLE);
                        if (envelopeView instanceof ContentAcceptHandler) {
                            ((ContentAcceptHandler) envelopeView).acceptContent(
                                    new String[] { propertyCommandMessage.getProperty().getPropertyName(), "" },
                                    AcceptedContentAction.REMOVE);
                        }
                    } catch (PartInitException e) {
                        log.error("Error while removing a property from Envelope Property table", e);
                    }
                }
            }
        } else if (eventObject instanceof JsonObject) {
            JsonObject breakpointCommandJsonObject = (JsonObject) eventObject;

            // The following if block runs for API level wire logs, since there is change of
            // wire log ID from the server side

            if (breakpointCommandJsonObject.get(MEDIATION_COMPONENT_WIRELOG_KEY) != null
                    && breakpointCommandJsonObject.get(SEQUENCE_WIRELOG_KEY) != null
                    && breakpointCommandJsonObject.get(SEQUENCE_WIRELOG_KEY).getAsJsonObject().get(API_WIRELOG_KEY) != null) {

                JsonObject resourceJsonObject = breakpointCommandJsonObject.get(SEQUENCE_WIRELOG_KEY).getAsJsonObject().get(API_WIRELOG_KEY)
                        .getAsJsonObject().get(RESOURCE_WIRELOG_KEY).getAsJsonObject();

                JsonElement urlMappingElement = resourceJsonObject.get(URL_MAPPING_OLD_WIRELOG_KEY);
                resourceJsonObject.remove(URL_MAPPING_OLD_WIRELOG_KEY);
                if(urlMappingElement == null) {
                    urlMappingElement = resourceJsonObject.get(URL_MAPPING_OLD_WIRELOG_KEY_TEMPLATE);
                    resourceJsonObject.remove(URL_MAPPING_OLD_WIRELOG_KEY_TEMPLATE);
                }

                JsonElement methodElement = resourceJsonObject.get(METHOD_WIRELOG_KEY);
                resourceJsonObject.remove(METHOD_WIRELOG_KEY);

                if (urlMappingElement != null) {
                    resourceJsonObject.add(URL_MAPPING_NEW_WIRELOG_KEY, urlMappingElement);
                }
                resourceJsonObject.add(METHOD_WIRELOG_KEY, methodElement);

                JsonElement mediationComponentElment = breakpointCommandJsonObject.get(MEDIATION_COMPONENT_WIRELOG_KEY);
                JsonElement sequenceElment = breakpointCommandJsonObject.get(SEQUENCE_WIRELOG_KEY);

                breakpointCommandJsonObject.remove(MEDIATION_COMPONENT_WIRELOG_KEY);
                breakpointCommandJsonObject.remove(SEQUENCE_WIRELOG_KEY);

                breakpointCommandJsonObject.add(MEDIATION_COMPONENT_WIRELOG_KEY, mediationComponentElment);
                breakpointCommandJsonObject.add(SEQUENCE_WIRELOG_KEY, sequenceElment);

            }

            ESBWirelog relaventWireLog = wireLogs.get(breakpointCommandJsonObject);
            try {
                IViewPart wireLogView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .showView(WIRE_LOG_VIEW_PRIMARY_ID, WIRE_LOG_VIEW_SECONDARY_ID, IWorkbenchPage.VIEW_VISIBLE);
                if (wireLogView instanceof ContentAcceptHandler) {
                    ((ContentAcceptHandler) wireLogView).acceptContent(relaventWireLog, null);
                }
            } catch (PartInitException e) {
                log.error("Error while updating the wirelog view", e);
            }

        } else {
            log.warn("Unhandled Event type recived for ESBStackFrame : " + eventObject.toString());
        }
    }

    @Override
    public void terminate() {
        propertyChangeCommandEB.unsubscribe(this);
        getDebugTarget().fireModelEvent(new TerminateRequest());
        OpenEditorUtil.removeBreakpointHitStatus();
    }

    private String getPropertyValueFromVariableList(String propertyName, String propertyContext) throws DebugException {
        for (IVariable contextVariable : variables) {
            if (ESBDebuggerUtil.getPropertyContextNameOfUIPropertyName(contextVariable.getName())
                    .equals(propertyContext)) {
                IVariable[] properties = contextVariable.getValue().getVariables();
                for (IVariable propertyVariable : properties) {
                    if (propertyVariable.getName().equals(propertyName)) {
                        return propertyVariable.getValue().getValueString();
                    }
                }
            }
        }
        throw new IllegalArgumentException(
                "Property value for given argument not exist : " + propertyContext + " " + propertyName);
    }

}
