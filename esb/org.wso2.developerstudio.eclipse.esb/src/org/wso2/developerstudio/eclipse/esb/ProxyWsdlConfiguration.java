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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Wsdl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlType <em>Wsdl Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlXML <em>Wsdl XML</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlURL <em>Wsdl URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlKey <em>Wsdl Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlResources <em>Wsdl Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyWsdlConfiguration()
 * @model
 * @generated
 */
public interface ProxyWsdlConfiguration extends ModelObject {

	/**
	 * Returns the value of the '<em><b>Wsdl Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyWsdlType
	 * @see #setWsdlType(ProxyWsdlType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyWsdlConfiguration_WsdlType()
	 * @model default="NONE"
	 * @generated
	 */
	ProxyWsdlType getWsdlType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlType <em>Wsdl Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyWsdlType
	 * @see #getWsdlType()
	 * @generated
	 */
	void setWsdlType(ProxyWsdlType value);

	/**
	 * Returns the value of the '<em><b>Wsdl XML</b></em>' attribute.
	 * The default value is <code>"<definitions/>"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl XML</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl XML</em>' attribute.
	 * @see #setWsdlXML(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyWsdlConfiguration_WsdlXML()
	 * @model default="<definitions/>"
	 * @generated
	 */
	String getWsdlXML();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlXML <em>Wsdl XML</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl XML</em>' attribute.
	 * @see #getWsdlXML()
	 * @generated
	 */
	void setWsdlXML(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl URL</b></em>' attribute.
	 * The default value is <code>"http://default/wsdl/url"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl URL</em>' attribute.
	 * @see #setWsdlURL(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyWsdlConfiguration_WsdlURL()
	 * @model default="http://default/wsdl/url"
	 * @generated
	 */
	String getWsdlURL();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlURL <em>Wsdl URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl URL</em>' attribute.
	 * @see #getWsdlURL()
	 * @generated
	 */
	void setWsdlURL(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Key</em>' containment reference.
	 * @see #setWsdlKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyWsdlConfiguration_WsdlKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getWsdlKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration#getWsdlKey <em>Wsdl Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Key</em>' containment reference.
	 * @see #getWsdlKey()
	 * @generated
	 */
	void setWsdlKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Wsdl Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Resources</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyWsdlConfiguration_WsdlResources()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProxyWsdlResource> getWsdlResources();
} // ProxyWsdl
