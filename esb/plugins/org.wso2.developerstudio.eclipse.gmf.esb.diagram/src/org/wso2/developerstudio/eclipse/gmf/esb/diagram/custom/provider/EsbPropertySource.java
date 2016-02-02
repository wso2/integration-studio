/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider;


import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EsbPropertySource extends PropertySource {
	private static final String PUBLISH_EVENT_ARBITRARY_CATEGORY = "arbitrary";
	private static final String PUBLISH_EVENT_PAYLOAD_CATEGORY = "payload";
	private static final String PUBLISH_EVENT_CORRELATION_CATEGORY = "correlation";
	private static final String PUBLISH_EVENT_META_CATEGORY = "meta";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public EsbPropertySource(Object object,
			IItemPropertySource itemPropertySource) {
		super(object, itemPropertySource);
	}

	
	protected IPropertyDescriptor createPropertyDescriptor(
			IItemPropertyDescriptor itemPropertyDescriptor) {
		EsbPackage pkg = EsbPackage.eINSTANCE;
		Object feature = itemPropertyDescriptor.getFeature(object);
		
		if (pkg.getLogMediator_Properties().equals(feature)) {
			return new LogConfigurationPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getEnrichMediator_SourceXpath().equals(feature)) {
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if (pkg.getEnrichMediator_TargetXpath().equals(feature)) {
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} /*else if (pkg.getFilterMediator_Xpath().equals(feature)) {
			return new FilterXPathPropertyDescriptor(object,
					itemPropertyDescriptor);
		}*//* else if (pkg.getFilterMediator_Source().equals(feature)) {
			return new FilterSourcePropertyDescriptor(object,
					itemPropertyDescriptor);
		}*/ else if (pkg.getXSLTMediator_Properties().equals(feature)) {
			return new XSLTPropertiesPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getXSLTMediator_Resources().equals(feature)) {
			return new XSLTResourcesPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getXSLTMediator_Features().equals(feature)) {
			return new XSLTFeaturesPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getXSLTMediator_SourceXPath().equals(feature)) {
			return new CustomPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getSwitchMediator_SourceXpath().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getSwitchMediator_CaseBranches().equals(feature)) {
			return new SwitchConfigurationPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getClassMediator_Properties().equals(feature)) {
			return new ClassConfigurationPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getSendMediator_StaticReceivingSequence().equals(feature)){
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getHeaderMediator_HeaderName().equals(feature)){
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getHeaderMediator_ValueExpression().equals(feature)){
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getAggregateMediator_AggregationExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAggregateMediator_CompletionMaxMessagesExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAggregateMediator_CompletionMinMessagesExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAggregateMediator_SequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getAggregateMediator_CorrelationExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getRMSequenceMediator_CorrelationXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getRMSequenceMediator_LastMessageXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getForEachMediator_ForEachExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getIterateMediator_IterateExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getIterateMediator_AttachPath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getCalloutMediator_ResultMessageXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getCalloutMediator_PayloadMessageXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSendMediator_DynamicReceivingSequence().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getProxyService_WsdlKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getProxyService_WsdlEndpoint().equals(feature)){
 		    return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
 	    } else if(pkg.getPropertyMediator_ValueExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}  else if(pkg.getPropertyMediator_OM().equals(feature)){
			return new PropertyMediatorOMPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getEventMediator_DynamicTopic().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getEventMediator_EventExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXSLTMediator_XsltDynamicSchemaKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFastXSLTMediator_FastXsltDynamicSchemaKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFastXSLTMediator_FastXsltStaticSchemaKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXSLTMediator_SourceXPath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXSLTMediator_XsltStaticSchemaKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXQueryMediator_TargetXPath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXQueryMediator_DynamicScriptKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXQueryMediator_StaticScriptKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getXQueryMediator_Variables().equals(feature)){
			return new XQueryVariablesPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFaultMediator_FaultReasonExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFaultMediator_FaultDetailExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFaultMediator_FaultStringExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFaultMediator_FaultCodeExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}/* else if(pkg.getCalloutMediator_PayloadRegistryKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}*/ else if(pkg.getSpringMediator_ConfigurationKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSmooksMediator_ConfigurationKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSmooksMediator_InputExpression() .equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSmooksMediator_OutputExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getEnqueueMediator_SequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getRuleMediator_RuleSetSourceKey().equals(feature)){
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getRuleMediator_FactsConfiguration().equals(feature)){
			return new RuleMediatorFactsPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getRuleMediator_ResultsConfiguration().equals(feature)){
			return new RuleMediatorResultsPropertyDescriptor(object,itemPropertyDescriptor);	
		}else if(pkg.getRuleMediator_RuleSessionProperties().equals(feature)){
			return new RuleMediatorSessionPropertyDescriptor(object,itemPropertyDescriptor);
		}/*else if(pkg.getRuleMediator_RuleSetProperties().equals(feature)){
			return new RuleMediatorRuleSetPropertyDescriptor(object,itemPropertyDescriptor);
		}*/ else if (pkg.getStoreMediator_OnStoreSequence().equals(feature)) {
			return new CustomPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getFilterMediator_Xpath().equals(feature)){
		    return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getFilterMediator_Source().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);			
			//CallTemplate Mediator Template parameter custom property descriptor.
		} else if(pkg.getCallTemplateMediator_TemplateParameters().equals(feature)){
			return new CallTemplateParamCustomPropertyDescriptor(object, itemPropertyDescriptor);			
			//Cache Mediator OnHitBranch Sequence Key custom property descriptor.
		} else if(pkg.getCacheMediator_SequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);			
		} else if (pkg.getStoreMediator_AvailableMessageStores().equals(feature)){
			return new StoreMediatorPropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getCommandMediator_Properties().equals(feature)) {			
			return new CommandMediatorPropertyDescriptor(object,itemPropertyDescriptor);
		} else if (pkg.getRouterMediator_RouterContainer().equals(feature)) {
			return new RouterMediatorPropertyDescriptor(object,itemPropertyDescriptor);
		} else if (pkg.getConditionalRouterMediator_ConditionalRouteBranches().equals(feature)) {
			return new ConditionalRouterMediatorPropertyDescriptor(object,itemPropertyDescriptor);
		} else if (pkg.getPayloadFactoryMediator_Args().equals(feature)) {
			return new PayloadFactoryPropertyDescriptor(object,itemPropertyDescriptor);
		} else if(pkg.getPayloadFactoryMediator_PayloadKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getAbstractSqlExecutorMediator_SqlStatements().equals(feature)) {
			return new SqlExecutorMediatorSqlStatementsPropertyDescriptor(object,itemPropertyDescriptor);		}
			//Throttle Mediator Policy Entries custom property descriptor.
		else if(pkg.getThrottleMediator_PolicyEntries().equals(feature)){			
			return new ThrottlePolicyEntryPropertyDescriptor(object, itemPropertyDescriptor);			
			//Throttle Mediator Policy key custom property descriptor.
		}else if(pkg.getThrottleMediator_PolicyKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
			//Throttle Mediator On Accept branch custom property descriptor.
		}else if(pkg.getThrottleMediator_OnAcceptBranchsequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);			
			//Throttle Mediator On Reject branch custom property descriptor.
		}else if(pkg.getThrottleMediator_OnRejectBranchsequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);			
			//Validate Mediator Source path Custom property descriptors.
		}else if(pkg.getValidateMediator_SourceXpath().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);			
			//Validate Mediator Schema Custom property descriptors.
		}else if(pkg.getValidateMediator_Schemas().equals(feature)){			
			return new ValidateSchemasPropertyDescriptor(object, itemPropertyDescriptor);			
			//Validate Mediator Features Custom property descriptors.
		}else if(pkg.getValidateMediator_Features().equals(feature)){			
			return new ValidateFeaturePropertyDescriptor(object, itemPropertyDescriptor);			
		} else if (pkg.getValidateMediator_Resources().equals(feature)) {
			return new ValidateResourcePropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getURLRewriteMediator_UrlRewriteRules().equals(feature)){			
			return new URLRewiterConfigurationPropertyDescriptor(object, itemPropertyDescriptor);			
			//Builder Mediator message builder custom property descriptor.
		}else if(pkg.getBuilderMediator_MessageBuilders().equals(feature)){			
			return new MessageBuilderPropertyDescriptor(object, itemPropertyDescriptor);			
		}else if(pkg.getRuleMediator_SourceXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getRuleMediator_TargetResultXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getRuleMediator_TargetXpath().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_InSequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_InSequenceOnError().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_OutSequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_OutSequenceOnError().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_FaultSequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_FaultSequenceOnError().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getTask_TaskProperties().equals(feature)){
			return new TaskConfigurationPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAPIResource_InSequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAPIResource_OutSequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAPIResource_FaultSequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAbstractEndPoint_ReliableMessagingPolicy().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAbstractEndPoint_SecurityPolicy().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAbstractEndPoint_InboundPolicy().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getAbstractEndPoint_OutboundPolicy().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getBeanMediator_ValueExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getBeanMediator_TargetExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getEJBMediator_SessionIdExpression().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getProxyService_WsdlResources().equals(feature)){
			return new ProxyServiceWSDLResourcePropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getProxyService_OnError().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getScriptMediator_ScriptDynamicKey().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getScriptMediator_ScriptKeys().equals(feature)) {
			return new ScriptKeysPropertyDescriptor(object,
					itemPropertyDescriptor);
		} else if (pkg.getScriptMediator_ScriptStaticKey().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSequences_OnError().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSequence_DynamicReferenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSequence_StaticReferenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getNamedEndpoint_DynamicReferenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getNamedEndpoint_StaticReferenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getEnrichMediator_InlineRegistryKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getProxyService_ServicePolicies().equals(feature)){
			return new ProxyServicePolicyPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getProxyService_EndpointKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getEndPoint_Properties().equals(feature)){
			return new EndPointPropertiesPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getTemplate_Parameters().equals(feature)){
			return new TemplateParametersPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getProxyService_ServiceParameters().equals(feature)){
			return new ProxyParametersPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getMessageStore_Parameters().equals(feature)){
            return new MessageStoreParamCustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getMessageProcessor_Sequence().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getMessageProcessor_ReplySequenceName().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getMessageProcessor_DeactivateSequenceName().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getMessageProcessor_FaultSequenceName().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getMessageProcessor_EndpointName().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getMessageProcessor_Parameters().equals(feature)){
            return new MessageProcessorParamCustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getCallTemplateMediator_AvailableTemplates().equals(feature)){
            return new CallTemplateTargetTemplateCustomPropertyDescriptor(object, itemPropertyDescriptor);     
		} else if(pkg.getTemplateEndpoint_AvailableTemplates().equals(feature)){
            return new TemplateEndpointTargetTemplateCustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSequences_TemplateParameters().equals(feature)){
			return new TemplateParametersPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getAbstractEndPoint_TemplateParameters().equals(feature)){
			return new TemplateParametersPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getSynapseAPI_Handlers().equals(feature)) {
			return new APIHandlersPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getTemplateEndpoint_Parameters().equals(feature)){
	    	return new TemplateEndpointParametersPropertyDescriptor(object, itemPropertyDescriptor); 
		} else if(pkg.getCloudConnectorOperation_ConnectorParameters().equals(feature)){
			return new CallTemplateParamCustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getCalloutMediator_AddressEndpoint().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getCalloutMediator_PolicyKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getCalloutMediator_InboundPolicyKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getCalloutMediator_InboundPolicyKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getCalloutMediator_OutboundPolicyKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getPayloadFactoryMediator_Payload().equals(feature)){
			return new PayloadFactoryMediatorFormatPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getMessageProcessor_MessageStore().equals(feature)){
			return new MessageProcessorMesageStorePropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getEJBMediator_MethodArguments().equals(feature)) {
			return new EJBMediatorMethodArgumentConfigurationPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getCallMediator_EndpointRegistrykey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getCallMediator_EndpointXpath().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getEntitlementMediator_OnRejectSequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getEntitlementMediator_OnAcceptSequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getEntitlementMediator_AdviceSequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getEntitlementMediator_ObligationsSequenceKey().equals(feature)){			
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if (pkg.getRecipientListEndPoint_EndpointsExpression().equals(feature)) {
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if (pkg.getCloudConnectorOperation_NewConfig().equals(feature)) {
			return new CloudConnectorNewConfigPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getCloudConnectorOperation_AvailableConfigs().equals(feature)){
            return new CloudConnectorAvailableConfigPropertyDescriptor(object, itemPropertyDescriptor);     
		}else if(pkg.getForEachMediator_SequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}else if(pkg.getIterateMediator_SequenceKey().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if (pkg.getCloneMediator_Targets().equals(feature)) {
			return new CloneTargetConfigurationPropertyDescriptor(object, itemPropertyDescriptor);
		}  else if(pkg.getDataMapperMediator_Configuration().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}  else if(pkg.getDataMapperMediator_InputSchema().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		}  else if(pkg.getDataMapperMediator_OutputSchema().equals(feature)){
			return new CustomPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getInboundEndpoint_ServiceParameters().equals(feature)){
			return new InboundEndpointParametersPropertyDescriptor(object, itemPropertyDescriptor);
		} else if(pkg.getPublishEventMediator_MetaAttributes().equals(feature)){
			return new PublishEventAttributesPropertyDescriptor(object, itemPropertyDescriptor, PUBLISH_EVENT_META_CATEGORY);
		} else if(pkg.getPublishEventMediator_CorrelationAttributes().equals(feature)){
			return new PublishEventAttributesPropertyDescriptor(object, itemPropertyDescriptor, PUBLISH_EVENT_CORRELATION_CATEGORY);
		} else if(pkg.getPublishEventMediator_PayloadAttributes().equals(feature)){
			return new PublishEventAttributesPropertyDescriptor(object, itemPropertyDescriptor, PUBLISH_EVENT_PAYLOAD_CATEGORY);
		} else if(pkg.getPublishEventMediator_ArbitraryAttributes().equals(feature)){
			return new PublishEventAttributesPropertyDescriptor(object, itemPropertyDescriptor, PUBLISH_EVENT_ARBITRARY_CATEGORY);
		}
 		
			
		// Else, default EMF behavior
		else {
			if(object instanceof CloudConnectorOperation){
				if(!pkg.getCloudConnectorOperation_ParameterEditorType().equals(feature) && !pkg.getCloudConnectorOperation_ConfigRef().equals(feature)){
					return new CloudConnectorDynamicParameterPropertyDescriptor(object, itemPropertyDescriptor);
				}
			}
			return super.createPropertyDescriptor(itemPropertyDescriptor);
		}
	}
	
	  public Object getPropertyValue(Object propertyId)
	  {
		  try{
			  return super.getPropertyValue(propertyId);
		  }
		  catch(NullPointerException e){
			  return null;
		  }
	  }
}
