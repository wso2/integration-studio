/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Service Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer#getSequenceAndEndpointContainer <em>Sequence And Endpoint Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer#getFaultContainer <em>Fault Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceContainer()
 * @model
 * @generated
 */
public interface ProxyServiceContainer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Sequence And Endpoint Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence And Endpoint Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence And Endpoint Container</em>' containment reference.
	 * @see #setSequenceAndEndpointContainer(ProxyServiceSequenceAndEndpointContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceContainer_SequenceAndEndpointContainer()
	 * @model containment="true"
	 * @generated
	 */
	ProxyServiceSequenceAndEndpointContainer getSequenceAndEndpointContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer#getSequenceAndEndpointContainer <em>Sequence And Endpoint Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence And Endpoint Container</em>' containment reference.
	 * @see #getSequenceAndEndpointContainer()
	 * @generated
	 */
	void setSequenceAndEndpointContainer(ProxyServiceSequenceAndEndpointContainer value);

	/**
	 * Returns the value of the '<em><b>Fault Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Container</em>' containment reference.
	 * @see #setFaultContainer(ProxyServiceFaultContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyServiceContainer_FaultContainer()
	 * @model containment="true"
	 * @generated
	 */
	ProxyServiceFaultContainer getFaultContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer#getFaultContainer <em>Fault Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Container</em>' containment reference.
	 * @see #getFaultContainer()
	 * @generated
	 */
	void setFaultContainer(ProxyServiceFaultContainer value);

} // ProxyServiceContainer
