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
 * $Id: OnAlarm.java,v 1.4 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>On Alarm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * When the alert fires, the activity is executed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.OnAlarm#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnAlarm#getFor <em>For</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnAlarm#getUntil <em>Until</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.OnAlarm#getRepeatEvery <em>Repeat Every</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getOnAlarm()
 * @model
 * @generated
 */
public interface OnAlarm extends BPELExtensibleElement {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference.
	 * @see #setActivity(Activity)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnAlarm_Activity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnAlarm#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>For</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For</em>' containment reference.
	 * @see #setFor(Expression)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnAlarm_For()
	 * @model containment="true"
	 * @generated
	 */
	Expression getFor();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnAlarm#getFor <em>For</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For</em>' containment reference.
	 * @see #getFor()
	 * @generated
	 */
	void setFor(Expression value);

	/**
	 * Returns the value of the '<em><b>Until</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Until</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Until</em>' containment reference.
	 * @see #setUntil(Expression)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnAlarm_Until()
	 * @model containment="true"
	 * @generated
	 */
	Expression getUntil();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnAlarm#getUntil <em>Until</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Until</em>' containment reference.
	 * @see #getUntil()
	 * @generated
	 */
	void setUntil(Expression value);

	/**
	 * Returns the value of the '<em><b>Repeat Every</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat Every</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat Every</em>' containment reference.
	 * @see #setRepeatEvery(Expression)
	 * @see org.eclipse.bpel.model.BPELPackage#getOnAlarm_RepeatEvery()
	 * @model containment="true"
	 * @generated
	 */
	Expression getRepeatEvery();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.OnAlarm#getRepeatEvery <em>Repeat Every</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat Every</em>' containment reference.
	 * @see #getRepeatEvery()
	 * @generated
	 */
	void setRepeatEvery(Expression value);

} // OnAlarm
