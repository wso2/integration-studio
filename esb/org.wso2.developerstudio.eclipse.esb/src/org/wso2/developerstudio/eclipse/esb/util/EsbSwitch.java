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
package org.wso2.developerstudio.eclipse.esb.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.esb.*;

/**
 * <!-- begin-user-doc -->
 * The <b>SwitchMediator</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage
 * @generated
 */
public class EsbSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EsbPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSwitch() {
		if (modelPackage == null) {
			modelPackage = EsbPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EsbPackage.MODEL_OBJECT: {
				ModelObject modelObject = (ModelObject)theEObject;
				T result = caseModelObject(modelObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAMESPACE: {
				Namespace namespace = (Namespace)theEObject;
				T result = caseNamespace(namespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SYNAPSE_CONFIGURATION: {
				SynapseConfiguration synapseConfiguration = (SynapseConfiguration)theEObject;
				T result = caseSynapseConfiguration(synapseConfiguration);
				if (result == null) result = caseModelObject(synapseConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CONFIGURATION_ELEMENT: {
				ConfigurationElement configurationElement = (ConfigurationElement)theEObject;
				T result = caseConfigurationElement(configurationElement);
				if (result == null) result = caseModelObject(configurationElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEDIATOR: {
				Mediator mediator = (Mediator)theEObject;
				T result = caseMediator(mediator);
				if (result == null) result = caseConfigurationElement(mediator);
				if (result == null) result = caseModelObject(mediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DESCRIPTION: {
				Description description = (Description)theEObject;
				T result = caseDescription(description);
				if (result == null) result = caseModelObject(description);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.END_POINT_REFERENCE: {
				EndPointReference endPointReference = (EndPointReference)theEObject;
				T result = caseEndPointReference(endPointReference);
				if (result == null) result = caseModelObject(endPointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.END_POINT: {
				EndPoint endPoint = (EndPoint)theEObject;
				T result = caseEndPoint(endPoint);
				if (result == null) result = caseConfigurationElement(endPoint);
				if (result == null) result = caseModelObject(endPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.UNKNOWN_OBJECT: {
				UnknownObject unknownObject = (UnknownObject)theEObject;
				T result = caseUnknownObject(unknownObject);
				if (result == null) result = caseEndPoint(unknownObject);
				if (result == null) result = caseMediator(unknownObject);
				if (result == null) result = caseConfigurationElement(unknownObject);
				if (result == null) result = caseModelObject(unknownObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEDIATOR_SEQUENCE: {
				MediatorSequence mediatorSequence = (MediatorSequence)theEObject;
				T result = caseMediatorSequence(mediatorSequence);
				if (result == null) result = caseConfigurationElement(mediatorSequence);
				if (result == null) result = caseModelObject(mediatorSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEDIATOR_BRANCH: {
				MediatorBranch mediatorBranch = (MediatorBranch)theEObject;
				T result = caseMediatorBranch(mediatorBranch);
				if (result == null) result = caseModelObject(mediatorBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PARENT_MEDIATOR: {
				ParentMediator parentMediator = (ParentMediator)theEObject;
				T result = caseParentMediator(parentMediator);
				if (result == null) result = caseMediator(parentMediator);
				if (result == null) result = caseConfigurationElement(parentMediator);
				if (result == null) result = caseModelObject(parentMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAMESPACED_PROPERTY: {
				NamespacedProperty namespacedProperty = (NamespacedProperty)theEObject;
				T result = caseNamespacedProperty(namespacedProperty);
				if (result == null) result = caseModelObject(namespacedProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.REGISTRY_KEY_PROPERTY: {
				RegistryKeyProperty registryKeyProperty = (RegistryKeyProperty)theEObject;
				T result = caseRegistryKeyProperty(registryKeyProperty);
				if (result == null) result = caseModelObject(registryKeyProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY: {
				AbstractNameValueProperty abstractNameValueProperty = (AbstractNameValueProperty)theEObject;
				T result = caseAbstractNameValueProperty(abstractNameValueProperty);
				if (result == null) result = caseModelObject(abstractNameValueProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY: {
				AbstractNameValueExpressionProperty abstractNameValueExpressionProperty = (AbstractNameValueExpressionProperty)theEObject;
				T result = caseAbstractNameValueExpressionProperty(abstractNameValueExpressionProperty);
				if (result == null) result = caseModelObject(abstractNameValueExpressionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAME_VALUE_TYPE_PROPERTY: {
				NameValueTypeProperty nameValueTypeProperty = (NameValueTypeProperty)theEObject;
				T result = caseNameValueTypeProperty(nameValueTypeProperty);
				if (result == null) result = caseModelObject(nameValueTypeProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE: {
				AbstractBooleanFeature abstractBooleanFeature = (AbstractBooleanFeature)theEObject;
				T result = caseAbstractBooleanFeature(abstractBooleanFeature);
				if (result == null) result = caseModelObject(abstractBooleanFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE: {
				AbstractLocationKeyResource abstractLocationKeyResource = (AbstractLocationKeyResource)theEObject;
				T result = caseAbstractLocationKeyResource(abstractLocationKeyResource);
				if (result == null) result = caseModelObject(abstractLocationKeyResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_COMMON_TARGET: {
				AbstractCommonTarget abstractCommonTarget = (AbstractCommonTarget)theEObject;
				T result = caseAbstractCommonTarget(abstractCommonTarget);
				if (result == null) result = caseModelObject(abstractCommonTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_END_POINT: {
				AbstractEndPoint abstractEndPoint = (AbstractEndPoint)theEObject;
				T result = caseAbstractEndPoint(abstractEndPoint);
				if (result == null) result = caseEndPoint(abstractEndPoint);
				if (result == null) result = caseConfigurationElement(abstractEndPoint);
				if (result == null) result = caseModelObject(abstractEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_DEFAULT_END_POINT: {
				AbstractDefaultEndPoint abstractDefaultEndPoint = (AbstractDefaultEndPoint)theEObject;
				T result = caseAbstractDefaultEndPoint(abstractDefaultEndPoint);
				if (result == null) result = caseAbstractEndPoint(abstractDefaultEndPoint);
				if (result == null) result = caseEndPoint(abstractDefaultEndPoint);
				if (result == null) result = caseConfigurationElement(abstractDefaultEndPoint);
				if (result == null) result = caseModelObject(abstractDefaultEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DEFAULT_END_POINT: {
				DefaultEndPoint defaultEndPoint = (DefaultEndPoint)theEObject;
				T result = caseDefaultEndPoint(defaultEndPoint);
				if (result == null) result = caseAbstractDefaultEndPoint(defaultEndPoint);
				if (result == null) result = caseAbstractEndPoint(defaultEndPoint);
				if (result == null) result = caseEndPoint(defaultEndPoint);
				if (result == null) result = caseConfigurationElement(defaultEndPoint);
				if (result == null) result = caseModelObject(defaultEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESS_END_POINT: {
				AddressEndPoint addressEndPoint = (AddressEndPoint)theEObject;
				T result = caseAddressEndPoint(addressEndPoint);
				if (result == null) result = caseAbstractDefaultEndPoint(addressEndPoint);
				if (result == null) result = caseAbstractEndPoint(addressEndPoint);
				if (result == null) result = caseEndPoint(addressEndPoint);
				if (result == null) result = caseConfigurationElement(addressEndPoint);
				if (result == null) result = caseModelObject(addressEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.WSDL_END_POINT: {
				WsdlEndPoint wsdlEndPoint = (WsdlEndPoint)theEObject;
				T result = caseWsdlEndPoint(wsdlEndPoint);
				if (result == null) result = caseAbstractEndPoint(wsdlEndPoint);
				if (result == null) result = caseEndPoint(wsdlEndPoint);
				if (result == null) result = caseConfigurationElement(wsdlEndPoint);
				if (result == null) result = caseModelObject(wsdlEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PARENT_END_POINT: {
				ParentEndPoint parentEndPoint = (ParentEndPoint)theEObject;
				T result = caseParentEndPoint(parentEndPoint);
				if (result == null) result = caseEndPoint(parentEndPoint);
				if (result == null) result = caseConfigurationElement(parentEndPoint);
				if (result == null) result = caseModelObject(parentEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAILOVER_END_POINT: {
				FailoverEndPoint failoverEndPoint = (FailoverEndPoint)theEObject;
				T result = caseFailoverEndPoint(failoverEndPoint);
				if (result == null) result = caseParentEndPoint(failoverEndPoint);
				if (result == null) result = caseEndPoint(failoverEndPoint);
				if (result == null) result = caseConfigurationElement(failoverEndPoint);
				if (result == null) result = caseModelObject(failoverEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOAD_BALANCE_END_POINT: {
				LoadBalanceEndPoint loadBalanceEndPoint = (LoadBalanceEndPoint)theEObject;
				T result = caseLoadBalanceEndPoint(loadBalanceEndPoint);
				if (result == null) result = caseParentEndPoint(loadBalanceEndPoint);
				if (result == null) result = caseEndPoint(loadBalanceEndPoint);
				if (result == null) result = caseConfigurationElement(loadBalanceEndPoint);
				if (result == null) result = caseModelObject(loadBalanceEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT: {
				DynamicLoadBalanceEndPoint dynamicLoadBalanceEndPoint = (DynamicLoadBalanceEndPoint)theEObject;
				T result = caseDynamicLoadBalanceEndPoint(dynamicLoadBalanceEndPoint);
				if (result == null) result = caseEndPoint(dynamicLoadBalanceEndPoint);
				if (result == null) result = caseConfigurationElement(dynamicLoadBalanceEndPoint);
				if (result == null) result = caseModelObject(dynamicLoadBalanceEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DYNAMIC_LOAD_BALANCE_PROPERTY: {
				DynamicLoadBalanceProperty dynamicLoadBalanceProperty = (DynamicLoadBalanceProperty)theEObject;
				T result = caseDynamicLoadBalanceProperty(dynamicLoadBalanceProperty);
				if (result == null) result = caseAbstractNameValueProperty(dynamicLoadBalanceProperty);
				if (result == null) result = caseModelObject(dynamicLoadBalanceProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XPATH_END_POINT_REFERENCE: {
				XPathEndPointReference xPathEndPointReference = (XPathEndPointReference)theEObject;
				T result = caseXPathEndPointReference(xPathEndPointReference);
				if (result == null) result = caseEndPointReference(xPathEndPointReference);
				if (result == null) result = caseModelObject(xPathEndPointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE: {
				RegistryKeyEndPointReference registryKeyEndPointReference = (RegistryKeyEndPointReference)theEObject;
				T result = caseRegistryKeyEndPointReference(registryKeyEndPointReference);
				if (result == null) result = caseEndPointReference(registryKeyEndPointReference);
				if (result == null) result = caseModelObject(registryKeyEndPointReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE: {
				ProxyService proxyService = (ProxyService)theEObject;
				T result = caseProxyService(proxyService);
				if (result == null) result = caseConfigurationElement(proxyService);
				if (result == null) result = caseModelObject(proxyService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_WSDL_CONFIGURATION: {
				ProxyWsdlConfiguration proxyWsdlConfiguration = (ProxyWsdlConfiguration)theEObject;
				T result = caseProxyWsdlConfiguration(proxyWsdlConfiguration);
				if (result == null) result = caseModelObject(proxyWsdlConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_WSDL_RESOURCE: {
				ProxyWsdlResource proxyWsdlResource = (ProxyWsdlResource)theEObject;
				T result = caseProxyWsdlResource(proxyWsdlResource);
				if (result == null) result = caseAbstractLocationKeyResource(proxyWsdlResource);
				if (result == null) result = caseModelObject(proxyWsdlResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_PARAMETER: {
				ProxyServiceParameter proxyServiceParameter = (ProxyServiceParameter)theEObject;
				T result = caseProxyServiceParameter(proxyServiceParameter);
				if (result == null) result = caseModelObject(proxyServiceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_POLICY: {
				ProxyServicePolicy proxyServicePolicy = (ProxyServicePolicy)theEObject;
				T result = caseProxyServicePolicy(proxyServicePolicy);
				if (result == null) result = caseModelObject(proxyServicePolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_PROXY_SEQUENCE_CONFIGURATION: {
				AbstractProxySequenceConfiguration abstractProxySequenceConfiguration = (AbstractProxySequenceConfiguration)theEObject;
				T result = caseAbstractProxySequenceConfiguration(abstractProxySequenceConfiguration);
				if (result == null) result = caseModelObject(abstractProxySequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_IN_SEQUENCE_CONFIGURATION: {
				ProxyInSequenceConfiguration proxyInSequenceConfiguration = (ProxyInSequenceConfiguration)theEObject;
				T result = caseProxyInSequenceConfiguration(proxyInSequenceConfiguration);
				if (result == null) result = caseAbstractProxySequenceConfiguration(proxyInSequenceConfiguration);
				if (result == null) result = caseModelObject(proxyInSequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION: {
				ProxyEndpointConfiguration proxyEndpointConfiguration = (ProxyEndpointConfiguration)theEObject;
				T result = caseProxyEndpointConfiguration(proxyEndpointConfiguration);
				if (result == null) result = caseModelObject(proxyEndpointConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_OUT_SEQUENCE_CONFIGURATION: {
				ProxyOutSequenceConfiguration proxyOutSequenceConfiguration = (ProxyOutSequenceConfiguration)theEObject;
				T result = caseProxyOutSequenceConfiguration(proxyOutSequenceConfiguration);
				if (result == null) result = caseAbstractProxySequenceConfiguration(proxyOutSequenceConfiguration);
				if (result == null) result = caseModelObject(proxyOutSequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_FAULT_SEQUENCE_CONFIGURATION: {
				ProxyFaultSequenceConfiguration proxyFaultSequenceConfiguration = (ProxyFaultSequenceConfiguration)theEObject;
				T result = caseProxyFaultSequenceConfiguration(proxyFaultSequenceConfiguration);
				if (result == null) result = caseAbstractProxySequenceConfiguration(proxyFaultSequenceConfiguration);
				if (result == null) result = caseModelObject(proxyFaultSequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOCAL_ENTRY: {
				LocalEntry localEntry = (LocalEntry)theEObject;
				T result = caseLocalEntry(localEntry);
				if (result == null) result = caseConfigurationElement(localEntry);
				if (result == null) result = caseModelObject(localEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY: {
				EvaluatorExpressionProperty evaluatorExpressionProperty = (EvaluatorExpressionProperty)theEObject;
				T result = caseEvaluatorExpressionProperty(evaluatorExpressionProperty);
				if (result == null) result = caseModelObject(evaluatorExpressionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TASK_IMPLEMENTATION: {
				TaskImplementation taskImplementation = (TaskImplementation)theEObject;
				T result = caseTaskImplementation(taskImplementation);
				if (result == null) result = caseModelObject(taskImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TASK_PROPERTY: {
				TaskProperty taskProperty = (TaskProperty)theEObject;
				T result = caseTaskProperty(taskProperty);
				if (result == null) result = caseNameValueTypeProperty(taskProperty);
				if (result == null) result = caseModelObject(taskProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseConfigurationElement(task);
				if (result == null) result = caseModelObject(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_IN_SEQUENCE_CONFIGURATION: {
				ApiInSequenceConfiguration apiInSequenceConfiguration = (ApiInSequenceConfiguration)theEObject;
				T result = caseApiInSequenceConfiguration(apiInSequenceConfiguration);
				if (result == null) result = caseAbstractProxySequenceConfiguration(apiInSequenceConfiguration);
				if (result == null) result = caseModelObject(apiInSequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_OUT_SEQUENCE_CONFIGURATION: {
				ApiOutSequenceConfiguration apiOutSequenceConfiguration = (ApiOutSequenceConfiguration)theEObject;
				T result = caseApiOutSequenceConfiguration(apiOutSequenceConfiguration);
				if (result == null) result = caseAbstractProxySequenceConfiguration(apiOutSequenceConfiguration);
				if (result == null) result = caseModelObject(apiOutSequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_FAULT_SEQUENCE_CONFIGURATION: {
				ApiFaultSequenceConfiguration apiFaultSequenceConfiguration = (ApiFaultSequenceConfiguration)theEObject;
				T result = caseApiFaultSequenceConfiguration(apiFaultSequenceConfiguration);
				if (result == null) result = caseAbstractProxySequenceConfiguration(apiFaultSequenceConfiguration);
				if (result == null) result = caseModelObject(apiFaultSequenceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE: {
				ApiResource apiResource = (ApiResource)theEObject;
				T result = caseApiResource(apiResource);
				if (result == null) result = caseModelObject(apiResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SYNAPSE_API: {
				SynapseAPI synapseAPI = (SynapseAPI)theEObject;
				T result = caseSynapseAPI(synapseAPI);
				if (result == null) result = caseConfigurationElement(synapseAPI);
				if (result == null) result = caseModelObject(synapseAPI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelObject(ModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synapse Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synapse Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynapseConfiguration(SynapseConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationElement(ConfigurationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespaced Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespaced Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespacedProperty(NamespacedProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registry Key Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registry Key Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistryKeyProperty(RegistryKeyProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyService(ProxyService object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Wsdl Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Wsdl Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyWsdlConfiguration(ProxyWsdlConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Wsdl Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Wsdl Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyWsdlResource(ProxyWsdlResource object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Service Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Service Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyServiceParameter(ProxyServiceParameter object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Service Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Service Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyServicePolicy(ProxyServicePolicy object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Proxy Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Proxy Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractProxySequenceConfiguration(AbstractProxySequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy In Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy In Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyInSequenceConfiguration(ProxyInSequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Endpoint Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Endpoint Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyEndpointConfiguration(ProxyEndpointConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Out Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Out Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyOutSequenceConfiguration(ProxyOutSequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Fault Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Fault Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyFaultSequenceConfiguration(ProxyFaultSequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalEntry(LocalEntry object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluator Expression Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluator Expression Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluatorExpressionProperty(EvaluatorExpressionProperty object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskImplementation(TaskImplementation object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskProperty(TaskProperty object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Api In Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Api In Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApiInSequenceConfiguration(ApiInSequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Api Out Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Api Out Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApiOutSequenceConfiguration(ApiOutSequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Api Fault Sequence Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Api Fault Sequence Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApiFaultSequenceConfiguration(ApiFaultSequenceConfiguration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Api Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Api Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApiResource(ApiResource object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Synapse API</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synapse API</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynapseAPI(SynapseAPI object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Mediator Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mediator Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediatorBranch(MediatorBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediator(Mediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescription(Description object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mediator Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mediator Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediatorSequence(MediatorSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parent Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParentMediator(ParentMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Name Value Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Name Value Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNameValueProperty(AbstractNameValueProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Name Value Expression Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Name Value Expression Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNameValueExpressionProperty(AbstractNameValueExpressionProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Value Type Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Value Type Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameValueTypeProperty(NameValueTypeProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Boolean Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Boolean Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractBooleanFeature(AbstractBooleanFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Location Key Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Location Key Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLocationKeyResource(AbstractLocationKeyResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Common Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Common Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractCommonTarget(AbstractCommonTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseEndPoint(EndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Object</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseUnknownObject(UnknownObject object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseAbstractEndPoint(AbstractEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Default End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Default End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseAbstractDefaultEndPoint(AbstractDefaultEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Default End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseDefaultEndPoint(DefaultEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Address End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseAddressEndPoint(AddressEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Wsdl End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wsdl End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseWsdlEndPoint(WsdlEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Parent End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseParentEndPoint(ParentEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Failover End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failover End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseFailoverEndPoint(FailoverEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Load Balance End Point</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Balance End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseLoadBalanceEndPoint(LoadBalanceEndPoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Load Balance End Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Load Balance End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicLoadBalanceEndPoint(DynamicLoadBalanceEndPoint object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Load Balance Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Load Balance Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicLoadBalanceProperty(DynamicLoadBalanceProperty object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>End Point Reference</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Point Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseEndPointReference(EndPointReference object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>XPath End Point Reference</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XPath End Point Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseXPathEndPointReference(XPathEndPointReference object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Registry Key End Point Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registry Key End Point Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistryKeyEndPointReference(RegistryKeyEndPointReference object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SequenceSwitch
