/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Name Value Expression Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyValueType <em>Property Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyExpression <em>Property Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionProperty()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNameValueExpressionProperty extends EsbNode {
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyName()
	 * @model default="property_name"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Value Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType
	 * @see #setPropertyValueType(PropertyValueType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyValueType()
	 * @model
	 * @generated
	 */
	PropertyValueType getPropertyValueType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyValueType <em>Property Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyValue()
	 * @model default="property_value"
	 * @generated
	 */
	String getPropertyValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyValue <em>Property Value</em>}' attribute.
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueExpressionProperty_PropertyExpression()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getPropertyExpression();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueExpressionProperty#getPropertyExpression <em>Property Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Expression</em>' containment reference.
	 * @see #getPropertyExpression()
	 * @generated
	 */
	void setPropertyExpression(NamespacedProperty value);

} // AbstractNameValueExpressionProperty
