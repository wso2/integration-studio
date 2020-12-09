/*******************************************************************************
 * Copyright (c) 2007 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dennis Ushakov, Intel - Initial API and Implementation
 *
 *******************************************************************************/
package org.eclipse.bpel.model.util;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import javax.wsdl.extensions.ExtensibilityElement;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
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
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.Extensions;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.FaultOnFailure;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Query;
import org.eclipse.bpel.model.RetryDelay;
import org.eclipse.bpel.model.RetryFor;
import org.eclipse.bpel.model.ServiceRef;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.WSDLElement;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ElementFactory {
	private WeakHashMap<Document, WeakReference<MyBPELWriter>> document2Writers = new WeakHashMap<Document, WeakReference<MyBPELWriter>>();

	static class MyBPELWriter extends
			org.eclipse.bpel.model.resource.BPELWriter {
		public MyBPELWriter(
				org.eclipse.bpel.model.resource.BPELResource bpelResource,
				Document document) {
			super(bpelResource, document);
		}

		@Override
		protected Element createBPELElement(String tagName) {
			return super.createBPELElement(tagName);
		}
		
		@Override
		protected Element createElementWithName(String tagName) {
			return super.createElementWithName(tagName);
		}

		@Override
		public Element activity2XML(org.eclipse.bpel.model.Activity activity) {
			return super.activity2XML(activity);
		}

		@Override
		protected Element variable2XML(Variable variable) {
			return super.variable2XML(variable);
		}

		@Override
		protected Element variables2XML(Variables variables) {
			return super.variables2XML(variables);
		}

		@Override
		protected Element completionCondition2XML(
				CompletionCondition completionCondition) {
			return super.completionCondition2XML(completionCondition);
		}

		@Override
		protected Element expression2XML(Expression expression,
				String elementName) {
			return super.expression2XML(expression, elementName);
		}

		@Override
		protected Element branches2XML(Branches branches) {
			return super.branches2XML(branches);
		}

		@Override
		protected Element extensibilityElement2XML(
				ExtensibilityElement extensibilityElement) {
			return super.extensibilityElement2XML(extensibilityElement);
		}

		@Override
		protected Element correlationSets2XML(CorrelationSets correlationSets) {
			return super.correlationSets2XML(correlationSets);
		}

		@Override
		protected Element fromParts2XML(FromParts fromParts) {
			return super.fromParts2XML(fromParts);
		}

		@Override
		protected Element fromPart2XML(FromPart fromPart) {
			return super.fromPart2XML(fromPart);
		}

		@Override
		protected Element toParts2XML(ToParts toParts) {
			return super.toParts2XML(toParts);
		}

		@Override
		protected Element toPart2XML(ToPart toPart) {
			return super.toPart2XML(toPart);
		}

		@Override
		protected Element correlationSet2XML(CorrelationSet correlationSet) {
			return super.correlationSet2XML(correlationSet);
		}

		@Override
		protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
			return super.partnerLinks2XML(partnerLinks);
		}

		@Override
		protected Element messageExchanges2XML(MessageExchanges messageExchanges) {
			return super.messageExchanges2XML(messageExchanges);
		}

		@Override
		protected Element elseIf2XML(ElseIf elseIf) {
			return super.elseIf2XML(elseIf);
		}

		@Override
		protected Element else2XML(Else _else) {
			return super.else2XML(_else);
		}

		@Override
		protected Element onAlarm2XML(OnAlarm onAlarm) {
			return super.onAlarm2XML(onAlarm);
		}

		@Override
		protected Element onMessage2XML(OnMessage onMsg) {
			return super.onMessage2XML(onMsg);
		}

		@Override
		protected Element onEvent2XML(OnEvent onEvent) {
			return super.onEvent2XML(onEvent);
		}

		@Override
		protected Element copy2XML(Copy copy) {
			return super.copy2XML(copy);
		}

		@Override
		protected Element catch2XML(Catch _catch) {
			return super.catch2XML(_catch);
		}
		
		@Override
		protected Element extensionAssignOperation2XML(ExtensionAssignOperation extensionAssignOperation) {
			return super.extensionAssignOperation2XML(extensionAssignOperation);
		}

		@Override
		protected Element catchAll2XML(CatchAll catchAll) {
			return super.catchAll2XML(catchAll);
		}

		@Override
		protected Element compensationHandler2XML(
				CompensationHandler compensationHandler) {
			return super.compensationHandler2XML(compensationHandler);
		}

		@Override
		protected void to2XML(To to, Element toElement) {
			super.to2XML(to, toElement);
		}

		@Override
		protected void from2XML(From from, Element fromElement) {
			super.from2XML(from, fromElement);
		}

		@Override
		protected Element eventHandler2XML(EventHandler eventHandler) {
			return super.eventHandler2XML(eventHandler);
		}

		@Override
		protected Element partnerLink2XML(PartnerLink partnerLink) {
			return super.partnerLink2XML(partnerLink);
		}

		@Override
		protected Element messageExchange2XML(MessageExchange messageExchange) {
			return super.messageExchange2XML(messageExchange);
		}

		@Override
		protected Element validate2XML(Validate activity) {
			return super.validate2XML(activity);
		}

		@Override
		protected Element query2XML(Query query) {
			return super.query2XML(query);
		}

		@Override
		protected Element faultHandlers2XML(FaultHandler faultHandler) {
			return super.faultHandlers2XML(faultHandler);
		}

		@Override
		protected void faultHandler2XML(Element parentElement,
				FaultHandler faultHandler) {
			super.faultHandler2XML(parentElement, faultHandler);
		}

		@Override
		protected Element import2XML(Import imp) {
			return super.import2XML(imp);
		}

		@Override
		protected Element correlation2XML(Correlation correlation) {
			return super.correlation2XML(correlation);
		}

		@Override
		protected Element correlations2XML(Correlations correlations) {
			return super.correlations2XML(correlations);
		}

		@Override
		protected String properties2XML(CorrelationSet correlationSet) {
			return super.properties2XML(correlationSet);
		}

		@Override
		protected Element link2XML(Link link) {
			return super.link2XML(link);
		}

		@Override
		protected Element links2XML(Links links) {
			return super.links2XML(links);
		}

		@Override
		protected Element extension2XML(Extension extension) {
			return super.extension2XML(extension);
		}

		@Override
		protected Element extensions2XML(Extensions extensions) {
			return super.extensions2XML(extensions);
		}

		@Override
		protected Element terminationHandler2XML(
				TerminationHandler terminationHandler) {
			return super.terminationHandler2XML(terminationHandler);
		}

		@Override
		protected Element source2XML(Source source) {
			return super.source2XML(source);
		}

		@Override
		protected Element sources2XML(Sources sources) {
			return super.sources2XML(sources);
		}

		@Override
		protected Element target2XML(Target target) {
			return super.target2XML(target);
		}

		@Override
		protected Element targets2XML(Targets targets) {
			return super.targets2XML(targets);
		}

		@Override
		protected Element serviceRef2XML(ServiceRef serviceRef) {
			return super.serviceRef2XML(serviceRef);
		}

		@Override
		protected Node serviceRefValue2XML(ServiceRef serviceRef) {
			return super.serviceRefValue2XML(serviceRef);
		}
		
		@Override
		protected Element documentation2XML(Documentation documentation) {
			return super.documentation2XML(documentation);
		}
		
		/**
		 * for failureHandling extension provided by ODE: JIRA:TOOLS-785
		 * 
		 */
		@Override
		protected Element failureHandling2XML(FailureHandling failureHandling)
		{
			return super.failureHandling2XML(failureHandling);
		}
		
		@Override
		protected Element faultOnFailure2XML(FaultOnFailure faultOnFailure, Element faultOnFailureElement)
		{
			return super.faultOnFailure2XML(faultOnFailure, faultOnFailureElement);
		}
		@Override
		protected Element retryFor2XML(RetryFor retryFor, Element retryForElement)
		{
			return super.retryFor2XML(retryFor, retryForElement);
		}
		@Override
		protected Element retryDelay2XML(RetryDelay retryDelay, Element retryDelayElement)
		{
			return super.retryDelay2XML(retryDelay, retryDelayElement);
		} 
		
	}

	private static ElementFactory factory;

	private ElementFactory() {
		super();
	}

	public static ElementFactory getInstance() {
		if (factory == null) {
			factory = new ElementFactory();
		}
		return factory;
	}

	public Element createElement(WSDLElement element, Object parent) {
		MyBPELWriter writer = getWriter(parent);
		if (element instanceof Activity) {
			return writer.activity2XML((Activity) element);
		}
		if (element instanceof Variable) {
			return writer.variable2XML((Variable) element);
		}
		if (element instanceof Variables) {
			return writer.variables2XML((Variables) element);
		}
		if (element instanceof CompletionCondition) {
			return writer
					.completionCondition2XML((CompletionCondition) element);
		}
		if (element instanceof PartnerLinks) {
			return writer.partnerLinks2XML((PartnerLinks) element);
		}
		if (element instanceof MessageExchanges) {
			return writer.messageExchanges2XML((MessageExchanges) element);
		}
		if (element instanceof CorrelationSets) {
			return writer.correlationSets2XML((CorrelationSets) element);
		}
		if (element instanceof ElseIf) {
			return writer.elseIf2XML((ElseIf) element);
		}
		if (element instanceof Else) {
			return writer.else2XML((Else) element);
		}
		if (element instanceof OnAlarm) {
			return writer.onAlarm2XML((OnAlarm) element);
		}
		if (element instanceof OnMessage) {
			return writer.onMessage2XML((OnMessage) element);
		}
		if (element instanceof OnEvent) {
			return writer.onEvent2XML((OnEvent) element);
		}
		if (element instanceof Copy) {
			return writer.copy2XML((Copy) element);
		}
		if (element instanceof Catch) {
			return writer.catch2XML((Catch) element);
		}
		if (element instanceof CatchAll) {
			return writer.catchAll2XML((CatchAll) element);
		}
		if (element instanceof CompensationHandler) {
			return writer
					.compensationHandler2XML((CompensationHandler) element);
		}
		if (element instanceof TerminationHandler) {
			return writer.terminationHandler2XML((TerminationHandler) element);
		}
		if (element instanceof To) {
			Element toElement = writer.createBPELElement("to");
			writer.to2XML((To) element, toElement);
			return toElement;
		}
		if (element instanceof From) {
			Element fromElement = writer.createBPELElement("from");
			writer.from2XML((From) element, fromElement);
			return fromElement;
		}
		if (element instanceof CorrelationSet) {
			return writer.correlationSet2XML((CorrelationSet) element);
		}
		if (element instanceof EventHandler) {
			return writer.eventHandler2XML((EventHandler) element);
		}
		if (element instanceof Branches) {
			Element branches = writer.branches2XML((Branches) element);
			branches.setAttribute(BPELConstants.AT_SUCCESSFUL_BRANCHES_ONLY,
					BPELUtils.boolean2XML(((Branches) element)
							.getCountCompletedBranchesOnly()));
			return branches;
		}
		if (element instanceof Condition) {
			return writer.expression2XML((Condition) element,
					BPELConstants.ND_CONDITION);
		}
		if (element instanceof PartnerLink) {
			return writer.partnerLink2XML((PartnerLink) element);
		}
		if (element instanceof MessageExchange) {
			return writer.messageExchange2XML((MessageExchange) element);
		}
		if (element instanceof Validate) {
			return writer.validate2XML((Validate) element);
		}
		if (element instanceof Query) {
			return writer.query2XML((Query) element);
		}
		if (element instanceof FaultHandler) {
			return writer.faultHandlers2XML((FaultHandler) element);
		}
		if (element instanceof FromParts) {
			return writer.fromParts2XML((FromParts) element);
		}
		if (element instanceof ToParts) {
			return writer.toParts2XML((ToParts) element);
		}
		if (element instanceof FromPart) {
			return writer.fromPart2XML((FromPart) element);
		}
		if (element instanceof ToPart) {
			return writer.toPart2XML((ToPart) element);
		}
		if (element instanceof Import) {
			return writer.import2XML((Import) element);
		}
		if (element instanceof Correlation) {
			return writer.correlation2XML((Correlation) element);
		}
		if (element instanceof Correlations) {
			return writer.correlations2XML((Correlations) element);
		}
		if (element instanceof Link) {
			return writer.link2XML((Link) element);
		}
		if (element instanceof Links) {
			return writer.links2XML((Links) element);
		}
		if (element instanceof Extension) {
			return writer.extension2XML((Extension) element);
		}
		if (element instanceof Extensions) {
			return writer.extensions2XML((Extensions) element);
		}
		if (element instanceof Source) {
			return writer.source2XML((Source) element);
		}
		if (element instanceof Sources) {
			return writer.sources2XML((Sources) element);
		}
		if (element instanceof Target) {
			return writer.target2XML((Target) element);
		}
		if (element instanceof Targets) {
			return writer.targets2XML((Targets) element);
		}
		if (element instanceof ServiceRef) {
			return writer.serviceRef2XML((ServiceRef) element);
		}
		if (element instanceof ExtensibilityElement) {
			return writer
					.extensibilityElement2XML((ExtensibilityElement) element);
		}
		if (element instanceof Documentation) {
			return writer.documentation2XML((Documentation) element);
		}
		// JIRA: TOOLS-785
		if (element instanceof FailureHandling){
			return writer.failureHandling2XML((FailureHandling) element);
		}
		if (element instanceof FaultOnFailure){
			Element faultOnFailureElement = writer.createElementWithName(BPELConstants.NODE_FAULT_ON_FAILURE);
			writer.faultOnFailure2XML((FaultOnFailure)element, faultOnFailureElement);
			return faultOnFailureElement;
		}
		if (element instanceof RetryDelay){
			Element retryDelayElement = writer.createElementWithName(BPELConstants.NODE_RETRY_DELAY);
			writer.retryDelay2XML((RetryDelay) element, retryDelayElement);
			return retryDelayElement;
		}
		if (element instanceof RetryFor){
			Element retryForElement = writer.createElementWithName(BPELConstants.NODE_RETRY_FOR);
			writer.retryFor2XML((RetryFor) element, retryForElement);
			return retryForElement;
		}
		
		throw new IllegalArgumentException("Cannot create element for type: " + element.getClass().getName());
	}

	public Node createLiteral(From from, String text) {
		MyBPELWriter writer = getWriter(from);
		Node node = null;
		Element literal = writer.createBPELElement("literal"); //$NON-NLS-1$
		//literal.setAttribute("xml:space", "preserve"); //$NON-NLS-1$ //$NON-NLS-2$

		if (Boolean.TRUE.equals(from.getUnsafeLiteral())) {
			node = BPELUtils.convertStringToNode(from, text, writer
					.getResource());
		}

		if (node != null) {
			for (Node child = node.getFirstChild(); child != null; child = child
					.getNextSibling()) {
				// TODO: (DU) This is here due to
				// https://issues.apache.org/jira/browse/XERCESJ-1289
				BPELUtils.copyInto(child, literal);
			}
		} else {
			CDATASection cdata = BPELUtils.createCDATASection(from.getElement()
					.getOwnerDocument(), text);
			BPELUtils.copyInto(cdata, literal);
		}

		return literal;
	}

	public String createPropertiesString(CorrelationSet correlationSet) {
		return getWriter(correlationSet).properties2XML(correlationSet);
	}

	public Element createExpressionElement(Expression element, Object parent,
			String name) {
		MyBPELWriter writer = getWriter(parent);
		return writer.expression2XML(element, name);
	}

	public String createName(WSDLElement element, QName name) {
		String namespace = name.getNamespaceURI();
		String prefix = BPELUtils.getNamespacePrefix(element, namespace);
		String localPart = name.getLocalPart();
		
		if (localPart == "") {
			return null;
		}
		
		if (prefix != null) {
			return prefix + ":" + localPart;
		} else {
			return localPart;
		}
	}	


	private MyBPELWriter getWriter(Object parent) {
		Document ownerDocument = getOwnerDocument(parent);
		MyBPELWriter writer = document2Writers.get(ownerDocument) != null ? document2Writers.get(ownerDocument).get() : null;
		if (writer == null) {
			BPELResource resource = (BPELResource) ((EObject) parent)
					.eResource();
			INamespaceMap<String, String> nsMap = BPELUtils
					.getNamespaceMap(resource.getProcess());
			if (resource.getOptionUseNSPrefix()) {
				nsMap.remove("");
				if (!nsMap.containsValue(resource.getNamespaceURI())) {
					nsMap.put(BPELConstants.PREFIX, resource.getNamespaceURI());
				}
			} else {
				nsMap.put("", resource.getNamespaceURI());
			}
			writer = new MyBPELWriter(resource, ownerDocument);
			document2Writers.put(ownerDocument, new WeakReference<MyBPELWriter>(writer));
		}
		return writer;
	}
	
	private static Document getOwnerDocument(Object parent) {
		Document ownerDocument = null;
		// if (!BPELUtils.isTransparentObject(parent)) {
		if (((BPELExtensibleElement) parent).getElement() != null)
			ownerDocument = ((BPELExtensibleElement) parent).getElement()
					.getOwnerDocument();
		// } else {
		// ownerDocument =
		// ((BPELExtensibleElement)((EObject)parent).eContainer()).getElement().getOwnerDocument();
		// }
		return ownerDocument;
	}
	
	void writeFaultHandler(FaultHandler faultHandler, WSDLElement parent) {
		getWriter(parent).faultHandler2XML(parent.getElement(), faultHandler);
	}

	public Node createValue(ServiceRef serviceRef) {
		return getWriter(serviceRef).serviceRefValue2XML(serviceRef);
	}
}