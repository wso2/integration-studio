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
 * $Id: Targets.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Targets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Targets#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Targets#getJoinCondition <em>Join Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getTargets()
 * @model
 * @generated
 */
public interface Targets extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Target}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getTargets_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Target> getChildren();

	/**
	 * Returns the value of the '<em><b>Join Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Condition</em>' containment reference.
	 * @see #setJoinCondition(Condition)
	 * @see org.eclipse.bpel.model.BPELPackage#getTargets_JoinCondition()
	 * @model containment="true"
	 * @generated
	 */
	Condition getJoinCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Targets#getJoinCondition <em>Join Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Condition</em>' containment reference.
	 * @see #getJoinCondition()
	 * @generated
	 */
	void setJoinCondition(Condition value);

} // Targets
