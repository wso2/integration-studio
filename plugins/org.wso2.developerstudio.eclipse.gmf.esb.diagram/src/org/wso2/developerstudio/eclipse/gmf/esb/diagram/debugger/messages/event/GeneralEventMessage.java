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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.IEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

/**
 * This class is the most simple event message model and other event message
 * models can extend this class. It only holds EventMessageType.
 * <p>
 * Following events are represented from this class:
 * <li>
 * <code>EventMessageType.RESUMED_CLIENT</code></li>
 * <li>
 * <code>EventMessageType.DEBUG_INFO_LOST</code></li>
 *
 * @see EventMessageType
 */
public class GeneralEventMessage implements IEventMessage {

    private EventMessageType event;

    public GeneralEventMessage(EventMessageType event) {
        this.event = event;
    }

    public EventMessageType getEvent() {
        return event;
    }

    public void setEvent(EventMessageType event) {
        this.event = event;
    }

}
