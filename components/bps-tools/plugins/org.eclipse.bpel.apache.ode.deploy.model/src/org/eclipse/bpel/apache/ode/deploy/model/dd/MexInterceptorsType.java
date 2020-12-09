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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mex Interceptors Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType#getMexInterceptor <em>Mex Interceptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getMexInterceptorsType()
 * @model extendedMetaData="name='mex-interceptors_._type' kind='elementOnly'"
 * @generated
 */
public interface MexInterceptorsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mex Interceptor</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mex Interceptor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mex Interceptor</em>' containment reference list.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getMexInterceptorsType_MexInterceptor()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='mex-interceptor' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TMexInterceptor> getMexInterceptor();

} // MexInterceptorsType
