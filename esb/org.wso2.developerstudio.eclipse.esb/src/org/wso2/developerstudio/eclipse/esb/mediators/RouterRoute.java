/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#isBreakAfterRoute <em>Break After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRouteExpression <em>Route Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRoutePattern <em>Route Pattern</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRouterRoute()
 * @model
 * @generated
 */
public interface RouterRoute extends ModelObject {
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRouterRoute_BreakAfterRoute()
	 * @model
	 * @generated
	 */
	boolean isBreakAfterRoute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#isBreakAfterRoute <em>Break After Route</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRouterRoute_RouteExpression()
	 * @model
	 * @generated
	 */
	NamespacedProperty getRouteExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRouteExpression <em>Route Expression</em>}' reference.
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
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRouterRoute_RoutePattern()
	 * @model
	 * @generated
	 */
	String getRoutePattern();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRoutePattern <em>Route Pattern</em>}' attribute.
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
	 * @see #setTarget(RouteTarget)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRouterRoute_Target()
	 * @model containment="true"
	 * @generated
	 */
	RouteTarget getTarget();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(RouteTarget value);

} // Route
