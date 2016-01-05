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
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;

/**
 * This class represent the request event from {@link ESBDebugger} to {@link ESBDebugTarget} when {@link ESBDebugger}
 * notify new property variables
 * are received from ESB Server
 */
public class PropertyRecievedEvent implements IESBDebuggerInternalEvent, IDebuggerEvent {

    private final PropertyRespondMessage scopeProperties;

    public PropertyRecievedEvent(PropertyRespondMessage variables) {
        this.scopeProperties = variables;
    }

    public PropertyRespondMessage getVariables() {
        return scopeProperties;
    }
}
