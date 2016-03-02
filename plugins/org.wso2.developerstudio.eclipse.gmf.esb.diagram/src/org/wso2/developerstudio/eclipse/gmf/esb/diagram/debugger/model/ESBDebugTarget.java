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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESBDEBUGGER_EVENT_TOPIC;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_DEBUGGER_EVENT_BROKER_DATA_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_DEBUG_TARGET_EVENT_TOPIC;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SUSPEND_POINT_MODEL_ID;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.ESBDebuggerException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IESBDebuggerInternalEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.DebuggerStartedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.MediationFlowCompleteEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.PropertyRecievedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.ResumedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.SuspendedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.TerminatedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.DebugPointRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.FetchVariablesRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.suspendpoint.ESBSuspendPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.DebugPointEventAction;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerResumeType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This is the root of the ESB Mediation Debugger debug element hierarchy. It
 * supports terminate, suspend , resume, breakpoint, skip points
 *
 */
public class ESBDebugTarget extends ESBDebugElement implements IDebugTarget, EventHandler {

    private IEventBroker debugTargetEventBroker;
    private final ESBDebugProcess esbDebugProcess;
    private final List<ESBDebugThread> esbDebugThreads = new ArrayList<ESBDebugThread>();
    private final ILaunch esbDebugerLaunch;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public ESBDebugTarget(final ILaunch launch) {
        super(null);
        debugTargetEventBroker = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
        debugTargetEventBroker.subscribe(ESBDEBUGGER_EVENT_TOPIC, this);
        esbDebugerLaunch = launch;
        fireCreationEvent();
        esbDebugProcess = new ESBDebugProcess(this);
        esbDebugProcess.fireCreationEvent();
    }

    @Override
    public void handleEvent(Event eventFromBroker) {
        if (!isDisconnected()) {
            Object eventObject = eventFromBroker.getProperty(ESB_DEBUGGER_EVENT_BROKER_DATA_NAME);
            if (eventObject instanceof IESBDebuggerInternalEvent) {
                IESBDebuggerInternalEvent event = (IESBDebuggerInternalEvent) eventObject;
                if (event instanceof DebuggerStartedEvent) {
                    ESBDebugThread thread = new ESBDebugThread(this);
                    esbDebugThreads.add(thread);
                    thread.fireCreationEvent();

                    ESBStackFrame stackFrame = new ESBStackFrame(this, thread);
                    thread.addStackFrame(stackFrame);
                    stackFrame.fireCreationEvent();

                    DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

                    resume();

                } else if (event instanceof SuspendedEvent) {
                    // this get called when ESB came to a breakpoint
                    setState(ESBDebuggerState.SUSPENDED);
                    fireSuspendEvent(0);
                    getThreads()[0].fireSuspendEvent(DebugEvent.BREAKPOINT);
                    try {
                        showDiagram((SuspendedEvent) event);
                    } catch (ESBDebuggerException | CoreException e) {
                        log.error("Error while trying to show diagram : " //$NON-NLS-1$
                                + e.getMessage(), e);
                    }
                    fireModelEvent(new FetchVariablesRequest());

                } else if (event instanceof ResumedEvent) {
                    if (((ResumedEvent) event).getType() == ESBDebuggerResumeType.CONTINUE) {
                        setState(ESBDebuggerState.RESUMED);
                        getThreads()[0].fireResumeEvent(DebugEvent.UNSPECIFIED);
                    }

                } else if (event instanceof PropertyRecievedEvent) {

                    try {
                        ESBStackFrame stackFrame = getThreads()[0].getTopStackFrame();
                        PropertyRespondMessage propertyMessage = ((PropertyRecievedEvent) event).getVariables();
                        stackFrame.setVariables(propertyMessage);
                    } catch (Exception e) {
                        log.error("Error while seting variable values", e); //$NON-NLS-1$
                    }

                } else if (event instanceof TerminatedEvent) {
                    setState(ESBDebuggerState.TERMINATED);

                    DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
                    debugTargetEventBroker.unsubscribe(this);
                    this.fireTerminateEvent();
                } else if (event instanceof MediationFlowCompleteEvent) {
                    setState(ESBDebuggerState.RESUMED);
                    OpenEditorUtil.removeBreakpointHitStatus();
                    try {
                        deletePreviousSuspendPointsFromBreakpointManager();
                    } catch (CoreException e) {
                        log.error("Error while deleting previous suspend point : " //$NON-NLS-1$
                                + e.getMessage(), e);
                    }
                }
            } else {
                log.warn("Unhandled event type detected for Event Broker Topic : " + ESBDEBUGGER_EVENT_TOPIC);
            }
        }
    }

    /**
     * Pass an event to the {@link InternalEventDispatcher} where it is handled
     * asynchronously.
     * 
     * @param event
     *            event to handle
     */
    void fireModelEvent(final IESBDebuggerInternalEvent event) {
        debugTargetEventBroker.send(ESB_DEBUG_TARGET_EVENT_TOPIC, event);
    }

    /**
     * This method finds the breakpoint registered in Breakpoint Manager which
     * suspended the ESB Server and call a method to open the source file and
     * show the associated mediator
     * 
     * @param event
     * @throws ESBDebuggerException
     * @throws CoreException
     */
    private void showDiagram(SuspendedEvent event) throws ESBDebuggerException, CoreException {

        AbstractESBDebugPointMessage info = event.getDetail();
        ESBDebugPoint breakpoint = getMatchingBreakpoint(info);
        IFile file = (IFile) breakpoint.getResource();
        deletePreviousSuspendPointsFromBreakpointManager();
        ESBSuspendPoint suspendPoint = new ESBSuspendPoint(file, breakpoint.getLineNumber(), breakpoint);
        DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(suspendPoint);
        if (file.exists()) {
            OpenEditorUtil.openSeparateEditor(file, breakpoint);
        }
    }

    /**
     * @throws CoreException
     */
    private void deletePreviousSuspendPointsFromBreakpointManager() throws CoreException {
        IBreakpoint[] suspendPoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(SUSPEND_POINT_MODEL_ID);
        for (IBreakpoint suspendPoint : suspendPoints) {
            DebugPlugin.getDefault().getBreakpointManager().removeBreakpoint(suspendPoint, false);
        }
    }

    private ESBDebugPoint getMatchingBreakpoint(AbstractESBDebugPointMessage info) throws ESBDebuggerException {

        IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                .getBreakpoints(getModelIdentifier());
        for (IBreakpoint breakpoint : breakpoints) {
            try {
                if (((ESBDebugPoint) breakpoint).isMatchedWithDebugPoint(info, true)) {
                    return (ESBDebugPoint) breakpoint;
                }
            } catch (CoreException | DebugPointMarkerNotFoundException e) {
                log.warn("Error while finding matching breakpoint " //$NON-NLS-1$
                        + e.getMessage(), e);
            }
        }

        throw new ESBDebuggerException("Matching Breakpoint not found in Breakpoint Manager with attributes"); //$NON-NLS-1$
    }

    @Override
    public ILaunch getLaunch() {
        return esbDebugerLaunch;
    }

    @Override
    public IProcess getProcess() {
        return esbDebugProcess;
    }

    @Override
    public ESBDebugThread[] getThreads() {
        return esbDebugThreads.toArray(new ESBDebugThread[esbDebugThreads.size()]);
    }

    @Override
    public boolean hasThreads() {
        return !esbDebugThreads.isEmpty();
    }

    @Override
    public String getName() {
        return Messages.ESBDebugTarget_ESBDebugTargetNameTag;
    }

    @Override
    public boolean supportsBreakpoint(final IBreakpoint breakpoint) {
        if (breakpoint instanceof ESBDebugPoint) {
            return true;
        }
        return false;
    }

    @Override
    public ESBDebugTarget getDebugTarget() {
        return this;
    }

    private boolean isEnabledBreakpoint(IBreakpoint breakpoint) throws CoreException {
        return breakpoint.isEnabled() && (DebugPlugin.getDefault().getBreakpointManager().isEnabled());
    }

    /**
     * This method get called when Breakpoint Manager got any new breakpoint
     * Registered.
     */
    @Override
    public void breakpointAdded(final IBreakpoint breakpoint) {
        try {
            if (breakpoint instanceof ESBDebugPoint && supportsBreakpoint(breakpoint)
                    && isEnabledBreakpoint(breakpoint)) {

                fireModelEvent(new DebugPointRequest((ESBDebugPoint) breakpoint, DebugPointEventAction.ADDED));
            }
        } catch (DebugPointMarkerNotFoundException e) {
            log.error("Error while creating DebugPointRequest in debug point adding event : " //$NON-NLS-1$
                    + e.getMessage(), e);
            ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(breakpoint);
        } catch (CoreException e) {
            log.error("Error while creating DebugPointRequest in debug point adding event  : " //$NON-NLS-1$
                    + e.getMessage(), e);
        }

    }

    /**
     * This method get called when any breakpoint is removed from the Breakpoint
     * Manager.
     */
    @Override
    public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
        try {
            if (breakpoint instanceof ESBDebugPoint && supportsBreakpoint(breakpoint)
                    && isEnabledBreakpoint(breakpoint)) {

                fireModelEvent(new DebugPointRequest((ESBDebugPoint) breakpoint, DebugPointEventAction.REMOVED));
            }
        } catch (DebugPointMarkerNotFoundException e) {
            log.error("Error while creating DebugPointRequest in debug point removing event : " //$NON-NLS-1$
                    + e.getMessage(), e);
            ESBDebuggerUtil.removeESBDebugPointFromBreakpointManager(breakpoint);
        } catch (CoreException e) {
            log.error("Error while creating DebugPointRequest in debug point removing event : " //$NON-NLS-1$
                    + e.getMessage(), e);
        }
    }

    @Override
    public void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
        breakpointRemoved(breakpoint, delta);
        breakpointAdded(breakpoint);
    }

    @Override
    public boolean supportsStorageRetrieval() {
        // no implementation
        return false;
    }

    @Override
    public IMemoryBlock getMemoryBlock(long startAddress, long length) {
        // no implementation
        return null;
    }

}
