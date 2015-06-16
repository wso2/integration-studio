/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.wso2.developerstudio.eclipse.gmf.esb.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage
 * @generated
 */
public class EsbSwitch<T> extends Switch<T> {
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
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EsbPackage.ESB_DIAGRAM: {
				EsbDiagram esbDiagram = (EsbDiagram)theEObject;
				T result = caseEsbDiagram(esbDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_NODE: {
				EsbNode esbNode = (EsbNode)theEObject;
				T result = caseEsbNode(esbNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_ELEMENT: {
				EsbElement esbElement = (EsbElement)theEObject;
				T result = caseEsbElement(esbElement);
				if (result == null) result = caseEsbNode(esbElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_SERVER: {
				EsbServer esbServer = (EsbServer)theEObject;
				T result = caseEsbServer(esbServer);
				if (result == null) result = caseEsbNode(esbServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEDIATOR: {
				Mediator mediator = (Mediator)theEObject;
				T result = caseMediator(mediator);
				if (result == null) result = caseEsbElement(mediator);
				if (result == null) result = caseEsbNode(mediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_CONNECTOR: {
				EsbConnector esbConnector = (EsbConnector)theEObject;
				T result = caseEsbConnector(esbConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INPUT_CONNECTOR: {
				InputConnector inputConnector = (InputConnector)theEObject;
				T result = caseInputConnector(inputConnector);
				if (result == null) result = caseEsbConnector(inputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.OUTPUT_CONNECTOR: {
				OutputConnector outputConnector = (OutputConnector)theEObject;
				T result = caseOutputConnector(outputConnector);
				if (result == null) result = caseEsbConnector(outputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR: {
				AdditionalOutputConnector additionalOutputConnector = (AdditionalOutputConnector)theEObject;
				T result = caseAdditionalOutputConnector(additionalOutputConnector);
				if (result == null) result = caseEsbConnector(additionalOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_LINK: {
				EsbLink esbLink = (EsbLink)theEObject;
				T result = caseEsbLink(esbLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.END_POINT: {
				EndPoint endPoint = (EndPoint)theEObject;
				T result = caseEndPoint(endPoint);
				if (result == null) result = caseEsbElement(endPoint);
				if (result == null) result = caseEsbNode(endPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_MEDIATOR: {
				CallMediator callMediator = (CallMediator)theEObject;
				T result = caseCallMediator(callMediator);
				if (result == null) result = caseMediator(callMediator);
				if (result == null) result = caseEsbElement(callMediator);
				if (result == null) result = caseEsbNode(callMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_MEDIATOR_INPUT_CONNECTOR: {
				CallMediatorInputConnector callMediatorInputConnector = (CallMediatorInputConnector)theEObject;
				T result = caseCallMediatorInputConnector(callMediatorInputConnector);
				if (result == null) result = caseInputConnector(callMediatorInputConnector);
				if (result == null) result = caseEsbConnector(callMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_MEDIATOR_OUTPUT_CONNECTOR: {
				CallMediatorOutputConnector callMediatorOutputConnector = (CallMediatorOutputConnector)theEObject;
				T result = caseCallMediatorOutputConnector(callMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(callMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(callMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_MEDIATOR_ENDPOINT_OUTPUT_CONNECTOR: {
				CallMediatorEndpointOutputConnector callMediatorEndpointOutputConnector = (CallMediatorEndpointOutputConnector)theEObject;
				T result = caseCallMediatorEndpointOutputConnector(callMediatorEndpointOutputConnector);
				if (result == null) result = caseOutputConnector(callMediatorEndpointOutputConnector);
				if (result == null) result = caseEsbConnector(callMediatorEndpointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.END_POINT_PROPERTY: {
				EndPointProperty endPointProperty = (EndPointProperty)theEObject;
				T result = caseEndPointProperty(endPointProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE: {
				ProxyService proxyService = (ProxyService)theEObject;
				T result = caseProxyService(proxyService);
				if (result == null) result = caseEsbElement(proxyService);
				if (result == null) result = caseEsbNode(proxyService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_OUTPUT_CONNECTOR: {
				ProxyOutputConnector proxyOutputConnector = (ProxyOutputConnector)theEObject;
				T result = caseProxyOutputConnector(proxyOutputConnector);
				if (result == null) result = caseOutputConnector(proxyOutputConnector);
				if (result == null) result = caseEsbConnector(proxyOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_INPUT_CONNECTOR: {
				ProxyInputConnector proxyInputConnector = (ProxyInputConnector)theEObject;
				T result = caseProxyInputConnector(proxyInputConnector);
				if (result == null) result = caseInputConnector(proxyInputConnector);
				if (result == null) result = caseEsbConnector(proxyInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_OUT_SEQUENCE_OUTPUT_CONNECTOR: {
				ProxyOutSequenceOutputConnector proxyOutSequenceOutputConnector = (ProxyOutSequenceOutputConnector)theEObject;
				T result = caseProxyOutSequenceOutputConnector(proxyOutSequenceOutputConnector);
				if (result == null) result = caseOutputConnector(proxyOutSequenceOutputConnector);
				if (result == null) result = caseEsbConnector(proxyOutSequenceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_IN_SEQUENCE_INPUT_CONNECTOR: {
				ProxyInSequenceInputConnector proxyInSequenceInputConnector = (ProxyInSequenceInputConnector)theEObject;
				T result = caseProxyInSequenceInputConnector(proxyInSequenceInputConnector);
				if (result == null) result = caseInputConnector(proxyInSequenceInputConnector);
				if (result == null) result = caseEsbConnector(proxyInSequenceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_WSDL_RESOURCE: {
				ProxyWSDLResource proxyWSDLResource = (ProxyWSDLResource)theEObject;
				T result = caseProxyWSDLResource(proxyWSDLResource);
				if (result == null) result = caseAbstractLocationKeyResource(proxyWSDLResource);
				if (result == null) result = caseEsbNode(proxyWSDLResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_FAULT_INPUT_CONNECTOR: {
				ProxyFaultInputConnector proxyFaultInputConnector = (ProxyFaultInputConnector)theEObject;
				T result = caseProxyFaultInputConnector(proxyFaultInputConnector);
				if (result == null) result = caseInputConnector(proxyFaultInputConnector);
				if (result == null) result = caseEsbConnector(proxyFaultInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_PARAMETER: {
				ProxyServiceParameter proxyServiceParameter = (ProxyServiceParameter)theEObject;
				T result = caseProxyServiceParameter(proxyServiceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_POLICY: {
				ProxyServicePolicy proxyServicePolicy = (ProxyServicePolicy)theEObject;
				T result = caseProxyServicePolicy(proxyServicePolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_SEQUENCE_AND_ENDPOINT_CONTAINER: {
				ProxyServiceSequenceAndEndpointContainer proxyServiceSequenceAndEndpointContainer = (ProxyServiceSequenceAndEndpointContainer)theEObject;
				T result = caseProxyServiceSequenceAndEndpointContainer(proxyServiceSequenceAndEndpointContainer);
				if (result == null) result = caseEsbNode(proxyServiceSequenceAndEndpointContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_FAULT_CONTAINER: {
				ProxyServiceFaultContainer proxyServiceFaultContainer = (ProxyServiceFaultContainer)theEObject;
				T result = caseProxyServiceFaultContainer(proxyServiceFaultContainer);
				if (result == null) result = caseEsbNode(proxyServiceFaultContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROXY_SERVICE_CONTAINER: {
				ProxyServiceContainer proxyServiceContainer = (ProxyServiceContainer)theEObject;
				T result = caseProxyServiceContainer(proxyServiceContainer);
				if (result == null) result = caseEsbNode(proxyServiceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEDIATOR_FLOW: {
				MediatorFlow mediatorFlow = (MediatorFlow)theEObject;
				T result = caseMediatorFlow(mediatorFlow);
				if (result == null) result = caseEsbNode(mediatorFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENDPOINT_FLOW: {
				EndpointFlow endpointFlow = (EndpointFlow)theEObject;
				T result = caseEndpointFlow(endpointFlow);
				if (result == null) result = caseEsbNode(endpointFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_END_POINT: {
				AbstractEndPoint abstractEndPoint = (AbstractEndPoint)theEObject;
				T result = caseAbstractEndPoint(abstractEndPoint);
				if (result == null) result = caseEndPoint(abstractEndPoint);
				if (result == null) result = caseEsbElement(abstractEndPoint);
				if (result == null) result = caseEsbNode(abstractEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_MEDIATOR: {
				MessageMediator messageMediator = (MessageMediator)theEObject;
				T result = caseMessageMediator(messageMediator);
				if (result == null) result = caseEsbElement(messageMediator);
				if (result == null) result = caseEsbNode(messageMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_INPUT_CONNECTOR: {
				MessageInputConnector messageInputConnector = (MessageInputConnector)theEObject;
				T result = caseMessageInputConnector(messageInputConnector);
				if (result == null) result = caseInputConnector(messageInputConnector);
				if (result == null) result = caseEsbConnector(messageInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_OUTPUT_CONNECTOR: {
				MessageOutputConnector messageOutputConnector = (MessageOutputConnector)theEObject;
				T result = caseMessageOutputConnector(messageOutputConnector);
				if (result == null) result = caseOutputConnector(messageOutputConnector);
				if (result == null) result = caseEsbConnector(messageOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DEFAULT_END_POINT: {
				DefaultEndPoint defaultEndPoint = (DefaultEndPoint)theEObject;
				T result = caseDefaultEndPoint(defaultEndPoint);
				if (result == null) result = caseAbstractEndPoint(defaultEndPoint);
				if (result == null) result = caseEndPoint(defaultEndPoint);
				if (result == null) result = caseEsbElement(defaultEndPoint);
				if (result == null) result = caseEsbNode(defaultEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DEFAULT_END_POINT_INPUT_CONNECTOR: {
				DefaultEndPointInputConnector defaultEndPointInputConnector = (DefaultEndPointInputConnector)theEObject;
				T result = caseDefaultEndPointInputConnector(defaultEndPointInputConnector);
				if (result == null) result = caseInputConnector(defaultEndPointInputConnector);
				if (result == null) result = caseEsbConnector(defaultEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DEFAULT_END_POINT_OUTPUT_CONNECTOR: {
				DefaultEndPointOutputConnector defaultEndPointOutputConnector = (DefaultEndPointOutputConnector)theEObject;
				T result = caseDefaultEndPointOutputConnector(defaultEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(defaultEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(defaultEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESS_END_POINT: {
				AddressEndPoint addressEndPoint = (AddressEndPoint)theEObject;
				T result = caseAddressEndPoint(addressEndPoint);
				if (result == null) result = caseAbstractEndPoint(addressEndPoint);
				if (result == null) result = caseEndPoint(addressEndPoint);
				if (result == null) result = caseEsbElement(addressEndPoint);
				if (result == null) result = caseEsbNode(addressEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESS_END_POINT_INPUT_CONNECTOR: {
				AddressEndPointInputConnector addressEndPointInputConnector = (AddressEndPointInputConnector)theEObject;
				T result = caseAddressEndPointInputConnector(addressEndPointInputConnector);
				if (result == null) result = caseInputConnector(addressEndPointInputConnector);
				if (result == null) result = caseEsbConnector(addressEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESS_END_POINT_OUTPUT_CONNECTOR: {
				AddressEndPointOutputConnector addressEndPointOutputConnector = (AddressEndPointOutputConnector)theEObject;
				T result = caseAddressEndPointOutputConnector(addressEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(addressEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(addressEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TEMPLATE_ENDPOINT: {
				TemplateEndpoint templateEndpoint = (TemplateEndpoint)theEObject;
				T result = caseTemplateEndpoint(templateEndpoint);
				if (result == null) result = caseAbstractEndPoint(templateEndpoint);
				if (result == null) result = caseEndPoint(templateEndpoint);
				if (result == null) result = caseEsbElement(templateEndpoint);
				if (result == null) result = caseEsbNode(templateEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TEMPLATE_ENDPOINT_INPUT_CONNECTOR: {
				TemplateEndpointInputConnector templateEndpointInputConnector = (TemplateEndpointInputConnector)theEObject;
				T result = caseTemplateEndpointInputConnector(templateEndpointInputConnector);
				if (result == null) result = caseInputConnector(templateEndpointInputConnector);
				if (result == null) result = caseEsbConnector(templateEndpointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TEMPLATE_ENDPOINT_OUTPUT_CONNECTOR: {
				TemplateEndpointOutputConnector templateEndpointOutputConnector = (TemplateEndpointOutputConnector)theEObject;
				T result = caseTemplateEndpointOutputConnector(templateEndpointOutputConnector);
				if (result == null) result = caseOutputConnector(templateEndpointOutputConnector);
				if (result == null) result = caseEsbConnector(templateEndpointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TEMPLATE_ENDPOINT_PARAMETER: {
				TemplateEndpointParameter templateEndpointParameter = (TemplateEndpointParameter)theEObject;
				T result = caseTemplateEndpointParameter(templateEndpointParameter);
				if (result == null) result = caseEsbNode(templateEndpointParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.HTTP_ENDPOINT: {
				HTTPEndpoint httpEndpoint = (HTTPEndpoint)theEObject;
				T result = caseHTTPEndpoint(httpEndpoint);
				if (result == null) result = caseAbstractEndPoint(httpEndpoint);
				if (result == null) result = caseEndPoint(httpEndpoint);
				if (result == null) result = caseEsbElement(httpEndpoint);
				if (result == null) result = caseEsbNode(httpEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.HTTP_END_POINT_INPUT_CONNECTOR: {
				HTTPEndPointInputConnector httpEndPointInputConnector = (HTTPEndPointInputConnector)theEObject;
				T result = caseHTTPEndPointInputConnector(httpEndPointInputConnector);
				if (result == null) result = caseInputConnector(httpEndPointInputConnector);
				if (result == null) result = caseEsbConnector(httpEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.HTTP_END_POINT_OUTPUT_CONNECTOR: {
				HTTPEndPointOutputConnector httpEndPointOutputConnector = (HTTPEndPointOutputConnector)theEObject;
				T result = caseHTTPEndPointOutputConnector(httpEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(httpEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(httpEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DROP_MEDIATOR: {
				DropMediator dropMediator = (DropMediator)theEObject;
				T result = caseDropMediator(dropMediator);
				if (result == null) result = caseMediator(dropMediator);
				if (result == null) result = caseEsbElement(dropMediator);
				if (result == null) result = caseEsbNode(dropMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DROP_MEDIATOR_INPUT_CONNECTOR: {
				DropMediatorInputConnector dropMediatorInputConnector = (DropMediatorInputConnector)theEObject;
				T result = caseDropMediatorInputConnector(dropMediatorInputConnector);
				if (result == null) result = caseInputConnector(dropMediatorInputConnector);
				if (result == null) result = caseEsbConnector(dropMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_MEDIATOR: {
				FilterMediator filterMediator = (FilterMediator)theEObject;
				T result = caseFilterMediator(filterMediator);
				if (result == null) result = caseMediator(filterMediator);
				if (result == null) result = caseEsbElement(filterMediator);
				if (result == null) result = caseEsbNode(filterMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_CONTAINER: {
				FilterContainer filterContainer = (FilterContainer)theEObject;
				T result = caseFilterContainer(filterContainer);
				if (result == null) result = caseEsbNode(filterContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_PASS_CONTAINER: {
				FilterPassContainer filterPassContainer = (FilterPassContainer)theEObject;
				T result = caseFilterPassContainer(filterPassContainer);
				if (result == null) result = caseEsbNode(filterPassContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_FAIL_CONTAINER: {
				FilterFailContainer filterFailContainer = (FilterFailContainer)theEObject;
				T result = caseFilterFailContainer(filterFailContainer);
				if (result == null) result = caseEsbNode(filterFailContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_MEDIATOR_INPUT_CONNECTOR: {
				FilterMediatorInputConnector filterMediatorInputConnector = (FilterMediatorInputConnector)theEObject;
				T result = caseFilterMediatorInputConnector(filterMediatorInputConnector);
				if (result == null) result = caseInputConnector(filterMediatorInputConnector);
				if (result == null) result = caseEsbConnector(filterMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_MEDIATOR_OUTPUT_CONNECTOR: {
				FilterMediatorOutputConnector filterMediatorOutputConnector = (FilterMediatorOutputConnector)theEObject;
				T result = caseFilterMediatorOutputConnector(filterMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(filterMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(filterMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_MEDIATOR_PASS_OUTPUT_CONNECTOR: {
				FilterMediatorPassOutputConnector filterMediatorPassOutputConnector = (FilterMediatorPassOutputConnector)theEObject;
				T result = caseFilterMediatorPassOutputConnector(filterMediatorPassOutputConnector);
				if (result == null) result = caseOutputConnector(filterMediatorPassOutputConnector);
				if (result == null) result = caseEsbConnector(filterMediatorPassOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FILTER_MEDIATOR_FAIL_OUTPUT_CONNECTOR: {
				FilterMediatorFailOutputConnector filterMediatorFailOutputConnector = (FilterMediatorFailOutputConnector)theEObject;
				T result = caseFilterMediatorFailOutputConnector(filterMediatorFailOutputConnector);
				if (result == null) result = caseOutputConnector(filterMediatorFailOutputConnector);
				if (result == null) result = caseEsbConnector(filterMediatorFailOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MERGE_NODE: {
				MergeNode mergeNode = (MergeNode)theEObject;
				T result = caseMergeNode(mergeNode);
				if (result == null) result = caseMediator(mergeNode);
				if (result == null) result = caseEsbElement(mergeNode);
				if (result == null) result = caseEsbNode(mergeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MERGE_NODE_FIRST_INPUT_CONNECTOR: {
				MergeNodeFirstInputConnector mergeNodeFirstInputConnector = (MergeNodeFirstInputConnector)theEObject;
				T result = caseMergeNodeFirstInputConnector(mergeNodeFirstInputConnector);
				if (result == null) result = caseInputConnector(mergeNodeFirstInputConnector);
				if (result == null) result = caseEsbConnector(mergeNodeFirstInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MERGE_NODE_SECOND_INPUT_CONNECTOR: {
				MergeNodeSecondInputConnector mergeNodeSecondInputConnector = (MergeNodeSecondInputConnector)theEObject;
				T result = caseMergeNodeSecondInputConnector(mergeNodeSecondInputConnector);
				if (result == null) result = caseInputConnector(mergeNodeSecondInputConnector);
				if (result == null) result = caseEsbConnector(mergeNodeSecondInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MERGE_NODE_OUTPUT_CONNECTOR: {
				MergeNodeOutputConnector mergeNodeOutputConnector = (MergeNodeOutputConnector)theEObject;
				T result = caseMergeNodeOutputConnector(mergeNodeOutputConnector);
				if (result == null) result = caseOutputConnector(mergeNodeOutputConnector);
				if (result == null) result = caseEsbConnector(mergeNodeOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOG_MEDIATOR: {
				LogMediator logMediator = (LogMediator)theEObject;
				T result = caseLogMediator(logMediator);
				if (result == null) result = caseMediator(logMediator);
				if (result == null) result = caseEsbElement(logMediator);
				if (result == null) result = caseEsbNode(logMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOG_MEDIATOR_INPUT_CONNECTOR: {
				LogMediatorInputConnector logMediatorInputConnector = (LogMediatorInputConnector)theEObject;
				T result = caseLogMediatorInputConnector(logMediatorInputConnector);
				if (result == null) result = caseInputConnector(logMediatorInputConnector);
				if (result == null) result = caseEsbConnector(logMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOG_MEDIATOR_OUTPUT_CONNECTOR: {
				LogMediatorOutputConnector logMediatorOutputConnector = (LogMediatorOutputConnector)theEObject;
				T result = caseLogMediatorOutputConnector(logMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(logMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(logMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOG_PROPERTY: {
				LogProperty logProperty = (LogProperty)theEObject;
				T result = caseLogProperty(logProperty);
				if (result == null) result = caseAbstractNameValueExpressionProperty(logProperty);
				if (result == null) result = caseEsbNode(logProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PUBLISH_EVENT_MEDIATOR: {
				PublishEventMediator publishEventMediator = (PublishEventMediator)theEObject;
				T result = casePublishEventMediator(publishEventMediator);
				if (result == null) result = caseMediator(publishEventMediator);
				if (result == null) result = caseEsbElement(publishEventMediator);
				if (result == null) result = caseEsbNode(publishEventMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PUBLISH_EVENT_MEDIATOR_INPUT_CONNECTOR: {
				PublishEventMediatorInputConnector publishEventMediatorInputConnector = (PublishEventMediatorInputConnector)theEObject;
				T result = casePublishEventMediatorInputConnector(publishEventMediatorInputConnector);
				if (result == null) result = caseInputConnector(publishEventMediatorInputConnector);
				if (result == null) result = caseEsbConnector(publishEventMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PUBLISH_EVENT_MEDIATOR_OUTPUT_CONNECTOR: {
				PublishEventMediatorOutputConnector publishEventMediatorOutputConnector = (PublishEventMediatorOutputConnector)theEObject;
				T result = casePublishEventMediatorOutputConnector(publishEventMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(publishEventMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(publishEventMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PUBLISH_EVENT_MEDIATOR_ATTRIBUTE: {
				PublishEventMediatorAttribute publishEventMediatorAttribute = (PublishEventMediatorAttribute)theEObject;
				T result = casePublishEventMediatorAttribute(publishEventMediatorAttribute);
				if (result == null) result = caseAbstractNameValueExpressionAttribute(publishEventMediatorAttribute);
				if (result == null) result = caseEsbNode(publishEventMediatorAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE: {
				AbstractNameValueExpressionAttribute abstractNameValueExpressionAttribute = (AbstractNameValueExpressionAttribute)theEObject;
				T result = caseAbstractNameValueExpressionAttribute(abstractNameValueExpressionAttribute);
				if (result == null) result = caseEsbNode(abstractNameValueExpressionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BAM_MEDIATOR: {
				BAMMediator bamMediator = (BAMMediator)theEObject;
				T result = caseBAMMediator(bamMediator);
				if (result == null) result = caseMediator(bamMediator);
				if (result == null) result = caseEsbElement(bamMediator);
				if (result == null) result = caseEsbNode(bamMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BAM_MEDIATOR_INPUT_CONNECTOR: {
				BAMMediatorInputConnector bamMediatorInputConnector = (BAMMediatorInputConnector)theEObject;
				T result = caseBAMMediatorInputConnector(bamMediatorInputConnector);
				if (result == null) result = caseInputConnector(bamMediatorInputConnector);
				if (result == null) result = caseEsbConnector(bamMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BAM_MEDIATOR_OUTPUT_CONNECTOR: {
				BAMMediatorOutputConnector bamMediatorOutputConnector = (BAMMediatorOutputConnector)theEObject;
				T result = caseBAMMediatorOutputConnector(bamMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(bamMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(bamMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BEAN_MEDIATOR: {
				BeanMediator beanMediator = (BeanMediator)theEObject;
				T result = caseBeanMediator(beanMediator);
				if (result == null) result = caseMediator(beanMediator);
				if (result == null) result = caseEsbElement(beanMediator);
				if (result == null) result = caseEsbNode(beanMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BEAN_MEDIATOR_INPUT_CONNECTOR: {
				BeanMediatorInputConnector beanMediatorInputConnector = (BeanMediatorInputConnector)theEObject;
				T result = caseBeanMediatorInputConnector(beanMediatorInputConnector);
				if (result == null) result = caseInputConnector(beanMediatorInputConnector);
				if (result == null) result = caseEsbConnector(beanMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BEAN_MEDIATOR_OUTPUT_CONNECTOR: {
				BeanMediatorOutputConnector beanMediatorOutputConnector = (BeanMediatorOutputConnector)theEObject;
				T result = caseBeanMediatorOutputConnector(beanMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(beanMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(beanMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EJB_MEDIATOR: {
				EJBMediator ejbMediator = (EJBMediator)theEObject;
				T result = caseEJBMediator(ejbMediator);
				if (result == null) result = caseMediator(ejbMediator);
				if (result == null) result = caseEsbElement(ejbMediator);
				if (result == null) result = caseEsbNode(ejbMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EJB_MEDIATOR_INPUT_CONNECTOR: {
				EJBMediatorInputConnector ejbMediatorInputConnector = (EJBMediatorInputConnector)theEObject;
				T result = caseEJBMediatorInputConnector(ejbMediatorInputConnector);
				if (result == null) result = caseInputConnector(ejbMediatorInputConnector);
				if (result == null) result = caseEsbConnector(ejbMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EJB_MEDIATOR_OUTPUT_CONNECTOR: {
				EJBMediatorOutputConnector ejbMediatorOutputConnector = (EJBMediatorOutputConnector)theEObject;
				T result = caseEJBMediatorOutputConnector(ejbMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(ejbMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(ejbMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.METHOD_ARGUMENT: {
				MethodArgument methodArgument = (MethodArgument)theEObject;
				T result = caseMethodArgument(methodArgument);
				if (result == null) result = caseAbstractNameValueExpressionProperty(methodArgument);
				if (result == null) result = caseEsbNode(methodArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.REGISTRY_KEY_PROPERTY: {
				RegistryKeyProperty registryKeyProperty = (RegistryKeyProperty)theEObject;
				T result = caseRegistryKeyProperty(registryKeyProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROPERTY_MEDIATOR: {
				PropertyMediator propertyMediator = (PropertyMediator)theEObject;
				T result = casePropertyMediator(propertyMediator);
				if (result == null) result = caseMediator(propertyMediator);
				if (result == null) result = caseEsbElement(propertyMediator);
				if (result == null) result = caseEsbNode(propertyMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROPERTY_MEDIATOR_INPUT_CONNECTOR: {
				PropertyMediatorInputConnector propertyMediatorInputConnector = (PropertyMediatorInputConnector)theEObject;
				T result = casePropertyMediatorInputConnector(propertyMediatorInputConnector);
				if (result == null) result = caseInputConnector(propertyMediatorInputConnector);
				if (result == null) result = caseEsbConnector(propertyMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PROPERTY_MEDIATOR_OUTPUT_CONNECTOR: {
				PropertyMediatorOutputConnector propertyMediatorOutputConnector = (PropertyMediatorOutputConnector)theEObject;
				T result = casePropertyMediatorOutputConnector(propertyMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(propertyMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(propertyMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAMESPACED_PROPERTY: {
				NamespacedProperty namespacedProperty = (NamespacedProperty)theEObject;
				T result = caseNamespacedProperty(namespacedProperty);
				if (result == null) result = caseEsbNode(namespacedProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENRICH_MEDIATOR: {
				EnrichMediator enrichMediator = (EnrichMediator)theEObject;
				T result = caseEnrichMediator(enrichMediator);
				if (result == null) result = caseMediator(enrichMediator);
				if (result == null) result = caseEsbElement(enrichMediator);
				if (result == null) result = caseEsbNode(enrichMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENRICH_MEDIATOR_INPUT_CONNECTOR: {
				EnrichMediatorInputConnector enrichMediatorInputConnector = (EnrichMediatorInputConnector)theEObject;
				T result = caseEnrichMediatorInputConnector(enrichMediatorInputConnector);
				if (result == null) result = caseInputConnector(enrichMediatorInputConnector);
				if (result == null) result = caseEsbConnector(enrichMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENRICH_MEDIATOR_OUTPUT_CONNECTOR: {
				EnrichMediatorOutputConnector enrichMediatorOutputConnector = (EnrichMediatorOutputConnector)theEObject;
				T result = caseEnrichMediatorOutputConnector(enrichMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(enrichMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(enrichMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY: {
				AbstractNameValueExpressionProperty abstractNameValueExpressionProperty = (AbstractNameValueExpressionProperty)theEObject;
				T result = caseAbstractNameValueExpressionProperty(abstractNameValueExpressionProperty);
				if (result == null) result = caseEsbNode(abstractNameValueExpressionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_BOOLEAN_FEATURE: {
				AbstractBooleanFeature abstractBooleanFeature = (AbstractBooleanFeature)theEObject;
				T result = caseAbstractBooleanFeature(abstractBooleanFeature);
				if (result == null) result = caseEsbNode(abstractBooleanFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE: {
				AbstractLocationKeyResource abstractLocationKeyResource = (AbstractLocationKeyResource)theEObject;
				T result = caseAbstractLocationKeyResource(abstractLocationKeyResource);
				if (result == null) result = caseEsbNode(abstractLocationKeyResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XSLT_MEDIATOR: {
				XSLTMediator xsltMediator = (XSLTMediator)theEObject;
				T result = caseXSLTMediator(xsltMediator);
				if (result == null) result = caseMediator(xsltMediator);
				if (result == null) result = caseEsbElement(xsltMediator);
				if (result == null) result = caseEsbNode(xsltMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XSLT_PROPERTY: {
				XSLTProperty xsltProperty = (XSLTProperty)theEObject;
				T result = caseXSLTProperty(xsltProperty);
				if (result == null) result = caseAbstractNameValueExpressionProperty(xsltProperty);
				if (result == null) result = caseEsbNode(xsltProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XSLT_FEATURE: {
				XSLTFeature xsltFeature = (XSLTFeature)theEObject;
				T result = caseXSLTFeature(xsltFeature);
				if (result == null) result = caseAbstractBooleanFeature(xsltFeature);
				if (result == null) result = caseEsbNode(xsltFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XSLT_RESOURCE: {
				XSLTResource xsltResource = (XSLTResource)theEObject;
				T result = caseXSLTResource(xsltResource);
				if (result == null) result = caseAbstractLocationKeyResource(xsltResource);
				if (result == null) result = caseEsbNode(xsltResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XSLT_MEDIATOR_INPUT_CONNECTOR: {
				XSLTMediatorInputConnector xsltMediatorInputConnector = (XSLTMediatorInputConnector)theEObject;
				T result = caseXSLTMediatorInputConnector(xsltMediatorInputConnector);
				if (result == null) result = caseInputConnector(xsltMediatorInputConnector);
				if (result == null) result = caseEsbConnector(xsltMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XSLT_MEDIATOR_OUTPUT_CONNECTOR: {
				XSLTMediatorOutputConnector xsltMediatorOutputConnector = (XSLTMediatorOutputConnector)theEObject;
				T result = caseXSLTMediatorOutputConnector(xsltMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(xsltMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(xsltMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_MEDIATOR: {
				SwitchMediator switchMediator = (SwitchMediator)theEObject;
				T result = caseSwitchMediator(switchMediator);
				if (result == null) result = caseMediator(switchMediator);
				if (result == null) result = caseEsbElement(switchMediator);
				if (result == null) result = caseEsbNode(switchMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR: {
				SwitchCaseBranchOutputConnector switchCaseBranchOutputConnector = (SwitchCaseBranchOutputConnector)theEObject;
				T result = caseSwitchCaseBranchOutputConnector(switchCaseBranchOutputConnector);
				if (result == null) result = caseOutputConnector(switchCaseBranchOutputConnector);
				if (result == null) result = caseEsbConnector(switchCaseBranchOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_DEFAULT_BRANCH_OUTPUT_CONNECTOR: {
				SwitchDefaultBranchOutputConnector switchDefaultBranchOutputConnector = (SwitchDefaultBranchOutputConnector)theEObject;
				T result = caseSwitchDefaultBranchOutputConnector(switchDefaultBranchOutputConnector);
				if (result == null) result = caseOutputConnector(switchDefaultBranchOutputConnector);
				if (result == null) result = caseEsbConnector(switchDefaultBranchOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_MEDIATOR_INPUT_CONNECTOR: {
				SwitchMediatorInputConnector switchMediatorInputConnector = (SwitchMediatorInputConnector)theEObject;
				T result = caseSwitchMediatorInputConnector(switchMediatorInputConnector);
				if (result == null) result = caseInputConnector(switchMediatorInputConnector);
				if (result == null) result = caseEsbConnector(switchMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_MEDIATOR_OUTPUT_CONNECTOR: {
				SwitchMediatorOutputConnector switchMediatorOutputConnector = (SwitchMediatorOutputConnector)theEObject;
				T result = caseSwitchMediatorOutputConnector(switchMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(switchMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(switchMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER: {
				SwitchMediatorContainer switchMediatorContainer = (SwitchMediatorContainer)theEObject;
				T result = caseSwitchMediatorContainer(switchMediatorContainer);
				if (result == null) result = caseEsbNode(switchMediatorContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER: {
				SwitchCaseParentContainer switchCaseParentContainer = (SwitchCaseParentContainer)theEObject;
				T result = caseSwitchCaseParentContainer(switchCaseParentContainer);
				if (result == null) result = caseEsbNode(switchCaseParentContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER: {
				SwitchDefaultParentContainer switchDefaultParentContainer = (SwitchDefaultParentContainer)theEObject;
				T result = caseSwitchDefaultParentContainer(switchDefaultParentContainer);
				if (result == null) result = caseEsbNode(switchDefaultParentContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_CASE_CONTAINER: {
				SwitchCaseContainer switchCaseContainer = (SwitchCaseContainer)theEObject;
				T result = caseSwitchCaseContainer(switchCaseContainer);
				if (result == null) result = caseEsbNode(switchCaseContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SWITCH_DEFAULT_CONTAINER: {
				SwitchDefaultContainer switchDefaultContainer = (SwitchDefaultContainer)theEObject;
				T result = caseSwitchDefaultContainer(switchDefaultContainer);
				if (result == null) result = caseEsbNode(switchDefaultContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCE_DIAGRAM: {
				SequenceDiagram sequenceDiagram = (SequenceDiagram)theEObject;
				T result = caseSequenceDiagram(sequenceDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_SEQUENCE: {
				EsbSequence esbSequence = (EsbSequence)theEObject;
				T result = caseEsbSequence(esbSequence);
				if (result == null) result = caseEsbNode(esbSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_SEQUENCE_INPUT: {
				EsbSequenceInput esbSequenceInput = (EsbSequenceInput)theEObject;
				T result = caseEsbSequenceInput(esbSequenceInput);
				if (result == null) result = caseEsbNode(esbSequenceInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_SEQUENCE_OUTPUT: {
				EsbSequenceOutput esbSequenceOutput = (EsbSequenceOutput)theEObject;
				T result = caseEsbSequenceOutput(esbSequenceOutput);
				if (result == null) result = caseEsbNode(esbSequenceOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_SEQUENCE_INPUT_CONNECTOR: {
				EsbSequenceInputConnector esbSequenceInputConnector = (EsbSequenceInputConnector)theEObject;
				T result = caseEsbSequenceInputConnector(esbSequenceInputConnector);
				if (result == null) result = caseOutputConnector(esbSequenceInputConnector);
				if (result == null) result = caseEsbConnector(esbSequenceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ESB_SEQUENCE_OUTPUT_CONNECTOR: {
				EsbSequenceOutputConnector esbSequenceOutputConnector = (EsbSequenceOutputConnector)theEObject;
				T result = caseEsbSequenceOutputConnector(esbSequenceOutputConnector);
				if (result == null) result = caseInputConnector(esbSequenceOutputConnector);
				if (result == null) result = caseEsbConnector(esbSequenceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseMediator(sequence);
				if (result == null) result = caseEsbElement(sequence);
				if (result == null) result = caseEsbNode(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCE_INPUT_CONNECTOR: {
				SequenceInputConnector sequenceInputConnector = (SequenceInputConnector)theEObject;
				T result = caseSequenceInputConnector(sequenceInputConnector);
				if (result == null) result = caseInputConnector(sequenceInputConnector);
				if (result == null) result = caseEsbConnector(sequenceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCE_OUTPUT_CONNECTOR: {
				SequenceOutputConnector sequenceOutputConnector = (SequenceOutputConnector)theEObject;
				T result = caseSequenceOutputConnector(sequenceOutputConnector);
				if (result == null) result = caseOutputConnector(sequenceOutputConnector);
				if (result == null) result = caseEsbConnector(sequenceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EVENT_MEDIATOR: {
				EventMediator eventMediator = (EventMediator)theEObject;
				T result = caseEventMediator(eventMediator);
				if (result == null) result = caseMediator(eventMediator);
				if (result == null) result = caseEsbElement(eventMediator);
				if (result == null) result = caseEsbNode(eventMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EVENT_MEDIATOR_INPUT_CONNECTOR: {
				EventMediatorInputConnector eventMediatorInputConnector = (EventMediatorInputConnector)theEObject;
				T result = caseEventMediatorInputConnector(eventMediatorInputConnector);
				if (result == null) result = caseInputConnector(eventMediatorInputConnector);
				if (result == null) result = caseEsbConnector(eventMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EVENT_MEDIATOR_OUTPUT_CONNECTOR: {
				EventMediatorOutputConnector eventMediatorOutputConnector = (EventMediatorOutputConnector)theEObject;
				T result = caseEventMediatorOutputConnector(eventMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(eventMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(eventMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY: {
				AbstractNameValueProperty abstractNameValueProperty = (AbstractNameValueProperty)theEObject;
				T result = caseAbstractNameValueProperty(abstractNameValueProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR: {
				EntitlementMediator entitlementMediator = (EntitlementMediator)theEObject;
				T result = caseEntitlementMediator(entitlementMediator);
				if (result == null) result = caseMediator(entitlementMediator);
				if (result == null) result = caseEsbElement(entitlementMediator);
				if (result == null) result = caseEsbNode(entitlementMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR_INPUT_CONNECTOR: {
				EntitlementMediatorInputConnector entitlementMediatorInputConnector = (EntitlementMediatorInputConnector)theEObject;
				T result = caseEntitlementMediatorInputConnector(entitlementMediatorInputConnector);
				if (result == null) result = caseInputConnector(entitlementMediatorInputConnector);
				if (result == null) result = caseEsbConnector(entitlementMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR_OUTPUT_CONNECTOR: {
				EntitlementMediatorOutputConnector entitlementMediatorOutputConnector = (EntitlementMediatorOutputConnector)theEObject;
				T result = caseEntitlementMediatorOutputConnector(entitlementMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(entitlementMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(entitlementMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR_ON_REJECT_OUTPUT_CONNECTOR: {
				EntitlementMediatorOnRejectOutputConnector entitlementMediatorOnRejectOutputConnector = (EntitlementMediatorOnRejectOutputConnector)theEObject;
				T result = caseEntitlementMediatorOnRejectOutputConnector(entitlementMediatorOnRejectOutputConnector);
				if (result == null) result = caseOutputConnector(entitlementMediatorOnRejectOutputConnector);
				if (result == null) result = caseEsbConnector(entitlementMediatorOnRejectOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR_ON_ACCEPT_OUTPUT_CONNECTOR: {
				EntitlementMediatorOnAcceptOutputConnector entitlementMediatorOnAcceptOutputConnector = (EntitlementMediatorOnAcceptOutputConnector)theEObject;
				T result = caseEntitlementMediatorOnAcceptOutputConnector(entitlementMediatorOnAcceptOutputConnector);
				if (result == null) result = caseOutputConnector(entitlementMediatorOnAcceptOutputConnector);
				if (result == null) result = caseEsbConnector(entitlementMediatorOnAcceptOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR_ADVICE_OUTPUT_CONNECTOR: {
				EntitlementMediatorAdviceOutputConnector entitlementMediatorAdviceOutputConnector = (EntitlementMediatorAdviceOutputConnector)theEObject;
				T result = caseEntitlementMediatorAdviceOutputConnector(entitlementMediatorAdviceOutputConnector);
				if (result == null) result = caseOutputConnector(entitlementMediatorAdviceOutputConnector);
				if (result == null) result = caseEsbConnector(entitlementMediatorAdviceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_MEDIATOR_OBLIGATIONS_OUTPUT_CONNECTOR: {
				EntitlementMediatorObligationsOutputConnector entitlementMediatorObligationsOutputConnector = (EntitlementMediatorObligationsOutputConnector)theEObject;
				T result = caseEntitlementMediatorObligationsOutputConnector(entitlementMediatorObligationsOutputConnector);
				if (result == null) result = caseOutputConnector(entitlementMediatorObligationsOutputConnector);
				if (result == null) result = caseEsbConnector(entitlementMediatorObligationsOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_CONTAINER: {
				EntitlementContainer entitlementContainer = (EntitlementContainer)theEObject;
				T result = caseEntitlementContainer(entitlementContainer);
				if (result == null) result = caseEsbNode(entitlementContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_ON_REJECT_CONTAINER: {
				EntitlementOnRejectContainer entitlementOnRejectContainer = (EntitlementOnRejectContainer)theEObject;
				T result = caseEntitlementOnRejectContainer(entitlementOnRejectContainer);
				if (result == null) result = caseEsbNode(entitlementOnRejectContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_ON_ACCEPT_CONTAINER: {
				EntitlementOnAcceptContainer entitlementOnAcceptContainer = (EntitlementOnAcceptContainer)theEObject;
				T result = caseEntitlementOnAcceptContainer(entitlementOnAcceptContainer);
				if (result == null) result = caseEsbNode(entitlementOnAcceptContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_ADVICE_CONTAINER: {
				EntitlementAdviceContainer entitlementAdviceContainer = (EntitlementAdviceContainer)theEObject;
				T result = caseEntitlementAdviceContainer(entitlementAdviceContainer);
				if (result == null) result = caseEsbNode(entitlementAdviceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENTITLEMENT_OBLIGATIONS_CONTAINER: {
				EntitlementObligationsContainer entitlementObligationsContainer = (EntitlementObligationsContainer)theEObject;
				T result = caseEntitlementObligationsContainer(entitlementObligationsContainer);
				if (result == null) result = caseEsbNode(entitlementObligationsContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENQUEUE_MEDIATOR: {
				EnqueueMediator enqueueMediator = (EnqueueMediator)theEObject;
				T result = caseEnqueueMediator(enqueueMediator);
				if (result == null) result = caseMediator(enqueueMediator);
				if (result == null) result = caseEsbElement(enqueueMediator);
				if (result == null) result = caseEsbNode(enqueueMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENQUEUE_MEDIATOR_INPUT_CONNECTOR: {
				EnqueueMediatorInputConnector enqueueMediatorInputConnector = (EnqueueMediatorInputConnector)theEObject;
				T result = caseEnqueueMediatorInputConnector(enqueueMediatorInputConnector);
				if (result == null) result = caseInputConnector(enqueueMediatorInputConnector);
				if (result == null) result = caseEsbConnector(enqueueMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENQUEUE_MEDIATOR_OUTPUT_CONNECTOR: {
				EnqueueMediatorOutputConnector enqueueMediatorOutputConnector = (EnqueueMediatorOutputConnector)theEObject;
				T result = caseEnqueueMediatorOutputConnector(enqueueMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(enqueueMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(enqueueMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLASS_MEDIATOR: {
				ClassMediator classMediator = (ClassMediator)theEObject;
				T result = caseClassMediator(classMediator);
				if (result == null) result = caseMediator(classMediator);
				if (result == null) result = caseEsbElement(classMediator);
				if (result == null) result = caseEsbNode(classMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLASS_MEDIATOR_INPUT_CONNECTOR: {
				ClassMediatorInputConnector classMediatorInputConnector = (ClassMediatorInputConnector)theEObject;
				T result = caseClassMediatorInputConnector(classMediatorInputConnector);
				if (result == null) result = caseInputConnector(classMediatorInputConnector);
				if (result == null) result = caseEsbConnector(classMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLASS_MEDIATOR_OUTPUT_CONNECTOR: {
				ClassMediatorOutputConnector classMediatorOutputConnector = (ClassMediatorOutputConnector)theEObject;
				T result = caseClassMediatorOutputConnector(classMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(classMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(classMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLASS_PROPERTY: {
				ClassProperty classProperty = (ClassProperty)theEObject;
				T result = caseClassProperty(classProperty);
				if (result == null) result = caseAbstractNameValueProperty(classProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SPRING_MEDIATOR: {
				SpringMediator springMediator = (SpringMediator)theEObject;
				T result = caseSpringMediator(springMediator);
				if (result == null) result = caseMediator(springMediator);
				if (result == null) result = caseEsbElement(springMediator);
				if (result == null) result = caseEsbNode(springMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SPRING_MEDIATOR_INPUT_CONNECTOR: {
				SpringMediatorInputConnector springMediatorInputConnector = (SpringMediatorInputConnector)theEObject;
				T result = caseSpringMediatorInputConnector(springMediatorInputConnector);
				if (result == null) result = caseInputConnector(springMediatorInputConnector);
				if (result == null) result = caseEsbConnector(springMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SPRING_MEDIATOR_OUTPUT_CONNECTOR: {
				SpringMediatorOutputConnector springMediatorOutputConnector = (SpringMediatorOutputConnector)theEObject;
				T result = caseSpringMediatorOutputConnector(springMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(springMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(springMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SCRIPT_MEDIATOR: {
				ScriptMediator scriptMediator = (ScriptMediator)theEObject;
				T result = caseScriptMediator(scriptMediator);
				if (result == null) result = caseMediator(scriptMediator);
				if (result == null) result = caseEsbElement(scriptMediator);
				if (result == null) result = caseEsbNode(scriptMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SCRIPT_MEDIATOR_INPUT_CONNECTOR: {
				ScriptMediatorInputConnector scriptMediatorInputConnector = (ScriptMediatorInputConnector)theEObject;
				T result = caseScriptMediatorInputConnector(scriptMediatorInputConnector);
				if (result == null) result = caseInputConnector(scriptMediatorInputConnector);
				if (result == null) result = caseEsbConnector(scriptMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SCRIPT_MEDIATOR_OUTPUT_CONNECTOR: {
				ScriptMediatorOutputConnector scriptMediatorOutputConnector = (ScriptMediatorOutputConnector)theEObject;
				T result = caseScriptMediatorOutputConnector(scriptMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(scriptMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(scriptMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAULT_MEDIATOR: {
				FaultMediator faultMediator = (FaultMediator)theEObject;
				T result = caseFaultMediator(faultMediator);
				if (result == null) result = caseMediator(faultMediator);
				if (result == null) result = caseEsbElement(faultMediator);
				if (result == null) result = caseEsbNode(faultMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAULT_MEDIATOR_INPUT_CONNECTOR: {
				FaultMediatorInputConnector faultMediatorInputConnector = (FaultMediatorInputConnector)theEObject;
				T result = caseFaultMediatorInputConnector(faultMediatorInputConnector);
				if (result == null) result = caseInputConnector(faultMediatorInputConnector);
				if (result == null) result = caseEsbConnector(faultMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAULT_MEDIATOR_OUTPUT_CONNECTOR: {
				FaultMediatorOutputConnector faultMediatorOutputConnector = (FaultMediatorOutputConnector)theEObject;
				T result = caseFaultMediatorOutputConnector(faultMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(faultMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(faultMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.AGGREGATE_MEDIATOR: {
				AggregateMediator aggregateMediator = (AggregateMediator)theEObject;
				T result = caseAggregateMediator(aggregateMediator);
				if (result == null) result = caseMediator(aggregateMediator);
				if (result == null) result = caseEsbElement(aggregateMediator);
				if (result == null) result = caseEsbNode(aggregateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.AGGREGATE_MEDIATOR_INPUT_CONNECTOR: {
				AggregateMediatorInputConnector aggregateMediatorInputConnector = (AggregateMediatorInputConnector)theEObject;
				T result = caseAggregateMediatorInputConnector(aggregateMediatorInputConnector);
				if (result == null) result = caseInputConnector(aggregateMediatorInputConnector);
				if (result == null) result = caseEsbConnector(aggregateMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.AGGREGATE_MEDIATOR_OUTPUT_CONNECTOR: {
				AggregateMediatorOutputConnector aggregateMediatorOutputConnector = (AggregateMediatorOutputConnector)theEObject;
				T result = caseAggregateMediatorOutputConnector(aggregateMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(aggregateMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(aggregateMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.AGGREGATE_MEDIATOR_ON_COMPLETE_OUTPUT_CONNECTOR: {
				AggregateMediatorOnCompleteOutputConnector aggregateMediatorOnCompleteOutputConnector = (AggregateMediatorOnCompleteOutputConnector)theEObject;
				T result = caseAggregateMediatorOnCompleteOutputConnector(aggregateMediatorOnCompleteOutputConnector);
				if (result == null) result = caseOutputConnector(aggregateMediatorOnCompleteOutputConnector);
				if (result == null) result = caseEsbConnector(aggregateMediatorOnCompleteOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_MEDIATOR: {
				RouterMediator routerMediator = (RouterMediator)theEObject;
				T result = caseRouterMediator(routerMediator);
				if (result == null) result = caseMediator(routerMediator);
				if (result == null) result = caseEsbElement(routerMediator);
				if (result == null) result = caseEsbNode(routerMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_ROUTE: {
				RouterRoute routerRoute = (RouterRoute)theEObject;
				T result = caseRouterRoute(routerRoute);
				if (result == null) result = caseEsbNode(routerRoute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_TARGET: {
				RouterTarget routerTarget = (RouterTarget)theEObject;
				T result = caseRouterTarget(routerTarget);
				if (result == null) result = caseAbstractCommonTarget(routerTarget);
				if (result == null) result = caseEsbNode(routerTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_MEDIATOR_INPUT_CONNECTOR: {
				RouterMediatorInputConnector routerMediatorInputConnector = (RouterMediatorInputConnector)theEObject;
				T result = caseRouterMediatorInputConnector(routerMediatorInputConnector);
				if (result == null) result = caseInputConnector(routerMediatorInputConnector);
				if (result == null) result = caseEsbConnector(routerMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_MEDIATOR_OUTPUT_CONNECTOR: {
				RouterMediatorOutputConnector routerMediatorOutputConnector = (RouterMediatorOutputConnector)theEObject;
				T result = caseRouterMediatorOutputConnector(routerMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(routerMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(routerMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_MEDIATOR_TARGET_OUTPUT_CONNECTOR: {
				RouterMediatorTargetOutputConnector routerMediatorTargetOutputConnector = (RouterMediatorTargetOutputConnector)theEObject;
				T result = caseRouterMediatorTargetOutputConnector(routerMediatorTargetOutputConnector);
				if (result == null) result = caseOutputConnector(routerMediatorTargetOutputConnector);
				if (result == null) result = caseEsbConnector(routerMediatorTargetOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER: {
				RouterMediatorContainer routerMediatorContainer = (RouterMediatorContainer)theEObject;
				T result = caseRouterMediatorContainer(routerMediatorContainer);
				if (result == null) result = caseEsbNode(routerMediatorContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ROUTER_TARGET_CONTAINER: {
				RouterTargetContainer routerTargetContainer = (RouterTargetContainer)theEObject;
				T result = caseRouterTargetContainer(routerTargetContainer);
				if (result == null) result = caseEsbNode(routerTargetContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_MEDIATOR: {
				CloneMediator cloneMediator = (CloneMediator)theEObject;
				T result = caseCloneMediator(cloneMediator);
				if (result == null) result = caseMediator(cloneMediator);
				if (result == null) result = caseEsbElement(cloneMediator);
				if (result == null) result = caseEsbNode(cloneMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_TARGET: {
				CloneTarget cloneTarget = (CloneTarget)theEObject;
				T result = caseCloneTarget(cloneTarget);
				if (result == null) result = caseAbstractCommonTarget(cloneTarget);
				if (result == null) result = caseEsbNode(cloneTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_MEDIATOR_INPUT_CONNECTOR: {
				CloneMediatorInputConnector cloneMediatorInputConnector = (CloneMediatorInputConnector)theEObject;
				T result = caseCloneMediatorInputConnector(cloneMediatorInputConnector);
				if (result == null) result = caseInputConnector(cloneMediatorInputConnector);
				if (result == null) result = caseEsbConnector(cloneMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_MEDIATOR_OUTPUT_CONNECTOR: {
				CloneMediatorOutputConnector cloneMediatorOutputConnector = (CloneMediatorOutputConnector)theEObject;
				T result = caseCloneMediatorOutputConnector(cloneMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(cloneMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(cloneMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR: {
				CloneMediatorTargetOutputConnector cloneMediatorTargetOutputConnector = (CloneMediatorTargetOutputConnector)theEObject;
				T result = caseCloneMediatorTargetOutputConnector(cloneMediatorTargetOutputConnector);
				if (result == null) result = caseOutputConnector(cloneMediatorTargetOutputConnector);
				if (result == null) result = caseEsbConnector(cloneMediatorTargetOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_MEDIATOR_CONTAINER: {
				CloneMediatorContainer cloneMediatorContainer = (CloneMediatorContainer)theEObject;
				T result = caseCloneMediatorContainer(cloneMediatorContainer);
				if (result == null) result = caseEsbNode(cloneMediatorContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLONE_TARGET_CONTAINER: {
				CloneTargetContainer cloneTargetContainer = (CloneTargetContainer)theEObject;
				T result = caseCloneTargetContainer(cloneTargetContainer);
				if (result == null) result = caseEsbNode(cloneTargetContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FOR_EACH_MEDIATOR: {
				ForEachMediator forEachMediator = (ForEachMediator)theEObject;
				T result = caseForEachMediator(forEachMediator);
				if (result == null) result = caseMediator(forEachMediator);
				if (result == null) result = caseEsbElement(forEachMediator);
				if (result == null) result = caseEsbNode(forEachMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FOR_EACH_MEDIATOR_INPUT_CONNECTOR: {
				ForEachMediatorInputConnector forEachMediatorInputConnector = (ForEachMediatorInputConnector)theEObject;
				T result = caseForEachMediatorInputConnector(forEachMediatorInputConnector);
				if (result == null) result = caseInputConnector(forEachMediatorInputConnector);
				if (result == null) result = caseEsbConnector(forEachMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FOR_EACH_MEDIATOR_OUTPUT_CONNECTOR: {
				ForEachMediatorOutputConnector forEachMediatorOutputConnector = (ForEachMediatorOutputConnector)theEObject;
				T result = caseForEachMediatorOutputConnector(forEachMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(forEachMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(forEachMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FOR_EACH_MEDIATOR_TARGET_OUTPUT_CONNECTOR: {
				ForEachMediatorTargetOutputConnector forEachMediatorTargetOutputConnector = (ForEachMediatorTargetOutputConnector)theEObject;
				T result = caseForEachMediatorTargetOutputConnector(forEachMediatorTargetOutputConnector);
				if (result == null) result = caseOutputConnector(forEachMediatorTargetOutputConnector);
				if (result == null) result = caseEsbConnector(forEachMediatorTargetOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FOR_EACH_TARGET: {
				ForEachTarget forEachTarget = (ForEachTarget)theEObject;
				T result = caseForEachTarget(forEachTarget);
				if (result == null) result = caseAbstractCommonTarget(forEachTarget);
				if (result == null) result = caseEsbNode(forEachTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ITERATE_MEDIATOR: {
				IterateMediator iterateMediator = (IterateMediator)theEObject;
				T result = caseIterateMediator(iterateMediator);
				if (result == null) result = caseMediator(iterateMediator);
				if (result == null) result = caseEsbElement(iterateMediator);
				if (result == null) result = caseEsbNode(iterateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ITERATE_MEDIATOR_INPUT_CONNECTOR: {
				IterateMediatorInputConnector iterateMediatorInputConnector = (IterateMediatorInputConnector)theEObject;
				T result = caseIterateMediatorInputConnector(iterateMediatorInputConnector);
				if (result == null) result = caseInputConnector(iterateMediatorInputConnector);
				if (result == null) result = caseEsbConnector(iterateMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ITERATE_MEDIATOR_OUTPUT_CONNECTOR: {
				IterateMediatorOutputConnector iterateMediatorOutputConnector = (IterateMediatorOutputConnector)theEObject;
				T result = caseIterateMediatorOutputConnector(iterateMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(iterateMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(iterateMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ITERATE_MEDIATOR_TARGET_OUTPUT_CONNECTOR: {
				IterateMediatorTargetOutputConnector iterateMediatorTargetOutputConnector = (IterateMediatorTargetOutputConnector)theEObject;
				T result = caseIterateMediatorTargetOutputConnector(iterateMediatorTargetOutputConnector);
				if (result == null) result = caseOutputConnector(iterateMediatorTargetOutputConnector);
				if (result == null) result = caseEsbConnector(iterateMediatorTargetOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ITERATE_TARGET: {
				IterateTarget iterateTarget = (IterateTarget)theEObject;
				T result = caseIterateTarget(iterateTarget);
				if (result == null) result = caseAbstractCommonTarget(iterateTarget);
				if (result == null) result = caseEsbNode(iterateTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_COMMON_TARGET: {
				AbstractCommonTarget abstractCommonTarget = (AbstractCommonTarget)theEObject;
				T result = caseAbstractCommonTarget(abstractCommonTarget);
				if (result == null) result = caseEsbNode(abstractCommonTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEDIATOR_SEQUENCE: {
				MediatorSequence mediatorSequence = (MediatorSequence)theEObject;
				T result = caseMediatorSequence(mediatorSequence);
				if (result == null) result = caseEsbNode(mediatorSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CACHE_MEDIATOR: {
				CacheMediator cacheMediator = (CacheMediator)theEObject;
				T result = caseCacheMediator(cacheMediator);
				if (result == null) result = caseMediator(cacheMediator);
				if (result == null) result = caseEsbElement(cacheMediator);
				if (result == null) result = caseEsbNode(cacheMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CACHE_MEDIATOR_INPUT_CONNECTOR: {
				CacheMediatorInputConnector cacheMediatorInputConnector = (CacheMediatorInputConnector)theEObject;
				T result = caseCacheMediatorInputConnector(cacheMediatorInputConnector);
				if (result == null) result = caseInputConnector(cacheMediatorInputConnector);
				if (result == null) result = caseEsbConnector(cacheMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CACHE_MEDIATOR_OUTPUT_CONNECTOR: {
				CacheMediatorOutputConnector cacheMediatorOutputConnector = (CacheMediatorOutputConnector)theEObject;
				T result = caseCacheMediatorOutputConnector(cacheMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(cacheMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(cacheMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CACHE_MEDIATOR_ON_HIT_OUTPUT_CONNECTOR: {
				CacheMediatorOnHitOutputConnector cacheMediatorOnHitOutputConnector = (CacheMediatorOnHitOutputConnector)theEObject;
				T result = caseCacheMediatorOnHitOutputConnector(cacheMediatorOnHitOutputConnector);
				if (result == null) result = caseOutputConnector(cacheMediatorOnHitOutputConnector);
				if (result == null) result = caseEsbConnector(cacheMediatorOnHitOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CACHE_ON_HIT_BRANCH: {
				CacheOnHitBranch cacheOnHitBranch = (CacheOnHitBranch)theEObject;
				T result = caseCacheOnHitBranch(cacheOnHitBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XQUERY_MEDIATOR: {
				XQueryMediator xQueryMediator = (XQueryMediator)theEObject;
				T result = caseXQueryMediator(xQueryMediator);
				if (result == null) result = caseMediator(xQueryMediator);
				if (result == null) result = caseEsbElement(xQueryMediator);
				if (result == null) result = caseEsbNode(xQueryMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XQUERY_MEDIATOR_INPUT_CONNECTOR: {
				XQueryMediatorInputConnector xQueryMediatorInputConnector = (XQueryMediatorInputConnector)theEObject;
				T result = caseXQueryMediatorInputConnector(xQueryMediatorInputConnector);
				if (result == null) result = caseInputConnector(xQueryMediatorInputConnector);
				if (result == null) result = caseEsbConnector(xQueryMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XQUERY_MEDIATOR_OUTPUT_CONNECTOR: {
				XQueryMediatorOutputConnector xQueryMediatorOutputConnector = (XQueryMediatorOutputConnector)theEObject;
				T result = caseXQueryMediatorOutputConnector(xQueryMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(xQueryMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(xQueryMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.XQUERY_VARIABLE: {
				XQueryVariable xQueryVariable = (XQueryVariable)theEObject;
				T result = caseXQueryVariable(xQueryVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALLOUT_MEDIATOR: {
				CalloutMediator calloutMediator = (CalloutMediator)theEObject;
				T result = caseCalloutMediator(calloutMediator);
				if (result == null) result = caseMediator(calloutMediator);
				if (result == null) result = caseEsbElement(calloutMediator);
				if (result == null) result = caseEsbNode(calloutMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALLOUT_MEDIATOR_INPUT_CONNECTOR: {
				CalloutMediatorInputConnector calloutMediatorInputConnector = (CalloutMediatorInputConnector)theEObject;
				T result = caseCalloutMediatorInputConnector(calloutMediatorInputConnector);
				if (result == null) result = caseInputConnector(calloutMediatorInputConnector);
				if (result == null) result = caseEsbConnector(calloutMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALLOUT_MEDIATOR_OUTPUT_CONNECTOR: {
				CalloutMediatorOutputConnector calloutMediatorOutputConnector = (CalloutMediatorOutputConnector)theEObject;
				T result = caseCalloutMediatorOutputConnector(calloutMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(calloutMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(calloutMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RM_SEQUENCE_MEDIATOR: {
				RMSequenceMediator rmSequenceMediator = (RMSequenceMediator)theEObject;
				T result = caseRMSequenceMediator(rmSequenceMediator);
				if (result == null) result = caseMediator(rmSequenceMediator);
				if (result == null) result = caseEsbElement(rmSequenceMediator);
				if (result == null) result = caseEsbNode(rmSequenceMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RM_SEQUENCE_MEDIATOR_INPUT_CONNECTOR: {
				RMSequenceMediatorInputConnector rmSequenceMediatorInputConnector = (RMSequenceMediatorInputConnector)theEObject;
				T result = caseRMSequenceMediatorInputConnector(rmSequenceMediatorInputConnector);
				if (result == null) result = caseInputConnector(rmSequenceMediatorInputConnector);
				if (result == null) result = caseEsbConnector(rmSequenceMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RM_SEQUENCE_MEDIATOR_OUTPUT_CONNECTOR: {
				RMSequenceMediatorOutputConnector rmSequenceMediatorOutputConnector = (RMSequenceMediatorOutputConnector)theEObject;
				T result = caseRMSequenceMediatorOutputConnector(rmSequenceMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(rmSequenceMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(rmSequenceMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TRANSACTION_MEDIATOR: {
				TransactionMediator transactionMediator = (TransactionMediator)theEObject;
				T result = caseTransactionMediator(transactionMediator);
				if (result == null) result = caseMediator(transactionMediator);
				if (result == null) result = caseEsbElement(transactionMediator);
				if (result == null) result = caseEsbNode(transactionMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TRANSACTION_MEDIATOR_INPUT_CONNECTOR: {
				TransactionMediatorInputConnector transactionMediatorInputConnector = (TransactionMediatorInputConnector)theEObject;
				T result = caseTransactionMediatorInputConnector(transactionMediatorInputConnector);
				if (result == null) result = caseInputConnector(transactionMediatorInputConnector);
				if (result == null) result = caseEsbConnector(transactionMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TRANSACTION_MEDIATOR_OUTPUT_CONNECTOR: {
				TransactionMediatorOutputConnector transactionMediatorOutputConnector = (TransactionMediatorOutputConnector)theEObject;
				T result = caseTransactionMediatorOutputConnector(transactionMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(transactionMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(transactionMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.OAUTH_MEDIATOR: {
				OAuthMediator oAuthMediator = (OAuthMediator)theEObject;
				T result = caseOAuthMediator(oAuthMediator);
				if (result == null) result = caseMediator(oAuthMediator);
				if (result == null) result = caseEsbElement(oAuthMediator);
				if (result == null) result = caseEsbNode(oAuthMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.OAUTH_MEDIATOR_INPUT_CONNECTOR: {
				OAuthMediatorInputConnector oAuthMediatorInputConnector = (OAuthMediatorInputConnector)theEObject;
				T result = caseOAuthMediatorInputConnector(oAuthMediatorInputConnector);
				if (result == null) result = caseInputConnector(oAuthMediatorInputConnector);
				if (result == null) result = caseEsbConnector(oAuthMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.OAUTH_MEDIATOR_OUTPUT_CONNECTOR: {
				OAuthMediatorOutputConnector oAuthMediatorOutputConnector = (OAuthMediatorOutputConnector)theEObject;
				T result = caseOAuthMediatorOutputConnector(oAuthMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(oAuthMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(oAuthMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.AUTOSCALE_IN_MEDIATOR: {
				AutoscaleInMediator autoscaleInMediator = (AutoscaleInMediator)theEObject;
				T result = caseAutoscaleInMediator(autoscaleInMediator);
				if (result == null) result = caseMediator(autoscaleInMediator);
				if (result == null) result = caseEsbElement(autoscaleInMediator);
				if (result == null) result = caseEsbNode(autoscaleInMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.AUTOSCALE_OUT_MEDIATOR: {
				AutoscaleOutMediator autoscaleOutMediator = (AutoscaleOutMediator)theEObject;
				T result = caseAutoscaleOutMediator(autoscaleOutMediator);
				if (result == null) result = caseMediator(autoscaleOutMediator);
				if (result == null) result = caseEsbElement(autoscaleOutMediator);
				if (result == null) result = caseEsbNode(autoscaleOutMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.HEADER_MEDIATOR: {
				HeaderMediator headerMediator = (HeaderMediator)theEObject;
				T result = caseHeaderMediator(headerMediator);
				if (result == null) result = caseMediator(headerMediator);
				if (result == null) result = caseEsbElement(headerMediator);
				if (result == null) result = caseEsbNode(headerMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.HEADER_MEDIATOR_INPUT_CONNECTOR: {
				HeaderMediatorInputConnector headerMediatorInputConnector = (HeaderMediatorInputConnector)theEObject;
				T result = caseHeaderMediatorInputConnector(headerMediatorInputConnector);
				if (result == null) result = caseInputConnector(headerMediatorInputConnector);
				if (result == null) result = caseEsbConnector(headerMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.HEADER_MEDIATOR_OUTPUT_CONNECTOR: {
				HeaderMediatorOutputConnector headerMediatorOutputConnector = (HeaderMediatorOutputConnector)theEObject;
				T result = caseHeaderMediatorOutputConnector(headerMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(headerMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(headerMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_MEDIATOR: {
				ThrottleMediator throttleMediator = (ThrottleMediator)theEObject;
				T result = caseThrottleMediator(throttleMediator);
				if (result == null) result = caseMediator(throttleMediator);
				if (result == null) result = caseEsbElement(throttleMediator);
				if (result == null) result = caseEsbNode(throttleMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_MEDIATOR_INPUT_CONNECTOR: {
				ThrottleMediatorInputConnector throttleMediatorInputConnector = (ThrottleMediatorInputConnector)theEObject;
				T result = caseThrottleMediatorInputConnector(throttleMediatorInputConnector);
				if (result == null) result = caseInputConnector(throttleMediatorInputConnector);
				if (result == null) result = caseEsbConnector(throttleMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_MEDIATOR_OUTPUT_CONNECTOR: {
				ThrottleMediatorOutputConnector throttleMediatorOutputConnector = (ThrottleMediatorOutputConnector)theEObject;
				T result = caseThrottleMediatorOutputConnector(throttleMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(throttleMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(throttleMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_MEDIATOR_ON_ACCEPT_OUTPUT_CONNECTOR: {
				ThrottleMediatorOnAcceptOutputConnector throttleMediatorOnAcceptOutputConnector = (ThrottleMediatorOnAcceptOutputConnector)theEObject;
				T result = caseThrottleMediatorOnAcceptOutputConnector(throttleMediatorOnAcceptOutputConnector);
				if (result == null) result = caseOutputConnector(throttleMediatorOnAcceptOutputConnector);
				if (result == null) result = caseEsbConnector(throttleMediatorOnAcceptOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_MEDIATOR_ON_REJECT_OUTPUT_CONNECTOR: {
				ThrottleMediatorOnRejectOutputConnector throttleMediatorOnRejectOutputConnector = (ThrottleMediatorOnRejectOutputConnector)theEObject;
				T result = caseThrottleMediatorOnRejectOutputConnector(throttleMediatorOnRejectOutputConnector);
				if (result == null) result = caseOutputConnector(throttleMediatorOnRejectOutputConnector);
				if (result == null) result = caseEsbConnector(throttleMediatorOnRejectOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_POLICY_CONFIGURATION: {
				ThrottlePolicyConfiguration throttlePolicyConfiguration = (ThrottlePolicyConfiguration)theEObject;
				T result = caseThrottlePolicyConfiguration(throttlePolicyConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_POLICY_ENTRY: {
				ThrottlePolicyEntry throttlePolicyEntry = (ThrottlePolicyEntry)theEObject;
				T result = caseThrottlePolicyEntry(throttlePolicyEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_ON_ACCEPT_BRANCH: {
				ThrottleOnAcceptBranch throttleOnAcceptBranch = (ThrottleOnAcceptBranch)theEObject;
				T result = caseThrottleOnAcceptBranch(throttleOnAcceptBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_ON_REJECT_BRANCH: {
				ThrottleOnRejectBranch throttleOnRejectBranch = (ThrottleOnRejectBranch)theEObject;
				T result = caseThrottleOnRejectBranch(throttleOnRejectBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_CONTAINER: {
				ThrottleContainer throttleContainer = (ThrottleContainer)theEObject;
				T result = caseThrottleContainer(throttleContainer);
				if (result == null) result = caseEsbNode(throttleContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_ON_ACCEPT_CONTAINER: {
				ThrottleOnAcceptContainer throttleOnAcceptContainer = (ThrottleOnAcceptContainer)theEObject;
				T result = caseThrottleOnAcceptContainer(throttleOnAcceptContainer);
				if (result == null) result = caseEsbNode(throttleOnAcceptContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.THROTTLE_ON_REJECT_CONTAINER: {
				ThrottleOnRejectContainer throttleOnRejectContainer = (ThrottleOnRejectContainer)theEObject;
				T result = caseThrottleOnRejectContainer(throttleOnRejectContainer);
				if (result == null) result = caseEsbNode(throttleOnRejectContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMMAND_MEDIATOR: {
				CommandMediator commandMediator = (CommandMediator)theEObject;
				T result = caseCommandMediator(commandMediator);
				if (result == null) result = caseMediator(commandMediator);
				if (result == null) result = caseEsbElement(commandMediator);
				if (result == null) result = caseEsbNode(commandMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMMAND_MEDIATOR_INPUT_CONNECTOR: {
				CommandMediatorInputConnector commandMediatorInputConnector = (CommandMediatorInputConnector)theEObject;
				T result = caseCommandMediatorInputConnector(commandMediatorInputConnector);
				if (result == null) result = caseInputConnector(commandMediatorInputConnector);
				if (result == null) result = caseEsbConnector(commandMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMMAND_MEDIATOR_OUTPUT_CONNECTOR: {
				CommandMediatorOutputConnector commandMediatorOutputConnector = (CommandMediatorOutputConnector)theEObject;
				T result = caseCommandMediatorOutputConnector(commandMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(commandMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(commandMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMMAND_PROPERTY: {
				CommandProperty commandProperty = (CommandProperty)theEObject;
				T result = caseCommandProperty(commandProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR: {
				AbstractSqlExecutorMediator abstractSqlExecutorMediator = (AbstractSqlExecutorMediator)theEObject;
				T result = caseAbstractSqlExecutorMediator(abstractSqlExecutorMediator);
				if (result == null) result = caseMediator(abstractSqlExecutorMediator);
				if (result == null) result = caseEsbElement(abstractSqlExecutorMediator);
				if (result == null) result = caseEsbNode(abstractSqlExecutorMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SQL_STATEMENT: {
				SqlStatement sqlStatement = (SqlStatement)theEObject;
				T result = caseSqlStatement(sqlStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SQL_PARAMETER_DEFINITION: {
				SqlParameterDefinition sqlParameterDefinition = (SqlParameterDefinition)theEObject;
				T result = caseSqlParameterDefinition(sqlParameterDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SQL_RESULT_MAPPING: {
				SqlResultMapping sqlResultMapping = (SqlResultMapping)theEObject;
				T result = caseSqlResultMapping(sqlResultMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DB_LOOKUP_MEDIATOR: {
				DBLookupMediator dbLookupMediator = (DBLookupMediator)theEObject;
				T result = caseDBLookupMediator(dbLookupMediator);
				if (result == null) result = caseAbstractSqlExecutorMediator(dbLookupMediator);
				if (result == null) result = caseMediator(dbLookupMediator);
				if (result == null) result = caseEsbElement(dbLookupMediator);
				if (result == null) result = caseEsbNode(dbLookupMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DB_LOOKUP_MEDIATOR_INPUT_CONNECTOR: {
				DBLookupMediatorInputConnector dbLookupMediatorInputConnector = (DBLookupMediatorInputConnector)theEObject;
				T result = caseDBLookupMediatorInputConnector(dbLookupMediatorInputConnector);
				if (result == null) result = caseInputConnector(dbLookupMediatorInputConnector);
				if (result == null) result = caseEsbConnector(dbLookupMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DB_LOOKUP_MEDIATOR_OUTPUT_CONNECTOR: {
				DBLookupMediatorOutputConnector dbLookupMediatorOutputConnector = (DBLookupMediatorOutputConnector)theEObject;
				T result = caseDBLookupMediatorOutputConnector(dbLookupMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(dbLookupMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(dbLookupMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DB_REPORT_MEDIATOR: {
				DBReportMediator dbReportMediator = (DBReportMediator)theEObject;
				T result = caseDBReportMediator(dbReportMediator);
				if (result == null) result = caseAbstractSqlExecutorMediator(dbReportMediator);
				if (result == null) result = caseMediator(dbReportMediator);
				if (result == null) result = caseEsbElement(dbReportMediator);
				if (result == null) result = caseEsbNode(dbReportMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DB_REPORT_MEDIATOR_INPUT_CONNECTOR: {
				DBReportMediatorInputConnector dbReportMediatorInputConnector = (DBReportMediatorInputConnector)theEObject;
				T result = caseDBReportMediatorInputConnector(dbReportMediatorInputConnector);
				if (result == null) result = caseInputConnector(dbReportMediatorInputConnector);
				if (result == null) result = caseEsbConnector(dbReportMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DB_REPORT_MEDIATOR_OUTPUT_CONNECTOR: {
				DBReportMediatorOutputConnector dbReportMediatorOutputConnector = (DBReportMediatorOutputConnector)theEObject;
				T result = caseDBReportMediatorOutputConnector(dbReportMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(dbReportMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(dbReportMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_MEDIATOR: {
				RuleMediator ruleMediator = (RuleMediator)theEObject;
				T result = caseRuleMediator(ruleMediator);
				if (result == null) result = caseMediator(ruleMediator);
				if (result == null) result = caseEsbElement(ruleMediator);
				if (result == null) result = caseEsbNode(ruleMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_MEDIATOR_INPUT_CONNECTOR: {
				RuleMediatorInputConnector ruleMediatorInputConnector = (RuleMediatorInputConnector)theEObject;
				T result = caseRuleMediatorInputConnector(ruleMediatorInputConnector);
				if (result == null) result = caseInputConnector(ruleMediatorInputConnector);
				if (result == null) result = caseEsbConnector(ruleMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_MEDIATOR_OUTPUT_CONNECTOR: {
				RuleMediatorOutputConnector ruleMediatorOutputConnector = (RuleMediatorOutputConnector)theEObject;
				T result = caseRuleMediatorOutputConnector(ruleMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(ruleMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(ruleMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_MEDIATOR_CHILD_MEDIATORS_OUTPUT_CONNECTOR: {
				RuleMediatorChildMediatorsOutputConnector ruleMediatorChildMediatorsOutputConnector = (RuleMediatorChildMediatorsOutputConnector)theEObject;
				T result = caseRuleMediatorChildMediatorsOutputConnector(ruleMediatorChildMediatorsOutputConnector);
				if (result == null) result = caseOutputConnector(ruleMediatorChildMediatorsOutputConnector);
				if (result == null) result = caseEsbConnector(ruleMediatorChildMediatorsOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_SET_CREATION_PROPERTY: {
				RuleSetCreationProperty ruleSetCreationProperty = (RuleSetCreationProperty)theEObject;
				T result = caseRuleSetCreationProperty(ruleSetCreationProperty);
				if (result == null) result = caseAbstractNameValueProperty(ruleSetCreationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_SESSION_PROPERTY: {
				RuleSessionProperty ruleSessionProperty = (RuleSessionProperty)theEObject;
				T result = caseRuleSessionProperty(ruleSessionProperty);
				if (result == null) result = caseAbstractNameValueProperty(ruleSessionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_FACTS_CONFIGURATION: {
				RuleFactsConfiguration ruleFactsConfiguration = (RuleFactsConfiguration)theEObject;
				T result = caseRuleFactsConfiguration(ruleFactsConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_FACT: {
				RuleFact ruleFact = (RuleFact)theEObject;
				T result = caseRuleFact(ruleFact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_RESULTS_CONFIGURATION: {
				RuleResultsConfiguration ruleResultsConfiguration = (RuleResultsConfiguration)theEObject;
				T result = caseRuleResultsConfiguration(ruleResultsConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_RESULT: {
				RuleResult ruleResult = (RuleResult)theEObject;
				T result = caseRuleResult(ruleResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RULE_CHILD_MEDIATORS_CONFIGURATION: {
				RuleChildMediatorsConfiguration ruleChildMediatorsConfiguration = (RuleChildMediatorsConfiguration)theEObject;
				T result = caseRuleChildMediatorsConfiguration(ruleChildMediatorsConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_TEMPLATE_PARAMETER: {
				CallTemplateParameter callTemplateParameter = (CallTemplateParameter)theEObject;
				T result = caseCallTemplateParameter(callTemplateParameter);
				if (result == null) result = caseEsbNode(callTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_TEMPLATE_MEDIATOR: {
				CallTemplateMediator callTemplateMediator = (CallTemplateMediator)theEObject;
				T result = caseCallTemplateMediator(callTemplateMediator);
				if (result == null) result = caseMediator(callTemplateMediator);
				if (result == null) result = caseEsbElement(callTemplateMediator);
				if (result == null) result = caseEsbNode(callTemplateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_TEMPLATE_MEDIATOR_INPUT_CONNECTOR: {
				CallTemplateMediatorInputConnector callTemplateMediatorInputConnector = (CallTemplateMediatorInputConnector)theEObject;
				T result = caseCallTemplateMediatorInputConnector(callTemplateMediatorInputConnector);
				if (result == null) result = caseInputConnector(callTemplateMediatorInputConnector);
				if (result == null) result = caseEsbConnector(callTemplateMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CALL_TEMPLATE_MEDIATOR_OUTPUT_CONNECTOR: {
				CallTemplateMediatorOutputConnector callTemplateMediatorOutputConnector = (CallTemplateMediatorOutputConnector)theEObject;
				T result = caseCallTemplateMediatorOutputConnector(callTemplateMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(callTemplateMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(callTemplateMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOOP_BACK_MEDIATOR: {
				LoopBackMediator loopBackMediator = (LoopBackMediator)theEObject;
				T result = caseLoopBackMediator(loopBackMediator);
				if (result == null) result = caseMediator(loopBackMediator);
				if (result == null) result = caseEsbElement(loopBackMediator);
				if (result == null) result = caseEsbNode(loopBackMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOOP_BACK_MEDIATOR_INPUT_CONNECTOR: {
				LoopBackMediatorInputConnector loopBackMediatorInputConnector = (LoopBackMediatorInputConnector)theEObject;
				T result = caseLoopBackMediatorInputConnector(loopBackMediatorInputConnector);
				if (result == null) result = caseInputConnector(loopBackMediatorInputConnector);
				if (result == null) result = caseEsbConnector(loopBackMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOOP_BACK_MEDIATOR_OUTPUT_CONNECTOR: {
				LoopBackMediatorOutputConnector loopBackMediatorOutputConnector = (LoopBackMediatorOutputConnector)theEObject;
				T result = caseLoopBackMediatorOutputConnector(loopBackMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(loopBackMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(loopBackMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RESPOND_MEDIATOR: {
				RespondMediator respondMediator = (RespondMediator)theEObject;
				T result = caseRespondMediator(respondMediator);
				if (result == null) result = caseMediator(respondMediator);
				if (result == null) result = caseEsbElement(respondMediator);
				if (result == null) result = caseEsbNode(respondMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RESPOND_MEDIATOR_INPUT_CONNECTOR: {
				RespondMediatorInputConnector respondMediatorInputConnector = (RespondMediatorInputConnector)theEObject;
				T result = caseRespondMediatorInputConnector(respondMediatorInputConnector);
				if (result == null) result = caseInputConnector(respondMediatorInputConnector);
				if (result == null) result = caseEsbConnector(respondMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RESPOND_MEDIATOR_OUTPUT_CONNECTOR: {
				RespondMediatorOutputConnector respondMediatorOutputConnector = (RespondMediatorOutputConnector)theEObject;
				T result = caseRespondMediatorOutputConnector(respondMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(respondMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(respondMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SMOOKS_MEDIATOR: {
				SmooksMediator smooksMediator = (SmooksMediator)theEObject;
				T result = caseSmooksMediator(smooksMediator);
				if (result == null) result = caseMediator(smooksMediator);
				if (result == null) result = caseEsbElement(smooksMediator);
				if (result == null) result = caseEsbNode(smooksMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SMOOKS_MEDIATOR_INPUT_CONNECTOR: {
				SmooksMediatorInputConnector smooksMediatorInputConnector = (SmooksMediatorInputConnector)theEObject;
				T result = caseSmooksMediatorInputConnector(smooksMediatorInputConnector);
				if (result == null) result = caseInputConnector(smooksMediatorInputConnector);
				if (result == null) result = caseEsbConnector(smooksMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SMOOKS_MEDIATOR_OUTPUT_CONNECTOR: {
				SmooksMediatorOutputConnector smooksMediatorOutputConnector = (SmooksMediatorOutputConnector)theEObject;
				T result = caseSmooksMediatorOutputConnector(smooksMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(smooksMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(smooksMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.STORE_MEDIATOR: {
				StoreMediator storeMediator = (StoreMediator)theEObject;
				T result = caseStoreMediator(storeMediator);
				if (result == null) result = caseMediator(storeMediator);
				if (result == null) result = caseEsbElement(storeMediator);
				if (result == null) result = caseEsbNode(storeMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.STORE_MEDIATOR_INPUT_CONNECTOR: {
				StoreMediatorInputConnector storeMediatorInputConnector = (StoreMediatorInputConnector)theEObject;
				T result = caseStoreMediatorInputConnector(storeMediatorInputConnector);
				if (result == null) result = caseInputConnector(storeMediatorInputConnector);
				if (result == null) result = caseEsbConnector(storeMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.STORE_MEDIATOR_OUTPUT_CONNECTOR: {
				StoreMediatorOutputConnector storeMediatorOutputConnector = (StoreMediatorOutputConnector)theEObject;
				T result = caseStoreMediatorOutputConnector(storeMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(storeMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(storeMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BUILDER_MEDIATOR: {
				BuilderMediator builderMediator = (BuilderMediator)theEObject;
				T result = caseBuilderMediator(builderMediator);
				if (result == null) result = caseMediator(builderMediator);
				if (result == null) result = caseEsbElement(builderMediator);
				if (result == null) result = caseEsbNode(builderMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BUILDER_MEDIATOR_INPUT_CONNECTOR: {
				BuilderMediatorInputConnector builderMediatorInputConnector = (BuilderMediatorInputConnector)theEObject;
				T result = caseBuilderMediatorInputConnector(builderMediatorInputConnector);
				if (result == null) result = caseInputConnector(builderMediatorInputConnector);
				if (result == null) result = caseEsbConnector(builderMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.BUILDER_MEDIATOR_OUTPUT_CONECTOR: {
				BuilderMediatorOutputConector builderMediatorOutputConector = (BuilderMediatorOutputConector)theEObject;
				T result = caseBuilderMediatorOutputConector(builderMediatorOutputConector);
				if (result == null) result = caseOutputConnector(builderMediatorOutputConector);
				if (result == null) result = caseEsbConnector(builderMediatorOutputConector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_BUILDER: {
				MessageBuilder messageBuilder = (MessageBuilder)theEObject;
				T result = caseMessageBuilder(messageBuilder);
				if (result == null) result = caseEsbNode(messageBuilder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR: {
				PayloadFactoryMediator payloadFactoryMediator = (PayloadFactoryMediator)theEObject;
				T result = casePayloadFactoryMediator(payloadFactoryMediator);
				if (result == null) result = caseMediator(payloadFactoryMediator);
				if (result == null) result = caseEsbElement(payloadFactoryMediator);
				if (result == null) result = caseEsbNode(payloadFactoryMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR_INPUT_CONNECTOR: {
				PayloadFactoryMediatorInputConnector payloadFactoryMediatorInputConnector = (PayloadFactoryMediatorInputConnector)theEObject;
				T result = casePayloadFactoryMediatorInputConnector(payloadFactoryMediatorInputConnector);
				if (result == null) result = caseInputConnector(payloadFactoryMediatorInputConnector);
				if (result == null) result = caseEsbConnector(payloadFactoryMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR_OUTPUT_CONNECTOR: {
				PayloadFactoryMediatorOutputConnector payloadFactoryMediatorOutputConnector = (PayloadFactoryMediatorOutputConnector)theEObject;
				T result = casePayloadFactoryMediatorOutputConnector(payloadFactoryMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(payloadFactoryMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(payloadFactoryMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT: {
				PayloadFactoryArgument payloadFactoryArgument = (PayloadFactoryArgument)theEObject;
				T result = casePayloadFactoryArgument(payloadFactoryArgument);
				if (result == null) result = caseEsbNode(payloadFactoryArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH: {
				ConditionalRouteBranch conditionalRouteBranch = (ConditionalRouteBranch)theEObject;
				T result = caseConditionalRouteBranch(conditionalRouteBranch);
				if (result == null) result = caseEsbNode(conditionalRouteBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR: {
				ConditionalRouterMediator conditionalRouterMediator = (ConditionalRouterMediator)theEObject;
				T result = caseConditionalRouterMediator(conditionalRouterMediator);
				if (result == null) result = caseMediator(conditionalRouterMediator);
				if (result == null) result = caseEsbElement(conditionalRouterMediator);
				if (result == null) result = caseEsbNode(conditionalRouterMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR_INPUT_CONNECTOR: {
				ConditionalRouterMediatorInputConnector conditionalRouterMediatorInputConnector = (ConditionalRouterMediatorInputConnector)theEObject;
				T result = caseConditionalRouterMediatorInputConnector(conditionalRouterMediatorInputConnector);
				if (result == null) result = caseInputConnector(conditionalRouterMediatorInputConnector);
				if (result == null) result = caseEsbConnector(conditionalRouterMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR_OUTPUT_CONNECTOR: {
				ConditionalRouterMediatorOutputConnector conditionalRouterMediatorOutputConnector = (ConditionalRouterMediatorOutputConnector)theEObject;
				T result = caseConditionalRouterMediatorOutputConnector(conditionalRouterMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(conditionalRouterMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(conditionalRouterMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR_ADDITIONAL_OUTPUT_CONNECTOR: {
				ConditionalRouterMediatorAdditionalOutputConnector conditionalRouterMediatorAdditionalOutputConnector = (ConditionalRouterMediatorAdditionalOutputConnector)theEObject;
				T result = caseConditionalRouterMediatorAdditionalOutputConnector(conditionalRouterMediatorAdditionalOutputConnector);
				if (result == null) result = caseOutputConnector(conditionalRouterMediatorAdditionalOutputConnector);
				if (result == null) result = caseEsbConnector(conditionalRouterMediatorAdditionalOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEND_MEDIATOR: {
				SendMediator sendMediator = (SendMediator)theEObject;
				T result = caseSendMediator(sendMediator);
				if (result == null) result = caseMediator(sendMediator);
				if (result == null) result = caseEsbElement(sendMediator);
				if (result == null) result = caseEsbNode(sendMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEND_CONTAINER: {
				SendContainer sendContainer = (SendContainer)theEObject;
				T result = caseSendContainer(sendContainer);
				if (result == null) result = caseEsbNode(sendContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEND_MEDIATOR_INPUT_CONNECTOR: {
				SendMediatorInputConnector sendMediatorInputConnector = (SendMediatorInputConnector)theEObject;
				T result = caseSendMediatorInputConnector(sendMediatorInputConnector);
				if (result == null) result = caseInputConnector(sendMediatorInputConnector);
				if (result == null) result = caseEsbConnector(sendMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEND_MEDIATOR_OUTPUT_CONNECTOR: {
				SendMediatorOutputConnector sendMediatorOutputConnector = (SendMediatorOutputConnector)theEObject;
				T result = caseSendMediatorOutputConnector(sendMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(sendMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(sendMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEND_MEDIATOR_ENDPOINT_OUTPUT_CONNECTOR: {
				SendMediatorEndpointOutputConnector sendMediatorEndpointOutputConnector = (SendMediatorEndpointOutputConnector)theEObject;
				T result = caseSendMediatorEndpointOutputConnector(sendMediatorEndpointOutputConnector);
				if (result == null) result = caseOutputConnector(sendMediatorEndpointOutputConnector);
				if (result == null) result = caseEsbConnector(sendMediatorEndpointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAILOVER_END_POINT: {
				FailoverEndPoint failoverEndPoint = (FailoverEndPoint)theEObject;
				T result = caseFailoverEndPoint(failoverEndPoint);
				if (result == null) result = caseParentEndPoint(failoverEndPoint);
				if (result == null) result = caseEndPoint(failoverEndPoint);
				if (result == null) result = caseEsbElement(failoverEndPoint);
				if (result == null) result = caseEsbNode(failoverEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAILOVER_END_POINT_INPUT_CONNECTOR: {
				FailoverEndPointInputConnector failoverEndPointInputConnector = (FailoverEndPointInputConnector)theEObject;
				T result = caseFailoverEndPointInputConnector(failoverEndPointInputConnector);
				if (result == null) result = caseInputConnector(failoverEndPointInputConnector);
				if (result == null) result = caseEsbConnector(failoverEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAILOVER_END_POINT_OUTPUT_CONNECTOR: {
				FailoverEndPointOutputConnector failoverEndPointOutputConnector = (FailoverEndPointOutputConnector)theEObject;
				T result = caseFailoverEndPointOutputConnector(failoverEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(failoverEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(failoverEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAILOVER_END_POINT_WEST_OUTPUT_CONNECTOR: {
				FailoverEndPointWestOutputConnector failoverEndPointWestOutputConnector = (FailoverEndPointWestOutputConnector)theEObject;
				T result = caseFailoverEndPointWestOutputConnector(failoverEndPointWestOutputConnector);
				if (result == null) result = caseOutputConnector(failoverEndPointWestOutputConnector);
				if (result == null) result = caseEsbConnector(failoverEndPointWestOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.PARENT_END_POINT: {
				ParentEndPoint parentEndPoint = (ParentEndPoint)theEObject;
				T result = caseParentEndPoint(parentEndPoint);
				if (result == null) result = caseEndPoint(parentEndPoint);
				if (result == null) result = caseEsbElement(parentEndPoint);
				if (result == null) result = caseEsbNode(parentEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.WSDL_END_POINT: {
				WSDLEndPoint wsdlEndPoint = (WSDLEndPoint)theEObject;
				T result = caseWSDLEndPoint(wsdlEndPoint);
				if (result == null) result = caseAbstractEndPoint(wsdlEndPoint);
				if (result == null) result = caseEndPoint(wsdlEndPoint);
				if (result == null) result = caseEsbElement(wsdlEndPoint);
				if (result == null) result = caseEsbNode(wsdlEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.WSDL_END_POINT_INPUT_CONNECTOR: {
				WSDLEndPointInputConnector wsdlEndPointInputConnector = (WSDLEndPointInputConnector)theEObject;
				T result = caseWSDLEndPointInputConnector(wsdlEndPointInputConnector);
				if (result == null) result = caseInputConnector(wsdlEndPointInputConnector);
				if (result == null) result = caseEsbConnector(wsdlEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.WSDL_END_POINT_OUTPUT_CONNECTOR: {
				WSDLEndPointOutputConnector wsdlEndPointOutputConnector = (WSDLEndPointOutputConnector)theEObject;
				T result = caseWSDLEndPointOutputConnector(wsdlEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(wsdlEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(wsdlEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOAD_BALANCE_END_POINT: {
				LoadBalanceEndPoint loadBalanceEndPoint = (LoadBalanceEndPoint)theEObject;
				T result = caseLoadBalanceEndPoint(loadBalanceEndPoint);
				if (result == null) result = caseParentEndPoint(loadBalanceEndPoint);
				if (result == null) result = caseEndPoint(loadBalanceEndPoint);
				if (result == null) result = caseEsbElement(loadBalanceEndPoint);
				if (result == null) result = caseEsbNode(loadBalanceEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MEMBER: {
				Member member = (Member)theEObject;
				T result = caseMember(member);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOAD_BALANCE_END_POINT_INPUT_CONNECTOR: {
				LoadBalanceEndPointInputConnector loadBalanceEndPointInputConnector = (LoadBalanceEndPointInputConnector)theEObject;
				T result = caseLoadBalanceEndPointInputConnector(loadBalanceEndPointInputConnector);
				if (result == null) result = caseInputConnector(loadBalanceEndPointInputConnector);
				if (result == null) result = caseEsbConnector(loadBalanceEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOAD_BALANCE_END_POINT_OUTPUT_CONNECTOR: {
				LoadBalanceEndPointOutputConnector loadBalanceEndPointOutputConnector = (LoadBalanceEndPointOutputConnector)theEObject;
				T result = caseLoadBalanceEndPointOutputConnector(loadBalanceEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(loadBalanceEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(loadBalanceEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOAD_BALANCE_END_POINT_WEST_OUTPUT_CONNECTOR: {
				LoadBalanceEndPointWestOutputConnector loadBalanceEndPointWestOutputConnector = (LoadBalanceEndPointWestOutputConnector)theEObject;
				T result = caseLoadBalanceEndPointWestOutputConnector(loadBalanceEndPointWestOutputConnector);
				if (result == null) result = caseOutputConnector(loadBalanceEndPointWestOutputConnector);
				if (result == null) result = caseEsbConnector(loadBalanceEndPointWestOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.LOCAL_ENTRY: {
				LocalEntry localEntry = (LocalEntry)theEObject;
				T result = caseLocalEntry(localEntry);
				if (result == null) result = caseEsbElement(localEntry);
				if (result == null) result = caseEsbNode(localEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SESSION: {
				Session session = (Session)theEObject;
				T result = caseSession(session);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCES: {
				Sequences sequences = (Sequences)theEObject;
				T result = caseSequences(sequences);
				if (result == null) result = caseEsbElement(sequences);
				if (result == null) result = caseEsbNode(sequences);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCES_OUTPUT_CONNECTOR: {
				SequencesOutputConnector sequencesOutputConnector = (SequencesOutputConnector)theEObject;
				T result = caseSequencesOutputConnector(sequencesOutputConnector);
				if (result == null) result = caseOutputConnector(sequencesOutputConnector);
				if (result == null) result = caseEsbConnector(sequencesOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SEQUENCES_INPUT_CONNECTOR: {
				SequencesInputConnector sequencesInputConnector = (SequencesInputConnector)theEObject;
				T result = caseSequencesInputConnector(sequencesInputConnector);
				if (result == null) result = caseInputConnector(sequencesInputConnector);
				if (result == null) result = caseEsbConnector(sequencesInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.URL_REWRITE_RULE_ACTION: {
				URLRewriteRuleAction urlRewriteRuleAction = (URLRewriteRuleAction)theEObject;
				T result = caseURLRewriteRuleAction(urlRewriteRuleAction);
				if (result == null) result = caseEsbNode(urlRewriteRuleAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.URL_REWRITE_RULE: {
				URLRewriteRule urlRewriteRule = (URLRewriteRule)theEObject;
				T result = caseURLRewriteRule(urlRewriteRule);
				if (result == null) result = caseEsbNode(urlRewriteRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.URL_REWRITE_MEDIATOR: {
				URLRewriteMediator urlRewriteMediator = (URLRewriteMediator)theEObject;
				T result = caseURLRewriteMediator(urlRewriteMediator);
				if (result == null) result = caseMediator(urlRewriteMediator);
				if (result == null) result = caseEsbElement(urlRewriteMediator);
				if (result == null) result = caseEsbNode(urlRewriteMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.URL_REWRITE_MEDIATOR_INPUT_CONNECTOR: {
				URLRewriteMediatorInputConnector urlRewriteMediatorInputConnector = (URLRewriteMediatorInputConnector)theEObject;
				T result = caseURLRewriteMediatorInputConnector(urlRewriteMediatorInputConnector);
				if (result == null) result = caseInputConnector(urlRewriteMediatorInputConnector);
				if (result == null) result = caseEsbConnector(urlRewriteMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.URL_REWRITE_MEDIATOR_OUTPUT_CONNECTOR: {
				URLRewriteMediatorOutputConnector urlRewriteMediatorOutputConnector = (URLRewriteMediatorOutputConnector)theEObject;
				T result = caseURLRewriteMediatorOutputConnector(urlRewriteMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(urlRewriteMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(urlRewriteMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY: {
				EvaluatorExpressionProperty evaluatorExpressionProperty = (EvaluatorExpressionProperty)theEObject;
				T result = caseEvaluatorExpressionProperty(evaluatorExpressionProperty);
				if (result == null) result = caseEsbNode(evaluatorExpressionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_MEDIATOR: {
				ValidateMediator validateMediator = (ValidateMediator)theEObject;
				T result = caseValidateMediator(validateMediator);
				if (result == null) result = caseMediator(validateMediator);
				if (result == null) result = caseEsbElement(validateMediator);
				if (result == null) result = caseEsbNode(validateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_RESOURCE: {
				ValidateResource validateResource = (ValidateResource)theEObject;
				T result = caseValidateResource(validateResource);
				if (result == null) result = caseAbstractLocationKeyResource(validateResource);
				if (result == null) result = caseEsbNode(validateResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_FEATURE: {
				ValidateFeature validateFeature = (ValidateFeature)theEObject;
				T result = caseValidateFeature(validateFeature);
				if (result == null) result = caseAbstractBooleanFeature(validateFeature);
				if (result == null) result = caseEsbNode(validateFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_SCHEMA: {
				ValidateSchema validateSchema = (ValidateSchema)theEObject;
				T result = caseValidateSchema(validateSchema);
				if (result == null) result = caseEsbNode(validateSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_MEDIATOR_INPUT_CONNECTOR: {
				ValidateMediatorInputConnector validateMediatorInputConnector = (ValidateMediatorInputConnector)theEObject;
				T result = caseValidateMediatorInputConnector(validateMediatorInputConnector);
				if (result == null) result = caseInputConnector(validateMediatorInputConnector);
				if (result == null) result = caseEsbConnector(validateMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_MEDIATOR_OUTPUT_CONNECTOR: {
				ValidateMediatorOutputConnector validateMediatorOutputConnector = (ValidateMediatorOutputConnector)theEObject;
				T result = caseValidateMediatorOutputConnector(validateMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(validateMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(validateMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.VALIDATE_MEDIATOR_ON_FAIL_OUTPUT_CONNECTOR: {
				ValidateMediatorOnFailOutputConnector validateMediatorOnFailOutputConnector = (ValidateMediatorOnFailOutputConnector)theEObject;
				T result = caseValidateMediatorOnFailOutputConnector(validateMediatorOnFailOutputConnector);
				if (result == null) result = caseOutputConnector(validateMediatorOnFailOutputConnector);
				if (result == null) result = caseEsbConnector(validateMediatorOnFailOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ENDPOINT_DIAGRAM: {
				EndpointDiagram endpointDiagram = (EndpointDiagram)theEObject;
				T result = caseEndpointDiagram(endpointDiagram);
				if (result == null) result = caseEsbElement(endpointDiagram);
				if (result == null) result = caseEsbNode(endpointDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAMED_ENDPOINT: {
				NamedEndpoint namedEndpoint = (NamedEndpoint)theEObject;
				T result = caseNamedEndpoint(namedEndpoint);
				if (result == null) result = caseAbstractEndPoint(namedEndpoint);
				if (result == null) result = caseEndPoint(namedEndpoint);
				if (result == null) result = caseEsbElement(namedEndpoint);
				if (result == null) result = caseEsbNode(namedEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAMED_ENDPOINT_INPUT_CONNECTOR: {
				NamedEndpointInputConnector namedEndpointInputConnector = (NamedEndpointInputConnector)theEObject;
				T result = caseNamedEndpointInputConnector(namedEndpointInputConnector);
				if (result == null) result = caseInputConnector(namedEndpointInputConnector);
				if (result == null) result = caseEsbConnector(namedEndpointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAMED_ENDPOINT_OUTPUT_CONNECTOR: {
				NamedEndpointOutputConnector namedEndpointOutputConnector = (NamedEndpointOutputConnector)theEObject;
				T result = caseNamedEndpointOutputConnector(namedEndpointOutputConnector);
				if (result == null) result = caseOutputConnector(namedEndpointOutputConnector);
				if (result == null) result = caseEsbConnector(namedEndpointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TEMPLATE: {
				Template template = (Template)theEObject;
				T result = caseTemplate(template);
				if (result == null) result = caseEsbElement(template);
				if (result == null) result = caseEsbNode(template);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TEMPLATE_PARAMETER: {
				TemplateParameter templateParameter = (TemplateParameter)theEObject;
				T result = caseTemplateParameter(templateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseEsbElement(task);
				if (result == null) result = caseEsbNode(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.NAME_VALUE_TYPE_PROPERTY: {
				NameValueTypeProperty nameValueTypeProperty = (NameValueTypeProperty)theEObject;
				T result = caseNameValueTypeProperty(nameValueTypeProperty);
				if (result == null) result = caseEsbNode(nameValueTypeProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.TASK_PROPERTY: {
				TaskProperty taskProperty = (TaskProperty)theEObject;
				T result = caseTaskProperty(taskProperty);
				if (result == null) result = caseNameValueTypeProperty(taskProperty);
				if (result == null) result = caseEsbNode(taskProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.SYNAPSE_API: {
				SynapseAPI synapseAPI = (SynapseAPI)theEObject;
				T result = caseSynapseAPI(synapseAPI);
				if (result == null) result = caseEsbElement(synapseAPI);
				if (result == null) result = caseEsbNode(synapseAPI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE: {
				APIResource apiResource = (APIResource)theEObject;
				T result = caseAPIResource(apiResource);
				if (result == null) result = caseEsbNode(apiResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_INPUT_CONNECTOR: {
				APIResourceInputConnector apiResourceInputConnector = (APIResourceInputConnector)theEObject;
				T result = caseAPIResourceInputConnector(apiResourceInputConnector);
				if (result == null) result = caseInputConnector(apiResourceInputConnector);
				if (result == null) result = caseEsbConnector(apiResourceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_OUTPUT_CONNECTOR: {
				APIResourceOutputConnector apiResourceOutputConnector = (APIResourceOutputConnector)theEObject;
				T result = caseAPIResourceOutputConnector(apiResourceOutputConnector);
				if (result == null) result = caseOutputConnector(apiResourceOutputConnector);
				if (result == null) result = caseEsbConnector(apiResourceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_OUT_SEQUENCE_OUTPUT_CONNECTOR: {
				APIResourceOutSequenceOutputConnector apiResourceOutSequenceOutputConnector = (APIResourceOutSequenceOutputConnector)theEObject;
				T result = caseAPIResourceOutSequenceOutputConnector(apiResourceOutSequenceOutputConnector);
				if (result == null) result = caseOutputConnector(apiResourceOutSequenceOutputConnector);
				if (result == null) result = caseEsbConnector(apiResourceOutSequenceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_IN_SEQUENCE_INPUT_CONNECTOR: {
				APIResourceInSequenceInputConnector apiResourceInSequenceInputConnector = (APIResourceInSequenceInputConnector)theEObject;
				T result = caseAPIResourceInSequenceInputConnector(apiResourceInSequenceInputConnector);
				if (result == null) result = caseInputConnector(apiResourceInSequenceInputConnector);
				if (result == null) result = caseEsbConnector(apiResourceInSequenceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_FAULT_INPUT_CONNECTOR: {
				APIResourceFaultInputConnector apiResourceFaultInputConnector = (APIResourceFaultInputConnector)theEObject;
				T result = caseAPIResourceFaultInputConnector(apiResourceFaultInputConnector);
				if (result == null) result = caseInputConnector(apiResourceFaultInputConnector);
				if (result == null) result = caseEsbConnector(apiResourceFaultInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_ENDPOINT: {
				APIResourceEndpoint apiResourceEndpoint = (APIResourceEndpoint)theEObject;
				T result = caseAPIResourceEndpoint(apiResourceEndpoint);
				if (result == null) result = caseAbstractEndPoint(apiResourceEndpoint);
				if (result == null) result = caseEndPoint(apiResourceEndpoint);
				if (result == null) result = caseEsbElement(apiResourceEndpoint);
				if (result == null) result = caseEsbNode(apiResourceEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_ENDPOINT_INPUT_CONNECTOR: {
				APIResourceEndpointInputConnector apiResourceEndpointInputConnector = (APIResourceEndpointInputConnector)theEObject;
				T result = caseAPIResourceEndpointInputConnector(apiResourceEndpointInputConnector);
				if (result == null) result = caseInputConnector(apiResourceEndpointInputConnector);
				if (result == null) result = caseEsbConnector(apiResourceEndpointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_RESOURCE_ENDPOINT_OUTPUT_CONNECTOR: {
				APIResourceEndpointOutputConnector apiResourceEndpointOutputConnector = (APIResourceEndpointOutputConnector)theEObject;
				T result = caseAPIResourceEndpointOutputConnector(apiResourceEndpointOutputConnector);
				if (result == null) result = caseOutputConnector(apiResourceEndpointOutputConnector);
				if (result == null) result = caseEsbConnector(apiResourceEndpointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMPLEX_ENDPOINTS: {
				ComplexEndpoints complexEndpoints = (ComplexEndpoints)theEObject;
				T result = caseComplexEndpoints(complexEndpoints);
				if (result == null) result = caseEsbElement(complexEndpoints);
				if (result == null) result = caseEsbNode(complexEndpoints);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMPLEX_ENDPOINTS_OUTPUT_CONNECTOR: {
				ComplexEndpointsOutputConnector complexEndpointsOutputConnector = (ComplexEndpointsOutputConnector)theEObject;
				T result = caseComplexEndpointsOutputConnector(complexEndpointsOutputConnector);
				if (result == null) result = caseOutputConnector(complexEndpointsOutputConnector);
				if (result == null) result = caseEsbConnector(complexEndpointsOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESSING_ENDPOINT: {
				AddressingEndpoint addressingEndpoint = (AddressingEndpoint)theEObject;
				T result = caseAddressingEndpoint(addressingEndpoint);
				if (result == null) result = caseAbstractEndPoint(addressingEndpoint);
				if (result == null) result = caseEndPoint(addressingEndpoint);
				if (result == null) result = caseEsbElement(addressingEndpoint);
				if (result == null) result = caseEsbNode(addressingEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESSING_ENDPOINT_INPUT_CONNECTOR: {
				AddressingEndpointInputConnector addressingEndpointInputConnector = (AddressingEndpointInputConnector)theEObject;
				T result = caseAddressingEndpointInputConnector(addressingEndpointInputConnector);
				if (result == null) result = caseInputConnector(addressingEndpointInputConnector);
				if (result == null) result = caseEsbConnector(addressingEndpointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.ADDRESSING_ENDPOINT_OUTPUT_CONNECTOR: {
				AddressingEndpointOutputConnector addressingEndpointOutputConnector = (AddressingEndpointOutputConnector)theEObject;
				T result = caseAddressingEndpointOutputConnector(addressingEndpointOutputConnector);
				if (result == null) result = caseOutputConnector(addressingEndpointOutputConnector);
				if (result == null) result = caseEsbConnector(addressingEndpointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RECIPIENT_LIST_END_POINT: {
				RecipientListEndPoint recipientListEndPoint = (RecipientListEndPoint)theEObject;
				T result = caseRecipientListEndPoint(recipientListEndPoint);
				if (result == null) result = caseParentEndPoint(recipientListEndPoint);
				if (result == null) result = caseEndPoint(recipientListEndPoint);
				if (result == null) result = caseEsbElement(recipientListEndPoint);
				if (result == null) result = caseEsbNode(recipientListEndPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RECIPIENT_LIST_END_POINT_INPUT_CONNECTOR: {
				RecipientListEndPointInputConnector recipientListEndPointInputConnector = (RecipientListEndPointInputConnector)theEObject;
				T result = caseRecipientListEndPointInputConnector(recipientListEndPointInputConnector);
				if (result == null) result = caseInputConnector(recipientListEndPointInputConnector);
				if (result == null) result = caseEsbConnector(recipientListEndPointInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RECIPIENT_LIST_END_POINT_OUTPUT_CONNECTOR: {
				RecipientListEndPointOutputConnector recipientListEndPointOutputConnector = (RecipientListEndPointOutputConnector)theEObject;
				T result = caseRecipientListEndPointOutputConnector(recipientListEndPointOutputConnector);
				if (result == null) result = caseOutputConnector(recipientListEndPointOutputConnector);
				if (result == null) result = caseEsbConnector(recipientListEndPointOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.RECIPIENT_LIST_END_POINT_WEST_OUTPUT_CONNECTOR: {
				RecipientListEndPointWestOutputConnector recipientListEndPointWestOutputConnector = (RecipientListEndPointWestOutputConnector)theEObject;
				T result = caseRecipientListEndPointWestOutputConnector(recipientListEndPointWestOutputConnector);
				if (result == null) result = caseOutputConnector(recipientListEndPointWestOutputConnector);
				if (result == null) result = caseEsbConnector(recipientListEndPointWestOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_STORE_PARAMETER: {
				MessageStoreParameter messageStoreParameter = (MessageStoreParameter)theEObject;
				T result = caseMessageStoreParameter(messageStoreParameter);
				if (result == null) result = caseEsbNode(messageStoreParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_STORE: {
				MessageStore messageStore = (MessageStore)theEObject;
				T result = caseMessageStore(messageStore);
				if (result == null) result = caseEsbElement(messageStore);
				if (result == null) result = caseEsbNode(messageStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_PROCESSOR_PARAMETER: {
				MessageProcessorParameter messageProcessorParameter = (MessageProcessorParameter)theEObject;
				T result = caseMessageProcessorParameter(messageProcessorParameter);
				if (result == null) result = caseEsbNode(messageProcessorParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.MESSAGE_PROCESSOR: {
				MessageProcessor messageProcessor = (MessageProcessor)theEObject;
				T result = caseMessageProcessor(messageProcessor);
				if (result == null) result = caseEsbElement(messageProcessor);
				if (result == null) result = caseEsbNode(messageProcessor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_HANDLER: {
				APIHandler apiHandler = (APIHandler)theEObject;
				T result = caseAPIHandler(apiHandler);
				if (result == null) result = caseEsbNode(apiHandler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.API_HANDLER_PROPERTY: {
				APIHandlerProperty apiHandlerProperty = (APIHandlerProperty)theEObject;
				T result = caseAPIHandlerProperty(apiHandlerProperty);
				if (result == null) result = caseEsbNode(apiHandlerProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLOUD_CONNECTOR: {
				CloudConnector cloudConnector = (CloudConnector)theEObject;
				T result = caseCloudConnector(cloudConnector);
				if (result == null) result = caseEsbElement(cloudConnector);
				if (result == null) result = caseEsbNode(cloudConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLOUD_CONNECTOR_INPUT_CONNECTOR: {
				CloudConnectorInputConnector cloudConnectorInputConnector = (CloudConnectorInputConnector)theEObject;
				T result = caseCloudConnectorInputConnector(cloudConnectorInputConnector);
				if (result == null) result = caseInputConnector(cloudConnectorInputConnector);
				if (result == null) result = caseEsbConnector(cloudConnectorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLOUD_CONNECTOR_OUTPUT_CONNECTOR: {
				CloudConnectorOutputConnector cloudConnectorOutputConnector = (CloudConnectorOutputConnector)theEObject;
				T result = caseCloudConnectorOutputConnector(cloudConnectorOutputConnector);
				if (result == null) result = caseOutputConnector(cloudConnectorOutputConnector);
				if (result == null) result = caseEsbConnector(cloudConnectorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLOUD_CONNECTOR_OPERATION: {
				CloudConnectorOperation cloudConnectorOperation = (CloudConnectorOperation)theEObject;
				T result = caseCloudConnectorOperation(cloudConnectorOperation);
				if (result == null) result = caseMediator(cloudConnectorOperation);
				if (result == null) result = caseEsbElement(cloudConnectorOperation);
				if (result == null) result = caseEsbNode(cloudConnectorOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLOUD_CONNECTOR_OPERATION_INPUT_CONNECTOR: {
				CloudConnectorOperationInputConnector cloudConnectorOperationInputConnector = (CloudConnectorOperationInputConnector)theEObject;
				T result = caseCloudConnectorOperationInputConnector(cloudConnectorOperationInputConnector);
				if (result == null) result = caseInputConnector(cloudConnectorOperationInputConnector);
				if (result == null) result = caseEsbConnector(cloudConnectorOperationInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.CLOUD_CONNECTOR_OPERATION_OUTPUT_CONNECTOR: {
				CloudConnectorOperationOutputConnector cloudConnectorOperationOutputConnector = (CloudConnectorOperationOutputConnector)theEObject;
				T result = caseCloudConnectorOperationOutputConnector(cloudConnectorOperationOutputConnector);
				if (result == null) result = caseOutputConnector(cloudConnectorOperationOutputConnector);
				if (result == null) result = caseEsbConnector(cloudConnectorOperationOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DATA_MAPPER_MEDIATOR: {
				DataMapperMediator dataMapperMediator = (DataMapperMediator)theEObject;
				T result = caseDataMapperMediator(dataMapperMediator);
				if (result == null) result = caseMediator(dataMapperMediator);
				if (result == null) result = caseEsbElement(dataMapperMediator);
				if (result == null) result = caseEsbNode(dataMapperMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DATA_MAPPER_MEDIATOR_INPUT_CONNECTOR: {
				DataMapperMediatorInputConnector dataMapperMediatorInputConnector = (DataMapperMediatorInputConnector)theEObject;
				T result = caseDataMapperMediatorInputConnector(dataMapperMediatorInputConnector);
				if (result == null) result = caseInputConnector(dataMapperMediatorInputConnector);
				if (result == null) result = caseEsbConnector(dataMapperMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.DATA_MAPPER_MEDIATOR_OUTPUT_CONNECTOR: {
				DataMapperMediatorOutputConnector dataMapperMediatorOutputConnector = (DataMapperMediatorOutputConnector)theEObject;
				T result = caseDataMapperMediatorOutputConnector(dataMapperMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(dataMapperMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(dataMapperMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAST_XSLT_MEDIATOR: {
				FastXSLTMediator fastXSLTMediator = (FastXSLTMediator)theEObject;
				T result = caseFastXSLTMediator(fastXSLTMediator);
				if (result == null) result = caseMediator(fastXSLTMediator);
				if (result == null) result = caseEsbElement(fastXSLTMediator);
				if (result == null) result = caseEsbNode(fastXSLTMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAST_XSLT_MEDIATOR_INPUT_CONNECTOR: {
				FastXSLTMediatorInputConnector fastXSLTMediatorInputConnector = (FastXSLTMediatorInputConnector)theEObject;
				T result = caseFastXSLTMediatorInputConnector(fastXSLTMediatorInputConnector);
				if (result == null) result = caseInputConnector(fastXSLTMediatorInputConnector);
				if (result == null) result = caseEsbConnector(fastXSLTMediatorInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.FAST_XSLT_MEDIATOR_OUTPUT_CONNECTOR: {
				FastXSLTMediatorOutputConnector fastXSLTMediatorOutputConnector = (FastXSLTMediatorOutputConnector)theEObject;
				T result = caseFastXSLTMediatorOutputConnector(fastXSLTMediatorOutputConnector);
				if (result == null) result = caseOutputConnector(fastXSLTMediatorOutputConnector);
				if (result == null) result = caseEsbConnector(fastXSLTMediatorOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT: {
				InboundEndpoint inboundEndpoint = (InboundEndpoint)theEObject;
				T result = caseInboundEndpoint(inboundEndpoint);
				if (result == null) result = caseEsbElement(inboundEndpoint);
				if (result == null) result = caseEsbNode(inboundEndpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_PARAMETER: {
				InboundEndpointParameter inboundEndpointParameter = (InboundEndpointParameter)theEObject;
				T result = caseInboundEndpointParameter(inboundEndpointParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER: {
				InboundEndpointContainer inboundEndpointContainer = (InboundEndpointContainer)theEObject;
				T result = caseInboundEndpointContainer(inboundEndpointContainer);
				if (result == null) result = caseEsbElement(inboundEndpointContainer);
				if (result == null) result = caseEsbNode(inboundEndpointContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_SEQUENCE_CONTAINER: {
				InboundEndpointSequenceContainer inboundEndpointSequenceContainer = (InboundEndpointSequenceContainer)theEObject;
				T result = caseInboundEndpointSequenceContainer(inboundEndpointSequenceContainer);
				if (result == null) result = caseEsbNode(inboundEndpointSequenceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_CONTAINER: {
				InboundEndpointOnErrorSequenceContainer inboundEndpointOnErrorSequenceContainer = (InboundEndpointOnErrorSequenceContainer)theEObject;
				T result = caseInboundEndpointOnErrorSequenceContainer(inboundEndpointOnErrorSequenceContainer);
				if (result == null) result = caseEsbNode(inboundEndpointOnErrorSequenceContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_SEQUENCE_INPUT_CONNECTOR: {
				InboundEndpointSequenceInputConnector inboundEndpointSequenceInputConnector = (InboundEndpointSequenceInputConnector)theEObject;
				T result = caseInboundEndpointSequenceInputConnector(inboundEndpointSequenceInputConnector);
				if (result == null) result = caseInputConnector(inboundEndpointSequenceInputConnector);
				if (result == null) result = caseEsbConnector(inboundEndpointSequenceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_SEQUENCE_OUTPUT_CONNECTOR: {
				InboundEndpointSequenceOutputConnector inboundEndpointSequenceOutputConnector = (InboundEndpointSequenceOutputConnector)theEObject;
				T result = caseInboundEndpointSequenceOutputConnector(inboundEndpointSequenceOutputConnector);
				if (result == null) result = caseOutputConnector(inboundEndpointSequenceOutputConnector);
				if (result == null) result = caseEsbConnector(inboundEndpointSequenceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR: {
				InboundEndpointOnErrorSequenceOutputConnector inboundEndpointOnErrorSequenceOutputConnector = (InboundEndpointOnErrorSequenceOutputConnector)theEObject;
				T result = caseInboundEndpointOnErrorSequenceOutputConnector(inboundEndpointOnErrorSequenceOutputConnector);
				if (result == null) result = caseOutputConnector(inboundEndpointOnErrorSequenceOutputConnector);
				if (result == null) result = caseEsbConnector(inboundEndpointOnErrorSequenceOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_INPUT_CONNECTOR: {
				InboundEndpointOnErrorSequenceInputConnector inboundEndpointOnErrorSequenceInputConnector = (InboundEndpointOnErrorSequenceInputConnector)theEObject;
				T result = caseInboundEndpointOnErrorSequenceInputConnector(inboundEndpointOnErrorSequenceInputConnector);
				if (result == null) result = caseInputConnector(inboundEndpointOnErrorSequenceInputConnector);
				if (result == null) result = caseEsbConnector(inboundEndpointOnErrorSequenceInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EsbPackage.COMMENT_MEDIATOR: {
				CommentMediator commentMediator = (CommentMediator)theEObject;
				T result = caseCommentMediator(commentMediator);
				if (result == null) result = caseMediator(commentMediator);
				if (result == null) result = caseEsbElement(commentMediator);
				if (result == null) result = caseEsbNode(commentMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbDiagram(EsbDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbNode(EsbNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbElement(EsbElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbServer(EsbServer object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbConnector(EsbConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputConnector(InputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputConnector(OutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additional Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additional Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditionalOutputConnector(AdditionalOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbLink(EsbLink object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Call Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallMediator(CallMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallMediatorInputConnector(CallMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallMediatorOutputConnector(CallMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Mediator Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Mediator Endpoint Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallMediatorEndpointOutputConnector(CallMediatorEndpointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Point Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Point Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndPointProperty(EndPointProperty object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyOutputConnector(ProxyOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyInputConnector(ProxyInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Out Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Out Sequence Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyOutSequenceOutputConnector(ProxyOutSequenceOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy In Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy In Sequence Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyInSequenceInputConnector(ProxyInSequenceInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy WSDL Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy WSDL Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyWSDLResource(ProxyWSDLResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Fault Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Fault Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyFaultInputConnector(ProxyFaultInputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Service Sequence And Endpoint Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Service Sequence And Endpoint Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyServiceSequenceAndEndpointContainer(ProxyServiceSequenceAndEndpointContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Service Fault Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Service Fault Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyServiceFaultContainer(ProxyServiceFaultContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proxy Service Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proxy Service Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProxyServiceContainer(ProxyServiceContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mediator Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mediator Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediatorFlow(MediatorFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Endpoint Flow</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Endpoint Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseEndpointFlow(EndpointFlow object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Message Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageMediator(MessageMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageInputConnector(MessageInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageOutputConnector(MessageOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Default End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultEndPointInputConnector(DefaultEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultEndPointOutputConnector(DefaultEndPointOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Address End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressEndPointInputConnector(AddressEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressEndPointOutputConnector(AddressEndPointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateEndpoint(TemplateEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Endpoint Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateEndpointInputConnector(TemplateEndpointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Endpoint Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateEndpointOutputConnector(TemplateEndpointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Endpoint Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Endpoint Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateEndpointParameter(TemplateEndpointParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HTTP Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HTTP Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHTTPEndpoint(HTTPEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HTTP End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HTTP End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHTTPEndPointInputConnector(HTTPEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HTTP End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HTTP End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHTTPEndPointOutputConnector(HTTPEndPointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drop Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drop Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDropMediator(DropMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drop Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drop Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDropMediatorInputConnector(DropMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterMediator(FilterMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseFilterContainer(FilterContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Pass Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Pass Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseFilterPassContainer(FilterPassContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Fail Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Fail Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseFilterFailContainer(FilterFailContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterMediatorInputConnector(FilterMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseFilterMediatorOutputConnector(FilterMediatorOutputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Mediator Pass Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Mediator Pass Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterMediatorPassOutputConnector(FilterMediatorPassOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Mediator Fail Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Mediator Fail Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterMediatorFailOutputConnector(FilterMediatorFailOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeNode(MergeNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Node First Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Node First Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeNodeFirstInputConnector(MergeNodeFirstInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Node Second Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Node Second Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeNodeSecondInputConnector(MergeNodeSecondInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Merge Node Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Merge Node Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMergeNodeOutputConnector(MergeNodeOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogMediator(LogMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogMediatorInputConnector(LogMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogMediatorOutputConnector(LogMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Log Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Log Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogProperty(LogProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish Event Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish Event Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishEventMediator(PublishEventMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish Event Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish Event Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishEventMediatorInputConnector(PublishEventMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish Event Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish Event Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishEventMediatorOutputConnector(PublishEventMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish Event Mediator Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish Event Mediator Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishEventMediatorAttribute(PublishEventMediatorAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Name Value Expression Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Name Value Expression Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNameValueExpressionAttribute(AbstractNameValueExpressionAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BAM Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BAM Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBAMMediator(BAMMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BAM Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BAM Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBAMMediatorInputConnector(BAMMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BAM Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BAM Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBAMMediatorOutputConnector(BAMMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bean Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bean Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeanMediator(BeanMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bean Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bean Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeanMediatorInputConnector(BeanMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bean Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bean Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeanMediatorOutputConnector(BeanMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EJB Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EJB Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEJBMediator(EJBMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EJB Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EJB Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEJBMediatorInputConnector(EJBMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EJB Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EJB Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEJBMediatorOutputConnector(EJBMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodArgument(MethodArgument object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Property Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyMediator(PropertyMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyMediatorInputConnector(PropertyMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyMediatorOutputConnector(PropertyMediatorOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Enrich Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enrich Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnrichMediator(EnrichMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enrich Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enrich Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnrichMediatorInputConnector(EnrichMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enrich Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enrich Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnrichMediatorOutputConnector(EnrichMediatorOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>XSLT Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSLT Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSLTMediator(XSLTMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSLT Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSLT Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSLTProperty(XSLTProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSLT Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSLT Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSLTFeature(XSLTFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSLT Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSLT Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSLTResource(XSLTResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSLT Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSLT Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSLTMediatorInputConnector(XSLTMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSLT Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSLT Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSLTMediatorOutputConnector(XSLTMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchMediator(SwitchMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Branch Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Branch Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseBranchOutputConnector(SwitchCaseBranchOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Default Branch Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Default Branch Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchDefaultBranchOutputConnector(SwitchDefaultBranchOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchMediatorInputConnector(SwitchMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchMediatorOutputConnector(SwitchMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Mediator Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Mediator Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchMediatorContainer(SwitchMediatorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Parent Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Parent Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseParentContainer(SwitchCaseParentContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Default Parent Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Default Parent Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchDefaultParentContainer(SwitchDefaultParentContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseContainer(SwitchCaseContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Default Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Default Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchDefaultContainer(SwitchDefaultContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceDiagram(SequenceDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbSequence(EsbSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbSequenceInput(EsbSequenceInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbSequenceOutput(EsbSequenceOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbSequenceInputConnector(EsbSequenceInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEsbSequenceOutputConnector(EsbSequenceOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceInputConnector(SequenceInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceOutputConnector(SequenceOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventMediator(EventMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventMediatorInputConnector(EventMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventMediatorOutputConnector(EventMediatorOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediator(EntitlementMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorInputConnector(EntitlementMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorOutputConnector(EntitlementMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator On Reject Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator On Reject Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorOnRejectOutputConnector(EntitlementMediatorOnRejectOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator On Accept Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator On Accept Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorOnAcceptOutputConnector(EntitlementMediatorOnAcceptOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator Advice Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator Advice Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorAdviceOutputConnector(EntitlementMediatorAdviceOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator Obligations Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator Obligations Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorObligationsOutputConnector(EntitlementMediatorObligationsOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementContainer(EntitlementContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement On Reject Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement On Reject Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementOnRejectContainer(EntitlementOnRejectContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement On Accept Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement On Accept Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementOnAcceptContainer(EntitlementOnAcceptContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Advice Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Advice Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementAdviceContainer(EntitlementAdviceContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Obligations Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Obligations Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementObligationsContainer(EntitlementObligationsContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enqueue Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enqueue Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnqueueMediator(EnqueueMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enqueue Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enqueue Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnqueueMediatorInputConnector(EnqueueMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enqueue Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enqueue Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnqueueMediatorOutputConnector(EnqueueMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMediator(ClassMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMediatorInputConnector(ClassMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMediatorOutputConnector(ClassMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassProperty(ClassProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spring Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spring Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpringMediator(SpringMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spring Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spring Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpringMediatorInputConnector(SpringMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spring Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spring Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpringMediatorOutputConnector(SpringMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateMediator(ValidateMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateResource(ValidateResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateFeature(ValidateFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Schema</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Schema</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateSchema(ValidateSchema object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateMediatorInputConnector(ValidateMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateMediatorOutputConnector(ValidateMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate Mediator On Fail Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate Mediator On Fail Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateMediatorOnFailOutputConnector(ValidateMediatorOnFailOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Endpoint Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Endpoint Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndpointDiagram(EndpointDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedEndpoint(NamedEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Endpoint Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedEndpointInputConnector(NamedEndpointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Endpoint Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedEndpointOutputConnector(NamedEndpointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplate(Template object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateParameter(TemplateParameter object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>API Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResource(APIResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceInputConnector(APIResourceInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceOutputConnector(APIResourceOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Out Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Out Sequence Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceOutSequenceOutputConnector(APIResourceOutSequenceOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource In Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource In Sequence Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceInSequenceInputConnector(APIResourceInSequenceInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Fault Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Fault Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceFaultInputConnector(APIResourceFaultInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceEndpoint(APIResourceEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Endpoint Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceEndpointInputConnector(APIResourceEndpointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Resource Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Resource Endpoint Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIResourceEndpointOutputConnector(APIResourceEndpointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Endpoints</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Endpoints</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexEndpoints(ComplexEndpoints object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Endpoints Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Endpoints Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexEndpointsOutputConnector(ComplexEndpointsOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Addressing Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Addressing Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressingEndpoint(AddressingEndpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Addressing Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Addressing Endpoint Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressingEndpointInputConnector(AddressingEndpointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Addressing Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Addressing Endpoint Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressingEndpointOutputConnector(AddressingEndpointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient List End Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient List End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecipientListEndPoint(RecipientListEndPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient List End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient List End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecipientListEndPointInputConnector(RecipientListEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient List End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient List End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecipientListEndPointOutputConnector(RecipientListEndPointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient List End Point West Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient List End Point West Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecipientListEndPointWestOutputConnector(RecipientListEndPointWestOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Store Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Store Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageStoreParameter(MessageStoreParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageStore(MessageStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Processor Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Processor Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageProcessorParameter(MessageProcessorParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageProcessor(MessageProcessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIHandler(APIHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>API Handler Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>API Handler Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAPIHandlerProperty(APIHandlerProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cloud Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cloud Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloudConnector(CloudConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cloud Connector Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cloud Connector Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloudConnectorInputConnector(CloudConnectorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cloud Connector Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cloud Connector Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloudConnectorOutputConnector(CloudConnectorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cloud Connector Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cloud Connector Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloudConnectorOperation(CloudConnectorOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cloud Connector Operation Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cloud Connector Operation Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloudConnectorOperationInputConnector(CloudConnectorOperationInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cloud Connector Operation Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cloud Connector Operation Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloudConnectorOperationOutputConnector(CloudConnectorOperationOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Mapper Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Mapper Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapperMediator(DataMapperMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Mapper Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Mapper Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapperMediatorInputConnector(DataMapperMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Mapper Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Mapper Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapperMediatorOutputConnector(DataMapperMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fast XSLT Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fast XSLT Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFastXSLTMediator(FastXSLTMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fast XSLT Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fast XSLT Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFastXSLTMediatorInputConnector(FastXSLTMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fast XSLT Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fast XSLT Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFastXSLTMediatorOutputConnector(FastXSLTMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpoint(InboundEndpoint object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInboundEndpointParameter(InboundEndpointParameter object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointContainer(InboundEndpointContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint Sequence Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint Sequence Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointSequenceContainer(InboundEndpointSequenceContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint On Error Sequence Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint On Error Sequence Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointOnErrorSequenceContainer(InboundEndpointOnErrorSequenceContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint Sequence Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointSequenceInputConnector(InboundEndpointSequenceInputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint Sequence Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointSequenceOutputConnector(InboundEndpointSequenceOutputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint On Error Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint On Error Sequence Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointOnErrorSequenceOutputConnector(InboundEndpointOnErrorSequenceOutputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inbound Endpoint On Error Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inbound Endpoint On Error Sequence Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInboundEndpointOnErrorSequenceInputConnector(InboundEndpointOnErrorSequenceInputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Comment Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommentMediator(CommentMediator object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptMediator(ScriptMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptMediatorInputConnector(ScriptMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptMediatorOutputConnector(ScriptMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultMediator(FaultMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultMediatorInputConnector(FaultMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultMediatorOutputConnector(FaultMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregate Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregateMediator(AggregateMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregate Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregate Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregateMediatorInputConnector(AggregateMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregate Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregate Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregateMediatorOutputConnector(AggregateMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregate Mediator On Complete Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregate Mediator On Complete Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregateMediatorOnCompleteOutputConnector(AggregateMediatorOnCompleteOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterMediator(RouterMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Route</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Route</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterRoute(RouterRoute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterTarget(RouterTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterMediatorInputConnector(RouterMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterMediatorOutputConnector(RouterMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Mediator Target Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterMediatorTargetOutputConnector(RouterMediatorTargetOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Mediator Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Mediator Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterMediatorContainer(RouterMediatorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Router Target Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Router Target Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouterTargetContainer(RouterTargetContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneMediator(CloneMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneTarget(CloneTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneMediatorInputConnector(CloneMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneMediatorOutputConnector(CloneMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Mediator Target Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneMediatorTargetOutputConnector(CloneMediatorTargetOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Mediator Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Mediator Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneMediatorContainer(CloneMediatorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Target Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Target Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneTargetContainer(CloneTargetContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachMediator(ForEachMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachMediatorInputConnector(ForEachMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachMediatorOutputConnector(ForEachMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Mediator Target Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachMediatorTargetOutputConnector(ForEachMediatorTargetOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachTarget(ForEachTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateMediator(IterateMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateMediatorInputConnector(IterateMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateMediatorOutputConnector(IterateMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Mediator Target Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateMediatorTargetOutputConnector(IterateMediatorTargetOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateTarget(IterateTarget object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Cache Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheMediator(CacheMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheMediatorInputConnector(CacheMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheMediatorOutputConnector(CacheMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache Mediator On Hit Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Mediator On Hit Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheMediatorOnHitOutputConnector(CacheMediatorOnHitOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache On Hit Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache On Hit Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheOnHitBranch(CacheOnHitBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XQuery Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XQuery Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXQueryMediator(XQueryMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XQuery Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XQuery Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXQueryMediatorInputConnector(XQueryMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XQuery Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XQuery Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXQueryMediatorOutputConnector(XQueryMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XQuery Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XQuery Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXQueryVariable(XQueryVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callout Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callout Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalloutMediator(CalloutMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callout Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callout Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalloutMediatorInputConnector(CalloutMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callout Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callout Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalloutMediatorOutputConnector(CalloutMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RM Sequence Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RM Sequence Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRMSequenceMediator(RMSequenceMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RM Sequence Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RM Sequence Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRMSequenceMediatorInputConnector(RMSequenceMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RM Sequence Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RM Sequence Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRMSequenceMediatorOutputConnector(RMSequenceMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transaction Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transaction Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionMediator(TransactionMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transaction Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transaction Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionMediatorInputConnector(TransactionMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transaction Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transaction Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransactionMediatorOutputConnector(TransactionMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OAuth Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OAuth Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOAuthMediator(OAuthMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OAuth Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OAuth Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOAuthMediatorInputConnector(OAuthMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OAuth Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OAuth Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOAuthMediatorOutputConnector(OAuthMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Autoscale In Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Autoscale In Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutoscaleInMediator(AutoscaleInMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Autoscale Out Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Autoscale Out Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAutoscaleOutMediator(AutoscaleOutMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Header Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Header Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeaderMediator(HeaderMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Header Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Header Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeaderMediatorInputConnector(HeaderMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Header Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Header Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeaderMediatorOutputConnector(HeaderMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottleMediator(ThrottleMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottleMediatorInputConnector(ThrottleMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottleMediatorOutputConnector(ThrottleMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Mediator On Accept Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Mediator On Accept Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseThrottleMediatorOnAcceptOutputConnector(ThrottleMediatorOnAcceptOutputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Mediator On Reject Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Mediator On Reject Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseThrottleMediatorOnRejectOutputConnector(ThrottleMediatorOnRejectOutputConnector object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Policy Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Policy Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottlePolicyConfiguration(ThrottlePolicyConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Policy Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Policy Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottlePolicyEntry(ThrottlePolicyEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle On Accept Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle On Accept Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottleOnAcceptBranch(ThrottleOnAcceptBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle On Reject Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle On Reject Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrottleOnRejectBranch(ThrottleOnRejectBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseThrottleContainer(ThrottleContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle On Accept Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle On Accept Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseThrottleOnAcceptContainer(ThrottleOnAcceptContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Throttle On Reject Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throttle On Reject Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseThrottleOnRejectContainer(ThrottleOnRejectContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Command Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandMediator(CommandMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandMediatorInputConnector(CommandMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandMediatorOutputConnector(CommandMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandProperty(CommandProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Sql Executor Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Sql Executor Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractSqlExecutorMediator(AbstractSqlExecutorMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sql Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sql Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSqlStatement(SqlStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sql Parameter Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sql Parameter Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSqlParameterDefinition(SqlParameterDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sql Result Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sql Result Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSqlResultMapping(SqlResultMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Lookup Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Lookup Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBLookupMediator(DBLookupMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Lookup Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Lookup Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBLookupMediatorInputConnector(DBLookupMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Lookup Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Lookup Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBLookupMediatorOutputConnector(DBLookupMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Report Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Report Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBReportMediator(DBReportMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Report Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Report Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBReportMediatorInputConnector(DBReportMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB Report Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB Report Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDBReportMediatorOutputConnector(DBReportMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleMediator(RuleMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleMediatorInputConnector(RuleMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleMediatorOutputConnector(RuleMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Mediator Child Mediators Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Mediator Child Mediators Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleMediatorChildMediatorsOutputConnector(RuleMediatorChildMediatorsOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Set Creation Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Set Creation Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleSetCreationProperty(RuleSetCreationProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Session Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Session Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleSessionProperty(RuleSessionProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Facts Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Facts Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleFactsConfiguration(RuleFactsConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Fact</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Fact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleFact(RuleFact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Results Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Results Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleResultsConfiguration(RuleResultsConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleResult(RuleResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Child Mediators Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Child Mediators Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleChildMediatorsConfiguration(RuleChildMediatorsConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallTemplateParameter(CallTemplateParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Template Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Template Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallTemplateMediator(CallTemplateMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Template Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Template Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallTemplateMediatorInputConnector(CallTemplateMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Template Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Template Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallTemplateMediatorOutputConnector(CallTemplateMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Back Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Back Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopBackMediator(LoopBackMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Back Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Back Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopBackMediatorInputConnector(LoopBackMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Back Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Back Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopBackMediatorOutputConnector(LoopBackMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Respond Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Respond Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRespondMediator(RespondMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Respond Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Respond Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRespondMediatorInputConnector(RespondMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Respond Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Respond Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRespondMediatorOutputConnector(RespondMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Smooks Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smooks Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmooksMediator(SmooksMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Smooks Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smooks Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmooksMediatorInputConnector(SmooksMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Smooks Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smooks Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmooksMediatorOutputConnector(SmooksMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoreMediator(StoreMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoreMediatorInputConnector(StoreMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoreMediatorOutputConnector(StoreMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builder Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builder Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuilderMediator(BuilderMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builder Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builder Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuilderMediatorInputConnector(BuilderMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builder Mediator Output Conector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builder Mediator Output Conector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuilderMediatorOutputConector(BuilderMediatorOutputConector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Builder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Builder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageBuilder(MessageBuilder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Payload Factory Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Payload Factory Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePayloadFactoryMediator(PayloadFactoryMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Payload Factory Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Payload Factory Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePayloadFactoryMediatorInputConnector(PayloadFactoryMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Payload Factory Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Payload Factory Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePayloadFactoryMediatorOutputConnector(PayloadFactoryMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Payload Factory Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Payload Factory Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePayloadFactoryArgument(PayloadFactoryArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Route Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Route Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalRouteBranch(ConditionalRouteBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Router Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Router Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalRouterMediator(ConditionalRouterMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Router Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Router Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalRouterMediatorInputConnector(ConditionalRouterMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Router Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Router Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalRouterMediatorOutputConnector(ConditionalRouterMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Router Mediator Additional Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Router Mediator Additional Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalRouterMediatorAdditionalOutputConnector(ConditionalRouterMediatorAdditionalOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSendMediator(SendMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSendContainer(SendContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Send Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSendMediatorInputConnector(SendMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSendMediatorOutputConnector(SendMediatorOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Mediator Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Mediator Endpoint Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSendMediatorEndpointOutputConnector(SendMediatorEndpointOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Failover End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failover End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailoverEndPointInputConnector(FailoverEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failover End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failover End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailoverEndPointOutputConnector(FailoverEndPointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failover End Point West Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failover End Point West Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailoverEndPointWestOutputConnector(FailoverEndPointWestOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>WSDL End Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WSDL End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSDLEndPoint(WSDLEndPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WSDL End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WSDL End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSDLEndPointInputConnector(WSDLEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WSDL End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WSDL End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSDLEndPointOutputConnector(WSDLEndPointOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMember(Member object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Balance End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Balance End Point Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadBalanceEndPointInputConnector(LoadBalanceEndPointInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Balance End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Balance End Point Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadBalanceEndPointOutputConnector(LoadBalanceEndPointOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Balance End Point West Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Balance End Point West Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadBalanceEndPointWestOutputConnector(LoadBalanceEndPointWestOutputConnector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Session</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Session</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSession(Session object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequences</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequences</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequences(Sequences object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequences Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequences Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequencesOutputConnector(SequencesOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequences Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequences Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequencesInputConnector(SequencesInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Rewrite Rule Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Rewrite Rule Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLRewriteRuleAction(URLRewriteRuleAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Rewrite Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Rewrite Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLRewriteRule(URLRewriteRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Rewrite Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Rewrite Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLRewriteMediator(URLRewriteMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Rewrite Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Rewrite Mediator Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLRewriteMediatorInputConnector(URLRewriteMediatorInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL Rewrite Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL Rewrite Mediator Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseURLRewriteMediatorOutputConnector(URLRewriteMediatorOutputConnector object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EsbSwitch
