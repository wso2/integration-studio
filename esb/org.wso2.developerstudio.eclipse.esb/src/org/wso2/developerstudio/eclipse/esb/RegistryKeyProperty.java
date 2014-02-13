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

import java.util.Map;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registry Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getPrettyName <em>Pretty Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getKeyName <em>Key Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getKeyValue <em>Key Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getRegistryKeyProperty()
 * @model
 * @generated
 */
public interface RegistryKeyProperty extends ModelObject {
    /**
	 * Returns the value of the '<em><b>Pretty Name</b></em>' attribute.
	 * The default value is <code>"Registry Key"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Pretty Name</em>' attribute.
	 * @see #setPrettyName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getRegistryKeyProperty_PrettyName()
	 * @model default="Registry Key"
	 * @generated
	 */
    String getPrettyName();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getPrettyName <em>Pretty Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pretty Name</em>' attribute.
	 * @see #getPrettyName()
	 * @generated
	 */
    void setPrettyName(String value);

    /**
	 * Returns the value of the '<em><b>Key Name</b></em>' attribute.
	 * The default value is <code>"keyName"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Name</em>' attribute.
	 * @see #setKeyName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getRegistryKeyProperty_KeyName()
	 * @model default="keyName"
	 * @generated
	 */
    String getKeyName();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getKeyName <em>Key Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Name</em>' attribute.
	 * @see #getKeyName()
	 * @generated
	 */
    void setKeyName(String value);

    /**
	 * Returns the value of the '<em><b>Key Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Value</em>' attribute.
	 * @see #setKeyValue(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getRegistryKeyProperty_KeyValue()
	 * @model
	 * @generated
	 */
    String getKeyValue();

    /**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getKeyValue <em>Key Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Value</em>' attribute.
	 * @see #getKeyValue()
	 * @generated
	 */
    void setKeyValue(String value);

				/**
	 * Returns the value of the '<em><b>Filters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filters</em>' attribute.
	 * @see #setFilters(Map)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getRegistryKeyProperty_Filters()
	 * @model dataType="org.wso2.developerstudio.eclipse.esb.Map<?, ?>"
	 * @generated
	 */
	Map<?, ?> getFilters();

				/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty#getFilters <em>Filters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filters</em>' attribute.
	 * @see #getFilters()
	 * @generated
	 */
	void setFilters(Map<?, ?> value);

} // RegistryProperty
