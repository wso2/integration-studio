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
 * $Id: BPELPackageImpl.java,v 1.40 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.AbstractAssignBound;
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
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.impl.MessagepropertiesPackageImpl;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.impl.PartnerlinktypePackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.xsd.XSDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BPELPackageImpl extends EPackageImpl implements BPELPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onAlarmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignE4XEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionAssignOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snippetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compensateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromPartsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toPartsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failureHandlingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultOnFailureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass retryForEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass retryDelayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compensationHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractAssignBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerLinksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variablesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationSetsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchAllEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownExtensibilityAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rethrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourcesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatUntilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminationHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elseIfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpelExtensibleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageExchangesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageExchangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compensateScopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum correlationPatternEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum endpointReferenceRoleEEnum = null;

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
	 * @see org.eclipse.bpel.model.BPELPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BPELPackageImpl() {
		super(eNS_URI, BPELFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BPELPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BPELPackage initGen() {
		if (isInited)
			return (BPELPackage) EPackage.Registry.INSTANCE
					.getEPackage(BPELPackage.eNS_URI);

		// Obtain or create and register package
		BPELPackageImpl theBPELPackage = (BPELPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof BPELPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new BPELPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		WSDLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PartnerlinktypePackageImpl thePartnerlinktypePackage = (PartnerlinktypePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(PartnerlinktypePackage.eNS_URI) instanceof PartnerlinktypePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(PartnerlinktypePackage.eNS_URI)
				: PartnerlinktypePackage.eINSTANCE);
		MessagepropertiesPackageImpl theMessagepropertiesPackage = (MessagepropertiesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MessagepropertiesPackage.eNS_URI) instanceof MessagepropertiesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(MessagepropertiesPackage.eNS_URI)
				: MessagepropertiesPackage.eINSTANCE);

		// Create package meta-data objects
		theBPELPackage.createPackageContents();
		thePartnerlinktypePackage.createPackageContents();
		theMessagepropertiesPackage.createPackageContents();

		// Initialize created meta-data
		theBPELPackage.initializePackageContents();
		thePartnerlinktypePackage.initializePackageContents();
		theMessagepropertiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBPELPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BPELPackage.eNS_URI, theBPELPackage);
		return theBPELPackage;
	}

	public static BPELPackage init() {
		BPELPackage thePackage = initGen();

		//TODO: handle the following test differently
		// Bugzilla 340654
		if (!CorrelationPattern.REQUESTRESPONSE_LITERAL.getName().equals(
				"requestresponse")) { //$NON-NLS-1$
			System.err
					.println("BPELPackageImpl: CorrelationPattern has invalid value. Fix CorrelationPattern.REQUESTRESPONSE_LITERAL."); //$NON-NLS-1$
		}
		return thePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcess() {
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_Name() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_TargetNamespace() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_QueryLanguage() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_ExpressionLanguage() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_SuppressJoinFailure() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_VariableAccessSerializable() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_PartnerLinks() {
		return (EReference) processEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Variables() {
		return (EReference) processEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Activity() {
		return (EReference) processEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_FaultHandlers() {
		return (EReference) processEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Extensions() {
		return (EReference) processEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_ExitOnStandardFault() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_MessageExchanges() {
		return (EReference) processEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_AbstractProcessProfile() {
		return (EAttribute) processEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_EventHandlers() {
		return (EReference) processEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_CorrelationSets() {
		return (EReference) processEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Imports() {
		return (EReference) processEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerLink() {
		return partnerLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerLink_Name() {
		return (EAttribute) partnerLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerLink_MyRole() {
		return (EReference) partnerLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerLink_PartnerRole() {
		return (EReference) partnerLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerLink_PartnerLinkType() {
		return (EReference) partnerLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerLink_InitializePartnerRole() {
		return (EAttribute) partnerLinkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultHandler() {
		return faultHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultHandler_Catch() {
		return (EReference) faultHandlerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultHandler_CatchAll() {
		return (EReference) faultHandlerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_Name() {
		return (EAttribute) activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_SuppressJoinFailure() {
		return (EAttribute) activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Targets() {
		return (EReference) activityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Sources() {
		return (EReference) activityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationSet() {
		return correlationSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCorrelationSet_Name() {
		return (EAttribute) correlationSetEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationSet_Properties() {
		return (EReference) correlationSetEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvoke() {
		return invokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_OutputVariable() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_InputVariable() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_CompensationHandler() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_FaultHandler() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_FromParts() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_ToParts() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvoke_FailureHandling() {
		return (EReference) invokeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Name() {
		return (EAttribute) linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Sources() {
		return (EReference) linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_Targets() {
		return (EReference) linkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatch() {
		return catchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatch_FaultName() {
		return (EAttribute) catchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatch_FaultVariable() {
		return (EReference) catchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatch_Activity() {
		return (EReference) catchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatch_FaultMessageType() {
		return (EReference) catchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatch_FaultElement() {
		return (EReference) catchEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReply() {
		return replyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReply_FaultName() {
		return (EAttribute) replyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReply_Variable() {
		return (EReference) replyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReply_ToParts() {
		return (EReference) replyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReply_MessageExchange() {
		return (EReference) replyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerActivity() {
		return partnerActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerActivity_PartnerLink() {
		return (EReference) partnerActivityEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerActivity_Correlations() {
		return (EReference) partnerActivityEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerActivity_PortType() {
		return (EReference) partnerActivityEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerActivity_Operation() {
		return (EReference) partnerActivityEClass.getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceive() {
		return receiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReceive_CreateInstance() {
		return (EAttribute) receiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceive_Variable() {
		return (EReference) receiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceive_FromParts() {
		return (EReference) receiveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceive_MessageExchange() {
		return (EReference) receiveEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrow() {
		return throwEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrow_FaultName() {
		return (EAttribute) throwEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrow_FaultVariable() {
		return (EReference) throwEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWait() {
		return waitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWait_For() {
		return (EReference) waitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWait_Until() {
		return (EReference) waitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmpty() {
		return emptyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_Activities() {
		return (EReference) sequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhile() {
		return whileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhile_Activity() {
		return (EReference) whileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhile_Condition() {
		return (EReference) whileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPick() {
		return pickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPick_CreateInstance() {
		return (EAttribute) pickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPick_Messages() {
		return (EReference) pickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPick_Alarm() {
		return (EReference) pickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlow() {
		return flowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_Activities() {
		return (EReference) flowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_Links() {
		return (EReference) flowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_CompletionCondition() {
		return (EReference) flowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnAlarm() {
		return onAlarmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnAlarm_Activity() {
		return (EReference) onAlarmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnAlarm_For() {
		return (EReference) onAlarmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnAlarm_Until() {
		return (EReference) onAlarmEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnAlarm_RepeatEvery() {
		return (EReference) onAlarmEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignE4X() {
		return assignE4XEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignE4X_Validate() {
		return (EAttribute) assignE4XEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignE4X_ExtensionAssignOperation() {
		return (EReference) assignE4XEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionAssignOperation() {
		return extensionAssignOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionAssignOperation_Snippet() {
		return (EReference) extensionAssignOperationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSnippet() {
		return snippetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnippet_Body() {
		return (EAttribute) snippetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssign() {
		return assignEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssign_Copy() {
		return (EReference) assignEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssign_Validate() {
		return (EAttribute) assignEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopy() {
		return copyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCopy_To() {
		return (EReference) copyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCopy_From() {
		return (EReference) copyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopy_KeepSrcElementName() {
		return (EAttribute) copyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopy_IgnoreMissingFromData() {
		return (EAttribute) copyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtension() {
		return extensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtension_Namespace() {
		return (EAttribute) extensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtension_MustUnderstand() {
		return (EAttribute) extensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScope() {
		return scopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScope_Isolated() {
		return (EAttribute) scopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_FaultHandlers() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_CompensationHandler() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_Activity() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_Variables() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_CorrelationSets() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_EventHandlers() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_PartnerLinks() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_TerminationHandler() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScope_MessageExchanges() {
		return (EReference) scopeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScope_ExitOnStandardFault() {
		return (EAttribute) scopeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompensate() {
		return compensateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromParts() {
		return fromPartsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromParts_Children() {
		return (EReference) fromPartsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToParts() {
		return toPartsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToParts_Children() {
		return (EReference) toPartsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFailureHandling() {
		return failureHandlingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureHandling_FaultOnFailure() {
		return (EReference) failureHandlingEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureHandling_RetryFor() {
		return (EReference) failureHandlingEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFailureHandling_RetryDelay() {
		return (EReference) failureHandlingEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultOnFailure() {
		return faultOnFailureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultOnFailure_Value() {
		return (EAttribute) faultOnFailureEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRetryFor() {
		return retryForEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRetryFor_Value() {
		return (EAttribute) retryForEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRetryDelay() {
		return retryDelayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRetryDelay_Value() {
		return (EAttribute) retryDelayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompensationHandler() {
		return compensationHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompensationHandler_Activity() {
		return (EReference) compensationHandlerEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAssignBound() {
		return abstractAssignBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAssignBound_Variable() {
		return (EReference) abstractAssignBoundEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAssignBound_Part() {
		return (EReference) abstractAssignBoundEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAssignBound_PartnerLink() {
		return (EReference) abstractAssignBoundEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAssignBound_Property() {
		return (EReference) abstractAssignBoundEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAssignBound_Query() {
		return (EReference) abstractAssignBoundEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAssignBound_Expression() {
		return (EReference) abstractAssignBoundEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTo() {
		return toEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFrom() {
		return fromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrom_Opaque() {
		return (EAttribute) fromEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrom_EndpointReference() {
		return (EAttribute) fromEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrom_Literal() {
		return (EAttribute) fromEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrom_UnsafeLiteral() {
		return (EAttribute) fromEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFrom_ServiceRef() {
		return (EReference) fromEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFrom_Type() {
		return (EReference) fromEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnMessage() {
		return onMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_Variable() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_Activity() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_PortType() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_PartnerLink() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_Correlations() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_Operation() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_FromParts() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnMessage_MessageExchange() {
		return (EReference) onMessageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Body() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_ExpressionLanguage() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Opaque() {
		return (EAttribute) expressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanExpression() {
		return booleanExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelation() {
		return correlationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCorrelation_Initiate() {
		return (EAttribute) correlationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCorrelation_Pattern() {
		return (EAttribute) correlationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelation_Set() {
		return (EReference) correlationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventHandler() {
		return eventHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventHandler_Alarm() {
		return (EReference) eventHandlerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventHandler_Events() {
		return (EReference) eventHandlerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSource() {
		return sourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSource_Link() {
		return (EReference) sourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSource_Activity() {
		return (EReference) sourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSource_TransitionCondition() {
		return (EReference) sourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Link() {
		return (EReference) targetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Activity() {
		return (EReference) targetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerLinks() {
		return partnerLinksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerLinks_Children() {
		return (EReference) partnerLinksEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariables() {
		return variablesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariables_Children() {
		return (EReference) variablesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationSets() {
		return correlationSetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationSets_Children() {
		return (EReference) correlationSetsEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinks() {
		return linksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinks_Children() {
		return (EReference) linksEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatchAll() {
		return catchAllEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchAll_Activity() {
		return (EReference) catchAllEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelations() {
		return correlationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelations_Children() {
		return (EReference) correlationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute) variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_MessageType() {
		return (EReference) variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_XSDElement() {
		return (EReference) variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Type() {
		return (EReference) variableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_From() {
		return (EReference) variableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknownExtensibilityAttribute() {
		return unknownExtensibilityAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnEvent() {
		return onEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_Activity() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_Variable() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_PartnerLink() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_Correlations() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_Operation() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_PortType() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_MessageType() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_XSDElement() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_CorrelationSets() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_FromParts() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOnEvent_MessageExchange() {
		return (EReference) onEventEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Namespace() {
		return (EAttribute) importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Location() {
		return (EAttribute) importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_ImportType() {
		return (EAttribute) importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRethrow() {
		return rethrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargets() {
		return targetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargets_Children() {
		return (EReference) targetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargets_JoinCondition() {
		return (EReference) targetsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSources() {
		return sourcesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSources_Children() {
		return (EReference) sourcesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuery() {
		return queryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_Value() {
		return (EAttribute) queryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_QueryLanguage() {
		return (EAttribute) queryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceRef() {
		return serviceRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRef_ReferenceScheme() {
		return (EAttribute) serviceRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceRef_Value() {
		return (EAttribute) serviceRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExit() {
		return exitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensions() {
		return extensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensions_Children() {
		return (EReference) extensionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionActivity() {
		return extensionActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromPart() {
		return fromPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromPart_ToVariable() {
		return (EReference) fromPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromPart_Part() {
		return (EReference) fromPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToPart() {
		return toPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPart_FromVariable() {
		return (EReference) toPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToPart_Part() {
		return (EReference) toPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueActivity() {
		return opaqueActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEach() {
		return forEachEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEach_StartCounterValue() {
		return (EReference) forEachEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEach_FinalCounterValue() {
		return (EReference) forEachEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEach_Parallel() {
		return (EAttribute) forEachEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEach_CounterName() {
		return (EReference) forEachEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEach_CompletionCondition() {
		return (EReference) forEachEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEach_Activity() {
		return (EReference) forEachEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepeatUntil() {
		return repeatUntilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeatUntil_Activity() {
		return (EReference) repeatUntilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeatUntil_Condition() {
		return (EReference) repeatUntilEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminationHandler() {
		return terminationHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminationHandler_Activity() {
		return (EReference) terminationHandlerEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIf() {
		return ifEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_Condition() {
		return (EReference) ifEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_ElseIf() {
		return (EReference) ifEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_Else() {
		return (EReference) ifEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_Activity() {
		return (EReference) ifEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElseIf() {
		return elseIfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElseIf_Condition() {
		return (EReference) elseIfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElseIf_Activity() {
		return (EReference) elseIfEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElse() {
		return elseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElse_Activity() {
		return (EReference) elseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionCondition() {
		return completionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompletionCondition_Branches() {
		return (EReference) completionConditionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranches() {
		return branchesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranches_CountCompletedBranchesOnly() {
		return (EAttribute) branchesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPELExtensibleElement() {
		return bpelExtensibleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPELExtensibleElement_Documentation() {
		return (EReference) bpelExtensibleElementEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidate() {
		return validateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidate_Variables() {
		return (EReference) validateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentation() {
		return documentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Lang() {
		return (EAttribute) documentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Source() {
		return (EAttribute) documentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Value() {
		return (EAttribute) documentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageExchanges() {
		return messageExchangesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageExchanges_Children() {
		return (EReference) messageExchangesEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageExchange() {
		return messageExchangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageExchange_Name() {
		return (EAttribute) messageExchangeEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompensateScope() {
		return compensateScopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompensateScope_Target() {
		return (EReference) compensateScopeEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCorrelationPattern() {
		return correlationPatternEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEndpointReferenceRole() {
		return endpointReferenceRoleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPELFactory getBPELFactory() {
		return (BPELFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		processEClass = createEClass(PROCESS);
		createEAttribute(processEClass, PROCESS__NAME);
		createEAttribute(processEClass, PROCESS__TARGET_NAMESPACE);
		createEAttribute(processEClass, PROCESS__QUERY_LANGUAGE);
		createEAttribute(processEClass, PROCESS__EXPRESSION_LANGUAGE);
		createEAttribute(processEClass, PROCESS__SUPPRESS_JOIN_FAILURE);
		createEAttribute(processEClass, PROCESS__VARIABLE_ACCESS_SERIALIZABLE);
		createEReference(processEClass, PROCESS__PARTNER_LINKS);
		createEReference(processEClass, PROCESS__VARIABLES);
		createEReference(processEClass, PROCESS__ACTIVITY);
		createEReference(processEClass, PROCESS__FAULT_HANDLERS);
		createEReference(processEClass, PROCESS__EVENT_HANDLERS);
		createEReference(processEClass, PROCESS__CORRELATION_SETS);
		createEReference(processEClass, PROCESS__IMPORTS);
		createEReference(processEClass, PROCESS__EXTENSIONS);
		createEAttribute(processEClass, PROCESS__EXIT_ON_STANDARD_FAULT);
		createEReference(processEClass, PROCESS__MESSAGE_EXCHANGES);
		createEAttribute(processEClass, PROCESS__ABSTRACT_PROCESS_PROFILE);

		partnerLinkEClass = createEClass(PARTNER_LINK);
		createEAttribute(partnerLinkEClass, PARTNER_LINK__NAME);
		createEReference(partnerLinkEClass, PARTNER_LINK__MY_ROLE);
		createEReference(partnerLinkEClass, PARTNER_LINK__PARTNER_ROLE);
		createEReference(partnerLinkEClass, PARTNER_LINK__PARTNER_LINK_TYPE);
		createEAttribute(partnerLinkEClass,
				PARTNER_LINK__INITIALIZE_PARTNER_ROLE);

		faultHandlerEClass = createEClass(FAULT_HANDLER);
		createEReference(faultHandlerEClass, FAULT_HANDLER__CATCH);
		createEReference(faultHandlerEClass, FAULT_HANDLER__CATCH_ALL);

		activityEClass = createEClass(ACTIVITY);
		createEAttribute(activityEClass, ACTIVITY__NAME);
		createEAttribute(activityEClass, ACTIVITY__SUPPRESS_JOIN_FAILURE);
		createEReference(activityEClass, ACTIVITY__TARGETS);
		createEReference(activityEClass, ACTIVITY__SOURCES);

		correlationSetEClass = createEClass(CORRELATION_SET);
		createEAttribute(correlationSetEClass, CORRELATION_SET__NAME);
		createEReference(correlationSetEClass, CORRELATION_SET__PROPERTIES);

		invokeEClass = createEClass(INVOKE);
		createEReference(invokeEClass, INVOKE__OUTPUT_VARIABLE);
		createEReference(invokeEClass, INVOKE__INPUT_VARIABLE);
		createEReference(invokeEClass, INVOKE__COMPENSATION_HANDLER);
		createEReference(invokeEClass, INVOKE__FAULT_HANDLER);
		createEReference(invokeEClass, INVOKE__FROM_PARTS);
		createEReference(invokeEClass, INVOKE__TO_PARTS);
		createEReference(invokeEClass, INVOKE__FAILURE_HANDLING);

		linkEClass = createEClass(LINK);
		createEAttribute(linkEClass, LINK__NAME);
		createEReference(linkEClass, LINK__SOURCES);
		createEReference(linkEClass, LINK__TARGETS);

		catchEClass = createEClass(CATCH);
		createEAttribute(catchEClass, CATCH__FAULT_NAME);
		createEReference(catchEClass, CATCH__FAULT_VARIABLE);
		createEReference(catchEClass, CATCH__ACTIVITY);
		createEReference(catchEClass, CATCH__FAULT_MESSAGE_TYPE);
		createEReference(catchEClass, CATCH__FAULT_ELEMENT);

		replyEClass = createEClass(REPLY);
		createEAttribute(replyEClass, REPLY__FAULT_NAME);
		createEReference(replyEClass, REPLY__VARIABLE);
		createEReference(replyEClass, REPLY__TO_PARTS);
		createEReference(replyEClass, REPLY__MESSAGE_EXCHANGE);

		partnerActivityEClass = createEClass(PARTNER_ACTIVITY);
		createEReference(partnerActivityEClass, PARTNER_ACTIVITY__PARTNER_LINK);
		createEReference(partnerActivityEClass, PARTNER_ACTIVITY__CORRELATIONS);
		createEReference(partnerActivityEClass, PARTNER_ACTIVITY__PORT_TYPE);
		createEReference(partnerActivityEClass, PARTNER_ACTIVITY__OPERATION);

		receiveEClass = createEClass(RECEIVE);
		createEAttribute(receiveEClass, RECEIVE__CREATE_INSTANCE);
		createEReference(receiveEClass, RECEIVE__VARIABLE);
		createEReference(receiveEClass, RECEIVE__FROM_PARTS);
		createEReference(receiveEClass, RECEIVE__MESSAGE_EXCHANGE);

		exitEClass = createEClass(EXIT);

		throwEClass = createEClass(THROW);
		createEAttribute(throwEClass, THROW__FAULT_NAME);
		createEReference(throwEClass, THROW__FAULT_VARIABLE);

		waitEClass = createEClass(WAIT);
		createEReference(waitEClass, WAIT__FOR);
		createEReference(waitEClass, WAIT__UNTIL);

		emptyEClass = createEClass(EMPTY);

		sequenceEClass = createEClass(SEQUENCE);
		createEReference(sequenceEClass, SEQUENCE__ACTIVITIES);

		whileEClass = createEClass(WHILE);
		createEReference(whileEClass, WHILE__ACTIVITY);
		createEReference(whileEClass, WHILE__CONDITION);

		pickEClass = createEClass(PICK);
		createEAttribute(pickEClass, PICK__CREATE_INSTANCE);
		createEReference(pickEClass, PICK__MESSAGES);
		createEReference(pickEClass, PICK__ALARM);

		flowEClass = createEClass(FLOW);
		createEReference(flowEClass, FLOW__ACTIVITIES);
		createEReference(flowEClass, FLOW__LINKS);
		createEReference(flowEClass, FLOW__COMPLETION_CONDITION);

		onAlarmEClass = createEClass(ON_ALARM);
		createEReference(onAlarmEClass, ON_ALARM__ACTIVITY);
		createEReference(onAlarmEClass, ON_ALARM__FOR);
		createEReference(onAlarmEClass, ON_ALARM__UNTIL);
		createEReference(onAlarmEClass, ON_ALARM__REPEAT_EVERY);

		assignE4XEClass = createEClass(ASSIGN_E4X);
		createEAttribute(assignE4XEClass, ASSIGN_E4X__VALIDATE);
		createEReference(assignE4XEClass,
				ASSIGN_E4X__EXTENSION_ASSIGN_OPERATION);

		extensionAssignOperationEClass = createEClass(EXTENSION_ASSIGN_OPERATION);
		createEReference(extensionAssignOperationEClass,
				EXTENSION_ASSIGN_OPERATION__SNIPPET);

		snippetEClass = createEClass(SNIPPET);
		createEAttribute(snippetEClass, SNIPPET__BODY);

		assignEClass = createEClass(ASSIGN);
		createEReference(assignEClass, ASSIGN__COPY);
		createEAttribute(assignEClass, ASSIGN__VALIDATE);

		copyEClass = createEClass(COPY);
		createEReference(copyEClass, COPY__TO);
		createEReference(copyEClass, COPY__FROM);
		createEAttribute(copyEClass, COPY__KEEP_SRC_ELEMENT_NAME);
		createEAttribute(copyEClass, COPY__IGNORE_MISSING_FROM_DATA);

		extensionEClass = createEClass(EXTENSION);
		createEAttribute(extensionEClass, EXTENSION__NAMESPACE);
		createEAttribute(extensionEClass, EXTENSION__MUST_UNDERSTAND);

		scopeEClass = createEClass(SCOPE);
		createEAttribute(scopeEClass, SCOPE__ISOLATED);
		createEReference(scopeEClass, SCOPE__FAULT_HANDLERS);
		createEReference(scopeEClass, SCOPE__COMPENSATION_HANDLER);
		createEReference(scopeEClass, SCOPE__ACTIVITY);
		createEReference(scopeEClass, SCOPE__VARIABLES);
		createEReference(scopeEClass, SCOPE__CORRELATION_SETS);
		createEReference(scopeEClass, SCOPE__EVENT_HANDLERS);
		createEReference(scopeEClass, SCOPE__PARTNER_LINKS);
		createEReference(scopeEClass, SCOPE__TERMINATION_HANDLER);
		createEReference(scopeEClass, SCOPE__MESSAGE_EXCHANGES);
		createEAttribute(scopeEClass, SCOPE__EXIT_ON_STANDARD_FAULT);

		compensateScopeEClass = createEClass(COMPENSATE_SCOPE);
		createEReference(compensateScopeEClass, COMPENSATE_SCOPE__TARGET);

		compensationHandlerEClass = createEClass(COMPENSATION_HANDLER);
		createEReference(compensationHandlerEClass,
				COMPENSATION_HANDLER__ACTIVITY);

		abstractAssignBoundEClass = createEClass(ABSTRACT_ASSIGN_BOUND);
		createEReference(abstractAssignBoundEClass,
				ABSTRACT_ASSIGN_BOUND__VARIABLE);
		createEReference(abstractAssignBoundEClass, ABSTRACT_ASSIGN_BOUND__PART);
		createEReference(abstractAssignBoundEClass,
				ABSTRACT_ASSIGN_BOUND__PARTNER_LINK);
		createEReference(abstractAssignBoundEClass,
				ABSTRACT_ASSIGN_BOUND__PROPERTY);
		createEReference(abstractAssignBoundEClass,
				ABSTRACT_ASSIGN_BOUND__QUERY);
		createEReference(abstractAssignBoundEClass,
				ABSTRACT_ASSIGN_BOUND__EXPRESSION);

		toEClass = createEClass(TO);

		fromEClass = createEClass(FROM);
		createEAttribute(fromEClass, FROM__OPAQUE);
		createEAttribute(fromEClass, FROM__ENDPOINT_REFERENCE);
		createEAttribute(fromEClass, FROM__LITERAL);
		createEAttribute(fromEClass, FROM__UNSAFE_LITERAL);
		createEReference(fromEClass, FROM__SERVICE_REF);
		createEReference(fromEClass, FROM__TYPE);

		onMessageEClass = createEClass(ON_MESSAGE);
		createEReference(onMessageEClass, ON_MESSAGE__VARIABLE);
		createEReference(onMessageEClass, ON_MESSAGE__ACTIVITY);
		createEReference(onMessageEClass, ON_MESSAGE__PORT_TYPE);
		createEReference(onMessageEClass, ON_MESSAGE__PARTNER_LINK);
		createEReference(onMessageEClass, ON_MESSAGE__CORRELATIONS);
		createEReference(onMessageEClass, ON_MESSAGE__OPERATION);
		createEReference(onMessageEClass, ON_MESSAGE__FROM_PARTS);
		createEReference(onMessageEClass, ON_MESSAGE__MESSAGE_EXCHANGE);

		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__BODY);
		createEAttribute(expressionEClass, EXPRESSION__EXPRESSION_LANGUAGE);
		createEAttribute(expressionEClass, EXPRESSION__OPAQUE);

		booleanExpressionEClass = createEClass(BOOLEAN_EXPRESSION);

		correlationEClass = createEClass(CORRELATION);
		createEAttribute(correlationEClass, CORRELATION__INITIATE);
		createEAttribute(correlationEClass, CORRELATION__PATTERN);
		createEReference(correlationEClass, CORRELATION__SET);

		messageExchangeEClass = createEClass(MESSAGE_EXCHANGE);
		createEAttribute(messageExchangeEClass, MESSAGE_EXCHANGE__NAME);

		eventHandlerEClass = createEClass(EVENT_HANDLER);
		createEReference(eventHandlerEClass, EVENT_HANDLER__ALARM);
		createEReference(eventHandlerEClass, EVENT_HANDLER__EVENTS);

		sourceEClass = createEClass(SOURCE);
		createEReference(sourceEClass, SOURCE__LINK);
		createEReference(sourceEClass, SOURCE__ACTIVITY);
		createEReference(sourceEClass, SOURCE__TRANSITION_CONDITION);

		targetEClass = createEClass(TARGET);
		createEReference(targetEClass, TARGET__LINK);
		createEReference(targetEClass, TARGET__ACTIVITY);

		partnerLinksEClass = createEClass(PARTNER_LINKS);
		createEReference(partnerLinksEClass, PARTNER_LINKS__CHILDREN);

		messageExchangesEClass = createEClass(MESSAGE_EXCHANGES);
		createEReference(messageExchangesEClass, MESSAGE_EXCHANGES__CHILDREN);

		variablesEClass = createEClass(VARIABLES);
		createEReference(variablesEClass, VARIABLES__CHILDREN);

		correlationSetsEClass = createEClass(CORRELATION_SETS);
		createEReference(correlationSetsEClass, CORRELATION_SETS__CHILDREN);

		linksEClass = createEClass(LINKS);
		createEReference(linksEClass, LINKS__CHILDREN);

		catchAllEClass = createEClass(CATCH_ALL);
		createEReference(catchAllEClass, CATCH_ALL__ACTIVITY);

		correlationsEClass = createEClass(CORRELATIONS);
		createEReference(correlationsEClass, CORRELATIONS__CHILDREN);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEReference(variableEClass, VARIABLE__MESSAGE_TYPE);
		createEReference(variableEClass, VARIABLE__XSD_ELEMENT);
		createEReference(variableEClass, VARIABLE__TYPE);
		createEReference(variableEClass, VARIABLE__FROM);

		unknownExtensibilityAttributeEClass = createEClass(UNKNOWN_EXTENSIBILITY_ATTRIBUTE);

		onEventEClass = createEClass(ON_EVENT);
		createEReference(onEventEClass, ON_EVENT__ACTIVITY);
		createEReference(onEventEClass, ON_EVENT__VARIABLE);
		createEReference(onEventEClass, ON_EVENT__PARTNER_LINK);
		createEReference(onEventEClass, ON_EVENT__CORRELATIONS);
		createEReference(onEventEClass, ON_EVENT__OPERATION);
		createEReference(onEventEClass, ON_EVENT__PORT_TYPE);
		createEReference(onEventEClass, ON_EVENT__MESSAGE_TYPE);
		createEReference(onEventEClass, ON_EVENT__XSD_ELEMENT);
		createEReference(onEventEClass, ON_EVENT__CORRELATION_SETS);
		createEReference(onEventEClass, ON_EVENT__FROM_PARTS);
		createEReference(onEventEClass, ON_EVENT__MESSAGE_EXCHANGE);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__NAMESPACE);
		createEAttribute(importEClass, IMPORT__LOCATION);
		createEAttribute(importEClass, IMPORT__IMPORT_TYPE);

		rethrowEClass = createEClass(RETHROW);

		conditionEClass = createEClass(CONDITION);

		targetsEClass = createEClass(TARGETS);
		createEReference(targetsEClass, TARGETS__CHILDREN);
		createEReference(targetsEClass, TARGETS__JOIN_CONDITION);

		sourcesEClass = createEClass(SOURCES);
		createEReference(sourcesEClass, SOURCES__CHILDREN);

		queryEClass = createEClass(QUERY);
		createEAttribute(queryEClass, QUERY__VALUE);
		createEAttribute(queryEClass, QUERY__QUERY_LANGUAGE);

		serviceRefEClass = createEClass(SERVICE_REF);
		createEAttribute(serviceRefEClass, SERVICE_REF__REFERENCE_SCHEME);
		createEAttribute(serviceRefEClass, SERVICE_REF__VALUE);

		extensionsEClass = createEClass(EXTENSIONS);
		createEReference(extensionsEClass, EXTENSIONS__CHILDREN);

		extensionActivityEClass = createEClass(EXTENSION_ACTIVITY);

		fromPartEClass = createEClass(FROM_PART);
		createEReference(fromPartEClass, FROM_PART__TO_VARIABLE);
		createEReference(fromPartEClass, FROM_PART__PART);

		toPartEClass = createEClass(TO_PART);
		createEReference(toPartEClass, TO_PART__FROM_VARIABLE);
		createEReference(toPartEClass, TO_PART__PART);

		opaqueActivityEClass = createEClass(OPAQUE_ACTIVITY);

		forEachEClass = createEClass(FOR_EACH);
		createEReference(forEachEClass, FOR_EACH__START_COUNTER_VALUE);
		createEReference(forEachEClass, FOR_EACH__FINAL_COUNTER_VALUE);
		createEAttribute(forEachEClass, FOR_EACH__PARALLEL);
		createEReference(forEachEClass, FOR_EACH__COUNTER_NAME);
		createEReference(forEachEClass, FOR_EACH__COMPLETION_CONDITION);
		createEReference(forEachEClass, FOR_EACH__ACTIVITY);

		repeatUntilEClass = createEClass(REPEAT_UNTIL);
		createEReference(repeatUntilEClass, REPEAT_UNTIL__ACTIVITY);
		createEReference(repeatUntilEClass, REPEAT_UNTIL__CONDITION);

		terminationHandlerEClass = createEClass(TERMINATION_HANDLER);
		createEReference(terminationHandlerEClass,
				TERMINATION_HANDLER__ACTIVITY);

		validateEClass = createEClass(VALIDATE);
		createEReference(validateEClass, VALIDATE__VARIABLES);

		ifEClass = createEClass(IF);
		createEReference(ifEClass, IF__CONDITION);
		createEReference(ifEClass, IF__ELSE_IF);
		createEReference(ifEClass, IF__ELSE);
		createEReference(ifEClass, IF__ACTIVITY);

		elseIfEClass = createEClass(ELSE_IF);
		createEReference(elseIfEClass, ELSE_IF__CONDITION);
		createEReference(elseIfEClass, ELSE_IF__ACTIVITY);

		elseEClass = createEClass(ELSE);
		createEReference(elseEClass, ELSE__ACTIVITY);

		completionConditionEClass = createEClass(COMPLETION_CONDITION);
		createEReference(completionConditionEClass,
				COMPLETION_CONDITION__BRANCHES);

		branchesEClass = createEClass(BRANCHES);
		createEAttribute(branchesEClass,
				BRANCHES__COUNT_COMPLETED_BRANCHES_ONLY);

		bpelExtensibleElementEClass = createEClass(BPEL_EXTENSIBLE_ELEMENT);
		createEReference(bpelExtensibleElementEClass,
				BPEL_EXTENSIBLE_ELEMENT__DOCUMENTATION);

		documentationEClass = createEClass(DOCUMENTATION);
		createEAttribute(documentationEClass, DOCUMENTATION__LANG);
		createEAttribute(documentationEClass, DOCUMENTATION__SOURCE);
		createEAttribute(documentationEClass, DOCUMENTATION__VALUE);

		compensateEClass = createEClass(COMPENSATE);

		fromPartsEClass = createEClass(FROM_PARTS);
		createEReference(fromPartsEClass, FROM_PARTS__CHILDREN);

		toPartsEClass = createEClass(TO_PARTS);
		createEReference(toPartsEClass, TO_PARTS__CHILDREN);

		failureHandlingEClass = createEClass(FAILURE_HANDLING);
		createEReference(failureHandlingEClass,
				FAILURE_HANDLING__FAULT_ON_FAILURE);
		createEReference(failureHandlingEClass, FAILURE_HANDLING__RETRY_FOR);
		createEReference(failureHandlingEClass, FAILURE_HANDLING__RETRY_DELAY);

		faultOnFailureEClass = createEClass(FAULT_ON_FAILURE);
		createEAttribute(faultOnFailureEClass, FAULT_ON_FAILURE__VALUE);

		retryForEClass = createEClass(RETRY_FOR);
		createEAttribute(retryForEClass, RETRY_FOR__VALUE);

		retryDelayEClass = createEClass(RETRY_DELAY);
		createEAttribute(retryDelayEClass, RETRY_DELAY__VALUE);

		// Create enums
		correlationPatternEEnum = createEEnum(CORRELATION_PATTERN);
		endpointReferenceRoleEEnum = createEEnum(ENDPOINT_REFERENCE_ROLE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		PartnerlinktypePackage thePartnerlinktypePackage = (PartnerlinktypePackage) EPackage.Registry.INSTANCE
				.getEPackage(PartnerlinktypePackage.eNS_URI);
		MessagepropertiesPackage theMessagepropertiesPackage = (MessagepropertiesPackage) EPackage.Registry.INSTANCE
				.getEPackage(MessagepropertiesPackage.eNS_URI);
		WSDLPackage theWSDLPackage = (WSDLPackage) EPackage.Registry.INSTANCE
				.getEPackage(WSDLPackage.eNS_URI);
		XSDPackage theXSDPackage = (XSDPackage) EPackage.Registry.INSTANCE
				.getEPackage(XSDPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		processEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		partnerLinkEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		faultHandlerEClass.getESuperTypes()
				.add(this.getBPELExtensibleElement());
		activityEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		correlationSetEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		invokeEClass.getESuperTypes().add(this.getPartnerActivity());
		linkEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		catchEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		replyEClass.getESuperTypes().add(this.getPartnerActivity());
		replyEClass.getESuperTypes().add(this.getActivity());
		partnerActivityEClass.getESuperTypes().add(this.getActivity());
		receiveEClass.getESuperTypes().add(this.getPartnerActivity());
		exitEClass.getESuperTypes().add(this.getActivity());
		throwEClass.getESuperTypes().add(this.getActivity());
		waitEClass.getESuperTypes().add(this.getActivity());
		emptyEClass.getESuperTypes().add(this.getActivity());
		sequenceEClass.getESuperTypes().add(this.getActivity());
		whileEClass.getESuperTypes().add(this.getActivity());
		pickEClass.getESuperTypes().add(this.getActivity());
		flowEClass.getESuperTypes().add(this.getActivity());
		onAlarmEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		assignE4XEClass.getESuperTypes().add(this.getActivity());
		extensionAssignOperationEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		snippetEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		assignEClass.getESuperTypes().add(this.getActivity());
		copyEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		extensionEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		scopeEClass.getESuperTypes().add(this.getActivity());
		compensateScopeEClass.getESuperTypes().add(this.getActivity());
		compensationHandlerEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		toEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		toEClass.getESuperTypes().add(this.getAbstractAssignBound());
		fromEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		fromEClass.getESuperTypes().add(this.getAbstractAssignBound());
		onMessageEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		expressionEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibilityElement());
		booleanExpressionEClass.getESuperTypes().add(this.getExpression());
		correlationEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		messageExchangeEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		eventHandlerEClass.getESuperTypes()
				.add(this.getBPELExtensibleElement());
		sourceEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		targetEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		partnerLinksEClass.getESuperTypes()
				.add(this.getBPELExtensibleElement());
		messageExchangesEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		variablesEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		correlationSetsEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		linksEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		catchAllEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		correlationsEClass.getESuperTypes()
				.add(this.getBPELExtensibleElement());
		variableEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		unknownExtensibilityAttributeEClass.getESuperTypes().add(
				theWSDLPackage.getUnknownExtensibilityElement());
		onEventEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		importEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		rethrowEClass.getESuperTypes().add(this.getActivity());
		conditionEClass.getESuperTypes().add(this.getExpression());
		targetsEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		sourcesEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		queryEClass.getESuperTypes().add(theWSDLPackage.getWSDLElement());
		serviceRefEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibleElement());
		extensionsEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		extensionActivityEClass.getESuperTypes().add(this.getActivity());
		fromPartEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		toPartEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		opaqueActivityEClass.getESuperTypes().add(this.getActivity());
		forEachEClass.getESuperTypes().add(this.getActivity());
		repeatUntilEClass.getESuperTypes().add(this.getActivity());
		terminationHandlerEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		validateEClass.getESuperTypes().add(this.getActivity());
		ifEClass.getESuperTypes().add(this.getActivity());
		elseIfEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		elseEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		completionConditionEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		branchesEClass.getESuperTypes().add(this.getExpression());
		bpelExtensibleElementEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibleElement());
		documentationEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		compensateEClass.getESuperTypes().add(this.getActivity());
		fromPartsEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		toPartsEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		failureHandlingEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		faultOnFailureEClass.getESuperTypes().add(
				this.getBPELExtensibleElement());
		retryForEClass.getESuperTypes().add(this.getBPELExtensibleElement());
		retryDelayEClass.getESuperTypes().add(this.getBPELExtensibleElement());

		// Initialize classes and features; add operations and parameters
		initEClass(
				processEClass,
				org.eclipse.bpel.model.Process.class,
				"Process", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getProcess_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProcess_TargetNamespace(),
				ecorePackage.getEString(),
				"targetNamespace", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProcess_QueryLanguage(),
				ecorePackage.getEString(),
				"queryLanguage", "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0", 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getProcess_ExpressionLanguage(),
				ecorePackage.getEString(),
				"expressionLanguage", "urn:oasis:names:tc:wsbpel:2.0:sublang:xpath1.0", 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getProcess_SuppressJoinFailure(),
				ecorePackage.getEBooleanObject(),
				"suppressJoinFailure", "false", 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getProcess_VariableAccessSerializable(),
				ecorePackage.getEBooleanObject(),
				"variableAccessSerializable", "false", 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getProcess_PartnerLinks(),
				this.getPartnerLinks(),
				null,
				"partnerLinks", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_Variables(),
				this.getVariables(),
				null,
				"variables", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_FaultHandlers(),
				this.getFaultHandler(),
				null,
				"faultHandlers", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_EventHandlers(),
				this.getEventHandler(),
				null,
				"eventHandlers", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_CorrelationSets(),
				this.getCorrelationSets(),
				null,
				"correlationSets", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_Imports(),
				this.getImport(),
				null,
				"imports", null, 0, -1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getProcess_Extensions(),
				this.getExtensions(),
				null,
				"extensions", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProcess_ExitOnStandardFault(),
				theEcorePackage.getEBooleanObject(),
				"exitOnStandardFault", "true", 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getProcess_MessageExchanges(),
				this.getMessageExchanges(),
				null,
				"messageExchanges", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProcess_AbstractProcessProfile(),
				theEcorePackage.getEString(),
				"abstractProcessProfile", null, 0, 1, org.eclipse.bpel.model.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				partnerLinkEClass,
				PartnerLink.class,
				"PartnerLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPartnerLink_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, PartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerLink_MyRole(),
				thePartnerlinktypePackage.getRole(),
				null,
				"myRole", null, 0, 1, PartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerLink_PartnerRole(),
				thePartnerlinktypePackage.getRole(),
				null,
				"partnerRole", null, 0, 1, PartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerLink_PartnerLinkType(),
				thePartnerlinktypePackage.getPartnerLinkType(),
				null,
				"PartnerLinkType", null, 0, 1, PartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPartnerLink_InitializePartnerRole(),
				theEcorePackage.getEBooleanObject(),
				"initializePartnerRole", null, 0, 1, PartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				faultHandlerEClass,
				FaultHandler.class,
				"FaultHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFaultHandler_Catch(),
				this.getCatch(),
				null,
				"catch", null, 0, -1, FaultHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFaultHandler_CatchAll(),
				this.getCatchAll(),
				null,
				"catchAll", null, 0, 1, FaultHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				activityEClass,
				Activity.class,
				"Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getActivity_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getActivity_SuppressJoinFailure(),
				ecorePackage.getEBooleanObject(),
				"suppressJoinFailure", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getActivity_Targets(),
				this.getTargets(),
				null,
				"targets", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getActivity_Sources(),
				this.getSources(),
				null,
				"sources", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				correlationSetEClass,
				CorrelationSet.class,
				"CorrelationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCorrelationSet_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, CorrelationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCorrelationSet_Properties(),
				theMessagepropertiesPackage.getProperty(),
				null,
				"properties", null, 0, -1, CorrelationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				invokeEClass,
				Invoke.class,
				"Invoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getInvoke_OutputVariable(),
				this.getVariable(),
				null,
				"outputVariable", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getInvoke_InputVariable(),
				this.getVariable(),
				null,
				"inputVariable", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getInvoke_CompensationHandler(),
				this.getCompensationHandler(),
				null,
				"compensationHandler", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getInvoke_FaultHandler(),
				this.getFaultHandler(),
				null,
				"faultHandler", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getInvoke_FromParts(),
				this.getFromParts(),
				null,
				"fromParts", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getInvoke_ToParts(),
				this.getToParts(),
				null,
				"toParts", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getInvoke_FailureHandling(),
				this.getFailureHandling(),
				null,
				"failureHandling", null, 0, 1, Invoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				linkEClass,
				Link.class,
				"Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getLink_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getLink_Sources(),
				this.getSource(),
				this.getSource_Link(),
				"sources", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getLink_Targets(),
				this.getTarget(),
				this.getTarget_Link(),
				"targets", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				catchEClass,
				Catch.class,
				"Catch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCatch_FaultName(),
				theWSDLPackage.getQName(),
				"faultName", null, 0, 1, Catch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCatch_FaultVariable(),
				this.getVariable(),
				null,
				"faultVariable", null, 0, 1, Catch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCatch_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, Catch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCatch_FaultMessageType(),
				theWSDLPackage.getMessage(),
				null,
				"faultMessageType", null, 0, 1, Catch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCatch_FaultElement(),
				theXSDPackage.getXSDElementDeclaration(),
				null,
				"faultElement", null, 0, 1, Catch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				replyEClass,
				Reply.class,
				"Reply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getReply_FaultName(),
				theWSDLPackage.getQName(),
				"faultName", null, 0, 1, Reply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getReply_Variable(),
				this.getVariable(),
				null,
				"variable", null, 0, 1, Reply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getReply_ToParts(),
				this.getToParts(),
				null,
				"toParts", null, 0, 1, Reply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getReply_MessageExchange(),
				this.getMessageExchange(),
				null,
				"messageExchange", null, 1, 1, Reply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				partnerActivityEClass,
				PartnerActivity.class,
				"PartnerActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getPartnerActivity_PartnerLink(),
				this.getPartnerLink(),
				null,
				"partnerLink", null, 1, 1, PartnerActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerActivity_Correlations(),
				this.getCorrelations(),
				null,
				"correlations", null, 0, 1, PartnerActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerActivity_PortType(),
				theWSDLPackage.getPortType(),
				null,
				"portType", null, 1, 1, PartnerActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerActivity_Operation(),
				theWSDLPackage.getOperation(),
				null,
				"operation", null, 1, 1, PartnerActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				receiveEClass,
				Receive.class,
				"Receive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getReceive_CreateInstance(),
				ecorePackage.getEBooleanObject(),
				"createInstance", "false", 0, 1, Receive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getReceive_Variable(),
				this.getVariable(),
				null,
				"variable", null, 1, 1, Receive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getReceive_FromParts(),
				this.getFromParts(),
				null,
				"fromParts", null, 0, 1, Receive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getReceive_MessageExchange(),
				this.getMessageExchange(),
				null,
				"messageExchange", null, 1, 1, Receive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				exitEClass,
				Exit.class,
				"Exit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				throwEClass,
				Throw.class,
				"Throw", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getThrow_FaultName(),
				theWSDLPackage.getQName(),
				"faultName", null, 0, 1, Throw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getThrow_FaultVariable(),
				this.getVariable(),
				null,
				"faultVariable", null, 0, 1, Throw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				waitEClass,
				Wait.class,
				"Wait", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getWait_For(),
				this.getExpression(),
				null,
				"for", null, 0, 1, Wait.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getWait_Until(),
				this.getExpression(),
				null,
				"until", null, 0, 1, Wait.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				emptyEClass,
				Empty.class,
				"Empty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				sequenceEClass,
				Sequence.class,
				"Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getSequence_Activities(),
				this.getActivity(),
				null,
				"activities", null, 1, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				whileEClass,
				While.class,
				"While", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getWhile_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getWhile_Condition(),
				this.getCondition(),
				null,
				"condition", null, 1, 1, While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				pickEClass,
				Pick.class,
				"Pick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPick_CreateInstance(),
				ecorePackage.getEBooleanObject(),
				"createInstance", "false", 0, 1, Pick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getPick_Messages(),
				this.getOnMessage(),
				null,
				"messages", null, 1, -1, Pick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPick_Alarm(),
				this.getOnAlarm(),
				null,
				"alarm", null, 0, -1, Pick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				flowEClass,
				Flow.class,
				"Flow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFlow_Activities(),
				this.getActivity(),
				null,
				"activities", null, 1, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFlow_Links(),
				this.getLinks(),
				null,
				"links", null, 0, 1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFlow_CompletionCondition(),
				this.getCompletionCondition(),
				null,
				"completionCondition", null, 0, 1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				onAlarmEClass,
				OnAlarm.class,
				"OnAlarm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getOnAlarm_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, OnAlarm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnAlarm_For(),
				this.getExpression(),
				null,
				"for", null, 0, 1, OnAlarm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnAlarm_Until(),
				this.getExpression(),
				null,
				"until", null, 0, 1, OnAlarm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnAlarm_RepeatEvery(),
				this.getExpression(),
				null,
				"repeatEvery", null, 0, 1, OnAlarm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				assignE4XEClass,
				AssignE4X.class,
				"AssignE4X", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getAssignE4X_Validate(),
				theEcorePackage.getEBooleanObject(),
				"Validate", "", 1, 1, AssignE4X.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getAssignE4X_ExtensionAssignOperation(),
				this.getExtensionAssignOperation(),
				null,
				"extensionAssignOperation", null, 1, -1, AssignE4X.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				extensionAssignOperationEClass,
				ExtensionAssignOperation.class,
				"ExtensionAssignOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getExtensionAssignOperation_Snippet(),
				this.getSnippet(),
				null,
				"snippet", null, 1, 1, ExtensionAssignOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				snippetEClass,
				Snippet.class,
				"Snippet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getSnippet_Body(),
				theEcorePackage.getEJavaObject(),
				"body", null, 1, 1, Snippet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				assignEClass,
				Assign.class,
				"Assign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getAssign_Copy(),
				this.getCopy(),
				null,
				"copy", null, 1, -1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAssign_Validate(),
				theEcorePackage.getEBooleanObject(),
				"validate", "false", 0, 1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				copyEClass,
				Copy.class,
				"Copy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCopy_To(),
				this.getTo(),
				null,
				"to", null, 1, 1, Copy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCopy_From(),
				this.getFrom(),
				null,
				"from", null, 1, 1, Copy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCopy_KeepSrcElementName(),
				ecorePackage.getEBooleanObject(),
				"keepSrcElementName", "false", 0, 1, Copy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getCopy_IgnoreMissingFromData(),
				ecorePackage.getEBooleanObject(),
				"ignoreMissingFromData", "false", 0, 1, Copy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				extensionEClass,
				Extension.class,
				"Extension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getExtension_Namespace(),
				ecorePackage.getEString(),
				"namespace", null, 0, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getExtension_MustUnderstand(),
				ecorePackage.getEBooleanObject(),
				"mustUnderstand", "false", 0, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				scopeEClass,
				Scope.class,
				"Scope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getScope_Isolated(),
				ecorePackage.getEBooleanObject(),
				"isolated", "false", 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getScope_FaultHandlers(),
				this.getFaultHandler(),
				null,
				"faultHandlers", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_CompensationHandler(),
				this.getCompensationHandler(),
				null,
				"compensationHandler", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_Variables(),
				this.getVariables(),
				null,
				"variables", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_CorrelationSets(),
				this.getCorrelationSets(),
				null,
				"correlationSets", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_EventHandlers(),
				this.getEventHandler(),
				null,
				"eventHandlers", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_PartnerLinks(),
				this.getPartnerLinks(),
				null,
				"partnerLinks", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_TerminationHandler(),
				this.getTerminationHandler(),
				null,
				"terminationHandler", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getScope_MessageExchanges(),
				this.getMessageExchanges(),
				null,
				"messageExchanges", null, 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getScope_ExitOnStandardFault(),
				ecorePackage.getEBooleanObject(),
				"exitOnStandardFault", "false", 0, 1, Scope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				compensateScopeEClass,
				CompensateScope.class,
				"CompensateScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCompensateScope_Target(),
				this.getActivity(),
				null,
				"target", null, 0, 1, CompensateScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				compensationHandlerEClass,
				CompensationHandler.class,
				"CompensationHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCompensationHandler_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, CompensationHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				abstractAssignBoundEClass,
				AbstractAssignBound.class,
				"AbstractAssignBound", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getAbstractAssignBound_Variable(),
				this.getVariable(),
				null,
				"variable", null, 0, 1, AbstractAssignBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getAbstractAssignBound_Part(),
				theWSDLPackage.getPart(),
				null,
				"part", null, 0, 1, AbstractAssignBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getAbstractAssignBound_PartnerLink(),
				this.getPartnerLink(),
				null,
				"partnerLink", null, 0, 1, AbstractAssignBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getAbstractAssignBound_Property(),
				theMessagepropertiesPackage.getProperty(),
				null,
				"property", null, 0, 1, AbstractAssignBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getAbstractAssignBound_Query(),
				this.getQuery(),
				null,
				"query", null, 0, 1, AbstractAssignBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getAbstractAssignBound_Expression(),
				this.getExpression(),
				null,
				"expression", null, 0, 1, AbstractAssignBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(toEClass, To.class,
				"To", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				fromEClass,
				From.class,
				"From", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getFrom_Opaque(),
				ecorePackage.getEBooleanObject(),
				"opaque", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFrom_EndpointReference(),
				this.getEndpointReferenceRole(),
				"endpointReference", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFrom_Literal(),
				ecorePackage.getEString(),
				"literal", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getFrom_UnsafeLiteral(),
				ecorePackage.getEBooleanObject(),
				"unsafeLiteral", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFrom_ServiceRef(),
				this.getServiceRef(),
				null,
				"serviceRef", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFrom_Type(),
				theXSDPackage.getXSDTypeDefinition(),
				null,
				"type", null, 0, 1, From.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				onMessageEClass,
				OnMessage.class,
				"OnMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getOnMessage_Variable(),
				this.getVariable(),
				null,
				"variable", null, 0, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_Activity(),
				this.getActivity(),
				null,
				"activity", null, 0, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_PortType(),
				theWSDLPackage.getPortType(),
				null,
				"portType", null, 1, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_PartnerLink(),
				this.getPartnerLink(),
				null,
				"partnerLink", null, 1, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_Correlations(),
				this.getCorrelations(),
				null,
				"correlations", null, 0, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_Operation(),
				theWSDLPackage.getOperation(),
				null,
				"operation", null, 1, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_FromParts(),
				this.getFromParts(),
				null,
				"fromParts", null, 0, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnMessage_MessageExchange(),
				this.getMessageExchange(),
				null,
				"messageExchange", null, 1, 1, OnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				expressionEClass,
				Expression.class,
				"Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getExpression_Body(),
				theEcorePackage.getEJavaObject(),
				"body", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getExpression_ExpressionLanguage(),
				ecorePackage.getEString(),
				"expressionLanguage", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getExpression_Opaque(),
				theEcorePackage.getEBooleanObject(),
				"opaque", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				booleanExpressionEClass,
				BooleanExpression.class,
				"BooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				correlationEClass,
				Correlation.class,
				"Correlation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCorrelation_Initiate(),
				ecorePackage.getEString(),
				"initiate", "no", 0, 1, Correlation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getCorrelation_Pattern(),
				this.getCorrelationPattern(),
				"pattern", null, 0, 1, Correlation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCorrelation_Set(),
				this.getCorrelationSet(),
				null,
				"set", null, 1, 1, Correlation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				messageExchangeEClass,
				MessageExchange.class,
				"MessageExchange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMessageExchange_Name(),
				ecorePackage.getEString(),
				"name", "", 0, 1, MessageExchange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				eventHandlerEClass,
				EventHandler.class,
				"EventHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getEventHandler_Alarm(),
				this.getOnAlarm(),
				null,
				"alarm", null, 0, -1, EventHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getEventHandler_Events(),
				this.getOnEvent(),
				null,
				"events", null, 0, -1, EventHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				sourceEClass,
				Source.class,
				"Source", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getSource_Link(),
				this.getLink(),
				this.getLink_Sources(),
				"Link", null, 1, 1, Source.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getSource_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, Source.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getSource_TransitionCondition(),
				this.getCondition(),
				null,
				"transitionCondition", null, 0, 1, Source.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				targetEClass,
				Target.class,
				"Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTarget_Link(),
				this.getLink(),
				this.getLink_Targets(),
				"Link", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTarget_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				partnerLinksEClass,
				PartnerLinks.class,
				"PartnerLinks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getPartnerLinks_Children(),
				this.getPartnerLink(),
				null,
				"children", null, 0, -1, PartnerLinks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				messageExchangesEClass,
				MessageExchanges.class,
				"MessageExchanges", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getMessageExchanges_Children(),
				this.getMessageExchange(),
				null,
				"children", null, 0, -1, MessageExchanges.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				variablesEClass,
				Variables.class,
				"Variables", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getVariables_Children(),
				this.getVariable(),
				null,
				"children", null, 0, -1, Variables.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				correlationSetsEClass,
				CorrelationSets.class,
				"CorrelationSets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCorrelationSets_Children(),
				this.getCorrelationSet(),
				null,
				"children", null, 0, -1, CorrelationSets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				linksEClass,
				Links.class,
				"Links", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getLinks_Children(),
				this.getLink(),
				null,
				"children", null, 0, -1, Links.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				catchAllEClass,
				CatchAll.class,
				"CatchAll", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCatchAll_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, CatchAll.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				correlationsEClass,
				Correlations.class,
				"Correlations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCorrelations_Children(),
				this.getCorrelation(),
				null,
				"children", null, 0, -1, Correlations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				variableEClass,
				Variable.class,
				"Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getVariable_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getVariable_MessageType(),
				theWSDLPackage.getMessage(),
				null,
				"messageType", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getVariable_XSDElement(),
				theXSDPackage.getXSDElementDeclaration(),
				null,
				"XSDElement", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getVariable_Type(),
				theXSDPackage.getXSDTypeDefinition(),
				null,
				"type", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getVariable_From(),
				this.getFrom(),
				null,
				"from", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				unknownExtensibilityAttributeEClass,
				UnknownExtensibilityAttribute.class,
				"UnknownExtensibilityAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				onEventEClass,
				OnEvent.class,
				"OnEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getOnEvent_Activity(),
				this.getActivity(),
				null,
				"activity", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_Variable(),
				this.getVariable(),
				null,
				"variable", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_PartnerLink(),
				this.getPartnerLink(),
				null,
				"partnerLink", null, 1, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_Correlations(),
				this.getCorrelations(),
				null,
				"correlations", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_Operation(),
				theWSDLPackage.getOperation(),
				null,
				"operation", null, 1, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_PortType(),
				theWSDLPackage.getPortType(),
				null,
				"portType", null, 1, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_MessageType(),
				theWSDLPackage.getMessage(),
				null,
				"messageType", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_XSDElement(),
				theXSDPackage.getXSDElementDeclaration(),
				null,
				"XSDElement", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_CorrelationSets(),
				this.getCorrelationSets(),
				null,
				"correlationSets", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_FromParts(),
				this.getFromParts(),
				null,
				"fromParts", null, 0, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOnEvent_MessageExchange(),
				this.getMessageExchange(),
				null,
				"messageExchange", null, 1, 1, OnEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				importEClass,
				Import.class,
				"Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getImport_Namespace(),
				ecorePackage.getEString(),
				"namespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getImport_Location(),
				ecorePackage.getEString(),
				"location", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getImport_ImportType(),
				ecorePackage.getEString(),
				"importType", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				rethrowEClass,
				Rethrow.class,
				"Rethrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				conditionEClass,
				Condition.class,
				"Condition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				targetsEClass,
				Targets.class,
				"Targets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTargets_Children(),
				this.getTarget(),
				null,
				"children", null, 0, -1, Targets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTargets_JoinCondition(),
				this.getCondition(),
				null,
				"joinCondition", null, 0, 1, Targets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				sourcesEClass,
				Sources.class,
				"Sources", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getSources_Children(),
				this.getSource(),
				null,
				"children", null, 0, -1, Sources.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				queryEClass,
				Query.class,
				"Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getQuery_Value(),
				ecorePackage.getEString(),
				"value", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuery_QueryLanguage(),
				ecorePackage.getEString(),
				"queryLanguage", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				serviceRefEClass,
				ServiceRef.class,
				"ServiceRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getServiceRef_ReferenceScheme(),
				ecorePackage.getEString(),
				"referenceScheme", null, 0, 1, ServiceRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getServiceRef_Value(),
				theEcorePackage.getEJavaObject(),
				"value", null, 0, 1, ServiceRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				extensionsEClass,
				Extensions.class,
				"Extensions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getExtensions_Children(),
				this.getExtension(),
				null,
				"children", null, 0, -1, Extensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				extensionActivityEClass,
				ExtensionActivity.class,
				"ExtensionActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				fromPartEClass,
				FromPart.class,
				"FromPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFromPart_ToVariable(),
				this.getVariable(),
				null,
				"toVariable", null, 0, 1, FromPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFromPart_Part(),
				theWSDLPackage.getPart(),
				null,
				"part", null, 0, 1, FromPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				toPartEClass,
				ToPart.class,
				"ToPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getToPart_FromVariable(),
				this.getVariable(),
				null,
				"fromVariable", null, 0, 1, ToPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getToPart_Part(),
				theWSDLPackage.getPart(),
				null,
				"part", null, 0, 1, ToPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				opaqueActivityEClass,
				OpaqueActivity.class,
				"OpaqueActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				forEachEClass,
				ForEach.class,
				"ForEach", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getForEach_StartCounterValue(),
				this.getExpression(),
				null,
				"startCounterValue", null, 1, 1, ForEach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getForEach_FinalCounterValue(),
				this.getExpression(),
				null,
				"finalCounterValue", null, 1, 1, ForEach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getForEach_Parallel(),
				theEcorePackage.getEBooleanObject(),
				"parallel", "false", 1, 1, ForEach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getForEach_CounterName(),
				this.getVariable(),
				null,
				"counterName", null, 1, 1, ForEach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getForEach_CompletionCondition(),
				this.getCompletionCondition(),
				null,
				"completionCondition", null, 0, 1, ForEach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getForEach_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, ForEach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				repeatUntilEClass,
				RepeatUntil.class,
				"RepeatUntil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getRepeatUntil_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, RepeatUntil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getRepeatUntil_Condition(),
				this.getCondition(),
				null,
				"condition", null, 1, 1, RepeatUntil.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				terminationHandlerEClass,
				TerminationHandler.class,
				"TerminationHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTerminationHandler_Activity(),
				this.getActivity(),
				null,
				"activity", null, 0, 1, TerminationHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				validateEClass,
				Validate.class,
				"Validate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getValidate_Variables(),
				this.getVariable(),
				null,
				"variables", null, 0, -1, Validate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(ifEClass, If.class,
				"If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getIf_Condition(),
				this.getCondition(),
				null,
				"condition", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getIf_ElseIf(),
				this.getElseIf(),
				null,
				"elseIf", null, 0, -1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getIf_Else(),
				this.getElse(),
				null,
				"else", null, 0, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getIf_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				elseIfEClass,
				ElseIf.class,
				"ElseIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getElseIf_Condition(),
				this.getCondition(),
				null,
				"condition", null, 0, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getElseIf_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				elseEClass,
				Else.class,
				"Else", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getElse_Activity(),
				this.getActivity(),
				null,
				"activity", null, 1, 1, Else.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				completionConditionEClass,
				CompletionCondition.class,
				"CompletionCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCompletionCondition_Branches(),
				this.getBranches(),
				null,
				"branches", null, 0, 1, CompletionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				branchesEClass,
				Branches.class,
				"Branches", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getBranches_CountCompletedBranchesOnly(),
				theEcorePackage.getEBooleanObject(),
				"countCompletedBranchesOnly", "false", 0, 1, Branches.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(
				bpelExtensibleElementEClass,
				BPELExtensibleElement.class,
				"BPELExtensibleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getBPELExtensibleElement_Documentation(),
				this.getDocumentation(),
				null,
				"documentation", null, 0, 1, BPELExtensibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				documentationEClass,
				Documentation.class,
				"Documentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getDocumentation_Lang(),
				theEcorePackage.getEString(),
				"lang", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDocumentation_Source(),
				theEcorePackage.getEString(),
				"source", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDocumentation_Value(),
				theEcorePackage.getEString(),
				"value", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				compensateEClass,
				Compensate.class,
				"Compensate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
				fromPartsEClass,
				FromParts.class,
				"FromParts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFromParts_Children(),
				this.getFromPart(),
				null,
				"children", null, 0, -1, FromParts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				toPartsEClass,
				ToParts.class,
				"ToParts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getToParts_Children(),
				this.getToPart(),
				null,
				"children", null, 0, -1, ToParts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				failureHandlingEClass,
				FailureHandling.class,
				"FailureHandling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getFailureHandling_FaultOnFailure(),
				this.getFaultOnFailure(),
				null,
				"faultOnFailure", null, 0, 1, FailureHandling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFailureHandling_RetryFor(),
				this.getRetryFor(),
				null,
				"retryFor", null, 0, 1, FailureHandling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getFailureHandling_RetryDelay(),
				this.getRetryDelay(),
				null,
				"retryDelay", null, 0, 1, FailureHandling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				faultOnFailureEClass,
				FaultOnFailure.class,
				"FaultOnFailure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getFaultOnFailure_Value(),
				theEcorePackage.getEBoolean(),
				"value", null, 0, 1, FaultOnFailure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				retryForEClass,
				RetryFor.class,
				"RetryFor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRetryFor_Value(),
				theEcorePackage.getEInt(),
				"value", null, 0, 1, RetryFor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				retryDelayEClass,
				RetryDelay.class,
				"RetryDelay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRetryDelay_Value(),
				theEcorePackage.getEInt(),
				"value", null, 0, 1, RetryDelay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(correlationPatternEEnum, CorrelationPattern.class,
				"CorrelationPattern"); //$NON-NLS-1$
		addEEnumLiteral(correlationPatternEEnum,
				CorrelationPattern.REQUEST_LITERAL);
		addEEnumLiteral(correlationPatternEEnum,
				CorrelationPattern.RESPONSE_LITERAL);
		addEEnumLiteral(correlationPatternEEnum,
				CorrelationPattern.REQUESTRESPONSE_LITERAL);

		initEEnum(endpointReferenceRoleEEnum, EndpointReferenceRole.class,
				"EndpointReferenceRole"); //$NON-NLS-1$
		addEEnumLiteral(endpointReferenceRoleEEnum,
				EndpointReferenceRole.MY_ROLE_LITERAL);
		addEEnumLiteral(endpointReferenceRoleEEnum,
				EndpointReferenceRole.PARTNER_ROLE_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //BPELPackageImpl
