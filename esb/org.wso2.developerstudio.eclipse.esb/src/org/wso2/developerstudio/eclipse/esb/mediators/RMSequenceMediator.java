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
 * A representation of the model object '<em><b>RM Sequence Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getRmSpecVersion <em>Rm Spec Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getCorrelationXpath <em>Correlation Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getLastMessageXpath <em>Last Message Xpath</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRMSequenceMediator()
 * @model
 * @generated
 */
public interface RMSequenceMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Rm Spec Version</b></em>' attribute.
	 * The default value is <code>"VERSION_1_0"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rm Spec Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rm Spec Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion
	 * @see #setRmSpecVersion(RMSpecVersion)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRMSequenceMediator_RmSpecVersion()
	 * @model default="VERSION_1_0"
	 * @generated
	 */
	RMSpecVersion getRmSpecVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getRmSpecVersion <em>Rm Spec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rm Spec Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion
	 * @see #getRmSpecVersion()
	 * @generated
	 */
	void setRmSpecVersion(RMSpecVersion value);

	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The default value is <code>"SINGLE_MESSAGE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType
	 * @see #setSequenceType(RMSequenceType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRMSequenceMediator_SequenceType()
	 * @model default="SINGLE_MESSAGE"
	 * @generated
	 */
	RMSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(RMSequenceType value);

	/**
	 * Returns the value of the '<em><b>Correlation Xpath</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Xpath</em>' reference.
	 * @see #setCorrelationXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRMSequenceMediator_CorrelationXpath()
	 * @model
	 * @generated
	 */
	NamespacedProperty getCorrelationXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getCorrelationXpath <em>Correlation Xpath</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlation Xpath</em>' reference.
	 * @see #getCorrelationXpath()
	 * @generated
	 */
	void setCorrelationXpath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Last Message Xpath</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Message Xpath</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Message Xpath</em>' reference.
	 * @see #setLastMessageXpath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRMSequenceMediator_LastMessageXpath()
	 * @model
	 * @generated
	 */
	NamespacedProperty getLastMessageXpath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getLastMessageXpath <em>Last Message Xpath</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Message Xpath</em>' reference.
	 * @see #getLastMessageXpath()
	 * @generated
	 */
	void setLastMessageXpath(NamespacedProperty value);

} // RMSequenceMediator
