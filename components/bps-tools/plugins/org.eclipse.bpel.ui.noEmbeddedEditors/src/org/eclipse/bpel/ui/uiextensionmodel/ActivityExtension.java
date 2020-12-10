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
public interface ActivityExtension extends EObject {
	
	/**
	 * @model
	 */
	public int getX();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * @model
	 */
	public int getY();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * @model
	 */
	public int getWidth();
	

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * @model
	 */
	public int getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * @model
	 */
	public boolean isImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension#isImplicit <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit</em>' attribute.
	 * @see #isImplicit()
	 * @generated
	 */
	void setImplicit(boolean value);

}
