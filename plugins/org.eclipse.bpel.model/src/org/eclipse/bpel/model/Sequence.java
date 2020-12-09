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
 * $Id: Sequence.java,v 1.2 2007/08/01 21:02:30 mchmielewski Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines the structure of the process. Activities in a sequence are executed in order.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Sequence#getActivities <em>Activities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends Activity {
	/**
	 * Returns the value of the '<em><b>Activities</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getSequence_Activities()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Activity> getActivities();

} // Sequence
