/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory;

/**
 * 
 * 
 */
public class EsbEEFAdapterFactory extends EsbAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEsbDiagramAdapter()
	 * 
	 */
	public Adapter createEsbDiagramAdapter() {
		return new EsbDiagramPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEsbServerAdapter()
	 * 
	 */
	public Adapter createEsbServerAdapter() {
		return new EsbServerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEsbLinkAdapter()
	 * 
	 */
	public Adapter createEsbLinkAdapter() {
		return new EsbLinkPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallMediatorAdapter()
	 * 
	 */
	public Adapter createCallMediatorAdapter() {
		return new CallMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCallMediatorInputConnectorAdapter() {
		return new CallMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCallMediatorOutputConnectorAdapter() {
		return new CallMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallMediatorEndpointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCallMediatorEndpointOutputConnectorAdapter() {
		return new CallMediatorEndpointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEndPointPropertyAdapter()
	 * 
	 */
	public Adapter createEndPointPropertyAdapter() {
		return new EndPointPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyServiceAdapter()
	 * 
	 */
	public Adapter createProxyServiceAdapter() {
		return new ProxyServicePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyOutputConnectorAdapter()
	 * 
	 */
	public Adapter createProxyOutputConnectorAdapter() {
		return new ProxyOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyInputConnectorAdapter()
	 * 
	 */
	public Adapter createProxyInputConnectorAdapter() {
		return new ProxyInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyOutSequenceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createProxyOutSequenceOutputConnectorAdapter() {
		return new ProxyOutSequenceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyInSequenceInputConnectorAdapter()
	 * 
	 */
	public Adapter createProxyInSequenceInputConnectorAdapter() {
		return new ProxyInSequenceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyWSDLResourceAdapter()
	 * 
	 */
	public Adapter createProxyWSDLResourceAdapter() {
		return new ProxyWSDLResourcePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyFaultInputConnectorAdapter()
	 * 
	 */
	public Adapter createProxyFaultInputConnectorAdapter() {
		return new ProxyFaultInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyServiceParameterAdapter()
	 * 
	 */
	public Adapter createProxyServiceParameterAdapter() {
		return new ProxyServiceParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createProxyServicePolicyAdapter()
	 * 
	 */
	public Adapter createProxyServicePolicyAdapter() {
		return new ProxyServicePolicyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMediatorFlowAdapter()
	 * 
	 */
	public Adapter createMediatorFlowAdapter() {
		return new MediatorFlowPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEndpointFlowAdapter()
	 * 
	 */
	public Adapter createEndpointFlowAdapter() {
		return new EndpointFlowPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageMediatorAdapter()
	 * 
	 */
	public Adapter createMessageMediatorAdapter() {
		return new MessageMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageInputConnectorAdapter()
	 * 
	 */
	public Adapter createMessageInputConnectorAdapter() {
		return new MessageInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageOutputConnectorAdapter()
	 * 
	 */
	public Adapter createMessageOutputConnectorAdapter() {
		return new MessageOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDefaultEndPointAdapter()
	 * 
	 */
	public Adapter createDefaultEndPointAdapter() {
		return new DefaultEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDefaultEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createDefaultEndPointInputConnectorAdapter() {
		return new DefaultEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDefaultEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createDefaultEndPointOutputConnectorAdapter() {
		return new DefaultEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAddressEndPointAdapter()
	 * 
	 */
	public Adapter createAddressEndPointAdapter() {
		return new AddressEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAddressEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createAddressEndPointInputConnectorAdapter() {
		return new AddressEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAddressEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAddressEndPointOutputConnectorAdapter() {
		return new AddressEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTemplateEndpointAdapter()
	 * 
	 */
	public Adapter createTemplateEndpointAdapter() {
		return new TemplateEndpointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTemplateEndpointInputConnectorAdapter()
	 * 
	 */
	public Adapter createTemplateEndpointInputConnectorAdapter() {
		return new TemplateEndpointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTemplateEndpointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createTemplateEndpointOutputConnectorAdapter() {
		return new TemplateEndpointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTemplateEndpointParameterAdapter()
	 * 
	 */
	public Adapter createTemplateEndpointParameterAdapter() {
		return new TemplateEndpointParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createHTTPEndpointAdapter()
	 * 
	 */
	public Adapter createHTTPEndpointAdapter() {
		return new HTTPEndpointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createHTTPEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createHTTPEndPointInputConnectorAdapter() {
		return new HTTPEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createHTTPEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createHTTPEndPointOutputConnectorAdapter() {
		return new HTTPEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDropMediatorAdapter()
	 * 
	 */
	public Adapter createDropMediatorAdapter() {
		return new DropMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDropMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createDropMediatorInputConnectorAdapter() {
		return new DropMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFilterMediatorAdapter()
	 * 
	 */
	public Adapter createFilterMediatorAdapter() {
		return new FilterMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFilterMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createFilterMediatorInputConnectorAdapter() {
		return new FilterMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFilterMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFilterMediatorOutputConnectorAdapter() {
		return new FilterMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFilterMediatorPassOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFilterMediatorPassOutputConnectorAdapter() {
		return new FilterMediatorPassOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFilterMediatorFailOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFilterMediatorFailOutputConnectorAdapter() {
		return new FilterMediatorFailOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMergeNodeAdapter()
	 * 
	 */
	public Adapter createMergeNodeAdapter() {
		return new MergeNodePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMergeNodeFirstInputConnectorAdapter()
	 * 
	 */
	public Adapter createMergeNodeFirstInputConnectorAdapter() {
		return new MergeNodeFirstInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMergeNodeSecondInputConnectorAdapter()
	 * 
	 */
	public Adapter createMergeNodeSecondInputConnectorAdapter() {
		return new MergeNodeSecondInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMergeNodeOutputConnectorAdapter()
	 * 
	 */
	public Adapter createMergeNodeOutputConnectorAdapter() {
		return new MergeNodeOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLogMediatorAdapter()
	 * 
	 */
	public Adapter createLogMediatorAdapter() {
		return new LogMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLogMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createLogMediatorInputConnectorAdapter() {
		return new LogMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLogMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createLogMediatorOutputConnectorAdapter() {
		return new LogMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLogPropertyAdapter()
	 * 
	 */
	public Adapter createLogPropertyAdapter() {
		return new LogPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPublishEventMediatorAdapter()
	 * 
	 */
	public Adapter createPublishEventMediatorAdapter() {
		return new PublishEventMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPublishEventMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createPublishEventMediatorInputConnectorAdapter() {
		return new PublishEventMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPublishEventMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createPublishEventMediatorOutputConnectorAdapter() {
		return new PublishEventMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPublishEventMediatorAttributeAdapter()
	 * 
	 */
	public Adapter createPublishEventMediatorAttributeAdapter() {
		return new PublishEventMediatorAttributePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBAMMediatorAdapter()
	 * 
	 */
	public Adapter createBAMMediatorAdapter() {
		return new BAMMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBAMMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createBAMMediatorInputConnectorAdapter() {
		return new BAMMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBAMMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createBAMMediatorOutputConnectorAdapter() {
		return new BAMMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBeanMediatorAdapter()
	 * 
	 */
	public Adapter createBeanMediatorAdapter() {
		return new BeanMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBeanMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createBeanMediatorInputConnectorAdapter() {
		return new BeanMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBeanMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createBeanMediatorOutputConnectorAdapter() {
		return new BeanMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEJBMediatorAdapter()
	 * 
	 */
	public Adapter createEJBMediatorAdapter() {
		return new EJBMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEJBMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createEJBMediatorInputConnectorAdapter() {
		return new EJBMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEJBMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEJBMediatorOutputConnectorAdapter() {
		return new EJBMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMethodArgumentAdapter()
	 * 
	 */
	public Adapter createMethodArgumentAdapter() {
		return new MethodArgumentPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRegistryKeyPropertyAdapter()
	 * 
	 */
	public Adapter createRegistryKeyPropertyAdapter() {
		return new RegistryKeyPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPropertyMediatorAdapter()
	 * 
	 */
	public Adapter createPropertyMediatorAdapter() {
		return new PropertyMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPropertyMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createPropertyMediatorInputConnectorAdapter() {
		return new PropertyMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPropertyMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createPropertyMediatorOutputConnectorAdapter() {
		return new PropertyMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPropertyGroupMediatorAdapter()
	 * 
	 */
	public Adapter createPropertyGroupMediatorAdapter() {
		return new PropertyGroupMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPropertyGroupMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createPropertyGroupMediatorInputConnectorAdapter() {
		return new PropertyGroupMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createNamespacedPropertyAdapter()
	 * 
	 */
	public Adapter createNamespacedPropertyAdapter() {
		return new NamespacedPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEnrichMediatorAdapter()
	 * 
	 */
	public Adapter createEnrichMediatorAdapter() {
		return new EnrichMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEnrichMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createEnrichMediatorInputConnectorAdapter() {
		return new EnrichMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEnrichMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEnrichMediatorOutputConnectorAdapter() {
		return new EnrichMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXSLTMediatorAdapter()
	 * 
	 */
	public Adapter createXSLTMediatorAdapter() {
		return new XSLTMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXSLTPropertyAdapter()
	 * 
	 */
	public Adapter createXSLTPropertyAdapter() {
		return new XSLTPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXSLTFeatureAdapter()
	 * 
	 */
	public Adapter createXSLTFeatureAdapter() {
		return new XSLTFeaturePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXSLTResourceAdapter()
	 * 
	 */
	public Adapter createXSLTResourceAdapter() {
		return new XSLTResourcePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXSLTMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createXSLTMediatorInputConnectorAdapter() {
		return new XSLTMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXSLTMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createXSLTMediatorOutputConnectorAdapter() {
		return new XSLTMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSwitchMediatorAdapter()
	 * 
	 */
	public Adapter createSwitchMediatorAdapter() {
		return new SwitchMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSwitchCaseBranchOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSwitchCaseBranchOutputConnectorAdapter() {
		return new SwitchCaseBranchOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSwitchDefaultBranchOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSwitchDefaultBranchOutputConnectorAdapter() {
		return new SwitchDefaultBranchOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSwitchMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createSwitchMediatorInputConnectorAdapter() {
		return new SwitchMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSwitchMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSwitchMediatorOutputConnectorAdapter() {
		return new SwitchMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSwitchCaseParentContainerAdapter()
	 * 
	 */
	public Adapter createSwitchCaseParentContainerAdapter() {
		return new SwitchCaseParentContainerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEsbSequenceAdapter()
	 * 
	 */
	public Adapter createEsbSequenceAdapter() {
		return new EsbSequencePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEsbSequenceInputConnectorAdapter()
	 * 
	 */
	public Adapter createEsbSequenceInputConnectorAdapter() {
		return new EsbSequenceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEsbSequenceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEsbSequenceOutputConnectorAdapter() {
		return new EsbSequenceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSequenceAdapter()
	 * 
	 */
	public Adapter createSequenceAdapter() {
		return new SequencePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSequenceInputConnectorAdapter()
	 * 
	 */
	public Adapter createSequenceInputConnectorAdapter() {
		return new SequenceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSequenceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSequenceOutputConnectorAdapter() {
		return new SequenceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEventMediatorAdapter()
	 * 
	 */
	public Adapter createEventMediatorAdapter() {
		return new EventMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEventMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createEventMediatorInputConnectorAdapter() {
		return new EventMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEventMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEventMediatorOutputConnectorAdapter() {
		return new EventMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorAdapter() {
		return new EntitlementMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorInputConnectorAdapter() {
		return new EntitlementMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorOutputConnectorAdapter() {
		return new EntitlementMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorOnRejectOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorOnRejectOutputConnectorAdapter() {
		return new EntitlementMediatorOnRejectOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorOnAcceptOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorOnAcceptOutputConnectorAdapter() {
		return new EntitlementMediatorOnAcceptOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorAdviceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorAdviceOutputConnectorAdapter() {
		return new EntitlementMediatorAdviceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEntitlementMediatorObligationsOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEntitlementMediatorObligationsOutputConnectorAdapter() {
		return new EntitlementMediatorObligationsOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEnqueueMediatorAdapter()
	 * 
	 */
	public Adapter createEnqueueMediatorAdapter() {
		return new EnqueueMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEnqueueMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createEnqueueMediatorInputConnectorAdapter() {
		return new EnqueueMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEnqueueMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createEnqueueMediatorOutputConnectorAdapter() {
		return new EnqueueMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createClassMediatorAdapter()
	 * 
	 */
	public Adapter createClassMediatorAdapter() {
		return new ClassMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createClassMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createClassMediatorInputConnectorAdapter() {
		return new ClassMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createClassMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createClassMediatorOutputConnectorAdapter() {
		return new ClassMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createClassPropertyAdapter()
	 * 
	 */
	public Adapter createClassPropertyAdapter() {
		return new ClassPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSpringMediatorAdapter()
	 * 
	 */
	public Adapter createSpringMediatorAdapter() {
		return new SpringMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSpringMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createSpringMediatorInputConnectorAdapter() {
		return new SpringMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSpringMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSpringMediatorOutputConnectorAdapter() {
		return new SpringMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createScriptMediatorAdapter()
	 * 
	 */
	public Adapter createScriptMediatorAdapter() {
		return new ScriptMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createScriptMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createScriptMediatorInputConnectorAdapter() {
		return new ScriptMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createScriptMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createScriptMediatorOutputConnectorAdapter() {
		return new ScriptMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFaultMediatorAdapter()
	 * 
	 */
	public Adapter createFaultMediatorAdapter() {
		return new FaultMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFaultMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createFaultMediatorInputConnectorAdapter() {
		return new FaultMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFaultMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFaultMediatorOutputConnectorAdapter() {
		return new FaultMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAggregateMediatorAdapter()
	 * 
	 */
	public Adapter createAggregateMediatorAdapter() {
		return new AggregateMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAggregateMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createAggregateMediatorInputConnectorAdapter() {
		return new AggregateMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAggregateMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAggregateMediatorOutputConnectorAdapter() {
		return new AggregateMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAggregateMediatorOnCompleteOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAggregateMediatorOnCompleteOutputConnectorAdapter() {
		return new AggregateMediatorOnCompleteOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterMediatorAdapter()
	 * 
	 */
	public Adapter createRouterMediatorAdapter() {
		return new RouterMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterRouteAdapter()
	 * 
	 */
	public Adapter createRouterRouteAdapter() {
		return new RouterRoutePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAbstractCommonTargetAdapter()
	 * 
	 */
	public Adapter createAbstractCommonTargetAdapter() {
		return new AbstractCommonTargetPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterTargetAdapter()
	 * 
	 */
	public Adapter createRouterTargetAdapter() {
		return new RouterTargetPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createRouterMediatorInputConnectorAdapter() {
		return new RouterMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRouterMediatorOutputConnectorAdapter() {
		return new RouterMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterMediatorTargetOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRouterMediatorTargetOutputConnectorAdapter() {
		return new RouterMediatorTargetOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterMediatorContainerAdapter()
	 * 
	 */
	public Adapter createRouterMediatorContainerAdapter() {
		return new RouterMediatorContainerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRouterTargetContainerAdapter()
	 * 
	 */
	public Adapter createRouterTargetContainerAdapter() {
		return new RouterTargetContainerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloneMediatorAdapter()
	 * 
	 */
	public Adapter createCloneMediatorAdapter() {
		return new CloneMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloneTargetAdapter()
	 * 
	 */
	public Adapter createCloneTargetAdapter() {
		return new CloneTargetPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloneMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCloneMediatorInputConnectorAdapter() {
		return new CloneMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloneMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCloneMediatorOutputConnectorAdapter() {
		return new CloneMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloneMediatorTargetOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCloneMediatorTargetOutputConnectorAdapter() {
		return new CloneMediatorTargetOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloneMediatorContainerAdapter()
	 * 
	 */
	public Adapter createCloneMediatorContainerAdapter() {
		return new CloneMediatorContainerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createForEachMediatorAdapter()
	 * 
	 */
	public Adapter createForEachMediatorAdapter() {
		return new ForEachMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createForEachMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createForEachMediatorInputConnectorAdapter() {
		return new ForEachMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createForEachMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createForEachMediatorOutputConnectorAdapter() {
		return new ForEachMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createForEachMediatorTargetOutputConnectorAdapter()
	 * 
	 */
	public Adapter createForEachMediatorTargetOutputConnectorAdapter() {
		return new ForEachMediatorTargetOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createForEachTargetAdapter()
	 * 
	 */
	public Adapter createForEachTargetAdapter() {
		return new ForEachTargetPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createIterateMediatorAdapter()
	 * 
	 */
	public Adapter createIterateMediatorAdapter() {
		return new IterateMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createIterateMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createIterateMediatorInputConnectorAdapter() {
		return new IterateMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createIterateMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createIterateMediatorOutputConnectorAdapter() {
		return new IterateMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createIterateMediatorTargetOutputConnectorAdapter()
	 * 
	 */
	public Adapter createIterateMediatorTargetOutputConnectorAdapter() {
		return new IterateMediatorTargetOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createIterateTargetAdapter()
	 * 
	 */
	public Adapter createIterateTargetAdapter() {
		return new IterateTargetPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMediatorSequenceAdapter()
	 * 
	 */
	public Adapter createMediatorSequenceAdapter() {
		return new MediatorSequencePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCacheMediatorAdapter()
	 * 
	 */
	public Adapter createCacheMediatorAdapter() {
		return new CacheMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCacheMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCacheMediatorInputConnectorAdapter() {
		return new CacheMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCacheMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCacheMediatorOutputConnectorAdapter() {
		return new CacheMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCacheMediatorOnHitOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCacheMediatorOnHitOutputConnectorAdapter() {
		return new CacheMediatorOnHitOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXQueryMediatorAdapter()
	 * 
	 */
	public Adapter createXQueryMediatorAdapter() {
		return new XQueryMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXQueryMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createXQueryMediatorInputConnectorAdapter() {
		return new XQueryMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXQueryMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createXQueryMediatorOutputConnectorAdapter() {
		return new XQueryMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createXQueryVariableAdapter()
	 * 
	 */
	public Adapter createXQueryVariableAdapter() {
		return new XQueryVariablePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCalloutMediatorAdapter()
	 * 
	 */
	public Adapter createCalloutMediatorAdapter() {
		return new CalloutMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCalloutMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCalloutMediatorInputConnectorAdapter() {
		return new CalloutMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCalloutMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCalloutMediatorOutputConnectorAdapter() {
		return new CalloutMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRMSequenceMediatorAdapter()
	 * 
	 */
	public Adapter createRMSequenceMediatorAdapter() {
		return new RMSequenceMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRMSequenceMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createRMSequenceMediatorInputConnectorAdapter() {
		return new RMSequenceMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRMSequenceMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRMSequenceMediatorOutputConnectorAdapter() {
		return new RMSequenceMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTransactionMediatorAdapter()
	 * 
	 */
	public Adapter createTransactionMediatorAdapter() {
		return new TransactionMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTransactionMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createTransactionMediatorInputConnectorAdapter() {
		return new TransactionMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTransactionMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createTransactionMediatorOutputConnectorAdapter() {
		return new TransactionMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createOAuthMediatorAdapter()
	 * 
	 */
	public Adapter createOAuthMediatorAdapter() {
		return new OAuthMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createOAuthMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createOAuthMediatorInputConnectorAdapter() {
		return new OAuthMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createOAuthMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createOAuthMediatorOutputConnectorAdapter() {
		return new OAuthMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAutoscaleInMediatorAdapter()
	 * 
	 */
	public Adapter createAutoscaleInMediatorAdapter() {
		return new AutoscaleInMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAutoscaleOutMediatorAdapter()
	 * 
	 */
	public Adapter createAutoscaleOutMediatorAdapter() {
		return new AutoscaleOutMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createHeaderMediatorAdapter()
	 * 
	 */
	public Adapter createHeaderMediatorAdapter() {
		return new HeaderMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createHeaderMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createHeaderMediatorInputConnectorAdapter() {
		return new HeaderMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createHeaderMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createHeaderMediatorOutputConnectorAdapter() {
		return new HeaderMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleMediatorAdapter()
	 * 
	 */
	public Adapter createThrottleMediatorAdapter() {
		return new ThrottleMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createThrottleMediatorInputConnectorAdapter() {
		return new ThrottleMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createThrottleMediatorOutputConnectorAdapter() {
		return new ThrottleMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleMediatorOnAcceptOutputConnectorAdapter()
	 * 
	 */
	public Adapter createThrottleMediatorOnAcceptOutputConnectorAdapter() {
		return new ThrottleMediatorOnAcceptOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleMediatorOnRejectOutputConnectorAdapter()
	 * 
	 */
	public Adapter createThrottleMediatorOnRejectOutputConnectorAdapter() {
		return new ThrottleMediatorOnRejectOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottlePolicyConfigurationAdapter()
	 * 
	 */
	public Adapter createThrottlePolicyConfigurationAdapter() {
		return new ThrottlePolicyConfigurationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottlePolicyEntryAdapter()
	 * 
	 */
	public Adapter createThrottlePolicyEntryAdapter() {
		return new ThrottlePolicyEntryPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleOnAcceptBranchAdapter()
	 * 
	 */
	public Adapter createThrottleOnAcceptBranchAdapter() {
		return new ThrottleOnAcceptBranchPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createThrottleOnRejectBranchAdapter()
	 * 
	 */
	public Adapter createThrottleOnRejectBranchAdapter() {
		return new ThrottleOnRejectBranchPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCommandMediatorAdapter()
	 * 
	 */
	public Adapter createCommandMediatorAdapter() {
		return new CommandMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCommandMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCommandMediatorInputConnectorAdapter() {
		return new CommandMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCommandMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCommandMediatorOutputConnectorAdapter() {
		return new CommandMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCommandPropertyAdapter()
	 * 
	 */
	public Adapter createCommandPropertyAdapter() {
		return new CommandPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSqlStatementAdapter()
	 * 
	 */
	public Adapter createSqlStatementAdapter() {
		return new SqlStatementPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSqlParameterDefinitionAdapter()
	 * 
	 */
	public Adapter createSqlParameterDefinitionAdapter() {
		return new SqlParameterDefinitionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSqlResultMappingAdapter()
	 * 
	 */
	public Adapter createSqlResultMappingAdapter() {
		return new SqlResultMappingPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDBLookupMediatorAdapter()
	 * 
	 */
	public Adapter createDBLookupMediatorAdapter() {
		return new DBLookupMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDBLookupMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createDBLookupMediatorInputConnectorAdapter() {
		return new DBLookupMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDBLookupMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createDBLookupMediatorOutputConnectorAdapter() {
		return new DBLookupMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDBReportMediatorAdapter()
	 * 
	 */
	public Adapter createDBReportMediatorAdapter() {
		return new DBReportMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDBReportMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createDBReportMediatorInputConnectorAdapter() {
		return new DBReportMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDBReportMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createDBReportMediatorOutputConnectorAdapter() {
		return new DBReportMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleMediatorAdapter()
	 * 
	 */
	public Adapter createRuleMediatorAdapter() {
		return new RuleMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createRuleMediatorInputConnectorAdapter() {
		return new RuleMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRuleMediatorOutputConnectorAdapter() {
		return new RuleMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleMediatorChildMediatorsOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRuleMediatorChildMediatorsOutputConnectorAdapter() {
		return new RuleMediatorChildMediatorsOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleSetCreationPropertyAdapter()
	 * 
	 */
	public Adapter createRuleSetCreationPropertyAdapter() {
		return new RuleSetCreationPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleSessionPropertyAdapter()
	 * 
	 */
	public Adapter createRuleSessionPropertyAdapter() {
		return new RuleSessionPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleFactsConfigurationAdapter()
	 * 
	 */
	public Adapter createRuleFactsConfigurationAdapter() {
		return new RuleFactsConfigurationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleFactAdapter()
	 * 
	 */
	public Adapter createRuleFactAdapter() {
		return new RuleFactPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleResultsConfigurationAdapter()
	 * 
	 */
	public Adapter createRuleResultsConfigurationAdapter() {
		return new RuleResultsConfigurationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRuleResultAdapter()
	 * 
	 */
	public Adapter createRuleResultAdapter() {
		return new RuleResultPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallTemplateParameterAdapter()
	 * 
	 */
	public Adapter createCallTemplateParameterAdapter() {
		return new CallTemplateParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallTemplateMediatorAdapter()
	 * 
	 */
	public Adapter createCallTemplateMediatorAdapter() {
		return new CallTemplateMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallTemplateMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCallTemplateMediatorInputConnectorAdapter() {
		return new CallTemplateMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCallTemplateMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCallTemplateMediatorOutputConnectorAdapter() {
		return new CallTemplateMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoopBackMediatorAdapter()
	 * 
	 */
	public Adapter createLoopBackMediatorAdapter() {
		return new LoopBackMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoopBackMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createLoopBackMediatorInputConnectorAdapter() {
		return new LoopBackMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoopBackMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createLoopBackMediatorOutputConnectorAdapter() {
		return new LoopBackMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRespondMediatorAdapter()
	 * 
	 */
	public Adapter createRespondMediatorAdapter() {
		return new RespondMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRespondMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createRespondMediatorInputConnectorAdapter() {
		return new RespondMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRespondMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRespondMediatorOutputConnectorAdapter() {
		return new RespondMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSmooksMediatorAdapter()
	 * 
	 */
	public Adapter createSmooksMediatorAdapter() {
		return new SmooksMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSmooksMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createSmooksMediatorInputConnectorAdapter() {
		return new SmooksMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSmooksMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSmooksMediatorOutputConnectorAdapter() {
		return new SmooksMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createStoreMediatorAdapter()
	 * 
	 */
	public Adapter createStoreMediatorAdapter() {
		return new StoreMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createStoreMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createStoreMediatorInputConnectorAdapter() {
		return new StoreMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createStoreMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createStoreMediatorOutputConnectorAdapter() {
		return new StoreMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBuilderMediatorAdapter()
	 * 
	 */
	public Adapter createBuilderMediatorAdapter() {
		return new BuilderMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBuilderMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createBuilderMediatorInputConnectorAdapter() {
		return new BuilderMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createBuilderMediatorOutputConectorAdapter()
	 * 
	 */
	public Adapter createBuilderMediatorOutputConectorAdapter() {
		return new BuilderMediatorOutputConectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageBuilderAdapter()
	 * 
	 */
	public Adapter createMessageBuilderAdapter() {
		return new MessageBuilderPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPayloadFactoryMediatorAdapter()
	 * 
	 */
	public Adapter createPayloadFactoryMediatorAdapter() {
		return new PayloadFactoryMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPayloadFactoryMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createPayloadFactoryMediatorInputConnectorAdapter() {
		return new PayloadFactoryMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPayloadFactoryMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createPayloadFactoryMediatorOutputConnectorAdapter() {
		return new PayloadFactoryMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createPayloadFactoryArgumentAdapter()
	 * 
	 */
	public Adapter createPayloadFactoryArgumentAdapter() {
		return new PayloadFactoryArgumentPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createConditionalRouteBranchAdapter()
	 * 
	 */
	public Adapter createConditionalRouteBranchAdapter() {
		return new ConditionalRouteBranchPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createConditionalRouterMediatorAdapter()
	 * 
	 */
	public Adapter createConditionalRouterMediatorAdapter() {
		return new ConditionalRouterMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createConditionalRouterMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createConditionalRouterMediatorInputConnectorAdapter() {
		return new ConditionalRouterMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createConditionalRouterMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createConditionalRouterMediatorOutputConnectorAdapter() {
		return new ConditionalRouterMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createConditionalRouterMediatorAdditionalOutputConnectorAdapter()
	 * 
	 */
	public Adapter createConditionalRouterMediatorAdditionalOutputConnectorAdapter() {
		return new ConditionalRouterMediatorAdditionalOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSendMediatorAdapter()
	 * 
	 */
	public Adapter createSendMediatorAdapter() {
		return new SendMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSendMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createSendMediatorInputConnectorAdapter() {
		return new SendMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSendMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSendMediatorOutputConnectorAdapter() {
		return new SendMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSendMediatorEndpointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSendMediatorEndpointOutputConnectorAdapter() {
		return new SendMediatorEndpointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createParentEndPointAdapter()
	 * 
	 */
	public Adapter createParentEndPointAdapter() {
		return new ParentEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFailoverEndPointAdapter()
	 * 
	 */
	public Adapter createFailoverEndPointAdapter() {
		return new FailoverEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFailoverEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createFailoverEndPointInputConnectorAdapter() {
		return new FailoverEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFailoverEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFailoverEndPointOutputConnectorAdapter() {
		return new FailoverEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFailoverEndPointWestOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFailoverEndPointWestOutputConnectorAdapter() {
		return new FailoverEndPointWestOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createWSDLEndPointAdapter()
	 * 
	 */
	public Adapter createWSDLEndPointAdapter() {
		return new WSDLEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createWSDLEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createWSDLEndPointInputConnectorAdapter() {
		return new WSDLEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createWSDLEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createWSDLEndPointOutputConnectorAdapter() {
		return new WSDLEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoadBalanceEndPointAdapter()
	 * 
	 */
	public Adapter createLoadBalanceEndPointAdapter() {
		return new LoadBalanceEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMemberAdapter()
	 * 
	 */
	public Adapter createMemberAdapter() {
		return new MemberPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoadBalanceEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createLoadBalanceEndPointInputConnectorAdapter() {
		return new LoadBalanceEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoadBalanceEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createLoadBalanceEndPointOutputConnectorAdapter() {
		return new LoadBalanceEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLoadBalanceEndPointWestOutputConnectorAdapter()
	 * 
	 */
	public Adapter createLoadBalanceEndPointWestOutputConnectorAdapter() {
		return new LoadBalanceEndPointWestOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createLocalEntryAdapter()
	 * 
	 */
	public Adapter createLocalEntryAdapter() {
		return new LocalEntryPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSessionAdapter()
	 * 
	 */
	public Adapter createSessionAdapter() {
		return new SessionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSequencesAdapter()
	 * 
	 */
	public Adapter createSequencesAdapter() {
		return new SequencesPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSequencesOutputConnectorAdapter()
	 * 
	 */
	public Adapter createSequencesOutputConnectorAdapter() {
		return new SequencesOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSequencesInputConnectorAdapter()
	 * 
	 */
	public Adapter createSequencesInputConnectorAdapter() {
		return new SequencesInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createURLRewriteRuleActionAdapter()
	 * 
	 */
	public Adapter createURLRewriteRuleActionAdapter() {
		return new URLRewriteRuleActionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createURLRewriteRuleAdapter()
	 * 
	 */
	public Adapter createURLRewriteRuleAdapter() {
		return new URLRewriteRulePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createURLRewriteMediatorAdapter()
	 * 
	 */
	public Adapter createURLRewriteMediatorAdapter() {
		return new URLRewriteMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createURLRewriteMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createURLRewriteMediatorInputConnectorAdapter() {
		return new URLRewriteMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createURLRewriteMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createURLRewriteMediatorOutputConnectorAdapter() {
		return new URLRewriteMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEvaluatorExpressionPropertyAdapter()
	 * 
	 */
	public Adapter createEvaluatorExpressionPropertyAdapter() {
		return new EvaluatorExpressionPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateMediatorAdapter()
	 * 
	 */
	public Adapter createValidateMediatorAdapter() {
		return new ValidateMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateResourceAdapter()
	 * 
	 */
	public Adapter createValidateResourceAdapter() {
		return new ValidateResourcePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateFeatureAdapter()
	 * 
	 */
	public Adapter createValidateFeatureAdapter() {
		return new ValidateFeaturePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateSchemaAdapter()
	 * 
	 */
	public Adapter createValidateSchemaAdapter() {
		return new ValidateSchemaPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createValidateMediatorInputConnectorAdapter() {
		return new ValidateMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createValidateMediatorOutputConnectorAdapter() {
		return new ValidateMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createValidateMediatorOnFailOutputConnectorAdapter()
	 * 
	 */
	public Adapter createValidateMediatorOnFailOutputConnectorAdapter() {
		return new ValidateMediatorOnFailOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createEndpointDiagramAdapter()
	 * 
	 */
	public Adapter createEndpointDiagramAdapter() {
		return new EndpointDiagramPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createNamedEndpointAdapter()
	 * 
	 */
	public Adapter createNamedEndpointAdapter() {
		return new NamedEndpointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createNamedEndpointInputConnectorAdapter()
	 * 
	 */
	public Adapter createNamedEndpointInputConnectorAdapter() {
		return new NamedEndpointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createNamedEndpointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createNamedEndpointOutputConnectorAdapter() {
		return new NamedEndpointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTemplateAdapter()
	 * 
	 */
	public Adapter createTemplateAdapter() {
		return new TemplatePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTemplateParameterAdapter()
	 * 
	 */
	public Adapter createTemplateParameterAdapter() {
		return new TemplateParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTaskAdapter()
	 * 
	 */
	public Adapter createTaskAdapter() {
		return new TaskPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createNameValueTypePropertyAdapter()
	 * 
	 */
	public Adapter createNameValueTypePropertyAdapter() {
		return new NameValueTypePropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createTaskPropertyAdapter()
	 * 
	 */
	public Adapter createTaskPropertyAdapter() {
		return new TaskPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createSynapseAPIAdapter()
	 * 
	 */
	public Adapter createSynapseAPIAdapter() {
		return new SynapseAPIPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceAdapter()
	 * 
	 */
	public Adapter createAPIResourceAdapter() {
		return new APIResourcePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceInputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceInputConnectorAdapter() {
		return new APIResourceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceOutputConnectorAdapter() {
		return new APIResourceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceOutSequenceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceOutSequenceOutputConnectorAdapter() {
		return new APIResourceOutSequenceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceInSequenceInputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceInSequenceInputConnectorAdapter() {
		return new APIResourceInSequenceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceFaultInputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceFaultInputConnectorAdapter() {
		return new APIResourceFaultInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceEndpointAdapter()
	 * 
	 */
	public Adapter createAPIResourceEndpointAdapter() {
		return new APIResourceEndpointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceEndpointInputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceEndpointInputConnectorAdapter() {
		return new APIResourceEndpointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIResourceEndpointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAPIResourceEndpointOutputConnectorAdapter() {
		return new APIResourceEndpointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createComplexEndpointsAdapter()
	 * 
	 */
	public Adapter createComplexEndpointsAdapter() {
		return new ComplexEndpointsPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createComplexEndpointsOutputConnectorAdapter()
	 * 
	 */
	public Adapter createComplexEndpointsOutputConnectorAdapter() {
		return new ComplexEndpointsOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAddressingEndpointAdapter()
	 * 
	 */
	public Adapter createAddressingEndpointAdapter() {
		return new AddressingEndpointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAddressingEndpointInputConnectorAdapter()
	 * 
	 */
	public Adapter createAddressingEndpointInputConnectorAdapter() {
		return new AddressingEndpointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAddressingEndpointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createAddressingEndpointOutputConnectorAdapter() {
		return new AddressingEndpointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRecipientListEndPointAdapter()
	 * 
	 */
	public Adapter createRecipientListEndPointAdapter() {
		return new RecipientListEndPointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRecipientListEndPointInputConnectorAdapter()
	 * 
	 */
	public Adapter createRecipientListEndPointInputConnectorAdapter() {
		return new RecipientListEndPointInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRecipientListEndPointOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRecipientListEndPointOutputConnectorAdapter() {
		return new RecipientListEndPointOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createRecipientListEndPointWestOutputConnectorAdapter()
	 * 
	 */
	public Adapter createRecipientListEndPointWestOutputConnectorAdapter() {
		return new RecipientListEndPointWestOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageStoreParameterAdapter()
	 * 
	 */
	public Adapter createMessageStoreParameterAdapter() {
		return new MessageStoreParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageStoreAdapter()
	 * 
	 */
	public Adapter createMessageStoreAdapter() {
		return new MessageStorePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageProcessorParameterAdapter()
	 * 
	 */
	public Adapter createMessageProcessorParameterAdapter() {
		return new MessageProcessorParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createMessageProcessorAdapter()
	 * 
	 */
	public Adapter createMessageProcessorAdapter() {
		return new MessageProcessorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIHandlerAdapter()
	 * 
	 */
	public Adapter createAPIHandlerAdapter() {
		return new APIHandlerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createAPIHandlerPropertyAdapter()
	 * 
	 */
	public Adapter createAPIHandlerPropertyAdapter() {
		return new APIHandlerPropertyPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloudConnectorAdapter()
	 * 
	 */
	public Adapter createCloudConnectorAdapter() {
		return new CloudConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloudConnectorInputConnectorAdapter()
	 * 
	 */
	public Adapter createCloudConnectorInputConnectorAdapter() {
		return new CloudConnectorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloudConnectorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCloudConnectorOutputConnectorAdapter() {
		return new CloudConnectorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloudConnectorOperationAdapter()
	 * 
	 */
	public Adapter createCloudConnectorOperationAdapter() {
		return new CloudConnectorOperationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloudConnectorOperationInputConnectorAdapter()
	 * 
	 */
	public Adapter createCloudConnectorOperationInputConnectorAdapter() {
		return new CloudConnectorOperationInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCloudConnectorOperationOutputConnectorAdapter()
	 * 
	 */
	public Adapter createCloudConnectorOperationOutputConnectorAdapter() {
		return new CloudConnectorOperationOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDataMapperMediatorAdapter()
	 * 
	 */
	public Adapter createDataMapperMediatorAdapter() {
		return new DataMapperMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDataMapperMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createDataMapperMediatorInputConnectorAdapter() {
		return new DataMapperMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createDataMapperMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createDataMapperMediatorOutputConnectorAdapter() {
		return new DataMapperMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFastXSLTMediatorAdapter()
	 * 
	 */
	public Adapter createFastXSLTMediatorAdapter() {
		return new FastXSLTMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFastXSLTMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createFastXSLTMediatorInputConnectorAdapter() {
		return new FastXSLTMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createFastXSLTMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createFastXSLTMediatorOutputConnectorAdapter() {
		return new FastXSLTMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointAdapter()
	 * 
	 */
	public Adapter createInboundEndpointAdapter() {
		return new InboundEndpointPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointParameterAdapter()
	 * 
	 */
	public Adapter createInboundEndpointParameterAdapter() {
		return new InboundEndpointParameterPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointContainerAdapter()
	 * 
	 */
	public Adapter createInboundEndpointContainerAdapter() {
		return new InboundEndpointContainerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointSequenceInputConnectorAdapter()
	 * 
	 */
	public Adapter createInboundEndpointSequenceInputConnectorAdapter() {
		return new InboundEndpointSequenceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointSequenceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createInboundEndpointSequenceOutputConnectorAdapter() {
		return new InboundEndpointSequenceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointOnErrorSequenceOutputConnectorAdapter()
	 * 
	 */
	public Adapter createInboundEndpointOnErrorSequenceOutputConnectorAdapter() {
		return new InboundEndpointOnErrorSequenceOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createInboundEndpointOnErrorSequenceInputConnectorAdapter()
	 * 
	 */
	public Adapter createInboundEndpointOnErrorSequenceInputConnectorAdapter() {
		return new InboundEndpointOnErrorSequenceInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createCommentMediatorAdapter()
	 * 
	 */
	public Adapter createCommentMediatorAdapter() {
		return new CommentMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createJsonTransformMediatorAdapter()
	 * 
	 */
	public Adapter createJsonTransformMediatorAdapter() {
		return new JsonTransformMediatorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createJsonTransformMediatorOutputConnectorAdapter()
	 * 
	 */
	public Adapter createJsonTransformMediatorOutputConnectorAdapter() {
		return new JsonTransformMediatorOutputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createJsonTransformMediatorInputConnectorAdapter()
	 * 
	 */
	public Adapter createJsonTransformMediatorInputConnectorAdapter() {
		return new JsonTransformMediatorInputConnectorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.util.EsbAdapterFactory#createJsonTransformMediatorPropertyAdapter()
	 * 
	 */
	public Adapter createJsonTransformMediatorPropertyAdapter() {
		return new JsonTransformMediatorPropertyPropertiesEditionProvider();
	}

}
