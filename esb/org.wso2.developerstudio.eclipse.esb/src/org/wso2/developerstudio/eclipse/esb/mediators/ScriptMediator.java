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
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptType <em>Script Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getMediateFunction <em>Mediate Function</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptKey <em>Script Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptBody <em>Script Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getScriptMediator()
 * @model
 * @generated
 */
public interface ScriptMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Script Type</b></em>' attribute.
	 * The default value is <code>"REGISTRY_REFERENCE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptType
	 * @see #setScriptType(ScriptType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getScriptMediator_ScriptType()
	 * @model default="REGISTRY_REFERENCE"
	 * @generated
	 */
	ScriptType getScriptType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptType <em>Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptType
	 * @see #getScriptType()
	 * @generated
	 */
	void setScriptType(ScriptType value);

	/**
	 * Returns the value of the '<em><b>Script Language</b></em>' attribute.
	 * The default value is <code>"JAVASCRIPT"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Language</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage
	 * @see #setScriptLanguage(ScriptLanguage)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getScriptMediator_ScriptLanguage()
	 * @model default="JAVASCRIPT"
	 * @generated
	 */
	ScriptLanguage getScriptLanguage();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptLanguage <em>Script Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Language</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage
	 * @see #getScriptLanguage()
	 * @generated
	 */
	void setScriptLanguage(ScriptLanguage value);

	/**
	 * Returns the value of the '<em><b>Mediate Function</b></em>' attribute.
	 * The default value is <code>"mediate"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mediate Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mediate Function</em>' attribute.
	 * @see #setMediateFunction(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getScriptMediator_MediateFunction()
	 * @model default="mediate"
	 * @generated
	 */
	String getMediateFunction();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getMediateFunction <em>Mediate Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mediate Function</em>' attribute.
	 * @see #getMediateFunction()
	 * @generated
	 */
	void setMediateFunction(String value);

	/**
	 * Returns the value of the '<em><b>Script Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Key</em>' containment reference.
	 * @see #setScriptKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getScriptMediator_ScriptKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getScriptKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptKey <em>Script Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Key</em>' containment reference.
	 * @see #getScriptKey()
	 * @generated
	 */
	void setScriptKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Script Body</b></em>' attribute.
	 * The default value is <code>"script_code"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Body</em>' attribute.
	 * @see #setScriptBody(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getScriptMediator_ScriptBody()
	 * @model default="script_code"
	 * @generated
	 */
	String getScriptBody();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptBody <em>Script Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Body</em>' attribute.
	 * @see #getScriptBody()
	 * @generated
	 */
	void setScriptBody(String value);

} // ScriptMediator
