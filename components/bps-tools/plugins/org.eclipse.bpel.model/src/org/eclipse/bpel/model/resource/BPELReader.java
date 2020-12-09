/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.model.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.bpel.model.impl.FromImpl;
import org.eclipse.bpel.model.impl.FromPartImpl;
import org.eclipse.bpel.model.impl.OnEventImpl;
import org.eclipse.bpel.model.impl.OnMessageImpl;
import org.eclipse.bpel.model.impl.PartnerActivityImpl;
import org.eclipse.bpel.model.impl.ToImpl;
import org.eclipse.bpel.model.impl.ToPartImpl;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.util.MessagepropertiesConstants;
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
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.PortType;
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

/**
 * BPELReader is invoked from BPELResourceImpl to parse the BPEL file and
 * create a Process object.
 */

@SuppressWarnings("nls")

public class BPELReader implements ErrorHandler {

	// The process we are reading
	private Process process = null;
	// Bugzilla 324165
	// The resource we are reading from
	private Resource fCurrentResource = null;
	// The successfully loaded resource
	private Resource fResource = null;
	// The document builder controls various DOM characteristics
	private DocumentBuilder docBuilder = null;
	// Registry for extensibility element serializers and deserializers
	private BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry.getInstance();
	
	private DOMParser fDOMParser;
	
	/** The XML Error handler */
	ErrorHandler fErrorHandler = null;
	
	
	/** The WS-BPEL Specification says how to resolve variables, taking into
	 * account scopes, etc. Technically, no one should override this behavior,
	 * but replacing this field with another implementation could allow
	 * you to optimize the search or provide different behavior. 
	 */
	public static VariableResolver VARIABLE_RESOLVER = new BPELVariableResolver();
	
	/**
	 * The WS-BPEL Specification says how to resolve links, taking into
	 * account scopes, etc. Technically, no one should override this behavior,
	 * but replacing this field with another implementation could allow
	 * you to optimize the search or provide different behavior.
	 */
	
	public static LinkResolver LINK_RESOLVER = new BPELLinkResolver();
	
	
	List<Runnable> fPass2Runnables = new ArrayList<Runnable>();
	
	/**
	 * Construct a new BPELReader using the given DocumentBuilder to determine
	 * how the DOM tree is constructed.
	 * 
	 * @param builder  the document builder to use when parsing the file
	 * @throws IOException if no document builder is specified
	 */
	public BPELReader (DocumentBuilder builder) throws IOException {
		if (builder == null) {
			throw new IOException(BPELPlugin.INSTANCE.getString("%BPELReader.missing_doc_builder"));
		}
		this.docBuilder = builder;
	}

	/**
	 * @param parser
	 */
	public BPELReader (DOMParser parser )  {		
		this.fDOMParser = parser;
	}

	/**
	 * Read from the given Document into the given resource.
	 * 
	 * @param resource the EMF resource to construct
	 * @param Document the document to read the BPEL from
	 */
	public void read(BPELResource resource, Document doc) {
		this.fResource = resource;
		// Pass 1 and 2 are inside the try so they don't occur if
		// an error happens during parsing.
		// In pass 1 we parse and create the structural elements and attributes. 
		pass1(doc);
		// In pass 2, we run any postLoadRunnables which need to happen after
		// pass 1 (for example, establishing object links to variables).
		pass2();
	}

	/**
	 * 
	 */
	
	public BPELReader () {
		this.fDOMParser = new LineCapturingDOMParser();
				
		// domParser.setProperty("http://xml.org/sax/features/namespaces",true);
		try {
			fDOMParser.setFeature( "http://apache.org/xml/features/dom/defer-node-expansion", false );
			fDOMParser.setFeature( "http://apache.org/xml/features/xinclude", false);
		} catch (SAXNotRecognizedException e) { 
			BPELPlugin.log("Not Recognized DOM Parser Feature",e );
		} catch (SAXNotSupportedException e) {		
			BPELPlugin.log("Not Supported DOM Parser Feature",e );
		}				
	}
	
	/** 
	 * Set the error handler 
	 * @param errorHandler 
	 */
	
	public void setErrorHandler ( ErrorHandler errorHandler ) {
		fErrorHandler = errorHandler;
	}

	void armErrorHandler ( ) {
		
		assert (docBuilder  != null || fDOMParser != null);
		
		if (docBuilder != null) {
			docBuilder.setErrorHandler(fErrorHandler != null ? fErrorHandler : this);
		} else {
			fDOMParser.setErrorHandler(fErrorHandler != null ? fErrorHandler : this);
		}	
	}

	
	Document read ( InputSource inputSource ) throws IOException, SAXException {	
		assert (docBuilder  != null || fDOMParser != null) : "No document builder/parser set";

		if (docBuilder != null) {
			return docBuilder.parse(inputSource);
		} 		
		fDOMParser.parse(inputSource);
		return fDOMParser.getDocument();
	}
	
	
	/**
	 * Read from the given input stream into the given resource.
	 * 
	 * @param resource  the EMF resource to construct
	 * @param inputStream  the input stream to read the BPEL from
	 */
	
	public void read (BPELResource resource, InputStream inputStream)  {
		
		armErrorHandler ();
		
		Document doc = null;
		try {
			InputSource inputSource = new InputSource(inputStream);
			inputSource.setPublicId( resource.getURI().toString() );
			inputSource.setSystemId( resource.getURI().toString() );
			
			resource.setErrorHandler(fErrorHandler != null ? fErrorHandler : this);
			// Bugzilla 324165
			// set the resource currently being loaded so the error handler can
			// attach diagnostics to it
			fCurrentResource = resource;
			doc = read ( inputSource );
			// After the document has successfully parsed, it's okay
			// to assign the resource.
			fResource = resource;
		} catch (SAXException sax) {
			// the error handlers will catch this.			
		} catch (IOException ioe) {
			BPELPlugin.log("I/O Error Reading BPEL XML", ioe ) ;
		} finally {
			
		}

		// Bugzilla 324165
		if (doc != null) {
			pass1(doc);		
			pass2();
		}
		fCurrentResource = null;
	}

	
	/**
	 * Return the resource that was used to read in this BPEL process.
	 * 
	 * @return the resource that was used to read in this BPEL process.
	 */
	
	public Resource getResource () {
		return fResource;
	}
	
	
	/**
	 * @param xmlSource the XML source
	 * @param sourceDescription some textual description of the source (for example Clipboard).
	 * @return a list of objects 
	 */
	
	public List<EObject> fromXML ( String xmlSource , String sourceDescription , Resource resource ) {
		
		armErrorHandler ();
		
		if (sourceDescription == null) {
			sourceDescription = "String";
		}
		
		Document doc = null;
		try {
			InputSource inputSource = new InputSource(new StringReader ( xmlSource ));
			inputSource.setPublicId( sourceDescription );
			// Bugzilla 324165
			// set the resource currently being loaded so the error handler can
			// attach diagnostics to it
			fCurrentResource = resource;
			doc = read (inputSource);
			
		} catch (SAXException sax) {
			// done by the handler.
		} catch (IOException ioe) {
			BPELPlugin.log("I/O Error Reading BPEL XML", ioe ) ;
		} finally {
			
		}
				
		if (doc == null) {
			fCurrentResource = null;
			return Collections.emptyList();		
		}
		
		fResource = resource;
		
		// Pass 1 and 2 are inside the try so they don't occur if
		// an error happens during parsing.
		// In pass 1 we parse and create the structural elements and attributes. 
		List<EObject> result = parseDocument(doc);
		// In pass 2, we run any postLoadRunnables which need to happen after
		// pass 1 (for example, establishing object links to variables).
		pass2();
		
		fCurrentResource = null;
		return result;		
	}
	
	
	/**
	 * In pass 1, we parse and create the structural elements and attributes,
	 * and add the process to the EMF resource's contents
	 * @param document  the DOM document to parse
	 */
	protected void pass1 (Document document) {
		Process p = xml2Resource(document);
		if (p != null) {
			fResource.getContents().add(p);
		}
	}
	
	/**
	 * In pass 2, we run any post load runnables which were queued during pass 1.
	 */
	protected void pass2() {	
		try {
			for(Runnable r : fPass2Runnables) {
				r.run();
			}
		} finally {			
			fPass2Runnables.clear();
		}
	}
	
	
	/**
     * Returns a list of child nodes of <code>parentElement</code> that are
     * {@link Element}s.
     * Returns an empty list if no elements are found.
     * 
	 * @param parentElement  the element to find the children of
	 * @return a node list of the children of parentElement
	 */
	protected List<Element> getChildElements(Element parentElement) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();		
		for (int i=0; i < children.getLength(); i++) {
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
				list.add( (Element) children.item(i));
		}
		return list;
	}

    /**
     * Returns a list of child nodes of <code>parentElement</code> that are
     * {@link Element}s with a BPEL namespace that have the given <code>localName</code>.
     * Returns an empty list if no matching elements are found.
     * 
	 * @param parentElement  the element to find the children of
	 * @param localName  the localName to match against
	 * @return a node list of the matching children of parentElement
     */
	public List<Element> getBPELChildElementsByLocalName(Element parentElement, String localName) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName()) && BPELUtils.isBPELElement(node)) {
                list.add((Element) node);
			}
		}
		return list;
	}

    /**
     * Returns the first child node of <code>parentElement</code> that is an {@link Element}
     * with a BPEL namespace and the given <code>localName</code>, or <code>null</code>
     * if a matching element is not found. 
     * 
	 * @param parentElement  the element to find the children of
	 * @param localName  the localName to match against
	 * @return the first matching element, or null if no element was found
      */
	public Element getBPELChildElementByLocalName(Element parentElement, String localName) {
		NodeList children = parentElement.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (localName.equals(node.getLocalName()) && BPELUtils.isBPELElement(node)) {
                return (Element) node;
            }
		}
		return null;
	}

    /**
	 * Walk from the given element up through its parents, looking for any
	 * xmlns definitions. Collect them all in a map (mapping the prefix to
	 * the namespace value) and return the map.
	 * 
	 * @param element  the element to get the xmlns definitions for
	 * @return a map of visible xmlns definitions
	 */
	protected Map<String,String> getAllNamespacesForElement (Element element) {
		Map<String,String> nsMap = new HashMap<String,String>();		
		Node tempNode = element;        
		while (tempNode != null && tempNode.getNodeType() == Node.ELEMENT_NODE) {
			NamedNodeMap attrs = ((Element)tempNode).getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				Attr attr = (Attr)attrs.item(i);
				// XML namespace attributes use the reserved namespace "http://www.w3.org/2000/xmlns/".
				if (XSDConstants.XMLNS_URI_2000.equalsIgnoreCase(attr.getNamespaceURI())) {
					final String key = BPELUtils.getNSPrefixMapKey(attr.getLocalName());
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
		Map<String,String> nsMap = null; // lazy init since it may require a new map
		NamedNodeMap attrs = element.getAttributes();
		
		for (int i=0; i < attrs.getLength(); i++) {
			Attr attr = (Attr) attrs.item(i);        
			// XML namespace attributes use the reserved namespace "http://www.w3.org/2000/xmlns/". 
			if (XSDConstants.XMLNS_URI_2000.equals(attr.getNamespaceURI())) {
				if (nsMap == null) {
					nsMap = BPELUtils.getNamespaceMap(eObject);
				}
				nsMap.put(BPELUtils.getNSPrefixMapKey(attr.getLocalName()), attr.getValue());
			}
		}
	}

	/**
	 * Given a DOM Element, find the child element which is a BPEL activity
	 * (of some type), parse it, and return the Activity.
	 * 
	 * @param element  the element in which to find an activity
	 * @return the activity, or null if no activity could be found
	 */
	protected Activity getChildActivity(Element element) {
		NodeList activityElements = element.getChildNodes();
		for (int i = 0; i < activityElements.getLength(); i++) {
			if (activityElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
				continue;
			}
			           	   	         	
			Element activityElement = (Element)activityElements.item(i);
			Activity activity = xml2Activity(activityElement);
							
			if (activity != null) {
				return activity;	
			}
		}
		return null;   	
	}

 
	/**
	 * Sets a PartnerLink element for a given EObject. The given activity element
	 * must contain an attribute named "partnerLink".
	 * 
	 * @param activityElement  the DOM element of the activity
	 * @param eObject  the EObject in which to set the partner link
	 */
	protected void setPartnerLink(Element activityElement, final EObject eObject, final EReference reference) {
		if (!activityElement.hasAttribute("partnerLink")) {
			return;
		}

		final String partnerLinkName = activityElement.getAttribute("partnerLink");
		// We must do this as a post load runnable because the partner link might not
		// exist yet.
		fPass2Runnables.add(new Runnable() {
			public void run() {	
				PartnerLink targetPartnerLink = BPELUtils.getPartnerLink(eObject, partnerLinkName);
				if (targetPartnerLink == null) {
					targetPartnerLink = new PartnerLinkProxy(getResource().getURI(), partnerLinkName);
				}
				eObject.eSet(reference, targetPartnerLink);				
			}
		});		
	}

	/**
	 * Sets a Variable element for a given EObject. The given activity element
	 * must contain an attribute with the given name
	 * 
	 * @param activityElement  the DOM element of the activity
	 * @param eObject  the EObject in which to set the variable
	 * @param variableAttrName  the name of the attribute containing the variable name
	 * @param reference  the EReference which is the variable pointer in EObject 
	 */
	protected void setVariable(Element activityElement, final EObject eObject, String variableNameAttr, final EReference reference) {
		if (!activityElement.hasAttribute(variableNameAttr)) {
			return;
		}

		final String variableName = activityElement.getAttribute(variableNameAttr);
		// We must do this as a post load runnable because the variable might not
		// exist yet.
		fPass2Runnables.add(new Runnable() {
			public void run() {				
				Variable targetVariable = getVariable(eObject, variableName);
				if (targetVariable == null) {
					targetVariable = new VariableProxy(getResource().getURI(), variableName);
				}		
				eObject.eSet(reference, targetVariable);				
			}
		});
  	} 	

	/**
	 * Find a Property name in element (in the named attribute) and set it
	 * into the given EObject. If EObject is a CorrelationSet, add the property
	 * to the list of properties. If it is a To, set the property.
	 * 
	 * @param element  the DOM element containing the property name
	 * @param eObject  the EObject in which to set the property
	 * @param propertyName  the name of the attribute containing the property name
	 */
	protected void setProperties(Element element, EObject eObject, String propertyName) {
		String propertyAttribute = element.getAttribute(propertyName);
		
		// added by Grid.Qian
		// we should permit user add a correlation without properties
		if(propertyAttribute == null){
			return;
		}
		StringTokenizer st = new StringTokenizer(propertyAttribute);

		while (st.hasMoreTokens()) {
			QName qName = BPELUtils.createQName(element, st.nextToken());
			Property property = new PropertyProxy(getResource().getURI(), qName);
			if (eObject instanceof CorrelationSet) {
				((CorrelationSet)eObject).getProperties().add(property);
			} else if (eObject instanceof To) {
				((To)eObject).setProperty(property);
			}
		}
	}

	/**
	 * Sets a CompensationHandler element for a given eObject.
	 */
	protected void setCompensationHandler(Element element, EObject eObject) {
       Element compensationHandlerElement = getBPELChildElementByLocalName(element, "compensationHandler");
                 
		if (compensationHandlerElement != null) {
			CompensationHandler compensationHandler = xml2CompensationHandler(compensationHandlerElement);
			xml2ExtensibleElement(compensationHandler, compensationHandlerElement); 

			if (eObject instanceof Invoke)	
				((Invoke)eObject).setCompensationHandler(compensationHandler);
			else if (eObject instanceof Scope)		
				((Scope)eObject).setCompensationHandler(compensationHandler);
        }  
	}

	/**
	 * Sets a FaultHandler element for a given extensibleElement.
	 */
	protected void setFaultHandler(Element element, BPELExtensibleElement extensibleElement) {
		List<Element> faultHandlerElements = getBPELChildElementsByLocalName(element, "faultHandlers");
		
		if (faultHandlerElements.size() > 0) {
			FaultHandler faultHandler =	xml2FaultHandler(faultHandlerElements.get(0)); 
			
			if (extensibleElement instanceof Process) {
				((Process)extensibleElement).setFaultHandlers(faultHandler);
			} else if (extensibleElement instanceof Invoke) {
				((Invoke)extensibleElement).setFaultHandler(faultHandler);
			}
		}
	}
	
	/**
	 * Sets a EventHandler element for a given extensibleElement.
	 */
	protected void setEventHandler(Element element, BPELExtensibleElement extensibleElement) {
		List<Element> eventHandlerElements = getBPELChildElementsByLocalName(element, "eventHandlers");
                 
		if (eventHandlerElements.size() > 0) {
			EventHandler eventHandler =	xml2EventHandler(eventHandlerElements.get(0)); 

			if (extensibleElement instanceof Process) ((Process)extensibleElement).setEventHandlers(eventHandler);
				else if (extensibleElement instanceof Scope) ((Scope)extensibleElement).setEventHandlers(eventHandler);
		}
	}	


	/**
	 * Sets the standard attributes (name, joinCondition, and suppressJoinFailure).
	 */
	protected void setStandardAttributes(Element activityElement, Activity activity) {

		// Set name
		Attr name = activityElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified())		
			activity.setName(name.getValue());

		// Set suppress join failure
		Attr suppressJoinFailure = activityElement.getAttributeNode("suppressJoinFailure");
		
		if (suppressJoinFailure != null && suppressJoinFailure.getSpecified())		
			activity.setSuppressJoinFailure( Boolean.valueOf( suppressJoinFailure.getValue().equals("yes")));
	}


	/**
	 * Sets name, portType, operation, partner, variable and correlation for a given PartnerActivity object.
	 */
	protected void setOperationParms(final Element activityElement,
									 final PartnerActivity activity,
									 EReference variableReference,
									 EReference inputVariableReference,
									 EReference outputVariableReference,
									 EReference partnerReference) {
		// Set partnerLink
		setPartnerLink(activityElement, activity, partnerReference);

		// Set portType
        PortType portType = null;
        if (activityElement.hasAttribute("portType")) {
            portType = BPELUtils.getPortType(getResource().getURI(), activityElement, "portType");
            activity.setPortType(portType);
        }

		// Set operation
		if (activityElement.hasAttribute("operation")) {
            if (portType != null) {
				activity.setOperation(BPELUtils.getOperation(getResource().getURI(), portType, activityElement, "operation"));
			} else {
                ((PartnerActivityImpl) activity).setOperationName(activityElement.getAttribute("operation"));
            }
		}
		
		// Set variable
		if (variableReference != null) {
			setVariable(activityElement, activity, "variable", variableReference);
		}
		if (inputVariableReference != null) {
			setVariable(activityElement, activity, "inputVariable", inputVariableReference);
		}
		if (outputVariableReference != null) {
			setVariable(activityElement, activity, "outputVariable", outputVariableReference);
		}
		
		// Set correlations
		Element correlationsElement = getBPELChildElementByLocalName(activityElement, "correlations");
		if (correlationsElement != null) {
			Correlations correlations = xml2Correlations(correlationsElement);
			activity.setCorrelations(correlations);
		}
	}

	/**
	 * Sets name, portType, operation, partner, variable and correlation for a given PartnerActivity object.
	 */
	protected void setOperationParmsOnMessage(final Element activityElement, final OnMessage onMessage) {
		// Set partnerLink
		setPartnerLink(activityElement, onMessage, BPELPackage.eINSTANCE.getOnMessage_PartnerLink());

        // Set portType
        PortType portType = null;
        if (activityElement.hasAttribute("portType")) {
            portType = BPELUtils.getPortType(getResource().getURI(), activityElement, "portType");
            onMessage.setPortType(portType);
        }
        
        // Set operation
        if (activityElement.hasAttribute("operation")) {
            if (portType != null) {
                onMessage.setOperation(BPELUtils.getOperation(getResource().getURI(), portType, activityElement, "operation"));
            } else {
                // If portType is not specified it will be resolved lazily and so will the operation.
                // Save the deserialized name so the operation can be later resolved.
                ((OnMessageImpl) onMessage).setOperationName(activityElement.getAttribute("operation"));
            }
        }

		// Set variable
		setVariable(activityElement, onMessage, "variable", BPELPackage.eINSTANCE.getOnMessage_Variable());

		// Set correlations
		Element correlationsElement = getBPELChildElementByLocalName(activityElement, "correlations");
		if (correlationsElement != null) {
			Correlations correlations = xml2Correlations(correlationsElement);
			onMessage.setCorrelations(correlations);
		}
	}

	/**
	 * Sets name, portType, operation, partner, variable, messageType and correlation for a given PartnerActivity object.
	 */
	protected void setOperationParmsOnEvent(final Element activityElement, final OnEvent onEvent) {
		// Set partnerLink
		setPartnerLink(activityElement, onEvent, BPELPackage.eINSTANCE.getOnEvent_PartnerLink());

        // Set portType
        PortType portType = null;
        if (activityElement.hasAttribute("portType")) {
            portType = BPELUtils.getPortType(getResource().getURI(), activityElement, "portType");
            onEvent.setPortType(portType);
        }

        // Set operation
        if (activityElement.hasAttribute("operation")) {
            if (portType != null) {
                onEvent.setOperation(BPELUtils.getOperation(getResource().getURI(), portType, activityElement, "operation"));
            } else {
                ((OnEventImpl) onEvent).setOperationName(activityElement.getAttribute("operation"));
            }
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
		}
		
		// Set message type
		if (activityElement.hasAttribute("messageType")) {
			QName qName = BPELUtils.createAttributeValue(activityElement, "messageType");
			Message messageType = new MessageProxy(getResource().getURI(), qName);
			onEvent.setMessageType(messageType);
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
		Element correlationsElement = getBPELChildElementByLocalName(activityElement, "correlations");
		if (correlationsElement != null) {
			Correlations correlations = xml2Correlations(correlationsElement);
			onEvent.setCorrelations(correlations);
		}
	}

	/**
	 * 
	 */
	protected List<EObject> parseDocument (Document document) {
		
		Element element = (document != null)? document.getDocumentElement(): null;
		List<EObject> list = new ArrayList<EObject>();		
		if (element == null) {
			return list;
		}
		
		if (element.getLocalName().equals("bag")) {			
			
			for(Node n = element.getFirstChild(); n != null; n = n.getNextSibling()) {
				if (n instanceof Element == false) {
					continue;
				}
				EObject next = parseElement ( (Element) n );
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

	
	EObject parseElement ( Element element ) {
		
		Method parseMethod = getParseMethod ( element );
		if (parseMethod == null) {
			return null;
		}								
		try {
			return (EObject) parseMethod.invoke(this, element) ;
		} catch (Throwable t) {
			t.printStackTrace();
			// 
		}
		return null;
	}
	
	Method getParseMethod ( Element element ) {
		if (BPELUtils.isBPELElement( element ) == false) {
			return null;
		}
		
		String methodName = element.getLocalName();
		methodName = "xml2" + Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);		
		
		return lookupMethod ( getClass(), methodName, Element.class );
	}
	
	Method lookupMethod ( Class<?> target, String methodName, Class<?> ... args ) {
		if (target == null || target == Object.class) {
			return null ;
		}
		
		for(Method m : target.getDeclaredMethods()) {
			if (methodName.equals(m.getName()) == false || m.getParameterTypes().length != args.length ) { 
				continue;
			}			
			Class<?> argTypes[] = m.getParameterTypes();			
			for(int i=0; i < args.length; i++) {
				if (argTypes[i].isAssignableFrom(args[i]) == false) {
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
		Element processElement = (document != null)? document.getDocumentElement(): null;
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
		if (!BPELConstants.isBPELNamespace(processElement.getNamespaceURI())) {
			return null;
		}
		
		process = BPELFactory.eINSTANCE.createProcess();
		process.setElement(processElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(process, processElement);
		
		// Handle Process element
		if (processElement.hasAttribute("name")) 
			process.setName(processElement.getAttribute("name"));
		
		if (processElement.hasAttribute("targetNamespace"))	
			process.setTargetNamespace(processElement.getAttribute("targetNamespace"));
		
		if (processElement.hasAttribute("suppressJoinFailure"))
			process.setSuppressJoinFailure( Boolean.valueOf( processElement.getAttribute("suppressJoinFailure").equals("yes")));
		
		if (processElement.hasAttribute("exitOnStandardFault"))
			process.setExitOnStandardFault( Boolean.valueOf( processElement.getAttribute("exitOnStandardFault").equals("yes")));
		
		if (processElement.hasAttribute("variableAccessSerializable"))
			process.setVariableAccessSerializable( Boolean.valueOf( processElement.getAttribute("variableAccessSerializable").equals("yes")));

		if (processElement.hasAttribute("queryLanguage"))
			process.setQueryLanguage(processElement.getAttribute("queryLanguage"));

		if (processElement.hasAttribute("expressionLanguage"))
			process.setExpressionLanguage(processElement.getAttribute("expressionLanguage"));
			
		// Handle Import Elements
		for(Element e : getBPELChildElementsByLocalName(processElement, "import")) {
			process.getImports().add(xml2Import(e));
		}
		
		
		// Handle PartnerLinks Element
		Element partnerLinksElement = getBPELChildElementByLocalName(processElement, "partnerLinks");
		if (partnerLinksElement != null)
			process.setPartnerLinks(xml2PartnerLinks(partnerLinksElement));
			
		// Handle Variables Element
		Element variablesElement = getBPELChildElementByLocalName(processElement, "variables");
		if (variablesElement != null)
			process.setVariables(xml2Variables(variablesElement));
			
		// Handle CorrelationSets Element
		Element correlationSetsElement = getBPELChildElementByLocalName(processElement, "correlationSets");
		if (correlationSetsElement != null)
			process.setCorrelationSets(xml2CorrelationSets(correlationSetsElement));
			 
		// Handle MessageExchanges Element
		Element messageExchangesElements = getBPELChildElementByLocalName(processElement, "messageExchanges");
		if (messageExchangesElements != null)
			process.setMessageExchanges(xml2MessageExchanges(messageExchangesElements));
		
		// Handle Extensions Element
		Element extensionsElement = getBPELChildElementByLocalName(processElement, "extensions");
		if (extensionsElement != null)
			process.setExtensions(xml2Extensions(extensionsElement));

		// Handle FaultHandler element
		setFaultHandler(processElement, process);
		
		// Handle CompensationHandler element
		// In BPEL 2.0, there is no compensation handler on process
		//setCompensationHandler(processElement, process);
		
		// Handle EventHandler element
		setEventHandler(processElement, process);
		
 		// Handle Activity elements
        Activity activity = xml2Activity(processElement); 
        process.setActivity(activity); 

		xml2ExtensibleElement(process,processElement);
		
		return process;
	}
	
	/**
	 * Converts an XML partnerLinks
	 */
	public PartnerLinks xml2PartnerLinks(Element partnerLinksElement) {
		if (!partnerLinksElement.getLocalName().equals("partnerLinks")) {
			return null;
		}
			
		PartnerLinks partnerLinks = BPELFactory.eINSTANCE.createPartnerLinks();		
		partnerLinks.setElement(partnerLinksElement);		
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(partnerLinks, partnerLinksElement);
		
		for(Element e : getBPELChildElementsByLocalName(partnerLinksElement, "partnerLink")) {
			partnerLinks.getChildren().add( xml2PartnerLink(e) );
		}		
		xml2ExtensibleElement(partnerLinks, partnerLinksElement);
	
		return partnerLinks;
	}


	public Variables xml2Variables(Element variablesElement) {
		if (!variablesElement.getLocalName().equals("variables"))
			return null;
			
		Variables variables = BPELFactory.eINSTANCE.createVariables();
		variables.setElement(variablesElement);
						
		// Save all the references to external namespaces		
		saveNamespacePrefix(variables, variablesElement);		
		for(Element e : getBPELChildElementsByLocalName(variablesElement, "variable")) {
			variables.getChildren().add( xml2Variable( e ) );
		}				
		xml2ExtensibleElement(variables, variablesElement);
		
		// Move variables that are extensibility elements to the list of children
		// JM: What is this supposed to accomplish?
		List<Variable> toBeMoved = new BasicEList<Variable>();
		for (Object next : variables.getExtensibilityElements() ) {
			if (next instanceof Variable) {
				toBeMoved.add((Variable) next);
			}
		}
		
		List<?> extensibility = variables.getExtensibilityElements();
		List<Variable> children = variables.getChildren();
		for(Variable element : toBeMoved) {
			extensibility.remove(element);
			children.add(element);
		}
		
		return variables;
	}
	
	public CorrelationSets xml2CorrelationSets(Element correlationSetsElement) {
		if (!correlationSetsElement.getLocalName().equals("correlationSets"))
			return null;
			
		CorrelationSets correlationSets = BPELFactory.eINSTANCE.createCorrelationSets();
		correlationSets.setElement(correlationSetsElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(correlationSets, correlationSetsElement);		
		
		for(Element e : getBPELChildElementsByLocalName(correlationSetsElement, "correlationSet")) {
			correlationSets.getChildren().add(xml2CorrelationSet(e));
		}

		xml2ExtensibleElement(correlationSets, correlationSetsElement);
		
		return correlationSets;
	}
	
	protected FromParts xml2FromParts(Element fromPartsElement) {
		if (!fromPartsElement.getLocalName().equals("fromParts"))
			return null;
			
		FromParts fromParts = BPELFactory.eINSTANCE.createFromParts();
		fromParts.setElement(fromPartsElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(fromParts, fromPartsElement);		
		
		for(Element e : getBPELChildElementsByLocalName(fromPartsElement, "fromPart")) {
			fromParts.getChildren().add(xml2FromPart(e));
		}

		xml2ExtensibleElement(fromParts, fromPartsElement);
		
		return fromParts;
	}
	
	protected ToParts xml2ToParts(Element toPartsElement) {
		if (!toPartsElement.getLocalName().equals("toParts"))
			return null;
			
		ToParts toParts = BPELFactory.eINSTANCE.createToParts();
		toParts.setElement(toPartsElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(toParts, toPartsElement);		
		
		for(Element e : getBPELChildElementsByLocalName(toPartsElement, "toPart")) {
			toParts.getChildren().add(xml2ToPart(e));
		}

		xml2ExtensibleElement(toParts, toPartsElement);
		
		return toParts;
	}

	protected FailureHandling xml2FailureHandling(Element failureHandlingElement) {
		if (!failureHandlingElement.getLocalName().equals("failureHandling"))
			return null;
			
		FailureHandling failureHandling = BPELFactory.eINSTANCE.createFailureHandling();
		failureHandling.setElement(failureHandlingElement);
		
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
	
	protected FaultOnFailure xml2FaultOnFailure(FaultOnFailure faultOnFailure,Element faultOnFailureElement)
	{
		// Save all the references to external namespaces
		saveNamespacePrefix(faultOnFailure, faultOnFailureElement);
    	
		if (faultOnFailureElement == null) {
			return faultOnFailure;
		}
		
		//reading body of the faultOnFailure and add it into the faultOnFailure object
		String data = getText(faultOnFailureElement);
		if (data != null) {

			if("true".equalsIgnoreCase(data)){
				faultOnFailure.setValue(true);
			}
			else
			{
				faultOnFailure.setValue(false);
			}
			
		}
	
    	return faultOnFailure;
	}
	
	protected RetryFor xml2RetryFor(RetryFor retryFor,Element retryForElement)
	{
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
	
	protected RetryDelay xml2RetryDelay(RetryDelay retryDelay,Element retryDelayElement)
	{
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
	
	public MessageExchanges xml2MessageExchanges(Element messageExchangesElement) {
		if (!messageExchangesElement.getLocalName().equals("messageExchanges"))
			return null;
		
		MessageExchanges messageExchanges = BPELFactory.eINSTANCE.createMessageExchanges();
		messageExchanges.setElement(messageExchangesElement);
		
		// Save all the references to external namespaces
		saveNamespacePrefix(messageExchanges, messageExchangesElement);
		
		for(Element e : getBPELChildElementsByLocalName(messageExchangesElement, "messageExchange")) {
			messageExchanges.getChildren().add(xml2MessageExchange(e));
		}
		
		xml2ExtensibleElement(messageExchanges, messageExchangesElement);
		
		return messageExchanges;
	}
	
	protected Extensions xml2Extensions(Element extensionsElement) {
		if (!extensionsElement.getLocalName().equals("extensions"))
			return null;
			
		Extensions extensions = BPELFactory.eINSTANCE.createExtensions();
		extensions.setElement(extensionsElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(extensions, extensionsElement);		
		for(Element e : getBPELChildElementsByLocalName(extensionsElement, "extension")) {
			extensions.getChildren().add(xml2Extension(e));
		}
		
		xml2ExtensibleElement(extensions, extensionsElement);
		
		return extensions;
	}

	/**
	 * Converts an XML compensationHandler element to a BPEL CompensationHandler object.
	 */
	protected CompensationHandler xml2CompensationHandler(Element activityElement) {
		CompensationHandler compensationHandler = BPELFactory.eINSTANCE.createCompensationHandler();
		compensationHandler.setElement(activityElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(compensationHandler, activityElement);
		
		compensationHandler.setActivity(getChildActivity(activityElement));
		
		return compensationHandler;
	}


	/**
	 * Converts an XML correlationSet element to a BPEL CorrelationSet object.
	 */
	protected CorrelationSet xml2CorrelationSet(Element correlationSetElement) {
		CorrelationSet correlationSet = BPELFactory.eINSTANCE.createCorrelationSet();		
		correlationSet.setElement(correlationSetElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(correlationSet, correlationSetElement);		
		
		if (correlationSetElement == null) return correlationSet;
		
		// Set name
		Attr name = correlationSetElement.getAttributeNode("name");

		if (name != null && name.getSpecified())		
			correlationSet.setName(name.getValue());

		setProperties(correlationSetElement, correlationSet, "properties");
		
		xml2ExtensibleElement(correlationSet, correlationSetElement);

		return correlationSet;
	}
	
	/**
	 * Converts an XML messageExchange element to a BPEL MessageExchange object.
	 */
	protected MessageExchange xml2MessageExchange(Element messageExchangeElement) {
		if (!messageExchangeElement.getLocalName().equals("messageExchange"))
			return null;
		
		MessageExchange messageExchange = BPELFactory.eINSTANCE.createMessageExchange();
		messageExchange.setElement(messageExchangeElement);
		
		// Save all the references to external namespaces
		saveNamespacePrefix(messageExchange, messageExchangeElement);
		
		// Set name
		if (messageExchangeElement.hasAttribute("name"))
			messageExchange.setName(messageExchangeElement.getAttribute("name"));
		
		xml2ExtensibleElement(messageExchange, messageExchangeElement);
		
		return messageExchange;
	}
	
	/**
	 * Converts an XML extension element to a BPEL Extension object.
	 */
	protected Extension xml2Extension(Element extensionElement) {
		Extension extension = BPELFactory.eINSTANCE.createExtension();
		extension.setElement(extensionElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(extension, extensionElement);		
		
		if (extensionElement == null) return extension;
		
		// Set namespace
		if (extensionElement.hasAttribute("namespace"))	
			extension.setNamespace(extensionElement.getAttribute("namespace"));
		
		// Set mustUnderstand
		if (extensionElement.hasAttribute("mustUnderstand"))
			extension.setMustUnderstand( Boolean.valueOf( extensionElement.getAttribute("mustUnderstand").equals("yes")));
		
		xml2ExtensibleElement(extension, extensionElement);

		return extension;
	}

	/**
	 * Converts an XML partnerLink element to a BPEL PartnerLink object.
	 */
  	protected PartnerLink xml2PartnerLink(Element partnerLinkElement) {
		if (!partnerLinkElement.getLocalName().equals("partnerLink"))
			return null;
			 
		PartnerLink partnerLink = BPELFactory.eINSTANCE.createPartnerLink();
		partnerLink.setElement(partnerLinkElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(partnerLink, partnerLinkElement);
		
		// Set name
		if (partnerLinkElement.hasAttribute("name"))
			partnerLink.setName(partnerLinkElement.getAttribute("name"));
			
		if (partnerLinkElement.hasAttribute("initializePartnerRole"))
			partnerLink.setInitializePartnerRole( Boolean.valueOf( partnerLinkElement.getAttribute("initializePartnerRole").equals("yes")));		
		
		Attr partnerLinkTypeName = partnerLinkElement.getAttributeNode("partnerLinkType");
		if (partnerLinkTypeName != null && partnerLinkTypeName.getSpecified()) {
			QName sltQName = BPELUtils.createAttributeValue(partnerLinkElement, "partnerLinkType");
			
			PartnerLinkTypeProxy slt = new PartnerLinkTypeProxy(getResource().getURI(), sltQName);
			partnerLink.setPartnerLinkType(slt);
			
			if(slt != null) {
				partnerLink.setPartnerLinkType(slt);
				
				if (partnerLinkElement.hasAttribute("myRole")) {
					RoleProxy role = new RoleProxy(getResource(), slt, partnerLinkElement.getAttribute("myRole"));
					partnerLink.setMyRole(role);
				}
				if (partnerLinkElement.hasAttribute("partnerRole")) {
					RoleProxy role = new RoleProxy(getResource(), slt, partnerLinkElement.getAttribute("partnerRole"));
					partnerLink.setPartnerRole(role);
				}
			}
		}

		xml2ExtensibleElement(partnerLink,partnerLinkElement);

        return partnerLink;
     }


	/**
	 * Converts an XML variable element to a BPEL Variable object.
	 */
	protected Variable xml2Variable(Element variableElement) {
		if (!variableElement.getLocalName().equals("variable"))
			return null;
			 
		Variable variable = BPELFactory.eINSTANCE.createVariable();
		variable.setElement(variableElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(variable, variableElement);

		// Set name
		if (variableElement.hasAttribute("name")) {
			String name = variableElement.getAttribute("name");
			variable.setName(name);
		}
		
		if (variableElement.hasAttribute("messageType")) {
			QName qName = BPELUtils.createAttributeValue(variableElement,"messageType");
			Message messageType = new MessageProxy(getResource().getURI(), qName);
			variable.setMessageType(messageType);
		}

		// Set xsd type
		if (variableElement.hasAttribute("type")) {
			QName qName = BPELUtils.createAttributeValue(variableElement, "type");
			XSDTypeDefinition type = new XSDTypeDefinitionProxy(getResource().getURI(), qName);
			variable.setType(type);						
		}
		
		// Set xsd element
		if (variableElement.hasAttribute("element")) {
			QName qName = BPELUtils.createAttributeValue(variableElement, "element");
			XSDElementDeclaration element = new XSDElementDeclarationProxy(getResource().getURI(), qName);
			variable.setXSDElement(element);			
		}

		// from-spec
        Element fromElement = getBPELChildElementByLocalName(variableElement, "from");
        if (fromElement != null) {
            From from = BPELFactory.eINSTANCE.createFrom();
            from.setElement(fromElement);
            
            xml2From(from, fromElement); 
            variable.setFrom(from);
        }
		
		xml2ExtensibleElement(variable,variableElement);
		
        return variable;
     }

	/**
	 * Converts an XML faultHandler element to a BPEL FaultHandler object.
	 */
 	protected FaultHandler xml2FaultHandler(Element faultHandlerElement) {
 		String localName = faultHandlerElement.getLocalName();
 		if (!(localName.equals("faultHandlers") ||
 				localName.equals("invoke")))
 			return null;
 			
		FaultHandler faultHandler = BPELFactory.eINSTANCE.createFaultHandler();
		
		if (localName.equals("faultHandlers")) {
			// This is "overloaded", what's the proper facade for the fault handler element in this case.
			faultHandler.setElement(faultHandlerElement);
		}
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(faultHandler, faultHandlerElement);
				
		for(Element e : getBPELChildElementsByLocalName(faultHandlerElement, "catch")) { 
			faultHandler.getCatch().add( xml2Catch(e)); 			
		}

		Element catchAllElement = getBPELChildElementByLocalName(faultHandlerElement, "catchAll");
		if (catchAllElement != null) {
			CatchAll catchAll = xml2CatchAll(catchAllElement);
			faultHandler.setCatchAll(catchAll);
		}
		
		// Only do this for an element named faultHandlers. If the element is named
		// invoke, then there really is no fault handler, only a series of catches.
		if (faultHandlerElement.getLocalName().equals("faultHandlers")) {
			xml2ExtensibleElement(faultHandler, faultHandlerElement);
		}
				
		return faultHandler;		
 	}

	/**
	 * Converts an XML catchAll element to a BPEL CatchAll object.
	 */
	protected CatchAll xml2CatchAll(Element catchAllElement) {
		if (!catchAllElement.getLocalName().equals("catchAll"))
			return null;
			
		CatchAll catchAll = BPELFactory.eINSTANCE.createCatchAll();
		catchAll.setElement(catchAllElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(catchAll, catchAllElement);		
		
		for(Element e : getChildElements(catchAllElement)) {
			Activity activity = xml2Activity(e);
			if (activity != null) {
				catchAll.setActivity(activity);
				break;
			}
		}
		
		xml2ExtensibleElement(catchAll, catchAllElement);
		
		return catchAll;
	}

	/**
	 * Converts an XML catch element to a BPEL Catch object.
	 */
	protected Catch xml2Catch(Element catchElement) {
		Catch _catch = BPELFactory.eINSTANCE.createCatch();
		_catch.setElement(catchElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(_catch, catchElement);
		
		if (catchElement == null) return _catch;
		
		if (catchElement.hasAttribute("faultName")) {
			QName qName = BPELUtils.createAttributeValue(catchElement, "faultName");	
			_catch.setFaultName(qName);
		}

		if (catchElement.hasAttribute("faultVariable")) {
			// Set fault variable
			Variable variable = BPELFactory.eINSTANCE.createVariable();
			// TODO: Should not this be the variable proxy ?
			variable.setName(catchElement.getAttribute("faultVariable"));
			_catch.setFaultVariable(variable);					
		}		
		
		if (catchElement.hasAttribute("faultMessageType")) {
			QName qName = BPELUtils.createAttributeValue(catchElement,"faultMessageType");
			Message messageType = new MessageProxy(getResource().getURI(), qName);
			_catch.setFaultMessageType(messageType);
		}

		if (catchElement.hasAttribute("faultElement")) {
			QName qName = BPELUtils.createAttributeValue(catchElement,"faultElement");
			XSDElementDeclaration element = new XSDElementDeclarationProxy(getResource().getURI(), qName);
			_catch.setFaultElement(element);
		}

		// Set Activities		
		NodeList catchElements = catchElement.getChildNodes();
        
        Element activityElement = null;

		if (catchElements != null && catchElements.getLength() > 0) {
          
           for (int i = 0; i < catchElements.getLength(); i++) {
           	   if (catchElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
           	   	  continue;
           	   }
           	
               activityElement = (Element)catchElements.item(i); 
               Activity activity = xml2Activity(activityElement);
               if (activity != null) { 
               		_catch.setActivity(activity);
               		break;
               }
           }
        }		

		xml2ExtensibleElement(_catch, catchElement);
		return _catch;
	}

    /**
	 * Converts an XML activity element to a BPEL Activity object.
	 */
     public Activity xml2Activity(Element activityElement) {
		Activity activity = null;
		boolean checkExtensibility = true;

        if (!BPELUtils.isBPELElement(activityElement)) 
            return null;
        
		String localName = activityElement.getLocalName();        
        if (localName.equals("process")){ 
			activity = getChildActivity(activityElement);
			checkExtensibility = false;
		} else if (localName.equals("receive")) {
       		activity = xml2Receive(activityElement);
     	} else if (localName.equals("reply")) {
      		activity = xml2Reply(activityElement);
     	} else if (localName.equals("invoke")) {
      		activity = xml2Invoke(activityElement);
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
					activity = xml2AssignE4X(activityElement);
				} else if ("copy".equalsIgnoreCase(childLocalName)) {
					activity = xml2Assign(activityElement);
				}

			} else {
				// Default Assign Activity. Since there is no child elements.
				activity = xml2Assign(activityElement);
			}
     	} else if (localName.equals("throw")) {
      		activity = xml2Throw(activityElement);
     	} else if (localName.equals("exit")) {
      		activity = xml2Exit(activityElement);
     	} else if (localName.equals("wait")) {
      		activity = xml2Wait(activityElement);
     	} else if (localName.equals("empty")) {
      		activity = xml2Empty(activityElement);
     	} else if (localName.equals("sequence")) {
      		activity = xml2Sequence(activityElement);
     	} else if (localName.equals("if")) {
     		activity = xml2If(activityElement);
     	} else if (localName.equals("while")) {
     		activity = xml2While(activityElement);
     	} else if (localName.equals("pick")) {
     		activity = xml2Pick(activityElement);
     	} else if (localName.equals("flow")) {
     		activity = xml2Flow(activityElement);
     	} else if (localName.equals("scope")) {
     		activity = xml2Scope(activityElement);
     	} else if (localName.equals("compensate")) {
     		activity = xml2Compensate(activityElement);
     	} else if (localName.equals("compensateScope")) {
     		activity = xml2CompensateScope(activityElement);     		
     	} else if (localName.equals("rethrow")) {
     		activity = xml2Rethrow(activityElement);
     	} else if (localName.equals("extensionActivity")) {
    		// extensionActivity is a special case. It does not have any standard
    		// attributes or elements, nor is it an extensible element.
    		// Return immediately.
    		activity = xml2ExtensionActivity(activityElement);
    		return activity;
     	} else if (localName.equals("opaqueActivity")) {
     		activity = xml2OpaqueActivity(activityElement);
     	} else if (localName.equals("forEach")) {
     		activity = xml2ForEach(activityElement);
     	} else if (localName.equals("repeatUntil")) {
     		activity = xml2RepeatUntil(activityElement);
     	} else if (localName.equals("validate")) {
     		activity = xml2Validate(activityElement);
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

 	protected void setStandardElements(Element activityElement, Activity activity) {
		// Handle targets
		Element targetsElement = getBPELChildElementByLocalName(activityElement, "targets");
		if (targetsElement != null) {
			activity.setTargets(xml2Targets(targetsElement));
		}
				
		// Handle sources
		Element sourcesElement = getBPELChildElementByLocalName(activityElement, "sources");
		if (sourcesElement != null) {
			activity.setSources(xml2Sources(sourcesElement));
		}
	}

 	protected Targets xml2Targets(Element targetsElement) {
		Targets targets = BPELFactory.eINSTANCE.createTargets();
		targets.setElement(targetsElement);
		
		for(Element e :  getBPELChildElementsByLocalName(targetsElement, "target")) {			
			targets.getChildren().add( xml2Target(e));          				
		}
		// Join condition
		Element joinConditionElement = getBPELChildElementByLocalName(targetsElement, "joinCondition");
		if (joinConditionElement != null) {
			targets.setJoinCondition(xml2Condition(joinConditionElement));
		}
		xml2ExtensibleElement(targets, targetsElement);

		return targets;
     }
     
	protected Target xml2Target(Element targetElement) {
		
		final Target target = BPELFactory.eINSTANCE.createTarget();
		target.setElement(targetElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(target, targetElement);
		
		xml2ExtensibleElement(target, targetElement);

		if (targetElement.hasAttribute("linkName")) {
			final String linkName = targetElement.getAttribute("linkName");			
			fPass2Runnables.add(new Runnable() {
				public void run() {
					Link link = getLink(target.getActivity(), linkName);
					if (link != null)
						target.setLink(link);
					else
						target.setLink(new LinkProxy(getResource().getURI(), linkName));
				}
			});
		}
		return target;		
	}
	
	protected Sources xml2Sources(Element sourcesElement) {
		Sources sources = BPELFactory.eINSTANCE.createSources();
		sources.setElement(sourcesElement);
		for(Element e : getBPELChildElementsByLocalName(sourcesElement, "source")) {
			sources.getChildren().add( xml2Source(e));          				
		}
		xml2ExtensibleElement(sources, sourcesElement);

		return sources;
	}
	
	protected Source xml2Source(Element sourceElement) {
		final String linkName = sourceElement.getAttribute("linkName");		
		final Source source = BPELFactory.eINSTANCE.createSource();
		source.setElement(sourceElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(source, sourceElement);
		
		// Read transitionCondition element
		Element transitionConditionElement = getBPELChildElementByLocalName(sourceElement, "transitionCondition");
		if (transitionConditionElement != null) {
			Condition transitionCondition = xml2Condition(transitionConditionElement);
			source.setTransitionCondition(transitionCondition);
		}
		
		
		xml2ExtensibleElement(source, sourceElement);
		
		fPass2Runnables.add(new Runnable() {
			public void run() {
				Link link = getLink(source.getActivity(), linkName);
				if (link != null)
					source.setLink(link);
				else
					source.setLink(new LinkProxy(getResource().getURI(), linkName));
			}
		});
		return source;							
	}	
	
	/**
	 * Converts an XML scope element to a BPEL Scope object.
	 */
	protected Activity xml2Scope(Element scopeElement) {
		
    	Scope scope = BPELFactory.eINSTANCE.createScope();
		scope.setElement(scopeElement);
		
    	//if (scopeElement == null) {
		//	return scope;
		//}

		Attr name = scopeElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified()) {
			scope.setName(name.getValue());
		}
				
		Attr isolated = scopeElement.getAttributeNode("isolated");
		
		if (isolated != null && isolated.getSpecified())
			scope.setIsolated( Boolean.valueOf( isolated.getValue().equals("yes")));
		
		// Handle attribute exitOnStandardFault
		Attr exitOnStandardFault = scopeElement.getAttributeNode("exitOnStandardFault");
		if (exitOnStandardFault != null && exitOnStandardFault.getSpecified())
			scope.setExitOnStandardFault( Boolean.valueOf( exitOnStandardFault.getValue().equals("yes")));
				
		// Handle Variables element
		Element variablesElement = getBPELChildElementByLocalName(scopeElement, "variables");
		if (variablesElement != null) {
			Variables variables = xml2Variables(variablesElement);
			scope.setVariables(variables);
		}
				
		// Handle CorrelationSet element
		Element correlationSetsElement = getBPELChildElementByLocalName(scopeElement, "correlationSets");
		if (correlationSetsElement != null) {
			CorrelationSets correlationSets = xml2CorrelationSets(correlationSetsElement);
			scope.setCorrelationSets(correlationSets);
		}
		
		// Handle PartnerLinks element
		Element partnerLinksElement = getBPELChildElementByLocalName(scopeElement, "partnerLinks");
		if (partnerLinksElement != null) {
			PartnerLinks partnerLinks = xml2PartnerLinks(partnerLinksElement);
			scope.setPartnerLinks(partnerLinks);
		}
		
		// MessageExchanges element
		Element messageExchangesElement = getBPELChildElementByLocalName(scopeElement, "messageExchanges");
		if (messageExchangesElement != null) {
			MessageExchanges messageExchanges = xml2MessageExchanges(messageExchangesElement);
			scope.setMessageExchanges(messageExchanges);
		}
				
		// Handle FaultHandler element
        Element faultHandlerElement = getBPELChildElementByLocalName(scopeElement, "faultHandlers");
        if (faultHandlerElement != null) {               		
			FaultHandler faultHandler =	xml2FaultHandler(faultHandlerElement); 
			scope.setFaultHandlers(faultHandler);
        }

		// Handle CompensationHandler element
		setCompensationHandler(scopeElement, scope);
		
		// Handler TerminationHandler element
		Element terminationHandlerElement = getBPELChildElementByLocalName(scopeElement, "terminationHandler");
		if (terminationHandlerElement != null) {
			TerminationHandler terminationHandler = xml2TerminationHandler(terminationHandlerElement);
			scope.setTerminationHandler(terminationHandler);
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
           	   	             	
               	activityElement = (Element)scopeElements.item(i); 
               
				if (activityElement.getLocalName().equals("faultHandlers") || 
					activityElement.getLocalName().equals("compensationHandler"))
				{
					continue;
				}
               
               Activity activity = xml2Activity(activityElement);
               if (activity != null) { 
               		scope.setActivity(activity);
               		break;
               }
           }
        }
        		
        return scope;
	}

	/**
	 * Converts an XML flow element to a BPEL Flow object.
	 */
	protected Activity xml2Flow(Element flowElement) {
    	
		Flow flow = BPELFactory.eINSTANCE.createFlow();
		flow.setElement(flowElement);
		
    	// if (flowElement == null) {
		//	return flow;		
		// }
		
		Attr name = flowElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified()) 
			flow.setName(name.getValue());
		
		Element linksElement = getBPELChildElementByLocalName(flowElement, "links");
		if (linksElement != null) {
			Links links = xml2Links(linksElement);
			flow.setLinks(links);
		}
			 
		Element completionConditionElement = getBPELChildElementByLocalName(flowElement, "completionCondition");
		if (completionConditionElement != null) {
			CompletionCondition completionCondition = xml2CompletionCondition(completionConditionElement);
			flow.setCompletionCondition(completionCondition);
		}
		
        setStandardAttributes(flowElement, flow);
        
        NodeList flowElements = flowElement.getChildNodes();
        
        Element activityElement = null;

		if (flowElements != null && flowElements.getLength() > 0) {
          
           for (int i = 0; i < flowElements.getLength(); i++) {
				if ((flowElements.item(i).getNodeType() != Node.ELEMENT_NODE) || 
				     ((Element)flowElements.item(i)).getLocalName().equals("links"))
           	   	  continue;
           	   	             	
               activityElement = (Element)flowElements.item(i); 
               Activity activity = xml2Activity(activityElement);
               if (activity != null) {
               		flow.getActivities().add(activity);
               }
           }
        }
		
		return flow;
	}

	protected Links xml2Links(Element linksElement) {
		if (!linksElement.getLocalName().equals("links"))
			return null;
			
		Links links = BPELFactory.eINSTANCE.createLinks();
		links.setElement(linksElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(links, linksElement);
		
		for(Element e :  getBPELChildElementsByLocalName(linksElement, "link")) {
			links.getChildren().add( xml2Link (e));
		}
		
		// extensibility elements
		xml2ExtensibleElement(links, linksElement);
		
		return links; 	
	}
	
	/**
	 * Converts an XML link element to a BPEL Link object.
	 */
	protected Link xml2Link(Element linkElement) {
		Link link = BPELFactory.eINSTANCE.createLink();
		link.setElement(linkElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(link, linkElement);				

		Attr name = linkElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified())
			link.setName(name.getValue());
		
		xml2ExtensibleElement(link,linkElement); 

		return link;		
	}

	/**
	 * Converts an XML pick element to a BPEL Pick object.
	 */
	protected Activity xml2Pick(Element pickElement) {
    	Pick pick = BPELFactory.eINSTANCE.createPick();
		pick.setElement(pickElement);

		// Set name
		Attr name = pickElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified())
			pick.setName(name.getValue());
		
		// Set createInstance
		Attr createInstance = pickElement.getAttributeNode("createInstance");
		
		if (createInstance != null && createInstance.getSpecified()) 
       		pick.setCreateInstance(Boolean.valueOf(createInstance.getValue().equals("yes") ? "True":"False"));  	
	
        NodeList pickElements = pickElement.getChildNodes();
        
        Element pickInstanceElement = null;

		if (pickElements != null && pickElements.getLength() > 0) {
          
           for (int i = 0; i < pickElements.getLength(); i++) {
				if (pickElements.item(i).getNodeType() != Node.ELEMENT_NODE)
           	   	  continue;
           	   	             	
               pickInstanceElement = (Element)pickElements.item(i);
               
				if (pickInstanceElement.getLocalName().equals("onAlarm")) {
     				OnAlarm onAlarm = xml2OnAlarm( pickInstanceElement );
     				
     				pick.getAlarm().add(onAlarm);
     			}     	
				else
					if (pickInstanceElement.getLocalName().equals("onMessage")) {
     					OnMessage onMessage = xml2OnMessage(pickInstanceElement);
	     				
    	 				pick.getMessages().add(onMessage);
     				}     
           }
        }
        
        setStandardAttributes(pickElement, pick);

		return pick;
	}

	/**
	 * Converts an XML eventHandler element to a BPEL eventHandler object.
	 */
	protected EventHandler xml2EventHandler(Element eventHandlerElement) {
		EventHandler eventHandler = BPELFactory.eINSTANCE.createEventHandler();
		eventHandler.setElement(eventHandlerElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(eventHandler, eventHandlerElement);			
	
		NodeList eventHandlerElements = eventHandlerElement.getChildNodes();        
		Element eventHandlerInstanceElement = null;
		if (eventHandlerElements != null && eventHandlerElements.getLength() > 0) {
          
			for (int i = 0; i < eventHandlerElements.getLength(); i++) {
				if (eventHandlerElements.item(i).getNodeType() != Node.ELEMENT_NODE)
					continue;           	   	             
			   	eventHandlerInstanceElement = (Element)eventHandlerElements.item(i);
               
				if (eventHandlerInstanceElement.getLocalName().equals("onAlarm")) {
					OnAlarm onAlarm = xml2OnAlarm(eventHandlerInstanceElement);     				
					eventHandler.getAlarm().add(onAlarm);
				}   
				else if (eventHandlerInstanceElement.getLocalName().equals("onEvent")) {
					OnEvent onEvent = xml2OnEvent(eventHandlerInstanceElement);	     				
					eventHandler.getEvents().add(onEvent);
				}  
			}
		}       
		
		xml2ExtensibleElement(eventHandler, eventHandlerElement); 
		return eventHandler;
	}

	/**
	 * Converts an XML onMessage element to a BPEL OnMessage object.
	 */
	protected OnMessage xml2OnMessage(Element onMessageElement) {
 		OnMessage onMessage = BPELFactory.eINSTANCE.createOnMessage();
 		onMessage.setElement(onMessageElement);
 		
		// Save all the references to external namespaces		
		saveNamespacePrefix(onMessage, onMessageElement); 			

		// Set several parms
		setOperationParmsOnMessage(onMessageElement, onMessage);
				
		// Set activity
		onMessage.setActivity(getChildActivity(onMessageElement));

		// Set fromParts
		Element fromPartsElement = getBPELChildElementByLocalName(onMessageElement, "fromParts");
		if (fromPartsElement != null) {
			FromParts fromParts = xml2FromParts(fromPartsElement);
			onMessage.setFromParts(fromParts);
		}	

		// Set messageExchange
		setMessageExchange(onMessageElement, onMessage, BPELPackage.eINSTANCE.getOnMessage_MessageExchange());
		
		xml2ExtensibleElement(onMessage, onMessageElement);
				
		return onMessage;
	}

	/**
	 * Converts an XML onEvent element to a BPEL OnEvent object.
	 */
	protected OnEvent xml2OnEvent(Element onEventElement) {
		OnEvent onEvent = BPELFactory.eINSTANCE.createOnEvent();
		onEvent.setElement(onEventElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(onEvent, onEventElement); 			

		// Set several parms
		setOperationParmsOnEvent(onEventElement, onEvent);
				
		// Set activity
		onEvent.setActivity(getChildActivity(onEventElement));

		// Set fromParts
		Element fromPartsElement = getBPELChildElementByLocalName(onEventElement, "fromParts");
		if (fromPartsElement != null) {
			FromParts fromParts = xml2FromParts(fromPartsElement);
			onEvent.setFromParts(fromParts);
		}		
		
		// Handle CorrelationSets Element
		Element correlationSetsElement = getBPELChildElementByLocalName(onEventElement, "correlationSets");
		if (correlationSetsElement != null)
			onEvent.setCorrelationSets(xml2CorrelationSets(correlationSetsElement));
		
		// Set messageExchange
		setMessageExchange(onEventElement, onEvent, BPELPackage.eINSTANCE.getOnEvent_MessageExchange());
		
		xml2ExtensibleElement(onEvent, onEventElement);
				
		return onEvent;
	}

	/**
	 * Converts an XML onAlarm element to a BPEL OnAlarm object.
	 */
	protected OnAlarm xml2OnAlarm(Element onAlarmElement) {
   		OnAlarm onAlarm = BPELFactory.eINSTANCE.createOnAlarm();
   		onAlarm.setElement(onAlarmElement);
   		
		// Save all the references to external namespaces		
		saveNamespacePrefix(onAlarm, onAlarmElement);   			
		
		// Set for element
		Element forElement = getBPELChildElementByLocalName(onAlarmElement, "for");
		if (forElement != null) {
			Expression expression = xml2Expression(forElement);
			onAlarm.setFor(expression);
		}
		
		// Set until element
		Element untilElement = getBPELChildElementByLocalName(onAlarmElement, "until");
		if (untilElement != null) {
			Expression expression = xml2Expression(untilElement);
			onAlarm.setUntil(expression);
		}
		
		// Set repeatEvery element
		Element repeatEveryElement = getBPELChildElementByLocalName(onAlarmElement, "repeatEvery");
		if (repeatEveryElement != null) {
			Expression expression = xml2Expression(repeatEveryElement);
			onAlarm.setRepeatEvery(expression);
		}
		
		// Set activity
		onAlarm.setActivity(getChildActivity(onAlarmElement));
		
		xml2ExtensibleElement(onAlarm, onAlarmElement);		
			
		return onAlarm;					
	}

	/**
	 * Converts an XML while element to a BPEL While object.
	 */
	protected Activity xml2While(Element whileElement) {
    	While _while = BPELFactory.eINSTANCE.createWhile();
		_while.setElement(whileElement);

		// Handle condition element
		Element conditionElement = getBPELChildElementByLocalName(whileElement, "condition");
		if (conditionElement != null) {
			Condition condition = xml2Condition(conditionElement);
			_while.setCondition(condition);
		}

        NodeList whileElements = whileElement.getChildNodes();
        
        Element activityElement = null;

		if (whileElements != null && whileElements.getLength() > 0) {
			
			for (int i = 0; i < whileElements.getLength(); i++) {			
				if (whileElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
           	   	  continue;
				}
           	   	  			
				activityElement = (Element) whileElements.item(i); 
            	Activity activity = xml2Activity(activityElement);
            	if (activity != null) { 
         	   		_while.setActivity(activity);
         	   		// only the first one
         	   		break ;
            	}
            	
			}
        }
        
        setStandardAttributes(whileElement, _while);
		
		return _while;
	}

	/**
	 * Converts an XML terminationHandler element to a BPEL TerminationHandler object.
	 */
	protected TerminationHandler xml2TerminationHandler(Element terminationHandlerElement) {
		TerminationHandler terminationHandler = BPELFactory.eINSTANCE.createTerminationHandler();
		terminationHandler.setElement(terminationHandlerElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(terminationHandler, terminationHandlerElement);
		
		terminationHandler.setActivity(getChildActivity(terminationHandlerElement));

		xml2ExtensibleElement(terminationHandler, terminationHandlerElement); 

		return terminationHandler;
	}



	/**
	 * Converts an XML if element to a BPEL If object.
	 */
	protected Activity xml2If(Element ifElement) {
		If _if = BPELFactory.eINSTANCE.createIf();		
		_if.setElement(ifElement);

		// Set activity
		Activity activity = getChildActivity(ifElement);
		if (activity != null) {
			_if.setActivity(activity);
		}
		
		// Handle condition element
		Element conditionElement = getBPELChildElementByLocalName(ifElement, "condition");
		if (conditionElement != null) {
			Condition condition = xml2Condition(conditionElement);
			_if.setCondition(condition);
		}
		
		// Handle elseif
		for(Element e : getBPELChildElementsByLocalName(ifElement, "elseif")) { 
			_if.getElseIf().add( xml2ElseIf ( e ));
        }
        
		// Handle else
		Element elseElement = getBPELChildElementByLocalName(ifElement, "else");
		if (elseElement != null) {
			Else _else = xml2Else(elseElement);
			_if.setElse(_else);
		}
		
		setStandardAttributes(ifElement, _if);
		
		return _if;		
	}

	/**
	 * Converts an XML elseIf element to a BPEL ElseIf object.
	 */
	protected ElseIf xml2ElseIf(Element elseIfElement) {
		ElseIf elseIf = BPELFactory.eINSTANCE.createElseIf();
    	elseIf.setElement(elseIfElement);
    	
		// Save all the references to external namespaces		
		saveNamespacePrefix(elseIf, elseIfElement);

		// Handle condition element
		Element conditionElement = getBPELChildElementByLocalName(elseIfElement, "condition");
		if (conditionElement != null) {
			Condition condition = xml2Condition(conditionElement);
			elseIf.setCondition(condition);
		}

		// Set activity
		Activity activity = getChildActivity(elseIfElement);
		if (activity != null) {
			elseIf.setActivity(activity);
		}
		
		return elseIf;
	}

	/**
	 * Converts an XML condition element to a BPEL Condition object.
	 */
	protected Condition xml2Condition(Element conditionElement) {
		Condition condition = BPELFactory.eINSTANCE.createCondition();
    	condition.setElement(conditionElement);
    	xml2Expression(conditionElement, condition);
    	return condition;
	}

	/**
	 * Converts an XML expression element to a BPEL Expression object.
	 * 
	 * Accept a pre-constructed argument. This is good for sub-types
	 * of expression.
	 * 
	 * Returns the second argument as a convenience.
	 *  
	 */
	protected Expression xml2Expression(Element expressionElement, Expression expression) {
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(expression, expressionElement);
    	
		if (expressionElement == null) {
			return expression;
		}

		// Set expressionLanguage
		if (expressionElement.hasAttribute("expressionLanguage")) {
			expression.setExpressionLanguage(expressionElement.getAttribute("expressionLanguage"));
		}

		// Set opaque
		if (expressionElement.hasAttribute("opaque")) {
			expression.setOpaque( Boolean.valueOf( expressionElement.getAttribute("opaque").equals("yes")));
		}
				
		String data = getText(expressionElement);
		if (data != null) {
			expression.setBody(data);
		}

		return expression;
	}

	/**
	 * Converts an XML expression element to a BPEL Expression object.
	 */
	protected Expression xml2Expression(Element expressionElement) {
		Expression expression = BPELFactory.eINSTANCE.createExpression();
		expression.setElement(expressionElement);
		
    	return xml2Expression(expressionElement, expression);
	}

	protected Else xml2Else(Element elseElement) {
		Else _else = BPELFactory.eINSTANCE.createElse();
		_else.setElement(elseElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(_else, elseElement);
		
		Activity activity = getChildActivity(elseElement);
		_else.setActivity(activity);
		
		return _else;
	}


	/**
	 * Converts an XML sequence element to a BPEL Sequence object.
	 */
	protected Activity xml2Sequence(Element sequenceElement) {
    	Sequence sequence = BPELFactory.eINSTANCE.createSequence();
    	sequence.setElement(sequenceElement);   	
	
		// Set name
		Attr name = sequenceElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified()) {
			sequence.setName(name.getValue());
		}
		
        NodeList sequenceElements = sequenceElement.getChildNodes();
        
        Element activityElement = null;

		if (sequenceElements != null && sequenceElements.getLength() > 0) {
          
           for (int i = 0; i < sequenceElements.getLength(); i++) {
        	   if (sequenceElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
           	   	  continue;
        	   }
           	   	             	
               activityElement = (Element)sequenceElements.item(i); 
               Activity activity = xml2Activity(activityElement);
               if (activity != null) { 
               		sequence.getActivities().add(activity);               	
               }
           }
        }
        
        setStandardAttributes(sequenceElement, sequence);
		
		return sequence;
	}

	/**
	 * Converts an XML empty element to a BPEL Empty object.
	 */
	protected Activity xml2Empty(Element emptyElement) {
		Empty empty = BPELFactory.eINSTANCE.createEmpty();
		empty.setElement(emptyElement);
		
		setStandardAttributes(emptyElement, empty);
		 
    	return empty;
	}

	/**
	 * Converts an XML opaqueActivity element to a BPEL OpaqueActivity object.
	 */
	protected Activity xml2OpaqueActivity(Element opaqueActivityElement) {
		OpaqueActivity opaqueActivity = BPELFactory.eINSTANCE.createOpaqueActivity();
		opaqueActivity.setElement(opaqueActivityElement);
		
		setStandardAttributes(opaqueActivityElement, opaqueActivity);
		 
    	return opaqueActivity;
	}

	/**
	 * Converts an XML valdateXML element to a BPEL ValidateXML object.
	 */
	protected Activity xml2Validate(Element validateElement) {
		final Validate validate = BPELFactory.eINSTANCE.createValidate();
		validate.setElement(validateElement);
		
		setStandardAttributes(validateElement, validate);
		if (validateElement.hasAttribute("variables")) {
			String variables = validateElement.getAttribute("variables");
			StringTokenizer st = new StringTokenizer(variables);

			while (st.hasMoreTokens()) {
				final String variableName = st.nextToken();
				// We must do this as a post load runnable because the variable might not
				// exist yet.
				fPass2Runnables.add(new Runnable() {
					public void run() {				
						Variable targetVariable = getVariable(validate, variableName);
						if (targetVariable == null) {
							targetVariable = new VariableProxy(getResource().getURI(), variableName);
						}
						validate.getVariables().add(targetVariable);
					}
				});
			}
		}
    	return validate;
	}
	
	/**
	 * Converts an XML rethrow element to a BPEL Rethrow object.
	 */
	protected Activity xml2Rethrow(Element rethrowElement) {
		Rethrow rethrow = BPELFactory.eINSTANCE.createRethrow();
		rethrow.setElement(rethrowElement);
		
		setStandardAttributes(rethrowElement, rethrow);
		 
    	return rethrow;
	}

	/**
	 * Converts an XML extensionactivity element to a BPEL ExtensionActivity object.
	 */
	protected Activity xml2ExtensionActivity(Element extensionActivityElement) {
		// Do not call setStandardAttributes here because extensionActivityElement
		// doesn't have them.
		Activity extensionActivity = BPELFactory.eINSTANCE.createExtensionActivity();

		// Find the child element.
		List<Element> nodeList = getChildElements(extensionActivityElement);
		
		if (nodeList.size() == 1) {
			final Element child = nodeList.get(0);
			// We found a child element. Look up a deserializer for this
			// activity and call it.
			String localName = child.getLocalName();
			String namespace = child.getNamespaceURI();
			final QName qname = new QName(namespace, localName);
			final BPELActivityDeserializer deserializer = extensionRegistry.getActivityDeserializer(qname);
			if (deserializer != null) {
				// Deserialize the DOM element and return the new Activity
				final Map<String,String> nsMap = getAllNamespacesForElement(child);
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
				extensionActivity = deserializer.unmarshall(qname,child,extensionActivity,process,nsMap,extensionRegistry, getResource().getURI(), this);
				// Now let's do the standard attributes and elements
				setStandardAttributes(child, extensionActivity);
				setStandardElements(child, extensionActivity);
				
				// Don't do extensibility because extensionActivity is not extensible.
				// If individual extensionActivity subclasses are actually extensible, they
				// have to do this themselves in their deserializer.
				
				// The created Activity that extends from ExtensioActivity should get the
				// whole <extensionActivity>-DOM-Fragment, this is done here.
				extensionActivity.setElement(extensionActivityElement);
				final Activity ea = extensionActivity;
				
		    	// Bug 120110 - run the deserializer again so it can resolve references to
				// objects that were not fully realized in pass 1.
				fPass2Runnables.add(new Runnable() {
					public void run() {
						deserializer.unmarshall(qname,child,ea,process,nsMap,extensionRegistry, getResource().getURI(), BPELReader.this);
					}
				});
 				return extensionActivity;
			}
		}
		// Fallback is to create a new extensionActivity.
		// Bugzilla 324115
		setStandardAttributes(extensionActivityElement, extensionActivity);
		setStandardElements(extensionActivityElement, extensionActivity);
		extensionActivity.setElement(extensionActivityElement);
		return extensionActivity;
	}

	
	/**
	 * Converts an XML wait element to a BPEL Wait object.
	 */
	protected Activity xml2Wait(Element waitElement) {
    	Wait wait = BPELFactory.eINSTANCE.createWait();
    	wait.setElement(waitElement);
		
		// Set name
		Attr name = waitElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified()) 
			wait.setName(name.getValue());
		
		// Set for element
		Element forElement = getBPELChildElementByLocalName(waitElement, "for");
		if (forElement != null) {
			Expression expression = xml2Expression(forElement);
			wait.setFor(expression);
		}
		
		// Set until element
		Element untilElement = getBPELChildElementByLocalName(waitElement, "until");
		if (untilElement != null) {
			Expression expression = xml2Expression(untilElement);
			wait.setUntil(expression);
		}
		
		setStandardAttributes(waitElement, wait);
			
		return wait;						
	}

	/**
	 * Converts an XML exit element to a BPEL Exit object.
	 */
	protected Activity xml2Exit(Element exitElement) {
    	Exit exit = BPELFactory.eINSTANCE.createExit();
    	exit.setElement(exitElement);
    	
		Attr name = exitElement.getAttributeNode("name");
		
		if (name != null && name.getSpecified())
			exit.setName(name.getValue());
		
		setStandardAttributes(exitElement, exit);
			
		return exit;
	}

	/**
	 * Converts an XML throw element to a BPEL Throw object.
	 */
	protected Activity xml2Throw(Element throwElement) {
		Throw _throw = BPELFactory.eINSTANCE.createThrow();
		_throw.setElement(throwElement);			
		
		if (throwElement.hasAttribute("name")) {
			_throw.setName(throwElement.getAttribute("name"));
		}
		if (throwElement.hasAttribute("faultName")) {
			QName qName = BPELUtils.createAttributeValue(throwElement, "faultName");	
			_throw.setFaultName(qName);
		}

		// Set fault variable name
		setVariable(throwElement, _throw, "faultVariable", BPELPackage.eINSTANCE.getThrow_FaultVariable());
		
		setStandardAttributes(throwElement, _throw);
		
		return _throw;	
	}

	/**
	 * Converts an XML assign element to a BPEL Assign object.
	 */
	protected Activity xml2Assign(Element assignElement) {
		Assign assign = BPELFactory.eINSTANCE.createAssign();
		assign.setElement(assignElement);			
        
		if (assignElement.hasAttribute("validate")) {
			assign.setValidate( Boolean.valueOf( assignElement.getAttribute("validate").equals("yes")));
		}
		
		for (Element copyElement : getBPELChildElementsByLocalName(assignElement, "copy") ) {                    
            assign.getCopy().add( xml2Copy ( copyElement ));
        }
        
        setStandardAttributes(assignElement, assign);

		return assign;
	}

	/**
	 * Converts an XML copy element to a BPEL Copy object.
	 */
	protected Copy xml2Copy(Element copyElement) {
		Copy copy = BPELFactory.eINSTANCE.createCopy();
		copy.setElement(copyElement);
        

		// Save all the references to external namespaces		
		saveNamespacePrefix(copy, copyElement);

        Element fromElement = getBPELChildElementByLocalName(copyElement, "from");
        if (fromElement != null) {
            From from = BPELFactory.eINSTANCE.createFrom();
            from.setElement(fromElement);
            
            xml2From(from, fromElement); 
            copy.setFrom(from);
        }
        
        Element toElement = getBPELChildElementByLocalName(copyElement, "to");
        if (toElement != null) {
            To to = BPELFactory.eINSTANCE.createTo();
            to.setElement(toElement);
            
            xml2To(to, toElement); 
            copy.setTo(to);
        }
 
		if (copyElement.hasAttribute("keepSrcElementName"))
			copy.setKeepSrcElementName( Boolean.valueOf( copyElement.getAttribute("keepSrcElementName").equals("yes")));
		
		if (copyElement.hasAttribute("ignoreMissingFromData")) 
			copy.setIgnoreMissingFromData( Boolean.valueOf( copyElement.getAttribute("ignoreMissingFromData").equals("yes")));

		xml2ExtensibleElement(copy, copyElement);
 		
		return copy;
	}

	/**
	 * Converts an XML toPart element to a BPEL ToPart object.
	 */
	protected ToPart xml2ToPart(Element toPartElement) {
		ToPart toPart = BPELFactory.eINSTANCE.createToPart();
		
		toPart.setElement(toPartElement);        

		// Save all the references to external namespaces		
		saveNamespacePrefix(toPart, toPartElement);

		// Set part
		Attr part = toPartElement.getAttributeNode("part"); 		
    
		if (part != null && part.getSpecified()) {		
			final String partAttr = toPartElement.getAttribute("part");
            ((ToPartImpl) toPart).setPartName(partAttr);
		}

		// Set fromVariable
		setVariable(toPartElement, toPart, "fromVariable", BPELPackage.eINSTANCE.getToPart_FromVariable());
        
        
		return toPart;
	}

	/**
	 * Converts an XML fromPart element to a BPEL FromPart object.
	 */
	protected FromPart xml2FromPart(Element fromPartElement) {
		FromPart fromPart = BPELFactory.eINSTANCE.createFromPart();
		fromPart.setElement(fromPartElement);		       

		// Save all the references to external namespaces		
		saveNamespacePrefix(fromPart, fromPartElement);

		// Set part
		Attr part = fromPartElement.getAttributeNode("part"); 		
    
		if (part != null && part.getSpecified()) {		
			final String partAttr = fromPartElement.getAttribute("part");
            ((FromPartImpl) fromPart).setPartName(partAttr);
		}

		// Set toVariable
		setVariable(fromPartElement, fromPart, "toVariable", BPELPackage.eINSTANCE.getFromPart_ToVariable());
        
		return fromPart;
	}

	/**
	 * Converts an XML "to" element to a BPEL To object.
	 */
	protected To xml2To(To to, Element toElement) {
//		The to-spec MUST be one of the following variants:
//	1.		<to variable="BPELVariableName" part="NCName"?>
//			   <query queryLanguage="anyURI"?>?
//			      queryContent
//			   </query>
//			</to>
//
//	2.		<to partnerLink="NCName" />
//
//	3.		<to variable="BPELVariableName" property="QName" />
//
//	4.		<to expressionLanguage="anyURI"?>expression</to>
//
//	5.		<to/>
			
		// Save all the references to external namespaces		
		saveNamespacePrefix(to, toElement);
		
		// Set variable
		Attr variable = toElement.getAttributeNode("variable"); 
    
		if (variable != null && variable.getSpecified()) {				
			setVariable(toElement, to, "variable", BPELPackage.eINSTANCE.getAbstractAssignBound_Variable());
		}

		// Set part
		Attr part = toElement.getAttributeNode("part"); 		
    
		if (part != null && part.getSpecified()) {		
			final String partAttr = toElement.getAttribute("part");
            ((ToImpl) to).setPartName(partAttr);
		}

		// Set partnerLink			
		Attr partnerLink = toElement.getAttributeNode("partnerLink");			
		
		if (partnerLink != null && partnerLink.getSpecified()) {
			setPartnerLink(toElement, to, BPELPackage.eINSTANCE.getAbstractAssignBound_PartnerLink());
		}

		// Set property		
		Attr property = toElement.getAttributeNode("property");
     		
		if (property != null && property.getSpecified()) {
			setProperties(toElement, to, "property");
		}

		// Set query element
		Element queryElement = getBPELChildElementByLocalName(toElement, "query");
		if (queryElement != null) {
			Query queryObject = BPELFactory.eINSTANCE.createQuery();
			
			queryObject.setElement(queryElement);
			to.setQuery(queryObject);
			
			// Set queryLanguage
			if (queryElement.hasAttribute("queryLanguage")) {
				String queryLanguage = queryElement.getAttribute("queryLanguage");
				queryObject.setQueryLanguage(queryLanguage);
			}

			// Set query text
			// Get the condition text
			String data = getText( queryElement  );
			if (data != null) {
				queryObject.setValue(data);
			}
		} else {	
			
			if (partnerLink == null && variable == null){

				// must be expression
				Expression expressionObject = BPELFactory.eINSTANCE.createExpression();
				
				to.setExpression(expressionObject);
				
				// Set expressionLanguage
				if (toElement.hasAttribute("expressionLanguage")) {
					expressionObject.setExpressionLanguage(toElement.getAttribute("expressionLanguage"));
				}
		
				// Set expression text
				// Get the condition text
				String data = getText( toElement );
				if (data != null) {			
					expressionObject.setBody(data);
				}				
			}
		}
		return to;
	}

	/**
	 * Converts an XML "from" element to a BPEL From object.
	 */
	protected From xml2From(From from, Element fromElement) {
		
		/** This is basically what's in xml2To */
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(from, fromElement);
		
		// Set variable
		Attr variable = fromElement.getAttributeNode("variable"); 
    
		if (variable != null && variable.getSpecified()) {				
			setVariable(fromElement, from, "variable", BPELPackage.eINSTANCE.getAbstractAssignBound_Variable() );
		}

		// Set part
		Attr part = fromElement.getAttributeNode("part"); 		
    
		if (part != null && part.getSpecified()) {		
			final String partAttr = fromElement.getAttribute("part");
            ((FromImpl) from).setPartName(partAttr);
		}

		// Set partnerLink			
		Attr partnerLink = fromElement.getAttributeNode("partnerLink");			
		
		if (partnerLink != null && partnerLink.getSpecified()) {
			setPartnerLink(fromElement, from, BPELPackage.eINSTANCE.getAbstractAssignBound_PartnerLink());
		}

		// Set property		
		Attr property = fromElement.getAttributeNode("property");
     		
		if (property != null && property.getSpecified()) {
			setProperties(fromElement, from, "property");
		}

		// Set query element
		Element queryElement = getBPELChildElementByLocalName(fromElement, "query");
		if (queryElement != null) {
			Query queryObject = BPELFactory.eINSTANCE.createQuery();
			
			queryObject.setElement(queryElement);
			from.setQuery(queryObject);
			
			// Set queryLanguage
			if (queryElement.hasAttribute("queryLanguage")) {
				String queryLanguage = queryElement.getAttribute("queryLanguage");
				queryObject.setQueryLanguage(queryLanguage);
			}

			// Set query text
			// Get the condition text
			String data = getText ( queryElement );
			if (data != null) {
				queryObject.setValue(data);
			}			
		}
		
		
		Attr endpointReference = fromElement.getAttributeNode("endpointReference");
    
		if (endpointReference != null && endpointReference.getSpecified()) {
			from.setEndpointReference(EndpointReferenceRole.get(endpointReference.getValue()));
		}
		
		// Set service-ref element		
		Element serviceRefElement = getBPELChildElementByLocalName(fromElement, "service-ref");
		Element literalElement = getBPELChildElementByLocalName(fromElement, "literal");
		
		
		if (serviceRefElement != null) {
					
			ServiceRef serviceRef = BPELFactory.eINSTANCE.createServiceRef();
			// TODO: ? serviceRef.setElement(serviceRefElement);
			
			from.setServiceRef(serviceRef);
			
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
				if (candidateChild != null && candidateChild.getNodeType() == Node.ELEMENT_NODE) {
					// Look if there's an ExtensibilityElement deserializer for this element
					Element childElement = (Element)candidateChild;
					QName qname = new QName(childElement.getNamespaceURI(), childElement.getLocalName());
					BPELExtensionDeserializer deserializer=null;
					try {
						deserializer = (BPELExtensionDeserializer)extensionRegistry.queryDeserializer(BPELExtensibleElement.class,qname);
					} catch (WSDLException e) {
						// nothing
					}
					
					if (deserializer != null && !(deserializer instanceof BPELUnknownExtensionDeserializer)) {
						// Deserialize the DOM element and add the new Extensibility element to the parent
						// BPELExtensibleElement
						try {
							Map<String,String> nsMap = getAllNamespacesForElement(serviceRefElement);
							ExtensibilityElement extensibilityElement=deserializer.unmarshall(BPELExtensibleElement.class,qname,childElement,process,nsMap,extensionRegistry,getResource().getURI(),this);
							serviceRef.setValue(extensibilityElement);
						} catch (WSDLException e) {
							throw new WrappedException(e);
						}
					} else {
						ServiceReferenceDeserializer referenceDeserializer = extensionRegistry.getServiceReferenceDeserializer(serviceRef.getReferenceScheme());
						if (referenceDeserializer != null) {
							Object serviceReference = referenceDeserializer.unmarshall(childElement, process);
							serviceRef.setValue(serviceReference);
						}
					}
				}
			} else {
				serviceRef.setValue(data);
			}
						
		} 
		
		
		// Literal node
		if (literalElement != null) {
			StringBuilder elementData = new StringBuilder(256);
			
			NodeList nl = literalElement.getChildNodes();
			
			outer : for (int i=0; i < nl.getLength(); i++) {
				
				Node n = nl.item(i);
				switch (n.getNodeType()) {
					case  Node.ELEMENT_NODE :
						elementData.setLength(0);
						elementData.append(BPELUtils.elementToString((Element)n));
						break outer;
						
					case Node.TEXT_NODE :
					case Node.CDATA_SECTION_NODE :
						// elementData.append( n.getTextContent() );
						elementData.append( getText(n) );
						break;
				}
			}
			
			from.setUnsafeLiteral(Boolean.FALSE);
			String elementDataFinal = elementData.toString();			
			if (isEmptyOrWhitespace(elementDataFinal) == false) {
				from.setUnsafeLiteral(Boolean.TRUE);
				from.setLiteral( elementDataFinal );
			}
			
		} else {		
		
			// must be expression
			Expression expressionObject = BPELFactory.eINSTANCE.createExpression();
			
			from.setExpression(expressionObject);
			
			// Set expressionLanguage
			if (fromElement.hasAttribute("expressionLanguage")) {
				expressionObject.setExpressionLanguage(fromElement.getAttribute("expressionLanguage"));
			}

			// Set expression text
			// Get the condition text
			String data = getText( fromElement );
			if (data != null) {			
				expressionObject.setBody(data);
			}								
		}

		// Set opaque
		Attr opaque = fromElement.getAttributeNode("opaque");
			
		if (opaque != null && opaque.getSpecified()) {
			from.setOpaque( Boolean.valueOf( opaque.getValue().equals("yes")));
		}

		
		// See if there is an xsi:type attribue.
		if (fromElement.hasAttribute("xsi:type")) {
			QName qName = BPELUtils.createAttributeValue(fromElement, "xsi:type");
			XSDTypeDefinition type = new XSDTypeDefinitionProxy(getResource().getURI(), qName);
			from.setType(type);						
		}
		return from;
	}
	
	/**
	 * Converts an XML assignE4X element to a BPEL Assign object.
	 * 
	 */
	protected Activity xml2AssignE4X(Element assignE4XElement) {
		AssignE4X assignE4X = BPELFactory.eINSTANCE.createAssignE4X();
		assignE4X.setElement(assignE4XElement);			
        
		//setting Validate Attribute value
		if (assignE4XElement.hasAttribute("validate")) {
			assignE4X.setValidate( Boolean.valueOf( assignE4XElement.getAttribute("validate").equals("yes")));
		}
		
		// Reading "extensionAssignOperation" Elements and adding them in to assignE4X
		for (Element extensionAssignOperationElement : getBPELChildElementsByLocalName(assignE4XElement, "extensionAssignOperation") ) {                    
            assignE4X.getExtensionAssignOperation().add( xml2ExtensionAssignOperation(extensionAssignOperationElement));
        }
        
        setStandardAttributes(assignE4XElement, assignE4X);

		return assignE4X;
	}
	
	/**
	 * Converts an XML ExtensionAssignOperation element to a BPEL ExtensionAssignOperation object.
	 * 
	 */
	protected ExtensionAssignOperation xml2ExtensionAssignOperation(Element extensionAssignOperationElement) {
		ExtensionAssignOperation extensionAssignOperation = BPELFactory.eINSTANCE.createExtensionAssignOperation();
		extensionAssignOperation.setElement(extensionAssignOperationElement);
        

		// Save all the references to external namespaces		
		saveNamespacePrefix(extensionAssignOperation, extensionAssignOperationElement);

		// Reading snippet Element
        Element snippetElement = getSnippet(extensionAssignOperationElement);
        
        if (snippetElement != null) {
            Snippet snippet = BPELFactory.eINSTANCE.createSnippet();
            snippet.setElement(snippetElement);
            
            xml2Snippet(snippet, snippetElement); 
            extensionAssignOperation.setSnippet(snippet);
        }
        

		xml2ExtensibleElement(extensionAssignOperation, extensionAssignOperationElement);
		return extensionAssignOperation;
	}
	
	/**
	 * returns a Snippet element from parent ExtensionAssignperation
	 * @param parentElement
	 * @return
	 */
	private Element getSnippet(Element parentElement) {
		String localName = "snippet";
		
		// Reading child nodes and check for localName is equal to "snippet"
		// by default snippet element is the first child of extensionAssignOperation element
		// in this implementation.
				
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
	 * Converts an XML Snippet element to a Snippet object.
	 */
	protected Snippet xml2Snippet(Snippet snippet,Element snippetElement)
	{
		// Save all the references to external namespaces
		saveNamespacePrefix(snippet, snippetElement);
    	
		if (snippetElement == null) {
			return snippet;
		}
		
		//reading body of the snippet and add it into the Snippet object
		String data = getText(snippetElement);
		if (data != null) {
			snippet.setBody(data);
		}
	
    	return snippet;
	}


	/**
	 * Converts an XML import element to a BPEL Import object.
	 */
	protected Import xml2Import(Element importElement) {
		if (!importElement.getLocalName().equals("import"))
			return null;
			
		Import imp = BPELFactory.eINSTANCE.createImport();
		imp.setElement(importElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(imp, importElement);
		
		// namespace
		if (importElement.hasAttribute("namespace"))
			imp.setNamespace(importElement.getAttribute("namespace"));
		
		// location
		if (importElement.hasAttribute("location"))
			imp.setLocation(importElement.getAttribute("location"));
		
		// importType
		if (importElement.hasAttribute("importType"))
			imp.setImportType(importElement.getAttribute("importType"));

		return imp;					
	}


	/**
	 * Converts an XML invoke element to a BPEL Invoke object.
	 */
	protected Activity xml2Invoke(Element invokeElement) {
		Invoke invoke = BPELFactory.eINSTANCE.createInvoke();
		invoke.setElement(invokeElement);			
		
		// Set several parms
		setStandardAttributes(invokeElement, invoke);
		setOperationParms(invokeElement, invoke, null, BPELPackage.eINSTANCE.getInvoke_InputVariable(), BPELPackage.eINSTANCE.getInvoke_OutputVariable(), BPELPackage.eINSTANCE.getPartnerActivity_PartnerLink());

		// Set compensationHandler
		setCompensationHandler(invokeElement, invoke);
		
		// Set the fault handler (for catche-s and catchAll-s)
		FaultHandler faultHandler = xml2FaultHandler(invokeElement);
		if (faultHandler != null && (!faultHandler.getCatch().isEmpty() ||  faultHandler.getCatchAll() != null)) {
			// Only set this on the activity if there is at least one catch clause, or a catchAll clause
			invoke.setFaultHandler(faultHandler);
		}

		Element toPartsElement = getBPELChildElementByLocalName(invokeElement, "toParts");
		if (toPartsElement != null) {
			ToParts toParts = xml2ToParts(toPartsElement);
			invoke.setToParts(toParts);
		}
		// Set fromParts
		Element fromPartsElement = getBPELChildElementByLocalName(invokeElement, "fromParts");
		if (fromPartsElement != null) {
			FromParts fromParts = xml2FromParts(fromPartsElement);
			invoke.setFromParts(fromParts);
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
			FailureHandling failureHandling = xml2FailureHandling(failureHandlingElement);
			invoke.setFailureHandling(failureHandling);
		}
		
		return invoke;
	}


	/**
	 * Converts an XML reply element to a BPEL Reply object.
	 */
	protected Activity xml2Reply(Element replyElement) {
		Reply reply = BPELFactory.eINSTANCE.createReply();
		reply.setElement(replyElement);			
		
		// Set several parms
		setStandardAttributes(replyElement, reply);
		setOperationParms(replyElement, reply, BPELPackage.eINSTANCE.getReply_Variable(), null, null, BPELPackage.eINSTANCE.getPartnerActivity_PartnerLink());

		if (replyElement.hasAttribute("faultName")) {
			QName qName = BPELUtils.createAttributeValue(replyElement, "faultName");	
			reply.setFaultName(qName);
		}

		Element toPartsElement = getBPELChildElementByLocalName(replyElement, "toParts");
		if (toPartsElement != null) {
			ToParts toParts = xml2ToParts(toPartsElement);
			reply.setToParts(toParts);
		}
		
		// Set messageExchange
		setMessageExchange(replyElement, reply, BPELPackage.eINSTANCE.getReply_MessageExchange());
		
		return reply;		
	}
     
     
	/**
	 * Converts an XML receive element to a BPEL Receive object.
	 */
	protected Activity xml2Receive(Element receiveElement) {
		Receive receive = BPELFactory.eINSTANCE.createReceive();
		receive.setElement(receiveElement);				
	
		// Set several parms
		setStandardAttributes(receiveElement, receive);
		setOperationParms(receiveElement, receive, BPELPackage.eINSTANCE.getReceive_Variable(), null, null, BPELPackage.eINSTANCE.getPartnerActivity_PartnerLink());

		// Set createInstance
		if (receiveElement.hasAttribute("createInstance")) {		           
			String createInstance = receiveElement.getAttribute("createInstance");
			receive.setCreateInstance( Boolean.valueOf( createInstance.equals("yes")));
		}

		Element fromPartsElement = getBPELChildElementByLocalName(receiveElement, "fromParts");
		if (fromPartsElement != null) {
			FromParts fromParts = xml2FromParts(fromPartsElement);
			receive.setFromParts(fromParts);
		}	
		
		// Set messageExchange
		setMessageExchange(receiveElement, receive, BPELPackage.eINSTANCE.getReceive_MessageExchange());
		
		return receive;
	}
	
	/**
	 * Sets a MessageExchange element for a given EObject. The given activity
	 * element must contain an attribute named "messageExchange".
	 * 
	 * @param activityElement
	 *            the DOM element of the activity
	 * @param eObject
	 *            the EObject in which to set the partner link
	 */
	protected void setMessageExchange(Element activityElement, final EObject eObject, final EReference reference) {
		if (!activityElement.hasAttribute("messageExchange")) {
			return;
		}
		final String messageExchangeName = activityElement.getAttribute("messageExchange");
		
		// We must do this as a post load runnable because the partner link might not
		// exist yet.
		fPass2Runnables.add(new Runnable() {
			public void run() {	
				MessageExchange targetMessageExchange = BPELUtils.getMessageExchange(eObject, messageExchangeName);
				if (targetMessageExchange == null) {
					targetMessageExchange = new MessageExchangeProxy(getResource().getURI(), messageExchangeName);
				}
				eObject.eSet(reference, targetMessageExchange);				
			}
		});		
	}

	/**
	 * Converts an XML forEach element to a BPEL ForEach object.
	 */
	protected Activity xml2ForEach(Element forEachElement) {
		ForEach forEach = BPELFactory.eINSTANCE.createForEach();
		forEach.setElement(forEachElement);			
		
		// Set several parms
		setStandardAttributes(forEachElement, forEach);

		if (forEachElement.hasAttribute("parallel")) {
			forEach.setParallel(forEachElement.getAttribute("parallel").equals("yes"));
		}

		// Set counterName variable
		if (forEachElement.hasAttribute("counterName")) {
			Variable variable = BPELFactory.eINSTANCE.createVariable();
			// TODO: How to facade this ?
			variable.setName(forEachElement.getAttribute("counterName"));
			QName qName = new QName(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001, "unsignedInt");
			XSDTypeDefinition type = new XSDTypeDefinitionProxy(getResource().getURI(), qName);
			variable.setType(type);
			forEach.setCounterName(variable);					
		}		

		// Set startCounterValue element
		Element startCounterValueElement = getBPELChildElementByLocalName(forEachElement, "startCounterValue");
		if (startCounterValueElement != null) {
			Expression expression = xml2Expression(startCounterValueElement);
			forEach.setStartCounterValue(expression);
		}
		
		// Set finalCounterValue element
		Element finalCounterValueElement = getBPELChildElementByLocalName(forEachElement, "finalCounterValue");
		if (finalCounterValueElement != null) {
			Expression expression = xml2Expression(finalCounterValueElement);
			forEach.setFinalCounterValue(expression);
		}
		
		// Set completionCondition element
		Element completionConditionElement = getBPELChildElementByLocalName(forEachElement, "completionCondition");
		if (completionConditionElement != null) {
			CompletionCondition completionCondition = xml2CompletionCondition(completionConditionElement);
			forEach.setCompletionCondition(completionCondition);
		}

		// Set activity
		Activity activity = getChildActivity(forEachElement);
		if (activity instanceof Scope) {
			forEach.setActivity(activity);
		}
				
		return forEach;
	}

	/**
	 * Converts an XML completionCondition element to a BPEL CompletionCondition object.
	 */
	protected CompletionCondition xml2CompletionCondition(Element completionConditionElement) {
		CompletionCondition completionCondition = BPELFactory.eINSTANCE.createCompletionCondition();
		completionCondition.setElement(completionConditionElement);			
		
		// Set branches element
		Element branchesElement = getBPELChildElementByLocalName(completionConditionElement, "branches");
		if (branchesElement != null) {
			Branches branches = xml2Branches(branchesElement);
			completionCondition.setBranches(branches);
		}
		
		return completionCondition;
	}

	/**
	 * Converts an XML branches element to a BPEL Branches object.
	 */
	protected Branches xml2Branches(Element branchesElement) {
		Branches branches = BPELFactory.eINSTANCE.createBranches();
		branches.setElement(branchesElement);
		
		xml2Expression(branchesElement, branches);

		if (branchesElement.hasAttribute("successfulBranchesOnly"))
			branches.setCountCompletedBranchesOnly( Boolean.valueOf( branchesElement.getAttribute("successfulBranchesOnly").equals("yes")));

		return branches;
	}

	/**
	 * Converts an XML documentation element to a BPEL Documentation object.
	 */
	protected Documentation xml2Documentation(Element documentationElement) {
		Documentation documentation = BPELFactory.eINSTANCE.createDocumentation();
		documentation.setElement(documentationElement);
				 
		if (documentationElement.hasAttribute("xml:lang")) {
			documentation.setLang(documentationElement.getAttribute("xml:lang"));
		}
		if (documentationElement.hasAttribute("source")) {
			documentation.setSource(documentationElement.getAttribute("source"));
		}
	    String text = getText(documentationElement);
	    if (text != null) {
	        documentation.setValue(text);
	    }
	    
		return documentation;
	}

	/**
	 * Converts an XML repeatUntil element to a BPEL RepeatUntil object.
	 */
	protected Activity xml2RepeatUntil(Element repeatUntilElement) {
		RepeatUntil repeatUntil = BPELFactory.eINSTANCE.createRepeatUntil();
		repeatUntil.setElement(repeatUntilElement);		
		
		// Set several parms
		setStandardAttributes(repeatUntilElement, repeatUntil);

		// Handle condition element
		Element conditionElement = getBPELChildElementByLocalName(repeatUntilElement, "condition");
		if (conditionElement != null) {
			Condition condition = xml2Condition(conditionElement);
			repeatUntil.setCondition(condition);
		}

        NodeList repeatUntilElements = repeatUntilElement.getChildNodes();
        
        Element activityElement = null;

		if (repeatUntilElements != null && repeatUntilElements.getLength() > 0) {
			for (int i = 0; i < repeatUntilElements.getLength(); i++) {
				
				if (repeatUntilElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
           	   		continue;
				}
           	   	  			
				activityElement = (Element)repeatUntilElements.item(i); 
            	Activity activity = xml2Activity(activityElement);
            	if (activity != null) {
            		repeatUntil.setActivity(activity);
            		break;
            	}
			}
        }
        
		return repeatUntil;
	}

	protected Correlations xml2Correlations(Element correlationsElement) {
		if (!correlationsElement.getLocalName().equals("correlations"))
			return null;
			
		Correlations correlations = BPELFactory.eINSTANCE.createCorrelations();
		correlations.setElement(correlationsElement);
		
		// Save all the references to external namespaces		
		saveNamespacePrefix(correlations, correlationsElement);
		
		for(Element e : getBPELChildElementsByLocalName(correlationsElement, "correlation")) {
			correlations.getChildren().add( xml2Correlation(e));			
		}
		
		// extensibility elements
		xml2ExtensibleElement(correlations, correlationsElement);
		
		return correlations;
	}		
	
	/**
	 * Converts an XML correlation element to a BPEL Correlation object.
	 */
	protected Correlation xml2Correlation(Element correlationElement) {
    	final Correlation correlation = BPELFactory.eINSTANCE.createCorrelation();
    	correlation.setElement(correlationElement);

		// Save all the references to external namespaces		
		saveNamespacePrefix(correlation, correlationElement);
    	
		if (correlationElement == null) return correlation;

		// Set set
		if (correlationElement.hasAttribute("set")) {
			final String correlationSetName = correlationElement.getAttribute("set");
			fPass2Runnables.add(new Runnable() {
				public void run() {	
					CorrelationSet cSet = BPELUtils.getCorrelationSetForActivity(correlation, correlationSetName);
					if (cSet == null) {
						cSet = new CorrelationSetProxy(getResource().getURI(), correlationSetName);
					}
					correlation.setSet(cSet);								
				}
			});		
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
		}
			
		// Set pattern
		Attr pattern = correlationElement.getAttributeNode("pattern");

		if (pattern != null && pattern.getSpecified()) {
			if (pattern.getValue().equals("request"))
				correlation.setPattern(CorrelationPattern.REQUEST_LITERAL);
			else if (pattern.getValue().equals("response"))
					correlation.setPattern(CorrelationPattern.RESPONSE_LITERAL);
				else if (pattern.getValue().equals("request-response"))
					correlation.setPattern(CorrelationPattern.REQUESTRESPONSE_LITERAL);			
		}
		
		xml2ExtensibleElement(correlation, correlationElement);
		
		return correlation;
	}
	
	protected Compensate xml2Compensate(Element compensateElement) {
		final Compensate compensate = BPELFactory.eINSTANCE.createCompensate();
		compensate.setElement(compensateElement);
		setStandardAttributes(compensateElement, compensate);		
		return compensate;
	}
	
	
	protected CompensateScope xml2CompensateScope (Element compensateScopeElement) {
		
		final CompensateScope compensateScope = BPELFactory.eINSTANCE.createCompensateScope();
		compensateScope.setElement(compensateScopeElement);
		
		final String target = compensateScopeElement.getAttribute("target");
		
		if (target != null && target.length() > 0) {
			fPass2Runnables.add(new Runnable() {
				public void run() {
					compensateScope.setTarget(target);
				}
			});
		}

		setStandardAttributes(compensateScopeElement, compensateScope);
		
		return compensateScope;
	}
	
	/**
	 * Converts an XML extensible element to a BPEL extensible element
	 */
	
	protected void xml2ExtensibleElement (BPELExtensibleElement extensibleElement, Element element) {
		
		if (extensionRegistry == null) {
			return;
		}
			
		// Handle the documentation element first
		Element documentationElement = getBPELChildElementByLocalName(element, "documentation");
		if (documentationElement != null) {
			Documentation documentation = xml2Documentation(documentationElement);
			extensibleElement.setDocumentation(documentation);
		}
		
		// Get the child nodes, elements and attributes
		List<Node> nodes=new ArrayList<Node>();
		
		NodeList nodeList = element.getChildNodes();
		for (int i=0, n=nodeList.getLength(); i<n; i++) {
			if (nodeList.item(i) instanceof Element) {
				final String namespaceURI = ((Element)nodeList.item(i)).getNamespaceURI();
				if (!(BPELConstants.isBPELNamespace(namespaceURI)))
					nodes.add(nodeList.item(i)); 
			}
		}
		
		NamedNodeMap nodeMap=element.getAttributes();
		for (int i=0, n=nodeMap.getLength(); i<n; i++) {
			Attr attr = (Attr)nodeMap.item(i);
			if (attr.getNamespaceURI() != null && !attr.getNamespaceURI().equals(XSDConstants.XMLNS_URI_2000)) {
				nodes.add(attr);	
			}
		}
		
		for (Node node : nodes ) {
			
			// TODO What is this check for? If we're actually checking for
			// the BPEL namespace, use BPELConstants instead.
			if (MessagepropertiesConstants.isMessagePropertiesNamespace(node.getNamespaceURI())) {
				continue;
			}
			
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				deserialize ( extensibleElement, (Element) node);
			} else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
				deserialize ( extensibleElement, (Attr) node);
			}
		}
	}
	

	protected void deserialize ( BPELExtensibleElement ee, Element elm ) {
		
		QName qname = new QName(elm.getNamespaceURI(),elm.getLocalName());
		BPELExtensionDeserializer deserializer = null;
		try {
			deserializer = (BPELExtensionDeserializer)extensionRegistry.queryDeserializer (BPELExtensibleElement.class,qname);
		} catch (WSDLException e) {
			// we don't have one.
		}
		if (deserializer == null) {
			return ;
		}
		// Deserialize the DOM element and add the new Extensibility element to the parent
		// BPELExtensibleElement
		Map<String,String> nsMap = getAllNamespacesForElement (elm);
		try {			
			ExtensibilityElement extensibilityElement = deserializer.unmarshall(ee.getClass(),qname,elm,process,nsMap,extensionRegistry,getResource().getURI(),this);
			ee.addExtensibilityElement(extensibilityElement);
		} catch (WSDLException e) {
			throw new WrappedException(e);
		}
	}
	
	
	protected void deserialize ( BPELExtensibleElement ee, Attr attr) {
		 
		if (attr.getSpecified() == false) {
			 return ;
		 }

		QName qname = new QName (attr.getNamespaceURI(),"extensibilityAttributes");
		BPELExtensionDeserializer deserializer = null;
		try {
			deserializer = (BPELExtensionDeserializer) extensionRegistry.queryDeserializer(BPELExtensibleElement.class,qname);
		} catch (WSDLException e) {
			// ignore
		}
		if (deserializer == null) {
			return ;
		}
		
		// Create a temp element to host the extensibility attribute
        // 
        // This turns something that looks like this:
        //   <bpws:X someNS:Y="Z"/>
        // into something that looks like this:
        //   <someNS:extensibilityAttributes xmlns:someNS="http://the.namespace" Y="Z"/>
        
		Element tempElement = attr.getOwnerDocument().createElementNS(attr.getNamespaceURI(), attr.getPrefix() + ":extensibilityAttributes");
        tempElement.setAttribute(BPELUtils.ATTR_XMLNS + ":" + attr.getPrefix(), attr.getNamespaceURI());
		tempElement.setAttribute(attr.getLocalName(), attr.getNodeValue());
		
		// Deserialize the temp DOM element and add the new Extensibility element to the parent
		// BPELExtensibleElement
		Map<String,String> nsMap = getAllNamespacesForElement( (Element) attr.getParentNode() );
		try {			
			ExtensibilityElement extensibilityElement = deserializer.unmarshall(BPELExtensibleElement.class,qname,tempElement,process,nsMap,extensionRegistry,getResource().getURI(),this);
			if (extensibilityElement!=null) {
				ee.addExtensibilityElement (extensibilityElement);
			}
		} catch (WSDLException e) {
			throw new WrappedException(e);
		}
	}
	
	/**
	 * Checks for process type
	 * @param processElement
	 * @return true if process is abstract, false otherwise
	 */
	public boolean isAbstractProcess(Element processElement)
	{
		
		if (processElement != null) {
    		Map<String, String> nsMap = this.getAllNamespacesForElement(processElement);
   		
    		if (nsMap.containsValue(BPELConstants.NAMESPACE_ABSTRACT_2007))
    		{
    			return true;
    		}
		}
    	return false;
	}
	
	/**
	 * returns abstract process profile
	 * @param processElement
	 * @return namespace of abstract process profile
	 */
	public String getProfileNamespace(Element processElement)
	{
		if (processElement.getAttribute(BPELConstants.AT_ABSTRACT_PROFILES) != null){
			
			return processElement.getAttribute(BPELConstants.AT_ABSTRACT_PROFILES);
		}
    	return null;
	}
	
	
	/**
     * Returns true if the string is either null or contains just whitespace.
	 * @param value 
	 * @return true if empty or whitespace, false otherwise.
     */
		
   static public boolean isEmptyOrWhitespace( String value )
   {
       if( value == null || value.length() == 0) {
           return true;
       }               
       for( int i = 0, j = value.length(); i < j; i++ )
       {
           if( ! Character.isWhitespace( value.charAt(i) ) ) {
               return false;
           }
       }
       return true;
   }
	
	
	/**
	 * Returns the text of the given node. If the node is an element node, its
	 * children text value is returned. Otherwise, the node is assumed to be 
	 * the first child node and the siblings sequence is scanned.
	 *   
	 * 
	 */
   
	String getText (Node node) {
		
		StringBuilder sb = new StringBuilder(128);
		
		if (node instanceof Element) {
			node = ((Element)node).getFirstChild();
		}		
		
		boolean bCData = false;
		
		while (node != null) {
			switch (node.getNodeType()) {
			case Node.TEXT_NODE :
				if (bCData) {
					break;
				}
				Text text = (Text) node;
				sb.append(text.getData());
				break;
			case Node.CDATA_SECTION_NODE :
				if (bCData == false) {
					sb.setLength(0);
					bCData = true;
				}
				CDATASection cdata = (CDATASection) node;
				sb.append( cdata.getData() );
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

	
	
	/**
	 * @see org.xml.sax.ErrorHandler#error(org.xml.sax.SAXParseException)
	 */
	@SuppressWarnings("boxing")
	public void error (SAXParseException exception) {
		
		String message = java.text.MessageFormat.format(
				"Error in {0} [{2}:{3}] {4}",				
				exception.getPublicId(),
				exception.getSystemId(),
				exception.getLineNumber(), 
				exception.getColumnNumber(),
				exception.getLocalizedMessage()
		);			
		BPELPlugin.logMessage(message, exception, IStatus.ERROR);		
		// Bugzilla 324165
		// add the error to resource
		if (fCurrentResource!=null)
			fCurrentResource.getErrors().add(new SAXParseDiagnostic(exception, SAXParseDiagnostic.ERROR));
	}

	/**
	 * @see org.xml.sax.ErrorHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	@SuppressWarnings("boxing")
	public void fatalError(SAXParseException exception)  {
		String message = java.text.MessageFormat.format(
				"Fatal Error in {0} [{2}:{3}] {4}",				
				exception.getPublicId(),
				exception.getSystemId(),
				exception.getLineNumber(), 
				exception.getColumnNumber(),
				exception.getLocalizedMessage()
		);			
		BPELPlugin.logMessage(message, exception, IStatus.ERROR);
		// Bugzilla 324165
		// add the error to resource
		if (fCurrentResource!=null)
			fCurrentResource.getErrors().add(new SAXParseDiagnostic(exception, SAXParseDiagnostic.FATAL_ERROR));
	}

	/**
	 * @see org.xml.sax.ErrorHandler#warning(org.xml.sax.SAXParseException)
	 */
	@SuppressWarnings("boxing")
	public void warning (SAXParseException exception)  {
		String message = java.text.MessageFormat.format(
				"Warning in {0} [{2}:{3}] {4}",				
				exception.getPublicId(),
				exception.getSystemId(),
				exception.getLineNumber(), 
				exception.getColumnNumber(),
				exception.getLocalizedMessage()
		);			
		BPELPlugin.logMessage(message, exception, IStatus.WARNING);		

		
		// Bugzilla 324165
		// add the error to resource
		if (fCurrentResource!=null)
			fCurrentResource.getErrors().add(new SAXParseDiagnostic(exception, SAXParseDiagnostic.WARNING));
	}	
}
