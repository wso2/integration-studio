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
 * A representation of the model object '<em><b>Fast XSLT Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getFastXsltSchemaKeyType <em>Fast Xslt Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getFastXsltStaticSchemaKey <em>Fast Xslt Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getFastXsltDynamicSchemaKey <em>Fast Xslt Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getOutputConnector <em>Output Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFastXSLTMediator()
 * @model
 * @generated
 */
public interface FastXSLTMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Fast Xslt Schema Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fast Xslt Schema Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fast Xslt Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #setFastXsltSchemaKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFastXSLTMediator_FastXsltSchemaKeyType()
	 * @model
	 * @generated
	 */
	KeyType getFastXsltSchemaKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getFastXsltSchemaKeyType <em>Fast Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fast Xslt Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.KeyType
	 * @see #getFastXsltSchemaKeyType()
	 * @generated
	 */
	void setFastXsltSchemaKeyType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Fast Xslt Static Schema Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fast Xslt Static Schema Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fast Xslt Static Schema Key</em>' containment reference.
	 * @see #setFastXsltStaticSchemaKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFastXSLTMediator_FastXsltStaticSchemaKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getFastXsltStaticSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getFastXsltStaticSchemaKey <em>Fast Xslt Static Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fast Xslt Static Schema Key</em>' containment reference.
	 * @see #getFastXsltStaticSchemaKey()
	 * @generated
	 */
	void setFastXsltStaticSchemaKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Fast Xslt Dynamic Schema Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fast Xslt Dynamic Schema Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fast Xslt Dynamic Schema Key</em>' containment reference.
	 * @see #setFastXsltDynamicSchemaKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFastXSLTMediator_FastXsltDynamicSchemaKey()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getFastXsltDynamicSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getFastXsltDynamicSchemaKey <em>Fast Xslt Dynamic Schema Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fast Xslt Dynamic Schema Key</em>' containment reference.
	 * @see #getFastXsltDynamicSchemaKey()
	 * @generated
	 */
	void setFastXsltDynamicSchemaKey(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Connector</em>' containment reference.
	 * @see #setInputConnector(FastXSLTMediatorInputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFastXSLTMediator_InputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FastXSLTMediatorInputConnector getInputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getInputConnector <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Connector</em>' containment reference.
	 * @see #getInputConnector()
	 * @generated
	 */
	void setInputConnector(FastXSLTMediatorInputConnector value);

	/**
	 * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Connector</em>' containment reference.
	 * @see #setOutputConnector(FastXSLTMediatorOutputConnector)
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFastXSLTMediator_OutputConnector()
	 * @model containment="true"
	 * @generated
	 */
	FastXSLTMediatorOutputConnector getOutputConnector();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Connector</em>' containment reference.
	 * @see #getOutputConnector()
	 * @generated
	 */
	void setOutputConnector(FastXSLTMediatorOutputConnector value);

} // FastXSLTMediator
