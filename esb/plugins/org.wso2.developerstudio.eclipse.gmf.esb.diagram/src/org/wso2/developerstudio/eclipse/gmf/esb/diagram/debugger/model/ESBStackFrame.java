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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROPERTY_CHANGE_COMMAND_HANDLER_EVENT_TOPIC;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.FetchVariablesRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.PropertyChangeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.TerminateRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class represents an execution context in a suspended thread. And it
 * contains variables representing visible locals and arguments at the current
 * execution location.
 * 
 */
public class ESBStackFrame extends ESBDebugElement implements IStackFrame, EventHandler {

    private final IThread thread;
    private int lineNumber = 1;
    private List<IVariable> variables = new ArrayList<>();
    private boolean variablesDirty = true;
    private IEventBroker propertyChangeCommandEB;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public ESBStackFrame(IDebugTarget target, IThread thread) {
        super(target);
        this.thread = thread;
        propertyChangeCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
        propertyChangeCommandEB.subscribe(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT, this);
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

    public void setVariables(PropertyRespondMessage propertyRespondMessage) throws DebugException {

        String name = propertyRespondMessage.getScope();
        boolean processed = false;
        for (IVariable variable : variables) {
            if (variable.getName().equals(getUITableVariableName(name))) {
                ((ESBVariable) variable).setValue(propertyRespondMessage.getPropertyValues());
                ((ESBVariable) variable).fireChangeEvent(DebugEvent.CONTENT);
                processed = true;
                break;
            }
        }

        if (!processed) {
            ESBVariable textVariable = new ESBVariable(getDebugTarget(), getUITableVariableName(name),
                    propertyRespondMessage.getPropertyValues().toString(), null);
            variables.add(textVariable);
            textVariable.fireCreationEvent();
        }
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

}
