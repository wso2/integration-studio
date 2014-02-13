/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Router Mediator Target Output Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector#getToAddress <em>To Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediatorTargetOutputConnector()
 * @model
 * @generated
 */
public interface RouterMediatorTargetOutputConnector extends OutputConnector {
	/**
	 * Returns the value of the '<em><b>Soap Action</b></em>' attribute.
	 * The default value is <code>"soapAction"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soap Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soap Action</em>' attribute.
	 * @see #setSoapAction(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediatorTargetOutputConnector_SoapAction()
	 * @model default="soapAction"
	 * @generated
	 */
	String getSoapAction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector#getSoapAction <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soap Action</em>' attribute.
	 * @see #getSoapAction()
	 * @generated
	 */
	void setSoapAction(String value);

	/**
	 * Returns the value of the '<em><b>To Address</b></em>' attribute.
	 * The default value is <code>"toAddress"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Address</em>' attribute.
	 * @see #setToAddress(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediatorTargetOutputConnector_ToAddress()
	 * @model default="toAddress"
	 * @generated
	 */
	String getToAddress();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector#getToAddress <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Address</em>' attribute.
	 * @see #getToAddress()
	 * @generated
	 */
	void setToAddress(String value);

} // RouterMediatorTargetOutputConnector
