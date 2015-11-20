/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Artifact Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getArtifactType()
 * @model
 * @generated
 */
public enum ArtifactType implements Enumerator {
	/**
	 * The '<em><b>SYNAPSE CONFIG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNAPSE_CONFIG_VALUE
	 * @generated
	 * @ordered
	 */
	SYNAPSE_CONFIG(0, "SYNAPSE_CONFIG", "SYNAPSE_CONFIG"),

	/**
	 * The '<em><b>PROXY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROXY_VALUE
	 * @generated
	 * @ordered
	 */
	PROXY(1, "PROXY", "PROXY"),

	/**
	 * The '<em><b>SEQUENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	SEQUENCE(2, "SEQUENCE", "SEQUENCE"),

	/**
	 * The '<em><b>ENDPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENDPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	ENDPOINT(3, "ENDPOINT", "ENDPOINT"),

	/**
	 * The '<em><b>LOCAL ENTRY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_ENTRY_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_ENTRY(4, "LOCAL_ENTRY", "LOCAL_ENTRY"),

	/**
	 * The '<em><b>TASK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TASK_VALUE
	 * @generated
	 * @ordered
	 */
	TASK(5, "TASK", "TASK"),

	/**
	 * The '<em><b>TEMPLATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPLATE(6, "TEMPLATE", "TEMPLATE"), /**
	 * The '<em><b>API</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #API_VALUE
	 * @generated
	 * @ordered
	 */
	API(7, "API", "API"), /**
	 * The '<em><b>MAIN SEQUENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAIN_SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	MAIN_SEQUENCE(8, "MAIN_SEQUENCE", "MAIN_SEQUENCE"), /**
	 * The '<em><b>COMPLEX ENDPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPLEX_ENDPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	COMPLEX_ENDPOINT(9, "COMPLEX_ENDPOINT", "COMPLEX_ENDPOINT"), /**
	 * The '<em><b>MESSAGE STORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_STORE_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_STORE(10, "MESSAGE_STORE", "MESSAGE_STORE"), /**
	 * The '<em><b>MESSAGE PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_PROCESSOR(11, "MESSAGE_PROCESSOR", "MESSAGE_PROCESSOR"), /**
	 * The '<em><b>INBOUND ENDPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #INBOUND_ENDPOINT_VALUE
	 * @generated
	 * @ordered
	 */
    INBOUND_ENDPOINT(12, "INBOUND_ENDPOINT", "INBOUND_ENDPOINT"),
	
	TEMPLATE_ENDPOINT(13, "TEMPLATE_ENDPOINT", "TEMPLATE_ENDPOINT"),
	TEMPLATE_ENDPOINT_ADDRESS(14, "TEMPLATE_ENDPOINT_ADDRESS", "TEMPLATE_ENDPOINT_ADDRESS"),
	TEMPLATE_ENDPOINT_WSDL(15, "TEMPLATE_ENDPOINT_WSDL", "TEMPLATE_ENDPOINT_WSDL"),
	TEMPLATE_ENDPOINT_DEFAULT(16, "TEMPLATE_ENDPOINT_DEFAULT", "TEMPLATE_ENDPOINT_DEFAULT"),
	TEMPLATE_ENDPOINT_HTTP(17, "TEMPLATE_ENDPOINT_HTTP", "TEMPLATE_ENDPOINT_HTTP"),
	TEMPLATE_SEQUENCE(18, "TEMPLATE_SEQUENCE", "TEMPLATE_SEQUENCE");

	/**
	 * The '<em><b>SYNAPSE CONFIG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYNAPSE CONFIG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNAPSE_CONFIG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYNAPSE_CONFIG_VALUE = 0;

	/**
	 * The '<em><b>PROXY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROXY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROXY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROXY_VALUE = 1;

	/**
	 * The '<em><b>SEQUENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEQUENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_VALUE = 2;

	/**
	 * The '<em><b>ENDPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENDPOINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENDPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENDPOINT_VALUE = 3;

	/**
	 * The '<em><b>LOCAL ENTRY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOCAL ENTRY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL_ENTRY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_ENTRY_VALUE = 4;

	/**
	 * The '<em><b>TASK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TASK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TASK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TASK_VALUE = 5;

	/**
	 * The '<em><b>TEMPLATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_VALUE = 6;

	/**
	 * The '<em><b>API</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>API</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #API
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int API_VALUE = 7;

	/**
	 * The '<em><b>MAIN SEQUENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAIN SEQUENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAIN_SEQUENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAIN_SEQUENCE_VALUE = 8;

	/**
	 * The '<em><b>COMPLEX ENDPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPLEX ENDPOINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPLEX_ENDPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPLEX_ENDPOINT_VALUE = 9;

	/**
	 * The '<em><b>MESSAGE STORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MESSAGE STORE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_STORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_STORE_VALUE = 10;

	/**
	 * The '<em><b>MESSAGE PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MESSAGE PROCESSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_PROCESSOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_PROCESSOR_VALUE = 11;

	/**
	 * The '<em><b>INBOUND ENDPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INBOUND ENDPOINT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #INBOUND_ENDPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int INBOUND_ENDPOINT_VALUE = 12;

    /**
	 * The '<em><b>TEMPLATE ENDPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE ENDPOINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_ENDPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_ENDPOINT_VALUE = 13;

	/**
	 * The '<em><b>TEMPLATE ENDPOINT ADDRESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE ENDPOINT ADDRESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_ENDPOINT_ADDRESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_ENDPOINT_ADDRESS_VALUE = 14;

	/**
	 * The '<em><b>TEMPLATE ENDPOINT WSDL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE ENDPOINT WSDL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_ENDPOINT_WSDL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_ENDPOINT_WSDL_VALUE = 15;

	/**
	 * The '<em><b>TEMPLATE ENDPOINT DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE ENDPOINT DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_ENDPOINT_DEFAULT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_ENDPOINT_DEFAULT_VALUE = 16;

	/**
	 * The '<em><b>TEMPLATE ENDPOINT HTTP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE ENDPOINT HTTP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_ENDPOINT_HTTP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_ENDPOINT_HTTP_VALUE = 17;

	/**
	 * The '<em><b>TEMPLATE SEQUENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPLATE SEQUENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_SEQUENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_SEQUENCE_VALUE = 18;

				/**
	 * An array of all the '<em><b>Artifact Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ArtifactType[] VALUES_ARRAY =
		new ArtifactType[] {
			SYNAPSE_CONFIG,
			PROXY,
			SEQUENCE,
			ENDPOINT,
			LOCAL_ENTRY,
			TASK,
			TEMPLATE,
			API,
			MAIN_SEQUENCE,
			COMPLEX_ENDPOINT,
			MESSAGE_STORE,
			MESSAGE_PROCESSOR,
			INBOUND_ENDPOINT,
			TEMPLATE_ENDPOINT,
			TEMPLATE_ENDPOINT_ADDRESS,
			TEMPLATE_ENDPOINT_WSDL,
			TEMPLATE_ENDPOINT_DEFAULT,
			TEMPLATE_ENDPOINT_HTTP,
			TEMPLATE_SEQUENCE,
		};

	/**
	 * A public read-only list of all the '<em><b>Artifact Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ArtifactType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Artifact Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArtifactType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ArtifactType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Artifact Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArtifactType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ArtifactType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Artifact Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArtifactType get(int value) {
		switch (value) {
			case SYNAPSE_CONFIG_VALUE: return SYNAPSE_CONFIG;
			case PROXY_VALUE: return PROXY;
			case SEQUENCE_VALUE: return SEQUENCE;
			case ENDPOINT_VALUE: return ENDPOINT;
			case LOCAL_ENTRY_VALUE: return LOCAL_ENTRY;
			case TASK_VALUE: return TASK;
			case TEMPLATE_VALUE: return TEMPLATE;
			case API_VALUE: return API;
			case MAIN_SEQUENCE_VALUE: return MAIN_SEQUENCE;
			case COMPLEX_ENDPOINT_VALUE: return COMPLEX_ENDPOINT;
			case MESSAGE_STORE_VALUE: return MESSAGE_STORE;
			case MESSAGE_PROCESSOR_VALUE: return MESSAGE_PROCESSOR;
			case INBOUND_ENDPOINT_VALUE: return INBOUND_ENDPOINT;
			case TEMPLATE_ENDPOINT_VALUE: return TEMPLATE_ENDPOINT;
			case TEMPLATE_ENDPOINT_ADDRESS_VALUE: return TEMPLATE_ENDPOINT_ADDRESS;
			case TEMPLATE_ENDPOINT_WSDL_VALUE: return TEMPLATE_ENDPOINT_WSDL;
			case TEMPLATE_ENDPOINT_DEFAULT_VALUE: return TEMPLATE_ENDPOINT_DEFAULT;
			case TEMPLATE_ENDPOINT_HTTP_VALUE: return TEMPLATE_ENDPOINT_HTTP;
			case TEMPLATE_SEQUENCE_VALUE: return TEMPLATE_SEQUENCE;
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
	private ArtifactType(int value, String name, String literal) {
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
	
} //ArtifactType
