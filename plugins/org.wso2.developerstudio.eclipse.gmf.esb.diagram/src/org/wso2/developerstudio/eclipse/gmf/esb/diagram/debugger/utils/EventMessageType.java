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
 * This enum represents the event message types which are received for ESB
 * Mediation Debugger Tool form ESB Server.
 *
 */
public enum EventMessageType {
    /*
     * This event type represent a breakpoint event
     */
    BREAKPOINT(BREAKPOINT_EVENT_TYPE),
    /*
     * This event type represent a skip point event
     */
    SKIPPOINT(SKIP_POINT_LABEL),
    /*
     * This event type represent a message mediation started
     */
    STARTED(STARTED_EVENT_TYPE),
    /*
     * This event type represent a call back event
     */
    CALLBACK(CALLBACK_EVENT_TYPE),
    /*
     * This event type represent a message mediation terminated
     */
    TERMINATED(TERMINATED_EVENT_TYPE),
    /*
     * This event type represent a client resumed event
     */
    RESUMED_CLIENT(RESUMED_CLIENT_EVENT_TYPE),
    /*
     * This event type represent a debug points and other debugger related info
     * lost event
     */
    DEBUG_INFO_LOST(DEBUG_INFO_LOST_EVENT);

    private final String event;

    private EventMessageType(String eventValue) {
        event = eventValue;
    }

    public boolean equalsName(String comapreEvent) {
        return (comapreEvent == null) ? false : event.equals(comapreEvent);
    }

    @Override
    public String toString() {
        return this.event;
    }
}
