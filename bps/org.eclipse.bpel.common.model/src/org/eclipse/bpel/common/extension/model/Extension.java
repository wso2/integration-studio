/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.extension.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.common.extension.model.Extension#getExtendedObject <em>Extended Object</em>}</li>
 *   <li>{@link org.eclipse.bpel.common.extension.model.Extension#getExtensionObject <em>Extension Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelPackage#getExtension()
 * @model 
 * @generated
 */
public interface Extension extends EObject {
	/**
	 * Returns the value of the '<em><b>Extended Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Object</em>' reference.
	 * @see #setExtendedObject(EObject)
	 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelPackage#getExtension_ExtendedObject()
	 * @model required="true"
	 * @generated
	 */
	EObject getExtendedObject();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.common.extension.model.Extension#getExtendedObject <em>Extended Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Object</em>' reference.
	 * @see #getExtendedObject()
	 * @generated
	 */
	void setExtendedObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Extension Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Object</em>' containment reference.
	 * @see #setExtensionObject(EObject)
	 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelPackage#getExtension_ExtensionObject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getExtensionObject();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.common.extension.model.Extension#getExtensionObject <em>Extension Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Object</em>' containment reference.
	 * @see #getExtensionObject()
	 * @generated
	 */
	void setExtensionObject(EObject value);

} // Extension
