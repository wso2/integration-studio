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
 * $Id: Throw.java,v 1.2 2007/12/06 20:01:24 smoser Exp $
 */
package org.eclipse.bpel.model;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throw</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Generates a fault from inside the business process. The FaultHandler may be a proxy for an application or process-specific fault instead of a BPEL FaultHandler
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Throw#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Throw#getFaultVariable <em>Fault Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getThrow()
 * @model
 * @generated
 */
public interface Throw extends Activity {
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
	 * @see org.eclipse.bpel.model.BPELPackage#getThrow_FaultName()
	 * @model dataType="org.eclipse.wst.wsdl.QName"
	 * @generated
	 */
	QName getFaultName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Throw#getFaultName <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Name</em>' attribute.
	 * @see #getFaultName()
	 */
	void setFaultName(QName value);

	/**
	 * Returns the value of the '<em><b>Fault Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Variable</em>' reference.
	 * @see #setFaultVariable(Variable)
	 * @see org.eclipse.bpel.model.BPELPackage#getThrow_FaultVariable()
	 * @model
	 * @generated
	 */
	Variable getFaultVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Throw#getFaultVariable <em>Fault Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Variable</em>' reference.
	 * @see #getFaultVariable()
	 */
	void setFaultVariable(Variable value);

} // Throw
