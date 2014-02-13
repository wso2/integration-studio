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
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getReferringSequenceType <em>Referring Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getDynamicReferenceKey <em>Dynamic Reference Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getStaticReferenceKey <em>Static Reference Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getSequenceKey <em>Sequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSequenceMediator()
 * @model
 * @generated
 */
public interface SequenceMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Referring Sequence Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referring Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #setReferringSequenceType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSequenceMediator_ReferringSequenceType()
	 * @model
	 * @generated
	 */
	KeyType getReferringSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getReferringSequenceType <em>Referring Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referring Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #getReferringSequenceType()
	 * @generated
	 */
	void setReferringSequenceType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Dynamic Reference Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Reference Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Reference Key</em>' reference.
	 * @see #setDynamicReferenceKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSequenceMediator_DynamicReferenceKey()
	 * @model
	 * @generated
	 */
	NamespacedProperty getDynamicReferenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getDynamicReferenceKey <em>Dynamic Reference Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Reference Key</em>' reference.
	 * @see #getDynamicReferenceKey()
	 * @generated
	 */
	void setDynamicReferenceKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Static Reference Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Reference Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Reference Key</em>' reference.
	 * @see #setStaticReferenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSequenceMediator_StaticReferenceKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getStaticReferenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getStaticReferenceKey <em>Static Reference Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Reference Key</em>' reference.
	 * @see #getStaticReferenceKey()
	 * @generated
	 */
	void setStaticReferenceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getSequenceMediator_SequenceKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getSequenceKey <em>Sequence Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

} // SequenceMediator
