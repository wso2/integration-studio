/**
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

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.Mediator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Router Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#isContinueAfterRoute <em>Continue After Route</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#getConditionalRouteBraches <em>Conditional Route Braches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getConditionalRouterMediator()
 * @model
 * @generated
 */
public interface ConditionalRouterMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Continue After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Continue After Route</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Continue After Route</em>' attribute.
	 * @see #setContinueAfterRoute(boolean)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getConditionalRouterMediator_ContinueAfterRoute()
	 * @model
	 * @generated
	 */
	boolean isContinueAfterRoute();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#isContinueAfterRoute <em>Continue After Route</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Continue After Route</em>' attribute.
	 * @see #isContinueAfterRoute()
	 * @generated
	 */
	void setContinueAfterRoute(boolean value);

	/**
	 * Returns the value of the '<em><b>Conditional Route Braches</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditional Route Braches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditional Route Braches</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getConditionalRouterMediator_ConditionalRouteBraches()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConditionalRouteBranch> getConditionalRouteBraches();

} // ConditionalRouterMediator
