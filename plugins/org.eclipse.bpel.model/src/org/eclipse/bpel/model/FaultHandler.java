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
 * $Id: FaultHandler.java,v 1.4 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines the activities that must be executed in response to faults resulting from the invocation of services in a process.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.FaultHandler#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.FaultHandler#getCatchAll <em>Catch All</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getFaultHandler()
 * @model
 * @generated
 */
public interface FaultHandler extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Catch</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Catch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getFaultHandler_Catch()
	 * @model containment="true"
	 * @generated
	 */
	EList<Catch> getCatch();

	/**
	 * Returns the value of the '<em><b>Catch All</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch All</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch All</em>' containment reference.
	 * @see #isSetCatchAll()
	 * @see #unsetCatchAll()
	 * @see #setCatchAll(CatchAll)
	 * @see org.eclipse.bpel.model.BPELPackage#getFaultHandler_CatchAll()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	CatchAll getCatchAll();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.FaultHandler#getCatchAll <em>Catch All</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch All</em>' containment reference.
	 * @see #isSetCatchAll()
	 * @see #unsetCatchAll()
	 * @see #getCatchAll()
	 * @generated
	 */
	void setCatchAll(CatchAll value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.FaultHandler#getCatchAll <em>Catch All</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCatchAll()
	 * @see #getCatchAll()
	 * @see #setCatchAll(CatchAll)
	 * @generated
	 */
	void unsetCatchAll();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.FaultHandler#getCatchAll <em>Catch All</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Catch All</em>' containment reference is set.
	 * @see #unsetCatchAll()
	 * @see #getCatchAll()
	 * @see #setCatchAll(CatchAll)
	 * @generated
	 */
	boolean isSetCatchAll();

} // FaultHandler
