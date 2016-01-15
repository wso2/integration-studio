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

/**
 * This class consists exclusively of static constant values which were used by
 * ESB Mediation Debugger implementation classes.
 *
 */
public class ESBDebuggerConstants {

    /**
     * This private constructor hides the implicit public constructor
     */
    private ESBDebuggerConstants() {
    }

    // Hash Code related constants
    public static final int INITIAL_HASH_CODE_RESULT_VALUE = 17;
    public static final int HASHCODE_MULTIPLIER_VALUE = 37;

    // Complex List Mediator Sequence Positions
    public static final Integer FILTER_PASS_CONTAINER_POSITION_VALUE = 1;
    public static final Integer FILTER_FAIL_CONTAINER_POSITION_VALUE = 0;
    public static final Integer THROTTLE_ON_ACCEPT_CONTAINER_POSITION_VALUE = 1;
    public static final Integer THROTTLE_ON_REJECT_CONTAINER_POSITION_VALUE = 0;
    public static final Integer ENTITLEMENT_ON_REJECT_CONTAINER_POSITION_VALUE = 0;
    public static final Integer ENTITLEMENT_ON_ACCEPT_CONTAINER_POSITION_VALUE = 1;
    public static final Integer ENTITLEMENT_ADVICE_CONTAINER_POSITION_VALUE = 2;
    public static final Integer ENTITLEMENT_OBLIGATIONS_CONTAINER_POSITION_VALUE = 3;
    public static final Integer SWITCH_DEFAULT_CONTAINER_POSITION_VALUE = 0;

    // Model ID's
    public static final String SUSPEND_POINT_MODEL_ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.suspend.point";
    public static final String ESB_DEBUG_MODEL_PRESENTATION_ID = "org.wso2.developerstudio.eclipse.esb.debugger.model.esbDebugModelPresentation";

    // ESB Debugger Communication Channel constants
    public static final String DEFAULT_COMMAND_PORT = "9005";
    public static final String DEFAULT_EVENT_PORT = "9006";
    public static final String DEFAULT_HOST_NAME = "localhost";
    public static final String ESB_SERVER_LOCATION = "server location path";

    // ESB Debug Point related constants
    public static final String ESB_BREAKPOINT_MARKER_ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ESBDebugPointMarker";
    public static final String MEDIATOR_POSITION_LABEL = "mediator-position";
    public static final String MAPPING_URL_TYPE_LABEL = "mapping";
    public static final String URL_TEMPLATE_LABEL = "url-template";
    public static final String URI_TEMPLATE_LABEL = "uri-template";
    public static final String URI_MAPPING_LABEL = "uri-mapping";
    public static final String URL_MAPPING_LABEL = "url-mapping";
    public static final String API_RESOURCE_METHOD_LABEL = "method";
    public static final String API_KEY_LABEL = "api-key";
    public static final String API_RESOURCE_LABEL = "resource";
    public static final String MAPPING_URL_TYPE = "mapping";
    public static final String COMMAND_LABEL = "command";
    public static final String MEDIATION_COMPONENT_LABEL = "command-argument";
    public static final String COMMAND_ARGUMENT_LABEL = "command-argument";
    public static final String SKIP_POINT_LABEL = "skip";
    public static final String BREAKPOINT_LABEL = "breakpoint";
    public static final String SEQUENCE_TYPE_LABEL = "sequence-type";
    public static final String SEQUENCE_KEY_LABEL = "sequence-key";
    public static final String NAMED_SEQUENCE_LABEL = "named";
    public static final String MAIN_SEQUENCE_NAME = "main";
    public static final String TEMPLATE_KEY_LABEL = "template-key";
    public static final String PROXY_KEY_LABEL = "proxy-key";
    public static final String INBOUND_ENDPOINT_KEY_LABEL = "inbound-key";
    public static final String TEMPLATE_SEQUENCE = "template_seq";

    public static final String MEDIATOR_DELETE_ACTION = "mediatordelete";
    public static final String MEDIATOR_INSERT_ACTION = "mediatorinsert";

    public static final String PROXY_INSEQ_LABEL = "proxy_inseq";
    public static final String PROXY_FAULTSEQ_LABEL = "proxy_faultseq";
    public static final String PROXY_OUTSEQ_LABEL = "proxy_outseq";
    public static final String INBOUND_SEQ_LABEL = "inbound_seq";
    public static final String INBOUND_FAULT_SEQ_LABEL = "inbound_faultseq";
    public static final String API_INSEQ_LABEL = "api_inseq";
    public static final String API_FAULTSEQ_LABEL = "api_faultseq";
    public static final String API_OUTSEQ_LABEL = "api_outseq";

    public static final String MAIN_SEQUENCE_LABEL = "main_sequence";
    public static final String MAIN_SEQUENCE_RELATIVE_LOCATION = "sequences/main.xml";
    public static final String TEMPLATE_LABEL = "template";
    public static final String SEQUENCE_LABEL = "sequence";
    public static final String PROXY_LABEL = "proxy";
    public static final String INBOUND_ENDPOINT_LABEL = "inbound";
    public static final String API_LABEL = "api";
    public static final String EVENT_LABEL = "event";

    // Event Message Type constants
    public static final String BREAKPOINT_EVENT_TYPE = "breakpoint";
    public static final String STARTED_EVENT_TYPE = "started";
    public static final String CALLBACK_EVENT_TYPE = "callback";
    public static final String RESUMED_CLIENT_EVENT_TYPE = "resumed client";
    public static final String TERMINATED_EVENT_TYPE = "terminated";
    public static final String DEBUG_INFO_LOST_EVENT = "synapse configuration updated-debug information lost";
    public static final String MESSAGE_RECIEVER_LABEL = "message-receiver";
    public static final String CALLBACK_RECIEVER_LABEL = "callback-receiver";

    // Command Types
    public static final String SET_COMMAND = "set";
    public static final String CLEAR_COMMAND = "clear";
    public static final String GET_COMMAND_VALUE = "get";
    public static final String RESUME_COMMAND_VALUE = "resume";
    public static final String PROPERTIES_VALUE = "properties";
    public static final String PROPERTY_VALUE = "property";

    // ESB Mediation Debugger Message models related constants
    public static final String COMMAND_RESPONSE_LABEL = "command-response";
    public static final String FAILED_REASON_LABEL = "failed-reason";

    // API Resource Methods
    public static final String API_METHOD_POST = "POST";
    public static final String API_METHOD_GET = "GET";
    public static final String API_METHOD_PUT = "PUT";
    public static final String API_METHOD_DELETE = "DELETE";
    public static final String API_METHOD_OPTIONS = "OPTIONS";
    public static final String API_METHOD_HEAD = "HEAD";
    public static final String API_METHOD_PATCH = "PATCH";

    // Internal event broker constants
    public static final String ESB_DEBUGGER_EVENT_BROKER_DATA_NAME = "org.eclipse.e4.data";
    public static final String ESB_DEBUG_TARGET_EVENT_TOPIC = "ESBDebugTarget_Events";
    public static final String ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT = "ESBStackFrame_Events";
    public static final String ESBDEBUGGER_EVENT_TOPIC = "ESBDebugger_Events";
    public static final String PROPERTY_CHANGE_COMMAND_HANDLER_EVENT_TOPIC = "PropertyChangeCommandHandler_Events";

    // Message Property scopes
    public static final String AXIS2_PROPERTY_TAG = "axis2";
    public static final String OPERATION_PROPERTY_TAG = "operation";
    public static final String AXIS2_CLIENT_PROPERTY_TAG = "axis2-client";
    public static final String TRANSPORT_PROPERTY_TAG = "transport";
    public static final String SYANPSE_PROPERTY_TAG = "synapse";

    // Message Property attribute key values
    public static final String AXIS2_PROPERTIES_KEY = "axis2-properties";
    public static final String SYNAPSE_PROPERTIES_KEY = "synapse-properties";
    public static final String OPERATION_PROPERTIES_KEY = "axis2Operation-properties";
    public static final String AXIS2_CLIENT_PROPERTIES_KEY = "axis2Client-properties";
    public static final String TRANSPORT_PROPERTIES_KEY = "axis2Transport-properties";

    public static final String AXIS2_CLIENT_PROPERTIES_TAG = "Axis2-Client Scope Properties";
    public static final String AXIS2_PROPERTIES_TAG = "Axis2 Scope Properties";
    public static final String OPERATION_PROPERTIES_TAG = "Operation Scope Properties";
    public static final String SYNAPSE_PROPERTIES_TAG = "Synapse Scope Properties";
    public static final String TRANSPORT_PROPERTIES_TAG = "Transport Scope Properties";

    // Message Property scopes UI Value
    public static final String AXIS2_PROPERTY_UI_NAME = "Axis2 Scope Properties";
    public static final String OPERATION_PROPERTY_UI_NAME = "Operation Scope Properties";
    public static final String AXIS2_CLIENT_PROPERTY_UI_NAME = "Axis2-Client Scope Properties";
    public static final String TRANSPORT_PROPERTY_UI_NAME = "Transport Scope Properties";
    public static final String SYANPSE_PROPERTY_UI_NAME = "Synapse Scope Properties";

    // ESB Debugger Model Constants
    public static final String ESB_MEDIATION_DEBUGGER_NAME = "ESB Mediation Debugger";
    public static final String VARIABLE_TYPE = "ESB Message";

    // ESB Breakpoint/Skip point related constants
    public static final String ESB_BREAKPOINT_COMMAND_LABEL = "Toggle Breakpoint";
    public static final String ESB_BREAKPOINT_REPOPULATE_COMMAND_LABEL = "Resend ESB Breakpoints";
    public static final String ESB_BREAKPOINT_COMMAND_TOOL_TIP = "Set breakpoint for this mediator";
    public static final String ESB_BREAKPOINT_REPOPULATE_COMMAND_TOOL_TIP = "Resend all ESB Breakpoints to connected ESB Server";
    public static final String ESB_BREAKPOINT_DELETE_ALL_COMMAND_TOOL_TIP = "Delete All ESB Breakpoints from workspace";
    public static final String ESB_BREAKPOINT_DELETE_ALL_COMMAND_LABEL = "Delete All ESB Breakpoints";
    public static final String ESB_BREAKPOINT_ACTION_ID = "org.wos2.developerstudio.eclipse.esb.debugger.breakpoint.action";
    public static final String ESB_BREAKPOINT_DELETE_ALL_ACTION_ID = "org.wos2.developerstudio.eclipse.esb.debugger.breakpoint.delete.all.action";
    public static final String ESB_BREAKPOINT_REPOPULATE_ACTION_ID = "org.wos2.developerstudio.eclipse.esb.debugger.breakpoint.repopulate.action";
    public static final String ESB_SKIPPOINT_COMMAND_LABEL = "Toggle Skip Point";
    public static final String ESB_SKIPPOINT_ACTION_ID = "org.wos2.developerstudio.eclipse.esb.debugger.skippoint.action";
    public static final String ESB_SKIPPOINT_COMMAND_TOOL_TIP = "Set skip point for this mediator";

    // Property Value Change command ID's
    public static final String ESB_MESSAGE_MEDIATION_PROPERTY_INJECT_COMMAND_ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.commands.InjectNewProperty";
    public static final String ESB_MESSAGE_MEDIATION_PROPERTY_CLEAR_COMMAND_ID = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.commands.ClearProperty";

    public static final String MEDIATOR_IN_A_UNKNOWN_POSITION_LOG_MESSAGE = "Selected Metdiator Edit Part is in a unknown position : ";
}
