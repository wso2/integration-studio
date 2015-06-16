/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage
 * @generated
 */
public interface EsbFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EsbFactory eINSTANCE = org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram</em>'.
	 * @generated
	 */
	EsbDiagram createEsbDiagram();

	/**
	 * Returns a new object of class '<em>Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server</em>'.
	 * @generated
	 */
	EsbServer createEsbServer();

	/**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
	EsbLink createEsbLink();

	/**
	 * Returns a new object of class '<em>Call Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Mediator</em>'.
	 * @generated
	 */
	CallMediator createCallMediator();

	/**
	 * Returns a new object of class '<em>Call Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Mediator Input Connector</em>'.
	 * @generated
	 */
	CallMediatorInputConnector createCallMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Call Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Mediator Output Connector</em>'.
	 * @generated
	 */
	CallMediatorOutputConnector createCallMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Call Mediator Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Mediator Endpoint Output Connector</em>'.
	 * @generated
	 */
	CallMediatorEndpointOutputConnector createCallMediatorEndpointOutputConnector();

	/**
	 * Returns a new object of class '<em>End Point Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Point Property</em>'.
	 * @generated
	 */
	EndPointProperty createEndPointProperty();

	/**
	 * Returns a new object of class '<em>Proxy Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Service</em>'.
	 * @generated
	 */
	ProxyService createProxyService();

	/**
	 * Returns a new object of class '<em>Proxy Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Output Connector</em>'.
	 * @generated
	 */
	ProxyOutputConnector createProxyOutputConnector();

	/**
	 * Returns a new object of class '<em>Proxy Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Input Connector</em>'.
	 * @generated
	 */
	ProxyInputConnector createProxyInputConnector();

	/**
	 * Returns a new object of class '<em>Proxy Out Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Out Sequence Output Connector</em>'.
	 * @generated
	 */
	ProxyOutSequenceOutputConnector createProxyOutSequenceOutputConnector();

	/**
	 * Returns a new object of class '<em>Proxy In Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy In Sequence Input Connector</em>'.
	 * @generated
	 */
	ProxyInSequenceInputConnector createProxyInSequenceInputConnector();

	/**
	 * Returns a new object of class '<em>Proxy WSDL Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy WSDL Resource</em>'.
	 * @generated
	 */
	ProxyWSDLResource createProxyWSDLResource();

	/**
	 * Returns a new object of class '<em>Proxy Fault Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Fault Input Connector</em>'.
	 * @generated
	 */
	ProxyFaultInputConnector createProxyFaultInputConnector();

	/**
	 * Returns a new object of class '<em>Proxy Service Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Service Parameter</em>'.
	 * @generated
	 */
	ProxyServiceParameter createProxyServiceParameter();

	/**
	 * Returns a new object of class '<em>Proxy Service Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Service Policy</em>'.
	 * @generated
	 */
	ProxyServicePolicy createProxyServicePolicy();

	/**
	 * Returns a new object of class '<em>Proxy Service Sequence And Endpoint Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Service Sequence And Endpoint Container</em>'.
	 * @generated
	 */
	ProxyServiceSequenceAndEndpointContainer createProxyServiceSequenceAndEndpointContainer();

	/**
	 * Returns a new object of class '<em>Proxy Service Fault Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Service Fault Container</em>'.
	 * @generated
	 */
	ProxyServiceFaultContainer createProxyServiceFaultContainer();

	/**
	 * Returns a new object of class '<em>Proxy Service Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proxy Service Container</em>'.
	 * @generated
	 */
	ProxyServiceContainer createProxyServiceContainer();

	/**
	 * Returns a new object of class '<em>Mediator Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mediator Flow</em>'.
	 * @generated
	 */
	MediatorFlow createMediatorFlow();

	/**
	 * Returns a new object of class '<em>Endpoint Flow</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Endpoint Flow</em>'.
	 * @generated
	 */
    EndpointFlow createEndpointFlow();

    /**
	 * Returns a new object of class '<em>Message Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Mediator</em>'.
	 * @generated
	 */
	MessageMediator createMessageMediator();

	/**
	 * Returns a new object of class '<em>Message Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Input Connector</em>'.
	 * @generated
	 */
	MessageInputConnector createMessageInputConnector();

	/**
	 * Returns a new object of class '<em>Message Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Output Connector</em>'.
	 * @generated
	 */
	MessageOutputConnector createMessageOutputConnector();

	/**
	 * Returns a new object of class '<em>Default End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default End Point</em>'.
	 * @generated
	 */
	DefaultEndPoint createDefaultEndPoint();

	/**
	 * Returns a new object of class '<em>Default End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default End Point Input Connector</em>'.
	 * @generated
	 */
	DefaultEndPointInputConnector createDefaultEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>Default End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default End Point Output Connector</em>'.
	 * @generated
	 */
	DefaultEndPointOutputConnector createDefaultEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Address End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address End Point</em>'.
	 * @generated
	 */
	AddressEndPoint createAddressEndPoint();

	/**
	 * Returns a new object of class '<em>Address End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address End Point Input Connector</em>'.
	 * @generated
	 */
	AddressEndPointInputConnector createAddressEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>Address End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address End Point Output Connector</em>'.
	 * @generated
	 */
	AddressEndPointOutputConnector createAddressEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Template Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Endpoint</em>'.
	 * @generated
	 */
	TemplateEndpoint createTemplateEndpoint();

	/**
	 * Returns a new object of class '<em>Template Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Endpoint Input Connector</em>'.
	 * @generated
	 */
	TemplateEndpointInputConnector createTemplateEndpointInputConnector();

	/**
	 * Returns a new object of class '<em>Template Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Endpoint Output Connector</em>'.
	 * @generated
	 */
	TemplateEndpointOutputConnector createTemplateEndpointOutputConnector();

	/**
	 * Returns a new object of class '<em>Template Endpoint Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Endpoint Parameter</em>'.
	 * @generated
	 */
	TemplateEndpointParameter createTemplateEndpointParameter();

	/**
	 * Returns a new object of class '<em>HTTP Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HTTP Endpoint</em>'.
	 * @generated
	 */
	HTTPEndpoint createHTTPEndpoint();

	/**
	 * Returns a new object of class '<em>HTTP End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HTTP End Point Input Connector</em>'.
	 * @generated
	 */
	HTTPEndPointInputConnector createHTTPEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>HTTP End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HTTP End Point Output Connector</em>'.
	 * @generated
	 */
	HTTPEndPointOutputConnector createHTTPEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Drop Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drop Mediator</em>'.
	 * @generated
	 */
	DropMediator createDropMediator();

	/**
	 * Returns a new object of class '<em>Drop Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drop Mediator Input Connector</em>'.
	 * @generated
	 */
	DropMediatorInputConnector createDropMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Filter Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Mediator</em>'.
	 * @generated
	 */
	FilterMediator createFilterMediator();

	/**
	 * Returns a new object of class '<em>Filter Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Container</em>'.
	 * @generated
	 */
    FilterContainer createFilterContainer();

    /**
	 * Returns a new object of class '<em>Filter Pass Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Pass Container</em>'.
	 * @generated
	 */
    FilterPassContainer createFilterPassContainer();

    /**
	 * Returns a new object of class '<em>Filter Fail Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Fail Container</em>'.
	 * @generated
	 */
    FilterFailContainer createFilterFailContainer();

    /**
	 * Returns a new object of class '<em>Filter Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Mediator Input Connector</em>'.
	 * @generated
	 */
	FilterMediatorInputConnector createFilterMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Filter Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Mediator Output Connector</em>'.
	 * @generated
	 */
    FilterMediatorOutputConnector createFilterMediatorOutputConnector();

    /**
	 * Returns a new object of class '<em>Filter Mediator Pass Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Mediator Pass Output Connector</em>'.
	 * @generated
	 */
	FilterMediatorPassOutputConnector createFilterMediatorPassOutputConnector();

	/**
	 * Returns a new object of class '<em>Filter Mediator Fail Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Mediator Fail Output Connector</em>'.
	 * @generated
	 */
	FilterMediatorFailOutputConnector createFilterMediatorFailOutputConnector();

	/**
	 * Returns a new object of class '<em>Merge Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Node</em>'.
	 * @generated
	 */
	MergeNode createMergeNode();

	/**
	 * Returns a new object of class '<em>Merge Node First Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Node First Input Connector</em>'.
	 * @generated
	 */
	MergeNodeFirstInputConnector createMergeNodeFirstInputConnector();

	/**
	 * Returns a new object of class '<em>Merge Node Second Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Node Second Input Connector</em>'.
	 * @generated
	 */
	MergeNodeSecondInputConnector createMergeNodeSecondInputConnector();

	/**
	 * Returns a new object of class '<em>Merge Node Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Merge Node Output Connector</em>'.
	 * @generated
	 */
	MergeNodeOutputConnector createMergeNodeOutputConnector();

	/**
	 * Returns a new object of class '<em>Log Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Mediator</em>'.
	 * @generated
	 */
	LogMediator createLogMediator();

	/**
	 * Returns a new object of class '<em>Log Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Mediator Input Connector</em>'.
	 * @generated
	 */
	LogMediatorInputConnector createLogMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Log Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Mediator Output Connector</em>'.
	 * @generated
	 */
	LogMediatorOutputConnector createLogMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Log Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Property</em>'.
	 * @generated
	 */
	LogProperty createLogProperty();

	/**
	 * Returns a new object of class '<em>Publish Event Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publish Event Mediator</em>'.
	 * @generated
	 */
	PublishEventMediator createPublishEventMediator();

	/**
	 * Returns a new object of class '<em>Publish Event Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publish Event Mediator Input Connector</em>'.
	 * @generated
	 */
	PublishEventMediatorInputConnector createPublishEventMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Publish Event Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publish Event Mediator Output Connector</em>'.
	 * @generated
	 */
	PublishEventMediatorOutputConnector createPublishEventMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Publish Event Mediator Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publish Event Mediator Attribute</em>'.
	 * @generated
	 */
	PublishEventMediatorAttribute createPublishEventMediatorAttribute();

	/**
	 * Returns a new object of class '<em>BAM Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BAM Mediator</em>'.
	 * @generated
	 */
	BAMMediator createBAMMediator();

	/**
	 * Returns a new object of class '<em>BAM Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BAM Mediator Input Connector</em>'.
	 * @generated
	 */
	BAMMediatorInputConnector createBAMMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>BAM Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BAM Mediator Output Connector</em>'.
	 * @generated
	 */
	BAMMediatorOutputConnector createBAMMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Bean Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bean Mediator</em>'.
	 * @generated
	 */
	BeanMediator createBeanMediator();

	/**
	 * Returns a new object of class '<em>Bean Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bean Mediator Input Connector</em>'.
	 * @generated
	 */
	BeanMediatorInputConnector createBeanMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Bean Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bean Mediator Output Connector</em>'.
	 * @generated
	 */
	BeanMediatorOutputConnector createBeanMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>EJB Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EJB Mediator</em>'.
	 * @generated
	 */
	EJBMediator createEJBMediator();

	/**
	 * Returns a new object of class '<em>EJB Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EJB Mediator Input Connector</em>'.
	 * @generated
	 */
	EJBMediatorInputConnector createEJBMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>EJB Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EJB Mediator Output Connector</em>'.
	 * @generated
	 */
	EJBMediatorOutputConnector createEJBMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Method Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Argument</em>'.
	 * @generated
	 */
	MethodArgument createMethodArgument();

	/**
	 * Returns a new object of class '<em>Registry Key Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registry Key Property</em>'.
	 * @generated
	 */
	RegistryKeyProperty createRegistryKeyProperty();
	
	
	RegistryKeyProperty copyRegistryKeyProperty(RegistryKeyProperty registryKeyProperty); 

	/**
	 * Returns a new object of class '<em>Property Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Mediator</em>'.
	 * @generated
	 */
	PropertyMediator createPropertyMediator();

	/**
	 * Returns a new object of class '<em>Property Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Mediator Input Connector</em>'.
	 * @generated
	 */
	PropertyMediatorInputConnector createPropertyMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Property Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Mediator Output Connector</em>'.
	 * @generated
	 */
	PropertyMediatorOutputConnector createPropertyMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Namespaced Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * Utility method for creating a copy of the given
	 * {@link EvaluatorExpressionProperty}.
	 * 
	 * @param evaluatorExpressionProperty
	 *            original {@link EvaluatorExpressionProperty} instance.
	 * @return copy of the original {@link EvaluatorExpressionProperty} instance.
	 */
	EvaluatorExpressionProperty copyEvaluatorExpressionProperty(
			EvaluatorExpressionProperty evaluatorExpressionProperty);
			
	/**
	 * Returns a new object of class '<em>Enrich Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enrich Mediator</em>'.
	 * @generated
	 */
	EnrichMediator createEnrichMediator();

	/**
	 * Returns a new object of class '<em>Enrich Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enrich Mediator Input Connector</em>'.
	 * @generated
	 */
	EnrichMediatorInputConnector createEnrichMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Enrich Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enrich Mediator Output Connector</em>'.
	 * @generated
	 */
	EnrichMediatorOutputConnector createEnrichMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>XSLT Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSLT Mediator</em>'.
	 * @generated
	 */
	XSLTMediator createXSLTMediator();

	/**
	 * Returns a new object of class '<em>XSLT Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSLT Property</em>'.
	 * @generated
	 */
	XSLTProperty createXSLTProperty();

	/**
	 * Returns a new object of class '<em>XSLT Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSLT Feature</em>'.
	 * @generated
	 */
	XSLTFeature createXSLTFeature();

	/**
	 * Returns a new object of class '<em>XSLT Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSLT Resource</em>'.
	 * @generated
	 */
	XSLTResource createXSLTResource();

	/**
	 * Returns a new object of class '<em>XSLT Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSLT Mediator Input Connector</em>'.
	 * @generated
	 */
	XSLTMediatorInputConnector createXSLTMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>XSLT Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSLT Mediator Output Connector</em>'.
	 * @generated
	 */
	XSLTMediatorOutputConnector createXSLTMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Switch Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Mediator</em>'.
	 * @generated
	 */
	SwitchMediator createSwitchMediator();

	/**
	 * Returns a new object of class '<em>Switch Case Branch Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case Branch Output Connector</em>'.
	 * @generated
	 */
	SwitchCaseBranchOutputConnector createSwitchCaseBranchOutputConnector();

	/**
	 * Returns a new object of class '<em>Switch Default Branch Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Default Branch Output Connector</em>'.
	 * @generated
	 */
	SwitchDefaultBranchOutputConnector createSwitchDefaultBranchOutputConnector();

	/**
	 * Returns a new object of class '<em>Switch Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Mediator Input Connector</em>'.
	 * @generated
	 */
	SwitchMediatorInputConnector createSwitchMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Switch Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Mediator Output Connector</em>'.
	 * @generated
	 */
	SwitchMediatorOutputConnector createSwitchMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Switch Mediator Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Mediator Container</em>'.
	 * @generated
	 */
	SwitchMediatorContainer createSwitchMediatorContainer();

	/**
	 * Returns a new object of class '<em>Switch Case Parent Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case Parent Container</em>'.
	 * @generated
	 */
	SwitchCaseParentContainer createSwitchCaseParentContainer();

	/**
	 * Returns a new object of class '<em>Switch Default Parent Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Default Parent Container</em>'.
	 * @generated
	 */
	SwitchDefaultParentContainer createSwitchDefaultParentContainer();

	/**
	 * Returns a new object of class '<em>Switch Case Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case Container</em>'.
	 * @generated
	 */
	SwitchCaseContainer createSwitchCaseContainer();

	/**
	 * Returns a new object of class '<em>Switch Default Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Default Container</em>'.
	 * @generated
	 */
	SwitchDefaultContainer createSwitchDefaultContainer();

	/**
	 * Returns a new object of class '<em>Sequence Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Diagram</em>'.
	 * @generated
	 */
	SequenceDiagram createSequenceDiagram();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	EsbSequence createEsbSequence();

	/**
	 * Returns a new object of class '<em>Sequence Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Input</em>'.
	 * @generated
	 */
	EsbSequenceInput createEsbSequenceInput();

	/**
	 * Returns a new object of class '<em>Sequence Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Output</em>'.
	 * @generated
	 */
	EsbSequenceOutput createEsbSequenceOutput();

	/**
	 * Returns a new object of class '<em>Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Input Connector</em>'.
	 * @generated
	 */
	EsbSequenceInputConnector createEsbSequenceInputConnector();

	/**
	 * Returns a new object of class '<em>Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Output Connector</em>'.
	 * @generated
	 */
	EsbSequenceOutputConnector createEsbSequenceOutputConnector();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Input Connector</em>'.
	 * @generated
	 */
	SequenceInputConnector createSequenceInputConnector();

	/**
	 * Returns a new object of class '<em>Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Output Connector</em>'.
	 * @generated
	 */
	SequenceOutputConnector createSequenceOutputConnector();

	/**
	 * Returns a new object of class '<em>Event Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Mediator</em>'.
	 * @generated
	 */
	EventMediator createEventMediator();

	/**
	 * Returns a new object of class '<em>Event Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Mediator Input Connector</em>'.
	 * @generated
	 */
	EventMediatorInputConnector createEventMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Event Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Mediator Output Connector</em>'.
	 * @generated
	 */
	EventMediatorOutputConnector createEventMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator</em>'.
	 * @generated
	 */
	EntitlementMediator createEntitlementMediator();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator Input Connector</em>'.
	 * @generated
	 */
	EntitlementMediatorInputConnector createEntitlementMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator Output Connector</em>'.
	 * @generated
	 */
	EntitlementMediatorOutputConnector createEntitlementMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator On Reject Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator On Reject Output Connector</em>'.
	 * @generated
	 */
	EntitlementMediatorOnRejectOutputConnector createEntitlementMediatorOnRejectOutputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator On Accept Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator On Accept Output Connector</em>'.
	 * @generated
	 */
	EntitlementMediatorOnAcceptOutputConnector createEntitlementMediatorOnAcceptOutputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator Advice Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator Advice Output Connector</em>'.
	 * @generated
	 */
	EntitlementMediatorAdviceOutputConnector createEntitlementMediatorAdviceOutputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator Obligations Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator Obligations Output Connector</em>'.
	 * @generated
	 */
	EntitlementMediatorObligationsOutputConnector createEntitlementMediatorObligationsOutputConnector();

	/**
	 * Returns a new object of class '<em>Entitlement Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Container</em>'.
	 * @generated
	 */
	EntitlementContainer createEntitlementContainer();

	/**
	 * Returns a new object of class '<em>Entitlement On Reject Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement On Reject Container</em>'.
	 * @generated
	 */
	EntitlementOnRejectContainer createEntitlementOnRejectContainer();

	/**
	 * Returns a new object of class '<em>Entitlement On Accept Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement On Accept Container</em>'.
	 * @generated
	 */
	EntitlementOnAcceptContainer createEntitlementOnAcceptContainer();

	/**
	 * Returns a new object of class '<em>Entitlement Advice Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Advice Container</em>'.
	 * @generated
	 */
	EntitlementAdviceContainer createEntitlementAdviceContainer();

	/**
	 * Returns a new object of class '<em>Entitlement Obligations Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Obligations Container</em>'.
	 * @generated
	 */
	EntitlementObligationsContainer createEntitlementObligationsContainer();

	/**
	 * Returns a new object of class '<em>Enqueue Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enqueue Mediator</em>'.
	 * @generated
	 */
	EnqueueMediator createEnqueueMediator();

	/**
	 * Returns a new object of class '<em>Enqueue Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enqueue Mediator Input Connector</em>'.
	 * @generated
	 */
	EnqueueMediatorInputConnector createEnqueueMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Enqueue Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enqueue Mediator Output Connector</em>'.
	 * @generated
	 */
	EnqueueMediatorOutputConnector createEnqueueMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Class Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Mediator</em>'.
	 * @generated
	 */
	ClassMediator createClassMediator();

	/**
	 * Returns a new object of class '<em>Class Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Mediator Input Connector</em>'.
	 * @generated
	 */
	ClassMediatorInputConnector createClassMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Class Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Mediator Output Connector</em>'.
	 * @generated
	 */
	ClassMediatorOutputConnector createClassMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Class Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Property</em>'.
	 * @generated
	 */
	ClassProperty createClassProperty();

	/**
	 * Returns a new object of class '<em>Spring Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spring Mediator</em>'.
	 * @generated
	 */
	SpringMediator createSpringMediator();

	/**
	 * Returns a new object of class '<em>Spring Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spring Mediator Input Connector</em>'.
	 * @generated
	 */
	SpringMediatorInputConnector createSpringMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Spring Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spring Mediator Output Connector</em>'.
	 * @generated
	 */
	SpringMediatorOutputConnector createSpringMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Validate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Mediator</em>'.
	 * @generated
	 */
	ValidateMediator createValidateMediator();

	/**
	 * Returns a new object of class '<em>Validate Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Resource</em>'.
	 * @generated
	 */
	ValidateResource createValidateResource();

	/**
	 * Returns a new object of class '<em>Validate Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Feature</em>'.
	 * @generated
	 */
	ValidateFeature createValidateFeature();

	/**
	 * Returns a new object of class '<em>Validate Schema</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Schema</em>'.
	 * @generated
	 */
	ValidateSchema createValidateSchema();

	/**
	 * Returns a new object of class '<em>Validate Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Mediator Input Connector</em>'.
	 * @generated
	 */
	ValidateMediatorInputConnector createValidateMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Validate Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Mediator Output Connector</em>'.
	 * @generated
	 */
	ValidateMediatorOutputConnector createValidateMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Validate Mediator On Fail Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Mediator On Fail Output Connector</em>'.
	 * @generated
	 */
	ValidateMediatorOnFailOutputConnector createValidateMediatorOnFailOutputConnector();

	/**
	 * Returns a new object of class '<em>Endpoint Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Endpoint Diagram</em>'.
	 * @generated
	 */
	EndpointDiagram createEndpointDiagram();

	/**
	 * Returns a new object of class '<em>Named Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Endpoint</em>'.
	 * @generated
	 */
	NamedEndpoint createNamedEndpoint();

	/**
	 * Returns a new object of class '<em>Named Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Endpoint Input Connector</em>'.
	 * @generated
	 */
	NamedEndpointInputConnector createNamedEndpointInputConnector();

	/**
	 * Returns a new object of class '<em>Named Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Endpoint Output Connector</em>'.
	 * @generated
	 */
	NamedEndpointOutputConnector createNamedEndpointOutputConnector();

	/**
	 * Returns a new object of class '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template</em>'.
	 * @generated
	 */
	Template createTemplate();

	/**
	 * Returns a new object of class '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter</em>'.
	 * @generated
	 */
	TemplateParameter createTemplateParameter();

	/**
	 * Returns a new object of class '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task</em>'.
	 * @generated
	 */
	Task createTask();

	/**
	 * Returns a new object of class '<em>Name Value Type Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Value Type Property</em>'.
	 * @generated
	 */
	NameValueTypeProperty createNameValueTypeProperty();

	/**
	 * Returns a new object of class '<em>Task Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Property</em>'.
	 * @generated
	 */
	TaskProperty createTaskProperty();

	/**
	 * Returns a new object of class '<em>Synapse API</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synapse API</em>'.
	 * @generated
	 */
	SynapseAPI createSynapseAPI();

	/**
	 * Returns a new object of class '<em>API Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource</em>'.
	 * @generated
	 */
	APIResource createAPIResource();

	/**
	 * Returns a new object of class '<em>API Resource Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Input Connector</em>'.
	 * @generated
	 */
	APIResourceInputConnector createAPIResourceInputConnector();

	/**
	 * Returns a new object of class '<em>API Resource Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Output Connector</em>'.
	 * @generated
	 */
	APIResourceOutputConnector createAPIResourceOutputConnector();

	/**
	 * Returns a new object of class '<em>API Resource Out Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Out Sequence Output Connector</em>'.
	 * @generated
	 */
	APIResourceOutSequenceOutputConnector createAPIResourceOutSequenceOutputConnector();

	/**
	 * Returns a new object of class '<em>API Resource In Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource In Sequence Input Connector</em>'.
	 * @generated
	 */
	APIResourceInSequenceInputConnector createAPIResourceInSequenceInputConnector();

	/**
	 * Returns a new object of class '<em>API Resource Fault Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Fault Input Connector</em>'.
	 * @generated
	 */
	APIResourceFaultInputConnector createAPIResourceFaultInputConnector();

	/**
	 * Returns a new object of class '<em>API Resource Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Endpoint</em>'.
	 * @generated
	 */
	APIResourceEndpoint createAPIResourceEndpoint();

	/**
	 * Returns a new object of class '<em>API Resource Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Endpoint Input Connector</em>'.
	 * @generated
	 */
	APIResourceEndpointInputConnector createAPIResourceEndpointInputConnector();

	/**
	 * Returns a new object of class '<em>API Resource Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Resource Endpoint Output Connector</em>'.
	 * @generated
	 */
	APIResourceEndpointOutputConnector createAPIResourceEndpointOutputConnector();

	/**
	 * Returns a new object of class '<em>Complex Endpoints</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Endpoints</em>'.
	 * @generated
	 */
	ComplexEndpoints createComplexEndpoints();

	/**
	 * Returns a new object of class '<em>Complex Endpoints Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Endpoints Output Connector</em>'.
	 * @generated
	 */
	ComplexEndpointsOutputConnector createComplexEndpointsOutputConnector();

	/**
	 * Returns a new object of class '<em>Addressing Endpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addressing Endpoint</em>'.
	 * @generated
	 */
	AddressingEndpoint createAddressingEndpoint();

	/**
	 * Returns a new object of class '<em>Addressing Endpoint Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addressing Endpoint Input Connector</em>'.
	 * @generated
	 */
	AddressingEndpointInputConnector createAddressingEndpointInputConnector();

	/**
	 * Returns a new object of class '<em>Addressing Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Addressing Endpoint Output Connector</em>'.
	 * @generated
	 */
	AddressingEndpointOutputConnector createAddressingEndpointOutputConnector();

	/**
	 * Returns a new object of class '<em>Recipient List End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipient List End Point</em>'.
	 * @generated
	 */
	RecipientListEndPoint createRecipientListEndPoint();

	/**
	 * Returns a new object of class '<em>Recipient List End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipient List End Point Input Connector</em>'.
	 * @generated
	 */
	RecipientListEndPointInputConnector createRecipientListEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>Recipient List End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipient List End Point Output Connector</em>'.
	 * @generated
	 */
	RecipientListEndPointOutputConnector createRecipientListEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Recipient List End Point West Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipient List End Point West Output Connector</em>'.
	 * @generated
	 */
	RecipientListEndPointWestOutputConnector createRecipientListEndPointWestOutputConnector();

	/**
	 * Returns a new object of class '<em>Message Store Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Store Parameter</em>'.
	 * @generated
	 */
	MessageStoreParameter createMessageStoreParameter();

	/**
	 * Returns a new object of class '<em>Message Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Store</em>'.
	 * @generated
	 */
	MessageStore createMessageStore();

	/**
	 * Returns a new object of class '<em>Message Processor Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Processor Parameter</em>'.
	 * @generated
	 */
	MessageProcessorParameter createMessageProcessorParameter();

	/**
	 * Returns a new object of class '<em>Message Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Processor</em>'.
	 * @generated
	 */
	MessageProcessor createMessageProcessor();

	/**
	 * Returns a new object of class '<em>API Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Handler</em>'.
	 * @generated
	 */
	APIHandler createAPIHandler();

	/**
	 * Returns a new object of class '<em>API Handler Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>API Handler Property</em>'.
	 * @generated
	 */
	APIHandlerProperty createAPIHandlerProperty();

	/**
	 * Returns a new object of class '<em>Cloud Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cloud Connector</em>'.
	 * @generated
	 */
	CloudConnector createCloudConnector();

	/**
	 * Returns a new object of class '<em>Cloud Connector Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cloud Connector Input Connector</em>'.
	 * @generated
	 */
	CloudConnectorInputConnector createCloudConnectorInputConnector();

	/**
	 * Returns a new object of class '<em>Cloud Connector Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cloud Connector Output Connector</em>'.
	 * @generated
	 */
	CloudConnectorOutputConnector createCloudConnectorOutputConnector();

	/**
	 * Returns a new object of class '<em>Cloud Connector Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cloud Connector Operation</em>'.
	 * @generated
	 */
	CloudConnectorOperation createCloudConnectorOperation();

	/**
	 * Returns a new object of class '<em>Cloud Connector Operation Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cloud Connector Operation Input Connector</em>'.
	 * @generated
	 */
	CloudConnectorOperationInputConnector createCloudConnectorOperationInputConnector();

	/**
	 * Returns a new object of class '<em>Cloud Connector Operation Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cloud Connector Operation Output Connector</em>'.
	 * @generated
	 */
	CloudConnectorOperationOutputConnector createCloudConnectorOperationOutputConnector();

	/**
	 * Returns a new object of class '<em>Data Mapper Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Mapper Mediator</em>'.
	 * @generated
	 */
	DataMapperMediator createDataMapperMediator();

	/**
	 * Returns a new object of class '<em>Data Mapper Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Mapper Mediator Input Connector</em>'.
	 * @generated
	 */
	DataMapperMediatorInputConnector createDataMapperMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Data Mapper Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Mapper Mediator Output Connector</em>'.
	 * @generated
	 */
	DataMapperMediatorOutputConnector createDataMapperMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Fast XSLT Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fast XSLT Mediator</em>'.
	 * @generated
	 */
	FastXSLTMediator createFastXSLTMediator();

	/**
	 * Returns a new object of class '<em>Fast XSLT Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fast XSLT Mediator Input Connector</em>'.
	 * @generated
	 */
	FastXSLTMediatorInputConnector createFastXSLTMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Fast XSLT Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fast XSLT Mediator Output Connector</em>'.
	 * @generated
	 */
	FastXSLTMediatorOutputConnector createFastXSLTMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Inbound Endpoint</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint</em>'.
	 * @generated
	 */
    InboundEndpoint createInboundEndpoint();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint Parameter</em>'.
	 * @generated
	 */
	InboundEndpointParameter createInboundEndpointParameter();

				/**
	 * Returns a new object of class '<em>Inbound Endpoint Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint Container</em>'.
	 * @generated
	 */
    InboundEndpointContainer createInboundEndpointContainer();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint Sequence Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint Sequence Container</em>'.
	 * @generated
	 */
    InboundEndpointSequenceContainer createInboundEndpointSequenceContainer();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint On Error Sequence Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint On Error Sequence Container</em>'.
	 * @generated
	 */
    InboundEndpointOnErrorSequenceContainer createInboundEndpointOnErrorSequenceContainer();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint Sequence Input Connector</em>'.
	 * @generated
	 */
    InboundEndpointSequenceInputConnector createInboundEndpointSequenceInputConnector();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint Sequence Output Connector</em>'.
	 * @generated
	 */
    InboundEndpointSequenceOutputConnector createInboundEndpointSequenceOutputConnector();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint On Error Sequence Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint On Error Sequence Output Connector</em>'.
	 * @generated
	 */
    InboundEndpointOnErrorSequenceOutputConnector createInboundEndpointOnErrorSequenceOutputConnector();

    /**
	 * Returns a new object of class '<em>Inbound Endpoint On Error Sequence Input Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inbound Endpoint On Error Sequence Input Connector</em>'.
	 * @generated
	 */
    InboundEndpointOnErrorSequenceInputConnector createInboundEndpointOnErrorSequenceInputConnector();

    /**
	 * Returns a new object of class '<em>Comment Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment Mediator</em>'.
	 * @generated
	 */
	CommentMediator createCommentMediator();

				/**
	 * Returns a new object of class '<em>Script Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Mediator</em>'.
	 * @generated
	 */
	ScriptMediator createScriptMediator();

	/**
	 * Returns a new object of class '<em>Script Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Mediator Input Connector</em>'.
	 * @generated
	 */
	ScriptMediatorInputConnector createScriptMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Script Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Mediator Output Connector</em>'.
	 * @generated
	 */
	ScriptMediatorOutputConnector createScriptMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Fault Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Mediator</em>'.
	 * @generated
	 */
	FaultMediator createFaultMediator();

	/**
	 * Returns a new object of class '<em>Fault Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Mediator Input Connector</em>'.
	 * @generated
	 */
	FaultMediatorInputConnector createFaultMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Fault Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Mediator Output Connector</em>'.
	 * @generated
	 */
	FaultMediatorOutputConnector createFaultMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Aggregate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregate Mediator</em>'.
	 * @generated
	 */
	AggregateMediator createAggregateMediator();

	/**
	 * Returns a new object of class '<em>Aggregate Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregate Mediator Input Connector</em>'.
	 * @generated
	 */
	AggregateMediatorInputConnector createAggregateMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Aggregate Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregate Mediator Output Connector</em>'.
	 * @generated
	 */
	AggregateMediatorOutputConnector createAggregateMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Aggregate Mediator On Complete Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregate Mediator On Complete Output Connector</em>'.
	 * @generated
	 */
	AggregateMediatorOnCompleteOutputConnector createAggregateMediatorOnCompleteOutputConnector();

	/**
	 * Returns a new object of class '<em>Router Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Mediator</em>'.
	 * @generated
	 */
	RouterMediator createRouterMediator();

	/**
	 * Returns a new object of class '<em>Router Route</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Route</em>'.
	 * @generated
	 */
	RouterRoute createRouterRoute();

	/**
	 * Returns a new object of class '<em>Router Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Target</em>'.
	 * @generated
	 */
	RouterTarget createRouterTarget();

	/**
	 * Returns a new object of class '<em>Router Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Mediator Input Connector</em>'.
	 * @generated
	 */
	RouterMediatorInputConnector createRouterMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Router Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Mediator Output Connector</em>'.
	 * @generated
	 */
	RouterMediatorOutputConnector createRouterMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Router Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Mediator Target Output Connector</em>'.
	 * @generated
	 */
	RouterMediatorTargetOutputConnector createRouterMediatorTargetOutputConnector();

	/**
	 * Returns a new object of class '<em>Router Mediator Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Mediator Container</em>'.
	 * @generated
	 */
	RouterMediatorContainer createRouterMediatorContainer();

	/**
	 * Returns a new object of class '<em>Router Target Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Router Target Container</em>'.
	 * @generated
	 */
	RouterTargetContainer createRouterTargetContainer();

	/**
	 * Returns a new object of class '<em>Clone Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Mediator</em>'.
	 * @generated
	 */
	CloneMediator createCloneMediator();

	/**
	 * Returns a new object of class '<em>Clone Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Target</em>'.
	 * @generated
	 */
	CloneTarget createCloneTarget();

	/**
	 * Returns a new object of class '<em>Clone Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Mediator Input Connector</em>'.
	 * @generated
	 */
	CloneMediatorInputConnector createCloneMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Clone Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Mediator Output Connector</em>'.
	 * @generated
	 */
	CloneMediatorOutputConnector createCloneMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Clone Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Mediator Target Output Connector</em>'.
	 * @generated
	 */
	CloneMediatorTargetOutputConnector createCloneMediatorTargetOutputConnector();

	/**
	 * Returns a new object of class '<em>Clone Mediator Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Mediator Container</em>'.
	 * @generated
	 */
	CloneMediatorContainer createCloneMediatorContainer();

	/**
	 * Returns a new object of class '<em>Clone Target Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clone Target Container</em>'.
	 * @generated
	 */
	CloneTargetContainer createCloneTargetContainer();

	/**
	 * Returns a new object of class '<em>For Each Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Mediator</em>'.
	 * @generated
	 */
	ForEachMediator createForEachMediator();

	/**
	 * Returns a new object of class '<em>For Each Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Mediator Input Connector</em>'.
	 * @generated
	 */
	ForEachMediatorInputConnector createForEachMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>For Each Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Mediator Output Connector</em>'.
	 * @generated
	 */
	ForEachMediatorOutputConnector createForEachMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>For Each Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Mediator Target Output Connector</em>'.
	 * @generated
	 */
	ForEachMediatorTargetOutputConnector createForEachMediatorTargetOutputConnector();

	/**
	 * Returns a new object of class '<em>For Each Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Target</em>'.
	 * @generated
	 */
	ForEachTarget createForEachTarget();

	/**
	 * Returns a new object of class '<em>Iterate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Mediator</em>'.
	 * @generated
	 */
	IterateMediator createIterateMediator();

	/**
	 * Returns a new object of class '<em>Iterate Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Mediator Input Connector</em>'.
	 * @generated
	 */
	IterateMediatorInputConnector createIterateMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Iterate Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Mediator Output Connector</em>'.
	 * @generated
	 */
	IterateMediatorOutputConnector createIterateMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Iterate Mediator Target Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Mediator Target Output Connector</em>'.
	 * @generated
	 */
	IterateMediatorTargetOutputConnector createIterateMediatorTargetOutputConnector();

	/**
	 * Returns a new object of class '<em>Iterate Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Target</em>'.
	 * @generated
	 */
	IterateTarget createIterateTarget();

	/**
	 * Returns a new object of class '<em>Abstract Common Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Common Target</em>'.
	 * @generated
	 */
	AbstractCommonTarget createAbstractCommonTarget();

	/**
	 * Returns a new object of class '<em>Mediator Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mediator Sequence</em>'.
	 * @generated
	 */
	MediatorSequence createMediatorSequence();

	/**
	 * Returns a new object of class '<em>Cache Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Mediator</em>'.
	 * @generated
	 */
	CacheMediator createCacheMediator();

	/**
	 * Returns a new object of class '<em>Cache Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Mediator Input Connector</em>'.
	 * @generated
	 */
	CacheMediatorInputConnector createCacheMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Cache Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Mediator Output Connector</em>'.
	 * @generated
	 */
	CacheMediatorOutputConnector createCacheMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Cache Mediator On Hit Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Mediator On Hit Output Connector</em>'.
	 * @generated
	 */
	CacheMediatorOnHitOutputConnector createCacheMediatorOnHitOutputConnector();

	/**
	 * Returns a new object of class '<em>Cache On Hit Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache On Hit Branch</em>'.
	 * @generated
	 */
	CacheOnHitBranch createCacheOnHitBranch();

	/**
	 * Returns a new object of class '<em>XQuery Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XQuery Mediator</em>'.
	 * @generated
	 */
	XQueryMediator createXQueryMediator();

	/**
	 * Returns a new object of class '<em>XQuery Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XQuery Mediator Input Connector</em>'.
	 * @generated
	 */
	XQueryMediatorInputConnector createXQueryMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>XQuery Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XQuery Mediator Output Connector</em>'.
	 * @generated
	 */
	XQueryMediatorOutputConnector createXQueryMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>XQuery Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XQuery Variable</em>'.
	 * @generated
	 */
	XQueryVariable createXQueryVariable();

	/**
	 * Returns a new object of class '<em>Callout Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Callout Mediator</em>'.
	 * @generated
	 */
	CalloutMediator createCalloutMediator();

	/**
	 * Returns a new object of class '<em>Callout Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Callout Mediator Input Connector</em>'.
	 * @generated
	 */
	CalloutMediatorInputConnector createCalloutMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Callout Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Callout Mediator Output Connector</em>'.
	 * @generated
	 */
	CalloutMediatorOutputConnector createCalloutMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>RM Sequence Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RM Sequence Mediator</em>'.
	 * @generated
	 */
	RMSequenceMediator createRMSequenceMediator();

	/**
	 * Returns a new object of class '<em>RM Sequence Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RM Sequence Mediator Input Connector</em>'.
	 * @generated
	 */
	RMSequenceMediatorInputConnector createRMSequenceMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>RM Sequence Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RM Sequence Mediator Output Connector</em>'.
	 * @generated
	 */
	RMSequenceMediatorOutputConnector createRMSequenceMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Transaction Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transaction Mediator</em>'.
	 * @generated
	 */
	TransactionMediator createTransactionMediator();

	/**
	 * Returns a new object of class '<em>Transaction Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transaction Mediator Input Connector</em>'.
	 * @generated
	 */
	TransactionMediatorInputConnector createTransactionMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Transaction Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transaction Mediator Output Connector</em>'.
	 * @generated
	 */
	TransactionMediatorOutputConnector createTransactionMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>OAuth Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OAuth Mediator</em>'.
	 * @generated
	 */
	OAuthMediator createOAuthMediator();

	/**
	 * Returns a new object of class '<em>OAuth Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OAuth Mediator Input Connector</em>'.
	 * @generated
	 */
	OAuthMediatorInputConnector createOAuthMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>OAuth Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OAuth Mediator Output Connector</em>'.
	 * @generated
	 */
	OAuthMediatorOutputConnector createOAuthMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Autoscale In Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Autoscale In Mediator</em>'.
	 * @generated
	 */
	AutoscaleInMediator createAutoscaleInMediator();

	/**
	 * Returns a new object of class '<em>Autoscale Out Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Autoscale Out Mediator</em>'.
	 * @generated
	 */
	AutoscaleOutMediator createAutoscaleOutMediator();

	/**
	 * Returns a new object of class '<em>Header Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Header Mediator</em>'.
	 * @generated
	 */
	HeaderMediator createHeaderMediator();

	/**
	 * Returns a new object of class '<em>Header Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Header Mediator Input Connector</em>'.
	 * @generated
	 */
	HeaderMediatorInputConnector createHeaderMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Header Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Header Mediator Output Connector</em>'.
	 * @generated
	 */
	HeaderMediatorOutputConnector createHeaderMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Throttle Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Mediator</em>'.
	 * @generated
	 */
	ThrottleMediator createThrottleMediator();

	/**
	 * Returns a new object of class '<em>Throttle Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Mediator Input Connector</em>'.
	 * @generated
	 */
	ThrottleMediatorInputConnector createThrottleMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Throttle Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Mediator Output Connector</em>'.
	 * @generated
	 */
	ThrottleMediatorOutputConnector createThrottleMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Throttle Mediator On Accept Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Mediator On Accept Output Connector</em>'.
	 * @generated
	 */
    ThrottleMediatorOnAcceptOutputConnector createThrottleMediatorOnAcceptOutputConnector();

    /**
	 * Returns a new object of class '<em>Throttle Mediator On Reject Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Mediator On Reject Output Connector</em>'.
	 * @generated
	 */
    ThrottleMediatorOnRejectOutputConnector createThrottleMediatorOnRejectOutputConnector();

    /**
	 * Returns a new object of class '<em>Throttle Policy Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Policy Configuration</em>'.
	 * @generated
	 */
	ThrottlePolicyConfiguration createThrottlePolicyConfiguration();

	/**
	 * Returns a new object of class '<em>Throttle Policy Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Policy Entry</em>'.
	 * @generated
	 */
	ThrottlePolicyEntry createThrottlePolicyEntry();

	/**
	 * Returns a new object of class '<em>Throttle On Accept Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle On Accept Branch</em>'.
	 * @generated
	 */
	ThrottleOnAcceptBranch createThrottleOnAcceptBranch();

	/**
	 * Returns a new object of class '<em>Throttle On Reject Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle On Reject Branch</em>'.
	 * @generated
	 */
	ThrottleOnRejectBranch createThrottleOnRejectBranch();

	/**
	 * Returns a new object of class '<em>Throttle Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Container</em>'.
	 * @generated
	 */
    ThrottleContainer createThrottleContainer();

    /**
	 * Returns a new object of class '<em>Throttle On Accept Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle On Accept Container</em>'.
	 * @generated
	 */
    ThrottleOnAcceptContainer createThrottleOnAcceptContainer();

    /**
	 * Returns a new object of class '<em>Throttle On Reject Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle On Reject Container</em>'.
	 * @generated
	 */
    ThrottleOnRejectContainer createThrottleOnRejectContainer();

    /**
	 * Returns a new object of class '<em>Command Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Mediator</em>'.
	 * @generated
	 */
	CommandMediator createCommandMediator();

	/**
	 * Returns a new object of class '<em>Command Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Mediator Input Connector</em>'.
	 * @generated
	 */
	CommandMediatorInputConnector createCommandMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Command Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Mediator Output Connector</em>'.
	 * @generated
	 */
	CommandMediatorOutputConnector createCommandMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Command Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Property</em>'.
	 * @generated
	 */
	CommandProperty createCommandProperty();

	/**
	 * Returns a new object of class '<em>Sql Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sql Statement</em>'.
	 * @generated
	 */
	SqlStatement createSqlStatement();

	/**
	 * Returns a new object of class '<em>Sql Parameter Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sql Parameter Definition</em>'.
	 * @generated
	 */
	SqlParameterDefinition createSqlParameterDefinition();

	/**
	 * Returns a new object of class '<em>Sql Result Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sql Result Mapping</em>'.
	 * @generated
	 */
	SqlResultMapping createSqlResultMapping();

	/**
	 * Returns a new object of class '<em>DB Lookup Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Lookup Mediator</em>'.
	 * @generated
	 */
	DBLookupMediator createDBLookupMediator();

	/**
	 * Returns a new object of class '<em>DB Lookup Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Lookup Mediator Input Connector</em>'.
	 * @generated
	 */
	DBLookupMediatorInputConnector createDBLookupMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>DB Lookup Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Lookup Mediator Output Connector</em>'.
	 * @generated
	 */
	DBLookupMediatorOutputConnector createDBLookupMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>DB Report Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Report Mediator</em>'.
	 * @generated
	 */
	DBReportMediator createDBReportMediator();

	/**
	 * Returns a new object of class '<em>DB Report Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Report Mediator Input Connector</em>'.
	 * @generated
	 */
	DBReportMediatorInputConnector createDBReportMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>DB Report Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Report Mediator Output Connector</em>'.
	 * @generated
	 */
	DBReportMediatorOutputConnector createDBReportMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Rule Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Mediator</em>'.
	 * @generated
	 */
	RuleMediator createRuleMediator();

	/**
	 * Returns a new object of class '<em>Rule Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Mediator Input Connector</em>'.
	 * @generated
	 */
	RuleMediatorInputConnector createRuleMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Rule Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Mediator Output Connector</em>'.
	 * @generated
	 */
	RuleMediatorOutputConnector createRuleMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Rule Mediator Child Mediators Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Mediator Child Mediators Output Connector</em>'.
	 * @generated
	 */
	RuleMediatorChildMediatorsOutputConnector createRuleMediatorChildMediatorsOutputConnector();

	/**
	 * Returns a new object of class '<em>Rule Set Creation Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Set Creation Property</em>'.
	 * @generated
	 */
	RuleSetCreationProperty createRuleSetCreationProperty();

	/**
	 * Returns a new object of class '<em>Rule Session Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Session Property</em>'.
	 * @generated
	 */
	RuleSessionProperty createRuleSessionProperty();

	/**
	 * Returns a new object of class '<em>Rule Facts Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Facts Configuration</em>'.
	 * @generated
	 */
	RuleFactsConfiguration createRuleFactsConfiguration();

	/**
	 * Returns a new object of class '<em>Rule Fact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Fact</em>'.
	 * @generated
	 */
	RuleFact createRuleFact();

	/**
	 * Returns a new object of class '<em>Rule Results Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Results Configuration</em>'.
	 * @generated
	 */
	RuleResultsConfiguration createRuleResultsConfiguration();

	/**
	 * Returns a new object of class '<em>Rule Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Result</em>'.
	 * @generated
	 */
	RuleResult createRuleResult();

	/**
	 * Returns a new object of class '<em>Rule Child Mediators Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Child Mediators Configuration</em>'.
	 * @generated
	 */
	RuleChildMediatorsConfiguration createRuleChildMediatorsConfiguration();

	/**
	 * Returns a new object of class '<em>Call Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Template Parameter</em>'.
	 * @generated
	 */
	CallTemplateParameter createCallTemplateParameter();

	/**
	 * Returns a new object of class '<em>Call Template Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Template Mediator</em>'.
	 * @generated
	 */
	CallTemplateMediator createCallTemplateMediator();

	/**
	 * Returns a new object of class '<em>Call Template Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Template Mediator Input Connector</em>'.
	 * @generated
	 */
	CallTemplateMediatorInputConnector createCallTemplateMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Call Template Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Template Mediator Output Connector</em>'.
	 * @generated
	 */
	CallTemplateMediatorOutputConnector createCallTemplateMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Loop Back Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Back Mediator</em>'.
	 * @generated
	 */
	LoopBackMediator createLoopBackMediator();

	/**
	 * Returns a new object of class '<em>Loop Back Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Back Mediator Input Connector</em>'.
	 * @generated
	 */
	LoopBackMediatorInputConnector createLoopBackMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Loop Back Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Back Mediator Output Connector</em>'.
	 * @generated
	 */
	LoopBackMediatorOutputConnector createLoopBackMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Respond Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Respond Mediator</em>'.
	 * @generated
	 */
	RespondMediator createRespondMediator();

	/**
	 * Returns a new object of class '<em>Respond Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Respond Mediator Input Connector</em>'.
	 * @generated
	 */
	RespondMediatorInputConnector createRespondMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Respond Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Respond Mediator Output Connector</em>'.
	 * @generated
	 */
	RespondMediatorOutputConnector createRespondMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Smooks Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smooks Mediator</em>'.
	 * @generated
	 */
	SmooksMediator createSmooksMediator();

	/**
	 * Returns a new object of class '<em>Smooks Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smooks Mediator Input Connector</em>'.
	 * @generated
	 */
	SmooksMediatorInputConnector createSmooksMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Smooks Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smooks Mediator Output Connector</em>'.
	 * @generated
	 */
	SmooksMediatorOutputConnector createSmooksMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Store Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store Mediator</em>'.
	 * @generated
	 */
	StoreMediator createStoreMediator();

	/**
	 * Returns a new object of class '<em>Store Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store Mediator Input Connector</em>'.
	 * @generated
	 */
	StoreMediatorInputConnector createStoreMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Store Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store Mediator Output Connector</em>'.
	 * @generated
	 */
	StoreMediatorOutputConnector createStoreMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Builder Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builder Mediator</em>'.
	 * @generated
	 */
	BuilderMediator createBuilderMediator();

	/**
	 * Returns a new object of class '<em>Builder Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builder Mediator Input Connector</em>'.
	 * @generated
	 */
	BuilderMediatorInputConnector createBuilderMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Builder Mediator Output Conector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builder Mediator Output Conector</em>'.
	 * @generated
	 */
	BuilderMediatorOutputConector createBuilderMediatorOutputConector();

	/**
	 * Returns a new object of class '<em>Message Builder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Builder</em>'.
	 * @generated
	 */
	MessageBuilder createMessageBuilder();

	/**
	 * Returns a new object of class '<em>Payload Factory Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payload Factory Mediator</em>'.
	 * @generated
	 */
	PayloadFactoryMediator createPayloadFactoryMediator();

	/**
	 * Returns a new object of class '<em>Payload Factory Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payload Factory Mediator Input Connector</em>'.
	 * @generated
	 */
	PayloadFactoryMediatorInputConnector createPayloadFactoryMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Payload Factory Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payload Factory Mediator Output Connector</em>'.
	 * @generated
	 */
	PayloadFactoryMediatorOutputConnector createPayloadFactoryMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Payload Factory Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payload Factory Argument</em>'.
	 * @generated
	 */
	PayloadFactoryArgument createPayloadFactoryArgument();

	/**
	 * Returns a new object of class '<em>Conditional Route Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Route Branch</em>'.
	 * @generated
	 */
	ConditionalRouteBranch createConditionalRouteBranch();

	/**
	 * Returns a new object of class '<em>Conditional Router Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Router Mediator</em>'.
	 * @generated
	 */
	ConditionalRouterMediator createConditionalRouterMediator();

	/**
	 * Returns a new object of class '<em>Conditional Router Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Router Mediator Input Connector</em>'.
	 * @generated
	 */
	ConditionalRouterMediatorInputConnector createConditionalRouterMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Conditional Router Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Router Mediator Output Connector</em>'.
	 * @generated
	 */
	ConditionalRouterMediatorOutputConnector createConditionalRouterMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Conditional Router Mediator Additional Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Router Mediator Additional Output Connector</em>'.
	 * @generated
	 */
	ConditionalRouterMediatorAdditionalOutputConnector createConditionalRouterMediatorAdditionalOutputConnector();

	/**
	 * Returns a new object of class '<em>Send Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Mediator</em>'.
	 * @generated
	 */
	SendMediator createSendMediator();

	/**
	 * Returns a new object of class '<em>Send Container</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Container</em>'.
	 * @generated
	 */
    SendContainer createSendContainer();

    /**
	 * Returns a new object of class '<em>Send Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Mediator Input Connector</em>'.
	 * @generated
	 */
	SendMediatorInputConnector createSendMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>Send Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Mediator Output Connector</em>'.
	 * @generated
	 */
	SendMediatorOutputConnector createSendMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Send Mediator Endpoint Output Connector</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Mediator Endpoint Output Connector</em>'.
	 * @generated
	 */
    SendMediatorEndpointOutputConnector createSendMediatorEndpointOutputConnector();

    /**
	 * Returns a new object of class '<em>Failover End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failover End Point</em>'.
	 * @generated
	 */
	FailoverEndPoint createFailoverEndPoint();

	/**
	 * Returns a new object of class '<em>Failover End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failover End Point Input Connector</em>'.
	 * @generated
	 */
	FailoverEndPointInputConnector createFailoverEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>Failover End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failover End Point Output Connector</em>'.
	 * @generated
	 */
	FailoverEndPointOutputConnector createFailoverEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Failover End Point West Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failover End Point West Output Connector</em>'.
	 * @generated
	 */
	FailoverEndPointWestOutputConnector createFailoverEndPointWestOutputConnector();

	/**
	 * Returns a new object of class '<em>Parent End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parent End Point</em>'.
	 * @generated
	 */
	ParentEndPoint createParentEndPoint();

	/**
	 * Returns a new object of class '<em>WSDL End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WSDL End Point</em>'.
	 * @generated
	 */
	WSDLEndPoint createWSDLEndPoint();

	/**
	 * Returns a new object of class '<em>WSDL End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WSDL End Point Input Connector</em>'.
	 * @generated
	 */
	WSDLEndPointInputConnector createWSDLEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>WSDL End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>WSDL End Point Output Connector</em>'.
	 * @generated
	 */
	WSDLEndPointOutputConnector createWSDLEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Load Balance End Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Balance End Point</em>'.
	 * @generated
	 */
	LoadBalanceEndPoint createLoadBalanceEndPoint();

	/**
	 * Returns a new object of class '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member</em>'.
	 * @generated
	 */
	Member createMember();

	/**
	 * Returns a new object of class '<em>Load Balance End Point Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Balance End Point Input Connector</em>'.
	 * @generated
	 */
	LoadBalanceEndPointInputConnector createLoadBalanceEndPointInputConnector();

	/**
	 * Returns a new object of class '<em>Load Balance End Point Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Balance End Point Output Connector</em>'.
	 * @generated
	 */
	LoadBalanceEndPointOutputConnector createLoadBalanceEndPointOutputConnector();

	/**
	 * Returns a new object of class '<em>Load Balance End Point West Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Balance End Point West Output Connector</em>'.
	 * @generated
	 */
	LoadBalanceEndPointWestOutputConnector createLoadBalanceEndPointWestOutputConnector();

	/**
	 * Returns a new object of class '<em>Local Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Entry</em>'.
	 * @generated
	 */
	LocalEntry createLocalEntry();

	/**
	 * Returns a new object of class '<em>Session</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Session</em>'.
	 * @generated
	 */
	Session createSession();

	/**
	 * Returns a new object of class '<em>Sequences</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequences</em>'.
	 * @generated
	 */
	Sequences createSequences();

	/**
	 * Returns a new object of class '<em>Sequences Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequences Output Connector</em>'.
	 * @generated
	 */
	SequencesOutputConnector createSequencesOutputConnector();

	/**
	 * Returns a new object of class '<em>Sequences Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequences Input Connector</em>'.
	 * @generated
	 */
	SequencesInputConnector createSequencesInputConnector();

	/**
	 * Returns a new object of class '<em>URL Rewrite Rule Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Rewrite Rule Action</em>'.
	 * @generated
	 */
	URLRewriteRuleAction createURLRewriteRuleAction();

	/**
	 * Returns a new object of class '<em>URL Rewrite Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Rewrite Rule</em>'.
	 * @generated
	 */
	URLRewriteRule createURLRewriteRule();

	/**
	 * Returns a new object of class '<em>URL Rewrite Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Rewrite Mediator</em>'.
	 * @generated
	 */
	URLRewriteMediator createURLRewriteMediator();

	/**
	 * Returns a new object of class '<em>URL Rewrite Mediator Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Rewrite Mediator Input Connector</em>'.
	 * @generated
	 */
	URLRewriteMediatorInputConnector createURLRewriteMediatorInputConnector();

	/**
	 * Returns a new object of class '<em>URL Rewrite Mediator Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>URL Rewrite Mediator Output Connector</em>'.
	 * @generated
	 */
	URLRewriteMediatorOutputConnector createURLRewriteMediatorOutputConnector();

	/**
	 * Returns a new object of class '<em>Evaluator Expression Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Evaluator Expression Property</em>'.
	 * @generated
	 */
	EvaluatorExpressionProperty createEvaluatorExpressionProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EsbPackage getEsbPackage();

} //EsbFactory
