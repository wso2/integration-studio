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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage
 * @generated
 */
public class MediatorsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MediatorsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediatorsSwitch() {
		if (modelPackage == null) {
			modelPackage = MediatorsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MediatorsPackage.IN_MEDIATOR: {
				InMediator inMediator = (InMediator)theEObject;
				T result = caseInMediator(inMediator);
				if (result == null) result = caseParentMediator(inMediator);
				if (result == null) result = caseMediator(inMediator);
				if (result == null) result = caseConfigurationElement(inMediator);
				if (result == null) result = caseModelObject(inMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.OUT_MEDIATOR: {
				OutMediator outMediator = (OutMediator)theEObject;
				T result = caseOutMediator(outMediator);
				if (result == null) result = caseParentMediator(outMediator);
				if (result == null) result = caseMediator(outMediator);
				if (result == null) result = caseConfigurationElement(outMediator);
				if (result == null) result = caseModelObject(outMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.DROP_MEDIATOR: {
				DropMediator dropMediator = (DropMediator)theEObject;
				T result = caseDropMediator(dropMediator);
				if (result == null) result = caseMediator(dropMediator);
				if (result == null) result = caseConfigurationElement(dropMediator);
				if (result == null) result = caseModelObject(dropMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SEND_MEDIATOR: {
				SendMediator sendMediator = (SendMediator)theEObject;
				T result = caseSendMediator(sendMediator);
				if (result == null) result = caseMediator(sendMediator);
				if (result == null) result = caseConfigurationElement(sendMediator);
				if (result == null) result = caseModelObject(sendMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.LOG_MEDIATOR: {
				LogMediator logMediator = (LogMediator)theEObject;
				T result = caseLogMediator(logMediator);
				if (result == null) result = caseMediator(logMediator);
				if (result == null) result = caseConfigurationElement(logMediator);
				if (result == null) result = caseModelObject(logMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.LOG_PROPERTY: {
				LogProperty logProperty = (LogProperty)theEObject;
				T result = caseLogProperty(logProperty);
				if (result == null) result = caseAbstractNameValueExpressionProperty(logProperty);
				if (result == null) result = caseModelObject(logProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.FILTER_MEDIATOR: {
				FilterMediator filterMediator = (FilterMediator)theEObject;
				T result = caseFilterMediator(filterMediator);
				if (result == null) result = caseMediator(filterMediator);
				if (result == null) result = caseConfigurationElement(filterMediator);
				if (result == null) result = caseModelObject(filterMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.FILTER_THEN_BRANCH: {
				FilterThenBranch filterThenBranch = (FilterThenBranch)theEObject;
				T result = caseFilterThenBranch(filterThenBranch);
				if (result == null) result = caseMediatorBranch(filterThenBranch);
				if (result == null) result = caseModelObject(filterThenBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.FILTER_ELSE_BRANCH: {
				FilterElseBranch filterElseBranch = (FilterElseBranch)theEObject;
				T result = caseFilterElseBranch(filterElseBranch);
				if (result == null) result = caseMediatorBranch(filterElseBranch);
				if (result == null) result = caseModelObject(filterElseBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SWITCH_MEDIATOR: {
				SwitchMediator switchMediator = (SwitchMediator)theEObject;
				T result = caseSwitchMediator(switchMediator);
				if (result == null) result = caseMediator(switchMediator);
				if (result == null) result = caseConfigurationElement(switchMediator);
				if (result == null) result = caseModelObject(switchMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SWITCH_CASE_BRANCH: {
				SwitchCaseBranch switchCaseBranch = (SwitchCaseBranch)theEObject;
				T result = caseSwitchCaseBranch(switchCaseBranch);
				if (result == null) result = caseMediatorBranch(switchCaseBranch);
				if (result == null) result = caseModelObject(switchCaseBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SWITCH_DEFAULT_BRANCH: {
				SwitchDefaultBranch switchDefaultBranch = (SwitchDefaultBranch)theEObject;
				T result = caseSwitchDefaultBranch(switchDefaultBranch);
				if (result == null) result = caseMediatorBranch(switchDefaultBranch);
				if (result == null) result = caseModelObject(switchDefaultBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENTITLEMENT_MEDIATOR: {
				EntitlementMediator entitlementMediator = (EntitlementMediator)theEObject;
				T result = caseEntitlementMediator(entitlementMediator);
				if (result == null) result = caseMediator(entitlementMediator);
				if (result == null) result = caseConfigurationElement(entitlementMediator);
				if (result == null) result = caseModelObject(entitlementMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENTITLEMENT_ADVICE_BRANCH: {
				EntitlementAdviceBranch entitlementAdviceBranch = (EntitlementAdviceBranch)theEObject;
				T result = caseEntitlementAdviceBranch(entitlementAdviceBranch);
				if (result == null) result = caseMediatorBranch(entitlementAdviceBranch);
				if (result == null) result = caseModelObject(entitlementAdviceBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENTITLEMENT_OBLIGATIONS_BRANCH: {
				EntitlementObligationsBranch entitlementObligationsBranch = (EntitlementObligationsBranch)theEObject;
				T result = caseEntitlementObligationsBranch(entitlementObligationsBranch);
				if (result == null) result = caseMediatorBranch(entitlementObligationsBranch);
				if (result == null) result = caseModelObject(entitlementObligationsBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH: {
				EntitlementMediatorOnRejectBranch entitlementMediatorOnRejectBranch = (EntitlementMediatorOnRejectBranch)theEObject;
				T result = caseEntitlementMediatorOnRejectBranch(entitlementMediatorOnRejectBranch);
				if (result == null) result = caseMediatorBranch(entitlementMediatorOnRejectBranch);
				if (result == null) result = caseModelObject(entitlementMediatorOnRejectBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH: {
				EntitlementMediatorOnAcceptBranch entitlementMediatorOnAcceptBranch = (EntitlementMediatorOnAcceptBranch)theEObject;
				T result = caseEntitlementMediatorOnAcceptBranch(entitlementMediatorOnAcceptBranch);
				if (result == null) result = caseMediatorBranch(entitlementMediatorOnAcceptBranch);
				if (result == null) result = caseModelObject(entitlementMediatorOnAcceptBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENQUEUE_MEDIATOR: {
				EnqueueMediator enqueueMediator = (EnqueueMediator)theEObject;
				T result = caseEnqueueMediator(enqueueMediator);
				if (result == null) result = caseMediator(enqueueMediator);
				if (result == null) result = caseConfigurationElement(enqueueMediator);
				if (result == null) result = caseModelObject(enqueueMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CLASS_MEDIATOR: {
				ClassMediator classMediator = (ClassMediator)theEObject;
				T result = caseClassMediator(classMediator);
				if (result == null) result = caseMediator(classMediator);
				if (result == null) result = caseConfigurationElement(classMediator);
				if (result == null) result = caseModelObject(classMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CLASS_PROPERTY: {
				ClassProperty classProperty = (ClassProperty)theEObject;
				T result = caseClassProperty(classProperty);
				if (result == null) result = caseAbstractNameValueProperty(classProperty);
				if (result == null) result = caseModelObject(classProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SPRING_MEDIATOR: {
				SpringMediator springMediator = (SpringMediator)theEObject;
				T result = caseSpringMediator(springMediator);
				if (result == null) result = caseMediator(springMediator);
				if (result == null) result = caseConfigurationElement(springMediator);
				if (result == null) result = caseModelObject(springMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.VALIDATE_MEDIATOR: {
				ValidateMediator validateMediator = (ValidateMediator)theEObject;
				T result = caseValidateMediator(validateMediator);
				if (result == null) result = caseMediator(validateMediator);
				if (result == null) result = caseConfigurationElement(validateMediator);
				if (result == null) result = caseModelObject(validateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.VALIDATE_ON_FAIL_BRANCH: {
				ValidateOnFailBranch validateOnFailBranch = (ValidateOnFailBranch)theEObject;
				T result = caseValidateOnFailBranch(validateOnFailBranch);
				if (result == null) result = caseMediatorBranch(validateOnFailBranch);
				if (result == null) result = caseModelObject(validateOnFailBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.VALIDATE_FEATURE: {
				ValidateFeature validateFeature = (ValidateFeature)theEObject;
				T result = caseValidateFeature(validateFeature);
				if (result == null) result = caseAbstractBooleanFeature(validateFeature);
				if (result == null) result = caseModelObject(validateFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.VALIDATE_SCHEMA: {
				ValidateSchema validateSchema = (ValidateSchema)theEObject;
				T result = caseValidateSchema(validateSchema);
				if (result == null) result = caseModelObject(validateSchema);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.VALIDATE_RESOURCE: {
				ValidateResource validateResource = (ValidateResource)theEObject;
				T result = caseValidateResource(validateResource);
				if (result == null) result = caseAbstractLocationKeyResource(validateResource);
				if (result == null) result = caseModelObject(validateResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SCRIPT_MEDIATOR: {
				ScriptMediator scriptMediator = (ScriptMediator)theEObject;
				T result = caseScriptMediator(scriptMediator);
				if (result == null) result = caseMediator(scriptMediator);
				if (result == null) result = caseConfigurationElement(scriptMediator);
				if (result == null) result = caseModelObject(scriptMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ENRICH_MEDIATOR: {
				EnrichMediator enrichMediator = (EnrichMediator)theEObject;
				T result = caseEnrichMediator(enrichMediator);
				if (result == null) result = caseMediator(enrichMediator);
				if (result == null) result = caseConfigurationElement(enrichMediator);
				if (result == null) result = caseModelObject(enrichMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.FAULT_MEDIATOR: {
				FaultMediator faultMediator = (FaultMediator)theEObject;
				T result = caseFaultMediator(faultMediator);
				if (result == null) result = caseMediator(faultMediator);
				if (result == null) result = caseConfigurationElement(faultMediator);
				if (result == null) result = caseModelObject(faultMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.AGGREGATE_MEDIATOR: {
				AggregateMediator aggregateMediator = (AggregateMediator)theEObject;
				T result = caseAggregateMediator(aggregateMediator);
				if (result == null) result = caseMediator(aggregateMediator);
				if (result == null) result = caseConfigurationElement(aggregateMediator);
				if (result == null) result = caseModelObject(aggregateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.AGGREGATE_ON_COMPLETE_BRANCH: {
				AggregateOnCompleteBranch aggregateOnCompleteBranch = (AggregateOnCompleteBranch)theEObject;
				T result = caseAggregateOnCompleteBranch(aggregateOnCompleteBranch);
				if (result == null) result = caseMediatorBranch(aggregateOnCompleteBranch);
				if (result == null) result = caseModelObject(aggregateOnCompleteBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ROUTER_MEDIATOR: {
				RouterMediator routerMediator = (RouterMediator)theEObject;
				T result = caseRouterMediator(routerMediator);
				if (result == null) result = caseMediator(routerMediator);
				if (result == null) result = caseConfigurationElement(routerMediator);
				if (result == null) result = caseModelObject(routerMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ROUTER_ROUTE: {
				RouterRoute routerRoute = (RouterRoute)theEObject;
				T result = caseRouterRoute(routerRoute);
				if (result == null) result = caseModelObject(routerRoute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ROUTE_TARGET: {
				RouteTarget routeTarget = (RouteTarget)theEObject;
				T result = caseRouteTarget(routeTarget);
				if (result == null) result = caseAbstractCommonTarget(routeTarget);
				if (result == null) result = caseModelObject(routeTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CLONE_MEDIATOR: {
				CloneMediator cloneMediator = (CloneMediator)theEObject;
				T result = caseCloneMediator(cloneMediator);
				if (result == null) result = caseMediator(cloneMediator);
				if (result == null) result = caseConfigurationElement(cloneMediator);
				if (result == null) result = caseModelObject(cloneMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CLONE_TARGET: {
				CloneTarget cloneTarget = (CloneTarget)theEObject;
				T result = caseCloneTarget(cloneTarget);
				if (result == null) result = caseAbstractCommonTarget(cloneTarget);
				if (result == null) result = caseModelObject(cloneTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ITERATE_MEDIATOR: {
				IterateMediator iterateMediator = (IterateMediator)theEObject;
				T result = caseIterateMediator(iterateMediator);
				if (result == null) result = caseMediator(iterateMediator);
				if (result == null) result = caseConfigurationElement(iterateMediator);
				if (result == null) result = caseModelObject(iterateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ITERATE_TARGET: {
				IterateTarget iterateTarget = (IterateTarget)theEObject;
				T result = caseIterateTarget(iterateTarget);
				if (result == null) result = caseAbstractCommonTarget(iterateTarget);
				if (result == null) result = caseModelObject(iterateTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CACHE_MEDIATOR: {
				CacheMediator cacheMediator = (CacheMediator)theEObject;
				T result = caseCacheMediator(cacheMediator);
				if (result == null) result = caseMediator(cacheMediator);
				if (result == null) result = caseConfigurationElement(cacheMediator);
				if (result == null) result = caseModelObject(cacheMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CACHE_ON_HIT_BRANCH: {
				CacheOnHitBranch cacheOnHitBranch = (CacheOnHitBranch)theEObject;
				T result = caseCacheOnHitBranch(cacheOnHitBranch);
				if (result == null) result = caseMediatorBranch(cacheOnHitBranch);
				if (result == null) result = caseModelObject(cacheOnHitBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.XSLT_MEDIATOR: {
				XSLTMediator xsltMediator = (XSLTMediator)theEObject;
				T result = caseXSLTMediator(xsltMediator);
				if (result == null) result = caseMediator(xsltMediator);
				if (result == null) result = caseConfigurationElement(xsltMediator);
				if (result == null) result = caseModelObject(xsltMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.XSLT_PROPERTY: {
				XSLTProperty xsltProperty = (XSLTProperty)theEObject;
				T result = caseXSLTProperty(xsltProperty);
				if (result == null) result = caseAbstractNameValueExpressionProperty(xsltProperty);
				if (result == null) result = caseModelObject(xsltProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.XSLT_FEATURE: {
				XSLTFeature xsltFeature = (XSLTFeature)theEObject;
				T result = caseXSLTFeature(xsltFeature);
				if (result == null) result = caseAbstractBooleanFeature(xsltFeature);
				if (result == null) result = caseModelObject(xsltFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.XSLT_RESOURCE: {
				XSLTResource xsltResource = (XSLTResource)theEObject;
				T result = caseXSLTResource(xsltResource);
				if (result == null) result = caseAbstractLocationKeyResource(xsltResource);
				if (result == null) result = caseModelObject(xsltResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.XQUERY_MEDIATOR: {
				XQueryMediator xQueryMediator = (XQueryMediator)theEObject;
				T result = caseXQueryMediator(xQueryMediator);
				if (result == null) result = caseMediator(xQueryMediator);
				if (result == null) result = caseConfigurationElement(xQueryMediator);
				if (result == null) result = caseModelObject(xQueryMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.XQUERY_VARIABLE: {
				XQueryVariable xQueryVariable = (XQueryVariable)theEObject;
				T result = caseXQueryVariable(xQueryVariable);
				if (result == null) result = caseModelObject(xQueryVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CALLOUT_MEDIATOR: {
				CalloutMediator calloutMediator = (CalloutMediator)theEObject;
				T result = caseCalloutMediator(calloutMediator);
				if (result == null) result = caseMediator(calloutMediator);
				if (result == null) result = caseConfigurationElement(calloutMediator);
				if (result == null) result = caseModelObject(calloutMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RM_SEQUENCE_MEDIATOR: {
				RMSequenceMediator rmSequenceMediator = (RMSequenceMediator)theEObject;
				T result = caseRMSequenceMediator(rmSequenceMediator);
				if (result == null) result = caseMediator(rmSequenceMediator);
				if (result == null) result = caseConfigurationElement(rmSequenceMediator);
				if (result == null) result = caseModelObject(rmSequenceMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.TRANSACTION_MEDIATOR: {
				TransactionMediator transactionMediator = (TransactionMediator)theEObject;
				T result = caseTransactionMediator(transactionMediator);
				if (result == null) result = caseMediator(transactionMediator);
				if (result == null) result = caseConfigurationElement(transactionMediator);
				if (result == null) result = caseModelObject(transactionMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.PROPERTY_MEDIATOR: {
				PropertyMediator propertyMediator = (PropertyMediator)theEObject;
				T result = casePropertyMediator(propertyMediator);
				if (result == null) result = caseMediator(propertyMediator);
				if (result == null) result = caseConfigurationElement(propertyMediator);
				if (result == null) result = caseModelObject(propertyMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.OAUTH_MEDIATOR: {
				OAuthMediator oAuthMediator = (OAuthMediator)theEObject;
				T result = caseOAuthMediator(oAuthMediator);
				if (result == null) result = caseMediator(oAuthMediator);
				if (result == null) result = caseConfigurationElement(oAuthMediator);
				if (result == null) result = caseModelObject(oAuthMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.AUTOSCALE_IN_MEDIATOR: {
				AutoscaleInMediator autoscaleInMediator = (AutoscaleInMediator)theEObject;
				T result = caseAutoscaleInMediator(autoscaleInMediator);
				if (result == null) result = caseMediator(autoscaleInMediator);
				if (result == null) result = caseConfigurationElement(autoscaleInMediator);
				if (result == null) result = caseModelObject(autoscaleInMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.AUTOSCALE_OUT_MEDIATOR: {
				AutoscaleOutMediator autoscaleOutMediator = (AutoscaleOutMediator)theEObject;
				T result = caseAutoscaleOutMediator(autoscaleOutMediator);
				if (result == null) result = caseMediator(autoscaleOutMediator);
				if (result == null) result = caseConfigurationElement(autoscaleOutMediator);
				if (result == null) result = caseModelObject(autoscaleOutMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.HEADER_MEDIATOR: {
				HeaderMediator headerMediator = (HeaderMediator)theEObject;
				T result = caseHeaderMediator(headerMediator);
				if (result == null) result = caseMediator(headerMediator);
				if (result == null) result = caseConfigurationElement(headerMediator);
				if (result == null) result = caseModelObject(headerMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.THROTTLE_MEDIATOR: {
				ThrottleMediator throttleMediator = (ThrottleMediator)theEObject;
				T result = caseThrottleMediator(throttleMediator);
				if (result == null) result = caseMediator(throttleMediator);
				if (result == null) result = caseConfigurationElement(throttleMediator);
				if (result == null) result = caseModelObject(throttleMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.THROTTLE_POLICY_CONFIGURATION: {
				ThrottlePolicyConfiguration throttlePolicyConfiguration = (ThrottlePolicyConfiguration)theEObject;
				T result = caseThrottlePolicyConfiguration(throttlePolicyConfiguration);
				if (result == null) result = caseModelObject(throttlePolicyConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.THROTTLE_POLICY_ENTRY: {
				ThrottlePolicyEntry throttlePolicyEntry = (ThrottlePolicyEntry)theEObject;
				T result = caseThrottlePolicyEntry(throttlePolicyEntry);
				if (result == null) result = caseModelObject(throttlePolicyEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.THROTTLE_ON_ACCEPT_BRANCH: {
				ThrottleOnAcceptBranch throttleOnAcceptBranch = (ThrottleOnAcceptBranch)theEObject;
				T result = caseThrottleOnAcceptBranch(throttleOnAcceptBranch);
				if (result == null) result = caseMediatorBranch(throttleOnAcceptBranch);
				if (result == null) result = caseModelObject(throttleOnAcceptBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.THROTTLE_ON_REJECT_BRANCH: {
				ThrottleOnRejectBranch throttleOnRejectBranch = (ThrottleOnRejectBranch)theEObject;
				T result = caseThrottleOnRejectBranch(throttleOnRejectBranch);
				if (result == null) result = caseMediatorBranch(throttleOnRejectBranch);
				if (result == null) result = caseModelObject(throttleOnRejectBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.COMMAND_MEDIATOR: {
				CommandMediator commandMediator = (CommandMediator)theEObject;
				T result = caseCommandMediator(commandMediator);
				if (result == null) result = caseMediator(commandMediator);
				if (result == null) result = caseConfigurationElement(commandMediator);
				if (result == null) result = caseModelObject(commandMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.COMMAND_PROPERTY: {
				CommandProperty commandProperty = (CommandProperty)theEObject;
				T result = caseCommandProperty(commandProperty);
				if (result == null) result = caseModelObject(commandProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.EVENT_MEDIATOR: {
				EventMediator eventMediator = (EventMediator)theEObject;
				T result = caseEventMediator(eventMediator);
				if (result == null) result = caseMediator(eventMediator);
				if (result == null) result = caseConfigurationElement(eventMediator);
				if (result == null) result = caseModelObject(eventMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR: {
				AbstractSqlExecutorMediator abstractSqlExecutorMediator = (AbstractSqlExecutorMediator)theEObject;
				T result = caseAbstractSqlExecutorMediator(abstractSqlExecutorMediator);
				if (result == null) result = caseMediator(abstractSqlExecutorMediator);
				if (result == null) result = caseConfigurationElement(abstractSqlExecutorMediator);
				if (result == null) result = caseModelObject(abstractSqlExecutorMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SQL_STATEMENT: {
				SqlStatement sqlStatement = (SqlStatement)theEObject;
				T result = caseSqlStatement(sqlStatement);
				if (result == null) result = caseModelObject(sqlStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SQL_PARAMETER_DEFINITION: {
				SqlParameterDefinition sqlParameterDefinition = (SqlParameterDefinition)theEObject;
				T result = caseSqlParameterDefinition(sqlParameterDefinition);
				if (result == null) result = caseModelObject(sqlParameterDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SQL_RESULT_MAPPING: {
				SqlResultMapping sqlResultMapping = (SqlResultMapping)theEObject;
				T result = caseSqlResultMapping(sqlResultMapping);
				if (result == null) result = caseModelObject(sqlResultMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.DB_LOOKUP_MEDIATOR: {
				DBLookupMediator dbLookupMediator = (DBLookupMediator)theEObject;
				T result = caseDBLookupMediator(dbLookupMediator);
				if (result == null) result = caseAbstractSqlExecutorMediator(dbLookupMediator);
				if (result == null) result = caseMediator(dbLookupMediator);
				if (result == null) result = caseConfigurationElement(dbLookupMediator);
				if (result == null) result = caseModelObject(dbLookupMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.DB_REPORT_MEDIATOR: {
				DBReportMediator dbReportMediator = (DBReportMediator)theEObject;
				T result = caseDBReportMediator(dbReportMediator);
				if (result == null) result = caseAbstractSqlExecutorMediator(dbReportMediator);
				if (result == null) result = caseMediator(dbReportMediator);
				if (result == null) result = caseConfigurationElement(dbReportMediator);
				if (result == null) result = caseModelObject(dbReportMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_MEDIATOR: {
				RuleMediator ruleMediator = (RuleMediator)theEObject;
				T result = caseRuleMediator(ruleMediator);
				if (result == null) result = caseMediator(ruleMediator);
				if (result == null) result = caseConfigurationElement(ruleMediator);
				if (result == null) result = caseModelObject(ruleMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_SET_CONFIGURATION: {
				RuleSetConfiguration ruleSetConfiguration = (RuleSetConfiguration)theEObject;
				T result = caseRuleSetConfiguration(ruleSetConfiguration);
				if (result == null) result = caseModelObject(ruleSetConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_SET_CREATION_PROPERTY: {
				RuleSetCreationProperty ruleSetCreationProperty = (RuleSetCreationProperty)theEObject;
				T result = caseRuleSetCreationProperty(ruleSetCreationProperty);
				if (result == null) result = caseAbstractNameValueProperty(ruleSetCreationProperty);
				if (result == null) result = caseModelObject(ruleSetCreationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_SESSION_CONFIGURATION: {
				RuleSessionConfiguration ruleSessionConfiguration = (RuleSessionConfiguration)theEObject;
				T result = caseRuleSessionConfiguration(ruleSessionConfiguration);
				if (result == null) result = caseModelObject(ruleSessionConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_SESSION_PROPERTY: {
				RuleSessionProperty ruleSessionProperty = (RuleSessionProperty)theEObject;
				T result = caseRuleSessionProperty(ruleSessionProperty);
				if (result == null) result = caseAbstractNameValueProperty(ruleSessionProperty);
				if (result == null) result = caseModelObject(ruleSessionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_FACTS_CONFIGURATION: {
				RuleFactsConfiguration ruleFactsConfiguration = (RuleFactsConfiguration)theEObject;
				T result = caseRuleFactsConfiguration(ruleFactsConfiguration);
				if (result == null) result = caseModelObject(ruleFactsConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_FACT: {
				RuleFact ruleFact = (RuleFact)theEObject;
				T result = caseRuleFact(ruleFact);
				if (result == null) result = caseModelObject(ruleFact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_RESULTS_CONFIGURATION: {
				RuleResultsConfiguration ruleResultsConfiguration = (RuleResultsConfiguration)theEObject;
				T result = caseRuleResultsConfiguration(ruleResultsConfiguration);
				if (result == null) result = caseModelObject(ruleResultsConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_RESULT: {
				RuleResult ruleResult = (RuleResult)theEObject;
				T result = caseRuleResult(ruleResult);
				if (result == null) result = caseModelObject(ruleResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.RULE_CHILD_MEDIATORS_CONFIGURATION: {
				RuleChildMediatorsConfiguration ruleChildMediatorsConfiguration = (RuleChildMediatorsConfiguration)theEObject;
				T result = caseRuleChildMediatorsConfiguration(ruleChildMediatorsConfiguration);
				if (result == null) result = caseMediatorBranch(ruleChildMediatorsConfiguration);
				if (result == null) result = caseModelObject(ruleChildMediatorsConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SEQUENCE_MEDIATOR: {
				SequenceMediator sequenceMediator = (SequenceMediator)theEObject;
				T result = caseSequenceMediator(sequenceMediator);
				if (result == null) result = caseMediator(sequenceMediator);
				if (result == null) result = caseConfigurationElement(sequenceMediator);
				if (result == null) result = caseModelObject(sequenceMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.BUILDER_MEDIATOR: {
				BuilderMediator builderMediator = (BuilderMediator)theEObject;
				T result = caseBuilderMediator(builderMediator);
				if (result == null) result = caseMediator(builderMediator);
				if (result == null) result = caseConfigurationElement(builderMediator);
				if (result == null) result = caseModelObject(builderMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.MESSAGE_BUILDER: {
				MessageBuilder messageBuilder = (MessageBuilder)theEObject;
				T result = caseMessageBuilder(messageBuilder);
				if (result == null) result = caseModelObject(messageBuilder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SMOOKS_MEDIATOR: {
				SmooksMediator smooksMediator = (SmooksMediator)theEObject;
				T result = caseSmooksMediator(smooksMediator);
				if (result == null) result = caseMediator(smooksMediator);
				if (result == null) result = caseConfigurationElement(smooksMediator);
				if (result == null) result = caseModelObject(smooksMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SMOOKS_IN_CONFIGURATION: {
				SmooksInConfiguration smooksInConfiguration = (SmooksInConfiguration)theEObject;
				T result = caseSmooksInConfiguration(smooksInConfiguration);
				if (result == null) result = caseModelObject(smooksInConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.SMOOKS_OUT_CONFIGURATION: {
				SmooksOutConfiguration smooksOutConfiguration = (SmooksOutConfiguration)theEObject;
				T result = caseSmooksOutConfiguration(smooksOutConfiguration);
				if (result == null) result = caseModelObject(smooksOutConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.STORE_MEDIATOR: {
				StoreMediator storeMediator = (StoreMediator)theEObject;
				T result = caseStoreMediator(storeMediator);
				if (result == null) result = caseMediator(storeMediator);
				if (result == null) result = caseConfigurationElement(storeMediator);
				if (result == null) result = caseModelObject(storeMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH: {
				ConditionalRouteBranch conditionalRouteBranch = (ConditionalRouteBranch)theEObject;
				T result = caseConditionalRouteBranch(conditionalRouteBranch);
				if (result == null) result = caseMediatorBranch(conditionalRouteBranch);
				if (result == null) result = caseModelObject(conditionalRouteBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CONDITIONAL_ROUTER_MEDIATOR: {
				ConditionalRouterMediator conditionalRouterMediator = (ConditionalRouterMediator)theEObject;
				T result = caseConditionalRouterMediator(conditionalRouterMediator);
				if (result == null) result = caseMediator(conditionalRouterMediator);
				if (result == null) result = caseConfigurationElement(conditionalRouterMediator);
				if (result == null) result = caseModelObject(conditionalRouterMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.URL_REWRITE_RULE_ACTION: {
				URLRewriteRuleAction urlRewriteRuleAction = (URLRewriteRuleAction)theEObject;
				T result = caseURLRewriteRuleAction(urlRewriteRuleAction);
				if (result == null) result = caseModelObject(urlRewriteRuleAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.URL_REWRITE_RULE: {
				URLRewriteRule urlRewriteRule = (URLRewriteRule)theEObject;
				T result = caseURLRewriteRule(urlRewriteRule);
				if (result == null) result = caseModelObject(urlRewriteRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.URL_REWRITE_MEDIATOR: {
				URLRewriteMediator urlRewriteMediator = (URLRewriteMediator)theEObject;
				T result = caseURLRewriteMediator(urlRewriteMediator);
				if (result == null) result = caseMediator(urlRewriteMediator);
				if (result == null) result = caseConfigurationElement(urlRewriteMediator);
				if (result == null) result = caseModelObject(urlRewriteMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CALL_TEMPLATE_MEDIATOR: {
				CallTemplateMediator callTemplateMediator = (CallTemplateMediator)theEObject;
				T result = caseCallTemplateMediator(callTemplateMediator);
				if (result == null) result = caseMediator(callTemplateMediator);
				if (result == null) result = caseConfigurationElement(callTemplateMediator);
				if (result == null) result = caseModelObject(callTemplateMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.CALL_TEMPLATE_PARAMETER: {
				CallTemplateParameter callTemplateParameter = (CallTemplateParameter)theEObject;
				T result = caseCallTemplateParameter(callTemplateParameter);
				if (result == null) result = caseModelObject(callTemplateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.PAYLOAD_FACTORY_MEDIATOR: {
				PayloadFactoryMediator payloadFactoryMediator = (PayloadFactoryMediator)theEObject;
				T result = casePayloadFactoryMediator(payloadFactoryMediator);
				if (result == null) result = caseMediator(payloadFactoryMediator);
				if (result == null) result = caseConfigurationElement(payloadFactoryMediator);
				if (result == null) result = caseModelObject(payloadFactoryMediator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MediatorsPackage.PAYLOAD_FACTORY_ARGUMENT: {
				PayloadFactoryArgument payloadFactoryArgument = (PayloadFactoryArgument)theEObject;
				T result = casePayloadFactoryArgument(payloadFactoryArgument);
				if (result == null) result = caseModelObject(payloadFactoryArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInMediator(InMediator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutMediator(OutMediator object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Filter Then Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Then Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterThenBranch(FilterThenBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Else Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Else Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterElseBranch(FilterElseBranch object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCaseBranch(SwitchCaseBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Default Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Default Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchDefaultBranch(SwitchDefaultBranch object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Advice Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Advice Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementAdviceBranch(EntitlementAdviceBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Obligations Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Obligations Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementObligationsBranch(EntitlementObligationsBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator On Reject Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator On Reject Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorOnRejectBranch(EntitlementMediatorOnRejectBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement Mediator On Accept Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement Mediator On Accept Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntitlementMediatorOnAcceptBranch(EntitlementMediatorOnAcceptBranch object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Validate On Fail Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate On Fail Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidateOnFailBranch(ValidateOnFailBranch object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Aggregate On Complete Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregate On Complete Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregateOnCompleteBranch(AggregateOnCompleteBranch object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Route Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Route Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRouteTarget(RouteTarget object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Rule Set Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Set Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleSetConfiguration(RuleSetConfiguration object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Rule Session Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Session Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleSessionConfiguration(RuleSessionConfiguration object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceMediator(SequenceMediator object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Smooks In Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smooks In Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmooksInConfiguration(SmooksInConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Smooks Out Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Smooks Out Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmooksOutConfiguration(SmooksOutConfiguration object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelObject(ModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationElement(ConfigurationElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Parent Mediator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent Mediator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParentMediator(ParentMediator object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mediator Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mediator Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediatorBranch(MediatorBranch object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //MediatorsSwitch
