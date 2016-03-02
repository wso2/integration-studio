/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Router Target Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getRouteExpression <em>Route Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getRoutePattern <em>Route Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterTargetContainer()
 * @model
 * @generated
 */
public interface RouterTargetContainer extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Mediator Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediator Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #setMediatorFlow(MediatorFlow)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterTargetContainer_MediatorFlow()
	 * @model containment="true"
	 * @generated
	 */
	MediatorFlow getMediatorFlow();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
	 * @see #getMediatorFlow()
	 * @generated
	 */
	void setMediatorFlow(MediatorFlow value);

	/**
	 * Returns the value of the '<em><b>Break After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break After Route</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break After Route</em>' attribute.
	 * @see #setBreakAfterRoute(boolean)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterTargetContainer_BreakAfterRoute()
	 * @model
	 * @generated
	 */
	boolean isBreakAfterRoute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#isBreakAfterRoute <em>Break After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break After Route</em>' attribute.
	 * @see #isBreakAfterRoute()
	 * @generated
	 */
	void setBreakAfterRoute(boolean value);

	/**
	 * Returns the value of the '<em><b>Route Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route Expression</em>' containment reference.
	 * @see #setRouteExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterTargetContainer_RouteExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getRouteExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getRouteExpression <em>Route Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route Expression</em>' containment reference.
	 * @see #getRouteExpression()
	 * @generated
	 */
	void setRouteExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Route Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route Pattern</em>' attribute.
	 * @see #setRoutePattern(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterTargetContainer_RoutePattern()
	 * @model
	 * @generated
	 */
	String getRoutePattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getRoutePattern <em>Route Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route Pattern</em>' attribute.
	 * @see #getRoutePattern()
	 * @generated
	 */
	void setRoutePattern(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(RouterTarget)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterTargetContainer_Target()
	 * @model containment="true"
	 * @generated
	 */
	RouterTarget getTarget();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(RouterTarget value);

} // RouterTargetContainer
