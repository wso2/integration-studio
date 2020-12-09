/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Property Name</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getPropertyName()
 * @model
 * @generated
 */
public enum PropertyName implements Enumerator {
    /**
     * The '<em><b>New Property Name</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NEW_PROPERTY_NAME_VALUE
     * @generated
     * @ordered
     */
    NEW_PROPERTY_NAME(0, "newPropertyName", "New Property..."),
    /**
     * The '<em><b>Action</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ACTION_VALUE
     * @generated
     * @ordered
     */
    ACTION(1, "Action", "Action"),
    /**
     * The '<em><b>COPY CONTENT LENGTH FROM INCOMING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COPY_CONTENT_LENGTH_FROM_INCOMING_VALUE
     * @generated
     * @ordered
     */
    COPY_CONTENT_LENGTH_FROM_INCOMING(2, "COPY_CONTENT_LENGTH_FROM_INCOMING", "COPY_CONTENT_LENGTH_FROM_INCOMING"),
    /**
     * The '<em><b>Cache Level</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CACHE_LEVEL_VALUE
     * @generated
     * @ordered
     */
    CACHE_LEVEL(3, "CacheLevel", "CacheLevel"),
    /**
     * The '<em><b>Client Api Non Blocking</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLIENT_API_NON_BLOCKING_VALUE
     * @generated
     * @ordered
     */
    CLIENT_API_NON_BLOCKING(4, "ClientApiNonBlocking", "ClientApiNonBlocking"),
    /**
     * The '<em><b>Concurrent Consumers</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONCURRENT_CONSUMERS_VALUE
     * @generated
     * @ordered
     */
    CONCURRENT_CONSUMERS(5, "ConcurrentConsumers", "ConcurrentConsumers"),
    /**
     * The '<em><b>Content Type</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONTENT_TYPE_VALUE
     * @generated
     * @ordered
     */
    CONTENT_TYPE(6, "ContentType", "ContentType"),
    /**
     * The '<em><b>Disable Addressing For Out Messages</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DISABLE_ADDRESSING_FOR_OUT_MESSAGES_VALUE
     * @generated
     * @ordered
     */
    DISABLE_ADDRESSING_FOR_OUT_MESSAGES(7, "disableAddressingForOutMessages", "disableAddressingForOutMessages"),
    /**
     * The '<em><b>DISABLE CHUNKING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DISABLE_CHUNKING_VALUE
     * @generated
     * @ordered
     */
    DISABLE_CHUNKING(8, "DISABLE_CHUNKING", "DISABLE_CHUNKING"),
    /**
     * The '<em><b>DISABLE SMOOKS RESULT PAYLOAD</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DISABLE_SMOOKS_RESULT_PAYLOAD_VALUE
     * @generated
     * @ordered
     */
    DISABLE_SMOOKS_RESULT_PAYLOAD(9, "DISABLE_SMOOKS_RESULT_PAYLOAD", "DISABLE_SMOOKS_RESULT_PAYLOAD"),
    /**
     * The '<em><b>ERROR CODE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ERROR_CODE_VALUE
     * @generated
     * @ordered
     */
    ERROR_CODE(10, "ERROR_CODE", "ERROR_CODE"),
    /**
     * The '<em><b>ERROR DETAIL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ERROR_DETAIL_VALUE
     * @generated
     * @ordered
     */
    ERROR_DETAIL(11, "ERROR_DETAIL", "ERROR_DETAIL"),
    /**
     * The '<em><b>ERROR EXCEPTION</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ERROR_EXCEPTION_VALUE
     * @generated
     * @ordered
     */
    ERROR_EXCEPTION(12, "ERROR_EXCEPTION", "ERROR_EXCEPTION"),
    /**
     * The '<em><b>ERROR MESSAGE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ERROR_MESSAGE_VALUE
     * @generated
     * @ordered
     */
    ERROR_MESSAGE(13, "ERROR_MESSAGE", "ERROR_MESSAGE"),
    /**
     * The '<em><b>FAULTS AS HTTP 200</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FAULTS_AS_HTTP_200_VALUE
     * @generated
     * @ordered
     */
    FAULTS_AS_HTTP_200(14, "FAULTS_AS_HTTP_200", "FAULTS_AS_HTTP_200"),
    /**
     * The '<em><b>FORCE ERROR ON SOAP FAULT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FORCE_ERROR_ON_SOAP_FAULT_VALUE
     * @generated
     * @ordered
     */
    FORCE_ERROR_ON_SOAP_FAULT(15, "FORCE_ERROR_ON_SOAP_FAULT", "FORCE_ERROR_ON_SOAP_FAULT"),
    /**
     * The '<em><b>FORCE HTTP 10</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #FORCE_HTTP_10_VALUE
     * @generated NOT
     * @ordered
     */
    FORCE_HTTP_10(23, "FORCE_HTTP_1.0", "FORCE_HTTP_1.0"),
    /**
     * The '<em><b>FORCE HTTP CONTENT LENGTH</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FORCE_HTTP_CONTENT_LENGTH_VALUE
     * @generated
     * @ordered
     */
    FORCE_HTTP_CONTENT_LENGTH(17, "FORCE_HTTP_CONTENT_LENGTH", "FORCE_HTTP_CONTENT_LENGTH"),
    /**
     * The '<em><b>FORCE POST PUT NOBODY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FORCE_POST_PUT_NOBODY_VALUE
     * @generated
     * @ordered
     */
    FORCE_POST_PUT_NOBODY(18, "FORCE_POST_PUT_NOBODY", "FORCE_POST_PUT_NOBODY"),
    /**
     * The '<em><b>FORCE SC ACCEPTED</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FORCE_SC_ACCEPTED_VALUE
     * @generated
     * @ordered
     */
    FORCE_SC_ACCEPTED(19, "FORCE_SC_ACCEPTED", "FORCE_SC_ACCEPTED"),
    /**
     * The '<em><b>Fault To</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FAULT_TO_VALUE
     * @generated
     * @ordered
     */
    FAULT_TO(20, "FaultTo", "FaultTo"),
    /**
     * The '<em><b>From</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FROM_VALUE
     * @generated
     * @ordered
     */
    FROM(21, "From", "From"),
    /**
     * The '<em><b>HTTP ETAG</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HTTP_ETAG_VALUE
     * @generated
     * @ordered
     */
    HTTP_ETAG(22, "HTTP_ETAG", "HTTP_ETAG"),
    /**
     * The '<em><b>HTTP SC</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HTTP_SC_VALUE
     * @generated
     * @ordered
     */
    HTTP_SC(23, "HTTP_SC", "HTTP_SC"),
    /**
     * The '<em><b>JMS COORELATION ID</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JMS_COORELATION_ID_VALUE
     * @generated
     * @ordered
     */
    JMS_COORELATION_ID(24, "JMS_COORELATION_ID", "JMS_COORELATION_ID"),
    /**
     * The '<em><b>Message Type</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MESSAGE_TYPE_VALUE
     * @generated
     * @ordered
     */
    MESSAGE_TYPE(25, "messageType", "messageType"),
    /**
     * The '<em><b>MESSAGE FORMAT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MESSAGE_FORMAT_VALUE
     * @generated
     * @ordered
     */
    MESSAGE_FORMAT(26, "MESSAGE_FORMAT", "MESSAGE_FORMAT"),
    /**
     * The '<em><b>Max Concurrent Consumers</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MAX_CONCURRENT_CONSUMERS_VALUE
     * @generated
     * @ordered
     */
    MAX_CONCURRENT_CONSUMERS(27, "MaxConcurrentConsumers", "MaxConcurrentConsumers"),
    /**
     * The '<em><b>Mercury Last Message</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MERCURY_LAST_MESSAGE_VALUE
     * @generated
     * @ordered
     */
    MERCURY_LAST_MESSAGE(28, "MercuryLastMessage", "MercuryLastMessage"),
    /**
     * The '<em><b>Mercury Sequence Key</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MERCURY_SEQUENCE_KEY_VALUE
     * @generated
     * @ordered
     */
    MERCURY_SEQUENCE_KEY(29, "MercurySequenceKey", "MercurySequenceKey"),
    /**
     * The '<em><b>Message ID</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MESSAGE_ID_VALUE
     * @generated
     * @ordered
     */
    MESSAGE_ID(30, "MessageID", "MessageID"),
    /**
     * The '<em><b>NO ENTITY BODY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NO_ENTITY_BODY_VALUE
     * @generated
     * @ordered
     */
    NO_ENTITY_BODY(31, "NO_ENTITY_BODY", "NO_ENTITY_BODY"),
    /**
     * The '<em><b>NO KEEPALIVE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NO_KEEPALIVE_VALUE
     * @generated
     * @ordered
     */
    NO_KEEPALIVE(32, "NO_KEEPALIVE", "NO_KEEPALIVE"),
    /**
     * The '<em><b>OUT ONLY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OUT_ONLY_VALUE
     * @generated
     * @ordered
     */
    OUT_ONLY(33, "OUT_ONLY", "OUT_ONLY"),
    /**
     * The '<em><b>Operation Name</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OPERATION_NAME_VALUE
     * @generated
     * @ordered
     */
    OPERATION_NAME(34, "OperationName", "OperationName"),
    /**
     * The '<em><b>POST TO URI</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #POST_TO_URI_VALUE
     * @generated
     * @ordered
     */
    POST_TO_URI(35, "POST_TO_URI", "POST_TO_URI"),
    /**
     * The '<em><b>Preserve Processed Headers</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PRESERVE_PROCESSED_HEADERS_VALUE
     * @generated
     * @ordered
     */
    PRESERVE_PROCESSED_HEADERS(36, "preserveProcessedHeaders", "preserveProcessedHeaders"),
    /**
     * The '<em><b>PRESERVE WS ADDRESSING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PRESERVE_WS_ADDRESSING_VALUE
     * @generated
     * @ordered
     */
    PRESERVE_WS_ADDRESSING(37, "PRESERVE_WS_ADDRESSING", "PRESERVE_WS_ADDRESSING"),
    /**
     * The '<em><b>REQUEST HOST HEADER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REQUEST_HOST_HEADER_VALUE
     * @generated
     * @ordered
     */
    REQUEST_HOST_HEADER(38, "REQUEST_HOST_HEADER", "REQUEST_HOST_HEADER"),
    /**
     * The '<em><b>RESPONSE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RESPONSE_VALUE
     * @generated
     * @ordered
     */
    RESPONSE(39, "RESPONSE", "RESPONSE"),
    /**
     * The '<em><b>REST URL POSTFIX</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REST_URL_POSTFIX_VALUE
     * @generated
     * @ordered
     */
    REST_URL_POSTFIX(40, "REST_URL_POSTFIX", "REST_URL_POSTFIX"),
    /**
     * The '<em><b>Relates To</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RELATES_TO_VALUE
     * @generated
     * @ordered
     */
    RELATES_TO(41, "RelatesTo", "RelatesTo"),
    /**
     * The '<em><b>Reply To</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REPLY_TO_VALUE
     * @generated
     * @ordered
     */
    REPLY_TO(42, "ReplyTo", "ReplyTo"),
    /**
     * The '<em><b>SERVER IP</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SERVER_IP_VALUE
     * @generated
     * @ordered
     */
    SERVER_IP(43, "SERVER_IP", "SERVER_IP"),
    /**
     * The '<em><b>SYSTEM DATE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SYSTEM_DATE_VALUE
     * @generated
     * @ordered
     */
    SYSTEM_DATE(44, "SYSTEM_DATE", "SYSTEM_DATE"),
    /**
     * The '<em><b>SYSTEM TIME</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SYSTEM_TIME_VALUE
     * @generated
     * @ordered
     */
    SYSTEM_TIME(45, "SYSTEM_TIME", "SYSTEM_TIME"),
    /**
     * The '<em><b>TRANSPORT HEADERS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TRANSPORT_HEADERS_VALUE
     * @generated
     * @ordered
     */
    TRANSPORT_HEADERS(46, "TRANSPORT_HEADERS", "TRANSPORT_HEADERS"),
    /**
     * The '<em><b>TRANSPORT IN NAME</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TRANSPORT_IN_NAME_VALUE
     * @generated
     * @ordered
     */
    TRANSPORT_IN_NAME(47, "TRANSPORT_IN_NAME", "TRANSPORT_IN_NAME"),
    /**
     * The '<em><b>To</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TO_VALUE
     * @generated
     * @ordered
     */
    TO(48, "To", "To"),
    /**
     * The '<em><b>Transport Non Blocking</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TRANSPORT_NON_BLOCKING_VALUE
     * @generated
     * @ordered
     */
    TRANSPORT_NON_BLOCKING(49, "transportNonBlocking", "transportNonBlocking"),
    /**
     * The '<em><b>JMS CONNECTION FACTORY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JMS_CONNECTION_FACTORY_VALUE
     * @generated
     * @ordered
     */
    JMS_CONNECTION_FACTORY(50, "JMS_CONNECTION_FACTORY", "transport.jms.ConnectionFactory"),
    /**
     * The '<em><b>JMS DESTINATION</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JMS_DESTINATION_VALUE
     * @generated
     * @ordered
     */
    JMS_DESTINATION(51, "JMS_DESTINATION", "transport.jms.Destination"),
    /**
     * The '<em><b>JMS DESTINATION TYPE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JMS_DESTINATION_TYPE_VALUE
     * @generated
     * @ordered
     */
    JMS_DESTINATION_TYPE(52, "JMS_DESTINATION_TYPE", "transport.jms.DestinationType"),
    /**
     * The '<em><b>JMS REPLY DESTINATION</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JMS_REPLY_DESTINATION_VALUE
     * @generated
     * @ordered
     */
    JMS_REPLY_DESTINATION(53, "JMS_REPLY_DESTINATION", "transport.jms.ReplyDestination"),
    /**
     * The '<em><b>JMS WRAPPER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JMS_WRAPPER_VALUE
     * @generated
     * @ordered
     */
    JMS_WRAPPER(54, "JMS_WRAPPER", "transport.jms.Wrapper"),
    /**
     * The '<em><b>VFS FILE URI</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_FILE_URI_VALUE
     * @generated
     * @ordered
     */
    VFS_FILE_URI(55, "VFS_FILE_URI", "transport.vfs.FileURI"),
    /**
     * The '<em><b>VFS CONTENT TYPE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_CONTENT_TYPE_VALUE
     * @generated
     * @ordered
     */
    VFS_CONTENT_TYPE(56, "VFS_CONTENT_TYPE", "transport.vfs.ContentType"),
    /**
     * The '<em><b>VFS FILENAME PATTERN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_FILENAME_PATTERN_VALUE
     * @generated
     * @ordered
     */
    VFS_FILENAME_PATTERN(57, "VFS_FILENAME_PATTERN", "transport.vfs.FileNamePattern"),
    /**
     * The '<em><b>POLL INTERVAL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #POLL_INTERVAL_VALUE
     * @generated
     * @ordered
     */
    POLL_INTERVAL(58, "POLL_INTERVAL", "transport.PollInterval"),
    /**
     * The '<em><b>VFS ACTION AFTER PROCESS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_ACTION_AFTER_PROCESS_VALUE
     * @generated
     * @ordered
     */
    VFS_ACTION_AFTER_PROCESS(59, "VFS_ACTION_AFTER_PROCESS", "transport.vfs.ActionAfterProcess"),
    /**
     * The '<em><b>VFS MOVE AFTER PROCESS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_AFTER_PROCESS_VALUE
     * @generated
     * @ordered
     */
    VFS_MOVE_AFTER_PROCESS(60, "VFS_MOVE_AFTER_PROCESS", "transport.vfs.MoveAfterProcess"),
    /**
     * The '<em><b>VFS ACTION AFTER ERRORS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_ACTION_AFTER_ERRORS_VALUE
     * @generated
     * @ordered
     */
    VFS_ACTION_AFTER_ERRORS(61, "VFS_ACTION_AFTER_ERRORS", "transport.vfs.ActionAfterErrors"),
    /**
     * The '<em><b>VFS MOVE AFTER ERRORS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_AFTER_ERRORS_VALUE
     * @generated
     * @ordered
     */
    VFS_MOVE_AFTER_ERRORS(62, "VFS_MOVE_AFTER_ERRORS", "transport.vfs.MoveAfterErrors"),
    /**
     * The '<em><b>VFS ACTION AFTER FAILURE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_ACTION_AFTER_FAILURE_VALUE
     * @generated
     * @ordered
     */
    VFS_ACTION_AFTER_FAILURE(63, "VFS_ACTION_AFTER_FAILURE", "transport.vfs.ActionAfterFailure"),
    /**
     * The '<em><b>VFS MOVE AFTER FAILURE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_AFTER_FAILURE_VALUE
     * @generated
     * @ordered
     */
    VFS_MOVE_AFTER_FAILURE(64, "VFS_MOVE_AFTER_FAILURE", "transport.vfs.MoveAfterFailure"),
    /**
     * The '<em><b>VFS REPLY FILE URI</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_REPLY_FILE_URI_VALUE
     * @generated
     * @ordered
     */
    VFS_REPLY_FILE_URI(65, "VFS_REPLY_FILE_URI", "transport.vfs.ReplyFileURI"),
    /**
     * The '<em><b>VFS REPLY FILENAME</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_REPLY_FILENAME_VALUE
     * @generated
     * @ordered
     */
    VFS_REPLY_FILENAME(66, "VFS_REPLY_FILENAME", "transport.vfs.ReplyFileName"),
    /**
     * The '<em><b>VFS MOVE TIMESTAMP FORMAT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_TIMESTAMP_FORMAT_VALUE
     * @generated
     * @ordered
     */
    VFS_MOVE_TIMESTAMP_FORMAT(67, "VFS_MOVE_TIMESTAMP_FORMAT", "transport.vfs.MoveTimestampFormat");

    /**
     * The '<em><b>New Property Name</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>New Property Name</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NEW_PROPERTY_NAME
     * @model name="newPropertyName" literal="New Property..."
     * @generated
     * @ordered
     */
    public static final int NEW_PROPERTY_NAME_VALUE = 0;

    /**
     * The '<em><b>Action</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Action</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ACTION
     * @model name="Action"
     * @generated
     * @ordered
     */
    public static final int ACTION_VALUE = 1;

    /**
     * The '<em><b>COPY CONTENT LENGTH FROM INCOMING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>COPY CONTENT LENGTH FROM INCOMING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #COPY_CONTENT_LENGTH_FROM_INCOMING
     * @model
     * @generated
     * @ordered
     */
    public static final int COPY_CONTENT_LENGTH_FROM_INCOMING_VALUE = 2;

    /**
     * The '<em><b>Cache Level</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Cache Level</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CACHE_LEVEL
     * @model name="CacheLevel"
     * @generated
     * @ordered
     */
    public static final int CACHE_LEVEL_VALUE = 3;

    /**
     * The '<em><b>Client Api Non Blocking</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Client Api Non Blocking</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CLIENT_API_NON_BLOCKING
     * @model name="ClientApiNonBlocking"
     * @generated
     * @ordered
     */
    public static final int CLIENT_API_NON_BLOCKING_VALUE = 4;

    /**
     * The '<em><b>Concurrent Consumers</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Concurrent Consumers</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CONCURRENT_CONSUMERS
     * @model name="ConcurrentConsumers"
     * @generated
     * @ordered
     */
    public static final int CONCURRENT_CONSUMERS_VALUE = 5;

    /**
     * The '<em><b>Content Type</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Content Type</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CONTENT_TYPE
     * @model name="ContentType"
     * @generated
     * @ordered
     */
    public static final int CONTENT_TYPE_VALUE = 6;

    /**
     * The '<em><b>Disable Addressing For Out Messages</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Disable Addressing For Out Messages</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DISABLE_ADDRESSING_FOR_OUT_MESSAGES
     * @model name="disableAddressingForOutMessages"
     * @generated
     * @ordered
     */
    public static final int DISABLE_ADDRESSING_FOR_OUT_MESSAGES_VALUE = 7;

    /**
     * The '<em><b>DISABLE CHUNKING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DISABLE CHUNKING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DISABLE_CHUNKING
     * @model
     * @generated
     * @ordered
     */
    public static final int DISABLE_CHUNKING_VALUE = 8;

    /**
     * The '<em><b>DISABLE SMOOKS RESULT PAYLOAD</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DISABLE SMOOKS RESULT PAYLOAD</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DISABLE_SMOOKS_RESULT_PAYLOAD
     * @model
     * @generated
     * @ordered
     */
    public static final int DISABLE_SMOOKS_RESULT_PAYLOAD_VALUE = 9;

    /**
     * The '<em><b>ERROR CODE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ERROR CODE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ERROR_CODE
     * @model
     * @generated
     * @ordered
     */
    public static final int ERROR_CODE_VALUE = 10;

    /**
     * The '<em><b>ERROR DETAIL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ERROR DETAIL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ERROR_DETAIL
     * @model
     * @generated
     * @ordered
     */
    public static final int ERROR_DETAIL_VALUE = 11;

    /**
     * The '<em><b>ERROR EXCEPTION</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ERROR EXCEPTION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ERROR_EXCEPTION
     * @model
     * @generated
     * @ordered
     */
    public static final int ERROR_EXCEPTION_VALUE = 12;

    /**
     * The '<em><b>ERROR MESSAGE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ERROR MESSAGE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ERROR_MESSAGE
     * @model
     * @generated
     * @ordered
     */
    public static final int ERROR_MESSAGE_VALUE = 13;

    /**
     * The '<em><b>FAULTS AS HTTP 200</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FAULTS AS HTTP 200</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FAULTS_AS_HTTP_200
     * @model
     * @generated
     * @ordered
     */
    public static final int FAULTS_AS_HTTP_200_VALUE = 14;

    /**
     * The '<em><b>FORCE ERROR ON SOAP FAULT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FORCE ERROR ON SOAP FAULT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FORCE_ERROR_ON_SOAP_FAULT
     * @model
     * @generated
     * @ordered
     */
    public static final int FORCE_ERROR_ON_SOAP_FAULT_VALUE = 15;

    /**
     * The '<em><b>FORCE HTTP 10</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FORCE HTTP 10</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FORCE_HTTP_10
     * @model name="FORCE_HTTP_1_0"
     * @generated
     * @ordered
     */
    public static final int FORCE_HTTP_10_VALUE = 16;

    /**
     * The '<em><b>FORCE HTTP CONTENT LENGTH</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FORCE HTTP CONTENT LENGTH</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FORCE_HTTP_CONTENT_LENGTH
     * @model
     * @generated
     * @ordered
     */
    public static final int FORCE_HTTP_CONTENT_LENGTH_VALUE = 17;

    /**
     * The '<em><b>FORCE POST PUT NOBODY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FORCE POST PUT NOBODY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FORCE_POST_PUT_NOBODY
     * @model
     * @generated
     * @ordered
     */
    public static final int FORCE_POST_PUT_NOBODY_VALUE = 18;

    /**
     * The '<em><b>FORCE SC ACCEPTED</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FORCE SC ACCEPTED</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FORCE_SC_ACCEPTED
     * @model
     * @generated
     * @ordered
     */
    public static final int FORCE_SC_ACCEPTED_VALUE = 19;

    /**
     * The '<em><b>Fault To</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Fault To</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FAULT_TO
     * @model name="FaultTo"
     * @generated
     * @ordered
     */
    public static final int FAULT_TO_VALUE = 20;

    /**
     * The '<em><b>From</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>From</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FROM
     * @model name="From"
     * @generated
     * @ordered
     */
    public static final int FROM_VALUE = 21;

    /**
     * The '<em><b>HTTP ETAG</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>HTTP ETAG</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #HTTP_ETAG
     * @model
     * @generated
     * @ordered
     */
    public static final int HTTP_ETAG_VALUE = 22;

    /**
     * The '<em><b>HTTP SC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>HTTP SC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #HTTP_SC
     * @model
     * @generated
     * @ordered
     */
    public static final int HTTP_SC_VALUE = 23;

    /**
     * The '<em><b>JMS COORELATION ID</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JMS COORELATION ID</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JMS_COORELATION_ID
     * @model
     * @generated
     * @ordered
     */
    public static final int JMS_COORELATION_ID_VALUE = 24;

    /**
     * The '<em><b>Message Type</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Message Type</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MESSAGE_TYPE
     * @model name="messageType"
     * @generated
     * @ordered
     */
    public static final int MESSAGE_TYPE_VALUE = 25;

    /**
     * The '<em><b>MESSAGE FORMAT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MESSAGE FORMAT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MESSAGE_FORMAT
     * @model
     * @generated
     * @ordered
     */
    public static final int MESSAGE_FORMAT_VALUE = 26;

    /**
     * The '<em><b>Max Concurrent Consumers</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Max Concurrent Consumers</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MAX_CONCURRENT_CONSUMERS
     * @model name="MaxConcurrentConsumers"
     * @generated
     * @ordered
     */
    public static final int MAX_CONCURRENT_CONSUMERS_VALUE = 27;

    /**
     * The '<em><b>Mercury Last Message</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Mercury Last Message</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MERCURY_LAST_MESSAGE
     * @model name="MercuryLastMessage"
     * @generated
     * @ordered
     */
    public static final int MERCURY_LAST_MESSAGE_VALUE = 28;

    /**
     * The '<em><b>Mercury Sequence Key</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Mercury Sequence Key</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MERCURY_SEQUENCE_KEY
     * @model name="MercurySequenceKey"
     * @generated
     * @ordered
     */
    public static final int MERCURY_SEQUENCE_KEY_VALUE = 29;

    /**
     * The '<em><b>Message ID</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Message ID</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MESSAGE_ID
     * @model name="MessageID"
     * @generated
     * @ordered
     */
    public static final int MESSAGE_ID_VALUE = 30;

    /**
     * The '<em><b>NO ENTITY BODY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NO ENTITY BODY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NO_ENTITY_BODY
     * @model
     * @generated
     * @ordered
     */
    public static final int NO_ENTITY_BODY_VALUE = 31;

    /**
     * The '<em><b>NO KEEPALIVE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NO KEEPALIVE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NO_KEEPALIVE
     * @model
     * @generated
     * @ordered
     */
    public static final int NO_KEEPALIVE_VALUE = 32;

    /**
     * The '<em><b>OUT ONLY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>OUT ONLY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #OUT_ONLY
     * @model
     * @generated
     * @ordered
     */
    public static final int OUT_ONLY_VALUE = 33;

    /**
     * The '<em><b>Operation Name</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Operation Name</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #OPERATION_NAME
     * @model name="OperationName"
     * @generated
     * @ordered
     */
    public static final int OPERATION_NAME_VALUE = 34;

    /**
     * The '<em><b>POST TO URI</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>POST TO URI</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #POST_TO_URI
     * @model
     * @generated
     * @ordered
     */
    public static final int POST_TO_URI_VALUE = 35;

    /**
     * The '<em><b>Preserve Processed Headers</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Preserve Processed Headers</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PRESERVE_PROCESSED_HEADERS
     * @model name="preserveProcessedHeaders"
     * @generated
     * @ordered
     */
    public static final int PRESERVE_PROCESSED_HEADERS_VALUE = 36;

    /**
     * The '<em><b>PRESERVE WS ADDRESSING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>PRESERVE WS ADDRESSING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PRESERVE_WS_ADDRESSING
     * @model
     * @generated
     * @ordered
     */
    public static final int PRESERVE_WS_ADDRESSING_VALUE = 37;

    /**
     * The '<em><b>REQUEST HOST HEADER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>REQUEST HOST HEADER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REQUEST_HOST_HEADER
     * @model
     * @generated
     * @ordered
     */
    public static final int REQUEST_HOST_HEADER_VALUE = 38;

    /**
     * The '<em><b>RESPONSE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>RESPONSE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RESPONSE
     * @model
     * @generated
     * @ordered
     */
    public static final int RESPONSE_VALUE = 39;

    /**
     * The '<em><b>REST URL POSTFIX</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>REST URL POSTFIX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REST_URL_POSTFIX
     * @model
     * @generated
     * @ordered
     */
    public static final int REST_URL_POSTFIX_VALUE = 40;

    /**
     * The '<em><b>Relates To</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Relates To</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RELATES_TO
     * @model name="RelatesTo"
     * @generated
     * @ordered
     */
    public static final int RELATES_TO_VALUE = 41;

    /**
     * The '<em><b>Reply To</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Reply To</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REPLY_TO
     * @model name="ReplyTo"
     * @generated
     * @ordered
     */
    public static final int REPLY_TO_VALUE = 42;

    /**
     * The '<em><b>SERVER IP</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SERVER IP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SERVER_IP
     * @model
     * @generated
     * @ordered
     */
    public static final int SERVER_IP_VALUE = 43;

    /**
     * The '<em><b>SYSTEM DATE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SYSTEM DATE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SYSTEM_DATE
     * @model
     * @generated
     * @ordered
     */
    public static final int SYSTEM_DATE_VALUE = 44;

    /**
     * The '<em><b>SYSTEM TIME</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SYSTEM TIME</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SYSTEM_TIME
     * @model
     * @generated
     * @ordered
     */
    public static final int SYSTEM_TIME_VALUE = 45;

    /**
     * The '<em><b>TRANSPORT HEADERS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TRANSPORT HEADERS</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TRANSPORT_HEADERS
     * @model
     * @generated
     * @ordered
     */
    public static final int TRANSPORT_HEADERS_VALUE = 46;

    /**
     * The '<em><b>TRANSPORT IN NAME</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TRANSPORT IN NAME</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TRANSPORT_IN_NAME
     * @model
     * @generated
     * @ordered
     */
    public static final int TRANSPORT_IN_NAME_VALUE = 47;

    /**
     * The '<em><b>To</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>To</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TO
     * @model name="To"
     * @generated
     * @ordered
     */
    public static final int TO_VALUE = 48;

    /**
     * The '<em><b>Transport Non Blocking</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Transport Non Blocking</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TRANSPORT_NON_BLOCKING
     * @model name="transportNonBlocking"
     * @generated
     * @ordered
     */
    public static final int TRANSPORT_NON_BLOCKING_VALUE = 49;

    /**
     * The '<em><b>JMS CONNECTION FACTORY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JMS CONNECTION FACTORY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JMS_CONNECTION_FACTORY
     * @model literal="transport.jms.ConnectionFactory"
     * @generated
     * @ordered
     */
    public static final int JMS_CONNECTION_FACTORY_VALUE = 50;

    /**
     * The '<em><b>JMS DESTINATION</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JMS DESTINATION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JMS_DESTINATION
     * @model literal="transport.jms.Destination"
     * @generated
     * @ordered
     */
    public static final int JMS_DESTINATION_VALUE = 51;

    /**
     * The '<em><b>JMS DESTINATION TYPE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JMS DESTINATION TYPE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JMS_DESTINATION_TYPE
     * @model literal="transport.jms.DestinationType"
     * @generated
     * @ordered
     */
    public static final int JMS_DESTINATION_TYPE_VALUE = 52;

    /**
     * The '<em><b>JMS REPLY DESTINATION</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JMS REPLY DESTINATION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JMS_REPLY_DESTINATION
     * @model literal="transport.jms.ReplyDestination"
     * @generated
     * @ordered
     */
    public static final int JMS_REPLY_DESTINATION_VALUE = 53;

    /**
     * The '<em><b>JMS WRAPPER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JMS WRAPPER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JMS_WRAPPER
     * @model literal="transport.jms.Wrapper"
     * @generated
     * @ordered
     */
    public static final int JMS_WRAPPER_VALUE = 54;

    /**
     * The '<em><b>VFS FILE URI</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS FILE URI</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_FILE_URI
     * @model literal="transport.vfs.FileURI"
     * @generated
     * @ordered
     */
    public static final int VFS_FILE_URI_VALUE = 55;

    /**
     * The '<em><b>VFS CONTENT TYPE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS CONTENT TYPE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_CONTENT_TYPE
     * @model literal="transport.vfs.ContentType"
     * @generated
     * @ordered
     */
    public static final int VFS_CONTENT_TYPE_VALUE = 56;

    /**
     * The '<em><b>VFS FILENAME PATTERN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS FILENAME PATTERN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_FILENAME_PATTERN
     * @model literal="transport.vfs.FileNamePattern"
     * @generated
     * @ordered
     */
    public static final int VFS_FILENAME_PATTERN_VALUE = 57;

    /**
     * The '<em><b>POLL INTERVAL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>POLL INTERVAL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #POLL_INTERVAL
     * @model literal="transport.PollInterval"
     * @generated
     * @ordered
     */
    public static final int POLL_INTERVAL_VALUE = 58;

    /**
     * The '<em><b>VFS ACTION AFTER PROCESS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS ACTION AFTER PROCESS</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_ACTION_AFTER_PROCESS
     * @model literal="transport.vfs.ActionAfterProcess"
     * @generated
     * @ordered
     */
    public static final int VFS_ACTION_AFTER_PROCESS_VALUE = 59;

    /**
     * The '<em><b>VFS MOVE AFTER PROCESS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS MOVE AFTER PROCESS</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_AFTER_PROCESS
     * @model literal="transport.vfs.MoveAfterProcess"
     * @generated
     * @ordered
     */
    public static final int VFS_MOVE_AFTER_PROCESS_VALUE = 60;

    /**
     * The '<em><b>VFS ACTION AFTER ERRORS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS ACTION AFTER ERRORS</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_ACTION_AFTER_ERRORS
     * @model literal="transport.vfs.ActionAfterErrors"
     * @generated
     * @ordered
     */
    public static final int VFS_ACTION_AFTER_ERRORS_VALUE = 61;

    /**
     * The '<em><b>VFS MOVE AFTER ERRORS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS MOVE AFTER ERRORS</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_AFTER_ERRORS
     * @model literal="transport.vfs.MoveAfterErrors"
     * @generated
     * @ordered
     */
    public static final int VFS_MOVE_AFTER_ERRORS_VALUE = 62;

    /**
     * The '<em><b>VFS ACTION AFTER FAILURE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS ACTION AFTER FAILURE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_ACTION_AFTER_FAILURE
     * @model literal="transport.vfs.ActionAfterFailure"
     * @generated
     * @ordered
     */
    public static final int VFS_ACTION_AFTER_FAILURE_VALUE = 63;

    /**
     * The '<em><b>VFS MOVE AFTER FAILURE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS MOVE AFTER FAILURE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_AFTER_FAILURE
     * @model literal="transport.vfs.MoveAfterFailure"
     * @generated
     * @ordered
     */
    public static final int VFS_MOVE_AFTER_FAILURE_VALUE = 64;

    /**
     * The '<em><b>VFS REPLY FILE URI</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS REPLY FILE URI</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_REPLY_FILE_URI
     * @model literal="transport.vfs.ReplyFileURI"
     * @generated
     * @ordered
     */
    public static final int VFS_REPLY_FILE_URI_VALUE = 65;

    /**
     * The '<em><b>VFS REPLY FILENAME</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS REPLY FILENAME</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_REPLY_FILENAME
     * @model literal="transport.vfs.ReplyFileName"
     * @generated
     * @ordered
     */
    public static final int VFS_REPLY_FILENAME_VALUE = 66;

    /**
     * The '<em><b>VFS MOVE TIMESTAMP FORMAT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VFS MOVE TIMESTAMP FORMAT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VFS_MOVE_TIMESTAMP_FORMAT
     * @model literal="transport.vfs.MoveTimestampFormat"
     * @generated
     * @ordered
     */
    public static final int VFS_MOVE_TIMESTAMP_FORMAT_VALUE = 67;

    /**
     * An array of all the '<em><b>Property Name</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final PropertyName[] VALUES_ARRAY = new PropertyName[] {
            NEW_PROPERTY_NAME,
            ACTION,
            COPY_CONTENT_LENGTH_FROM_INCOMING,
            CACHE_LEVEL,
            CLIENT_API_NON_BLOCKING,
            CONCURRENT_CONSUMERS,
            CONTENT_TYPE,
            DISABLE_ADDRESSING_FOR_OUT_MESSAGES,
            DISABLE_CHUNKING,
            DISABLE_SMOOKS_RESULT_PAYLOAD,
            ERROR_CODE,
            ERROR_DETAIL,
            ERROR_EXCEPTION,
            ERROR_MESSAGE,
            FAULTS_AS_HTTP_200,
            FORCE_ERROR_ON_SOAP_FAULT,
            FORCE_HTTP_10,
            FORCE_HTTP_CONTENT_LENGTH,
            FORCE_POST_PUT_NOBODY,
            FORCE_SC_ACCEPTED,
            FAULT_TO,
            FROM,
            HTTP_ETAG,
            HTTP_SC,
            JMS_COORELATION_ID,
            MESSAGE_TYPE,
            MESSAGE_FORMAT,
            MAX_CONCURRENT_CONSUMERS,
            MERCURY_LAST_MESSAGE,
            MERCURY_SEQUENCE_KEY,
            MESSAGE_ID,
            NO_ENTITY_BODY,
            NO_KEEPALIVE,
            OUT_ONLY,
            OPERATION_NAME,
            POST_TO_URI,
            PRESERVE_PROCESSED_HEADERS,
            PRESERVE_WS_ADDRESSING,
            REQUEST_HOST_HEADER,
            RESPONSE,
            REST_URL_POSTFIX,
            RELATES_TO,
            REPLY_TO,
            SERVER_IP,
            SYSTEM_DATE,
            SYSTEM_TIME,
            TRANSPORT_HEADERS,
            TRANSPORT_IN_NAME,
            TO,
            TRANSPORT_NON_BLOCKING,
            JMS_CONNECTION_FACTORY,
            JMS_DESTINATION,
            JMS_DESTINATION_TYPE,
            JMS_REPLY_DESTINATION,
            JMS_WRAPPER,
            VFS_FILE_URI,
            VFS_CONTENT_TYPE,
            VFS_FILENAME_PATTERN,
            POLL_INTERVAL,
            VFS_ACTION_AFTER_PROCESS,
            VFS_MOVE_AFTER_PROCESS,
            VFS_ACTION_AFTER_ERRORS,
            VFS_MOVE_AFTER_ERRORS,
            VFS_ACTION_AFTER_FAILURE,
            VFS_MOVE_AFTER_FAILURE,
            VFS_REPLY_FILE_URI,
            VFS_REPLY_FILENAME,
            VFS_MOVE_TIMESTAMP_FORMAT,
        };

    /**
     * A public read-only list of all the '<em><b>Property Name</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<PropertyName> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Property Name</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PropertyName get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PropertyName result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Property Name</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PropertyName getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PropertyName result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Property Name</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PropertyName get(int value) {
        switch (value) {
            case NEW_PROPERTY_NAME_VALUE: return NEW_PROPERTY_NAME;
            case ACTION_VALUE: return ACTION;
            case COPY_CONTENT_LENGTH_FROM_INCOMING_VALUE: return COPY_CONTENT_LENGTH_FROM_INCOMING;
            case CACHE_LEVEL_VALUE: return CACHE_LEVEL;
            case CLIENT_API_NON_BLOCKING_VALUE: return CLIENT_API_NON_BLOCKING;
            case CONCURRENT_CONSUMERS_VALUE: return CONCURRENT_CONSUMERS;
            case CONTENT_TYPE_VALUE: return CONTENT_TYPE;
            case DISABLE_ADDRESSING_FOR_OUT_MESSAGES_VALUE: return DISABLE_ADDRESSING_FOR_OUT_MESSAGES;
            case DISABLE_CHUNKING_VALUE: return DISABLE_CHUNKING;
            case DISABLE_SMOOKS_RESULT_PAYLOAD_VALUE: return DISABLE_SMOOKS_RESULT_PAYLOAD;
            case ERROR_CODE_VALUE: return ERROR_CODE;
            case ERROR_DETAIL_VALUE: return ERROR_DETAIL;
            case ERROR_EXCEPTION_VALUE: return ERROR_EXCEPTION;
            case ERROR_MESSAGE_VALUE: return ERROR_MESSAGE;
            case FAULTS_AS_HTTP_200_VALUE: return FAULTS_AS_HTTP_200;
            case FORCE_ERROR_ON_SOAP_FAULT_VALUE: return FORCE_ERROR_ON_SOAP_FAULT;
            case FORCE_HTTP_10_VALUE: return FORCE_HTTP_10;
            case FORCE_HTTP_CONTENT_LENGTH_VALUE: return FORCE_HTTP_CONTENT_LENGTH;
            case FORCE_POST_PUT_NOBODY_VALUE: return FORCE_POST_PUT_NOBODY;
            case FORCE_SC_ACCEPTED_VALUE: return FORCE_SC_ACCEPTED;
            case FAULT_TO_VALUE: return FAULT_TO;
            case FROM_VALUE: return FROM;
            case HTTP_ETAG_VALUE: return HTTP_ETAG;
            case HTTP_SC_VALUE: return HTTP_SC;
            case JMS_COORELATION_ID_VALUE: return JMS_COORELATION_ID;
            case MESSAGE_TYPE_VALUE: return MESSAGE_TYPE;
            case MESSAGE_FORMAT_VALUE: return MESSAGE_FORMAT;
            case MAX_CONCURRENT_CONSUMERS_VALUE: return MAX_CONCURRENT_CONSUMERS;
            case MERCURY_LAST_MESSAGE_VALUE: return MERCURY_LAST_MESSAGE;
            case MERCURY_SEQUENCE_KEY_VALUE: return MERCURY_SEQUENCE_KEY;
            case MESSAGE_ID_VALUE: return MESSAGE_ID;
            case NO_ENTITY_BODY_VALUE: return NO_ENTITY_BODY;
            case NO_KEEPALIVE_VALUE: return NO_KEEPALIVE;
            case OUT_ONLY_VALUE: return OUT_ONLY;
            case OPERATION_NAME_VALUE: return OPERATION_NAME;
            case POST_TO_URI_VALUE: return POST_TO_URI;
            case PRESERVE_PROCESSED_HEADERS_VALUE: return PRESERVE_PROCESSED_HEADERS;
            case PRESERVE_WS_ADDRESSING_VALUE: return PRESERVE_WS_ADDRESSING;
            case REQUEST_HOST_HEADER_VALUE: return REQUEST_HOST_HEADER;
            case RESPONSE_VALUE: return RESPONSE;
            case REST_URL_POSTFIX_VALUE: return REST_URL_POSTFIX;
            case RELATES_TO_VALUE: return RELATES_TO;
            case REPLY_TO_VALUE: return REPLY_TO;
            case SERVER_IP_VALUE: return SERVER_IP;
            case SYSTEM_DATE_VALUE: return SYSTEM_DATE;
            case SYSTEM_TIME_VALUE: return SYSTEM_TIME;
            case TRANSPORT_HEADERS_VALUE: return TRANSPORT_HEADERS;
            case TRANSPORT_IN_NAME_VALUE: return TRANSPORT_IN_NAME;
            case TO_VALUE: return TO;
            case TRANSPORT_NON_BLOCKING_VALUE: return TRANSPORT_NON_BLOCKING;
            case JMS_CONNECTION_FACTORY_VALUE: return JMS_CONNECTION_FACTORY;
            case JMS_DESTINATION_VALUE: return JMS_DESTINATION;
            case JMS_DESTINATION_TYPE_VALUE: return JMS_DESTINATION_TYPE;
            case JMS_REPLY_DESTINATION_VALUE: return JMS_REPLY_DESTINATION;
            case JMS_WRAPPER_VALUE: return JMS_WRAPPER;
            case VFS_FILE_URI_VALUE: return VFS_FILE_URI;
            case VFS_CONTENT_TYPE_VALUE: return VFS_CONTENT_TYPE;
            case VFS_FILENAME_PATTERN_VALUE: return VFS_FILENAME_PATTERN;
            case POLL_INTERVAL_VALUE: return POLL_INTERVAL;
            case VFS_ACTION_AFTER_PROCESS_VALUE: return VFS_ACTION_AFTER_PROCESS;
            case VFS_MOVE_AFTER_PROCESS_VALUE: return VFS_MOVE_AFTER_PROCESS;
            case VFS_ACTION_AFTER_ERRORS_VALUE: return VFS_ACTION_AFTER_ERRORS;
            case VFS_MOVE_AFTER_ERRORS_VALUE: return VFS_MOVE_AFTER_ERRORS;
            case VFS_ACTION_AFTER_FAILURE_VALUE: return VFS_ACTION_AFTER_FAILURE;
            case VFS_MOVE_AFTER_FAILURE_VALUE: return VFS_MOVE_AFTER_FAILURE;
            case VFS_REPLY_FILE_URI_VALUE: return VFS_REPLY_FILE_URI;
            case VFS_REPLY_FILENAME_VALUE: return VFS_REPLY_FILENAME;
            case VFS_MOVE_TIMESTAMP_FORMAT_VALUE: return VFS_MOVE_TIMESTAMP_FORMAT;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private PropertyName(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // PropertyName
