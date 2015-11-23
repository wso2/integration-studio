/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Value Type Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty#getPropertyValue <em>Property Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNameValueTypeProperty()
 * @model
 * @generated
 */
public interface NameValueTypeProperty extends EsbNode {
	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNameValueTypeProperty_PropertyName()
	 * @model
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Value</em>' attribute.
	 * @see #setPropertyValue(String)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNameValueTypeProperty_PropertyValue()
	 * @model
	 * @generated
	 */
	String getPropertyValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty#getPropertyValue <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value</em>' attribute.
	 * @see #getPropertyValue()
	 * @generated
	 */
	void setPropertyValue(String value);

	/**
	 * Returns the value of the '<em><b>Property Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.TaskPropertyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.TaskPropertyType
	 * @see #setPropertyType(TaskPropertyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getNameValueTypeProperty_PropertyType()
	 * @model
	 * @generated
	 */
	TaskPropertyType getPropertyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.NameValueTypeProperty#getPropertyType <em>Property Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.TaskPropertyType
	 * @see #getPropertyType()
	 * @generated
	 */
	void setPropertyType(TaskPropertyType value);

} // NameValueTypeProperty
