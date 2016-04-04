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
 * $Id: Catch.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import javax.xml.namespace.QName;

import org.eclipse.wst.wsdl.Message;
import org.eclipse.xsd.XSDElementDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Catch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Catch#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Catch#getFaultVariable <em>Fault Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Catch#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Catch#getFaultMessageType <em>Fault Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Catch#getFaultElement <em>Fault Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getCatch()
 * @model
 * @generated
 */
public interface Catch extends BPELExtensibleElement {
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
	 * @see org.eclipse.bpel.model.BPELPackage#getCatch_FaultName()
	 * @model dataType="org.eclipse.wst.wsdl.QName"
	 * @generated
	 */
	QName getFaultName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Catch#getFaultName <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Name</em>' attribute.
	 * @see #getFaultName()
	 */
	void setFaultName(QName value);

	/**
	 * Returns the value of the '<em><b>Fault Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Variable</em>' containment reference.
	 * @see #setFaultVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getCatch_FaultVariable()
	 * @model containment="true"
	 * @generated
	 */
	Variable getFaultVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Catch#getFaultVariable <em>Fault Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Variable</em>' containment reference.
	 * @see #getFaultVariable()
	 * @generated
	 */
	void setFaultVariable(Variable value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getCatch_Activity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Catch#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Fault Message Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Message Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Message Type</em>' reference.
	 * @see #setFaultMessageType(Message)
	 * @see org.eclipse.bpel.model.BPELPackage#getCatch_FaultMessageType()
	 * @model
	 * @generated
	 */
	Message getFaultMessageType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Catch#getFaultMessageType <em>Fault Message Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Message Type</em>' reference.
	 * @see #getFaultMessageType()
	 */
	void setFaultMessageType(Message value);

	/**
	 * Returns the value of the '<em><b>Fault Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Element</em>' reference.
	 * @see #setFaultElement(XSDElementDeclaration)
	 * @see org.eclipse.bpel.model.BPELPackage#getCatch_FaultElement()
	 * @model
	 * @generated
	 */
	XSDElementDeclaration getFaultElement();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Catch#getFaultElement <em>Fault Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Element</em>' reference.
	 * @see #getFaultElement()
	 */
	void setFaultElement(XSDElementDeclaration value);

} // Catch
