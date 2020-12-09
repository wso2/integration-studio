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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests;

import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IDebugTargetRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IESBDebuggerInternalEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.DebugPointEventAction;

/**
 * This class represent the request event from {@link ESBDebugTarget} to {@link ESBDebugger} when a
 * {@link ESBDebugPoint} adding or removing operation
 * occurred by user
 *
 */
public class DebugPointRequest implements IDebugTargetRequest, IESBDebuggerInternalEvent {

    private final DebugPointEventAction type;
    private final int lineNumber;
    private AbstractESBDebugPointMessage debugPoint;

    public DebugPointRequest(ESBDebugPoint debugPoint, DebugPointEventAction action)
            throws DebugPointMarkerNotFoundException, CoreException {
        type = action;
        lineNumber = debugPoint.getLineNumber();
        this.debugPoint = debugPoint.getLocation();
    }

    public DebugPointEventAction getType() {
        return type;
    }

    public int getLine() {
        return lineNumber;
    }

    public AbstractESBDebugPointMessage getDebugPointAttributes() {
        return debugPoint;
    }

    @Override
    public String toString() {
        return "BreakpointEvent: " + ((getType() == DebugPointEventAction.ADDED) ? "ADDED" : "REMOVED") + ", line : "
                + getLine() + " , attributes : " + getDebugPointAttributes();
    }

    public AbstractESBDebugPointMessage getDebugPoint() {
        return debugPoint;
    }
}
