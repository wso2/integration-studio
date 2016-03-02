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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

/**
 * This Enum contains command values ESB Server Mediation Debugger sends to ESB
 * Mediation Debugger Tool via JSON Channel
 */
public enum ESBDebuggerCommands {
    /*
     * This command represent register debug point command
     */
    SET_BREAKPOINT_SKIPPOINT(SET_COMMAND),
    /*
     * This command represent unregister debug point command
     */
    CLEAR_BREAKPOINT_SKIPPOINT(CLEAR_COMMAND),
    /*
     * This command represent get values from ESb Server Mediation Debugger
     */
    GET_COMMAND(GET_COMMAND_VALUE),
    /*
     * This command represent resume ESB Server Mediation Debugger
     */
    RESUME_COMMAND(RESUME_COMMAND_VALUE);

    private final String command;

    private ESBDebuggerCommands(String commandValue) {
        command = commandValue;
    }

    public boolean equalsName(String comapreCommand) {
        return (comapreCommand == null) ? false : command.equals(comapreCommand);
    }

    @Override
    public String toString() {
        return this.command;
    }
}