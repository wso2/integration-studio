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
 * $Id: Wait.java,v 1.2 2007/08/01 21:02:31 mchmielewski Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Waits for a given time period or until a certain time is reached. Either expression for or until may be specified, but not both.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Wait#getFor <em>For</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Wait#getUntil <em>Until</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getWait()
 * @model
 * @generated
 */
public interface Wait extends Activity {
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
	 * @see org.eclipse.bpel.model.BPELPackage#getWait_For()
	 * @model containment="true"
	 * @generated
	 */
	Expression getFor();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Wait#getFor <em>For</em>}' containment reference.
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
	 * @see org.eclipse.bpel.model.BPELPackage#getWait_Until()
	 * @model containment="true"
	 * @generated
	 */
	Expression getUntil();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Wait#getUntil <em>Until</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Until</em>' containment reference.
	 * @see #getUntil()
	 * @generated
	 */
	void setUntil(Expression value);

} // Wait
