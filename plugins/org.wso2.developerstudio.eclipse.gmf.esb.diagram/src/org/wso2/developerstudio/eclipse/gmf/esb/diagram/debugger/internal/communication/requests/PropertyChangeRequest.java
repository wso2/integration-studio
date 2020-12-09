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

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.impl.ESBDebugger;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IDebugTargetRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.IESBDebuggerInternalEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugTarget;

/**
 * This class represent the request event from {@link ESBDebugTarget} to {@link ESBDebugger} when property variables
 * need to be modified
 *
 */
public class PropertyChangeRequest implements IDebugTargetRequest, IESBDebuggerInternalEvent {

    private PropertyChangeCommand propertyCommand;

    public PropertyChangeRequest(PropertyChangeCommand propertyCommand) {
        this.propertyCommand = propertyCommand;
    }

    public PropertyChangeCommand getPropertyCommand() {
        return propertyCommand;
    }

    public void setPropertyCommand(PropertyChangeCommand propertyCommand) {
        this.propertyCommand = propertyCommand;
    }

    @Override
    public String toString() {
        return "Property Change Request to " + propertyCommand.getCommand() + " property for key "
                + propertyCommand.getProperty().getPropertyName() + " : "
                + propertyCommand.getProperty().getProprtyValue();
    }
}
