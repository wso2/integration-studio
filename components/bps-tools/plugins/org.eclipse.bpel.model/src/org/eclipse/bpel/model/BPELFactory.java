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
 * $Id: BPELFactory.java,v 1.22 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.model.BPELPackage
 * @generated
 */
public interface BPELFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BPELFactory eINSTANCE = org.eclipse.bpel.model.impl.BPELFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Partner Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partner Link</em>'.
	 * @generated
	 */
	PartnerLink createPartnerLink();

	/**
	 * Returns a new object of class '<em>Fault Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault Handler</em>'.
	 * @generated
	 */
	FaultHandler createFaultHandler();

	/**
	 * Returns a new object of class '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity</em>'.
	 * @generated
	 */
	Activity createActivity();

	/**
	 * Returns a new object of class '<em>Correlation Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correlation Set</em>'.
	 * @generated
	 */
	CorrelationSet createCorrelationSet();

	/**
	 * Returns a new object of class '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke</em>'.
	 * @generated
	 */
	Invoke createInvoke();

	/**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
	Link createLink();

	/**
	 * Returns a new object of class '<em>Catch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catch</em>'.
	 * @generated
	 */
	Catch createCatch();

	/**
	 * Returns a new object of class '<em>Reply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reply</em>'.
	 * @generated
	 */
	Reply createReply();

	/**
	 * Returns a new object of class '<em>Partner Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partner Activity</em>'.
	 * @generated
	 */
	PartnerActivity createPartnerActivity();

	/**
	 * Returns a new object of class '<em>Receive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Receive</em>'.
	 * @generated
	 */
	Receive createReceive();

	/**
	 * Returns a new object of class '<em>Throw</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Throw</em>'.
	 * @generated
	 */
	Throw createThrow();

	/**
	 * Returns a new object of class '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait</em>'.
	 * @generated
	 */
	Wait createWait();

	/**
	 * Returns a new object of class '<em>Empty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty</em>'.
	 * @generated
	 */
	Empty createEmpty();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>While</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While</em>'.
	 * @generated
	 */
	While createWhile();

	/**
	 * Returns a new object of class '<em>Pick</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pick</em>'.
	 * @generated
	 */
	Pick createPick();

	/**
	 * Returns a new object of class '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow</em>'.
	 * @generated
	 */
	Flow createFlow();

	/**
	 * Returns a new object of class '<em>On Alarm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Alarm</em>'.
	 * @generated
	 */
	OnAlarm createOnAlarm();

	/**
	 * Returns a new object of class '<em>Assign E4X</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign E4X</em>'.
	 * @generated
	 */
	AssignE4X createAssignE4X();

	/**
	 * Returns a new object of class '<em>Extension Assign Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Assign Operation</em>'.
	 * @generated
	 */
	ExtensionAssignOperation createExtensionAssignOperation();

	/**
	 * Returns a new object of class '<em>Snippet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snippet</em>'.
	 * @generated
	 */
	Snippet createSnippet();

	/**
	 * Returns a new object of class '<em>Assign</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign</em>'.
	 * @generated
	 */
	Assign createAssign();

	/**
	 * Returns a new object of class '<em>Copy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copy</em>'.
	 * @generated
	 */
	Copy createCopy();

	/**
	 * Returns a new object of class '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension</em>'.
	 * @generated
	 */
	Extension createExtension();

	/**
	 * Returns a new object of class '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scope</em>'.
	 * @generated
	 */
	Scope createScope();

	/**
	 * Returns a new object of class '<em>Compensate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compensate</em>'.
	 * @generated
	 */
	Compensate createCompensate();

	/**
	 * Returns a new object of class '<em>From Parts</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Parts</em>'.
	 * @generated
	 */
	FromParts createFromParts();

	/**
	 * Returns a new object of class '<em>To Parts</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Parts</em>'.
	 * @generated
	 */
	ToParts createToParts();

	/**
	 * Returns a new object of class '<em>Failure Handling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Failure Handling</em>'.
	 * @generated
	 */
	FailureHandling createFailureHandling();

	/**
	 * Returns a new object of class '<em>Fault On Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fault On Failure</em>'.
	 * @generated
	 */
	FaultOnFailure createFaultOnFailure();

	/**
	 * Returns a new object of class '<em>Retry For</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Retry For</em>'.
	 * @generated
	 */
	RetryFor createRetryFor();

	/**
	 * Returns a new object of class '<em>Retry Delay</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Retry Delay</em>'.
	 * @generated
	 */
	RetryDelay createRetryDelay();

	/**
	 * Returns a new object of class '<em>Compensation Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compensation Handler</em>'.
	 * @generated
	 */
	CompensationHandler createCompensationHandler();

	/**
	 * Returns a new object of class '<em>To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To</em>'.
	 * @generated
	 */
	To createTo();

	/**
	 * Returns a new object of class '<em>From</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From</em>'.
	 * @generated
	 */
	From createFrom();

	/**
	 * Returns a new object of class '<em>On Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Message</em>'.
	 * @generated
	 */
	OnMessage createOnMessage();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Expression</em>'.
	 * @generated
	 */
	BooleanExpression createBooleanExpression();

	/**
	 * Returns a new object of class '<em>Correlation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correlation</em>'.
	 * @generated
	 */
	Correlation createCorrelation();

	/**
	 * Returns a new object of class '<em>Event Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Handler</em>'.
	 * @generated
	 */
	EventHandler createEventHandler();

	/**
	 * Returns a new object of class '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source</em>'.
	 * @generated
	 */
	Source createSource();

	/**
	 * Returns a new object of class '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target</em>'.
	 * @generated
	 */
	Target createTarget();

	/**
	 * Returns a new object of class '<em>Partner Links</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partner Links</em>'.
	 * @generated
	 */
	PartnerLinks createPartnerLinks();

	/**
	 * Returns a new object of class '<em>Variables</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variables</em>'.
	 * @generated
	 */
	Variables createVariables();

	/**
	 * Returns a new object of class '<em>Correlation Sets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correlation Sets</em>'.
	 * @generated
	 */
	CorrelationSets createCorrelationSets();

	/**
	 * Returns a new object of class '<em>Links</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Links</em>'.
	 * @generated
	 */
	Links createLinks();

	/**
	 * Returns a new object of class '<em>Catch All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catch All</em>'.
	 * @generated
	 */
	CatchAll createCatchAll();

	/**
	 * Returns a new object of class '<em>Correlations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Correlations</em>'.
	 * @generated
	 */
	Correlations createCorrelations();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Unknown Extensibility Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Extensibility Attribute</em>'.
	 * @generated
	 */
	UnknownExtensibilityAttribute createUnknownExtensibilityAttribute();

	/**
	 * Returns a new object of class '<em>On Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>On Event</em>'.
	 * @generated
	 */
	OnEvent createOnEvent();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Rethrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rethrow</em>'.
	 * @generated
	 */
	Rethrow createRethrow();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>Targets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Targets</em>'.
	 * @generated
	 */
	Targets createTargets();

	/**
	 * Returns a new object of class '<em>Sources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sources</em>'.
	 * @generated
	 */
	Sources createSources();

	/**
	 * Returns a new object of class '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query</em>'.
	 * @generated
	 */
	Query createQuery();

	/**
	 * Returns a new object of class '<em>Service Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Ref</em>'.
	 * @generated
	 */
	ServiceRef createServiceRef();

	/**
	 * Returns a new object of class '<em>Exit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exit</em>'.
	 * @generated
	 */
	Exit createExit();

	/**
	 * Returns a new object of class '<em>Extensions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extensions</em>'.
	 * @generated
	 */
	Extensions createExtensions();

	/**
	 * Returns a new object of class '<em>Extension Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Activity</em>'.
	 * @generated
	 */
	ExtensionActivity createExtensionActivity();

	/**
	 * Returns a new object of class '<em>From Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Part</em>'.
	 * @generated
	 */
	FromPart createFromPart();

	/**
	 * Returns a new object of class '<em>To Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Part</em>'.
	 * @generated
	 */
	ToPart createToPart();

	/**
	 * Returns a new object of class '<em>Opaque Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opaque Activity</em>'.
	 * @generated
	 */
	OpaqueActivity createOpaqueActivity();

	/**
	 * Returns a new object of class '<em>For Each</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each</em>'.
	 * @generated
	 */
	ForEach createForEach();

	/**
	 * Returns a new object of class '<em>Repeat Until</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repeat Until</em>'.
	 * @generated
	 */
	RepeatUntil createRepeatUntil();

	/**
	 * Returns a new object of class '<em>Termination Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Termination Handler</em>'.
	 * @generated
	 */
	TerminationHandler createTerminationHandler();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Else If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else If</em>'.
	 * @generated
	 */
	ElseIf createElseIf();

	/**
	 * Returns a new object of class '<em>Else</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else</em>'.
	 * @generated
	 */
	Else createElse();

	/**
	 * Returns a new object of class '<em>Completion Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Condition</em>'.
	 * @generated
	 */
	CompletionCondition createCompletionCondition();

	/**
	 * Returns a new object of class '<em>Branches</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branches</em>'.
	 * @generated
	 */
	Branches createBranches();

	/**
	 * Returns a new object of class '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extensible Element</em>'.
	 * @generated
	 */
	BPELExtensibleElement createBPELExtensibleElement();

	/**
	 * Returns a new object of class '<em>Validate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate</em>'.
	 * @generated
	 */
	Validate createValidate();

	/**
	 * Returns a new object of class '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation</em>'.
	 * @generated
	 */
	Documentation createDocumentation();

	/**
	 * Returns a new object of class '<em>Message Exchanges</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Exchanges</em>'.
	 * @generated
	 */
	MessageExchanges createMessageExchanges();

	/**
	 * Returns a new object of class '<em>Message Exchange</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Exchange</em>'.
	 * @generated
	 */
	MessageExchange createMessageExchange();

	/**
	 * Returns a new object of class '<em>Compensate Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compensate Scope</em>'.
	 * @generated
	 */
	CompensateScope createCompensateScope();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BPELPackage getBPELPackage();

} //BPELFactory
