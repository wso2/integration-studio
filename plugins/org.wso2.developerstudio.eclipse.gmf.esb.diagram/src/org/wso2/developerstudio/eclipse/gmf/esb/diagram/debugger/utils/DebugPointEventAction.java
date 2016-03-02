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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.CLEAR_COMMAND;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SET_COMMAND;

/**
 * This Enum represents the actions which can be made with ESB Mediation
 * Debugger Debug points
 *
 */
public enum DebugPointEventAction {
    ADDED(SET_COMMAND), REMOVED(CLEAR_COMMAND);

    private final String action;

    private DebugPointEventAction(String actionValue) {
        action = actionValue;
    }

    public boolean equalsName(String comapreAction) {
        return (comapreAction == null) ? false : action.equals(comapreAction);
    }

    @Override
    public String toString() {
        return this.action;
    }
}
