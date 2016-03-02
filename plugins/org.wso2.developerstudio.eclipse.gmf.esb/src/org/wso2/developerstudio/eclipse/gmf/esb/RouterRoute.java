/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Router Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute#getRouteExpression <em>Route Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute#getRoutePattern <em>Route Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterRoute()
 * @model
 * @generated
 */
public interface RouterRoute extends EsbNode {
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterRoute_BreakAfterRoute()
	 * @model
	 * @generated
	 */
	boolean isBreakAfterRoute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute#isBreakAfterRoute <em>Break After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break After Route</em>' attribute.
	 * @see #isBreakAfterRoute()
	 * @generated
	 */
	void setBreakAfterRoute(boolean value);

	/**
	 * Returns the value of the '<em><b>Route Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route Expression</em>' reference.
	 * @see #setRouteExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterRoute_RouteExpression()
	 * @model
	 * @generated
	 */
	NamespacedProperty getRouteExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute#getRouteExpression <em>Route Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route Expression</em>' reference.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getRouterRoute_RoutePattern()
	 * @model
	 * @generated
	 */
	String getRoutePattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.RouterRoute#getRoutePattern <em>Route Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route Pattern</em>' attribute.
	 * @see #getRoutePattern()
	 * @generated
	 */
	void setRoutePattern(String value);

} // RouterRoute
