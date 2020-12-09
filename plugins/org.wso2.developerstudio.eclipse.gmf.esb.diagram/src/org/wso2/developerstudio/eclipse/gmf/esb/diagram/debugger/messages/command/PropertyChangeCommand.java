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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.PROPERTY_VALUE;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PropertyValueBean;

/**
 * This class represents the message sent to ESB Server Debugger setting values
 * of a certain property
 *
 */
public class PropertyChangeCommand {

    private String command;
    private String commandArgument;
    private String context;
    private PropertyValueBean property;

    public PropertyChangeCommand(String command, String commandArgument, String context, PropertyValueBean property) {
        this.command = command;
        this.commandArgument = commandArgument;
        this.context = context;
        this.property = property;
    }

    public PropertyChangeCommand(String command, String context, PropertyValueBean property) {
        this.command = command;
        this.commandArgument = PROPERTY_VALUE;
        this.context = context;
        this.property = property;
    }

    public PropertyValueBean getProperty() {
        return property;
    }

    public void setProperty(PropertyValueBean property) {
        this.property = property;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandArgument() {
        return commandArgument;
    }

    public void setCommandArgument(String commandArgument) {
        this.commandArgument = commandArgument;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
