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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.util.ObjectValidator;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Model Object</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getObjectState <em>Object State</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getSourceText <em>Source Text</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getDefaultNamespace <em>Default Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getAdditionalNamespaces <em>Additional Namespaces</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getCurrentEsbVersion <em>Current Esb Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject()
 * @model abstract="true"
 * @generated
 */
public interface ModelObject extends EObject {
	/**
	 * Default synapse namespace.
	 */
	String DEFAULT_SYNAPSE_NAMESPACE_URI = "http://synapse.apache.org/ns/2010/04/configuration";

	/**
	 * Whether synapse namespace prefix should be used or not.
	 */
	Boolean USE_SYNAPSE_NAMESPACE_PREFIX = false;

	/**
	 * Default synapse namespace prefix.
	 */
	String DEFAULT_SYNAPSE_NAMESPACE_PREFIX = "syn";

	/**
	 * Soap 1.1 envelope namespace uri.
	 */
	String SOAP_1_1_ENVELOPE_NAMESPACE_URI = "http://schemas.xmlsoap.org/soap/envelope/";

	/**
	 * Soap 1.1 envelope namespace prefix.
	 */
	String SOAP_1_1_ENVELOPE_NAMESPACE_PREFIX = "soap11Env";

	/**
	 * Soap 1.2 envelope namespace uri.
	 */
	String SOAP_1_2_ENVELOPE_NAMESPACE_URI = "http://www.w3.org/2003/05/soap-envelope";

	/**
	 * Soap 1.2 envelope namespace prefix.
	 */
	String SOAP_1_2_ENVELOPE_NAMESPACE_PREFIX = "soap12Env";

	/**
	 * Policy namespace URI.
	 */
	String WS_POLICY_NAMESPACE_URI = "http://schemas.xmlsoap.org/ws/2004/09/policy";

	/**
	 * Policy namespace prefix.
	 */
	String WS_POLICY_NAMESAPCE_PREFIX = "wsp";

	/**
	 * Throttle namespace URI.
	 */
	String WSO2_THROTTLE_NAMESPACE_URI = "http://www.wso2.org/products/wso2commons/throttle";

	/**
	 * Throttle namespace prefix.
	 */
	String WSO2_THROTTLE_NAMESPACE_PREFIX = "throttle";

	/**
	 * WS security utility namespace URI.
	 */
	String WSS_UTILITY_NAMESPACE_URI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

	/**
	 * WS security utility namespace prefix.
	 */
	String WSS_UTILITY_NAMESPACE_PREFIX = "wsu";

	/**
	 * Default property value used for xpath expressions.
	 */
	String DEFAULT_XPATH_PROPERTY_VALUE = "/default/xpath";

	/**
	 * Default property value used for namespaced expressions.
	 */
	String DEFAULT_EXPRESSION_PROPERTY_VALUE = "/default/expression";

	/**
	 * Default property value used for string literals.
	 */
	String DEFAULT_STRING_PROPERTY_VALUE = "default";
	
	/**
	 * Default property value used for evaluator expression.
	 */
	String DEFAULT_EVALUATOR_EXPRESSION_VALUE = "<condition></condition>";

	/**
	 * Default property value used for registry keys.
	 */
	String DEFAULT_REGISTRY_KEY = "/default/key";

	/**
	 * Default property value used for sequence reference registry keys.
	 */
	String DEFAULT_SEQUENCE_REFERENCE_REGISTRY_KEY = "/default/sequence";

	/**
	 * Default property value used for endpoint reference registry keys.
	 */
	String DEFAULT_ENDPOINT_REFERENCE_REGISTRY_KEY = "/default/endpoint";

	/**
	 * Default property value used for resource reference registry keys.
	 */
	String DEFAULT_RESOURCE_REFERENCE_REGISTRY_KEY = "/default/resource";

	/**
	 * Returns the value of the '<em><b>Object State</b></em>' attribute.
	 * The default value is <code>"NORMAL"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.ModelObjectState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object State</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ModelObjectState
	 * @see #setObjectState(ModelObjectState)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject_ObjectState()
	 * @model default="NORMAL"
	 * @generated
	 */
	ModelObjectState getObjectState();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getObjectState <em>Object State</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Object State</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ModelObjectState
	 * @see #getObjectState()
	 * @generated
	 */
	void setObjectState(ModelObjectState value);

	/**
	 * Returns the value of the '<em><b>Source Text</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Text</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Text</em>' attribute.
	 * @see #setSourceText(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject_SourceText()
	 * @model
	 * @generated
	 */
	String getSourceText();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getSourceText <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Source Text</em>' attribute.
	 * @see #getSourceText()
	 * @generated
	 */
	void setSourceText(String value);

	/**
	 * Returns the value of the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Namespace</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Namespace</em>' reference.
	 * @see #setDefaultNamespace(Namespace)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject_DefaultNamespace()
	 * @model
	 * @generated
	 */
	Namespace getDefaultNamespace();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getDefaultNamespace <em>Default Namespace</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Default Namespace</em>' reference.
	 * @see #getDefaultNamespace()
	 * @generated
	 */
	void setDefaultNamespace(Namespace value);

	/**
	 * Returns the value of the '<em><b>Additional Namespaces</b></em>' reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.Namespace}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Additional Namespaces</em>' reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Namespaces</em>' reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject_AdditionalNamespaces()
	 * @model
	 * @generated
	 */
	EList<Namespace> getAdditionalNamespaces();

	/**
	 * Returns the value of the '<em><b>Current Esb Version</b></em>' attribute.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.EsbVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Esb Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Esb Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbVersion
	 * @see #setCurrentEsbVersion(EsbVersion)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject_CurrentEsbVersion()
	 * @model
	 * @generated
	 */
	EsbVersion getCurrentEsbVersion();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ModelObject#getCurrentEsbVersion <em>Current Esb Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Esb Version</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbVersion
	 * @see #getCurrentEsbVersion()
	 * @generated
	 */
	void setCurrentEsbVersion(EsbVersion value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' containment reference list.
	 * The list contents are of type {@link org.wso2.developerstudio.eclipse.esb.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' containment reference list.
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getModelObject_Comment()
	 * @model containment="true"
	 * @generated
	 */
	EList<Comment> getComment();

	/**
	 * Realize this model object using information contained within the
	 * specified {@link Element}.
	 * 
	 * @param self
	 *            serialized form of this model object.
	 * @throws Exception
	 *             if the given {@link Element} cannot be understood by this
	 *             model object.
	 */
	void load(Element self) throws Exception;

	/**
	 * Serialize this model object into the specified parent element.
	 * 
	 * @param parent
	 *            parent element.
	 * @return newly created child {@link Element} or parent itself if no child
	 *         element was created.
	 * @throws Exception
	 *             if an error occurs while serializing.
	 */
	Element save(Element parent) throws Exception;

	/**
	 * Queries whether this object has a source representation (for source
	 * editing).
	 * 
	 * @return true if this {@link ModelObject} can be represented in a source
	 *         editor, false otherwise.
	 */
	boolean hasSourceRepresentation();
	
	
	Map<String, ObjectValidator> validate();

	/**
	 * Allows access to the list of errors encountered while loading this model
	 * object. TODO: It's not good to allow direct access to this list, a better
	 * design must be deviced later.
	 * 
	 * @return list of errors encountered while loading this model object.
	 */
	List<Throwable> getLoadErrors();
} // ModelObject
