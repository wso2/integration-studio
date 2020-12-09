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

import com.google.gson.JsonObject;

/**
 * This class is the wire log object class witch holds wirelogs for a mediator id
 *
 */
public class ESBWirelog {

    private JsonObject mediatorId;
    private String requestWireLog;
    private String responseWireLog;

    public JsonObject getMediatorId() {
        return mediatorId;
    }

    public void setMediatorId(JsonObject mediatorId) {
        this.mediatorId = mediatorId;
    }

    public String getRequestWireLog() {
        return requestWireLog;
    }

    public void setRequestWireLog(String requestWireLog) {
        this.requestWireLog = requestWireLog;
    }

    public String getResponseWireLog() {
        return responseWireLog;
    }

    public void setResponseWireLog(String responseWireLog) {
        this.responseWireLog = responseWireLog;
    }
}
