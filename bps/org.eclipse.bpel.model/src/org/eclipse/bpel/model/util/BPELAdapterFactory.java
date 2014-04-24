/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: BPELAdapterFactory.java,v 1.24 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.util;

import javax.wsdl.extensions.AttributeExtensible;
import javax.wsdl.extensions.ElementExtensible;
import javax.wsdl.extensions.ExtensibilityElement;

import org.eclipse.bpel.model.AbstractAssignBound;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.BooleanExpression;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.Compensate;
import org.eclipse.bpel.model.CompensateScope;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.Condition;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Documentation;
import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.Empty;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Exit;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.FaultOnFailure;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.OpaqueActivity;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.Rethrow;
import org.eclipse.bpel.model.RetryDelay;
import org.eclipse.bpel.model.RetryFor;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.model.Snippet;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Throw;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.UnknownExtensibilityAttribute;
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.Wait;
import org.eclipse.bpel.model.While;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.ExtensibleElement;
import org.eclipse.wst.wsdl.UnknownExtensibilityElement;
import org.eclipse.wst.wsdl.WSDLElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.model.BPELPackage
 * @generated
 */
public class BPELAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BPELPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPELAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BPELPackage.eINSTANCE;
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
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPELSwitch<Adapter> modelSwitch = new BPELSwitch<Adapter>() {
		@Override
		public Adapter caseProcess(org.eclipse.bpel.model.Process object) {
			return createProcessAdapter();
		}

		@Override
		public Adapter casePartnerLink(PartnerLink object) {
			return createPartnerLinkAdapter();
		}

		@Override
		public Adapter caseFaultHandler(FaultHandler object) {
			return createFaultHandlerAdapter();
		}

		@Override
		public Adapter caseActivity(Activity object) {
			return createActivityAdapter();
		}

		@Override
		public Adapter caseCorrelationSet(CorrelationSet object) {
			return createCorrelationSetAdapter();
		}

		@Override
		public Adapter caseInvoke(Invoke object) {
			return createInvokeAdapter();
		}

		@Override
		public Adapter caseLink(Link object) {
			return createLinkAdapter();
		}

		@Override
		public Adapter caseCatch(Catch object) {
			return createCatchAdapter();
		}

		@Override
		public Adapter caseReply(Reply object) {
			return createReplyAdapter();
		}

		@Override
		public Adapter casePartnerActivity(PartnerActivity object) {
			return createPartnerActivityAdapter();
		}

		@Override
		public Adapter caseReceive(Receive object) {
			return createReceiveAdapter();
		}

		@Override
		public Adapter caseExit(Exit object) {
			return createExitAdapter();
		}

		@Override
		public Adapter caseThrow(Throw object) {
			return createThrowAdapter();
		}

		@Override
		public Adapter caseWait(Wait object) {
			return createWaitAdapter();
		}

		@Override
		public Adapter caseEmpty(Empty object) {
			return createEmptyAdapter();
		}

		@Override
		public Adapter caseSequence(Sequence object) {
			return createSequenceAdapter();
		}

		@Override
		public Adapter caseWhile(While object) {
			return createWhileAdapter();
		}

		@Override
		public Adapter casePick(Pick object) {
			return createPickAdapter();
		}

		@Override
		public Adapter caseFlow(Flow object) {
			return createFlowAdapter();
		}

		@Override
		public Adapter caseOnAlarm(OnAlarm object) {
			return createOnAlarmAdapter();
		}

		@Override
		public Adapter caseAssignE4X(AssignE4X object) {
			return createAssignE4XAdapter();
		}

		@Override
		public Adapter caseExtensionAssignOperation(
				ExtensionAssignOperation object) {
			return createExtensionAssignOperationAdapter();
		}

		@Override
		public Adapter caseSnippet(Snippet object) {
			return createSnippetAdapter();
		}

		@Override
		public Adapter caseAssign(Assign object) {
			return createAssignAdapter();
		}

		@Override
		public Adapter caseCopy(Copy object) {
			return createCopyAdapter();
		}

		@Override
		public Adapter caseExtension(Extension object) {
			return createExtensionAdapter();
		}

		@Override
		public Adapter caseScope(Scope object) {
			return createScopeAdapter();
		}

		@Override
		public Adapter caseCompensateScope(CompensateScope object) {
			return createCompensateScopeAdapter();
		}

		@Override
		public Adapter caseCompensationHandler(CompensationHandler object) {
			return createCompensationHandlerAdapter();
		}

		@Override
		public Adapter caseAbstractAssignBound(AbstractAssignBound object) {
			return createAbstractAssignBoundAdapter();
		}

		@Override
		public Adapter caseTo(To object) {
			return createToAdapter();
		}

		@Override
		public Adapter caseFrom(From object) {
			return createFromAdapter();
		}

		@Override
		public Adapter caseOnMessage(OnMessage object) {
			return createOnMessageAdapter();
		}

		@Override
		public Adapter caseExpression(Expression object) {
			return createExpressionAdapter();
		}

		@Override
		public Adapter caseBooleanExpression(BooleanExpression object) {
			return createBooleanExpressionAdapter();
		}

		@Override
		public Adapter caseCorrelation(Correlation object) {
			return createCorrelationAdapter();
		}

		@Override
		public Adapter caseMessageExchange(MessageExchange object) {
			return createMessageExchangeAdapter();
		}

		@Override
		public Adapter caseEventHandler(EventHandler object) {
			return createEventHandlerAdapter();
		}

		@Override
		public Adapter caseSource(Source object) {
			return createSourceAdapter();
		}

		@Override
		public Adapter caseTarget(Target object) {
			return createTargetAdapter();
		}

		@Override
		public Adapter casePartnerLinks(PartnerLinks object) {
			return createPartnerLinksAdapter();
		}

		@Override
		public Adapter caseMessageExchanges(MessageExchanges object) {
			return createMessageExchangesAdapter();
		}

		@Override
		public Adapter caseVariables(Variables object) {
			return createVariablesAdapter();
		}

		@Override
		public Adapter caseCorrelationSets(CorrelationSets object) {
			return createCorrelationSetsAdapter();
		}

		@Override
		public Adapter caseLinks(Links object) {
			return createLinksAdapter();
		}

		@Override
		public Adapter caseCatchAll(CatchAll object) {
			return createCatchAllAdapter();
		}

		@Override
		public Adapter caseCorrelations(Correlations object) {
			return createCorrelationsAdapter();
		}

		@Override
		public Adapter caseVariable(Variable object) {
			return createVariableAdapter();
		}

		@Override
		public Adapter caseUnknownExtensibilityAttribute(
				UnknownExtensibilityAttribute object) {
			return createUnknownExtensibilityAttributeAdapter();
		}

		@Override
		public Adapter caseOnEvent(OnEvent object) {
			return createOnEventAdapter();
		}

		@Override
		public Adapter caseImport(Import object) {
			return createImportAdapter();
		}

		@Override
		public Adapter caseRethrow(Rethrow object) {
			return createRethrowAdapter();
		}

		@Override
		public Adapter caseCondition(Condition object) {
			return createConditionAdapter();
		}

		@Override
		public Adapter caseTargets(Targets object) {
			return createTargetsAdapter();
		}

		@Override
		public Adapter caseSources(Sources object) {
			return createSourcesAdapter();
		}

		@Override
		public Adapter caseQuery(Query object) {
			return createQueryAdapter();
		}

		@Override
		public Adapter caseServiceRef(ServiceRef object) {
			return createServiceRefAdapter();
		}

		@Override
		public Adapter caseExtensions(Extensions object) {
			return createExtensionsAdapter();
		}

		@Override
		public Adapter caseExtensionActivity(ExtensionActivity object) {
			return createExtensionActivityAdapter();
		}

		@Override
		public Adapter caseFromPart(FromPart object) {
			return createFromPartAdapter();
		}

		@Override
		public Adapter caseToPart(ToPart object) {
			return createToPartAdapter();
		}

		@Override
		public Adapter caseOpaqueActivity(OpaqueActivity object) {
			return createOpaqueActivityAdapter();
		}

		@Override
		public Adapter caseForEach(ForEach object) {
			return createForEachAdapter();
		}

		@Override
		public Adapter caseRepeatUntil(RepeatUntil object) {
			return createRepeatUntilAdapter();
		}

		@Override
		public Adapter caseTerminationHandler(TerminationHandler object) {
			return createTerminationHandlerAdapter();
		}

		@Override
		public Adapter caseValidate(Validate object) {
			return createValidateAdapter();
		}

		@Override
		public Adapter caseIf(If object) {
			return createIfAdapter();
		}

		@Override
		public Adapter caseElseIf(ElseIf object) {
			return createElseIfAdapter();
		}

		@Override
		public Adapter caseElse(Else object) {
			return createElseAdapter();
		}

		@Override
		public Adapter caseCompletionCondition(CompletionCondition object) {
			return createCompletionConditionAdapter();
		}

		@Override
		public Adapter caseBranches(Branches object) {
			return createBranchesAdapter();
		}

		@Override
		public Adapter caseBPELExtensibleElement(BPELExtensibleElement object) {
			return createBPELExtensibleElementAdapter();
		}

		@Override
		public Adapter caseDocumentation(Documentation object) {
			return createDocumentationAdapter();
		}

		@Override
		public Adapter caseCompensate(Compensate object) {
			return createCompensateAdapter();
		}

		@Override
		public Adapter caseFromParts(FromParts object) {
			return createFromPartsAdapter();
		}

		@Override
		public Adapter caseToParts(ToParts object) {
			return createToPartsAdapter();
		}

		@Override
		public Adapter caseFailureHandling(FailureHandling object) {
			return createFailureHandlingAdapter();
		}

		@Override
		public Adapter caseFaultOnFailure(FaultOnFailure object) {
			return createFaultOnFailureAdapter();
		}

		@Override
		public Adapter caseRetryFor(RetryFor object) {
			return createRetryForAdapter();
		}

		@Override
		public Adapter caseRetryDelay(RetryDelay object) {
			return createRetryDelayAdapter();
		}

		@Override
		public Adapter caseWSDLElement(WSDLElement object) {
			return createWSDLElementAdapter();
		}

		@Override
		public Adapter caseIElementExtensible(ElementExtensible object) {
			return createIElementExtensibleAdapter();
		}

		@Override
		public Adapter caseIAttributeExtensible(AttributeExtensible object) {
			return createIAttributeExtensibleAdapter();
		}

		@Override
		public Adapter caseExtensibleElement(ExtensibleElement object) {
			return createExtensibleElementAdapter();
		}

		@Override
		public Adapter caseIExtensibilityElement(ExtensibilityElement object) {
			return createIExtensibilityElementAdapter();
		}

		@Override
		public Adapter caseExtensibilityElement(
				org.eclipse.wst.wsdl.ExtensibilityElement object) {
			return createExtensibilityElementAdapter();
		}

		@Override
		public Adapter caseUnknownExtensibilityElement(
				UnknownExtensibilityElement object) {
			return createUnknownExtensibilityElementAdapter();
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
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.PartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.PartnerLink
	 * @generated
	 */
	public Adapter createPartnerLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.FaultHandler <em>Fault Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.FaultHandler
	 * @generated
	 */
	public Adapter createFaultHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.CorrelationSet <em>Correlation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.CorrelationSet
	 * @generated
	 */
	public Adapter createCorrelationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Invoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Invoke
	 * @generated
	 */
	public Adapter createInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Catch <em>Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Catch
	 * @generated
	 */
	public Adapter createCatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Reply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Reply
	 * @generated
	 */
	public Adapter createReplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.PartnerActivity <em>Partner Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.PartnerActivity
	 * @generated
	 */
	public Adapter createPartnerActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Receive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Receive
	 * @generated
	 */
	public Adapter createReceiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Throw <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Throw
	 * @generated
	 */
	public Adapter createThrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Wait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Wait
	 * @generated
	 */
	public Adapter createWaitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Empty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Empty
	 * @generated
	 */
	public Adapter createEmptyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.While
	 * @generated
	 */
	public Adapter createWhileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Pick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Pick
	 * @generated
	 */
	public Adapter createPickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Flow
	 * @generated
	 */
	public Adapter createFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.OnAlarm <em>On Alarm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.OnAlarm
	 * @generated
	 */
	public Adapter createOnAlarmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.AssignE4X <em>Assign E4X</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.AssignE4X
	 * @generated
	 */
	public Adapter createAssignE4XAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ExtensionAssignOperation <em>Extension Assign Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ExtensionAssignOperation
	 * @generated
	 */
	public Adapter createExtensionAssignOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Snippet <em>Snippet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Snippet
	 * @generated
	 */
	public Adapter createSnippetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Assign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Assign
	 * @generated
	 */
	public Adapter createAssignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Copy <em>Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Copy
	 * @generated
	 */
	public Adapter createCopyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Extension
	 * @generated
	 */
	public Adapter createExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Scope
	 * @generated
	 */
	public Adapter createScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Compensate <em>Compensate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Compensate
	 * @generated
	 */
	public Adapter createCompensateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.FromParts <em>From Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.FromParts
	 * @generated
	 */
	public Adapter createFromPartsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ToParts <em>To Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ToParts
	 * @generated
	 */
	public Adapter createToPartsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.FailureHandling <em>Failure Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.FailureHandling
	 * @generated
	 */
	public Adapter createFailureHandlingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.FaultOnFailure <em>Fault On Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.FaultOnFailure
	 * @generated
	 */
	public Adapter createFaultOnFailureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.RetryFor <em>Retry For</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.RetryFor
	 * @generated
	 */
	public Adapter createRetryForAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.RetryDelay <em>Retry Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.RetryDelay
	 * @generated
	 */
	public Adapter createRetryDelayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.CompensationHandler <em>Compensation Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.CompensationHandler
	 * @generated
	 */
	public Adapter createCompensationHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.AbstractAssignBound <em>Abstract Assign Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.AbstractAssignBound
	 * @generated
	 */
	public Adapter createAbstractAssignBoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.To <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.To
	 * @generated
	 */
	public Adapter createToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.From <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.From
	 * @generated
	 */
	public Adapter createFromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.OnMessage <em>On Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.OnMessage
	 * @generated
	 */
	public Adapter createOnMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.BooleanExpression
	 * @generated
	 */
	public Adapter createBooleanExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Correlation <em>Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Correlation
	 * @generated
	 */
	public Adapter createCorrelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.EventHandler <em>Event Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.EventHandler
	 * @generated
	 */
	public Adapter createEventHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Source <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Source
	 * @generated
	 */
	public Adapter createSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Target
	 * @generated
	 */
	public Adapter createTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.PartnerLinks <em>Partner Links</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.PartnerLinks
	 * @generated
	 */
	public Adapter createPartnerLinksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Variables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Variables
	 * @generated
	 */
	public Adapter createVariablesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.CorrelationSets <em>Correlation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.CorrelationSets
	 * @generated
	 */
	public Adapter createCorrelationSetsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Links <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Links
	 * @generated
	 */
	public Adapter createLinksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.CatchAll <em>Catch All</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.CatchAll
	 * @generated
	 */
	public Adapter createCatchAllAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Correlations <em>Correlations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Correlations
	 * @generated
	 */
	public Adapter createCorrelationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.UnknownExtensibilityAttribute <em>Unknown Extensibility Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.UnknownExtensibilityAttribute
	 * @generated
	 */
	public Adapter createUnknownExtensibilityAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.OnEvent <em>On Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.OnEvent
	 * @generated
	 */
	public Adapter createOnEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Rethrow <em>Rethrow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Rethrow
	 * @generated
	 */
	public Adapter createRethrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Targets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Targets
	 * @generated
	 */
	public Adapter createTargetsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Sources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Sources
	 * @generated
	 */
	public Adapter createSourcesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Query
	 * @generated
	 */
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ServiceRef <em>Service Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ServiceRef
	 * @generated
	 */
	public Adapter createServiceRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Exit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Exit
	 * @generated
	 */
	public Adapter createExitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Extensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Extensions
	 * @generated
	 */
	public Adapter createExtensionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ExtensionActivity <em>Extension Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ExtensionActivity
	 * @generated
	 */
	public Adapter createExtensionActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.FromPart <em>From Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.FromPart
	 * @generated
	 */
	public Adapter createFromPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ToPart <em>To Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ToPart
	 * @generated
	 */
	public Adapter createToPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.OpaqueActivity <em>Opaque Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.OpaqueActivity
	 * @generated
	 */
	public Adapter createOpaqueActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ForEach <em>For Each</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ForEach
	 * @generated
	 */
	public Adapter createForEachAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.RepeatUntil <em>Repeat Until</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.RepeatUntil
	 * @generated
	 */
	public Adapter createRepeatUntilAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.TerminationHandler <em>Termination Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.TerminationHandler
	 * @generated
	 */
	public Adapter createTerminationHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.ElseIf <em>Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.ElseIf
	 * @generated
	 */
	public Adapter createElseIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Else <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Else
	 * @generated
	 */
	public Adapter createElseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.CompletionCondition <em>Completion Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.CompletionCondition
	 * @generated
	 */
	public Adapter createCompletionConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Branches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Branches
	 * @generated
	 */
	public Adapter createBranchesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.BPELExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.BPELExtensibleElement
	 * @generated
	 */
	public Adapter createBPELExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.wst.wsdl.WSDLElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.wst.wsdl.WSDLElement
	 * @generated
	 */
	public Adapter createWSDLElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.wsdl.extensions.ElementExtensible <em>IElement Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.wsdl.extensions.ElementExtensible
	 * @generated
	 */
	public Adapter createIElementExtensibleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.wsdl.extensions.AttributeExtensible <em>IAttribute Extensible</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.wsdl.extensions.AttributeExtensible
	 * @generated
	 */
	public Adapter createIAttributeExtensibleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.wst.wsdl.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.wst.wsdl.ExtensibleElement
	 * @generated
	 */
	public Adapter createExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Validate <em>Validate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Validate
	 * @generated
	 */
	public Adapter createValidateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.Documentation
	 * @generated
	 */
	public Adapter createDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.MessageExchanges <em>Message Exchanges</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.MessageExchanges
	 * @generated
	 */
	public Adapter createMessageExchangesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.MessageExchange <em>Message Exchange</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.MessageExchange
	 * @generated
	 */
	public Adapter createMessageExchangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.bpel.model.CompensateScope <em>Compensate Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.bpel.model.CompensateScope
	 * @generated
	 */
	public Adapter createCompensateScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.wsdl.extensions.ExtensibilityElement <em>IExtensibility Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.wsdl.extensions.ExtensibilityElement
	 * @generated
	 */
	public Adapter createIExtensibilityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.wst.wsdl.ExtensibilityElement <em>Extensibility Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.wst.wsdl.ExtensibilityElement
	 * @generated
	 */
	public Adapter createExtensibilityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.wst.wsdl.UnknownExtensibilityElement <em>Unknown Extensibility Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.wst.wsdl.UnknownExtensibilityElement
	 * @generated
	 */
	public Adapter createUnknownExtensibilityElementAdapter() {
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

} //BPELAdapterFactory
