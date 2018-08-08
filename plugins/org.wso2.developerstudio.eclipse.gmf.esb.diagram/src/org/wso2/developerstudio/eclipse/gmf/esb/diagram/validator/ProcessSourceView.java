/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.impl.OMNamespaceImpl;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.AggregateMediatorFactory;
import org.apache.synapse.config.xml.BeanMediatorFactory;
import org.apache.synapse.config.xml.CallMediatorFactory;
import org.apache.synapse.config.xml.CalloutMediatorFactory;
import org.apache.synapse.config.xml.ClassMediatorFactory;
import org.apache.synapse.config.xml.CloneMediatorFactory;
import org.apache.synapse.config.xml.ConditionalRouterMediatorFactory;
import org.apache.synapse.config.xml.DBLookupMediatorFactory;
import org.apache.synapse.config.xml.DBReportMediatorFactory;
import org.apache.synapse.config.xml.DropMediatorFactory;
import org.apache.synapse.config.xml.EJBMediatorFactory;
import org.apache.synapse.config.xml.EnqueueMediatorFactory;
import org.apache.synapse.config.xml.EnrichMediatorFactory;
import org.apache.synapse.config.xml.EntryFactory;
import org.apache.synapse.config.xml.FaultMediatorFactory;
import org.apache.synapse.config.xml.FilterMediatorFactory;
import org.apache.synapse.config.xml.ForEachMediatorFactory;
import org.apache.synapse.config.xml.HeaderMediatorFactory;
import org.apache.synapse.config.xml.InvokeMediatorFactory;
import org.apache.synapse.config.xml.IterateMediatorFactory;
import org.apache.synapse.config.xml.LogMediatorFactory;
import org.apache.synapse.config.xml.LoopBackMediatorFactory;
import org.apache.synapse.config.xml.MessageProcessorFactory;
import org.apache.synapse.config.xml.MessageStoreFactory;
import org.apache.synapse.config.xml.POJOCommandMediatorFactory;
import org.apache.synapse.config.xml.PayloadFactoryMediatorFactory;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.config.xml.ProxyServiceFactory;
import org.apache.synapse.config.xml.RespondMediatorFactory;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.SwitchMediatorFactory;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.config.xml.TransactionMediatorFactory;
import org.apache.synapse.config.xml.URLRewriteMediatorFactory;
import org.apache.synapse.config.xml.ValidateMediatorFactory;
import org.apache.synapse.config.xml.XSLTMediatorFactory;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.config.xml.eventing.EventPublisherMediatorFactory;
import org.apache.synapse.config.xml.inbound.InboundEndpointFactory;
import org.apache.synapse.config.xml.rest.APIFactory;
import org.apache.synapse.mediators.bsf.ScriptMediatorFactory;
import org.apache.synapse.mediators.spring.SpringMediatorFactory;
import org.apache.synapse.mediators.throttle.ThrottleMediatorFactory;
import org.apache.synapse.mediators.xquery.XQueryMediatorFactory;
import org.apache.synapse.startup.quartz.SimpleQuartzFactory;
import org.wso2.carbon.identity.entitlement.mediator.config.xml.EntitlementMediatorFactory;
import org.wso2.carbon.identity.oauth.mediator.config.xml.OAuthMediatorFactory;
import org.wso2.carbon.mediator.cache.CacheMediatorFactory;
import org.wso2.carbon.mediator.datamapper.config.xml.DataMapperMediatorFactory;
import org.wso2.carbon.mediator.event.xml.EventMediatorFactory;
import org.wso2.carbon.mediator.fastXSLT.config.xml.FastXSLTMediatorFactory;
import org.wso2.carbon.mediator.service.MediatorException;
import org.wso2.carbon.mediator.transform.xml.SmooksMediatorFactory;
import org.wso2.carbon.relay.mediators.builder.xml.BuilderMediatorFactory;
import org.wso2.carbon.rule.mediator.RuleMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.BamMediatorExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.sheet.XMLTag;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.namespace.QName;

/**
 * Process source view content
 *
 */
public class ProcessSourceView {

	private static SourceError sourceError = new SourceError();
	private static Stack<XMLTag> xmlTags;
	private static Queue<XMLTag> xmlTagsQueue = new LinkedList<>();
	private static Set<String> mediators = new HashSet<>(Arrays.asList("log", "call", "enqueue", "send", "loopback",
			"respond", "event", "drop", "enrich", "property", "filter", "call-template", "sequence", "store", "switch",
			"validate", "conditionalRouter", "bean", "class", "pojoCommand", "ejb", "script", "spring", "enrich",
			"fault", "header", "payload", "smooks", "rewrite", "xquery", "xslt", "datamapper", "fastXSLT", "cache",
			"dbreport", "dblookup", "event", "throttle", "transaction", "aggregate", "callout", "clone", "iterate",
			"foreach", "entitlementService", "oauthService", "builder", "rule", "bam", "publishEvent"));

	private static Set<String> artifacts = new HashSet<>(Arrays.asList("api", "proxy", "endpoint", "inboundEndpoint",
			"localEntry", "messageProcessor", "store", "sequence", "task", "template"));

	private static Set<String> intermediary = new HashSet<>(Arrays.asList("inSequence", "outSequence", "faultSequence",
			"resource", "description", "target", "publishWSDL", "enableAddressing", "enableSec", "enableRM", "policy",
			"parameter", "timeout", "duration", "responseAction", "markForSuspension", "action", "errorCodes",
			"retriesBeforeSuspension", "retryDelay", "suspendOnFailure", "initialDuration", "progressionFactor",
			"maximumDuration", "membershipHandler", "definition", "member", "http", "address", "failover",
			"dynamicLoadbalance", "wsdl", "loadBalance", "default", "recipientlist"));

	public ProcessSourceView() {

	}

	/**
	 * Start processing synapse content. Here we split the content and send for
	 * processing
	 * 
	 * @param xmlContent
	 *            xml content of the source view
	 * @return If there is an source view error
	 */
	public static SourceError validateSynapseContent(String xmlContent) {

		xmlTagsQueue.clear();
		if (!xmlContent.trim().isEmpty()) {
			String[] lines = xmlContent.split("\n");
			int length = 0;

			for (int i = 0; i < lines.length; i++) {
				String line = lines[i];
				processTags(line, i, length);
				length += (line.length() + 1);
			}

			return synapseValidation();
		} else {
			return null;
		}

	}

	/**
	 * Validate for the xml parser errors in the source content
	 * 
	 * @param xmlContent
	 *            source view content
	 * @return Source error
	 * @throws ValidationException
	 */
	public static SourceError validateXMLContent(String xmlContent) throws ValidationException {

		String parserClass = "org.apache.xerces.parsers.SAXParser";
		String validationFeature = "http://xml.org/sax/features/validation";
		String schemaFeature = "http://apache.org/xml/features/validation/schema";
		try {

			XMLReader r = XMLReaderFactory.createXMLReader(parserClass);
			r.setFeature(validationFeature, true);
			r.setFeature(schemaFeature, true);
			r.setErrorHandler(new MyErrorHandler());
			InputSource inputSource = new InputSource(new StringReader(xmlContent));
			r.parse(inputSource);

		} catch (SAXException e) {
			// ignore
		} catch (IOException e) {
			throw new ValidationException("Error while processig the xml content.", e);
		}

		int start = calculateLength(xmlContent, sourceError.getStartChar(), sourceError.getLineNumber());
		sourceError.setStartChar(start);
		sourceError.setEndChar(start + 1);
		return sourceError;
	}

	/**
	 * Create XML tag objects according to the source view content
	 * 
	 * @param line
	 *            Line content
	 * @param index
	 *            Line number
	 * @param length
	 *            Current content length
	 * @return List of XML tags in the line
	 */
	private static List<XMLTag> processTags(String line, int index, int length) {
		List<XMLTag> tempTags = new ArrayList<>();

		XMLTag xmlTag = new XMLTag();
		String value = line;

		xmlTag.setLine(index + 1);

		if (hasTag(value)) {
			// has a tag
			while (hasTag(value)) {
				xmlTag = new XMLTag();
				xmlTag.setLine(index + 1);

				int sT = value.indexOf("<");
				int eT = value.indexOf(">");

				if (sT != -1) {
					// has <
					if (eT != -1) {
						// has < and > ==> can be 1, 2, 3, 8
						if (value.substring(sT + 1, sT + 2).equals("/")) {
							// 2
							xmlTag.setTagType(2);
							String[] values = value.substring(sT + 2, eT).split(" ");
							xmlTag.setqName(values[0]);
						} else if (value.substring(eT - 1, eT).equals("/")) {
							// 3
							xmlTag.setTagType(3);
							String[] qName = value.substring(sT + 1).split("/| ");// **needs to be //?
							xmlTag.setqName(qName[0]);

						} else if (value.substring(sT + 1, sT + 2).equals("?")) {
							// 8
							xmlTag.setTagType(8);
						} else {
							// 1
							xmlTag.setTagType(1);
							String[] values = (value.substring(sT + 1, eT)).split(" ");
							xmlTag.setqName(values[0]);
						}

						xmlTag.setEndIndex(eT + length + 1);
						xmlTag.setStartIndex(sT + length + 1);
						xmlTag.setValue(value.substring(sT, eT + 1));
						value = value.substring(eT + 1);

					} else {
						// has < ==> can be 4 || can be 8
						if (value.substring(sT + 1, sT + 2).equals("?")) {
							xmlTag.setTagType(8);
						} else {
							xmlTag.setTagType(4);
							String[] values = (value.substring(sT + 1)).split(" ");
							xmlTag.setqName(values[0]);
						}
						xmlTag.setValue(value);
						xmlTag.setEndIndex(-1);
						xmlTag.setStartIndex(sT + length + 1);
						value = "";
					}
				} else {
					// no <
					if (eT != -1) {
						// has > ==> can be 5, 6

						if (eT > 0 && value.substring(eT - 1, eT).equals("/")) {
							xmlTag.setTagType(5);

						} else {
							if (value.substring(sT + 1, sT + 2).equals("?")) {
								xmlTag.setTagType(8);
							} else {
								// String[] qName = value.split(" ");
								// xmlTag.setqName(qName[0]);
								xmlTag.setTagType(6);
							}
						}
						xmlTag.setValue(value.substring(0, eT + 1));
						xmlTag.setEndIndex(eT + length + 1);
						xmlTag.setStartIndex(-1);
						value = value.substring(eT + 1);

					} else {
						// no tags ==> 7
						xmlTag.setValue(value);
						xmlTag.setTagType(7);
						xmlTag.setEndIndex(-1);
						xmlTag.setStartIndex(-1);

					}
				}

				xmlTagsQueue.add(xmlTag);
				tempTags.add(xmlTag);
			}
		} else {
			// whole line has no tags
			xmlTag.setValue(value);
			xmlTag.setTagType(7);
			xmlTag.setEndIndex(-1);
			xmlTag.setStartIndex(-1);

			xmlTagsQueue.add(xmlTag);
			tempTags.add(xmlTag);

			return tempTags;
		}

		return tempTags;
	}

	/**
	 * Validate created XMLTags
	 * 
	 * @return SourceError object if there is an error
	 */
	private static SourceError synapseValidation() {

		SourceError sourceError = null;
		xmlTags = new Stack<>();
		XMLTag prev = null;

		while (!xmlTagsQueue.isEmpty()) {
			XMLTag tempTag = xmlTagsQueue.remove();

			if (tempTag.isStartTag()) { // 14
				xmlTags.push(tempTag);
				// type 4 is already covered in xml validation.
				if (prev.getTagType() == 7 && !"".equals(prev.getValue().trim())) {
					String error = "Cannot have the tag \"" + prev.getValue() + "\" before the tag \""
							+ tempTag.getValue() + "\".";
					return createError(error, tempTag);
					
				}

			} else if (tempTag.isEndTag() || tempTag.getTagType() == 3) {// 235
				if (prev != null && prev.getTagType() != 8) {
					xmlTags.push(tempTag);
					if (!intermediary.contains(tempTag.getqName())) {
						sourceError = mediatorValidation();
						if (sourceError != null) {
							return sourceError;
						}
					}

				} else {
					// type 4 is already covered in xml validation.
					// can be 8
					String error = "Closing tag \"" + tempTag.getValue()
							+ "\" does not have a coresponding starting tag.";

					return createError(error, tempTag);
				}

			} else if (tempTag.getTagType() == 6 || tempTag.getTagType() == 7) {
				if (prev != null && (prev.getTagType() == 4 || prev.getTagType() == 7)) {
					xmlTags.push(tempTag);

				} else if (tempTag.getTagType() == 6) {
					String error = "Cannot have the tag \"" + prev.getValue() + "\" before the tag \""
							+ tempTag.getValue() + "\".";
					return createError(error, tempTag);
				}

			} else if (tempTag.getTagType() == 8) {
				if (prev != null && prev.getTagType() != 8) {
					String error = "Cannot have the tag \"" + prev.getValue() + "\" before the tag \""
							+ tempTag.getValue() + "\".";
					return createError(error, tempTag);
				}
				// no need to add encoding tag
			}

			prev = tempTag;
		}
		return sourceError;
	}

	/**
	 * Validate for each synapse content tags
	 * 
	 * @return SourceError object if there is an error
	 */
	private static SourceError mediatorValidation() {

		boolean insideTag = true;
		if (xmlTags.size() > 0) {

			XMLTag xmlTag = xmlTags.pop();
			String mediatorVal = xmlTag.getValue();
			String error = "";

			if (xmlTag.getTagType() == 3) {

				error = validate(mediatorVal, xmlTag.getqName());

				if (!error.equals("")) {
					return createError(error, xmlTag);
				}

			} else {

				while (insideTag) {

					if (xmlTags.size() > 0) {
						xmlTag = xmlTags.pop();
						if (xmlTag.getTagType() == 4) {
							mediatorVal = xmlTag.getValue().concat(" ".concat(mediatorVal));
						} else {
							mediatorVal = xmlTag.getValue().concat(mediatorVal);
						}

						if (xmlTag.isStartTag()) {

							error = validate(mediatorVal, xmlTag.getqName());

							if (!error.equals("")) {
								return createError(error, xmlTag);
							}

							insideTag = intermediary.contains(xmlTag.getqName());
						}
					} else {
						insideTag = false;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Create a SourceError object
	 * 
	 * @param error
	 *            Error description to add in the IMarker
	 * @param xmlTag
	 *            Current XMLTag
	 * @return Created source error
	 */
	private static SourceError createError(String error, XMLTag xmlTag) {
		SourceError sourceError = new SourceError();
		sourceError.setException(error);
		sourceError.setLineNumber(xmlTag.getLine());
		sourceError.setStartChar(xmlTag.getStartIndex());
		sourceError.setEndChar(xmlTag.getStartIndex() + xmlTag.getqName().length());

		return sourceError;
	}

	private static String validate(String mediatorVal, String qTag) {

		String error = "";

		if (intermediary.contains(qTag)) {

		} else if (artifacts.contains(qTag)) {
			error = validateArtifacts(mediatorVal, qTag);

		} else if (mediators.contains(qTag)) {
			error = validateMediators(mediatorVal, qTag);

		}
		return error;

	}

	/**
	 * Process synapse validation on artifacts such as proxy, api, endpoint, etc.
	 * 
	 * @param mediator
	 *            Mediator content
	 * @param qTag
	 *            QName of the mediator
	 * @return Error description
	 */
	private static String validateArtifacts(String mediator, String qTag) {

		try {
			OMElement omElement = AXIOMUtil.stringToOM(mediator);

			if (qTag.equals("api")) {
				APIFactory factory = new APIFactory();
				factory.createAPI(omElement);

			} else if (qTag.equals("proxy")) {
				ProxyServiceFactory factory = new ProxyServiceFactory();
				factory.createProxy(omElement, null);

			} else if (qTag.equals("endpoint")) {
				//omElement = omElement.getFirstElement();
				omElement.getFirstElement().setNamespace(new OMNamespaceImpl(SynapseConstants.SYNAPSE_NAMESPACE, ""));
				EndpointFactory.getEndpointFromElement(omElement, false, null);

				
			} else if (qTag.equals("inboundEndpoint")) {
				InboundEndpointFactory factory = new InboundEndpointFactory();
				factory.createInboundEndpoint(omElement, null);

			} else if (qTag.equals("localEntry")) {
				EntryFactory factory = new EntryFactory();
				factory.createEntry(omElement, null);

			} else if (qTag.equals("messageProcessor")) {
				MessageProcessorFactory factory = new MessageProcessorFactory();
				factory.createMessageProcessor(omElement);

			} else if (qTag.equals("store")) {
				MessageStoreFactory factory = new MessageStoreFactory();
				factory.createMessageStore(omElement, null);

			} else if (qTag.equals("sequence")) {
				SequenceMediatorFactory factory = new SequenceMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("task")) {
				SimpleQuartzFactory factory = new SimpleQuartzFactory();
				factory.createStartup(omElement);

			} else if (qTag.equals("template")) {
				TemplateMediatorFactory factory = new TemplateMediatorFactory();
				factory.createMediator(omElement, null);

			}

		} catch (SynapseException | MediatorException e) {
			return e.getMessage();
			
		} catch (XMLStreamException e) {
			// ignore
		}
		return "";
	}

	/**
	 * Validate esb mediators such as log, send, call, etc.
	 * 
	 * @param mediator
	 *            Mediator content
	 * @param qTag
	 *            QName of the mediator
	 * @return Error description
	 */
	private static String validateMediators(String mediator, String qTag) {

		try {
			OMElement omElement = AXIOMUtil.stringToOM(mediator);

			if (qTag.equals("log")) {
				LogMediatorFactory factory = new LogMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("enqueue")) {
				EnqueueMediatorFactory factory = new EnqueueMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("send")) {
				SendMediatorFactory factory = new SendMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("loopback")) {
				LoopBackMediatorFactory factory = new LoopBackMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("call")) {
				CallMediatorFactory factory = new CallMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("respond")) {
				RespondMediatorFactory factory = new RespondMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("event")) {
				EventMediatorFactory factory = new EventMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("drop")) {
				DropMediatorFactory factory = new DropMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("enrich")) {
				EnrichMediatorFactory factory = new EnrichMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("property")) {
				PropertyMediatorFactory factory = new PropertyMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("filter")) {
				FilterMediatorFactory factory = new FilterMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("call-template")) {
				InvokeMediatorFactory factory = new InvokeMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("sequence")) {
				SequenceMediatorFactory factory = new SequenceMediatorFactory();
				factory.createAnonymousSequence(omElement, null);

			} else if (qTag.equals("store")) {
				MessageProcessorFactory factory = new MessageProcessorFactory();
				factory.createMessageProcessor(omElement);

			} else if (qTag.equals("switch")) {
				SwitchMediatorFactory factory = new SwitchMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("validate")) {
				ValidateMediatorFactory factory = new ValidateMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("conditionalRouter")) {
				ConditionalRouterMediatorFactory factory = new ConditionalRouterMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("bean")) {
				BeanMediatorFactory factory = new BeanMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("class")) {
				ClassMediatorFactory factory = new ClassMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("pojoCommand")) {
				POJOCommandMediatorFactory factory = new POJOCommandMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("ejb")) {
				EJBMediatorFactory factory = new EJBMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("script")) {
				Properties properties = new Properties();
				ScriptMediatorFactory factory = new ScriptMediatorFactory();
				factory.createMediator(omElement, properties);

			} else if (qTag.equals("spring")) {
				SpringMediatorFactory factory = new SpringMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("enrich")) {
				EnrichMediatorFactory factory = new EnrichMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("fault")) {
				FaultMediatorFactory factory = new FaultMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("header")) {
				HeaderMediatorFactory factory = new HeaderMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("payload")) {
				PayloadFactoryMediatorFactory factory = new PayloadFactoryMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("smooks")) {
				SmooksMediatorFactory factory = new SmooksMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("rewrite")) {
				URLRewriteMediatorFactory factory = new URLRewriteMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("xquery")) {
				XQueryMediatorFactory factory = new XQueryMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("xslt")) {
				XSLTMediatorFactory factory = new XSLTMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("datamapper")) {
				DataMapperMediatorFactory factory = new DataMapperMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("fastXSLT")) {
				FastXSLTMediatorFactory factory = new FastXSLTMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("cache")) {
				CacheMediatorFactory factory = new CacheMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("dbreport")) {
				DBReportMediatorFactory factory = new DBReportMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("dblookup")) {
				DBLookupMediatorFactory factory = new DBLookupMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("event")) {
				EventMediatorFactory factory = new EventMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("throttle")) {
				ThrottleMediatorFactory factory = new ThrottleMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("transaction")) {
				TransactionMediatorFactory factory = new TransactionMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("aggregate")) {
				AggregateMediatorFactory factory = new AggregateMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("callout")) {
				CalloutMediatorFactory factory = new CalloutMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("clone")) {
				CloneMediatorFactory factory = new CloneMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("iterate")) {
				IterateMediatorFactory factory = new IterateMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("foreach")) {
				ForEachMediatorFactory factory = new ForEachMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("entitlementService")) {
				EntitlementMediatorFactory factory = new EntitlementMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("oauthService")) {
				OAuthMediatorFactory factory = new OAuthMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("builder")) {
				BuilderMediatorFactory factory = new BuilderMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("rule")) {
				RuleMediatorFactory factory = new RuleMediatorFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("bam")) {
				BamMediatorExtFactory factory = new BamMediatorExtFactory();
				factory.createMediator(omElement, null);

			} else if (qTag.equals("publishEvent")) {
				EventPublisherMediatorFactory factory = new EventPublisherMediatorFactory();
				factory.createMediator(omElement, null);

			}

		} catch (SynapseException | MediatorException e) {
			return e.getMessage();
			
		} catch (XMLStreamException e) {
			// ignore
		}
		return "";
	}

	/**
	 * Check whether there is a tag within the source view line
	 * 
	 * @param value
	 *            Source view content
	 * @return Whether content has a tag or not
	 */
	private static boolean hasTag(String value) {
		return value.contains("<") || value.contains(">");
	}

	/**
	 * Calculate the current length of the source view.
	 * 
	 * @param xml
	 *            Full source view content
	 * @param start
	 *            Current tag starting index
	 * @param line
	 *            Line number
	 * @return Starting index acording to the source view
	 */
	private static int calculateLength(String xml, int start, int line) {
		int length = 0;
		String[] lines = xml.split("\n");
		for (int i = 0; i < line - 1; i++) {
			length += (lines[i].length() + 1);
		}
		length = length + start;
		return length;
	}

	/**
	 * Set xml parser errors for the sourceError object.
	 */
	private static class MyErrorHandler extends DefaultHandler {
		String errorMsg = "";

		public void fatalError(SAXParseException e) throws SAXException {
			errorMsg = errorMsg + " " + e.getMessage();
			sourceError.setException(errorMsg);
			sourceError.setLineNumber(e.getLineNumber());
			sourceError.setStartChar(e.getColumnNumber() - 2);
		}

		public void error(SAXParseException e) throws SAXException {
			errorMsg = errorMsg + " " + e.getMessage();
			sourceError.setException(errorMsg);
		}
	}
}
