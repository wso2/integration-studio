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

import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregate Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getAggregateID <em>Aggregate ID</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCorrelationExpression <em>Correlation Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionTimeout <em>Completion Timeout</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMinMessages <em>Completion Min Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMaxMessages <em>Completion Max Messages</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getOnCompleteBranch <em>On Complete Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator()
 * @model
 * @generated
 */
public interface AggregateMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Completion Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Timeout</em>' attribute.
	 * @see #setCompletionTimeout(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator_CompletionTimeout()
	 * @model
	 * @generated
	 */
	int getCompletionTimeout();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionTimeout <em>Completion Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Timeout</em>' attribute.
	 * @see #getCompletionTimeout()
	 * @generated
	 */
	void setCompletionTimeout(int value);

	/**
	 * Returns the value of the '<em><b>Completion Min Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Min Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Min Messages</em>' attribute.
	 * @see #setCompletionMinMessages(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator_CompletionMinMessages()
	 * @model
	 * @generated
	 */
	int getCompletionMinMessages();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMinMessages <em>Completion Min Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Min Messages</em>' attribute.
	 * @see #getCompletionMinMessages()
	 * @generated
	 */
	void setCompletionMinMessages(int value);

	/**
	 * Returns the value of the '<em><b>Completion Max Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Max Messages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Max Messages</em>' attribute.
	 * @see #setCompletionMaxMessages(int)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator_CompletionMaxMessages()
	 * @model
	 * @generated
	 */
	int getCompletionMaxMessages();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMaxMessages <em>Completion Max Messages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Max Messages</em>' attribute.
	 * @see #getCompletionMaxMessages()
	 * @generated
	 */
	void setCompletionMaxMessages(int value);

	/**
	 * Returns the value of the '<em><b>Correlation Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Expression</em>' containment reference.
	 * @see #setCorrelationExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator_CorrelationExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getCorrelationExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCorrelationExpression <em>Correlation Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Expression</em>' containment reference.
	 * @see #getCorrelationExpression()
	 * @generated
	 */
	void setCorrelationExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>On Complete Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Complete Branch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Complete Branch</em>' containment reference.
	 * @see #setOnCompleteBranch(AggregateOnCompleteBranch)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator_OnCompleteBranch()
	 * @model containment="true"
	 * @generated
	 */
	AggregateOnCompleteBranch getOnCompleteBranch();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getOnCompleteBranch <em>On Complete Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Complete Branch</em>' containment reference.
	 * @see #getOnCompleteBranch()
	 * @generated
	 */
	void setOnCompleteBranch(AggregateOnCompleteBranch value);

	/**
	 * Returns the value of the '<em><b>Aggregate ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregate ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregate ID</em>' attribute.
	 * @see #setAggregateID(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getAggregateMediator_AggregateID()
	 * @model
	 * @generated
	 */
	String getAggregateID();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getAggregateID <em>Aggregate ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregate ID</em>' attribute.
	 * @see #getAggregateID()
	 * @generated
	 */
	void setAggregateID(String value);

} // AggregateMediator
