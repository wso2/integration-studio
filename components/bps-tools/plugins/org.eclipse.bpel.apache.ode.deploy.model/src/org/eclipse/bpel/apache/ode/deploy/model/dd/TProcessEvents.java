/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TProcess Events</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getScopeEvents <em>Scope Events</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getGenerate <em>Generate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTProcessEvents()
 * @model extendedMetaData="name='tProcessEvents' kind='elementOnly'"
 * @generated
 */
public interface TProcessEvents extends TEnableEventList {
	/**
	 * Returns the value of the '<em><b>Scope Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope Events</em>' containment reference list.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTProcessEvents_ScopeEvents()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='scope-events' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TScopeEvents> getScopeEvents();

	/**
	 * Returns the value of the '<em><b>Generate</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * The literals are from the enumeration {@link org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate</em>' attribute.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
	 * @see #isSetGenerate()
	 * @see #unsetGenerate()
	 * @see #setGenerate(GenerateType)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTProcessEvents_Generate()
	 * @model default="all" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='generate'"
	 * @generated
	 */
	GenerateType getGenerate();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getGenerate <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate</em>' attribute.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
	 * @see #isSetGenerate()
	 * @see #unsetGenerate()
	 * @see #getGenerate()
	 * @generated
	 */
	void setGenerate(GenerateType value);

	/**
	 * Unsets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getGenerate <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGenerate()
	 * @see #getGenerate()
	 * @see #setGenerate(GenerateType)
	 * @generated
	 */
	void unsetGenerate();

	/**
	 * Returns whether the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getGenerate <em>Generate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Generate</em>' attribute is set.
	 * @see #unsetGenerate()
	 * @see #getGenerate()
	 * @see #setGenerate(GenerateType)
	 * @generated
	 */
	boolean isSetGenerate();

} // TProcessEvents
