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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.impl.OMNamespaceImpl;
import org.apache.axiom.om.impl.llom.OMElementImpl;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.ProxyServiceFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.config.xml.endpoints.EndpointFactory;
import org.apache.synapse.task.SynapseTaskException;
import org.wso2.carbon.mediator.service.MediatorException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyAPIFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyInboundEndpointFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyMediatorFactoryFinder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyMessageProcessorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyMessageStoreFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.DummyTaskDescriptionFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer.EntryExtFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.sheet.XMLTag;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Process source view content
 *
 */
public class ProcessSourceView {

    private static final String PARSER_CLASS = "org.apache.xerces.parsers.SAXParser";
    private static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
    private static final String SCHEMA_FEATURE = "http://apache.org/xml/features/validation/schema";
    private static final String SYNAPSE_NAMESPACE = "http://ws.apache.org/ns/synapse";
    private static final String IN_SEQUENCE = "inSequence";
    private static final String OUT_SEQUENCE = "outSequence";
    private static final String FAULT_SEQUENCE = "faultSequence";
    private static final String START_COMMENT = "<!--";
    private static final String END_COMMENT = "-->";
    
    private static SourceError sourceError = new SourceError();
    private static Stack<XMLTag> xmlTags;
    private static Queue<XMLTag> xmlTagsQueue = new LinkedList<>();
    private static Set<String> mediators = new HashSet<>(Arrays.asList("log", "call", "enqueue", "send", "loopback",
            "respond", "event", "drop", "enrich", "property", "filter", "call-template", "sequence", "store", "switch",
            "validate", "conditionalRouter", "bean", "class", "pojoCommand", "ejb", "script", "spring", "enrich",
            "makefault", "header", "payloadFactory", "smooks", "rewrite", "xquery", "xslt", "datamapper", "fastXSLT",
            "cache", "dbreport", "dblookup", "event", "throttle", "transaction", "aggregate", "callout", "clone",
            "iterate", "foreach", "entitlementService", "oauthService", "builder", "rule", "bam", "publishEvent",
            "builder", "propertyGroup", "jsontransform"));

    private static Set<String> artifacts = new HashSet<>(Arrays.asList("api", "proxy", "endpoint", "inboundEndpoint",
            "localEntry", "messageProcessor", "messageStore", "sequence", "task", "template"));

    private static Set<String> intermediary = new HashSet<>(Arrays.asList("inSequence", "outSequence", "faultSequence",
            "resource", "description", "target", "publishWSDL", "enableAddressing", "enableSec", "enableRM", "policy",
            "parameter", "timeout", "duration", "responseAction", "markForSuspension", "action", "errorCodes",
            "retriesBeforeSuspension", "retryDelay", "suspendOnFailure", "initialDuration", "progressionFactor",
            "maximumDuration", "membershipHandler", "definition", "member", "http", "address", "failover",
            "dynamicLoadbalance", "wsdl", "loadBalance", "default", "recipientlist", "format", "args", "source",
            "onCacheHit", "protocol", "methods", "headersToExcludeInHash", "responseCodes", "enableCacheControl",
            "includeAgeHeader", "hashGenerator", "implementation", "onReject", "onAccept", "obligations", "advice",
            "case", "on-fail", "then", "else", "eventSink", "streamName", "streamVersion", "attributes", "meta",
            "correlation", "payload", "arbitrary", "serverProfile", "streamConfig", "with-param", "schema", "feature",
            "code", "reason", "equal", "condition", "include", "detail", "input", "output", "rewriterule", "variable",
            "result", "messageCount", "correlateOn", "completeCondition", "onComplete", "configuration", "source",
            "messageBuilder", "target", "ruleSet", "properties", "input", "output", "attribute", "arg", "fact",
            "trigger", "in", "out", "handlers", "handler", "session", "match", "role"));
    
    private static Set<String> graphicalEndpoint = new HashSet<>(Arrays.asList("loadbalance", "failover", "recipientlist"));
    
    private static Set<String> proxySequence = new HashSet<>(Arrays.asList("inSequence", "outSequence", "faultSequence"));
    
    private static Set<String> dbMediatorImtermediary = new HashSet<>(Arrays.asList("driver", "url", "user", "password",
            "connection", "statement", "pool", "sql", "result"));
    
    private static SequenceMediatorFactory sequenceMediatorFactory;
    private static TemplateMediatorFactory templateMediatorFactory;

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
     * This method is to validate the mediator positions with drop, loopback, send, and respond mediators.
     * 
     * @param xmlContent source view content
     * @throws TransformerException
     */
    public static void validateMediatorPosition(String xmlContent) throws TransformerException {

        String erroneousMediator = "";

        try {
            OMElement element = AXIOMUtil.stringToOM(xmlContent);

            String localName = element.getLocalName();

            if (localName.equals("proxy")) {

                OMElement target = (OMElement) element.getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, "target"));
                OMElement inSequence = target.getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, IN_SEQUENCE));
                if (inSequence != null) {
                    erroneousMediator = processSequence(inSequence, IN_SEQUENCE);
                }
                if (erroneousMediator.equals("")) {
                    OMElement outSequence = target.getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, OUT_SEQUENCE));
                    if (outSequence != null) {
                        erroneousMediator = processSequence(outSequence, OUT_SEQUENCE);
                    }
                }

                if (erroneousMediator.equals("")) {
                    OMElement faultSequence = target
                            .getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, FAULT_SEQUENCE));
                    if (faultSequence != null) {
                        erroneousMediator = processSequence(faultSequence, FAULT_SEQUENCE);
                    }
                }

            } else if (localName.equals("api")) {
                Iterator resources = element.getChildrenWithName(new QName(SYNAPSE_NAMESPACE, "resource"));
                while (resources.hasNext()) {
                    Object resourceObj = resources.next();
                    if (resourceObj instanceof OMElement) {

                        OMElement resource = (OMElement) resourceObj;
                        if (erroneousMediator.equals("")) {
                            OMElement inSequence = resource
                                    .getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, IN_SEQUENCE));
                            if (inSequence != null) {
                                erroneousMediator = processSequence(inSequence, IN_SEQUENCE);
                            }
                        }
                        if (erroneousMediator.equals("")) {
                            OMElement outSequence = resource
                                    .getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, OUT_SEQUENCE));
                            if (outSequence != null) {
                                erroneousMediator = processSequence(outSequence, OUT_SEQUENCE);
                            }
                        }

                        if (erroneousMediator.equals("")) {
                            OMElement faultSequence = resource
                                    .getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, FAULT_SEQUENCE));
                            if (faultSequence != null) {
                                erroneousMediator = processSequence(faultSequence, FAULT_SEQUENCE);
                            }
                        }
                    }
                }

            } else if (localName.equals("sequence")) {
                erroneousMediator = processSequence(element, "sequence");

            } else if (localName.equals("template") && xmlContent.contains("sequence")) {
                OMElement sequence = (OMElement) element
                        .getFirstChildWithName(new QName(SYNAPSE_NAMESPACE, "sequence"));
                if (sequence != null) {
                    erroneousMediator = processSequence(sequence, "sequence");
                }
            }

        } catch (XMLStreamException e) {
            return;
        }

        if (!erroneousMediator.equals("")) {
            throw new TransformerException(erroneousMediator);
        }
    }

    private static String processSequence(OMElement element, String seqName) {
        boolean isError = false;

        Iterator dropElements = element.getChildrenWithName(new QName(SYNAPSE_NAMESPACE, "drop"));
        if (dropElements.hasNext()) {
            // has drop mediators
            Object drop = dropElements.next();

            if (drop instanceof OMElement) {
                OMElement dropElement = (OMElement) drop;
                isError = processSiblings(dropElement);
            }

            while (!isError && dropElements.hasNext()) {
                Object dropTemp = dropElements.next();
                if (dropTemp instanceof OMElement) {
                    OMElement dropElement = (OMElement) dropTemp;
                    isError = processSiblings(dropElement);
                }
            }

            if (isError) {
                return "Cannot add mediators after the Drop mediator, as it represents the end of the mediation flow "
                        + "where the current message will be stopped processing.";
            }
        }

        Iterator sendElements = element.getChildrenWithName(new QName(SYNAPSE_NAMESPACE, "send"));
        if (sendElements.hasNext()) {
            // has send mediators
            Object send = sendElements.next();

            if (send instanceof OMElement) {
                OMElement sendElement = (OMElement) send;
                isError = processSiblings(sendElement);
            }

            while (!isError && sendElements.hasNext()) {
                Object sendTemp = sendElements.next();
                if (sendTemp instanceof OMElement) {
                    OMElement sendElement = (OMElement) sendTemp;
                    isError = processSiblings(sendElement);
                }
            }

            if (isError) {
                return "Cannot add mediators after the Send mediator, as it is used to send messages out of synapse to an endpoint.";
            }
        }

        Iterator loopbackElements = element.getChildrenWithName(new QName(SYNAPSE_NAMESPACE, "loopback"));
        if (loopbackElements.hasNext()) {
            // has loopback mediators
            if (seqName.equals(OUT_SEQUENCE) || seqName.equals(FAULT_SEQUENCE)) {
                return "Loopback mediator is not allowed to be added in " + seqName
                        + ", as it is used to move the message from" + " inSequence to outSequence.";
            }

            Object loopback = loopbackElements.next();
            if (loopback instanceof OMElement) {
                OMElement loopbackElement = (OMElement) loopback;
                isError = processSiblings(loopbackElement);
            }

            while (!isError && loopbackElements.hasNext()) {
                Object loopbackTemp = loopbackElements.next();
                if (loopbackTemp instanceof OMElement) {
                    OMElement loopbackElement = (OMElement) loopbackTemp;
                    isError = processSiblings(loopbackElement);
                }
            }

            if (isError) {
                return "Cannot add mediators after the Loopback mediator, as it is used to move the message from inSequence to outSequence.";
            }
        }

        Iterator respondElements = element.getChildrenWithName(new QName(SYNAPSE_NAMESPACE, "respond"));
        if (respondElements.hasNext()) {
            // has respond mediators
            Object respond = respondElements.next();

            if (respond instanceof OMElement) {
                OMElement respondElement = (OMElement) respond;
                isError = processSiblings(respondElement);
            }

            while (!isError && respondElements.hasNext()) {
                Object respondTemp = respondElements.next();
                if (respondTemp instanceof OMElement) {
                    OMElement resondElement = (OMElement) respondTemp;
                    isError = processSiblings(resondElement);
                }
            }

            if (isError) {
                return "Cannot add mediators after the Respond mediator, as it stops the processing on the current message and"
                        + " sends the message back to the client as a response.";
            }
        }

        return "";
    }

    /**
     * Processes the siblings of a given OMNode and returns true if there are any other mediator related OMElements
     * afterward. Else, returns false.
     * 
     * @param omElement current mediator OMElement
     * @return
     */
    private static boolean processSiblings(OMElement omElement) {
        OMNode nextSibling = omElement.getNextOMSibling();
        if (nextSibling != null) {
            if (nextSibling instanceof OMElement) {
                return true;
            } else if (nextSibling instanceof OMText) {
                if (getNextOMElement((OMText) nextSibling) != null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Returns with the next OMElement sibling
     * 
     * @param text current text node
     * @return
     */
    private static OMElement getNextOMElement(OMText text) {
        OMNode nextNode = text.getNextOMSibling();
        if (nextNode instanceof OMElement) {
            return (OMElement) nextNode;

        } else if (nextNode != null && nextNode instanceof OMText) {
            return getNextOMElement((OMText) nextNode);

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

        try {

            XMLReader r = XMLReaderFactory.createXMLReader(PARSER_CLASS);
            r.setFeature(VALIDATION_FEATURE, true);
            r.setFeature(SCHEMA_FEATURE, true);
            r.setErrorHandler(new MyErrorHandler());
            InputSource inputSource = new InputSource(new StringReader(xmlContent));
            r.parse(inputSource);

        } catch (SAXException e) {
            // ignore
        } catch (IOException e) {
            throw new ValidationException("Error while processing the xml content.", e);
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
            while (hasTag(value) || hasString(value)) {
                xmlTag = new XMLTag();
                xmlTag.setLine(index + 1);

                int startTag = value.indexOf("<");
                int endTag = value.indexOf(">");
                boolean order = endTag > startTag;

                if (hasStringBeforeTag(value, startTag)) {
                    xmlTag.setTagType(7);
                    xmlTag.setEndIndex(startTag + length + 1);
                    xmlTag.setStartIndex(0 + length + 1);
                    xmlTag.setValue(value.substring(0, startTag));
                    value = value.substring(startTag);

                } else if (startTag != -1) {
                    // has <
                    if (endTag != -1) {
                        // has < and > ==> can be 1, 2, 3, 8
                        if (order) {
                            if (value.substring(startTag + 1, startTag + 2).equals("/")) {
                                // 2
                                xmlTag.setTagType(2);
                                String[] values = value.substring(startTag + 2, endTag).split(" ");
                                xmlTag.setqName(values[0]);
                            } else if (value.substring(endTag - 1, endTag).equals("/")) {
                                // 3
                                xmlTag.setTagType(3);
                                String[] qName = value.substring(startTag + 1).split("/| ");// **needs to be //?
                                xmlTag.setqName(qName[0]);

                            } else if (value.substring(startTag + 1, startTag + 2).equals("?")) {
                                // 8
                                xmlTag.setTagType(8);
                            } else if (value.substring(startTag + 1, startTag + 2).equals("!")) {
                                // 7 <![CDATA[ ]]>
                                xmlTag.setTagType(7);
                            } else {
                                // 1
                                xmlTag.setTagType(1);
                                String[] values = (value.substring(startTag + 1, endTag)).split(" ");
                                xmlTag.setqName(values[0]);
                            }

                            xmlTag.setEndIndex(endTag + length + 1);
                            xmlTag.setStartIndex(startTag + length + 1);
                            xmlTag.setValue(value.substring(startTag, endTag + 1));
                            value = value.substring(endTag + 1);

                        } else {

                            if (endTag > 0 && value.substring(endTag - 1, endTag).equals("/")) {
                                xmlTag.setTagType(5);

                            } else {
                                if (value.substring(endTag - 1, endTag).equals("?")) {
                                    xmlTag.setTagType(8);
                                } else if (value.substring(endTag - 1, endTag).equals("]")) {
                                    // 7 ]]>
                                    xmlTag.setTagType(7);
                                } else {
                                    xmlTag.setTagType(6);
                                }
                            }
                            xmlTag.setValue(value.substring(0, endTag + 1));
                            xmlTag.setEndIndex(endTag + length + 1);
                            xmlTag.setStartIndex(-1);
                            value = value.substring(endTag + 1);
                        }

                    } else {
                        // has < ==> can be 4 || can be 8
                        if (value.substring(startTag + 1, startTag + 2).equals("?")) {
                            xmlTag.setTagType(8);
                        } else if (value.substring(startTag + 1, startTag + 2).equals("!")) {
                            // 7 <![CDATA[
                            xmlTag.setTagType(7);
                        } else {
                            xmlTag.setTagType(4);
                            String[] values = (value.substring(startTag + 1)).split(" ");
                            xmlTag.setqName(values[0]);
                        }
                        xmlTag.setValue(value);
                        xmlTag.setEndIndex(-1);
                        xmlTag.setStartIndex(startTag + length + 1);
                        value = "";
                    }
                } else {
                    // no <
                    if (endTag != -1) {
                        // has > ==> can be 5, 6

                        if (endTag > 0 && value.substring(endTag - 1, endTag).equals("/")) {
                            xmlTag.setTagType(5);

                        } else {
                            if (endTag > 0 && value.substring(endTag - 1, endTag).equals("?")) {
                                xmlTag.setTagType(8);
                            } else if (endTag > 0 && value.substring(endTag - 1, endTag).equals("]")) {
                                // 7 ]]>
                                xmlTag.setTagType(7);
                            } else {
                                xmlTag.setTagType(6);
                            }
                        }
                        xmlTag.setValue(value.substring(0, endTag + 1));
                        xmlTag.setEndIndex(endTag + length + 1);
                        xmlTag.setStartIndex(-1);
                        value = value.substring(endTag + 1);

                    } else {
                        // no tags ==> 7
                        xmlTag.setValue(value);
                        xmlTag.setTagType(7);
                        xmlTag.setEndIndex(-1);
                        xmlTag.setStartIndex(-1);
                        value = "";

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
        Stack<XMLTag> intermediaryStack = new Stack<>();
        boolean insideRuleSet = false;
        String artifactType = "";
        boolean insideGraphicalEp = false;
        boolean graphicalEpInsideArtifact = false;
        boolean insideTargetTag = false;
        boolean insideProxySequence = false;
        boolean insideTemplate = false;
        boolean isComment = false;
        boolean insidePublishWSDL = false;

        while (!xmlTagsQueue.isEmpty()) {
            XMLTag tempTag = xmlTagsQueue.remove();

            if (tempTag.isStartTag()) { // 14
                if (!isComment) {
                    xmlTags.push(tempTag);
                }

                if (!insidePublishWSDL && tempTag.getqName().equals("publishWSDL")) {
                	insidePublishWSDL = true;
                	continue;
                } else if (insidePublishWSDL) {
                	continue;
                }
                
                if (tempTag.getqName().equals("target")) {
                    insideTargetTag = true;
                }

                if (tempTag.getqName().equals("template")) {
                	insideTemplate = true;
                }
                
                if (insideTargetTag && proxySequence.contains(tempTag.getqName())) {
                    insideProxySequence = true;
                }
                
                if (artifactType.equals("") && artifacts.contains(tempTag.getqName())) {
                    artifactType = tempTag.getqName();
                }

                if (artifactType.equals("endpoint") && graphicalEndpoint.contains(tempTag.getqName())) {
                    insideGraphicalEp = true;
                } else if (!artifactType.equals("") && graphicalEndpoint.contains(tempTag.getqName())) {
                    graphicalEpInsideArtifact = true;
                }

                if (tempTag.getqName().equals("ruleSet")) {
                    insideRuleSet = true;
                }

                if ((!tempTag.getqName().equals("sequence") && !tempTag.getqName().equals("endpoint")
                        && mediators.contains(tempTag.getqName()))) {
                    if (!artifactType.equals("localEntry") && (!tempTag.getqName().equals("rule")
                            || (tempTag.getqName().equals("rule") && !insideRuleSet))) {
                        if (intermediaryStack.size() > 0) {
                            XMLTag next = intermediaryStack.pop();
                            intermediaryStack.push(next);
                            if (next != null && !next.getqName().equals("payloadFactory") && !next.getqName().equals("validate")) {
                                intermediaryStack.push(tempTag);
                            }
                        } else {
                            intermediaryStack.push(tempTag);
                        }
                    }

                } else if (tempTag.getqName().equals("sequence")) {
                    if (intermediaryStack.size() > 0) {
                        XMLTag next = intermediaryStack.pop();
                        intermediaryStack.push(next);
                        if (!artifactType.equals("localEntry") && (!(next.getqName().equals("foreach")
                                || next.getqName().equals("clone") || next.getqName().equals("iterate")
                                || (next.getqName().equals("payloadFactory"))))) {
                            intermediaryStack.push(tempTag);
                        }
                    } else {
                        if (!artifactType.equals("localEntry") && !artifactType.equals("sequence")) {
                            intermediaryStack.push(tempTag);
                        }
                    }
                } else if (tempTag.getqName().equals("endpoint")) {
                    if (!insideGraphicalEp || !graphicalEpInsideArtifact) {
                        intermediaryStack.push(tempTag);
                    }
                }

            } else if (tempTag.isEndTag() || tempTag.getTagType() == 3) {// 235

                if (tempTag.getValue().trim().startsWith(START_COMMENT)) {
                    isComment = true;
                } else if (isComment && tempTag.getValue().trim().endsWith(END_COMMENT)) {
                    isComment = false;
                }
            	
                if (insidePublishWSDL && tempTag.getqName().equals("publishWSDL")) {
                	insidePublishWSDL = false;
                	xmlTags.push(tempTag);
                	continue;
                } else if (insidePublishWSDL) {
                	xmlTags.push(tempTag);
                	continue;
                }
                
                if (insideTargetTag && tempTag.getqName().equals("target")) {
                    insideTargetTag = false;
                }
                
                if (insideTemplate && tempTag.getqName().equals("template")) {
                	insideTemplate = false;
                }

                if (insideTargetTag && proxySequence.contains(tempTag.getqName())) {
                    insideProxySequence = false;
                }
                
                if (tempTag.getqName().equals("ruleSet")) {
                    insideRuleSet = false;
                }

                if (artifactType.equals("endpoint") && insideGraphicalEp && graphicalEndpoint.contains(tempTag.getqName())) {
                    insideGraphicalEp = false;
                }
                
                if (graphicalEpInsideArtifact && graphicalEndpoint.contains(tempTag.getqName())) {
                    graphicalEpInsideArtifact = false;
                }

                if (prev != null && prev.getTagType() != 8) {
                	if (!isComment) {
                		xmlTags.push(tempTag);
                	} else if (isComment && tempTag.getValue().trim().endsWith(END_COMMENT)) {
                		isComment = false;
                	}
                    XMLTag currentMediator = null;

                    if (intermediaryStack.size() > 0) {
                        currentMediator = intermediaryStack.pop();
                    }

                    if (!intermediary.contains(tempTag.getqName()) && ((tempTag.getTagType() == 3)
                            || (currentMediator != null && currentMediator.getqName().equals(tempTag.getqName()))
                            || artifacts.contains(tempTag.getqName()) || (currentMediator != null && currentMediator.getqName().equals("property") && intermediary.size() > 0))) {

                        if (tempTag.getTagType() == 3 && currentMediator != null
                                && ((currentMediator.getqName().equals("payloadFactory")
                                        && !tempTag.getqName().equals("payloadFactory"))
                                        || (currentMediator.getqName().equals("throttle") && !tempTag.getqName().equals("throttle")) 
                                        || (currentMediator.getqName().equals("pojoCommand") && !tempTag.getqName().equals("pojoCommand")) 
                                        || (currentMediator.getqName().equals("validate") && !tempTag.getqName().equals("validate"))
                                        || (currentMediator.getqName().equals("enrich") && !tempTag.getqName().equals("enrich"))
                                        || (currentMediator.getqName().equals("header") && !tempTag.getqName().equals("header")))) {
                            intermediaryStack.push(currentMediator);

                        } else if (currentMediator != null && currentMediator.getqName().equals("rule")) {

                            if (!insideRuleSet && tempTag.getqName().equals("rule")) {
                                sourceError = mediatorValidation();
                                if (sourceError != null) {
                                    return sourceError;
                                }

                            } else {
                                if (currentMediator != null) {
                                    intermediaryStack.push(currentMediator);
                                }
                            }

                        } else if (currentMediator != null && currentMediator.getqName().equals("makefault")) {
                            XMLTag next;
                            if (intermediaryStack.size() > 0) {
                                next = intermediaryStack.pop();
                                if (next != null && next.getqName().equals("validate")) {
                                    intermediaryStack.push(next);

                                } else {
                                    sourceError = mediatorValidation();
                                    if (sourceError != null) {
                                        return sourceError;
                                    }
                                }

                            } else {
                                sourceError = mediatorValidation();
                                if (sourceError != null) {
                                    return sourceError;
                                }
                            }

                        } else if (tempTag.getqName().equals("sequence")) {

                            if (currentMediator != null && (currentMediator.getqName().equals("foreach")
                                    || currentMediator.getqName().equals("clone")
                                    || currentMediator.getqName().equals("iterate")
                                    || currentMediator.getqName().equals("payloadFactory"))) {
                                intermediaryStack.push(currentMediator);

                            } else if (!artifactType.equals("localEntry") && !artifactType.equals("template")) {
                                sourceError = mediatorValidation();
                                if (sourceError != null) {
                                    return sourceError;
                                }
                            }

                        } else {
                            if (currentMediator != null
                                    && (currentMediator.getqName().equals("foreach")
                                            || currentMediator.getqName().equals("clone")
                                            || currentMediator.getqName().equals("iterate")
                                            || currentMediator.getqName().equals("property") || currentMediator.getqName().equals("jsontransform"))
                                    && !tempTag.getqName().equals(currentMediator.getqName())) {
                                intermediaryStack.push(currentMediator);

                            } else if ((!artifactType.equals("localEntry") && tempTag.getTagType() == 3
                                    && (currentMediator == null
                                            || currentMediator != null && !currentMediator.getqName().equals("filter")))
                                    || (tempTag.getTagType() != 3 && (currentMediator != null
                                            && tempTag.getqName().equals(currentMediator.getqName())
                                            || (artifacts.contains(tempTag.getqName())
                                                    && !artifactType.equals("localEntry"))))) {
                                if (currentMediator != null
                                        && (currentMediator.getqName().equals("dblookup")
                                                || currentMediator.getqName().equals("dbreport"))
                                        && dbMediatorImtermediary.contains(tempTag.getqName())) {
                                    intermediaryStack.push(currentMediator);
	
                            	} else if (((!tempTag.getqName().equals("endpoint") && !isGraphicalEP(tempTag.getqName()))
                                        || (tempTag.getqName().equals("endpoint") && !insideGraphicalEp && !graphicalEpInsideArtifact && !insideTemplate))
                                		&& (!insideTargetTag || (insideTargetTag && insideProxySequence))) {
                            		if (!isComment) {
	                                    sourceError = mediatorValidation();
	                                    if (sourceError != null) {
	                                        return sourceError;
	                                    }
                            		}
                                    if (currentMediator != null && !currentMediator.getqName().equals(tempTag.getqName())) {
                                    	intermediaryStack.push(currentMediator);
                                    }
                                }
                            } else if (currentMediator != null) {
                                intermediaryStack.push(currentMediator);
                            }
                        }

                    } else {
                        if (currentMediator != null && !isComment) {
                            if (currentMediator.getTagType() == 4 && tempTag.getTagType() == 5 
                                    && currentMediator.getValue().equals(prev.getValue())) {
                                sourceError = mediatorValidation();
                                if (sourceError != null) {
                                    return sourceError;
                                }
                                
                            } else {
                                intermediaryStack.push(currentMediator);
                            }
                        }
                    }

                } else if (tempTag.getTagType() != 3 && !tempTag.getValue().trim().endsWith(END_COMMENT)) {
                    // type 4 is already covered in xml validation.
                    // can be 8
                    String error = "Closing tag \"" + tempTag.getValue()
                            + "\" does not have a coresponding starting tag.";

                    return createError(error, tempTag);

                } else if (tempTag.getTagType() == 3 && artifacts.contains(tempTag.getqName())) {
                    xmlTags.push(tempTag);
                    sourceError = mediatorValidation();
                    if (sourceError != null) {
                        return sourceError;
                    }
                }

            } else if (tempTag.getTagType() == 6 || tempTag.getTagType() == 7) {
                if (tempTag.getValue().trim().startsWith(START_COMMENT)) {
                    isComment = true;
                } else if (isComment && tempTag.getValue().trim().endsWith(END_COMMENT)) {
                    isComment = false;
                }
            	
                if (!isComment && prev != null && (prev.getTagType() == 4 || prev.getTagType() == 7 || prev.getTagType() == 1)) {
                    xmlTags.push(tempTag);

                } else if (!isComment && intermediaryStack.size() > 0) {
                    xmlTags.push(tempTag);
                }

            } else if (tempTag.getTagType() == 8) {
                if (tempTag.getValue().contains("xml-multiple")) {
                    xmlTags.push(tempTag);

                } else if (prev != null && prev.getTagType() != 8) {
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
        String firstMediatorQTag = "";
        boolean insideRuleSet = false;
        boolean insideGraphiclEP = false;
        boolean isFirstType5 = false;//type 5 eg: "abc />"

        if (xmlTags.size() > 0) {

            XMLTag xmlTag = xmlTags.pop();
            String mediatorVal = xmlTag.getValue();
            firstMediatorQTag = xmlTag.getqName();
            if (firstMediatorQTag.equals("") && xmlTag.getTagType() == 5) {
                isFirstType5 = true;
            }
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

                        if (xmlTag.isStartTag() && (xmlTag.getqName().equals(firstMediatorQTag) || isFirstType5)) {

                            if (xmlTag.getqName().equals("rule") && insideRuleSet) {
                                insideTag = true;

                            } else if (xmlTag.getqName().equals("ruleSet")) {
                                insideRuleSet = false;
                                
                            } else if (insideGraphiclEP && graphicalEndpoint.contains(xmlTag.getqName())) {
                                insideGraphiclEP = false;
                                
                            } else if (!insideGraphiclEP) {

                                error = validate(mediatorVal, xmlTag.getqName());

                                if (error != null && !error.equals("")) {
                                    return createError(error, xmlTag);
                                }

                                insideTag = intermediary.contains(xmlTag.getqName());
                            }

                        } else {
                            if (xmlTag.isEndTag() && xmlTag.getqName().equals("ruleSet")) {
                                insideRuleSet = true;
                            } else if (xmlTag.isEndTag() && graphicalEndpoint.contains(xmlTag.getqName())) {
                                insideGraphiclEP = true;
                            } else if (xmlTag.isStartTag() && insideGraphiclEP && graphicalEndpoint.contains(xmlTag.getqName())) {
                                insideGraphiclEP = false;
                            }
                            insideTag = true;
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
            return error;

        } else if (artifacts.contains(qTag)) {
            return validateArtifacts(mediatorVal, qTag);

        } else if (mediators.contains(qTag)) {
            return MediatorValidationUtil.validateMediatorsFromString(mediatorVal, qTag);

        } else if (DummyMediatorFactoryFinder.getInstance().getFactory(mediatorVal, qTag) == null) {
            return "Invalid mediator " + mediatorVal;
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

            switch (qTag) {
			case "api":
				DummyAPIFactory.createAPI(omElement, true);
				break;
			case "proxy":
				ProxyServiceFactory.createProxy(omElement, null);
				break;
			case "endpoint":
				if (omElement.getFirstElement() != null) {
                    setNamespaceForChildren(omElement);
                } else {
                    omElement.setNamespace(new OMNamespaceImpl(SynapseConstants.SYNAPSE_NAMESPACE, ""));
                }
                EndpointFactory.getEndpointFromElement(omElement, false, null);
				break;
			case "inboundEndpoint":
				DummyInboundEndpointFactory.createInboundEndpointDev(omElement);
				break;
			case "localEntry":
				EntryExtFactory.createEntry(omElement, null);
				break;
			case "messageProcessor":
				DummyMessageProcessorFactory.createMessageProcessor(omElement, null);
				break;
			case "messageStore":
				DummyMessageStoreFactory.createMessageStore(omElement, null);
				break;
			case "sequence":
				if (sequenceMediatorFactory == null) {
                    sequenceMediatorFactory = new SequenceMediatorFactory();
                }
                sequenceMediatorFactory.createSpecificMediator(omElement, null);
				break;
			case "task":
				DummyTaskDescriptionFactory.createTaskDescription(omElement,
                        OMAbstractFactory.getOMFactory().createOMNamespace(SYNAPSE_NAMESPACE, ""));
				break;
			case "template":
				if (templateMediatorFactory == null) {
                    templateMediatorFactory = new TemplateMediatorFactory();
                }
                templateMediatorFactory.createMediator(omElement, null);
				break;
			default:
				break;
			}

        } catch (SynapseException | MediatorException | SynapseTaskException | NullPointerException e) {
            return e.getMessage();

        } catch (XMLStreamException e) {
            // ignore
        }
        return "";
    }

    /**
     * Set the namespace for all the child elements
     * 
     * @param omElement
     *            Root element
     */
    private static void setNamespaceForChildren(OMElement omElement) {
        Iterator childern = omElement.getChildren();
        OMElement currentElement = null;
        while (childern.hasNext()) {
            Object child = childern.next();
            if (child instanceof OMElementImpl) {
                currentElement = (OMElement) child;
                currentElement.setNamespace(new OMNamespaceImpl(SYNAPSE_NAMESPACE, ""));
                if (currentElement.getChildren().hasNext()) {
                    setNamespaceForChildren(currentElement);
                }

            }
        }
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
     * Check whether non empty string content exists
     * 
     * @param value
     *            Content of the line
     * @return Whether non empty string content exists
     */
    private static boolean hasString(String value) {
        if (!value.trim().equals("") && value.length() > 0) {
            return true;
        }

        return false;

    }

    /**
     * Returns whether a non empty string exists before < tag
     * 
     * @param value
     *            Content of the line
     * @return Whether there is non empty content
     */
    private static boolean hasStringBeforeTag(String value, int sT) {
        if (sT > 0 && !value.substring(0, sT).trim().equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isGraphicalEP(String qName) {
        if (qName.equals("loadbalance") || qName.equals("failover") || qName.equals("recipientlist")) {
            return true;
        }
        return false;
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
     * @return Starting index according to the source view
     */
    private static int calculateLength(String xml, int start, int line) {
        int length = 0;
        String[] lines = xml.split("\n");
        int nonEmptyLines = lines.length;
        for (int i = 0; i < line - 1; i++) {
            if (nonEmptyLines > i) {
                length += (lines[i].length() + 1);
            } else {
                length += 1;
            }
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
