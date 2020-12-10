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
 * $Id: Activity.java,v 1.5 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a unit-of-work in a process. If the suppressJoinFailure is true, then the joinCondition determines if the activity is executed based on incoming links.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Activity#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Activity#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Activity#getTargets <em>Targets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Activity#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.bpel.model.BPELPackage#getActivity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Activity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Suppresses the join failure for this activity and all nested activities (unless overridden by some nested activity).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see #isSetSuppressJoinFailure()
	 * @see #unsetSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getActivity_SuppressJoinFailure()
	 * @model unsettable="true"
	 * @generated
	 */
	Boolean getSuppressJoinFailure();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Activity#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see #isSetSuppressJoinFailure()
	 * @see #unsetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 */
	void setSuppressJoinFailure(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Activity#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(Boolean)
	 */
	void unsetSuppressJoinFailure();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Activity#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Suppress Join Failure</em>' attribute is set.
	 * @see #unsetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(Boolean)
	 * @generated
	 */
	boolean isSetSuppressJoinFailure();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' containment reference.
	 * @see #setTargets(Targets)
	 * @see org.eclipse.bpel.model.BPELPackage#getActivity_Targets()
	 * @model containment="true"
	 * @generated
	 */
	Targets getTargets();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Activity#getTargets <em>Targets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Targets</em>' containment reference.
	 * @see #getTargets()
	 * @generated
	 */
	void setTargets(Targets value);

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' containment reference.
	 * @see #setSources(Sources)
	 * @see org.eclipse.bpel.model.BPELPackage#getActivity_Sources()
	 * @model containment="true"
	 * @generated
	 */
	Sources getSources();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Activity#getSources <em>Sources</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sources</em>' containment reference.
	 * @see #getSources()
	 * @generated
	 */
	void setSources(Sources value);

} // Activity
