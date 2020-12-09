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
 * $Id: OnEvent.java,v 1.11 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.xsd.XSDElementDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getMessageType <em>Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getXSDElement <em>XSD Element</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnEvent#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent()
 * @model
 * @generated
 */
public interface OnEvent extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference.
	 * @see #setActivity(Activity)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_Activity()
	 * @model containment="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_Variable()
	 * @model containment="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Partner Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link</em>' reference.
	 * @see #setPartnerLink(PartnerLink)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_PartnerLink()
	 * @model required="true"
	 * @generated
	 */
	PartnerLink getPartnerLink();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getPartnerLink <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link</em>' reference.
	 * @see #getPartnerLink()
	 */
	void setPartnerLink(PartnerLink value);

	/**
	 * Returns the value of the '<em><b>Correlations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlations</em>' containment reference.
	 * @see #setCorrelations(Correlations)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_Correlations()
	 * @model containment="true"
	 * @generated
	 */
	Correlations getCorrelations();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getCorrelations <em>Correlations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlations</em>' containment reference.
	 * @see #getCorrelations()
	 * @generated
	 */
	void setCorrelations(Correlations value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_Operation()
	 * @model required="true"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' reference.
	 * @see #setPortType(PortType)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_PortType()
	 * @model required="true"
	 * @generated
	 */
	PortType getPortType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getPortType <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' reference.
	 * @see #getPortType()
	 */
	void setPortType(PortType value);

	/**
	 * Returns the value of the '<em><b>Message Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Type</em>' reference.
	 * @see #setMessageType(Message)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_MessageType()
	 * @model
	 * @generated
	 */
	Message getMessageType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getMessageType <em>Message Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Type</em>' reference.
	 * @see #getMessageType()
	 * @generated
	 */
	void setMessageType(Message value);

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=336003
	// "element" attribute was missing from original model
	/**
	 * Returns the value of the '<em><b>XSD Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSD Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSD Element</em>' reference.
	 * @see #setXSDElement(XSDElementDeclaration)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_XSDElement()
	 * @model
	 * @generated
	 */
	XSDElementDeclaration getXSDElement();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getXSDElement <em>XSD Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSD Element</em>' reference.
	 * @see #getXSDElement()
	 * @generated
	 */
	void setXSDElement(XSDElementDeclaration value);

	/**
	 * Returns the value of the '<em><b>Correlation Sets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Sets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Sets</em>' containment reference.
	 * @see #setCorrelationSets(CorrelationSets)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_CorrelationSets()
	 * @model containment="true"
	 * @generated
	 */
	CorrelationSets getCorrelationSets();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getCorrelationSets <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Sets</em>' containment reference.
	 * @see #getCorrelationSets()
	 * @generated
	 */
	void setCorrelationSets(CorrelationSets value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_FromParts()
	 * @model containment="true"
	 * @generated
	 */
	FromParts getFromParts();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getFromParts <em>From Parts</em>}' containment reference.
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
	 * @see org.eclipse.bpel.model.BPELPackage#getOnEvent_MessageExchange()
	 * @model required="true"
	 * @generated
	 */
	MessageExchange getMessageExchange();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnEvent#getMessageExchange <em>Message Exchange</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Exchange</em>' reference.
	 * @see #getMessageExchange()
	 * @generated
	 */
	void setMessageExchange(MessageExchange value);

} // OnEvent
