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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.developerstudio.eclipse.esb.*;
import org.wso2.developerstudio.eclipse.esb.util.EsbUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class EsbFactoryImpl extends EFactoryImpl implements EsbFactory {
	/**
	 * Model object resolver factory.
	 */
	private ModelObjectResolverFactory resolverFactory = ModelObjectResolverFactoryImpl
			.getInstance();

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public EsbFactoryImpl() {
		super();
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static EsbFactory init() {
		try {
			EsbFactory theEsbFactory = (EsbFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/wso2/developerstudio/eclipse/esb"); 
			if (theEsbFactory != null) {
				return theEsbFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EsbFactoryImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	public Element serializeToElement(ModelObject modelObj) throws Exception {
		Element result = null;
		if (modelObj.hasSourceRepresentation()) {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element rootElem = document.createElement("root");
			document.appendChild(rootElem);

			// Actual serialization happens here.
			result = modelObj.save(rootElem);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public String serializeToString(ModelObject modelObj) throws Exception {
		if (modelObj.getObjectState().equals(ModelObjectState.NORMAL)) {
			Element elem = serializeToElement(modelObj);
			return (null != elem) ? EsbUtils.renderElement(elem, true) : null;
		} else {
			return modelObj.getSourceText();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T extends ModelObject> T loadModelObject(Element element,
			Class<T> clazz, ModelObject parent) {
		T result = null;
		ModelObjectResolver resolver = resolverFactory.getResolver(element
				.getLocalName());
		if (null != resolver) {
			ModelObject modelObj = resolver.resolve(element, parent);
			if (null != modelObj) {
				if (clazz.isAssignableFrom(modelObj.getClass())) {
					try {
						modelObj.load(element);
						result = (T) modelObj;
					} catch (Exception ex) {
						if (null != parent) {
							parent.getLoadErrors().add(ex);
						}
					}
				} else {
					// TODO: Whoops!
				}
			} else {
				// TODO: Log (model object resolver was unable to
				// determine the model object type).
			}
		} else {
			// TODO: Log (no model object resolver found).
		}

		// Fall back.
		if (null == result && (clazz.isAssignableFrom(UnknownObject.class))) {
			result = (T) createUnknownObject(element);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IStatus> extractLoadErrors(ModelObject rootObject) {
		List<IStatus> statusList = new ArrayList<IStatus>();
		extractLoadErrors(rootObject, statusList);
		return statusList;
	}

	/**
	 * Utility method used for recursively extracting load errors of a
	 * {@link ModelObject} and its children.
	 * 
	 * @param modelObj
	 *            {@link ModelObject} to be analyzed.
	 * @param statusList
	 *            list of {@link IStatus} objects collected so far.
	 */
	private void extractLoadErrors(ModelObject modelObj,
			List<IStatus> statusList) {
		for (Throwable throwable : modelObj.getLoadErrors()) {
			statusList
					.add(new Status(IStatus.WARNING,
							"org.wso2.developerstudio.eclipse.esb", String.format(
									"Error while loading model object: [%s]",
									modelObj.getClass().getCanonicalName()),
							throwable));
		}

		// Clear current load errors after collecting them.
		modelObj.getLoadErrors().clear();

		// Recurse.
		for (EObject childObj : modelObj.eContents()) {
			if (childObj instanceof ModelObject) {
				extractLoadErrors((ModelObject) childObj, statusList);
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EsbPackage.NAMESPACE: return createNamespace();
			case EsbPackage.SYNAPSE_CONFIGURATION: return createSynapseConfiguration();
			case EsbPackage.DESCRIPTION: return createDescription();
			case EsbPackage.COMMENT: return createComment();
			case EsbPackage.UNKNOWN_OBJECT: return createUnknownObject();
			case EsbPackage.MEDIATOR_SEQUENCE: return createMediatorSequence();
			case EsbPackage.NAMESPACED_PROPERTY: return createNamespacedProperty();
			case EsbPackage.REGISTRY_KEY_PROPERTY: return createRegistryKeyProperty();
			case EsbPackage.NAME_VALUE_TYPE_PROPERTY: return createNameValueTypeProperty();
			case EsbPackage.DEFAULT_END_POINT: return createDefaultEndPoint();
			case EsbPackage.ADDRESS_END_POINT: return createAddressEndPoint();
			case EsbPackage.WSDL_END_POINT: return createWsdlEndPoint();
			case EsbPackage.FAILOVER_END_POINT: return createFailoverEndPoint();
			case EsbPackage.LOAD_BALANCE_END_POINT: return createLoadBalanceEndPoint();
			case EsbPackage.DYNAMIC_LOAD_BALANCE_END_POINT: return createDynamicLoadBalanceEndPoint();
			case EsbPackage.DYNAMIC_LOAD_BALANCE_PROPERTY: return createDynamicLoadBalanceProperty();
			case EsbPackage.XPATH_END_POINT_REFERENCE: return createXPathEndPointReference();
			case EsbPackage.REGISTRY_KEY_END_POINT_REFERENCE: return createRegistryKeyEndPointReference();
			case EsbPackage.PROXY_SERVICE: return createProxyService();
			case EsbPackage.PROXY_WSDL_CONFIGURATION: return createProxyWsdlConfiguration();
			case EsbPackage.PROXY_WSDL_RESOURCE: return createProxyWsdlResource();
			case EsbPackage.PROXY_SERVICE_PARAMETER: return createProxyServiceParameter();
			case EsbPackage.PROXY_SERVICE_POLICY: return createProxyServicePolicy();
			case EsbPackage.PROXY_IN_SEQUENCE_CONFIGURATION: return createProxyInSequenceConfiguration();
			case EsbPackage.PROXY_ENDPOINT_CONFIGURATION: return createProxyEndpointConfiguration();
			case EsbPackage.PROXY_OUT_SEQUENCE_CONFIGURATION: return createProxyOutSequenceConfiguration();
			case EsbPackage.PROXY_FAULT_SEQUENCE_CONFIGURATION: return createProxyFaultSequenceConfiguration();
			case EsbPackage.LOCAL_ENTRY: return createLocalEntry();
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY: return createEvaluatorExpressionProperty();
			case EsbPackage.TASK_IMPLEMENTATION: return createTaskImplementation();
			case EsbPackage.TASK_PROPERTY: return createTaskProperty();
			case EsbPackage.TASK: return createTask();
			case EsbPackage.API_IN_SEQUENCE_CONFIGURATION: return createApiInSequenceConfiguration();
			case EsbPackage.API_OUT_SEQUENCE_CONFIGURATION: return createApiOutSequenceConfiguration();
			case EsbPackage.API_FAULT_SEQUENCE_CONFIGURATION: return createApiFaultSequenceConfiguration();
			case EsbPackage.API_RESOURCE: return createApiResource();
			case EsbPackage.SYNAPSE_API: return createSynapseAPI();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EsbPackage.MODEL_OBJECT_STATE:
				return createModelObjectStateFromString(eDataType, initialValue);
			case EsbPackage.TASK_PROPERTY_TYPE:
				return createTaskPropertyTypeFromString(eDataType, initialValue);
			case EsbPackage.PROPERTY_VALUE_TYPE:
				return createPropertyValueTypeFromString(eDataType, initialValue);
			case EsbPackage.TARGET_SEQUENCE_TYPE:
				return createTargetSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.TARGET_ENDPOINT_TYPE:
				return createTargetEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_ADDRESSING_VERSION:
				return createEndPointAddressingVersionFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_TIME_OUT_ACTION:
				return createEndPointTimeOutActionFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_MESSAGE_FORMAT:
				return createEndPointMessageFormatFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_ATTACHMENT_OPTIMIZATION:
				return createEndPointAttachmentOptimizationFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_WSDL_TYPE:
				return createEndPointWsdlTypeFromString(eDataType, initialValue);
			case EsbPackage.LOAD_BALANCE_ALGORITHM:
				return createLoadBalanceAlgorithmFromString(eDataType, initialValue);
			case EsbPackage.LOAD_BALANCE_SESSION_TYPE:
				return createLoadBalanceSessionTypeFromString(eDataType, initialValue);
			case EsbPackage.PROXY_WSDL_TYPE:
				return createProxyWsdlTypeFromString(eDataType, initialValue);
			case EsbPackage.PROXY_SEQUENCE_TYPE:
				return createProxySequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.PROXY_ENDPOINT_TYPE:
				return createProxyEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.LOCAL_ENTRY_VALUE_TYPE:
				return createLocalEntryValueTypeFromString(eDataType, initialValue);
			case EsbPackage.ESB_VERSION:
				return createEsbVersionFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_MESSAGE_FORMAT_REST_TYPE:
				return createEndPointMessageFormatRestTypeFromString(eDataType, initialValue);
			case EsbPackage.TASK_TRIGGER_TYPE:
				return createTaskTriggerTypeFromString(eDataType, initialValue);
			case EsbPackage.API_RESOURCE_URL_STYLE:
				return createApiResourceUrlStyleFromString(eDataType, initialValue);
			case EsbPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EsbPackage.MODEL_OBJECT_STATE:
				return convertModelObjectStateToString(eDataType, instanceValue);
			case EsbPackage.TASK_PROPERTY_TYPE:
				return convertTaskPropertyTypeToString(eDataType, instanceValue);
			case EsbPackage.PROPERTY_VALUE_TYPE:
				return convertPropertyValueTypeToString(eDataType, instanceValue);
			case EsbPackage.TARGET_SEQUENCE_TYPE:
				return convertTargetSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.TARGET_ENDPOINT_TYPE:
				return convertTargetEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_ADDRESSING_VERSION:
				return convertEndPointAddressingVersionToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_TIME_OUT_ACTION:
				return convertEndPointTimeOutActionToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_MESSAGE_FORMAT:
				return convertEndPointMessageFormatToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_ATTACHMENT_OPTIMIZATION:
				return convertEndPointAttachmentOptimizationToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_WSDL_TYPE:
				return convertEndPointWsdlTypeToString(eDataType, instanceValue);
			case EsbPackage.LOAD_BALANCE_ALGORITHM:
				return convertLoadBalanceAlgorithmToString(eDataType, instanceValue);
			case EsbPackage.LOAD_BALANCE_SESSION_TYPE:
				return convertLoadBalanceSessionTypeToString(eDataType, instanceValue);
			case EsbPackage.PROXY_WSDL_TYPE:
				return convertProxyWsdlTypeToString(eDataType, instanceValue);
			case EsbPackage.PROXY_SEQUENCE_TYPE:
				return convertProxySequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.PROXY_ENDPOINT_TYPE:
				return convertProxyEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.LOCAL_ENTRY_VALUE_TYPE:
				return convertLocalEntryValueTypeToString(eDataType, instanceValue);
			case EsbPackage.ESB_VERSION:
				return convertEsbVersionToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_MESSAGE_FORMAT_REST_TYPE:
				return convertEndPointMessageFormatRestTypeToString(eDataType, instanceValue);
			case EsbPackage.TASK_TRIGGER_TYPE:
				return convertTaskTriggerTypeToString(eDataType, instanceValue);
			case EsbPackage.API_RESOURCE_URL_STYLE:
				return convertApiResourceUrlStyleToString(eDataType, instanceValue);
			case EsbPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace createNamespace() {
		NamespaceImpl namespace = new NamespaceImpl();
		return namespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointAddressingVersion createEndPointAddressingVersionFromString(
			EDataType eDataType, String initialValue) {
		EndPointAddressingVersion result = EndPointAddressingVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointAddressingVersionToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointTimeOutAction createEndPointTimeOutActionFromString(
			EDataType eDataType, String initialValue) {
		EndPointTimeOutAction result = EndPointTimeOutAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointTimeOutActionToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointMessageFormat createEndPointMessageFormatFromString(
			EDataType eDataType, String initialValue) {
		EndPointMessageFormat result = EndPointMessageFormat.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointMessageFormatToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointAttachmentOptimization createEndPointAttachmentOptimizationFromString(
			EDataType eDataType, String initialValue) {
		EndPointAttachmentOptimization result = EndPointAttachmentOptimization.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointAttachmentOptimizationToString(
			EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointWsdlType createEndPointWsdlTypeFromString(
			EDataType eDataType, String initialValue) {
		EndPointWsdlType result = EndPointWsdlType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointWsdlTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceAlgorithm createLoadBalanceAlgorithmFromString(
			EDataType eDataType, String initialValue) {
		LoadBalanceAlgorithm result = LoadBalanceAlgorithm.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadBalanceAlgorithmToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceSessionType createLoadBalanceSessionTypeFromString(
			EDataType eDataType, String initialValue) {
		LoadBalanceSessionType result = LoadBalanceSessionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadBalanceSessionTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SynapseConfiguration createSynapseConfiguration() {
		SynapseConfigurationImpl synapseConfiguration = new SynapseConfigurationImpl();
		return synapseConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description createDescription() {
		DescriptionImpl description = new DescriptionImpl();
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorSequence createMediatorSequence() {
		MediatorSequenceImpl mediatorSequence = new MediatorSequenceImpl();
		return mediatorSequence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownObject createUnknownObject() {
		UnknownObjectImpl unknownObject = new UnknownObjectImpl();
		return unknownObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NamespacedProperty createNamespacedProperty() {
		NamespacedPropertyImpl namespacedProperty = new NamespacedPropertyImpl();
		return namespacedProperty;
	}

	/**
	 * {@inheritDoc}
	 */
	public NamespacedProperty copyNamespacedProperty(
			NamespacedProperty namespacedProperty) {
		NamespacedProperty copy = createNamespacedProperty();
		copy.setPrettyName(namespacedProperty.getPrettyName());
		copy.setPropertyName(namespacedProperty.getPropertyName());
		copy.setPropertyValue(namespacedProperty.getPropertyValue());
		copy.getNamespaces().putAll(namespacedProperty.getNamespaces());
		return copy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty createRegistryKeyProperty() {
		RegistryKeyPropertyImpl registryKeyProperty = new RegistryKeyPropertyImpl();
		return registryKeyProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameValueTypeProperty createNameValueTypeProperty() {
		NameValueTypePropertyImpl nameValueTypeProperty = new NameValueTypePropertyImpl();
		return nameValueTypeProperty;
	}

	/**
	 * {@inheritDoc}
	 */
	public RegistryKeyProperty copyRegistryKeyProperty(
			RegistryKeyProperty registryKeyProperty) {
		RegistryKeyProperty copy = createRegistryKeyProperty();
		copy.setPrettyName(registryKeyProperty.getPrettyName());
		copy.setKeyName(registryKeyProperty.getKeyName());
		copy.setKeyValue(registryKeyProperty.getKeyValue());
		copy.setFilters(registryKeyProperty.getFilters());
		return copy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyService createProxyService() {
		ProxyServiceImpl proxyService = new ProxyServiceImpl();
		return proxyService;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyWsdlConfiguration createProxyWsdlConfiguration() {
		ProxyWsdlConfigurationImpl proxyWsdlConfiguration = new ProxyWsdlConfigurationImpl();
		return proxyWsdlConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyWsdlResource createProxyWsdlResource() {
		ProxyWsdlResourceImpl proxyWsdlResource = new ProxyWsdlResourceImpl();
		return proxyWsdlResource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServiceParameter createProxyServiceParameter() {
		ProxyServiceParameterImpl proxyServiceParameter = new ProxyServiceParameterImpl();
		return proxyServiceParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServicePolicy createProxyServicePolicy() {
		ProxyServicePolicyImpl proxyServicePolicy = new ProxyServicePolicyImpl();
		return proxyServicePolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyInSequenceConfiguration createProxyInSequenceConfiguration() {
		ProxyInSequenceConfigurationImpl proxyInSequenceConfiguration = new ProxyInSequenceConfigurationImpl();
		return proxyInSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyEndpointConfiguration createProxyEndpointConfiguration() {
		ProxyEndpointConfigurationImpl proxyEndpointConfiguration = new ProxyEndpointConfigurationImpl();
		return proxyEndpointConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyOutSequenceConfiguration createProxyOutSequenceConfiguration() {
		ProxyOutSequenceConfigurationImpl proxyOutSequenceConfiguration = new ProxyOutSequenceConfigurationImpl();
		return proxyOutSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyFaultSequenceConfiguration createProxyFaultSequenceConfiguration() {
		ProxyFaultSequenceConfigurationImpl proxyFaultSequenceConfiguration = new ProxyFaultSequenceConfigurationImpl();
		return proxyFaultSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocalEntry createLocalEntry() {
		LocalEntryImpl localEntry = new LocalEntryImpl();
		return localEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluatorExpressionProperty createEvaluatorExpressionProperty() {
		EvaluatorExpressionPropertyImpl evaluatorExpressionProperty = new EvaluatorExpressionPropertyImpl();
		return evaluatorExpressionProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskImplementation createTaskImplementation() {
		TaskImplementationImpl taskImplementation = new TaskImplementationImpl();
		return taskImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskProperty createTaskProperty() {
		TaskPropertyImpl taskProperty = new TaskPropertyImpl();
		return taskProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiInSequenceConfiguration createApiInSequenceConfiguration() {
		ApiInSequenceConfigurationImpl apiInSequenceConfiguration = new ApiInSequenceConfigurationImpl();
		return apiInSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiOutSequenceConfiguration createApiOutSequenceConfiguration() {
		ApiOutSequenceConfigurationImpl apiOutSequenceConfiguration = new ApiOutSequenceConfigurationImpl();
		return apiOutSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiFaultSequenceConfiguration createApiFaultSequenceConfiguration() {
		ApiFaultSequenceConfigurationImpl apiFaultSequenceConfiguration = new ApiFaultSequenceConfigurationImpl();
		return apiFaultSequenceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiResource createApiResource() {
		ApiResourceImpl apiResource = new ApiResourceImpl();
		return apiResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynapseAPI createSynapseAPI() {
		SynapseAPIImpl synapseAPI = new SynapseAPIImpl();
		return synapseAPI;
	}

	/**
	 * {@inheritDoc}
	 */
	public EvaluatorExpressionProperty copyevaluatorExpressionProperty(
			EvaluatorExpressionProperty evaluatorExpressionProperty) {
		EvaluatorExpressionProperty copy = createEvaluatorExpressionProperty();
		copy.setPrettyName(evaluatorExpressionProperty.getPrettyName());
		copy.setEvaluatorName(evaluatorExpressionProperty.getEvaluatorName());
		copy.setEvaluatorValue(evaluatorExpressionProperty.getEvaluatorValue());
		return copy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyValueTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultEndPoint createDefaultEndPoint() {
		DefaultEndPointImpl defaultEndPoint = new DefaultEndPointImpl();
		return defaultEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AddressEndPoint createAddressEndPoint() {
		AddressEndPointImpl addressEndPoint = new AddressEndPointImpl();
		return addressEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WsdlEndPoint createWsdlEndPoint() {
		WsdlEndPointImpl wsdlEndPoint = new WsdlEndPointImpl();
		return wsdlEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FailoverEndPoint createFailoverEndPoint() {
		FailoverEndPointImpl failoverEndPoint = new FailoverEndPointImpl();
		return failoverEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPoint createLoadBalanceEndPoint() {
		LoadBalanceEndPointImpl loadBalanceEndPoint = new LoadBalanceEndPointImpl();
		return loadBalanceEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicLoadBalanceEndPoint createDynamicLoadBalanceEndPoint() {
		DynamicLoadBalanceEndPointImpl dynamicLoadBalanceEndPoint = new DynamicLoadBalanceEndPointImpl();
		return dynamicLoadBalanceEndPoint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicLoadBalanceProperty createDynamicLoadBalanceProperty() {
		DynamicLoadBalancePropertyImpl dynamicLoadBalanceProperty = new DynamicLoadBalancePropertyImpl();
		return dynamicLoadBalanceProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public XPathEndPointReference createXPathEndPointReference() {
		XPathEndPointReferenceImpl xPathEndPointReference = new XPathEndPointReferenceImpl();
		return xPathEndPointReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyEndPointReference createRegistryKeyEndPointReference() {
		RegistryKeyEndPointReferenceImpl registryKeyEndPointReference = new RegistryKeyEndPointReferenceImpl();
		return registryKeyEndPointReference;
	}

	/**
	 * {@inheritDoc}
	 */
	public UnknownObject createUnknownObject(Element elem) {
		// Return an unknown object.
		UnknownObject unknownObject = createUnknownObject();
		try {
			unknownObject.load(elem);
		} catch (Exception ex) {
			// Not possible.
		}
		return unknownObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelObjectState createModelObjectStateFromString(
			EDataType eDataType, String initialValue) {
		ModelObjectState result = ModelObjectState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModelObjectStateToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskPropertyType createTaskPropertyTypeFromString(EDataType eDataType, String initialValue) {
		TaskPropertyType result = TaskPropertyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTaskPropertyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueType createPropertyValueTypeFromString(
			EDataType eDataType, String initialValue) {
		PropertyValueType result = PropertyValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyWsdlType createProxyWsdlTypeFromString(EDataType eDataType,
			String initialValue) {
		ProxyWsdlType result = ProxyWsdlType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProxyWsdlTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxySequenceType createProxySequenceTypeFromString(
			EDataType eDataType, String initialValue) {
		ProxySequenceType result = ProxySequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProxySequenceTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyEndpointType createProxyEndpointTypeFromString(
			EDataType eDataType, String initialValue) {
		ProxyEndpointType result = ProxyEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProxyEndpointTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocalEntryValueType createLocalEntryValueTypeFromString(
			EDataType eDataType, String initialValue) {
		LocalEntryValueType result = LocalEntryValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLocalEntryValueTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbVersion createEsbVersionFromString(EDataType eDataType, String initialValue) {
		EsbVersion result = EsbVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEsbVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EndPointMessageFormatRestType createEndPointMessageFormatRestTypeFromString(EDataType eDataType, String initialValue) {
		EndPointMessageFormatRestType result = EndPointMessageFormatRestType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertEndPointMessageFormatRestTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskTriggerType createTaskTriggerTypeFromString(EDataType eDataType, String initialValue) {
		TaskTriggerType result = TaskTriggerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTaskTriggerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiResourceUrlStyle createApiResourceUrlStyleFromString(EDataType eDataType, String initialValue) {
		ApiResourceUrlStyle result = ApiResourceUrlStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertApiResourceUrlStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSequenceType createTargetSequenceTypeFromString(
			EDataType eDataType, String initialValue) {
		TargetSequenceType result = TargetSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTargetSequenceTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetEndpointType createTargetEndpointTypeFromString(
			EDataType eDataType, String initialValue) {
		TargetEndpointType result = TargetEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTargetEndpointTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> createMapFromString(EDataType eDataType,
			String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EsbPackage getEsbPackage() {
		return (EsbPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EsbPackage getPackage() {
		return EsbPackage.eINSTANCE;
	}


} // SequenceFactoryImpl
