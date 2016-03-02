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
 * A representation of the model object '<em><b>Router Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#isContinueAfterRouting <em>Continue After Routing</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getTargetOutputConnector <em>Target Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getRouterContainer <em>Router Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediator()
 * @model
 * @generated
 */
public interface RouterMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Continue After Routing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continue After Routing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continue After Routing</em>' attribute.
	 * @see #setContinueAfterRouting(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediator_ContinueAfterRouting()
	 * @model
	 * @generated
	 */
	boolean isContinueAfterRouting();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#isContinueAfterRouting <em>Continue After Routing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Continue After Routing</em>' attribute.
	 * @see #isContinueAfterRouting()
	 * @generated
	 */
	void setContinueAfterRouting(boolean value);

	/**
	 * Returns the value of the '<em><b>Target Output Connector</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Output Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Output Connector</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediator_TargetOutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	EList<RouterMediatorTargetOutputConnector> getTargetOutputConnector();

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(RouterMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RouterMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(RouterMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(RouterMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	RouterMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(RouterMediatorOutputConnector value);

	/**
	 * Returns the value of the '<em><b>Router Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Router Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Router Container</em>' containment reference.
	 * @see #setRouterContainer(RouterMediatorContainer)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterMediator_RouterContainer()
	 * @model containment="true"
	 * @generated
	 */
	RouterMediatorContainer getRouterContainer();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator#getRouterContainer <em>Router Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Router Container</em>' containment reference.
	 * @see #getRouterContainer()
	 * @generated
	 */
	void setRouterContainer(RouterMediatorContainer value);

} // RouterMediator
