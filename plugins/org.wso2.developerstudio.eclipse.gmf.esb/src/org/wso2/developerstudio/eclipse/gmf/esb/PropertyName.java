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
	NEW_PROPERTY_NAME(0, "newPropertyName", "New Property..."), /**
	 * The '<em><b>PRESERVE WS ADDRESSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESERVE_WS_ADDRESSING_VALUE
	 * @generated
	 * @ordered
	 */
	PRESERVE_WS_ADDRESSING(1, "PRESERVE_WS_ADDRESSING", "PRESERVE_WS_ADDRESSING"), /**
	 * The '<em><b>RESPONSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESPONSE_VALUE
	 * @generated
	 * @ordered
	 */
	RESPONSE(2, "RESPONSE", "RESPONSE"), /**
	 * The '<em><b>OUT ONLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	OUT_ONLY(3, "OUT_ONLY", "OUT_ONLY"), /**
	 * The '<em><b>ERROR CODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_CODE_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR_CODE(4, "ERROR_CODE", "ERROR_CODE"), /**
	 * The '<em><b>ERROR MESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR_MESSAGE(5, "ERROR_MESSAGE", "ERROR_MESSAGE"), /**
	 * The '<em><b>ERROR DETAIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_DETAIL_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR_DETAIL(6, "ERROR_DETAIL", "ERROR_DETAIL"), /**
	 * The '<em><b>ERROR EXCEPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_EXCEPTION_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR_EXCEPTION(7, "ERROR_EXCEPTION", "ERROR_EXCEPTION"), /**
	 * The '<em><b>TRANSPORT HEADERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT_HEADERS_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPORT_HEADERS(8, "TRANSPORT_HEADERS", "TRANSPORT_HEADERS"), /**
	 * The '<em><b>Message Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_TYPE(9, "messageType", "messageType"), /**
	 * The '<em><b>Content Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENT_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENT_TYPE(10, "ContentType", "ContentType"), /**
	 * The '<em><b>Disable Addressing For Out Messages</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_ADDRESSING_FOR_OUT_MESSAGES_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_ADDRESSING_FOR_OUT_MESSAGES(11, "disableAddressingForOutMessages", "disableAddressingForOutMessages"), /**
	 * The '<em><b>DISABLE SMOOKS RESULT PAYLOAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_SMOOKS_RESULT_PAYLOAD_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_SMOOKS_RESULT_PAYLOAD(12, "DISABLE_SMOOKS_RESULT_PAYLOAD", "DISABLE_SMOOKS_RESULT_PAYLOAD"), /**
	 * The '<em><b>Client Api Non Blocking</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLIENT_API_NON_BLOCKING_VALUE
	 * @generated
	 * @ordered
	 */
	CLIENT_API_NON_BLOCKING(13, "ClientApiNonBlocking", "ClientApiNonBlocking"), /**
	 * The '<em><b>Transport Non Blocking</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT_NON_BLOCKING_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPORT_NON_BLOCKING(14, "transportNonBlocking", "transportNonBlocking"), /**
	 * The '<em><b>TRANSPORT IN NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT_IN_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSPORT_IN_NAME(15, "TRANSPORT_IN_NAME", "TRANSPORT_IN_NAME"), /**
	 * The '<em><b>Preserve Processed Headers</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESERVE_PROCESSED_HEADERS_VALUE
	 * @generated
	 * @ordered
	 */
	PRESERVE_PROCESSED_HEADERS(16, "preserveProcessedHeaders", "preserveProcessedHeaders"), /**
	 * The '<em><b>SERVER IP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVER_IP_VALUE
	 * @generated
	 * @ordered
	 */
	SERVER_IP(17, "SERVER_IP", "SERVER_IP"), /**
	 * The '<em><b>FORCE ERROR ON SOAP FAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCE_ERROR_ON_SOAP_FAULT_VALUE
	 * @generated
	 * @ordered
	 */
	FORCE_ERROR_ON_SOAP_FAULT(18, "FORCE_ERROR_ON_SOAP_FAULT", "FORCE_ERROR_ON_SOAP_FAULT"), /**
	 * The '<em><b>POST TO URI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_TO_URI_VALUE
	 * @generated
	 * @ordered
	 */
	POST_TO_URI(19, "POST_TO_URI", "POST_TO_URI"), /**
	 * The '<em><b>FORCE SC ACCEPTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCE_SC_ACCEPTED_VALUE
	 * @generated
	 * @ordered
	 */
	FORCE_SC_ACCEPTED(20, "FORCE_SC_ACCEPTED", "FORCE_SC_ACCEPTED"), /**
	 * The '<em><b>DISABLE CHUNKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_CHUNKING_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_CHUNKING(21, "DISABLE_CHUNKING", "DISABLE_CHUNKING"), /**
	 * The '<em><b>NO ENTITY BODY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_ENTITY_BODY_VALUE
	 * @generated
	 * @ordered
	 */
	NO_ENTITY_BODY(22, "NO_ENTITY_BODY", "NO_ENTITY_BODY"), /**
	 * The '<em><b>FORCE HTTP 10</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCE_HTTP_10_VALUE
	 * @generated NOT
	 * @ordered
	 */
	FORCE_HTTP_10(23, "FORCE_HTTP_1.0", "FORCE_HTTP_1.0"), /**
	 * The '<em><b>HTTP SC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HTTP_SC_VALUE
	 * @generated
	 * @ordered
	 */
	HTTP_SC(24, "HTTP_SC", "HTTP_SC"), /**
	 * The '<em><b>FAULTS AS HTTP 200</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTS_AS_HTTP_200_VALUE
	 * @generated
	 * @ordered
	 */
	FAULTS_AS_HTTP_200(25, "FAULTS_AS_HTTP_200", "FAULTS_AS_HTTP_200"), /**
	 * The '<em><b>NO KEEPALIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_KEEPALIVE_VALUE
	 * @generated
	 * @ordered
	 */
	NO_KEEPALIVE(26, "NO_KEEPALIVE", "NO_KEEPALIVE"), /**
	 * The '<em><b>REST URL POSTFIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REST_URL_POSTFIX_VALUE
	 * @generated
	 * @ordered
	 */
	REST_URL_POSTFIX(27, "REST_URL_POSTFIX", "REST_URL_POSTFIX"), /**
	 * The '<em><b>REQUEST HOST HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REQUEST_HOST_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	REQUEST_HOST_HEADER(28, "REQUEST_HOST_HEADER", "REQUEST_HOST_HEADER"), /**
	 * The '<em><b>FORCE POST PUT NOBODY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCE_POST_PUT_NOBODY_VALUE
	 * @generated
	 * @ordered
	 */
	FORCE_POST_PUT_NOBODY(29, "FORCE_POST_PUT_NOBODY", "FORCE_POST_PUT_NOBODY"), /**
	 * The '<em><b>FORCE HTTP CONTENT LENGTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCE_HTTP_CONTENT_LENGTH_VALUE
	 * @generated
	 * @ordered
	 */
	FORCE_HTTP_CONTENT_LENGTH(30, "FORCE_HTTP_CONTENT_LENGTH", "FORCE_HTTP_CONTENT_LENGTH"), /**
	 * The '<em><b>COPY CONTENT LENGTH FROM INCOMING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPY_CONTENT_LENGTH_FROM_INCOMING_VALUE
	 * @generated
	 * @ordered
	 */
	COPY_CONTENT_LENGTH_FROM_INCOMING(31, "COPY_CONTENT_LENGTH_FROM_INCOMING", "COPY_CONTENT_LENGTH_FROM_INCOMING"), /**
	 * The '<em><b>To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TO_VALUE
	 * @generated
	 * @ordered
	 */
	TO(32, "To", "To"), /**
	 * The '<em><b>From</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FROM_VALUE
	 * @generated
	 * @ordered
	 */
	FROM(33, "From", "From"), /**
	 * The '<em><b>Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ACTION(34, "Action", "Action"), /**
	 * The '<em><b>Reply To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLY_TO_VALUE
	 * @generated
	 * @ordered
	 */
	REPLY_TO(35, "ReplyTo", "ReplyTo"), /**
	 * The '<em><b>Message ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_ID_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_ID(36, "MessageID", "MessageID"), /**
	 * The '<em><b>Relates To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATES_TO_VALUE
	 * @generated
	 * @ordered
	 */
	RELATES_TO(37, "RelatesTo", "RelatesTo"), /**
	 * The '<em><b>Fault To</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULT_TO_VALUE
	 * @generated
	 * @ordered
	 */
	FAULT_TO(38, "FaultTo", "FaultTo"), /**
	 * The '<em><b>Cache Level</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CACHE_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	CACHE_LEVEL(39, "CacheLevel", "CacheLevel"), /**
	 * The '<em><b>Concurrent Consumers</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONCURRENT_CONSUMERS_VALUE
	 * @generated
	 * @ordered
	 */
	CONCURRENT_CONSUMERS(40, "ConcurrentConsumers", "ConcurrentConsumers"), /**
	 * The '<em><b>HTTP ETAG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HTTP_ETAG_VALUE
	 * @generated
	 * @ordered
	 */
	HTTP_ETAG(41, "HTTP_ETAG", "HTTP_ETAG"), /**
	 * The '<em><b>JMS COORELATION ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JMS_COORELATION_ID_VALUE
	 * @generated
	 * @ordered
	 */
	JMS_COORELATION_ID(42, "JMS_COORELATION_ID", "JMS_COORELATION_ID"), /**
	 * The '<em><b>Max Concurrent Consumers</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_CONCURRENT_CONSUMERS_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_CONCURRENT_CONSUMERS(43, "MaxConcurrentConsumers", "MaxConcurrentConsumers"), /**
	 * The '<em><b>Mercury Sequence Key</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERCURY_SEQUENCE_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	MERCURY_SEQUENCE_KEY(44, "MercurySequenceKey", "MercurySequenceKey"), /**
	 * The '<em><b>Mercury Last Message</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERCURY_LAST_MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	MERCURY_LAST_MESSAGE(45, "MercuryLastMessage", "MercuryLastMessage"), /**
	 * The '<em><b>SYSTEM DATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_DATE_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_DATE(47, "SYSTEM_DATE", "SYSTEM_DATE"), /**
	 * The '<em><b>SYSTEM TIME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	SYSTEM_TIME(48, "SYSTEM_TIME", "SYSTEM_TIME"), /**
	 * The '<em><b>MESSAGE FORMAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_FORMAT_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_FORMAT(49, "MESSAGE_FORMAT", "MESSAGE_FORMAT"), /**
	 * The '<em><b>Operation Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATION_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	OPERATION_NAME(50, "OperationName", "OperationName");

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
	public static final int PRESERVE_WS_ADDRESSING_VALUE = 1;

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
	public static final int RESPONSE_VALUE = 2;

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
	public static final int OUT_ONLY_VALUE = 3;

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
	public static final int ERROR_CODE_VALUE = 4;

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
	public static final int ERROR_MESSAGE_VALUE = 5;

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
	public static final int ERROR_DETAIL_VALUE = 6;

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
	public static final int ERROR_EXCEPTION_VALUE = 7;

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
	public static final int TRANSPORT_HEADERS_VALUE = 8;

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
	public static final int MESSAGE_TYPE_VALUE = 9;

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
	public static final int CONTENT_TYPE_VALUE = 10;

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
	public static final int DISABLE_ADDRESSING_FOR_OUT_MESSAGES_VALUE = 11;

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
	public static final int DISABLE_SMOOKS_RESULT_PAYLOAD_VALUE = 12;

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
	public static final int CLIENT_API_NON_BLOCKING_VALUE = 13;

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
	public static final int TRANSPORT_NON_BLOCKING_VALUE = 14;

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
	public static final int TRANSPORT_IN_NAME_VALUE = 15;

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
	public static final int PRESERVE_PROCESSED_HEADERS_VALUE = 16;

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
	public static final int SERVER_IP_VALUE = 17;

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
	public static final int FORCE_ERROR_ON_SOAP_FAULT_VALUE = 18;

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
	public static final int POST_TO_URI_VALUE = 19;

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
	public static final int FORCE_SC_ACCEPTED_VALUE = 20;

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
	public static final int DISABLE_CHUNKING_VALUE = 21;

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
	public static final int NO_ENTITY_BODY_VALUE = 22;

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
	public static final int FORCE_HTTP_10_VALUE = 23;

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
	public static final int HTTP_SC_VALUE = 24;

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
	public static final int FAULTS_AS_HTTP_200_VALUE = 25;

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
	public static final int NO_KEEPALIVE_VALUE = 26;

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
	public static final int REST_URL_POSTFIX_VALUE = 27;

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
	public static final int REQUEST_HOST_HEADER_VALUE = 28;

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
	public static final int FORCE_POST_PUT_NOBODY_VALUE = 29;

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
	public static final int FORCE_HTTP_CONTENT_LENGTH_VALUE = 30;

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
	public static final int COPY_CONTENT_LENGTH_FROM_INCOMING_VALUE = 31;

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
	public static final int TO_VALUE = 32;

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
	public static final int FROM_VALUE = 33;

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
	public static final int ACTION_VALUE = 34;

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
	public static final int REPLY_TO_VALUE = 35;

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
	public static final int MESSAGE_ID_VALUE = 36;

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
	public static final int RELATES_TO_VALUE = 37;

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
	public static final int FAULT_TO_VALUE = 38;

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
	public static final int CACHE_LEVEL_VALUE = 39;

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
	public static final int CONCURRENT_CONSUMERS_VALUE = 40;

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
	public static final int HTTP_ETAG_VALUE = 41;

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
	public static final int JMS_COORELATION_ID_VALUE = 42;

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
	public static final int MAX_CONCURRENT_CONSUMERS_VALUE = 43;

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
	public static final int MERCURY_SEQUENCE_KEY_VALUE = 44;

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
	public static final int MERCURY_LAST_MESSAGE_VALUE = 45;

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
	public static final int SYSTEM_DATE_VALUE = 47;

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
	public static final int SYSTEM_TIME_VALUE = 48;

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
	public static final int MESSAGE_FORMAT_VALUE = 49;

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
	public static final int OPERATION_NAME_VALUE = 50;

	/**
	 * An array of all the '<em><b>Property Name</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PropertyName[] VALUES_ARRAY =
		new PropertyName[] {
			NEW_PROPERTY_NAME,
			PRESERVE_WS_ADDRESSING,
			RESPONSE,
			OUT_ONLY,
			ERROR_CODE,
			ERROR_MESSAGE,
			ERROR_DETAIL,
			ERROR_EXCEPTION,
			TRANSPORT_HEADERS,
			MESSAGE_TYPE,
			CONTENT_TYPE,
			DISABLE_ADDRESSING_FOR_OUT_MESSAGES,
			DISABLE_SMOOKS_RESULT_PAYLOAD,
			CLIENT_API_NON_BLOCKING,
			TRANSPORT_NON_BLOCKING,
			TRANSPORT_IN_NAME,
			PRESERVE_PROCESSED_HEADERS,
			SERVER_IP,
			FORCE_ERROR_ON_SOAP_FAULT,
			POST_TO_URI,
			FORCE_SC_ACCEPTED,
			DISABLE_CHUNKING,
			NO_ENTITY_BODY,
			FORCE_HTTP_10,
			HTTP_SC,
			FAULTS_AS_HTTP_200,
			NO_KEEPALIVE,
			REST_URL_POSTFIX,
			REQUEST_HOST_HEADER,
			FORCE_POST_PUT_NOBODY,
			FORCE_HTTP_CONTENT_LENGTH,
			COPY_CONTENT_LENGTH_FROM_INCOMING,
			TO,
			FROM,
			ACTION,
			REPLY_TO,
			MESSAGE_ID,
			RELATES_TO,
			FAULT_TO,
			CACHE_LEVEL,
			CONCURRENT_CONSUMERS,
			HTTP_ETAG,
			JMS_COORELATION_ID,
			MAX_CONCURRENT_CONSUMERS,
			MERCURY_SEQUENCE_KEY,
			MERCURY_LAST_MESSAGE,
			SYSTEM_DATE,
			SYSTEM_TIME,
			MESSAGE_FORMAT,
			OPERATION_NAME,
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
	 * @generated
	 */
	public static PropertyName get(int value) {
		switch (value) {
			case NEW_PROPERTY_NAME_VALUE: return NEW_PROPERTY_NAME;
			case PRESERVE_WS_ADDRESSING_VALUE: return PRESERVE_WS_ADDRESSING;
			case RESPONSE_VALUE: return RESPONSE;
			case OUT_ONLY_VALUE: return OUT_ONLY;
			case ERROR_CODE_VALUE: return ERROR_CODE;
			case ERROR_MESSAGE_VALUE: return ERROR_MESSAGE;
			case ERROR_DETAIL_VALUE: return ERROR_DETAIL;
			case ERROR_EXCEPTION_VALUE: return ERROR_EXCEPTION;
			case TRANSPORT_HEADERS_VALUE: return TRANSPORT_HEADERS;
			case MESSAGE_TYPE_VALUE: return MESSAGE_TYPE;
			case CONTENT_TYPE_VALUE: return CONTENT_TYPE;
			case DISABLE_ADDRESSING_FOR_OUT_MESSAGES_VALUE: return DISABLE_ADDRESSING_FOR_OUT_MESSAGES;
			case DISABLE_SMOOKS_RESULT_PAYLOAD_VALUE: return DISABLE_SMOOKS_RESULT_PAYLOAD;
			case CLIENT_API_NON_BLOCKING_VALUE: return CLIENT_API_NON_BLOCKING;
			case TRANSPORT_NON_BLOCKING_VALUE: return TRANSPORT_NON_BLOCKING;
			case TRANSPORT_IN_NAME_VALUE: return TRANSPORT_IN_NAME;
			case PRESERVE_PROCESSED_HEADERS_VALUE: return PRESERVE_PROCESSED_HEADERS;
			case SERVER_IP_VALUE: return SERVER_IP;
			case FORCE_ERROR_ON_SOAP_FAULT_VALUE: return FORCE_ERROR_ON_SOAP_FAULT;
			case POST_TO_URI_VALUE: return POST_TO_URI;
			case FORCE_SC_ACCEPTED_VALUE: return FORCE_SC_ACCEPTED;
			case DISABLE_CHUNKING_VALUE: return DISABLE_CHUNKING;
			case NO_ENTITY_BODY_VALUE: return NO_ENTITY_BODY;
			case FORCE_HTTP_10_VALUE: return FORCE_HTTP_10;
			case HTTP_SC_VALUE: return HTTP_SC;
			case FAULTS_AS_HTTP_200_VALUE: return FAULTS_AS_HTTP_200;
			case NO_KEEPALIVE_VALUE: return NO_KEEPALIVE;
			case REST_URL_POSTFIX_VALUE: return REST_URL_POSTFIX;
			case REQUEST_HOST_HEADER_VALUE: return REQUEST_HOST_HEADER;
			case FORCE_POST_PUT_NOBODY_VALUE: return FORCE_POST_PUT_NOBODY;
			case FORCE_HTTP_CONTENT_LENGTH_VALUE: return FORCE_HTTP_CONTENT_LENGTH;
			case COPY_CONTENT_LENGTH_FROM_INCOMING_VALUE: return COPY_CONTENT_LENGTH_FROM_INCOMING;
			case TO_VALUE: return TO;
			case FROM_VALUE: return FROM;
			case ACTION_VALUE: return ACTION;
			case REPLY_TO_VALUE: return REPLY_TO;
			case MESSAGE_ID_VALUE: return MESSAGE_ID;
			case RELATES_TO_VALUE: return RELATES_TO;
			case FAULT_TO_VALUE: return FAULT_TO;
			case CACHE_LEVEL_VALUE: return CACHE_LEVEL;
			case CONCURRENT_CONSUMERS_VALUE: return CONCURRENT_CONSUMERS;
			case HTTP_ETAG_VALUE: return HTTP_ETAG;
			case JMS_COORELATION_ID_VALUE: return JMS_COORELATION_ID;
			case MAX_CONCURRENT_CONSUMERS_VALUE: return MAX_CONCURRENT_CONSUMERS;
			case MERCURY_SEQUENCE_KEY_VALUE: return MERCURY_SEQUENCE_KEY;
			case MERCURY_LAST_MESSAGE_VALUE: return MERCURY_LAST_MESSAGE;
			case SYSTEM_DATE_VALUE: return SYSTEM_DATE;
			case SYSTEM_TIME_VALUE: return SYSTEM_TIME;
			case MESSAGE_FORMAT_VALUE: return MESSAGE_FORMAT;
			case OPERATION_NAME_VALUE: return OPERATION_NAME;
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
	
} //PropertyName
