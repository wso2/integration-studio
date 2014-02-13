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
package org.wso2.developerstudio.eclipse.esb;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Name Value Expression Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyValueType <em>Property Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyExpression <em>Property Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractNameValueExpressionProperty()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNameValueExpressionProperty extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * The default value is <code>"property_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyName()
	 * @model default="property_name"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Value Type</b></em>' attribute.
	 * The default value is <code>"VALUE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.PropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.PropertyValueType
	 * @see #setPropertyValueType(PropertyValueType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyValueType()
	 * @model default="VALUE"
	 * @generated
	 */
	PropertyValueType getPropertyValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyValueType <em>Property Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.PropertyValueType
	 * @see #getPropertyValueType()
	 * @generated
	 */
	void setPropertyValueType(PropertyValueType value);

	/**
	 * Returns the value of the '<em><b>Property Value</b></em>' attribute.
	 * The default value is <code>"property_value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value</em>' attribute.
	 * @see #setPropertyValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyValue()
	 * @model default="property_value"
	 * @generated
	 */
	String getPropertyValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyValue <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value</em>' attribute.
	 * @see #getPropertyValue()
	 * @generated
	 */
	void setPropertyValue(String value);

	/**
	 * Returns the value of the '<em><b>Property Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Expression</em>' containment reference.
	 * @see #setPropertyExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getPropertyExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty#getPropertyExpression <em>Property Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Expression</em>' containment reference.
	 * @see #getPropertyExpression()
	 * @generated
	 */
	void setPropertyExpression(NamespacedProperty value);

} // AbstractNameValueExpressionProperty
