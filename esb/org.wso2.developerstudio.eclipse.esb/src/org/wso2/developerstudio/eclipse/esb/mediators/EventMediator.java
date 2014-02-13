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
 * A representation of the model object '<em><b>Event Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getTopicType <em>Topic Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getStaticTopic <em>Static Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getDynamicTopic <em>Dynamic Topic</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventExpression <em>Event Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventSource <em>Event Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEventMediator()
 * @model
 * @generated
 */
public interface EventMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Topic Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topic Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #setTopicType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEventMediator_TopicType()
	 * @model
	 * @generated
	 */
	KeyType getTopicType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getTopicType <em>Topic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #getTopicType()
	 * @generated
	 */
	void setTopicType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Static Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Topic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Topic</em>' attribute.
	 * @see #setStaticTopic(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEventMediator_StaticTopic()
	 * @model
	 * @generated
	 */
	String getStaticTopic();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getStaticTopic <em>Static Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Topic</em>' attribute.
	 * @see #getStaticTopic()
	 * @generated
	 */
	void setStaticTopic(String value);

	/**
	 * Returns the value of the '<em><b>Dynamic Topic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Topic</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Topic</em>' reference.
	 * @see #setDynamicTopic(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEventMediator_DynamicTopic()
	 * @model
	 * @generated
	 */
	NamespacedProperty getDynamicTopic();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getDynamicTopic <em>Dynamic Topic</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Topic</em>' reference.
	 * @see #getDynamicTopic()
	 * @generated
	 */
	void setDynamicTopic(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Event Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Expression</em>' reference.
	 * @see #setEventExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEventMediator_EventExpression()
	 * @model
	 * @generated
	 */
	NamespacedProperty getEventExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventExpression <em>Event Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Expression</em>' reference.
	 * @see #getEventExpression()
	 * @generated
	 */
	void setEventExpression(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Event Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Source</em>' attribute.
	 * @see #setEventSource(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getEventMediator_EventSource()
	 * @model
	 * @generated
	 */
	String getEventSource();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventSource <em>Event Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Source</em>' attribute.
	 * @see #getEventSource()
	 * @generated
	 */
	void setEventSource(String value);

} // EventMediator
