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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.impl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESBDEBUGGER_EVENT_TOPIC;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_DEBUGGER_EVENT_BROKER_DATA_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_DEBUG_TARGET_EVENT_TOPIC;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.GET_COMMAND_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROPERTIES_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYANPSE_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTY_TAG;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.IESBDebugger;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.IESBDebuggerInterface;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IESBDebuggerInternalEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.DebuggerStartedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.MediationFlowCompleteEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.PropertyRecievedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.ResumedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.SuspendedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.TerminatedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.DebugPointRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.FetchVariablesRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.PropertyChangeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.ResumeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.TerminateRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.IEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.IResponseMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.CommandMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.GetPropertyCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.DebugPointEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.GeneralEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.SpecialCoordinationEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.CommandResponseMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerCommands;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerResumeType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * {@link ESBDebugger} implements the representation of ESB Mediation debugger
 * to communicate UI and ESB Server.
 */
public class ESBDebugger implements IESBDebugger, EventHandler {

    private IEventBroker debuggerEventBroker;
    private boolean stepping = false;
    private IESBDebuggerInterface debuggerInterface;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public ESBDebugger(int commandPort, int eventPort, String hostName) throws IOException {
        this(new ESBDebuggerInterface(commandPort, eventPort, hostName));
    }

    public ESBDebugger(IESBDebuggerInterface debuggerInterface) {
        debuggerEventBroker = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
        debuggerEventBroker.subscribe(ESB_DEBUG_TARGET_EVENT_TOPIC, this);
        this.debuggerInterface = debuggerInterface;
        this.debuggerInterface.attachDebugger(this);
    }

    @Override
    public void handleEvent(Event eventFromBroker) {
        IESBDebuggerInternalEvent event = (IESBDebuggerInternalEvent) eventFromBroker
                .getProperty(ESB_DEBUGGER_EVENT_BROKER_DATA_NAME);
        try {
            if (event instanceof ResumeRequest) {
                stepping = (((ResumeRequest) event).getType().equals(ESBDebuggerResumeType.STEP_OVER));
                debuggerInterface.sendCommand(new CommandMessage(ESBDebuggerCommands.RESUME_COMMAND));
            } else if (event instanceof DebugPointRequest) {
                sendDebugPointForServer((DebugPointRequest) event);
            } else if (event instanceof FetchVariablesRequest) {
                getPropertiesFromESB();
            } else if (event instanceof TerminateRequest) {
                fireTerminatedEvent();
            } else if (event instanceof PropertyChangeRequest) {
                debuggerInterface.sendChangePropertyCommand(((PropertyChangeRequest) event).getPropertyCommand());
            }
        } catch (IOException e) {
            log.error("Termination Operation Failed", e);
        } catch (Exception e) {
            log.error("Failed to perform event from ESBDebugger " + e.getMessage(), e);
        }

    }

    @Override
    public void fireLoadedEvent() {
        fireEvent(new DebuggerStartedEvent());
    }

    @Override
    public void fireSuspendedEvent(final DebugPointEventMessage event) {
        fireEvent(new SuspendedEvent(event));
    }

    @Override
    public void fireResumedEvent() {
        fireEvent(new ResumedEvent(stepping ? ESBDebuggerResumeType.STEP_OVER : ESBDebuggerResumeType.CONTINUE));
    }

    @Override
    public void fireTerminatedEvent() throws IOException, DebugPointMarkerNotFoundException, CoreException {
        ESBDebuggerUtil.removeDebugPointsFromESBServer(debuggerInterface);
        debuggerInterface.sendCommand(new CommandMessage(ESBDebuggerCommands.RESUME_COMMAND));
        fireEvent(new TerminatedEvent());
        log.info("Sending terminate request to debug target");
        debuggerInterface.terminate();
        debuggerEventBroker.unsubscribe(this);
    }

    /**
     * Pass an event to the {@link InternalEventDispatcher} where it is handled
     * asynchronously.
     * 
     * @param event
     *            event to handle
     */
    public void fireEvent(final IESBDebuggerInternalEvent event) {
        debuggerEventBroker.send(ESBDEBUGGER_EVENT_TOPIC, event);
    }

    @Override
    public IESBDebuggerInterface getESBDebuggerInterface() {
        return debuggerInterface;
    }

    @Override
    public void notifyResponce(IResponseMessage responseMessage) {

        if (responseMessage instanceof CommandResponseMessage) {
            CommandResponseMessage response = (CommandResponseMessage) responseMessage;
            if (StringUtils.isNotEmpty(response.getFailedReason())) {
                log.warn(response.getFailedReason());
            }
        } else if (responseMessage instanceof PropertyRespondMessage) {
            fireEvent(new PropertyRecievedEvent((PropertyRespondMessage) responseMessage));
        }

    }

    @Override
    public void notifyEvent(IEventMessage event) {

        if (event instanceof DebugPointEventMessage) {
            if (((DebugPointEventMessage) event).getEvent() == EventMessageType.BREAKPOINT) {
                fireSuspendedEvent((DebugPointEventMessage) event);
            }

        } else if (event instanceof SpecialCoordinationEventMessage) {
            SpecialCoordinationEventMessage cordinationMessage = (SpecialCoordinationEventMessage) event;
            log.info("Event : " + cordinationMessage.getEvent().toString() + " , Message-Reciever : "
                    + cordinationMessage.getMessageReciever() + " , Callback-Reciever : "
                    + cordinationMessage.getCallbackReciever());
            switch (((SpecialCoordinationEventMessage) event).getEvent()) {
            case TERMINATED:
                mediationFlowCompleted();
                break;
            default:
                break;
            }
        } else if (event instanceof GeneralEventMessage) {
            GeneralEventMessage generalMessage = (GeneralEventMessage) event;
            log.info("Event : " + generalMessage.getEvent().toString());
            switch (((GeneralEventMessage) event).getEvent()) {
            case DEBUG_INFO_LOST:
                ESBDebuggerUtil.repopulateESBServerBreakpoints();
                break;
            default:
                break;
            }
        }
    }

    private void mediationFlowCompleted() {
        fireEvent(new MediationFlowCompleteEvent());

    }

    private void getPropertiesFromESB() throws Exception {
        debuggerInterface.sendGetPropertiesCommand(new GetPropertyCommand(GET_COMMAND_VALUE, PROPERTIES_VALUE,
                AXIS2_PROPERTY_TAG));
        debuggerInterface.sendGetPropertiesCommand(new GetPropertyCommand(GET_COMMAND_VALUE, PROPERTIES_VALUE,
                AXIS2_CLIENT_PROPERTY_TAG));
        debuggerInterface.sendGetPropertiesCommand(new GetPropertyCommand(GET_COMMAND_VALUE, PROPERTIES_VALUE,
                TRANSPORT_PROPERTY_TAG));
        debuggerInterface.sendGetPropertiesCommand(new GetPropertyCommand(GET_COMMAND_VALUE, PROPERTIES_VALUE,
                OPERATION_PROPERTY_TAG));
        debuggerInterface.sendGetPropertiesCommand(new GetPropertyCommand(GET_COMMAND_VALUE, PROPERTIES_VALUE,
                SYANPSE_PROPERTY_TAG));
    }

    private void sendDebugPointForServer(DebugPointRequest event) throws Exception {
        AbstractESBDebugPointMessage debugPoint = event.getDebugPointAttributes();
        debugPoint.setCommand(event.getType().toString());
        debuggerInterface.sendBreakpointCommand(debugPoint);
    }

}
