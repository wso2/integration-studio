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
package org.wso2.developerstudio.eclipse.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Value Type Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty#getPropertyType <em>Property Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty#getPropertyValue <em>Property Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getNameValueTypeProperty()
 * @model
 * @generated
 */
public interface NameValueTypeProperty extends ModelObject {
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
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getNameValueTypeProperty_PropertyName()
	 * @model required="true"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Property Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.TaskPropertyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.TaskPropertyType
	 * @see #setPropertyType(TaskPropertyType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getNameValueTypeProperty_PropertyType()
	 * @model required="true"
	 * @generated
	 */
	TaskPropertyType getPropertyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty#getPropertyType <em>Property Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.TaskPropertyType
	 * @see #getPropertyType()
	 * @generated
	 */
	void setPropertyType(TaskPropertyType value);

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
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getNameValueTypeProperty_PropertyValue()
	 * @model required="true"
	 * @generated
	 */
	String getPropertyValue();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty#getPropertyValue <em>Property Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Value</em>' attribute.
	 * @see #getPropertyValue()
	 * @generated
	 */
	void setPropertyValue(String value);

} // NameValueTypeProperty
