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
package org.eclipse.bpel.model.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.dom.AttrImpl;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Correlation;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Import;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.To;
import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.proxy.MessageProxy;
import org.eclipse.bpel.model.proxy.OperationProxy;
import org.eclipse.bpel.model.proxy.PortTypeProxy;
import org.eclipse.bpel.model.reordering.IExtensibilityElementListHandler;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.names.NCNameWordDetector;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.ExtensibleElement;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.ibm.wsdl.util.xml.DOM2Writer;
import com.ibm.wsdl.util.xml.DOMUtils;

/**
 * 
 * @author (IBM)
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 * @date Feb 27, 2007
 * 
 */

@SuppressWarnings("nls")
public class BPELUtils {

	/** Namespace attribute */
	public static final String ATTR_XMLNS = "xmlns"; //$NON-NLS-1$

	/**
	 * Lookup an externally defined object by its QName by using a ref object
	 * (any object from the BPEL EMF model) using a refType and name.
	 * 
	 * This is a general query mechanism used by the import resolvers to resolve
	 * anything from the perspective of the BPEL process.
	 * 
	 * @param ref
	 *            the reference object
	 * @param qname
	 *            the QName to resolve.
	 * @param name
	 *            the name within the QName to resolve (can be null)
	 * @param refType
	 *            the thing to look up (look in WSDLUtil and XSDUtil for the
	 *            possible values)
	 * @return the looked up object (or null).
	 */

	static public EObject lookup(EObject ref, QName qname, String name,
			String refType) {

		Process process = getProcess(ref);
		if (process == null) {
			return null;
		}

		Iterator<?> it = process.getImports().iterator();
		EObject result = null;

		while (it.hasNext()) {
			Import imp = (Import) it.next();

			// The null and "" problem ...
			String ns = imp.getNamespace();
			if (ns == null) {
				ns = javax.xml.XMLConstants.DEFAULT_NS_PREFIX;
			}

			if (ns.equals(qname.getNamespaceURI()) == false
					|| imp.getLocation() == null) {
				continue;
			}

			ImportResolver[] resolvers = ImportResolverRegistry.INSTANCE
					.getResolvers(imp.getImportType());
			for (int i = 0; i < resolvers.length; i++) {
				result = resolvers[i].resolve(imp, qname, name, refType);
				if (result != null) {
					return result;
				}
			}
		}

		return result;
	}

	/**
	 * Get name namespace associated to the prefix.
	 * 
	 * @param eObject
	 *            the reference object
	 * @param prefix
	 *            the prefix to lookup
	 * @return the namespace associated with the prefix.
	 */

	public static String getNamespace(EObject eObject, String prefix) {

		Map<String, String> prefixNSMap = null;
		EObject context = eObject;

		while (context != null) {
			prefixNSMap = getNamespaceMap(context);
			String value = prefixNSMap.get(prefix);
			if (value != null) {
				return value;
			}
			context = context.eContainer();
		}
		return null;
	}

	/**
	 * Set the namespace prefix on the EObject passed. The namespace -> prefix
	 * mapping is defined on the object passed. Note that this is different then
	 * getPrefix(), where the prefix mapping is searched via the hierarchy of
	 * the EMF model.
	 * 
	 * @param eObject
	 *            an object at which level the prefix mapping ought to be set.
	 * @param namespaceURI
	 *            namespace URI
	 * @param prefix
	 *            the prefix.
	 * @throws RuntimeException
	 *             if the prefix is already set.
	 */

	@SuppressWarnings("unchecked")
	public static void setPrefix(EObject eObject, String namespaceURI,
			String prefix) {

		INamespaceMap<String, String> prefixNSMap = getNamespaceMap(eObject);
		if (prefixNSMap.containsKey(prefix)) {
			throw new RuntimeException("Prefix is already mapped!");
		}
		prefixNSMap.put(prefix, namespaceURI);
	}

	/**
	 * Given a starting object from within our EMF model return the prefix
	 * associated with the namespace passed. The object tree is traversed up to
	 * the root to find the associated mapping and first such association is
	 * returned.
	 * 
	 * @param eObject
	 *            the EMF object to start at.
	 * @param namespace
	 *            the XML namespace to query for prefix mapping
	 * @return the prefix name or null of no mapping exists
	 */

	public static String getNamespacePrefix(EObject eObject, String namespace) {

		for (EObject context = eObject; context != null; context = context
				.eContainer()) {
			List<String> pfxList = getNamespaceMap(context).getReverse(
					namespace);
			if (pfxList.size() > 0) {
				return pfxList.get(0);
			}
		}
		return null;
	}

	/**
	 * Given a starting object from within our EMF model set the prefix
	 * associated with the namespace passed. The object tree is traversed up to
	 * the root to find the associated mapping and first such association is
	 * returned.
	 * 
	 * @param eObject
	 *            the EMF object to start at.
	 * @param namespace
	 *            the XML namespace to query for prefix mapping
	 * @param prefix
	 *            the prefix to set
	 * 
	 */

	public static void setNamespacePrefix(EObject eObject, String namespace,
			String prefix) {
		setPrefix(getNearestScopeOrProcess(eObject), namespace, prefix);
	}

	/**
	 * @param eObject
	 * @return the namespace map for the given object.
	 */

	@SuppressWarnings("unchecked")
	static public INamespaceMap<String, String> getNamespaceMap(EObject eObject) {

		if (eObject == null) {
			throw new NullPointerException(
					"eObject cannot be null in getNamespaceMap()");
		}

		INamespaceMap<String, String> nsMap = null;
    	// Bug 120110 - this eObject may not have a namespace map, but its
		// ancestors might, so keep searching until we find one or until
		// we run out of ancestors.
		while (nsMap==null && eObject!=null) {
			nsMap = AdapterRegistry.INSTANCE.adapt(
				eObject, INamespaceMap.class);
			if (nsMap==null)
				eObject = eObject.eContainer();
		}
		
		if (nsMap == null) {
			throw new IllegalStateException(
					"INamespaceMap cannot be attached to an eObject");
		}

		return nsMap;
	}

	/**
	 * Return the process object, the root of the EMF BPEL model, from the
	 * reference object passed.
	 * 
	 * @param eObj
	 *            the reference object.
	 * @return the process object, or null
	 */
	public static Process getProcess(Object object) {
		if (object instanceof EObject) {
			// check if *this* is already the process object
			if (object instanceof Process)
				return (Process)object;
			EObject cont = ((EObject)object).eContainer();
			while (cont != null) {
				if (cont.eClass() == BPELPackage.eINSTANCE.getProcess())
					return (Process)cont;
				cont = cont.eContainer();
			}
		}
		return null;
	}

	/**
	 * Return the closest Scope or Process objects from the EMF object
	 * hierarchy. We use this code to assign namespace prefix mappings when they
	 * don't exist.
	 * 
	 * @param eObject
	 * @return closest scope or process object.
	 */

	public static EObject getNearestScopeOrProcess(EObject eObject) {

		EObject context = eObject;
		while (context != null) {
			if (context instanceof Scope) {
				return context;
			}
			if (context instanceof Process) {
				return context;
			}
			context = context.eContainer();
		}
		return null;
	}

	/**
	 * Return all global and local namespaces of this context
	 * 
	 * @param eObject
	 *            reference object
	 * @return the prefix map.
	 */

	public static Map<String, String> getAllNamespacesForContext(EObject eObject) {
		Map<String, String> nsMap = new HashMap<String, String>();
		EObject context = eObject;

		while (context != null) {
			Map<String, String> localNSMap = getNamespaceMap(context);
			for (Entry<String, String> entry : localNSMap.entrySet()) {
				if (!nsMap.containsKey(entry.getKey())) {
					nsMap.put(entry.getKey(), entry.getValue());
				}
			}
			context = context.eContainer();
		}
		return nsMap;
	}

	/**
	 * Reorder extensibility list.
	 * 
	 * @param extensibilityElementListHandlers
	 * @param parent
	 * @return the reordered list.
	 */
	@SuppressWarnings("unchecked")
	public static List<ExtensibleElement> reorderExtensibilityList(
			List<IExtensibilityElementListHandler> extensibilityElementListHandlers,
			ExtensibleElement parent) {

		List<ExtensibleElement> tempExtensibilityElementList = new ArrayList<ExtensibleElement>();
		tempExtensibilityElementList.addAll(parent.getExtensibilityElements());

		if (extensibilityElementListHandlers.isEmpty()
				|| parent.getExtensibilityElements() == null
				|| parent.getExtensibilityElements().size() <= 1)
			return tempExtensibilityElementList;

		for (IExtensibilityElementListHandler element : extensibilityElementListHandlers) {
			element.orderList(parent, tempExtensibilityElementList);
		}

		return tempExtensibilityElementList;
	}

	/**
	 * Convert string to a BPEL DOM node.
	 * 
	 * @param s
	 *            the string
	 * @param bpelResource
	 *            the BPEL resource
	 * @return the node
	 */

	public static Node convertStringToNode(EObject parent, String s, BPELResource bpelResource) {
		// Create DOM document
		DocumentBuilderFactory factory = new DocumentBuilderFactoryImpl();
		factory.setNamespaceAware(true);
		factory.setValidating(false);

		StringBuilder namespaces = new StringBuilder();
		Map<String, String> nsMap = getAllNamespacesForContext(parent);		
		for (Entry<String, String> e : nsMap.entrySet()) {
			String prefix = e.getKey();
			String value = e.getValue();
			if (BPELConstants.isBPELNamespace(value)) {
				continue;
			}
			if (prefix != "") {
				namespaces.append("xmlns:");
				namespaces.append(prefix);
			} else {
				namespaces.append("xmlns");
			}
			namespaces.append("=\"");
			namespaces.append(value);
			namespaces.append("\" ");
		}		
		
		String namespaceURI = bpelResource.getNamespaceURI();
		if (bpelResource.getOptionUseNSPrefix()) {
			String prefix = "bpws";
			s = "<" + prefix + ":from xmlns:" + prefix + "=\"" + namespaceURI + "\" "
					+ namespaces.toString() + ">" + s + "</" + prefix + ":from>";
		} else {
			s = "<from xmlns=\"" + namespaceURI + "\" " + namespaces.toString() + ">" + s + "</from>";
		}

		try {
			StringReader sr = new StringReader(s);
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource source = new InputSource(sr);
			source.setEncoding("UTF8");
			Document document = builder.parse(source);
			return document.getDocumentElement();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Convert an element to string.
	 * 
	 * @param element
	 *            the element
	 * @return string version of the element XML source
	 */

	public static String elementToString(Element element) {
		StringWriter writer = new StringWriter();
		DOM2Writer.serializeAsXML(element, writer);
		return writer.getBuffer().toString();
	}

	/**
	 * Create attribute value.
	 * 
	 * @param element
	 * @param attribute
	 * @return QName for the attribute value.
	 */

	public static QName createAttributeValue(Element element, String attribute) {
		String prefixedValue = element.getAttribute(attribute);
		return createQName(element, prefixedValue);
	}

	/**
	 * Create QName
	 * 
	 * @param element
	 *            the element used as a reference for namespace reference.
	 * @param prefixedValue
	 *            the prefixed value (NCName as a QName, that is "foo:bar")
	 * @return the QName created
	 */

	public static QName createQName(Element element, String prefixedValue) {
		int index = prefixedValue.indexOf(':');
		String prefix = (index != -1) ? prefixedValue.substring(0, index)
				: null;
		String localPart = prefixedValue.substring(index + 1);
		String namespaceURI = DOMUtils.getNamespaceURIFromPrefix(element,
				prefix);

		// namespaceURI may be null. That's okay.
		// Bugzilla 320654
		if (prefix==null)
			return new QName(namespaceURI, localPart);
		return new QName(namespaceURI, localPart, prefix);
	}

	/**
	 * Return a partner link whose name is partnerLinkName.
	 * 
	 * @param eObject
	 *            the reference object
	 * @param partnerLinkName
	 *            the partner link name.
	 * @return the PartnerLink or null if one does not exist.
	 */

	public static PartnerLink getPartnerLink(EObject eObject,
			String partnerLinkName) {

		EObject container = eObject;

		while (container != null) {

			PartnerLinks partnerLinks = null;

			if (container instanceof Process) {
				partnerLinks = ((Process) container).getPartnerLinks();
			} else if (container instanceof Scope) {
				partnerLinks = ((Scope) container).getPartnerLinks();
			}

			if (partnerLinks != null) {
				for (PartnerLink pl : partnerLinks.getChildren()) {
					if (pl.getName().equals(partnerLinkName)) {
						return pl;
					}
				}
			}

			container = container.eContainer();
		}
		return null;
	}

	/**
	 * Return a message exchange whose name is messageExchangeName.
	 * 
	 * @param eObject
	 *            the reference object
	 * @param messageExchangeName
	 *            the message exchange name.
	 * @return the MessageExchange or null if one does not exist.
	 */

	public static MessageExchange getMessageExchange(EObject eObject,
			String messageExchangeName) {

		EObject container = eObject;

		while (container != null) {

			MessageExchanges messageExchanges = null;

			if (container instanceof Process) {
				messageExchanges = ((Process) container).getMessageExchanges();
			} else if (container instanceof Scope) {
				messageExchanges = ((Scope) container).getMessageExchanges();
			}

			if (messageExchanges != null) {
				for (MessageExchange me : messageExchanges.getChildren()) {
					if (me.getName().equals(messageExchangeName)) {
						return me;
					}
				}
			}
			container = container.eContainer();
		}
		return null;
	}

	/**
	 * Get the correlation set for an activity.
	 * 
	 * @param correlation
	 *            the correlation object
	 * @param correlationSetName
	 *            the name of the correlation set
	 * @return the correlation set for that activity.
	 */

	public static CorrelationSet getCorrelationSetForActivity(
			Correlation correlation, String correlationSetName) {
		EObject container = correlation.eContainer();

		while (container != null) {
			CorrelationSets correlationSets = null;
			if (container instanceof Process) {
				correlationSets = ((Process) container).getCorrelationSets();
			} else if (container instanceof Scope) {
				correlationSets = ((Scope) container).getCorrelationSets();
			} else if (container instanceof OnEvent) {
				correlationSets = ((OnEvent) container).getCorrelationSets();
			}

			if (correlationSets != null) {
				for (CorrelationSet correlationSet : correlationSets
						.getChildren()) {
					if (correlationSet.getName().equals(correlationSetName)) {
						return correlationSet;
					}
				}
			}
			container = container.eContainer();
		}
		return null;
	}

	/**
	 * Map default namespace attribute "xmlns" to the empty key "" in the
	 * prefix-to-namespace map.
	 * 
	 * @param attrName
	 *            attribute name
	 * @return the prefix map key
	 */
	public static final String getNSPrefixMapKey(final String attrName) {
		return ATTR_XMLNS.equals(attrName) ? "" : attrName;
	}

	/**
	 * Return a port type proxy for the given URI.
	 * 
	 * @param uri
	 *            the URI
	 * @param activityElement
	 *            the reference element for namespace lookups
	 * @param qnameAttribute
	 *            the QName (as string) representing the portType.
	 * @return the port type proxy.
	 */

	public static PortType getPortType(URI uri, Element activityElement,
			String qnameAttribute) {
		QName qName = createAttributeValue(activityElement, qnameAttribute);
		PortTypeProxy portType = new PortTypeProxy(uri, qName);
		return portType;
	}

	/**
	 * Return the message proxy for the given URI object.
	 * 
	 * @param uri
	 *            the URI
	 * @param activityElement
	 *            the reference element for namespace lookups
	 * @param qnameAttribute
	 *            the QName (as string) representing the message.
	 * @return the message proxy.
	 */

	public static Message getMessage(URI uri, Element activityElement,
			String qnameAttribute) {
		QName qName = createAttributeValue(activityElement, qnameAttribute);
		MessageProxy message = new MessageProxy(uri, qName);
		return message;
	}

	/**
	 * Return the operation proxy for the given URI object.
	 * 
	 * @param uri
	 *            the URI
	 * @param portType
	 *            the port type that has this operation.
	 * @param activityElement
	 *            the reference element for namespace lookups
	 * @param operationAttribute
	 *            the QName (as string) representing the operation.
	 * @return the message proxy.
	 */

	public static Operation getOperation(URI uri, PortType portType,
			Element activityElement, String operationAttribute) {
		if (!activityElement.hasAttribute(operationAttribute))
			return null;
		String operationSignature = activityElement
				.getAttribute(operationAttribute);
		Operation operation = new OperationProxy(uri, portType,
				operationSignature);
		return operation;
	}

	/**
	 * Tests if <code>node</code> is a DOM {@link Element} with a BPEL
	 * namespace.
	 * 
	 * @param node
	 *            the node to test
	 * @return true if BPEL element, false otherwise.
	 */

	public static final boolean isBPELElement(Node node) {
		return node != null && node.getNodeType() == Node.ELEMENT_NODE
				&& BPELConstants.isBPELNamespace(node.getNamespaceURI());
	}

	/**
	 * Boolean as XML version string.
	 * 
	 * @param b
	 *            boolean (true/false)
	 * @return "yes" or "no"
	 */

	public static String boolean2XML(Boolean b) {
		if (b == null || b.equals(Boolean.FALSE)) {
			return "no";
		}
		return "yes";
	}

	/**
	 * Boolean as XML version string.
	 * 
	 * @param b
	 *            boolean (true/false)
	 * @return "yes" or "no"
	 */

	public static String boolean2XML(boolean b) {
		if (!b) {
			return "no";
		}
		return "yes";
	}

	public static boolean xml2boolean(String xml) {
		return "yes".equals(xml);
	}

	/**
	 * Create CData section with the string value indicated.
	 * 
	 * @param document
	 * @param value
	 * @return the CData section.
	 */

	public static CDATASection createCDATASection(Document document,
			String value) {
		return document.createCDATASection(stripExtraCR(value));
	}

	/**
	 * Strip extra carriage returns.
	 * 
	 * @param value
	 * @return the "pretty" string
	 */

	public static String stripExtraCR(String value) {
		if (value == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			result.append(chars[i]);
			if (i < chars.length - 1) {
				if (chars[i] == '\r' && chars[i + 1] == '\n')
					i++;
			}
		}

		return result.toString();
	}

	/**
	 * This is a slightly hacked resource set that we will be using for to solve
	 * the problem of loading the right resources from URLs that betray no
	 * information on the type of the resource.
	 * 
	 * @param resourceSet
	 * 
	 * @return the BPELResourceSetImpl that walks around the problem indicated.
	 * 
	 */

	public static BPELResourceSetImpl slightlyHackedResourceSet(
			ResourceSet resourceSet) {

		if (resourceSet instanceof BPELResourceSetImpl) {
			return (BPELResourceSetImpl) resourceSet;
		}

		Map<Object, Object> map = resourceSet.getLoadOptions();
		BPELResourceSetImpl result = (BPELResourceSetImpl) map
				.get(BPELResourceSetImpl.SLIGHTLY_HACKED_KEY);
		if (result == null) {
			result = new BPELResourceSetImpl();
			map.put(BPELResourceSetImpl.SLIGHTLY_HACKED_KEY, result);
		}
		return result;
	}

	/**
	 * Return the resource set that we should be using to load "specific" type
	 * of resources. The "slightlyHacked" resource set is kept in the load
	 * options map.
	 * 
	 * @param eObj
	 * @return the slightly hacked resource set.
	 * 
	 */
	public static BPELResourceSetImpl slightlyHackedResourceSet(EObject eObj) {
		return slightlyHackedResourceSet(eObj.eResource().getResourceSet());
	}

	static Map<String, Locale> string2Locale = new HashMap<String, Locale>();
	static Map<Locale, String> locale2String = new HashMap<Locale, String>();

	static {
		StringBuilder sb = new StringBuilder();
		for (Locale l : Locale.getAvailableLocales()) {
			sb.setLength(0);
			sb.append(l.getLanguage());
			if (isEmptyOrWhitespace(l.getCountry()) == false) {
				sb.append("-").append(l.getCountry());
			}

			String key = sb.toString().toLowerCase();

			string2Locale.put(key, l);
			locale2String.put(l, key);
		}
	}

	/**
	 * Lookup the locale for the key.
	 * 
	 * @param key
	 *            the key (language + country code)
	 * @return the locale or the default locale.
	 */

	public static Locale lookupLocaleFor(String key) {
		if (key == null) {
			return Locale.getDefault();
		}
		key = key.replace('_', '-').toLowerCase();
		Locale locale = string2Locale.get(key);
		if (locale == null) {
			locale = Locale.getDefault();
		}
		return locale;
	}

	/**
	 * Lookup the key for the locale.
	 * 
	 * @param locale
	 *            the locale
	 * @return the key associated with it.
	 */

	public static String lookupLocaleKeyFor(Locale locale) {
		if (locale == null) {
			return locale2String.get(Locale.getDefault());
		}
		String key = locale2String.get(locale);
		if (key == null) {
			key = locale2String.get(Locale.getDefault());
		}
		return key;
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

	static NCNameWordDetector NCNAME_DETECTOR = new NCNameWordDetector();

	/**
	 * Checks for a valid prefix name.
	 * 
	 * @param pfx
	 * @return true if valid, false if not.
	 */

	public static boolean isValidPrefixName(String pfx) {

		if (pfx == null) {
			return false;
		}

		if (NCNAME_DETECTOR.isValid(pfx) == false) {
			return false;
		}

		/** Must not start with (x|X)(m|M)(l|L) */

		return true;
	}

	public static boolean isTransparent(Object parent, Object child) {
		return (child instanceof FaultHandler && parent instanceof Invoke)
				|| (child instanceof Expression && parent instanceof From)
				|| (child instanceof Expression && parent instanceof To);
	}
	
	public static boolean isActivityNode(Node node) {
		String name = node.getLocalName();
		return isBPELElement(node) && 
			   (BPELConstants.ND_INVOKE.equals(name) ||
			   BPELConstants.ND_ASSIGN.equals(name) ||
			   BPELConstants.ND_WHILE.equals(name) ||
			   BPELConstants.ND_REPEAT_UNTIL.equals(name) ||
			   BPELConstants.ND_RECEIVE.equals(name) ||
			   BPELConstants.ND_REPLY.equals(name) ||
			   BPELConstants.ND_THROW.equals(name) ||
			   BPELConstants.ND_WAIT.equals(name) ||
			   BPELConstants.ND_SEQUENCE.equals(name) ||
			   BPELConstants.ND_PICK.equals(name) ||
			   BPELConstants.ND_FLOW.equals(name) ||
			   BPELConstants.ND_SCOPE.equals(name) ||
			   BPELConstants.ND_COMPENSATE.equals(name) ||
			   BPELConstants.ND_RETHROW.equals(name) ||
			   BPELConstants.ND_EXIT.equals(name) ||
			   BPELConstants.ND_EXTENSION_ACTIVITY.equals(name) ||
			   BPELConstants.ND_INVOKE.equals(name) ||
			   BPELConstants.ND_FOR_EACH.equals(name) ||
			   BPELConstants.ND_IF.equals(name) ||
			   BPELConstants.ND_VALIDATE.equals(name) ||
			   BPELConstants.ND_COMPENSATE_SCOPE.equals(name) ||
			   BPELConstants.ND_EMPTY.equals(name) ||
			   BPELConstants.ND_OPAQUEACTIVITY.equals(name));
			
	}

	// TODO: (DU) This is here due to
	// https://issues.apache.org/jira/browse/XERCESJ-1289
	public static void copyInto(Node src, Node dest) throws DOMException {

		// get node factory
		Document factory = dest.getOwnerDocument();
		boolean domimpl = factory instanceof DocumentImpl;

		// placement variables
		Node start = src;
		Node parent = src;
		Node place = src;

		// traverse source tree
		while (place != null) {

			// copy this node
			Node node = null;
			int type = place.getNodeType();
			switch (type) {
			case Node.CDATA_SECTION_NODE: {
				node = factory.createCDATASection(place.getNodeValue());
				break;
			}
			case Node.COMMENT_NODE: {
				node = factory.createComment(place.getNodeValue());
				break;
			}
			case Node.ELEMENT_NODE: {
				Element element = factory.createElement(place.getNodeName());
				node = element;
				NamedNodeMap attrs = place.getAttributes();
				int attrCount = attrs.getLength();
				for (int i = 0; i < attrCount; i++) {
					Attr attr = (Attr) attrs.item(i);
					String attrName = attr.getNodeName();
					String attrValue = attr.getNodeValue();
					element.setAttribute(attrName, attrValue);
					if (domimpl && !attr.getSpecified()) {
						((AttrImpl) element.getAttributeNode(attrName))
								.setSpecified(false);
					}
				}
				break;
			}
			case Node.ENTITY_REFERENCE_NODE: {
				node = factory.createEntityReference(place.getNodeName());
				break;
			}
			case Node.PROCESSING_INSTRUCTION_NODE: {
				node = factory.createProcessingInstruction(place.getNodeName(),
						place.getNodeValue());
				break;
			}
			case Node.TEXT_NODE: {
				node = factory.createTextNode(place.getNodeValue());
				break;
			}
			default: {
				throw new IllegalArgumentException("can't copy node type, "
						+ type + " (" + place.getNodeName() + ')');
			}
			}
			dest.appendChild(node);

			// iterate over children
			if (place.hasChildNodes()) {
				parent = place;
				place = place.getFirstChild();
				dest = node;
			}

			// advance
			else if (place != start) {
				place = place.getNextSibling();
				while (place == null && parent != start) {
					place = parent.getNextSibling();
					parent = parent.getParentNode();
					dest = dest.getParentNode();
				}
			} else {
				place = null;
			}

		}

	} // copyInto(Node,Node)

	// https://issues.jboss.org/browse/JBIDE-8068
	public static boolean isAbstractProcess(Process process)
	{
		Map<String,String>m = BPELUtils.getAllNamespacesForContext(process);
		boolean result = m.containsValue(BPELConstants.NAMESPACE_ABSTRACT_2007);
		return result;
	}
}
