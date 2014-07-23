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
 * $Id: Pick.java,v 1.3 2007/12/06 20:01:24 smoser Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Blocks and waits for the occurrence of one of a set of messages to arrive or for a time-out to go off. When the pick trigger occurs, the associated activity is executed and the pick completes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.Pick#getCreateInstance <em>Create Instance</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Pick#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.Pick#getAlarm <em>Alarm</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.BPELPackage#getPick()
 * @model
 * @generated
 */
public interface Pick extends Activity {
	/**
	 * Returns the value of the '<em><b>Create Instance</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Instance</em>' attribute.
	 * @see #isSetCreateInstance()
	 * @see #unsetCreateInstance()
	 * @see #setCreateInstance(Boolean)
	 * @see org.eclipse.bpel.model.BPELPackage#getPick_CreateInstance()
	 * @model default="false" unsettable="true"
	 * @generated
	 */
	Boolean getCreateInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.Pick#getCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Instance</em>' attribute.
	 * @see #isSetCreateInstance()
	 * @see #unsetCreateInstance()
	 * @see #getCreateInstance()
	 * @generated
	 */
	void setCreateInstance(Boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.model.Pick#getCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreateInstance()
	 * @see #getCreateInstance()
	 * @see #setCreateInstance(Boolean)
	 */
	void unsetCreateInstance();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.model.Pick#getCreateInstance <em>Create Instance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Instance</em>' attribute is set.
	 * @see #unsetCreateInstance()
	 * @see #getCreateInstance()
	 * @see #setCreateInstance(Boolean)
	 * @generated
	 */
	boolean isSetCreateInstance();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.OnMessage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getPick_Messages()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<OnMessage> getMessages();

	/**
	 * Returns the value of the '<em><b>Alarm</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.OnAlarm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alarm</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alarm</em>' containment reference list.
	 * @see org.eclipse.bpel.model.BPELPackage#getPick_Alarm()
	 * @model containment="true"
	 * @generated
	 */
	EList<OnAlarm> getAlarm();

} // Pick
