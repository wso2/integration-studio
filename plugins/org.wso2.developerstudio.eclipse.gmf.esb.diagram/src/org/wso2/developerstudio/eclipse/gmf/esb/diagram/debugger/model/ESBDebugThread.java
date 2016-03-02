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

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IThread;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class is the sequential flow of execution in a {@link ESBDebugTarget}.
 * This contains stack frames. Stack frames are only available when the thread
 * is suspended, and are returned in top-down order. Minimally, a thread
 * supports the following: suspend/resume stepping terminate
 */
public class ESBDebugThread extends ESBDebugElement implements IThread {

    private final List<ESBStackFrame> stackFrames = new ArrayList<>();

    public ESBDebugThread(final ESBDebugTarget debugTarget) {
        super(debugTarget);
    }

    public void addStackFrame(ESBStackFrame stackFrame) {
        stackFrames.add(0, stackFrame);
    }

    @Override
    public ESBStackFrame[] getStackFrames() {
        return stackFrames.toArray(new ESBStackFrame[stackFrames.size()]);
    }

    @Override
    public boolean hasStackFrames() {
        return getStackFrames().length > 0;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public ESBStackFrame getTopStackFrame() {
        if (!stackFrames.isEmpty())
            return stackFrames.get(0);

        return null;
    }

    @Override
    public String getName() {
        return Messages.ESBDebugThread_ESBDebugThreadTag;
    }

    @Override
    public IBreakpoint[] getBreakpoints() {
        return DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(getModelIdentifier());
    }
}
