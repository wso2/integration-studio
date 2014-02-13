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

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XQuery Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getTargetXPath <em>Target XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getScriptKeyType <em>Script Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getStaticScriptKey <em>Static Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getDynamicScriptKey <em>Dynamic Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getQueryKey <em>Query Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator()
 * @model
 * @generated
 */
public interface XQueryMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Target XPath</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target XPath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target XPath</em>' reference.
	 * @see #setTargetXPath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator_TargetXPath()
	 * @model
	 * @generated
	 */
	NamespacedProperty getTargetXPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getTargetXPath <em>Target XPath</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target XPath</em>' reference.
	 * @see #getTargetXPath()
	 * @generated
	 */
	void setTargetXPath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Script Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #setScriptKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator_ScriptKeyType()
	 * @model
	 * @generated
	 */
	KeyType getScriptKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getScriptKeyType <em>Script Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #getScriptKeyType()
	 * @generated
	 */
	void setScriptKeyType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Static Script Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Script Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Script Key</em>' reference.
	 * @see #setStaticScriptKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator_StaticScriptKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getStaticScriptKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getStaticScriptKey <em>Static Script Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Script Key</em>' reference.
	 * @see #getStaticScriptKey()
	 * @generated
	 */
	void setStaticScriptKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Dynamic Script Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Script Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Script Key</em>' reference.
	 * @see #setDynamicScriptKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator_DynamicScriptKey()
	 * @model
	 * @generated
	 */
	NamespacedProperty getDynamicScriptKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getDynamicScriptKey <em>Dynamic Script Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Script Key</em>' reference.
	 * @see #getDynamicScriptKey()
	 * @generated
	 */
	void setDynamicScriptKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Query Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Key</em>' reference.
	 * @see #setQueryKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator_QueryKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getQueryKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getQueryKey <em>Query Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Key</em>' reference.
	 * @see #getQueryKey()
	 * @generated
	 */
	void setQueryKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXQueryMediator_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<XQueryVariable> getVariables();

} // XQueryMediator
