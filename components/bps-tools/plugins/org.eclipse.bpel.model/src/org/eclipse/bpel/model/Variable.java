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
 * $Id: Variable.java,v 1.6 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.wst.wsdl.Message;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Variable#getMessageType <em>Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Variable#getXSDElement <em>XSD Element</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Variable#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Variable#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getVariable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Variable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 */
	void setName(String value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getVariable_MessageType()
	 * @model
	 * @generated
	 */
	Message getMessageType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Variable#getMessageType <em>Message Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Type</em>' reference.
	 * @see #getMessageType()
	 */
	void setMessageType(Message value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getVariable_XSDElement()
	 * @model
	 * @generated
	 */
	XSDElementDeclaration getXSDElement();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Variable#getXSDElement <em>XSD Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSD Element</em>' reference.
	 * @see #getXSDElement()
	 */
	void setXSDElement(XSDElementDeclaration value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(XSDTypeDefinition)
	 * @see org.eclipse.bpel.model.BPELPackage#getVariable_Type()
	 * @model
	 * @generated
	 */
	XSDTypeDefinition getType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Variable#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 */
	void setType(XSDTypeDefinition value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' containment reference.
	 * @see #setFrom(From)
	 * @see org.eclipse.bpel.model.BPELPackage#getVariable_From()
	 * @model containment="true"
	 * @generated
	 */
	From getFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Variable#getFrom <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' containment reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(From value);

} // Variable
