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
 * $Id: Reply.java,v 1.6 2008/02/28 17:33:21 smoser Exp $
 */
package org.eclipse.bpel.model;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reply</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows a business process to send a message in reply to a message that was received through a Receive. The combination of a Receive and Reply forms a synchronous request-response operation on the WSDL portType for the process. The container for the replay activity provides the output message for the partner process invoke activity that invoked the corresponding receive activity.
 * 
 * FaultName specifies the name of a fault and must match some Catch fault name in the Scope or Process's FaultHandler.
 * 
 * A receive can have more than one corresponding reply, at most one without a faultName, and any mumber with different faults.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Reply#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Reply#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Reply#getToParts <em>To Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Reply#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getReply()
 * @model
 * @generated
 */
public interface Reply extends PartnerActivity, Activity {
	/**
	 * Returns the value of the '<em><b>Fault Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Name</em>' attribute.
	 * @see #setFaultName(QName)
	 * @see org.eclipse.bpel.model.BPELPackage#getReply_FaultName()
	 * @model dataType="org.eclipse.wst.wsdl.QName"
	 * @generated
	 */
	QName getFaultName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Reply#getFaultName <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Name</em>' attribute.
	 * @see #getFaultName()
	 */
	void setFaultName(QName value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getReply_Variable()
	 * @model
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Reply#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>To Parts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Parts</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Parts</em>' containment reference.
	 * @see #setToParts(ToParts)
	 * @see org.eclipse.bpel.model.BPELPackage#getReply_ToParts()
	 * @model containment="true"
	 * @generated
	 */
	ToParts getToParts();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Reply#getToParts <em>To Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Parts</em>' containment reference.
	 * @see #getToParts()
	 * @generated
	 */
	void setToParts(ToParts value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getReply_MessageExchange()
	 * @model required="true"
	 * @generated
	 */
	MessageExchange getMessageExchange();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Reply#getMessageExchange <em>Message Exchange</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exchange</em>' reference.
	 * @see #getMessageExchange()
	 * @generated
	 */
	void setMessageExchange(MessageExchange value);

} // Reply
