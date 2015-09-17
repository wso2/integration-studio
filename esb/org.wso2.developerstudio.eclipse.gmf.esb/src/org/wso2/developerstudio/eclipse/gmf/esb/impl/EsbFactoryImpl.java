/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EsbFactoryImpl extends EFactoryImpl implements EsbFactory {
	static int proxyservicecount;
	private static final String BAM_MEDIATOR_DEFAULT_SERVER_PROFILE_NAME = "server_profile_name";
	private static final String BAM_MEDIATOR_DEFAULT_STREAM_NAME = "stream_name";
	private static final String BAM_MEDIATOR_DEFAULT_STREAM_VERSION = "1.0.0";
	private static final String OAUTH_MEDIATOR_DEFAULT_USERNAME = "username";
	private static final String OAUTH_MEDIATOR_DEFAULT_PASSWORD = "password";
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EsbFactory init() {
		try {
			EsbFactory theEsbFactory = (EsbFactory)EPackage.Registry.INSTANCE.getEFactory(EsbPackage.eNS_URI);
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
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EsbPackage.ESB_DIAGRAM: return createEsbDiagram();
			case EsbPackage.ESB_SERVER: return createEsbServer();
			case EsbPackage.ESB_LINK: return createEsbLink();
			case EsbPackage.CALL_MEDIATOR: return createCallMediator();
			case EsbPackage.CALL_MEDIATOR_INPUT_CONNECTOR: return createCallMediatorInputConnector();
			case EsbPackage.CALL_MEDIATOR_OUTPUT_CONNECTOR: return createCallMediatorOutputConnector();
			case EsbPackage.CALL_MEDIATOR_ENDPOINT_OUTPUT_CONNECTOR: return createCallMediatorEndpointOutputConnector();
			case EsbPackage.END_POINT_PROPERTY: return createEndPointProperty();
			case EsbPackage.PROXY_SERVICE: return createProxyService();
			case EsbPackage.PROXY_OUTPUT_CONNECTOR: return createProxyOutputConnector();
			case EsbPackage.PROXY_INPUT_CONNECTOR: return createProxyInputConnector();
			case EsbPackage.PROXY_OUT_SEQUENCE_OUTPUT_CONNECTOR: return createProxyOutSequenceOutputConnector();
			case EsbPackage.PROXY_IN_SEQUENCE_INPUT_CONNECTOR: return createProxyInSequenceInputConnector();
			case EsbPackage.PROXY_WSDL_RESOURCE: return createProxyWSDLResource();
			case EsbPackage.PROXY_FAULT_INPUT_CONNECTOR: return createProxyFaultInputConnector();
			case EsbPackage.PROXY_SERVICE_PARAMETER: return createProxyServiceParameter();
			case EsbPackage.PROXY_SERVICE_POLICY: return createProxyServicePolicy();
			case EsbPackage.PROXY_SERVICE_SEQUENCE_AND_ENDPOINT_CONTAINER: return createProxyServiceSequenceAndEndpointContainer();
			case EsbPackage.PROXY_SERVICE_FAULT_CONTAINER: return createProxyServiceFaultContainer();
			case EsbPackage.PROXY_SERVICE_CONTAINER: return createProxyServiceContainer();
			case EsbPackage.MEDIATOR_FLOW: return createMediatorFlow();
			case EsbPackage.ENDPOINT_FLOW: return createEndpointFlow();
			case EsbPackage.MESSAGE_MEDIATOR: return createMessageMediator();
			case EsbPackage.MESSAGE_INPUT_CONNECTOR: return createMessageInputConnector();
			case EsbPackage.MESSAGE_OUTPUT_CONNECTOR: return createMessageOutputConnector();
			case EsbPackage.DEFAULT_END_POINT: return createDefaultEndPoint();
			case EsbPackage.DEFAULT_END_POINT_INPUT_CONNECTOR: return createDefaultEndPointInputConnector();
			case EsbPackage.DEFAULT_END_POINT_OUTPUT_CONNECTOR: return createDefaultEndPointOutputConnector();
			case EsbPackage.ADDRESS_END_POINT: return createAddressEndPoint();
			case EsbPackage.ADDRESS_END_POINT_INPUT_CONNECTOR: return createAddressEndPointInputConnector();
			case EsbPackage.ADDRESS_END_POINT_OUTPUT_CONNECTOR: return createAddressEndPointOutputConnector();
			case EsbPackage.TEMPLATE_ENDPOINT: return createTemplateEndpoint();
			case EsbPackage.TEMPLATE_ENDPOINT_INPUT_CONNECTOR: return createTemplateEndpointInputConnector();
			case EsbPackage.TEMPLATE_ENDPOINT_OUTPUT_CONNECTOR: return createTemplateEndpointOutputConnector();
			case EsbPackage.TEMPLATE_ENDPOINT_PARAMETER: return createTemplateEndpointParameter();
			case EsbPackage.HTTP_ENDPOINT: return createHTTPEndpoint();
			case EsbPackage.HTTP_END_POINT_INPUT_CONNECTOR: return createHTTPEndPointInputConnector();
			case EsbPackage.HTTP_END_POINT_OUTPUT_CONNECTOR: return createHTTPEndPointOutputConnector();
			case EsbPackage.DROP_MEDIATOR: return createDropMediator();
			case EsbPackage.DROP_MEDIATOR_INPUT_CONNECTOR: return createDropMediatorInputConnector();
			case EsbPackage.FILTER_MEDIATOR: return createFilterMediator();
			case EsbPackage.FILTER_CONTAINER: return createFilterContainer();
			case EsbPackage.FILTER_PASS_CONTAINER: return createFilterPassContainer();
			case EsbPackage.FILTER_FAIL_CONTAINER: return createFilterFailContainer();
			case EsbPackage.FILTER_MEDIATOR_INPUT_CONNECTOR: return createFilterMediatorInputConnector();
			case EsbPackage.FILTER_MEDIATOR_OUTPUT_CONNECTOR: return createFilterMediatorOutputConnector();
			case EsbPackage.FILTER_MEDIATOR_PASS_OUTPUT_CONNECTOR: return createFilterMediatorPassOutputConnector();
			case EsbPackage.FILTER_MEDIATOR_FAIL_OUTPUT_CONNECTOR: return createFilterMediatorFailOutputConnector();
			case EsbPackage.MERGE_NODE: return createMergeNode();
			case EsbPackage.MERGE_NODE_FIRST_INPUT_CONNECTOR: return createMergeNodeFirstInputConnector();
			case EsbPackage.MERGE_NODE_SECOND_INPUT_CONNECTOR: return createMergeNodeSecondInputConnector();
			case EsbPackage.MERGE_NODE_OUTPUT_CONNECTOR: return createMergeNodeOutputConnector();
			case EsbPackage.LOG_MEDIATOR: return createLogMediator();
			case EsbPackage.LOG_MEDIATOR_INPUT_CONNECTOR: return createLogMediatorInputConnector();
			case EsbPackage.LOG_MEDIATOR_OUTPUT_CONNECTOR: return createLogMediatorOutputConnector();
			case EsbPackage.LOG_PROPERTY: return createLogProperty();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR: return createPublishEventMediator();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR_INPUT_CONNECTOR: return createPublishEventMediatorInputConnector();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR_OUTPUT_CONNECTOR: return createPublishEventMediatorOutputConnector();
			case EsbPackage.PUBLISH_EVENT_MEDIATOR_ATTRIBUTE: return createPublishEventMediatorAttribute();
			case EsbPackage.BAM_MEDIATOR: return createBAMMediator();
			case EsbPackage.BAM_MEDIATOR_INPUT_CONNECTOR: return createBAMMediatorInputConnector();
			case EsbPackage.BAM_MEDIATOR_OUTPUT_CONNECTOR: return createBAMMediatorOutputConnector();
			case EsbPackage.BEAN_MEDIATOR: return createBeanMediator();
			case EsbPackage.BEAN_MEDIATOR_INPUT_CONNECTOR: return createBeanMediatorInputConnector();
			case EsbPackage.BEAN_MEDIATOR_OUTPUT_CONNECTOR: return createBeanMediatorOutputConnector();
			case EsbPackage.EJB_MEDIATOR: return createEJBMediator();
			case EsbPackage.EJB_MEDIATOR_INPUT_CONNECTOR: return createEJBMediatorInputConnector();
			case EsbPackage.EJB_MEDIATOR_OUTPUT_CONNECTOR: return createEJBMediatorOutputConnector();
			case EsbPackage.METHOD_ARGUMENT: return createMethodArgument();
			case EsbPackage.REGISTRY_KEY_PROPERTY: return createRegistryKeyProperty();
			case EsbPackage.PROPERTY_MEDIATOR: return createPropertyMediator();
			case EsbPackage.PROPERTY_MEDIATOR_INPUT_CONNECTOR: return createPropertyMediatorInputConnector();
			case EsbPackage.PROPERTY_MEDIATOR_OUTPUT_CONNECTOR: return createPropertyMediatorOutputConnector();
			case EsbPackage.NAMESPACED_PROPERTY: return createNamespacedProperty();
			case EsbPackage.ENRICH_MEDIATOR: return createEnrichMediator();
			case EsbPackage.ENRICH_MEDIATOR_INPUT_CONNECTOR: return createEnrichMediatorInputConnector();
			case EsbPackage.ENRICH_MEDIATOR_OUTPUT_CONNECTOR: return createEnrichMediatorOutputConnector();
			case EsbPackage.XSLT_MEDIATOR: return createXSLTMediator();
			case EsbPackage.XSLT_PROPERTY: return createXSLTProperty();
			case EsbPackage.XSLT_FEATURE: return createXSLTFeature();
			case EsbPackage.XSLT_RESOURCE: return createXSLTResource();
			case EsbPackage.XSLT_MEDIATOR_INPUT_CONNECTOR: return createXSLTMediatorInputConnector();
			case EsbPackage.XSLT_MEDIATOR_OUTPUT_CONNECTOR: return createXSLTMediatorOutputConnector();
			case EsbPackage.SWITCH_MEDIATOR: return createSwitchMediator();
			case EsbPackage.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR: return createSwitchCaseBranchOutputConnector();
			case EsbPackage.SWITCH_DEFAULT_BRANCH_OUTPUT_CONNECTOR: return createSwitchDefaultBranchOutputConnector();
			case EsbPackage.SWITCH_MEDIATOR_INPUT_CONNECTOR: return createSwitchMediatorInputConnector();
			case EsbPackage.SWITCH_MEDIATOR_OUTPUT_CONNECTOR: return createSwitchMediatorOutputConnector();
			case EsbPackage.SWITCH_MEDIATOR_CONTAINER: return createSwitchMediatorContainer();
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER: return createSwitchCaseParentContainer();
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER: return createSwitchDefaultParentContainer();
			case EsbPackage.SWITCH_CASE_CONTAINER: return createSwitchCaseContainer();
			case EsbPackage.SWITCH_DEFAULT_CONTAINER: return createSwitchDefaultContainer();
			case EsbPackage.SEQUENCE_DIAGRAM: return createSequenceDiagram();
			case EsbPackage.ESB_SEQUENCE: return createEsbSequence();
			case EsbPackage.ESB_SEQUENCE_INPUT: return createEsbSequenceInput();
			case EsbPackage.ESB_SEQUENCE_OUTPUT: return createEsbSequenceOutput();
			case EsbPackage.ESB_SEQUENCE_INPUT_CONNECTOR: return createEsbSequenceInputConnector();
			case EsbPackage.ESB_SEQUENCE_OUTPUT_CONNECTOR: return createEsbSequenceOutputConnector();
			case EsbPackage.SEQUENCE: return createSequence();
			case EsbPackage.SEQUENCE_INPUT_CONNECTOR: return createSequenceInputConnector();
			case EsbPackage.SEQUENCE_OUTPUT_CONNECTOR: return createSequenceOutputConnector();
			case EsbPackage.EVENT_MEDIATOR: return createEventMediator();
			case EsbPackage.EVENT_MEDIATOR_INPUT_CONNECTOR: return createEventMediatorInputConnector();
			case EsbPackage.EVENT_MEDIATOR_OUTPUT_CONNECTOR: return createEventMediatorOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR: return createEntitlementMediator();
			case EsbPackage.ENTITLEMENT_MEDIATOR_INPUT_CONNECTOR: return createEntitlementMediatorInputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR_OUTPUT_CONNECTOR: return createEntitlementMediatorOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR_ON_REJECT_OUTPUT_CONNECTOR: return createEntitlementMediatorOnRejectOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR_ON_ACCEPT_OUTPUT_CONNECTOR: return createEntitlementMediatorOnAcceptOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR_ADVICE_OUTPUT_CONNECTOR: return createEntitlementMediatorAdviceOutputConnector();
			case EsbPackage.ENTITLEMENT_MEDIATOR_OBLIGATIONS_OUTPUT_CONNECTOR: return createEntitlementMediatorObligationsOutputConnector();
			case EsbPackage.ENTITLEMENT_CONTAINER: return createEntitlementContainer();
			case EsbPackage.ENTITLEMENT_ON_REJECT_CONTAINER: return createEntitlementOnRejectContainer();
			case EsbPackage.ENTITLEMENT_ON_ACCEPT_CONTAINER: return createEntitlementOnAcceptContainer();
			case EsbPackage.ENTITLEMENT_ADVICE_CONTAINER: return createEntitlementAdviceContainer();
			case EsbPackage.ENTITLEMENT_OBLIGATIONS_CONTAINER: return createEntitlementObligationsContainer();
			case EsbPackage.ENQUEUE_MEDIATOR: return createEnqueueMediator();
			case EsbPackage.ENQUEUE_MEDIATOR_INPUT_CONNECTOR: return createEnqueueMediatorInputConnector();
			case EsbPackage.ENQUEUE_MEDIATOR_OUTPUT_CONNECTOR: return createEnqueueMediatorOutputConnector();
			case EsbPackage.CLASS_MEDIATOR: return createClassMediator();
			case EsbPackage.CLASS_MEDIATOR_INPUT_CONNECTOR: return createClassMediatorInputConnector();
			case EsbPackage.CLASS_MEDIATOR_OUTPUT_CONNECTOR: return createClassMediatorOutputConnector();
			case EsbPackage.CLASS_PROPERTY: return createClassProperty();
			case EsbPackage.SPRING_MEDIATOR: return createSpringMediator();
			case EsbPackage.SPRING_MEDIATOR_INPUT_CONNECTOR: return createSpringMediatorInputConnector();
			case EsbPackage.SPRING_MEDIATOR_OUTPUT_CONNECTOR: return createSpringMediatorOutputConnector();
			case EsbPackage.SCRIPT_MEDIATOR: return createScriptMediator();
			case EsbPackage.SCRIPT_MEDIATOR_INPUT_CONNECTOR: return createScriptMediatorInputConnector();
			case EsbPackage.SCRIPT_MEDIATOR_OUTPUT_CONNECTOR: return createScriptMediatorOutputConnector();
			case EsbPackage.FAULT_MEDIATOR: return createFaultMediator();
			case EsbPackage.FAULT_MEDIATOR_INPUT_CONNECTOR: return createFaultMediatorInputConnector();
			case EsbPackage.FAULT_MEDIATOR_OUTPUT_CONNECTOR: return createFaultMediatorOutputConnector();
			case EsbPackage.AGGREGATE_MEDIATOR: return createAggregateMediator();
			case EsbPackage.AGGREGATE_MEDIATOR_INPUT_CONNECTOR: return createAggregateMediatorInputConnector();
			case EsbPackage.AGGREGATE_MEDIATOR_OUTPUT_CONNECTOR: return createAggregateMediatorOutputConnector();
			case EsbPackage.AGGREGATE_MEDIATOR_ON_COMPLETE_OUTPUT_CONNECTOR: return createAggregateMediatorOnCompleteOutputConnector();
			case EsbPackage.ROUTER_MEDIATOR: return createRouterMediator();
			case EsbPackage.ROUTER_ROUTE: return createRouterRoute();
			case EsbPackage.ROUTER_TARGET: return createRouterTarget();
			case EsbPackage.ROUTER_MEDIATOR_INPUT_CONNECTOR: return createRouterMediatorInputConnector();
			case EsbPackage.ROUTER_MEDIATOR_OUTPUT_CONNECTOR: return createRouterMediatorOutputConnector();
			case EsbPackage.ROUTER_MEDIATOR_TARGET_OUTPUT_CONNECTOR: return createRouterMediatorTargetOutputConnector();
			case EsbPackage.ROUTER_MEDIATOR_CONTAINER: return createRouterMediatorContainer();
			case EsbPackage.ROUTER_TARGET_CONTAINER: return createRouterTargetContainer();
			case EsbPackage.CLONE_MEDIATOR: return createCloneMediator();
			case EsbPackage.CLONE_TARGET: return createCloneTarget();
			case EsbPackage.CLONE_MEDIATOR_INPUT_CONNECTOR: return createCloneMediatorInputConnector();
			case EsbPackage.CLONE_MEDIATOR_OUTPUT_CONNECTOR: return createCloneMediatorOutputConnector();
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR: return createCloneMediatorTargetOutputConnector();
			case EsbPackage.CLONE_MEDIATOR_CONTAINER: return createCloneMediatorContainer();
			case EsbPackage.CLONE_TARGET_CONTAINER: return createCloneTargetContainer();
			case EsbPackage.FOR_EACH_MEDIATOR: return createForEachMediator();
			case EsbPackage.FOR_EACH_MEDIATOR_INPUT_CONNECTOR: return createForEachMediatorInputConnector();
			case EsbPackage.FOR_EACH_MEDIATOR_OUTPUT_CONNECTOR: return createForEachMediatorOutputConnector();
			case EsbPackage.FOR_EACH_MEDIATOR_TARGET_OUTPUT_CONNECTOR: return createForEachMediatorTargetOutputConnector();
			case EsbPackage.FOR_EACH_TARGET: return createForEachTarget();
			case EsbPackage.ITERATE_MEDIATOR: return createIterateMediator();
			case EsbPackage.ITERATE_MEDIATOR_INPUT_CONNECTOR: return createIterateMediatorInputConnector();
			case EsbPackage.ITERATE_MEDIATOR_OUTPUT_CONNECTOR: return createIterateMediatorOutputConnector();
			case EsbPackage.ITERATE_MEDIATOR_TARGET_OUTPUT_CONNECTOR: return createIterateMediatorTargetOutputConnector();
			case EsbPackage.ITERATE_TARGET: return createIterateTarget();
			case EsbPackage.ABSTRACT_COMMON_TARGET: return createAbstractCommonTarget();
			case EsbPackage.MEDIATOR_SEQUENCE: return createMediatorSequence();
			case EsbPackage.CACHE_MEDIATOR: return createCacheMediator();
			case EsbPackage.CACHE_MEDIATOR_INPUT_CONNECTOR: return createCacheMediatorInputConnector();
			case EsbPackage.CACHE_MEDIATOR_OUTPUT_CONNECTOR: return createCacheMediatorOutputConnector();
			case EsbPackage.CACHE_MEDIATOR_ON_HIT_OUTPUT_CONNECTOR: return createCacheMediatorOnHitOutputConnector();
			case EsbPackage.CACHE_ON_HIT_BRANCH: return createCacheOnHitBranch();
			case EsbPackage.XQUERY_MEDIATOR: return createXQueryMediator();
			case EsbPackage.XQUERY_MEDIATOR_INPUT_CONNECTOR: return createXQueryMediatorInputConnector();
			case EsbPackage.XQUERY_MEDIATOR_OUTPUT_CONNECTOR: return createXQueryMediatorOutputConnector();
			case EsbPackage.XQUERY_VARIABLE: return createXQueryVariable();
			case EsbPackage.CALLOUT_MEDIATOR: return createCalloutMediator();
			case EsbPackage.CALLOUT_MEDIATOR_INPUT_CONNECTOR: return createCalloutMediatorInputConnector();
			case EsbPackage.CALLOUT_MEDIATOR_OUTPUT_CONNECTOR: return createCalloutMediatorOutputConnector();
			case EsbPackage.RM_SEQUENCE_MEDIATOR: return createRMSequenceMediator();
			case EsbPackage.RM_SEQUENCE_MEDIATOR_INPUT_CONNECTOR: return createRMSequenceMediatorInputConnector();
			case EsbPackage.RM_SEQUENCE_MEDIATOR_OUTPUT_CONNECTOR: return createRMSequenceMediatorOutputConnector();
			case EsbPackage.TRANSACTION_MEDIATOR: return createTransactionMediator();
			case EsbPackage.TRANSACTION_MEDIATOR_INPUT_CONNECTOR: return createTransactionMediatorInputConnector();
			case EsbPackage.TRANSACTION_MEDIATOR_OUTPUT_CONNECTOR: return createTransactionMediatorOutputConnector();
			case EsbPackage.OAUTH_MEDIATOR: return createOAuthMediator();
			case EsbPackage.OAUTH_MEDIATOR_INPUT_CONNECTOR: return createOAuthMediatorInputConnector();
			case EsbPackage.OAUTH_MEDIATOR_OUTPUT_CONNECTOR: return createOAuthMediatorOutputConnector();
			case EsbPackage.AUTOSCALE_IN_MEDIATOR: return createAutoscaleInMediator();
			case EsbPackage.AUTOSCALE_OUT_MEDIATOR: return createAutoscaleOutMediator();
			case EsbPackage.HEADER_MEDIATOR: return createHeaderMediator();
			case EsbPackage.HEADER_MEDIATOR_INPUT_CONNECTOR: return createHeaderMediatorInputConnector();
			case EsbPackage.HEADER_MEDIATOR_OUTPUT_CONNECTOR: return createHeaderMediatorOutputConnector();
			case EsbPackage.THROTTLE_MEDIATOR: return createThrottleMediator();
			case EsbPackage.THROTTLE_MEDIATOR_INPUT_CONNECTOR: return createThrottleMediatorInputConnector();
			case EsbPackage.THROTTLE_MEDIATOR_OUTPUT_CONNECTOR: return createThrottleMediatorOutputConnector();
			case EsbPackage.THROTTLE_MEDIATOR_ON_ACCEPT_OUTPUT_CONNECTOR: return createThrottleMediatorOnAcceptOutputConnector();
			case EsbPackage.THROTTLE_MEDIATOR_ON_REJECT_OUTPUT_CONNECTOR: return createThrottleMediatorOnRejectOutputConnector();
			case EsbPackage.THROTTLE_POLICY_CONFIGURATION: return createThrottlePolicyConfiguration();
			case EsbPackage.THROTTLE_POLICY_ENTRY: return createThrottlePolicyEntry();
			case EsbPackage.THROTTLE_ON_ACCEPT_BRANCH: return createThrottleOnAcceptBranch();
			case EsbPackage.THROTTLE_ON_REJECT_BRANCH: return createThrottleOnRejectBranch();
			case EsbPackage.THROTTLE_CONTAINER: return createThrottleContainer();
			case EsbPackage.THROTTLE_ON_ACCEPT_CONTAINER: return createThrottleOnAcceptContainer();
			case EsbPackage.THROTTLE_ON_REJECT_CONTAINER: return createThrottleOnRejectContainer();
			case EsbPackage.COMMAND_MEDIATOR: return createCommandMediator();
			case EsbPackage.COMMAND_MEDIATOR_INPUT_CONNECTOR: return createCommandMediatorInputConnector();
			case EsbPackage.COMMAND_MEDIATOR_OUTPUT_CONNECTOR: return createCommandMediatorOutputConnector();
			case EsbPackage.COMMAND_PROPERTY: return createCommandProperty();
			case EsbPackage.SQL_STATEMENT: return createSqlStatement();
			case EsbPackage.SQL_PARAMETER_DEFINITION: return createSqlParameterDefinition();
			case EsbPackage.SQL_RESULT_MAPPING: return createSqlResultMapping();
			case EsbPackage.DB_LOOKUP_MEDIATOR: return createDBLookupMediator();
			case EsbPackage.DB_LOOKUP_MEDIATOR_INPUT_CONNECTOR: return createDBLookupMediatorInputConnector();
			case EsbPackage.DB_LOOKUP_MEDIATOR_OUTPUT_CONNECTOR: return createDBLookupMediatorOutputConnector();
			case EsbPackage.DB_REPORT_MEDIATOR: return createDBReportMediator();
			case EsbPackage.DB_REPORT_MEDIATOR_INPUT_CONNECTOR: return createDBReportMediatorInputConnector();
			case EsbPackage.DB_REPORT_MEDIATOR_OUTPUT_CONNECTOR: return createDBReportMediatorOutputConnector();
			case EsbPackage.RULE_MEDIATOR: return createRuleMediator();
			case EsbPackage.RULE_MEDIATOR_INPUT_CONNECTOR: return createRuleMediatorInputConnector();
			case EsbPackage.RULE_MEDIATOR_OUTPUT_CONNECTOR: return createRuleMediatorOutputConnector();
			case EsbPackage.RULE_MEDIATOR_CHILD_MEDIATORS_OUTPUT_CONNECTOR: return createRuleMediatorChildMediatorsOutputConnector();
			case EsbPackage.RULE_SET_CREATION_PROPERTY: return createRuleSetCreationProperty();
			case EsbPackage.RULE_SESSION_PROPERTY: return createRuleSessionProperty();
			case EsbPackage.RULE_FACTS_CONFIGURATION: return createRuleFactsConfiguration();
			case EsbPackage.RULE_FACT: return createRuleFact();
			case EsbPackage.RULE_RESULTS_CONFIGURATION: return createRuleResultsConfiguration();
			case EsbPackage.RULE_RESULT: return createRuleResult();
			case EsbPackage.RULE_CHILD_MEDIATORS_CONFIGURATION: return createRuleChildMediatorsConfiguration();
			case EsbPackage.CALL_TEMPLATE_PARAMETER: return createCallTemplateParameter();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR: return createCallTemplateMediator();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR_INPUT_CONNECTOR: return createCallTemplateMediatorInputConnector();
			case EsbPackage.CALL_TEMPLATE_MEDIATOR_OUTPUT_CONNECTOR: return createCallTemplateMediatorOutputConnector();
			case EsbPackage.LOOP_BACK_MEDIATOR: return createLoopBackMediator();
			case EsbPackage.LOOP_BACK_MEDIATOR_INPUT_CONNECTOR: return createLoopBackMediatorInputConnector();
			case EsbPackage.LOOP_BACK_MEDIATOR_OUTPUT_CONNECTOR: return createLoopBackMediatorOutputConnector();
			case EsbPackage.RESPOND_MEDIATOR: return createRespondMediator();
			case EsbPackage.RESPOND_MEDIATOR_INPUT_CONNECTOR: return createRespondMediatorInputConnector();
			case EsbPackage.RESPOND_MEDIATOR_OUTPUT_CONNECTOR: return createRespondMediatorOutputConnector();
			case EsbPackage.SMOOKS_MEDIATOR: return createSmooksMediator();
			case EsbPackage.SMOOKS_MEDIATOR_INPUT_CONNECTOR: return createSmooksMediatorInputConnector();
			case EsbPackage.SMOOKS_MEDIATOR_OUTPUT_CONNECTOR: return createSmooksMediatorOutputConnector();
			case EsbPackage.STORE_MEDIATOR: return createStoreMediator();
			case EsbPackage.STORE_MEDIATOR_INPUT_CONNECTOR: return createStoreMediatorInputConnector();
			case EsbPackage.STORE_MEDIATOR_OUTPUT_CONNECTOR: return createStoreMediatorOutputConnector();
			case EsbPackage.BUILDER_MEDIATOR: return createBuilderMediator();
			case EsbPackage.BUILDER_MEDIATOR_INPUT_CONNECTOR: return createBuilderMediatorInputConnector();
			case EsbPackage.BUILDER_MEDIATOR_OUTPUT_CONECTOR: return createBuilderMediatorOutputConector();
			case EsbPackage.MESSAGE_BUILDER: return createMessageBuilder();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR: return createPayloadFactoryMediator();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR_INPUT_CONNECTOR: return createPayloadFactoryMediatorInputConnector();
			case EsbPackage.PAYLOAD_FACTORY_MEDIATOR_OUTPUT_CONNECTOR: return createPayloadFactoryMediatorOutputConnector();
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT: return createPayloadFactoryArgument();
			case EsbPackage.CONDITIONAL_ROUTE_BRANCH: return createConditionalRouteBranch();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR: return createConditionalRouterMediator();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR_INPUT_CONNECTOR: return createConditionalRouterMediatorInputConnector();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR_OUTPUT_CONNECTOR: return createConditionalRouterMediatorOutputConnector();
			case EsbPackage.CONDITIONAL_ROUTER_MEDIATOR_ADDITIONAL_OUTPUT_CONNECTOR: return createConditionalRouterMediatorAdditionalOutputConnector();
			case EsbPackage.SEND_MEDIATOR: return createSendMediator();
			case EsbPackage.SEND_CONTAINER: return createSendContainer();
			case EsbPackage.SEND_MEDIATOR_INPUT_CONNECTOR: return createSendMediatorInputConnector();
			case EsbPackage.SEND_MEDIATOR_OUTPUT_CONNECTOR: return createSendMediatorOutputConnector();
			case EsbPackage.SEND_MEDIATOR_ENDPOINT_OUTPUT_CONNECTOR: return createSendMediatorEndpointOutputConnector();
			case EsbPackage.FAILOVER_END_POINT: return createFailoverEndPoint();
			case EsbPackage.FAILOVER_END_POINT_INPUT_CONNECTOR: return createFailoverEndPointInputConnector();
			case EsbPackage.FAILOVER_END_POINT_OUTPUT_CONNECTOR: return createFailoverEndPointOutputConnector();
			case EsbPackage.FAILOVER_END_POINT_WEST_OUTPUT_CONNECTOR: return createFailoverEndPointWestOutputConnector();
			case EsbPackage.PARENT_END_POINT: return createParentEndPoint();
			case EsbPackage.WSDL_END_POINT: return createWSDLEndPoint();
			case EsbPackage.WSDL_END_POINT_INPUT_CONNECTOR: return createWSDLEndPointInputConnector();
			case EsbPackage.WSDL_END_POINT_OUTPUT_CONNECTOR: return createWSDLEndPointOutputConnector();
			case EsbPackage.LOAD_BALANCE_END_POINT: return createLoadBalanceEndPoint();
			case EsbPackage.MEMBER: return createMember();
			case EsbPackage.LOAD_BALANCE_END_POINT_INPUT_CONNECTOR: return createLoadBalanceEndPointInputConnector();
			case EsbPackage.LOAD_BALANCE_END_POINT_OUTPUT_CONNECTOR: return createLoadBalanceEndPointOutputConnector();
			case EsbPackage.LOAD_BALANCE_END_POINT_WEST_OUTPUT_CONNECTOR: return createLoadBalanceEndPointWestOutputConnector();
			case EsbPackage.LOCAL_ENTRY: return createLocalEntry();
			case EsbPackage.SESSION: return createSession();
			case EsbPackage.SEQUENCES: return createSequences();
			case EsbPackage.SEQUENCES_OUTPUT_CONNECTOR: return createSequencesOutputConnector();
			case EsbPackage.SEQUENCES_INPUT_CONNECTOR: return createSequencesInputConnector();
			case EsbPackage.URL_REWRITE_RULE_ACTION: return createURLRewriteRuleAction();
			case EsbPackage.URL_REWRITE_RULE: return createURLRewriteRule();
			case EsbPackage.URL_REWRITE_MEDIATOR: return createURLRewriteMediator();
			case EsbPackage.URL_REWRITE_MEDIATOR_INPUT_CONNECTOR: return createURLRewriteMediatorInputConnector();
			case EsbPackage.URL_REWRITE_MEDIATOR_OUTPUT_CONNECTOR: return createURLRewriteMediatorOutputConnector();
			case EsbPackage.EVALUATOR_EXPRESSION_PROPERTY: return createEvaluatorExpressionProperty();
			case EsbPackage.VALIDATE_MEDIATOR: return createValidateMediator();
			case EsbPackage.VALIDATE_RESOURCE: return createValidateResource();
			case EsbPackage.VALIDATE_FEATURE: return createValidateFeature();
			case EsbPackage.VALIDATE_SCHEMA: return createValidateSchema();
			case EsbPackage.VALIDATE_MEDIATOR_INPUT_CONNECTOR: return createValidateMediatorInputConnector();
			case EsbPackage.VALIDATE_MEDIATOR_OUTPUT_CONNECTOR: return createValidateMediatorOutputConnector();
			case EsbPackage.VALIDATE_MEDIATOR_ON_FAIL_OUTPUT_CONNECTOR: return createValidateMediatorOnFailOutputConnector();
			case EsbPackage.ENDPOINT_DIAGRAM: return createEndpointDiagram();
			case EsbPackage.NAMED_ENDPOINT: return createNamedEndpoint();
			case EsbPackage.NAMED_ENDPOINT_INPUT_CONNECTOR: return createNamedEndpointInputConnector();
			case EsbPackage.NAMED_ENDPOINT_OUTPUT_CONNECTOR: return createNamedEndpointOutputConnector();
			case EsbPackage.TEMPLATE: return createTemplate();
			case EsbPackage.TEMPLATE_PARAMETER: return createTemplateParameter();
			case EsbPackage.TASK: return createTask();
			case EsbPackage.NAME_VALUE_TYPE_PROPERTY: return createNameValueTypeProperty();
			case EsbPackage.TASK_PROPERTY: return createTaskProperty();
			case EsbPackage.SYNAPSE_API: return createSynapseAPI();
			case EsbPackage.API_RESOURCE: return createAPIResource();
			case EsbPackage.API_RESOURCE_INPUT_CONNECTOR: return createAPIResourceInputConnector();
			case EsbPackage.API_RESOURCE_OUTPUT_CONNECTOR: return createAPIResourceOutputConnector();
			case EsbPackage.API_RESOURCE_OUT_SEQUENCE_OUTPUT_CONNECTOR: return createAPIResourceOutSequenceOutputConnector();
			case EsbPackage.API_RESOURCE_IN_SEQUENCE_INPUT_CONNECTOR: return createAPIResourceInSequenceInputConnector();
			case EsbPackage.API_RESOURCE_FAULT_INPUT_CONNECTOR: return createAPIResourceFaultInputConnector();
			case EsbPackage.API_RESOURCE_ENDPOINT: return createAPIResourceEndpoint();
			case EsbPackage.API_RESOURCE_ENDPOINT_INPUT_CONNECTOR: return createAPIResourceEndpointInputConnector();
			case EsbPackage.API_RESOURCE_ENDPOINT_OUTPUT_CONNECTOR: return createAPIResourceEndpointOutputConnector();
			case EsbPackage.COMPLEX_ENDPOINTS: return createComplexEndpoints();
			case EsbPackage.COMPLEX_ENDPOINTS_OUTPUT_CONNECTOR: return createComplexEndpointsOutputConnector();
			case EsbPackage.ADDRESSING_ENDPOINT: return createAddressingEndpoint();
			case EsbPackage.ADDRESSING_ENDPOINT_INPUT_CONNECTOR: return createAddressingEndpointInputConnector();
			case EsbPackage.ADDRESSING_ENDPOINT_OUTPUT_CONNECTOR: return createAddressingEndpointOutputConnector();
			case EsbPackage.RECIPIENT_LIST_END_POINT: return createRecipientListEndPoint();
			case EsbPackage.RECIPIENT_LIST_END_POINT_INPUT_CONNECTOR: return createRecipientListEndPointInputConnector();
			case EsbPackage.RECIPIENT_LIST_END_POINT_OUTPUT_CONNECTOR: return createRecipientListEndPointOutputConnector();
			case EsbPackage.RECIPIENT_LIST_END_POINT_WEST_OUTPUT_CONNECTOR: return createRecipientListEndPointWestOutputConnector();
			case EsbPackage.MESSAGE_STORE_PARAMETER: return createMessageStoreParameter();
			case EsbPackage.MESSAGE_STORE: return createMessageStore();
			case EsbPackage.MESSAGE_PROCESSOR_PARAMETER: return createMessageProcessorParameter();
			case EsbPackage.MESSAGE_PROCESSOR: return createMessageProcessor();
			case EsbPackage.API_HANDLER: return createAPIHandler();
			case EsbPackage.API_HANDLER_PROPERTY: return createAPIHandlerProperty();
			case EsbPackage.CLOUD_CONNECTOR: return createCloudConnector();
			case EsbPackage.CLOUD_CONNECTOR_INPUT_CONNECTOR: return createCloudConnectorInputConnector();
			case EsbPackage.CLOUD_CONNECTOR_OUTPUT_CONNECTOR: return createCloudConnectorOutputConnector();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION: return createCloudConnectorOperation();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION_INPUT_CONNECTOR: return createCloudConnectorOperationInputConnector();
			case EsbPackage.CLOUD_CONNECTOR_OPERATION_OUTPUT_CONNECTOR: return createCloudConnectorOperationOutputConnector();
			case EsbPackage.DATA_MAPPER_MEDIATOR: return createDataMapperMediator();
			case EsbPackage.DATA_MAPPER_MEDIATOR_INPUT_CONNECTOR: return createDataMapperMediatorInputConnector();
			case EsbPackage.DATA_MAPPER_MEDIATOR_OUTPUT_CONNECTOR: return createDataMapperMediatorOutputConnector();
			case EsbPackage.FAST_XSLT_MEDIATOR: return createFastXSLTMediator();
			case EsbPackage.FAST_XSLT_MEDIATOR_INPUT_CONNECTOR: return createFastXSLTMediatorInputConnector();
			case EsbPackage.FAST_XSLT_MEDIATOR_OUTPUT_CONNECTOR: return createFastXSLTMediatorOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT: return createInboundEndpoint();
			case EsbPackage.INBOUND_ENDPOINT_PARAMETER: return createInboundEndpointParameter();
			case EsbPackage.INBOUND_ENDPOINT_CONTAINER: return createInboundEndpointContainer();
			case EsbPackage.INBOUND_ENDPOINT_SEQUENCE_CONTAINER: return createInboundEndpointSequenceContainer();
			case EsbPackage.INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_CONTAINER: return createInboundEndpointOnErrorSequenceContainer();
			case EsbPackage.INBOUND_ENDPOINT_SEQUENCE_INPUT_CONNECTOR: return createInboundEndpointSequenceInputConnector();
			case EsbPackage.INBOUND_ENDPOINT_SEQUENCE_OUTPUT_CONNECTOR: return createInboundEndpointSequenceOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_OUTPUT_CONNECTOR: return createInboundEndpointOnErrorSequenceOutputConnector();
			case EsbPackage.INBOUND_ENDPOINT_ON_ERROR_SEQUENCE_INPUT_CONNECTOR: return createInboundEndpointOnErrorSequenceInputConnector();
			case EsbPackage.COMMENT_MEDIATOR: return createCommentMediator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EsbPackage.ARTIFACT_TYPE:
				return createArtifactTypeFromString(eDataType, initialValue);
			case EsbPackage.CALL_MEDIATOR_ENDPOINT_TYPE:
				return createCallMediatorEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_PROPERTY_SCOPE:
				return createEndPointPropertyScopeFromString(eDataType, initialValue);
			case EsbPackage.SEQUENCE_TYPE:
				return createSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.PROXY_WSDL_TYPE:
				return createProxyWsdlTypeFromString(eDataType, initialValue);
			case EsbPackage.HTTP_METHOD_TYPE:
				return createHttpMethodTypeFromString(eDataType, initialValue);
			case EsbPackage.FILTER_MEDIATOR_CONDITION_TYPE:
				return createFilterMediatorConditionTypeFromString(eDataType, initialValue);
			case EsbPackage.LOG_CATEGORY:
				return createLogCategoryFromString(eDataType, initialValue);
			case EsbPackage.LOG_LEVEL:
				return createLogLevelFromString(eDataType, initialValue);
			case EsbPackage.ATTRIBUTE_VALUE_TYPE:
				return createAttributeValueTypeFromString(eDataType, initialValue);
			case EsbPackage.ATTRIBUTE_TYPE:
				return createAttributeTypeFromString(eDataType, initialValue);
			case EsbPackage.BEAN_MEDIATOR_ACTION:
				return createBeanMediatorActionFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_ADDRESSING_VERSION:
				return createEndPointAddressingVersionFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_TIME_OUT_ACTION:
				return createEndPointTimeOutActionFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_MESSAGE_FORMAT:
				return createEndPointMessageFormatFromString(eDataType, initialValue);
			case EsbPackage.END_POINT_ATTACHMENT_OPTIMIZATION:
				return createEndPointAttachmentOptimizationFromString(eDataType, initialValue);
			case EsbPackage.PROPERTY_DATA_TYPE:
				return createPropertyDataTypeFromString(eDataType, initialValue);
			case EsbPackage.PROPERTY_ACTION:
				return createPropertyActionFromString(eDataType, initialValue);
			case EsbPackage.PROPERTY_SCOPE:
				return createPropertyScopeFromString(eDataType, initialValue);
			case EsbPackage.PROPERTY_VALUE_TYPE:
				return createPropertyValueTypeFromString(eDataType, initialValue);
			case EsbPackage.PROPERTY_NAME:
				return createPropertyNameFromString(eDataType, initialValue);
			case EsbPackage.ENRICH_SOURCE_INLINE_TYPE:
				return createEnrichSourceInlineTypeFromString(eDataType, initialValue);
			case EsbPackage.ENRICH_SOURCE_TYPE:
				return createEnrichSourceTypeFromString(eDataType, initialValue);
			case EsbPackage.ENRICH_TARGET_ACTION:
				return createEnrichTargetActionFromString(eDataType, initialValue);
			case EsbPackage.ENRICH_TARGET_TYPE:
				return createEnrichTargetTypeFromString(eDataType, initialValue);
			case EsbPackage.EVENT_TOPIC_TYPE:
				return createEventTopicTypeFromString(eDataType, initialValue);
			case EsbPackage.ENTITLEMENT_CALLBACK_HANDLER:
				return createEntitlementCallbackHandlerFromString(eDataType, initialValue);
			case EsbPackage.ENTITLEMENT_CLIENT_TYPE:
				return createEntitlementClientTypeFromString(eDataType, initialValue);
			case EsbPackage.ENTITLEMENT_SEQUENCE_TYPE:
				return createEntitlementSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.SCRIPT_KEY_TYPE_ENUM:
				return createscriptKeyTypeEnumFromString(eDataType, initialValue);
			case EsbPackage.SCRIPT_TYPE:
				return createScriptTypeFromString(eDataType, initialValue);
			case EsbPackage.SCRIPT_LANGUAGE:
				return createScriptLanguageFromString(eDataType, initialValue);
			case EsbPackage.FAULT_SOAP_VERSION:
				return createFaultSoapVersionFromString(eDataType, initialValue);
			case EsbPackage.FAULT_CODE_SOAP11:
				return createFaultCodeSoap11FromString(eDataType, initialValue);
			case EsbPackage.FAULT_CODE_SOAP12:
				return createFaultCodeSoap12FromString(eDataType, initialValue);
			case EsbPackage.FAULT_CODE_TYPE:
				return createFaultCodeTypeFromString(eDataType, initialValue);
			case EsbPackage.FAULT_STRING_TYPE:
				return createFaultStringTypeFromString(eDataType, initialValue);
			case EsbPackage.FAULT_REASON_TYPE:
				return createFaultReasonTypeFromString(eDataType, initialValue);
			case EsbPackage.FAULT_DETAIL_TYPE:
				return createFaultDetailTypeFromString(eDataType, initialValue);
			case EsbPackage.COMPLETION_MESSAGES_TYPE:
				return createCompletionMessagesTypeFromString(eDataType, initialValue);
			case EsbPackage.AGGREGATE_SEQUENCE_TYPE:
				return createAggregateSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.TARGET_SEQUENCE_TYPE:
				return createTargetSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.TARGET_ENDPOINT_TYPE:
				return createTargetEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.CACHE_SEQUENCE_TYPE:
				return createCacheSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.CACHE_IMPLEMENTATION_TYPE:
				return createCacheImplementationTypeFromString(eDataType, initialValue);
			case EsbPackage.CACHE_ACTION:
				return createCacheActionFromString(eDataType, initialValue);
			case EsbPackage.CACHE_SCOPE:
				return createCacheScopeFromString(eDataType, initialValue);
			case EsbPackage.XQUERY_VARIABLE_TYPE:
				return createXQueryVariableTypeFromString(eDataType, initialValue);
			case EsbPackage.XQUERY_VARIABLE_VALUE_TYPE:
				return createXQueryVariableValueTypeFromString(eDataType, initialValue);
			case EsbPackage.CALLOUT_ENDPOINT_TYPE:
				return createCalloutEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.CALLOUT_PAYLOAD_TYPE:
				return createCalloutPayloadTypeFromString(eDataType, initialValue);
			case EsbPackage.CALLOUT_SECURITY_POLICIES:
				return createCalloutSecurityPoliciesFromString(eDataType, initialValue);
			case EsbPackage.CALLOUT_SECURITY_TYPE:
				return createCalloutSecurityTypeFromString(eDataType, initialValue);
			case EsbPackage.CALLOUT_RESULT_TYPE:
				return createCalloutResultTypeFromString(eDataType, initialValue);
			case EsbPackage.RM_SPEC_VERSION:
				return createRMSpecVersionFromString(eDataType, initialValue);
			case EsbPackage.RM_SEQUENCE_TYPE:
				return createRMSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.TRANSACTION_ACTION:
				return createTransactionActionFromString(eDataType, initialValue);
			case EsbPackage.HEADER_ACTION:
				return createHeaderActionFromString(eDataType, initialValue);
			case EsbPackage.HEADER_VALUE_TYPE:
				return createHeaderValueTypeFromString(eDataType, initialValue);
			case EsbPackage.SCOPE_TYPE:
				return createScopeTypeFromString(eDataType, initialValue);
			case EsbPackage.THROTTLE_POLICY_TYPE:
				return createThrottlePolicyTypeFromString(eDataType, initialValue);
			case EsbPackage.THROTTLE_CONDITION_TYPE:
				return createThrottleConditionTypeFromString(eDataType, initialValue);
			case EsbPackage.THROTTLE_ACCESS_TYPE:
				return createThrottleAccessTypeFromString(eDataType, initialValue);
			case EsbPackage.THROTTLE_SEQUENCE_TYPE:
				return createThrottleSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.COMMAND_PROPERTY_VALUE_TYPE:
				return createCommandPropertyValueTypeFromString(eDataType, initialValue);
			case EsbPackage.COMMAND_PROPERTY_MESSAGE_ACTION:
				return createCommandPropertyMessageActionFromString(eDataType, initialValue);
			case EsbPackage.COMMAND_PROPERTY_CONTEXT_ACTION:
				return createCommandPropertyContextActionFromString(eDataType, initialValue);
			case EsbPackage.SQL_EXECUTOR_CONNECTION_TYPE:
				return createSqlExecutorConnectionTypeFromString(eDataType, initialValue);
			case EsbPackage.SQL_EXECUTOR_DATASOURCE_TYPE:
				return createSqlExecutorDatasourceTypeFromString(eDataType, initialValue);
			case EsbPackage.SQL_EXECUTOR_BOOLEAN_VALUE:
				return createSqlExecutorBooleanValueFromString(eDataType, initialValue);
			case EsbPackage.SQL_EXECUTOR_ISOLATION_LEVEL:
				return createSqlExecutorIsolationLevelFromString(eDataType, initialValue);
			case EsbPackage.SQL_PARAMETER_VALUE_TYPE:
				return createSqlParameterValueTypeFromString(eDataType, initialValue);
			case EsbPackage.SQL_PARAMETER_DATA_TYPE:
				return createSqlParameterDataTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_ACTIONS:
				return createRuleActionsFromString(eDataType, initialValue);
			case EsbPackage.RULE_TYPE:
				return createRuleTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_SOURCE_TYPE:
				return createRuleSourceTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_FACT_TYPE:
				return createRuleFactTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_FACT_VALUE_TYPE:
				return createRuleFactValueTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_RESULT_TYPE:
				return createRuleResultTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_RESULT_VALUE_TYPE:
				return createRuleResultValueTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_OPTION_TYPE:
				return createRuleOptionTypeFromString(eDataType, initialValue);
			case EsbPackage.SMOOKS_IO_DATA_TYPE:
				return createSmooksIODataTypeFromString(eDataType, initialValue);
			case EsbPackage.SMOOKS_OUTPUT_DATA_TYPE:
				return createSmooksOutputDataTypeFromString(eDataType, initialValue);
			case EsbPackage.EXPRESSION_ACTION:
				return createExpressionActionFromString(eDataType, initialValue);
			case EsbPackage.OUTPUT_METHOD:
				return createOutputMethodFromString(eDataType, initialValue);
			case EsbPackage.RECEIVING_SEQUENCE_TYPE:
				return createReceivingSequenceTypeFromString(eDataType, initialValue);
			case EsbPackage.KEY_TYPE:
				return createKeyTypeFromString(eDataType, initialValue);
			case EsbPackage.MEDIA_TYPE:
				return createMediaTypeFromString(eDataType, initialValue);
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT_TYPE:
				return createPayloadFactoryArgumentTypeFromString(eDataType, initialValue);
			case EsbPackage.PAYLOAD_FORMAT_TYPE:
				return createPayloadFormatTypeFromString(eDataType, initialValue);
			case EsbPackage.TYPE:
				return createTypeFromString(eDataType, initialValue);
			case EsbPackage.LOAD_BALANCE_SESSION_TYPE:
				return createLoadBalanceSessionTypeFromString(eDataType, initialValue);
			case EsbPackage.LOCAL_ENTRY_VALUE_TYPE:
				return createLocalEntryValueTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_ACTION_TYPE:
				return createRuleActionTypeFromString(eDataType, initialValue);
			case EsbPackage.RULE_FRAGMENT_TYPE:
				return createRuleFragmentTypeFromString(eDataType, initialValue);
			case EsbPackage.TEMPLATE_TYPE:
				return createTemplateTypeFromString(eDataType, initialValue);
			case EsbPackage.TASK_PROPERTY_TYPE:
				return createTaskPropertyTypeFromString(eDataType, initialValue);
			case EsbPackage.TASK_TRIGGER_TYPE:
				return createTaskTriggerTypeFromString(eDataType, initialValue);
			case EsbPackage.API_RESOURCE_URL_STYLE:
				return createApiResourceUrlStyleFromString(eDataType, initialValue);
			case EsbPackage.RECIPIENT_LIST_ENDPOINT_TYPE:
				return createRecipientListEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.MESSAGE_STORE_TYPE:
				return createMessageStoreTypeFromString(eDataType, initialValue);
			case EsbPackage.JMS_SPEC_VERSION:
				return createJMSSpecVersionFromString(eDataType, initialValue);
			case EsbPackage.JDBC_CONNECTION_INFORMATION_TYPE:
				return createJDBCConnectionInformationTypeFromString(eDataType, initialValue);
			case EsbPackage.MESSAGE_PROCESSOR_TYPE:
				return createMessageProcessorTypeFromString(eDataType, initialValue);
			case EsbPackage.PROCESSOR_STATE:
				return createProcessorStateFromString(eDataType, initialValue);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION_PARAM_EDITOR_TYPE:
				return createCloudConnectorOperationParamEditorTypeFromString(eDataType, initialValue);
			case EsbPackage.DATA_MAPPER_MEDIATOR_DATA_TYPES:
				return createDataMapperMediatorDataTypesFromString(eDataType, initialValue);
			case EsbPackage.PROTOCOL:
				return createProtocolFromString(eDataType, initialValue);
			case EsbPackage.INBOUND_ENDPOINT_TYPE:
				return createInboundEndpointTypeFromString(eDataType, initialValue);
			case EsbPackage.INBOUND_ENDPOINT_BEHAVIOUR_TYPE:
				return createInboundEndpointBehaviourTypeFromString(eDataType, initialValue);
			case EsbPackage.CONTENT_TYPE:
				return createContentTypeFromString(eDataType, initialValue);
			case EsbPackage.TOPICS_TYPE:
				return createTopicsTypeFromString(eDataType, initialValue);
			case EsbPackage.TOPIC_FILTER_FROM_TYPE:
				return createTopicFilterFromTypeFromString(eDataType, initialValue);
			case EsbPackage.CONSUMER_TYPE:
				return createConsumerTypeFromString(eDataType, initialValue);
			case EsbPackage.AUTO_OFFSET_RESET_TYPE:
				return createAutoOffsetResetTypeFromString(eDataType, initialValue);
			case EsbPackage.PARTITION_ASSIGNMENT_STRATEGY_TYPE:
				return createPartitionAssignmentStrategyTypeFromString(eDataType, initialValue);
			case EsbPackage.OFFSETS_STORAGE_TYPE:
				return createOffsetsStorageTypeFromString(eDataType, initialValue);
			case EsbPackage.ENABLE:
				return createEnableFromString(eDataType, initialValue);
			case EsbPackage.VFS_ACTION:
				return createVFSActionFromString(eDataType, initialValue);
			case EsbPackage.VFS_FILE_SORT:
				return createVFSFileSortFromString(eDataType, initialValue);
			case EsbPackage.JMS_CONNECTION_FACTORY_TYPE:
				return createJMSConnectionFactoryTypeFromString(eDataType, initialValue);
			case EsbPackage.JMS_SESSION_ACKNOWLEDGEMENT:
				return createJMSSessionAcknowledgementFromString(eDataType, initialValue);
			case EsbPackage.JMS_CACHE_LEVEL:
				return createJMSCacheLevelFromString(eDataType, initialValue);
			case EsbPackage.MQTT_SUBSCRIPTION_QOS:
				return createMQTTSubscriptionQOSFromString(eDataType, initialValue);
			case EsbPackage.FEED_TYPE:
				return createFeedTypeFromString(eDataType, initialValue);
			case EsbPackage.ENABLE_DISABLE_STATE:
				return createEnableDisableStateFromString(eDataType, initialValue);
			case EsbPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EsbPackage.ARTIFACT_TYPE:
				return convertArtifactTypeToString(eDataType, instanceValue);
			case EsbPackage.CALL_MEDIATOR_ENDPOINT_TYPE:
				return convertCallMediatorEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_PROPERTY_SCOPE:
				return convertEndPointPropertyScopeToString(eDataType, instanceValue);
			case EsbPackage.SEQUENCE_TYPE:
				return convertSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.PROXY_WSDL_TYPE:
				return convertProxyWsdlTypeToString(eDataType, instanceValue);
			case EsbPackage.HTTP_METHOD_TYPE:
				return convertHttpMethodTypeToString(eDataType, instanceValue);
			case EsbPackage.FILTER_MEDIATOR_CONDITION_TYPE:
				return convertFilterMediatorConditionTypeToString(eDataType, instanceValue);
			case EsbPackage.LOG_CATEGORY:
				return convertLogCategoryToString(eDataType, instanceValue);
			case EsbPackage.LOG_LEVEL:
				return convertLogLevelToString(eDataType, instanceValue);
			case EsbPackage.ATTRIBUTE_VALUE_TYPE:
				return convertAttributeValueTypeToString(eDataType, instanceValue);
			case EsbPackage.ATTRIBUTE_TYPE:
				return convertAttributeTypeToString(eDataType, instanceValue);
			case EsbPackage.BEAN_MEDIATOR_ACTION:
				return convertBeanMediatorActionToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_ADDRESSING_VERSION:
				return convertEndPointAddressingVersionToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_TIME_OUT_ACTION:
				return convertEndPointTimeOutActionToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_MESSAGE_FORMAT:
				return convertEndPointMessageFormatToString(eDataType, instanceValue);
			case EsbPackage.END_POINT_ATTACHMENT_OPTIMIZATION:
				return convertEndPointAttachmentOptimizationToString(eDataType, instanceValue);
			case EsbPackage.PROPERTY_DATA_TYPE:
				return convertPropertyDataTypeToString(eDataType, instanceValue);
			case EsbPackage.PROPERTY_ACTION:
				return convertPropertyActionToString(eDataType, instanceValue);
			case EsbPackage.PROPERTY_SCOPE:
				return convertPropertyScopeToString(eDataType, instanceValue);
			case EsbPackage.PROPERTY_VALUE_TYPE:
				return convertPropertyValueTypeToString(eDataType, instanceValue);
			case EsbPackage.PROPERTY_NAME:
				return convertPropertyNameToString(eDataType, instanceValue);
			case EsbPackage.ENRICH_SOURCE_INLINE_TYPE:
				return convertEnrichSourceInlineTypeToString(eDataType, instanceValue);
			case EsbPackage.ENRICH_SOURCE_TYPE:
				return convertEnrichSourceTypeToString(eDataType, instanceValue);
			case EsbPackage.ENRICH_TARGET_ACTION:
				return convertEnrichTargetActionToString(eDataType, instanceValue);
			case EsbPackage.ENRICH_TARGET_TYPE:
				return convertEnrichTargetTypeToString(eDataType, instanceValue);
			case EsbPackage.EVENT_TOPIC_TYPE:
				return convertEventTopicTypeToString(eDataType, instanceValue);
			case EsbPackage.ENTITLEMENT_CALLBACK_HANDLER:
				return convertEntitlementCallbackHandlerToString(eDataType, instanceValue);
			case EsbPackage.ENTITLEMENT_CLIENT_TYPE:
				return convertEntitlementClientTypeToString(eDataType, instanceValue);
			case EsbPackage.ENTITLEMENT_SEQUENCE_TYPE:
				return convertEntitlementSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.SCRIPT_KEY_TYPE_ENUM:
				return convertscriptKeyTypeEnumToString(eDataType, instanceValue);
			case EsbPackage.SCRIPT_TYPE:
				return convertScriptTypeToString(eDataType, instanceValue);
			case EsbPackage.SCRIPT_LANGUAGE:
				return convertScriptLanguageToString(eDataType, instanceValue);
			case EsbPackage.FAULT_SOAP_VERSION:
				return convertFaultSoapVersionToString(eDataType, instanceValue);
			case EsbPackage.FAULT_CODE_SOAP11:
				return convertFaultCodeSoap11ToString(eDataType, instanceValue);
			case EsbPackage.FAULT_CODE_SOAP12:
				return convertFaultCodeSoap12ToString(eDataType, instanceValue);
			case EsbPackage.FAULT_CODE_TYPE:
				return convertFaultCodeTypeToString(eDataType, instanceValue);
			case EsbPackage.FAULT_STRING_TYPE:
				return convertFaultStringTypeToString(eDataType, instanceValue);
			case EsbPackage.FAULT_REASON_TYPE:
				return convertFaultReasonTypeToString(eDataType, instanceValue);
			case EsbPackage.FAULT_DETAIL_TYPE:
				return convertFaultDetailTypeToString(eDataType, instanceValue);
			case EsbPackage.COMPLETION_MESSAGES_TYPE:
				return convertCompletionMessagesTypeToString(eDataType, instanceValue);
			case EsbPackage.AGGREGATE_SEQUENCE_TYPE:
				return convertAggregateSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.TARGET_SEQUENCE_TYPE:
				return convertTargetSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.TARGET_ENDPOINT_TYPE:
				return convertTargetEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.CACHE_SEQUENCE_TYPE:
				return convertCacheSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.CACHE_IMPLEMENTATION_TYPE:
				return convertCacheImplementationTypeToString(eDataType, instanceValue);
			case EsbPackage.CACHE_ACTION:
				return convertCacheActionToString(eDataType, instanceValue);
			case EsbPackage.CACHE_SCOPE:
				return convertCacheScopeToString(eDataType, instanceValue);
			case EsbPackage.XQUERY_VARIABLE_TYPE:
				return convertXQueryVariableTypeToString(eDataType, instanceValue);
			case EsbPackage.XQUERY_VARIABLE_VALUE_TYPE:
				return convertXQueryVariableValueTypeToString(eDataType, instanceValue);
			case EsbPackage.CALLOUT_ENDPOINT_TYPE:
				return convertCalloutEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.CALLOUT_PAYLOAD_TYPE:
				return convertCalloutPayloadTypeToString(eDataType, instanceValue);
			case EsbPackage.CALLOUT_SECURITY_POLICIES:
				return convertCalloutSecurityPoliciesToString(eDataType, instanceValue);
			case EsbPackage.CALLOUT_SECURITY_TYPE:
				return convertCalloutSecurityTypeToString(eDataType, instanceValue);
			case EsbPackage.CALLOUT_RESULT_TYPE:
				return convertCalloutResultTypeToString(eDataType, instanceValue);
			case EsbPackage.RM_SPEC_VERSION:
				return convertRMSpecVersionToString(eDataType, instanceValue);
			case EsbPackage.RM_SEQUENCE_TYPE:
				return convertRMSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.TRANSACTION_ACTION:
				return convertTransactionActionToString(eDataType, instanceValue);
			case EsbPackage.HEADER_ACTION:
				return convertHeaderActionToString(eDataType, instanceValue);
			case EsbPackage.HEADER_VALUE_TYPE:
				return convertHeaderValueTypeToString(eDataType, instanceValue);
			case EsbPackage.SCOPE_TYPE:
				return convertScopeTypeToString(eDataType, instanceValue);
			case EsbPackage.THROTTLE_POLICY_TYPE:
				return convertThrottlePolicyTypeToString(eDataType, instanceValue);
			case EsbPackage.THROTTLE_CONDITION_TYPE:
				return convertThrottleConditionTypeToString(eDataType, instanceValue);
			case EsbPackage.THROTTLE_ACCESS_TYPE:
				return convertThrottleAccessTypeToString(eDataType, instanceValue);
			case EsbPackage.THROTTLE_SEQUENCE_TYPE:
				return convertThrottleSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.COMMAND_PROPERTY_VALUE_TYPE:
				return convertCommandPropertyValueTypeToString(eDataType, instanceValue);
			case EsbPackage.COMMAND_PROPERTY_MESSAGE_ACTION:
				return convertCommandPropertyMessageActionToString(eDataType, instanceValue);
			case EsbPackage.COMMAND_PROPERTY_CONTEXT_ACTION:
				return convertCommandPropertyContextActionToString(eDataType, instanceValue);
			case EsbPackage.SQL_EXECUTOR_CONNECTION_TYPE:
				return convertSqlExecutorConnectionTypeToString(eDataType, instanceValue);
			case EsbPackage.SQL_EXECUTOR_DATASOURCE_TYPE:
				return convertSqlExecutorDatasourceTypeToString(eDataType, instanceValue);
			case EsbPackage.SQL_EXECUTOR_BOOLEAN_VALUE:
				return convertSqlExecutorBooleanValueToString(eDataType, instanceValue);
			case EsbPackage.SQL_EXECUTOR_ISOLATION_LEVEL:
				return convertSqlExecutorIsolationLevelToString(eDataType, instanceValue);
			case EsbPackage.SQL_PARAMETER_VALUE_TYPE:
				return convertSqlParameterValueTypeToString(eDataType, instanceValue);
			case EsbPackage.SQL_PARAMETER_DATA_TYPE:
				return convertSqlParameterDataTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_ACTIONS:
				return convertRuleActionsToString(eDataType, instanceValue);
			case EsbPackage.RULE_TYPE:
				return convertRuleTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_SOURCE_TYPE:
				return convertRuleSourceTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_FACT_TYPE:
				return convertRuleFactTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_FACT_VALUE_TYPE:
				return convertRuleFactValueTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_RESULT_TYPE:
				return convertRuleResultTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_RESULT_VALUE_TYPE:
				return convertRuleResultValueTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_OPTION_TYPE:
				return convertRuleOptionTypeToString(eDataType, instanceValue);
			case EsbPackage.SMOOKS_IO_DATA_TYPE:
				return convertSmooksIODataTypeToString(eDataType, instanceValue);
			case EsbPackage.SMOOKS_OUTPUT_DATA_TYPE:
				return convertSmooksOutputDataTypeToString(eDataType, instanceValue);
			case EsbPackage.EXPRESSION_ACTION:
				return convertExpressionActionToString(eDataType, instanceValue);
			case EsbPackage.OUTPUT_METHOD:
				return convertOutputMethodToString(eDataType, instanceValue);
			case EsbPackage.RECEIVING_SEQUENCE_TYPE:
				return convertReceivingSequenceTypeToString(eDataType, instanceValue);
			case EsbPackage.KEY_TYPE:
				return convertKeyTypeToString(eDataType, instanceValue);
			case EsbPackage.MEDIA_TYPE:
				return convertMediaTypeToString(eDataType, instanceValue);
			case EsbPackage.PAYLOAD_FACTORY_ARGUMENT_TYPE:
				return convertPayloadFactoryArgumentTypeToString(eDataType, instanceValue);
			case EsbPackage.PAYLOAD_FORMAT_TYPE:
				return convertPayloadFormatTypeToString(eDataType, instanceValue);
			case EsbPackage.TYPE:
				return convertTypeToString(eDataType, instanceValue);
			case EsbPackage.LOAD_BALANCE_SESSION_TYPE:
				return convertLoadBalanceSessionTypeToString(eDataType, instanceValue);
			case EsbPackage.LOCAL_ENTRY_VALUE_TYPE:
				return convertLocalEntryValueTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_ACTION_TYPE:
				return convertRuleActionTypeToString(eDataType, instanceValue);
			case EsbPackage.RULE_FRAGMENT_TYPE:
				return convertRuleFragmentTypeToString(eDataType, instanceValue);
			case EsbPackage.TEMPLATE_TYPE:
				return convertTemplateTypeToString(eDataType, instanceValue);
			case EsbPackage.TASK_PROPERTY_TYPE:
				return convertTaskPropertyTypeToString(eDataType, instanceValue);
			case EsbPackage.TASK_TRIGGER_TYPE:
				return convertTaskTriggerTypeToString(eDataType, instanceValue);
			case EsbPackage.API_RESOURCE_URL_STYLE:
				return convertApiResourceUrlStyleToString(eDataType, instanceValue);
			case EsbPackage.RECIPIENT_LIST_ENDPOINT_TYPE:
				return convertRecipientListEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.MESSAGE_STORE_TYPE:
				return convertMessageStoreTypeToString(eDataType, instanceValue);
			case EsbPackage.JMS_SPEC_VERSION:
				return convertJMSSpecVersionToString(eDataType, instanceValue);
			case EsbPackage.JDBC_CONNECTION_INFORMATION_TYPE:
				return convertJDBCConnectionInformationTypeToString(eDataType, instanceValue);
			case EsbPackage.MESSAGE_PROCESSOR_TYPE:
				return convertMessageProcessorTypeToString(eDataType, instanceValue);
			case EsbPackage.PROCESSOR_STATE:
				return convertProcessorStateToString(eDataType, instanceValue);
			case EsbPackage.CLOUD_CONNECTOR_OPERATION_PARAM_EDITOR_TYPE:
				return convertCloudConnectorOperationParamEditorTypeToString(eDataType, instanceValue);
			case EsbPackage.DATA_MAPPER_MEDIATOR_DATA_TYPES:
				return convertDataMapperMediatorDataTypesToString(eDataType, instanceValue);
			case EsbPackage.PROTOCOL:
				return convertProtocolToString(eDataType, instanceValue);
			case EsbPackage.INBOUND_ENDPOINT_TYPE:
				return convertInboundEndpointTypeToString(eDataType, instanceValue);
			case EsbPackage.INBOUND_ENDPOINT_BEHAVIOUR_TYPE:
				return convertInboundEndpointBehaviourTypeToString(eDataType, instanceValue);
			case EsbPackage.CONTENT_TYPE:
				return convertContentTypeToString(eDataType, instanceValue);
			case EsbPackage.TOPICS_TYPE:
				return convertTopicsTypeToString(eDataType, instanceValue);
			case EsbPackage.TOPIC_FILTER_FROM_TYPE:
				return convertTopicFilterFromTypeToString(eDataType, instanceValue);
			case EsbPackage.CONSUMER_TYPE:
				return convertConsumerTypeToString(eDataType, instanceValue);
			case EsbPackage.AUTO_OFFSET_RESET_TYPE:
				return convertAutoOffsetResetTypeToString(eDataType, instanceValue);
			case EsbPackage.PARTITION_ASSIGNMENT_STRATEGY_TYPE:
				return convertPartitionAssignmentStrategyTypeToString(eDataType, instanceValue);
			case EsbPackage.OFFSETS_STORAGE_TYPE:
				return convertOffsetsStorageTypeToString(eDataType, instanceValue);
			case EsbPackage.ENABLE:
				return convertEnableToString(eDataType, instanceValue);
			case EsbPackage.VFS_ACTION:
				return convertVFSActionToString(eDataType, instanceValue);
			case EsbPackage.VFS_FILE_SORT:
				return convertVFSFileSortToString(eDataType, instanceValue);
			case EsbPackage.JMS_CONNECTION_FACTORY_TYPE:
				return convertJMSConnectionFactoryTypeToString(eDataType, instanceValue);
			case EsbPackage.JMS_SESSION_ACKNOWLEDGEMENT:
				return convertJMSSessionAcknowledgementToString(eDataType, instanceValue);
			case EsbPackage.JMS_CACHE_LEVEL:
				return convertJMSCacheLevelToString(eDataType, instanceValue);
			case EsbPackage.MQTT_SUBSCRIPTION_QOS:
				return convertMQTTSubscriptionQOSToString(eDataType, instanceValue);
			case EsbPackage.FEED_TYPE:
				return convertFeedTypeToString(eDataType, instanceValue);
			case EsbPackage.ENABLE_DISABLE_STATE:
				return convertEnableDisableStateToString(eDataType, instanceValue);
			case EsbPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EsbDiagram createEsbDiagram() {
		EsbDiagramImpl esbDiagram = new EsbDiagramImpl();
		EsbServerImpl esbServer = new EsbServerImpl();
		esbDiagram.setServer(esbServer);
		return esbDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbServer createEsbServer() {
		EsbServerImpl esbServer = new EsbServerImpl();
		return esbServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbLink createEsbLink() {
		EsbLinkImpl esbLink = new EsbLinkImpl();
		return esbLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CallMediator createCallMediator() {
		CallMediatorImpl callMediator = new CallMediatorImpl();
		callMediator.setInputConnector(createCallMediatorInputConnector());
		callMediator.setOutputConnector(createCallMediatorOutputConnector());
		callMediator.setEndpointOutputConnector(createCallMediatorEndpointOutputConnector());
		callMediator.setMediatorFlow(createMediatorFlow());
		return callMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorInputConnector createCallMediatorInputConnector() {
		CallMediatorInputConnectorImpl callMediatorInputConnector = new CallMediatorInputConnectorImpl();
		return callMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorOutputConnector createCallMediatorOutputConnector() {
		CallMediatorOutputConnectorImpl callMediatorOutputConnector = new CallMediatorOutputConnectorImpl();
		return callMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorEndpointOutputConnector createCallMediatorEndpointOutputConnector() {
		CallMediatorEndpointOutputConnectorImpl callMediatorEndpointOutputConnector = new CallMediatorEndpointOutputConnectorImpl();
		return callMediatorEndpointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointProperty createEndPointProperty() {
		EndPointPropertyImpl endPointProperty = new EndPointPropertyImpl();
		return endPointProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProxyService createProxyService() {
		proxyservicecount++;
		ProxyServiceImpl proxyService = new ProxyServiceImpl();
		proxyService.setOutputConnector(createProxyOutputConnector());
		proxyService.setInputConnector(createProxyInputConnector());
		proxyService.setOutSequenceOutputConnector(createProxyOutSequenceOutputConnector());
		proxyService.setFaultInputConnector(createProxyFaultInputConnector());
		proxyService.setContainer(createProxyServiceContainer());
		//proxyService.setName("proxy" +proxyservicecount);
		return proxyService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyOutputConnector createProxyOutputConnector() {
		ProxyOutputConnectorImpl proxyOutputConnector = new ProxyOutputConnectorImpl();
		return proxyOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyInputConnector createProxyInputConnector() {
		ProxyInputConnectorImpl proxyInputConnector = new ProxyInputConnectorImpl();
		return proxyInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyOutSequenceOutputConnector createProxyOutSequenceOutputConnector() {
		ProxyOutSequenceOutputConnectorImpl proxyOutSequenceOutputConnector = new ProxyOutSequenceOutputConnectorImpl();
		return proxyOutSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyInSequenceInputConnector createProxyInSequenceInputConnector() {
		ProxyInSequenceInputConnectorImpl proxyInSequenceInputConnector = new ProxyInSequenceInputConnectorImpl();
		return proxyInSequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyWSDLResource createProxyWSDLResource() {
		ProxyWSDLResourceImpl proxyWSDLResource = new ProxyWSDLResourceImpl();
		return proxyWSDLResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyFaultInputConnector createProxyFaultInputConnector() {
		ProxyFaultInputConnectorImpl proxyFaultInputConnector = new ProxyFaultInputConnectorImpl();
		return proxyFaultInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServiceParameter createProxyServiceParameter() {
		ProxyServiceParameterImpl proxyServiceParameter = new ProxyServiceParameterImpl();
		return proxyServiceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServicePolicy createProxyServicePolicy() {
		ProxyServicePolicyImpl proxyServicePolicy = new ProxyServicePolicyImpl();
		return proxyServicePolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProxyServiceSequenceAndEndpointContainer createProxyServiceSequenceAndEndpointContainer() {
		ProxyServiceSequenceAndEndpointContainerImpl proxyServiceSequenceAndEndpointContainer = new ProxyServiceSequenceAndEndpointContainerImpl();
		proxyServiceSequenceAndEndpointContainer.setMediatorFlow(createMediatorFlow());
		return proxyServiceSequenceAndEndpointContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProxyServiceFaultContainer createProxyServiceFaultContainer() {
		ProxyServiceFaultContainerImpl proxyServiceFaultContainer = new ProxyServiceFaultContainerImpl();
		proxyServiceFaultContainer.setMediatorFlow(createMediatorFlow());
		return proxyServiceFaultContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProxyServiceContainer createProxyServiceContainer() {
		ProxyServiceContainerImpl proxyServiceContainer = new ProxyServiceContainerImpl();
		proxyServiceContainer.setSequenceAndEndpointContainer(createProxyServiceSequenceAndEndpointContainer());
		proxyServiceContainer.setFaultContainer(createProxyServiceFaultContainer());
		return proxyServiceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorFlow createMediatorFlow() {
		MediatorFlowImpl mediatorFlow = new MediatorFlowImpl();
		return mediatorFlow;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EndpointFlow createEndpointFlow() {
		EndpointFlowImpl endpointFlow = new EndpointFlowImpl();
		return endpointFlow;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MessageMediator createMessageMediator() {
		MessageMediatorImpl messageMediator = new MessageMediatorImpl();
		messageMediator.setInputConnector(createMessageInputConnector());
		messageMediator.setOutputConnector(createMessageOutputConnector());
		return messageMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageInputConnector createMessageInputConnector() {
		MessageInputConnectorImpl messageInputConnector = new MessageInputConnectorImpl();
		return messageInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageOutputConnector createMessageOutputConnector() {
		MessageOutputConnectorImpl messageOutputConnector = new MessageOutputConnectorImpl();
		return messageOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DefaultEndPoint createDefaultEndPoint() {
		DefaultEndPointImpl defaultEndPoint = new DefaultEndPointImpl();
		defaultEndPoint.setInputConnector(createDefaultEndPointInputConnector());
		return defaultEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultEndPointInputConnector createDefaultEndPointInputConnector() {
		DefaultEndPointInputConnectorImpl defaultEndPointInputConnector = new DefaultEndPointInputConnectorImpl();
		return defaultEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultEndPointOutputConnector createDefaultEndPointOutputConnector() {
		DefaultEndPointOutputConnectorImpl defaultEndPointOutputConnector = new DefaultEndPointOutputConnectorImpl();
		return defaultEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DropMediator createDropMediator() {
		DropMediatorImpl dropMediator = new DropMediatorImpl();
		dropMediator.setInputConnector(createDropMediatorInputConnector());
		return dropMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DropMediatorInputConnector createDropMediatorInputConnector() {
		DropMediatorInputConnectorImpl dropMediatorInputConnector = new DropMediatorInputConnectorImpl();
		return dropMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FilterMediator createFilterMediator() {
		FilterMediatorImpl filterMediator = new FilterMediatorImpl();
		filterMediator.setInputConnector(createFilterMediatorInputConnector());
		filterMediator.setOutputConnector(createFilterMediatorOutputConnector());
		filterMediator.setPassOutputConnector(createFilterMediatorPassOutputConnector());
		filterMediator.setFailOutputConnector(createFilterMediatorFailOutputConnector());
		filterMediator.setFilterContainer(createFilterContainer());
		return filterMediator;
	}

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FilterContainer createFilterContainer() {
        FilterContainerImpl filterContainer = new FilterContainerImpl();
        filterContainer.setPassContainer(createFilterPassContainer());
        filterContainer.setFailContainer(createFilterFailContainer());
        return filterContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FilterPassContainer createFilterPassContainer() {
        FilterPassContainerImpl filterPassContainer = new FilterPassContainerImpl();
        filterPassContainer.setMediatorFlow(createMediatorFlow());
        return filterPassContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public FilterFailContainer createFilterFailContainer() {
        FilterFailContainerImpl filterFailContainer = new FilterFailContainerImpl();
        filterFailContainer.setMediatorFlow(createMediatorFlow());
        return filterFailContainer;
    }

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorInputConnector createFilterMediatorInputConnector() {
		FilterMediatorInputConnectorImpl filterMediatorInputConnector = new FilterMediatorInputConnectorImpl();
		return filterMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public FilterMediatorOutputConnector createFilterMediatorOutputConnector() {
		FilterMediatorOutputConnectorImpl filterMediatorOutputConnector = new FilterMediatorOutputConnectorImpl();
		return filterMediatorOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorPassOutputConnector createFilterMediatorPassOutputConnector() {
		FilterMediatorPassOutputConnectorImpl filterMediatorPassOutputConnector = new FilterMediatorPassOutputConnectorImpl();
		return filterMediatorPassOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorFailOutputConnector createFilterMediatorFailOutputConnector() {
		FilterMediatorFailOutputConnectorImpl filterMediatorFailOutputConnector = new FilterMediatorFailOutputConnectorImpl();
		return filterMediatorFailOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MergeNode createMergeNode() {
		MergeNodeImpl mergeNode = new MergeNodeImpl();
		mergeNode.setFirstInputConnector(createMergeNodeFirstInputConnector());
		mergeNode.setSecondInputConnector(createMergeNodeSecondInputConnector());
		mergeNode.setOutputConnector(createMergeNodeOutputConnector());
		return mergeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNodeFirstInputConnector createMergeNodeFirstInputConnector() {
		MergeNodeFirstInputConnectorImpl mergeNodeFirstInputConnector = new MergeNodeFirstInputConnectorImpl();
		return mergeNodeFirstInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNodeSecondInputConnector createMergeNodeSecondInputConnector() {
		MergeNodeSecondInputConnectorImpl mergeNodeSecondInputConnector = new MergeNodeSecondInputConnectorImpl();
		return mergeNodeSecondInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNodeOutputConnector createMergeNodeOutputConnector() {
		MergeNodeOutputConnectorImpl mergeNodeOutputConnector = new MergeNodeOutputConnectorImpl();
		return mergeNodeOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LogMediator createLogMediator() {
		LogMediatorImpl logMediator = new LogMediatorImpl();
		logMediator.setInputConnector(createLogMediatorInputConnector());
		logMediator.setOutputConnector(createLogMediatorOutputConnector());
		return logMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMediatorInputConnector createLogMediatorInputConnector() {
		LogMediatorInputConnectorImpl logMediatorInputConnector = new LogMediatorInputConnectorImpl();
		return logMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMediatorOutputConnector createLogMediatorOutputConnector() {
		LogMediatorOutputConnectorImpl logMediatorOutputConnector = new LogMediatorOutputConnectorImpl();
		return logMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LogProperty createLogProperty() {
		LogPropertyImpl logProperty = new LogPropertyImpl();
		NamespacedProperty namespacedProperty = createNamespacedProperty();
		namespacedProperty.setPrettyName("property expression");
		namespacedProperty.setPropertyName("expression");
		namespacedProperty.setPropertyValue("/default/expression");
		logProperty.setPropertyExpression(namespacedProperty);
		logProperty.setPropertyName("property_name");
		logProperty.setPropertyValue("property_value");
		return logProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PublishEventMediator createPublishEventMediator() {
		PublishEventMediatorImpl publishEventMediator = new PublishEventMediatorImpl();
		publishEventMediator.setInputConnector(createPublishEventMediatorInputConnector());
		publishEventMediator.setOutputconnector(createPublishEventMediatorOutputConnector());
		return publishEventMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMediatorInputConnector createPublishEventMediatorInputConnector() {
		PublishEventMediatorInputConnectorImpl publishEventMediatorInputConnector = new PublishEventMediatorInputConnectorImpl();
		return publishEventMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMediatorOutputConnector createPublishEventMediatorOutputConnector() {
		PublishEventMediatorOutputConnectorImpl publishEventMediatorOutputConnector = new PublishEventMediatorOutputConnectorImpl();
		return publishEventMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishEventMediatorAttribute createPublishEventMediatorAttribute() {
		PublishEventMediatorAttributeImpl publishEventMediatorAttribute = new PublishEventMediatorAttributeImpl();
		return publishEventMediatorAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BAMMediator createBAMMediator() {
		BAMMediatorImpl bamMediator = new BAMMediatorImpl();
		bamMediator.setInputConnector(createBAMMediatorInputConnector());
		bamMediator.setOutputConnector(createBAMMediatorOutputConnector());
		bamMediator.setServerProfile(BAM_MEDIATOR_DEFAULT_SERVER_PROFILE_NAME);
		bamMediator.setStreamName(BAM_MEDIATOR_DEFAULT_STREAM_NAME);
		bamMediator.setStreamVersion(BAM_MEDIATOR_DEFAULT_STREAM_VERSION);
		return bamMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAMMediatorInputConnector createBAMMediatorInputConnector() {
		BAMMediatorInputConnectorImpl bamMediatorInputConnector = new BAMMediatorInputConnectorImpl();
		return bamMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAMMediatorOutputConnector createBAMMediatorOutputConnector() {
		BAMMediatorOutputConnectorImpl bamMediatorOutputConnector = new BAMMediatorOutputConnectorImpl();
		return bamMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BeanMediator createBeanMediator() {
		BeanMediatorImpl beanMediator = new BeanMediatorImpl();
		beanMediator.setInputConnector(createBeanMediatorInputConnector());
		beanMediator.setOutputConnector(createBeanMediatorOutputConnector());
		return beanMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanMediatorInputConnector createBeanMediatorInputConnector() {
		BeanMediatorInputConnectorImpl beanMediatorInputConnector = new BeanMediatorInputConnectorImpl();
		return beanMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanMediatorOutputConnector createBeanMediatorOutputConnector() {
		BeanMediatorOutputConnectorImpl beanMediatorOutputConnector = new BeanMediatorOutputConnectorImpl();
		return beanMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EJBMediator createEJBMediator() {
		EJBMediatorImpl ejbMediator = new EJBMediatorImpl();
		ejbMediator.setInputConnector(createEJBMediatorInputConnector());
		ejbMediator.setOutputConnector(createEJBMediatorOutputConnector());
		return ejbMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EJBMediatorInputConnector createEJBMediatorInputConnector() {
		EJBMediatorInputConnectorImpl ejbMediatorInputConnector = new EJBMediatorInputConnectorImpl();
		return ejbMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EJBMediatorOutputConnector createEJBMediatorOutputConnector() {
		EJBMediatorOutputConnectorImpl ejbMediatorOutputConnector = new EJBMediatorOutputConnectorImpl();
		return ejbMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MethodArgument createMethodArgument() {
		MethodArgumentImpl methodArgument = new MethodArgumentImpl();
		NamespacedProperty namespacedProperty = createNamespacedProperty();
		namespacedProperty.setPrettyName("property expression");
		namespacedProperty.setPropertyName("expression");
		namespacedProperty.setPropertyValue("/default/expression");
		methodArgument.setPropertyExpression(namespacedProperty);
		methodArgument.setPropertyName("property_name");
		methodArgument.setPropertyValue("property_value");
		return methodArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AddressEndPoint createAddressEndPoint() {
		AddressEndPointImpl addressEndPoint = new AddressEndPointImpl();
		addressEndPoint.setInputConnector(createAddressEndPointInputConnector());
		return addressEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressEndPointInputConnector createAddressEndPointInputConnector() {
		AddressEndPointInputConnectorImpl addressEndPointInputConnector = new AddressEndPointInputConnectorImpl();
		return addressEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressEndPointOutputConnector createAddressEndPointOutputConnector() {
		AddressEndPointOutputConnectorImpl addressEndPointOutputConnector = new AddressEndPointOutputConnectorImpl();
		return addressEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TemplateEndpoint createTemplateEndpoint() {
		TemplateEndpointImpl templateEndpoint = new TemplateEndpointImpl();
		templateEndpoint.setInputConnector(createTemplateEndpointInputConnector());
		return templateEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateEndpointInputConnector createTemplateEndpointInputConnector() {
		TemplateEndpointInputConnectorImpl templateEndpointInputConnector = new TemplateEndpointInputConnectorImpl();
		return templateEndpointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateEndpointOutputConnector createTemplateEndpointOutputConnector() {
		TemplateEndpointOutputConnectorImpl templateEndpointOutputConnector = new TemplateEndpointOutputConnectorImpl();
		return templateEndpointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateEndpointParameter createTemplateEndpointParameter() {
		TemplateEndpointParameterImpl templateEndpointParameter = new TemplateEndpointParameterImpl();
		return templateEndpointParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public HTTPEndpoint createHTTPEndpoint() {
		HTTPEndpointImpl httpEndpoint = new HTTPEndpointImpl();
		httpEndpoint.setInputConnector(createHTTPEndPointInputConnector());
		return httpEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPEndPointInputConnector createHTTPEndPointInputConnector() {
		HTTPEndPointInputConnectorImpl httpEndPointInputConnector = new HTTPEndPointInputConnectorImpl();
		return httpEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPEndPointOutputConnector createHTTPEndPointOutputConnector() {
		HTTPEndPointOutputConnectorImpl httpEndPointOutputConnector = new HTTPEndPointOutputConnectorImpl();
		return httpEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty createRegistryKeyProperty() {
		RegistryKeyPropertyImpl registryKeyProperty = new RegistryKeyPropertyImpl();
		return registryKeyProperty;
	}
	
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyMediator createPropertyMediator() {
		PropertyMediatorImpl propertyMediator = new PropertyMediatorImpl();
		propertyMediator.setInputConnector(createPropertyMediatorInputConnector());
		propertyMediator.setOutputConnector(createPropertyMediatorOutputConnector());
		return propertyMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMediatorInputConnector createPropertyMediatorInputConnector() {
		PropertyMediatorInputConnectorImpl propertyMediatorInputConnector = new PropertyMediatorInputConnectorImpl();
		return propertyMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMediatorOutputConnector createPropertyMediatorOutputConnector() {
		PropertyMediatorOutputConnectorImpl propertyMediatorOutputConnector = new PropertyMediatorOutputConnectorImpl();
		return propertyMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		copy.setSupportsDynamicXPaths(namespacedProperty.isSupportsDynamicXPaths());
		copy.setDynamic(namespacedProperty.isDynamic());
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EnrichMediator createEnrichMediator() {
		EnrichMediatorImpl enrichMediator = new EnrichMediatorImpl();
		enrichMediator.setInputConnector(createEnrichMediatorInputConnector());
		enrichMediator.setOutputConnector(createEnrichMediatorOutputConnector());
		return enrichMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichMediatorInputConnector createEnrichMediatorInputConnector() {
		EnrichMediatorInputConnectorImpl enrichMediatorInputConnector = new EnrichMediatorInputConnectorImpl();
		return enrichMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichMediatorOutputConnector createEnrichMediatorOutputConnector() {
		EnrichMediatorOutputConnectorImpl enrichMediatorOutputConnector = new EnrichMediatorOutputConnectorImpl();
		return enrichMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XSLTMediator createXSLTMediator() {
		XSLTMediatorImpl xsltMediator = new XSLTMediatorImpl();
		xsltMediator.setInputConnector(createXSLTMediatorInputConnector());
		xsltMediator.setOutputConnector(createXSLTMediatorOutputConnector());
		return xsltMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTProperty createXSLTProperty() {
		XSLTPropertyImpl xsltProperty = new XSLTPropertyImpl();
		return xsltProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTFeature createXSLTFeature() {
		XSLTFeatureImpl xsltFeature = new XSLTFeatureImpl();
		return xsltFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTResource createXSLTResource() {
		XSLTResourceImpl xsltResource = new XSLTResourceImpl();
		return xsltResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTMediatorInputConnector createXSLTMediatorInputConnector() {
		XSLTMediatorInputConnectorImpl xsltMediatorInputConnector = new XSLTMediatorInputConnectorImpl();
		return xsltMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSLTMediatorOutputConnector createXSLTMediatorOutputConnector() {
		XSLTMediatorOutputConnectorImpl xsltMediatorOutputConnector = new XSLTMediatorOutputConnectorImpl();
		return xsltMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SwitchMediator createSwitchMediator() {
		SwitchMediatorImpl switchMediator = new SwitchMediatorImpl();
		switchMediator.setInputConnector(createSwitchMediatorInputConnector());
		switchMediator.setOutputConnector(createSwitchMediatorOutputConnector());
		switchMediator.setDefaultBranch(createSwitchDefaultBranchOutputConnector());
		switchMediator.setSwitchContainer(createSwitchMediatorContainer());
		return switchMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCaseBranchOutputConnector createSwitchCaseBranchOutputConnector() {
		SwitchCaseBranchOutputConnectorImpl switchCaseBranchOutputConnector = new SwitchCaseBranchOutputConnectorImpl();
		return switchCaseBranchOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchDefaultBranchOutputConnector createSwitchDefaultBranchOutputConnector() {
		SwitchDefaultBranchOutputConnectorImpl switchDefaultBranchOutputConnector = new SwitchDefaultBranchOutputConnectorImpl();
		return switchDefaultBranchOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchMediatorInputConnector createSwitchMediatorInputConnector() {
		SwitchMediatorInputConnectorImpl switchMediatorInputConnector = new SwitchMediatorInputConnectorImpl();
		return switchMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchMediatorOutputConnector createSwitchMediatorOutputConnector() {
		SwitchMediatorOutputConnectorImpl switchMediatorOutputConnector = new SwitchMediatorOutputConnectorImpl();
		return switchMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SwitchMediatorContainer createSwitchMediatorContainer() {
		SwitchMediatorContainerImpl switchMediatorContainer = new SwitchMediatorContainerImpl();
		switchMediatorContainer.setSwitchCaseParentContainer(createSwitchCaseParentContainer());
		switchMediatorContainer.setSwitchDefaultParentContainer(createSwitchDefaultParentContainer());
		return switchMediatorContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCaseParentContainer createSwitchCaseParentContainer() {
		SwitchCaseParentContainerImpl switchCaseParentContainer = new SwitchCaseParentContainerImpl();
		return switchCaseParentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SwitchDefaultParentContainer createSwitchDefaultParentContainer() {
		SwitchDefaultParentContainerImpl switchDefaultParentContainer = new SwitchDefaultParentContainerImpl();
		switchDefaultParentContainer.setSwitchDefaultContainer(createSwitchDefaultContainer());
		return switchDefaultParentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SwitchCaseContainer createSwitchCaseContainer() {
		SwitchCaseContainerImpl switchCaseContainer = new SwitchCaseContainerImpl();
		switchCaseContainer.setMediatorFlow(createMediatorFlow());
		return switchCaseContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SwitchDefaultContainer createSwitchDefaultContainer() {
		SwitchDefaultContainerImpl switchDefaultContainer = new SwitchDefaultContainerImpl();
		switchDefaultContainer.setMediatorFlow(createMediatorFlow());
		return switchDefaultContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SequenceDiagram createSequenceDiagram() {
		SequenceDiagramImpl sequenceDiagram = new SequenceDiagramImpl();
		sequenceDiagram.setSequence(createEsbSequence());
		return sequenceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EsbSequence createEsbSequence() {
		EsbSequenceImpl esbSequence = new EsbSequenceImpl();
		esbSequence.setInput(createEsbSequenceInputConnector());
		esbSequence.setOutput(createEsbSequenceOutputConnector());
		return esbSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceInput createEsbSequenceInput() {
		EsbSequenceInputImpl esbSequenceInput = new EsbSequenceInputImpl();
		return esbSequenceInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceOutput createEsbSequenceOutput() {
		EsbSequenceOutputImpl esbSequenceOutput = new EsbSequenceOutputImpl();
		return esbSequenceOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceInputConnector createEsbSequenceInputConnector() {
		EsbSequenceInputConnectorImpl esbSequenceInputConnector = new EsbSequenceInputConnectorImpl();
		return esbSequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbSequenceOutputConnector createEsbSequenceOutputConnector() {
		EsbSequenceOutputConnectorImpl esbSequenceOutputConnector = new EsbSequenceOutputConnectorImpl();
		return esbSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		sequence.setInputConnector(createSequenceInputConnector());		
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceInputConnector createSequenceInputConnector() {
		SequenceInputConnectorImpl sequenceInputConnector = new SequenceInputConnectorImpl();
		return sequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceOutputConnector createSequenceOutputConnector() {
		SequenceOutputConnectorImpl sequenceOutputConnector = new SequenceOutputConnectorImpl();
		return sequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventMediator createEventMediator() {
		EventMediatorImpl eventMediator = new EventMediatorImpl();
		eventMediator.setInputConnector(createEventMediatorInputConnector());
		eventMediator.setOutputConnector(createEventMediatorOutputConnector());
		return eventMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMediatorInputConnector createEventMediatorInputConnector() {
		EventMediatorInputConnectorImpl eventMediatorInputConnector = new EventMediatorInputConnectorImpl();
		return eventMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMediatorOutputConnector createEventMediatorOutputConnector() {
		EventMediatorOutputConnectorImpl eventMediatorOutputConnector = new EventMediatorOutputConnectorImpl();
		return eventMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntitlementMediator createEntitlementMediator() {
		EntitlementMediatorImpl entitlementMediator = new EntitlementMediatorImpl();
		entitlementMediator.setInputConnector(createEntitlementMediatorInputConnector());
		entitlementMediator.setOutputConnector(createEntitlementMediatorOutputConnector());
		entitlementMediator.setOnRejectOutputConnector(createEntitlementMediatorOnRejectOutputConnector());
		entitlementMediator.setOnAcceptOutputConnector(createEntitlementMediatorOnAcceptOutputConnector());
		entitlementMediator.setAdviceOutputConnector(createEntitlementMediatorAdviceOutputConnector());
		entitlementMediator.setObligationsOutputConnector(createEntitlementMediatorObligationsOutputConnector());
		entitlementMediator.setEntitlementContainer(createEntitlementContainer());
		return entitlementMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorInputConnector createEntitlementMediatorInputConnector() {
		EntitlementMediatorInputConnectorImpl entitlementMediatorInputConnector = new EntitlementMediatorInputConnectorImpl();
		return entitlementMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOutputConnector createEntitlementMediatorOutputConnector() {
		EntitlementMediatorOutputConnectorImpl entitlementMediatorOutputConnector = new EntitlementMediatorOutputConnectorImpl();
		return entitlementMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnRejectOutputConnector createEntitlementMediatorOnRejectOutputConnector() {
		EntitlementMediatorOnRejectOutputConnectorImpl entitlementMediatorOnRejectOutputConnector = new EntitlementMediatorOnRejectOutputConnectorImpl();
		return entitlementMediatorOnRejectOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnAcceptOutputConnector createEntitlementMediatorOnAcceptOutputConnector() {
		EntitlementMediatorOnAcceptOutputConnectorImpl entitlementMediatorOnAcceptOutputConnector = new EntitlementMediatorOnAcceptOutputConnectorImpl();
		return entitlementMediatorOnAcceptOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorAdviceOutputConnector createEntitlementMediatorAdviceOutputConnector() {
		EntitlementMediatorAdviceOutputConnectorImpl entitlementMediatorAdviceOutputConnector = new EntitlementMediatorAdviceOutputConnectorImpl();
		return entitlementMediatorAdviceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorObligationsOutputConnector createEntitlementMediatorObligationsOutputConnector() {
		EntitlementMediatorObligationsOutputConnectorImpl entitlementMediatorObligationsOutputConnector = new EntitlementMediatorObligationsOutputConnectorImpl();
		return entitlementMediatorObligationsOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntitlementContainer createEntitlementContainer() {
		EntitlementContainerImpl entitlementContainer = new EntitlementContainerImpl();
		entitlementContainer.setOnRejectContainer(createEntitlementOnRejectContainer());
		entitlementContainer.setOnAcceptContainer(createEntitlementOnAcceptContainer());
		entitlementContainer.setAdviceContainer(createEntitlementAdviceContainer());
		entitlementContainer.setObligationsContainer(createEntitlementObligationsContainer());
		return entitlementContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntitlementOnRejectContainer createEntitlementOnRejectContainer() {
		EntitlementOnRejectContainerImpl entitlementOnRejectContainer = new EntitlementOnRejectContainerImpl();
		entitlementOnRejectContainer.setMediatorFlow(createMediatorFlow());
		return entitlementOnRejectContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntitlementOnAcceptContainer createEntitlementOnAcceptContainer() {
		EntitlementOnAcceptContainerImpl entitlementOnAcceptContainer = new EntitlementOnAcceptContainerImpl();
		entitlementOnAcceptContainer.setMediatorFlow(createMediatorFlow());
		return entitlementOnAcceptContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntitlementAdviceContainer createEntitlementAdviceContainer() {
		EntitlementAdviceContainerImpl entitlementAdviceContainer = new EntitlementAdviceContainerImpl();
		entitlementAdviceContainer.setMediatorFlow(createMediatorFlow());
		return entitlementAdviceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EntitlementObligationsContainer createEntitlementObligationsContainer() {
		EntitlementObligationsContainerImpl entitlementObligationsContainer = new EntitlementObligationsContainerImpl();
		entitlementObligationsContainer.setMediatorFlow(createMediatorFlow());
		return entitlementObligationsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EnqueueMediator createEnqueueMediator() {
		EnqueueMediatorImpl enqueueMediator = new EnqueueMediatorImpl();
		enqueueMediator.setInputConnector(createEnqueueMediatorInputConnector());
		enqueueMediator.setOutputConnector(createEnqueueMediatorOutputConnector());
		return enqueueMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnqueueMediatorInputConnector createEnqueueMediatorInputConnector() {
		EnqueueMediatorInputConnectorImpl enqueueMediatorInputConnector = new EnqueueMediatorInputConnectorImpl();
		return enqueueMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnqueueMediatorOutputConnector createEnqueueMediatorOutputConnector() {
		EnqueueMediatorOutputConnectorImpl enqueueMediatorOutputConnector = new EnqueueMediatorOutputConnectorImpl();
		return enqueueMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ClassMediator createClassMediator() {
		ClassMediatorImpl classMediator = new ClassMediatorImpl();
		classMediator.setInputConnector(createClassMediatorInputConnector());
		classMediator.setOutputConnector(createClassMediatorOutputConnector());
		return classMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMediatorInputConnector createClassMediatorInputConnector() {
		ClassMediatorInputConnectorImpl classMediatorInputConnector = new ClassMediatorInputConnectorImpl();
		return classMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMediatorOutputConnector createClassMediatorOutputConnector() {
		ClassMediatorOutputConnectorImpl classMediatorOutputConnector = new ClassMediatorOutputConnectorImpl();
		return classMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassProperty createClassProperty() {
		ClassPropertyImpl classProperty = new ClassPropertyImpl();
		return classProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SpringMediator createSpringMediator() {
		SpringMediatorImpl springMediator = new SpringMediatorImpl();
		springMediator.setInputConnector(createSpringMediatorInputConnector());
		springMediator.setOutputConnector(createSpringMediatorOutputConnector());
		return springMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpringMediatorInputConnector createSpringMediatorInputConnector() {
		SpringMediatorInputConnectorImpl springMediatorInputConnector = new SpringMediatorInputConnectorImpl();
		return springMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpringMediatorOutputConnector createSpringMediatorOutputConnector() {
		SpringMediatorOutputConnectorImpl springMediatorOutputConnector = new SpringMediatorOutputConnectorImpl();
		return springMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ValidateMediator createValidateMediator() {
		ValidateMediatorImpl validateMediator = new ValidateMediatorImpl();
		validateMediator.setInputConnector(createValidateMediatorInputConnector());
		validateMediator.setOutputConnector(createValidateMediatorOutputConnector());
		validateMediator.setOnFailOutputConnector(createValidateMediatorOnFailOutputConnector());
		validateMediator.setMediatorFlow(createMediatorFlow());
		return validateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateResource createValidateResource() {
		ValidateResourceImpl validateResource = new ValidateResourceImpl();
		return validateResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateFeature createValidateFeature() {
		ValidateFeatureImpl validateFeature = new ValidateFeatureImpl();
		return validateFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateSchema createValidateSchema() {
		ValidateSchemaImpl validateSchema = new ValidateSchemaImpl();
		return validateSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorInputConnector createValidateMediatorInputConnector() {
		ValidateMediatorInputConnectorImpl validateMediatorInputConnector = new ValidateMediatorInputConnectorImpl();
		return validateMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorOutputConnector createValidateMediatorOutputConnector() {
		ValidateMediatorOutputConnectorImpl validateMediatorOutputConnector = new ValidateMediatorOutputConnectorImpl();
		return validateMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediatorOnFailOutputConnector createValidateMediatorOnFailOutputConnector() {
		ValidateMediatorOnFailOutputConnectorImpl validateMediatorOnFailOutputConnector = new ValidateMediatorOnFailOutputConnectorImpl();
		return validateMediatorOnFailOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndpointDiagram createEndpointDiagram() {
		EndpointDiagramImpl endpointDiagram = new EndpointDiagramImpl();
		return endpointDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedEndpoint createNamedEndpoint() {
		NamedEndpointImpl namedEndpoint = new NamedEndpointImpl();
		namedEndpoint.setInputConnector(createNamedEndpointInputConnector());
		return namedEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedEndpointInputConnector createNamedEndpointInputConnector() {
		NamedEndpointInputConnectorImpl namedEndpointInputConnector = new NamedEndpointInputConnectorImpl();
		return namedEndpointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedEndpointOutputConnector createNamedEndpointOutputConnector() {
		NamedEndpointOutputConnectorImpl namedEndpointOutputConnector = new NamedEndpointOutputConnectorImpl();
		return namedEndpointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template createTemplate() {
		TemplateImpl template = new TemplateImpl();
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameter createTemplateParameter() {
		TemplateParameterImpl templateParameter = new TemplateParameterImpl();
		return templateParameter;
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
	public NameValueTypeProperty createNameValueTypeProperty() {
		NameValueTypePropertyImpl nameValueTypeProperty = new NameValueTypePropertyImpl();
		return nameValueTypeProperty;
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
	public SynapseAPI createSynapseAPI() {
		SynapseAPIImpl synapseAPI = new SynapseAPIImpl();
		return synapseAPI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public APIResource createAPIResource() {
		APIResourceImpl apiResource = new APIResourceImpl();
		apiResource.setInputConnector(createAPIResourceInputConnector());
		apiResource.setOutputConnector(createAPIResourceOutputConnector());
		apiResource.setOutSequenceOutputConnector(createAPIResourceOutSequenceOutputConnector());
		apiResource.setFaultInputConnector(createAPIResourceFaultInputConnector());
		apiResource.setContainer(createProxyServiceContainer());
		return apiResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceInputConnector createAPIResourceInputConnector() {
		APIResourceInputConnectorImpl apiResourceInputConnector = new APIResourceInputConnectorImpl();
		return apiResourceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceOutputConnector createAPIResourceOutputConnector() {
		APIResourceOutputConnectorImpl apiResourceOutputConnector = new APIResourceOutputConnectorImpl();
		return apiResourceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceOutSequenceOutputConnector createAPIResourceOutSequenceOutputConnector() {
		APIResourceOutSequenceOutputConnectorImpl apiResourceOutSequenceOutputConnector = new APIResourceOutSequenceOutputConnectorImpl();
		return apiResourceOutSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceInSequenceInputConnector createAPIResourceInSequenceInputConnector() {
		APIResourceInSequenceInputConnectorImpl apiResourceInSequenceInputConnector = new APIResourceInSequenceInputConnectorImpl();
		return apiResourceInSequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceFaultInputConnector createAPIResourceFaultInputConnector() {
		APIResourceFaultInputConnectorImpl apiResourceFaultInputConnector = new APIResourceFaultInputConnectorImpl();
		return apiResourceFaultInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceEndpoint createAPIResourceEndpoint() {
		APIResourceEndpointImpl apiResourceEndpoint = new APIResourceEndpointImpl();
		return apiResourceEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceEndpointInputConnector createAPIResourceEndpointInputConnector() {
		APIResourceEndpointInputConnectorImpl apiResourceEndpointInputConnector = new APIResourceEndpointInputConnectorImpl();
		return apiResourceEndpointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceEndpointOutputConnector createAPIResourceEndpointOutputConnector() {
		APIResourceEndpointOutputConnectorImpl apiResourceEndpointOutputConnector = new APIResourceEndpointOutputConnectorImpl();
		return apiResourceEndpointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComplexEndpoints createComplexEndpoints() {
		ComplexEndpointsImpl complexEndpoints = new ComplexEndpointsImpl();
		complexEndpoints.setMediatorFlow(createMediatorFlow());
		return complexEndpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexEndpointsOutputConnector createComplexEndpointsOutputConnector() {
		ComplexEndpointsOutputConnectorImpl complexEndpointsOutputConnector = new ComplexEndpointsOutputConnectorImpl();
		return complexEndpointsOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AddressingEndpoint createAddressingEndpoint() {
		AddressingEndpointImpl addressingEndpoint = new AddressingEndpointImpl();
		addressingEndpoint.setInputConnector(createAddressingEndpointInputConnector());
		return addressingEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressingEndpointInputConnector createAddressingEndpointInputConnector() {
		AddressingEndpointInputConnectorImpl addressingEndpointInputConnector = new AddressingEndpointInputConnectorImpl();
		return addressingEndpointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressingEndpointOutputConnector createAddressingEndpointOutputConnector() {
		AddressingEndpointOutputConnectorImpl addressingEndpointOutputConnector = new AddressingEndpointOutputConnectorImpl();
		return addressingEndpointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RecipientListEndPoint createRecipientListEndPoint() {
		RecipientListEndPointImpl recipientListEndPoint = new RecipientListEndPointImpl();
		recipientListEndPoint.setInputConnector(createRecipientListEndPointInputConnector());
		recipientListEndPoint.setMediatorFlow(createMediatorFlow());
		return recipientListEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndPointInputConnector createRecipientListEndPointInputConnector() {
		RecipientListEndPointInputConnectorImpl recipientListEndPointInputConnector = new RecipientListEndPointInputConnectorImpl();
		return recipientListEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndPointOutputConnector createRecipientListEndPointOutputConnector() {
		RecipientListEndPointOutputConnectorImpl recipientListEndPointOutputConnector = new RecipientListEndPointOutputConnectorImpl();
		return recipientListEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndPointWestOutputConnector createRecipientListEndPointWestOutputConnector() {
		RecipientListEndPointWestOutputConnectorImpl recipientListEndPointWestOutputConnector = new RecipientListEndPointWestOutputConnectorImpl();
		return recipientListEndPointWestOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageStoreParameter createMessageStoreParameter() {
		MessageStoreParameterImpl messageStoreParameter = new MessageStoreParameterImpl();
		return messageStoreParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageStore createMessageStore() {
		MessageStoreImpl messageStore = new MessageStoreImpl();
		return messageStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageProcessorParameter createMessageProcessorParameter() {
		MessageProcessorParameterImpl messageProcessorParameter = new MessageProcessorParameterImpl();
		return messageProcessorParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageProcessor createMessageProcessor() {
		MessageProcessorImpl messageProcessor = new MessageProcessorImpl();
		return messageProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIHandler createAPIHandler() {
		APIHandlerImpl apiHandler = new APIHandlerImpl();
		return apiHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIHandlerProperty createAPIHandlerProperty() {
		APIHandlerPropertyImpl apiHandlerProperty = new APIHandlerPropertyImpl();
		return apiHandlerProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnector createCloudConnector() {
		CloudConnectorImpl cloudConnector = new CloudConnectorImpl();
		return cloudConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorInputConnector createCloudConnectorInputConnector() {
		CloudConnectorInputConnectorImpl cloudConnectorInputConnector = new CloudConnectorInputConnectorImpl();
		return cloudConnectorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOutputConnector createCloudConnectorOutputConnector() {
		CloudConnectorOutputConnectorImpl cloudConnectorOutputConnector = new CloudConnectorOutputConnectorImpl();
		return cloudConnectorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CloudConnectorOperation createCloudConnectorOperation() {
		CloudConnectorOperationImpl cloudConnectorOperation = new CloudConnectorOperationImpl();
		cloudConnectorOperation.setInputConnector(createCloudConnectorOperationInputConnector());
		cloudConnectorOperation.setOutputConnector(createCloudConnectorOperationOutputConnector());
		return cloudConnectorOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationInputConnector createCloudConnectorOperationInputConnector() {
		CloudConnectorOperationInputConnectorImpl cloudConnectorOperationInputConnector = new CloudConnectorOperationInputConnectorImpl();
		return cloudConnectorOperationInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationOutputConnector createCloudConnectorOperationOutputConnector() {
		CloudConnectorOperationOutputConnectorImpl cloudConnectorOperationOutputConnector = new CloudConnectorOperationOutputConnectorImpl();
		return cloudConnectorOperationOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataMapperMediator createDataMapperMediator() {
		DataMapperMediatorImpl dataMapperMediator = new DataMapperMediatorImpl();
		dataMapperMediator.setInputConnector(createDataMapperMediatorInputConnector());
		dataMapperMediator.setOutputConnector(createDataMapperMediatorOutputConnector());
		return dataMapperMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorInputConnector createDataMapperMediatorInputConnector() {
		DataMapperMediatorInputConnectorImpl dataMapperMediatorInputConnector = new DataMapperMediatorInputConnectorImpl();
		return dataMapperMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorOutputConnector createDataMapperMediatorOutputConnector() {
		DataMapperMediatorOutputConnectorImpl dataMapperMediatorOutputConnector = new DataMapperMediatorOutputConnectorImpl();
		return dataMapperMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FastXSLTMediator createFastXSLTMediator() {
		FastXSLTMediatorImpl fastXSLTMediator = new FastXSLTMediatorImpl();
		fastXSLTMediator.setInputConnector(createFastXSLTMediatorInputConnector());
		fastXSLTMediator.setOutputConnector(createFastXSLTMediatorOutputConnector());
		return fastXSLTMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastXSLTMediatorInputConnector createFastXSLTMediatorInputConnector() {
		FastXSLTMediatorInputConnectorImpl fastXSLTMediatorInputConnector = new FastXSLTMediatorInputConnectorImpl();
		return fastXSLTMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FastXSLTMediatorOutputConnector createFastXSLTMediatorOutputConnector() {
		FastXSLTMediatorOutputConnectorImpl fastXSLTMediatorOutputConnector = new FastXSLTMediatorOutputConnectorImpl();
		return fastXSLTMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InboundEndpoint createInboundEndpoint() {
		InboundEndpointImpl inboundEndpoint = new InboundEndpointImpl();
        inboundEndpoint.setSequenceInputConnector(createInboundEndpointSequenceInputConnector());
        inboundEndpoint.setSequenceOutputConnector(createInboundEndpointSequenceOutputConnector());
        inboundEndpoint.setOnErrorSequenceInputConnector(createInboundEndpointOnErrorSequenceInputConnector());
        inboundEndpoint.setOnErrorSequenceOutputConnector(createInboundEndpointOnErrorSequenceOutputConnector());
        inboundEndpoint.setContainer(createInboundEndpointContainer());
        //inboundEndpoint.setInboundHttpPort("8000");
		return inboundEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointParameter createInboundEndpointParameter() {
		InboundEndpointParameterImpl inboundEndpointParameter = new InboundEndpointParameterImpl();
		return inboundEndpointParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InboundEndpointContainer createInboundEndpointContainer() {
		InboundEndpointContainerImpl inboundEndpointContainer = new InboundEndpointContainerImpl();
        inboundEndpointContainer.setSequenceContainer(createInboundEndpointSequenceContainer());
        inboundEndpointContainer.setOnErrorSequenceContainer(createInboundEndpointOnErrorSequenceContainer());
		return inboundEndpointContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InboundEndpointSequenceContainer createInboundEndpointSequenceContainer() {
		InboundEndpointSequenceContainerImpl inboundEndpointSequenceContainer = new InboundEndpointSequenceContainerImpl();
		inboundEndpointSequenceContainer.setMediatorFlow(createMediatorFlow());
		return inboundEndpointSequenceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InboundEndpointOnErrorSequenceContainer createInboundEndpointOnErrorSequenceContainer() {
		InboundEndpointOnErrorSequenceContainerImpl inboundEndpointOnErrorSequenceContainer = new InboundEndpointOnErrorSequenceContainerImpl();
		inboundEndpointOnErrorSequenceContainer.setMediatorFlow(createMediatorFlow());
		return inboundEndpointOnErrorSequenceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointSequenceInputConnector createInboundEndpointSequenceInputConnector() {
		InboundEndpointSequenceInputConnectorImpl inboundEndpointSequenceInputConnector = new InboundEndpointSequenceInputConnectorImpl();
		return inboundEndpointSequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointSequenceOutputConnector createInboundEndpointSequenceOutputConnector() {
		InboundEndpointSequenceOutputConnectorImpl inboundEndpointSequenceOutputConnector = new InboundEndpointSequenceOutputConnectorImpl();
		return inboundEndpointSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointOnErrorSequenceOutputConnector createInboundEndpointOnErrorSequenceOutputConnector() {
		InboundEndpointOnErrorSequenceOutputConnectorImpl inboundEndpointOnErrorSequenceOutputConnector = new InboundEndpointOnErrorSequenceOutputConnectorImpl();
		return inboundEndpointOnErrorSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointOnErrorSequenceInputConnector createInboundEndpointOnErrorSequenceInputConnector() {
		InboundEndpointOnErrorSequenceInputConnectorImpl inboundEndpointOnErrorSequenceInputConnector = new InboundEndpointOnErrorSequenceInputConnectorImpl();
		return inboundEndpointOnErrorSequenceInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommentMediator createCommentMediator() {
		CommentMediatorImpl commentMediator = new CommentMediatorImpl();
		return commentMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArtifactType createArtifactTypeFromString(EDataType eDataType, String initialValue) {
		ArtifactType result = ArtifactType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArtifactTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallMediatorEndpointType createCallMediatorEndpointTypeFromString(EDataType eDataType, String initialValue) {
		CallMediatorEndpointType result = CallMediatorEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCallMediatorEndpointTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointPropertyScope createEndPointPropertyScopeFromString(EDataType eDataType, String initialValue) {
		EndPointPropertyScope result = EndPointPropertyScope.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointPropertyScopeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType createSequenceTypeFromString(EDataType eDataType, String initialValue) {
		SequenceType result = SequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScriptMediator createScriptMediator() {
		ScriptMediatorImpl scriptMediator = new ScriptMediatorImpl();
		scriptMediator.setInputConnector(createScriptMediatorInputConnector());
		scriptMediator.setOutputConnector(createScriptMediatorOutputConnector());
		return scriptMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMediatorInputConnector createScriptMediatorInputConnector() {
		ScriptMediatorInputConnectorImpl scriptMediatorInputConnector = new ScriptMediatorInputConnectorImpl();
		return scriptMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMediatorOutputConnector createScriptMediatorOutputConnector() {
		ScriptMediatorOutputConnectorImpl scriptMediatorOutputConnector = new ScriptMediatorOutputConnectorImpl();
		return scriptMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FaultMediator createFaultMediator() {
		FaultMediatorImpl faultMediator = new FaultMediatorImpl();
		faultMediator.setInputConnector(createFaultMediatorInputConnector());
		faultMediator.setOutputConnector(createFaultMediatorOutputConnector());
		return faultMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultMediatorInputConnector createFaultMediatorInputConnector() {
		FaultMediatorInputConnectorImpl faultMediatorInputConnector = new FaultMediatorInputConnectorImpl();
		return faultMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultMediatorOutputConnector createFaultMediatorOutputConnector() {
		FaultMediatorOutputConnectorImpl faultMediatorOutputConnector = new FaultMediatorOutputConnectorImpl();
		return faultMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AggregateMediator createAggregateMediator() {
		AggregateMediatorImpl aggregateMediator = new AggregateMediatorImpl();
		aggregateMediator.setInputConnector(createAggregateMediatorInputConnector());
		aggregateMediator.setOutputConnector(createAggregateMediatorOutputConnector());
		aggregateMediator.setOnCompleteOutputConnector(createAggregateMediatorOnCompleteOutputConnector());
		aggregateMediator.setMediatorFlow(createMediatorFlow());
		return aggregateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediatorInputConnector createAggregateMediatorInputConnector() {
		AggregateMediatorInputConnectorImpl aggregateMediatorInputConnector = new AggregateMediatorInputConnectorImpl();
		return aggregateMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediatorOutputConnector createAggregateMediatorOutputConnector() {
		AggregateMediatorOutputConnectorImpl aggregateMediatorOutputConnector = new AggregateMediatorOutputConnectorImpl();
		return aggregateMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediatorOnCompleteOutputConnector createAggregateMediatorOnCompleteOutputConnector() {
		AggregateMediatorOnCompleteOutputConnectorImpl aggregateMediatorOnCompleteOutputConnector = new AggregateMediatorOnCompleteOutputConnectorImpl();
		return aggregateMediatorOnCompleteOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RouterMediator createRouterMediator() {
		RouterMediatorImpl routerMediator = new RouterMediatorImpl();
		routerMediator.setInputConnector(createRouterMediatorInputConnector());
		routerMediator.setOutputConnector(createRouterMediatorOutputConnector());
		routerMediator.setRouterContainer(createRouterMediatorContainer());
		return routerMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterRoute createRouterRoute() {
		RouterRouteImpl routerRoute = new RouterRouteImpl();
		return routerRoute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RouterTarget createRouterTarget() {
		RouterTargetImpl routerTarget = new RouterTargetImpl();
		routerTarget.setSequenceType(TargetSequenceType.ANONYMOUS);
		routerTarget.setSequenceKey(createRegistryKeyProperty());
		routerTarget.setEndpointType(TargetEndpointType.NONE);
		routerTarget.setEndpointKey(createRegistryKeyProperty());
		return routerTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorInputConnector createRouterMediatorInputConnector() {
		RouterMediatorInputConnectorImpl routerMediatorInputConnector = new RouterMediatorInputConnectorImpl();
		return routerMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorOutputConnector createRouterMediatorOutputConnector() {
		RouterMediatorOutputConnectorImpl routerMediatorOutputConnector = new RouterMediatorOutputConnectorImpl();
		return routerMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorTargetOutputConnector createRouterMediatorTargetOutputConnector() {
		RouterMediatorTargetOutputConnectorImpl routerMediatorTargetOutputConnector = new RouterMediatorTargetOutputConnectorImpl();
		return routerMediatorTargetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediatorContainer createRouterMediatorContainer() {
		RouterMediatorContainerImpl routerMediatorContainer = new RouterMediatorContainerImpl();
		return routerMediatorContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RouterTargetContainer createRouterTargetContainer() {
		RouterTargetContainerImpl routerTargetContainer = new RouterTargetContainerImpl();
		routerTargetContainer.setMediatorFlow(createMediatorFlow());
		routerTargetContainer.setBreakAfterRoute(true);
		routerTargetContainer.setTarget(createRouterTarget());
		routerTargetContainer.setRoutePattern("");
		NamespacedProperty namespacedProperty = createNamespacedProperty();
		namespacedProperty.setPropertyValue("/default/expression");
		routerTargetContainer.setRouteExpression(namespacedProperty);
		return routerTargetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CloneMediator createCloneMediator() {
		CloneMediatorImpl cloneMediator = new CloneMediatorImpl();
		cloneMediator.setInputConnector(createCloneMediatorInputConnector());
		cloneMediator.setOutputConnector(createCloneMediatorOutputConnector());
		cloneMediator.setCloneContainer(createCloneMediatorContainer());
		return cloneMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneTarget createCloneTarget() {
		CloneTargetImpl cloneTarget = new CloneTargetImpl();
		return cloneTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorInputConnector createCloneMediatorInputConnector() {
		CloneMediatorInputConnectorImpl cloneMediatorInputConnector = new CloneMediatorInputConnectorImpl();
		return cloneMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorOutputConnector createCloneMediatorOutputConnector() {
		CloneMediatorOutputConnectorImpl cloneMediatorOutputConnector = new CloneMediatorOutputConnectorImpl();
		return cloneMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorTargetOutputConnector createCloneMediatorTargetOutputConnector() {
		CloneMediatorTargetOutputConnectorImpl cloneMediatorTargetOutputConnector = new CloneMediatorTargetOutputConnectorImpl();
		return cloneMediatorTargetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediatorContainer createCloneMediatorContainer() {
		CloneMediatorContainerImpl cloneMediatorContainer = new CloneMediatorContainerImpl();
		return cloneMediatorContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CloneTargetContainer createCloneTargetContainer() {
		CloneTargetContainerImpl cloneTargetContainer = new CloneTargetContainerImpl();
		cloneTargetContainer.setMediatorFlow(createMediatorFlow());
		return cloneTargetContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ForEachMediator createForEachMediator() {
		ForEachMediatorImpl forEachMediator = new ForEachMediatorImpl();
		forEachMediator.setInputConnector(createForEachMediatorInputConnector());
		forEachMediator.setOutputConnector(createForEachMediatorOutputConnector());
		forEachMediator.setTargetOutputConnector(createForEachMediatorTargetOutputConnector());
		forEachMediator.setMediatorFlow(createMediatorFlow());
		return forEachMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorInputConnector createForEachMediatorInputConnector() {
		ForEachMediatorInputConnectorImpl forEachMediatorInputConnector = new ForEachMediatorInputConnectorImpl();
		return forEachMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorOutputConnector createForEachMediatorOutputConnector() {
		ForEachMediatorOutputConnectorImpl forEachMediatorOutputConnector = new ForEachMediatorOutputConnectorImpl();
		return forEachMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachMediatorTargetOutputConnector createForEachMediatorTargetOutputConnector() {
		ForEachMediatorTargetOutputConnectorImpl forEachMediatorTargetOutputConnector = new ForEachMediatorTargetOutputConnectorImpl();
		return forEachMediatorTargetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachTarget createForEachTarget() {
		ForEachTargetImpl forEachTarget = new ForEachTargetImpl();
		return forEachTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IterateMediator createIterateMediator() {
		IterateMediatorImpl iterateMediator = new IterateMediatorImpl();
		iterateMediator.setInputConnector(createIterateMediatorInputConnector());
		iterateMediator.setOutputConnector(createIterateMediatorOutputConnector());
		iterateMediator.setTargetOutputConnector(createIterateMediatorTargetOutputConnector());
		iterateMediator.setMediatorFlow(createMediatorFlow());
		return iterateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorInputConnector createIterateMediatorInputConnector() {
		IterateMediatorInputConnectorImpl iterateMediatorInputConnector = new IterateMediatorInputConnectorImpl();
		return iterateMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorOutputConnector createIterateMediatorOutputConnector() {
		IterateMediatorOutputConnectorImpl iterateMediatorOutputConnector = new IterateMediatorOutputConnectorImpl();
		return iterateMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateMediatorTargetOutputConnector createIterateMediatorTargetOutputConnector() {
		IterateMediatorTargetOutputConnectorImpl iterateMediatorTargetOutputConnector = new IterateMediatorTargetOutputConnectorImpl();
		return iterateMediatorTargetOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateTarget createIterateTarget() {
		IterateTargetImpl iterateTarget = new IterateTargetImpl();
		return iterateTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractCommonTarget createAbstractCommonTarget() {
		AbstractCommonTargetImpl abstractCommonTarget = new AbstractCommonTargetImpl();
		return abstractCommonTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorSequence createMediatorSequence() {
		MediatorSequenceImpl mediatorSequence = new MediatorSequenceImpl();
		return mediatorSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CacheMediator createCacheMediator() {
		CacheMediatorImpl cacheMediator = new CacheMediatorImpl();
		cacheMediator.setInputConnector(createCacheMediatorInputConnector());
		cacheMediator.setOutputConnector(createCacheMediatorOutputConnector());
		cacheMediator.setOnHitOutputConnector(createCacheMediatorOnHitOutputConnector());
		cacheMediator.setMediatorFlow(createMediatorFlow());
		return cacheMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMediatorInputConnector createCacheMediatorInputConnector() {
		CacheMediatorInputConnectorImpl cacheMediatorInputConnector = new CacheMediatorInputConnectorImpl();
		return cacheMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMediatorOutputConnector createCacheMediatorOutputConnector() {
		CacheMediatorOutputConnectorImpl cacheMediatorOutputConnector = new CacheMediatorOutputConnectorImpl();
		return cacheMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMediatorOnHitOutputConnector createCacheMediatorOnHitOutputConnector() {
		CacheMediatorOnHitOutputConnectorImpl cacheMediatorOnHitOutputConnector = new CacheMediatorOnHitOutputConnectorImpl();
		return cacheMediatorOnHitOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheOnHitBranch createCacheOnHitBranch() {
		CacheOnHitBranchImpl cacheOnHitBranch = new CacheOnHitBranchImpl();
		return cacheOnHitBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XQueryMediator createXQueryMediator() {
		XQueryMediatorImpl xQueryMediator = new XQueryMediatorImpl();
		xQueryMediator.setInputConnector(createXQueryMediatorInputConnector());
		xQueryMediator.setOutputConnector(createXQueryMediatorOutputConnector());
		return xQueryMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryMediatorInputConnector createXQueryMediatorInputConnector() {
		XQueryMediatorInputConnectorImpl xQueryMediatorInputConnector = new XQueryMediatorInputConnectorImpl();
		return xQueryMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryMediatorOutputConnector createXQueryMediatorOutputConnector() {
		XQueryMediatorOutputConnectorImpl xQueryMediatorOutputConnector = new XQueryMediatorOutputConnectorImpl();
		return xQueryMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryVariable createXQueryVariable() {
		XQueryVariableImpl xQueryVariable = new XQueryVariableImpl();
		return xQueryVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CalloutMediator createCalloutMediator() {
		CalloutMediatorImpl calloutMediator = new CalloutMediatorImpl();
		calloutMediator.setInputConnector(createCalloutMediatorInputConnector());
		calloutMediator.setOutputConnector(createCalloutMediatorOutputConnector());
		return calloutMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutMediatorInputConnector createCalloutMediatorInputConnector() {
		CalloutMediatorInputConnectorImpl calloutMediatorInputConnector = new CalloutMediatorInputConnectorImpl();
		return calloutMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutMediatorOutputConnector createCalloutMediatorOutputConnector() {
		CalloutMediatorOutputConnectorImpl calloutMediatorOutputConnector = new CalloutMediatorOutputConnectorImpl();
		return calloutMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RMSequenceMediator createRMSequenceMediator() {
		RMSequenceMediatorImpl rmSequenceMediator = new RMSequenceMediatorImpl();
		rmSequenceMediator.setInputConnector(createRMSequenceMediatorInputConnector());
		rmSequenceMediator.setOutputConnector(createRMSequenceMediatorOutputConnector());
		return rmSequenceMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceMediatorInputConnector createRMSequenceMediatorInputConnector() {
		RMSequenceMediatorInputConnectorImpl rmSequenceMediatorInputConnector = new RMSequenceMediatorInputConnectorImpl();
		return rmSequenceMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceMediatorOutputConnector createRMSequenceMediatorOutputConnector() {
		RMSequenceMediatorOutputConnectorImpl rmSequenceMediatorOutputConnector = new RMSequenceMediatorOutputConnectorImpl();
		return rmSequenceMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TransactionMediator createTransactionMediator() {
		TransactionMediatorImpl transactionMediator = new TransactionMediatorImpl();
		transactionMediator.setInputConnector(createTransactionMediatorInputConnector());
		transactionMediator.setOutputConnector(createTransactionMediatorOutputConnector());
		return transactionMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionMediatorInputConnector createTransactionMediatorInputConnector() {
		TransactionMediatorInputConnectorImpl transactionMediatorInputConnector = new TransactionMediatorInputConnectorImpl();
		return transactionMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionMediatorOutputConnector createTransactionMediatorOutputConnector() {
		TransactionMediatorOutputConnectorImpl transactionMediatorOutputConnector = new TransactionMediatorOutputConnectorImpl();
		return transactionMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OAuthMediator createOAuthMediator() {
		OAuthMediatorImpl oAuthMediator = new OAuthMediatorImpl();
		oAuthMediator.setInputConnector(createOAuthMediatorInputConnector());
		oAuthMediator.setOutputConnector(createOAuthMediatorOutputConnector());
		oAuthMediator.setUsername(OAUTH_MEDIATOR_DEFAULT_USERNAME);
		oAuthMediator.setPassword(OAUTH_MEDIATOR_DEFAULT_PASSWORD);
		return oAuthMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OAuthMediatorInputConnector createOAuthMediatorInputConnector() {
		OAuthMediatorInputConnectorImpl oAuthMediatorInputConnector = new OAuthMediatorInputConnectorImpl();
		return oAuthMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OAuthMediatorOutputConnector createOAuthMediatorOutputConnector() {
		OAuthMediatorOutputConnectorImpl oAuthMediatorOutputConnector = new OAuthMediatorOutputConnectorImpl();
		return oAuthMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoscaleInMediator createAutoscaleInMediator() {
		AutoscaleInMediatorImpl autoscaleInMediator = new AutoscaleInMediatorImpl();
		return autoscaleInMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoscaleOutMediator createAutoscaleOutMediator() {
		AutoscaleOutMediatorImpl autoscaleOutMediator = new AutoscaleOutMediatorImpl();
		return autoscaleOutMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public HeaderMediator createHeaderMediator() {		
		HeaderMediatorImpl headerMediator = new HeaderMediatorImpl();
		headerMediator.setInputConnector(createHeaderMediatorInputConnector());
		headerMediator.setOutputConnector(createHeaderMediatorOutputConnector());
		return headerMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderMediatorInputConnector createHeaderMediatorInputConnector() {
		HeaderMediatorInputConnectorImpl headerMediatorInputConnector = new HeaderMediatorInputConnectorImpl();
		return headerMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderMediatorOutputConnector createHeaderMediatorOutputConnector() {
		HeaderMediatorOutputConnectorImpl headerMediatorOutputConnector = new HeaderMediatorOutputConnectorImpl();
		return headerMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ThrottleMediator createThrottleMediator() {
		ThrottleMediatorImpl throttleMediator = new ThrottleMediatorImpl();
		throttleMediator.setInputConnector(createThrottleMediatorInputConnector());
		throttleMediator.setOutputConnector(createThrottleMediatorOutputConnector());
		throttleMediator.setOnAcceptOutputConnector(createThrottleMediatorOnAcceptOutputConnector());
		throttleMediator.setOnRejectOutputConnector(createThrottleMediatorOnRejectOutputConnector());
		throttleMediator.setThrottleContainer(createThrottleContainer());
		return throttleMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleMediatorInputConnector createThrottleMediatorInputConnector() {
		ThrottleMediatorInputConnectorImpl throttleMediatorInputConnector = new ThrottleMediatorInputConnectorImpl();
		return throttleMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleMediatorOutputConnector createThrottleMediatorOutputConnector() {
		ThrottleMediatorOutputConnectorImpl throttleMediatorOutputConnector = new ThrottleMediatorOutputConnectorImpl();
		return throttleMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleMediatorOnAcceptOutputConnector createThrottleMediatorOnAcceptOutputConnector() {
		ThrottleMediatorOnAcceptOutputConnectorImpl throttleMediatorOnAcceptOutputConnector = new ThrottleMediatorOnAcceptOutputConnectorImpl();
		return throttleMediatorOnAcceptOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ThrottleMediatorOnRejectOutputConnector createThrottleMediatorOnRejectOutputConnector() {
		ThrottleMediatorOnRejectOutputConnectorImpl throttleMediatorOnRejectOutputConnector = new ThrottleMediatorOnRejectOutputConnectorImpl();
		return throttleMediatorOnRejectOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottlePolicyConfiguration createThrottlePolicyConfiguration() {
		ThrottlePolicyConfigurationImpl throttlePolicyConfiguration = new ThrottlePolicyConfigurationImpl();
		return throttlePolicyConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottlePolicyEntry createThrottlePolicyEntry() {
		ThrottlePolicyEntryImpl throttlePolicyEntry = new ThrottlePolicyEntryImpl();
		return throttlePolicyEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleOnAcceptBranch createThrottleOnAcceptBranch() {
		ThrottleOnAcceptBranchImpl throttleOnAcceptBranch = new ThrottleOnAcceptBranchImpl();
		return throttleOnAcceptBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleOnRejectBranch createThrottleOnRejectBranch() {
		ThrottleOnRejectBranchImpl throttleOnRejectBranch = new ThrottleOnRejectBranchImpl();
		return throttleOnRejectBranch;
	}

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ThrottleContainer createThrottleContainer() {
        ThrottleContainerImpl throttleContainer = new ThrottleContainerImpl();
        throttleContainer.setOnAcceptContainer(createThrottleOnAcceptContainer());
        throttleContainer.setOnRejectContainer(createThrottleOnRejectContainer());
        return throttleContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ThrottleOnAcceptContainer createThrottleOnAcceptContainer() {
        ThrottleOnAcceptContainerImpl throttleOnAcceptContainer = new ThrottleOnAcceptContainerImpl();
        throttleOnAcceptContainer.setMediatorFlow(createMediatorFlow());
        return throttleOnAcceptContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public ThrottleOnRejectContainer createThrottleOnRejectContainer() {
        ThrottleOnRejectContainerImpl throttleOnRejectContainer = new ThrottleOnRejectContainerImpl();
        throttleOnRejectContainer.setMediatorFlow(createMediatorFlow());
        return throttleOnRejectContainer;
    }

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CommandMediator createCommandMediator() {
		CommandMediatorImpl commandMediator = new CommandMediatorImpl();
		commandMediator.setInputConnector(createCommandMediatorInputConnector());
		commandMediator.setOutputConnector(createCommandMediatorOutputConnector());
		return commandMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandMediatorInputConnector createCommandMediatorInputConnector() {
		CommandMediatorInputConnectorImpl commandMediatorInputConnector = new CommandMediatorInputConnectorImpl();
		return commandMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandMediatorOutputConnector createCommandMediatorOutputConnector() {
		CommandMediatorOutputConnectorImpl commandMediatorOutputConnector = new CommandMediatorOutputConnectorImpl();
		return commandMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandProperty createCommandProperty() {
		CommandPropertyImpl commandProperty = new CommandPropertyImpl();
		return commandProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlStatement createSqlStatement() {
		SqlStatementImpl sqlStatement = new SqlStatementImpl();
		return sqlStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlParameterDefinition createSqlParameterDefinition() {
		SqlParameterDefinitionImpl sqlParameterDefinition = new SqlParameterDefinitionImpl();
		return sqlParameterDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlResultMapping createSqlResultMapping() {
		SqlResultMappingImpl sqlResultMapping = new SqlResultMappingImpl();
		return sqlResultMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DBLookupMediator createDBLookupMediator() {
		DBLookupMediatorImpl dbLookupMediator = new DBLookupMediatorImpl();
		dbLookupMediator.setInputConnector(createDBLookupMediatorInputConnector());
		dbLookupMediator.setOutputConnector(createDBLookupMediatorOutputConnector());
		return dbLookupMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBLookupMediatorInputConnector createDBLookupMediatorInputConnector() {
		DBLookupMediatorInputConnectorImpl dbLookupMediatorInputConnector = new DBLookupMediatorInputConnectorImpl();
		return dbLookupMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBLookupMediatorOutputConnector createDBLookupMediatorOutputConnector() {
		DBLookupMediatorOutputConnectorImpl dbLookupMediatorOutputConnector = new DBLookupMediatorOutputConnectorImpl();
		return dbLookupMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DBReportMediator createDBReportMediator() {
		DBReportMediatorImpl dbReportMediator = new DBReportMediatorImpl();
		dbReportMediator.setInputConnector(createDBReportMediatorInputConnector());
		dbReportMediator.setOutputConnector(createDBReportMediatorOutputConnector());
		return dbReportMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBReportMediatorInputConnector createDBReportMediatorInputConnector() {
		DBReportMediatorInputConnectorImpl dbReportMediatorInputConnector = new DBReportMediatorInputConnectorImpl();
		return dbReportMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBReportMediatorOutputConnector createDBReportMediatorOutputConnector() {
		DBReportMediatorOutputConnectorImpl dbReportMediatorOutputConnector = new DBReportMediatorOutputConnectorImpl();
		return dbReportMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RuleMediator createRuleMediator() {
		RuleMediatorImpl ruleMediator = new RuleMediatorImpl();
		ruleMediator.setInputConnector(createRuleMediatorInputConnector());
		ruleMediator.setOutputConnector(createRuleMediatorOutputConnector());
		ruleMediator.setChildMediatorsOutputConnector(createRuleMediatorChildMediatorsOutputConnector());
		ruleMediator.setMediatorFlow(createMediatorFlow());
		ruleMediator.setFactsConfiguration(createRuleFactsConfiguration());
		ruleMediator.setResultsConfiguration(createRuleResultsConfiguration());
		return ruleMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMediatorInputConnector createRuleMediatorInputConnector() {
		RuleMediatorInputConnectorImpl ruleMediatorInputConnector = new RuleMediatorInputConnectorImpl();
		return ruleMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMediatorOutputConnector createRuleMediatorOutputConnector() {
		RuleMediatorOutputConnectorImpl ruleMediatorOutputConnector = new RuleMediatorOutputConnectorImpl();
		return ruleMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMediatorChildMediatorsOutputConnector createRuleMediatorChildMediatorsOutputConnector() {
		RuleMediatorChildMediatorsOutputConnectorImpl ruleMediatorChildMediatorsOutputConnector = new RuleMediatorChildMediatorsOutputConnectorImpl();
		return ruleMediatorChildMediatorsOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSetCreationProperty createRuleSetCreationProperty() {
		RuleSetCreationPropertyImpl ruleSetCreationProperty = new RuleSetCreationPropertyImpl();
		return ruleSetCreationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSessionProperty createRuleSessionProperty() {
		RuleSessionPropertyImpl ruleSessionProperty = new RuleSessionPropertyImpl();
		return ruleSessionProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFactsConfiguration createRuleFactsConfiguration() {
		RuleFactsConfigurationImpl ruleFactsConfiguration = new RuleFactsConfigurationImpl();
		return ruleFactsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFact createRuleFact() {
		RuleFactImpl ruleFact = new RuleFactImpl();
		return ruleFact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResultsConfiguration createRuleResultsConfiguration() {
		RuleResultsConfigurationImpl ruleResultsConfiguration = new RuleResultsConfigurationImpl();
		return ruleResultsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResult createRuleResult() {
		RuleResultImpl ruleResult = new RuleResultImpl();
		return ruleResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleChildMediatorsConfiguration createRuleChildMediatorsConfiguration() {
		RuleChildMediatorsConfigurationImpl ruleChildMediatorsConfiguration = new RuleChildMediatorsConfigurationImpl();
		return ruleChildMediatorsConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CallTemplateParameter createCallTemplateParameter() {
		CallTemplateParameterImpl callTemplateParameter = new CallTemplateParameterImpl();
		NamespacedProperty namespacedProperty = createNamespacedProperty();
		namespacedProperty.setPrettyName("parameter expression");
		namespacedProperty.setPropertyName("expression");
		namespacedProperty.setPropertyValue("");
		namespacedProperty.setSupportsDynamicXPaths(true);
		callTemplateParameter.setParameterName("param_name");
		callTemplateParameter.setParameterValue("");
		callTemplateParameter.setParameterExpression(namespacedProperty);
		callTemplateParameter.setTemplateParameterType(RuleOptionType.VALUE);
		return callTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CallTemplateMediator createCallTemplateMediator() {
		CallTemplateMediatorImpl callTemplateMediator = new CallTemplateMediatorImpl();
		callTemplateMediator.setInputConnector(createCallTemplateMediatorInputConnector());
		callTemplateMediator.setOutputConnector(createCallTemplateMediatorOutputConnector());
		return callTemplateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateMediatorInputConnector createCallTemplateMediatorInputConnector() {
		CallTemplateMediatorInputConnectorImpl callTemplateMediatorInputConnector = new CallTemplateMediatorInputConnectorImpl();
		return callTemplateMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateMediatorOutputConnector createCallTemplateMediatorOutputConnector() {
		CallTemplateMediatorOutputConnectorImpl callTemplateMediatorOutputConnector = new CallTemplateMediatorOutputConnectorImpl();
		return callTemplateMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LoopBackMediator createLoopBackMediator() {
		LoopBackMediatorImpl loopBackMediator = new LoopBackMediatorImpl();
		loopBackMediator.setInputConnector(createLoopBackMediatorInputConnector());
		loopBackMediator.setOutputConnector(createLoopBackMediatorOutputConnector());
		return loopBackMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopBackMediatorInputConnector createLoopBackMediatorInputConnector() {
		LoopBackMediatorInputConnectorImpl loopBackMediatorInputConnector = new LoopBackMediatorInputConnectorImpl();
		return loopBackMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopBackMediatorOutputConnector createLoopBackMediatorOutputConnector() {
		LoopBackMediatorOutputConnectorImpl loopBackMediatorOutputConnector = new LoopBackMediatorOutputConnectorImpl();
		return loopBackMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RespondMediator createRespondMediator() {
		RespondMediatorImpl respondMediator = new RespondMediatorImpl();
		respondMediator.setInputConnector(createRespondMediatorInputConnector());
		respondMediator.setOutputConnector(createRespondMediatorOutputConnector());
		return respondMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RespondMediatorInputConnector createRespondMediatorInputConnector() {
		RespondMediatorInputConnectorImpl respondMediatorInputConnector = new RespondMediatorInputConnectorImpl();
		return respondMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RespondMediatorOutputConnector createRespondMediatorOutputConnector() {
		RespondMediatorOutputConnectorImpl respondMediatorOutputConnector = new RespondMediatorOutputConnectorImpl();
		return respondMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SmooksMediator createSmooksMediator() {
		SmooksMediatorImpl smooksMediator = new SmooksMediatorImpl();
		smooksMediator.setInputConnector(createSmooksMediatorInputConnector());
		smooksMediator.setOutputConnector(createSmooksMediatorOutputConnector());
		return smooksMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksMediatorInputConnector createSmooksMediatorInputConnector() {
		SmooksMediatorInputConnectorImpl smooksMediatorInputConnector = new SmooksMediatorInputConnectorImpl();
		return smooksMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksMediatorOutputConnector createSmooksMediatorOutputConnector() {
		SmooksMediatorOutputConnectorImpl smooksMediatorOutputConnector = new SmooksMediatorOutputConnectorImpl();
		return smooksMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StoreMediator createStoreMediator() {
		StoreMediatorImpl storeMediator = new StoreMediatorImpl();
		storeMediator.setInputConnector(createStoreMediatorInputConnector());
		storeMediator.setOutputConnector(createStoreMediatorOutputConnector());
		return storeMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreMediatorInputConnector createStoreMediatorInputConnector() {
		StoreMediatorInputConnectorImpl storeMediatorInputConnector = new StoreMediatorInputConnectorImpl();
		return storeMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreMediatorOutputConnector createStoreMediatorOutputConnector() {
		StoreMediatorOutputConnectorImpl storeMediatorOutputConnector = new StoreMediatorOutputConnectorImpl();
		return storeMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BuilderMediator createBuilderMediator() {
		BuilderMediatorImpl builderMediator = new BuilderMediatorImpl();
		builderMediator.setInputConnector(createBuilderMediatorInputConnector());
		builderMediator.setOutputConnector(createBuilderMediatorOutputConector());
		return builderMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuilderMediatorInputConnector createBuilderMediatorInputConnector() {
		BuilderMediatorInputConnectorImpl builderMediatorInputConnector = new BuilderMediatorInputConnectorImpl();
		return builderMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuilderMediatorOutputConector createBuilderMediatorOutputConector() {
		BuilderMediatorOutputConectorImpl builderMediatorOutputConector = new BuilderMediatorOutputConectorImpl();
		return builderMediatorOutputConector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageBuilder createMessageBuilder() {
		MessageBuilderImpl messageBuilder = new MessageBuilderImpl();
		return messageBuilder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PayloadFactoryMediator createPayloadFactoryMediator() {
		PayloadFactoryMediatorImpl payloadFactoryMediator = new PayloadFactoryMediatorImpl();
		payloadFactoryMediator.setInputConnector(createPayloadFactoryMediatorInputConnector());
		payloadFactoryMediator.setOutputConnector(createPayloadFactoryMediatorOutputConnector());
		return payloadFactoryMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryMediatorInputConnector createPayloadFactoryMediatorInputConnector() {
		PayloadFactoryMediatorInputConnectorImpl payloadFactoryMediatorInputConnector = new PayloadFactoryMediatorInputConnectorImpl();
		return payloadFactoryMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryMediatorOutputConnector createPayloadFactoryMediatorOutputConnector() {
		PayloadFactoryMediatorOutputConnectorImpl payloadFactoryMediatorOutputConnector = new PayloadFactoryMediatorOutputConnectorImpl();
		return payloadFactoryMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryArgument createPayloadFactoryArgument() {
		PayloadFactoryArgumentImpl payloadFactoryArgument = new PayloadFactoryArgumentImpl();
		return payloadFactoryArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConditionalRouteBranch createConditionalRouteBranch() {
		ConditionalRouteBranchImpl conditionalRouteBranch = new ConditionalRouteBranchImpl();
		conditionalRouteBranch.setBreakAfterRoute(false);
		RegistryKeyProperty registryKeyProperty = createRegistryKeyProperty();
		registryKeyProperty.setKeyName("Target");
		registryKeyProperty.setKeyValue("default");
		EvaluatorExpressionProperty evaluatorExpressionProperty = createEvaluatorExpressionProperty();
		evaluatorExpressionProperty.setEvaluatorValue("<equal  type=\"param\" source=\"foo\" value=\"bar\"/>");
		conditionalRouteBranch.setEvaluatorExpression(evaluatorExpressionProperty);
		conditionalRouteBranch.setTargetSequence(registryKeyProperty);
		return conditionalRouteBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConditionalRouterMediator createConditionalRouterMediator() {
		ConditionalRouterMediatorImpl conditionalRouterMediator = new ConditionalRouterMediatorImpl();
		conditionalRouterMediator.setInputConnector(createConditionalRouterMediatorInputConnector());
		conditionalRouterMediator.setOutputConnector(createConditionalRouterMediatorOutputConnector());
		//conditionalRouterMediator.setAdditionalOutputConnector(createConditionalRouterMediatorAdditionalOutputConnector());
		//conditionalRouterMediator.setMediatorFlow(createMediatorFlow());
		return conditionalRouterMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorInputConnector createConditionalRouterMediatorInputConnector() {
		ConditionalRouterMediatorInputConnectorImpl conditionalRouterMediatorInputConnector = new ConditionalRouterMediatorInputConnectorImpl();
		return conditionalRouterMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorOutputConnector createConditionalRouterMediatorOutputConnector() {
		ConditionalRouterMediatorOutputConnectorImpl conditionalRouterMediatorOutputConnector = new ConditionalRouterMediatorOutputConnectorImpl();
		return conditionalRouterMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediatorAdditionalOutputConnector createConditionalRouterMediatorAdditionalOutputConnector() {
		ConditionalRouterMediatorAdditionalOutputConnectorImpl conditionalRouterMediatorAdditionalOutputConnector = new ConditionalRouterMediatorAdditionalOutputConnectorImpl();
		return conditionalRouterMediatorAdditionalOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SendMediator createSendMediator() {
		SendMediatorImpl sendMediator = new SendMediatorImpl();
		sendMediator.setInputConnector(createSendMediatorInputConnector());
		sendMediator.setOutputConnector(createSendMediatorOutputConnector());
		sendMediator.setEndpointOutputConnector(createSendMediatorEndpointOutputConnector());
		sendMediator.setMediatorFlow(createMediatorFlow());
		return sendMediator;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SendContainer createSendContainer() {
		SendContainerImpl sendContainer = new SendContainerImpl();
		return sendContainer;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendMediatorInputConnector createSendMediatorInputConnector() {
		SendMediatorInputConnectorImpl sendMediatorInputConnector = new SendMediatorInputConnectorImpl();
		return sendMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendMediatorOutputConnector createSendMediatorOutputConnector() {
		SendMediatorOutputConnectorImpl sendMediatorOutputConnector = new SendMediatorOutputConnectorImpl();
		return sendMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SendMediatorEndpointOutputConnector createSendMediatorEndpointOutputConnector() {
		SendMediatorEndpointOutputConnectorImpl sendMediatorEndpointOutputConnector = new SendMediatorEndpointOutputConnectorImpl();
		return sendMediatorEndpointOutputConnector;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FailoverEndPoint createFailoverEndPoint() {
		FailoverEndPointImpl failoverEndPoint = new FailoverEndPointImpl();
		failoverEndPoint.setInputConnector(createFailoverEndPointInputConnector());
		failoverEndPoint.setMediatorFlow(createMediatorFlow());
		return failoverEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailoverEndPointInputConnector createFailoverEndPointInputConnector() {
		FailoverEndPointInputConnectorImpl failoverEndPointInputConnector = new FailoverEndPointInputConnectorImpl();
		return failoverEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailoverEndPointOutputConnector createFailoverEndPointOutputConnector() {
		FailoverEndPointOutputConnectorImpl failoverEndPointOutputConnector = new FailoverEndPointOutputConnectorImpl();
		return failoverEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailoverEndPointWestOutputConnector createFailoverEndPointWestOutputConnector() {
		FailoverEndPointWestOutputConnectorImpl failoverEndPointWestOutputConnector = new FailoverEndPointWestOutputConnectorImpl();
		return failoverEndPointWestOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParentEndPoint createParentEndPoint() {
		ParentEndPointImpl parentEndPoint = new ParentEndPointImpl();
		return parentEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public WSDLEndPoint createWSDLEndPoint() {
		WSDLEndPointImpl wsdlEndPoint = new WSDLEndPointImpl();
		wsdlEndPoint.setInputConnector(createWSDLEndPointInputConnector());
		return wsdlEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSDLEndPointInputConnector createWSDLEndPointInputConnector() {
		WSDLEndPointInputConnectorImpl wsdlEndPointInputConnector = new WSDLEndPointInputConnectorImpl();
		return wsdlEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSDLEndPointOutputConnector createWSDLEndPointOutputConnector() {
		WSDLEndPointOutputConnectorImpl wsdlEndPointOutputConnector = new WSDLEndPointOutputConnectorImpl();
		return wsdlEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LoadBalanceEndPoint createLoadBalanceEndPoint() {
		LoadBalanceEndPointImpl loadBalanceEndPoint = new LoadBalanceEndPointImpl();		
		loadBalanceEndPoint.setInputConnector(createLoadBalanceEndPointInputConnector());	
		loadBalanceEndPoint.setMediatorFlow(createMediatorFlow());
		return loadBalanceEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Member createMember() {
		MemberImpl member = new MemberImpl();
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPointInputConnector createLoadBalanceEndPointInputConnector() {
		LoadBalanceEndPointInputConnectorImpl loadBalanceEndPointInputConnector = new LoadBalanceEndPointInputConnectorImpl();
		return loadBalanceEndPointInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPointOutputConnector createLoadBalanceEndPointOutputConnector() {
		LoadBalanceEndPointOutputConnectorImpl loadBalanceEndPointOutputConnector = new LoadBalanceEndPointOutputConnectorImpl();
		return loadBalanceEndPointOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceEndPointWestOutputConnector createLoadBalanceEndPointWestOutputConnector() {
		LoadBalanceEndPointWestOutputConnectorImpl loadBalanceEndPointWestOutputConnector = new LoadBalanceEndPointWestOutputConnectorImpl();
		return loadBalanceEndPointWestOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalEntry createLocalEntry() {
		LocalEntryImpl localEntry = new LocalEntryImpl();
		return localEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Session createSession() {
		SessionImpl session = new SessionImpl();
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Sequences createSequences() {
		SequencesImpl sequences = new SequencesImpl();
		sequences.setInputConnector(createSequencesInputConnector());
		sequences.setOutputConnector(createSequencesOutputConnector());
		sequences.setMediatorFlow(createMediatorFlow());
		return sequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequencesOutputConnector createSequencesOutputConnector() {
		SequencesOutputConnectorImpl sequencesOutputConnector = new SequencesOutputConnectorImpl();
		return sequencesOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequencesInputConnector createSequencesInputConnector() {
		SequencesInputConnectorImpl sequencesInputConnector = new SequencesInputConnectorImpl();
		return sequencesInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLRewriteRuleAction createURLRewriteRuleAction() {
		URLRewriteRuleActionImpl urlRewriteRuleAction = new URLRewriteRuleActionImpl();
		return urlRewriteRuleAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLRewriteRule createURLRewriteRule() {
		URLRewriteRuleImpl urlRewriteRule = new URLRewriteRuleImpl();
		return urlRewriteRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URLRewriteMediator createURLRewriteMediator() {
		URLRewriteMediatorImpl urlRewriteMediator = new URLRewriteMediatorImpl();
		urlRewriteMediator.setInputConnector(createURLRewriteMediatorInputConnector());
		urlRewriteMediator.setOutputConnector(createURLRewriteMediatorOutputConnector());
		return urlRewriteMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLRewriteMediatorInputConnector createURLRewriteMediatorInputConnector() {
		URLRewriteMediatorInputConnectorImpl urlRewriteMediatorInputConnector = new URLRewriteMediatorInputConnectorImpl();
		return urlRewriteMediatorInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URLRewriteMediatorOutputConnector createURLRewriteMediatorOutputConnector() {
		URLRewriteMediatorOutputConnectorImpl urlRewriteMediatorOutputConnector = new URLRewriteMediatorOutputConnectorImpl();
		return urlRewriteMediatorOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	public ProxyWsdlType createProxyWsdlTypeFromString(EDataType eDataType, String initialValue) {
		ProxyWsdlType result = ProxyWsdlType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProxyWsdlTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpMethodType createHttpMethodTypeFromString(EDataType eDataType, String initialValue) {
		HttpMethodType result = HttpMethodType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHttpMethodTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediatorConditionType createFilterMediatorConditionTypeFromString(EDataType eDataType, String initialValue) {
		FilterMediatorConditionType result = FilterMediatorConditionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFilterMediatorConditionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogCategory createLogCategoryFromString(EDataType eDataType, String initialValue) {
		LogCategory result = LogCategory.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogCategoryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogLevel createLogLevelFromString(EDataType eDataType, String initialValue) {
		LogLevel result = LogLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueType createAttributeValueTypeFromString(EDataType eDataType, String initialValue) {
		AttributeValueType result = AttributeValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeType createAttributeTypeFromString(EDataType eDataType, String initialValue) {
		AttributeType result = AttributeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttributeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanMediatorAction createBeanMediatorActionFromString(EDataType eDataType, String initialValue) {
		BeanMediatorAction result = BeanMediatorAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBeanMediatorActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointAddressingVersion createEndPointAddressingVersionFromString(EDataType eDataType, String initialValue) {
		EndPointAddressingVersion result = EndPointAddressingVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointAddressingVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointTimeOutAction createEndPointTimeOutActionFromString(EDataType eDataType, String initialValue) {
		EndPointTimeOutAction result = EndPointTimeOutAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointTimeOutActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointMessageFormat createEndPointMessageFormatFromString(EDataType eDataType, String initialValue) {
		EndPointMessageFormat result = EndPointMessageFormat.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointMessageFormatToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPointAttachmentOptimization createEndPointAttachmentOptimizationFromString(EDataType eDataType, String initialValue) {
		EndPointAttachmentOptimization result = EndPointAttachmentOptimization.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndPointAttachmentOptimizationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyDataType createPropertyDataTypeFromString(EDataType eDataType, String initialValue) {
		PropertyDataType result = PropertyDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAction createPropertyActionFromString(EDataType eDataType, String initialValue) {
		PropertyAction result = PropertyAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyScope createPropertyScopeFromString(EDataType eDataType, String initialValue) {
		PropertyScope result = PropertyScope.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyScopeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyValueType createPropertyValueTypeFromString(EDataType eDataType, String initialValue) {
		PropertyValueType result = PropertyValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyName createPropertyNameFromString(EDataType eDataType, String initialValue) {
		PropertyName result = PropertyName.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichSourceInlineType createEnrichSourceInlineTypeFromString(EDataType eDataType, String initialValue) {
		EnrichSourceInlineType result = EnrichSourceInlineType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnrichSourceInlineTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichSourceType createEnrichSourceTypeFromString(EDataType eDataType, String initialValue) {
		EnrichSourceType result = EnrichSourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnrichSourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichTargetAction createEnrichTargetActionFromString(EDataType eDataType, String initialValue) {
		EnrichTargetAction result = EnrichTargetAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnrichTargetActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichTargetType createEnrichTargetTypeFromString(EDataType eDataType, String initialValue) {
		EnrichTargetType result = EnrichTargetType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnrichTargetTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventTopicType createEventTopicTypeFromString(EDataType eDataType, String initialValue) {
		EventTopicType result = EventTopicType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventTopicTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementCallbackHandler createEntitlementCallbackHandlerFromString(EDataType eDataType, String initialValue) {
		EntitlementCallbackHandler result = EntitlementCallbackHandler.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntitlementCallbackHandlerToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementClientType createEntitlementClientTypeFromString(EDataType eDataType, String initialValue) {
		EntitlementClientType result = EntitlementClientType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntitlementClientTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementSequenceType createEntitlementSequenceTypeFromString(EDataType eDataType, String initialValue) {
		EntitlementSequenceType result = EntitlementSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntitlementSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scriptKeyTypeEnum createscriptKeyTypeEnumFromString(EDataType eDataType, String initialValue) {
		scriptKeyTypeEnum result = scriptKeyTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertscriptKeyTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptType createScriptTypeFromString(EDataType eDataType, String initialValue) {
		ScriptType result = ScriptType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScriptTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptLanguage createScriptLanguageFromString(EDataType eDataType, String initialValue) {
		ScriptLanguage result = ScriptLanguage.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScriptLanguageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultSoapVersion createFaultSoapVersionFromString(EDataType eDataType, String initialValue) {
		FaultSoapVersion result = FaultSoapVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultSoapVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeSoap11 createFaultCodeSoap11FromString(EDataType eDataType, String initialValue) {
		FaultCodeSoap11 result = FaultCodeSoap11.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultCodeSoap11ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeSoap12 createFaultCodeSoap12FromString(EDataType eDataType, String initialValue) {
		FaultCodeSoap12 result = FaultCodeSoap12.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultCodeSoap12ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultCodeType createFaultCodeTypeFromString(EDataType eDataType, String initialValue) {
		FaultCodeType result = FaultCodeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultCodeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultStringType createFaultStringTypeFromString(EDataType eDataType, String initialValue) {
		FaultStringType result = FaultStringType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultStringTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultReasonType createFaultReasonTypeFromString(EDataType eDataType, String initialValue) {
		FaultReasonType result = FaultReasonType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultReasonTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultDetailType createFaultDetailTypeFromString(EDataType eDataType, String initialValue) {
		FaultDetailType result = FaultDetailType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFaultDetailTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionMessagesType createCompletionMessagesTypeFromString(EDataType eDataType, String initialValue) {
		CompletionMessagesType result = CompletionMessagesType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompletionMessagesTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateSequenceType createAggregateSequenceTypeFromString(EDataType eDataType, String initialValue) {
		AggregateSequenceType result = AggregateSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAggregateSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSequenceType createTargetSequenceTypeFromString(EDataType eDataType, String initialValue) {
		TargetSequenceType result = TargetSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTargetSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetEndpointType createTargetEndpointTypeFromString(EDataType eDataType, String initialValue) {
		TargetEndpointType result = TargetEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTargetEndpointTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheSequenceType createCacheSequenceTypeFromString(EDataType eDataType, String initialValue) {
		CacheSequenceType result = CacheSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCacheSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheImplementationType createCacheImplementationTypeFromString(EDataType eDataType, String initialValue) {
		CacheImplementationType result = CacheImplementationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCacheImplementationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheAction createCacheActionFromString(EDataType eDataType, String initialValue) {
		CacheAction result = CacheAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCacheActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheScope createCacheScopeFromString(EDataType eDataType, String initialValue) {
		CacheScope result = CacheScope.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCacheScopeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryVariableType createXQueryVariableTypeFromString(EDataType eDataType, String initialValue) {
		XQueryVariableType result = XQueryVariableType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertXQueryVariableTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XQueryVariableValueType createXQueryVariableValueTypeFromString(EDataType eDataType, String initialValue) {
		XQueryVariableValueType result = XQueryVariableValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertXQueryVariableValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutEndpointType createCalloutEndpointTypeFromString(EDataType eDataType, String initialValue) {
		CalloutEndpointType result = CalloutEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCalloutEndpointTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutPayloadType createCalloutPayloadTypeFromString(EDataType eDataType, String initialValue) {
		CalloutPayloadType result = CalloutPayloadType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCalloutPayloadTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutSecurityPolicies createCalloutSecurityPoliciesFromString(EDataType eDataType, String initialValue) {
		CalloutSecurityPolicies result = CalloutSecurityPolicies.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCalloutSecurityPoliciesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutSecurityType createCalloutSecurityTypeFromString(EDataType eDataType, String initialValue) {
		CalloutSecurityType result = CalloutSecurityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCalloutSecurityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalloutResultType createCalloutResultTypeFromString(EDataType eDataType, String initialValue) {
		CalloutResultType result = CalloutResultType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCalloutResultTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSpecVersion createRMSpecVersionFromString(EDataType eDataType, String initialValue) {
		RMSpecVersion result = RMSpecVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRMSpecVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceType createRMSequenceTypeFromString(EDataType eDataType, String initialValue) {
		RMSequenceType result = RMSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRMSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionAction createTransactionActionFromString(EDataType eDataType, String initialValue) {
		TransactionAction result = TransactionAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransactionActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderAction createHeaderActionFromString(EDataType eDataType, String initialValue) {
		HeaderAction result = HeaderAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHeaderActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeaderValueType createHeaderValueTypeFromString(EDataType eDataType, String initialValue) {
		HeaderValueType result = HeaderValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHeaderValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType createScopeTypeFromString(EDataType eDataType, String initialValue) {
		ScopeType result = ScopeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScopeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottlePolicyType createThrottlePolicyTypeFromString(EDataType eDataType, String initialValue) {
		ThrottlePolicyType result = ThrottlePolicyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertThrottlePolicyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleConditionType createThrottleConditionTypeFromString(EDataType eDataType, String initialValue) {
		ThrottleConditionType result = ThrottleConditionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertThrottleConditionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleAccessType createThrottleAccessTypeFromString(EDataType eDataType, String initialValue) {
		ThrottleAccessType result = ThrottleAccessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertThrottleAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleSequenceType createThrottleSequenceTypeFromString(EDataType eDataType, String initialValue) {
		ThrottleSequenceType result = ThrottleSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertThrottleSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPropertyValueType createCommandPropertyValueTypeFromString(EDataType eDataType, String initialValue) {
		CommandPropertyValueType result = CommandPropertyValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCommandPropertyValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPropertyMessageAction createCommandPropertyMessageActionFromString(EDataType eDataType, String initialValue) {
		CommandPropertyMessageAction result = CommandPropertyMessageAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCommandPropertyMessageActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPropertyContextAction createCommandPropertyContextActionFromString(EDataType eDataType, String initialValue) {
		CommandPropertyContextAction result = CommandPropertyContextAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCommandPropertyContextActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorConnectionType createSqlExecutorConnectionTypeFromString(EDataType eDataType, String initialValue) {
		SqlExecutorConnectionType result = SqlExecutorConnectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSqlExecutorConnectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorDatasourceType createSqlExecutorDatasourceTypeFromString(EDataType eDataType, String initialValue) {
		SqlExecutorDatasourceType result = SqlExecutorDatasourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSqlExecutorDatasourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorBooleanValue createSqlExecutorBooleanValueFromString(EDataType eDataType, String initialValue) {
		SqlExecutorBooleanValue result = SqlExecutorBooleanValue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSqlExecutorBooleanValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorIsolationLevel createSqlExecutorIsolationLevelFromString(EDataType eDataType, String initialValue) {
		SqlExecutorIsolationLevel result = SqlExecutorIsolationLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSqlExecutorIsolationLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlParameterValueType createSqlParameterValueTypeFromString(EDataType eDataType, String initialValue) {
		SqlParameterValueType result = SqlParameterValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSqlParameterValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlParameterDataType createSqlParameterDataTypeFromString(EDataType eDataType, String initialValue) {
		SqlParameterDataType result = SqlParameterDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSqlParameterDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleActions createRuleActionsFromString(EDataType eDataType, String initialValue) {
		RuleActions result = RuleActions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleActionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleType createRuleTypeFromString(EDataType eDataType, String initialValue) {
		RuleType result = RuleType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSourceType createRuleSourceTypeFromString(EDataType eDataType, String initialValue) {
		RuleSourceType result = RuleSourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleSourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFactType createRuleFactTypeFromString(EDataType eDataType, String initialValue) {
		RuleFactType result = RuleFactType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleFactTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFactValueType createRuleFactValueTypeFromString(EDataType eDataType, String initialValue) {
		RuleFactValueType result = RuleFactValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleFactValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResultType createRuleResultTypeFromString(EDataType eDataType, String initialValue) {
		RuleResultType result = RuleResultType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleResultTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleResultValueType createRuleResultValueTypeFromString(EDataType eDataType, String initialValue) {
		RuleResultValueType result = RuleResultValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleResultValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleOptionType createRuleOptionTypeFromString(EDataType eDataType, String initialValue) {
		RuleOptionType result = RuleOptionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleOptionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksIODataType createSmooksIODataTypeFromString(EDataType eDataType, String initialValue) {
		SmooksIODataType result = SmooksIODataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSmooksIODataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksOutputDataType createSmooksOutputDataTypeFromString(EDataType eDataType, String initialValue) {
		SmooksOutputDataType result = SmooksOutputDataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSmooksOutputDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAction createExpressionActionFromString(EDataType eDataType, String initialValue) {
		ExpressionAction result = ExpressionAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpressionActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputMethod createOutputMethodFromString(EDataType eDataType, String initialValue) {
		OutputMethod result = OutputMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOutputMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceivingSequenceType createReceivingSequenceTypeFromString(EDataType eDataType, String initialValue) {
		ReceivingSequenceType result = ReceivingSequenceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReceivingSequenceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType createKeyTypeFromString(EDataType eDataType, String initialValue) {
		KeyType result = KeyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertKeyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaType createMediaTypeFromString(EDataType eDataType, String initialValue) {
		MediaType result = MediaType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMediaTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFactoryArgumentType createPayloadFactoryArgumentTypeFromString(EDataType eDataType, String initialValue) {
		PayloadFactoryArgumentType result = PayloadFactoryArgumentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPayloadFactoryArgumentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PayloadFormatType createPayloadFormatTypeFromString(EDataType eDataType, String initialValue) {
		PayloadFormatType result = PayloadFormatType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPayloadFormatTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createTypeFromString(EDataType eDataType, String initialValue) {
		Type result = Type.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadBalanceSessionType createLoadBalanceSessionTypeFromString(EDataType eDataType, String initialValue) {
		LoadBalanceSessionType result = LoadBalanceSessionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoadBalanceSessionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalEntryValueType createLocalEntryValueTypeFromString(EDataType eDataType, String initialValue) {
		LocalEntryValueType result = LocalEntryValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLocalEntryValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleActionType createRuleActionTypeFromString(EDataType eDataType, String initialValue) {
		RuleActionType result = RuleActionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleActionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleFragmentType createRuleFragmentTypeFromString(EDataType eDataType, String initialValue) {
		RuleFragmentType result = RuleFragmentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRuleFragmentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateType createTemplateTypeFromString(EDataType eDataType, String initialValue) {
		TemplateType result = TemplateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemplateTypeToString(EDataType eDataType, Object instanceValue) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecipientListEndpointType createRecipientListEndpointTypeFromString(EDataType eDataType, String initialValue) {
		RecipientListEndpointType result = RecipientListEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRecipientListEndpointTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageStoreType createMessageStoreTypeFromString(EDataType eDataType, String initialValue) {
		MessageStoreType result = MessageStoreType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageStoreTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSSpecVersion createJMSSpecVersionFromString(EDataType eDataType, String initialValue) {
		JMSSpecVersion result = JMSSpecVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJMSSpecVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDBCConnectionInformationType createJDBCConnectionInformationTypeFromString(EDataType eDataType, String initialValue) {
		JDBCConnectionInformationType result = JDBCConnectionInformationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJDBCConnectionInformationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageProcessorType createMessageProcessorTypeFromString(EDataType eDataType, String initialValue) {
		MessageProcessorType result = MessageProcessorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageProcessorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorState createProcessorStateFromString(EDataType eDataType, String initialValue) {
		ProcessorState result = ProcessorState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessorStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloudConnectorOperationParamEditorType createCloudConnectorOperationParamEditorTypeFromString(EDataType eDataType, String initialValue) {
		CloudConnectorOperationParamEditorType result = CloudConnectorOperationParamEditorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCloudConnectorOperationParamEditorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorDataTypes createDataMapperMediatorDataTypesFromString(EDataType eDataType, String initialValue) {
		DataMapperMediatorDataTypes result = DataMapperMediatorDataTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataMapperMediatorDataTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol createProtocolFromString(EDataType eDataType, String initialValue) {
		Protocol result = Protocol.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProtocolToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointType createInboundEndpointTypeFromString(EDataType eDataType, String initialValue) {
		InboundEndpointType result = InboundEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInboundEndpointTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InboundEndpointBehaviourType createInboundEndpointBehaviourTypeFromString(EDataType eDataType, String initialValue) {
		InboundEndpointBehaviourType result = InboundEndpointBehaviourType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInboundEndpointBehaviourTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentType createContentTypeFromString(EDataType eDataType, String initialValue) {
		ContentType result = ContentType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicsType createTopicsTypeFromString(EDataType eDataType, String initialValue) {
		TopicsType result = TopicsType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTopicsTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopicFilterFromType createTopicFilterFromTypeFromString(EDataType eDataType, String initialValue) {
		TopicFilterFromType result = TopicFilterFromType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTopicFilterFromTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerType createConsumerTypeFromString(EDataType eDataType, String initialValue) {
		ConsumerType result = ConsumerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConsumerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoOffsetResetType createAutoOffsetResetTypeFromString(EDataType eDataType, String initialValue) {
		AutoOffsetResetType result = AutoOffsetResetType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAutoOffsetResetTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitionAssignmentStrategyType createPartitionAssignmentStrategyTypeFromString(EDataType eDataType, String initialValue) {
		PartitionAssignmentStrategyType result = PartitionAssignmentStrategyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPartitionAssignmentStrategyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OffsetsStorageType createOffsetsStorageTypeFromString(EDataType eDataType, String initialValue) {
		OffsetsStorageType result = OffsetsStorageType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOffsetsStorageTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enable createEnableFromString(EDataType eDataType, String initialValue) {
		Enable result = Enable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VFSAction createVFSActionFromString(EDataType eDataType, String initialValue) {
		VFSAction result = VFSAction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVFSActionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VFSFileSort createVFSFileSortFromString(EDataType eDataType, String initialValue) {
		VFSFileSort result = VFSFileSort.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVFSFileSortToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSConnectionFactoryType createJMSConnectionFactoryTypeFromString(EDataType eDataType, String initialValue) {
		JMSConnectionFactoryType result = JMSConnectionFactoryType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJMSConnectionFactoryTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSSessionAcknowledgement createJMSSessionAcknowledgementFromString(EDataType eDataType, String initialValue) {
		JMSSessionAcknowledgement result = JMSSessionAcknowledgement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJMSSessionAcknowledgementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JMSCacheLevel createJMSCacheLevelFromString(EDataType eDataType, String initialValue) {
		JMSCacheLevel result = JMSCacheLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJMSCacheLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MQTTSubscriptionQOS createMQTTSubscriptionQOSFromString(EDataType eDataType, String initialValue) {
		MQTTSubscriptionQOS result = MQTTSubscriptionQOS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMQTTSubscriptionQOSToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeedType createFeedTypeFromString(EDataType eDataType, String initialValue) {
		FeedType result = FeedType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeedTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnableDisableState createEnableDisableStateFromString(EDataType eDataType, String initialValue) {
		EnableDisableState result = EnableDisableState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnableDisableStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbPackage getEsbPackage() {
		return (EsbPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EsbPackage getPackage() {
		return EsbPackage.eINSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	public EvaluatorExpressionProperty copyEvaluatorExpressionProperty(
			EvaluatorExpressionProperty evaluatorExpressionProperty) {
		EvaluatorExpressionProperty copy = createEvaluatorExpressionProperty();
		copy.setEvaluatorName(evaluatorExpressionProperty.getEvaluatorName());
		copy.setEvaluatorValue(evaluatorExpressionProperty.getEvaluatorValue());
		copy.setPrettyName(evaluatorExpressionProperty.getPrettyName());
		return copy;
	}

} //EsbFactoryImpl
