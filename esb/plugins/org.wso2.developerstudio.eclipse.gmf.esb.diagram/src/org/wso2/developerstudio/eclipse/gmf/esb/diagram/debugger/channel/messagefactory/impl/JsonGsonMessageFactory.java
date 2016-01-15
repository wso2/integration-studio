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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.messagefactory.impl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.BREAKPOINT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.CALLBACK_EVENT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.CALLBACK_RECIEVER_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.COMMAND_RESPONSE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEBUG_INFO_LOST_EVENT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.EVENT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.FAILED_REASON_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.MESSAGE_RECIEVER_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.RESUMED_CLIENT_EVENT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SEQUENCE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SKIP_POINT_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.STARTED_EVENT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TEMPLATE_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TERMINATED_EVENT_TYPE;

import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.messagefactory.ICommunicationMessageFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.IEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.IResponseMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.CommandMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.GetPropertyCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.DebugPointEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.GeneralEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.event.SpecialCoordinationEventMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.CommandResponseMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.response.PropertyRespondMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBMediatorPosition;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.MediatorPositionGsonSerializer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PojoToGsonCustomNamingStrategy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.EventMessageType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * This class implements the {@link ICommunicationMessageFactory} interface and
 * implement its methods using GSON JSON library
 */
public class JsonGsonMessageFactory implements ICommunicationMessageFactory {

    @Override
    public String createCommand(CommandMessage command) {
        Gson commandMessage = new Gson();
        return commandMessage.toJson(command);
    }

    @Override
    public String createGetPropertiesCommand(GetPropertyCommand command) {

        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingStrategy(new PojoToGsonCustomNamingStrategy());
        Gson propertyCommandMessage = builder.create();
        return propertyCommandMessage.toJson(command);
    }

    @Override
    public IResponseMessage convertResponseToIResponseMessage(String response) {
        JsonElement jsonElement = new JsonParser().parse(response);
        Set<Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();
        String commandResponse = null;
        String failedReason = null;
        String scope = null;
        JsonElement propertyValues = null;
        for (Entry<String, JsonElement> entry : entrySet) {
            if (COMMAND_RESPONSE_LABEL.equals(entry.getKey())) {
                commandResponse = entry.getValue().getAsString();
            } else if (FAILED_REASON_LABEL.equals(entry.getKey())) {
                failedReason = entry.getValue().getAsString();
            } else {
                scope = entry.getKey();
                propertyValues = entry.getValue();
            }
        }

        if (StringUtils.isNotEmpty(commandResponse)) {
            return new CommandResponseMessage(commandResponse, failedReason);
        } else if (!propertyValues.isJsonNull()) {
            return new PropertyRespondMessage(scope, propertyValues);
        }
        throw new IllegalArgumentException("Invalid Response message Recieved from ESB Server Debugger " + response);
    }

    @Override
    public IEventMessage convertEventToIEventMessage(String eventMessage) {

        JsonElement jsonElement = new JsonParser().parse(eventMessage);
        Set<Entry<String, JsonElement>> entrySet = jsonElement.getAsJsonObject().entrySet();

        EventMessageType event = null;
        String callbackReciever = null;
        String messageReciever = null;
        JsonElement recievedArtifactInfo = null;
        ArtifactType debugPointType = null;

        for (Entry<String, JsonElement> entry : entrySet) {

            switch (entry.getKey()) {
            case EVENT_LABEL:
                event = getEventMessageType(entry.getValue().getAsString());
                break;
            case CALLBACK_RECIEVER_LABEL:
                callbackReciever = entry.getValue().getAsString();
                break;
            case MESSAGE_RECIEVER_LABEL:
                messageReciever = entry.getValue().getAsString();
                break;
            case SEQUENCE_LABEL:
                recievedArtifactInfo = entry.getValue();
                debugPointType = ArtifactType.SEQUENCE;
                break;
            case TEMPLATE_LABEL:
                recievedArtifactInfo = entry.getValue();
                debugPointType = ArtifactType.TEMPLATE;
                break;
            }
        }

        if (event != null) {
            return getIEventMessage(eventMessage, event, callbackReciever, messageReciever, recievedArtifactInfo,
                    debugPointType);
        } else {
            throw new IllegalArgumentException(
                    "Invalid Message Recieved from ESB Server Debugger Which doesn't have an event tag : "
                            + eventMessage);
        }

    }

    /**
     * This method check the parameters and returns the desired {@link IEventMessage}
     * 
     * @param eventMessage
     * @param event
     * @param callbackReciever
     * @param messageReciever
     * @param recievedArtifactInfo
     * @param debugPointType
     * @return
     */
    private IEventMessage getIEventMessage(String eventMessage, EventMessageType event, String callbackReciever,
            String messageReciever, JsonElement recievedArtifactInfo, ArtifactType debugPointType) {

        switch (event) {
        case RESUMED_CLIENT:
            return new GeneralEventMessage(event);
        case DEBUG_INFO_LOST:
            return new GeneralEventMessage(event);
        case STARTED:
            return new SpecialCoordinationEventMessage(event, messageReciever, callbackReciever);
        case CALLBACK:
            return new SpecialCoordinationEventMessage(event, messageReciever, callbackReciever);
        case TERMINATED:
            return new SpecialCoordinationEventMessage(event, messageReciever, callbackReciever);
        case BREAKPOINT:
        case SKIPPOINT:
            return new DebugPointEventMessage(event, ESBDebuggerUtil.getESBDebugPoint(debugPointType, event,
                    recievedArtifactInfo));
        default:
            throw new IllegalArgumentException("Invalid Event Message Recieved from ESB Server Debugger : "
                    + eventMessage);
        }
    }

    private EventMessageType getEventMessageType(String event) {
        switch (event) {
        case BREAKPOINT_LABEL:
            return EventMessageType.BREAKPOINT;
        case SKIP_POINT_LABEL:
            return EventMessageType.SKIPPOINT;
        case STARTED_EVENT_TYPE:
            return EventMessageType.STARTED;
        case TERMINATED_EVENT_TYPE:
            return EventMessageType.TERMINATED;
        case CALLBACK_EVENT_TYPE:
            return EventMessageType.CALLBACK;
        case RESUMED_CLIENT_EVENT_TYPE:
            return EventMessageType.RESUMED_CLIENT;
        case DEBUG_INFO_LOST_EVENT:
            return EventMessageType.DEBUG_INFO_LOST;
        default:
            throw new IllegalArgumentException("Invalid Event Message Type : " + event);
        }

    }

    @Override
    public String createBreakpointCommand(AbstractESBDebugPointMessage debugPoint) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ESBMediatorPosition.class, new MediatorPositionGsonSerializer());
        builder.setFieldNamingStrategy(new PojoToGsonCustomNamingStrategy());
        Gson debugPointMessage = builder.create();
        return debugPointMessage.toJson(debugPoint);
    }

    @Override
    public String createPropertyChangeCommand(PropertyChangeCommand propertyChangeCommand) {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingStrategy(new PojoToGsonCustomNamingStrategy());
        Gson propertyChangeMessage = builder.create();
        return propertyChangeMessage.toJson(propertyChangeCommand);
    }

}
