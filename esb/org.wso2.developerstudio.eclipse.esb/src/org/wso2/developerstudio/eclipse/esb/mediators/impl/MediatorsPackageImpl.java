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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.impl.EsbPackageImpl;
import org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleInMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleOutMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheAction;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheScope;
import org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType;
import org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType;
import org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ClassProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget;
import org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.DBLookupMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.DropMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType;
import org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType;
import org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction;
import org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence;
import org.wso2.developerstudio.eclipse.esb.mediators.EventMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion;
import org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterElseBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.FilterThenBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction;
import org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.InMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget;
import org.wso2.developerstudio.eclipse.esb.mediators.KeyType;
import org.wso2.developerstudio.eclipse.esb.mediators.LogCategory;
import org.wso2.developerstudio.eclipse.esb.mediators.LogLevel;
import org.wso2.developerstudio.eclipse.esb.mediators.LogMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.LogProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder;
import org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.OutMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope;
import org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion;
import org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.RouteTarget;
import org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleChildMediatorsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFact;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResult;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSetCreationProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ScriptType;
import org.wso2.developerstudio.eclipse.esb.mediators.SendMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping;
import org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement;
import org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.SwitchDefaultBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType;
import org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction;
import org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule;
import org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateOnFailBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource;
import org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType;
import org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty;
import org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource;
import org.wso2.developerstudio.eclipse.esb.mediators.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MediatorsPackageImpl extends EPackageImpl implements MediatorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterThenBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterElseBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchCaseBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchDefaultBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementAdviceBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementObligationsBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorOnRejectBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entitlementMediatorOnAcceptBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enqueueMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass springMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateOnFailBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enrichMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregateOnCompleteBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routerRouteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass routeTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheOnHitBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xsltResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xQueryMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xQueryVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calloutMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rmSequenceMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oAuthMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoscaleInMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoscaleOutMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttlePolicyConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttlePolicyEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleOnAcceptBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throttleOnRejectBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSqlExecutorMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlParameterDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sqlResultMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbLookupMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dbReportMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSetConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSetCreationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSessionConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSessionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleFactsConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleFactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleResultsConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleChildMediatorsConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageBuilderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smooksMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smooksInConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass smooksOutConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storeMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouteBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalRouterMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteRuleActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urlRewriteMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTemplateMediatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callTemplateParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass payloadFactoryMediatorEClass = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EClass payloadFactoryArgumentEClass = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logCategoryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum filterConditionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entitlementSequenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scriptTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scriptLanguageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichSourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichTargetActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichTargetTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultSoapVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultCodeSoap11EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultCodeSoap12EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultStringTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultReasonTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultDetailTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aggregateSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheImplementationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cacheScopeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum xQueryVariableTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum xQueryVariableValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutPayloadTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum calloutResultTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rmSpecVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rmSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transactionActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyDataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyScopeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum propertyValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum headerActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum headerValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttlePolicyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttleConditionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttleAccessTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum throttleSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandPropertyValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandPropertyMessageActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandPropertyContextActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorConnectionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorDatasourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorBooleanValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlExecutorIsolationLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlParameterValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sqlParameterDataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleSourceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleFactTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleFactValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleResultTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleResultValueTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum smooksIODataTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum expressionActionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum outputMethodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum receivingSequenceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum keyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleActionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleFragmentTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ruleOptionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enrichSourceInlineTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    private EEnum payloadFactoryArgumentTypeEEnum = null;

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum callOutMediatorEndpointTypeEEnum = null;

				/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MediatorsPackageImpl() {
		super(eNS_URI, MediatorsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MediatorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MediatorsPackage init() {
		if (isInited) return (MediatorsPackage)EPackage.Registry.INSTANCE.getEPackage(MediatorsPackage.eNS_URI);

		// Obtain or create and register package
		MediatorsPackageImpl theMediatorsPackage = (MediatorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MediatorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MediatorsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EsbPackageImpl theEsbPackage = (EsbPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EsbPackage.eNS_URI) instanceof EsbPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EsbPackage.eNS_URI) : EsbPackage.eINSTANCE);

		// Create package meta-data objects
		theMediatorsPackage.createPackageContents();
		theEsbPackage.createPackageContents();

		// Initialize created meta-data
		theMediatorsPackage.initializePackageContents();
		theEsbPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMediatorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MediatorsPackage.eNS_URI, theMediatorsPackage);
		return theMediatorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInMediator() {
		return inMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutMediator() {
		return outMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDropMediator() {
		return dropMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendMediator() {
		return sendMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_AnonymousEndPoint() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_EndPointReference() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSendMediator_ReceivingSequenceType() {
		return (EAttribute)sendMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_StaticReceivingSequence() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendMediator_DynamicReceivingSequence() {
		return (EReference)sendMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMediator() {
		return logMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMediator_LogCategory() {
		return (EAttribute)logMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMediator_LogLevel() {
		return (EAttribute)logMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMediator_LogSeparator() {
		return (EAttribute)logMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogMediator_Properties() {
		return (EReference)logMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogProperty() {
		return logPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterMediator() {
		return filterMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterMediator_ConditionType() {
		return (EAttribute)filterMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_FilterXpath() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_FilterSource() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterMediator_FilterRegex() {
		return (EAttribute)filterMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_ThenBranch() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFilterMediator_ElseBranch() {
		return (EReference)filterMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterThenBranch() {
		return filterThenBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterElseBranch() {
		return filterElseBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchMediator() {
		return switchMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_SourceXpath() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_CaseBranches() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchMediator_DefaultBranch() {
		return (EReference)switchMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchCaseBranch() {
		return switchCaseBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchCaseBranch_CaseRegex() {
		return (EAttribute)switchCaseBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchDefaultBranch() {
		return switchDefaultBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediator() {
		return entitlementMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_ServerURL() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_Username() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_Password() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OnAccept() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_OnReject() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_Obligations() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediator_Advice() {
		return (EReference)entitlementMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediator_CallbackClass() {
		return (EAttribute)entitlementMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementAdviceBranch() {
		return entitlementAdviceBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementAdviceBranch_SequenceType() {
		return (EAttribute)entitlementAdviceBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementAdviceBranch_SequenceKey() {
		return (EReference)entitlementAdviceBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementObligationsBranch() {
		return entitlementObligationsBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementObligationsBranch_SequenceType() {
		return (EAttribute)entitlementObligationsBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementObligationsBranch_SequenceKey() {
		return (EReference)entitlementObligationsBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorOnRejectBranch() {
		return entitlementMediatorOnRejectBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediatorOnRejectBranch_SequenceType() {
		return (EAttribute)entitlementMediatorOnRejectBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediatorOnRejectBranch_SequenceKey() {
		return (EReference)entitlementMediatorOnRejectBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntitlementMediatorOnAcceptBranch() {
		return entitlementMediatorOnAcceptBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntitlementMediatorOnAcceptBranch_SequenceType() {
		return (EAttribute)entitlementMediatorOnAcceptBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntitlementMediatorOnAcceptBranch_SequenceKey() {
		return (EReference)entitlementMediatorOnAcceptBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnqueueMediator() {
		return enqueueMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnqueueMediator_Executor() {
		return (EAttribute)enqueueMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnqueueMediator_Priority() {
		return (EAttribute)enqueueMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnqueueMediator_SequenceKey() {
		return (EReference)enqueueMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassMediator() {
		return classMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMediator_ClassName() {
		return (EAttribute)classMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassMediator_Properties() {
		return (EReference)classMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassProperty() {
		return classPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpringMediator() {
		return springMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpringMediator_BeanName() {
		return (EAttribute)springMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpringMediator_ConfigurationKey() {
		return (EReference)springMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateMediator() {
		return validateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_SourceXpath() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_OnFailBranch() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_Features() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_Schemas() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateMediator_Resources() {
		return (EReference)validateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateOnFailBranch() {
		return validateOnFailBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateFeature() {
		return validateFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateSchema() {
		return validateSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateSchema_ValidateStaticSchemaKey() {
		return (EReference)validateSchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateSchema_ValidateDynamicSchemaKey() {
		return (EReference)validateSchemaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValidateSchema_ValidateSchemaKeyType() {
		return (EAttribute)validateSchemaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidateSchema_SchemaKey() {
		return (EReference)validateSchemaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidateResource() {
		return validateResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptMediator() {
		return scriptMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_ScriptType() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_ScriptLanguage() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_MediateFunction() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScriptMediator_ScriptKey() {
		return (EReference)scriptMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptMediator_ScriptBody() {
		return (EAttribute)scriptMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnrichMediator() {
		return enrichMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_CloneSource() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_SourceType() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_SourceXpath() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_SourceProperty() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_SourceXML() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_TargetAction() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_TargetType() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_TargetXpath() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_TargetProperty() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnrichMediator_InlineType() {
		return (EAttribute)enrichMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnrichMediator_InlineRegistryKey() {
		return (EReference)enrichMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultMediator() {
		return faultMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_SoapVersion() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultCodeSoap11() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultStringType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultStringValue() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultStringExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultActor() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultCodeSoap12() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultReasonType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultReasonValue() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultReasonExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_RoleName() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_NodeName() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultDetailType() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultMediator_FaultDetailValue() {
		return (EAttribute)faultMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultMediator_FaultDetailExpression() {
		return (EReference)faultMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregateMediator() {
		return aggregateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_CorrelationExpression() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionTimeout() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionMinMessages() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_CompletionMaxMessages() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateMediator_OnCompleteBranch() {
		return (EReference)aggregateMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateMediator_AggregateID() {
		return (EAttribute)aggregateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregateOnCompleteBranch() {
		return aggregateOnCompleteBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateOnCompleteBranch_AggregationExpression() {
		return (EReference)aggregateOnCompleteBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregateOnCompleteBranch_SequenceType() {
		return (EAttribute)aggregateOnCompleteBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregateOnCompleteBranch_SequenceKey() {
		return (EReference)aggregateOnCompleteBranchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterMediator() {
		return routerMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterMediator_ContinueAfterRouting() {
		return (EAttribute)routerMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterMediator_Routes() {
		return (EReference)routerMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouterRoute() {
		return routerRouteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterRoute_BreakAfterRoute() {
		return (EAttribute)routerRouteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterRoute_RouteExpression() {
		return (EReference)routerRouteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRouterRoute_RoutePattern() {
		return (EAttribute)routerRouteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRouterRoute_Target() {
		return (EReference)routerRouteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRouteTarget() {
		return routeTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneMediator() {
		return cloneMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediator_CloneID() {
		return (EAttribute)cloneMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediator_SequentialMediation() {
		return (EAttribute)cloneMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneMediator_ContinueParent() {
		return (EAttribute)cloneMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneMediator_Targets() {
		return (EReference)cloneMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneTarget() {
		return cloneTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneTarget_SoapAction() {
		return (EAttribute)cloneTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneTarget_ToAddress() {
		return (EAttribute)cloneTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateMediator() {
		return iterateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_IterateID() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_SequentialMediation() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_ContinueParent() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateMediator_PreservePayload() {
		return (EAttribute)iterateMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_IterateExpression() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_AttachPath() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateMediator_Target() {
		return (EReference)iterateMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateTarget() {
		return iterateTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateTarget_SoapAction() {
		return (EAttribute)iterateTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterateTarget_ToAddress() {
		return (EAttribute)iterateTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMediator() {
		return cacheMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheId() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheScope() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheAction() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_HashGenerator() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_CacheTimeout() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_MaxMessageSize() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_ImplementationType() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMediator_MaxEntryCount() {
		return (EAttribute)cacheMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMediator_OnHitBranch() {
		return (EReference)cacheMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheOnHitBranch() {
		return cacheOnHitBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheOnHitBranch_SequenceType() {
		return (EAttribute)cacheOnHitBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheOnHitBranch_SequenceKey() {
		return (EReference)cacheOnHitBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTMediator() {
		return xsltMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_SourceXPath() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_XsltKey() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_Properties() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_Features() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_Resources() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXSLTMediator_XsltSchemaKeyType() {
		return (EAttribute)xsltMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_XsltStaticSchemaKey() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSLTMediator_XsltDynamicSchemaKey() {
		return (EReference)xsltMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTProperty() {
		return xsltPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTFeature() {
		return xsltFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSLTResource() {
		return xsltResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXQueryMediator() {
		return xQueryMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_TargetXPath() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryMediator_ScriptKeyType() {
		return (EAttribute)xQueryMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_StaticScriptKey() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_DynamicScriptKey() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_QueryKey() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryMediator_Variables() {
		return (EReference)xQueryMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXQueryVariable() {
		return xQueryVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_VariableName() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_VariableType() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_ValueType() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXQueryVariable_ValueLiteral() {
		return (EAttribute)xQueryVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryVariable_ValueExpression() {
		return (EReference)xQueryVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXQueryVariable_ValueKey() {
		return (EReference)xQueryVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalloutMediator() {
		return calloutMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_ServiceURL() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_SoapAction() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PathToAxis2xml() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PathToAxis2Repository() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PayloadType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_PayloadMessageXpath() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_PayloadRegistryKey() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_ResultType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_ResultMessageXpath() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_ResultContextProperty() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_PassHeaders() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_UseServerConfig() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalloutMediator_EndpointType() {
		return (EAttribute)calloutMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalloutMediator_EndpointKey() {
		return (EReference)calloutMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRMSequenceMediator() {
		return rmSequenceMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRMSequenceMediator_RmSpecVersion() {
		return (EAttribute)rmSequenceMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRMSequenceMediator_SequenceType() {
		return (EAttribute)rmSequenceMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRMSequenceMediator_CorrelationXpath() {
		return (EReference)rmSequenceMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRMSequenceMediator_LastMessageXpath() {
		return (EReference)rmSequenceMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransactionMediator() {
		return transactionMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransactionMediator_Action() {
		return (EAttribute)transactionMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyMediator() {
		return propertyMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyName() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyDataType() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyAction() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_PropertyScope() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueType() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueLiteral() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyMediator_ValueExpression() {
		return (EReference)propertyMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueOM() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueStringPattern() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyMediator_ValueStringCapturingGroup() {
		return (EAttribute)propertyMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOAuthMediator() {
		return oAuthMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOAuthMediator_RemoteServiceUrl() {
		return (EAttribute)oAuthMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoscaleInMediator() {
		return autoscaleInMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoscaleOutMediator() {
		return autoscaleOutMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeaderMediator() {
		return headerMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderMediator_HeaderName() {
		return (EReference)headerMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_HeaderAction() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_ValueType() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHeaderMediator_ValueLiteral() {
		return (EAttribute)headerMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHeaderMediator_ValueExpression() {
		return (EReference)headerMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleMediator() {
		return throttleMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleMediator_GroupId() {
		return (EAttribute)throttleMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_PolicyConfiguration() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OnAcceptBranch() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleMediator_OnRejectBranch() {
		return (EReference)throttleMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottlePolicyConfiguration() {
		return throttlePolicyConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyConfiguration_PolicyType() {
		return (EAttribute)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottlePolicyConfiguration_PolicyKey() {
		return (EReference)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyConfiguration_MaxConcurrentAccessCount() {
		return (EAttribute)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottlePolicyConfiguration_PolicyEntries() {
		return (EReference)throttlePolicyConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottlePolicyEntry() {
		return throttlePolicyEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_ThrottleType() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_ThrottleRange() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_AccessType() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_MaxRequestCount() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_UnitTime() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottlePolicyEntry_ProhibitPeriod() {
		return (EAttribute)throttlePolicyEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleOnAcceptBranch() {
		return throttleOnAcceptBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleOnAcceptBranch_SequenceType() {
		return (EAttribute)throttleOnAcceptBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleOnAcceptBranch_SequenceKey() {
		return (EReference)throttleOnAcceptBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrottleOnRejectBranch() {
		return throttleOnRejectBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrottleOnRejectBranch_SequenceType() {
		return (EAttribute)throttleOnRejectBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrottleOnRejectBranch_SequenceKey() {
		return (EReference)throttleOnRejectBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandMediator() {
		return commandMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandMediator_ClassName() {
		return (EAttribute)commandMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandMediator_Properties() {
		return (EReference)commandMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandProperty() {
		return commandPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_PropertyName() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ValueType() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ValueLiteral() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ValueContextPropertyName() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandProperty_ValueMessageElementXpath() {
		return (EReference)commandPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_ContextAction() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandProperty_MessageAction() {
		return (EAttribute)commandPropertyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventMediator() {
		return eventMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventMediator_TopicType() {
		return (EAttribute)eventMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventMediator_StaticTopic() {
		return (EAttribute)eventMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventMediator_DynamicTopic() {
		return (EReference)eventMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventMediator_EventExpression() {
		return (EReference)eventMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventMediator_EventSource() {
		return (EAttribute)eventMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSqlExecutorMediator() {
		return abstractSqlExecutorMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionType() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDsType() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDbDriver() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDsInitialContext() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionDsName() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionURL() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionUsername() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_ConnectionPassword() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyAutocommit() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyIsolation() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxactive() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxidle() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxopenstatements() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMaxwait() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyMinidle() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyPoolstatements() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyTestonborrow() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyTestwhileidle() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyValidationquery() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSqlExecutorMediator_PropertyInitialsize() {
		return (EAttribute)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSqlExecutorMediator_SqlStatements() {
		return (EReference)abstractSqlExecutorMediatorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlStatement() {
		return sqlStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlStatement_QueryString() {
		return (EAttribute)sqlStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlStatement_Parameters() {
		return (EReference)sqlStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlStatement_ResultsEnabled() {
		return (EAttribute)sqlStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlStatement_Results() {
		return (EReference)sqlStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlParameterDefinition() {
		return sqlParameterDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlParameterDefinition_DataType() {
		return (EAttribute)sqlParameterDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlParameterDefinition_ValueType() {
		return (EAttribute)sqlParameterDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlParameterDefinition_ValueLiteral() {
		return (EAttribute)sqlParameterDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSqlParameterDefinition_ValueExpression() {
		return (EReference)sqlParameterDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSqlResultMapping() {
		return sqlResultMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlResultMapping_PropertyName() {
		return (EAttribute)sqlResultMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSqlResultMapping_ColumnId() {
		return (EAttribute)sqlResultMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBLookupMediator() {
		return dbLookupMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBReportMediator() {
		return dbReportMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDBReportMediator_ConnectionUseTransaction() {
		return (EAttribute)dbReportMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleMediator() {
		return ruleMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_RuleSetConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_RuleSessionConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_FactsConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_ResultsConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleMediator_ChildMediatorsConfiguration() {
		return (EReference)ruleMediatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleSetConfiguration() {
		return ruleSetConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleSetConfiguration_SourceType() {
		return (EAttribute)ruleSetConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleSetConfiguration_SourceCode() {
		return (EAttribute)ruleSetConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleSetConfiguration_SourceKey() {
		return (EReference)ruleSetConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleSetConfiguration_Properties() {
		return (EReference)ruleSetConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleSetCreationProperty() {
		return ruleSetCreationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleSessionConfiguration() {
		return ruleSessionConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleSessionConfiguration_StatefulSession() {
		return (EAttribute)ruleSessionConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleSessionConfiguration_Properties() {
		return (EReference)ruleSessionConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleSessionProperty() {
		return ruleSessionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleFactsConfiguration() {
		return ruleFactsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleFactsConfiguration_Facts() {
		return (EReference)ruleFactsConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleFact() {
		return ruleFactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_FactType() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_FactCustomType() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_FactName() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_ValueType() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleFact_ValueLiteral() {
		return (EAttribute)ruleFactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleFact_ValueExpression() {
		return (EReference)ruleFactEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleFact_ValueKey() {
		return (EReference)ruleFactEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleResultsConfiguration() {
		return ruleResultsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleResultsConfiguration_Results() {
		return (EReference)ruleResultsConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleResult() {
		return ruleResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ResultType() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ResultCustomType() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ResultName() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ValueType() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleResult_ValueLiteral() {
		return (EAttribute)ruleResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleResult_ValueExpression() {
		return (EReference)ruleResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleResult_ValueKey() {
		return (EReference)ruleResultEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleChildMediatorsConfiguration() {
		return ruleChildMediatorsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceMediator() {
		return sequenceMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceMediator_ReferringSequenceType() {
		return (EAttribute)sequenceMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceMediator_DynamicReferenceKey() {
		return (EReference)sequenceMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceMediator_StaticReferenceKey() {
		return (EReference)sequenceMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceMediator_SequenceKey() {
		return (EReference)sequenceMediatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderMediator() {
		return builderMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderMediator_MessageBuilders() {
		return (EReference)builderMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageBuilder() {
		return messageBuilderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageBuilder_ContentType() {
		return (EAttribute)messageBuilderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageBuilder_BuilderClass() {
		return (EAttribute)messageBuilderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageBuilder_FormatterClass() {
		return (EAttribute)messageBuilderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmooksMediator() {
		return smooksMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_ConfigurationKey() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_Input() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksMediator_Output() {
		return (EReference)smooksMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmooksInConfiguration() {
		return smooksInConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksInConfiguration_Type() {
		return (EAttribute)smooksInConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksInConfiguration_Expression() {
		return (EReference)smooksInConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSmooksOutConfiguration() {
		return smooksOutConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksOutConfiguration_Type() {
		return (EAttribute)smooksOutConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSmooksOutConfiguration_Expression() {
		return (EReference)smooksOutConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksOutConfiguration_Property() {
		return (EAttribute)smooksOutConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksOutConfiguration_Action() {
		return (EAttribute)smooksOutConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSmooksOutConfiguration_OutputMethod() {
		return (EAttribute)smooksOutConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoreMediator() {
		return storeMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStoreMediator_MessageStore() {
		return (EAttribute)storeMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoreMediator_OnStoreSequence() {
		return (EReference)storeMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouteBranch() {
		return conditionalRouteBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalRouteBranch_BreakAfterRoute() {
		return (EAttribute)conditionalRouteBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouteBranch_EvaluatorExpression() {
		return (EReference)conditionalRouteBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouteBranch_TargetSequence() {
		return (EReference)conditionalRouteBranchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalRouterMediator() {
		return conditionalRouterMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalRouterMediator_ContinueAfterRoute() {
		return (EAttribute)conditionalRouterMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalRouterMediator_ConditionalRouteBraches() {
		return (EReference)conditionalRouterMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteRuleAction() {
		return urlRewriteRuleActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_RuleAction() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_RuleFragment() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_RuleOption() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteRuleAction_ActionExpression() {
		return (EReference)urlRewriteRuleActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_ActionValue() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteRuleAction_ActionRegex() {
		return (EAttribute)urlRewriteRuleActionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteRule() {
		return urlRewriteRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteRule_UrlRewriteRuleCondition() {
		return (EReference)urlRewriteRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteRule_RewriteRuleAction() {
		return (EReference)urlRewriteRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURLRewriteMediator() {
		return urlRewriteMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getURLRewriteMediator_UrlRewriteRules() {
		return (EReference)urlRewriteMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteMediator_InProperty() {
		return (EAttribute)urlRewriteMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getURLRewriteMediator_OutProperty() {
		return (EAttribute)urlRewriteMediatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTemplateMediator() {
		return callTemplateMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateMediator_TargetTemplate() {
		return (EAttribute)callTemplateMediatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallTemplateMediator_TemplateParameters() {
		return (EReference)callTemplateMediatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallTemplateParameter() {
		return callTemplateParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateParameter_ParameterName() {
		return (EAttribute)callTemplateParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateParameter_TemplateParameterType() {
		return (EAttribute)callTemplateParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallTemplateParameter_ParameterValue() {
		return (EAttribute)callTemplateParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallTemplateParameter_ParameterExpression() {
		return (EReference)callTemplateParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPayloadFactoryMediator() {
		return payloadFactoryMediatorEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getPayloadFactoryMediator_Format() {
		return (EAttribute)payloadFactoryMediatorEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPayloadFactoryMediator_Args() {
		return (EReference)payloadFactoryMediatorEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EClass getPayloadFactoryArgument() {
		return payloadFactoryArgumentEClass;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getPayloadFactoryArgument_ArgumentType() {
		return (EAttribute)payloadFactoryArgumentEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getPayloadFactoryArgument_ArgumentValue() {
		return (EAttribute)payloadFactoryArgumentEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EReference getPayloadFactoryArgument_ArgumentExpression() {
		return (EReference)payloadFactoryArgumentEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogCategory() {
		return logCategoryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogLevel() {
		return logLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFilterConditionType() {
		return filterConditionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEntitlementSequence() {
		return entitlementSequenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScriptType() {
		return scriptTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScriptLanguage() {
		return scriptLanguageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichSourceType() {
		return enrichSourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichTargetAction() {
		return enrichTargetActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichTargetType() {
		return enrichTargetTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultSoapVersion() {
		return faultSoapVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultCodeSoap11() {
		return faultCodeSoap11EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultCodeSoap12() {
		return faultCodeSoap12EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultStringType() {
		return faultStringTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultReasonType() {
		return faultReasonTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultDetailType() {
		return faultDetailTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAggregateSequenceType() {
		return aggregateSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheSequenceType() {
		return cacheSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheImplementationType() {
		return cacheImplementationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheAction() {
		return cacheActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCacheScope() {
		return cacheScopeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getXQueryVariableType() {
		return xQueryVariableTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getXQueryVariableValueType() {
		return xQueryVariableValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutPayloadType() {
		return calloutPayloadTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCalloutResultType() {
		return calloutResultTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRMSpecVersion() {
		return rmSpecVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRMSequenceType() {
		return rmSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransactionAction() {
		return transactionActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyDataType() {
		return propertyDataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyAction() {
		return propertyActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyScope() {
		return propertyScopeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPropertyValueType() {
		return propertyValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHeaderAction() {
		return headerActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHeaderValueType() {
		return headerValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottlePolicyType() {
		return throttlePolicyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottleConditionType() {
		return throttleConditionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottleAccessType() {
		return throttleAccessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThrottleSequenceType() {
		return throttleSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandPropertyValueType() {
		return commandPropertyValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandPropertyMessageAction() {
		return commandPropertyMessageActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandPropertyContextAction() {
		return commandPropertyContextActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorConnectionType() {
		return sqlExecutorConnectionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorDatasourceType() {
		return sqlExecutorDatasourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorBooleanValue() {
		return sqlExecutorBooleanValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlExecutorIsolationLevel() {
		return sqlExecutorIsolationLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlParameterValueType() {
		return sqlParameterValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSqlParameterDataType() {
		return sqlParameterDataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleSourceType() {
		return ruleSourceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleFactType() {
		return ruleFactTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleFactValueType() {
		return ruleFactValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleResultType() {
		return ruleResultTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleResultValueType() {
		return ruleResultValueTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSmooksIODataType() {
		return smooksIODataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExpressionAction() {
		return expressionActionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOutputMethod() {
		return outputMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReceivingSequenceType() {
		return receivingSequenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKeyType() {
		return keyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleActionType() {
		return ruleActionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleFragmentType() {
		return ruleFragmentTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRuleOptionType() {
		return ruleOptionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnrichSourceInlineType() {
		return enrichSourceInlineTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EEnum getPayloadFactoryArgumentType() {
		return payloadFactoryArgumentTypeEEnum;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCallOutMediatorEndpointType() {
		return callOutMediatorEndpointTypeEEnum;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorsFactory getMediatorsFactory() {
		return (MediatorsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		inMediatorEClass = createEClass(IN_MEDIATOR);

		outMediatorEClass = createEClass(OUT_MEDIATOR);

		dropMediatorEClass = createEClass(DROP_MEDIATOR);

		sendMediatorEClass = createEClass(SEND_MEDIATOR);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__ANONYMOUS_END_POINT);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__END_POINT_REFERENCE);
		createEAttribute(sendMediatorEClass, SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE);
		createEReference(sendMediatorEClass, SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE);

		logMediatorEClass = createEClass(LOG_MEDIATOR);
		createEAttribute(logMediatorEClass, LOG_MEDIATOR__LOG_CATEGORY);
		createEAttribute(logMediatorEClass, LOG_MEDIATOR__LOG_LEVEL);
		createEAttribute(logMediatorEClass, LOG_MEDIATOR__LOG_SEPARATOR);
		createEReference(logMediatorEClass, LOG_MEDIATOR__PROPERTIES);

		logPropertyEClass = createEClass(LOG_PROPERTY);

		filterMediatorEClass = createEClass(FILTER_MEDIATOR);
		createEAttribute(filterMediatorEClass, FILTER_MEDIATOR__CONDITION_TYPE);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__FILTER_XPATH);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__FILTER_SOURCE);
		createEAttribute(filterMediatorEClass, FILTER_MEDIATOR__FILTER_REGEX);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__THEN_BRANCH);
		createEReference(filterMediatorEClass, FILTER_MEDIATOR__ELSE_BRANCH);

		filterThenBranchEClass = createEClass(FILTER_THEN_BRANCH);

		filterElseBranchEClass = createEClass(FILTER_ELSE_BRANCH);

		switchMediatorEClass = createEClass(SWITCH_MEDIATOR);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__SOURCE_XPATH);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__CASE_BRANCHES);
		createEReference(switchMediatorEClass, SWITCH_MEDIATOR__DEFAULT_BRANCH);

		switchCaseBranchEClass = createEClass(SWITCH_CASE_BRANCH);
		createEAttribute(switchCaseBranchEClass, SWITCH_CASE_BRANCH__CASE_REGEX);

		switchDefaultBranchEClass = createEClass(SWITCH_DEFAULT_BRANCH);

		entitlementMediatorEClass = createEClass(ENTITLEMENT_MEDIATOR);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__SERVER_URL);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__USERNAME);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__PASSWORD);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_ACCEPT);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ON_REJECT);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__OBLIGATIONS);
		createEReference(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__ADVICE);
		createEAttribute(entitlementMediatorEClass, ENTITLEMENT_MEDIATOR__CALLBACK_CLASS);

		entitlementAdviceBranchEClass = createEClass(ENTITLEMENT_ADVICE_BRANCH);
		createEAttribute(entitlementAdviceBranchEClass, ENTITLEMENT_ADVICE_BRANCH__SEQUENCE_TYPE);
		createEReference(entitlementAdviceBranchEClass, ENTITLEMENT_ADVICE_BRANCH__SEQUENCE_KEY);

		entitlementObligationsBranchEClass = createEClass(ENTITLEMENT_OBLIGATIONS_BRANCH);
		createEAttribute(entitlementObligationsBranchEClass, ENTITLEMENT_OBLIGATIONS_BRANCH__SEQUENCE_TYPE);
		createEReference(entitlementObligationsBranchEClass, ENTITLEMENT_OBLIGATIONS_BRANCH__SEQUENCE_KEY);

		entitlementMediatorOnRejectBranchEClass = createEClass(ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH);
		createEAttribute(entitlementMediatorOnRejectBranchEClass, ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_TYPE);
		createEReference(entitlementMediatorOnRejectBranchEClass, ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_KEY);

		entitlementMediatorOnAcceptBranchEClass = createEClass(ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH);
		createEAttribute(entitlementMediatorOnAcceptBranchEClass, ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SEQUENCE_TYPE);
		createEReference(entitlementMediatorOnAcceptBranchEClass, ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SEQUENCE_KEY);

		enqueueMediatorEClass = createEClass(ENQUEUE_MEDIATOR);
		createEAttribute(enqueueMediatorEClass, ENQUEUE_MEDIATOR__EXECUTOR);
		createEAttribute(enqueueMediatorEClass, ENQUEUE_MEDIATOR__PRIORITY);
		createEReference(enqueueMediatorEClass, ENQUEUE_MEDIATOR__SEQUENCE_KEY);

		classMediatorEClass = createEClass(CLASS_MEDIATOR);
		createEAttribute(classMediatorEClass, CLASS_MEDIATOR__CLASS_NAME);
		createEReference(classMediatorEClass, CLASS_MEDIATOR__PROPERTIES);

		classPropertyEClass = createEClass(CLASS_PROPERTY);

		springMediatorEClass = createEClass(SPRING_MEDIATOR);
		createEAttribute(springMediatorEClass, SPRING_MEDIATOR__BEAN_NAME);
		createEReference(springMediatorEClass, SPRING_MEDIATOR__CONFIGURATION_KEY);

		validateMediatorEClass = createEClass(VALIDATE_MEDIATOR);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__SOURCE_XPATH);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__ON_FAIL_BRANCH);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__FEATURES);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__SCHEMAS);
		createEReference(validateMediatorEClass, VALIDATE_MEDIATOR__RESOURCES);

		validateOnFailBranchEClass = createEClass(VALIDATE_ON_FAIL_BRANCH);

		validateFeatureEClass = createEClass(VALIDATE_FEATURE);

		validateSchemaEClass = createEClass(VALIDATE_SCHEMA);
		createEReference(validateSchemaEClass, VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY);
		createEReference(validateSchemaEClass, VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY);
		createEAttribute(validateSchemaEClass, VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE);
		createEReference(validateSchemaEClass, VALIDATE_SCHEMA__SCHEMA_KEY);

		validateResourceEClass = createEClass(VALIDATE_RESOURCE);

		scriptMediatorEClass = createEClass(SCRIPT_MEDIATOR);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_TYPE);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_LANGUAGE);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__MEDIATE_FUNCTION);
		createEReference(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_KEY);
		createEAttribute(scriptMediatorEClass, SCRIPT_MEDIATOR__SCRIPT_BODY);

		enrichMediatorEClass = createEClass(ENRICH_MEDIATOR);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__CLONE_SOURCE);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_TYPE);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_XPATH);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_PROPERTY);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__SOURCE_XML);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_ACTION);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_TYPE);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_XPATH);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__TARGET_PROPERTY);
		createEAttribute(enrichMediatorEClass, ENRICH_MEDIATOR__INLINE_TYPE);
		createEReference(enrichMediatorEClass, ENRICH_MEDIATOR__INLINE_REGISTRY_KEY);

		faultMediatorEClass = createEClass(FAULT_MEDIATOR);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__SOAP_VERSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_CODE_SOAP11);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_STRING_TYPE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_STRING_VALUE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_STRING_EXPRESSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_ACTOR);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_CODE_SOAP12);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_REASON_TYPE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_REASON_VALUE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_REASON_EXPRESSION);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__ROLE_NAME);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__NODE_NAME);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_DETAIL_TYPE);
		createEAttribute(faultMediatorEClass, FAULT_MEDIATOR__FAULT_DETAIL_VALUE);
		createEReference(faultMediatorEClass, FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION);

		aggregateMediatorEClass = createEClass(AGGREGATE_MEDIATOR);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__AGGREGATE_ID);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES);
		createEAttribute(aggregateMediatorEClass, AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES);
		createEReference(aggregateMediatorEClass, AGGREGATE_MEDIATOR__ON_COMPLETE_BRANCH);

		aggregateOnCompleteBranchEClass = createEClass(AGGREGATE_ON_COMPLETE_BRANCH);
		createEReference(aggregateOnCompleteBranchEClass, AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION);
		createEAttribute(aggregateOnCompleteBranchEClass, AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE);
		createEReference(aggregateOnCompleteBranchEClass, AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY);

		routerMediatorEClass = createEClass(ROUTER_MEDIATOR);
		createEAttribute(routerMediatorEClass, ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING);
		createEReference(routerMediatorEClass, ROUTER_MEDIATOR__ROUTES);

		routerRouteEClass = createEClass(ROUTER_ROUTE);
		createEAttribute(routerRouteEClass, ROUTER_ROUTE__BREAK_AFTER_ROUTE);
		createEReference(routerRouteEClass, ROUTER_ROUTE__ROUTE_EXPRESSION);
		createEAttribute(routerRouteEClass, ROUTER_ROUTE__ROUTE_PATTERN);
		createEReference(routerRouteEClass, ROUTER_ROUTE__TARGET);

		routeTargetEClass = createEClass(ROUTE_TARGET);

		cloneMediatorEClass = createEClass(CLONE_MEDIATOR);
		createEAttribute(cloneMediatorEClass, CLONE_MEDIATOR__CLONE_ID);
		createEAttribute(cloneMediatorEClass, CLONE_MEDIATOR__SEQUENTIAL_MEDIATION);
		createEAttribute(cloneMediatorEClass, CLONE_MEDIATOR__CONTINUE_PARENT);
		createEReference(cloneMediatorEClass, CLONE_MEDIATOR__TARGETS);

		cloneTargetEClass = createEClass(CLONE_TARGET);
		createEAttribute(cloneTargetEClass, CLONE_TARGET__SOAP_ACTION);
		createEAttribute(cloneTargetEClass, CLONE_TARGET__TO_ADDRESS);

		iterateMediatorEClass = createEClass(ITERATE_MEDIATOR);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__ITERATE_ID);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__CONTINUE_PARENT);
		createEAttribute(iterateMediatorEClass, ITERATE_MEDIATOR__PRESERVE_PAYLOAD);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__ITERATE_EXPRESSION);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__ATTACH_PATH);
		createEReference(iterateMediatorEClass, ITERATE_MEDIATOR__TARGET);

		iterateTargetEClass = createEClass(ITERATE_TARGET);
		createEAttribute(iterateTargetEClass, ITERATE_TARGET__SOAP_ACTION);
		createEAttribute(iterateTargetEClass, ITERATE_TARGET__TO_ADDRESS);

		cacheMediatorEClass = createEClass(CACHE_MEDIATOR);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_ID);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_SCOPE);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_ACTION);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__HASH_GENERATOR);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__CACHE_TIMEOUT);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__MAX_MESSAGE_SIZE);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__IMPLEMENTATION_TYPE);
		createEAttribute(cacheMediatorEClass, CACHE_MEDIATOR__MAX_ENTRY_COUNT);
		createEReference(cacheMediatorEClass, CACHE_MEDIATOR__ON_HIT_BRANCH);

		cacheOnHitBranchEClass = createEClass(CACHE_ON_HIT_BRANCH);
		createEAttribute(cacheOnHitBranchEClass, CACHE_ON_HIT_BRANCH__SEQUENCE_TYPE);
		createEReference(cacheOnHitBranchEClass, CACHE_ON_HIT_BRANCH__SEQUENCE_KEY);

		xsltMediatorEClass = createEClass(XSLT_MEDIATOR);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__PROPERTIES);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__FEATURES);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__RESOURCES);
		createEAttribute(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__SOURCE_XPATH);
		createEReference(xsltMediatorEClass, XSLT_MEDIATOR__XSLT_KEY);

		xsltPropertyEClass = createEClass(XSLT_PROPERTY);

		xsltFeatureEClass = createEClass(XSLT_FEATURE);

		xsltResourceEClass = createEClass(XSLT_RESOURCE);

		xQueryMediatorEClass = createEClass(XQUERY_MEDIATOR);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__VARIABLES);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__TARGET_XPATH);
		createEAttribute(xQueryMediatorEClass, XQUERY_MEDIATOR__SCRIPT_KEY_TYPE);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__STATIC_SCRIPT_KEY);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY);
		createEReference(xQueryMediatorEClass, XQUERY_MEDIATOR__QUERY_KEY);

		xQueryVariableEClass = createEClass(XQUERY_VARIABLE);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VARIABLE_NAME);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VARIABLE_TYPE);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_TYPE);
		createEAttribute(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_LITERAL);
		createEReference(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_EXPRESSION);
		createEReference(xQueryVariableEClass, XQUERY_VARIABLE__VALUE_KEY);

		calloutMediatorEClass = createEClass(CALLOUT_MEDIATOR);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__SERVICE_URL);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__SOAP_ACTION);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PATH_TO_AXIS2XML);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PAYLOAD_TYPE);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__RESULT_TYPE);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__PASS_HEADERS);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__USE_SERVER_CONFIG);
		createEAttribute(calloutMediatorEClass, CALLOUT_MEDIATOR__ENDPOINT_TYPE);
		createEReference(calloutMediatorEClass, CALLOUT_MEDIATOR__ENDPOINT_KEY);

		rmSequenceMediatorEClass = createEClass(RM_SEQUENCE_MEDIATOR);
		createEAttribute(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION);
		createEAttribute(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE);
		createEReference(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH);
		createEReference(rmSequenceMediatorEClass, RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH);

		transactionMediatorEClass = createEClass(TRANSACTION_MEDIATOR);
		createEAttribute(transactionMediatorEClass, TRANSACTION_MEDIATOR__ACTION);

		propertyMediatorEClass = createEClass(PROPERTY_MEDIATOR);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_NAME);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_ACTION);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__PROPERTY_SCOPE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_TYPE);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_LITERAL);
		createEReference(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_EXPRESSION);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_OM);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_STRING_PATTERN);
		createEAttribute(propertyMediatorEClass, PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP);

		oAuthMediatorEClass = createEClass(OAUTH_MEDIATOR);
		createEAttribute(oAuthMediatorEClass, OAUTH_MEDIATOR__REMOTE_SERVICE_URL);

		autoscaleInMediatorEClass = createEClass(AUTOSCALE_IN_MEDIATOR);

		autoscaleOutMediatorEClass = createEClass(AUTOSCALE_OUT_MEDIATOR);

		headerMediatorEClass = createEClass(HEADER_MEDIATOR);
		createEReference(headerMediatorEClass, HEADER_MEDIATOR__HEADER_NAME);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__HEADER_ACTION);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__VALUE_TYPE);
		createEAttribute(headerMediatorEClass, HEADER_MEDIATOR__VALUE_LITERAL);
		createEReference(headerMediatorEClass, HEADER_MEDIATOR__VALUE_EXPRESSION);

		throttleMediatorEClass = createEClass(THROTTLE_MEDIATOR);
		createEAttribute(throttleMediatorEClass, THROTTLE_MEDIATOR__GROUP_ID);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__POLICY_CONFIGURATION);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH);
		createEReference(throttleMediatorEClass, THROTTLE_MEDIATOR__ON_REJECT_BRANCH);

		throttlePolicyConfigurationEClass = createEClass(THROTTLE_POLICY_CONFIGURATION);
		createEAttribute(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE);
		createEReference(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__POLICY_KEY);
		createEAttribute(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT);
		createEReference(throttlePolicyConfigurationEClass, THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES);

		throttlePolicyEntryEClass = createEClass(THROTTLE_POLICY_ENTRY);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__THROTTLE_TYPE);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__THROTTLE_RANGE);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__ACCESS_TYPE);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__UNIT_TIME);
		createEAttribute(throttlePolicyEntryEClass, THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD);

		throttleOnAcceptBranchEClass = createEClass(THROTTLE_ON_ACCEPT_BRANCH);
		createEAttribute(throttleOnAcceptBranchEClass, THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_TYPE);
		createEReference(throttleOnAcceptBranchEClass, THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_KEY);

		throttleOnRejectBranchEClass = createEClass(THROTTLE_ON_REJECT_BRANCH);
		createEAttribute(throttleOnRejectBranchEClass, THROTTLE_ON_REJECT_BRANCH__SEQUENCE_TYPE);
		createEReference(throttleOnRejectBranchEClass, THROTTLE_ON_REJECT_BRANCH__SEQUENCE_KEY);

		commandMediatorEClass = createEClass(COMMAND_MEDIATOR);
		createEAttribute(commandMediatorEClass, COMMAND_MEDIATOR__CLASS_NAME);
		createEReference(commandMediatorEClass, COMMAND_MEDIATOR__PROPERTIES);

		commandPropertyEClass = createEClass(COMMAND_PROPERTY);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__PROPERTY_NAME);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__VALUE_TYPE);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__VALUE_LITERAL);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME);
		createEReference(commandPropertyEClass, COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__CONTEXT_ACTION);
		createEAttribute(commandPropertyEClass, COMMAND_PROPERTY__MESSAGE_ACTION);

		eventMediatorEClass = createEClass(EVENT_MEDIATOR);
		createEAttribute(eventMediatorEClass, EVENT_MEDIATOR__TOPIC_TYPE);
		createEAttribute(eventMediatorEClass, EVENT_MEDIATOR__STATIC_TOPIC);
		createEReference(eventMediatorEClass, EVENT_MEDIATOR__DYNAMIC_TOPIC);
		createEReference(eventMediatorEClass, EVENT_MEDIATOR__EVENT_EXPRESSION);
		createEAttribute(eventMediatorEClass, EVENT_MEDIATOR__EVENT_SOURCE);

		abstractSqlExecutorMediatorEClass = createEClass(ABSTRACT_SQL_EXECUTOR_MEDIATOR);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY);
		createEAttribute(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE);
		createEReference(abstractSqlExecutorMediatorEClass, ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS);

		sqlStatementEClass = createEClass(SQL_STATEMENT);
		createEAttribute(sqlStatementEClass, SQL_STATEMENT__QUERY_STRING);
		createEReference(sqlStatementEClass, SQL_STATEMENT__PARAMETERS);
		createEAttribute(sqlStatementEClass, SQL_STATEMENT__RESULTS_ENABLED);
		createEReference(sqlStatementEClass, SQL_STATEMENT__RESULTS);

		sqlParameterDefinitionEClass = createEClass(SQL_PARAMETER_DEFINITION);
		createEAttribute(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__DATA_TYPE);
		createEAttribute(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__VALUE_TYPE);
		createEAttribute(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__VALUE_LITERAL);
		createEReference(sqlParameterDefinitionEClass, SQL_PARAMETER_DEFINITION__VALUE_EXPRESSION);

		sqlResultMappingEClass = createEClass(SQL_RESULT_MAPPING);
		createEAttribute(sqlResultMappingEClass, SQL_RESULT_MAPPING__PROPERTY_NAME);
		createEAttribute(sqlResultMappingEClass, SQL_RESULT_MAPPING__COLUMN_ID);

		dbLookupMediatorEClass = createEClass(DB_LOOKUP_MEDIATOR);

		dbReportMediatorEClass = createEClass(DB_REPORT_MEDIATOR);
		createEAttribute(dbReportMediatorEClass, DB_REPORT_MEDIATOR__CONNECTION_USE_TRANSACTION);

		ruleMediatorEClass = createEClass(RULE_MEDIATOR);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__RULE_SET_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__RULE_SESSION_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__FACTS_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__RESULTS_CONFIGURATION);
		createEReference(ruleMediatorEClass, RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION);

		ruleSetConfigurationEClass = createEClass(RULE_SET_CONFIGURATION);
		createEAttribute(ruleSetConfigurationEClass, RULE_SET_CONFIGURATION__SOURCE_TYPE);
		createEAttribute(ruleSetConfigurationEClass, RULE_SET_CONFIGURATION__SOURCE_CODE);
		createEReference(ruleSetConfigurationEClass, RULE_SET_CONFIGURATION__SOURCE_KEY);
		createEReference(ruleSetConfigurationEClass, RULE_SET_CONFIGURATION__PROPERTIES);

		ruleSetCreationPropertyEClass = createEClass(RULE_SET_CREATION_PROPERTY);

		ruleSessionConfigurationEClass = createEClass(RULE_SESSION_CONFIGURATION);
		createEAttribute(ruleSessionConfigurationEClass, RULE_SESSION_CONFIGURATION__STATEFUL_SESSION);
		createEReference(ruleSessionConfigurationEClass, RULE_SESSION_CONFIGURATION__PROPERTIES);

		ruleSessionPropertyEClass = createEClass(RULE_SESSION_PROPERTY);

		ruleFactsConfigurationEClass = createEClass(RULE_FACTS_CONFIGURATION);
		createEReference(ruleFactsConfigurationEClass, RULE_FACTS_CONFIGURATION__FACTS);

		ruleFactEClass = createEClass(RULE_FACT);
		createEAttribute(ruleFactEClass, RULE_FACT__FACT_TYPE);
		createEAttribute(ruleFactEClass, RULE_FACT__FACT_CUSTOM_TYPE);
		createEAttribute(ruleFactEClass, RULE_FACT__FACT_NAME);
		createEAttribute(ruleFactEClass, RULE_FACT__VALUE_TYPE);
		createEAttribute(ruleFactEClass, RULE_FACT__VALUE_LITERAL);
		createEReference(ruleFactEClass, RULE_FACT__VALUE_EXPRESSION);
		createEReference(ruleFactEClass, RULE_FACT__VALUE_KEY);

		ruleResultsConfigurationEClass = createEClass(RULE_RESULTS_CONFIGURATION);
		createEReference(ruleResultsConfigurationEClass, RULE_RESULTS_CONFIGURATION__RESULTS);

		ruleResultEClass = createEClass(RULE_RESULT);
		createEAttribute(ruleResultEClass, RULE_RESULT__RESULT_TYPE);
		createEAttribute(ruleResultEClass, RULE_RESULT__RESULT_CUSTOM_TYPE);
		createEAttribute(ruleResultEClass, RULE_RESULT__RESULT_NAME);
		createEAttribute(ruleResultEClass, RULE_RESULT__VALUE_TYPE);
		createEAttribute(ruleResultEClass, RULE_RESULT__VALUE_LITERAL);
		createEReference(ruleResultEClass, RULE_RESULT__VALUE_EXPRESSION);
		createEReference(ruleResultEClass, RULE_RESULT__VALUE_KEY);

		ruleChildMediatorsConfigurationEClass = createEClass(RULE_CHILD_MEDIATORS_CONFIGURATION);

		sequenceMediatorEClass = createEClass(SEQUENCE_MEDIATOR);
		createEAttribute(sequenceMediatorEClass, SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE);
		createEReference(sequenceMediatorEClass, SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY);
		createEReference(sequenceMediatorEClass, SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY);
		createEReference(sequenceMediatorEClass, SEQUENCE_MEDIATOR__SEQUENCE_KEY);

		builderMediatorEClass = createEClass(BUILDER_MEDIATOR);
		createEReference(builderMediatorEClass, BUILDER_MEDIATOR__MESSAGE_BUILDERS);

		messageBuilderEClass = createEClass(MESSAGE_BUILDER);
		createEAttribute(messageBuilderEClass, MESSAGE_BUILDER__CONTENT_TYPE);
		createEAttribute(messageBuilderEClass, MESSAGE_BUILDER__BUILDER_CLASS);
		createEAttribute(messageBuilderEClass, MESSAGE_BUILDER__FORMATTER_CLASS);

		smooksMediatorEClass = createEClass(SMOOKS_MEDIATOR);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__CONFIGURATION_KEY);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__INPUT);
		createEReference(smooksMediatorEClass, SMOOKS_MEDIATOR__OUTPUT);

		smooksInConfigurationEClass = createEClass(SMOOKS_IN_CONFIGURATION);
		createEAttribute(smooksInConfigurationEClass, SMOOKS_IN_CONFIGURATION__TYPE);
		createEReference(smooksInConfigurationEClass, SMOOKS_IN_CONFIGURATION__EXPRESSION);

		smooksOutConfigurationEClass = createEClass(SMOOKS_OUT_CONFIGURATION);
		createEAttribute(smooksOutConfigurationEClass, SMOOKS_OUT_CONFIGURATION__TYPE);
		createEReference(smooksOutConfigurationEClass, SMOOKS_OUT_CONFIGURATION__EXPRESSION);
		createEAttribute(smooksOutConfigurationEClass, SMOOKS_OUT_CONFIGURATION__PROPERTY);
		createEAttribute(smooksOutConfigurationEClass, SMOOKS_OUT_CONFIGURATION__ACTION);
		createEAttribute(smooksOutConfigurationEClass, SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD);

		storeMediatorEClass = createEClass(STORE_MEDIATOR);
		createEAttribute(storeMediatorEClass, STORE_MEDIATOR__MESSAGE_STORE);
		createEReference(storeMediatorEClass, STORE_MEDIATOR__ON_STORE_SEQUENCE);

		conditionalRouteBranchEClass = createEClass(CONDITIONAL_ROUTE_BRANCH);
		createEAttribute(conditionalRouteBranchEClass, CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE);
		createEReference(conditionalRouteBranchEClass, CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION);
		createEReference(conditionalRouteBranchEClass, CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE);

		conditionalRouterMediatorEClass = createEClass(CONDITIONAL_ROUTER_MEDIATOR);
		createEAttribute(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE);
		createEReference(conditionalRouterMediatorEClass, CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES);

		urlRewriteRuleActionEClass = createEClass(URL_REWRITE_RULE_ACTION);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__RULE_ACTION);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__RULE_FRAGMENT);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__RULE_OPTION);
		createEReference(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__ACTION_VALUE);
		createEAttribute(urlRewriteRuleActionEClass, URL_REWRITE_RULE_ACTION__ACTION_REGEX);

		urlRewriteRuleEClass = createEClass(URL_REWRITE_RULE);
		createEReference(urlRewriteRuleEClass, URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION);
		createEReference(urlRewriteRuleEClass, URL_REWRITE_RULE__REWRITE_RULE_ACTION);

		urlRewriteMediatorEClass = createEClass(URL_REWRITE_MEDIATOR);
		createEReference(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__URL_REWRITE_RULES);
		createEAttribute(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__IN_PROPERTY);
		createEAttribute(urlRewriteMediatorEClass, URL_REWRITE_MEDIATOR__OUT_PROPERTY);

		callTemplateMediatorEClass = createEClass(CALL_TEMPLATE_MEDIATOR);
		createEAttribute(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE);
		createEReference(callTemplateMediatorEClass, CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS);

		callTemplateParameterEClass = createEClass(CALL_TEMPLATE_PARAMETER);
		createEAttribute(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__PARAMETER_NAME);
		createEAttribute(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE);
		createEAttribute(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE);
		createEReference(callTemplateParameterEClass, CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION);

		payloadFactoryMediatorEClass = createEClass(PAYLOAD_FACTORY_MEDIATOR);
		createEAttribute(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__FORMAT);
		createEReference(payloadFactoryMediatorEClass, PAYLOAD_FACTORY_MEDIATOR__ARGS);

		payloadFactoryArgumentEClass = createEClass(PAYLOAD_FACTORY_ARGUMENT);
		createEAttribute(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE);
		createEAttribute(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE);
		createEReference(payloadFactoryArgumentEClass, PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION);

		// Create enums
		logCategoryEEnum = createEEnum(LOG_CATEGORY);
		logLevelEEnum = createEEnum(LOG_LEVEL);
		filterConditionTypeEEnum = createEEnum(FILTER_CONDITION_TYPE);
		entitlementSequenceEEnum = createEEnum(ENTITLEMENT_SEQUENCE);
		scriptTypeEEnum = createEEnum(SCRIPT_TYPE);
		scriptLanguageEEnum = createEEnum(SCRIPT_LANGUAGE);
		enrichSourceTypeEEnum = createEEnum(ENRICH_SOURCE_TYPE);
		enrichTargetActionEEnum = createEEnum(ENRICH_TARGET_ACTION);
		enrichTargetTypeEEnum = createEEnum(ENRICH_TARGET_TYPE);
		faultSoapVersionEEnum = createEEnum(FAULT_SOAP_VERSION);
		faultCodeSoap11EEnum = createEEnum(FAULT_CODE_SOAP11);
		faultCodeSoap12EEnum = createEEnum(FAULT_CODE_SOAP12);
		faultStringTypeEEnum = createEEnum(FAULT_STRING_TYPE);
		faultReasonTypeEEnum = createEEnum(FAULT_REASON_TYPE);
		faultDetailTypeEEnum = createEEnum(FAULT_DETAIL_TYPE);
		aggregateSequenceTypeEEnum = createEEnum(AGGREGATE_SEQUENCE_TYPE);
		cacheSequenceTypeEEnum = createEEnum(CACHE_SEQUENCE_TYPE);
		cacheImplementationTypeEEnum = createEEnum(CACHE_IMPLEMENTATION_TYPE);
		cacheActionEEnum = createEEnum(CACHE_ACTION);
		cacheScopeEEnum = createEEnum(CACHE_SCOPE);
		xQueryVariableTypeEEnum = createEEnum(XQUERY_VARIABLE_TYPE);
		xQueryVariableValueTypeEEnum = createEEnum(XQUERY_VARIABLE_VALUE_TYPE);
		calloutPayloadTypeEEnum = createEEnum(CALLOUT_PAYLOAD_TYPE);
		calloutResultTypeEEnum = createEEnum(CALLOUT_RESULT_TYPE);
		rmSpecVersionEEnum = createEEnum(RM_SPEC_VERSION);
		rmSequenceTypeEEnum = createEEnum(RM_SEQUENCE_TYPE);
		transactionActionEEnum = createEEnum(TRANSACTION_ACTION);
		propertyDataTypeEEnum = createEEnum(PROPERTY_DATA_TYPE);
		propertyActionEEnum = createEEnum(PROPERTY_ACTION);
		propertyScopeEEnum = createEEnum(PROPERTY_SCOPE);
		propertyValueTypeEEnum = createEEnum(PROPERTY_VALUE_TYPE);
		headerActionEEnum = createEEnum(HEADER_ACTION);
		headerValueTypeEEnum = createEEnum(HEADER_VALUE_TYPE);
		throttlePolicyTypeEEnum = createEEnum(THROTTLE_POLICY_TYPE);
		throttleConditionTypeEEnum = createEEnum(THROTTLE_CONDITION_TYPE);
		throttleAccessTypeEEnum = createEEnum(THROTTLE_ACCESS_TYPE);
		throttleSequenceTypeEEnum = createEEnum(THROTTLE_SEQUENCE_TYPE);
		commandPropertyValueTypeEEnum = createEEnum(COMMAND_PROPERTY_VALUE_TYPE);
		commandPropertyMessageActionEEnum = createEEnum(COMMAND_PROPERTY_MESSAGE_ACTION);
		commandPropertyContextActionEEnum = createEEnum(COMMAND_PROPERTY_CONTEXT_ACTION);
		sqlExecutorConnectionTypeEEnum = createEEnum(SQL_EXECUTOR_CONNECTION_TYPE);
		sqlExecutorDatasourceTypeEEnum = createEEnum(SQL_EXECUTOR_DATASOURCE_TYPE);
		sqlExecutorBooleanValueEEnum = createEEnum(SQL_EXECUTOR_BOOLEAN_VALUE);
		sqlExecutorIsolationLevelEEnum = createEEnum(SQL_EXECUTOR_ISOLATION_LEVEL);
		sqlParameterValueTypeEEnum = createEEnum(SQL_PARAMETER_VALUE_TYPE);
		sqlParameterDataTypeEEnum = createEEnum(SQL_PARAMETER_DATA_TYPE);
		ruleSourceTypeEEnum = createEEnum(RULE_SOURCE_TYPE);
		ruleFactTypeEEnum = createEEnum(RULE_FACT_TYPE);
		ruleFactValueTypeEEnum = createEEnum(RULE_FACT_VALUE_TYPE);
		ruleResultTypeEEnum = createEEnum(RULE_RESULT_TYPE);
		ruleResultValueTypeEEnum = createEEnum(RULE_RESULT_VALUE_TYPE);
		smooksIODataTypeEEnum = createEEnum(SMOOKS_IO_DATA_TYPE);
		expressionActionEEnum = createEEnum(EXPRESSION_ACTION);
		outputMethodEEnum = createEEnum(OUTPUT_METHOD);
		receivingSequenceTypeEEnum = createEEnum(RECEIVING_SEQUENCE_TYPE);
		keyTypeEEnum = createEEnum(KEY_TYPE);
		ruleActionTypeEEnum = createEEnum(RULE_ACTION_TYPE);
		ruleFragmentTypeEEnum = createEEnum(RULE_FRAGMENT_TYPE);
		ruleOptionTypeEEnum = createEEnum(RULE_OPTION_TYPE);
		enrichSourceInlineTypeEEnum = createEEnum(ENRICH_SOURCE_INLINE_TYPE);
		payloadFactoryArgumentTypeEEnum = createEEnum(PAYLOAD_FACTORY_ARGUMENT_TYPE);
		callOutMediatorEndpointTypeEEnum = createEEnum(CALL_OUT_MEDIATOR_ENDPOINT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EsbPackage theEsbPackage = (EsbPackage)EPackage.Registry.INSTANCE.getEPackage(EsbPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inMediatorEClass.getESuperTypes().add(theEsbPackage.getParentMediator());
		outMediatorEClass.getESuperTypes().add(theEsbPackage.getParentMediator());
		dropMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		sendMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		logMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		logPropertyEClass.getESuperTypes().add(theEsbPackage.getAbstractNameValueExpressionProperty());
		filterMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		filterThenBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		filterElseBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		switchMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		switchCaseBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		switchDefaultBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		entitlementMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		entitlementAdviceBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		entitlementObligationsBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		entitlementMediatorOnRejectBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		entitlementMediatorOnAcceptBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		enqueueMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		classMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		classPropertyEClass.getESuperTypes().add(theEsbPackage.getAbstractNameValueProperty());
		springMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		validateMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		validateOnFailBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		validateFeatureEClass.getESuperTypes().add(theEsbPackage.getAbstractBooleanFeature());
		validateSchemaEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		validateResourceEClass.getESuperTypes().add(theEsbPackage.getAbstractLocationKeyResource());
		scriptMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		enrichMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		faultMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		aggregateMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		aggregateOnCompleteBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		routerMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		routerRouteEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		routeTargetEClass.getESuperTypes().add(theEsbPackage.getAbstractCommonTarget());
		cloneMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		cloneTargetEClass.getESuperTypes().add(theEsbPackage.getAbstractCommonTarget());
		iterateMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		iterateTargetEClass.getESuperTypes().add(theEsbPackage.getAbstractCommonTarget());
		cacheMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		cacheOnHitBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		xsltMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		xsltPropertyEClass.getESuperTypes().add(theEsbPackage.getAbstractNameValueExpressionProperty());
		xsltFeatureEClass.getESuperTypes().add(theEsbPackage.getAbstractBooleanFeature());
		xsltResourceEClass.getESuperTypes().add(theEsbPackage.getAbstractLocationKeyResource());
		xQueryMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		xQueryVariableEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		calloutMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		rmSequenceMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		transactionMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		propertyMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		oAuthMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		autoscaleInMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		autoscaleOutMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		headerMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		throttleMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		throttlePolicyConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		throttlePolicyEntryEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		throttleOnAcceptBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		throttleOnRejectBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		commandMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		commandPropertyEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		eventMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		abstractSqlExecutorMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		sqlStatementEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		sqlParameterDefinitionEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		sqlResultMappingEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		dbLookupMediatorEClass.getESuperTypes().add(this.getAbstractSqlExecutorMediator());
		dbReportMediatorEClass.getESuperTypes().add(this.getAbstractSqlExecutorMediator());
		ruleMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		ruleSetConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		ruleSetCreationPropertyEClass.getESuperTypes().add(theEsbPackage.getAbstractNameValueProperty());
		ruleSessionConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		ruleSessionPropertyEClass.getESuperTypes().add(theEsbPackage.getAbstractNameValueProperty());
		ruleFactsConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		ruleFactEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		ruleResultsConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		ruleResultEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		ruleChildMediatorsConfigurationEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		sequenceMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		builderMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		messageBuilderEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		smooksMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		smooksInConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		smooksOutConfigurationEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		storeMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		conditionalRouteBranchEClass.getESuperTypes().add(theEsbPackage.getMediatorBranch());
		conditionalRouterMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		urlRewriteRuleActionEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		urlRewriteRuleEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		urlRewriteMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		callTemplateMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		callTemplateParameterEClass.getESuperTypes().add(theEsbPackage.getModelObject());
		payloadFactoryMediatorEClass.getESuperTypes().add(theEsbPackage.getMediator());
		payloadFactoryArgumentEClass.getESuperTypes().add(theEsbPackage.getModelObject());

		// Initialize classes and features; add operations and parameters
		initEClass(inMediatorEClass, InMediator.class, "InMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outMediatorEClass, OutMediator.class, "OutMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dropMediatorEClass, DropMediator.class, "DropMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sendMediatorEClass, SendMediator.class, "SendMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSendMediator_AnonymousEndPoint(), theEsbPackage.getEndPoint(), null, "anonymousEndPoint", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_EndPointReference(), theEsbPackage.getEndPointReference(), null, "endPointReference", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSendMediator_ReceivingSequenceType(), this.getReceivingSequenceType(), "receivingSequenceType", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_StaticReceivingSequence(), theEsbPackage.getRegistryKeyProperty(), null, "StaticReceivingSequence", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSendMediator_DynamicReceivingSequence(), theEsbPackage.getNamespacedProperty(), null, "DynamicReceivingSequence", null, 0, 1, SendMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logMediatorEClass, LogMediator.class, "LogMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogMediator_LogCategory(), this.getLogCategory(), "logCategory", "INFO", 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMediator_LogLevel(), this.getLogLevel(), "logLevel", "FULL", 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMediator_LogSeparator(), ecorePackage.getEString(), "logSeparator", ",", 0, 1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogMediator_Properties(), this.getLogProperty(), null, "properties", null, 0, -1, LogMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logPropertyEClass, LogProperty.class, "LogProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterMediatorEClass, FilterMediator.class, "FilterMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilterMediator_ConditionType(), this.getFilterConditionType(), "conditionType", "XPATH", 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_FilterXpath(), theEsbPackage.getNamespacedProperty(), null, "filterXpath", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_FilterSource(), theEsbPackage.getNamespacedProperty(), null, "filterSource", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterMediator_FilterRegex(), ecorePackage.getEString(), "filterRegex", "http://localhost:9000.*", 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_ThenBranch(), this.getFilterThenBranch(), null, "thenBranch", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFilterMediator_ElseBranch(), this.getFilterElseBranch(), null, "elseBranch", null, 0, 1, FilterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterThenBranchEClass, FilterThenBranch.class, "FilterThenBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filterElseBranchEClass, FilterElseBranch.class, "FilterElseBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(switchMediatorEClass, SwitchMediator.class, "SwitchMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchMediator_SourceXpath(), theEsbPackage.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_CaseBranches(), this.getSwitchCaseBranch(), null, "caseBranches", null, 0, -1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchMediator_DefaultBranch(), this.getSwitchDefaultBranch(), null, "defaultBranch", null, 0, 1, SwitchMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseBranchEClass, SwitchCaseBranch.class, "SwitchCaseBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwitchCaseBranch_CaseRegex(), ecorePackage.getEString(), "caseRegex", ".*+", 0, 1, SwitchCaseBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchDefaultBranchEClass, SwitchDefaultBranch.class, "SwitchDefaultBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entitlementMediatorEClass, EntitlementMediator.class, "EntitlementMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntitlementMediator_ServerURL(), ecorePackage.getEString(), "serverURL", "server_url", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_Username(), ecorePackage.getEString(), "username", "username", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_Password(), ecorePackage.getEString(), "password", "password", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OnAccept(), this.getEntitlementMediatorOnAcceptBranch(), null, "onAccept", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_OnReject(), this.getEntitlementMediatorOnRejectBranch(), null, "onReject", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_Obligations(), this.getEntitlementObligationsBranch(), null, "Obligations", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediator_Advice(), this.getEntitlementAdviceBranch(), null, "Advice", null, 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntitlementMediator_CallbackClass(), ecorePackage.getEString(), "callbackClass", "callbackClass", 0, 1, EntitlementMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementAdviceBranchEClass, EntitlementAdviceBranch.class, "EntitlementAdviceBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntitlementAdviceBranch_SequenceType(), this.getEntitlementSequence(), "sequenceType", null, 0, 1, EntitlementAdviceBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementAdviceBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, EntitlementAdviceBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementObligationsBranchEClass, EntitlementObligationsBranch.class, "EntitlementObligationsBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntitlementObligationsBranch_SequenceType(), this.getEntitlementSequence(), "sequenceType", null, 0, 1, EntitlementObligationsBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementObligationsBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, EntitlementObligationsBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementMediatorOnRejectBranchEClass, EntitlementMediatorOnRejectBranch.class, "EntitlementMediatorOnRejectBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntitlementMediatorOnRejectBranch_SequenceType(), this.getEntitlementSequence(), "sequenceType", null, 0, 1, EntitlementMediatorOnRejectBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediatorOnRejectBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, EntitlementMediatorOnRejectBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementMediatorOnAcceptBranchEClass, EntitlementMediatorOnAcceptBranch.class, "EntitlementMediatorOnAcceptBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntitlementMediatorOnAcceptBranch_SequenceType(), this.getEntitlementSequence(), "sequenceType", null, 0, 1, EntitlementMediatorOnAcceptBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntitlementMediatorOnAcceptBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, EntitlementMediatorOnAcceptBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enqueueMediatorEClass, EnqueueMediator.class, "EnqueueMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnqueueMediator_Executor(), ecorePackage.getEString(), "executor", "executor_name", 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnqueueMediator_Priority(), ecorePackage.getEInt(), "priority", "0", 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnqueueMediator_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, EnqueueMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classMediatorEClass, ClassMediator.class, "ClassMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassMediator_ClassName(), ecorePackage.getEString(), "className", "class_name", 0, 1, ClassMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassMediator_Properties(), this.getClassProperty(), null, "properties", null, 0, -1, ClassMediator.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classPropertyEClass, ClassProperty.class, "ClassProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(springMediatorEClass, SpringMediator.class, "SpringMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpringMediator_BeanName(), ecorePackage.getEString(), "beanName", "bean_name", 0, 1, SpringMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpringMediator_ConfigurationKey(), theEsbPackage.getRegistryKeyProperty(), null, "configurationKey", null, 0, 1, SpringMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateMediatorEClass, ValidateMediator.class, "ValidateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidateMediator_SourceXpath(), theEsbPackage.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_OnFailBranch(), this.getValidateOnFailBranch(), null, "onFailBranch", null, 0, 1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_Features(), this.getValidateFeature(), null, "features", null, 0, -1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_Schemas(), this.getValidateSchema(), null, "schemas", null, 0, -1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateMediator_Resources(), this.getValidateResource(), null, "resources", null, 0, -1, ValidateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateOnFailBranchEClass, ValidateOnFailBranch.class, "ValidateOnFailBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validateFeatureEClass, ValidateFeature.class, "ValidateFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(validateSchemaEClass, ValidateSchema.class, "ValidateSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidateSchema_ValidateStaticSchemaKey(), theEsbPackage.getRegistryKeyProperty(), null, "validateStaticSchemaKey", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateSchema_ValidateDynamicSchemaKey(), theEsbPackage.getNamespacedProperty(), null, "validateDynamicSchemaKey", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidateSchema_ValidateSchemaKeyType(), this.getKeyType(), "validateSchemaKeyType", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidateSchema_SchemaKey(), theEsbPackage.getRegistryKeyProperty(), null, "schemaKey", null, 0, 1, ValidateSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validateResourceEClass, ValidateResource.class, "ValidateResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptMediatorEClass, ScriptMediator.class, "ScriptMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptMediator_ScriptType(), this.getScriptType(), "scriptType", "REGISTRY_REFERENCE", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_ScriptLanguage(), this.getScriptLanguage(), "scriptLanguage", "JAVASCRIPT", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_MediateFunction(), ecorePackage.getEString(), "mediateFunction", "mediate", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScriptMediator_ScriptKey(), theEsbPackage.getRegistryKeyProperty(), null, "scriptKey", null, 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScriptMediator_ScriptBody(), ecorePackage.getEString(), "scriptBody", "script_code", 0, 1, ScriptMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enrichMediatorEClass, EnrichMediator.class, "EnrichMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnrichMediator_CloneSource(), ecorePackage.getEBoolean(), "cloneSource", "false", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_SourceType(), this.getEnrichSourceType(), "sourceType", "CUSTOM", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_SourceXpath(), theEsbPackage.getNamespacedProperty(), null, "sourceXpath", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_SourceProperty(), ecorePackage.getEString(), "sourceProperty", "source_property", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_SourceXML(), ecorePackage.getEString(), "sourceXML", "<inline/>", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_TargetAction(), this.getEnrichTargetAction(), "targetAction", "REPLACE", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_TargetType(), this.getEnrichTargetType(), "targetType", "CUSTOM", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_TargetXpath(), theEsbPackage.getNamespacedProperty(), null, "targetXpath", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_TargetProperty(), ecorePackage.getEString(), "targetProperty", "target_property", 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnrichMediator_InlineType(), this.getEnrichSourceInlineType(), "inlineType", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnrichMediator_InlineRegistryKey(), theEsbPackage.getRegistryKeyProperty(), null, "inlineRegistryKey", null, 0, 1, EnrichMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(faultMediatorEClass, FaultMediator.class, "FaultMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFaultMediator_SoapVersion(), this.getFaultSoapVersion(), "soapVersion", "SOAP_1_1", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultCodeSoap11(), this.getFaultCodeSoap11(), "faultCodeSoap11", "VERSION_MISSMATCH", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultStringType(), this.getFaultStringType(), "faultStringType", "VALUE", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultStringValue(), ecorePackage.getEString(), "faultStringValue", "fault_string", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultStringExpression(), theEsbPackage.getNamespacedProperty(), null, "faultStringExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultActor(), ecorePackage.getEString(), "faultActor", "", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultCodeSoap12(), this.getFaultCodeSoap12(), "faultCodeSoap12", "VERSION_MISSMATCH", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultReasonType(), this.getFaultReasonType(), "faultReasonType", "VALUE", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultReasonValue(), ecorePackage.getEString(), "faultReasonValue", "fault_reason", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultReasonExpression(), theEsbPackage.getNamespacedProperty(), null, "faultReasonExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_RoleName(), ecorePackage.getEString(), "roleName", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_NodeName(), ecorePackage.getEString(), "nodeName", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultDetailType(), this.getFaultDetailType(), "faultDetailType", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultMediator_FaultDetailValue(), ecorePackage.getEString(), "faultDetailValue", "fault_detail", 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultMediator_FaultDetailExpression(), theEsbPackage.getNamespacedProperty(), null, "faultDetailExpression", null, 0, 1, FaultMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregateMediatorEClass, AggregateMediator.class, "AggregateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregateMediator_AggregateID(), ecorePackage.getEString(), "aggregateID", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_CorrelationExpression(), theEsbPackage.getNamespacedProperty(), null, "correlationExpression", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionTimeout(), ecorePackage.getEInt(), "completionTimeout", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionMinMessages(), ecorePackage.getEInt(), "completionMinMessages", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateMediator_CompletionMaxMessages(), ecorePackage.getEInt(), "completionMaxMessages", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateMediator_OnCompleteBranch(), this.getAggregateOnCompleteBranch(), null, "onCompleteBranch", null, 0, 1, AggregateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregateOnCompleteBranchEClass, AggregateOnCompleteBranch.class, "AggregateOnCompleteBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregateOnCompleteBranch_AggregationExpression(), theEsbPackage.getNamespacedProperty(), null, "aggregationExpression", null, 0, 1, AggregateOnCompleteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregateOnCompleteBranch_SequenceType(), this.getAggregateSequenceType(), "sequenceType", null, 0, 1, AggregateOnCompleteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregateOnCompleteBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, AggregateOnCompleteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerMediatorEClass, RouterMediator.class, "RouterMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRouterMediator_ContinueAfterRouting(), ecorePackage.getEBoolean(), "continueAfterRouting", null, 0, 1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterMediator_Routes(), this.getRouterRoute(), null, "routes", null, 0, -1, RouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routerRouteEClass, RouterRoute.class, "RouterRoute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRouterRoute_BreakAfterRoute(), ecorePackage.getEBoolean(), "breakAfterRoute", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterRoute_RouteExpression(), theEsbPackage.getNamespacedProperty(), null, "routeExpression", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRouterRoute_RoutePattern(), ecorePackage.getEString(), "routePattern", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRouterRoute_Target(), this.getRouteTarget(), null, "target", null, 0, 1, RouterRoute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(routeTargetEClass, RouteTarget.class, "RouteTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloneMediatorEClass, CloneMediator.class, "CloneMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloneMediator_CloneID(), ecorePackage.getEString(), "cloneID", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneMediator_SequentialMediation(), ecorePackage.getEBoolean(), "sequentialMediation", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneMediator_ContinueParent(), ecorePackage.getEBoolean(), "continueParent", null, 0, 1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneMediator_Targets(), this.getCloneTarget(), null, "targets", null, 0, -1, CloneMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cloneTargetEClass, CloneTarget.class, "CloneTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloneTarget_SoapAction(), ecorePackage.getEString(), "soapAction", null, 0, 1, CloneTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCloneTarget_ToAddress(), ecorePackage.getEString(), "toAddress", null, 0, 1, CloneTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterateMediatorEClass, IterateMediator.class, "IterateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterateMediator_IterateID(), ecorePackage.getEString(), "iterateID", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_SequentialMediation(), ecorePackage.getEBoolean(), "sequentialMediation", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_ContinueParent(), ecorePackage.getEBoolean(), "continueParent", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateMediator_PreservePayload(), ecorePackage.getEBoolean(), "preservePayload", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_IterateExpression(), theEsbPackage.getNamespacedProperty(), null, "iterateExpression", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_AttachPath(), theEsbPackage.getNamespacedProperty(), null, "attachPath", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterateMediator_Target(), this.getIterateTarget(), null, "target", null, 0, 1, IterateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterateTargetEClass, IterateTarget.class, "IterateTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIterateTarget_SoapAction(), ecorePackage.getEString(), "soapAction", null, 0, 1, IterateTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterateTarget_ToAddress(), ecorePackage.getEString(), "toAddress", null, 0, 1, IterateTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheMediatorEClass, CacheMediator.class, "CacheMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCacheMediator_CacheId(), ecorePackage.getEString(), "cacheId", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_CacheScope(), this.getCacheScope(), "cacheScope", "PER_MEDIATOR", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_CacheAction(), this.getCacheAction(), "cacheAction", "FINDER", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_HashGenerator(), ecorePackage.getEString(), "hashGenerator", "org.wso2.caching.digest.DOMHashGenerator", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_CacheTimeout(), ecorePackage.getEInt(), "cacheTimeout", "120", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_MaxMessageSize(), ecorePackage.getEInt(), "maxMessageSize", "2000", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_ImplementationType(), this.getCacheImplementationType(), "implementationType", "IN_MEMORY", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMediator_MaxEntryCount(), ecorePackage.getEInt(), "maxEntryCount", "1000", 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMediator_OnHitBranch(), this.getCacheOnHitBranch(), null, "onHitBranch", null, 0, 1, CacheMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheOnHitBranchEClass, CacheOnHitBranch.class, "CacheOnHitBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCacheOnHitBranch_SequenceType(), this.getCacheSequenceType(), "sequenceType", "REGISTRY_REFERENCE", 0, 1, CacheOnHitBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheOnHitBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, CacheOnHitBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xsltMediatorEClass, XSLTMediator.class, "XSLTMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSLTMediator_Properties(), this.getXSLTProperty(), null, "properties", null, 0, -1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_Features(), this.getXSLTFeature(), null, "features", null, 0, -1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_Resources(), this.getXSLTResource(), null, "resources", null, 0, -1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXSLTMediator_XsltSchemaKeyType(), this.getKeyType(), "xsltSchemaKeyType", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_XsltStaticSchemaKey(), theEsbPackage.getRegistryKeyProperty(), null, "xsltStaticSchemaKey", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_XsltDynamicSchemaKey(), theEsbPackage.getNamespacedProperty(), null, "xsltDynamicSchemaKey", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_SourceXPath(), theEsbPackage.getNamespacedProperty(), null, "sourceXPath", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSLTMediator_XsltKey(), theEsbPackage.getRegistryKeyProperty(), null, "xsltKey", null, 0, 1, XSLTMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xsltPropertyEClass, XSLTProperty.class, "XSLTProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xsltFeatureEClass, XSLTFeature.class, "XSLTFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xsltResourceEClass, XSLTResource.class, "XSLTResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xQueryMediatorEClass, XQueryMediator.class, "XQueryMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXQueryMediator_Variables(), this.getXQueryVariable(), null, "variables", null, 0, -1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_TargetXPath(), theEsbPackage.getNamespacedProperty(), null, "targetXPath", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryMediator_ScriptKeyType(), this.getKeyType(), "scriptKeyType", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_StaticScriptKey(), theEsbPackage.getRegistryKeyProperty(), null, "staticScriptKey", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_DynamicScriptKey(), theEsbPackage.getNamespacedProperty(), null, "dynamicScriptKey", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryMediator_QueryKey(), theEsbPackage.getRegistryKeyProperty(), null, "queryKey", null, 0, 1, XQueryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xQueryVariableEClass, XQueryVariable.class, "XQueryVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXQueryVariable_VariableName(), ecorePackage.getEString(), "variableName", "variable_name", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryVariable_VariableType(), this.getXQueryVariableType(), "variableType", "STRING", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryVariable_ValueType(), this.getXQueryVariableValueType(), "valueType", "LITERAL", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXQueryVariable_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "literal_value", 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryVariable_ValueExpression(), theEsbPackage.getNamespacedProperty(), null, "valueExpression", null, 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXQueryVariable_ValueKey(), theEsbPackage.getRegistryKeyProperty(), null, "valueKey", null, 0, 1, XQueryVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(calloutMediatorEClass, CalloutMediator.class, "CalloutMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCalloutMediator_ServiceURL(), ecorePackage.getEString(), "serviceURL", "service_url", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_SoapAction(), ecorePackage.getEString(), "soapAction", "soap_action", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PathToAxis2xml(), ecorePackage.getEString(), "pathToAxis2xml", "", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PathToAxis2Repository(), ecorePackage.getEString(), "pathToAxis2Repository", "", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PayloadType(), this.getCalloutPayloadType(), "payloadType", "MESSAGE_ELEMENT", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_PayloadMessageXpath(), theEsbPackage.getNamespacedProperty(), null, "payloadMessageXpath", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_PayloadRegistryKey(), theEsbPackage.getRegistryKeyProperty(), null, "payloadRegistryKey", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_ResultType(), this.getCalloutResultType(), "resultType", "MESSAGE_ELEMENT", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_ResultMessageXpath(), theEsbPackage.getNamespacedProperty(), null, "resultMessageXpath", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_ResultContextProperty(), ecorePackage.getEString(), "resultContextProperty", "context_property_name", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_PassHeaders(), ecorePackage.getEBoolean(), "passHeaders", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_UseServerConfig(), ecorePackage.getEBoolean(), "useServerConfig", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCalloutMediator_EndpointType(), this.getCallOutMediatorEndpointType(), "EndpointType", "ANONYMOUS", 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCalloutMediator_EndpointKey(), theEsbPackage.getRegistryKeyProperty(), null, "endpointKey", null, 0, 1, CalloutMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rmSequenceMediatorEClass, RMSequenceMediator.class, "RMSequenceMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRMSequenceMediator_RmSpecVersion(), this.getRMSpecVersion(), "rmSpecVersion", "VERSION_1_0", 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRMSequenceMediator_SequenceType(), this.getRMSequenceType(), "sequenceType", "SINGLE_MESSAGE", 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRMSequenceMediator_CorrelationXpath(), theEsbPackage.getNamespacedProperty(), null, "correlationXpath", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRMSequenceMediator_LastMessageXpath(), theEsbPackage.getNamespacedProperty(), null, "lastMessageXpath", null, 0, 1, RMSequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transactionMediatorEClass, TransactionMediator.class, "TransactionMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransactionMediator_Action(), this.getTransactionAction(), "action", null, 0, 1, TransactionMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyMediatorEClass, PropertyMediator.class, "PropertyMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyMediator_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyDataType(), this.getPropertyDataType(), "propertyDataType", "STRING", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyAction(), this.getPropertyAction(), "propertyAction", "SET", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_PropertyScope(), this.getPropertyScope(), "propertyScope", "SYNAPSE", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueType(), this.getPropertyValueType(), "valueType", "LITERAL", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyMediator_ValueExpression(), theEsbPackage.getNamespacedProperty(), null, "valueExpression", null, 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueOM(), ecorePackage.getEString(), "valueOM", "<value/>", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueStringPattern(), ecorePackage.getEString(), "valueStringPattern", "", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyMediator_ValueStringCapturingGroup(), ecorePackage.getEInt(), "valueStringCapturingGroup", "0", 0, 1, PropertyMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oAuthMediatorEClass, OAuthMediator.class, "OAuthMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOAuthMediator_RemoteServiceUrl(), ecorePackage.getEString(), "remoteServiceUrl", "service_url", 0, 1, OAuthMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autoscaleInMediatorEClass, AutoscaleInMediator.class, "AutoscaleInMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(autoscaleOutMediatorEClass, AutoscaleOutMediator.class, "AutoscaleOutMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(headerMediatorEClass, HeaderMediator.class, "HeaderMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHeaderMediator_HeaderName(), theEsbPackage.getNamespacedProperty(), null, "headerName", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_HeaderAction(), this.getHeaderAction(), "headerAction", "", 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_ValueType(), this.getHeaderValueType(), "valueType", "", 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeaderMediator_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "header_value", 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHeaderMediator_ValueExpression(), theEsbPackage.getNamespacedProperty(), null, "valueExpression", null, 0, 1, HeaderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleMediatorEClass, ThrottleMediator.class, "ThrottleMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottleMediator_GroupId(), ecorePackage.getEString(), "groupId", "group_id", 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_PolicyConfiguration(), this.getThrottlePolicyConfiguration(), null, "policyConfiguration", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnAcceptBranch(), this.getThrottleOnAcceptBranch(), null, "onAcceptBranch", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleMediator_OnRejectBranch(), this.getThrottleOnRejectBranch(), null, "onRejectBranch", null, 0, 1, ThrottleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttlePolicyConfigurationEClass, ThrottlePolicyConfiguration.class, "ThrottlePolicyConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottlePolicyConfiguration_PolicyType(), this.getThrottlePolicyType(), "policyType", "INLINE", 0, 1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottlePolicyConfiguration_PolicyKey(), theEsbPackage.getRegistryKeyProperty(), null, "policyKey", null, 0, 1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyConfiguration_MaxConcurrentAccessCount(), ecorePackage.getEInt(), "maxConcurrentAccessCount", null, 0, 1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottlePolicyConfiguration_PolicyEntries(), this.getThrottlePolicyEntry(), null, "policyEntries", null, 0, -1, ThrottlePolicyConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttlePolicyEntryEClass, ThrottlePolicyEntry.class, "ThrottlePolicyEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottlePolicyEntry_ThrottleType(), this.getThrottleConditionType(), "throttleType", "IP", 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_ThrottleRange(), ecorePackage.getEString(), "throttleRange", "other", 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_AccessType(), this.getThrottleAccessType(), "accessType", "ALLOW", 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_MaxRequestCount(), ecorePackage.getEInt(), "maxRequestCount", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_UnitTime(), ecorePackage.getEInt(), "unitTime", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrottlePolicyEntry_ProhibitPeriod(), ecorePackage.getEInt(), "prohibitPeriod", null, 0, 1, ThrottlePolicyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleOnAcceptBranchEClass, ThrottleOnAcceptBranch.class, "ThrottleOnAcceptBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottleOnAcceptBranch_SequenceType(), this.getThrottleSequenceType(), "sequenceType", "ANONYMOUS", 0, 1, ThrottleOnAcceptBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleOnAcceptBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, ThrottleOnAcceptBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throttleOnRejectBranchEClass, ThrottleOnRejectBranch.class, "ThrottleOnRejectBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrottleOnRejectBranch_SequenceType(), this.getThrottleSequenceType(), "sequenceType", "ANONYMOUS", 0, 1, ThrottleOnRejectBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrottleOnRejectBranch_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, ThrottleOnRejectBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandMediatorEClass, CommandMediator.class, "CommandMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommandMediator_ClassName(), ecorePackage.getEString(), "className", "class_name", 0, 1, CommandMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandMediator_Properties(), this.getCommandProperty(), null, "properties", null, 0, -1, CommandMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandPropertyEClass, CommandProperty.class, "CommandProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommandProperty_PropertyName(), ecorePackage.getEString(), "propertyName", "property_name", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ValueType(), this.getCommandPropertyValueType(), "valueType", "LITERAL", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "literal_value", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ValueContextPropertyName(), ecorePackage.getEString(), "valueContextPropertyName", "context_property_name", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandProperty_ValueMessageElementXpath(), theEsbPackage.getNamespacedProperty(), null, "valueMessageElementXpath", null, 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_ContextAction(), this.getCommandPropertyContextAction(), "contextAction", "READ_AND_UPDATE_CONTEXT", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandProperty_MessageAction(), this.getCommandPropertyMessageAction(), "messageAction", "READ_AND_UPDATE_MESSAGE", 0, 1, CommandProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventMediatorEClass, EventMediator.class, "EventMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventMediator_TopicType(), this.getKeyType(), "topicType", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventMediator_StaticTopic(), ecorePackage.getEString(), "staticTopic", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventMediator_DynamicTopic(), theEsbPackage.getNamespacedProperty(), null, "dynamicTopic", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventMediator_EventExpression(), theEsbPackage.getNamespacedProperty(), null, "eventExpression", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventMediator_EventSource(), ecorePackage.getEString(), "eventSource", null, 0, 1, EventMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractSqlExecutorMediatorEClass, AbstractSqlExecutorMediator.class, "AbstractSqlExecutorMediator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionType(), this.getSqlExecutorConnectionType(), "connectionType", "DB_CONNECTION", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDsType(), this.getSqlExecutorDatasourceType(), "connectionDsType", "EXTERNAL", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDbDriver(), ecorePackage.getEString(), "connectionDbDriver", "driver_class", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDsInitialContext(), ecorePackage.getEString(), "connectionDsInitialContext", "initial_context", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionDsName(), ecorePackage.getEString(), "connectionDsName", "datasource_name", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionURL(), ecorePackage.getEString(), "connectionURL", "connection_url", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionUsername(), ecorePackage.getEString(), "connectionUsername", "username", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_ConnectionPassword(), ecorePackage.getEString(), "connectionPassword", "password", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyAutocommit(), this.getSqlExecutorBooleanValue(), "propertyAutocommit", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyIsolation(), this.getSqlExecutorIsolationLevel(), "propertyIsolation", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxactive(), ecorePackage.getEInt(), "propertyMaxactive", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxidle(), ecorePackage.getEInt(), "propertyMaxidle", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxopenstatements(), ecorePackage.getEInt(), "propertyMaxopenstatements", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMaxwait(), ecorePackage.getEInt(), "propertyMaxwait", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyMinidle(), ecorePackage.getEInt(), "propertyMinidle", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyPoolstatements(), this.getSqlExecutorBooleanValue(), "propertyPoolstatements", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyTestonborrow(), this.getSqlExecutorBooleanValue(), "propertyTestonborrow", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyTestwhileidle(), this.getSqlExecutorBooleanValue(), "propertyTestwhileidle", "DEFAULT", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyValidationquery(), ecorePackage.getEString(), "propertyValidationquery", "", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSqlExecutorMediator_PropertyInitialsize(), ecorePackage.getEInt(), "propertyInitialsize", "-1", 0, 1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractSqlExecutorMediator_SqlStatements(), this.getSqlStatement(), null, "sqlStatements", null, 0, -1, AbstractSqlExecutorMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlStatementEClass, SqlStatement.class, "SqlStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlStatement_QueryString(), ecorePackage.getEString(), "queryString", "sql_query", 0, 1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSqlStatement_Parameters(), this.getSqlParameterDefinition(), null, "parameters", null, 0, -1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlStatement_ResultsEnabled(), ecorePackage.getEBoolean(), "resultsEnabled", "false", 0, 1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSqlStatement_Results(), this.getSqlResultMapping(), null, "results", null, 0, -1, SqlStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlParameterDefinitionEClass, SqlParameterDefinition.class, "SqlParameterDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlParameterDefinition_DataType(), this.getSqlParameterDataType(), "dataType", "CHAR", 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlParameterDefinition_ValueType(), this.getSqlParameterValueType(), "valueType", "LITERAL", 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlParameterDefinition_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSqlParameterDefinition_ValueExpression(), theEsbPackage.getNamespacedProperty(), null, "valueExpression", null, 0, 1, SqlParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sqlResultMappingEClass, SqlResultMapping.class, "SqlResultMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSqlResultMapping_PropertyName(), ecorePackage.getEString(), "propertyName", "message_context_property_name", 0, 1, SqlResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSqlResultMapping_ColumnId(), ecorePackage.getEString(), "columnId", "column_name_or_index", 0, 1, SqlResultMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dbLookupMediatorEClass, DBLookupMediator.class, "DBLookupMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dbReportMediatorEClass, DBReportMediator.class, "DBReportMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBReportMediator_ConnectionUseTransaction(), ecorePackage.getEBoolean(), "connectionUseTransaction", "false", 0, 1, DBReportMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleMediatorEClass, RuleMediator.class, "RuleMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleMediator_RuleSetConfiguration(), this.getRuleSetConfiguration(), null, "ruleSetConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_RuleSessionConfiguration(), this.getRuleSessionConfiguration(), null, "ruleSessionConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_FactsConfiguration(), this.getRuleFactsConfiguration(), null, "factsConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_ResultsConfiguration(), this.getRuleResultsConfiguration(), null, "resultsConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleMediator_ChildMediatorsConfiguration(), this.getRuleChildMediatorsConfiguration(), null, "childMediatorsConfiguration", null, 0, 1, RuleMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleSetConfigurationEClass, RuleSetConfiguration.class, "RuleSetConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleSetConfiguration_SourceType(), this.getRuleSourceType(), "sourceType", "INLINE", 0, 1, RuleSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleSetConfiguration_SourceCode(), ecorePackage.getEString(), "sourceCode", "<code/>", 0, 1, RuleSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleSetConfiguration_SourceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sourceKey", null, 0, 1, RuleSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleSetConfiguration_Properties(), this.getRuleSetCreationProperty(), null, "properties", null, 0, -1, RuleSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleSetCreationPropertyEClass, RuleSetCreationProperty.class, "RuleSetCreationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleSessionConfigurationEClass, RuleSessionConfiguration.class, "RuleSessionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleSessionConfiguration_StatefulSession(), ecorePackage.getEBoolean(), "statefulSession", "true", 0, 1, RuleSessionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleSessionConfiguration_Properties(), this.getRuleSessionProperty(), null, "properties", null, 0, -1, RuleSessionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleSessionPropertyEClass, RuleSessionProperty.class, "RuleSessionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ruleFactsConfigurationEClass, RuleFactsConfiguration.class, "RuleFactsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleFactsConfiguration_Facts(), this.getRuleFact(), null, "facts", null, 0, -1, RuleFactsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleFactEClass, RuleFact.class, "RuleFact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleFact_FactType(), this.getRuleFactType(), "factType", "CUSTOM", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_FactCustomType(), ecorePackage.getEString(), "factCustomType", "custom_type", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_FactName(), ecorePackage.getEString(), "factName", "fact_name", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_ValueType(), this.getRuleFactValueType(), "valueType", "LITERAL", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleFact_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleFact_ValueExpression(), theEsbPackage.getNamespacedProperty(), null, "valueExpression", null, 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleFact_ValueKey(), theEsbPackage.getRegistryKeyProperty(), null, "valueKey", null, 0, 1, RuleFact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleResultsConfigurationEClass, RuleResultsConfiguration.class, "RuleResultsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleResultsConfiguration_Results(), this.getRuleResult(), null, "results", null, 0, -1, RuleResultsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleResultEClass, RuleResult.class, "RuleResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleResult_ResultType(), this.getRuleResultType(), "resultType", "CUSTOM", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ResultCustomType(), ecorePackage.getEString(), "resultCustomType", "custom_type", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ResultName(), ecorePackage.getEString(), "resultName", "result_name", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ValueType(), this.getRuleResultValueType(), "valueType", "LITERAL", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleResult_ValueLiteral(), ecorePackage.getEString(), "valueLiteral", "value", 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleResult_ValueExpression(), theEsbPackage.getNamespacedProperty(), null, "valueExpression", null, 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleResult_ValueKey(), theEsbPackage.getRegistryKeyProperty(), null, "valueKey", null, 0, 1, RuleResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleChildMediatorsConfigurationEClass, RuleChildMediatorsConfiguration.class, "RuleChildMediatorsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceMediatorEClass, SequenceMediator.class, "SequenceMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequenceMediator_ReferringSequenceType(), this.getKeyType(), "referringSequenceType", null, 0, 1, SequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceMediator_DynamicReferenceKey(), theEsbPackage.getNamespacedProperty(), null, "dynamicReferenceKey", null, 0, 1, SequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceMediator_StaticReferenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "staticReferenceKey", null, 0, 1, SequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceMediator_SequenceKey(), theEsbPackage.getRegistryKeyProperty(), null, "sequenceKey", null, 0, 1, SequenceMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderMediatorEClass, BuilderMediator.class, "BuilderMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderMediator_MessageBuilders(), this.getMessageBuilder(), null, "messageBuilders", null, 0, -1, BuilderMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageBuilderEClass, MessageBuilder.class, "MessageBuilder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMessageBuilder_ContentType(), ecorePackage.getEString(), "contentType", "application/xml", 0, 1, MessageBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageBuilder_BuilderClass(), ecorePackage.getEString(), "builderClass", "org.apache.axis2.builder.ApplicationXMLBuilder", 0, 1, MessageBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageBuilder_FormatterClass(), ecorePackage.getEString(), "formatterClass", "org.apache.axis2.transport.http.ApplicationXMLFormatter", 0, 1, MessageBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smooksMediatorEClass, SmooksMediator.class, "SmooksMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSmooksMediator_ConfigurationKey(), theEsbPackage.getRegistryKeyProperty(), null, "configurationKey", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksMediator_Input(), this.getSmooksInConfiguration(), null, "input", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksMediator_Output(), this.getSmooksOutConfiguration(), null, "output", null, 0, 1, SmooksMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smooksInConfigurationEClass, SmooksInConfiguration.class, "SmooksInConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSmooksInConfiguration_Type(), this.getSmooksIODataType(), "type", null, 0, 1, SmooksInConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksInConfiguration_Expression(), theEsbPackage.getNamespacedProperty(), null, "expression", null, 0, 1, SmooksInConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(smooksOutConfigurationEClass, SmooksOutConfiguration.class, "SmooksOutConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSmooksOutConfiguration_Type(), this.getSmooksIODataType(), "type", null, 0, 1, SmooksOutConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSmooksOutConfiguration_Expression(), theEsbPackage.getNamespacedProperty(), null, "expression", null, 0, 1, SmooksOutConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksOutConfiguration_Property(), ecorePackage.getEString(), "property", null, 0, 1, SmooksOutConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksOutConfiguration_Action(), this.getExpressionAction(), "action", null, 0, 1, SmooksOutConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSmooksOutConfiguration_OutputMethod(), this.getOutputMethod(), "outputMethod", "", 0, 1, SmooksOutConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storeMediatorEClass, StoreMediator.class, "StoreMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStoreMediator_MessageStore(), ecorePackage.getEString(), "messageStore", "<test/>", 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoreMediator_OnStoreSequence(), theEsbPackage.getRegistryKeyProperty(), null, "onStoreSequence", null, 0, 1, StoreMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalRouteBranchEClass, ConditionalRouteBranch.class, "ConditionalRouteBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalRouteBranch_BreakAfterRoute(), ecorePackage.getEBoolean(), "breakAfterRoute", null, 0, 1, ConditionalRouteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouteBranch_EvaluatorExpression(), theEsbPackage.getEvaluatorExpressionProperty(), null, "evaluatorExpression", null, 0, 1, ConditionalRouteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouteBranch_TargetSequence(), theEsbPackage.getRegistryKeyProperty(), null, "targetSequence", null, 0, 1, ConditionalRouteBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalRouterMediatorEClass, ConditionalRouterMediator.class, "ConditionalRouterMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalRouterMediator_ContinueAfterRoute(), ecorePackage.getEBoolean(), "continueAfterRoute", null, 0, 1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalRouterMediator_ConditionalRouteBraches(), this.getConditionalRouteBranch(), null, "conditionalRouteBraches", null, 0, -1, ConditionalRouterMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlRewriteRuleActionEClass, URLRewriteRuleAction.class, "URLRewriteRuleAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getURLRewriteRuleAction_RuleAction(), this.getRuleActionType(), "ruleAction", "", 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_RuleFragment(), this.getRuleFragmentType(), "ruleFragment", "", 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_RuleOption(), this.getRuleOptionType(), "ruleOption", "", 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLRewriteRuleAction_ActionExpression(), theEsbPackage.getNamespacedProperty(), null, "actionExpression", null, 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_ActionValue(), ecorePackage.getEString(), "actionValue", "", 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteRuleAction_ActionRegex(), ecorePackage.getEString(), "actionRegex", "", 0, 1, URLRewriteRuleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlRewriteRuleEClass, URLRewriteRule.class, "URLRewriteRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURLRewriteRule_UrlRewriteRuleCondition(), theEsbPackage.getEvaluatorExpressionProperty(), null, "urlRewriteRuleCondition", null, 0, 1, URLRewriteRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getURLRewriteRule_RewriteRuleAction(), this.getURLRewriteRuleAction(), null, "rewriteRuleAction", null, 0, -1, URLRewriteRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(urlRewriteMediatorEClass, URLRewriteMediator.class, "URLRewriteMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getURLRewriteMediator_UrlRewriteRules(), this.getURLRewriteRule(), null, "urlRewriteRules", null, 0, -1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteMediator_InProperty(), ecorePackage.getEString(), "InProperty", null, 0, 1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getURLRewriteMediator_OutProperty(), ecorePackage.getEString(), "outProperty", null, 0, 1, URLRewriteMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callTemplateMediatorEClass, CallTemplateMediator.class, "CallTemplateMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCallTemplateMediator_TargetTemplate(), ecorePackage.getEString(), "targetTemplate", null, 0, 1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallTemplateMediator_TemplateParameters(), this.getCallTemplateParameter(), null, "templateParameters", null, 0, -1, CallTemplateMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callTemplateParameterEClass, CallTemplateParameter.class, "CallTemplateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCallTemplateParameter_ParameterName(), ecorePackage.getEString(), "parameterName", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallTemplateParameter_TemplateParameterType(), this.getRuleOptionType(), "templateParameterType", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallTemplateParameter_ParameterValue(), ecorePackage.getEString(), "parameterValue", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallTemplateParameter_ParameterExpression(), theEsbPackage.getNamespacedProperty(), null, "parameterExpression", null, 0, 1, CallTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(payloadFactoryMediatorEClass, PayloadFactoryMediator.class, "PayloadFactoryMediator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPayloadFactoryMediator_Format(), ecorePackage.getEString(), "format", null, 0, 1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryMediator_Args(), this.getPayloadFactoryArgument(), null, "args", null, 0, -1, PayloadFactoryMediator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(payloadFactoryArgumentEClass, PayloadFactoryArgument.class, "PayloadFactoryArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPayloadFactoryArgument_ArgumentType(), this.getPayloadFactoryArgumentType(), "argumentType", null, 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPayloadFactoryArgument_ArgumentValue(), ecorePackage.getEString(), "argumentValue", null, 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPayloadFactoryArgument_ArgumentExpression(), theEsbPackage.getNamespacedProperty(), null, "argumentExpression", null, 0, 1, PayloadFactoryArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(logCategoryEEnum, LogCategory.class, "LogCategory");
		addEEnumLiteral(logCategoryEEnum, LogCategory.TRACE);
		addEEnumLiteral(logCategoryEEnum, LogCategory.DEBUG);
		addEEnumLiteral(logCategoryEEnum, LogCategory.INFO);
		addEEnumLiteral(logCategoryEEnum, LogCategory.WARN);
		addEEnumLiteral(logCategoryEEnum, LogCategory.ERROR);
		addEEnumLiteral(logCategoryEEnum, LogCategory.FATAL);

		initEEnum(logLevelEEnum, LogLevel.class, "LogLevel");
		addEEnumLiteral(logLevelEEnum, LogLevel.FULL);
		addEEnumLiteral(logLevelEEnum, LogLevel.SIMPLE);
		addEEnumLiteral(logLevelEEnum, LogLevel.HEADERS);
		addEEnumLiteral(logLevelEEnum, LogLevel.CUSTOM);

		initEEnum(filterConditionTypeEEnum, FilterConditionType.class, "FilterConditionType");
		addEEnumLiteral(filterConditionTypeEEnum, FilterConditionType.XPATH);
		addEEnumLiteral(filterConditionTypeEEnum, FilterConditionType.SOURCE_AND_REGULAR_EXPRESSION);

		initEEnum(entitlementSequenceEEnum, EntitlementSequence.class, "EntitlementSequence");
		addEEnumLiteral(entitlementSequenceEEnum, EntitlementSequence.ANONYMOUS);
		addEEnumLiteral(entitlementSequenceEEnum, EntitlementSequence.REGISTRY_REFERENCE);

		initEEnum(scriptTypeEEnum, ScriptType.class, "ScriptType");
		addEEnumLiteral(scriptTypeEEnum, ScriptType.INLINE);
		addEEnumLiteral(scriptTypeEEnum, ScriptType.REGISTRY_REFERENCE);

		initEEnum(scriptLanguageEEnum, ScriptLanguage.class, "ScriptLanguage");
		addEEnumLiteral(scriptLanguageEEnum, ScriptLanguage.JAVASCRIPT);
		addEEnumLiteral(scriptLanguageEEnum, ScriptLanguage.RUBY);
		addEEnumLiteral(scriptLanguageEEnum, ScriptLanguage.GROOVY);

		initEEnum(enrichSourceTypeEEnum, EnrichSourceType.class, "EnrichSourceType");
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.CUSTOM);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.ENVELOPE);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.BODY);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.PROPERTY);
		addEEnumLiteral(enrichSourceTypeEEnum, EnrichSourceType.INLINE);

		initEEnum(enrichTargetActionEEnum, EnrichTargetAction.class, "EnrichTargetAction");
		addEEnumLiteral(enrichTargetActionEEnum, EnrichTargetAction.REPLACE);
		addEEnumLiteral(enrichTargetActionEEnum, EnrichTargetAction.CHILD);
		addEEnumLiteral(enrichTargetActionEEnum, EnrichTargetAction.SIBLING);

		initEEnum(enrichTargetTypeEEnum, EnrichTargetType.class, "EnrichTargetType");
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.CUSTOM);
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.ENVELOPE);
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.BODY);
		addEEnumLiteral(enrichTargetTypeEEnum, EnrichTargetType.PROPERTY);

		initEEnum(faultSoapVersionEEnum, FaultSoapVersion.class, "FaultSoapVersion");
		addEEnumLiteral(faultSoapVersionEEnum, FaultSoapVersion.SOAP_11);
		addEEnumLiteral(faultSoapVersionEEnum, FaultSoapVersion.SOAP_12);

		initEEnum(faultCodeSoap11EEnum, FaultCodeSoap11.class, "FaultCodeSoap11");
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.VERSION_MISSMATCH);
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.MUST_UNDERSTAND);
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.CLIENT);
		addEEnumLiteral(faultCodeSoap11EEnum, FaultCodeSoap11.SERVER);

		initEEnum(faultCodeSoap12EEnum, FaultCodeSoap12.class, "FaultCodeSoap12");
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.VERSION_MISSMATCH);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.MUST_UNDERSTAND);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.DATA_ENCODING_UNKNOWN);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.SENDER);
		addEEnumLiteral(faultCodeSoap12EEnum, FaultCodeSoap12.RECEIVER);

		initEEnum(faultStringTypeEEnum, FaultStringType.class, "FaultStringType");
		addEEnumLiteral(faultStringTypeEEnum, FaultStringType.VALUE);
		addEEnumLiteral(faultStringTypeEEnum, FaultStringType.EXPRESSION);

		initEEnum(faultReasonTypeEEnum, FaultReasonType.class, "FaultReasonType");
		addEEnumLiteral(faultReasonTypeEEnum, FaultReasonType.VALUE);
		addEEnumLiteral(faultReasonTypeEEnum, FaultReasonType.EXPRESSION);

		initEEnum(faultDetailTypeEEnum, FaultDetailType.class, "FaultDetailType");
		addEEnumLiteral(faultDetailTypeEEnum, FaultDetailType.VALUE);
		addEEnumLiteral(faultDetailTypeEEnum, FaultDetailType.EXPRESSION);

		initEEnum(aggregateSequenceTypeEEnum, AggregateSequenceType.class, "AggregateSequenceType");
		addEEnumLiteral(aggregateSequenceTypeEEnum, AggregateSequenceType.ANONYMOUS);
		addEEnumLiteral(aggregateSequenceTypeEEnum, AggregateSequenceType.REGISTRY_REFERENCE);

		initEEnum(cacheSequenceTypeEEnum, CacheSequenceType.class, "CacheSequenceType");
		addEEnumLiteral(cacheSequenceTypeEEnum, CacheSequenceType.ANONYMOUS);
		addEEnumLiteral(cacheSequenceTypeEEnum, CacheSequenceType.REGISTRY_REFERENCE);

		initEEnum(cacheImplementationTypeEEnum, CacheImplementationType.class, "CacheImplementationType");
		addEEnumLiteral(cacheImplementationTypeEEnum, CacheImplementationType.IN_MEMORY);

		initEEnum(cacheActionEEnum, CacheAction.class, "CacheAction");
		addEEnumLiteral(cacheActionEEnum, CacheAction.FINDER);
		addEEnumLiteral(cacheActionEEnum, CacheAction.COLLECTOR);

		initEEnum(cacheScopeEEnum, CacheScope.class, "CacheScope");
		addEEnumLiteral(cacheScopeEEnum, CacheScope.PER_MEDIATOR);
		addEEnumLiteral(cacheScopeEEnum, CacheScope.PER_HOST);

		initEEnum(xQueryVariableTypeEEnum, XQueryVariableType.class, "XQueryVariableType");
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.DOCUMENT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.DOCUMENT_ELEMENT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.ELEMENT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.INT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.INTEGER);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.BOOLEAN);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.BYTE);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.DOUBLE);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.SHORT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.LONG);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.FLOAT);
		addEEnumLiteral(xQueryVariableTypeEEnum, XQueryVariableType.STRING);

		initEEnum(xQueryVariableValueTypeEEnum, XQueryVariableValueType.class, "XQueryVariableValueType");
		addEEnumLiteral(xQueryVariableValueTypeEEnum, XQueryVariableValueType.LITERAL);
		addEEnumLiteral(xQueryVariableValueTypeEEnum, XQueryVariableValueType.EXPRESSION);

		initEEnum(calloutPayloadTypeEEnum, CalloutPayloadType.class, "CalloutPayloadType");
		addEEnumLiteral(calloutPayloadTypeEEnum, CalloutPayloadType.MESSAGE_ELEMENT);
		addEEnumLiteral(calloutPayloadTypeEEnum, CalloutPayloadType.REGISTRY_ENTRY);

		initEEnum(calloutResultTypeEEnum, CalloutResultType.class, "CalloutResultType");
		addEEnumLiteral(calloutResultTypeEEnum, CalloutResultType.MESSAGE_ELEMENT);
		addEEnumLiteral(calloutResultTypeEEnum, CalloutResultType.CONTEXT_PROPERTY);

		initEEnum(rmSpecVersionEEnum, RMSpecVersion.class, "RMSpecVersion");
		addEEnumLiteral(rmSpecVersionEEnum, RMSpecVersion.VERSION_10);
		addEEnumLiteral(rmSpecVersionEEnum, RMSpecVersion.VERSION_11);

		initEEnum(rmSequenceTypeEEnum, RMSequenceType.class, "RMSequenceType");
		addEEnumLiteral(rmSequenceTypeEEnum, RMSequenceType.SINGLE_MESSAGE);
		addEEnumLiteral(rmSequenceTypeEEnum, RMSequenceType.CORRELATED_SEQUENCE);

		initEEnum(transactionActionEEnum, TransactionAction.class, "TransactionAction");
		addEEnumLiteral(transactionActionEEnum, TransactionAction.COMMIT);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.FAULT_IF_NO_TRANSACTION);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.INITIATE_NEW);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.RESUME);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.SUSPEND);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.ROLLBACK);
		addEEnumLiteral(transactionActionEEnum, TransactionAction.USE_EXISTING_OR_NEW);

		initEEnum(propertyDataTypeEEnum, PropertyDataType.class, "PropertyDataType");
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.STRING);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.INTEGER);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.BOOLEAN);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.DOUBLE);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.FLOAT);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.LONG);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.SHORT);
		addEEnumLiteral(propertyDataTypeEEnum, PropertyDataType.OM);

		initEEnum(propertyActionEEnum, PropertyAction.class, "PropertyAction");
		addEEnumLiteral(propertyActionEEnum, PropertyAction.SET);
		addEEnumLiteral(propertyActionEEnum, PropertyAction.REMOVE);

		initEEnum(propertyScopeEEnum, PropertyScope.class, "PropertyScope");
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.SYNAPSE);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.TRANSPORT);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.AXIS2);
		addEEnumLiteral(propertyScopeEEnum, PropertyScope.AXIS2_CLIENT);

		initEEnum(propertyValueTypeEEnum, PropertyValueType.class, "PropertyValueType");
		addEEnumLiteral(propertyValueTypeEEnum, PropertyValueType.LITERAL);
		addEEnumLiteral(propertyValueTypeEEnum, PropertyValueType.EXPRESSION);

		initEEnum(headerActionEEnum, HeaderAction.class, "HeaderAction");
		addEEnumLiteral(headerActionEEnum, HeaderAction.SET);
		addEEnumLiteral(headerActionEEnum, HeaderAction.REMOVE);

		initEEnum(headerValueTypeEEnum, HeaderValueType.class, "HeaderValueType");
		addEEnumLiteral(headerValueTypeEEnum, HeaderValueType.LITERAL);
		addEEnumLiteral(headerValueTypeEEnum, HeaderValueType.EXPRESSION);

		initEEnum(throttlePolicyTypeEEnum, ThrottlePolicyType.class, "ThrottlePolicyType");
		addEEnumLiteral(throttlePolicyTypeEEnum, ThrottlePolicyType.INLINE);
		addEEnumLiteral(throttlePolicyTypeEEnum, ThrottlePolicyType.REGISTRY_REFERENCE);

		initEEnum(throttleConditionTypeEEnum, ThrottleConditionType.class, "ThrottleConditionType");
		addEEnumLiteral(throttleConditionTypeEEnum, ThrottleConditionType.IP);
		addEEnumLiteral(throttleConditionTypeEEnum, ThrottleConditionType.DOMAIN);

		initEEnum(throttleAccessTypeEEnum, ThrottleAccessType.class, "ThrottleAccessType");
		addEEnumLiteral(throttleAccessTypeEEnum, ThrottleAccessType.ALLOW);
		addEEnumLiteral(throttleAccessTypeEEnum, ThrottleAccessType.DENY);
		addEEnumLiteral(throttleAccessTypeEEnum, ThrottleAccessType.CONTROL);

		initEEnum(throttleSequenceTypeEEnum, ThrottleSequenceType.class, "ThrottleSequenceType");
		addEEnumLiteral(throttleSequenceTypeEEnum, ThrottleSequenceType.ANONYMOUS);
		addEEnumLiteral(throttleSequenceTypeEEnum, ThrottleSequenceType.REGISTRY_REFERENCE);

		initEEnum(commandPropertyValueTypeEEnum, CommandPropertyValueType.class, "CommandPropertyValueType");
		addEEnumLiteral(commandPropertyValueTypeEEnum, CommandPropertyValueType.LITERAL);
		addEEnumLiteral(commandPropertyValueTypeEEnum, CommandPropertyValueType.MESSAGE_ELEMENT);
		addEEnumLiteral(commandPropertyValueTypeEEnum, CommandPropertyValueType.CONTEXT_PROPERTY);

		initEEnum(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.class, "CommandPropertyMessageAction");
		addEEnumLiteral(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.READ_MESSAGE);
		addEEnumLiteral(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.UPDATE_MESSAGE);
		addEEnumLiteral(commandPropertyMessageActionEEnum, CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE);

		initEEnum(commandPropertyContextActionEEnum, CommandPropertyContextAction.class, "CommandPropertyContextAction");
		addEEnumLiteral(commandPropertyContextActionEEnum, CommandPropertyContextAction.READ_CONTEXT);
		addEEnumLiteral(commandPropertyContextActionEEnum, CommandPropertyContextAction.UPDATE_CONTEXT);
		addEEnumLiteral(commandPropertyContextActionEEnum, CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT);

		initEEnum(sqlExecutorConnectionTypeEEnum, SqlExecutorConnectionType.class, "SqlExecutorConnectionType");
		addEEnumLiteral(sqlExecutorConnectionTypeEEnum, SqlExecutorConnectionType.DB_CONNECTION);
		addEEnumLiteral(sqlExecutorConnectionTypeEEnum, SqlExecutorConnectionType.DATA_SOURCE);

		initEEnum(sqlExecutorDatasourceTypeEEnum, SqlExecutorDatasourceType.class, "SqlExecutorDatasourceType");
		addEEnumLiteral(sqlExecutorDatasourceTypeEEnum, SqlExecutorDatasourceType.EXTERNAL);
		addEEnumLiteral(sqlExecutorDatasourceTypeEEnum, SqlExecutorDatasourceType.CARBON);

		initEEnum(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.class, "SqlExecutorBooleanValue");
		addEEnumLiteral(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.FALSE);
		addEEnumLiteral(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.TRUE);
		addEEnumLiteral(sqlExecutorBooleanValueEEnum, SqlExecutorBooleanValue.DEFAULT);

		initEEnum(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.class, "SqlExecutorIsolationLevel");
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_NONE);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_READ_COMMITTED);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_READ_UNCOMMITTED);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_REPEATABLE_READ);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.TRANSACTION_SERIALIZABLE);
		addEEnumLiteral(sqlExecutorIsolationLevelEEnum, SqlExecutorIsolationLevel.DEFAULT);

		initEEnum(sqlParameterValueTypeEEnum, SqlParameterValueType.class, "SqlParameterValueType");
		addEEnumLiteral(sqlParameterValueTypeEEnum, SqlParameterValueType.LITERAL);
		addEEnumLiteral(sqlParameterValueTypeEEnum, SqlParameterValueType.EXPRESSION);

		initEEnum(sqlParameterDataTypeEEnum, SqlParameterDataType.class, "SqlParameterDataType");
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.CHAR);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.VARCHAR);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.LONGVARCHAR);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.NUMERIC);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.DECIMAL);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.BIT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.TINYINT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.SMALLINT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.INTEGER);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.BIGINT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.REAL);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.FLOAT);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.DOUBLE);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.DATE);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.TIME);
		addEEnumLiteral(sqlParameterDataTypeEEnum, SqlParameterDataType.TIMESTAMP);

		initEEnum(ruleSourceTypeEEnum, RuleSourceType.class, "RuleSourceType");
		addEEnumLiteral(ruleSourceTypeEEnum, RuleSourceType.INLINE);
		addEEnumLiteral(ruleSourceTypeEEnum, RuleSourceType.REGISTRY_REFERENCE);

		initEEnum(ruleFactTypeEEnum, RuleFactType.class, "RuleFactType");
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.CUSTOM);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.DOM);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.MESSAGE);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.CONTEXT);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.OMELEMENT);
		addEEnumLiteral(ruleFactTypeEEnum, RuleFactType.MEDIATOR);

		initEEnum(ruleFactValueTypeEEnum, RuleFactValueType.class, "RuleFactValueType");
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.NONE);
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.LITERAL);
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.EXPRESSION);
		addEEnumLiteral(ruleFactValueTypeEEnum, RuleFactValueType.REGISTRY_REFERENCE);

		initEEnum(ruleResultTypeEEnum, RuleResultType.class, "RuleResultType");
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.CUSTOM);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.DOM);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.MESSAGE);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.CONTEXT);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.OMELEMENT);
		addEEnumLiteral(ruleResultTypeEEnum, RuleResultType.MEDIATOR);

		initEEnum(ruleResultValueTypeEEnum, RuleResultValueType.class, "RuleResultValueType");
		addEEnumLiteral(ruleResultValueTypeEEnum, RuleResultValueType.LITERAL);
		addEEnumLiteral(ruleResultValueTypeEEnum, RuleResultValueType.EXPRESSION);
		addEEnumLiteral(ruleResultValueTypeEEnum, RuleResultValueType.REGISTRY_REFERENCE);

		initEEnum(smooksIODataTypeEEnum, SmooksIODataType.class, "SmooksIODataType");
		addEEnumLiteral(smooksIODataTypeEEnum, SmooksIODataType.XML);
		addEEnumLiteral(smooksIODataTypeEEnum, SmooksIODataType.TEXT);

		initEEnum(expressionActionEEnum, ExpressionAction.class, "ExpressionAction");
		addEEnumLiteral(expressionActionEEnum, ExpressionAction.ADD);
		addEEnumLiteral(expressionActionEEnum, ExpressionAction.REPLACE);
		addEEnumLiteral(expressionActionEEnum, ExpressionAction.SIBLING);

		initEEnum(outputMethodEEnum, OutputMethod.class, "OutputMethod");
		addEEnumLiteral(outputMethodEEnum, OutputMethod.DEFAULT);
		addEEnumLiteral(outputMethodEEnum, OutputMethod.PROPERTY);
		addEEnumLiteral(outputMethodEEnum, OutputMethod.EXPRESSION);

		initEEnum(receivingSequenceTypeEEnum, ReceivingSequenceType.class, "ReceivingSequenceType");
		addEEnumLiteral(receivingSequenceTypeEEnum, ReceivingSequenceType.DEFAULT);
		addEEnumLiteral(receivingSequenceTypeEEnum, ReceivingSequenceType.STATIC);
		addEEnumLiteral(receivingSequenceTypeEEnum, ReceivingSequenceType.DYNAMIC);

		initEEnum(keyTypeEEnum, KeyType.class, "KeyType");
		addEEnumLiteral(keyTypeEEnum, KeyType.STATIC);
		addEEnumLiteral(keyTypeEEnum, KeyType.DYNAMIC);

		initEEnum(ruleActionTypeEEnum, RuleActionType.class, "RuleActionType");
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.REPLACE);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.REMOVE);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.APPEND);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.PREPEND);
		addEEnumLiteral(ruleActionTypeEEnum, RuleActionType.SET);

		initEEnum(ruleFragmentTypeEEnum, RuleFragmentType.class, "RuleFragmentType");
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.PROTOCOL);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.HOST);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.PORT);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.PATH);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.QUERY);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.REF);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.USER);
		addEEnumLiteral(ruleFragmentTypeEEnum, RuleFragmentType.FULL);

		initEEnum(ruleOptionTypeEEnum, RuleOptionType.class, "RuleOptionType");
		addEEnumLiteral(ruleOptionTypeEEnum, RuleOptionType.VALUE);
		addEEnumLiteral(ruleOptionTypeEEnum, RuleOptionType.EXPRESSION);

		initEEnum(enrichSourceInlineTypeEEnum, EnrichSourceInlineType.class, "EnrichSourceInlineType");
		addEEnumLiteral(enrichSourceInlineTypeEEnum, EnrichSourceInlineType.CONTENT);
		addEEnumLiteral(enrichSourceInlineTypeEEnum, EnrichSourceInlineType.KEY);

		initEEnum(payloadFactoryArgumentTypeEEnum, PayloadFactoryArgumentType.class, "PayloadFactoryArgumentType");
		addEEnumLiteral(payloadFactoryArgumentTypeEEnum, PayloadFactoryArgumentType.VALUE);
		addEEnumLiteral(payloadFactoryArgumentTypeEEnum, PayloadFactoryArgumentType.EXPRESSION);

		initEEnum(callOutMediatorEndpointTypeEEnum, CallOutMediatorEndpointType.class, "CallOutMediatorEndpointType");
		addEEnumLiteral(callOutMediatorEndpointTypeEEnum, CallOutMediatorEndpointType.ANONYMOUS);
		addEEnumLiteral(callOutMediatorEndpointTypeEEnum, CallOutMediatorEndpointType.REGISTRY_REFERENCE);

		// Create resource
		createResource(eNS_URI);
	}

} //MediatorsPackageImpl
