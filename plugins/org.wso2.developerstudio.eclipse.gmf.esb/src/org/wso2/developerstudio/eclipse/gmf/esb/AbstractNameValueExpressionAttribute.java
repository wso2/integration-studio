/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Name Value Expression Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeValueType <em>Attribute Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeValue <em>Attribute Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeType <em>Attribute Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeExpression <em>Attribute Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionAttribute()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNameValueExpressionAttribute extends EsbNode {

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * The default value is <code>"attribute_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionAttribute_AttributeName()
	 * @model default="attribute_name"
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Attribute Value Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType
	 * @see #setAttributeValueType(AttributeValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionAttribute_AttributeValueType()
	 * @model
	 * @generated
	 */
	AttributeValueType getAttributeValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeValueType <em>Attribute Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType
	 * @see #getAttributeValueType()
	 * @generated
	 */
	void setAttributeValueType(AttributeValueType value);

	/**
	 * Returns the value of the '<em><b>Attribute Value</b></em>' attribute.
	 * The default value is <code>"attribute_value"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Value</em>' attribute.
	 * @see #setAttributeValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionAttribute_AttributeValue()
	 * @model default="attribute_value"
	 * @generated
	 */
	String getAttributeValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeValue <em>Attribute Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Value</em>' attribute.
	 * @see #getAttributeValue()
	 * @generated
	 */
	void setAttributeValue(String value);

	/**
	 * Returns the value of the '<em><b>Attribute Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.AttributeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.AttributeType
	 * @see #setAttributeType(AttributeType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionAttribute_AttributeType()
	 * @model
	 * @generated
	 */
	AttributeType getAttributeType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeType <em>Attribute Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.AttributeType
	 * @see #getAttributeType()
	 * @generated
	 */
	void setAttributeType(AttributeType value);

	/**
	 * Returns the value of the '<em><b>Attribute Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Expression</em>' containment reference.
	 * @see #setAttributeExpression(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionAttribute_AttributeExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getAttributeExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionAttribute#getAttributeExpression <em>Attribute Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Expression</em>' containment reference.
	 * @see #getAttributeExpression()
	 * @generated
	 */
	void setAttributeExpression(NamespacedProperty value);
} // AbstractNameValueExpressionAttribute
