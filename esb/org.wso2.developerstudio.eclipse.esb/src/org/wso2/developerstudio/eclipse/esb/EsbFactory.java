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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EFactory;
import org.w3c.dom.Element;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage
 * @generated
 */
public interface EsbFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	EsbFactory eINSTANCE = org.wso2.developerstudio.eclipse.esb.impl.EsbFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Namespace</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Namespace</em>'.
	 * @generated
	 */
	Namespace createNamespace();

	/**
	 * Returns a new object of class '<em>Synapse Configuration</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Synapse Configuration</em>'.
	 * @generated
	 */
	SynapseConfiguration createSynapseConfiguration();

	/**
	 * Returns a new object of class '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description</em>'.
	 * @generated
	 */
	Description createDescription();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Mediator Sequence</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mediator Sequence</em>'.
	 * @generated
	 */
	MediatorSequence createMediatorSequence();

	/**
	 * Returns a new object of class '<em>Unknown Object</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Unknown Object</em>'.
	 * @generated
	 */
	UnknownObject createUnknownObject();

	/**
	 * Returns a new object of class '<em>Namespaced Property</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Namespaced Property</em>'.
	 * @generated
	 */
	NamespacedProperty createNamespacedProperty();

	/**
	 * Utility method for creating a copy of the given
	 * {@link NamespacedProperty}.
	 * 
	 * @param namespacedProperty
	 *            original {@link NamespacedProperty} instance.
	 * @return copy of the original {@link NamespacedProperty} instance.
	 */
	NamespacedProperty copyNamespacedProperty(
			NamespacedProperty namespacedProperty);

	/**
	 * Returns a new object of class '<em>Registry Key Property</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Registry Key Property</em>'.
	 * @generated
	 */
	RegistryKeyProperty createRegistryKeyProperty();

	/**
	 * Returns a new object of class '<em>Name Value Type Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Value Type Property</em>'.
	 * @generated
	 */
	NameValueTypeProperty createNameValueTypeProperty();

	/**
	 * Utility method for creating a copy of the given
	 * {@link RegistryKeyProperty}.
	 * 
	 * @param registryKeyProperty
	 *            original {@link RegistryKeyProperty} instance.
	 * @return copy of the original {@link RegistryKeyProperty}.
	 */
	RegistryKeyProperty copyRegistryKeyProperty(
			RegistryKeyProperty registryKeyProperty);

	/**
	 * Returns a new object of class '<em>Proxy Service</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Proxy Service</em>'.
	 * @generated
	 */
	ProxyService createProxyService();

	/**
	 * Returns a new object of class '<em>Proxy Wsdl Configuration</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Proxy Wsdl Configuration</em>'.
	 * @generated
	 */
	ProxyWsdlConfiguration createProxyWsdlConfiguration();

	/**
	 * Returns a new object of class '<em>Proxy Wsdl Resource</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Proxy Wsdl Resource</em>'.
	 * @generated
	 */
	ProxyWsdlResource createProxyWsdlResource();

	/**
	 * Returns a new object of class '<em>Proxy Service Parameter</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Proxy Service Parameter</em>'.
	 * @generated
	 */
	ProxyServiceParameter createProxyServiceParameter();

	/**
	 * Returns a new object of class '<em>Proxy Service Policy</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Proxy Service Policy</em>'.
	 * @generated
	 */
	ProxyServicePolicy createProxyServicePolicy();

	/**
	 * Returns a new object of class '<em>Proxy In Sequence Configuration</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy In Sequence Configuration</em>'.
	 * @generated
	 */
	ProxyInSequenceConfiguration createProxyInSequenceConfiguration();

	/**
	 * Returns a new object of class '<em>Proxy Endpoint Configuration</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Endpoint Configuration</em>'.
	 * @generated
	 */
	ProxyEndpointConfiguration createProxyEndpointConfiguration();

	/**
	 * Returns a new object of class '<em>Proxy Out Sequence Configuration</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Out Sequence Configuration</em>'.
	 * @generated
	 */
	ProxyOutSequenceConfiguration createProxyOutSequenceConfiguration();

	/**
	 * Returns a new object of class '<em>Proxy Fault Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Fault Sequence Configuration</em>'.
	 * @generated
	 */
	ProxyFaultSequenceConfiguration createProxyFaultSequenceConfiguration();

	/**
	 * Returns a new object of class '<em>Local Entry</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Entry</em>'.
	 * @generated
	 */
	LocalEntry createLocalEntry();


	/**
	 * Returns a new object of class '<em>Evaluator Expression Property</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluator Expression Property</em>'.
	 * @generated
	 */
	EvaluatorExpressionProperty createEvaluatorExpressionProperty();

	/**
	 * Returns a new object of class '<em>Task Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Implementation</em>'.
	 * @generated
	 */
	TaskImplementation createTaskImplementation();

	/**
	 * Returns a new object of class '<em>Task Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Property</em>'.
	 * @generated
	 */
	TaskProperty createTaskProperty();

	/**
	 * Returns a new object of class '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task</em>'.
	 * @generated
	 */
	Task createTask();

	/**
	 * Returns a new object of class '<em>Api In Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Api In Sequence Configuration</em>'.
	 * @generated
	 */
	ApiInSequenceConfiguration createApiInSequenceConfiguration();

	/**
	 * Returns a new object of class '<em>Api Out Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Api Out Sequence Configuration</em>'.
	 * @generated
	 */
	ApiOutSequenceConfiguration createApiOutSequenceConfiguration();

	/**
	 * Returns a new object of class '<em>Api Fault Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Api Fault Sequence Configuration</em>'.
	 * @generated
	 */
	ApiFaultSequenceConfiguration createApiFaultSequenceConfiguration();

	/**
	 * Returns a new object of class '<em>Api Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Api Resource</em>'.
	 * @generated
	 */
	ApiResource createApiResource();

	/**
	 * Returns a new object of class '<em>Synapse API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synapse API</em>'.
	 * @generated
	 */
	SynapseAPI createSynapseAPI();

	/**
	 * Utility method for creating a copy of the given
	 * {@link EvaluatorExpressionProperty}.
	 * 
	 * @param evaluatorExpressionProperty
	 *            original {@link EvaluatorExpressionProperty} instance.
	 * @return copy of the original {@link EvaluatorExpressionProperty}
	 *         instance.
	 */
	EvaluatorExpressionProperty copyevaluatorExpressionProperty(
			EvaluatorExpressionProperty evaluatorExpressionProperty);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EsbPackage getEsbPackage();

	/**
	 * Returns a new object of class '<em>Default End Point</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Default End Point</em>'.
	 * @generated
	 */
	DefaultEndPoint createDefaultEndPoint();

	/**
	 * Returns a new object of class '<em>Address End Point</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Address End Point</em>'.
	 * @generated
	 */
	AddressEndPoint createAddressEndPoint();

	/**
	 * Returns a new object of class '<em>Wsdl End Point</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Wsdl End Point</em>'.
	 * @generated
	 */
	WsdlEndPoint createWsdlEndPoint();

	/**
	 * Returns a new object of class '<em>Failover End Point</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Failover End Point</em>'.
	 * @generated
	 */
	FailoverEndPoint createFailoverEndPoint();

	/**
	 * Returns a new object of class '<em>Load Balance End Point</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Load Balance End Point</em>'.
	 * @generated
	 */
	LoadBalanceEndPoint createLoadBalanceEndPoint();

	/**
	 * Returns a new object of class '<em>Dynamic Load Balance End Point</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Load Balance End Point</em>'.
	 * @generated
	 */
	DynamicLoadBalanceEndPoint createDynamicLoadBalanceEndPoint();

	/**
	 * Returns a new object of class '<em>Dynamic Load Balance Property</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Load Balance Property</em>'.
	 * @generated
	 */
	DynamicLoadBalanceProperty createDynamicLoadBalanceProperty();

	/**
	 * Returns a new object of class '<em>XPath End Point Reference</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>XPath End Point Reference</em>'.
	 * @generated
	 */
	XPathEndPointReference createXPathEndPointReference();

	/**
	 * Returns a new object of class '<em>Registry Key End Point Reference</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Registry Key End Point Reference</em>'.
	 * @generated
	 */

	RegistryKeyEndPointReference createRegistryKeyEndPointReference();

	/**
	 * Convenience method for building a model objects from it's serialized
	 * {@link Element} form.
	 * 
	 * @param <T>
	 *            {@link ModelObject} sub type.
	 * @param element
	 *            {@link Element} which holds the serialized definition of a
	 *            {@link ModelObject}.
	 * @param clazz
	 *            specific {@link ModelObject} type expected as result.
	 * @param parent
	 *            {@link ModelObject} which is going to the the container of
	 *            newly created {@link ModelObject}.
	 * @return newly created {@link ModelObject} instance or null if an error is
	 *         encountered.
	 */
	<T extends ModelObject> T loadModelObject(Element element, Class<T> clazz,
			ModelObject parent);

	/**
	 * Utility method for serializing any {@link ModelObject} into an
	 * {@link Element}.
	 * 
	 * @param modelObj
	 *            {@link ModelObject} to be serialized.
	 * @return {@link Element} holding the serialized form of the specified
	 *         {@link ModelObject} or null if the given model object cannot be
	 *         serialized into a single element.
	 * @throws Exception
	 *             if an error occurs during serialization.
	 */
	Element serializeToElement(ModelObject modelObj) throws Exception;

	/**
	 * Serializes the specified {@link ModelObject} into a string.
	 * 
	 * @param modelObj
	 *            {@link ModelObject} to be serialized.
	 * @return string representation of the provided {@link ModelObject} or null
	 *         if the given model object should not be serialized into a string.
	 * @throws Exception
	 *             if an error occurs during serialization.
	 */
	String serializeToString(ModelObject modelObj) throws Exception;

	/**
	 * Utility method for creating an {@link UnknownObject} wrapping a given
	 * {@link Element}.
	 * 
	 * @param elem
	 *            {@link Element} to be wrapped with this {@link UnknownObject}.
	 * @return {@link UnknownObject} wrapping the specified {@link Element}.
	 */
	UnknownObject createUnknownObject(Element elem);

	/**
	 * Utility method for recursively extracting load errors of a
	 * {@link ModelObject} into {@link IStatus} objects.
	 * 
	 * @param rootObject
	 *            {@link ModelObject} to be analyzed.
	 * @return list of {@link IStatus} objects corresponding to load errors
	 *         encountered while de-serializing the specified
	 *         {@link ModelObject} and its children.
	 */
	List<IStatus> extractLoadErrors(ModelObject rootObject);

} // SequenceFactory
