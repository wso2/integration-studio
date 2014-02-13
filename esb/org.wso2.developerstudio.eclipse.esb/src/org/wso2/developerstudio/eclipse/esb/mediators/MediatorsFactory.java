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
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage
 * @generated
 */
public interface MediatorsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MediatorsFactory eINSTANCE = org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>In Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Mediator</em>'.
	 * @generated
	 */
	InMediator createInMediator();

	/**
	 * Returns a new object of class '<em>Out Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Out Mediator</em>'.
	 * @generated
	 */
	OutMediator createOutMediator();

	/**
	 * Returns a new object of class '<em>Drop Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drop Mediator</em>'.
	 * @generated
	 */
	DropMediator createDropMediator();

	/**
	 * Returns a new object of class '<em>Send Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Mediator</em>'.
	 * @generated
	 */
	SendMediator createSendMediator();

	/**
	 * Returns a new object of class '<em>Log Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Mediator</em>'.
	 * @generated
	 */
	LogMediator createLogMediator();

	/**
	 * Returns a new object of class '<em>Log Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log Property</em>'.
	 * @generated
	 */
	LogProperty createLogProperty();

	/**
	 * Returns a new object of class '<em>Filter Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Mediator</em>'.
	 * @generated
	 */
	FilterMediator createFilterMediator();

	/**
	 * Returns a new object of class '<em>Filter Then Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Then Branch</em>'.
	 * @generated
	 */
	FilterThenBranch createFilterThenBranch();

	/**
	 * Returns a new object of class '<em>Filter Else Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Else Branch</em>'.
	 * @generated
	 */
	FilterElseBranch createFilterElseBranch();

	/**
	 * Returns a new object of class '<em>Switch Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Mediator</em>'.
	 * @generated
	 */
	SwitchMediator createSwitchMediator();

	/**
	 * Returns a new object of class '<em>Switch Case Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case Branch</em>'.
	 * @generated
	 */
	SwitchCaseBranch createSwitchCaseBranch();

	/**
	 * Returns a new object of class '<em>Switch Default Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Default Branch</em>'.
	 * @generated
	 */
	SwitchDefaultBranch createSwitchDefaultBranch();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator</em>'.
	 * @generated
	 */
	EntitlementMediator createEntitlementMediator();

	/**
	 * Returns a new object of class '<em>Entitlement Advice Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Advice Branch</em>'.
	 * @generated
	 */
	EntitlementAdviceBranch createEntitlementAdviceBranch();

	/**
	 * Returns a new object of class '<em>Entitlement Obligations Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Obligations Branch</em>'.
	 * @generated
	 */
	EntitlementObligationsBranch createEntitlementObligationsBranch();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator On Reject Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator On Reject Branch</em>'.
	 * @generated
	 */
	EntitlementMediatorOnRejectBranch createEntitlementMediatorOnRejectBranch();

	/**
	 * Returns a new object of class '<em>Entitlement Mediator On Accept Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entitlement Mediator On Accept Branch</em>'.
	 * @generated
	 */
	EntitlementMediatorOnAcceptBranch createEntitlementMediatorOnAcceptBranch();

	/**
	 * Returns a new object of class '<em>Enqueue Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enqueue Mediator</em>'.
	 * @generated
	 */
	EnqueueMediator createEnqueueMediator();

	/**
	 * Returns a new object of class '<em>Class Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Mediator</em>'.
	 * @generated
	 */
	ClassMediator createClassMediator();

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
	 * Returns a new object of class '<em>Validate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Mediator</em>'.
	 * @generated
	 */
	ValidateMediator createValidateMediator();

	/**
	 * Returns a new object of class '<em>Validate On Fail Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate On Fail Branch</em>'.
	 * @generated
	 */
	ValidateOnFailBranch createValidateOnFailBranch();

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
	 * Returns a new object of class '<em>Validate Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Resource</em>'.
	 * @generated
	 */
	ValidateResource createValidateResource();

	/**
	 * Returns a new object of class '<em>Script Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Mediator</em>'.
	 * @generated
	 */
	ScriptMediator createScriptMediator();

	/**
	 * Returns a new object of class '<em>Enrich Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enrich Mediator</em>'.
	 * @generated
	 */
	EnrichMediator createEnrichMediator();

	/**
	 * Returns a new object of class '<em>Fault Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Mediator</em>'.
	 * @generated
	 */
	FaultMediator createFaultMediator();

	/**
	 * Returns a new object of class '<em>Aggregate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregate Mediator</em>'.
	 * @generated
	 */
	AggregateMediator createAggregateMediator();

	/**
	 * Returns a new object of class '<em>Aggregate On Complete Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregate On Complete Branch</em>'.
	 * @generated
	 */
	AggregateOnCompleteBranch createAggregateOnCompleteBranch();

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
	 * Returns a new object of class '<em>Route Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Route Target</em>'.
	 * @generated
	 */
	RouteTarget createRouteTarget();

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
	 * Returns a new object of class '<em>Iterate Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Mediator</em>'.
	 * @generated
	 */
	IterateMediator createIterateMediator();

	/**
	 * Returns a new object of class '<em>Iterate Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Target</em>'.
	 * @generated
	 */
	IterateTarget createIterateTarget();

	/**
	 * Returns a new object of class '<em>Cache Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Mediator</em>'.
	 * @generated
	 */
	CacheMediator createCacheMediator();

	/**
	 * Returns a new object of class '<em>Cache On Hit Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache On Hit Branch</em>'.
	 * @generated
	 */
	CacheOnHitBranch createCacheOnHitBranch();

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
	 * Returns a new object of class '<em>XQuery Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XQuery Mediator</em>'.
	 * @generated
	 */
	XQueryMediator createXQueryMediator();

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
	 * Returns a new object of class '<em>RM Sequence Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RM Sequence Mediator</em>'.
	 * @generated
	 */
	RMSequenceMediator createRMSequenceMediator();

	/**
	 * Returns a new object of class '<em>Transaction Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transaction Mediator</em>'.
	 * @generated
	 */
	TransactionMediator createTransactionMediator();

	/**
	 * Returns a new object of class '<em>Property Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Mediator</em>'.
	 * @generated
	 */
	PropertyMediator createPropertyMediator();

	/**
	 * Returns a new object of class '<em>OAuth Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OAuth Mediator</em>'.
	 * @generated
	 */
	OAuthMediator createOAuthMediator();

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
	 * Returns a new object of class '<em>Throttle Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throttle Mediator</em>'.
	 * @generated
	 */
	ThrottleMediator createThrottleMediator();

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
	 * Returns a new object of class '<em>Command Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Mediator</em>'.
	 * @generated
	 */
	CommandMediator createCommandMediator();

	/**
	 * Returns a new object of class '<em>Command Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Property</em>'.
	 * @generated
	 */
	CommandProperty createCommandProperty();

	/**
	 * Returns a new object of class '<em>Event Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Mediator</em>'.
	 * @generated
	 */
	EventMediator createEventMediator();

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
	 * Returns a new object of class '<em>DB Report Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DB Report Mediator</em>'.
	 * @generated
	 */
	DBReportMediator createDBReportMediator();

	/**
	 * Returns a new object of class '<em>Rule Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Mediator</em>'.
	 * @generated
	 */
	RuleMediator createRuleMediator();

	/**
	 * Returns a new object of class '<em>Rule Set Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Set Configuration</em>'.
	 * @generated
	 */
	RuleSetConfiguration createRuleSetConfiguration();

	/**
	 * Returns a new object of class '<em>Rule Set Creation Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Set Creation Property</em>'.
	 * @generated
	 */
	RuleSetCreationProperty createRuleSetCreationProperty();

	/**
	 * Returns a new object of class '<em>Rule Session Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Session Configuration</em>'.
	 * @generated
	 */
	RuleSessionConfiguration createRuleSessionConfiguration();

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
	 * Returns a new object of class '<em>Sequence Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Mediator</em>'.
	 * @generated
	 */
	SequenceMediator createSequenceMediator();

	/**
	 * Returns a new object of class '<em>Builder Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builder Mediator</em>'.
	 * @generated
	 */
	BuilderMediator createBuilderMediator();

	/**
	 * Returns a new object of class '<em>Message Builder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Builder</em>'.
	 * @generated
	 */
	MessageBuilder createMessageBuilder();

	/**
	 * Returns a new object of class '<em>Smooks Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smooks Mediator</em>'.
	 * @generated
	 */
	SmooksMediator createSmooksMediator();

	/**
	 * Returns a new object of class '<em>Smooks In Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smooks In Configuration</em>'.
	 * @generated
	 */
	SmooksInConfiguration createSmooksInConfiguration();

	/**
	 * Returns a new object of class '<em>Smooks Out Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Smooks Out Configuration</em>'.
	 * @generated
	 */
	SmooksOutConfiguration createSmooksOutConfiguration();

	/**
	 * Returns a new object of class '<em>Store Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store Mediator</em>'.
	 * @generated
	 */
	StoreMediator createStoreMediator();

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
	 * Returns a new object of class '<em>Call Template Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Template Mediator</em>'.
	 * @generated
	 */
	CallTemplateMediator createCallTemplateMediator();

	/**
	 * Returns a new object of class '<em>Call Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Template Parameter</em>'.
	 * @generated
	 */
	CallTemplateParameter createCallTemplateParameter();

	/**
	 * Returns a new object of class '<em>Payload Factory Mediator</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payload Factory Mediator</em>'.
	 * @generated
	 */
    PayloadFactoryMediator createPayloadFactoryMediator();

    /**
	 * Returns a new object of class '<em>Payload Factory Argument</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payload Factory Argument</em>'.
	 * @generated
	 */
    PayloadFactoryArgument createPayloadFactoryArgument();

    /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MediatorsPackage getMediatorsPackage();

} //MediatorsFactory
