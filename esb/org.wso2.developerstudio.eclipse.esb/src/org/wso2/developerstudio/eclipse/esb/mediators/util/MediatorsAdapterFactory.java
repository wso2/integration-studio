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
package org.wso2.developerstudio.eclipse.esb.mediators.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.esb.AbstractBooleanFeature;
import org.wso2.developerstudio.eclipse.esb.AbstractCommonTarget;
import org.wso2.developerstudio.eclipse.esb.AbstractLocationKeyResource;
import org.wso2.developerstudio.eclipse.esb.AbstractNameValueExpressionProperty;
import org.wso2.developerstudio.eclipse.esb.AbstractNameValueProperty;
import org.wso2.developerstudio.eclipse.esb.ConfigurationElement;
import org.wso2.developerstudio.eclipse.esb.Mediator;
import org.wso2.developerstudio.eclipse.esb.MediatorBranch;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.ParentMediator;
import org.wso2.developerstudio.eclipse.esb.mediators.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage
 * @generated
 */
public class MediatorsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MediatorsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MediatorsPackage.eINSTANCE;
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
	protected MediatorsSwitch<Adapter> modelSwitch =
		new MediatorsSwitch<Adapter>() {
			@Override
			public Adapter caseInMediator(InMediator object) {
				return createInMediatorAdapter();
			}
			@Override
			public Adapter caseOutMediator(OutMediator object) {
				return createOutMediatorAdapter();
			}
			@Override
			public Adapter caseDropMediator(DropMediator object) {
				return createDropMediatorAdapter();
			}
			@Override
			public Adapter caseSendMediator(SendMediator object) {
				return createSendMediatorAdapter();
			}
			@Override
			public Adapter caseLogMediator(LogMediator object) {
				return createLogMediatorAdapter();
			}
			@Override
			public Adapter caseLogProperty(LogProperty object) {
				return createLogPropertyAdapter();
			}
			@Override
			public Adapter caseFilterMediator(FilterMediator object) {
				return createFilterMediatorAdapter();
			}
			@Override
			public Adapter caseFilterThenBranch(FilterThenBranch object) {
				return createFilterThenBranchAdapter();
			}
			@Override
			public Adapter caseFilterElseBranch(FilterElseBranch object) {
				return createFilterElseBranchAdapter();
			}
			@Override
			public Adapter caseSwitchMediator(SwitchMediator object) {
				return createSwitchMediatorAdapter();
			}
			@Override
			public Adapter caseSwitchCaseBranch(SwitchCaseBranch object) {
				return createSwitchCaseBranchAdapter();
			}
			@Override
			public Adapter caseSwitchDefaultBranch(SwitchDefaultBranch object) {
				return createSwitchDefaultBranchAdapter();
			}
			@Override
			public Adapter caseEntitlementMediator(EntitlementMediator object) {
				return createEntitlementMediatorAdapter();
			}
			@Override
			public Adapter caseEntitlementAdviceBranch(EntitlementAdviceBranch object) {
				return createEntitlementAdviceBranchAdapter();
			}
			@Override
			public Adapter caseEntitlementObligationsBranch(EntitlementObligationsBranch object) {
				return createEntitlementObligationsBranchAdapter();
			}
			@Override
			public Adapter caseEntitlementMediatorOnRejectBranch(EntitlementMediatorOnRejectBranch object) {
				return createEntitlementMediatorOnRejectBranchAdapter();
			}
			@Override
			public Adapter caseEntitlementMediatorOnAcceptBranch(EntitlementMediatorOnAcceptBranch object) {
				return createEntitlementMediatorOnAcceptBranchAdapter();
			}
			@Override
			public Adapter caseEnqueueMediator(EnqueueMediator object) {
				return createEnqueueMediatorAdapter();
			}
			@Override
			public Adapter caseClassMediator(ClassMediator object) {
				return createClassMediatorAdapter();
			}
			@Override
			public Adapter caseClassProperty(ClassProperty object) {
				return createClassPropertyAdapter();
			}
			@Override
			public Adapter caseSpringMediator(SpringMediator object) {
				return createSpringMediatorAdapter();
			}
			@Override
			public Adapter caseValidateMediator(ValidateMediator object) {
				return createValidateMediatorAdapter();
			}
			@Override
			public Adapter caseValidateOnFailBranch(ValidateOnFailBranch object) {
				return createValidateOnFailBranchAdapter();
			}
			@Override
			public Adapter caseValidateFeature(ValidateFeature object) {
				return createValidateFeatureAdapter();
			}
			@Override
			public Adapter caseValidateSchema(ValidateSchema object) {
				return createValidateSchemaAdapter();
			}
			@Override
			public Adapter caseValidateResource(ValidateResource object) {
				return createValidateResourceAdapter();
			}
			@Override
			public Adapter caseScriptMediator(ScriptMediator object) {
				return createScriptMediatorAdapter();
			}
			@Override
			public Adapter caseEnrichMediator(EnrichMediator object) {
				return createEnrichMediatorAdapter();
			}
			@Override
			public Adapter caseFaultMediator(FaultMediator object) {
				return createFaultMediatorAdapter();
			}
			@Override
			public Adapter caseAggregateMediator(AggregateMediator object) {
				return createAggregateMediatorAdapter();
			}
			@Override
			public Adapter caseAggregateOnCompleteBranch(AggregateOnCompleteBranch object) {
				return createAggregateOnCompleteBranchAdapter();
			}
			@Override
			public Adapter caseRouterMediator(RouterMediator object) {
				return createRouterMediatorAdapter();
			}
			@Override
			public Adapter caseRouterRoute(RouterRoute object) {
				return createRouterRouteAdapter();
			}
			@Override
			public Adapter caseRouteTarget(RouteTarget object) {
				return createRouteTargetAdapter();
			}
			@Override
			public Adapter caseCloneMediator(CloneMediator object) {
				return createCloneMediatorAdapter();
			}
			@Override
			public Adapter caseCloneTarget(CloneTarget object) {
				return createCloneTargetAdapter();
			}
			@Override
			public Adapter caseIterateMediator(IterateMediator object) {
				return createIterateMediatorAdapter();
			}
			@Override
			public Adapter caseIterateTarget(IterateTarget object) {
				return createIterateTargetAdapter();
			}
			@Override
			public Adapter caseCacheMediator(CacheMediator object) {
				return createCacheMediatorAdapter();
			}
			@Override
			public Adapter caseCacheOnHitBranch(CacheOnHitBranch object) {
				return createCacheOnHitBranchAdapter();
			}
			@Override
			public Adapter caseXSLTMediator(XSLTMediator object) {
				return createXSLTMediatorAdapter();
			}
			@Override
			public Adapter caseXSLTProperty(XSLTProperty object) {
				return createXSLTPropertyAdapter();
			}
			@Override
			public Adapter caseXSLTFeature(XSLTFeature object) {
				return createXSLTFeatureAdapter();
			}
			@Override
			public Adapter caseXSLTResource(XSLTResource object) {
				return createXSLTResourceAdapter();
			}
			@Override
			public Adapter caseXQueryMediator(XQueryMediator object) {
				return createXQueryMediatorAdapter();
			}
			@Override
			public Adapter caseXQueryVariable(XQueryVariable object) {
				return createXQueryVariableAdapter();
			}
			@Override
			public Adapter caseCalloutMediator(CalloutMediator object) {
				return createCalloutMediatorAdapter();
			}
			@Override
			public Adapter caseRMSequenceMediator(RMSequenceMediator object) {
				return createRMSequenceMediatorAdapter();
			}
			@Override
			public Adapter caseTransactionMediator(TransactionMediator object) {
				return createTransactionMediatorAdapter();
			}
			@Override
			public Adapter casePropertyMediator(PropertyMediator object) {
				return createPropertyMediatorAdapter();
			}
			@Override
			public Adapter caseOAuthMediator(OAuthMediator object) {
				return createOAuthMediatorAdapter();
			}
			@Override
			public Adapter caseAutoscaleInMediator(AutoscaleInMediator object) {
				return createAutoscaleInMediatorAdapter();
			}
			@Override
			public Adapter caseAutoscaleOutMediator(AutoscaleOutMediator object) {
				return createAutoscaleOutMediatorAdapter();
			}
			@Override
			public Adapter caseHeaderMediator(HeaderMediator object) {
				return createHeaderMediatorAdapter();
			}
			@Override
			public Adapter caseThrottleMediator(ThrottleMediator object) {
				return createThrottleMediatorAdapter();
			}
			@Override
			public Adapter caseThrottlePolicyConfiguration(ThrottlePolicyConfiguration object) {
				return createThrottlePolicyConfigurationAdapter();
			}
			@Override
			public Adapter caseThrottlePolicyEntry(ThrottlePolicyEntry object) {
				return createThrottlePolicyEntryAdapter();
			}
			@Override
			public Adapter caseThrottleOnAcceptBranch(ThrottleOnAcceptBranch object) {
				return createThrottleOnAcceptBranchAdapter();
			}
			@Override
			public Adapter caseThrottleOnRejectBranch(ThrottleOnRejectBranch object) {
				return createThrottleOnRejectBranchAdapter();
			}
			@Override
			public Adapter caseCommandMediator(CommandMediator object) {
				return createCommandMediatorAdapter();
			}
			@Override
			public Adapter caseCommandProperty(CommandProperty object) {
				return createCommandPropertyAdapter();
			}
			@Override
			public Adapter caseEventMediator(EventMediator object) {
				return createEventMediatorAdapter();
			}
			@Override
			public Adapter caseAbstractSqlExecutorMediator(AbstractSqlExecutorMediator object) {
				return createAbstractSqlExecutorMediatorAdapter();
			}
			@Override
			public Adapter caseSqlStatement(SqlStatement object) {
				return createSqlStatementAdapter();
			}
			@Override
			public Adapter caseSqlParameterDefinition(SqlParameterDefinition object) {
				return createSqlParameterDefinitionAdapter();
			}
			@Override
			public Adapter caseSqlResultMapping(SqlResultMapping object) {
				return createSqlResultMappingAdapter();
			}
			@Override
			public Adapter caseDBLookupMediator(DBLookupMediator object) {
				return createDBLookupMediatorAdapter();
			}
			@Override
			public Adapter caseDBReportMediator(DBReportMediator object) {
				return createDBReportMediatorAdapter();
			}
			@Override
			public Adapter caseRuleMediator(RuleMediator object) {
				return createRuleMediatorAdapter();
			}
			@Override
			public Adapter caseRuleSetConfiguration(RuleSetConfiguration object) {
				return createRuleSetConfigurationAdapter();
			}
			@Override
			public Adapter caseRuleSetCreationProperty(RuleSetCreationProperty object) {
				return createRuleSetCreationPropertyAdapter();
			}
			@Override
			public Adapter caseRuleSessionConfiguration(RuleSessionConfiguration object) {
				return createRuleSessionConfigurationAdapter();
			}
			@Override
			public Adapter caseRuleSessionProperty(RuleSessionProperty object) {
				return createRuleSessionPropertyAdapter();
			}
			@Override
			public Adapter caseRuleFactsConfiguration(RuleFactsConfiguration object) {
				return createRuleFactsConfigurationAdapter();
			}
			@Override
			public Adapter caseRuleFact(RuleFact object) {
				return createRuleFactAdapter();
			}
			@Override
			public Adapter caseRuleResultsConfiguration(RuleResultsConfiguration object) {
				return createRuleResultsConfigurationAdapter();
			}
			@Override
			public Adapter caseRuleResult(RuleResult object) {
				return createRuleResultAdapter();
			}
			@Override
			public Adapter caseRuleChildMediatorsConfiguration(RuleChildMediatorsConfiguration object) {
				return createRuleChildMediatorsConfigurationAdapter();
			}
			@Override
			public Adapter caseSequenceMediator(SequenceMediator object) {
				return createSequenceMediatorAdapter();
			}
			@Override
			public Adapter caseBuilderMediator(BuilderMediator object) {
				return createBuilderMediatorAdapter();
			}
			@Override
			public Adapter caseMessageBuilder(MessageBuilder object) {
				return createMessageBuilderAdapter();
			}
			@Override
			public Adapter caseSmooksMediator(SmooksMediator object) {
				return createSmooksMediatorAdapter();
			}
			@Override
			public Adapter caseSmooksInConfiguration(SmooksInConfiguration object) {
				return createSmooksInConfigurationAdapter();
			}
			@Override
			public Adapter caseSmooksOutConfiguration(SmooksOutConfiguration object) {
				return createSmooksOutConfigurationAdapter();
			}
			@Override
			public Adapter caseStoreMediator(StoreMediator object) {
				return createStoreMediatorAdapter();
			}
			@Override
			public Adapter caseConditionalRouteBranch(ConditionalRouteBranch object) {
				return createConditionalRouteBranchAdapter();
			}
			@Override
			public Adapter caseConditionalRouterMediator(ConditionalRouterMediator object) {
				return createConditionalRouterMediatorAdapter();
			}
			@Override
			public Adapter caseURLRewriteRuleAction(URLRewriteRuleAction object) {
				return createURLRewriteRuleActionAdapter();
			}
			@Override
			public Adapter caseURLRewriteRule(URLRewriteRule object) {
				return createURLRewriteRuleAdapter();
			}
			@Override
			public Adapter caseURLRewriteMediator(URLRewriteMediator object) {
				return createURLRewriteMediatorAdapter();
			}
			@Override
			public Adapter caseCallTemplateMediator(CallTemplateMediator object) {
				return createCallTemplateMediatorAdapter();
			}
			@Override
			public Adapter caseCallTemplateParameter(CallTemplateParameter object) {
				return createCallTemplateParameterAdapter();
			}
			@Override
			public Adapter casePayloadFactoryMediator(PayloadFactoryMediator object) {
				return createPayloadFactoryMediatorAdapter();
			}
			@Override
			public Adapter casePayloadFactoryArgument(PayloadFactoryArgument object) {
				return createPayloadFactoryArgumentAdapter();
			}
			@Override
			public Adapter caseModelObject(ModelObject object) {
				return createModelObjectAdapter();
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
			public Adapter caseParentMediator(ParentMediator object) {
				return createParentMediatorAdapter();
			}
			@Override
			public Adapter caseAbstractNameValueExpressionProperty(AbstractNameValueExpressionProperty object) {
				return createAbstractNameValueExpressionPropertyAdapter();
			}
			@Override
			public Adapter caseMediatorBranch(MediatorBranch object) {
				return createMediatorBranchAdapter();
			}
			@Override
			public Adapter caseAbstractNameValueProperty(AbstractNameValueProperty object) {
				return createAbstractNameValuePropertyAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.InMediator <em>In Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.InMediator
	 * @generated
	 */
	public Adapter createInMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.OutMediator <em>Out Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutMediator
	 * @generated
	 */
	public Adapter createOutMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.DropMediator <em>Drop Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DropMediator
	 * @generated
	 */
	public Adapter createDropMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator <em>Send Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator
	 * @generated
	 */
	public Adapter createSendMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator <em>Log Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogMediator
	 * @generated
	 */
	public Adapter createLogMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogProperty <em>Log Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogProperty
	 * @generated
	 */
	public Adapter createLogPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator <em>Filter Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator
	 * @generated
	 */
	public Adapter createFilterMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterThenBranch <em>Filter Then Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterThenBranch
	 * @generated
	 */
	public Adapter createFilterThenBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterElseBranch <em>Filter Else Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterElseBranch
	 * @generated
	 */
	public Adapter createFilterElseBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator <em>Switch Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator
	 * @generated
	 */
	public Adapter createSwitchMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch <em>Switch Case Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch
	 * @generated
	 */
	public Adapter createSwitchCaseBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchDefaultBranch <em>Switch Default Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchDefaultBranch
	 * @generated
	 */
	public Adapter createSwitchDefaultBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator <em>Entitlement Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator
	 * @generated
	 */
	public Adapter createEntitlementMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch <em>Entitlement Advice Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch
	 * @generated
	 */
	public Adapter createEntitlementAdviceBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch <em>Entitlement Obligations Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch
	 * @generated
	 */
	public Adapter createEntitlementObligationsBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch <em>Entitlement Mediator On Reject Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch
	 * @generated
	 */
	public Adapter createEntitlementMediatorOnRejectBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch <em>Entitlement Mediator On Accept Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch
	 * @generated
	 */
	public Adapter createEntitlementMediatorOnAcceptBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator <em>Enqueue Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator
	 * @generated
	 */
	public Adapter createEnqueueMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator <em>Class Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator
	 * @generated
	 */
	public Adapter createClassMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ClassProperty <em>Class Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ClassProperty
	 * @generated
	 */
	public Adapter createClassPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator <em>Spring Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator
	 * @generated
	 */
	public Adapter createSpringMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator <em>Validate Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator
	 * @generated
	 */
	public Adapter createValidateMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateOnFailBranch <em>Validate On Fail Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateOnFailBranch
	 * @generated
	 */
	public Adapter createValidateOnFailBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature <em>Validate Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature
	 * @generated
	 */
	public Adapter createValidateFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema <em>Validate Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema
	 * @generated
	 */
	public Adapter createValidateSchemaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource <em>Validate Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource
	 * @generated
	 */
	public Adapter createValidateResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator <em>Script Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator
	 * @generated
	 */
	public Adapter createScriptMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator <em>Enrich Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator
	 * @generated
	 */
	public Adapter createEnrichMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator <em>Fault Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator
	 * @generated
	 */
	public Adapter createFaultMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator <em>Aggregate Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator
	 * @generated
	 */
	public Adapter createAggregateMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch <em>Aggregate On Complete Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch
	 * @generated
	 */
	public Adapter createAggregateOnCompleteBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator <em>Router Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator
	 * @generated
	 */
	public Adapter createRouterMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute <em>Router Route</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute
	 * @generated
	 */
	public Adapter createRouterRouteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouteTarget <em>Route Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouteTarget
	 * @generated
	 */
	public Adapter createRouteTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator <em>Clone Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator
	 * @generated
	 */
	public Adapter createCloneMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget <em>Clone Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget
	 * @generated
	 */
	public Adapter createCloneTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator <em>Iterate Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator
	 * @generated
	 */
	public Adapter createIterateMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget <em>Iterate Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget
	 * @generated
	 */
	public Adapter createIterateTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator <em>Cache Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator
	 * @generated
	 */
	public Adapter createCacheMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch <em>Cache On Hit Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch
	 * @generated
	 */
	public Adapter createCacheOnHitBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator <em>XSLT Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator
	 * @generated
	 */
	public Adapter createXSLTMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty <em>XSLT Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty
	 * @generated
	 */
	public Adapter createXSLTPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature <em>XSLT Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature
	 * @generated
	 */
	public Adapter createXSLTFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource <em>XSLT Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource
	 * @generated
	 */
	public Adapter createXSLTResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator <em>XQuery Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator
	 * @generated
	 */
	public Adapter createXQueryMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable <em>XQuery Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable
	 * @generated
	 */
	public Adapter createXQueryVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator <em>Callout Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator
	 * @generated
	 */
	public Adapter createCalloutMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator <em>RM Sequence Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator
	 * @generated
	 */
	public Adapter createRMSequenceMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator <em>Transaction Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator
	 * @generated
	 */
	public Adapter createTransactionMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator <em>Property Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator
	 * @generated
	 */
	public Adapter createPropertyMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator <em>OAuth Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator
	 * @generated
	 */
	public Adapter createOAuthMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleInMediator <em>Autoscale In Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleInMediator
	 * @generated
	 */
	public Adapter createAutoscaleInMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleOutMediator <em>Autoscale Out Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleOutMediator
	 * @generated
	 */
	public Adapter createAutoscaleOutMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator <em>Header Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator
	 * @generated
	 */
	public Adapter createHeaderMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator <em>Throttle Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator
	 * @generated
	 */
	public Adapter createThrottleMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration <em>Throttle Policy Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration
	 * @generated
	 */
	public Adapter createThrottlePolicyConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry <em>Throttle Policy Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry
	 * @generated
	 */
	public Adapter createThrottlePolicyEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch <em>Throttle On Accept Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch
	 * @generated
	 */
	public Adapter createThrottleOnAcceptBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch <em>Throttle On Reject Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch
	 * @generated
	 */
	public Adapter createThrottleOnRejectBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator <em>Command Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator
	 * @generated
	 */
	public Adapter createCommandMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty <em>Command Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty
	 * @generated
	 */
	public Adapter createCommandPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator <em>Event Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator
	 * @generated
	 */
	public Adapter createEventMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator <em>Abstract Sql Executor Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator
	 * @generated
	 */
	public Adapter createAbstractSqlExecutorMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement <em>Sql Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement
	 * @generated
	 */
	public Adapter createSqlStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition <em>Sql Parameter Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition
	 * @generated
	 */
	public Adapter createSqlParameterDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping <em>Sql Result Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping
	 * @generated
	 */
	public Adapter createSqlResultMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.DBLookupMediator <em>DB Lookup Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DBLookupMediator
	 * @generated
	 */
	public Adapter createDBLookupMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator <em>DB Report Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator
	 * @generated
	 */
	public Adapter createDBReportMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator <em>Rule Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator
	 * @generated
	 */
	public Adapter createRuleMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration <em>Rule Set Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration
	 * @generated
	 */
	public Adapter createRuleSetConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetCreationProperty <em>Rule Set Creation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetCreationProperty
	 * @generated
	 */
	public Adapter createRuleSetCreationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration <em>Rule Session Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration
	 * @generated
	 */
	public Adapter createRuleSessionConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionProperty <em>Rule Session Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionProperty
	 * @generated
	 */
	public Adapter createRuleSessionPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration <em>Rule Facts Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration
	 * @generated
	 */
	public Adapter createRuleFactsConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact <em>Rule Fact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact
	 * @generated
	 */
	public Adapter createRuleFactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration <em>Rule Results Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration
	 * @generated
	 */
	public Adapter createRuleResultsConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult <em>Rule Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult
	 * @generated
	 */
	public Adapter createRuleResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleChildMediatorsConfiguration <em>Rule Child Mediators Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleChildMediatorsConfiguration
	 * @generated
	 */
	public Adapter createRuleChildMediatorsConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator <em>Sequence Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator
	 * @generated
	 */
	public Adapter createSequenceMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator <em>Builder Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator
	 * @generated
	 */
	public Adapter createBuilderMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder <em>Message Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder
	 * @generated
	 */
	public Adapter createMessageBuilderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator <em>Smooks Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator
	 * @generated
	 */
	public Adapter createSmooksMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration <em>Smooks In Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration
	 * @generated
	 */
	public Adapter createSmooksInConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration <em>Smooks Out Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration
	 * @generated
	 */
	public Adapter createSmooksOutConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator <em>Store Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator
	 * @generated
	 */
	public Adapter createStoreMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch <em>Conditional Route Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch
	 * @generated
	 */
	public Adapter createConditionalRouteBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator <em>Conditional Router Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator
	 * @generated
	 */
	public Adapter createConditionalRouterMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction <em>URL Rewrite Rule Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction
	 * @generated
	 */
	public Adapter createURLRewriteRuleActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule <em>URL Rewrite Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule
	 * @generated
	 */
	public Adapter createURLRewriteRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator <em>URL Rewrite Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator
	 * @generated
	 */
	public Adapter createURLRewriteMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator <em>Call Template Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator
	 * @generated
	 */
	public Adapter createCallTemplateMediatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter <em>Call Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter
	 * @generated
	 */
	public Adapter createCallTemplateParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator <em>Payload Factory Mediator</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator
	 * @generated
	 */
    public Adapter createPayloadFactoryMediatorAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument <em>Payload Factory Argument</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument
	 * @generated
	 */
    public Adapter createPayloadFactoryArgumentAdapter() {
		return null;
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

} //MediatorsAdapterFactory
