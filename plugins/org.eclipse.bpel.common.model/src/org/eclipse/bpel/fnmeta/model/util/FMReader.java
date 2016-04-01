/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.fnmeta.model.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.bpel.common.extension.model.Activator;
import org.eclipse.bpel.fnmeta.model.Argument;
import org.eclipse.bpel.fnmeta.model.Assistant;
import org.eclipse.bpel.fnmeta.model.FMFactory;
import org.eclipse.bpel.fnmeta.model.Function;
import org.eclipse.bpel.fnmeta.model.Option;
import org.eclipse.bpel.fnmeta.model.Optionality;
import org.eclipse.bpel.fnmeta.model.Registry;
import org.eclipse.bpel.fnmeta.model.proxy.ArgumentProxy;
import org.eclipse.bpel.fnmeta.model.proxy.AssistantProxy;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLDefaultHandler;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 3, 2007
 *
 */

@SuppressWarnings("nls")

public class FMReader implements XMLLoad , ErrorHandler {

	List<Runnable> fPass2Runnables = new ArrayList<Runnable>();
	DocumentBuilder fBuilder;
	XMLResource fResource;
	
	
	/**
	 * @see org.eclipse.emf.ecore.xmi.XMLLoad#createDefaultHandler()
	 */
	public XMLDefaultHandler createDefaultHandler() {		
		return null;
	}
	
	/**
	 * @see org.eclipse.emf.ecore.xmi.XMLLoad#load(org.eclipse.emf.ecore.xmi.XMLResource, java.io.InputStream, java.util.Map)
	 */
	public void load (XMLResource resource, InputStream inputStream,	Map<?, ?> options)  {
		InputSource inputSource = new InputSource(inputStream);
		inputSource.setPublicId( resource.getURI().toString() );
		inputSource.setSystemId( resource.getURI().toString() );
		load (resource,inputSource,options);
	}
	
	/**
	 * @see org.eclipse.emf.ecore.xmi.XMLLoad#load(org.eclipse.emf.ecore.xmi.XMLResource, org.xml.sax.InputSource, java.util.Map)
	 */
	public void load (XMLResource resource, InputSource inputSource,	Map<?, ?> options)  {

		Element top = null;
		try {
			top = read ( inputSource );
			// After the document has successfully parsed, it's okay
			// to assign the resource.
		} catch (SAXException sax) {
			// the error handlers will catch this.			
		} catch (IOException ioe) {
			Activator.log("I/O Error Reading BPEL XML", ioe , IStatus.ERROR) ;
		} finally {
			
		}
		
		if (top == null) {
			return ;
		}
		
		load(resource,top,options);
	}

	/**
	 * @see org.eclipse.emf.ecore.xmi.XMLLoad#load(org.eclipse.emf.ecore.xmi.XMLResource, org.w3c.dom.Node, java.util.Map)
	 */
	public void load (XMLResource resource, Node node, Map<?, ?> options)  {

		if (node instanceof Element == false) {
			return ;
		}
		fResource = resource;
		
		EObject root = pass1( (Element) node);
		if (root != null) {
			resource.getContents().add(root);
		}
		pass2();		
	}
	
	 
	Element read ( InputSource inputSource ) throws IOException, SAXException {	
		if (fBuilder == null) {
			fBuilder = getDocumentBuilder();
			fBuilder.setErrorHandler(this);
		}		
		return fBuilder.parse(inputSource).getDocumentElement();
		
	}
	
	protected DocumentBuilder getDocumentBuilder() throws IOException {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException exc) {
			throw new IOException(exc.toString());
		}
		return builder;
	}
	
	
	/**
	 * In pass 1, we parse and create the structural elements and attributes,
	 * and add the process to the EMF resource's contents
	 * @param document  the DOM document to parse
	 */
	protected EObject pass1 (Element elm) {
		return xml2Resource(elm);
	}
	
	/**
	 * In pass 2, we run any post load runn ables which were queued during pass 1.
	 */
	protected void pass2() {	
		for(Runnable r : fPass2Runnables) {
			r.run();
		}
		fPass2Runnables.clear();
	}
	
	
	/**
     * Returns a list of child nodes of <code>parentElement</code> that are
     * {@link Element}s.
     * Returns an empty list if no elements are found.
     * 
	 * @param parentElement  the element to find the children of
	 * @return a node list of the children of parentElement
	 */
	protected List<Element> getChildElements (Element parentElement) {
		List<Element> list = new ArrayList<Element>();
		NodeList children = parentElement.getChildNodes();		
		for (int i=0; i < children.getLength(); i++) {
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
				list.add( (Element) children.item(i));
		}
		return list;
	}

    /**
     * 
	 * @param parentElement  the element to find the children of
	 * @param localName  the localName to match against
	 * @return a node list of the matching children of parentElement
     */
	protected List<Element> getChildElementsByLocalName(Element parentElement, String localName) {
		List<Element> list = new ArrayList<Element>();
		for(Node node = parentElement.getFirstChild(); node != null ; node = node.getNextSibling()) {
			if (localName.equals(node.getLocalName())) {
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
	protected Element getChildElementByLocalName (Element parentElement, String localName) {
		for(Node node = parentElement.getFirstChild(); node != null ; node = node.getNextSibling()) {
			if (localName.equals(node.getLocalName()) ) {
                return (Element) node;
            }
		}
		return null;
	}

	/**
	 * Converts an XML document to a BPEL Resource object.
	 */
	protected EObject xml2Resource(Element element) {
		return xml2Registry (element);
	}


	/**
	 * Converts an XML process to a BPEL Process object.
	 */
	@SuppressWarnings("nls")
	protected Registry xml2Registry(Element element) {
		if (element == null || element.getLocalName().equals("bpel-xpath-functions") == false ) {
			return null;
		}
		
		Registry registry  = FMFactory.eINSTANCE.createRegistry();
		registry.setElement(element);
					
		// Assistants
		for(Element e : getChildElementsByLocalName(element, "assistant")) {
			registry.getAssistants().add(xml2Assistant(e));
		}

		// Arguments
		for(Element e : getChildElementsByLocalName(element, "arg")) {
			registry.getArguments().add(xml2Argument(e));
		}
		// Functions
		for(Element e : getChildElementsByLocalName(element, "function")) {
			registry.getFunctions().add(xml2Function(e));
		}
		return registry;
	}
	
	/**
	 * Converts an XML partnerLinks
	 */
	protected Assistant xml2Assistant (Element element) {
		if (element == null || element.getLocalName().equals("assistant") == false) {
			return null;
		}
		
		if (element.getFirstChild() == null || element.hasAttribute("ref") ) {
			return new AssistantProxy( fResource.getURI(), element.getAttribute("ref") );
		}
		
		Assistant assistant = FMFactory.eINSTANCE.createAssistant();						
		
		for(Element e : getChildElementsByLocalName(element, "option")) {
			assistant.getOptions().add( xml2Option(e) );
		}		
		return assistant;
	}



	protected Option xml2Option (Element element) {
		if (element == null || element.getLocalName().equals("option") == false) {
			return null;
		}
			
		Option option = FMFactory.eINSTANCE.createOption();		
		option.setValue( element.getAttribute("value") );
		option.setDisplayValue( getText(element) );
		
		return option;
	}
	
	@SuppressWarnings("boxing")
	protected Argument xml2Argument (Element element) {
		if (element == null || element.getLocalName().equals("arg") == false) {
			return null;
		}
		
		if (element.getFirstChild() == null || element.hasAttribute("ref") ) {
			return new ArgumentProxy(fResource.getURI(), element.getAttribute("ref") );
		}
		
		Argument arg = FMFactory.eINSTANCE.createArgument();
		arg.setElement(element);
		
		arg.setName( element.getAttribute("name") );
		arg.setType (element.getAttribute("type") );
		arg.setDefaultValue(element.getAttribute("default") );
		String opt = element.getAttribute("optional");
		
		/** By default, optionality is Optionality.REQUIRED */
		if ("true".equalsIgnoreCase(opt) || "?".equals(opt)) {
			arg.setOptionality(Optionality.OPTIONAL);
		} else if ("*".equals(opt)) {
			arg.setOptionality(Optionality.OPTIONAL_MANY);
		}
		
		arg.setAssistant( xml2Assistant( getChildElementByLocalName(element, "assistant")));
		arg.setComment( getText( getChildElementByLocalName(element, "comment")));
		
		return arg;
	}
	
	@SuppressWarnings("boxing")
	protected Function xml2Function (Element element) {
		if (element == null || element.getLocalName().equals("function") == false) {
			return null;
		}
			
		Function function = FMFactory.eINSTANCE.createFunction();
		function.setElement(element);
		
		function.setName( element.getAttribute("id"));
		function.setReturnType(element.getAttribute("returns"));
		function.setHelp( getText( getChildElementByLocalName(element, "help")) );
		function.setComment( getText( getChildElementByLocalName(element, "comment")) ); 
		
		function.setClassName( element.getAttribute("class"));
		
		Element dep = getChildElementByLocalName(element,"deprecated");
		
		if (dep != null) {
			function.setIsDeprecated( false );
			function.setDeprecateComment(getText(dep));
		}
				
		Element ns = getChildElementByLocalName(element, "namespace");
		
		if (ns != null) {
			function.setNamespace( getText(ns) );
			function.setPrefix(ns.getAttribute("prefix"));
		}
		
		for(Element a : getChildElementsByLocalName(element, "arg")) {
			function.getArguments().add( xml2Argument(a));
		}
		return function;
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
		Activator.log(message, exception, IStatus.ERROR);		
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
		Activator.log(message, exception, IStatus.ERROR);
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
		Activator.log(message, exception, IStatus.WARNING);		
	}	

}
