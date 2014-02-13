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
 * A representation of the model object '<em><b>Abstract Location Key Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource#getLocation <em>Location</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractLocationKeyResource()
 * @model abstract="true"
 * @generated
 */
public interface AbstractLocationKeyResource extends ModelObject {
	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * The default value is <code>"default_location"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractLocationKeyResource_Location()
	 * @model default="default_location"
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference.
	 * @see #setKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getAbstractLocationKeyResource_Key()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource#getKey <em>Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' containment reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(RegistryKeyProperty value);

} // AbstractLocationKeyResource
