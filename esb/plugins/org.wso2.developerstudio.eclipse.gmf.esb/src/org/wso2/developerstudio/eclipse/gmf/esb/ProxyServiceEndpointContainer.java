/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Service Endpoint Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceEndpointContainer#getEndpointFlow <em>Endpoint Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceEndpointContainer()
 * @model
 * @generated
 */
public interface ProxyServiceEndpointContainer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Endpoint Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Flow</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Flow</em>' containment reference.
	 * @see #setEndpointFlow(EndpointFlow)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceEndpointContainer_EndpointFlow()
	 * @model containment="true"
	 * @generated
	 */
    EndpointFlow getEndpointFlow();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceEndpointContainer#getEndpointFlow <em>Endpoint Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Flow</em>' containment reference.
	 * @see #getEndpointFlow()
	 * @generated
	 */
    void setEndpointFlow(EndpointFlow value);

} // ProxyServiceEndpointContainer
