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

import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getTemplateParameterType <em>Template Parameter Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterValue <em>Parameter Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterExpression <em>Parameter Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateParameter()
 * @model
 * @generated
 */
public interface CallTemplateParameter extends ModelObject {

	/**
	 * Returns the value of the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Name</em>' attribute.
	 * @see #setParameterName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateParameter_ParameterName()
	 * @model
	 * @generated
	 */
	String getParameterName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterName <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Name</em>' attribute.
	 * @see #getParameterName()
	 * @generated
	 */
	void setParameterName(String value);

	/**
	 * Returns the value of the '<em><b>Template Parameter Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Parameter Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Parameter Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
	 * @see #setTemplateParameterType(RuleOptionType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateParameter_TemplateParameterType()
	 * @model
	 * @generated
	 */
	RuleOptionType getTemplateParameterType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getTemplateParameterType <em>Template Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Parameter Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
	 * @see #getTemplateParameterType()
	 * @generated
	 */
	void setTemplateParameterType(RuleOptionType value);

	/**
	 * Returns the value of the '<em><b>Parameter Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Value</em>' attribute.
	 * @see #setParameterValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateParameter_ParameterValue()
	 * @model
	 * @generated
	 */
	String getParameterValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterValue <em>Parameter Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Value</em>' attribute.
	 * @see #getParameterValue()
	 * @generated
	 */
	void setParameterValue(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Expression</em>' reference.
	 * @see #setParameterExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCallTemplateParameter_ParameterExpression()
	 * @model
	 * @generated
	 */
	NamespacedProperty getParameterExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterExpression <em>Parameter Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Expression</em>' reference.
	 * @see #getParameterExpression()
	 * @generated
	 */
	void setParameterExpression(NamespacedProperty value);
} // CallTemplateParameter
