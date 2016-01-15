/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.actions;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_DEBUGGER_EVENT_BROKER_DATA_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_MESSAGE_MEDIATION_PROPERTY_CLEAR_COMMAND_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_MESSAGE_MEDIATION_PROPERTY_INJECT_COMMAND_ID;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROPERTY_CHANGE_COMMAND_HANDLER_EVENT_TOPIC;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.FetchVariablesRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBStackFrame;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class handles the commands executed by the user from UI regarding ESB Message Mediation Property injecting and
 * clearing. This class is mentioned in the plugin.xml to handle those commands as following,
 * 
 * <pre>
 * {@code   <extension point="org.eclipse.ui.handlers">
 *     <handler
 *             commandId="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.commands.InjectNewProperty"
 *             class="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.actions.PropertyChangeCommandHandler"/>
 *     <handler
 *             commandId="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.commands.ClearProperty"
 *             class="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.actions.PropertyChangeCommandHandler"/>
 *  </extension>}
 * </pre>
 *
 */
public class PropertyChangeCommandHandler extends AbstractHandler implements EventHandler {

    private IEventBroker propertyChangeCommandEB;
    List<IVariable> variables;
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * This method handles the events received from commands which triggered by user UI interactions for
     * InjectNewProperty and ClearProperty
     * <p>
     * When InjectNewProperty triggered the {@link InjectPropertyDialog} was opened for user to provide the attributes.
     * 
     * <p>
     * When ClearProperty triggered this method sends an event request of {@link FetchVariablesRequest} for Eclipse
     * Event Manager Topic which listened by {@link ESBStackFrame} instance Event Broker.
     */
    @Override
    public Object execute(ExecutionEvent handlerEvent) throws ExecutionException {
        initializeHandler();
        String commandId = handlerEvent.getCommand().getId();
        if (ESB_MESSAGE_MEDIATION_PROPERTY_INJECT_COMMAND_ID.equals(commandId)) {
            Shell shell = new Shell();
            InjectPropertyDialog dialog = new InjectPropertyDialog(shell);
            PropertyChangeCommand propertyCommandMessage = dialog.open();
            if (propertyCommandMessage.getContext() != null) {
                propertyChangeCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT, propertyCommandMessage);
            }
            disposeEventBroker();
        } else if (ESB_MESSAGE_MEDIATION_PROPERTY_CLEAR_COMMAND_ID.equals(commandId)) {
            propertyChangeCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT, new FetchVariablesRequest());
        } else {
            log.warn("Unhandled Command Id recieved for PropertyChangeCommandHandler : " + commandId);
            disposeEventBroker();
        }
        return null;
    }

    /**
     * This method handles events listened by Event Broker Registered to this handler.
     * <p>
     * When handler receives response from {@link ESBStackFrame} for the {@link FetchVariablesRequest} it opens the
     * {@link ClearPropertyDialog}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void handleEvent(Event eventFromBroker) {
        Object eventObject = eventFromBroker.getProperty(ESB_DEBUGGER_EVENT_BROKER_DATA_NAME);
        if (eventObject instanceof List) {
            variables = (List<IVariable>) eventObject;
            Shell shell = new Shell();
            ClearPropertyDialog dialog = null;
            try {
                dialog = new ClearPropertyDialog(shell, variables);
            } catch (DebugException e) {
                log.error("Error while opening Property clear window : " + e.getMessage(), e);
            }
            PropertyChangeCommand propertyCommandMessage = dialog.open();
            if (propertyCommandMessage.getContext() != null) {
                propertyChangeCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT, propertyCommandMessage);
            }
        } else {
            log.warn("Unhandled Event type recived for ESBStackFrame : " + eventObject.toString());
        }
        disposeEventBroker();
    }

    private void disposeEventBroker() {
        propertyChangeCommandEB.unsubscribe(this);
        propertyChangeCommandEB = null;
    }

    private void initializeHandler() {
        propertyChangeCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
        propertyChangeCommandEB.subscribe(PROPERTY_CHANGE_COMMAND_HANDLER_EVENT_TOPIC, this);
    }

}
