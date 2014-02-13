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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.esb.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage
 * @generated
 */
public class EsbAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EsbPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EsbPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EsbSwitch<Adapter> modelSwitch =
		new EsbSwitch<Adapter>() {
			@Override
			public Adapter caseModelObject(ModelObject object) {
				return createModelObjectAdapter();
			}
			@Override
			public Adapter caseNamespace(Namespace object) {
				return createNamespaceAdapter();
			}
			@Override
			public Adapter caseSynapseConfiguration(SynapseConfiguration object) {
				return createSynapseConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigurationElement(ConfigurationElement object) {
				return createConfigurationElementAdapter();
			}
			@Override
			public Adapter caseMediator(Mediator object) {
				return createMediatorAdapter();
			}
			@Override
			public Adapter caseDescription(Description object) {
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseComment(Comment object) {
				return createCommentAdapter();
			}
			@Override
			public Adapter caseEndPointReference(EndPointReference object) {
				return createEndPointReferenceAdapter();
			}
			@Override
			public Adapter caseEndPoint(EndPoint object) {
				return createEndPointAdapter();
			}
			@Override
			public Adapter caseUnknownObject(UnknownObject object) {
				return createUnknownObjectAdapter();
			}
			@Override
			public Adapter caseMediatorSequence(MediatorSequence object) {
				return createMediatorSequenceAdapter();
			}
			@Override
			public Adapter caseMediatorBranch(MediatorBranch object) {
				return createMediatorBranchAdapter();
			}
			@Override
			public Adapter caseParentMediator(ParentMediator object) {
				return createParentMediatorAdapter();
			}
			@Override
			public Adapter caseNamespacedProperty(NamespacedProperty object) {
				return createNamespacedPropertyAdapter();
			}
			@Override
			public Adapter caseRegistryKeyProperty(RegistryKeyProperty object) {
				return createRegistryKeyPropertyAdapter();
			}
			@Override
			public Adapter caseAbstractNameValueProperty(AbstractNameValueProperty object) {
				return createAbstractNameValuePropertyAdapter();
			}
			@Override
			public Adapter caseAbstractNameValueExpressionProperty(AbstractNameValueExpressionProperty object) {
				return createAbstractNameValueExpressionPropertyAdapter();
			}
			@Override
			public Adapter caseNameValueTypeProperty(NameValueTypeProperty object) {
				return createNameValueTypePropertyAdapter();
			}
			@Override
			public Adapter caseAbstractBooleanFeature(AbstractBooleanFeature object) {
				return createAbstractBooleanFeatureAdapter();
			}
			@Override
			public Adapter caseAbstractLocationKeyResource(AbstractLocationKeyResource object) {
				return createAbstractLocationKeyResourceAdapter();
			}
			@Override
			public Adapter caseAbstractCommonTarget(AbstractCommonTarget object) {
				return createAbstractCommonTargetAdapter();
			}
			@Override
			public Adapter caseAbstractEndPoint(AbstractEndPoint object) {
				return createAbstractEndPointAdapter();
			}
			@Override
			public Adapter caseAbstractDefaultEndPoint(AbstractDefaultEndPoint object) {
				return createAbstractDefaultEndPointAdapter();
			}
			@Override
			public Adapter caseDefaultEndPoint(DefaultEndPoint object) {
				return createDefaultEndPointAdapter();
			}
			@Override
			public Adapter caseAddressEndPoint(AddressEndPoint object) {
				return createAddressEndPointAdapter();
			}
			@Override
			public Adapter caseWsdlEndPoint(WsdlEndPoint object) {
				return createWsdlEndPointAdapter();
			}
			@Override
			public Adapter caseParentEndPoint(ParentEndPoint object) {
				return createParentEndPointAdapter();
			}
			@Override
			public Adapter caseFailoverEndPoint(FailoverEndPoint object) {
				return createFailoverEndPointAdapter();
			}
			@Override
			public Adapter caseLoadBalanceEndPoint(LoadBalanceEndPoint object) {
				return createLoadBalanceEndPointAdapter();
			}
			@Override
			public Adapter caseDynamicLoadBalanceEndPoint(DynamicLoadBalanceEndPoint object) {
				return createDynamicLoadBalanceEndPointAdapter();
			}
			@Override
			public Adapter caseDynamicLoadBalanceProperty(DynamicLoadBalanceProperty object) {
				return createDynamicLoadBalancePropertyAdapter();
			}
			@Override
			public Adapter caseXPathEndPointReference(XPathEndPointReference object) {
				return createXPathEndPointReferenceAdapter();
			}
			@Override
			public Adapter caseRegistryKeyEndPointReference(RegistryKeyEndPointReference object) {
				return createRegistryKeyEndPointReferenceAdapter();
			}
			@Override
			public Adapter caseProxyService(ProxyService object) {
				return createProxyServiceAdapter();
			}
			@Override
			public Adapter caseProxyWsdlConfiguration(ProxyWsdlConfiguration object) {
				return createProxyWsdlConfigurationAdapter();
			}
			@Override
			public Adapter caseProxyWsdlResource(ProxyWsdlResource object) {
				return createProxyWsdlResourceAdapter();
			}
			@Override
			public Adapter caseProxyServiceParameter(ProxyServiceParameter object) {
				return createProxyServiceParameterAdapter();
			}
			@Override
			public Adapter caseProxyServicePolicy(ProxyServicePolicy object) {
				return createProxyServicePolicyAdapter();
			}
			@Override
			public Adapter caseAbstractProxySequenceConfiguration(AbstractProxySequenceConfiguration object) {
				return createAbstractProxySequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseProxyInSequenceConfiguration(ProxyInSequenceConfiguration object) {
				return createProxyInSequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseProxyEndpointConfiguration(ProxyEndpointConfiguration object) {
				return createProxyEndpointConfigurationAdapter();
			}
			@Override
			public Adapter caseProxyOutSequenceConfiguration(ProxyOutSequenceConfiguration object) {
				return createProxyOutSequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseProxyFaultSequenceConfiguration(ProxyFaultSequenceConfiguration object) {
				return createProxyFaultSequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseLocalEntry(LocalEntry object) {
				return createLocalEntryAdapter();
			}
			@Override
			public Adapter caseEvaluatorExpressionProperty(EvaluatorExpressionProperty object) {
				return createEvaluatorExpressionPropertyAdapter();
			}
			@Override
			public Adapter caseTaskImplementation(TaskImplementation object) {
				return createTaskImplementationAdapter();
			}
			@Override
			public Adapter caseTaskProperty(TaskProperty object) {
				return createTaskPropertyAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseApiInSequenceConfiguration(ApiInSequenceConfiguration object) {
				return createApiInSequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseApiOutSequenceConfiguration(ApiOutSequenceConfiguration object) {
				return createApiOutSequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseApiFaultSequenceConfiguration(ApiFaultSequenceConfiguration object) {
				return createApiFaultSequenceConfigurationAdapter();
			}
			@Override
			public Adapter caseApiResource(ApiResource object) {
				return createApiResourceAdapter();
			}
			@Override
			public Adapter caseSynapseAPI(SynapseAPI object) {
				return createSynapseAPIAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ModelObject <em>Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ModelObject
	 * @generated
	 */
	public Adapter createModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.SynapseConfiguration <em>Synapse Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.SynapseConfiguration
	 * @generated
	 */
	public Adapter createSynapseConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ConfigurationElement
	 * @generated
	 */
	public Adapter createConfigurationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.NamespacedProperty <em>Namespaced Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.NamespacedProperty
	 * @generated
	 */
	public Adapter createNamespacedPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty <em>Registry Key Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty
	 * @generated
	 */
	public Adapter createRegistryKeyPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyService <em>Proxy Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyService
	 * @generated
	 */
	public Adapter createProxyServiceAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration <em>Proxy Wsdl Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyWsdlConfiguration
	 * @generated
	 */
	public Adapter createProxyWsdlConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyWsdlResource <em>Proxy Wsdl Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyWsdlResource
	 * @generated
	 */
	public Adapter createProxyWsdlResourceAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyServiceParameter <em>Proxy Service Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyServiceParameter
	 * @generated
	 */
	public Adapter createProxyServiceParameterAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyServicePolicy <em>Proxy Service Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyServicePolicy
	 * @generated
	 */
	public Adapter createProxyServicePolicyAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration <em>Abstract Proxy Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractProxySequenceConfiguration
	 * @generated
	 */
	public Adapter createAbstractProxySequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyInSequenceConfiguration <em>Proxy In Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyInSequenceConfiguration
	 * @generated
	 */
	public Adapter createProxyInSequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration <em>Proxy Endpoint Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration
	 * @generated
	 */
	public Adapter createProxyEndpointConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyOutSequenceConfiguration <em>Proxy Out Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyOutSequenceConfiguration
	 * @generated
	 */
	public Adapter createProxyOutSequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ProxyFaultSequenceConfiguration <em>Proxy Fault Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyFaultSequenceConfiguration
	 * @generated
	 */
	public Adapter createProxyFaultSequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.LocalEntry <em>Local Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.LocalEntry
	 * @generated
	 */
	public Adapter createLocalEntryAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty <em>Evaluator Expression Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.EvaluatorExpressionProperty
	 * @generated
	 */
	public Adapter createEvaluatorExpressionPropertyAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.TaskImplementation <em>Task Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.TaskImplementation
	 * @generated
	 */
	public Adapter createTaskImplementationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.TaskProperty <em>Task Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.TaskProperty
	 * @generated
	 */
	public Adapter createTaskPropertyAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ApiInSequenceConfiguration <em>Api In Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ApiInSequenceConfiguration
	 * @generated
	 */
	public Adapter createApiInSequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ApiOutSequenceConfiguration <em>Api Out Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ApiOutSequenceConfiguration
	 * @generated
	 */
	public Adapter createApiOutSequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ApiFaultSequenceConfiguration <em>Api Fault Sequence Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ApiFaultSequenceConfiguration
	 * @generated
	 */
	public Adapter createApiFaultSequenceConfigurationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ApiResource <em>Api Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ApiResource
	 * @generated
	 */
	public Adapter createApiResourceAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.SynapseAPI <em>Synapse API</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.SynapseAPI
	 * @generated
	 */
	public Adapter createSynapseAPIAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.MediatorBranch <em>Mediator Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.MediatorBranch
	 * @generated
	 */
	public Adapter createMediatorBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.Mediator <em>Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.Mediator
	 * @generated
	 */
	public Adapter createMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.Description
	 * @generated
	 */
	public Adapter createDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.Comment
	 * @generated
	 */
	public Adapter createCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.MediatorSequence <em>Mediator Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.MediatorSequence
	 * @generated
	 */
	public Adapter createMediatorSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ParentMediator <em>Parent Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ParentMediator
	 * @generated
	 */
	public Adapter createParentMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueProperty <em>Abstract Name Value Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractNameValueProperty
	 * @generated
	 */
	public Adapter createAbstractNameValuePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty <em>Abstract Name Value Expression Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty
	 * @generated
	 */
	public Adapter createAbstractNameValueExpressionPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty <em>Name Value Type Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.NameValueTypeProperty
	 * @generated
	 */
	public Adapter createNameValueTypePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractBooleanFeature <em>Abstract Boolean Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractBooleanFeature
	 * @generated
	 */
	public Adapter createAbstractBooleanFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource <em>Abstract Location Key Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource
	 * @generated
	 */
	public Adapter createAbstractLocationKeyResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget <em>Abstract Common Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget
	 * @generated
	 */
	public Adapter createAbstractCommonTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.EndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPoint
	 * @generated
	 */
    public Adapter createEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.UnknownObject <em>Unknown Object</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.UnknownObject
	 * @generated
	 */
    public Adapter createUnknownObjectAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractEndPoint <em>Abstract End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractEndPoint
	 * @generated
	 */
    public Adapter createAbstractEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint <em>Abstract Default End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AbstractDefaultEndPoint
	 * @generated
	 */
    public Adapter createAbstractDefaultEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.DefaultEndPoint <em>Default End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.DefaultEndPoint
	 * @generated
	 */
    public Adapter createDefaultEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.AddressEndPoint <em>Address End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.AddressEndPoint
	 * @generated
	 */
    public Adapter createAddressEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.WsdlEndPoint <em>Wsdl End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.WsdlEndPoint
	 * @generated
	 */
    public Adapter createWsdlEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.ParentEndPoint <em>Parent End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.ParentEndPoint
	 * @generated
	 */
    public Adapter createParentEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.FailoverEndPoint <em>Failover End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.FailoverEndPoint
	 * @generated
	 */
    public Adapter createFailoverEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint <em>Load Balance End Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.LoadBalanceEndPoint
	 * @generated
	 */
    public Adapter createLoadBalanceEndPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint <em>Dynamic Load Balance End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceEndPoint
	 * @generated
	 */
	public Adapter createDynamicLoadBalanceEndPointAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceProperty <em>Dynamic Load Balance Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.DynamicLoadBalanceProperty
	 * @generated
	 */
	public Adapter createDynamicLoadBalancePropertyAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.EndPointReference <em>End Point Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.EndPointReference
	 * @generated
	 */
    public Adapter createEndPointReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.XPathEndPointReference <em>XPath End Point Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.XPathEndPointReference
	 * @generated
	 */
    public Adapter createXPathEndPointReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.RegistryKeyEndPointReference <em>Registry Key End Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.RegistryKeyEndPointReference
	 * @generated
	 */
	public Adapter createRegistryKeyEndPointReferenceAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SequenceAdapterFactory
