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
 */
public interface ProcessExtension extends EObject {

	/**
	 * @model
	 */
	public boolean isSpecCompliant();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension#isSpecCompliant <em>Spec Compliant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spec Compliant</em>' attribute.
	 * @see #isSpecCompliant()
	 * @generated
	 */
	void setSpecCompliant(boolean value);

	/**
	 * @model
	 */
	public long getModificationStamp();
	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension#getModificationStamp <em>Modification Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modification Stamp</em>' attribute.
	 * @see #getModificationStamp()
	 * @generated
	 */
	void setModificationStamp(long value);

}
