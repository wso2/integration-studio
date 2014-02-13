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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.eclipse.emf.common.util.EList;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XSLT Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getResources <em>Resources</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getSourceXPath <em>Source XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltKey <em>Xslt Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator()
 * @model
 * @generated
 */
public interface XSLTMediator extends Mediator {
	/**
	 * Returns the value of the '<em><b>Source XPath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source XPath</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source XPath</em>' containment reference.
	 * @see #setSourceXPath(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_SourceXPath()
	 * @model containment="true"
	 * @generated
	 */
	NamespacedProperty getSourceXPath();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getSourceXPath <em>Source XPath</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source XPath</em>' containment reference.
	 * @see #getSourceXPath()
	 * @generated
	 */
	void setSourceXPath(NamespacedProperty value);

	/**
	 * Returns the value of the '<em><b>Xslt Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Key</em>' reference.
	 * @see #setXsltKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_XsltKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getXsltKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltKey <em>Xslt Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Key</em>' reference.
	 * @see #getXsltKey()
	 * @generated
	 */
	void setXsltKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<XSLTProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<XSLTFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<XSLTResource> getResources();

	/**
	 * Returns the value of the '<em><b>Xslt Schema Key Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Schema Key Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #setXsltSchemaKeyType(KeyType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_XsltSchemaKeyType()
	 * @model
	 * @generated
	 */
	KeyType getXsltSchemaKeyType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Schema Key Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see #getXsltSchemaKeyType()
	 * @generated
	 */
	void setXsltSchemaKeyType(KeyType value);

	/**
	 * Returns the value of the '<em><b>Xslt Static Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Static Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Static Schema Key</em>' reference.
	 * @see #setXsltStaticSchemaKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_XsltStaticSchemaKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getXsltStaticSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Static Schema Key</em>' reference.
	 * @see #getXsltStaticSchemaKey()
	 * @generated
	 */
	void setXsltStaticSchemaKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Xslt Dynamic Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xslt Dynamic Schema Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xslt Dynamic Schema Key</em>' reference.
	 * @see #setXsltDynamicSchemaKey(NamespacedProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getXSLTMediator_XsltDynamicSchemaKey()
	 * @model
	 * @generated
	 */
	NamespacedProperty getXsltDynamicSchemaKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xslt Dynamic Schema Key</em>' reference.
	 * @see #getXsltDynamicSchemaKey()
	 * @generated
	 */
	void setXsltDynamicSchemaKey(NamespacedProperty value);

} // XSLTMediator
