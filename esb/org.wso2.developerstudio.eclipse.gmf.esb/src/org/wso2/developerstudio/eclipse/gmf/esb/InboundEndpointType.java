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
 * A representation of the literals of the enumeration '<em><b>Inbound Endpoint Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getInboundEndpointType()
 * @model
 * @generated
 */
public enum InboundEndpointType implements Enumerator {
	/**
	 * The '<em><b>Http</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HTTP_VALUE
	 * @generated
	 * @ordered
	 */
	HTTP(0, "http", "HTTP"),

	/**
	 * The '<em><b>File</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_VALUE
	 * @generated
	 * @ordered
	 */
	FILE(1, "file", "File"),

	/**
	 * The '<em><b>Jms</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JMS_VALUE
	 * @generated
	 * @ordered
	 */
	JMS(2, "jms", "JMS"),

	/**
	 * The '<em><b>Custom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOM_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOM(3, "custom", "Custom"), /**
	 * The '<em><b>Https</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HTTPS_VALUE
	 * @generated
	 * @ordered
	 */
	HTTPS(4, "https", "HTTPS"), /**
	 * The '<em><b>Hl7</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HL7_VALUE
	 * @generated
	 * @ordered
	 */
	HL7(5, "hl7", "HL7"), /**
	 * The '<em><b>Kafka</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KAFKA_VALUE
	 * @generated
	 * @ordered
	 */
	KAFKA(6, "kafka", "KAFKA"), /**
	 * The '<em><b>Cxf ws rm</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CXF_WS_RM_VALUE
	 * @generated
	 * @ordered
	 */
	CXF_WS_RM(7, "cxf_ws_rm", "CXF_WS_RM"), /**
	 * The '<em><b>Mqtt</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MQTT_VALUE
	 * @generated
	 * @ordered
	 */
	MQTT(8, "mqtt", "MQTT"), /**
	 * The '<em><b>Rabbitmq</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RABBITMQ_VALUE
	 * @generated
	 * @ordered
	 */
	RABBITMQ(9, "rabbitmq", "RABBITMQ"), /**
	 * The '<em><b>Feed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEED_VALUE
	 * @generated
	 * @ordered
	 */
	FEED(10, "feed", "Feed");

	/**
	 * The '<em><b>Http</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HTTP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HTTP
	 * @model name="http" literal="HTTP"
	 * @generated
	 * @ordered
	 */
	public static final int HTTP_VALUE = 0;

	/**
	 * The '<em><b>File</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>File</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE
	 * @model name="file" literal="File"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_VALUE = 1;

	/**
	 * The '<em><b>Jms</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JMS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JMS
	 * @model name="jms" literal="JMS"
	 * @generated
	 * @ordered
	 */
	public static final int JMS_VALUE = 2;

	/**
	 * The '<em><b>Custom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Custom</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOM
	 * @model name="custom" literal="Custom"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOM_VALUE = 3;

	/**
	 * The '<em><b>Https</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HTTPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HTTPS
	 * @model name="https" literal="HTTPS"
	 * @generated
	 * @ordered
	 */
	public static final int HTTPS_VALUE = 4;

	/**
	 * The '<em><b>Hl7</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HL7</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HL7
	 * @model name="hl7" literal="HL7"
	 * @generated
	 * @ordered
	 */
	public static final int HL7_VALUE = 5;

	/**
	 * The '<em><b>Kafka</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KAFKA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KAFKA
	 * @model name="kafka" literal="KAFKA"
	 * @generated
	 * @ordered
	 */
	public static final int KAFKA_VALUE = 6;

	/**
	 * The '<em><b>Cxf ws rm</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CXF WS RM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CXF_WS_RM
	 * @model name="cxf_ws_rm" literal="CXF_WS_RM"
	 * @generated
	 * @ordered
	 */
	public static final int CXF_WS_RM_VALUE = 7;

	/**
	 * The '<em><b>Mqtt</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mqtt</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MQTT
	 * @model name="mqtt" literal="MQTT"
	 * @generated
	 * @ordered
	 */
	public static final int MQTT_VALUE = 8;

	/**
	 * The '<em><b>Rabbitmq</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rabbitmq</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RABBITMQ
	 * @model name="rabbitmq" literal="RABBITMQ"
	 * @generated
	 * @ordered
	 */
	public static final int RABBITMQ_VALUE = 9;

	/**
	 * The '<em><b>Feed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Feed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEED
	 * @model name="feed" literal="Feed"
	 * @generated
	 * @ordered
	 */
	public static final int FEED_VALUE = 10;

	/**
	 * An array of all the '<em><b>Inbound Endpoint Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final InboundEndpointType[] VALUES_ARRAY =
		new InboundEndpointType[] {
			HTTP,
			FILE,
			JMS,
			CUSTOM,
			HTTPS,
			HL7,
			KAFKA,
			CXF_WS_RM,
			MQTT,
			RABBITMQ,
			FEED,
		};

	/**
	 * A public read-only list of all the '<em><b>Inbound Endpoint Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<InboundEndpointType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Inbound Endpoint Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InboundEndpointType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InboundEndpointType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Inbound Endpoint Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InboundEndpointType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			InboundEndpointType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Inbound Endpoint Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InboundEndpointType get(int value) {
		switch (value) {
			case HTTP_VALUE: return HTTP;
			case FILE_VALUE: return FILE;
			case JMS_VALUE: return JMS;
			case CUSTOM_VALUE: return CUSTOM;
			case HTTPS_VALUE: return HTTPS;
			case HL7_VALUE: return HL7;
			case KAFKA_VALUE: return KAFKA;
			case CXF_WS_RM_VALUE: return CXF_WS_RM;
			case MQTT_VALUE: return MQTT;
			case RABBITMQ_VALUE: return RABBITMQ;
			case FEED_VALUE: return FEED;
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
	private InboundEndpointType(int value, String name, String literal) {
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
	
} //InboundEndpointType
