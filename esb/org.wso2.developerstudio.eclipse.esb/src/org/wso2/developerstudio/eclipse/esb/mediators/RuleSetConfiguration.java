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
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Set Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceCode <em>Source Code</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceKey <em>Source Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleSetConfiguration()
 * @model
 * @generated
 */
public interface RuleSetConfiguration extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * The default value is <code>"INLINE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType
	 * @see #setSourceType(RuleSourceType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleSetConfiguration_SourceType()
	 * @model default="INLINE"
	 * @generated
	 */
	RuleSourceType getSourceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(RuleSourceType value);

	/**
	 * Returns the value of the '<em><b>Source Code</b></em>' attribute.
	 * The default value is <code>"<code/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Code</em>' attribute.
	 * @see #setSourceCode(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleSetConfiguration_SourceCode()
	 * @model default="<code/>"
	 * @generated
	 */
	String getSourceCode();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceCode <em>Source Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Code</em>' attribute.
	 * @see #getSourceCode()
	 * @generated
	 */
	void setSourceCode(String value);

	/**
	 * Returns the value of the '<em><b>Source Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Key</em>' containment reference.
	 * @see #setSourceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleSetConfiguration_SourceKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getSourceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceKey <em>Source Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Key</em>' containment reference.
	 * @see #getSourceKey()
	 * @generated
	 */
	void setSourceKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetCreationProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getRuleSetConfiguration_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleSetCreationProperty> getProperties();

} // RuleSetConfiguration
