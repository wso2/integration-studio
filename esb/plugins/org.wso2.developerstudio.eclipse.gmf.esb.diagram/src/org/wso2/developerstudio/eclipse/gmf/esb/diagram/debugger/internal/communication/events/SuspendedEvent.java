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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IDebuggerEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IESBDebuggerInternalEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.DebugPointEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;

/**
 * This class represent the request event from {@link ESBDebugger} to {@link ESBDebugTarget} when {@link ESBDebugger}
 * notify suspend action from
 * ESB Server
 */
public class SuspendedEvent implements IESBDebuggerInternalEvent, IDebuggerEvent {

    private AbstractESBDebugPointMessage debugPoint;

    public SuspendedEvent(DebugPointEventMessage event) {
        debugPoint = event.getDebugPoint();
    }

    public AbstractESBDebugPointMessage getDetail() {
        return debugPoint;
    }
}