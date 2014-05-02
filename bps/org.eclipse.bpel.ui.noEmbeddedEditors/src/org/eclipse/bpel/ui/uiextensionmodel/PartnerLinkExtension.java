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
public interface PartnerLinkExtension extends EObject {

	/**
	 * @model
	 */
	public static final int KIND_UNKNOWN = 0;
	/**
	 * @model
	 */
	public static final int KIND_INBOUND = 1;
	/**
	 * @model
	 */
	public static final int KIND_OUTBOUND = 2;
	/**
	 * @model
	 */
	public static final int KIND_ADVANCED = 3;

	/**
	 * @model transient="true"
	 */
	public int getPartnerKind();
	/**
	 * Sets the value of the '{@link org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension#getPartnerKind <em>Partner Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Kind</em>' attribute.
	 * @see #getPartnerKind()
	 * @generated
	 */
	void setPartnerKind(int value);

}
