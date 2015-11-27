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
 * $Id: BPELFactoryImpl.java,v 1.24 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.BPELFactory;
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
import org.eclipse.bpel.model.CorrelationPattern;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Documentation;
import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.Empty;
import org.eclipse.bpel.model.EndpointReferenceRole;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Exit;
import org.eclipse.bpel.model.Expression;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BPELFactoryImpl extends EFactoryImpl implements BPELFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BPELFactory init() {
		try {
			BPELFactory theBPELFactory = (BPELFactory) EPackage.Registry.INSTANCE
					.getEFactory(BPELPackage.eNS_URI);
			if (theBPELFactory != null) {
				return theBPELFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BPELFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPELFactoryImpl() {
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
		case BPELPackage.PROCESS:
			return createProcess();
		case BPELPackage.PARTNER_LINK:
			return createPartnerLink();
		case BPELPackage.FAULT_HANDLER:
			return createFaultHandler();
		case BPELPackage.ACTIVITY:
			return createActivity();
		case BPELPackage.CORRELATION_SET:
			return createCorrelationSet();
		case BPELPackage.INVOKE:
			return createInvoke();
		case BPELPackage.LINK:
			return createLink();
		case BPELPackage.CATCH:
			return createCatch();
		case BPELPackage.REPLY:
			return createReply();
		case BPELPackage.PARTNER_ACTIVITY:
			return createPartnerActivity();
		case BPELPackage.RECEIVE:
			return createReceive();
		case BPELPackage.EXIT:
			return createExit();
		case BPELPackage.THROW:
			return createThrow();
		case BPELPackage.WAIT:
			return createWait();
		case BPELPackage.EMPTY:
			return createEmpty();
		case BPELPackage.SEQUENCE:
			return createSequence();
		case BPELPackage.WHILE:
			return createWhile();
		case BPELPackage.PICK:
			return createPick();
		case BPELPackage.FLOW:
			return createFlow();
		case BPELPackage.ON_ALARM:
			return createOnAlarm();
		case BPELPackage.ASSIGN_E4X:
			return createAssignE4X();
		case BPELPackage.EXTENSION_ASSIGN_OPERATION:
			return createExtensionAssignOperation();
		case BPELPackage.SNIPPET:
			return createSnippet();
		case BPELPackage.ASSIGN:
			return createAssign();
		case BPELPackage.COPY:
			return createCopy();
		case BPELPackage.EXTENSION:
			return createExtension();
		case BPELPackage.SCOPE:
			return createScope();
		case BPELPackage.COMPENSATE_SCOPE:
			return createCompensateScope();
		case BPELPackage.COMPENSATION_HANDLER:
			return createCompensationHandler();
		case BPELPackage.TO:
			return createTo();
		case BPELPackage.FROM:
			return createFrom();
		case BPELPackage.ON_MESSAGE:
			return createOnMessage();
		case BPELPackage.EXPRESSION:
			return createExpression();
		case BPELPackage.BOOLEAN_EXPRESSION:
			return createBooleanExpression();
		case BPELPackage.CORRELATION:
			return createCorrelation();
		case BPELPackage.MESSAGE_EXCHANGE:
			return createMessageExchange();
		case BPELPackage.EVENT_HANDLER:
			return createEventHandler();
		case BPELPackage.SOURCE:
			return createSource();
		case BPELPackage.TARGET:
			return createTarget();
		case BPELPackage.PARTNER_LINKS:
			return createPartnerLinks();
		case BPELPackage.MESSAGE_EXCHANGES:
			return createMessageExchanges();
		case BPELPackage.VARIABLES:
			return createVariables();
		case BPELPackage.CORRELATION_SETS:
			return createCorrelationSets();
		case BPELPackage.LINKS:
			return createLinks();
		case BPELPackage.CATCH_ALL:
			return createCatchAll();
		case BPELPackage.CORRELATIONS:
			return createCorrelations();
		case BPELPackage.VARIABLE:
			return createVariable();
		case BPELPackage.UNKNOWN_EXTENSIBILITY_ATTRIBUTE:
			return createUnknownExtensibilityAttribute();
		case BPELPackage.ON_EVENT:
			return createOnEvent();
		case BPELPackage.IMPORT:
			return createImport();
		case BPELPackage.RETHROW:
			return createRethrow();
		case BPELPackage.CONDITION:
			return createCondition();
		case BPELPackage.TARGETS:
			return createTargets();
		case BPELPackage.SOURCES:
			return createSources();
		case BPELPackage.QUERY:
			return createQuery();
		case BPELPackage.SERVICE_REF:
			return createServiceRef();
		case BPELPackage.EXTENSIONS:
			return createExtensions();
		case BPELPackage.EXTENSION_ACTIVITY:
			return createExtensionActivity();
		case BPELPackage.FROM_PART:
			return createFromPart();
		case BPELPackage.TO_PART:
			return createToPart();
		case BPELPackage.OPAQUE_ACTIVITY:
			return createOpaqueActivity();
		case BPELPackage.FOR_EACH:
			return createForEach();
		case BPELPackage.REPEAT_UNTIL:
			return createRepeatUntil();
		case BPELPackage.TERMINATION_HANDLER:
			return createTerminationHandler();
		case BPELPackage.VALIDATE:
			return createValidate();
		case BPELPackage.IF:
			return createIf();
		case BPELPackage.ELSE_IF:
			return createElseIf();
		case BPELPackage.ELSE:
			return createElse();
		case BPELPackage.COMPLETION_CONDITION:
			return createCompletionCondition();
		case BPELPackage.BRANCHES:
			return createBranches();
		case BPELPackage.BPEL_EXTENSIBLE_ELEMENT:
			return createBPELExtensibleElement();
		case BPELPackage.DOCUMENTATION:
			return createDocumentation();
		case BPELPackage.COMPENSATE:
			return createCompensate();
		case BPELPackage.FROM_PARTS:
			return createFromParts();
		case BPELPackage.TO_PARTS:
			return createToParts();
		case BPELPackage.FAILURE_HANDLING:
			return createFailureHandling();
		case BPELPackage.FAULT_ON_FAILURE:
			return createFaultOnFailure();
		case BPELPackage.RETRY_FOR:
			return createRetryFor();
		case BPELPackage.RETRY_DELAY:
			return createRetryDelay();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
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
		case BPELPackage.CORRELATION_PATTERN:
			return createCorrelationPatternFromString(eDataType, initialValue);
		case BPELPackage.ENDPOINT_REFERENCE_ROLE:
			return createEndpointReferenceRoleFromString(eDataType,
					initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
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
		case BPELPackage.CORRELATION_PATTERN:
			return convertCorrelationPatternToString(eDataType, instanceValue);
		case BPELPackage.ENDPOINT_REFERENCE_ROLE:
			return convertEndpointReferenceRoleToString(eDataType,
					instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpel.model.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink createPartnerLink() {
		PartnerLinkImpl partnerLink = new PartnerLinkImpl();
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultHandler createFaultHandler() {
		FaultHandlerImpl faultHandler = new FaultHandlerImpl();
		return faultHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationSet createCorrelationSet() {
		CorrelationSetImpl correlationSet = new CorrelationSetImpl();
		return correlationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke createInvoke() {
		InvokeImpl invoke = new InvokeImpl();
		return invoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Catch createCatch() {
		CatchImpl catch_ = new CatchImpl();
		return catch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reply createReply() {
		ReplyImpl reply = new ReplyImpl();
		return reply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerActivity createPartnerActivity() {
		PartnerActivityImpl partnerActivity = new PartnerActivityImpl();
		return partnerActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Receive createReceive() {
		ReceiveImpl receive = new ReceiveImpl();
		return receive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Throw createThrow() {
		ThrowImpl throw_ = new ThrowImpl();
		return throw_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wait createWait() {
		WaitImpl wait = new WaitImpl();
		return wait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Empty createEmpty() {
		EmptyImpl empty = new EmptyImpl();
		return empty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public While createWhile() {
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pick createPick() {
		PickImpl pick = new PickImpl();
		return pick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow createFlow() {
		FlowImpl flow = new FlowImpl();
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnAlarm createOnAlarm() {
		OnAlarmImpl onAlarm = new OnAlarmImpl();
		return onAlarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignE4X createAssignE4X() {
		AssignE4XImpl assignE4X = new AssignE4XImpl();
		return assignE4X;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionAssignOperation createExtensionAssignOperation() {
		ExtensionAssignOperationImpl extensionAssignOperation = new ExtensionAssignOperationImpl();
		return extensionAssignOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snippet createSnippet() {
		SnippetImpl snippet = new SnippetImpl();
		return snippet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assign createAssign() {
		AssignImpl assign = new AssignImpl();
		return assign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Copy createCopy() {
		CopyImpl copy = new CopyImpl();
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scope createScope() {
		ScopeImpl scope = new ScopeImpl();
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compensate createCompensate() {
		CompensateImpl compensate = new CompensateImpl();
		return compensate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromParts createFromParts() {
		FromPartsImpl fromParts = new FromPartsImpl();
		return fromParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToParts createToParts() {
		ToPartsImpl toParts = new ToPartsImpl();
		return toParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FailureHandling createFailureHandling() {
		FailureHandlingImpl failureHandling = new FailureHandlingImpl();
		return failureHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultOnFailure createFaultOnFailure() {
		FaultOnFailureImpl faultOnFailure = new FaultOnFailureImpl();
		return faultOnFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetryFor createRetryFor() {
		RetryForImpl retryFor = new RetryForImpl();
		return retryFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetryDelay createRetryDelay() {
		RetryDelayImpl retryDelay = new RetryDelayImpl();
		return retryDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationPattern createCorrelationPatternFromString(
			EDataType eDataType, String initialValue) {
		CorrelationPattern result = CorrelationPattern.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCorrelationPatternToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndpointReferenceRole createEndpointReferenceRoleFromString(
			EDataType eDataType, String initialValue) {
		EndpointReferenceRole result = EndpointReferenceRole.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEndpointReferenceRoleToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompensationHandler createCompensationHandler() {
		CompensationHandlerImpl compensationHandler = new CompensationHandlerImpl();
		return compensationHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public To createTo() {
		ToImpl to = new ToImpl();
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public From createFrom() {
		FromImpl from = new FromImpl();
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnMessage createOnMessage() {
		OnMessageImpl onMessage = new OnMessageImpl();
		return onMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpression createBooleanExpression() {
		BooleanExpressionImpl booleanExpression = new BooleanExpressionImpl();
		return booleanExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Correlation createCorrelation() {
		CorrelationImpl correlation = new CorrelationImpl();
		return correlation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventHandler createEventHandler() {
		EventHandlerImpl eventHandler = new EventHandlerImpl();
		return eventHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Source createSource() {
		SourceImpl source = new SourceImpl();
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLinks createPartnerLinks() {
		PartnerLinksImpl partnerLinks = new PartnerLinksImpl();
		return partnerLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variables createVariables() {
		VariablesImpl variables = new VariablesImpl();
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationSets createCorrelationSets() {
		CorrelationSetsImpl correlationSets = new CorrelationSetsImpl();
		return correlationSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Links createLinks() {
		LinksImpl links = new LinksImpl();
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatchAll createCatchAll() {
		CatchAllImpl catchAll = new CatchAllImpl();
		return catchAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Correlations createCorrelations() {
		CorrelationsImpl correlations = new CorrelationsImpl();
		return correlations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnknownExtensibilityAttribute createUnknownExtensibilityAttribute() {
		UnknownExtensibilityAttributeImpl unknownExtensibilityAttribute = new UnknownExtensibilityAttributeImpl();
		return unknownExtensibilityAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnEvent createOnEvent() {
		OnEventImpl onEvent = new OnEventImpl();
		return onEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rethrow createRethrow() {
		RethrowImpl rethrow = new RethrowImpl();
		return rethrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Targets createTargets() {
		TargetsImpl targets = new TargetsImpl();
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sources createSources() {
		SourcesImpl sources = new SourcesImpl();
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceRef createServiceRef() {
		ServiceRefImpl serviceRef = new ServiceRefImpl();
		return serviceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exit createExit() {
		ExitImpl exit = new ExitImpl();
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extensions createExtensions() {
		ExtensionsImpl extensions = new ExtensionsImpl();
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionActivity createExtensionActivity() {
		ExtensionActivityImpl extensionActivity = new ExtensionActivityImpl();
		return extensionActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromPart createFromPart() {
		FromPartImpl fromPart = new FromPartImpl();
		return fromPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToPart createToPart() {
		ToPartImpl toPart = new ToPartImpl();
		return toPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueActivity createOpaqueActivity() {
		OpaqueActivityImpl opaqueActivity = new OpaqueActivityImpl();
		return opaqueActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEach createForEach() {
		ForEachImpl forEach = new ForEachImpl();
		return forEach;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepeatUntil createRepeatUntil() {
		RepeatUntilImpl repeatUntil = new RepeatUntilImpl();
		return repeatUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminationHandler createTerminationHandler() {
		TerminationHandlerImpl terminationHandler = new TerminationHandlerImpl();
		return terminationHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseIf createElseIf() {
		ElseIfImpl elseIf = new ElseIfImpl();
		return elseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Else createElse() {
		ElseImpl else_ = new ElseImpl();
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionCondition createCompletionCondition() {
		CompletionConditionImpl completionCondition = new CompletionConditionImpl();
		return completionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branches createBranches() {
		BranchesImpl branches = new BranchesImpl();
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPELExtensibleElement createBPELExtensibleElement() {
		BPELExtensibleElementImpl bpelExtensibleElement = new BPELExtensibleElementImpl();
		return bpelExtensibleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Validate createValidate() {
		ValidateImpl validate = new ValidateImpl();
		return validate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation createDocumentation() {
		DocumentationImpl documentation = new DocumentationImpl();
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchanges createMessageExchanges() {
		MessageExchangesImpl messageExchanges = new MessageExchangesImpl();
		return messageExchanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchange createMessageExchange() {
		MessageExchangeImpl messageExchange = new MessageExchangeImpl();
		return messageExchange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompensateScope createCompensateScope() {
		CompensateScopeImpl compensateScope = new CompensateScopeImpl();
		return compensateScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPELPackage getBPELPackage() {
		return (BPELPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BPELPackage getPackage() {
		return BPELPackage.eINSTANCE;
	}

} //BPELFactoryImpl
