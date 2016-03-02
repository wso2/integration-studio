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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IDisconnect;
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.debug.core.model.ITerminate;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.DisconnectRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.ResumeRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.TerminateRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerResumeType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;

/**
 * This class is implementation of common function for debug elements
 *
 */
public abstract class ESBDebugElement extends DebugElement implements ISuspendResume, IDisconnect, ITerminate, IStep {

    public ESBDebugElement(IDebugTarget target) {
        super(target);
    }

    public enum ESBDebuggerState {
        NOT_STARTED, SUSPENDED, RESUMED, TERMINATED, STEPPING
    }

    protected ESBDebuggerState esbDebuggerState = ESBDebuggerState.NOT_STARTED;

    @Override
    public String getModelIdentifier() {
        return ESBDebugModelPresentation.ID;
    }

    protected void setState(ESBDebuggerState state) {
        getDebugTarget().esbDebuggerState = state;
    }

    protected ESBDebuggerState getState() {
        return getDebugTarget().esbDebuggerState;
    }

    @Override
    public ESBDebugTarget getDebugTarget() {
        return (ESBDebugTarget) super.getDebugTarget();
    }

    @Override
    public boolean canResume() {
        return isSuspended();
    }

    @Override
    public boolean canSuspend() {
        return false;
    }

    @Override
    public boolean isSuspended() {
        return getState() == ESBDebuggerState.SUSPENDED;
    }

    @Override
    public void resume() {
        getDebugTarget().fireModelEvent(new ResumeRequest(ESBDebuggerResumeType.CONTINUE));
        OpenEditorUtil.removeBreakpointHitStatus();
    }

    @Override
    public void suspend() throws DebugException {
        throw new DebugException(new Status(IStatus.ERROR, ESBDebuggerConstants.ESB_MEDIATION_DEBUGGER_NAME,
                "suspend() not supported"));
    }

    @Override
    public boolean canDisconnect() {
        return false;
    }

    @Override
    public void disconnect() {
        getDebugTarget().fireModelEvent(new DisconnectRequest());
    }

    @Override
    public boolean isDisconnected() {
        return isTerminated();
    }

    @Override
    public boolean canTerminate() {
        return !isTerminated();
    }

    @Override
    public boolean isTerminated() {
        return getState() == ESBDebuggerState.TERMINATED;
    }

    @Override
    public void terminate() {
        getDebugTarget().fireModelEvent(new TerminateRequest());
        OpenEditorUtil.removeBreakpointHitStatus();
    }

    @Override
    public boolean canStepInto() {
        return false;
    }

    @Override
    public boolean canStepOver() {
        return isSuspended();
    }

    @Override
    public boolean canStepReturn() {
        return false;
    }

    @Override
    public boolean isStepping() {
        return getState() == ESBDebuggerState.STEPPING;
    }

    @Override
    public void stepInto() throws DebugException {
        throw new DebugException(new Status(IStatus.ERROR, ESBDebuggerConstants.ESB_MEDIATION_DEBUGGER_NAME,
                "stepInto() not supported"));
    }

    @Override
    public void stepOver() {
        getDebugTarget().fireModelEvent(new ResumeRequest(ESBDebuggerResumeType.STEP_OVER));
    }

    @Override
    public void stepReturn() throws DebugException {
        throw new DebugException(new Status(IStatus.ERROR, ESBDebuggerConstants.ESB_MEDIATION_DEBUGGER_NAME,
                "stepReturn() not supported"));
    }

}
