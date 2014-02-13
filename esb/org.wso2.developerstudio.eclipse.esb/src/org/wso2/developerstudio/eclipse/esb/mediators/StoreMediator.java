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

import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Store Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getMessageStore <em>Message Store</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getOnStoreSequence <em>On Store Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getStoreMediator()
 * @model
 * @generated
 */
public interface StoreMediator extends Mediator {

	/**
	 * Returns the value of the '<em><b>Message Store</b></em>' attribute.
	 * The default value is <code>"<test/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Store</em>' attribute.
	 * @see #setMessageStore(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getStoreMediator_MessageStore()
	 * @model default="<test/>"
	 * @generated
	 */
	String getMessageStore();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getMessageStore <em>Message Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Store</em>' attribute.
	 * @see #getMessageStore()
	 * @generated
	 */
	void setMessageStore(String value);

	/**
	 * Returns the value of the '<em><b>On Store Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Store Sequence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Store Sequence</em>' reference.
	 * @see #setOnStoreSequence(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getStoreMediator_OnStoreSequence()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getOnStoreSequence();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getOnStoreSequence <em>On Store Sequence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Store Sequence</em>' reference.
	 * @see #getOnStoreSequence()
	 * @generated
	 */
	void setOnStoreSequence(RegistryKeyProperty value);
} // StoreMediator
