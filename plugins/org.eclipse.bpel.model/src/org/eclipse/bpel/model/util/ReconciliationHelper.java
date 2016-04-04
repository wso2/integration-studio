/*******************************************************************************
 * Copyright (c) 2007 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Ushakov, Intel - Initial API and Implementation
 *    Oleg Danilov, Intel
 *
 *******************************************************************************/

package org.eclipse.bpel.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
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
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.Extension;
import org.eclipse.bpel.model.ExtensionActivity;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.Extensions;
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
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.RepeatUntil;
import org.eclipse.bpel.model.Reply;
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
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.model.impl.CorrelationSetsImpl;
//Bugzilla 340654 - renamed to avoid confusion with WSDL's ExtensibilityElement
import org.eclipse.bpel.model.impl.BPELExtensibilityElementImpl;
import org.eclipse.bpel.model.impl.BPELExtensibleElementImpl;
import org.eclipse.bpel.model.impl.MessageExchangesImpl;
import org.eclipse.bpel.model.impl.PartnerLinksImpl;
import org.eclipse.bpel.model.impl.VariablesImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReconciliationHelper {
	private static ReconciliationHelper helper;
	private HashMap<Document, ReconciliationBPELReader> document2reader = new HashMap<Document, ReconciliationBPELReader>();
	
	public static ReconciliationHelper getInstance() {
		if (helper == null) {
			helper = new ReconciliationHelper();
		}
		return helper;
	}
	
	public void reconcile(WSDLElement element, Element changedElement) {
//		if (isLoading(element)) {
//			System.err.println("**LOADING***");
//			(new Exception()).printStackTrace();
//			return;
//		}
//		System.err.println("**RECONCILE***");
//		System.err.println(element);
//		(new Exception()).printStackTrace();
		ReconciliationBPELReader reader = getReader(element, changedElement);
		if (element instanceof Activity) {
			reader.xml2Activity((Activity)element, changedElement);
		} else if (element instanceof Process) {
			reader.xml2Process(changedElement);
		} else if (element instanceof Import) {
			reader.xml2Import((Import)element, changedElement);
		} else if (element instanceof Condition) {
			reader.xml2Condition((Condition)element, changedElement);
		} else if (element instanceof CompletionCondition) {
			reader.xml2CompletionCondition((CompletionCondition)element, changedElement);
		} else if (element instanceof Branches) {
			reader.xml2Branches((Branches)element, changedElement);
		} else if (element instanceof Expression) {
			reader.xml2Expression((Expression)element, changedElement);
		} else if (element instanceof Documentation) {
			reader.xml2Documentation((Documentation)element, changedElement);
		} else if (element instanceof Link) {
			reader.xml2Link((Link)element, changedElement);
		} else if (element instanceof Links) {
			reader.xml2Links((Links)element, changedElement);
		} else if (element instanceof ElseIf) {
			reader.xml2ElseIf((ElseIf)element, changedElement);
		} else if (element instanceof Else) {
			reader.xml2Else((Else)element, changedElement);
		} else if (element instanceof Variable) {
			reader.xml2Variable((Variable)element, changedElement);
		} else if (element instanceof Variables) {
			reader.xml2Variables((Variables)element, changedElement);
		} else if (element instanceof From) {
			reader.xml2From((From)element, changedElement);
		} else if (element instanceof FromPart) {
			reader.xml2FromPart((FromPart)element, changedElement);
		} else if (element instanceof FromParts) {
			reader.xml2FromParts((FromParts)element, changedElement);
		} else if (element instanceof To) {
			reader.xml2To((To)element, changedElement);
		} else if (element instanceof ToPart) {
			reader.xml2ToPart((ToPart)element, changedElement);
		} else if (element instanceof ToParts) {
			reader.xml2ToParts((ToParts)element, changedElement);
		} else if (element instanceof Query) {
			reader.xml2Query((Query)element, changedElement);
		} else if (element instanceof ServiceRef) {
			reader.xml2ServiceRef((ServiceRef)element, changedElement);
		} else if (element instanceof PartnerLinks) {
			reader.xml2PartnerLinks((PartnerLinks) element, changedElement);
		} else if (element instanceof PartnerLink) {
			reader.xml2PartnerLink((PartnerLink) element, changedElement);
		} else if (element instanceof Catch){
			reader.xml2Catch((Catch)element, changedElement);
		} else if (element instanceof CatchAll){
			reader.xml2CatchAll((CatchAll)element, changedElement);
		} else if (element instanceof Copy){
			reader.xml2Copy((Copy)element, changedElement);
		} else if (element instanceof FaultHandler) {
			reader.xml2FaultHandler((FaultHandler)element, changedElement);
		} else if (element instanceof EventHandler) {
			reader.xml2EventHandler((EventHandler)element, changedElement);
		} else if (element instanceof TerminationHandler) {
			reader.xml2TerminationHandler((TerminationHandler)element, changedElement);
		} else if (element instanceof Correlation) {
			reader.xml2Correlation((Correlation)element, changedElement);
		} else if (element instanceof Correlations) {
			reader.xml2Correlations((Correlations)element, changedElement);
		} else if (element instanceof CorrelationSet) {
			reader.xml2CorrelationSet((CorrelationSet)element, changedElement);
		} else if (element instanceof CorrelationSets) {
			reader.xml2CorrelationSets((CorrelationSets)element, changedElement);
		} else if (element instanceof OnAlarm){
			reader.xml2OnAlarm((OnAlarm)element, changedElement);
		} else if (element instanceof OnMessage){
			reader.xml2OnMessage((OnMessage)element, changedElement);
		} else if (element instanceof OnEvent){
			reader.xml2OnEvent((OnEvent)element, changedElement);
		} else if (element instanceof MessageExchanges){
			reader.xml2MessageExchanges((MessageExchanges)element, changedElement);
		} else if (element instanceof MessageExchange){
			reader.xml2MessageExchange((MessageExchange)element, changedElement);
		} else if (element instanceof Extension){
			reader.xml2Extension((Extension)element, changedElement);
		} else if (element instanceof Extensions){
			reader.xml2Extensions((Extensions)element, changedElement);
		} else if (element instanceof Source){
			reader.xml2Source((Source)element, changedElement);
		} else if (element instanceof Sources){
			reader.xml2Sources((Sources)element, changedElement);
		} else if (element instanceof Target){
			reader.xml2Target((Target)element, changedElement);
		} else if (element instanceof Targets){
			reader.xml2Targets((Targets)element, changedElement);
		} else if (element instanceof CompensationHandler){
			// https://issues.jboss.org/browse/JBIDE-8048
			// this was left out inadvertently
			reader.xml2CompensationHandler((CompensationHandler)element, changedElement);
		} else if (element instanceof BPELExtensibleElement){
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			reader.xml2ExtensibleElement((BPELExtensibleElement)element, changedElement);
		} else if (element instanceof ExtensionAssignOperation) {
			// added to support Extension Assign Operations
			reader.xml2ExtensionAssignOperation((ExtensionAssignOperation)element, changedElement);
		} else if (element instanceof Snippet) {
			// added to support snippet
			reader.xml2Snippet((Snippet)element, changedElement);
		}
		
		else {
			System.err.println("Cannot reconcile: " + element.getClass());
//			throw new NotImplementedException(element.getClass().toString());
		}
	}

	public static boolean isLoading(WSDLElement element) {
		Process process = BPELUtils.getProcess(element);
		return process == null || process.eResource() == null || !process.eResource().isLoaded();
	}
	
	public static void replaceChild(WSDLElement parent, WSDLElement oldElement,
			WSDLElement newElement) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);		
			
			if (isLoading(parent)) {
				return;
			}

			Element parseElement = parent.getElement();

			if (parent instanceof ExtensionActivity) {
				parseElement = getExtensionActivityChildElement(parseElement);
			}

			if (parseElement == null) {
				System.err.println("trying to replace child on null element: "
						+ parent.getClass());
				return;
			}
			if (oldElement == newElement) {
				return;
			}
			if (newElement != null) {
				if (newElement.getElement() == null) {
					Element newDomElement = ElementFactory.getInstance()
							.createElement(newElement, parent);
					if (newDomElement == null) {
						return;
					}
					newElement.setElement(newDomElement);
				}
				if (oldElement != null
						&& oldElement.getElement() != null
						&& parseElement == oldElement.getElement()
								.getParentNode()) {
					parseElement.replaceChild(newElement.getElement(),
							oldElement.getElement());
				} else {
					ElementPlacer.placeChild(parent, newElement.getElement());
				}
			} else if (oldElement != null
					&& oldElement.getElement() != null
					&& parseElement == oldElement.getElement()
							.getParentNode()) {
				ElementPlacer.niceRemoveChild(parent, oldElement.getElement());
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	/**
	 * Returns a list of child nodes of <code>parentElement</code> that are
	 * {@link Element}s. Returns an empty list if no elements are found.
	 * 
	 * @param parentElement
	 *            the element to find the children of
	 * @return a node list of the children of parentElement
	 */
	protected static List<Element> getChildElements(Element parentElement) {
		List<Element> list = new ArrayList<Element>();

		if (parentElement != null) {
			NodeList children = parentElement.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
					list.add((Element) children.item(i));
			}
		}

		return list;
	}

	public static Element getExtensionActivityChildElement(
			Element parentElement) {
		// Find the child element.
		List<Element> nodeList = getChildElements(parentElement);

		if (nodeList.size() == 1) {
			return nodeList.get(0);
		}
		
		return null;
	}
	
	/**
	 * Updates the target and source of the link to show to the new name.
	 * 
	 * @param link
	 *            that will be renamed
	 * @param name
	 *            new name
	 */
	private static void updateLinkNameReferences(Link link, String name) {
		if (link.getSources() != null && !link.getSources().isEmpty()) {
			((Source) link.getSources().get(0)).getElement().setAttribute(BPELConstants.AT_LINK_NAME, name);
		}
		if (link.getTargets() != null && !link.getTargets().isEmpty()) {
			((Target) link.getTargets().get(0)).getElement().setAttribute(BPELConstants.AT_LINK_NAME, name);
		}
	}
	
	/**
	 * Updates all places where message exchanges are referenced by their name.
	 * Does work for local and global message exchanges as well.
	 * 
	 * @param messExchange
	 *            that will be renamed
	 * @param name
	 *            new name
	 */
	private static void updateMessageExchangeNameReferences(
			MessageExchange messExchange, String name) {
		// make more efficient for local messageExchanges
		EObject nearestScopeOrProcess = BPELUtils.getNearestScopeOrProcess(messExchange);
		if (nearestScopeOrProcess == null)
			return;

		TreeIterator<EObject> iter = nearestScopeOrProcess.eAllContents();
		while (iter.hasNext()) {
			Object object = iter.next();
			
			// Receive
			if (object instanceof Receive) {
				Receive receive = (Receive) object;
				if (messExchange.equals(receive.getMessageExchange())) {
					receive.getElement().setAttribute(BPELConstants.AT_MESSAGE_EXCHANGE, name);
				}
				
			// Reply
			} else if (object instanceof Reply) {
				Reply reply = (Reply) object;
				if (messExchange.equals(reply.getMessageExchange())) {
					reply.getElement().setAttribute(BPELConstants.AT_MESSAGE_EXCHANGE, name);
				}
				
			// OnMessage
			} else if (object instanceof OnMessage) {
				OnMessage onMessage = (OnMessage) object;
				if (messExchange.equals(onMessage.getMessageExchange())) {
					onMessage.getElement().setAttribute(BPELConstants.AT_MESSAGE_EXCHANGE, name);
				}
				
			// OnEvent
			} else if (object instanceof OnEvent) {
				OnEvent onEvent = (OnEvent) object;
				if (messExchange.equals(onEvent.getMessageExchange())) {
					onEvent.getElement().setAttribute(BPELConstants.AT_MESSAGE_EXCHANGE, name);
				}
			}
		}
	}
	
	/**
	 * Updates all places where correlation sets are referenced by name. Does
	 * differentiate for global and local variables.
	 * 
	 * @param corrSet
	 *            correlation set that will be renamed
	 * @param name
	 *            new name of the correlation set
	 */
	private static void updateCorrelationSetNameReferences(CorrelationSet corrSet, String name) {
		// make more efficient for local correlationSets
		EObject nearestScopeOrProcess = BPELUtils.getNearestScopeOrProcess(corrSet);
		if (nearestScopeOrProcess == null)
			return;

		TreeIterator<EObject> iter = nearestScopeOrProcess.eAllContents();
		while (iter.hasNext()) {
			Object object = iter.next();
			
			// PartnerActivities: Receive, Reply, Invoke
			if (object instanceof PartnerActivity) {
				PartnerActivity partnerAct = (PartnerActivity) object;
				Correlations correlations = partnerAct.getCorrelations();
				if(correlations == null){
					continue;
				}
				EList<Correlation> list = correlations.getChildren();
				for (Correlation correlation : list) {
					if (corrSet.equals(correlation.getSet())) {
						correlation.getElement().setAttribute(BPELConstants.AT_SET, name);
					}
				}
			}

			// OnMessage
			else if (object instanceof OnMessage) {
				OnMessage onMessage = (OnMessage) object;
				Correlations correlations = onMessage.getCorrelations();
				if(correlations == null){
					continue;
				}
				EList<Correlation> list = correlations.getChildren();
				for (Correlation correlation : list) {
					if (corrSet.equals(correlation.getSet())) {
						correlation.getElement().setAttribute(BPELConstants.AT_SET, name);
					}
				}

			// OnEvent
			} else if (object instanceof OnEvent) {
				OnEvent onEvent = (OnEvent) object;
				Correlations correlations = onEvent.getCorrelations();
				if(correlations == null){
					continue;
				}
				EList<Correlation> list = correlations.getChildren();
				for (Correlation correlation : list) {
					if (corrSet.equals(correlation.getSet())) {
						correlation.getElement().setAttribute(BPELConstants.AT_SET, name);
					}
				}
			}
		}
	}
	
	/**
	 * Does update all places where partner links are referenced by name. Does
	 * work for local and global partner links.
	 * 
	 * @param partnerLink
	 *            that will be renamed
	 * @param name
	 *            new name partnerLink will be renamed to
	 */
	private static void updatePartnerLinkNameReferences(PartnerLink partnerLink, String name) {
		EObject nearestScopeOrProcess = BPELUtils.getNearestScopeOrProcess(partnerLink);
		if (nearestScopeOrProcess == null)
			return;

		TreeIterator<EObject> iter = nearestScopeOrProcess.eAllContents();
		while (iter.hasNext()) {
			Object object = iter.next();

			// PartnerActivity: Receive, Reply, Invoke
			if (object instanceof PartnerActivity) {
				PartnerActivity partnerAct = (PartnerActivity) object;
				if (partnerLink.equals(partnerAct.getPartnerLink())) {
					partnerAct.getElement().setAttribute(BPELConstants.AT_PARTNER_LINK, name);
				}
				
			// OnEvent
			} else if (object instanceof OnEvent) {
				OnEvent onEvent = (OnEvent) object;
				if (partnerLink.equals(onEvent.getPartnerLink())) {
					onEvent.getElement().setAttribute(BPELConstants.AT_PARTNER_LINK, name);
				}
				
			// OnMessage
			} else if (object instanceof OnMessage) {
				OnMessage onMessage = (OnMessage) object;
				if (partnerLink.equals(onMessage.getPartnerLink())) {
					onMessage.getElement().setAttribute(BPELConstants.AT_PARTNER_LINK, name);
				}
				
			// From
			} else if (object instanceof From) {
				From from = (From) object;
				if (partnerLink.equals(from.getPartnerLink())) {
					from.getElement().setAttribute(BPELConstants.AT_PARTNER_LINK, name);
				}
				
			// To
			} else if (object instanceof To) {
				To to = (To) object;
				if (partnerLink.equals(to.getPartnerLink())) {
					to.getElement().setAttribute(BPELConstants.AT_PARTNER_LINK, name);
				}
			}
		}
	}
	
	/**
	 * Updates the references to the counter variable of the Foreach activity
	 * 
	 * @param forEach
	 *            from which the counter variable is renamed
	 * @param name
	 *            new name of the counter variable
	 */
	private static void updateForeachCounterVariableNameReferences(ForEach forEach, String name) {
		EObject nearestScopeOrProcess = BPELUtils.getNearestScopeOrProcess(forEach);
		if (nearestScopeOrProcess == null)
			return;

		updateVariableNameReferencesOnScope(nearestScopeOrProcess, forEach.getCounterName(), name); 
	}
	
	/**
	 * Helper method used by updateVariableNameReferences or
	 * updateForeachCounterVariableNameReferences to finally update the variable
	 * in a given scope
	 * 
	 * @param scope
	 *            where variable references will be renamed in doubt use the
	 *            process or use method updateVariableNameReferences or
	 *            updateForeachCounterVariableNameReferences
	 * @param variable
	 * @param name
	 */
	private static void updateVariableNameReferencesOnScope(EObject scope, Variable variable, String name) {
		TreeIterator<EObject> iter = scope.eAllContents();
		while (iter.hasNext()) {
			Object object = iter.next();
			
			// Assign: From / Variable Initialization: From
			if (object instanceof From) {
				From from = (From) object;
				if (variable.equals(from.getVariable())) {
					from.getElement().setAttribute(BPELConstants.AT_VARIABLE, name);
				}
				
			// Assign: To
			} else if (object instanceof To) {
				To to = (To) object;
				if (variable.equals(to.getVariable())) {
					to.getElement().setAttribute(BPELConstants.AT_VARIABLE, name);
				}
			
			// Receive
			} else if (object instanceof Receive) {
				Receive receive = (Receive) object;
				if (variable.equals(receive.getVariable())) {
					receive.getElement().setAttribute(BPELConstants.AT_VARIABLE, name);
				}
				
			// Reply
			} else if (object instanceof Reply) {
				Reply reply = (Reply) object;
				if (variable.equals(reply.getVariable())) {
					reply.getElement().setAttribute(BPELConstants.AT_VARIABLE, name);
				}
				
			// Invoke
			} else if (object instanceof Invoke) {
				Invoke invoke = (Invoke) object;
				// FromParts
				if (invoke.getFromParts() != null) {
					FromParts fromParts = invoke.getFromParts();
					EList<FromPart> list = fromParts.getChildren();
					for (FromPart fromPart : list) {
						if (variable.equals(fromPart.getToVariable())) {
							fromPart.getElement().setAttribute(BPELConstants.AT_TO_VARIABLE, name);
						}
					}
				}
				// ToParts
				if (invoke.getToParts() != null) {
					ToParts toParts = invoke.getToParts();
					EList<ToPart> list = toParts.getChildren();
					for (ToPart toPart : list) {
						if (variable.equals(toPart.getFromVariable())) {
							toPart.getElement().setAttribute(BPELConstants.AT_FROM_VARIABLE, name);
						}
					}
				}
				// InputVariable
				if (variable.equals(invoke.getInputVariable())) {
					invoke.getElement().setAttribute(BPELConstants.AT_INPUT_VARIABLE, name);
				}
				// OutputVariable
				if (variable.equals(invoke.getOutputVariable())) {
					invoke.getElement().setAttribute(BPELConstants.AT_OUTPUT_VARIABLE, name);
				}
				
			// Throw
			} else if (object instanceof Throw) {
				Throw _throw = (Throw) object;
				if (variable.equals(_throw.getFaultVariable())) {
					_throw.getElement().setAttribute(BPELConstants.AT_FAULT_VARIABLE, name);
				}
				
			// Catch
			} else if (object instanceof Catch) {
				Catch _catch = (Catch) object;
				if (variable.equals(_catch.getFaultVariable())) {
					_catch.getElement().setAttribute(BPELConstants.AT_FAULT_VARIABLE, name);
				}

			// Validate
			} else if (object instanceof Validate) {
				Validate validate = (Validate) object;
				EList<Variable> variables = validate.getVariables();
				// update the string directly
				// TODO refactor with: ValidateImpl.createVariablesString()
				if (variables == null || variables.size() == 0) {
					ReconciliationHelper.replaceAttribute(validate, BPELConstants.AT_VARIABLES, (String) null);
				} else {
					StringBuilder val = new StringBuilder();
					Iterator<Variable> i = variables.iterator();
					for (; i.hasNext();) {
						Variable var = i.next();

						if (variable.equals(var)) {
							val.append(name);
						} else {
							val.append(var.getName());
						}
						if (i.hasNext()) {
							val.append(" ");
						}
					}
					ReconciliationHelper.replaceAttribute(validate, BPELConstants.AT_VARIABLES, val.toString());
				}

			// OnMessage
			} else if (object instanceof OnMessage) {
				OnMessage onMessage = (OnMessage) object;
				
				if (variable.equals(onMessage.getVariable())) {
					onMessage.getElement().setAttribute(BPELConstants.AT_VARIABLE, name);
				}

			// OnEvent
			} else if (object instanceof OnEvent) {
				OnEvent onEvent = (OnEvent) object;
				if (variable.equals(onEvent.getVariable())) {
					onEvent.getElement().setAttribute(BPELConstants.AT_VARIABLE, name);
				}
			}
			// TODO XPATH, Expressions, etc.?
		}
	}

	
	/**
	 * Update all locations where variables are referenced by name to reference
	 * the new name. Does work for both local and global variables without
	 * problems
	 * 
	 * @param variable
	 *            that will be renamed
	 * @param name
	 *            the new name the variable will be renamed to
	 */
	private static void updateVariableNameReferences(Variable variable, String name) {
		// make more efficient for local variables
		EObject nearestScopeOrProcess = BPELUtils.getNearestScopeOrProcess(variable);
		if (nearestScopeOrProcess == null)
			return;

		updateVariableNameReferencesOnScope(nearestScopeOrProcess, variable, name); 
	}
	
	public static void replaceAttribute(WSDLElement element, String attributeName, String attributeValue) {
		boolean oldUpdatingDom = isUpdatingDom(element);

		Element parseElement = element.getElement();

		if (element instanceof ExtensionActivity) {
			parseElement = getExtensionActivityChildElement(parseElement);
		}
		try {
			setUpdatingDom(element, true);
			
			if (isLoading(element)) {
				return;
			}
			if (parseElement == null) {
				// https://issues.jboss.org/browse/JBIDE-8048
				// Hack to allow setting an implicit variable's attributes for OnEvent, Catch.
				// These are not real Variable objects (i.e. they are not XML elements like
				// real <variable>'s). To do this right, we really should define an
				// ImplicitVariable model object instead of reusing Variable objects inside
				// OnEvent and Catch...
				EObject parent = element.eContainer();
				if (parent instanceof OnEvent || parent instanceof Catch) {
					// ignore attempts to set attributes on the parent that aren't in the model
					for ( EStructuralFeature feature : parent.eClass().getEAllStructuralFeatures()) {
						if ( feature.getName().equals(attributeName)) {
							parseElement = ((BPELExtensibleElement)parent).getElement();
							break;
						}
					}
				}
				if (parseElement == null) {
					System.err.println("trying to replace attribute " + "\"" + attributeName + "\"" +
							" on null element " + element.getClass() + " contained in " +
							(element.eContainer() == null ? null : element.eContainer().getClass())
					);
					return;
				}
			}
			
			// This is a problem in eclipse3.6, if we use parseElement.getAttribute(attributeName) and the attribute is not in the parseElement,
			// users add a element firstly, it is ok. But when users add the same element secondly, we will get a NPE. It is a eclipse xml issue.
			// So fix as below.
			if (parseElement.getAttributes().getNamedItem(attributeName) != null && isEqual(parseElement.getAttribute(attributeName), attributeValue)) {
				return;
			}
			
			if (attributeValue != null && !attributeValue.equals("")) {
				parseElement.setAttribute(attributeName, attributeValue);
			} else {
				parseElement.removeAttribute(attributeName);
			}
			
			// update references in DOM if necessary!
			if (BPELConstants.AT_NAME.equals(attributeName)) {
				
				// Link
				if (element instanceof Link) {
					updateLinkNameReferences((Link) element, attributeValue);
				}

				// Variable
				if (element instanceof Variable) {
					updateVariableNameReferences((Variable) element, attributeValue);
				}

				// MessageExchange
				else if (element instanceof MessageExchange) {
					updateMessageExchangeNameReferences(
							(MessageExchange) element, attributeValue);
				}

				// CorrelationSet
				else if (element instanceof CorrelationSet) {
					updateCorrelationSetNameReferences(
							(CorrelationSet) element, attributeValue);
				}

				// PartnerLink
				else if (element instanceof PartnerLink) {
					updatePartnerLinkNameReferences((PartnerLink) element, attributeValue);
				}
			} else if (BPELConstants.AT_COUNTER_NAME.equals(attributeName)) {
				if (element instanceof ForEach) {
					updateForeachCounterVariableNameReferences((ForEach) element, attributeValue);
				}
			}
			
	    	// Bug 120110 - if this is not an extension activity, notify all
			// extensionActivities that this thing has changed - references
			// to this thing should be updated in the activity's XML fragment
			if ( !(element instanceof ExtensionActivity)) {
				Process process = BPELUtils.getProcess(element);
				if (process!=null) {
					TreeIterator<EObject> iter = process.eAllContents();
					while (iter.hasNext()) {
						Object object = iter.next();
						if (object instanceof ExtensionActivity) {
							((ExtensionActivity)object).updateElementReferences(element, attributeName, attributeValue);
						}
					}
				}
			}
			
		} finally {
			setUpdatingDom(element, oldUpdatingDom);
		}
	}
	
	public static void replaceAttribute(WSDLElement element, String attributeName, QName attributeValue) {
		if (isLoading(element)) {
			return;
		}
		replaceAttribute(element, attributeName, attributeValue == null ? null : ElementFactory.getInstance().createName(element, attributeValue));
	}
		
	public static void replaceLiteral(From from, String literal) {
		boolean oldUpdatingDom = isUpdatingDom(from);
		try {
			setUpdatingDom(from, true);		
			
			Element parentElement = from.getElement();
			if (parentElement == null || isLoading(from)) {
				return;
			}
			Element oldLiteral = ReconciliationHelper.getBPELChildElementByLocalName(parentElement, BPELConstants.ND_LITERAL);
			Node newLiteral = literal == null ? null : ElementFactory.getInstance().createLiteral(from, literal);
			if (oldLiteral == null) {
				if (newLiteral != null) {
					ElementPlacer.placeChild(from, newLiteral);
				}
			} else {
				if (newLiteral != null) {
					parentElement.replaceChild(newLiteral, oldLiteral);
				} else {
					parentElement.removeChild(oldLiteral);
				}
			}
		} finally {
			setUpdatingDom(from, oldUpdatingDom);
		}
	}
	
	public static void replaceText(WSDLElement parent, Object newText) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
			if (isLoading(parent)) {
				return;
			}
	
			Element element = parent.getElement();
			if (parent instanceof ExtensionActivity) {
				element = getExtensionActivityChildElement(element);
			}
			if (element == null) {
				System.err.println("trying to replace text on null element");
				return;
			}
	
			ArrayList<Node> nodesToRemove = getTextNodes(element);
			for (Node n : nodesToRemove) {
				element.removeChild(n);
			}
	
			// TODO: (DU) Here must be some method like in BPELWriter.expression2XML
			if (newText != null && !newText.toString().equals("")) {
				CDATASection cdata = BPELUtils.createCDATASection(element
						.getOwnerDocument(), newText.toString());
				ElementPlacer.placeChild(parent, cdata);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}

	private static ArrayList<Node> getTextNodes(Element element) {
		ArrayList<Node> nodesToRemove = new ArrayList<Node>();
		Node node = element.getFirstChild();		
		boolean bCData = false;		
		while (node != null) {
			switch (node.getNodeType()) {
			case Node.TEXT_NODE:
				if (bCData) {
					break;
				}
				nodesToRemove.add(node);
				break;
			case Node.CDATA_SECTION_NODE:
				if (bCData == false) {
					nodesToRemove.clear();
					bCData = true;
				}
				nodesToRemove.add(node);
				break;
			}
			node = node.getNextSibling();
		}
		return nodesToRemove;
	}
	
	public static void replaceExpression(WSDLElement parent, Expression newExpression) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
				if (isLoading(parent)) {
				return;
			}
			if (parent.getElement() == null) {
				System.err.println("trying to replace expression on null element:" + parent.getClass());
				return;
			}
			Element element = parent.getElement();
			if (newExpression != null) {
				if (newExpression.getExpressionLanguage() != null) {
					element.setAttribute("expressionLanguage", newExpression.getExpressionLanguage());
				}
				replaceText(parent, newExpression.getBody());			
			} else {
				replaceText(parent, null);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	
	/**
	 * This will replace the Snippet node of the parent node
	 */
	public static void replaceSnippet(WSDLElement parent, Snippet newSnippet) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
				if (isLoading(parent)) {
				return;
			}
			if (parent.getElement() == null) {
				System.err.println("trying to replace snippet on null element:" + parent.getClass());
				return;
			}
			Element element = parent.getElement();
			if (newSnippet != null) {
				replaceText(parent, newSnippet.getBody());			
			} else {
				replaceText(parent, null);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	public static void replaceFaultOnFailure(WSDLElement parent, FaultOnFailure newFaultOnFailure) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
				if (isLoading(parent)) {
				return;
			}
			if (parent.getElement() == null) {
				System.err.println("trying to replace FaultOnFailure on null element:" + parent.getClass());
				return;
			}
			Element element = parent.getElement();
			if (newFaultOnFailure != null) {
				replaceText(parent, newFaultOnFailure.isValue());			
			} else {
				replaceText(parent, null);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	public static void replaceRetryFor(WSDLElement parent, RetryFor newRetryFor) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
				if (isLoading(parent)) {
				return;
			}
			if (parent.getElement() == null) {
				System.err.println("trying to replace RetryFor on null element:" + parent.getClass());
				return;
			}
			Element element = parent.getElement();
			if (newRetryFor != null) {
				replaceText(parent, newRetryFor.getValue());			
			} else {
				replaceText(parent, null);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	public static void replaceRetryDelay(WSDLElement parent, RetryDelay newRetryDelay) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
				if (isLoading(parent)) {
				return;
			}
			if (parent.getElement() == null) {
				System.err.println("trying to replace RetryDelay on null element:" + parent.getClass());
				return;
			}
			Element element = parent.getElement();
			if (newRetryDelay != null) {
				replaceText(parent, newRetryDelay.getValue());			
			} else {
				replaceText(parent, null);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	public static void replaceFaultHandler(WSDLElement parent, FaultHandler newFaultHandler) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
			if (isLoading(parent)) {
				return;
			}
			if (parent.getElement() == null) {
				System.err.println("trying to replace faultHandler on null element:" + parent.getClass());
				return;
			}
			Element parentElement = parent.getElement();
			if (parent instanceof ExtensionActivity) {
				parentElement = getExtensionActivityChildElement(parentElement);
			}
			for (Element node : ReconciliationHelper.getBPELChildElementsByLocalName(parentElement, BPELConstants.ND_CATCH)) {
				parentElement.removeChild(node);
			}
			parentElement.removeChild(ReconciliationHelper.getBPELChildElementByLocalName(parentElement, BPELConstants.ND_CATCH_ALL));
			if (newFaultHandler != null) {
				ElementFactory.getInstance().writeFaultHandler(newFaultHandler, parent);
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}
	
	public static Node replaceValue(ServiceRef serviceRef, Node oldValueNode, Object newValue) {
		boolean oldUpdatingDom = isUpdatingDom(serviceRef);
		try {
			setUpdatingDom(serviceRef, true);
			
			if (isLoading(serviceRef)) {
				return null;
			}
			if (serviceRef.getElement() == null) {
				return null;
			}

			Node newValueNode = ElementFactory.getInstance().createValue(serviceRef);
			if (oldValueNode == null && newValueNode != null) {
				ElementPlacer.placeChild(serviceRef, newValueNode);
			} else if (oldValueNode != null && newValueNode != null) {
				serviceRef.getElement().replaceChild(newValueNode, oldValueNode);
			}
			return newValueNode;
		} finally {
			setUpdatingDom(serviceRef, oldUpdatingDom);
		}
	}
	
	static boolean isUpdatingDom(WSDLElement element) {
		if (element instanceof BPELExtensibleElementImpl) {
			return ((BPELExtensibleElementImpl) element).isUpdatingDOM();			
		} else if (element instanceof BPELExtensibilityElementImpl) {
			return ((BPELExtensibilityElementImpl) element).isUpdatingDOM();			
		} 
		return false;
	}
	
	static void setUpdatingDom(WSDLElement element, boolean updatingDOM) {
		if (element instanceof BPELExtensibleElementImpl) {
			((BPELExtensibleElementImpl) element).setUpdatingDOM(updatingDOM);			
		} else if (element instanceof BPELExtensibilityElementImpl) {
			((BPELExtensibilityElementImpl) element).setUpdatingDOM(updatingDOM);			
		} 
	}
	
	private ReconciliationBPELReader getReader(WSDLElement element, Element changedElement) {
		ReconciliationBPELReader reader = document2reader.get(changedElement.getOwnerDocument());
		if (reader == null) {
			reader = new ReconciliationBPELReader(BPELUtils.getProcess(element));
			document2reader.put(changedElement.getOwnerDocument(), reader);			
		}
		return reader;
	}
	
	public void patchDom(EObject child, EObject parent, Node parentElement, EObject before, Node beforeElement) {
		
        // If the parent object is an ExtensionActivity, then we need to set the
        // new child as child of the <extensionActivity> element child and not the <extensionActivity> itself. 
        // This code snippet changes the parentElement to the correct subelement
        if (parent instanceof ExtensionActivity) {
			// Bugzilla 324115
			// Fix NPE
            Node realParent = ReconciliationHelper.getExtensionActivityChildElement((Element) parentElement);
            if (realParent!=null)
            	parentElement = realParent;
        }
		
		if (child instanceof Variable) {
			parentElement = patchParentElement(child, parent, parentElement, BPELConstants.ND_VARIABLES, BPELConstants.ND_VARIABLE);
		} else if (child instanceof CorrelationSet) {
			parentElement = patchParentElement(child, parent, parentElement, BPELConstants.ND_CORRELATION_SETS, BPELConstants.ND_CORRELATION_SET);
		} else if (child instanceof PartnerLink) {
			parentElement = patchParentElement(child, parent, parentElement, BPELConstants.ND_PARTNER_LINKS, BPELConstants.ND_PARTNER_LINK);
		} else if (child instanceof MessageExchange) {
			parentElement = patchParentElement(child, parent, parentElement, BPELConstants.ND_MESSAGE_EXCHANGES, BPELConstants.ND_MESSAGE_EXCHANGE);
		}
		
		// TODO: (DU) probably this if will be no longer needed when sync work is finished
	    if (!BPELUtils.isTransparent(parent, child)) {
	    	Element childElement = ((WSDLElement)child).getElement();
			if (childElement == null) {
	    		childElement = ElementFactory.getInstance().createElement(((BPELExtensibleElement)child), parent);
	    		((BPELExtensibleElement)child).setElement(childElement);
	    	}
			if (childElement.getParentNode() != parentElement) {
				System.err.println("Non-reconciling element:" + parent.getClass());
				parentElement.insertBefore(childElement, beforeElement);
			}
		} else if (child instanceof FaultHandler) {
			((FaultHandler) child).setElement((Element) parentElement);
	    }
	    
	    // This code is to handle particular types that are created with their children
	    if (child instanceof ForEach) {
	    	ForEach forEach = (ForEach)child;
	    	Variable counter = forEach.getCounterName();
	    	if (counter.getElement() == null) {
	    		replaceAttribute(forEach, BPELConstants.AT_COUNTER_NAME, counter.getName());
	    	}
	    } else if (child instanceof Scope) {
	    	
	    } else if (child instanceof Pick) {
	    	
	    } else if (child instanceof Assign) {
	    	
	    } else if (child instanceof Catch) {
	    	Catch c = (Catch)child;
	    	reconcile(c, c.getElement());
			System.err.println("Catch patch ok");
	    } else if (child instanceof CatchAll) {
	    	CatchAll c = (CatchAll)child;
	    	reconcile(c, c.getElement());
			System.err.println("CatchAll patch ok");
	    } else if (child instanceof TerminationHandler) {
	    	TerminationHandler th = (TerminationHandler)child;
	    	reconcile(th, th.getElement());
			System.err.println("TerminationHandler patch ok");
	    } else if (child instanceof OnEvent) {
	    	
	    } else if (child instanceof OnAlarm) {
	        // fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=330308
	    	OnAlarm o = (OnAlarm)child;
	    	Activity a = o.getActivity();
	    	Element s = ReconciliationHelper.getBPELChildElementByLocalName(o.getElement(), BPELConstants.ND_SCOPE);
	    	a.setElement(s);
	    	reconcile(a, s);
	    } else if (child instanceof FaultHandler) {
	    	FaultHandler c = (FaultHandler)child;
	    	EList<Catch> _catch = c.getCatch();
			if (_catch.size() == 1 && _catch.get(0).getElement() == null) {
				Catch ch = _catch.get(0);
				Element catchElement = ReconciliationHelper.getBPELChildElementByLocalName(c.getElement(), BPELConstants.ND_CATCH);
				ch.setElement(catchElement);
				reconcile(ch, catchElement);
	    	}
			System.err.println("FaultHandler patch ok");
	    } else if (child instanceof EventHandler) {
	    	// fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=330308
	    	EventHandler e = (EventHandler)child;
	    	EList<OnEvent> _onEvent = e.getEvents();
	    	OnEvent on = _onEvent.get(0);
	    	Element onElement = ReconciliationHelper.getBPELChildElementByLocalName(e.getElement(), BPELConstants.ND_ON_EVENT);
	    	on.setElement(onElement);
	    	reconcile(on, onElement);
	    }  else if (child instanceof CompensationHandler) {
	    	// fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=330308
	    	CompensationHandler c = (CompensationHandler)child;
	    	Activity a = c.getActivity();
	    	Element s = ReconciliationHelper.getBPELChildElementByLocalName(c.getElement(), BPELConstants.ND_SEQUENCE);
	    	a.setElement(s);
	    	reconcile(a, s);
	    }

	    	
	}

	public Node patchParentElement(EObject child, EObject parent, Node parentElement, String parentNodeName, String nodeName) {
		WSDLElement variables = (WSDLElement)parent;
		WSDLElement	var = (WSDLElement)child;
		WSDLElement container = (WSDLElement)variables.eContainer();
		
		if (variables.getElement() == null && container != null && container.getElement() != null) {			
			parentElement = ReconciliationHelper.getBPELChildElementByLocalName(container.getElement(), parentNodeName);
			variables.setElement(parentElement != null ? (Element)parentElement : ElementFactory.getInstance().createElement(variables, container));
			var.setElement(ReconciliationHelper.getBPELChildElementByLocalName(variables.getElement(), nodeName));
			if (parentElement == null) {
				ElementPlacer.placeChild(container, variables.getElement());
				parentElement = variables.getElement();
			}
		}
		
		return parentElement;
	}
	
	/**
	 * Returns the first child node of <code>parentElement</code> that is an
	 * {@link Element} with a BPEL namespace and the given
	 * <code>localName</code>, or <code>null</code> if a matching element
	 * is not found.
	 * 
	 * @param parentElement
	 *            the element to find the children of
	 * @param localName
	 *            the localName to match against
	 * @return the first matching element, or null if no element was found
	 */
	public static Element getBPELChildElementByLocalName(Element parentElement,
			String localName) {
		if (parentElement == null) {
			return null;
		}
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName())) {
				return (Element) node;
			}
		}
		return null;
	}
	
	/**
	 * Returns a snippet element of parent ExtensionAssignOperation
	 * 
	 */
	
	protected static Element getSnippet(Element parentElement) {
		String localName = "snippet";
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName())) {
                return (Element) node;
            }
		}
		return null;
	}
	
	/**
	 * Returns a list of child activity nodes of <code>parentElement</code>
	 * Returns an empty list if no matching elements are found.
	 * 
	 * @param parentElement
	 *            the element to find the children of	 
	 * @return a node list of the matching children of parentElement
	 */
	public static List<Element> getActivities(Element parentElement) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (BPELUtils.isActivityNode(node)) {
				list.add((Element) node);
			}
		}
		return list;
	}

	/**
	 * Returns a list of child nodes of <code>parentElement</code> that are
	 * {@link Element}s with a BPEL namespace that have the given
	 * <code>localName</code>. Returns an empty list if no matching elements
	 * are found.
	 * 
	 * @param parentElement
	 *            the element to find the children of
	 * @param localName
	 *            the localName to match against
	 * @return a node list of the matching children of parentElement
	 */
	public static List<Element> getBPELChildElementsByLocalName(
			Element parentElement, String localName) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName())
					&& BPELUtils.isBPELElement(node)) {
				list.add((Element) node);
			}
		}
		return list;
	}

	public static void updateVariableName(WSDLElement parent, String varName) {
		if (parent == null || parent.getElement() == null) {
			return;
		}
		if (parent instanceof Catch) {
			replaceAttribute(parent, BPELConstants.AT_FAULT_VARIABLE, varName);
		}
	}
	
	public static void adoptChild(WSDLElement parent, List<? extends WSDLElement> children, WSDLElement newChild, String nodeName) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			
			if (isLoading(parent) || parent.getElement() == null) {
				return;
			}
			Element parseElement = parent.getElement();
			
			if (parent instanceof ExtensionActivity) {
				parseElement = getExtensionActivityChildElement(parseElement);
			}
			if (newChild.getElement() == null) {
				newChild.setElement(ElementFactory.getInstance().createElement(newChild, parent));
			}
			if (newChild.getElement().getParentNode() == parseElement) {
				// already in the dom tree
				return;
			}
			int index = children.indexOf(newChild);
			List<Element> domChildren;
			if (parent instanceof Sequence || parent instanceof Flow) {
				domChildren = getActivities(parseElement);
			} else {
				domChildren = ReconciliationHelper.getBPELChildElementsByLocalName(parseElement, nodeName);
			}
			if (index >= domChildren.size()) {
				ElementPlacer.placeChild(parent, newChild.getElement());
			} else {
				ElementPlacer.niceInsertBefore(parent, newChild.getElement(), domChildren.get(index));
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}

	public static void orphanChild(WSDLElement parent, WSDLElement child) {
		boolean oldUpdatingDom = isUpdatingDom(parent);
		try {
			setUpdatingDom(parent, true);
			if (isLoading(parent) || parent.getElement() == null) {
				return;
			}
			if (parent.getElement() != null && child.getElement() != null
					&& child.getElement().getParentNode() == parent.getElement()) {
				parent.getElement().removeChild(child.getElement());
			}
			
			// We should delete enclosing element only if child has been 
			// deleted from GUI (parent.isReconciling == false)
			// If we delete child in source tab then parent should be kept intact 
	
			// Remove <variables> if there are no children
			if ((child instanceof Variable) && (((Variables) parent).getChildren().size() == 0) && !((VariablesImpl)parent).isReconciling()){
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setVariables(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setVariables(null);
				else
					throw new IllegalStateException();
			}
			// Remove <partnerlinks> if there are no children
			if ((child instanceof PartnerLink) && (((PartnerLinks) parent).getChildren().size() == 0) && !((PartnerLinksImpl)parent).isReconciling()){
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setPartnerLinks(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setPartnerLinks(null);
				else
					throw new IllegalStateException();
			}
			// Remove <correlationsets> if there are no children
			if ((child instanceof CorrelationSet) && (((CorrelationSets) parent).getChildren().size() == 0) && !((CorrelationSetsImpl)parent).isReconciling()){
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setCorrelationSets(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setCorrelationSets(null);
				else
					throw new IllegalStateException();
			}
			// Remove <messageExchanges> if there are no children
			if ((child instanceof MessageExchange) && (((MessageExchanges) parent).getChildren().size() == 0) && !((MessageExchangesImpl)parent).isReconciling()) {
				if (parent.getContainer() instanceof Process)
					((Process) parent.getContainer()).setMessageExchanges(null);
				else if (parent.getContainer() instanceof Scope)
					((Scope) parent.getContainer()).setMessageExchanges(null);
				else
					throw new IllegalStateException();
			}
			if (child instanceof Catch && parent instanceof Invoke) {								
				Invoke invoke = (Invoke)parent;
				FaultHandler faultHandler = invoke.getFaultHandler();
				if (faultHandler.getCatch().size() == 0 && faultHandler.getCatchAll() == null) {
					invoke.setFaultHandler(null);
				}
			}
		} finally {
			setUpdatingDom(parent, oldUpdatingDom);
		}
	}		
//    public static Collection<Element> getContentNodes(WSDLElement element, Element changedElement) {
//        Collection<Element> result = new ArrayList<Element>();
//        for (Node child = changedElement.getFirstChild(); child != null; child = child.getNextSibling()) {
//            if (child.getNodeType() == Node.ELEMENT_NODE) {
//                result.add((Element)child);
//            } else {
//                System.err.println("getContentNodes:" + element.getClass() + ", child: " + child);
//            }
//        }
//        return result;
//    }
//    
//    private static class MyBPELReader extends BPELReader {
//        protected void setProperties(Element element, EObject object, String propertyName) {
//            super.setProperties(element, object, propertyName);
//        }
//    }
//    
//    static public Activity createActivity(Element child) {
//        String bpelType = child.getLocalName();
//
//        if (bpelType.equals(BPELConstants.ND_EMPTY)) {
//            Empty empty = BPELFactory.eINSTANCE.createEmpty();
//            empty.setElement(child);
//            return empty;
//        } else if (bpelType.equals(BPELConstants.ND_INVOKE)) {
//            Invoke invoke = BPELFactory.eINSTANCE.createInvoke();
//            invoke.setElement(child);
//            return invoke;
//        } else if (bpelType.equals(BPELConstants.ND_RECEIVE)) {
//            Receive receive = BPELFactory.eINSTANCE.createReceive();
//            receive.setElement(child);
//            return receive;
//        } else if (bpelType.equals(BPELConstants.ND_REPLY)) {
//            Reply reply = BPELFactory.eINSTANCE.createReply();
//            reply.setElement(child);
//            return reply;
//        } else if (bpelType.equals(BPELConstants.ND_VALIDATE)) {
//            Validate validate = BPELFactory.eINSTANCE.createValidate();
//            validate.setElement(child);
//            return validate;
//        } else if (bpelType.equals(BPELConstants.ND_IF)) {
//            If _if = BPELFactory.eINSTANCE.createIf();
//            _if.setElement(child);
//            return _if;
//        } else if (bpelType.equals(BPELConstants.ND_PICK)) {
//            Pick pick = BPELFactory.eINSTANCE.createPick();
//            pick.setElement(child);
//            return pick;
//        } else if (bpelType.equals(BPELConstants.ND_WHILE)) {
//            While _while = BPELFactory.eINSTANCE.createWhile();
//            _while.setElement(child);
//            return _while;
//        } else if (bpelType.equals(BPELConstants.ND_FOR_EACH)) {
//            ForEach foreach = BPELFactory.eINSTANCE.createForEach();
//            foreach.setElement(child);
//            return foreach;
//        } else if (bpelType.equals(BPELConstants.ND_REPEAT_UNTIL)) {
//            RepeatUntil repeatUntil = BPELFactory.eINSTANCE.createRepeatUntil();
//            repeatUntil.setElement(child);
//            return repeatUntil;
//        } else if (bpelType.equals(BPELConstants.ND_WAIT)) {
//            Wait wait = BPELFactory.eINSTANCE.createWait();
//            wait.setElement(child);
//            return wait;
//        } else if (bpelType.equals(BPELConstants.ND_SEQUENCE)) {
//            Sequence sequence = BPELFactory.eINSTANCE.createSequence();
//            sequence.setElement(child);
//            return sequence;
//        } else if (bpelType.equals(BPELConstants.ND_SCOPE)) {
//            Scope scope = BPELFactory.eINSTANCE.createScope();
//            scope.setElement(child);
//            return scope;
//        } else if (bpelType.equals(BPELConstants.ND_FLOW)) {
//            Flow flow = BPELFactory.eINSTANCE.createFlow();
//            flow.setElement(child);
//            return flow;
//        } else if (bpelType.equals(BPELConstants.ND_EXIT)) {
//            Exit exit = BPELFactory.eINSTANCE.createExit();
//            exit.setElement(child);
//            return exit;
//        } else if (bpelType.equals(BPELConstants.ND_THROW)) {
//            Throw _throw = BPELFactory.eINSTANCE.createThrow();
//            _throw.setElement(child);
//            return _throw;
//        } else if (bpelType.equals(BPELConstants.ND_RETHROW)) {
//            Rethrow rethrow = BPELFactory.eINSTANCE.createRethrow();
//            rethrow.setElement(child);
//            return rethrow;
//        } else if (bpelType.equals(BPELConstants.ND_COMPENSATE)) {
//            Compensate compensate = BPELFactory.eINSTANCE.createCompensate();
//            compensate.setElement(child);
//            return compensate;
//        } else if (bpelType.equals(BPELConstants.ND_COMPENSATE_SCOPE)) {
//            CompensateScope compensateScope = BPELFactory.eINSTANCE.createCompensateScope();
//            compensateScope.setElement(child);
//            return compensateScope;
//        } else if (bpelType.equals(BPELConstants.ND_ASSIGN)) {
//            Assign assign = BPELFactory.eINSTANCE.createAssign();
//            assign.setElement(child);
//            return assign;
//        } 
//        return null;
//    }
//    
//    public static void setProperties(Element element, EObject eObject, String propertyName) {
//        MyBPELReader reader = new MyBPELReader();
//        reader.setProperties(element, eObject, propertyName);
//    }
//
    public static boolean isSingleActivityContainer(Object context) {
        if (context instanceof If)  return true;
        if (context instanceof ForEach)  return true;
        if (context instanceof ElseIf)  return true;
        if (context instanceof Else)  return true;
        if (context instanceof Catch)  return true;
        if (context instanceof CatchAll)  return true;
        if (context instanceof OnAlarm)  return true;
        if (context instanceof OnMessage)  return true;
        if (context instanceof OnEvent)  return true;
        if (context instanceof Process)  return true;
        if (context instanceof While)  return true;
        if (context instanceof RepeatUntil)  return true;
        if (context instanceof CompensationHandler) return true;
        if (context instanceof Scope) return true;
        if (context instanceof ExtensionActivity) return true;
        //TODO: DElegate this call to the app. Ext Activity Impl
        return false;
    }
//
    
    static private boolean isEqual ( String s1, String s2 ) {
		return s1 != null ? s1.equals(s2) : s2 == null;
	}
    
//    public static EList getActivities(Object context) {
//        if (context instanceof Sequence) {
//            return ((Sequence)context).getActivities();         
//        }
//        if (context instanceof Flow) {
//            return ((Flow)context).getActivities();         
//        }
//        throw new IllegalArgumentException();
//    }
//    
    public static Activity getActivity(Object context) {
        if (context instanceof ElseIf)  return ((ElseIf)context).getActivity();
        if (context instanceof ForEach) return ((ForEach)context).getActivity();
        if (context instanceof Else)  return ((Else)context).getActivity();
        if (context instanceof Catch)  return ((Catch)context).getActivity();
        if (context instanceof CatchAll)  return ((CatchAll)context).getActivity();
        if (context instanceof OnAlarm)  return ((OnAlarm)context).getActivity();
        if (context instanceof OnMessage)  return ((OnMessage)context).getActivity();
        if (context instanceof OnEvent)  return ((OnEvent)context).getActivity();
        if (context instanceof Process)  return ((Process)context).getActivity();
        if (context instanceof While)  return ((While)context).getActivity();
        if (context instanceof RepeatUntil)  return ((RepeatUntil)context).getActivity();
        if (context instanceof Scope)  return ((Scope)context).getActivity();
        if (context instanceof FaultHandler) return getCatchAll((FaultHandler)context);
        if (context instanceof CompensationHandler)  return ((CompensationHandler)context).getActivity();
        if (context instanceof TerminationHandler)  return ((TerminationHandler)context).getActivity();
        if (context instanceof If) return ((If) context).getActivity();
		// Bugzilla 324115
        if (context instanceof ExtensionActivity)
        {
        	ExtensionActivity ea = (ExtensionActivity)context;
        	for (EStructuralFeature sf : ea.eClass().getEAllStructuralFeatures())
        	{
        		if (sf.getName().equals("activity"))
        			return (Activity) ea.eGet(sf);
        	}
        }
        System.err.println("Missing getActivity():" + context.getClass());
        throw new IllegalArgumentException();
    }
//
//    public static void setActivity(Object context, Activity activity) {
//        if (context instanceof ElseIf) {
//            ((ElseIf)context).setActivity(activity); return;
//        }
//        if (context instanceof Else) {
//            ((Else)context).setActivity(activity); return;
//        }
//        if (context instanceof Catch) {
//            ((Catch)context).setActivity(activity); return;
//        }
//        if (context instanceof CatchAll) {
//            ((CatchAll)context).setActivity(activity); return;
//        }
//        if (context instanceof OnAlarm) {
//            ((OnAlarm)context).setActivity(activity); return;
//        }
//        if (context instanceof OnMessage) {
//            ((OnMessage)context).setActivity(activity); return;
//        }
//        if (context instanceof OnEvent) {
//            ((OnEvent)context).setActivity(activity); return;
//        }
//        if (context instanceof Process) {
//            ((Process)context).setActivity(activity); return;
//        }
//        if (context instanceof While) {
//            ((While)context).setActivity(activity); return;
//        }
//        if (context instanceof RepeatUntil) {
//            ((RepeatUntil)context).setActivity(activity); return;
//        }
//        if (context instanceof Scope) {
//            ((Scope)context).setActivity(activity); return;
//        }
//        if (context instanceof FaultHandler) {
//            setCatchAll((FaultHandler)context, activity); return;
//        }
//        if (context instanceof CompensationHandler) {
//            ((CompensationHandler)context).setActivity(activity); return;
//        }
//        if (context instanceof TerminationHandler) {
//            ((TerminationHandler)context).setActivity(activity); return;
//        }
//        if (context instanceof If) {
//            ((If)context).setActivity(activity); return;
//        }       
//        throw new IllegalArgumentException();
//    }
//
    private static Activity getCatchAll(FaultHandler faultHandler) {
        CatchAll catchAll = faultHandler.getCatchAll();
        return (catchAll == null)? null : catchAll.getActivity();
    }
//    
//    public static void setCatchAll(FaultHandler faultHandler, Activity activity) {
//        if (activity == null)  {
//            faultHandler.setCatchAll(null);
//        } else if (faultHandler.getCatchAll() == null) {
//            CatchAll catchAll = BPELFactory.eINSTANCE.createCatchAll();
//            catchAll.setElement(ElementFactory.createElement(catchAll, faultHandler));          
//            faultHandler.setCatchAll(catchAll);
//            faultHandler.getElement().appendChild(catchAll.getElement());
//            catchAll.setActivity(activity);
//        } else {
//            faultHandler.getCatchAll().setActivity(activity);
//        }
//    }   
//    
//    public static void addActivity(WSDLElement parent, Activity activity) {
//        if (isSingleActivityContainer(parent)) {
//            Activity oldActivity = getActivity(parent);         
//            if (oldActivity != null) {      
//                boolean oldFirst = parent.getElement().getFirstChild() == oldActivity.getElement();             
//                Sequence sequence;
//                if (oldActivity instanceof Sequence) {
//                    sequence = (Sequence) oldActivity;
//                } else if (activity instanceof Sequence) {
//                     sequence = (Sequence)activity;                  
//                } else {
//                    sequence = BPELFactory.eINSTANCE.createSequence();
//                    sequence.setElement(ElementFactory.createElement(sequence, parent));
//                    parent.getElement().removeChild(oldActivity.getElement());
//                }
//                setActivity(parent, activity);
//                if (oldFirst) {
//                    sequence.getActivities().add(oldActivity);
//                    sequence.getElement().appendChild(oldActivity.getElement());
//                }
//                sequence.getActivities().add(activity);
//                sequence.getElement().appendChild(activity.getElement());
//                if (!oldFirst) {
//                    sequence.getActivities().add(oldActivity);
//                    sequence.getElement().appendChild(oldActivity.getElement());
//                }
////              parent.getElement().removeChild(oldActivity.getElement());
//            } else {
//                setActivity(parent, activity);
//            }
//        } else {
//            getActivities(parent).add(activity);
//        }
//    }   	
}
