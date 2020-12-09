package org.eclipse.bpel.model.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;

import org.apache.xerces.parsers.DOMParser;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.BPELPlugin;
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
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.Extension;
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
import org.eclipse.bpel.model.Process;
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
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.Wait;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.extensions.BPELExtensionDeserializer;
import org.eclipse.bpel.model.extensions.BPELExtensionRegistry;
import org.eclipse.bpel.model.extensions.BPELUnknownExtensionDeserializer;
import org.eclipse.bpel.model.extensions.ServiceReferenceDeserializer;
import org.eclipse.bpel.model.impl.DocumentationImpl;
import org.eclipse.bpel.model.impl.FromImpl;
import org.eclipse.bpel.model.impl.FromPartImpl;
import org.eclipse.bpel.model.impl.OnEventImpl;
import org.eclipse.bpel.model.impl.OnMessageImpl;
import org.eclipse.bpel.model.impl.PartnerActivityImpl;
import org.eclipse.bpel.model.impl.ToImpl;
import org.eclipse.bpel.model.impl.ToPartImpl;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.util.MessagepropertiesConstants;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.proxy.CorrelationSetProxy;
import org.eclipse.bpel.model.proxy.LinkProxy;
import org.eclipse.bpel.model.proxy.MessageExchangeProxy;
import org.eclipse.bpel.model.proxy.MessageProxy;
import org.eclipse.bpel.model.proxy.PartnerLinkProxy;
import org.eclipse.bpel.model.proxy.PartnerLinkTypeProxy;
import org.eclipse.bpel.model.proxy.PropertyProxy;
import org.eclipse.bpel.model.proxy.RoleProxy;
import org.eclipse.bpel.model.proxy.VariableProxy;
import org.eclipse.bpel.model.proxy.XSDElementDeclarationProxy;
import org.eclipse.bpel.model.proxy.XSDTypeDefinitionProxy;
import org.eclipse.bpel.model.resource.BPELLinkResolver;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.bpel.model.resource.BPELVariableResolver;
import org.eclipse.bpel.model.resource.LineCapturingDOMParser;
import org.eclipse.bpel.model.resource.LinkResolver;
import org.eclipse.bpel.model.resource.VariableResolver;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;

public class ReconciliationBPELReader extends BPELReader implements
		ErrorHandler {

	// The process we are reading
	private Process process = null;
	// The resource we are reading from
	private Resource fResource = null;
	// The document builder controls various DOM characteristics
	private DocumentBuilder docBuilder = null;
	// Registry for extensibility element serializers and deserializers
	private BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry
			.getInstance();

	private DOMParser fDOMParser;

	/** The XML Error handler */
	ErrorHandler fErrorHandler = null;

	/**
	 * The WS-BPEL Specification says how to resolve variables, taking into
	 * account scopes, etc. Technically, no one should override this behavior,
	 * but replacing this field with another implementation could allow you to
	 * optimize the search or provide different behavior.
	 */
	public static VariableResolver VARIABLE_RESOLVER = new BPELVariableResolver();

	/**
	 * The WS-BPEL Specification says how to resolve links, taking into account
	 * scopes, etc. Technically, no one should override this behavior, but
	 * replacing this field with another implementation could allow you to
	 * optimize the search or provide different behavior.
	 */

	public static LinkResolver LINK_RESOLVER = new BPELLinkResolver();

	/**
	 * Construct a new BPELReader using the given DocumentBuilder to determine
	 * how the DOM tree is constructed.
	 * 
	 * @param builder
	 *            the document builder to use when parsing the file
	 * @throws IOException
	 *             if no document builder is specified
	 */
	public ReconciliationBPELReader(DocumentBuilder builder) throws IOException {
		if (builder == null) {
			throw new IOException(BPELPlugin.INSTANCE
					.getString("%BPELReader.missing_doc_builder"));
		}
		this.docBuilder = builder;
	}

	/**
	 * @param parser
	 */
	public ReconciliationBPELReader(DOMParser parser) {
		this.fDOMParser = parser;
	}

	public ReconciliationBPELReader(Process process) {
		this.process = process;
		this.fResource = process.eResource();
	}

	public ReconciliationBPELReader() {
		this.fDOMParser = new LineCapturingDOMParser();

		// domParser.setProperty("http://xml.org/sax/features/namespaces",true);
		try {
			fDOMParser.setFeature(
					"http://apache.org/xml/features/dom/defer-node-expansion",
					false);
			fDOMParser.setFeature("http://apache.org/xml/features/xinclude",
					false);
		} catch (SAXNotRecognizedException e) {
			BPELPlugin.log("Not Recognized DOM Parser Feature", e);
		} catch (SAXNotSupportedException e) {
			BPELPlugin.log("Not Supported DOM Parser Feature", e);
		}
	}

	/**
	 * Set the error handler
	 * 
	 * @param errorHandler
	 */

	public void setErrorHandler(ErrorHandler errorHandler) {
		fErrorHandler = errorHandler;
	}

	void armErrorHandler() {

		assert (docBuilder != null || fDOMParser != null);

		if (docBuilder != null) {
			docBuilder.setErrorHandler(fErrorHandler != null ? fErrorHandler
					: this);
		} else {
			fDOMParser.setErrorHandler(fErrorHandler != null ? fErrorHandler
					: this);
		}
	}

	Document read(InputSource inputSource) throws IOException, SAXException {
		assert (docBuilder != null || fDOMParser != null) : "No document builder/parser set";

		if (docBuilder != null) {
			return docBuilder.parse(inputSource);
		}
		fDOMParser.parse(inputSource);
		return fDOMParser.getDocument();
	}

	/**
	 * Return the resource that was used to read in this BPEL process.
	 * 
	 * @return the resource that was used to read in this BPEL process.
	 */

	public Resource getResource() {
		return fResource;
	}

	/**
	 * In pass 1, we parse and create the structural elements and attributes,
	 * and add the process to the EMF resource's contents
	 * 
	 * @param document
	 *            the DOM document to parse
	 */
	protected void pass1(Document document) {
		Process p = xml2Resource(document);
		if (p != null) {
			fResource.getContents().add(p);
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
	protected List<Element> getChildElements(Element parentElement) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
				list.add((Element) children.item(i));
		}
		return list;
	}

	/**
	 * Walk from the given element up through its parents, looking for any xmlns
	 * definitions. Collect them all in a map (mapping the prefix to the
	 * namespace value) and return the map.
	 * 
	 * @param element
	 *            the element to get the xmlns definitions for
	 * @return a map of visible xmlns definitions
	 */
	protected Map<String, String> getAllNamespacesForElement(Element element) {
		Map<String, String> nsMap = new HashMap<String, String>();
		Node tempNode = element;
		while (tempNode != null && tempNode.getNodeType() == Node.ELEMENT_NODE) {
			NamedNodeMap attrs = ((Element) tempNode).getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				Attr attr = (Attr) attrs.item(i);
				// XML namespace attributes use the reserved namespace
				// "http://www.w3.org/2000/xmlns/".
				if (XSDConstants.XMLNS_URI_2000.equalsIgnoreCase(attr
						.getNamespaceURI())) {
					final String key = BPELUtils.getNSPrefixMapKey(attr
							.getLocalName());
					if (!nsMap.containsKey(key)) {
						nsMap.put(key, attr.getValue());
					}
				}
			}
			tempNode = tempNode.getParentNode();
		}
		return nsMap;
	}

	/**
	 * For all attributes of the given element, ensure that their namespace
	 * prefixes are in the resource's prefix-to-namespace-map.
	 * 
	 * @param eObject
	 * @param element
	 */
	protected void saveNamespacePrefix(EObject eObject, Element element) {
		// Map<String, String> nsMap = null; // lazy init since it may require a
		// // new map
		// NamedNodeMap attrs = element.getAttributes();
		//
		// for (int i = 0; i < attrs.getLength(); i++) {
		// Attr attr = (Attr) attrs.item(i);
		// // XML namespace attributes use the reserved namespace
		// // "http://www.w3.org/2000/xmlns/".
		// if (XSDConstants.XMLNS_URI_2000.equals(attr.getNamespaceURI())) {
		// if (nsMap == null) {
		// nsMap = BPELUtils.getNamespaceMap(eObject);
		// // nsMap =
		// ((BPELResource)fResource).getPrefixToNamespaceMap(eObject);
		// // nsMap.clear();
		// }
		// nsMap.put(BPELUtils.getNSPrefixMapKey(attr.getLocalName()),
		// attr.getValue());
		// }
		// }
	}

	/**
	 * Given a DOM Element, find the child element which is a BPEL activity (of
	 * some type), parse it, and return the Activity.
	 * 
	 * @param element
	 *            the element in which to find an activity
	 * @return the activity, or null if no activity could be found
	 */
	protected Activity getChildActivity(Object parent, Element element) {
		NodeList activityElements = element.getChildNodes();
		Activity childActivity = ReconciliationHelper.getActivity(parent);
		if (childActivity != null && childActivity.getElement() != null
				&& childActivity.getElement().getParentNode() == element) {
			return childActivity;
		}
		for (int i = 0; i < activityElements.getLength(); i++) {
			if (activityElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}

			Element activityElement = (Element) activityElements.item(i);
			Activity activity = xml2Activity(null, activityElement);

			if (activity != null) {
				return activity;
			}
		}
		return null;
	}

	/**
	 * Sets a PartnerLink element for a given EObject. The given activity
	 * element must contain an attribute named "partnerLink".
	 * 
	 * @param activityElement
	 *            the DOM element of the activity
	 * @param eObject
	 *            the EObject in which to set the partner link
	 */
	protected void setPartnerLink(Element activityElement,
			final EObject eObject, final EReference reference) {
		if (!activityElement.hasAttribute("partnerLink")) {
			eObject.eSet(reference, null);
			return;
		}

		final String partnerLinkName = activityElement
				.getAttribute("partnerLink");
		PartnerLink targetPartnerLink = BPELUtils.getPartnerLink(eObject,
				partnerLinkName);
		if (targetPartnerLink == null) {
			targetPartnerLink = new PartnerLinkProxy(getResource().getURI(),
					partnerLinkName);
		}
		eObject.eSet(reference, targetPartnerLink);
	}

	/**
	 * Sets a PartnerLink element for a given EObject. The given activity
	 * element must contain an attribute named "messageExchange".
	 * 
	 * @param activityElement
	 *            the DOM element of the activity
	 * @param eObject
	 *            the EObject in which to set the message exchange
	 */
	protected void setMessageExchange(Element activityElement,
			final EObject eObject, final EReference reference) {
		if (!activityElement.hasAttribute("messageExchange")) {
			eObject.eSet(reference, null);
			return;
		}

		final String messageExchangeName = activityElement
				.getAttribute("messageExchange");
		MessageExchange targetMessageExchange = BPELUtils.getMessageExchange(
				eObject, messageExchangeName);
		if (targetMessageExchange == null) {
			targetMessageExchange = new MessageExchangeProxy(getResource()
					.getURI(), messageExchangeName);
		}
		eObject.eSet(reference, targetMessageExchange);
	}

	/**
	 * Sets a Variable element for a given EObject. The given activity element
	 * must contain an attribute with the given name
	 * 
	 * @param activityElement
	 *            the DOM element of the activity
	 * @param eObject
	 *            the EObject in which to set the variable
	 * @param variableAttrName
	 *            the name of the attribute containing the variable name
	 * @param reference
	 *            the EReference which is the variable pointer in EObject
	 */
	protected void setVariable(Element activityElement, final EObject eObject,
			String variableNameAttr, final EReference reference) {
		if (!activityElement.hasAttribute(variableNameAttr)) {
			eObject.eSet(reference, null);
			return;
		}

		final String variableName = activityElement
				.getAttribute(variableNameAttr);
		Variable targetVariable = getVariable(eObject, variableName);
		if (targetVariable == null) {
			targetVariable = new VariableProxy(getResource().getURI(),
					variableName);
		}
		eObject.eSet(reference, targetVariable);
	}

	/**
	 * Find a Property name in element (in the named attribute) and set it into
	 * the given EObject. If EObject is a CorrelationSet, add the property to
	 * the list of properties. If it is a To, set the property.
	 * 
	 * @param element
	 *            the DOM element containing the property name
	 * @param eObject
	 *            the EObject in which to set the property
	 * @param propertyName
	 *            the name of the attribute containing the property name
	 */
	protected void setProperties(Element element, EObject eObject,
			String propertyName) {
		String propertyAttribute = element.getAttribute(propertyName);

		if (eObject instanceof CorrelationSet) {
			((CorrelationSet) eObject).getProperties().clear();
		} else if (eObject instanceof To) {
			((To) eObject).setProperty(null);
		} else if (eObject instanceof From) {
			((From) eObject).setProperty(null);
		}

		if (propertyAttribute == null) {
			return;
		}

		StringTokenizer st = new StringTokenizer(propertyAttribute);
		while (st.hasMoreTokens()) {
			QName qName = BPELUtils.createQName(element, st.nextToken());
			Property property = new PropertyProxy(getResource().getURI(), qName);
			if (eObject instanceof CorrelationSet) {
				((CorrelationSet) eObject).getProperties().add(property);
			} else if (eObject instanceof To) {
				((To) eObject).setProperty(property);
			} else if (eObject instanceof From) {
				((From) eObject).setProperty(property);
			}
		}
	}

	/**
	 * Sets a CompensationHandler element for a given eObject.
	 */
	protected void setCompensationHandler(Element element, EObject eObject) {
		Element compensationHandlerElement = ReconciliationHelper
				.getBPELChildElementByLocalName(element, "compensationHandler");

		CompensationHandler compensationHandler = null;
		if (eObject instanceof Invoke) {
			compensationHandler = ((Invoke) eObject).getCompensationHandler();
		} else if (eObject instanceof Scope) {
			compensationHandler = ((Scope) eObject).getCompensationHandler();
		}
		CompensationHandler oldCompensationHandler = compensationHandler;

		if (compensationHandlerElement != null && compensationHandler == null) {
			compensationHandler = xml2CompensationHandler( null, compensationHandlerElement );
			xml2ExtensibleElement( compensationHandler, compensationHandlerElement );
		} 
		else if (compensationHandlerElement == null) {
			compensationHandler = null;
		}

		if (oldCompensationHandler != compensationHandler) {
			if (eObject instanceof Invoke)
				((Invoke) eObject).setCompensationHandler(compensationHandler);
			else if (eObject instanceof Scope)
				((Scope) eObject).setCompensationHandler(compensationHandler);
		}
	}

	/**
	 * Sets a FaultHandler element for a given extensibleElement.
	 */
	protected void setFaultHandler(Element element,
			BPELExtensibleElement extensibleElement) {
		Element faultHandlerElement = ReconciliationHelper
				.getBPELChildElementByLocalName(element, "faultHandlers");

		FaultHandler faultHandler = null;
		if (extensibleElement instanceof Process) {
			faultHandler = ((Process) extensibleElement).getFaultHandlers();
		} else if (extensibleElement instanceof Invoke) {
			faultHandler = ((Invoke) extensibleElement).getFaultHandler();
		}
		FaultHandler oldFaultHandler = faultHandler;

		if (faultHandlerElement != null && faultHandler == null) {
			faultHandler = xml2FaultHandler( null, faultHandlerElement );
		} else if (faultHandlerElement == null) {
			faultHandler = null;
		}

		if (oldFaultHandler != faultHandler) {
			if (extensibleElement instanceof Process) {
				((Process) extensibleElement).setFaultHandlers(faultHandler);
			} else if (extensibleElement instanceof Invoke) {
				((Invoke) extensibleElement).setFaultHandler(faultHandler);
			}
		}
	}

	/**
	 * Sets a EventHandler element for a given extensibleElement.
	 */
	protected void setEventHandler(Element element,
			BPELExtensibleElement extensibleElement) {
		Element eventHandlerElement = ReconciliationHelper
				.getBPELChildElementByLocalName(element, "eventHandlers");

		EventHandler eventHandler = null;
		if (extensibleElement instanceof Process)
			eventHandler = ((Process) extensibleElement).getEventHandlers();
		else if (extensibleElement instanceof Scope)
			eventHandler = ((Scope) extensibleElement).getEventHandlers();
		EventHandler oldEventHandler = eventHandler;

		if (eventHandlerElement != null && eventHandler == null) {
			eventHandler = xml2EventHandler( null, eventHandlerElement );
		} else if (eventHandlerElement == null) {
			eventHandler = null;
		}

		if (oldEventHandler != eventHandler) {
			if (extensibleElement instanceof Process)
				((Process) extensibleElement).setEventHandlers(eventHandler);
			else if (extensibleElement instanceof Scope)
				((Scope) extensibleElement).setEventHandlers(eventHandler);
		}
	}

	/**
	 * Sets the standard attributes (name, joinCondition, and
	 * suppressJoinFailure).
	 */
	protected void setStandardAttributes(Element activityElement,
			Activity activity) {

		// Set name
		Attr name = activityElement.getAttributeNode("name");

		if (name != null && name.getSpecified()) {
			activity.setName(name.getValue());
		} else {
			activity.setName(null);
		}

		// Set suppress join failure
		Attr suppressJoinFailure = activityElement
				.getAttributeNode("suppressJoinFailure");

		if (suppressJoinFailure != null && suppressJoinFailure.getSpecified()) {
			activity.setSuppressJoinFailure(BPELUtils
					.xml2boolean(suppressJoinFailure.getValue()));
		} else {
			activity.unsetSuppressJoinFailure();
		}
	}

	/**
	 * Sets name, portType, operation, partner, variable and correlation for a
	 * given PartnerActivity object.
	 */
	protected void setOperationParms(final Element activityElement,
			final PartnerActivity activity, EReference variableReference,
			EReference inputVariableReference,
			EReference outputVariableReference, EReference partnerReference) {
		// Set partnerLink
		setPartnerLink(activityElement, activity, partnerReference);

		// Set portType
		PortType portType = null;
		if (activityElement.hasAttribute("portType")) {
			portType = BPELUtils.getPortType(getResource().getURI(),
					activityElement, "portType");
			activity.setPortType(portType);
		} else {
			activity.setPortType(null);
		}

		// Set operation
		if (activityElement.hasAttribute("operation")) {
			if (portType != null) {
				activity.setOperation(BPELUtils.getOperation(getResource()
						.getURI(), portType, activityElement, "operation"));
			} else {
				((PartnerActivityImpl) activity)
						.setOperationName(activityElement
								.getAttribute("operation"));
			}
		} else {
			activity.setOperation(null);
		}

		// Set variable
		if (variableReference != null) {
			setVariable(activityElement, activity, "variable",
					variableReference);
		}
		if (inputVariableReference != null) {
			setVariable(activityElement, activity, "inputVariable",
					inputVariableReference);
		}
		if (outputVariableReference != null) {
			setVariable(activityElement, activity, "outputVariable",
					outputVariableReference);
		}

		// Set correlations
		Element correlationsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(activityElement, "correlations");
		if (correlationsElement != null && activity.getCorrelations() == null) {
			activity.setCorrelations(xml2Correlations(activity
					.getCorrelations(), correlationsElement));
		} else if (correlationsElement == null) {
			activity.setCorrelations(null);
		}
	}

	/**
	 * Sets name, portType, operation, partner, variable and correlation for a
	 * given PartnerActivity object.
	 */
	protected void setOperationParmsOnMessage(final Element activityElement,
			final OnMessage onMessage) {
		// Set partnerLink
		setPartnerLink(activityElement, onMessage, BPELPackage.eINSTANCE
				.getOnMessage_PartnerLink());

		// Set portType
		PortType portType = null;
		if (activityElement.hasAttribute("portType")) {
			portType = BPELUtils.getPortType(getResource().getURI(),
					activityElement, "portType");
			onMessage.setPortType(portType);
		} else {
			onMessage.setPortType(null);
		}

		// Set operation
		if (activityElement.hasAttribute("operation")) {
			if (portType != null) {
				onMessage.setOperation(BPELUtils.getOperation(getResource()
						.getURI(), portType, activityElement, "operation"));
			} else {
				// If portType is not specified it will be resolved lazily and
				// so will the operation.
				// Save the deserialized name so the operation can be later
				// resolved.
				((OnMessageImpl) onMessage).setOperationName(activityElement
						.getAttribute("operation"));
			}
		} else {
			onMessage.setOperation(null);
		}

		// Set variable
		setVariable(activityElement, onMessage, "variable",
				BPELPackage.eINSTANCE.getOnMessage_Variable());

		// Set correlations
		Element correlationsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(activityElement, "correlations");
		if (correlationsElement != null && onMessage.getCorrelations() == null) {
			onMessage.setCorrelations(xml2Correlations(onMessage
					.getCorrelations(), correlationsElement));
		} else if (correlationsElement == null) {
			onMessage.setCorrelations(null);
		}
	}

	/**
	 * Sets name, portType, operation, partner, variable, messageType and
	 * correlation for a given PartnerActivity object.
	 */
	protected void setOperationParmsOnEvent(final Element activityElement,
			final OnEvent onEvent) {
		// Set partnerLink
		setPartnerLink(activityElement, onEvent, BPELPackage.eINSTANCE
				.getOnEvent_PartnerLink());

		// Set portType
		PortType portType = null;
		if (activityElement.hasAttribute("portType")) {
			portType = BPELUtils.getPortType(getResource().getURI(),
					activityElement, "portType");
			onEvent.setPortType(portType);
		} else {
			onEvent.setPortType(null);
		}

		// Set operation
		if (activityElement.hasAttribute("operation")) {
			if (portType != null) {
				onEvent.setOperation(BPELUtils.getOperation(getResource()
						.getURI(), portType, activityElement, "operation"));
			} else {
				((OnEventImpl) onEvent).setOperationName(activityElement
						.getAttribute("operation"));
			}
		} else {
			onEvent.setOperation(null);
		}

		// Set variable
		if (activityElement.hasAttribute("variable")) {
			Variable variable = BPELFactory.eINSTANCE.createVariable();

			// Set name
			String name = activityElement.getAttribute("variable");
			variable.setName(name);
			onEvent.setVariable(variable);
			// Don't set the message type of the variable, this will happen
			// in the next step.
		} else {
			onEvent.setVariable(null);
		}

		// Set message type
		if (activityElement.hasAttribute("messageType")) {
			QName qName = BPELUtils.createAttributeValue(activityElement,
					"messageType");
			Message messageType = new MessageProxy(getResource().getURI(),
					qName);
			onEvent.setMessageType(messageType);
		} else {
			onEvent.setMessageType(null);
		}

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=336003
		// "element" attribute was missing from original model
		// Set xsd element
		if (activityElement.hasAttribute("element")) {
			QName qName = BPELUtils.createAttributeValue(activityElement,
					"element");
			XSDElementDeclaration element = new XSDElementDeclarationProxy(
					getResource().getURI(), qName);
			onEvent.setXSDElement(element);
		} else {
			onEvent.setXSDElement(null);
		}

		// Set correlations
		Element correlationsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(activityElement, "correlations");
		if (correlationsElement != null && onEvent.getCorrelations() == null) {
			onEvent.setCorrelations(xml2Correlations(onEvent.getCorrelations(),
					correlationsElement));
		} else if (correlationsElement == null) {
			onEvent.setCorrelations(null);
		}
	}

	/**
	 * 
	 */
	protected List<EObject> parseDocument(Document document) {

		Element element = (document != null) ? document.getDocumentElement()
				: null;
		List<EObject> list = new ArrayList<EObject>();
		if (element == null) {
			return list;
		}

		if (element.getLocalName().equals("bag")) {

			for (Node n = element.getFirstChild(); n != null; n = n
					.getNextSibling()) {
				if (n instanceof Element == false) {
					continue;
				}
				EObject next = parseElement((Element) n);
				if (next != null) {
					list.add(next);
				}
			}

		} else {
			EObject next = parseElement(element);
			if (next != null) {
				list.add(next);
			}
		}
		return list;
	}

	EObject parseElement(Element element) {

		Method parseMethod = getParseMethod(element);
		if (parseMethod == null) {
			return null;
		}
		try {
			return (EObject) parseMethod.invoke(this, element);
		} catch (Throwable t) {
			t.printStackTrace();
			// 
		}
		return null;
	}

	Method getParseMethod(Element element) {
		if (BPELUtils.isBPELElement(element) == false) {
			return null;
		}

		String methodName = element.getLocalName();
		methodName = "xml2" + Character.toUpperCase(methodName.charAt(0))
				+ methodName.substring(1);

		return lookupMethod(getClass(), methodName, Element.class);
	}

	Method lookupMethod(Class<?> target, String methodName, Class<?>... args) {
		if (target == null || target == Object.class) {
			return null;
		}

		for (Method m : target.getDeclaredMethods()) {
			if (methodName.equals(m.getName()) == false
					|| m.getParameterTypes().length != args.length) {
				continue;
			}
			Class<?> argTypes[] = m.getParameterTypes();
			for (int i = 0; i < args.length; i++) {
				if (!argTypes[i].isAssignableFrom(args[i])) {
					continue;
				}
			}
			return m;
		}
		return lookupMethod(target.getSuperclass(), methodName, args);

	}

	/**
	 * Converts an XML document to a BPEL Resource object.
	 */
	protected Process xml2Resource(Document document) {
		Element processElement = (document != null) ? document
				.getDocumentElement() : null;
		if (processElement == null) {
			return null;
		}
		return xml2Process(processElement);
	}

	/**
	 * Converts an XML process to a BPEL Process object.
	 */
	@SuppressWarnings("nls")
	protected Process xml2Process(Element processElement) {
		if (!processElement.getLocalName().equals("process")) {
			return null;
		}
		// if (!BPELConstants.isBPELNamespace(processElement.getNamespaceURI()))
		// {
		// return null;
		// }

		if (process == null) {
			process = BPELFactory.eINSTANCE.createProcess();
			process.setElement(processElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(process, processElement);

		// Handle Process element
		if (processElement.hasAttribute("name")) {
			process.setName(processElement.getAttribute("name"));
		} else {
			process.setName(null);
		}

		if (processElement.hasAttribute("targetNamespace")) {
			process.setTargetNamespace(processElement
					.getAttribute("targetNamespace"));
		} else {
			process.setTargetNamespace(null);
		}

		if (processElement.hasAttribute("suppressJoinFailure")) {
			process.setSuppressJoinFailure(BPELUtils.xml2boolean(processElement
					.getAttribute("suppressJoinFailure")));
		} else {
			process.unsetSuppressJoinFailure();
		}

		if (processElement.hasAttribute("exitOnStandardFault")) {
			process.setExitOnStandardFault(BPELUtils.xml2boolean(processElement
					.getAttribute("exitOnStandardFault")));
		} else {
			process.setExitOnStandardFault(false);
		}

		if (processElement.hasAttribute("variableAccessSerializable")) {
			process.setVariableAccessSerializable(BPELUtils
					.xml2boolean(processElement
							.getAttribute("variableAccessSerializable")));
		} else {
			process.unsetVariableAccessSerializable();
		}

		if (processElement.hasAttribute("queryLanguage")) {
			process.setQueryLanguage(processElement
					.getAttribute("queryLanguage"));
		} else {
			process.unsetQueryLanguage();
		}

		if (processElement.hasAttribute("expressionLanguage")) {
			process.setExpressionLanguage(processElement
					.getAttribute("expressionLanguage"));
		} else {
			process.unsetExpressionLanguage();
		}

		if (processElement.hasAttribute("abstractProcessProfile")) {
			process.setAbstractProcessProfile(processElement
					.getAttribute("abstractProcessProfile"));
		} else {
			process.unsetAbstractProcessProfile();
		}

		// Handle Import Elements
		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(processElement, "import");
		syncLists(processElement, childElements, process.getImports(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2Import(null, element);
					}
				});

		// Handle PartnerLinks Element
		Element partnerLinksElement = ReconciliationHelper
				.getBPELChildElementByLocalName(processElement, "partnerLinks");
		if (partnerLinksElement != null
				&& (process.getPartnerLinks() == null || process
						.getPartnerLinks().getChildren().size() == 0)) {
			process.setPartnerLinks(xml2PartnerLinks(process.getPartnerLinks(),
					partnerLinksElement));
		} else if (partnerLinksElement == null) {
			process.setPartnerLinks(null);
		}

		// Handle Variables Element
		Element variablesElement = ReconciliationHelper
				.getBPELChildElementByLocalName(processElement, "variables");
		if (variablesElement != null) {
			if (process.getVariables() == null
					|| process.getVariables().getChildren() == null
					|| process.getVariables().getChildren().size() == 0) {
				process.setVariables(xml2Variables(process.getVariables(),
						variablesElement));
			}
		} else {
			process.setVariables(null);
		}

		// Handle CorrelationSets Element
		Element correlationSetsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(processElement,
						"correlationSets");
		if (correlationSetsElement != null
				&& (process.getCorrelationSets() == null || process
						.getCorrelationSets().getChildren() == null)) {
			process.setCorrelationSets(xml2CorrelationSets(process
					.getCorrelationSets(), correlationSetsElement));
		} else if (correlationSetsElement == null) {
			process.setCorrelationSets(null);
		}

		// Handle MessageExchanges Element
		Element messageExchangesElements = ReconciliationHelper
				.getBPELChildElementByLocalName(processElement,
						"messageExchanges");
		
		if (messageExchangesElements != null
				&& (process.getMessageExchanges() == null || process
						.getMessageExchanges().getChildren() == null
						)) {
			process.setMessageExchanges(xml2MessageExchanges(process
					.getMessageExchanges(), messageExchangesElements));
		} else if(messageExchangesElements == null){
			// add if(messageExchangesElements == null) by Grid.Qian
			process.setMessageExchanges(null);
		}

		// Handle Extensions Element
		Element extensionsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(processElement, "extensions");
		if (extensionsElement != null && process.getExtensions() == null) {
			process.setExtensions(xml2Extensions(process.getExtensions(),
					extensionsElement));
		} else if (extensionsElement == null) {
			process.setExtensions(null);
		}

		// Handle FaultHandler element
		setFaultHandler(processElement, process);

		// Handle CompensationHandler element
		// In BPEL 2.0, there is no compensation handler on process
		// setCompensationHandler(processElement, process);

		// Handle EventHandler element
		setEventHandler(processElement, process);

		process.setActivity(xml2Activity(null, processElement));

		xml2ExtensibleElement(process, processElement);

		return process;
	}

	/**
	 * Converts an XML partnerLinks
	 */
	protected PartnerLinks xml2PartnerLinks(PartnerLinks partnerLinks,
			Element partnerLinksElement) {
		if (!partnerLinksElement.getLocalName().equals("partnerLinks")) {
			return null;
		}

		if (partnerLinks == null) {
			partnerLinks = BPELFactory.eINSTANCE.createPartnerLinks();
			partnerLinks.setElement(partnerLinksElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(partnerLinks, partnerLinksElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(partnerLinksElement,
						"partnerLink");
		EList<PartnerLink> childrenList = partnerLinks.getChildren();
		syncLists(partnerLinksElement, childElements, childrenList,
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2PartnerLink(null, element);
					}
				});

		xml2ExtensibleElement(partnerLinks, partnerLinksElement);
		return partnerLinks;
	}

	protected Variables xml2Variables(Variables variables,
			Element variablesElement) {
		if (!variablesElement.getLocalName().equals("variables"))
			return null;

		if (variables == null) {
			variables = BPELFactory.eINSTANCE.createVariables();
			variables.setElement(variablesElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(variables, variablesElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(variablesElement, "variable");
		EList<Variable> childrenList = variables.getChildren();
		syncLists(variablesElement, childElements, childrenList, new Creator() {
			public WSDLElement create(Element element) {
				return xml2Variable(null, element);
			}
		});

		xml2ExtensibleElement(variables, variablesElement);

		// Move variables that are extensibility elements to the list of
		// children
		// JM: What is this supposed to accomplish?
		// List<Variable> toBeMoved = new BasicEList<Variable>();
		// for (Object next : variables.getExtensibilityElements()) {
		// if (next instanceof Variable) {
		// toBeMoved.add((Variable) next);
		// }
		// }
		//
		// List<?> extensibility = variables.getExtensibilityElements();
		// List<Variable> children = variables.getChildren();
		// for (Variable element : toBeMoved) {
		// extensibility.remove(element);
		// children.add(element);
		// }

		return variables;
	}

	protected CorrelationSets xml2CorrelationSets(
			CorrelationSets correlationSets, Element correlationSetsElement) {
		if (!correlationSetsElement.getLocalName().equals("correlationSets"))
			return null;

		if (correlationSets == null) {
			correlationSets = BPELFactory.eINSTANCE.createCorrelationSets();
			correlationSets.setElement(correlationSetsElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(correlationSets, correlationSetsElement);

		syncLists(correlationSetsElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(correlationSetsElement,
						BPELConstants.ND_CORRELATION_SET), correlationSets
				.getChildren(), new Creator() {
			public WSDLElement create(Element element) {
				return xml2CorrelationSet(null, element);
			}
		});

		xml2ExtensibleElement(correlationSets, correlationSetsElement);

		return correlationSets;
	}

	protected FromParts xml2FromParts(FromParts fromParts,
			Element fromPartsElement) {
		if (!fromPartsElement.getLocalName().equals("fromParts"))
			return null;

		if (fromParts == null) {
			fromParts = BPELFactory.eINSTANCE.createFromParts();
			fromParts.setElement(fromPartsElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(fromParts, fromPartsElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(fromPartsElement, "fromPart");
		EList<FromPart> childrenList = fromParts.getChildren();
		syncLists(fromPartsElement, childElements, childrenList, new Creator() {
			public WSDLElement create(Element element) {
				return xml2FromPart(null, element);
			}
		});

		xml2ExtensibleElement(fromParts, fromPartsElement);

		return fromParts;
	}

	protected ToParts xml2ToParts(ToParts toParts, Element toPartsElement) {
		if (!toPartsElement.getLocalName().equals("toParts"))
			return null;

		if (toParts == null) {
			toParts = BPELFactory.eINSTANCE.createToParts();
			toParts.setElement(toPartsElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(toParts, toPartsElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(toPartsElement, "toPart");
		EList<ToPart> childrenList = toParts.getChildren();
		syncLists(toPartsElement, childElements, childrenList, new Creator() {
			public WSDLElement create(Element element) {
				return xml2ToPart(null, element);
			}
		});

		xml2ExtensibleElement(toParts, toPartsElement);

		return toParts;
	}

	/**
	 * Converts an XML messageExchanges
	 */
	protected MessageExchanges xml2MessageExchanges(
			MessageExchanges messageExchanges, Element messageExchangesElement) {
		if (!messageExchangesElement.getLocalName().equals("messageExchanges"))
			return null;

		if (messageExchanges == null) {
			messageExchanges = BPELFactory.eINSTANCE.createMessageExchanges();
			messageExchanges.setElement(messageExchangesElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(messageExchanges, messageExchangesElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(messageExchangesElement,
						"messageExchange");
		EList<MessageExchange> childrenList = messageExchanges.getChildren();
		syncLists(messageExchangesElement, childElements, childrenList,
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2MessageExchange(null, element);
					}
				});

		xml2ExtensibleElement(messageExchanges, messageExchangesElement);
		return messageExchanges;
	}

	protected Extensions xml2Extensions(Extensions extensions,
			Element extensionsElement) {
		if (!extensionsElement.getLocalName().equals("extensions"))
			return null;

		if (extensions == null) {
			extensions = BPELFactory.eINSTANCE.createExtensions();
			extensions.setElement(extensionsElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(extensions, extensionsElement);

		syncLists(extensionsElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(extensionsElement,
						BPELConstants.ND_EXTENSION), extensions.getChildren(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2Extension(null, element);
					}
				});

		xml2ExtensibleElement(extensions, extensionsElement);

		return extensions;
	}

	/**
	 * Converts an XML compensationHandler element to a BPEL CompensationHandler
	 * object.
	 */
	protected CompensationHandler xml2CompensationHandler(
			CompensationHandler compensationHandler, Element activityElement) {
		if (compensationHandler == null) {
			compensationHandler = BPELFactory.eINSTANCE
					.createCompensationHandler();
			compensationHandler.setElement(activityElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(compensationHandler, activityElement);

		compensationHandler.setActivity(getChildActivity(compensationHandler,
				activityElement));

		return compensationHandler;
	}

	/**
	 * Converts an XML correlationSet element to a BPEL CorrelationSet object.
	 */
	protected CorrelationSet xml2CorrelationSet(CorrelationSet correlationSet,
			Element correlationSetElement) {
		if (correlationSet == null) {
			correlationSet = BPELFactory.eINSTANCE.createCorrelationSet();
			correlationSet.setElement(correlationSetElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(correlationSet, correlationSetElement);

		if (correlationSetElement == null)
			return correlationSet;

		// Set name
		Attr name = correlationSetElement.getAttributeNode("name");

		if (name != null && name.getSpecified()) {
			correlationSet.setName(name.getValue());
		} else {
			correlationSet.setName(null);
		}

		setProperties(correlationSetElement, correlationSet, "properties");

		xml2ExtensibleElement(correlationSet, correlationSetElement);

		return correlationSet;
	}

	/**
	 * Converts an XML messageExchange element to a BPEL MessageExchange object.
	 */
	protected MessageExchange xml2MessageExchange(
			MessageExchange messageExchange, Element messageExchangeElement) {
		if (!messageExchangeElement.getLocalName().equals("messageExchange"))
			return null;
		
		if (messageExchange == null) {
			messageExchange = BPELFactory.eINSTANCE.createMessageExchange();
			messageExchange.setElement(messageExchangeElement);
		}
		
		// Save all the references to external namespaces
		saveNamespacePrefix(messageExchange, messageExchangeElement);

		if (messageExchangeElement == null)
			return messageExchange;
		
		if (!messageExchangeElement.getLocalName().equals("messageExchange"))
			return null;

		// Save all the references to external namespaces
		saveNamespacePrefix(messageExchange, messageExchangeElement);

		// Set name
		if (messageExchangeElement.hasAttribute("name")) {
			messageExchange
					.setName(messageExchangeElement.getAttribute("name"));
		} else {
			messageExchange.setName(null);
		}

		xml2ExtensibleElement(messageExchange, messageExchangeElement);

		return messageExchange;
	}

	/**
	 * Converts an XML extension element to a BPEL Extension object.
	 */
	protected Extension xml2Extension(Extension extension,
			Element extensionElement) {
		if (extension == null) {
			extension = BPELFactory.eINSTANCE.createExtension();
			extension.setElement(extensionElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(extension, extensionElement);

		if (extensionElement == null)
			return extension;

		// Set namespace
		if (extensionElement.hasAttribute("namespace")) {
			extension.setNamespace(extensionElement.getAttribute("namespace"));
		} else {
			extension.setNamespace(null);
		}

		// Set mustUnderstand
		if (extensionElement.hasAttribute("mustUnderstand")) {
			extension.setMustUnderstand(BPELUtils.xml2boolean(extensionElement
					.getAttribute("mustUnderstand")));
		} else {
			extension.unsetMustUnderstand();
		}

		xml2ExtensibleElement(extension, extensionElement);

		return extension;
	}

	/**
	 * Converts an XML partnerLink element to a BPEL PartnerLink object.
	 */
	protected PartnerLink xml2PartnerLink(PartnerLink partnerLink,
			Element partnerLinkElement) {
		if (!partnerLinkElement.getLocalName().equals("partnerLink"))
			return null;

		if (partnerLink == null) {
			partnerLink = BPELFactory.eINSTANCE.createPartnerLink();
			partnerLink.setElement(partnerLinkElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(partnerLink, partnerLinkElement);

		// Set name
		if (partnerLinkElement.hasAttribute("name")) {
			partnerLink.setName(partnerLinkElement.getAttribute("name"));
		} else {
			partnerLink.setName(null);
		}

		if (partnerLinkElement.hasAttribute("initializePartnerRole")) {
			partnerLink.setInitializePartnerRole(BPELUtils
					.xml2boolean(partnerLinkElement
							.getAttribute("initializePartnerRole")));
		} else {
			partnerLink.unsetInitializePartnerRole();
		}

		Attr partnerLinkTypeName = partnerLinkElement
				.getAttributeNode("partnerLinkType");
		if (partnerLinkTypeName != null && partnerLinkTypeName.getSpecified()) {
			QName sltQName = BPELUtils.createAttributeValue(partnerLinkElement,
					"partnerLinkType");

			PartnerLinkTypeProxy slt = new PartnerLinkTypeProxy(getResource()
					.getURI(), sltQName);

			if (slt != null) {
				PartnerLinkType oldPartnerLinkType = partnerLink
						.getPartnerLinkType();
				if (!sltQName.getLocalPart().equals(
						oldPartnerLinkType == null ? null : oldPartnerLinkType
								.getName())) {
					partnerLink.setPartnerLinkType(slt);
				}

				if (partnerLinkElement.hasAttribute("myRole")) {
					RoleProxy role = new RoleProxy(getResource(), slt,
							partnerLinkElement.getAttribute("myRole"));
					Role oldRole = partnerLink.getMyRole();
					if (!role.getName().equals(
							oldRole == null ? null : oldRole.getName())) {
						partnerLink.setMyRole(role);
					}
				} else {
					partnerLink.setMyRole(null);
				}
				if (partnerLinkElement.hasAttribute("partnerRole")) {
					RoleProxy role = new RoleProxy(getResource(), slt,
							partnerLinkElement.getAttribute("partnerRole"));
					Role oldRole = partnerLink.getPartnerRole();
					if (!role.getName().equals(
							oldRole == null ? null : oldRole.getName())) {
						partnerLink.setPartnerRole(role);
					}
				} else {
					partnerLink.setPartnerRole(null);
				}
			} else {
				partnerLink.setPartnerLinkType(null);
			}
		} else {
			partnerLink.setPartnerLinkType(null);
		}

		xml2ExtensibleElement(partnerLink, partnerLinkElement);

		return partnerLink;
	}

	/**
	 * Converts an XML variable element to a BPEL Variable object.
	 */
	protected Variable xml2Variable(Variable variable, Element variableElement) {
		if (!variableElement.getLocalName().equals("variable"))
			return null;

		if (variable == null) {
			variable = BPELFactory.eINSTANCE.createVariable();
			variable.setElement(variableElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(variable, variableElement);

		// Set name
		if (variableElement.hasAttribute("name")) {
			variable.setName(variableElement.getAttribute("name"));
		} else {
			variable.setName(null);
		}

		if (variableElement.hasAttribute("messageType")) {
			QName qName = BPELUtils.createAttributeValue(variableElement,
					"messageType");
			Message messageType = new MessageProxy(getResource().getURI(),
					qName);
			variable.setMessageType(messageType);
		} else {
			variable.setMessageType(null);
		}

		// Set xsd type
		if (variableElement.hasAttribute("type")) {
			QName qName = BPELUtils.createAttributeValue(variableElement,
					"type");
			XSDTypeDefinition type = new XSDTypeDefinitionProxy(getResource()
					.getURI(), qName);
			variable.setType(type);
		} else {
			variable.setType(null);
		}

		// Set xsd element
		if (variableElement.hasAttribute("element")) {
			QName qName = BPELUtils.createAttributeValue(variableElement,
					"element");
			XSDElementDeclaration element = new XSDElementDeclarationProxy(
					getResource().getURI(), qName);
			variable.setXSDElement(element);
		} else {
			variable.setXSDElement(null);
		}

		// from-spec
		Element fromElement = ReconciliationHelper
				.getBPELChildElementByLocalName(variableElement, "from");
		if (fromElement != null && variable.getFrom() == null) {
			variable.setFrom(xml2From(variable.getFrom(), fromElement));
		} else if (fromElement == null) {
			variable.setFrom(null);
		}

		xml2ExtensibleElement(variable, variableElement);

		return variable;
	}

	/**
	 * Converts an XML faultHandler element to a BPEL FaultHandler object.
	 */
	protected FaultHandler xml2FaultHandler(FaultHandler faultHandler,
			Element faultHandlerElement) {
		String localName = faultHandlerElement.getLocalName();
		if (!(localName.equals("faultHandlers") || localName.equals("invoke")))
			return null;

		if (faultHandler == null) {
			faultHandler = BPELFactory.eINSTANCE.createFaultHandler();
		}

		if (localName.equals("faultHandlers")) {
			// This is "overloaded", what's the proper facade for the fault
			// handler element in this case.
			faultHandler.setElement(faultHandlerElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(faultHandler, faultHandlerElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(faultHandlerElement, "catch");
		syncLists(faultHandlerElement, childElements, faultHandler.getCatch(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2Catch(null, element);
					}
				});

		Element catchAllElement = ReconciliationHelper
				.getBPELChildElementByLocalName(faultHandlerElement, "catchAll");
		if (catchAllElement != null && faultHandler.getCatchAll() == null) {
			faultHandler.setCatchAll(xml2CatchAll(faultHandler.getCatchAll(),
					catchAllElement));
		} else if (catchAllElement == null) {
			faultHandler.setCatchAll(null);
		}

		// Only do this for an element named faultHandlers. If the element is
		// named
		// invoke, then there really is no fault handler, only a series of
		// catches.
		if (faultHandlerElement.getLocalName().equals("faultHandlers")) {
			xml2ExtensibleElement(faultHandler, faultHandlerElement);
		}

		return faultHandler;
	}

	/**
	 * Converts an XML catchAll element to a BPEL CatchAll object.
	 */
	protected CatchAll xml2CatchAll(CatchAll catchAll, Element catchAllElement) {
		if (!catchAllElement.getLocalName().equals("catchAll"))
			return null;

		if (catchAll == null) {
			catchAll = BPELFactory.eINSTANCE.createCatchAll();
			catchAll.setElement(catchAllElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(catchAll, catchAllElement);

		catchAll.setActivity(getChildActivity(catchAll, catchAllElement));

		xml2ExtensibleElement(catchAll, catchAllElement);

		return catchAll;
	}

	/**
	 * Converts an XML catch element to a BPEL Catch object.
	 */
	protected Catch xml2Catch(Catch _catch, Element catchElement) {
		if (_catch == null) {
			_catch = BPELFactory.eINSTANCE.createCatch();
			_catch.setElement(catchElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(_catch, catchElement);

		if (catchElement == null)
			return _catch;

		if (catchElement.hasAttribute("faultName")) {
			QName qName = BPELUtils.createAttributeValue(catchElement,
					"faultName");
			_catch.setFaultName(qName);
		} else {
			_catch.setFaultName(null);
		}

		if (catchElement.hasAttribute("faultVariable")) {
			if (_catch.getFaultVariable() == null) {
				// Set fault variable
				Variable variable = BPELFactory.eINSTANCE.createVariable();
				// TODO: Should not this be the variable proxy ?
				variable.setName(catchElement.getAttribute("faultVariable"));
				_catch.setFaultVariable(variable);
			}
		} else {
			_catch.setFaultVariable(null);
		}

		if (catchElement.hasAttribute("faultMessageType")) {
			QName qName = BPELUtils.createAttributeValue(catchElement,
					"faultMessageType");
			Message messageType = new MessageProxy(getResource().getURI(),
					qName);
			_catch.setFaultMessageType(messageType);
		} else {
			_catch.setFaultMessageType(null);
		}

		if (catchElement.hasAttribute("faultElement")) {
			QName qName = BPELUtils.createAttributeValue(catchElement,
					"faultElement");
			XSDElementDeclaration element = new XSDElementDeclarationProxy(
					getResource().getURI(), qName);
			_catch.setFaultElement(element);
		} else {
			_catch.setFaultElement(null);
		}

		// Set Activities
		_catch.setActivity(getChildActivity(_catch, catchElement));

		xml2ExtensibleElement(_catch, catchElement);
		return _catch;
	}

	/**
	 * Converts an XML activity element to a BPEL Activity object.
	 */
	public Activity xml2Activity(Activity activity, Element activityElement) {
		boolean checkExtensibility = true;

		// if (!BPELUtils.isBPELElement(activityElement))
		// return null;

		String localName = activityElement.getLocalName();
		if (localName.equals("process")) {
			activity = getChildActivity(process, activityElement);
			checkExtensibility = false;
		} else if (localName.equals("receive")) {
			activity = xml2Receive(activity, activityElement);
		} else if (localName.equals("reply")) {
			activity = xml2Reply(activity, activityElement);
		} else if (localName.equals("invoke")) {
			activity = xml2Invoke(activity, activityElement);
		} else if (localName.equals("assign")) {
     		// Identifying the Correct Assign Activity 

			String childLocalName = "";
			// Since E4X Assign Activity has at least one ExtensionAssignOperation by default
			if (activityElement.getFirstChild() != null) {
				//Reading all (*) child elements
				NodeList node = activityElement.getElementsByTagName("*");
				// checking for first child. 
				// This implementation supports only for either <copy> or <extensionAssignOpetion>
				childLocalName = node.item(0).getLocalName();
				if ("extensionAssignOperation".equalsIgnoreCase(childLocalName)) {
					activity = xml2AssignE4X(activity, activityElement);
				} else if ("copy".equalsIgnoreCase(childLocalName)) {
					activity = xml2Assign(activity, activityElement);
				}

			} else {
				// Default Assign Activity. Since there is no child elements.
				activity = xml2Assign(activity, activityElement);
			}
		} else if (localName.equals("throw")) {
			activity = xml2Throw(activity, activityElement);
		} else if (localName.equals("exit")) {
			activity = xml2Exit(activity, activityElement);
		} else if (localName.equals("wait")) {
			activity = xml2Wait(activity, activityElement);
		} else if (localName.equals("empty")) {
			activity = xml2Empty(activity, activityElement);
		} else if (localName.equals("sequence")) {
			activity = xml2Sequence(activity, activityElement);
		} else if (localName.equals("if")) {
			activity = xml2If(activity, activityElement);
		} else if (localName.equals("while")) {
			activity = xml2While(activity, activityElement);
		} else if (localName.equals("pick")) {
			activity = xml2Pick(activity, activityElement);
		} else if (localName.equals("flow")) {
			activity = xml2Flow(activity, activityElement);
		} else if (localName.equals("scope")) {
			activity = xml2Scope(activity, activityElement);
		} else if (localName.equals("compensate")) {
			activity = xml2Compensate(activity, activityElement);
		} else if (localName.equals("compensateScope")) {
			activity = xml2CompensateScope(activity, activityElement);
		} else if (localName.equals("rethrow")) {
			activity = xml2Rethrow(activity, activityElement);
		} else if (localName.equals("extensionActivity")) {
			// extensionActivity is a special case. It does not have any
			// standard attributes or elements, nor is it an extensible
			// element. Return immediately.
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
			// Need to pass the activity in to the deserializer
			activity = xml2ExtensionActivity(activity,activityElement);
			return activity;
		} else if (localName.equals("opaqueActivity")) {
			activity = xml2OpaqueActivity(activity, activityElement);
		} else if (localName.equals("forEach")) {
			activity = xml2ForEach(activity, activityElement);
		} else if (localName.equals("repeatUntil")) {
			activity = xml2RepeatUntil(activity, activityElement);
		} else if (localName.equals("validate")) {
			activity = xml2Validate(activity, activityElement);
		} else {
			return null;
		}

		setStandardElements(activityElement, activity);

		if (checkExtensibility) {
			xml2ExtensibleElement(activity, activityElement);
			// Save all the references to external namespaces
			saveNamespacePrefix(activity, activityElement);
		}

		return activity;
	}

	protected void setStandardElements(Element activityElement,
			Activity activity) {
		// Handle targets
		Element targetsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(activityElement, "targets");
		if (targetsElement != null && activity.getTargets() == null) {
			activity.setTargets(xml2Targets(activity.getTargets(),
					targetsElement));
		} else if (targetsElement == null) {
			activity.setTargets(null);
		}

		// Handle sources
		Element sourcesElement = ReconciliationHelper
				.getBPELChildElementByLocalName(activityElement, "sources");
		if (sourcesElement != null && activity.getSources() == null) {
			activity.setSources(xml2Sources(activity.getSources(),
					sourcesElement));
		} else if (sourcesElement == null) {
			activity.setSources(null);
		}
	}

	protected Targets xml2Targets(Targets targets, Element targetsElement) {
		if (targets == null) {
			targets = BPELFactory.eINSTANCE.createTargets();
			targets.setElement(targetsElement);
		}

		syncLists(targetsElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(targetsElement,
						BPELConstants.ND_TARGET), targets.getChildren(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2Target(null, element);
					}
				});

		// Join condition
		Element joinConditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(targetsElement, "joinCondition");
		if (joinConditionElement != null && targets.getJoinCondition() == null) {
			targets.setJoinCondition(xml2Condition(targets.getJoinCondition(),
					joinConditionElement));
		} else if (joinConditionElement == null) {
			targets.setJoinCondition(null);
		}

		xml2ExtensibleElement(targets, targetsElement);

		return targets;
	}

	protected Target xml2Target(Target target, Element targetElement) {
		if (target == null) {
			target = BPELFactory.eINSTANCE.createTarget();
			target.setElement(targetElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(target, targetElement);

		xml2ExtensibleElement(target, targetElement);

		if (targetElement.hasAttribute("linkName")) {
			final String linkName = targetElement.getAttribute("linkName");
			createLink(target, linkName);
		} else {
			target.setLink(null);
		}
		return target;
	}

	protected Sources xml2Sources(Sources sources, Element sourcesElement) {
		if (sources == null) {
			sources = BPELFactory.eINSTANCE.createSources();
			sources.setElement(sourcesElement);
		}

		syncLists(sourcesElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(sourcesElement,
						BPELConstants.ND_SOURCE), sources.getChildren(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2Source(null, element);
					}
				});

		xml2ExtensibleElement(sources, sourcesElement);

		return sources;
	}

	protected Source xml2Source(Source source, Element sourceElement) {
		final String linkName = sourceElement.getAttribute("linkName");
		if (source == null) {
			source = BPELFactory.eINSTANCE.createSource();
			source.setElement(sourceElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(source, sourceElement);

		// Read transitionCondition element
		Element transitionConditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(sourceElement,
						"transitionCondition");
		if (transitionConditionElement != null
				&& source.getTransitionCondition() == null) {
			source.setTransitionCondition(xml2Condition(source
					.getTransitionCondition(), transitionConditionElement));
		} else if (transitionConditionElement == null) {
			source.setTransitionCondition(null);
		}

		xml2ExtensibleElement(source, sourceElement);
		if (linkName != null) {
			createLink(source, linkName);
		} else {
			source.setLink(null);
		}
		return source;
	}

	/**
	 * Converts an XML scope element to a BPEL Scope object.
	 */
	protected Activity xml2Scope(Activity scopeActivity, Element scopeElement) {
		Scope scope;
		if (scopeActivity instanceof Scope) {
			scope = (Scope) scopeActivity;
		} else {
			scope = BPELFactory.eINSTANCE.createScope();
			scope.setElement(scopeElement);
		}

		Attr isolated = scopeElement.getAttributeNode("isolated");
		if (isolated != null && isolated.getSpecified()) {
			scope.setIsolated(BPELUtils.xml2boolean(isolated.getValue()));
		} else {
			scope.unsetIsolated();
		}

		// Handle attribute exitOnStandardFault
		Attr exitOnStandardFault = scopeElement
				.getAttributeNode("exitOnStandardFault");
		if (exitOnStandardFault != null && exitOnStandardFault.getSpecified()) {
			scope.setExitOnStandardFault(BPELUtils
					.xml2boolean(exitOnStandardFault.getValue()));
		} else {
			scope.unsetExitOnStandardFault();
		}

		// Handle Variables element
		Element variablesElement = ReconciliationHelper
				.getBPELChildElementByLocalName(scopeElement, "variables");
		if (variablesElement != null
				&& (scope.getVariables() == null || scope.getVariables()
						.getChildren().size() == 0)) {
			scope.setVariables(xml2Variables(scope.getVariables(),
					variablesElement));
		} else if (variablesElement == null) {
			scope.setVariables(null);
		}

		// Handle CorrelationSet element
		Element correlationSetsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(scopeElement, "correlationSets");
		if (correlationSetsElement != null
				&& (scope.getCorrelationSets() == null || scope
						.getCorrelationSets().getChildren().size() == 0)) {
			scope.setCorrelationSets(xml2CorrelationSets(scope
					.getCorrelationSets(), correlationSetsElement));
		} else if (correlationSetsElement == null) {
			scope.setCorrelationSets(null);
		}

		// Handle PartnerLinks element
		Element partnerLinksElement = ReconciliationHelper
				.getBPELChildElementByLocalName(scopeElement, "partnerLinks");
		if (partnerLinksElement != null
				&& (scope.getPartnerLinks() == null || scope.getPartnerLinks()
						.getChildren().size() == 0)) {
			scope.setPartnerLinks(xml2PartnerLinks(scope.getPartnerLinks(),
					partnerLinksElement));
		} else if (partnerLinksElement == null) {
			scope.setPartnerLinks(null);
		}

		// MessageExchanges element
		Element messageExchangesElement = ReconciliationHelper
				.getBPELChildElementByLocalName(scopeElement,
						"messageExchanges");
		if (messageExchangesElement != null
				&& (scope.getMessageExchanges() == null || scope
						.getMessageExchanges().getChildren().size() == 0)) {
			scope.setMessageExchanges(xml2MessageExchanges(scope
					.getMessageExchanges(), messageExchangesElement));
		} else if (messageExchangesElement == null) {
			scope.setMessageExchanges(null);
		}

		// Handle FaultHandler element
		Element faultHandlerElement = ReconciliationHelper
				.getBPELChildElementByLocalName(scopeElement, "faultHandlers");
		if (faultHandlerElement != null && scope.getFaultHandlers() == null) {
			scope.setFaultHandlers(xml2FaultHandler(scope.getFaultHandlers(),
					faultHandlerElement));
		} else if (faultHandlerElement == null) {
			scope.setFaultHandlers(null);
		}

		// Handle CompensationHandler element
		setCompensationHandler(scopeElement, scope);

		// Handler TerminationHandler element
		Element terminationHandlerElement = ReconciliationHelper
				.getBPELChildElementByLocalName(scopeElement,
						"terminationHandler");
		if (terminationHandlerElement != null
				&& scope.getTerminationHandler() == null) {
			scope.setTerminationHandler(xml2TerminationHandler(scope
					.getTerminationHandler(), terminationHandlerElement));
		} else if (terminationHandlerElement == null) {
			scope.setTerminationHandler(null);
		}

		// Handler EventHandler element
		setEventHandler(scopeElement, scope);

		setStandardAttributes(scopeElement, scope);

		// Handle activities
		NodeList scopeElements = scopeElement.getChildNodes();

		Element activityElement = null;

		if (scopeElements != null && scopeElements.getLength() > 0) {

			for (int i = 0; i < scopeElements.getLength(); i++) {
				if (scopeElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}

				activityElement = (Element) scopeElements.item(i);

				if (activityElement.getLocalName().equals("faultHandlers")
						|| activityElement.getLocalName().equals(
								"compensationHandler")) {
					continue;
				}
				Activity activity;
				if (scope.getActivity() == null
						|| scope.getActivity().getElement() != activityElement) {
					activity = xml2Activity(null, activityElement);
				} else {
					activity = scope.getActivity();
					activityElement = activity.getElement();
				}
				if (activity != null) {
					scope.setActivity(activity);
					break;
				}
			}
		}
		if (activityElement == null) {
			scope.setActivity(null);
		}

		return scope;
	}

	/**
	 * Converts an XML flow element to a BPEL Flow object.
	 */
	protected Activity xml2Flow(Activity flowActivity, Element flowElement) {
		Flow flow;
		if (flowActivity instanceof Flow) {
			flow = (Flow) flowActivity;
		} else {
			flow = BPELFactory.eINSTANCE.createFlow();
			flow.setElement(flowElement);
		}

		Element linksElement = ReconciliationHelper
				.getBPELChildElementByLocalName(flowElement, "links");
		if (linksElement != null && flow.getLinks() == null) {
			flow.setLinks(xml2Links(flow.getLinks(), linksElement));
		} else if (linksElement == null) {
			flow.setLinks(null);
		}

		Element completionConditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(flowElement,
						"completionCondition");
		if (completionConditionElement != null
				&& flow.getCompletionCondition() == null) {
			flow.setCompletionCondition(xml2CompletionCondition(flow
					.getCompletionCondition(), completionConditionElement));
		} else if (completionConditionElement == null) {
			flow.setCompletionCondition(null);
		}

		setStandardAttributes(flowElement, flow);

		syncSequences(flowElement, flow.getActivities());

		return flow;
	}

	protected Links xml2Links(Links links, Element linksElement) {
		if (!linksElement.getLocalName().equals("links"))
			return null;

		if (links == null) {
			links = BPELFactory.eINSTANCE.createLinks();
			links.setElement(linksElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(links, linksElement);

		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(linksElement, "link");
		EList<Link> childrenList = links.getChildren();
		syncLists(linksElement, childElements, childrenList, new Creator() {
			public WSDLElement create(Element element) {
				return xml2Link(null, element);
			}
		});

		// extensibility elements
		xml2ExtensibleElement(links, linksElement);

		return links;
	}

	
	/**
	 * Converts an XML assignE4X element to a BPEL Assign object.
	 * 
	 */
	protected Activity xml2AssignE4X(Activity assignE4XActivity, Element assignE4XElement) {
		AssignE4X assignE4X;
		
		if (assignE4XActivity instanceof AssignE4X) {
			assignE4X = (AssignE4X) assignE4XActivity;
		} else {
			assignE4X = BPELFactory.eINSTANCE.createAssignE4X();
			assignE4X.setElement(assignE4XElement);
		}
		//setting Validate Attribute value
		if (assignE4XElement.hasAttribute("validate")) {
			assignE4X.setValidate(BPELUtils.xml2boolean(assignE4XElement
					.getAttribute("validate")));
		} else {
			assignE4X.setValidate(false);
		}

		syncLists(assignE4XElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(assignE4XElement, "extensionAssignOperation"), assignE4X
				.getExtensionAssignOperation(), new Creator() {
			public WSDLElement create(Element element) {
				return xml2ExtensionAssignOperation(null, element);
			}
		});

		setStandardAttributes(assignE4XElement, assignE4X);

		return assignE4X;
	}
	
	/**
	 * Converts an XML ExtensionAssignOperation element to a BPEL ExtensionAssignOperation object.
	 * 
	 */
	protected ExtensionAssignOperation xml2ExtensionAssignOperation(ExtensionAssignOperation extensionAssignOperation, Element extensionAssignOperationElement) {
		if (extensionAssignOperation == null) {
			extensionAssignOperation = BPELFactory.eINSTANCE.createExtensionAssignOperation();
			extensionAssignOperation.setElement(extensionAssignOperationElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(extensionAssignOperation, extensionAssignOperationElement);

		Element snippetElement = ReconciliationHelper
				.getSnippet(extensionAssignOperationElement);
		if (snippetElement != null && extensionAssignOperation.getSnippet() == null) {
			extensionAssignOperation.setSnippet(xml2Snippet(extensionAssignOperation.getSnippet(), snippetElement));
		} else if (snippetElement == null) {
			extensionAssignOperation.setSnippet(null);
		}

		xml2ExtensibleElement(extensionAssignOperation, extensionAssignOperationElement);

		return extensionAssignOperation;
	}
	
	
	
	/**
	 * returns a Snippet element from parent ExtensionAssignperation
	 * 
	 * @param parentElement
	 * @return
	 */
	protected Snippet xml2Snippet(Snippet snippet,Element snippetElement)
	{
		if (snippet == null) {
			snippet = BPELFactory.eINSTANCE.createSnippet();
			snippet.setElement(snippetElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(snippet, snippetElement);

		if (snippetElement == null) {
			return snippet;
		}

		String data = getText(snippetElement);
		if (data != null) {
			snippet.setBody(data);
		} else {
			snippet.setBody(null);
		}

		return snippet;
	}
	
	
	/**
	 * Converts an XML link element to a BPEL Link object.
	 */
	protected Link xml2Link(Link link, Element linkElement) {
		if (link == null) {
			link = BPELFactory.eINSTANCE.createLink();
			link.setElement(linkElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(link, linkElement);

		Attr name = linkElement.getAttributeNode("name");
		if (name != null && name.getSpecified()) {
			link.setName(name.getValue());
		} else {
			link.setName(null);
		}

		xml2ExtensibleElement(link, linkElement);

		return link;
	}

	/**
	 * Converts an XML pick element to a BPEL Pick object.
	 */
	protected Activity xml2Pick(Activity pickActivity, Element pickElement) {
		Pick pick;
		if (pickActivity instanceof Pick) {
			pick = (Pick) pickActivity;
		} else {
			pick = BPELFactory.eINSTANCE.createPick();
			pick.setElement(pickElement);
		}

		// Set name
		Attr name = pickElement.getAttributeNode("name");

		if (name != null && name.getSpecified()) {
			pick.setName(name.getValue());
		} else {
			pick.setName(null);
		}

		// Set createInstance
		Attr createInstance = pickElement.getAttributeNode("createInstance");
		if (createInstance != null && createInstance.getSpecified()) {
			pick.setCreateInstance(BPELUtils.xml2boolean(createInstance
					.getValue()));
		} else {
			pick.unsetCreateInstance();
		}

		syncLists(pickElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(pickElement,
						BPELConstants.ND_ON_ALARM), pick.getAlarm(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2OnAlarm(null, element);
					}
				});

		syncLists(pickElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(pickElement,
						BPELConstants.ND_ON_MESSAGE), pick.getMessages(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2OnMessage(null, element);
					}
				});

		setStandardAttributes(pickElement, pick);

		return pick;
	}

	/**
	 * Converts an XML eventHandler element to a BPEL eventHandler object.
	 */
	protected EventHandler xml2EventHandler(EventHandler eventHandler,
			Element eventHandlerElement) {
		if (eventHandler == null) {
			eventHandler = BPELFactory.eINSTANCE.createEventHandler();
			eventHandler.setElement(eventHandlerElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(eventHandler, eventHandlerElement);

		syncLists(eventHandlerElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(eventHandlerElement,
						BPELConstants.ND_ON_ALARM), eventHandler.getAlarm(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2OnAlarm(null, element);
					}
				});

		syncLists(eventHandlerElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(eventHandlerElement,
						BPELConstants.ND_ON_EVENT), eventHandler.getEvents(),
				new Creator() {
					public WSDLElement create(Element element) {
						return xml2OnEvent(null, element);
					}
				});

		xml2ExtensibleElement(eventHandler, eventHandlerElement);
		return eventHandler;
	}

	/**
	 * Converts an XML onMessage element to a BPEL OnMessage object.
	 */
	protected OnMessage xml2OnMessage(OnMessage onMessage,
			Element onMessageElement) {
		if (onMessage == null) {
			onMessage = BPELFactory.eINSTANCE.createOnMessage();
			onMessage.setElement(onMessageElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(onMessage, onMessageElement);

		// Set several parms
		setOperationParmsOnMessage(onMessageElement, onMessage);

		// Set activity
		onMessage.setActivity(getChildActivity(onMessage, onMessageElement));

		// set the fromParts
		Element fromPartsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(onMessageElement, "fromParts");
		if (fromPartsElement != null && onMessage.getFromParts() == null) {
			onMessage.setFromParts(xml2FromParts(onMessage.getFromParts(),
					fromPartsElement));
		} else if (fromPartsElement == null) {
			onMessage.setFromParts(null);
		}

		// Set messageExchange
		setMessageExchange(onMessageElement, (EObject) onMessage,
				BPELPackage.eINSTANCE.getOnMessage_MessageExchange());

		xml2ExtensibleElement(onMessage, onMessageElement);

		return onMessage;
	}

	/**
	 * Converts an XML onEvent element to a BPEL OnEvent object.
	 */
	protected OnEvent xml2OnEvent(OnEvent onEvent, Element onEventElement) {
		if (onEvent == null) {
			onEvent = BPELFactory.eINSTANCE.createOnEvent();
			onEvent.setElement(onEventElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(onEvent, onEventElement);

		// Set several parms
		setOperationParmsOnEvent(onEventElement, onEvent);

		// Set activity
		onEvent.setActivity(getChildActivity(onEvent, onEventElement));

		// set the fromParts
		Element fromPartsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(onEventElement, "fromParts");
		if (fromPartsElement != null && onEvent.getFromParts() == null) {
			FromParts fromParts = xml2FromParts(onEvent.getFromParts(),
					fromPartsElement);
			onEvent.setFromParts(fromParts);
		} else if (fromPartsElement == null) {
			onEvent.setFromParts(null);
		}

		// Handle CorrelationSets Element
		Element correlationSetsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(onEventElement,
						"correlationSets");
		if (correlationSetsElement != null
				&& onEvent.getCorrelationSets() == null) {
			onEvent.setCorrelationSets(xml2CorrelationSets(onEvent
					.getCorrelationSets(), correlationSetsElement));
		} else if (correlationSetsElement == null) {
			onEvent.setCorrelationSets(null);
		}

		// Set messageExchange
		setMessageExchange(onEventElement, (EObject) onEvent,
				BPELPackage.eINSTANCE.getOnEvent_MessageExchange());

		xml2ExtensibleElement(onEvent, onEventElement);

		return onEvent;
	}

	/**
	 * Converts an XML onAlarm element to a BPEL OnAlarm object.
	 */
	protected OnAlarm xml2OnAlarm(OnAlarm onAlarm, Element onAlarmElement) {
		if (onAlarm == null) {
			onAlarm = BPELFactory.eINSTANCE.createOnAlarm();
			onAlarm.setElement(onAlarmElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(onAlarm, onAlarmElement);

		// Set for element
		Element forElement = ReconciliationHelper
				.getBPELChildElementByLocalName(onAlarmElement, "for");
		if (forElement != null && onAlarm.getFor() == null) {
			onAlarm.setFor(xml2Expression(onAlarm.getFor(), forElement));
		} else if (forElement == null) {
			onAlarm.setFor(null);
		}

		// Set until element
		Element untilElement = ReconciliationHelper
				.getBPELChildElementByLocalName(onAlarmElement, "until");
		if (untilElement != null && onAlarm.getUntil() == null) {
			onAlarm.setUntil(xml2Expression(onAlarm.getUntil(), untilElement));
		} else if (untilElement == null) {
			onAlarm.setUntil(null);
		}

		// Set repeatEvery element
		Element repeatEveryElement = ReconciliationHelper
				.getBPELChildElementByLocalName(onAlarmElement, "repeatEvery");
		if (repeatEveryElement != null && onAlarm.getRepeatEvery() == null) {
			onAlarm.setRepeatEvery(xml2Expression(onAlarm.getRepeatEvery(),
					repeatEveryElement));
		} else if (repeatEveryElement == null) {
			onAlarm.setRepeatEvery(null);
		}

		// Set activity
		onAlarm.setActivity(getChildActivity(onAlarm, onAlarmElement));

		xml2ExtensibleElement(onAlarm, onAlarmElement);

		return onAlarm;
	}

	/**
	 * Converts an XML while element to a BPEL While object.
	 */
	protected Activity xml2While(Activity whileActivity, Element whileElement) {
		While _while;
		if (whileActivity instanceof While) {
			_while = (While) whileActivity;
		} else {
			_while = BPELFactory.eINSTANCE.createWhile();
			_while.setElement(whileElement);
		}

		// Handle condition element
		Element conditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(whileElement, "condition");
		if (conditionElement != null && _while.getCondition() == null) {
			_while.setCondition(xml2Condition(_while.getCondition(),
					conditionElement));
		} else if (conditionElement == null) {
			_while.setCondition(null);
		}

		_while.setActivity(getChildActivity(_while, whileElement));

		setStandardAttributes(whileElement, _while);

		return _while;
	}

	/**
	 * Converts an XML terminationHandler element to a BPEL TerminationHandler
	 * object.
	 */
	protected TerminationHandler xml2TerminationHandler(
			TerminationHandler terminationHandler,
			Element terminationHandlerElement) {
		if (terminationHandler == null) {
			terminationHandler = BPELFactory.eINSTANCE
					.createTerminationHandler();
			terminationHandler.setElement(terminationHandlerElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(terminationHandler, terminationHandlerElement);

		terminationHandler.setActivity(getChildActivity(terminationHandler,
				terminationHandlerElement));

		xml2ExtensibleElement(terminationHandler, terminationHandlerElement);

		return terminationHandler;
	}

	/**
	 * Converts an XML if element to a BPEL If object.
	 */
	protected Activity xml2If(Activity ifActivity, Element ifElement) {
		If _if;
		if (ifActivity instanceof If) {
			_if = (If) ifActivity;
		} else {
			_if = BPELFactory.eINSTANCE.createIf();
			_if.setElement(ifElement);
		}

		// Set activity
		Activity activity = getChildActivity(_if, ifElement);
		_if.setActivity(activity);

		// Handle condition element
		Element conditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(ifElement, "condition");
		if (conditionElement != null && _if.getCondition() == null) {
			_if
					.setCondition(xml2Condition(_if.getCondition(),
							conditionElement));
		} else if (conditionElement == null) {
			_if.setCondition(null);
		}

		// Handle elseif
		List<Element> childElements = ReconciliationHelper
				.getBPELChildElementsByLocalName(ifElement, "elseif");
		EList<ElseIf> childrenList = _if.getElseIf();
		syncLists(ifElement, childElements, childrenList, new Creator() {
			public WSDLElement create(Element element) {
				return xml2ElseIf(null, element);
			}
		});

		// Handle else
		Element elseElement = ReconciliationHelper
				.getBPELChildElementByLocalName(ifElement, "else");
		if (elseElement != null && _if.getElse() == null) {
			_if.setElse(xml2Else(_if.getElse(), elseElement));
		} else if (elseElement == null) {
			_if.setElse(null);
		}

		setStandardAttributes(ifElement, _if);

		return _if;
	}

	/**
	 * Converts an XML elseIf element to a BPEL ElseIf object.
	 */
	protected ElseIf xml2ElseIf(ElseIf elseIf, Element elseIfElement) {
		if (elseIf == null) {
			elseIf = BPELFactory.eINSTANCE.createElseIf();
			elseIf.setElement(elseIfElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(elseIf, elseIfElement);

		// Handle condition element
		Element conditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(elseIfElement, "condition");
		if (conditionElement != null && elseIf.getCondition() == null) {
			elseIf.setCondition(xml2Condition(elseIf.getCondition(),
					conditionElement));
		} else if (conditionElement == null) {
			elseIf.setCondition(null);
		}

		elseIf.setActivity(getChildActivity(elseIf, elseIfElement));

		return elseIf;
	}

	/**
	 * Converts an XML condition element to a BPEL Condition object.
	 */
	protected Condition xml2Condition(Condition condition,
			Element conditionElement) {
		if (condition == null) {
			condition = BPELFactory.eINSTANCE.createCondition();
			condition.setElement(conditionElement);
		}
		xml2Expression(condition, conditionElement);
		return condition;
	}

	/**
	 * Converts an XML expression element to a BPEL Expression object.
	 * 
	 * Accept a pre-constructed argument. This is good for sub-types of
	 * expression.
	 * 
	 * Returns the second argument as a convenience.
	 * 
	 */
	protected Expression xml2Expression(Expression expression,
			Element expressionElement) {
		if (expression == null) {
			expression = BPELFactory.eINSTANCE.createExpression();
			expression.setElement(expressionElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(expression, expressionElement);

		if (expressionElement == null) {
			return expression;
		}

		// Set expressionLanguage
		if (expressionElement.hasAttribute("expressionLanguage")) {
			expression.setExpressionLanguage(expressionElement
					.getAttribute("expressionLanguage"));
		} else {
			expression.unsetExpressionLanguage();
		}

		// Set opaque
		if (expressionElement.hasAttribute("opaque")) {
			expression.setOpaque(BPELUtils.xml2boolean(expressionElement
					.getAttribute("opaque")));
		} else {
			expression.unsetOpaque();
		}

		String data = getText(expressionElement);
		if (data != null) {
			expression.setBody(data);
		} else {
			expression.setBody(null);
		}

		return expression;
	}

	protected Else xml2Else(Else _else, Element elseElement) {
		if (_else == null) {
			_else = BPELFactory.eINSTANCE.createElse();
			_else.setElement(elseElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(_else, elseElement);

		Activity activity = getChildActivity(_else, elseElement);
		_else.setActivity(activity);

		return _else;
	}

	/**
	 * Converts an XML sequence element to a BPEL Sequence object.
	 */
	protected Activity xml2Sequence(Activity sequenceActivity,
			Element sequenceElement) {
		Sequence sequence;
		if (sequenceActivity instanceof Sequence) {
			sequence = (Sequence) sequenceActivity;
		} else {
			sequence = BPELFactory.eINSTANCE.createSequence();
			sequence.setElement(sequenceElement);
		}

		syncSequences(sequenceElement, sequence.getActivities());

		setStandardAttributes(sequenceElement, sequence);

		return sequence;
	}

	/**
	 * Converts an XML empty element to a BPEL Empty object.
	 */
	protected Activity xml2Empty(Activity activity, Element emptyElement) {
		Empty empty;
		if (activity instanceof Empty) {
			empty = (Empty) activity;
		} else {
			empty = BPELFactory.eINSTANCE.createEmpty();
			empty.setElement(emptyElement);
		}

		setStandardAttributes(emptyElement, empty);

		return empty;
	}

	/**
	 * Converts an XML opaqueActivity element to a BPEL OpaqueActivity object.
	 */
	protected Activity xml2OpaqueActivity(Activity opaque,
			Element opaqueActivityElement) {
		OpaqueActivity opaqueActivity;
		if (opaque instanceof OpaqueActivity) {
			opaqueActivity = (OpaqueActivity) opaque;
		} else {
			opaqueActivity = BPELFactory.eINSTANCE.createOpaqueActivity();
			opaqueActivity.setElement(opaqueActivityElement);
		}

		setStandardAttributes(opaqueActivityElement, opaqueActivity);

		return opaqueActivity;
	}

	/**
	 * Converts an XML valdateXML element to a BPEL ValidateXML object.
	 */
	protected Activity xml2Validate(Activity validateActivity,
			Element validateElement) {
		final Validate validate;
		if (validateActivity instanceof Validate) {
			validate = (Validate) validateActivity;
		} else {
			validate = BPELFactory.eINSTANCE.createValidate();
			validate.setElement(validateElement);
		}

		setStandardAttributes(validateElement, validate);
		validate.getVariables().clear();
		if (validateElement.hasAttribute("variables")) {
			String variables = validateElement.getAttribute("variables");
			StringTokenizer st = new StringTokenizer(variables);

			while (st.hasMoreTokens()) {
				final String variableName = st.nextToken();
				// We must do this as a post load runnable because the variable
				// might not
				// exist yet.
				Variable targetVariable = getVariable(validate, variableName);
				if (targetVariable == null) {
					targetVariable = new VariableProxy(getResource().getURI(),
							variableName);
				}
				validate.getVariables().add(targetVariable);
			}
		}
		return validate;
	}

	/**
	 * Converts an XML rethrow element to a BPEL Rethrow object.
	 */
	protected Activity xml2Rethrow(Activity rethrowActivity,
			Element rethrowElement) {
		Rethrow rethrow;
		if (rethrowActivity instanceof Rethrow) {
			rethrow = (Rethrow) rethrowActivity;
		} else {
			rethrow = BPELFactory.eINSTANCE.createRethrow();
			rethrow.setElement(rethrowElement);
		}

		setStandardAttributes(rethrowElement, rethrow);

		return rethrow;
	}

	/**
	 * Converts an XML extensionactivity element to a BPEL ExtensionActivity
	 * object.
	 */
	protected Activity xml2ExtensionActivity(Activity extensionActivity,
			Element extensionActivityElement) {
		// Do not call setStandardAttributes here because
		// extensionActivityElement
		// doesn't have them.

		List<Element> nodeList = getChildElements(extensionActivityElement);

		if (nodeList.size() == 1) {
			Element child = nodeList.get(0);
			// We found a child element. Look up a deserializer for this
			// activity and call it.
			String localName = child.getLocalName();
			String namespace = child.getNamespaceURI();
			QName qname = new QName(namespace, localName);
			BPELActivityDeserializer deserializer = extensionRegistry
					.getActivityDeserializer(qname);
			if (deserializer != null) {
				// Deserialize the DOM element and return the new Activity
				Map<String, String> nsMap = getAllNamespacesForElement(child);
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
				// pass the activity that was already created to the serializer
				extensionActivity = deserializer.unmarshall(qname, child,
						extensionActivity, process, nsMap, extensionRegistry, getResource()
										.getURI(), this);

				// Now let's do the standard attributes and elements
				setStandardAttributes(child, extensionActivity);
				setStandardElements(child, extensionActivity);

				// Don't do extensibility because extensionActivity is not
				// extensible.
				// If individual extensionActivity subclasses are actually
				// extensible, they
				// have to do this themselves in their deserializer.

				// The created Activity that extends from ExtensioActivity
				// should get the
				// whole <extensionActivity>-DOM-Fragment, this is done here.
				extensionActivity.setElement(extensionActivityElement);

				return extensionActivity;
			}
		}
		
		// TODO: do something smart here (deserializer not found?)
		return null;
	}

	/**
	 * Converts an XML wait element to a BPEL Wait object.
	 */
	protected Activity xml2Wait(Activity waitActivity, Element waitElement) {
		Wait wait;
		if (waitActivity instanceof Wait) {
			wait = (Wait) waitActivity;
		} else {
			wait = BPELFactory.eINSTANCE.createWait();
			wait.setElement(waitElement);
		}

		// Set name
		Attr name = waitElement.getAttributeNode("name");

		if (name != null && name.getSpecified())
			wait.setName(name.getValue());

		// Set for element
		Element forElement = ReconciliationHelper
				.getBPELChildElementByLocalName(waitElement, "for");
		if (forElement != null && wait.getFor() == null) {
			wait.setFor(xml2Expression(wait.getFor(), forElement));
		} else if (forElement == null) {
			wait.setFor(null);
		}

		// Set until element
		Element untilElement = ReconciliationHelper
				.getBPELChildElementByLocalName(waitElement, "until");
		if (untilElement != null && wait.getUntil() == null) {
			wait.setUntil(xml2Expression(wait.getUntil(), untilElement));
		} else if (untilElement == null) {
			wait.setUntil(null);
		}

		setStandardAttributes(waitElement, wait);

		return wait;
	}

	/**
	 * Converts an XML exit element to a BPEL Exit object.
	 */
	protected Activity xml2Exit(Activity activity, Element exitElement) {
		Exit exit;
		if (activity instanceof Exit) {
			exit = (Exit) activity;
		} else {
			exit = BPELFactory.eINSTANCE.createExit();
			exit.setElement(exitElement);
		}
		setStandardAttributes(exitElement, exit);

		return exit;
	}

	/**
	 * Converts an XML throw element to a BPEL Throw object.
	 */
	protected Activity xml2Throw(Activity throwActivity, Element throwElement) {
		Throw _throw;
		if (throwActivity instanceof Throw) {
			_throw = (Throw) throwActivity;
		} else {
			_throw = BPELFactory.eINSTANCE.createThrow();
			_throw.setElement(throwElement);
		}

		if (throwElement.hasAttribute("faultName")) {
			QName qName = BPELUtils.createAttributeValue(throwElement,
					"faultName");
			_throw.setFaultName(qName);
		} else {
			_throw.setFaultName(null);
		}

		// Set fault variable name
		setVariable(throwElement, _throw, "faultVariable",
				BPELPackage.eINSTANCE.getThrow_FaultVariable());

		setStandardAttributes(throwElement, _throw);

		return _throw;
	}

	/**
	 * Converts an XML assign element to a BPEL Assign object.
	 */
	protected Activity xml2Assign(Activity assignActivity, Element assignElement) {
		Assign assign;
		if (assignActivity instanceof Assign) {
			assign = (Assign) assignActivity;
		} else {
			assign = BPELFactory.eINSTANCE.createAssign();
			assign.setElement(assignElement);
		}

		if (assignElement.hasAttribute("validate")) {
			assign.setValidate(BPELUtils.xml2boolean(assignElement
					.getAttribute("validate")));
		} else {
			assign.setValidate(false);
		}

		syncLists(assignElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(assignElement, "copy"), assign
				.getCopy(), new Creator() {
			public WSDLElement create(Element element) {
				return xml2Copy(null, element);
			}
		});

		setStandardAttributes(assignElement, assign);

		return assign;
	}

	/**
	 * Converts an XML copy element to a BPEL Copy object.
	 */
	protected Copy xml2Copy(Copy copy, Element copyElement) {
		if (copy == null) {
			copy = BPELFactory.eINSTANCE.createCopy();
			copy.setElement(copyElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(copy, copyElement);

		Element fromElement = ReconciliationHelper
				.getBPELChildElementByLocalName(copyElement, "from");
		if (fromElement != null && copy.getFrom() == null) {
			copy.setFrom(xml2From(copy.getFrom(), fromElement));
		} else if (fromElement == null) {
			copy.setFrom(null);
		}

		Element toElement = ReconciliationHelper
				.getBPELChildElementByLocalName(copyElement, "to");
		if (toElement != null && copy.getTo() == null) {
			copy.setTo(xml2To(copy.getTo(), toElement));
		} else if (toElement == null) {
			copy.setTo(null);
		}

		if (copyElement.hasAttribute("keepSrcElementName")) {
			copy.setKeepSrcElementName(BPELUtils.xml2boolean(copyElement
					.getAttribute("keepSrcElementName")));
		} else {
			copy.unsetKeepSrcElementName();
		}

		if (copyElement.hasAttribute("ignoreMissingFromData")) {
			copy.setIgnoreMissingFromData(BPELUtils.xml2boolean(copyElement
					.getAttribute("ignoreMissingFromData")));
		} else {
			copy.unsetIgnoreMissingFromData();
		}

		xml2ExtensibleElement(copy, copyElement);

		return copy;
	}

	/**
	 * Converts an XML toPart element to a BPEL ToPart object.
	 */
	protected ToPart xml2ToPart(ToPart toPart, Element toPartElement) {
		if (toPart == null) {
			toPart = BPELFactory.eINSTANCE.createToPart();
			toPart.setElement(toPartElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(toPart, toPartElement);

		// Set part
		Attr part = toPartElement.getAttributeNode("part");

		if (part != null && part.getSpecified()) {
			final String partAttr = toPartElement.getAttribute("part");
			((ToPartImpl) toPart).setPartName(partAttr);
		} else {
			((ToPartImpl) toPart).setPartName(null);
		}

		// Set fromVariable
		setVariable(toPartElement, toPart, "fromVariable",
				BPELPackage.eINSTANCE.getToPart_FromVariable());

		return toPart;
	}

	/**
	 * Converts an XML fromPart element to a BPEL FromPart object.
	 */
	protected FromPart xml2FromPart(FromPart fromPart, Element fromPartElement) {
		if (fromPart == null) {
			fromPart = BPELFactory.eINSTANCE.createFromPart();
			fromPart.setElement(fromPartElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(fromPart, fromPartElement);

		// Set part
		Attr part = fromPartElement.getAttributeNode("part");

		if (part != null && part.getSpecified()) {
			final String partAttr = fromPartElement.getAttribute("part");
			((FromPartImpl) fromPart).setPartName(partAttr);
		} else {
			((FromPartImpl) fromPart).setPartName(null);
		}

		// Set toVariable
		setVariable(fromPartElement, fromPart, "toVariable",
				BPELPackage.eINSTANCE.getFromPart_ToVariable());

		return fromPart;
	}

	/**
	 *  Converts an XML FaultOnFailure element to a FaultOnFailure object
	 *  for failureHandling extension provided by ODE: JIRA:TOOLS-785
	 */
	protected FailureHandling xml2FailureHandling(FailureHandling failureHandling,Element failureHandlingElement) {
		if (!failureHandlingElement.getLocalName().equals("failureHandling"))
			return null;
		if (failureHandling == null) {
			failureHandling = BPELFactory.eINSTANCE.createFailureHandling();
			failureHandling.setElement(failureHandlingElement);
		}	
		
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(failureHandling, failureHandlingElement);		
		
		// Reading faultOnFailure Element
        Element faultOnFailureElement=  null;
        
        String localName = "faultOnFailure";
		NodeList children = failureHandlingElement.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (localName.equals(node.getLocalName())) {
					faultOnFailureElement = (Element) node;
	            }
			}	
        if (faultOnFailureElement != null) {
        	FaultOnFailure faultOnFailure = BPELFactory.eINSTANCE.createFaultOnFailure();
        	faultOnFailure.setElement(faultOnFailureElement);
            xml2FaultOnFailure(faultOnFailure, faultOnFailureElement); 
            failureHandling.setFaultOnFailure(faultOnFailure);
        }
        
     // Reading retryFor Element
        Element retryForElement=  null;
        
        localName = "retryFor";
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (localName.equals(node.getLocalName())) {
					retryForElement = (Element) node;
	            }
			}	
        if (retryForElement != null) {
        	RetryFor retryFor = BPELFactory.eINSTANCE.createRetryFor();
        	retryFor.setElement(retryForElement);
            xml2RetryFor(retryFor, retryForElement); 
            failureHandling.setRetryFor(retryFor);
        }
        
     // Reading retryDelay Element
        Element retryDelayElement=  null;
        
        localName = "retryDelay";
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (localName.equals(node.getLocalName())) {
					retryDelayElement = (Element) node;
	            }
			}	
        if (retryDelayElement != null) {
        	RetryDelay retryDelay = BPELFactory.eINSTANCE.createRetryDelay();
        	retryDelay.setElement(retryDelayElement);
            xml2RetryDelay(retryDelay, retryDelayElement); 
            failureHandling.setRetryDelay(retryDelay);
        }
        
		xml2ExtensibleElement(failureHandling, failureHandlingElement);
		
		return failureHandling;
	}
	/**
	 *  Converts an XML FaultOnFailure element to a FaultOnFailure object
	 *  for failureHandling extension provided by ODE: JIRA:TOOLS-785
	 */
	protected FaultOnFailure xml2FaultOnFailure(FaultOnFailure faultOnFailure,Element faultOnFailureElement)
	{
		if (faultOnFailure == null) {
			faultOnFailure = BPELFactory.eINSTANCE.createFaultOnFailure();
			faultOnFailure.setElement(faultOnFailureElement);
		}
		// Save all the references to external namespaces
		saveNamespacePrefix(faultOnFailure, faultOnFailureElement);
    	
		//reading body of the faultOnFailure and add it into the faultOnFailure object
		String data = getText(faultOnFailureElement);
		if (data != null) {
			faultOnFailure.setValue(Boolean.getBoolean(data));
		}
    	return faultOnFailure;
	}
	
	/**
	 *  Converts an XML retryFor element to a retryFor object
	 *  for failureHandling extension provided by ODE: JIRA:TOOLS-785
	 */
	protected RetryFor xml2RetryFor(RetryFor retryFor,Element retryForElement)
	{
		if (retryFor == null) {
			retryFor = BPELFactory.eINSTANCE.createRetryFor();
			retryFor.setElement(retryForElement);
		}
		// Save all the references to external namespaces
		saveNamespacePrefix(retryFor, retryForElement);
    	
		if (retryForElement == null) {
			return retryFor;
		}
		
		//reading body of the retryFor and add it into the retryFor object
		String data = getText(retryForElement);
		if (data != null) {
			retryFor.setValue(Integer.parseInt(data));
		}
	
    	return retryFor;
	}
	

	/**
	 *  Converts an XML RetryDelay element to a RetryDelay object
	 *  for failureHandling extension provided by ODE: JIRA:TOOLS-785
	 */
	protected RetryDelay xml2RetryDelay(RetryDelay retryDelay,Element retryDelayElement)
	{
		if (retryDelay == null) {
			retryDelay = BPELFactory.eINSTANCE.createRetryDelay();
			retryDelay.setElement(retryDelayElement);
		}
		
		// Save all the references to external namespaces
		saveNamespacePrefix(retryDelay, retryDelayElement);
    	
		
		if (retryDelayElement == null) {
			return retryDelay;
		}
		
		//reading body of the retryDelay and add it into the retryDelay object
		String data = getText(retryDelayElement);
		if (data != null) {
			retryDelay.setValue(Integer.parseInt(data));
		}
	
    	return retryDelay;
	}
	/**
	 * Converts an XML "to" element to a BPEL To object.
	 */
	protected To xml2To(To to, Element toElement) {
		if (to == null) {
			to = BPELFactory.eINSTANCE.createTo();
			to.setElement(toElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(to, toElement);

		// Set variable
		Attr variable = toElement.getAttributeNode("variable");

		if (variable != null && variable.getSpecified()) {
			setVariable(toElement, to, "variable", BPELPackage.eINSTANCE
					.getAbstractAssignBound_Variable());
		} else {
			to.setVariable(null);
		}

		// Set part
		Attr part = toElement.getAttributeNode("part");

		if (part != null && part.getSpecified()) {
			final String partAttr = toElement.getAttribute("part");
			((ToImpl) to).setPartName(partAttr);
		} else {
			((ToImpl) to).setPartName(null);
		}

		// Set partnerLink
		Attr partnerLink = toElement.getAttributeNode("partnerLink");

		if (partnerLink != null && partnerLink.getSpecified()) {
			setPartnerLink(toElement, to, BPELPackage.eINSTANCE
					.getAbstractAssignBound_PartnerLink());
		} else {
			to.setPartnerLink(null);
		}

		// Set property
		Attr property = toElement.getAttributeNode("property");
		if (property != null && property.getSpecified()) {
			setProperties(toElement, to, "property");
		} else {
			to.setProperty(null);
		}

		// Set query element
		Element queryElement = ReconciliationHelper
				.getBPELChildElementByLocalName(toElement, "query");
		if (queryElement != null && to.getQuery() == null) {
			to.setQuery(xml2Query(to.getQuery(), queryElement));
		} else if (queryElement == null) {
			if (partnerLink == null && variable == null) {
				Expression expression = to.getExpression();
				if (expression == null) {
					expression = BPELFactory.eINSTANCE.createExpression();
					to.setExpression(expression);
				}
				xml2Expression(expression, toElement);
			}
		}

		return to;
	}

	/**
	 * Converts an XML "from" element to a BPEL From object.
	 */
	protected From xml2From(From from, Element fromElement) {
		if (from == null) {
			from = BPELFactory.eINSTANCE.createFrom();
			from.setElement(fromElement);
		}

		/** This is basically what's in xml2To */

		// Save all the references to external namespaces
		saveNamespacePrefix(from, fromElement);

		// Set variable
		Attr variable = fromElement.getAttributeNode("variable");

		if (variable != null && variable.getSpecified()) {
			setVariable(fromElement, from, "variable", BPELPackage.eINSTANCE
					.getAbstractAssignBound_Variable());
		} else {
			from.setVariable(null);
		}

		// Set part
		Attr part = fromElement.getAttributeNode("part");

		if (part != null && part.getSpecified()) {
			final String partAttr = fromElement.getAttribute("part");
			((FromImpl) from).setPartName(partAttr);
		} else {
			((FromImpl) from).setPartName(null);
		}

		// Set partnerLink
		Attr partnerLink = fromElement.getAttributeNode("partnerLink");
		if (partnerLink != null && partnerLink.getSpecified()) {
			setPartnerLink(fromElement, from, BPELPackage.eINSTANCE
					.getAbstractAssignBound_PartnerLink());
		} else {
			from.setPartnerLink(null);
		}

		// Set property
		Attr property = fromElement.getAttributeNode("property");
		if (property != null && property.getSpecified()) {
			setProperties(fromElement, from, "property");
		}

		// Set query element
		Element queryElement = ReconciliationHelper
				.getBPELChildElementByLocalName(fromElement, "query");
		if (queryElement != null && from.getQuery() == null) {
			from.setQuery(xml2Query(from.getQuery(), queryElement));
		} else if (queryElement == null) {
			from.setQuery(null);
		}

		Attr endpointReference = fromElement
				.getAttributeNode("endpointReference");
		if (endpointReference != null && endpointReference.getSpecified()) {
			from.setEndpointReference(EndpointReferenceRole
					.get(endpointReference.getValue()));
		} else {
			from.unsetEndpointReference();
		}

		// Set service-ref element
		Element serviceRefElement = ReconciliationHelper
				.getBPELChildElementByLocalName(fromElement, "service-ref");
		if (serviceRefElement != null && from.getServiceRef() == null) {
			from.setServiceRef(xml2ServiceRef(from.getServiceRef(),
					serviceRefElement));
		} else if (serviceRefElement == null) {
			from.setServiceRef(null);
		}

		// Set opaque
		Attr opaque = fromElement.getAttributeNode("opaque");
		if (opaque != null && opaque.getSpecified()) {
			from.setOpaque(BPELUtils.xml2boolean(opaque.getValue()));
		} else {
			from.unsetOpaque();
		}

		// Literal node
		Element literalElement = ReconciliationHelper
				.getBPELChildElementByLocalName(fromElement, "literal");
		if (literalElement != null) {
			StringBuilder elementData = new StringBuilder(256);

			NodeList nl = literalElement.getChildNodes();

			outer: for (int i = 0; i < nl.getLength(); i++) {

				Node n = nl.item(i);
				switch (n.getNodeType()) {
				case Node.ELEMENT_NODE:
					elementData.setLength(0);
					elementData.append(BPELUtils.elementToString((Element) n));
					break outer;

				case Node.TEXT_NODE:
				case Node.CDATA_SECTION_NODE:
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
					// https://jira.jboss.org/browse/JBIDE-7351
					// don't display "null" for literal editor widgets
					{
						String data = getText(n);
						if (data != null)
							elementData.append(data);
					break;
					}
				}
			}

			from.setUnsafeLiteral(Boolean.FALSE);
			String elementDataFinal = elementData.toString();
			if (isEmptyOrWhitespace(elementDataFinal) == false) {
				from.setUnsafeLiteral(Boolean.TRUE);
				from.setLiteral(elementDataFinal);
			}

		} else {
			// add the judgment for these elements == null by Grid.Qian
			// if no the judgment, for example variable !=null, the from
			// element will has variable != null and expression != null
			// at the same time
			if (variable == null && partnerLink == null
					&& endpointReference == null && opaque ==null) {
				// must be expression
				Expression expressionObject = from.getExpression();
				if (expressionObject == null) {
					expressionObject = BPELFactory.eINSTANCE.createExpression();
					from.setExpression(expressionObject);
				}

				xml2Expression(expressionObject, fromElement);
			}
		}

		// See if there is an xsi:type attribute.
		if (fromElement.hasAttribute("xsi:type")) {
			QName qName = BPELUtils.createAttributeValue(fromElement,
					"xsi:type");
			XSDTypeDefinition type = new XSDTypeDefinitionProxy(getResource()
					.getURI(), qName);
			from.setType(type);
		} else {
			from.setType(null);
		}
		return from;
	}

	protected ServiceRef xml2ServiceRef(ServiceRef serviceRef,
			Element serviceRefElement) {
		if (serviceRef == null) {
			serviceRef = BPELFactory.eINSTANCE.createServiceRef();
			serviceRef.setElement(serviceRefElement);
		}

		// Set reference scheme
		if (serviceRefElement.hasAttribute("reference-scheme")) {
			String scheme = serviceRefElement.getAttribute("reference-scheme");
			serviceRef.setReferenceScheme(scheme);
		}

		// Set the value of the service reference

		// Determine whether or not there is an element in the child list.
		Node candidateChild = null;
		NodeList nodeList = serviceRefElement.getChildNodes();
		int length = nodeList.getLength();
		for (int i = 0; i < length; i++) {
			Node child = nodeList.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				candidateChild = child;
				break;
			}
		}
		if (candidateChild == null) {
			candidateChild = serviceRefElement.getFirstChild();
		}
		String data = getText(candidateChild);

		if (data == null) {
			// No text or CDATA node. If it's an element node, then
			// deserialize and install.
			if (candidateChild != null
					&& candidateChild.getNodeType() == Node.ELEMENT_NODE) {
				// Look if there's an ExtensibilityElement deserializer for
				// this element
				Element childElement = (Element) candidateChild;
				QName qname = new QName(childElement.getNamespaceURI(),
						childElement.getLocalName());
				BPELExtensionDeserializer deserializer = null;
				try {
					deserializer = (BPELExtensionDeserializer) extensionRegistry
							.queryDeserializer(BPELExtensibleElement.class, qname);
				} catch (WSDLException e) {
				}
				if (deserializer != null
						&& !(deserializer instanceof BPELUnknownExtensionDeserializer)) {
					// Deserialize the DOM element and add the new
					// Extensibility element to the parent
					// BPELExtensibleElement
					try {
						Map<String, String> nsMap = getAllNamespacesForElement(serviceRefElement);
						ExtensibilityElement extensibilityElement = deserializer
								.unmarshall(BPELExtensibleElement.class, qname,
										childElement, process, nsMap,
										extensionRegistry, getResource()
												.getURI(), this);
						serviceRef.setValue(extensibilityElement);
					} catch (WSDLException e) {
						throw new WrappedException(e);
					}
				} else {
					ServiceReferenceDeserializer referenceDeserializer = extensionRegistry
							.getServiceReferenceDeserializer(serviceRef
									.getReferenceScheme());
					if (referenceDeserializer != null) {
						Object serviceReference = referenceDeserializer
								.unmarshall(childElement, process);
						serviceRef.setValue(serviceReference);
					}
				}
			}
		} else {
			serviceRef.setValue(data);
		}
		return serviceRef;
	}

	protected Query xml2Query(Query queryObject, Element queryElement) {
		if (queryObject == null) {
			queryObject = BPELFactory.eINSTANCE.createQuery();
		}

		queryObject.setElement(queryElement);

		// Set queryLanguage
		if (queryElement.hasAttribute("queryLanguage")) {
			String queryLanguage = queryElement.getAttribute("queryLanguage");
			queryObject.setQueryLanguage(queryLanguage);
		} else {
			queryObject.setQueryLanguage(null);
		}

		// Set query text
		// Get the condition text
		String data = getText(queryElement);
		if (data != null) {
			queryObject.setValue(data);
		} else {
			queryObject.setValue(null);
		}
		return queryObject;
	}

	/**
	 * Converts an XML import element to a BPEL Import object.
	 */
	protected Import xml2Import(Import imp, Element importElement) {
		if (!importElement.getLocalName().equals("import"))
			return null;

		if (imp == null) {
			imp = BPELFactory.eINSTANCE.createImport();
			imp.setElement(importElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(imp, importElement);

		// namespace
		if (importElement.hasAttribute("namespace")) {
			imp.setNamespace(importElement.getAttribute("namespace"));
		} else {
			imp.setNamespace(null);
		}

		// location
		if (importElement.hasAttribute("location")) {
			imp.setLocation(importElement.getAttribute("location"));
		} else {
			imp.setLocation(null);
		}

		// importType
		if (importElement.hasAttribute("importType")) {
			imp.setImportType(importElement.getAttribute("importType"));
		} else {
			imp.setImportType(null);
		}

		return imp;
	}

	/**
	 * Converts an XML invoke element to a BPEL Invoke object.
	 */
	protected Activity xml2Invoke(Activity invokeActivity, Element invokeElement) {
		Invoke invoke;
		if (invokeActivity instanceof Invoke) {
			invoke = (Invoke) invokeActivity;
		} else {
			invoke = BPELFactory.eINSTANCE.createInvoke();
			invoke.setElement(invokeElement);
		}

		// Set several parms
		setStandardAttributes(invokeElement, invoke);
		setOperationParms(invokeElement, invoke, null, BPELPackage.eINSTANCE
				.getInvoke_InputVariable(), BPELPackage.eINSTANCE
				.getInvoke_OutputVariable(), BPELPackage.eINSTANCE
				.getPartnerActivity_PartnerLink());

		// Set compensationHandler
		setCompensationHandler(invokeElement, invoke);

		// Set the fault handler (for catche-s and catchAll-s)
		FaultHandler faultHandler = xml2FaultHandler(invoke.getFaultHandler(),
				invokeElement);
		if (faultHandler != null
				&& (!faultHandler.getCatch().isEmpty() || faultHandler
						.getCatchAll() != null)) {
			// Only set this on the activity if there is at least one catch
			// clause, or a catchAll clause
			invoke.setFaultHandler(faultHandler);
		}

		// set the toParts
		Element toPartsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(invokeElement, "toParts");
		if (toPartsElement != null && invoke.getToParts() == null) {
			invoke.setToParts(xml2ToParts(invoke.getToParts(), toPartsElement));
		} else if (toPartsElement == null) {
			invoke.setToParts(null);
		}

		// set the fromParts
		Element fromPartsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(invokeElement, "fromParts");
		if (fromPartsElement != null && invoke.getFromParts() == null) {
			invoke.setFromParts(xml2FromParts(invoke.getFromParts(),
					fromPartsElement));
		} else if (fromPartsElement == null) {
			invoke.setFromParts(null);
		}
		// Set failureHandling
		NodeList children = invokeElement.getChildNodes();
		Element failureHandlingElement = null;
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if ("failureHandling".equals(node.getLocalName())){
               
				failureHandlingElement=  (Element) node;
				break;
			}
		}
		if (failureHandlingElement != null) {
			FailureHandling failureHandling = xml2FailureHandling(invoke.getFailureHandling(),failureHandlingElement);
			invoke.setFailureHandling(failureHandling);
		}else if (fromPartsElement == null) {
			invoke.setFailureHandling(null);
		}

		return invoke;
	}

	/**
	 * Converts an XML reply element to a BPEL Reply object.
	 * 
	 * @param activity
	 */
	protected Activity xml2Reply(Activity replyActivity, Element replyElement) {
		Reply reply;
		if (replyActivity instanceof Reply) {
			reply = (Reply) replyActivity;
		} else {
			reply = BPELFactory.eINSTANCE.createReply();
			reply.setElement(replyElement);
		}

		// Set several parms
		setStandardAttributes(replyElement, reply);
		setOperationParms(replyElement, reply, BPELPackage.eINSTANCE
				.getReply_Variable(), null, null, BPELPackage.eINSTANCE
				.getPartnerActivity_PartnerLink());

		if (replyElement.hasAttribute("faultName")) {
			QName qName = BPELUtils.createAttributeValue(replyElement,
					"faultName");
			reply.setFaultName(qName);
		} else {
			reply.setFaultName(null);
		}

		// set the toParts
		Element toPartsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(replyElement, "toParts");
		if (toPartsElement != null && reply.getToParts() == null) {
			reply.setToParts(xml2ToParts(reply.getToParts(), toPartsElement));
		} else if (toPartsElement == null) {
			reply.setToParts(null);
		}

		// Set messageExchange
		setMessageExchange(replyElement, (EObject) reply, BPELPackage.eINSTANCE
				.getReply_MessageExchange());

		return reply;
	}

	/**
	 * Converts an XML receive element to a BPEL Receive object.
	 */
	protected Activity xml2Receive(Activity receiveActivity,
			Element receiveElement) {
		Receive receive;
		if (receiveActivity instanceof Receive) {
			receive = (Receive) receiveActivity;
		} else {
			receive = BPELFactory.eINSTANCE.createReceive();
			receive.setElement(receiveElement);
		}

		// Set several parms
		setStandardAttributes(receiveElement, receive);
		setOperationParms(receiveElement, receive, BPELPackage.eINSTANCE
				.getReceive_Variable(), null, null, BPELPackage.eINSTANCE
				.getPartnerActivity_PartnerLink());

		// Set createInstance
		if (receiveElement.hasAttribute("createInstance")) {
			receive.setCreateInstance(BPELUtils.xml2boolean(receiveElement
					.getAttribute("createInstance")));
		} else {
			receive.unsetCreateInstance();
		}

		// set the fromParts
		Element fromPartsElement = ReconciliationHelper
				.getBPELChildElementByLocalName(receiveElement, "fromParts");
		if (fromPartsElement != null && receive.getFromParts() == null) {
			receive.setFromParts(xml2FromParts(receive.getFromParts(),
					fromPartsElement));
		} else if (fromPartsElement == null) {
			receive.setFromParts(null);
		}

		// Set messageExchange
		setMessageExchange(receiveElement, (EObject) receive,
				BPELPackage.eINSTANCE.getReceive_MessageExchange());

		return receive;
	}

	/**
	 * Converts an XML forEach element to a BPEL ForEach object.
	 */
	protected Activity xml2ForEach(Activity forEachActivity,
			Element forEachElement) {
		ForEach forEach;
		if (forEachActivity instanceof ForEach) {
			forEach = (ForEach) forEachActivity;
		} else {
			forEach = BPELFactory.eINSTANCE.createForEach();
			forEach.setElement(forEachElement);
		}

		// Set several parms
		setStandardAttributes(forEachElement, forEach);

		if (forEachElement.hasAttribute("parallel")) {
			// if (process != null) {
			// process.setSuppressJoinFailure(BPELUtils.xml2boolean(forEachElement.getAttribute("parallel"));
			// }
			forEach.setParallel(BPELUtils.xml2boolean(forEachElement
					.getAttribute("parallel")));
		} else {
			forEach.setParallel(false);
		}

		// Set counterName variable
		if (forEachElement.hasAttribute("counterName")) {

			String counterName = forEachElement.getAttribute("counterName");
			if (forEach.getCounterName() == null
					|| !forEach.getCounterName().getName().equals(counterName)) {
				Variable variable = BPELFactory.eINSTANCE.createVariable();
				// TODO: How to facade this ?
				variable.setName(counterName);
				QName qName = new QName(
						XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001, "unsignedInt");
				XSDTypeDefinition type = new XSDTypeDefinitionProxy(
						getResource().getURI(), qName);
				variable.setType(type);
				forEach.setCounterName(variable);
			}
		} else {
			forEach.setCounterName(null);
		}

		// Set startCounterValue element
		Element startCounterValueElement = ReconciliationHelper
				.getBPELChildElementByLocalName(forEachElement,
						"startCounterValue");
		if (startCounterValueElement != null
				&& forEach.getStartCounterValue() == null) {
			forEach.setStartCounterValue(xml2Expression(forEach
					.getStartCounterValue(), startCounterValueElement));
		} else if (startCounterValueElement == null) {
			forEach.setStartCounterValue(null);
		}

		// Set finalCounterValue element
		Element finalCounterValueElement = ReconciliationHelper
				.getBPELChildElementByLocalName(forEachElement,
						"finalCounterValue");
		if (finalCounterValueElement != null
				&& forEach.getFinalCounterValue() == null) {
			forEach.setFinalCounterValue(xml2Expression(forEach
					.getFinalCounterValue(), finalCounterValueElement));
		} else if (finalCounterValueElement == null) {
			forEach.setFinalCounterValue(null);
		}

		// Set completionCondition element
		Element completionConditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(forEachElement,
						"completionCondition");
		if (completionConditionElement != null
				&& forEach.getCompletionCondition() == null) {
			forEach.setCompletionCondition(xml2CompletionCondition(forEach
					.getCompletionCondition(), completionConditionElement));
		} else if (completionConditionElement == null) {
			forEach.setCompletionCondition(null);
		}

		// Set activity
		Activity activity = getChildActivity(forEach, forEachElement);
		if (activity instanceof Scope) {
			forEach.setActivity(activity);
		} else {
			forEach.setActivity(null);
		}

		return forEach;
	}

	/**
	 * Converts an XML completionCondition element to a BPEL CompletionCondition
	 * object.
	 */
	protected CompletionCondition xml2CompletionCondition(
			CompletionCondition completionCondition,
			Element completionConditionElement) {
		if (completionCondition == null) {
			completionCondition = BPELFactory.eINSTANCE
					.createCompletionCondition();
			completionCondition.setElement(completionConditionElement);
		}

		// Set branches element
		Element branchesElement = ReconciliationHelper
				.getBPELChildElementByLocalName(completionConditionElement,
						"branches");
		if (branchesElement != null
				&& completionCondition.getBranches() == null) {
			completionCondition.setBranches(xml2Branches(completionCondition
					.getBranches(), branchesElement));
		} else if (branchesElement == null) {
			completionCondition.setBranches(null);
		}

		return completionCondition;
	}

	/**
	 * Converts an XML branches element to a BPEL Branches object.
	 */
	protected Branches xml2Branches(Branches branches, Element branchesElement) {
		if (branches == null) {
			branches = BPELFactory.eINSTANCE.createBranches();
			branches.setElement(branchesElement);
		}

		xml2Expression(branches, branchesElement);

		if (branchesElement.hasAttribute("successfulBranchesOnly")) {
			branches.setCountCompletedBranchesOnly(BPELUtils
					.xml2boolean(branchesElement
							.getAttribute("successfulBranchesOnly")));
		} else {
			branches.unsetCountCompletedBranchesOnly();
		}
		return branches;
	}

	/**
	 * Converts an XML documentation element to a BPEL Documentation object.
	 */
	protected Documentation xml2Documentation(Documentation documentation,
			Element documentationElement) {
		if (documentation == null) {
			documentation = BPELFactory.eINSTANCE.createDocumentation();
		}
		((DocumentationImpl) documentation).setElement(documentationElement);

		if (documentationElement.hasAttribute("xml:lang")) {
			documentation
					.setLang(documentationElement.getAttribute("xml:lang"));
		} else {
			documentation.setLang(null);
		}
		if (documentationElement.hasAttribute("source")) {
			documentation
					.setSource(documentationElement.getAttribute("source"));
		} else {
			documentation.setSource(null);
		}

		String text = getText(documentationElement);
		if (text != null) {
			documentation.setValue(text);
		} else {
			documentation.setValue(null);
		}

		return documentation;
	}

	/**
	 * Converts an XML repeatUntil element to a BPEL RepeatUntil object.
	 */
	protected Activity xml2RepeatUntil(Activity repeatUntilActivity,
			Element repeatUntilElement) {
		RepeatUntil repeatUntil;
		if (repeatUntilActivity instanceof RepeatUntil) {
			repeatUntil = (RepeatUntil) repeatUntilActivity;
		} else {
			repeatUntil = BPELFactory.eINSTANCE.createRepeatUntil();
			repeatUntil.setElement(repeatUntilElement);
		}

		// Set several parms
		setStandardAttributes(repeatUntilElement, repeatUntil);

		// Handle condition element
		Element conditionElement = ReconciliationHelper
				.getBPELChildElementByLocalName(repeatUntilElement, "condition");
		if (conditionElement != null && repeatUntil.getCondition() == null) {
			repeatUntil.setCondition(xml2Condition(repeatUntil.getCondition(),
					conditionElement));
		} else if (conditionElement == null) {
			repeatUntil.setCondition(null);
		}

		repeatUntil.setActivity(getChildActivity(repeatUntil,
				repeatUntilElement));

		return repeatUntil;
	}

	protected Correlations xml2Correlations(Correlations correlations,
			Element correlationsElement) {
		if (!correlationsElement.getLocalName().equals("correlations"))
			return null;

		if (correlations == null) {
			correlations = BPELFactory.eINSTANCE.createCorrelations();
			correlations.setElement(correlationsElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(correlations, correlationsElement);

		syncLists(correlationsElement, ReconciliationHelper
				.getBPELChildElementsByLocalName(correlationsElement,
						BPELConstants.ND_CORRELATION), correlations
				.getChildren(), new Creator() {
			public WSDLElement create(Element element) {
				return xml2Correlation(null, element);
			}
		});

		// extensibility elements
		xml2ExtensibleElement(correlations, correlationsElement);

		return correlations;
	}

	/**
	 * Converts an XML correlation element to a BPEL Correlation object.
	 */
	protected Correlation xml2Correlation(Correlation correlation,
			Element correlationElement) {
		if (correlation == null) {
			correlation = BPELFactory.eINSTANCE.createCorrelation();
			correlation.setElement(correlationElement);
		}

		// Save all the references to external namespaces
		saveNamespacePrefix(correlation, correlationElement);

		if (correlationElement == null)
			return correlation;

		// Set set
		if (correlationElement.hasAttribute("set")) {
			final String correlationSetName = correlationElement
					.getAttribute("set");
			CorrelationSet cSet = BPELUtils.getCorrelationSetForActivity(
					correlation, correlationSetName);
			if (cSet == null) {
				cSet = new CorrelationSetProxy(getResource().getURI(),
						correlationSetName);
			}
			correlation.setSet(cSet);
		} else {
			correlation.setSet(null);
		}

		// Set initiation
		Attr initiation = correlationElement.getAttributeNode("initiate");
		if (initiation != null && initiation.getSpecified()) {
			if (initiation.getValue().equals("yes"))
				correlation.setInitiate("yes");
			else if (initiation.getValue().equals("no"))
				correlation.setInitiate("no");
			else if (initiation.getValue().equals("join"))
				correlation.setInitiate("join");
			else
				correlation.unsetInitiate();
		} else {
			correlation.unsetInitiate();
		}

		// Set pattern
		Attr pattern = correlationElement.getAttributeNode("pattern");

		if (pattern != null && pattern.getSpecified()) {
			if (pattern.getValue().equals("request"))
				correlation.setPattern(CorrelationPattern.REQUEST_LITERAL);
			else if (pattern.getValue().equals("response"))
				correlation.setPattern(CorrelationPattern.RESPONSE_LITERAL);
			else if (pattern.getValue().equals("request-response"))
				correlation
						.setPattern(CorrelationPattern.REQUESTRESPONSE_LITERAL);
			else
				correlation.unsetPattern();
		} else {
			correlation.unsetPattern();
		}

		xml2ExtensibleElement(correlation, correlationElement);

		return correlation;
	}

	protected Compensate xml2Compensate(Activity compensateActivity,
			Element compensateElement) {
		Compensate compensate;
		if (compensateActivity instanceof Compensate) {
			compensate = (Compensate) compensateActivity;
		} else {
			compensate = BPELFactory.eINSTANCE.createCompensate();
			compensate.setElement(compensateElement);
		}
		setStandardAttributes(compensateElement, compensate);
		return compensate;
	}

	protected CompensateScope xml2CompensateScope(
			Activity compensateScopeActivity, Element compensateScopeElement) {

		CompensateScope compensateScope;
		if (compensateScopeActivity instanceof CompensateScope) {
			compensateScope = (CompensateScope) compensateScopeActivity;
		} else {
			compensateScope = BPELFactory.eINSTANCE.createCompensateScope();
			compensateScope.setElement(compensateScopeElement);
		}

		final String target = compensateScopeElement.getAttribute("target");

		if (target != null && target.length() > 0) {
			compensateScope.setTarget(target);
		} else {
			compensateScope.setTarget((Activity) null);
		}

		setStandardAttributes(compensateScopeElement, compensateScope);

		return compensateScope;
	}

	/**
	 * Converts an XML extensible element to a BPEL extensible element
	 */

	protected void xml2ExtensibleElement(BPELExtensibleElement extensibleElement,
			Element element) {

		if (extensionRegistry == null) {
			return;
		}

		// Handle the documentation element first
		Element documentationElement = ReconciliationHelper
				.getBPELChildElementByLocalName(element, "documentation");
		if (documentationElement != null
				&& extensibleElement.getDocumentation() == null) {
			extensibleElement
					.setDocumentation(xml2Documentation(extensibleElement
							.getDocumentation(), documentationElement));
		} else if (documentationElement == null) {
			extensibleElement.setDocumentation(null);
		}

		// Get the child nodes, elements and attributes
		List<Node> nodes = new ArrayList<Node>();

		NodeList nodeList = element.getChildNodes();
		for (int i = 0, n = nodeList.getLength(); i < n; i++) {
			if (nodeList.item(i) instanceof Element) {
				final String namespaceURI = ((Element) nodeList.item(i))
						.getNamespaceURI();
				if (!(BPELConstants.isBPELNamespace(namespaceURI)))
					nodes.add(nodeList.item(i));
			}
		}

		NamedNodeMap nodeMap = element.getAttributes();
		for (int i = 0, n = nodeMap.getLength(); i < n; i++) {
			Attr attr = (Attr) nodeMap.item(i);
			if (attr.getNamespaceURI() != null
					&& !attr.getNamespaceURI().equals(
							XSDConstants.XMLNS_URI_2000)) {
				nodes.add(attr);
			}
		}

		extensibleElement.getExtensibilityElements().clear();

		for (Node node : nodes) {

			// TODO What is this check for? If we're actually checking for
			// the BPEL namespace, use BPELConstants instead.
			if (MessagepropertiesConstants.isMessagePropertiesNamespace(node
					.getNamespaceURI())) {
				continue;
			}

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				deserialize(extensibleElement, (Element) node);
			} else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
				deserialize(extensibleElement, (Attr) node);
			}
		}
	}

	protected void deserialize(BPELExtensibleElement ee, Element elm) {

		QName qname = new QName(elm.getNamespaceURI(), elm.getLocalName());
		BPELExtensionDeserializer deserializer = null;
		try {
			deserializer = (BPELExtensionDeserializer) extensionRegistry
					.queryDeserializer(BPELExtensibleElement.class, qname);
		} catch (WSDLException e) {
			// we don't have one.
		}
		if (deserializer == null) {
			return;
		}
		// Deserialize the DOM element and add the new Extensibility element to
		// the parent
		// BPELExtensibleElement
		Map<String, String> nsMap = getAllNamespacesForElement(elm);
		try {
			ExtensibilityElement extensibilityElement = deserializer
					.unmarshall(ee.getClass(), qname, elm, process, nsMap,
							extensionRegistry, getResource().getURI(), this);
			ee.addExtensibilityElement(extensibilityElement);
		} catch (WSDLException e) {
			throw new WrappedException(e);
		}
	}

	protected void deserialize(BPELExtensibleElement ee, Attr attr) {

		if (attr.getSpecified() == false) {
			return;
		}

		QName qname = new QName(attr.getNamespaceURI(),
				"extensibilityAttributes");
		BPELExtensionDeserializer deserializer = null;
		try {
			deserializer = (BPELExtensionDeserializer) extensionRegistry
					.queryDeserializer(BPELExtensibleElement.class, qname);
		} catch (WSDLException e) {
			// ignore
		}
		if (deserializer == null) {
			return;
		}

		// Create a temp element to host the extensibility attribute
		// 
		// This turns something that looks like this:
		// <bpws:X someNS:Y="Z"/>
		// into something that looks like this:
		// <someNS:extensibilityAttributes xmlns:someNS="http://the.namespace"
		// Y="Z"/>

		Element tempElement = attr.getOwnerDocument().createElementNS(
				attr.getNamespaceURI(),
				attr.getPrefix() + ":extensibilityAttributes");
		tempElement.setAttribute(BPELUtils.ATTR_XMLNS + ":" + attr.getPrefix(),
				attr.getNamespaceURI());
		tempElement.setAttribute(attr.getLocalName(), attr.getNodeValue());

		// Deserialize the temp DOM element and add the new Extensibility
		// element to the parent
		// BPELExtensibleElement
		Map<String, String> nsMap = getAllNamespacesForElement((Element) attr
				.getParentNode());
		try {
			ExtensibilityElement extensibilityElement = deserializer
					.unmarshall(BPELExtensibleElement.class, qname, tempElement,
							process, nsMap, extensionRegistry, getResource()
									.getURI(), this);
			if (extensibilityElement != null) {
				ee.addExtensibilityElement(extensibilityElement);
			}
		} catch (WSDLException e) {
			throw new WrappedException(e);
		}
	}

	/**
	 * Returns true if the string is either null or contains just whitespace.
	 * 
	 * @param value
	 * @return true if empty or whitespace, false otherwise.
	 */

	static public boolean isEmptyOrWhitespace(String value) {
		if (value == null || value.length() == 0) {
			return true;
		}
		for (int i = 0, j = value.length(); i < j; i++) {
			if (!Character.isWhitespace(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the text of the given node. If the node is an element node, its
	 * children text value is returned. Otherwise, the node is assumed to be the
	 * first child node and the siblings sequence is scanned.
	 * 
	 * 
	 */

	String getText(Node node) {

		StringBuilder sb = new StringBuilder(128);

		if (node instanceof Element) {
			node = ((Element) node).getFirstChild();
		}

		boolean bCData = false;

		while (node != null) {
			switch (node.getNodeType()) {
			case Node.TEXT_NODE:
				if (bCData) {
					break;
				}
				Text text = (Text) node;
				sb.append(text.getData());
				break;
			case Node.CDATA_SECTION_NODE:
				if (bCData == false) {
					sb.setLength(0);
					bCData = true;
				}
				CDATASection cdata = (CDATASection) node;
				sb.append(cdata.getData());
				break;
			}
			node = node.getNextSibling();
		}
		String data = sb.toString();
		if (isEmptyOrWhitespace(data)) {
			return null;
		}
		return data;
	}

	/**
	 * @param eObject
	 * @param variableName
	 * @return the resolved variable
	 */
	public static Variable getVariable(EObject eObject, String variableName) {
		return VARIABLE_RESOLVER.getVariable(eObject, variableName);
	}

	/**
	 * @param activity
	 * @param linkName
	 * @return the resolved link
	 */
	public static Link getLink(Activity activity, String linkName) {
		return LINK_RESOLVER.getLink(activity, linkName);
	}

	private interface Creator {
		WSDLElement create(Element element);
	}

	private void syncLists(Element ifElement, List<Element> childElements,
			EList childrenList, Creator creator) {
		WSDLElement[] children = (WSDLElement[]) childrenList
				.toArray(new WSDLElement[childrenList.size()]);
		int i, j, insertionIndex = 0;
		for (i = 0, j = 0; i < children.length && j < childElements.size(); i++) {
			WSDLElement elseIf = children[i];
			if (elseIf.getElement() == null
					|| elseIf.getElement().getParentNode() != ifElement) {
				childrenList.remove(insertionIndex);
				continue;
			}
			Element element = childElements.get(j);
			while (elseIf.getElement() != element && j < childElements.size()) {
				childrenList.add(insertionIndex, creator.create(element));
				j++;
				insertionIndex++;
				element = childElements.get(j);
			}
			if (elseIf.getElement() == element) {
				j++;
				insertionIndex++;
			}
		}
		for (int k = i; k < children.length; k++) {
			WSDLElement elseIf = children[k];
			if (elseIf.getElement() == null
					|| elseIf.getElement().getParentNode() != ifElement) {
				childrenList.remove(elseIf);
			}
		}
		for (int k = j; k < childElements.size(); k++) {
			childrenList.add(creator.create(childElements.get(k)));

		}
	}

	private void syncSequences(Element sequenceElement,
			EList<Activity> activitiesList) {
		NodeList sequenceElements = sequenceElement.getChildNodes();

		Element activityElement = null;
		Activity[] activities = new Activity[activitiesList.size()];
		activitiesList.toArray(activities);

		if (sequenceElements != null) {
			int i = 0, j = 0, insertionIndex = 0;
			for (; i < sequenceElements.getLength() && j < activities.length; j++) {
				while (sequenceElements.item(i) != null
						&& (sequenceElements.item(i).getNodeType() != Node.ELEMENT_NODE || ((Element) sequenceElements
								.item(i)).getLocalName().equals("links"))) {
					i++;
				}

				activityElement = (Element) sequenceElements.item(i);
				Activity activity = activities[j];
				if (activity.getElement() == null
						|| activity.getElement().getParentNode() != sequenceElement) {
					activitiesList.remove(insertionIndex);
					continue;
				}
				Node node = activityElement;
				while (node != activity.getElement()
						&& i < sequenceElements.getLength()) {
					if (node.getNodeType() == Node.ELEMENT_NODE
							&& !((Element) node).getLocalName().equals("links")) {
						activityElement = (Element) sequenceElements.item(i);
						Activity newActivity = xml2Activity(null,
								activityElement);
						if (newActivity != null) {
							activitiesList.add(insertionIndex, newActivity);
							insertionIndex++;
						}
					}
					i++;
					node = sequenceElements.item(i);
				}
				if (node == activity.getElement()) {
					insertionIndex++;
					i++;
				}
			}
			for (int k = j; k < activities.length; k++) {
				Activity activity = activities[k];
				if (activity.getElement() == null
						|| activity.getElement().getParentNode() != sequenceElement) {
					activitiesList.remove(activity);
				}
			}
			for (int k = i; k < sequenceElements.getLength(); k++) {
				if (sequenceElements.item(k) != null
						&& (sequenceElements.item(k).getNodeType() != Node.ELEMENT_NODE || ((Element) sequenceElements
								.item(k)).getLocalName().equals("links"))) {
					continue;
				}
				activityElement = (Element) sequenceElements.item(k);
				Activity newActivity = xml2Activity(null, activityElement);
				if (newActivity != null) {
					activitiesList.add(newActivity);
				}

			}
		} else {
			activitiesList.clear();
		}
	}

	private void createLink(final Target target, final String linkName) {
		Link link = getLink(target.getActivity(), linkName);
		if (link != null)
			target.setLink(link);
		else
			target.setLink(new LinkProxy(getResource().getURI(), linkName));
	}

	private void createLink(final Source source, final String linkName) {
		Link link = getLink(source.getActivity(), linkName);
		if (link != null)
			source.setLink(link);
		else
			source.setLink(new LinkProxy(getResource().getURI(), linkName));
	}

	/**
	 * @see org.xml.sax.ErrorHandler#error(org.xml.sax.SAXParseException)
	 */
	@SuppressWarnings("boxing")
	public void error(SAXParseException exception) {

		String message = java.text.MessageFormat.format(
				"Error in {0} [{2}:{3}] {4}", exception.getPublicId(),
				exception.getSystemId(), exception.getLineNumber(), exception
						.getColumnNumber(), exception.getLocalizedMessage());
		BPELPlugin.logMessage(message, exception, IStatus.ERROR);
	}

	/**
	 * @see org.xml.sax.ErrorHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	@SuppressWarnings("boxing")
	public void fatalError(SAXParseException exception) {
		String message = java.text.MessageFormat.format(
				"Fatal Error in {0} [{2}:{3}] {4}", exception.getPublicId(),
				exception.getSystemId(), exception.getLineNumber(), exception
						.getColumnNumber(), exception.getLocalizedMessage());
		BPELPlugin.logMessage(message, exception, IStatus.ERROR);
	}

	/**
	 * @see org.xml.sax.ErrorHandler#warning(org.xml.sax.SAXParseException)
	 */
	@SuppressWarnings("boxing")
	public void warning(SAXParseException exception) {
		String message = java.text.MessageFormat.format(
				"Warning in {0} [{2}:{3}] {4}", exception.getPublicId(),
				exception.getSystemId(), exception.getLineNumber(), exception
						.getColumnNumber(), exception.getLocalizedMessage());
		BPELPlugin.logMessage(message, exception, IStatus.WARNING);

	}
}
