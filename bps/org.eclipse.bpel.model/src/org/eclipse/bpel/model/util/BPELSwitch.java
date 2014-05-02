/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.model.util;

import java.util.List;

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
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.FaultHandler;
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
import org.eclipse.emf.ecore.EObject;

import org.eclipse.wst.wsdl.ExtensibleElement;
import org.eclipse.wst.wsdl.UnknownExtensibilityElement;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultOnFailure;
import org.eclipse.bpel.model.RetryDelay;
import org.eclipse.bpel.model.RetryFor;

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
 * @see org.eclipse.bpel.model.BPELPackage
 * @generated
 */
public class BPELSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BPELPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPELSwitch() {
		if (modelPackage == null) {
			modelPackage = BPELPackage.eINSTANCE;
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
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
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
		case BPELPackage.PROCESS: {
			org.eclipse.bpel.model.Process process = (org.eclipse.bpel.model.Process) theEObject;
			T result = caseProcess(process);
			if (result == null)
				result = caseBPELExtensibleElement(process);
			if (result == null)
				result = caseExtensibleElement(process);
			if (result == null)
				result = caseWSDLElement(process);
			if (result == null)
				result = caseIElementExtensible(process);
			if (result == null)
				result = caseIAttributeExtensible(process);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.PARTNER_LINK: {
			PartnerLink partnerLink = (PartnerLink) theEObject;
			T result = casePartnerLink(partnerLink);
			if (result == null)
				result = caseBPELExtensibleElement(partnerLink);
			if (result == null)
				result = caseExtensibleElement(partnerLink);
			if (result == null)
				result = caseWSDLElement(partnerLink);
			if (result == null)
				result = caseIElementExtensible(partnerLink);
			if (result == null)
				result = caseIAttributeExtensible(partnerLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FAULT_HANDLER: {
			FaultHandler faultHandler = (FaultHandler) theEObject;
			T result = caseFaultHandler(faultHandler);
			if (result == null)
				result = caseBPELExtensibleElement(faultHandler);
			if (result == null)
				result = caseExtensibleElement(faultHandler);
			if (result == null)
				result = caseWSDLElement(faultHandler);
			if (result == null)
				result = caseIElementExtensible(faultHandler);
			if (result == null)
				result = caseIAttributeExtensible(faultHandler);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ACTIVITY: {
			Activity activity = (Activity) theEObject;
			T result = caseActivity(activity);
			if (result == null)
				result = caseBPELExtensibleElement(activity);
			if (result == null)
				result = caseExtensibleElement(activity);
			if (result == null)
				result = caseWSDLElement(activity);
			if (result == null)
				result = caseIElementExtensible(activity);
			if (result == null)
				result = caseIAttributeExtensible(activity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CORRELATION_SET: {
			CorrelationSet correlationSet = (CorrelationSet) theEObject;
			T result = caseCorrelationSet(correlationSet);
			if (result == null)
				result = caseBPELExtensibleElement(correlationSet);
			if (result == null)
				result = caseExtensibleElement(correlationSet);
			if (result == null)
				result = caseWSDLElement(correlationSet);
			if (result == null)
				result = caseIElementExtensible(correlationSet);
			if (result == null)
				result = caseIAttributeExtensible(correlationSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.INVOKE: {
			Invoke invoke = (Invoke) theEObject;
			T result = caseInvoke(invoke);
			if (result == null)
				result = casePartnerActivity(invoke);
			if (result == null)
				result = caseActivity(invoke);
			if (result == null)
				result = caseBPELExtensibleElement(invoke);
			if (result == null)
				result = caseExtensibleElement(invoke);
			if (result == null)
				result = caseWSDLElement(invoke);
			if (result == null)
				result = caseIElementExtensible(invoke);
			if (result == null)
				result = caseIAttributeExtensible(invoke);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.LINK: {
			Link link = (Link) theEObject;
			T result = caseLink(link);
			if (result == null)
				result = caseBPELExtensibleElement(link);
			if (result == null)
				result = caseExtensibleElement(link);
			if (result == null)
				result = caseWSDLElement(link);
			if (result == null)
				result = caseIElementExtensible(link);
			if (result == null)
				result = caseIAttributeExtensible(link);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CATCH: {
			Catch catch_ = (Catch) theEObject;
			T result = caseCatch(catch_);
			if (result == null)
				result = caseBPELExtensibleElement(catch_);
			if (result == null)
				result = caseExtensibleElement(catch_);
			if (result == null)
				result = caseWSDLElement(catch_);
			if (result == null)
				result = caseIElementExtensible(catch_);
			if (result == null)
				result = caseIAttributeExtensible(catch_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.REPLY: {
			Reply reply = (Reply) theEObject;
			T result = caseReply(reply);
			if (result == null)
				result = casePartnerActivity(reply);
			if (result == null)
				result = caseActivity(reply);
			if (result == null)
				result = caseBPELExtensibleElement(reply);
			if (result == null)
				result = caseExtensibleElement(reply);
			if (result == null)
				result = caseWSDLElement(reply);
			if (result == null)
				result = caseIElementExtensible(reply);
			if (result == null)
				result = caseIAttributeExtensible(reply);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.PARTNER_ACTIVITY: {
			PartnerActivity partnerActivity = (PartnerActivity) theEObject;
			T result = casePartnerActivity(partnerActivity);
			if (result == null)
				result = caseActivity(partnerActivity);
			if (result == null)
				result = caseBPELExtensibleElement(partnerActivity);
			if (result == null)
				result = caseExtensibleElement(partnerActivity);
			if (result == null)
				result = caseWSDLElement(partnerActivity);
			if (result == null)
				result = caseIElementExtensible(partnerActivity);
			if (result == null)
				result = caseIAttributeExtensible(partnerActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.RECEIVE: {
			Receive receive = (Receive) theEObject;
			T result = caseReceive(receive);
			if (result == null)
				result = casePartnerActivity(receive);
			if (result == null)
				result = caseActivity(receive);
			if (result == null)
				result = caseBPELExtensibleElement(receive);
			if (result == null)
				result = caseExtensibleElement(receive);
			if (result == null)
				result = caseWSDLElement(receive);
			if (result == null)
				result = caseIElementExtensible(receive);
			if (result == null)
				result = caseIAttributeExtensible(receive);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EXIT: {
			Exit exit = (Exit) theEObject;
			T result = caseExit(exit);
			if (result == null)
				result = caseActivity(exit);
			if (result == null)
				result = caseBPELExtensibleElement(exit);
			if (result == null)
				result = caseExtensibleElement(exit);
			if (result == null)
				result = caseWSDLElement(exit);
			if (result == null)
				result = caseIElementExtensible(exit);
			if (result == null)
				result = caseIAttributeExtensible(exit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.THROW: {
			Throw throw_ = (Throw) theEObject;
			T result = caseThrow(throw_);
			if (result == null)
				result = caseActivity(throw_);
			if (result == null)
				result = caseBPELExtensibleElement(throw_);
			if (result == null)
				result = caseExtensibleElement(throw_);
			if (result == null)
				result = caseWSDLElement(throw_);
			if (result == null)
				result = caseIElementExtensible(throw_);
			if (result == null)
				result = caseIAttributeExtensible(throw_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.WAIT: {
			Wait wait = (Wait) theEObject;
			T result = caseWait(wait);
			if (result == null)
				result = caseActivity(wait);
			if (result == null)
				result = caseBPELExtensibleElement(wait);
			if (result == null)
				result = caseExtensibleElement(wait);
			if (result == null)
				result = caseWSDLElement(wait);
			if (result == null)
				result = caseIElementExtensible(wait);
			if (result == null)
				result = caseIAttributeExtensible(wait);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EMPTY: {
			Empty empty = (Empty) theEObject;
			T result = caseEmpty(empty);
			if (result == null)
				result = caseActivity(empty);
			if (result == null)
				result = caseBPELExtensibleElement(empty);
			if (result == null)
				result = caseExtensibleElement(empty);
			if (result == null)
				result = caseWSDLElement(empty);
			if (result == null)
				result = caseIElementExtensible(empty);
			if (result == null)
				result = caseIAttributeExtensible(empty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.SEQUENCE: {
			Sequence sequence = (Sequence) theEObject;
			T result = caseSequence(sequence);
			if (result == null)
				result = caseActivity(sequence);
			if (result == null)
				result = caseBPELExtensibleElement(sequence);
			if (result == null)
				result = caseExtensibleElement(sequence);
			if (result == null)
				result = caseWSDLElement(sequence);
			if (result == null)
				result = caseIElementExtensible(sequence);
			if (result == null)
				result = caseIAttributeExtensible(sequence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.WHILE: {
			While while_ = (While) theEObject;
			T result = caseWhile(while_);
			if (result == null)
				result = caseActivity(while_);
			if (result == null)
				result = caseBPELExtensibleElement(while_);
			if (result == null)
				result = caseExtensibleElement(while_);
			if (result == null)
				result = caseWSDLElement(while_);
			if (result == null)
				result = caseIElementExtensible(while_);
			if (result == null)
				result = caseIAttributeExtensible(while_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.PICK: {
			Pick pick = (Pick) theEObject;
			T result = casePick(pick);
			if (result == null)
				result = caseActivity(pick);
			if (result == null)
				result = caseBPELExtensibleElement(pick);
			if (result == null)
				result = caseExtensibleElement(pick);
			if (result == null)
				result = caseWSDLElement(pick);
			if (result == null)
				result = caseIElementExtensible(pick);
			if (result == null)
				result = caseIAttributeExtensible(pick);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FLOW: {
			Flow flow = (Flow) theEObject;
			T result = caseFlow(flow);
			if (result == null)
				result = caseActivity(flow);
			if (result == null)
				result = caseBPELExtensibleElement(flow);
			if (result == null)
				result = caseExtensibleElement(flow);
			if (result == null)
				result = caseWSDLElement(flow);
			if (result == null)
				result = caseIElementExtensible(flow);
			if (result == null)
				result = caseIAttributeExtensible(flow);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ON_ALARM: {
			OnAlarm onAlarm = (OnAlarm) theEObject;
			T result = caseOnAlarm(onAlarm);
			if (result == null)
				result = caseBPELExtensibleElement(onAlarm);
			if (result == null)
				result = caseExtensibleElement(onAlarm);
			if (result == null)
				result = caseWSDLElement(onAlarm);
			if (result == null)
				result = caseIElementExtensible(onAlarm);
			if (result == null)
				result = caseIAttributeExtensible(onAlarm);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ASSIGN_E4X: {
			AssignE4X assignE4X = (AssignE4X) theEObject;
			T result = caseAssignE4X(assignE4X);
			if (result == null)
				result = caseActivity(assignE4X);
			if (result == null)
				result = caseBPELExtensibleElement(assignE4X);
			if (result == null)
				result = caseExtensibleElement(assignE4X);
			if (result == null)
				result = caseWSDLElement(assignE4X);
			if (result == null)
				result = caseIElementExtensible(assignE4X);
			if (result == null)
				result = caseIAttributeExtensible(assignE4X);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EXTENSION_ASSIGN_OPERATION: {
			ExtensionAssignOperation extensionAssignOperation = (ExtensionAssignOperation) theEObject;
			T result = caseExtensionAssignOperation(extensionAssignOperation);
			if (result == null)
				result = caseBPELExtensibleElement(extensionAssignOperation);
			if (result == null)
				result = caseExtensibleElement(extensionAssignOperation);
			if (result == null)
				result = caseWSDLElement(extensionAssignOperation);
			if (result == null)
				result = caseIElementExtensible(extensionAssignOperation);
			if (result == null)
				result = caseIAttributeExtensible(extensionAssignOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.SNIPPET: {
			Snippet snippet = (Snippet) theEObject;
			T result = caseSnippet(snippet);
			if (result == null)
				result = caseBPELExtensibleElement(snippet);
			if (result == null)
				result = caseExtensibleElement(snippet);
			if (result == null)
				result = caseWSDLElement(snippet);
			if (result == null)
				result = caseIElementExtensible(snippet);
			if (result == null)
				result = caseIAttributeExtensible(snippet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ASSIGN: {
			Assign assign = (Assign) theEObject;
			T result = caseAssign(assign);
			if (result == null)
				result = caseActivity(assign);
			if (result == null)
				result = caseBPELExtensibleElement(assign);
			if (result == null)
				result = caseExtensibleElement(assign);
			if (result == null)
				result = caseWSDLElement(assign);
			if (result == null)
				result = caseIElementExtensible(assign);
			if (result == null)
				result = caseIAttributeExtensible(assign);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.COPY: {
			Copy copy = (Copy) theEObject;
			T result = caseCopy(copy);
			if (result == null)
				result = caseBPELExtensibleElement(copy);
			if (result == null)
				result = caseExtensibleElement(copy);
			if (result == null)
				result = caseWSDLElement(copy);
			if (result == null)
				result = caseIElementExtensible(copy);
			if (result == null)
				result = caseIAttributeExtensible(copy);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EXTENSION: {
			Extension extension = (Extension) theEObject;
			T result = caseExtension(extension);
			if (result == null)
				result = caseBPELExtensibleElement(extension);
			if (result == null)
				result = caseExtensibleElement(extension);
			if (result == null)
				result = caseWSDLElement(extension);
			if (result == null)
				result = caseIElementExtensible(extension);
			if (result == null)
				result = caseIAttributeExtensible(extension);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.SCOPE: {
			Scope scope = (Scope) theEObject;
			T result = caseScope(scope);
			if (result == null)
				result = caseActivity(scope);
			if (result == null)
				result = caseBPELExtensibleElement(scope);
			if (result == null)
				result = caseExtensibleElement(scope);
			if (result == null)
				result = caseWSDLElement(scope);
			if (result == null)
				result = caseIElementExtensible(scope);
			if (result == null)
				result = caseIAttributeExtensible(scope);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.COMPENSATE_SCOPE: {
			CompensateScope compensateScope = (CompensateScope) theEObject;
			T result = caseCompensateScope(compensateScope);
			if (result == null)
				result = caseActivity(compensateScope);
			if (result == null)
				result = caseBPELExtensibleElement(compensateScope);
			if (result == null)
				result = caseExtensibleElement(compensateScope);
			if (result == null)
				result = caseWSDLElement(compensateScope);
			if (result == null)
				result = caseIElementExtensible(compensateScope);
			if (result == null)
				result = caseIAttributeExtensible(compensateScope);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.COMPENSATION_HANDLER: {
			CompensationHandler compensationHandler = (CompensationHandler) theEObject;
			T result = caseCompensationHandler(compensationHandler);
			if (result == null)
				result = caseBPELExtensibleElement(compensationHandler);
			if (result == null)
				result = caseExtensibleElement(compensationHandler);
			if (result == null)
				result = caseWSDLElement(compensationHandler);
			if (result == null)
				result = caseIElementExtensible(compensationHandler);
			if (result == null)
				result = caseIAttributeExtensible(compensationHandler);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ABSTRACT_ASSIGN_BOUND: {
			AbstractAssignBound abstractAssignBound = (AbstractAssignBound) theEObject;
			T result = caseAbstractAssignBound(abstractAssignBound);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.TO: {
			To to = (To) theEObject;
			T result = caseTo(to);
			if (result == null)
				result = caseBPELExtensibleElement(to);
			if (result == null)
				result = caseAbstractAssignBound(to);
			if (result == null)
				result = caseExtensibleElement(to);
			if (result == null)
				result = caseWSDLElement(to);
			if (result == null)
				result = caseIElementExtensible(to);
			if (result == null)
				result = caseIAttributeExtensible(to);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FROM: {
			From from = (From) theEObject;
			T result = caseFrom(from);
			if (result == null)
				result = caseBPELExtensibleElement(from);
			if (result == null)
				result = caseAbstractAssignBound(from);
			if (result == null)
				result = caseExtensibleElement(from);
			if (result == null)
				result = caseWSDLElement(from);
			if (result == null)
				result = caseIElementExtensible(from);
			if (result == null)
				result = caseIAttributeExtensible(from);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ON_MESSAGE: {
			OnMessage onMessage = (OnMessage) theEObject;
			T result = caseOnMessage(onMessage);
			if (result == null)
				result = caseBPELExtensibleElement(onMessage);
			if (result == null)
				result = caseExtensibleElement(onMessage);
			if (result == null)
				result = caseWSDLElement(onMessage);
			if (result == null)
				result = caseIElementExtensible(onMessage);
			if (result == null)
				result = caseIAttributeExtensible(onMessage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EXPRESSION: {
			Expression expression = (Expression) theEObject;
			T result = caseExpression(expression);
			if (result == null)
				result = caseExtensibilityElement(expression);
			if (result == null)
				result = caseWSDLElement(expression);
			if (result == null)
				result = caseIExtensibilityElement(expression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.BOOLEAN_EXPRESSION: {
			BooleanExpression booleanExpression = (BooleanExpression) theEObject;
			T result = caseBooleanExpression(booleanExpression);
			if (result == null)
				result = caseExpression(booleanExpression);
			if (result == null)
				result = caseExtensibilityElement(booleanExpression);
			if (result == null)
				result = caseWSDLElement(booleanExpression);
			if (result == null)
				result = caseIExtensibilityElement(booleanExpression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CORRELATION: {
			Correlation correlation = (Correlation) theEObject;
			T result = caseCorrelation(correlation);
			if (result == null)
				result = caseBPELExtensibleElement(correlation);
			if (result == null)
				result = caseExtensibleElement(correlation);
			if (result == null)
				result = caseWSDLElement(correlation);
			if (result == null)
				result = caseIElementExtensible(correlation);
			if (result == null)
				result = caseIAttributeExtensible(correlation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.MESSAGE_EXCHANGE: {
			MessageExchange messageExchange = (MessageExchange) theEObject;
			T result = caseMessageExchange(messageExchange);
			if (result == null)
				result = caseBPELExtensibleElement(messageExchange);
			if (result == null)
				result = caseExtensibleElement(messageExchange);
			if (result == null)
				result = caseWSDLElement(messageExchange);
			if (result == null)
				result = caseIElementExtensible(messageExchange);
			if (result == null)
				result = caseIAttributeExtensible(messageExchange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EVENT_HANDLER: {
			EventHandler eventHandler = (EventHandler) theEObject;
			T result = caseEventHandler(eventHandler);
			if (result == null)
				result = caseBPELExtensibleElement(eventHandler);
			if (result == null)
				result = caseExtensibleElement(eventHandler);
			if (result == null)
				result = caseWSDLElement(eventHandler);
			if (result == null)
				result = caseIElementExtensible(eventHandler);
			if (result == null)
				result = caseIAttributeExtensible(eventHandler);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.SOURCE: {
			Source source = (Source) theEObject;
			T result = caseSource(source);
			if (result == null)
				result = caseBPELExtensibleElement(source);
			if (result == null)
				result = caseExtensibleElement(source);
			if (result == null)
				result = caseWSDLElement(source);
			if (result == null)
				result = caseIElementExtensible(source);
			if (result == null)
				result = caseIAttributeExtensible(source);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.TARGET: {
			Target target = (Target) theEObject;
			T result = caseTarget(target);
			if (result == null)
				result = caseBPELExtensibleElement(target);
			if (result == null)
				result = caseExtensibleElement(target);
			if (result == null)
				result = caseWSDLElement(target);
			if (result == null)
				result = caseIElementExtensible(target);
			if (result == null)
				result = caseIAttributeExtensible(target);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.PARTNER_LINKS: {
			PartnerLinks partnerLinks = (PartnerLinks) theEObject;
			T result = casePartnerLinks(partnerLinks);
			if (result == null)
				result = caseBPELExtensibleElement(partnerLinks);
			if (result == null)
				result = caseExtensibleElement(partnerLinks);
			if (result == null)
				result = caseWSDLElement(partnerLinks);
			if (result == null)
				result = caseIElementExtensible(partnerLinks);
			if (result == null)
				result = caseIAttributeExtensible(partnerLinks);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.MESSAGE_EXCHANGES: {
			MessageExchanges messageExchanges = (MessageExchanges) theEObject;
			T result = caseMessageExchanges(messageExchanges);
			if (result == null)
				result = caseBPELExtensibleElement(messageExchanges);
			if (result == null)
				result = caseExtensibleElement(messageExchanges);
			if (result == null)
				result = caseWSDLElement(messageExchanges);
			if (result == null)
				result = caseIElementExtensible(messageExchanges);
			if (result == null)
				result = caseIAttributeExtensible(messageExchanges);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.VARIABLES: {
			Variables variables = (Variables) theEObject;
			T result = caseVariables(variables);
			if (result == null)
				result = caseBPELExtensibleElement(variables);
			if (result == null)
				result = caseExtensibleElement(variables);
			if (result == null)
				result = caseWSDLElement(variables);
			if (result == null)
				result = caseIElementExtensible(variables);
			if (result == null)
				result = caseIAttributeExtensible(variables);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CORRELATION_SETS: {
			CorrelationSets correlationSets = (CorrelationSets) theEObject;
			T result = caseCorrelationSets(correlationSets);
			if (result == null)
				result = caseBPELExtensibleElement(correlationSets);
			if (result == null)
				result = caseExtensibleElement(correlationSets);
			if (result == null)
				result = caseWSDLElement(correlationSets);
			if (result == null)
				result = caseIElementExtensible(correlationSets);
			if (result == null)
				result = caseIAttributeExtensible(correlationSets);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.LINKS: {
			Links links = (Links) theEObject;
			T result = caseLinks(links);
			if (result == null)
				result = caseBPELExtensibleElement(links);
			if (result == null)
				result = caseExtensibleElement(links);
			if (result == null)
				result = caseWSDLElement(links);
			if (result == null)
				result = caseIElementExtensible(links);
			if (result == null)
				result = caseIAttributeExtensible(links);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CATCH_ALL: {
			CatchAll catchAll = (CatchAll) theEObject;
			T result = caseCatchAll(catchAll);
			if (result == null)
				result = caseBPELExtensibleElement(catchAll);
			if (result == null)
				result = caseExtensibleElement(catchAll);
			if (result == null)
				result = caseWSDLElement(catchAll);
			if (result == null)
				result = caseIElementExtensible(catchAll);
			if (result == null)
				result = caseIAttributeExtensible(catchAll);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CORRELATIONS: {
			Correlations correlations = (Correlations) theEObject;
			T result = caseCorrelations(correlations);
			if (result == null)
				result = caseBPELExtensibleElement(correlations);
			if (result == null)
				result = caseExtensibleElement(correlations);
			if (result == null)
				result = caseWSDLElement(correlations);
			if (result == null)
				result = caseIElementExtensible(correlations);
			if (result == null)
				result = caseIAttributeExtensible(correlations);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.VARIABLE: {
			Variable variable = (Variable) theEObject;
			T result = caseVariable(variable);
			if (result == null)
				result = caseBPELExtensibleElement(variable);
			if (result == null)
				result = caseExtensibleElement(variable);
			if (result == null)
				result = caseWSDLElement(variable);
			if (result == null)
				result = caseIElementExtensible(variable);
			if (result == null)
				result = caseIAttributeExtensible(variable);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.UNKNOWN_EXTENSIBILITY_ATTRIBUTE: {
			UnknownExtensibilityAttribute unknownExtensibilityAttribute = (UnknownExtensibilityAttribute) theEObject;
			T result = caseUnknownExtensibilityAttribute(unknownExtensibilityAttribute);
			if (result == null)
				result = caseUnknownExtensibilityElement(unknownExtensibilityAttribute);
			if (result == null)
				result = caseExtensibilityElement(unknownExtensibilityAttribute);
			if (result == null)
				result = caseWSDLElement(unknownExtensibilityAttribute);
			if (result == null)
				result = caseIExtensibilityElement(unknownExtensibilityAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ON_EVENT: {
			OnEvent onEvent = (OnEvent) theEObject;
			T result = caseOnEvent(onEvent);
			if (result == null)
				result = caseBPELExtensibleElement(onEvent);
			if (result == null)
				result = caseExtensibleElement(onEvent);
			if (result == null)
				result = caseWSDLElement(onEvent);
			if (result == null)
				result = caseIElementExtensible(onEvent);
			if (result == null)
				result = caseIAttributeExtensible(onEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.IMPORT: {
			Import import_ = (Import) theEObject;
			T result = caseImport(import_);
			if (result == null)
				result = caseBPELExtensibleElement(import_);
			if (result == null)
				result = caseExtensibleElement(import_);
			if (result == null)
				result = caseWSDLElement(import_);
			if (result == null)
				result = caseIElementExtensible(import_);
			if (result == null)
				result = caseIAttributeExtensible(import_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.RETHROW: {
			Rethrow rethrow = (Rethrow) theEObject;
			T result = caseRethrow(rethrow);
			if (result == null)
				result = caseActivity(rethrow);
			if (result == null)
				result = caseBPELExtensibleElement(rethrow);
			if (result == null)
				result = caseExtensibleElement(rethrow);
			if (result == null)
				result = caseWSDLElement(rethrow);
			if (result == null)
				result = caseIElementExtensible(rethrow);
			if (result == null)
				result = caseIAttributeExtensible(rethrow);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.CONDITION: {
			Condition condition = (Condition) theEObject;
			T result = caseCondition(condition);
			if (result == null)
				result = caseExpression(condition);
			if (result == null)
				result = caseExtensibilityElement(condition);
			if (result == null)
				result = caseWSDLElement(condition);
			if (result == null)
				result = caseIExtensibilityElement(condition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.TARGETS: {
			Targets targets = (Targets) theEObject;
			T result = caseTargets(targets);
			if (result == null)
				result = caseBPELExtensibleElement(targets);
			if (result == null)
				result = caseExtensibleElement(targets);
			if (result == null)
				result = caseWSDLElement(targets);
			if (result == null)
				result = caseIElementExtensible(targets);
			if (result == null)
				result = caseIAttributeExtensible(targets);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.SOURCES: {
			Sources sources = (Sources) theEObject;
			T result = caseSources(sources);
			if (result == null)
				result = caseBPELExtensibleElement(sources);
			if (result == null)
				result = caseExtensibleElement(sources);
			if (result == null)
				result = caseWSDLElement(sources);
			if (result == null)
				result = caseIElementExtensible(sources);
			if (result == null)
				result = caseIAttributeExtensible(sources);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.QUERY: {
			Query query = (Query) theEObject;
			T result = caseQuery(query);
			if (result == null)
				result = caseWSDLElement(query);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.SERVICE_REF: {
			ServiceRef serviceRef = (ServiceRef) theEObject;
			T result = caseServiceRef(serviceRef);
			if (result == null)
				result = caseExtensibleElement(serviceRef);
			if (result == null)
				result = caseWSDLElement(serviceRef);
			if (result == null)
				result = caseIElementExtensible(serviceRef);
			if (result == null)
				result = caseIAttributeExtensible(serviceRef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EXTENSIONS: {
			Extensions extensions = (Extensions) theEObject;
			T result = caseExtensions(extensions);
			if (result == null)
				result = caseBPELExtensibleElement(extensions);
			if (result == null)
				result = caseExtensibleElement(extensions);
			if (result == null)
				result = caseWSDLElement(extensions);
			if (result == null)
				result = caseIElementExtensible(extensions);
			if (result == null)
				result = caseIAttributeExtensible(extensions);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.EXTENSION_ACTIVITY: {
			ExtensionActivity extensionActivity = (ExtensionActivity) theEObject;
			T result = caseExtensionActivity(extensionActivity);
			if (result == null)
				result = caseActivity(extensionActivity);
			if (result == null)
				result = caseBPELExtensibleElement(extensionActivity);
			if (result == null)
				result = caseExtensibleElement(extensionActivity);
			if (result == null)
				result = caseWSDLElement(extensionActivity);
			if (result == null)
				result = caseIElementExtensible(extensionActivity);
			if (result == null)
				result = caseIAttributeExtensible(extensionActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FROM_PART: {
			FromPart fromPart = (FromPart) theEObject;
			T result = caseFromPart(fromPart);
			if (result == null)
				result = caseBPELExtensibleElement(fromPart);
			if (result == null)
				result = caseExtensibleElement(fromPart);
			if (result == null)
				result = caseWSDLElement(fromPart);
			if (result == null)
				result = caseIElementExtensible(fromPart);
			if (result == null)
				result = caseIAttributeExtensible(fromPart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.TO_PART: {
			ToPart toPart = (ToPart) theEObject;
			T result = caseToPart(toPart);
			if (result == null)
				result = caseBPELExtensibleElement(toPart);
			if (result == null)
				result = caseExtensibleElement(toPart);
			if (result == null)
				result = caseWSDLElement(toPart);
			if (result == null)
				result = caseIElementExtensible(toPart);
			if (result == null)
				result = caseIAttributeExtensible(toPart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.OPAQUE_ACTIVITY: {
			OpaqueActivity opaqueActivity = (OpaqueActivity) theEObject;
			T result = caseOpaqueActivity(opaqueActivity);
			if (result == null)
				result = caseActivity(opaqueActivity);
			if (result == null)
				result = caseBPELExtensibleElement(opaqueActivity);
			if (result == null)
				result = caseExtensibleElement(opaqueActivity);
			if (result == null)
				result = caseWSDLElement(opaqueActivity);
			if (result == null)
				result = caseIElementExtensible(opaqueActivity);
			if (result == null)
				result = caseIAttributeExtensible(opaqueActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FOR_EACH: {
			ForEach forEach = (ForEach) theEObject;
			T result = caseForEach(forEach);
			if (result == null)
				result = caseActivity(forEach);
			if (result == null)
				result = caseBPELExtensibleElement(forEach);
			if (result == null)
				result = caseExtensibleElement(forEach);
			if (result == null)
				result = caseWSDLElement(forEach);
			if (result == null)
				result = caseIElementExtensible(forEach);
			if (result == null)
				result = caseIAttributeExtensible(forEach);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.REPEAT_UNTIL: {
			RepeatUntil repeatUntil = (RepeatUntil) theEObject;
			T result = caseRepeatUntil(repeatUntil);
			if (result == null)
				result = caseActivity(repeatUntil);
			if (result == null)
				result = caseBPELExtensibleElement(repeatUntil);
			if (result == null)
				result = caseExtensibleElement(repeatUntil);
			if (result == null)
				result = caseWSDLElement(repeatUntil);
			if (result == null)
				result = caseIElementExtensible(repeatUntil);
			if (result == null)
				result = caseIAttributeExtensible(repeatUntil);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.TERMINATION_HANDLER: {
			TerminationHandler terminationHandler = (TerminationHandler) theEObject;
			T result = caseTerminationHandler(terminationHandler);
			if (result == null)
				result = caseBPELExtensibleElement(terminationHandler);
			if (result == null)
				result = caseExtensibleElement(terminationHandler);
			if (result == null)
				result = caseWSDLElement(terminationHandler);
			if (result == null)
				result = caseIElementExtensible(terminationHandler);
			if (result == null)
				result = caseIAttributeExtensible(terminationHandler);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.VALIDATE: {
			Validate validate = (Validate) theEObject;
			T result = caseValidate(validate);
			if (result == null)
				result = caseActivity(validate);
			if (result == null)
				result = caseBPELExtensibleElement(validate);
			if (result == null)
				result = caseExtensibleElement(validate);
			if (result == null)
				result = caseWSDLElement(validate);
			if (result == null)
				result = caseIElementExtensible(validate);
			if (result == null)
				result = caseIAttributeExtensible(validate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.IF: {
			If if_ = (If) theEObject;
			T result = caseIf(if_);
			if (result == null)
				result = caseActivity(if_);
			if (result == null)
				result = caseBPELExtensibleElement(if_);
			if (result == null)
				result = caseExtensibleElement(if_);
			if (result == null)
				result = caseWSDLElement(if_);
			if (result == null)
				result = caseIElementExtensible(if_);
			if (result == null)
				result = caseIAttributeExtensible(if_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ELSE_IF: {
			ElseIf elseIf = (ElseIf) theEObject;
			T result = caseElseIf(elseIf);
			if (result == null)
				result = caseBPELExtensibleElement(elseIf);
			if (result == null)
				result = caseExtensibleElement(elseIf);
			if (result == null)
				result = caseWSDLElement(elseIf);
			if (result == null)
				result = caseIElementExtensible(elseIf);
			if (result == null)
				result = caseIAttributeExtensible(elseIf);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.ELSE: {
			Else else_ = (Else) theEObject;
			T result = caseElse(else_);
			if (result == null)
				result = caseBPELExtensibleElement(else_);
			if (result == null)
				result = caseExtensibleElement(else_);
			if (result == null)
				result = caseWSDLElement(else_);
			if (result == null)
				result = caseIElementExtensible(else_);
			if (result == null)
				result = caseIAttributeExtensible(else_);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.COMPLETION_CONDITION: {
			CompletionCondition completionCondition = (CompletionCondition) theEObject;
			T result = caseCompletionCondition(completionCondition);
			if (result == null)
				result = caseBPELExtensibleElement(completionCondition);
			if (result == null)
				result = caseExtensibleElement(completionCondition);
			if (result == null)
				result = caseWSDLElement(completionCondition);
			if (result == null)
				result = caseIElementExtensible(completionCondition);
			if (result == null)
				result = caseIAttributeExtensible(completionCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.BRANCHES: {
			Branches branches = (Branches) theEObject;
			T result = caseBranches(branches);
			if (result == null)
				result = caseExpression(branches);
			if (result == null)
				result = caseExtensibilityElement(branches);
			if (result == null)
				result = caseWSDLElement(branches);
			if (result == null)
				result = caseIExtensibilityElement(branches);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.BPEL_EXTENSIBLE_ELEMENT: {
			BPELExtensibleElement bpelExtensibleElement = (BPELExtensibleElement) theEObject;
			T result = caseBPELExtensibleElement(bpelExtensibleElement);
			if (result == null)
				result = caseExtensibleElement(bpelExtensibleElement);
			if (result == null)
				result = caseWSDLElement(bpelExtensibleElement);
			if (result == null)
				result = caseIElementExtensible(bpelExtensibleElement);
			if (result == null)
				result = caseIAttributeExtensible(bpelExtensibleElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.DOCUMENTATION: {
			Documentation documentation = (Documentation) theEObject;
			T result = caseDocumentation(documentation);
			if (result == null)
				result = caseBPELExtensibleElement(documentation);
			if (result == null)
				result = caseExtensibleElement(documentation);
			if (result == null)
				result = caseWSDLElement(documentation);
			if (result == null)
				result = caseIElementExtensible(documentation);
			if (result == null)
				result = caseIAttributeExtensible(documentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.COMPENSATE: {
			Compensate compensate = (Compensate) theEObject;
			T result = caseCompensate(compensate);
			if (result == null)
				result = caseActivity(compensate);
			if (result == null)
				result = caseBPELExtensibleElement(compensate);
			if (result == null)
				result = caseExtensibleElement(compensate);
			if (result == null)
				result = caseWSDLElement(compensate);
			if (result == null)
				result = caseIElementExtensible(compensate);
			if (result == null)
				result = caseIAttributeExtensible(compensate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FROM_PARTS: {
			FromParts fromParts = (FromParts) theEObject;
			T result = caseFromParts(fromParts);
			if (result == null)
				result = caseBPELExtensibleElement(fromParts);
			if (result == null)
				result = caseExtensibleElement(fromParts);
			if (result == null)
				result = caseWSDLElement(fromParts);
			if (result == null)
				result = caseIElementExtensible(fromParts);
			if (result == null)
				result = caseIAttributeExtensible(fromParts);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.TO_PARTS: {
			ToParts toParts = (ToParts) theEObject;
			T result = caseToParts(toParts);
			if (result == null)
				result = caseBPELExtensibleElement(toParts);
			if (result == null)
				result = caseExtensibleElement(toParts);
			if (result == null)
				result = caseWSDLElement(toParts);
			if (result == null)
				result = caseIElementExtensible(toParts);
			if (result == null)
				result = caseIAttributeExtensible(toParts);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FAILURE_HANDLING: {
			FailureHandling failureHandling = (FailureHandling) theEObject;
			T result = caseFailureHandling(failureHandling);
			if (result == null)
				result = caseBPELExtensibleElement(failureHandling);
			if (result == null)
				result = caseExtensibleElement(failureHandling);
			if (result == null)
				result = caseWSDLElement(failureHandling);
			if (result == null)
				result = caseIElementExtensible(failureHandling);
			if (result == null)
				result = caseIAttributeExtensible(failureHandling);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.FAULT_ON_FAILURE: {
			FaultOnFailure faultOnFailure = (FaultOnFailure) theEObject;
			T result = caseFaultOnFailure(faultOnFailure);
			if (result == null)
				result = caseBPELExtensibleElement(faultOnFailure);
			if (result == null)
				result = caseExtensibleElement(faultOnFailure);
			if (result == null)
				result = caseWSDLElement(faultOnFailure);
			if (result == null)
				result = caseIElementExtensible(faultOnFailure);
			if (result == null)
				result = caseIAttributeExtensible(faultOnFailure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.RETRY_FOR: {
			RetryFor retryFor = (RetryFor) theEObject;
			T result = caseRetryFor(retryFor);
			if (result == null)
				result = caseBPELExtensibleElement(retryFor);
			if (result == null)
				result = caseExtensibleElement(retryFor);
			if (result == null)
				result = caseWSDLElement(retryFor);
			if (result == null)
				result = caseIElementExtensible(retryFor);
			if (result == null)
				result = caseIAttributeExtensible(retryFor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case BPELPackage.RETRY_DELAY: {
			RetryDelay retryDelay = (RetryDelay) theEObject;
			T result = caseRetryDelay(retryDelay);
			if (result == null)
				result = caseBPELExtensibleElement(retryDelay);
			if (result == null)
				result = caseExtensibleElement(retryDelay);
			if (result == null)
				result = caseWSDLElement(retryDelay);
			if (result == null)
				result = caseIElementExtensible(retryDelay);
			if (result == null)
				result = caseIAttributeExtensible(retryDelay);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(org.eclipse.bpel.model.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partner Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerLink(PartnerLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultHandler(FaultHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationSet(CorrelationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke(Invoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatch(Catch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReply(Reply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partner Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerActivity(PartnerActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Receive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Receive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReceive(Receive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExit(Exit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throw</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throw</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrow(Throw object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWait(Wait object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmpty(Empty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhile(While object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePick(Pick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlow(Flow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Alarm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Alarm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnAlarm(OnAlarm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign E4X</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign E4X</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignE4X(AssignE4X object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Assign Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Assign Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionAssignOperation(ExtensionAssignOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snippet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snippet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnippet(Snippet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssign(Assign object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Copy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Copy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCopy(Copy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtension(Extension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScope(Scope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compensate Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compensate Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompensateScope(CompensateScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compensation Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compensation Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompensationHandler(CompensationHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Assign Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Assign Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAssignBound(AbstractAssignBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTo(To object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFrom(From object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnMessage(OnMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExpression(BooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelation(Correlation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Exchange</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Exchange</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageExchange(MessageExchange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventHandler(EventHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSource(Source object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTarget(Target object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partner Links</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Links</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerLinks(PartnerLinks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Exchanges</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Exchanges</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageExchanges(MessageExchanges object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variables</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variables</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariables(Variables object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Sets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Sets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationSets(CorrelationSets object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Links</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Links</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinks(Links object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catch All</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catch All</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatchAll(CatchAll object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelations(Correlations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Extensibility Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Extensibility Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownExtensibilityAttribute(
			UnknownExtensibilityAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>On Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>On Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnEvent(OnEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rethrow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rethrow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRethrow(Rethrow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Targets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Targets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargets(Targets object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sources</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sources</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSources(Sources object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuery(Query object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceRef(ServiceRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensions(Extensions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionActivity(ExtensionActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromPart(FromPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToPart(ToPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueActivity(OpaqueActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEach(ForEach object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeat Until</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeat Until</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeatUntil(RepeatUntil object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Termination Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Termination Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminationHandler(TerminationHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidate(Validate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElseIf(ElseIf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElse(Else object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Completion Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Completion Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompletionCondition(CompletionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branches</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branches</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranches(Branches object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPELExtensibleElement(BPELExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentation(Documentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compensate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compensate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompensate(Compensate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>From Parts</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Parts</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFromParts(FromParts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Parts</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Parts</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToParts(ToParts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failure Handling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure Handling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailureHandling(FailureHandling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fault On Failure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fault On Failure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFaultOnFailure(FaultOnFailure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Retry For</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Retry For</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRetryFor(RetryFor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Retry Delay</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Retry Delay</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRetryDelay(RetryDelay object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSDLElement(WSDLElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IElement Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IElement Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIElementExtensible(ElementExtensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAttribute Extensible</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAttribute Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAttributeExtensible(AttributeExtensible object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IExtensibility Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IExtensibility Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIExtensibilityElement(ExtensibilityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensibility Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensibility Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensibilityElement(
			org.eclipse.wst.wsdl.ExtensibilityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unknown Extensibility Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unknown Extensibility Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnknownExtensibilityElement(UnknownExtensibilityElement object) {
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

} //BPELSwitch
