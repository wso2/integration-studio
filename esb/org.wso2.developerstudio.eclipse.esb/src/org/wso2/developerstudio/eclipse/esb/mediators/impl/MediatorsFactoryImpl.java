/**
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
package org.wso2.developerstudio.eclipse.esb.mediators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.wso2.developerstudio.eclipse.esb.mediators.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MediatorsFactoryImpl extends EFactoryImpl implements MediatorsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MediatorsFactory init() {
		try {
			MediatorsFactory theMediatorsFactory = (MediatorsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/wso2/developerstudio/eclipse/esb/mediators"); 
			if (theMediatorsFactory != null) {
				return theMediatorsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MediatorsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorsFactoryImpl() {
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
			case MediatorsPackage.IN_MEDIATOR: return createInMediator();
			case MediatorsPackage.OUT_MEDIATOR: return createOutMediator();
			case MediatorsPackage.DROP_MEDIATOR: return createDropMediator();
			case MediatorsPackage.SEND_MEDIATOR: return createSendMediator();
			case MediatorsPackage.LOG_MEDIATOR: return createLogMediator();
			case MediatorsPackage.LOG_PROPERTY: return createLogProperty();
			case MediatorsPackage.FILTER_MEDIATOR: return createFilterMediator();
			case MediatorsPackage.FILTER_THEN_BRANCH: return createFilterThenBranch();
			case MediatorsPackage.FILTER_ELSE_BRANCH: return createFilterElseBranch();
			case MediatorsPackage.SWITCH_MEDIATOR: return createSwitchMediator();
			case MediatorsPackage.SWITCH_CASE_BRANCH: return createSwitchCaseBranch();
			case MediatorsPackage.SWITCH_DEFAULT_BRANCH: return createSwitchDefaultBranch();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR: return createEntitlementMediator();
			case MediatorsPackage.ENTITLEMENT_ADVICE_BRANCH: return createEntitlementAdviceBranch();
			case MediatorsPackage.ENTITLEMENT_OBLIGATIONS_BRANCH: return createEntitlementObligationsBranch();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH: return createEntitlementMediatorOnRejectBranch();
			case MediatorsPackage.ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH: return createEntitlementMediatorOnAcceptBranch();
			case MediatorsPackage.ENQUEUE_MEDIATOR: return createEnqueueMediator();
			case MediatorsPackage.CLASS_MEDIATOR: return createClassMediator();
			case MediatorsPackage.CLASS_PROPERTY: return createClassProperty();
			case MediatorsPackage.SPRING_MEDIATOR: return createSpringMediator();
			case MediatorsPackage.VALIDATE_MEDIATOR: return createValidateMediator();
			case MediatorsPackage.VALIDATE_ON_FAIL_BRANCH: return createValidateOnFailBranch();
			case MediatorsPackage.VALIDATE_FEATURE: return createValidateFeature();
			case MediatorsPackage.VALIDATE_SCHEMA: return createValidateSchema();
			case MediatorsPackage.VALIDATE_RESOURCE: return createValidateResource();
			case MediatorsPackage.SCRIPT_MEDIATOR: return createScriptMediator();
			case MediatorsPackage.ENRICH_MEDIATOR: return createEnrichMediator();
			case MediatorsPackage.FAULT_MEDIATOR: return createFaultMediator();
			case MediatorsPackage.AGGREGATE_MEDIATOR: return createAggregateMediator();
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH: return createAggregateOnCompleteBranch();
			case MediatorsPackage.ROUTER_MEDIATOR: return createRouterMediator();
			case MediatorsPackage.ROUTER_ROUTE: return createRouterRoute();
			case MediatorsPackage.ROUTE_TARGET: return createRouteTarget();
			case MediatorsPackage.CLONE_MEDIATOR: return createCloneMediator();
			case MediatorsPackage.CLONE_TARGET: return createCloneTarget();
			case MediatorsPackage.ITERATE_MEDIATOR: return createIterateMediator();
			case MediatorsPackage.ITERATE_TARGET: return createIterateTarget();
			case MediatorsPackage.CACHE_MEDIATOR: return createCacheMediator();
			case MediatorsPackage.CACHE_ON_HIT_BRANCH: return createCacheOnHitBranch();
			case MediatorsPackage.XSLT_MEDIATOR: return createXSLTMediator();
			case MediatorsPackage.XSLT_PROPERTY: return createXSLTProperty();
			case MediatorsPackage.XSLT_FEATURE: return createXSLTFeature();
			case MediatorsPackage.XSLT_RESOURCE: return createXSLTResource();
			case MediatorsPackage.XQUERY_MEDIATOR: return createXQueryMediator();
			case MediatorsPackage.XQUERY_VARIABLE: return createXQueryVariable();
			case MediatorsPackage.CALLOUT_MEDIATOR: return createCalloutMediator();
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR: return createRMSequenceMediator();
			case MediatorsPackage.TRANSACTION_MEDIATOR: return createTransactionMediator();
			case MediatorsPackage.PROPERTY_MEDIATOR: return createPropertyMediator();
			case MediatorsPackage.OAUTH_MEDIATOR: return createOAuthMediator();
			case MediatorsPackage.AUTOSCALE_IN_MEDIATOR: return createAutoscaleInMediator();
			case MediatorsPackage.AUTOSCALE_OUT_MEDIATOR: return createAutoscaleOutMediator();
			case MediatorsPackage.HEADER_MEDIATOR: return createHeaderMediator();
			case MediatorsPackage.THROTTLE_MEDIATOR: return createThrottleMediator();
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION: return createThrottlePolicyConfiguration();
			case MediatorsPackage.THROTTLE_POLICY_ENTRY: return createThrottlePolicyEntry();
			case MediatorsPackage.THROTTLE_ON_ACCEPT_BRANCH: return createThrottleOnAcceptBranch();
			case MediatorsPackage.THROTTLE_ON_REJECT_BRANCH: return createThrottleOnRejectBranch();
			case MediatorsPackage.COMMAND_MEDIATOR: return createCommandMediator();
			case MediatorsPackage.COMMAND_PROPERTY: return createCommandProperty();
			case MediatorsPackage.EVENT_MEDIATOR: return createEventMediator();
			case MediatorsPackage.SQL_STATEMENT: return createSqlStatement();
			case MediatorsPackage.SQL_PARAMETER_DEFINITION: return createSqlParameterDefinition();
			case MediatorsPackage.SQL_RESULT_MAPPING: return createSqlResultMapping();
			case MediatorsPackage.DB_LOOKUP_MEDIATOR: return createDBLookupMediator();
			case MediatorsPackage.DB_REPORT_MEDIATOR: return createDBReportMediator();
			case MediatorsPackage.RULE_MEDIATOR: return createRuleMediator();
			case MediatorsPackage.RULE_SET_CONFIGURATION: return createRuleSetConfiguration();
			case MediatorsPackage.RULE_SET_CREATION_PROPERTY: return createRuleSetCreationProperty();
			case MediatorsPackage.RULE_SESSION_CONFIGURATION: return createRuleSessionConfiguration();
			case MediatorsPackage.RULE_SESSION_PROPERTY: return createRuleSessionProperty();
			case MediatorsPackage.RULE_FACTS_CONFIGURATION: return createRuleFactsConfiguration();
			case MediatorsPackage.RULE_FACT: return createRuleFact();
			case MediatorsPackage.RULE_RESULTS_CONFIGURATION: return createRuleResultsConfiguration();
			case MediatorsPackage.RULE_RESULT: return createRuleResult();
			case MediatorsPackage.RULE_CHILD_MEDIATORS_CONFIGURATION: return createRuleChildMediatorsConfiguration();
			case MediatorsPackage.SEQUENCE_MEDIATOR: return createSequenceMediator();
			case MediatorsPackage.BUILDER_MEDIATOR: return createBuilderMediator();
			case MediatorsPackage.MESSAGE_BUILDER: return createMessageBuilder();
			case MediatorsPackage.SMOOKS_MEDIATOR: return createSmooksMediator();
			case MediatorsPackage.SMOOKS_IN_CONFIGURATION: return createSmooksInConfiguration();
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION: return createSmooksOutConfiguration();
			case MediatorsPackage.STORE_MEDIATOR: return createStoreMediator();
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH: return createConditionalRouteBranch();
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR: return createConditionalRouterMediator();
			case MediatorsPackage.URL_REWRITE_RULE_ACTION: return createURLRewriteRuleAction();
			case MediatorsPackage.URL_REWRITE_RULE: return createURLRewriteRule();
			case MediatorsPackage.URL_REWRITE_MEDIATOR: return createURLRewriteMediator();
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR: return createCallTemplateMediator();
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER: return createCallTemplateParameter();
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR: return createPayloadFactoryMediator();
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT: return createPayloadFactoryArgument();
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
			case MediatorsPackage.LOG_CATEGORY:
				return createLogCategoryFromString(eDataType, initialValue);
			case MediatorsPackage.LOG_LEVEL:
				return createLogLevelFromString(eDataType, initialValue);
			case MediatorsPackage.FILTER_CONDITION_TYPE:
				return createFilterConditionTypeFromString(eDataType, initialValue);
			case MediatorsPackage.ENTITLEMENT_SEQUENCE:
				return createEntitlementSequenceFromString(eDataType, initialValue);
			case MediatorsPackage.SCRIPT_TYPE:
				return createScriptTypeFromString(eDataType, initialValue);
			case MediatorsPackage.SCRIPT_LANGUAGE:
				return createScriptLanguageFromString(eDataType, initialValue);
			case MediatorsPackage.ENRICH_SOURCE_TYPE:
				return createEnrichSourceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.ENRICH_TARGET_ACTION:
				return createEnrichTargetActionFromString(eDataType, initialValue);
			case MediatorsPackage.ENRICH_TARGET_TYPE:
				return createEnrichTargetTypeFromString(eDataType, initialValue);
			case MediatorsPackage.FAULT_SOAP_VERSION:
				return createFaultSoapVersionFromString(eDataType, initialValue);
			case MediatorsPackage.FAULT_CODE_SOAP11:
				return createFaultCodeSoap11FromString(eDataType, initialValue);
			case MediatorsPackage.FAULT_CODE_SOAP12:
				return createFaultCodeSoap12FromString(eDataType, initialValue);
			case MediatorsPackage.FAULT_STRING_TYPE:
				return createFaultStringTypeFromString(eDataType, initialValue);
			case MediatorsPackage.FAULT_REASON_TYPE:
				return createFaultReasonTypeFromString(eDataType, initialValue);
			case MediatorsPackage.FAULT_DETAIL_TYPE:
				return createFaultDetailTypeFromString(eDataType, initialValue);
			case MediatorsPackage.AGGREGATE_SEQUENCE_TYPE:
				return createAggregateSequenceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.CACHE_SEQUENCE_TYPE:
				return createCacheSequenceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.CACHE_IMPLEMENTATION_TYPE:
				return createCacheImplementationTypeFromString(eDataType, initialValue);
			case MediatorsPackage.CACHE_ACTION:
				return createCacheActionFromString(eDataType, initialValue);
			case MediatorsPackage.CACHE_SCOPE:
				return createCacheScopeFromString(eDataType, initialValue);
			case MediatorsPackage.XQUERY_VARIABLE_TYPE:
				return createXQueryVariableTypeFromString(eDataType, initialValue);
			case MediatorsPackage.XQUERY_VARIABLE_VALUE_TYPE:
				return createXQueryVariableValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.CALLOUT_PAYLOAD_TYPE:
				return createCalloutPayloadTypeFromString(eDataType, initialValue);
			case MediatorsPackage.CALLOUT_RESULT_TYPE:
				return createCalloutResultTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RM_SPEC_VERSION:
				return createRMSpecVersionFromString(eDataType, initialValue);
			case MediatorsPackage.RM_SEQUENCE_TYPE:
				return createRMSequenceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.TRANSACTION_ACTION:
				return createTransactionActionFromString(eDataType, initialValue);
			case MediatorsPackage.PROPERTY_DATA_TYPE:
				return createPropertyDataTypeFromString(eDataType, initialValue);
			case MediatorsPackage.PROPERTY_ACTION:
				return createPropertyActionFromString(eDataType, initialValue);
			case MediatorsPackage.PROPERTY_SCOPE:
				return createPropertyScopeFromString(eDataType, initialValue);
			case MediatorsPackage.PROPERTY_VALUE_TYPE:
				return createPropertyValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.HEADER_ACTION:
				return createHeaderActionFromString(eDataType, initialValue);
			case MediatorsPackage.HEADER_VALUE_TYPE:
				return createHeaderValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.THROTTLE_POLICY_TYPE:
				return createThrottlePolicyTypeFromString(eDataType, initialValue);
			case MediatorsPackage.THROTTLE_CONDITION_TYPE:
				return createThrottleConditionTypeFromString(eDataType, initialValue);
			case MediatorsPackage.THROTTLE_ACCESS_TYPE:
				return createThrottleAccessTypeFromString(eDataType, initialValue);
			case MediatorsPackage.THROTTLE_SEQUENCE_TYPE:
				return createThrottleSequenceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.COMMAND_PROPERTY_VALUE_TYPE:
				return createCommandPropertyValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.COMMAND_PROPERTY_MESSAGE_ACTION:
				return createCommandPropertyMessageActionFromString(eDataType, initialValue);
			case MediatorsPackage.COMMAND_PROPERTY_CONTEXT_ACTION:
				return createCommandPropertyContextActionFromString(eDataType, initialValue);
			case MediatorsPackage.SQL_EXECUTOR_CONNECTION_TYPE:
				return createSqlExecutorConnectionTypeFromString(eDataType, initialValue);
			case MediatorsPackage.SQL_EXECUTOR_DATASOURCE_TYPE:
				return createSqlExecutorDatasourceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.SQL_EXECUTOR_BOOLEAN_VALUE:
				return createSqlExecutorBooleanValueFromString(eDataType, initialValue);
			case MediatorsPackage.SQL_EXECUTOR_ISOLATION_LEVEL:
				return createSqlExecutorIsolationLevelFromString(eDataType, initialValue);
			case MediatorsPackage.SQL_PARAMETER_VALUE_TYPE:
				return createSqlParameterValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.SQL_PARAMETER_DATA_TYPE:
				return createSqlParameterDataTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_SOURCE_TYPE:
				return createRuleSourceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_FACT_TYPE:
				return createRuleFactTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_FACT_VALUE_TYPE:
				return createRuleFactValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_RESULT_TYPE:
				return createRuleResultTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_RESULT_VALUE_TYPE:
				return createRuleResultValueTypeFromString(eDataType, initialValue);
			case MediatorsPackage.SMOOKS_IO_DATA_TYPE:
				return createSmooksIODataTypeFromString(eDataType, initialValue);
			case MediatorsPackage.EXPRESSION_ACTION:
				return createExpressionActionFromString(eDataType, initialValue);
			case MediatorsPackage.OUTPUT_METHOD:
				return createOutputMethodFromString(eDataType, initialValue);
			case MediatorsPackage.RECEIVING_SEQUENCE_TYPE:
				return createReceivingSequenceTypeFromString(eDataType, initialValue);
			case MediatorsPackage.KEY_TYPE:
				return createKeyTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_ACTION_TYPE:
				return createRuleActionTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_FRAGMENT_TYPE:
				return createRuleFragmentTypeFromString(eDataType, initialValue);
			case MediatorsPackage.RULE_OPTION_TYPE:
				return createRuleOptionTypeFromString(eDataType, initialValue);
			case MediatorsPackage.ENRICH_SOURCE_INLINE_TYPE:
				return createEnrichSourceInlineTypeFromString(eDataType, initialValue);
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT_TYPE:
				return createPayloadFactoryArgumentTypeFromString(eDataType, initialValue);
			case MediatorsPackage.CALL_OUT_MEDIATOR_ENDPOINT_TYPE:
				return createCallOutMediatorEndpointTypeFromString(eDataType, initialValue);
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
			case MediatorsPackage.LOG_CATEGORY:
				return convertLogCategoryToString(eDataType, instanceValue);
			case MediatorsPackage.LOG_LEVEL:
				return convertLogLevelToString(eDataType, instanceValue);
			case MediatorsPackage.FILTER_CONDITION_TYPE:
				return convertFilterConditionTypeToString(eDataType, instanceValue);
			case MediatorsPackage.ENTITLEMENT_SEQUENCE:
				return convertEntitlementSequenceToString(eDataType, instanceValue);
			case MediatorsPackage.SCRIPT_TYPE:
				return convertScriptTypeToString(eDataType, instanceValue);
			case MediatorsPackage.SCRIPT_LANGUAGE:
				return convertScriptLanguageToString(eDataType, instanceValue);
			case MediatorsPackage.ENRICH_SOURCE_TYPE:
				return convertEnrichSourceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.ENRICH_TARGET_ACTION:
				return convertEnrichTargetActionToString(eDataType, instanceValue);
			case MediatorsPackage.ENRICH_TARGET_TYPE:
				return convertEnrichTargetTypeToString(eDataType, instanceValue);
			case MediatorsPackage.FAULT_SOAP_VERSION:
				return convertFaultSoapVersionToString(eDataType, instanceValue);
			case MediatorsPackage.FAULT_CODE_SOAP11:
				return convertFaultCodeSoap11ToString(eDataType, instanceValue);
			case MediatorsPackage.FAULT_CODE_SOAP12:
				return convertFaultCodeSoap12ToString(eDataType, instanceValue);
			case MediatorsPackage.FAULT_STRING_TYPE:
				return convertFaultStringTypeToString(eDataType, instanceValue);
			case MediatorsPackage.FAULT_REASON_TYPE:
				return convertFaultReasonTypeToString(eDataType, instanceValue);
			case MediatorsPackage.FAULT_DETAIL_TYPE:
				return convertFaultDetailTypeToString(eDataType, instanceValue);
			case MediatorsPackage.AGGREGATE_SEQUENCE_TYPE:
				return convertAggregateSequenceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.CACHE_SEQUENCE_TYPE:
				return convertCacheSequenceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.CACHE_IMPLEMENTATION_TYPE:
				return convertCacheImplementationTypeToString(eDataType, instanceValue);
			case MediatorsPackage.CACHE_ACTION:
				return convertCacheActionToString(eDataType, instanceValue);
			case MediatorsPackage.CACHE_SCOPE:
				return convertCacheScopeToString(eDataType, instanceValue);
			case MediatorsPackage.XQUERY_VARIABLE_TYPE:
				return convertXQueryVariableTypeToString(eDataType, instanceValue);
			case MediatorsPackage.XQUERY_VARIABLE_VALUE_TYPE:
				return convertXQueryVariableValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.CALLOUT_PAYLOAD_TYPE:
				return convertCalloutPayloadTypeToString(eDataType, instanceValue);
			case MediatorsPackage.CALLOUT_RESULT_TYPE:
				return convertCalloutResultTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RM_SPEC_VERSION:
				return convertRMSpecVersionToString(eDataType, instanceValue);
			case MediatorsPackage.RM_SEQUENCE_TYPE:
				return convertRMSequenceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.TRANSACTION_ACTION:
				return convertTransactionActionToString(eDataType, instanceValue);
			case MediatorsPackage.PROPERTY_DATA_TYPE:
				return convertPropertyDataTypeToString(eDataType, instanceValue);
			case MediatorsPackage.PROPERTY_ACTION:
				return convertPropertyActionToString(eDataType, instanceValue);
			case MediatorsPackage.PROPERTY_SCOPE:
				return convertPropertyScopeToString(eDataType, instanceValue);
			case MediatorsPackage.PROPERTY_VALUE_TYPE:
				return convertPropertyValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.HEADER_ACTION:
				return convertHeaderActionToString(eDataType, instanceValue);
			case MediatorsPackage.HEADER_VALUE_TYPE:
				return convertHeaderValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.THROTTLE_POLICY_TYPE:
				return convertThrottlePolicyTypeToString(eDataType, instanceValue);
			case MediatorsPackage.THROTTLE_CONDITION_TYPE:
				return convertThrottleConditionTypeToString(eDataType, instanceValue);
			case MediatorsPackage.THROTTLE_ACCESS_TYPE:
				return convertThrottleAccessTypeToString(eDataType, instanceValue);
			case MediatorsPackage.THROTTLE_SEQUENCE_TYPE:
				return convertThrottleSequenceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.COMMAND_PROPERTY_VALUE_TYPE:
				return convertCommandPropertyValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.COMMAND_PROPERTY_MESSAGE_ACTION:
				return convertCommandPropertyMessageActionToString(eDataType, instanceValue);
			case MediatorsPackage.COMMAND_PROPERTY_CONTEXT_ACTION:
				return convertCommandPropertyContextActionToString(eDataType, instanceValue);
			case MediatorsPackage.SQL_EXECUTOR_CONNECTION_TYPE:
				return convertSqlExecutorConnectionTypeToString(eDataType, instanceValue);
			case MediatorsPackage.SQL_EXECUTOR_DATASOURCE_TYPE:
				return convertSqlExecutorDatasourceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.SQL_EXECUTOR_BOOLEAN_VALUE:
				return convertSqlExecutorBooleanValueToString(eDataType, instanceValue);
			case MediatorsPackage.SQL_EXECUTOR_ISOLATION_LEVEL:
				return convertSqlExecutorIsolationLevelToString(eDataType, instanceValue);
			case MediatorsPackage.SQL_PARAMETER_VALUE_TYPE:
				return convertSqlParameterValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.SQL_PARAMETER_DATA_TYPE:
				return convertSqlParameterDataTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_SOURCE_TYPE:
				return convertRuleSourceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_FACT_TYPE:
				return convertRuleFactTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_FACT_VALUE_TYPE:
				return convertRuleFactValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_RESULT_TYPE:
				return convertRuleResultTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_RESULT_VALUE_TYPE:
				return convertRuleResultValueTypeToString(eDataType, instanceValue);
			case MediatorsPackage.SMOOKS_IO_DATA_TYPE:
				return convertSmooksIODataTypeToString(eDataType, instanceValue);
			case MediatorsPackage.EXPRESSION_ACTION:
				return convertExpressionActionToString(eDataType, instanceValue);
			case MediatorsPackage.OUTPUT_METHOD:
				return convertOutputMethodToString(eDataType, instanceValue);
			case MediatorsPackage.RECEIVING_SEQUENCE_TYPE:
				return convertReceivingSequenceTypeToString(eDataType, instanceValue);
			case MediatorsPackage.KEY_TYPE:
				return convertKeyTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_ACTION_TYPE:
				return convertRuleActionTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_FRAGMENT_TYPE:
				return convertRuleFragmentTypeToString(eDataType, instanceValue);
			case MediatorsPackage.RULE_OPTION_TYPE:
				return convertRuleOptionTypeToString(eDataType, instanceValue);
			case MediatorsPackage.ENRICH_SOURCE_INLINE_TYPE:
				return convertEnrichSourceInlineTypeToString(eDataType, instanceValue);
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT_TYPE:
				return convertPayloadFactoryArgumentTypeToString(eDataType, instanceValue);
			case MediatorsPackage.CALL_OUT_MEDIATOR_ENDPOINT_TYPE:
				return convertCallOutMediatorEndpointTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InMediator createInMediator() {
		InMediatorImpl inMediator = new InMediatorImpl();
		return inMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutMediator createOutMediator() {
		OutMediatorImpl outMediator = new OutMediatorImpl();
		return outMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DropMediator createDropMediator() {
		DropMediatorImpl dropMediator = new DropMediatorImpl();
		return dropMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendMediator createSendMediator() {
		SendMediatorImpl sendMediator = new SendMediatorImpl();
		return sendMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogMediator createLogMediator() {
		LogMediatorImpl logMediator = new LogMediatorImpl();
		return logMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogProperty createLogProperty() {
		LogPropertyImpl logProperty = new LogPropertyImpl();
		return logProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterMediator createFilterMediator() {
		FilterMediatorImpl filterMediator = new FilterMediatorImpl();
		return filterMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterThenBranch createFilterThenBranch() {
		FilterThenBranchImpl filterThenBranch = new FilterThenBranchImpl();
		return filterThenBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterElseBranch createFilterElseBranch() {
		FilterElseBranchImpl filterElseBranch = new FilterElseBranchImpl();
		return filterElseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchMediator createSwitchMediator() {
		SwitchMediatorImpl switchMediator = new SwitchMediatorImpl();
		return switchMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCaseBranch createSwitchCaseBranch() {
		SwitchCaseBranchImpl switchCaseBranch = new SwitchCaseBranchImpl();
		return switchCaseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchDefaultBranch createSwitchDefaultBranch() {
		SwitchDefaultBranchImpl switchDefaultBranch = new SwitchDefaultBranchImpl();
		return switchDefaultBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediator createEntitlementMediator() {
		EntitlementMediatorImpl entitlementMediator = new EntitlementMediatorImpl();
		return entitlementMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementAdviceBranch createEntitlementAdviceBranch() {
		EntitlementAdviceBranchImpl entitlementAdviceBranch = new EntitlementAdviceBranchImpl();
		return entitlementAdviceBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementObligationsBranch createEntitlementObligationsBranch() {
		EntitlementObligationsBranchImpl entitlementObligationsBranch = new EntitlementObligationsBranchImpl();
		return entitlementObligationsBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnRejectBranch createEntitlementMediatorOnRejectBranch() {
		EntitlementMediatorOnRejectBranchImpl entitlementMediatorOnRejectBranch = new EntitlementMediatorOnRejectBranchImpl();
		return entitlementMediatorOnRejectBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementMediatorOnAcceptBranch createEntitlementMediatorOnAcceptBranch() {
		EntitlementMediatorOnAcceptBranchImpl entitlementMediatorOnAcceptBranch = new EntitlementMediatorOnAcceptBranchImpl();
		return entitlementMediatorOnAcceptBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnqueueMediator createEnqueueMediator() {
		EnqueueMediatorImpl enqueueMediator = new EnqueueMediatorImpl();
		return enqueueMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMediator createClassMediator() {
		ClassMediatorImpl classMediator = new ClassMediatorImpl();
		return classMediator;
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
	 * @generated
	 */
	public SpringMediator createSpringMediator() {
		SpringMediatorImpl springMediator = new SpringMediatorImpl();
		return springMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateMediator createValidateMediator() {
		ValidateMediatorImpl validateMediator = new ValidateMediatorImpl();
		return validateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidateOnFailBranch createValidateOnFailBranch() {
		ValidateOnFailBranchImpl validateOnFailBranch = new ValidateOnFailBranchImpl();
		return validateOnFailBranch;
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
	public ValidateResource createValidateResource() {
		ValidateResourceImpl validateResource = new ValidateResourceImpl();
		return validateResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptMediator createScriptMediator() {
		ScriptMediatorImpl scriptMediator = new ScriptMediatorImpl();
		return scriptMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnrichMediator createEnrichMediator() {
		EnrichMediatorImpl enrichMediator = new EnrichMediatorImpl();
		return enrichMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultMediator createFaultMediator() {
		FaultMediatorImpl faultMediator = new FaultMediatorImpl();
		return faultMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateMediator createAggregateMediator() {
		AggregateMediatorImpl aggregateMediator = new AggregateMediatorImpl();
		return aggregateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateOnCompleteBranch createAggregateOnCompleteBranch() {
		AggregateOnCompleteBranchImpl aggregateOnCompleteBranch = new AggregateOnCompleteBranchImpl();
		return aggregateOnCompleteBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouterMediator createRouterMediator() {
		RouterMediatorImpl routerMediator = new RouterMediatorImpl();
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
	 * @generated
	 */
	public RouteTarget createRouteTarget() {
		RouteTargetImpl routeTarget = new RouteTargetImpl();
		return routeTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneMediator createCloneMediator() {
		CloneMediatorImpl cloneMediator = new CloneMediatorImpl();
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
	public IterateMediator createIterateMediator() {
		IterateMediatorImpl iterateMediator = new IterateMediatorImpl();
		return iterateMediator;
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
	public CacheMediator createCacheMediator() {
		CacheMediatorImpl cacheMediator = new CacheMediatorImpl();
		return cacheMediator;
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
	 * @generated
	 */
	public XSLTMediator createXSLTMediator() {
		XSLTMediatorImpl xsltMediator = new XSLTMediatorImpl();
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
	public XQueryMediator createXQueryMediator() {
		XQueryMediatorImpl xQueryMediator = new XQueryMediatorImpl();
		return xQueryMediator;
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
	 * @generated
	 */
	public CalloutMediator createCalloutMediator() {
		CalloutMediatorImpl calloutMediator = new CalloutMediatorImpl();
		return calloutMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RMSequenceMediator createRMSequenceMediator() {
		RMSequenceMediatorImpl rmSequenceMediator = new RMSequenceMediatorImpl();
		return rmSequenceMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionMediator createTransactionMediator() {
		TransactionMediatorImpl transactionMediator = new TransactionMediatorImpl();
		return transactionMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMediator createPropertyMediator() {
		PropertyMediatorImpl propertyMediator = new PropertyMediatorImpl();
		return propertyMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OAuthMediator createOAuthMediator() {
		OAuthMediatorImpl oAuthMediator = new OAuthMediatorImpl();
		return oAuthMediator;
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
	 * @generated
	 */
	public HeaderMediator createHeaderMediator() {
		HeaderMediatorImpl headerMediator = new HeaderMediatorImpl();
		return headerMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrottleMediator createThrottleMediator() {
		ThrottleMediatorImpl throttleMediator = new ThrottleMediatorImpl();
		return throttleMediator;
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
	 * @generated
	 */
	public CommandMediator createCommandMediator() {
		CommandMediatorImpl commandMediator = new CommandMediatorImpl();
		return commandMediator;
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
	public EventMediator createEventMediator() {
		EventMediatorImpl eventMediator = new EventMediatorImpl();
		return eventMediator;
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
	 * @generated
	 */
	public DBLookupMediator createDBLookupMediator() {
		DBLookupMediatorImpl dbLookupMediator = new DBLookupMediatorImpl();
		return dbLookupMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBReportMediator createDBReportMediator() {
		DBReportMediatorImpl dbReportMediator = new DBReportMediatorImpl();
		return dbReportMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleMediator createRuleMediator() {
		RuleMediatorImpl ruleMediator = new RuleMediatorImpl();
		return ruleMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSetConfiguration createRuleSetConfiguration() {
		RuleSetConfigurationImpl ruleSetConfiguration = new RuleSetConfigurationImpl();
		return ruleSetConfiguration;
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
	public RuleSessionConfiguration createRuleSessionConfiguration() {
		RuleSessionConfigurationImpl ruleSessionConfiguration = new RuleSessionConfigurationImpl();
		return ruleSessionConfiguration;
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
	 * @generated
	 */
	public SequenceMediator createSequenceMediator() {
		SequenceMediatorImpl sequenceMediator = new SequenceMediatorImpl();
		return sequenceMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuilderMediator createBuilderMediator() {
		BuilderMediatorImpl builderMediator = new BuilderMediatorImpl();
		return builderMediator;
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
	 * @generated
	 */
	public SmooksMediator createSmooksMediator() {
		SmooksMediatorImpl smooksMediator = new SmooksMediatorImpl();
		return smooksMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksInConfiguration createSmooksInConfiguration() {
		SmooksInConfigurationImpl smooksInConfiguration = new SmooksInConfigurationImpl();
		return smooksInConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SmooksOutConfiguration createSmooksOutConfiguration() {
		SmooksOutConfigurationImpl smooksOutConfiguration = new SmooksOutConfigurationImpl();
		return smooksOutConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreMediator createStoreMediator() {
		StoreMediatorImpl storeMediator = new StoreMediatorImpl();
		return storeMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouteBranch createConditionalRouteBranch() {
		ConditionalRouteBranchImpl conditionalRouteBranch = new ConditionalRouteBranchImpl();
		return conditionalRouteBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalRouterMediator createConditionalRouterMediator() {
		ConditionalRouterMediatorImpl conditionalRouterMediator = new ConditionalRouterMediatorImpl();
		return conditionalRouterMediator;
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
	 * @generated
	 */
	public URLRewriteMediator createURLRewriteMediator() {
		URLRewriteMediatorImpl urlRewriteMediator = new URLRewriteMediatorImpl();
		return urlRewriteMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateMediator createCallTemplateMediator() {
		CallTemplateMediatorImpl callTemplateMediator = new CallTemplateMediatorImpl();
		return callTemplateMediator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallTemplateParameter createCallTemplateParameter() {
		CallTemplateParameterImpl callTemplateParameter = new CallTemplateParameterImpl();
		return callTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PayloadFactoryMediator createPayloadFactoryMediator() {
		PayloadFactoryMediatorImpl payloadFactoryMediator = new PayloadFactoryMediatorImpl();
		return payloadFactoryMediator;
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
	public FilterConditionType createFilterConditionTypeFromString(EDataType eDataType, String initialValue) {
		FilterConditionType result = FilterConditionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFilterConditionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementSequence createEntitlementSequenceFromString(EDataType eDataType, String initialValue) {
		EntitlementSequence result = EntitlementSequence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEntitlementSequenceToString(EDataType eDataType, Object instanceValue) {
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
	public CallOutMediatorEndpointType createCallOutMediatorEndpointTypeFromString(EDataType eDataType, String initialValue) {
		CallOutMediatorEndpointType result = CallOutMediatorEndpointType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCallOutMediatorEndpointTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorsPackage getMediatorsPackage() {
		return (MediatorsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MediatorsPackage getPackage() {
		return MediatorsPackage.eINSTANCE;
	}

} //MediatorsFactoryImpl
