/**
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 */
package org.eclipse.bpel.apache.ode.deploy.model.dd;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TEnd Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getXmlns <em>Xmlns</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getEndpointReference <em>Endpoint Reference</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getServiceDescriptionReference <em>Service Description Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTEndPoint()
 * @model extendedMetaData="name='tEndPoint' kind='elementOnly'"
 * @generated
 */
public interface TEndPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Xmlns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmlns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmlns</em>' attribute.
	 * @see #setXmlns(String)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTEndPoint_Xmlns()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='xmlns'"
	 * @generated
	 */
	String getXmlns();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getXmlns <em>Xmlns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmlns</em>' attribute.
	 * @see #getXmlns()
	 * @generated
	 */
	void setXmlns(String value);

	/**
	 * Returns the value of the '<em><b>Endpoint Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Reference</em>' attribute.
	 * @see #setEndpointReference(String)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTEndPoint_EndpointReference()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='endpointReference'"
	 * @generated
	 */
	String getEndpointReference();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getEndpointReference <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Reference</em>' attribute.
	 * @see #getEndpointReference()
	 * @generated
	 */
	void setEndpointReference(String value);

	/**
	 * Returns the value of the '<em><b>Service Description Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Description Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Description Reference</em>' attribute.
	 * @see #setServiceDescriptionReference(String)
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#getTEndPoint_ServiceDescriptionReference()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serviceDescriptionReference'"
	 * @generated
	 */
	String getServiceDescriptionReference();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getServiceDescriptionReference <em>Service Description Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Description Reference</em>' attribute.
	 * @see #getServiceDescriptionReference()
	 * @generated
	 */
	void setServiceDescriptionReference(String value);

} // TEndPoint
