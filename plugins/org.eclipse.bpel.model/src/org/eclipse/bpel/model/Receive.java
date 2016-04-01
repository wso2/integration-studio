/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: Receive.java,v 1.6 2008/02/28 17:33:21 smoser Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows a business process to block and wait for a particular message to be invoked by a partner in another process. A Receive Activity has a corresponding WSDL portType and operation which other processes can use to invoke the service. The partner can only invoke operations specified by the role it is playing as defined in a ServiceLinkType.
 * 
 * The container for the receive activity corresponds to the input message of its operation. The container messageType must be the input message.
 * 
 * If the operation has an output message, it corresponds to a request-response WSDL message. There must be a corresponding Reply Activity in the process having a container whose messageType is the same as the output message. The Reply Activity is used to send a return message back to the invoking process .
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Receive#getCreateInstance <em>Create Instance</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Receive#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Receive#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Receive#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getReceive()
 * @model
 * @generated
 */
public interface Receive extends PartnerActivity {
	/**
	 * Returns the value of the '<em><b>Create Instance</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Instance</em>' attribute.
	 * @see #isSetCreateInstance()
	 * @see #unsetCreateInstance()
	 * @see #setCreateInstance(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getReceive_CreateInstance()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getCreateInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Receive#getCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Instance</em>' attribute.
	 * @see #isSetCreateInstance()
	 * @see #unsetCreateInstance()
	 * @see #getCreateInstance()
	 */
	void setCreateInstance(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Receive#getCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreateInstance()
	 * @see #getCreateInstance()
	 * @see #setCreateInstance(Boolean)
	 */
	void unsetCreateInstance();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Receive#getCreateInstance <em>Create Instance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Instance</em>' attribute is set.
	 * @see #unsetCreateInstance()
	 * @see #getCreateInstance()
	 * @see #setCreateInstance(Boolean)
	 * @generated
	 */
	boolean isSetCreateInstance();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getReceive_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Receive#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>From Parts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Parts</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Parts</em>' containment reference.
	 * @see #setFromParts(FromParts)
	 * @see org.eclipse.bpel.model.BPELPackage#getReceive_FromParts()
	 * @model containment="true"
	 * @generated
	 */
	FromParts getFromParts();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Receive#getFromParts <em>From Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Parts</em>' containment reference.
	 * @see #getFromParts()
	 * @generated
	 */
	void setFromParts(FromParts value);

	/**
	 * Returns the value of the '<em><b>Message Exchange</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Exchange</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Exchange</em>' reference.
	 * @see #setMessageExchange(MessageExchange)
	 * @see org.eclipse.bpel.model.BPELPackage#getReceive_MessageExchange()
	 * @model required="true"
	 * @generated
	 */
	MessageExchange getMessageExchange();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Receive#getMessageExchange <em>Message Exchange</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exchange</em>' reference.
	 * @see #getMessageExchange()
	 * @generated
	 */
	void setMessageExchange(MessageExchange value);

} // Receive
