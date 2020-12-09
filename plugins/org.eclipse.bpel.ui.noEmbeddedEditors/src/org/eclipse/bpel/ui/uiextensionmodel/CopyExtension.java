/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.uiextensionmodel;


import org.eclipse.emf.ecore.EObject;

/**
 * @model
 * @transient
 */
public interface CopyExtension extends EObject {

	/**
	 * @model
	 * @transient
	 */
	public int getFromType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.CopyExtension#getFromType <em>From Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Type</em>' attribute.
	 * @see #getFromType()
	 * @generated
	 */
	void setFromType(int value);

	/**
	 * @model
	 * @transient
	 */
	public int getToType();
	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.CopyExtension#getToType <em>To Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Type</em>' attribute.
	 * @see #getToType()
	 * @generated
	 */
	void setToType(int value);

}
