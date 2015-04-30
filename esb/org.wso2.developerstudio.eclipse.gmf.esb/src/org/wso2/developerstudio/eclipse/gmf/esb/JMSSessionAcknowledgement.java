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
 * A representation of the literals of the enumeration '<em><b>JMS Session Acknowledgement</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getJMSSessionAcknowledgement()
 * @model
 * @generated
 */
public enum JMSSessionAcknowledgement implements Enumerator {
	/**
	 * The '<em><b>AUTO ACKNOWLEDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTO_ACKNOWLEDGE_VALUE
	 * @generated
	 * @ordered
	 */
	AUTO_ACKNOWLEDGE(0, "AUTO_ACKNOWLEDGE", "AUTO_ACKNOWLEDGE"),

	/**
	 * The '<em><b>CLIENT ACKNOWLEDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLIENT_ACKNOWLEDGE_VALUE
	 * @generated
	 * @ordered
	 */
	CLIENT_ACKNOWLEDGE(1, "CLIENT_ACKNOWLEDGE", "CLIENT_ACKNOWLEDGE"),

	/**
	 * The '<em><b>DUPS OK ACKNOWLEDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUPS_OK_ACKNOWLEDGE_VALUE
	 * @generated
	 * @ordered
	 */
	DUPS_OK_ACKNOWLEDGE(2, "DUPS_OK_ACKNOWLEDGE", "DUPS_OK_ACKNOWLEDGE"),

	/**
	 * The '<em><b>SESSION TRANSACTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SESSION_TRANSACTED_VALUE
	 * @generated
	 * @ordered
	 */
	SESSION_TRANSACTED(3, "SESSION_TRANSACTED", "SESSION_TRANSACTED");

	/**
	 * The '<em><b>AUTO ACKNOWLEDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AUTO ACKNOWLEDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTO_ACKNOWLEDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUTO_ACKNOWLEDGE_VALUE = 0;

	/**
	 * The '<em><b>CLIENT ACKNOWLEDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLIENT ACKNOWLEDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLIENT_ACKNOWLEDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLIENT_ACKNOWLEDGE_VALUE = 1;

	/**
	 * The '<em><b>DUPS OK ACKNOWLEDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DUPS OK ACKNOWLEDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DUPS_OK_ACKNOWLEDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DUPS_OK_ACKNOWLEDGE_VALUE = 2;

	/**
	 * The '<em><b>SESSION TRANSACTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SESSION TRANSACTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SESSION_TRANSACTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SESSION_TRANSACTED_VALUE = 3;

	/**
	 * An array of all the '<em><b>JMS Session Acknowledgement</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JMSSessionAcknowledgement[] VALUES_ARRAY =
		new JMSSessionAcknowledgement[] {
			AUTO_ACKNOWLEDGE,
			CLIENT_ACKNOWLEDGE,
			DUPS_OK_ACKNOWLEDGE,
			SESSION_TRANSACTED,
		};

	/**
	 * A public read-only list of all the '<em><b>JMS Session Acknowledgement</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JMSSessionAcknowledgement> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>JMS Session Acknowledgement</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JMSSessionAcknowledgement get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JMSSessionAcknowledgement result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JMS Session Acknowledgement</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JMSSessionAcknowledgement getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JMSSessionAcknowledgement result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>JMS Session Acknowledgement</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JMSSessionAcknowledgement get(int value) {
		switch (value) {
			case AUTO_ACKNOWLEDGE_VALUE: return AUTO_ACKNOWLEDGE;
			case CLIENT_ACKNOWLEDGE_VALUE: return CLIENT_ACKNOWLEDGE;
			case DUPS_OK_ACKNOWLEDGE_VALUE: return DUPS_OK_ACKNOWLEDGE;
			case SESSION_TRANSACTED_VALUE: return SESSION_TRANSACTED;
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
	private JMSSessionAcknowledgement(int value, String name, String literal) {
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
	
} //JMSSessionAcknowledgement
