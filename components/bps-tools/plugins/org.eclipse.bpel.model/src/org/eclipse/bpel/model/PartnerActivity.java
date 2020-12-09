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
 * $Id: PartnerActivity.java,v 1.2 2007/12/06 20:01:24 smoser Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.PartnerActivity#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerActivity#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerActivity#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.PartnerActivity#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getPartnerActivity()
 * @model
 * @generated
 */
public interface PartnerActivity extends Activity {
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
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerActivity_PartnerLink()
	 * @model required="true"
	 * @generated
	 */
	PartnerLink getPartnerLink();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerActivity#getPartnerLink <em>Partner Link</em>}' reference.
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
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerActivity_Correlations()
	 * @model containment="true"
	 * @generated
	 */
	Correlations getCorrelations();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerActivity#getCorrelations <em>Correlations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlations</em>' containment reference.
	 * @see #getCorrelations()
	 * @generated
	 */
	void setCorrelations(Correlations value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerActivity_PortType()
	 * @model required="true"
	 * @generated
	 */
	PortType getPortType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerActivity#getPortType <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' reference.
	 * @see #getPortType()
	 */
	void setPortType(PortType value);

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
	 * @see org.eclipse.bpel.model.BPELPackage#getPartnerActivity_Operation()
	 * @model required="true"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.PartnerActivity#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 */
	void setOperation(Operation value);

} // PartnerActivity
