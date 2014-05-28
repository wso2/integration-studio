/*******************************************************************************
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
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.util.DOMUtil;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
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
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
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
import org.eclipse.bpel.model.Validate;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.bpel.model.Wait;
import org.eclipse.bpel.model.While;
import org.eclipse.bpel.model.adapters.INamespaceMap;
import org.eclipse.bpel.model.extensions.BPELActivitySerializer;
import org.eclipse.bpel.model.extensions.BPELExtensionRegistry;
import org.eclipse.bpel.model.extensions.BPELExtensionSerializer;
import org.eclipse.bpel.model.extensions.ServiceReferenceSerializer;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.proxy.IBPELServicesProxy;
import org.eclipse.bpel.model.reordering.IExtensibilityElementListHandler;
import org.eclipse.bpel.model.reordering.extensions.ExtensionFactory;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELServicesUtility;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.util.WSDLConstants;
import org.eclipse.wst.wsdl.util.WSDLResourceImpl;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDNamedComponent;
import org.eclipse.xsd.XSDTypeDefinition;
import org.eclipse.xsd.util.XSDConstants;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.eclipse.bpel.model.FailureHandling;
import org.eclipse.bpel.model.FaultOnFailure;
import org.eclipse.bpel.model.RetryDelay;
import org.eclipse.bpel.model.RetryFor;

/**
 * BPELWriter is responsible for serializing the BPEL EMF model to an output stream.
 */
@SuppressWarnings("nls")
public class BPELWriter {

	/**
	 * Prevents the BPEL writer from searching and adding automatically import declarations.
	 * <p>
	 * This option was added because the BPEL writer performs some actions that are
	 * not natural with a pure EMF approach. Using this option in the EMF serialization
	 * allows to by-pass these actions for the automatic resolution of imports.
	 * </p>
	 */
	public static final String SKIP_AUTO_IMPORT = "bpel.skip.auto.import";

	static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private Document document = null;
	private BPELResource fBPELResource = null;
	private WsdlImportsManager wsdlNamespacePrefixManager;
	// private NamespacePrefixManager bpelNamespacePrefixManager;
	private List<IExtensibilityElementListHandler> extensibilityElementListHandlers = null;
	protected BPELPackage bpelPackage = null;

	private final BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry
			.getInstance();

	/**
	 * WsdlImportsManager is responsible for ensuring that, for a given
	 * namespace and resource uri, an import exists in the bpel file.
	 */
	class WsdlImportsManager {

		Process fProcessContext;

		// Map of resource URIs to namespaces
		private final Map<String, String> fResourceNamespaceMap;

		/**
		 * @param context
		 */
		WsdlImportsManager(Process process) {

			this.fProcessContext = process;

			this.fResourceNamespaceMap = new HashMap<String, String>();

			// For each existing import in the process, add it to the namespace
			// map.
			for (Object next : this.fProcessContext.getImports()) {
				Import imp = (org.eclipse.bpel.model.Import) next;
				if (imp.getLocation() == null) {
					System.err.println("Import location is unexpectedly null: "
							+ imp);
				} else {
					URI locationURI = URI.createURI(imp.getLocation());
					String importPath = locationURI.resolve(
							getResource().getURI()).toString();

					this.fResourceNamespaceMap.put(importPath, imp.getNamespace());
				}
			}
		}

		/**
		 * Ensure that there exists an import mapping the given namespace to the
		 * given resource. If the import doesn't exist in our map, add it to the
		 * map and create a new Import in the process.
		 *
		 * @param resource
		 * @param namespace
		 */

		void ensureImported(Resource resource, String namespace) {

			// For service references. If the declaration comes from the
			// bpel xsd, bail out.
			if (BPELConstants.NAMESPACE.equals(namespace)) {
				return;
			}

			String key = resource.getURI().toString();

			if (this.fResourceNamespaceMap.containsKey(key)) {
				return;
			}
			// second check to ensure the calculated path is not empty
			String locationURI = getRelativeLocation(resource.getURI());
			if (locationURI != null && locationURI.length() != 0) {

				// Create and add the import to the process
				org.eclipse.bpel.model.Import _import = BPELFactory.eINSTANCE
						.createImport();

				_import.setNamespace(namespace);
				_import.setLocation(locationURI);

				if (resource instanceof WSDLResourceImpl) {
					_import.setImportType(WSDLConstants.WSDL_NAMESPACE_URI);
				} else if (resource instanceof XSDResourceImpl) {
					_import
							.setImportType(XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001);
				}

				this.fProcessContext.getImports().add(_import);

				// Add it to our namespace map for easy reference
				this.fResourceNamespaceMap.put(key, namespace);
			}
		}

		/**
		 * Helper method. Return the relative location of the given file uri,
		 * relative to the location of the BPEL file.
		 */
		String getRelativeLocation(URI importedFileUri) {
			URI relativeURI = importedFileUri.deresolve(getResourceURI(), true,
					true, false);
			return relativeURI.toString();
		}

		URI getResourceURI() {
			return getResource().getURI();
		}
	}

	public BPELWriter() {
	}

	public BPELWriter(BPELResource resource, Document document) {
		this();
		this.fBPELResource = resource;
		this.document = document;
		// bpelNamespacePrefixManager = new NamespacePrefixManager(resource);
	}

	/**
	 * Return the resource used in this writer.
	 *
	 * @return the resource used in this writer.
	 */

	public BPELResource getResource() {
		return this.fBPELResource;
	}

	/**
	 * Convert the BPEL model to an XML DOM model and then write the DOM model
	 * to the output stream.
	 *
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doSave(OutputStream,
	 *      Map)
	 */
	public void write(BPELResource resource, OutputStream out, Map<?, ?> args)
			throws IOException {

		try {
			// Create a DOM document.

			final DocumentBuilderFactory documentBuilderFactory =
			// DocumentBuilderFactory.newInstance();
			// new org.apache.crimson.jaxp.DocumentBuilderFactoryImpl();
			new org.apache.xerces.jaxp.DocumentBuilderFactoryImpl();

			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setValidating(false);
			DocumentBuilder builder = documentBuilderFactory
					.newDocumentBuilder();
			this.document = builder.newDocument();

			// Transform the EMF model to the DOM document.

			this.bpelPackage = BPELPackage.eINSTANCE;

			this.fBPELResource = resource;

			Process process = resource.getProcess();

			// bpelNamespacePrefixManager = new NamespacePrefixManager( resource
			// );
			this.wsdlNamespacePrefixManager = new WsdlImportsManager(process);

			// VZ: do not force auto imports
			Boolean skipAutoImport = (Boolean) args.get( SKIP_AUTO_IMPORT );
			if( skipAutoImport == null || ! skipAutoImport )
				walkExternalReferences();
			// VZ

			this.document = resource2XML(resource);

			// Transform the DOM document to its serialized form.

			OutputFormat fmt = new OutputFormat(this.document);
			fmt.setIndenting(true);
			fmt.setIndent(4);

			XMLSerializer serializer = new XMLSerializer(out, fmt);
			serializer.serialize(this.document);

			// The code below does not indent, due to bug in JDK 1.5. Read it
			// here.
			// http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=5064280

			//
			// TransformerFactory transformerFactory =
			// TransformerFactory.newInstance();
			// Transformer transformer = transformerFactory.newTransformer();
			//
			//
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			//
			// // Unless a width is set, there will be only line breaks but no
			// indentation.
			// // The IBM JDK and the Sun JDK don't agree on the property name,
			// // so we set them both.
			// //
			// transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount",
			// "2");
			// transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
			// "2");
			// // TODO Do we need to support different encodings?
			// // if (encoding != null)
			// // {
			// // transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
			// // }
			//
			// transformer.transform(new DOMSource(document), new
			// StreamResult(out));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Convert the BPEL model to an XML DOM model and then write the DOM model
	 * to the output stream.
	 *
	 * @param eObj
	 * @return
	 *
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doSave(OutputStream,
	 *      Map)
	 */
	public String toXML(EObject eObj) {

		// Create a DOM document.

		final DocumentBuilderFactory documentBuilderFactory =
		// DocumentBuilderFactory.newInstance();
		// new org.apache.crimson.jaxp.DocumentBuilderFactoryImpl();
		new org.apache.xerces.jaxp.DocumentBuilderFactoryImpl();

		documentBuilderFactory.setNamespaceAware(true);
		documentBuilderFactory.setValidating(false);
		DocumentBuilder builder = null;
		try {
			builder = documentBuilderFactory.newDocumentBuilder();
		} catch (Exception ex) {
			return EMPTY_STRING;
		}
		this.document = builder.newDocument();

		// Transform the EMF model to the DOM document.

		this.bpelPackage = BPELPackage.eINSTANCE;

		// bpelNamespacePrefixManager = new NamespacePrefixManager(
		// getResource() );
		if (eObj instanceof Process) {
			this.wsdlNamespacePrefixManager = new WsdlImportsManager((Process) eObj);
		} else {
			this.wsdlNamespacePrefixManager = null;
		}

		anyBPELObject2xml(eObj);

		// Transform the DOM document to its serialized form.

		OutputFormat fmt = new OutputFormat(this.document);
		fmt.setIndenting(true);
		fmt.setIndent(4);
		fmt.setOmitDocumentType(true);
		fmt.setOmitXMLDeclaration(true);

		StringWriter out = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(out, fmt);

		try {
			serializer.serialize(this.document);
		} catch (Exception ex) {
			//
		}

		return out.toString();
	}

	protected Document anyBPELObject2xml(EObject eObj) {

		Element element = anyObject2xml(eObj);
		this.document.appendChild(element);
		serializePrefixes(eObj, element);

		return this.document;
	}

	protected Element anyObject2xml(EObject eObj) {

		String methodName = eObj.eClass().getName();
		methodName = Character.toLowerCase(methodName.charAt(0))
				+ methodName.substring(1) + "2XML";

		Method serializeMethod = lookupMethod(getClass(), methodName,
				EObject.class);

		if (serializeMethod == null) {
			throw new IllegalArgumentException("No serialize method "
					+ methodName);
		}

		Class<?> paramClazz = serializeMethod.getParameterTypes()[0];
		try {
			return (Element) serializeMethod
					.invoke(this, paramClazz.cast(eObj));
		} catch (Throwable t) {
			t.printStackTrace();

		}
		throw new IllegalArgumentException("Cannot serialize object " + eObj);
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
				// This is reversed, on purpose.
				if (args[i].isAssignableFrom(argTypes[i]) == false) {
					continue;
				}
			}
			return m;
		}
		return lookupMethod(target.getSuperclass(), methodName, args);
	}

	protected Document resource2XML(BPELResource resource) {
		Process process = resource.getProcess();
		Element procElement = process2XML(process);
		this.document.appendChild(procElement);
		serializePrefixes(process, procElement);
		return this.document;
	}

	protected Element process2XML(Process process) {

		Element processElement = createBPELElement("process");
		if (process.getName() != null)
			processElement.setAttribute("name", process.getName());
		if (process.getTargetNamespace() != null)
			processElement.setAttribute("targetNamespace", process
					.getTargetNamespace());
		if (process.isSetSuppressJoinFailure())
			processElement.setAttribute("suppressJoinFailure", BPELUtils
					.boolean2XML(process.getSuppressJoinFailure()));
		if (process.getExitOnStandardFault() != null)
			processElement.setAttribute("exitOnStandardFault", BPELUtils
					.boolean2XML(process.getExitOnStandardFault()));
		if (process.isSetVariableAccessSerializable())
			processElement.setAttribute("variableAccessSerializable", BPELUtils
					.boolean2XML(process.getVariableAccessSerializable()));
		if (process.isSetQueryLanguage())
			processElement.setAttribute("queryLanguage", process
					.getQueryLanguage());
		if (process.isSetExpressionLanguage())
			processElement.setAttribute("expressionLanguage", process
					.getExpressionLanguage());
		if (process.isSetAbstractProcessProfile())
			processElement.setAttribute("abstractProcessProfile", process
					.getAbstractProcessProfile());


		for (Object next : process.getImports()) {
			processElement
					.appendChild(import2XML((org.eclipse.bpel.model.Import) next));
		}

		if (process.getPartnerLinks() != null
				&& !process.getPartnerLinks().getChildren().isEmpty())
			processElement.appendChild(partnerLinks2XML(process
					.getPartnerLinks()));

		if (process.getVariables() != null
				&& !process.getVariables().getChildren().isEmpty())
			processElement.appendChild(variables2XML(process.getVariables()));

		if (process.getCorrelationSets() != null
				&& !process.getCorrelationSets().getChildren().isEmpty())
			processElement.appendChild(correlationSets2XML(process
					.getCorrelationSets()));

		if (process.getExtensions() != null)
			processElement.appendChild(extensions2XML(process.getExtensions()));

		if (process.getFaultHandlers() != null)
			processElement.appendChild(faultHandlers2XML(process
					.getFaultHandlers()));

		if (process.getEventHandlers() != null)
			processElement.appendChild(eventHandler2XML(process
					.getEventHandlers()));

		if (process.getMessageExchanges() != null
				&& !process.getMessageExchanges().getChildren().isEmpty())
			processElement.appendChild(messageExchanges2XML(process
					.getMessageExchanges()));

		if (process.getActivity() != null)
			processElement.appendChild(activity2XML(process.getActivity()));

		extensibleElement2XML(process, processElement);

		return processElement;
	}

	protected void walkExternalReferences() {
		Map<?, ?> crossReferences = EcoreUtil.ExternalCrossReferencer
				.find(getResource());

		for (Object name : crossReferences.keySet()) {
EObject externalObject = (EObject) name;
String namespace = getNamespace(externalObject);
if (XSDConstants.SCHEMA_FOR_SCHEMA_URI_2001.equals(namespace)) {
		addNewRootPrefix("xsd", namespace);
} else if (namespace != null && externalObject.eResource() != null) {
		this.wsdlNamespacePrefixManager.ensureImported(externalObject
				.eResource(), namespace);
}
}
	}

	protected QName getQName(EObject object) {
		QName qname = null;

		if (object.eIsProxy() && object instanceof IBPELServicesProxy) {
			qname = ((IBPELServicesProxy) object).getQName();
		} else if (object instanceof PartnerLinkType) {
			qname = BPELServicesUtility.getQName((PartnerLinkType) object);
		} else if (object instanceof Property) {
			qname = BPELServicesUtility.getQName((Property) object);
		}

		return qname;
	}

	protected String getNamespace(EObject object) {
		String namespace = null;
		if (object instanceof IBPELServicesProxy) {
			return ((IBPELServicesProxy) object).getQName().getNamespaceURI();
		} else if (object instanceof PartnerLinkType
				|| object instanceof Property) {
			Definition def = ((org.eclipse.wst.wsdl.ExtensibilityElement) object)
					.getEnclosingDefinition();
			if (def != null) {
				namespace = def.getTargetNamespace();
			}
		} else if (object instanceof XSDNamedComponent) {
			return ((XSDNamedComponent) object).getTargetNamespace();
		} else {
			for (Iterator<?> featureIt = object.eClass().getEAllAttributes()
					.iterator(); featureIt.hasNext() && namespace == null;) {
				EAttribute attr = (EAttribute) featureIt.next();
				if (attr.getName().equals("qName")) {
					QName qName = (QName) object.eGet(attr);
					if (qName != null)
						namespace = qName.getNamespaceURI();
				}
			}
		}
		return namespace;
	}

	protected String getOperationSignature(Operation op) {
		String signature = "";
		if (op != null) {
			signature = op.getName();
		}
		return signature;
	}

	protected Element import2XML(org.eclipse.bpel.model.Import imp) {
		Element importElement = createBPELElement("import");
		if (imp.getNamespace() != null) {
			importElement.setAttribute("namespace", imp.getNamespace());
		}
		if (imp.getLocation() != null) {
			importElement.setAttribute("location", imp.getLocation());
		}
		if (imp.getImportType() != null) {
			importElement.setAttribute("importType", imp.getImportType());
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(imp, importElement);

		return importElement;
	}

	protected Element partnerLinks2XML(PartnerLinks partnerLinks) {
		// If there are no partner links then skip creating Element
		if (partnerLinks.getChildren().isEmpty())
			return null;

		Element partnerLinksElement = createBPELElement("partnerLinks");

		for (Object next : partnerLinks.getChildren()) {
			partnerLinksElement
					.appendChild(partnerLink2XML((PartnerLink) next));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(partnerLinks, partnerLinksElement);
		extensibleElement2XML(partnerLinks, partnerLinksElement);

		return partnerLinksElement;
	}

	protected Element partnerLink2XML(PartnerLink partnerLink) {
		Element partnerLinkElement = createBPELElement("partnerLink");
		if (partnerLink.getName() != null) {
			partnerLinkElement.setAttribute("name", partnerLink.getName());
		}

		if (partnerLink.isSetInitializePartnerRole())
			partnerLinkElement.setAttribute("initializePartnerRole", BPELUtils
					.boolean2XML(partnerLink.getInitializePartnerRole()));

		PartnerLinkType plt = partnerLink.getPartnerLinkType();
		if (plt != null) {
			String qnameStr = qNameToString(partnerLink, getQName(plt));
			partnerLinkElement.setAttribute("partnerLinkType", qnameStr);
			Role myRole = partnerLink.getMyRole();
			if (myRole != null) {
				partnerLinkElement.setAttribute("myRole", myRole.getName());
			}
			Role partnerRole = partnerLink.getPartnerRole();
			if (partnerRole != null) {
				partnerLinkElement.setAttribute("partnerRole", partnerRole
						.getName());
			}

		}

		// serialize local namespace prefixes to XML
		serializePrefixes(partnerLink, partnerLinkElement);
		extensibleElement2XML(partnerLink, partnerLinkElement);

		return partnerLinkElement;
	}

	protected Element variables2XML(Variables variables) {
		// If there are no variables then skip creating Element
		if (variables.getChildren().isEmpty())
			return null;

		Element variablesElement = createBPELElement("variables");

		for (Object next : variables.getChildren()) {
			Variable variable = (Variable) next;
			variablesElement.appendChild(variable2XML(variable));
		}

		extensibleElement2XML(variables, variablesElement);

		// serialize local namespace prefixes to XML
		serializePrefixes(variables, variablesElement);
		extensibleElement2XML(variables, variablesElement);

		return variablesElement;
	}

	protected Element variable2XML(Variable variable) {
		Element variableElement = createBPELElement("variable");

		if (variable.getName() != null) {
			variableElement.setAttribute("name", variable.getName());
		}

		Message msg = variable.getMessageType();
		if (msg != null) {
			variableElement.setAttribute("messageType", qNameToString(variable,
					msg.getQName()));
		}

		if (variable.getType() != null) {
			XSDTypeDefinition type = variable.getType();
			QName qname = new QName(type.getTargetNamespace(), type.getName());
			variableElement
					.setAttribute("type", qNameToString(variable, qname));
		}

		if (variable.getXSDElement() != null) {
			XSDElementDeclaration element = variable.getXSDElement();
			QName qname = new QName(element.getTargetNamespace(), element
					.getName());
			variableElement.setAttribute("element", qNameToString(variable,
					qname));
		}

		// from-spec
		From from = variable.getFrom();
		if (from != null) {
			Element fromElement = createBPELElement("from");
			from2XML(from, fromElement);
			variableElement.appendChild(fromElement);
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(variable, variableElement);
		extensibleElement2XML(variable, variableElement);

		return variableElement;
	}

	protected Element fromPart2XML(FromPart fromPart) {
		Element fromPartElement = createBPELElement("fromPart");

		if (fromPart.getPart() != null) {
			fromPartElement.setAttribute("part", fromPart.getPart().getName());
		}

		if (fromPart.getToVariable() != null) {
			fromPartElement.setAttribute("toVariable", fromPart.getToVariable()
					.getName());
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(fromPart, fromPartElement);

		return fromPartElement;
	}

	protected Element toPart2XML(ToPart toPart) {
		Element toPartElement = createBPELElement("toPart");

		if (toPart.getPart() != null) {
			toPartElement.setAttribute("part", toPart.getPart().getName());
		}

		if (toPart.getFromVariable() != null) {
			toPartElement.setAttribute("fromVariable", toPart.getFromVariable()
					.getName());
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(toPart, toPartElement);

		return toPartElement;
	}

	protected Element extensions2XML(Extensions extensions) {
		Element extensionsElement = createBPELElement("extensions");

		Iterator<?> it = extensions.getChildren().iterator();
		while (it.hasNext()) {
			Extension extension = (Extension) it.next();
			extensionsElement.appendChild(extension2XML(extension));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(extensions, extensionsElement);
		extensibleElement2XML(extensions, extensionsElement);

		return extensionsElement;
	}

	protected Element extension2XML(Extension extension) {
		Element extensionElement = createBPELElement("extension");
		if (extension.getNamespace() != null) {
			extensionElement
					.setAttribute("namespace", extension.getNamespace());
		}
		if (extension.isSetMustUnderstand()) {
			extensionElement.setAttribute("mustUnderstand", BPELUtils
					.boolean2XML(extension.getMustUnderstand()));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(extension, extensionElement);
		extensibleElement2XML(extension, extensionElement);
		return extensionElement;
	}

	protected Element correlationSets2XML(CorrelationSets correlationSets) {
		// If there are no correlation sets then skip creating Element
		if (correlationSets.getChildren().isEmpty())
			return null;

		Element correlationSetsElement = createBPELElement("correlationSets");

		Iterator<?> it = correlationSets.getChildren().iterator();
		while (it.hasNext()) {
			CorrelationSet correlationSet = (CorrelationSet) it.next();
			correlationSetsElement
					.appendChild(correlationSet2XML(correlationSet));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(correlationSets, correlationSetsElement);
		extensibleElement2XML(correlationSets, correlationSetsElement);

		return correlationSetsElement;
	}

	protected Element correlationSet2XML(CorrelationSet correlationSet) {
		Element correlationSetElement = createBPELElement("correlationSet");
		if (correlationSet.getName() != null) {
			correlationSetElement
					.setAttribute("name", correlationSet.getName());
		}
		String propertiesList = properties2XML(correlationSet);
		if (propertiesList.length() > 0) {
			correlationSetElement.setAttribute("properties", propertiesList);
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(correlationSet, correlationSetElement);
		extensibleElement2XML(correlationSet, correlationSetElement);
		return correlationSetElement;
	}

	protected String properties2XML(CorrelationSet correlationSet) {
		StringBuffer propertiesList = new StringBuffer();
		Iterator<?> properties = correlationSet.getProperties().iterator();
		while (properties.hasNext()) {
			Property property = (Property) properties.next();
			String qnameStr = qNameToString(correlationSet, getQName(property));
			propertiesList.append(qnameStr);
			if (properties.hasNext())
				propertiesList.append(" ");
		}
		return propertiesList.toString();
	}

	protected Element messageExchanges2XML(MessageExchanges messageExchanges) {
		// If there are no messageExchanges then skip creating Element
		if (messageExchanges.getChildren().isEmpty())
			return null;

		Element messageExchangesElement = createBPELElement("messageExchanges");

		for (Object next : messageExchanges.getChildren()) {
			messageExchangesElement
					.appendChild(messageExchange2XML((MessageExchange) next));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(messageExchanges, messageExchangesElement);
		extensibleElement2XML(messageExchanges, messageExchangesElement);

		return messageExchangesElement;
	}

	protected Element messageExchange2XML(MessageExchange messageExchange) {
		Element messageExchangeElement = createBPELElement("messageExchange");

		if (messageExchange.getName() != null)
			messageExchangeElement.setAttribute("name", messageExchange
					.getName());

		// serialize local namespace prefixes to XML
		serializePrefixes(messageExchange, messageExchangeElement);
		extensibleElement2XML(messageExchange, messageExchangeElement);

		return messageExchangeElement;
	}

	protected Element fromParts2XML(FromParts fromParts) {
		Element fromPartsElement = createBPELElement("fromParts");

		for (Object next : fromParts.getChildren()) {
			FromPart fromPart = (FromPart) next;
			fromPartsElement.appendChild(fromPart2XML(fromPart));
		}

		extensibleElement2XML(fromParts, fromPartsElement);

		// serialize local namespace prefixes to XML
		serializePrefixes(fromParts, fromPartsElement);
		extensibleElement2XML(fromParts, fromPartsElement);

		return fromPartsElement;
	}

	protected Element toParts2XML(ToParts toParts) {
		Element toPartsElement = createBPELElement("toParts");

		for (Object next : toParts.getChildren()) {
			ToPart toPart = (ToPart) next;
			toPartsElement.appendChild(toPart2XML(toPart));
		}

		extensibleElement2XML(toParts, toPartsElement);

		// serialize local namespace prefixes to XML
		serializePrefixes(toParts, toPartsElement);
		extensibleElement2XML(toParts, toPartsElement);

		return toPartsElement;
	}


	/**
	 * for failureHandling extension provided by ODE: JIRA:TOOLS-785
	 * 
	 */
	
	protected Element failureHandling2XML(FailureHandling  failureHandling ) {
		Element failureHandlingElement = createElementWithTag(
				BPELConstants.NAMESPACE_FAILURE_HANDLING_URL,
				BPELConstants.NAMESPACE_FAILURE_HANDLING_PREFIX,
				BPELConstants.NODE_FAILURE_HANDLING);

		//FaultOnFailure
		FaultOnFailure faultOnFailure = failureHandling.getFaultOnFailure();
		if (faultOnFailure != null) {
			// Creating Element with ext nameSpace;
			Element faultOnFailureElement = document.createElement(BPELConstants.NODE_FAULT_ON_FAILURE);
			faultOnFailure2XML(faultOnFailure, faultOnFailureElement);
			failureHandlingElement.appendChild(faultOnFailureElement);
		}
		
		//retryFor
		RetryFor retryFor = failureHandling.getRetryFor();
		if (retryFor != null) {
			// Creating Element with ext nameSpace;
			Element retryForElement = document.createElement(BPELConstants.NODE_RETRY_FOR);
			retryFor2XML(retryFor, retryForElement);
			failureHandlingElement.appendChild(retryForElement);
		}
		
		//retryFor
		RetryDelay retryDelay = failureHandling.getRetryDelay();
		if (retryDelay != null) {
			// Creating Element with ext nameSpace;
			Element retryDelayElement = document.createElement(BPELConstants.NODE_RETRY_DELAY);
			retryDelay2XML(retryDelay, retryDelayElement);
			failureHandlingElement.appendChild(retryDelayElement);
		}
		
		// serialize local namespace prefixes to XML
		failureHandlingElement.setAttributeNS(XSDConstants.XMLNS_URI_2000,
					"xmlns:" + BPELConstants.NAMESPACE_FAILURE_HANDLING_PREFIX
					, BPELConstants.NAMESPACE_FAILURE_HANDLING_URL);
		
		//extensibleElement2XML(eao, ecoElement);
		
		return failureHandlingElement;
		
	}

	protected Element faultOnFailure2XML(FaultOnFailure faultOnFailure, Element faultOnFailureElement)
	{
		// adding Body content.
		Boolean body = faultOnFailure.isValue();
		CDATASection cdata = BPELUtils.createCDATASection(document,	String.valueOf(body));
		faultOnFailureElement.appendChild(cdata);
		return faultOnFailureElement;
	}
	
	protected Element retryFor2XML(RetryFor retryFor, Element retryForElement)
	{
		// adding Body content.
		int body = retryFor.getValue();
		CDATASection cdata = BPELUtils.createCDATASection(document,	String.valueOf(body));
		retryForElement.appendChild(cdata);
		return retryForElement;
	}
	
	protected Element retryDelay2XML(RetryDelay retryDelay, Element retryDelayElement)
	{
		// adding Body content.
		int body = retryDelay.getValue();
		CDATASection cdata = BPELUtils.createCDATASection(document,	String.valueOf(body));
		retryDelayElement.appendChild(cdata);
		
		return retryDelayElement;
	}
	
	protected Element correlations2XML(Correlations correlations) {
	Element correlationsElement = createBPELElement("correlations");

		Iterator<?> it = correlations.getChildren().iterator();
		while (it.hasNext()) {
			Correlation correlation = (Correlation) it.next();
			correlationsElement.appendChild(correlation2XML(correlation));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(correlations, correlationsElement);
		extensibleElement2XML(correlations, correlationsElement);

		return correlationsElement;
	}

	protected Element correlation2XML(Correlation correlation) {
		Element correlationElement = createBPELElement("correlation");

		if (correlation.getSet() != null
				&& correlation.getSet().getName() != null)
			correlationElement.setAttribute("set", correlation.getSet()
					.getName());

		if (correlation.isSetInitiate())
			correlationElement.setAttribute("initiate", correlation
					.getInitiate());

		if (correlation.isSetPattern())
			correlationElement.setAttribute("pattern", correlation.getPattern()
					// Bugzilla 340654
					.getLiteral());

		// serialize local namespace prefixes to XML
		serializePrefixes(correlation, correlationElement);
		extensibleElement2XML(correlation, correlationElement);

		return correlationElement;
	}

	protected Element faultHandlers2XML(FaultHandler faultHandler) {
		Element faultHandlersElement = createBPELElement("faultHandlers");
		faultHandler2XML(faultHandlersElement, faultHandler);
		// serialize local namespace prefixes to XML
		serializePrefixes(faultHandler, faultHandlersElement);
		extensibleElement2XML(faultHandler, faultHandlersElement);

		return faultHandlersElement;
	}

	protected void faultHandler2XML(Element parentElement,
			FaultHandler faultHandler) {
		Iterator<?> catches = faultHandler.getCatch().iterator();
		while (catches.hasNext()) {
			Catch _catch = (Catch) catches.next();
			parentElement.appendChild(catch2XML(_catch));
		}
		if (faultHandler.getCatchAll() != null) {
			parentElement.appendChild(catchAll2XML(faultHandler.getCatchAll()));
		}
	}

	protected Element compensationHandler2XML(
			CompensationHandler compensationHandler) {
		Element compensationHandlerElement = createBPELElement("compensationHandler");

		if (compensationHandler.getActivity() != null) {
			Element activityElement = activity2XML(compensationHandler
					.getActivity());
			compensationHandlerElement.appendChild(activityElement);
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(compensationHandler, compensationHandlerElement);
		extensibleElement2XML(compensationHandler, compensationHandlerElement);
		return compensationHandlerElement;
	}

	protected Element terminationHandler2XML(
			TerminationHandler terminationHandler) {
		Element terminationHandlerElement = createBPELElement("terminationHandler");

		if (terminationHandler.getActivity() != null) {
			Element activityElement = activity2XML(terminationHandler
					.getActivity());
			terminationHandlerElement.appendChild(activityElement);
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(terminationHandler, terminationHandlerElement);
		extensibleElement2XML(terminationHandler, terminationHandlerElement);
		return terminationHandlerElement;
	}

	protected Element eventHandler2XML(EventHandler eventHandler) {
		Element eventHandlerElement = createBPELElement("eventHandlers");

		// TODO: For backwards compatibility with 1.1 we should serialize
		// OnMessages here.
		for (Object name : eventHandler.getEvents()) {
			OnEvent onEvent = (OnEvent) name;
			eventHandlerElement.appendChild(onEvent2XML(onEvent));
		}
		for (Object name : eventHandler.getAlarm()) {
			OnAlarm onAlarm = (OnAlarm) name;
			eventHandlerElement.appendChild(onAlarm2XML(onAlarm));
		}
		// serialize local namespace prefixes to XML
		serializePrefixes(eventHandler, eventHandlerElement);
		extensibleElement2XML(eventHandler, eventHandlerElement);
		return eventHandlerElement;
	}

	public Element activity2XML(Activity activity) {

		Element activityElement = null;

		if (activity instanceof ExtensionActivity)
			activityElement = extensionActivity2XML((ExtensionActivity) activity);
		else if (activity instanceof Empty)
			activityElement = empty2XML((Empty) activity);
		else if (activity instanceof Invoke)
			activityElement = invoke2XML((Invoke) activity);
		else if (activity instanceof Assign)
			activityElement = assign2XML((Assign) activity);
		else if (activity instanceof AssignE4X)
			//If activity is E4X assign
			activityElement = assignE4X2XML((AssignE4X) activity);
		else if (activity instanceof Reply)
			activityElement = reply2XML((Reply) activity);
		else if (activity instanceof Receive)
			activityElement = receive2XML((Receive) activity);
		else if (activity instanceof Wait)
			activityElement = wait2XML((Wait) activity);
		else if (activity instanceof Throw)
			activityElement = throw2XML((Throw) activity);
		else if (activity instanceof Exit)
			activityElement = exit2XML((Exit) activity);
		else if (activity instanceof Flow)
			activityElement = flow2XML((Flow) activity);
		else if (activity instanceof If)
			activityElement = if2XML((If) activity);
		else if (activity instanceof While)
			activityElement = while2XML((While) activity);
		else if (activity instanceof Sequence)
			activityElement = sequence2XML((Sequence) activity);
		else if (activity instanceof Pick)
			activityElement = pick2XML((Pick) activity);
		else if (activity instanceof Scope)
			activityElement = scope2XML((Scope) activity);
		else if (activity instanceof Compensate)
			activityElement = compensate2XML((Compensate) activity);
		else if (activity instanceof CompensateScope)
			activityElement = compensateScope2XML((CompensateScope) activity);
		else if (activity instanceof Rethrow)
			activityElement = rethrow2XML((Rethrow) activity);
		else if (activity instanceof OpaqueActivity)
			activityElement = opaqueActivity2XML((OpaqueActivity) activity);
		else if (activity instanceof ForEach)
			activityElement = forEach2XML((ForEach) activity);
		else if (activity instanceof RepeatUntil)
			activityElement = repeatUntil2XML((RepeatUntil) activity);
		else if (activity instanceof Validate)
			activityElement = validate2XML((Validate) activity);

		return activityElement;
	}

	protected Element addCommonActivityItems(Element activityElement,
			Activity activity) {

		addStandardAttributes(activityElement, activity);
		addStandardElements(activityElement, activity);

		// serialize local namespace prefixes to XML
		serializePrefixes(activity, activityElement);

		extensibleElement2XML(activity, activityElement);

		return activityElement;
	}

	protected void addStandardAttributes(Element activityElement,
			Activity activity) {
		if (activity.getName() != null)
			activityElement.setAttribute("name", activity.getName());
		if (activity.isSetSuppressJoinFailure()) {
			activityElement.setAttribute("suppressJoinFailure", BPELUtils
					.boolean2XML(activity.getSuppressJoinFailure()));
		}

	}

	protected void addStandardElements(Element activityElement,
			Activity activity) {
		// NOTE: Mind the order of these elements.
		Node firstChild = activityElement.getFirstChild();
		Targets targets = activity.getTargets();
		if (targets != null) {
			activityElement.insertBefore(targets2XML(targets), firstChild);
		}
		Sources sources = activity.getSources();
		if (sources != null) {
			activityElement.insertBefore(sources2XML(sources), firstChild);
		}
	}

	protected Element catch2XML(Catch _catch) {
		Element catchElement = createBPELElement("catch");
		if (_catch.getFaultName() != null) {
			catchElement.setAttribute("faultName", qNameToString(_catch, _catch
					.getFaultName()));
		}
		if (_catch.getFaultVariable() != null) {
			catchElement.setAttribute("faultVariable", _catch
					.getFaultVariable().getName());
		}
		if (_catch.getFaultMessageType() != null) {
			catchElement.setAttribute("faultMessageType", qNameToString(_catch,
					_catch.getFaultMessageType().getQName()));
		}
		if (_catch.getFaultElement() != null) {
			XSDElementDeclaration element = _catch.getFaultElement();
			QName qname = new QName(element.getTargetNamespace(), element
					.getName());
			catchElement.setAttribute("faultElement", qNameToString(_catch,
					qname));
		}
		if (_catch.getActivity() != null) {
			catchElement.appendChild(activity2XML(_catch.getActivity())); // might
			// be a
			// compensate
			// activity
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(_catch, catchElement);
		extensibleElement2XML(_catch, catchElement);
		return catchElement;
	}

	protected Element catchAll2XML(CatchAll catchAll) {
		Element catchAllElement = createBPELElement("catchAll");

		Activity activity = catchAll.getActivity();
		if (activity != null)
			catchAllElement.appendChild(activity2XML(activity)); // might be
		// a
		// compensate
		// activity

		// serialize local namespace prefixes to XML
		serializePrefixes(catchAll, catchAllElement);
		extensibleElement2XML(catchAll, catchAllElement);

		return catchAllElement;
	}

	protected Element empty2XML(Empty empty) {
		Element activityElement = createBPELElement("empty");

		addCommonActivityItems(activityElement, empty);
		return activityElement;
	}

	protected Element opaqueActivity2XML(OpaqueActivity activity) {
		Element activityElement = createBPELElement("opaqueActivity");

		//Set Namespace to Abstract Process
		INamespaceMap<String, String> nsMap = BPELUtils.getNamespaceMap(this.fBPELResource.getProcess());

		if (this.fBPELResource.getOptionUseNSPrefix()) {
        	nsMap.remove("");
            List<String> prefix = nsMap.getReverse(this.fBPELResource.getNamespaceURI());
            if (prefix.isEmpty()){
            	nsMap.put(BPELConstants.PREFIX, BPELConstants.NAMESPACE_ABSTRACT_2007);
            } else {
            	//TODO: Which prefix?
            	nsMap.put(prefix.get(0), BPELConstants.NAMESPACE_ABSTRACT_2007);
            }
    	} else {
            nsMap.put("", BPELConstants.NAMESPACE_ABSTRACT_2007);
        }

		this.fBPELResource.setNamespaceURI(BPELConstants.NAMESPACE_ABSTRACT_2007);

		Process process = this.fBPELResource.getProcess();
		//Set Default Abstract Process Profile
		//TODO: Let user decide whether to use a profile
			if (!process.isSetAbstractProcessProfile()){
				process.setAbstractProcessProfile(BPELConstants.NAMESPACE_ABSTRACT_PROFILE_T);
			}
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element forEach2XML(ForEach forEach) {

		Element activityElement = createBPELElement("forEach");

		if (forEach.getParallel() != null)
			activityElement.setAttribute("parallel", BPELUtils
					.boolean2XML(forEach.getParallel()));

		if (forEach.getCounterName() != null) {
			activityElement.setAttribute("counterName", forEach
					.getCounterName().getName());
		}

		if (forEach.getStartCounterValue() != null) {
			activityElement.appendChild(expression2XML(forEach
					.getStartCounterValue(), "startCounterValue"));
		}

		if (forEach.getFinalCounterValue() != null) {
			activityElement.appendChild(expression2XML(forEach
					.getFinalCounterValue(), "finalCounterValue"));
		}

		CompletionCondition completionCondition = forEach
				.getCompletionCondition();
		if (completionCondition != null) {
			Element completionConditionElement = completionCondition2XML(completionCondition);
			activityElement.appendChild(completionConditionElement);
		}

		if (forEach.getActivity() != null) {
			activityElement.appendChild(activity2XML(forEach.getActivity()));
		}

		addCommonActivityItems(activityElement, forEach);
		return activityElement;
	}

	protected Element completionCondition2XML(
			CompletionCondition completionCondition) {
		Element completionConditionElement = createBPELElement("completionCondition");

		if (completionCondition.getBranches() != null) {
			Element branchesElement = branches2XML(completionCondition
					.getBranches());
			completionConditionElement.appendChild(branchesElement);
		}

		return completionConditionElement;
	}

	protected Element branches2XML(Branches branches) {
		Element branchesElement = expression2XML(branches, "branches");

		if (branches.isSetCountCompletedBranchesOnly())
			branchesElement.setAttribute("successfulBranchesOnly", BPELUtils
					.boolean2XML(branches.getCountCompletedBranchesOnly()));

		return branchesElement;
	}

	protected Element rethrow2XML(Rethrow activity) {
		Element activityElement = createBPELElement("rethrow");
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element validate2XML(Validate activity) {
		Element activityElement = createBPELElement("validate");

		StringBuilder variablesList = new StringBuilder();
		Iterator<?> variables = activity.getVariables().iterator();
		while (variables.hasNext()) {
			Variable variable = (Variable) variables.next();
			variablesList.append(variable.getName());
			if (variables.hasNext())
				variablesList.append(" ");
		}
		if (variablesList.length() > 0) {
			activityElement.setAttribute("variables", variablesList.toString());
		}
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element extensionActivity2XML(ExtensionActivity activity) {

		Element activityElement = createBPELElement("extensionActivity");

		String localName = activity.eClass().getName();
		String namespace = activity.eClass().getEPackage().getNsURI();
		QName qName = new QName(namespace, localName);
		BPELActivitySerializer serializer = this.extensionRegistry
				.getActivitySerializer(qName);
		DocumentFragment fragment = null;
		if (serializer != null) {
			fragment = this.document.createDocumentFragment();
			serializer.marshall(qName, activity, fragment, getProcess(), this);
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458
			// Only append Element nodes generated by the serializer
			// XML beautification is handled by the ElementPlacer class
			Element child = getFirstChildElement(fragment);
			if (child!=null) {
				activityElement.appendChild(child);
			}
		}

		return activityElement;
	}

	protected Element invoke2XML(Invoke activity) {

		Element activityElement = createBPELElement("invoke");

		if (activity.getPartnerLink() != null)
			activityElement.setAttribute("partnerLink", activity
					.getPartnerLink().getName());
		if (activity.getPortType() != null)
			activityElement.setAttribute("portType", qNameToString(activity,
					activity.getPortType().getQName()));
		if (activity.getOperation() != null)
			activityElement.setAttribute("operation",
					getOperationSignature(activity.getOperation()));
		if (activity.getInputVariable() != null)
			activityElement.setAttribute("inputVariable", activity
					.getInputVariable().getName());
		if (activity.getOutputVariable() != null)
			activityElement.setAttribute("outputVariable", activity
					.getOutputVariable().getName());

		if (activity.getCorrelations() != null)
			activityElement.appendChild(correlations2XML(activity
					.getCorrelations()));

		FaultHandler faultHandler = activity.getFaultHandler();
		if (faultHandler != null) {
			faultHandler2XML(activityElement, faultHandler);
		}

		if (activity.getCompensationHandler() != null)
			activityElement.appendChild(compensationHandler2XML(activity
					.getCompensationHandler()));

		if (activity.getFromParts() != null)
			activityElement.appendChild(fromParts2XML(activity.getFromParts()));

		if (activity.getToParts() != null)
			activityElement.appendChild(toParts2XML(activity.getToParts()));

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element receive2XML(Receive activity) {

		Element activityElement = createBPELElement("receive");

		if (activity.getPartnerLink() != null)
			activityElement.setAttribute("partnerLink", activity
					.getPartnerLink().getName());
		if (activity.getPortType() != null)
			activityElement.setAttribute("portType", qNameToString(activity,
					activity.getPortType().getQName()));
		if (activity.getOperation() != null)
			activityElement.setAttribute("operation",
					getOperationSignature(activity.getOperation()));
		if (activity.getVariable() != null)
			activityElement.setAttribute("variable", activity.getVariable()
					.getName());
		if (activity.isSetCreateInstance())
			activityElement.setAttribute("createInstance", BPELUtils
					.boolean2XML(activity.getCreateInstance()));
		if (activity.getMessageExchange() != null)
			activityElement.setAttribute("messageExchange", activity
					.getMessageExchange().getName());

		if (activity.getCorrelations() != null)
			activityElement.appendChild(correlations2XML(activity
					.getCorrelations()));

		if (activity.getFromParts() != null)
			activityElement.appendChild(fromParts2XML(activity.getFromParts()));

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element reply2XML(Reply activity) {

		Element activityElement = createBPELElement("reply");
		if (activity.getPartnerLink() != null)
			activityElement.setAttribute("partnerLink", activity
					.getPartnerLink().getName());
		if (activity.getPortType() != null)
			activityElement.setAttribute("portType", qNameToString(activity,
					activity.getPortType().getQName()));
		if (activity.getOperation() != null)
			activityElement.setAttribute("operation",
					getOperationSignature(activity.getOperation()));
		if (activity.getVariable() != null)
			activityElement.setAttribute("variable", activity.getVariable()
					.getName());
		if (activity.getFaultName() != null) {
			activityElement.setAttribute("faultName", qNameToString(activity,
					activity.getFaultName()));
		}
		if (activity.getMessageExchange() != null)
			activityElement.setAttribute("messageExchange", activity
					.getMessageExchange().getName());

		if (activity.getCorrelations() != null)
			activityElement.appendChild(correlations2XML(activity
					.getCorrelations()));

		if (activity.getToParts() != null)
			activityElement.appendChild(toParts2XML(activity.getToParts()));

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}


	/**
	 * Returns assign Element which suppots for E4X 
	 */
	protected Element assignE4X2XML(AssignE4X activity) {
 
		Element activityElement = createBPELElement("assign");

		// setting Validate Attribute 
		if (activity.getValidate() != null)
			activityElement.setAttribute("validate", BPELUtils
					.boolean2XML(activity.getValidate()));
		
		//Adding ExtensionAssign Operations to the assign element.
		List<?> extensionAssignOperationList = activity.getExtensionAssignOperation();
		if (!extensionAssignOperationList.isEmpty()) {
			for (Iterator<?> i = extensionAssignOperationList.iterator(); i.hasNext();) {
				ExtensionAssignOperation extensionAssignOperation = (ExtensionAssignOperation) i.next();
				activityElement.appendChild(extensionAssignOperation2XML(extensionAssignOperation));
			}
		}

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}
	
	/** 
	 * Returns a ExtensionAssignOperation Element 
	 * 
	 */
	protected Element extensionAssignOperation2XML(ExtensionAssignOperation extensionAssignOpearation) {
		Element ecoElement = createBPELElement("extensionAssignOperation");

		//getting Snippet of ExtensionAssignOperation
		Snippet snippet = extensionAssignOpearation.getSnippet();
		if (snippet != null) {
			// Creating Element with js nameSpace;
			Element snippetElement = createElementWithTag( "http://ode.apache.org/extensions/e4x","js" , "snippet");
			snippet2XML(snippet, snippetElement);
			ecoElement.appendChild(snippetElement);
		}
		
		// serialize local namespace prefixes to XML
		serializePrefixes(extensionAssignOpearation, ecoElement);
		extensibleElement2XML(extensionAssignOpearation, ecoElement);

		return ecoElement;
	}
	
	/** 
	 * Returns a Snippet Element 
	 * 
	 */
	protected Element snippet2XML(Snippet snippet, Element snippetElement)
	{
		// adding Body content.
		if (snippet.getBody() != null) {
			Object body = snippet.getBody();
			if (body instanceof ExtensibilityElement) {
				ExtensibilityElement extensibilityElement = (ExtensibilityElement) body;
				Element child = extensibilityElement2XML(extensibilityElement);
				if (child != null) {
					snippetElement.appendChild(child);
				}
			} else {
				CDATASection cdata = BPELUtils.createCDATASection(document,
						snippet.getBody().toString());
				snippetElement.appendChild(cdata);
			}
		}
		
		// adding "xmln:js=http://ode.apache.org/extensions/e4x" attribute for Snippet.
		String prefix = "js";
		String namespace = "http://ode.apache.org/extensions/e4x";
		snippetElement.setAttributeNS(XSDConstants.XMLNS_URI_2000,
					"xmlns:" + prefix, namespace);

		return snippetElement;
	
	}
	
	/**
	 * Creating Elements with given nameSpace;
	 * exampel:if  ns=js, nameSpaceURI= http://ode.apache.org/extensions/e4x; tagName=snippet
	 * this will generate <js:snippet>
	 * 
	 * @param namespaceURI
	 * @param ns
	 * @param tagName
	 * @return
	 */
	protected Element createElementWithTag(String nameSpaceURI , String ns ,String tagName) {
		
	    return document.createElementNS(nameSpaceURI, ns+ ":" + tagName);
		
	}

	protected Element createElementWithName(String tagName)	{
		return document.createElement(tagName);
	}

	protected Element assign2XML(Assign activity) {

		Element activityElement = createBPELElement("assign");

		if (activity.getValidate() != null)
			activityElement.setAttribute("validate", BPELUtils
					.boolean2XML(activity.getValidate()));

		List<?> copies = activity.getCopy();
		if (!copies.isEmpty()) {
			for (Object name : copies) {
				Copy copy = (Copy) name;
				activityElement.appendChild(copy2XML(copy));
			}
		}

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element copy2XML(Copy copy) {
		Element copyElement = createBPELElement("copy");

		if (copy.isSetKeepSrcElementName())
			copyElement.setAttribute("keepSrcElementName", BPELUtils
					.boolean2XML(copy.getKeepSrcElementName()));

		if (copy.isSetIgnoreMissingFromData())
			copyElement.setAttribute("ignoreMissingFromData", BPELUtils
					.boolean2XML(copy.getIgnoreMissingFromData()));

		From from = copy.getFrom();
		if (from != null) {
			Element fromElement = createBPELElement("from");
			from2XML(from, fromElement);
			copyElement.appendChild(fromElement);
		}
		To to = copy.getTo();
		if (to != null) {
			Element toElement = createBPELElement("to");
			to2XML(to, toElement);
			copyElement.appendChild(toElement);
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(copy, copyElement);
		extensibleElement2XML(copy, copyElement);

		return copyElement;
	}

	protected void from2XML(From from, Element fromElement) {

		if (from.getVariable() != null) {
			fromElement.setAttribute("variable", from.getVariable().getName());
		}
		if (from.getPart() != null) {
			fromElement.setAttribute("part", from.getPart().getName());
		}
		if (from.getPartnerLink() != null) {
			fromElement.setAttribute("partnerLink", from.getPartnerLink()
					.getName());
		}
		Property property = from.getProperty();
		if (property != null) {
			String qnameStr = qNameToString(from, getQName(property));
			fromElement.setAttribute("property", qnameStr);
		}

		if (from.getQuery() != null) {
			Query query = from.getQuery();
			Element queryElement = query2XML(query);
			fromElement.appendChild(queryElement);
		}

		if (from.isSetEndpointReference()) {
			fromElement.setAttribute("endpointReference", from
					.getEndpointReference().toString());
		}

		if (from.isSetOpaque()) {
			fromElement.setAttribute("opaque", BPELUtils.boolean2XML(from
					.getOpaque()));
		}

		if (from.isSetLiteral() && from.getLiteral() != null
				&& !from.getLiteral().equals("")) {

			Node node = null;
			Element literal = createBPELElement("literal");

			fromElement.appendChild(literal);

			if (Boolean.TRUE.equals(from.getUnsafeLiteral())) {
				node = BPELUtils.convertStringToNode(from, from.getLiteral(),
						getResource());
			}

			if (node != null) {
				for (Node child = node.getFirstChild(); child != null; child = child
						.getNextSibling()) {
					DOMUtil.copyInto(child, literal);
				}
			} else {
				CDATASection cdata = BPELUtils.createCDATASection(this.document,
						from.getLiteral());
				fromElement.appendChild(cdata);
			}

		}

		if (from.getServiceRef() != null) {
			fromElement.appendChild(serviceRef2XML(from.getServiceRef()));
		}

		if (from.getExpression() != null) {
			Expression expression = from.getExpression();

			if (expression.getExpressionLanguage() != null) {
				fromElement.setAttribute("expressionLanguage", expression
						.getExpressionLanguage());
			}
			if (expression.getBody() != null) {
				CDATASection cdata = BPELUtils.createCDATASection(this.document,
						(String) expression.getBody());
				fromElement.appendChild(cdata);
			}
		}

		if (from.getType() != null) {
			XSDTypeDefinition type = from.getType();
			QName qname = new QName(type.getTargetNamespace(), type.getName());
			fromElement.setAttribute("xsi:type", qNameToString(from, qname));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(from, fromElement);
		extensibleElement2XML(from, fromElement);

	}

	protected Element serviceRef2XML(ServiceRef serviceRef) {
		Element serviceRefElement = createBPELElement("service-ref");
		String referenceScheme = serviceRef.getReferenceScheme();
		if (referenceScheme != null) {
			serviceRefElement.setAttribute("reference-scheme", referenceScheme);
		}
		if (serviceRef.getValue() != null) {
			Node valueNode = serviceRefValue2XML(serviceRef);
			if (valueNode != null) {
				serviceRefElement.appendChild(valueNode);
			}
		}
		return serviceRefElement;
	}

	protected Node serviceRefValue2XML(ServiceRef serviceRef) {
		Object value = serviceRef.getValue();
		if (value instanceof ExtensibilityElement) {
			ExtensibilityElement extensibilityElement = (ExtensibilityElement) value;
			BPELExtensionSerializer serializer = null;
			QName qname = extensibilityElement.getElementType();
			try {
				serializer = (BPELExtensionSerializer) this.extensionRegistry
						.querySerializer(BPELExtensibleElement.class, qname);
			} catch (WSDLException e) {
			}

			if (serializer != null) {
				// Deserialize the DOM element and add the new Extensibility
				// element to the parent
				// BPELExtensibleElement
				DocumentFragment fragment = this.document.createDocumentFragment();
				try {
					serializer.marshall(BPELExtensibleElement.class, qname,
							extensibilityElement, fragment, getProcess(),
							this.extensionRegistry, this);
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458
					Element child = getFirstChildElement(fragment);
					return child;
				} catch (WSDLException e) {
					throw new WrappedException(e);
				}
			}
		} else if (serviceRef.getValue() != null) {
			ServiceReferenceSerializer serializer = this.extensionRegistry
					.getServiceReferenceSerializer(serviceRef
							.getReferenceScheme());
			if (serializer != null) {
				DocumentFragment fragment = this.document.createDocumentFragment();
				serializer.marshall(value, fragment, getProcess(), serviceRef
						.eContainer(), this);
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458
				Element child = getFirstChildElement(fragment);
				return child;
			} else {
				CDATASection cdata = BPELUtils.createCDATASection(this.document,
						serviceRef.getValue().toString());
				return cdata;
			}
		}
		return null;
	}

	protected Element query2XML(Query query) {
		Element queryElement = createBPELElement("query");
		if (query.getQueryLanguage() != null) {
			queryElement
					.setAttribute("queryLanguage", query.getQueryLanguage());
		}
		if (query.getValue() != null) {
			CDATASection cdata = BPELUtils.createCDATASection(this.document, query
					.getValue());
			queryElement.appendChild(cdata);
		}
		return queryElement;
	}

	protected void to2XML(To to, Element toElement) {
		if (to.getVariable() != null) {
			toElement.setAttribute("variable", to.getVariable().getName());
		}
		if (to.getPart() != null) {
			toElement.setAttribute("part", to.getPart().getName());
		}
		if (to.getPartnerLink() != null) {
			toElement
					.setAttribute("partnerLink", to.getPartnerLink().getName());
		}
		Property property = to.getProperty();
		if (property != null) {
			String qnameStr = qNameToString(to, getQName(property));
			toElement.setAttribute("property", qnameStr);
		}

		if (to.getQuery() != null) {
			Query query = to.getQuery();
			Element queryElement = query2XML(query);
			toElement.appendChild(queryElement);
		}
		if (to.getExpression() != null) {
			Expression expression = to.getExpression();

			if (expression.getExpressionLanguage() != null) {
				toElement.setAttribute("expressionLanguage", expression
						.getExpressionLanguage());
			}
			if (expression.getBody() != null) {
				CDATASection cdata = BPELUtils.createCDATASection(this.document,
						(String) expression.getBody());
				toElement.appendChild(cdata);
			}
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(to, toElement);
		extensibleElement2XML(to, toElement);
	}

	protected Element wait2XML(Wait activity) {
		Element activityElement = createBPELElement("wait");

		if (activity.getFor() != null) {
			activityElement
					.appendChild(expression2XML(activity.getFor(), "for"));
		}
		if (activity.getUntil() != null) {
			activityElement.appendChild(expression2XML(activity.getUntil(),
					"until"));
		}
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element throw2XML(Throw activity) {
		Element activityElement = createBPELElement("throw");

		if (activity.getFaultVariable() != null
				&& activity.getFaultVariable().getName() != null) {
			activityElement.setAttribute("faultVariable", activity
					.getFaultVariable().getName());
		}
		if (activity.getFaultName() != null) {
			activityElement.setAttribute("faultName", qNameToString(activity,
					activity.getFaultName()));
		}
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element exit2XML(Exit activity) {
		Element activityElement = createBPELElement("exit");
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	void addActivities(Element activityElement, List<?> listOfActivities) {
		for (Object next : listOfActivities) {
			activityElement.appendChild(activity2XML((Activity) next));
		}
	}

	protected Element flow2XML(Flow activity) {

		Element activityElement = createBPELElement("flow");

		Links links = activity.getLinks();
		if (links != null) {
			Element linksElement = links2XML(links);
			activityElement.appendChild(linksElement);
		}

		CompletionCondition completionCondition = activity
				.getCompletionCondition();
		if (completionCondition != null) {
			Element completionConditionElement = completionCondition2XML(completionCondition);
			activityElement.appendChild(completionConditionElement);
		}

		addActivities(activityElement, activity.getActivities());

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element documentation2XML(Documentation documentation) {
		Element documentationElement = createBPELElement("documentation");

		if (documentation.getSource() != null) {
			documentationElement.setAttribute("source", documentation
					.getSource());
		}
		if (documentation.getLang() != null) {
			documentationElement.setAttribute("xml:lang", documentation
					.getLang());
		}
		if (documentation.getValue() != null
				&& documentation.getValue().length() > 0) {
			Text textNode = documentationElement.getOwnerDocument()
					.createTextNode(documentation.getValue());
			documentationElement.appendChild(textNode);
		}

		return documentationElement;
	}

	protected Element links2XML(Links links) {
		Element linksElement = createBPELElement("links");

		for (Object next : links.getChildren()) {
			linksElement.appendChild(link2XML((Link) next));
		}
		// serialize local namespace prefixes to XML
		serializePrefixes(links, linksElement);
		extensibleElement2XML(links, linksElement);

		return linksElement;
	}

	protected Element link2XML(Link link) {
		Element linkElement = createBPELElement("link");
		if (link.getName() != null)
			linkElement.setAttribute("name", link.getName());

		// serialize local namespace prefixes to XML
		serializePrefixes(link, linkElement);
		extensibleElement2XML(link, linkElement);

		return linkElement;
	}

	protected Element if2XML(If activity) {

		Element ifElement = createBPELElement("if");

		if (activity.getCondition() != null) {
			ifElement.appendChild(expression2XML(activity.getCondition(),
					"condition"));
		}

		if (activity.getActivity() != null) {
			ifElement.appendChild(activity2XML(activity.getActivity()));
		}


		List<?> elseIfs = activity.getElseIf();
		if (!elseIfs.isEmpty()) {
			for (Object next : elseIfs) {
				ElseIf elseIf = (ElseIf) next;
				ifElement.appendChild(elseIf2XML(elseIf));
			}
		}
		Else _else = activity.getElse();
		if (_else != null) {
			Element elseElement = else2XML(_else);
			ifElement.appendChild(elseElement);
		}

		addCommonActivityItems(ifElement, activity);
		return ifElement;
	}

	protected Element elseIf2XML(ElseIf elseIf) {
		Element elseIfElement = createBPELElement("elseif");

		if (elseIf.getCondition() != null) {
			elseIfElement.appendChild(expression2XML(elseIf.getCondition(),
					"condition"));
		}
		if (elseIf.getActivity() != null) {
			elseIfElement.appendChild(activity2XML(elseIf.getActivity()));
		}
		// serialize local namespace prefixes to XML
		serializePrefixes(elseIf, elseIfElement);
		extensibleElement2XML(elseIf, elseIfElement);

		return elseIfElement;
	}

	protected Element else2XML(Else _else) {
		Element elseElement = createBPELElement("else");
		if (_else.getActivity() != null) {
			Element activityElement = activity2XML(_else.getActivity());
			elseElement.appendChild(activityElement);
		}
		// serialize local namespace prefixes to XML
		serializePrefixes(_else, elseElement);
		extensibleElement2XML(_else, elseElement);

		return elseElement;
	}

	protected Element while2XML(While activity) {
		Element activityElement = createBPELElement("while");

		if (activity.getCondition() != null) {
			activityElement.appendChild(expression2XML(activity.getCondition(),
					"condition"));
		}
		if (activity.getActivity() != null) {
			activityElement.appendChild(activity2XML(activity.getActivity()));
		}
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element repeatUntil2XML(RepeatUntil activity) {

		Element activityElement = createBPELElement("repeatUntil");

		if (activity.getActivity() != null) {
			activityElement.appendChild(activity2XML(activity.getActivity()));
		}
		if (activity.getCondition() != null) {
			activityElement.appendChild(expression2XML(activity.getCondition(),
					"condition"));
		}

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element expression2XML(Expression expression, String elementName) {
		Element expressionElement = createBPELElement(elementName);

		if (expression.getExpressionLanguage() != null) {
			expressionElement.setAttribute("expressionLanguage", expression
					.getExpressionLanguage());
		}
		if (expression.getOpaque() != null) {
			expressionElement.setAttribute("opaque", BPELUtils
					.boolean2XML(expression.getOpaque()));
		}
		if (expression.getBody() != null) {
			Object body = expression.getBody();
			if (body instanceof ExtensibilityElement) {
				ExtensibilityElement extensibilityElement = (ExtensibilityElement) body;
				Element child = extensibilityElement2XML(extensibilityElement);
				if (child != null) {
					expressionElement.appendChild(child);
				}
			} else {
				CDATASection cdata = BPELUtils.createCDATASection(this.document,
						expression.getBody().toString());
				expressionElement.appendChild(cdata);
			}
		}

		return expressionElement;
	}

	protected Element sequence2XML(Sequence activity) {
		Element activityElement = createBPELElement("sequence");

		addActivities(activityElement, activity.getActivities());
		addCommonActivityItems(activityElement, activity);

		return activityElement;
	}

	protected Element sources2XML(Sources sources) {
		Element sourcesElement = createBPELElement("sources");
		for (Object next : sources.getChildren()) {
			sourcesElement.appendChild(source2XML((Source) next));
		}
		extensibleElement2XML(sources, sourcesElement);
		return sourcesElement;
	}

	protected Element source2XML(Source source) {

		Element sourceElement = createBPELElement("source");
		sourceElement.setAttribute("linkName", source.getLink().getName());
		Condition transitionCondition = source.getTransitionCondition();
		if (transitionCondition != null) {
			sourceElement.appendChild(expression2XML(transitionCondition,
					"transitionCondition"));
		}
		extensibleElement2XML(source, sourceElement);
		return sourceElement;
	}

	protected Element targets2XML(Targets targets) {
		Element targetsElement = createBPELElement("targets");

		// Write out the join condition
		Condition joinCondition = targets.getJoinCondition();
		if (joinCondition != null) {
			targetsElement.appendChild(expression2XML(joinCondition,
					"joinCondition"));
		}
		for (Object next : targets.getChildren()) {
			targetsElement.appendChild(target2XML((Target) next));
		}

		extensibleElement2XML(targets, targetsElement);
		return targetsElement;
	}

	protected Element target2XML(Target target) {
		Element targetElement = createBPELElement("target");
		targetElement.setAttribute("linkName", target.getLink().getName());
		extensibleElement2XML(target, targetElement);
		return targetElement;
	}

	protected Element onMessage2XML(OnMessage onMsg) {
		Element onMessageElement = createBPELElement("onMessage");
		if (onMsg.getPartnerLink() != null
				&& onMsg.getPartnerLink().getName() != null) {
			onMessageElement.setAttribute("partnerLink", onMsg.getPartnerLink()
					.getName());
		}
		if (onMsg.getPortType() != null
				&& onMsg.getPortType().getQName() != null) {
			onMessageElement.setAttribute("portType", qNameToString(onMsg,
					onMsg.getPortType().getQName()));
		}
		if (onMsg.getOperation() != null) {
			onMessageElement.setAttribute("operation",
					getOperationSignature(onMsg.getOperation()));
		}
		if (onMsg.getVariable() != null
				&& onMsg.getVariable().getName() != null) {
			onMessageElement.setAttribute("variable", onMsg.getVariable()
					.getName());
		}
		if (onMsg.getMessageExchange() != null)
			onMessageElement.setAttribute("messageExchange", onMsg
					.getMessageExchange().getName());
		if (onMsg.getCorrelations() != null) {
			onMessageElement.appendChild(correlations2XML(onMsg
					.getCorrelations()));
		}
		if (onMsg.getActivity() != null) {
			onMessageElement.appendChild(activity2XML(onMsg.getActivity()));
		}
		if (onMsg.getFromParts() != null) {
			onMessageElement.appendChild(fromParts2XML(onMsg.getFromParts()));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(onMsg, onMessageElement);

		// TODO: Why do we have this? I don't think OnMessage is extensible.
		extensibleElement2XML(onMsg, onMessageElement);
		return onMessageElement;
	}

	protected Element onEvent2XML(OnEvent onEvent) {
		Element onEventElement = createBPELElement("onEvent");
		if (onEvent.getPartnerLink() != null
				&& onEvent.getPartnerLink().getName() != null) {
			onEventElement.setAttribute("partnerLink", onEvent.getPartnerLink()
					.getName());
		}
		if (onEvent.getPortType() != null
				&& onEvent.getPortType().getQName() != null) {
			onEventElement.setAttribute("portType", qNameToString(onEvent,
					onEvent.getPortType().getQName()));
		}
		if (onEvent.getOperation() != null) {
			onEventElement.setAttribute("operation",
					getOperationSignature(onEvent.getOperation()));
		}
		if (onEvent.getVariable() != null
				&& onEvent.getVariable().getName() != null) {
			onEventElement.setAttribute("variable", onEvent.getVariable()
					.getName());
		}
		if (onEvent.getMessageExchange() != null)
			onEventElement.setAttribute("messageExchange", onEvent
					.getMessageExchange().getName());
		if (onEvent.getMessageType() != null) {
			onEventElement.setAttribute("messageType", qNameToString(onEvent,
					onEvent.getMessageType().getQName()));
		}
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=336003
		// "element" attribute was missing from original model
		if (onEvent.getXSDElement() != null) {
			onEventElement.setAttribute("element",
					onEvent.getXSDElement().getQName());
		}
		if (onEvent.getCorrelationSets() != null) {
			onEventElement.appendChild(correlationSets2XML(onEvent
					.getCorrelationSets()));
		}
		if (onEvent.getCorrelations() != null) {
			onEventElement.appendChild(correlations2XML(onEvent
					.getCorrelations()));
		}

		if (onEvent.getActivity() != null) {
			onEventElement.appendChild(activity2XML(onEvent.getActivity()));
		}

		if (onEvent.getFromParts() != null) {
			onEventElement.appendChild(fromParts2XML(onEvent.getFromParts()));
		}

		// serialize local namespace prefixes to XML
		serializePrefixes(onEvent, onEventElement);

		// TODO: Why do we have this? I don't think OnEvent is extensible.
		extensibleElement2XML(onEvent, onEventElement);
		return onEventElement;
	}

	protected Element onAlarm2XML(OnAlarm onAlarm) {
		Element onAlarmElement = createBPELElement("onAlarm");
		if (onAlarm.getFor() != null) {
			onAlarmElement.appendChild(expression2XML(onAlarm.getFor(), "for"));
		}
		if (onAlarm.getUntil() != null) {
			onAlarmElement.appendChild(expression2XML(onAlarm.getUntil(),
					"until"));
		}
		if (onAlarm.getRepeatEvery() != null) {
			onAlarmElement.appendChild(expression2XML(onAlarm.getRepeatEvery(),
					"repeatEvery"));
		}
		if (onAlarm.getActivity() != null) {
			onAlarmElement.appendChild(activity2XML(onAlarm.getActivity()));
		}
		// serialize local namespace prefixes to XML
		serializePrefixes(onAlarm, onAlarmElement);

		// TODO: Why do we have this? I don't think OnAlarm is extensible.
		extensibleElement2XML(onAlarm, onAlarmElement);
		return onAlarmElement;
	}

	protected Element pick2XML(Pick activity) {
		Element activityElement = createBPELElement("pick");

		if (activity.isSetCreateInstance()) {
			activityElement.setAttribute("createInstance", BPELUtils
					.boolean2XML(activity.getCreateInstance()));
		}
		for (Object next : activity.getMessages()) {
			activityElement.appendChild(onMessage2XML((OnMessage) next));
		}
		for (Object next : activity.getAlarm()) {
			activityElement.appendChild(onAlarm2XML((OnAlarm) next));
		}
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element scope2XML(Scope activity) {

		Element activityElement = createBPELElement("scope");

		if (activity.isSetIsolated())
			activityElement.setAttribute("isolated", BPELUtils
					.boolean2XML(activity.getIsolated()));
		if (activity.isSetExitOnStandardFault())
			activityElement.setAttribute("exitOnStandardFault", BPELUtils
					.boolean2XML(activity.getExitOnStandardFault()));
		if (activity.getVariables() != null
				&& !activity.getVariables().getChildren().isEmpty())
			activityElement.appendChild(variables2XML(activity.getVariables()));
		if (activity.getCorrelationSets() != null
				&& !activity.getCorrelationSets().getChildren().isEmpty())
			activityElement.appendChild(correlationSets2XML(activity
					.getCorrelationSets()));
		if (activity.getPartnerLinks() != null
				&& !activity.getPartnerLinks().getChildren().isEmpty())
			activityElement.appendChild(partnerLinks2XML(activity
					.getPartnerLinks()));
		if (activity.getFaultHandlers() != null)
			activityElement.appendChild(faultHandlers2XML(activity
					.getFaultHandlers()));
		if (activity.getCompensationHandler() != null)
			activityElement.appendChild(compensationHandler2XML(activity
					.getCompensationHandler()));
		if (activity.getTerminationHandler() != null)
			activityElement.appendChild(terminationHandler2XML(activity
					.getTerminationHandler()));
		if (activity.getEventHandlers() != null)
			activityElement.appendChild(eventHandler2XML(activity
					.getEventHandlers()));
		if (activity.getMessageExchanges() != null
				&& !activity.getMessageExchanges().getChildren().isEmpty())
			activityElement.appendChild(messageExchanges2XML(activity
					.getMessageExchanges()));
		if (activity.getActivity() != null)
			activityElement.appendChild(activity2XML(activity.getActivity()));

		addCommonActivityItems(activityElement, activity);

		return activityElement;
	}

	protected Element compensateScope2XML(CompensateScope activity) {
		Element activityElement = createBPELElement("compensateScope");

		Activity scopeOrInvoke = activity.getTarget();
		if (scopeOrInvoke != null) {
			activityElement.setAttribute("scope", scopeOrInvoke.getName());
		}

		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected Element compensate2XML(Compensate activity) {
		Element activityElement = createBPELElement("compensate");
		addCommonActivityItems(activityElement, activity);
		return activityElement;
	}

	protected QName getQName(org.eclipse.wst.wsdl.ExtensibilityElement element,
			String localName) {
		EObject container = null;
		for (container = element.eContainer(); container != null
				&& !(container instanceof Definition);) {
			container = container.eContainer();
		}
		if (container == null) {
			return null;
		}
		return new QName(((Definition) container).getTargetNamespace(),
				localName);
	}

	/**
	 * Convert a BPEL ExtensibileElement to XML
	 */
	protected void extensibleElement2XML(BPELExtensibleElement extensibleElement,
			Element element) {

		if (extensibleElement.getDocumentation() != null) {
			// We can't just do appendChild here. This is called *after* the
			// concrete type
			// has had a chance to append children, and documentation should
			// precede all of
			// these children
			Node firstChild = element.getFirstChild();
			Element documentationElement = documentation2XML(extensibleElement
					.getDocumentation());
			if (firstChild == null) {
				element.appendChild(documentationElement);
			} else {
				element.insertBefore(documentationElement, firstChild);
			}
		}

		// Get the extensibility elements and if the platform is running try to
		// order them.
		// If the platform is not running just serialize the elements in the
		// order they appear.
		List<org.eclipse.wst.wsdl.ExtensibleElement> extensibilityElements;
		if (Platform.isRunning()) {
			if (this.extensibilityElementListHandlers == null) {
				this.extensibilityElementListHandlers = ExtensionFactory.INSTANCE
						.createHandlers(ExtensionFactory.ID_EXTENSION_REORDERING);
			}
			extensibilityElements = BPELUtils.reorderExtensibilityList(
					this.extensibilityElementListHandlers, extensibleElement);
		} else {
			extensibilityElements = extensibleElement.getExtensibilityElements();
		}

		// Loop through the extensibility elements
		for (Object name : extensibilityElements) {
			ExtensibilityElement extensibilityElement = (ExtensibilityElement) name;

			// Lookup a serializer for the extensibility element
			BPELExtensionSerializer serializer = null;
			QName qname = extensibilityElement.getElementType();
			try {
				serializer = (BPELExtensionSerializer) this.extensionRegistry
						.querySerializer(BPELExtensibleElement.class, qname);
			} catch (WSDLException e) {
				// TODO: Exception handling
			}
			if (serializer != null) {

				// Create a temp document fragment for the serializer
				DocumentFragment fragment = this.document.createDocumentFragment();

				// Serialize the extensibility element into the parent DOM
				// element
				try {
					serializer.marshall(BPELExtensibleElement.class, qname,
							extensibilityElement, fragment, getProcess(),
							this.extensionRegistry, this);
				} catch (WSDLException e) {
					throw new WrappedException(e);
				}

				Node tempElement = fragment.getFirstChild();
				if (tempElement == null) {
					return;
				}
				String nodeName = tempElement.getNodeName();
				nodeName = nodeName.substring(nodeName.lastIndexOf(':') + 1);
				if (nodeName.equals("extensibilityAttributes")) {

					// Add the attributes to the parent DOM element
					String elementName = tempElement.getNodeName();
					String prefix = elementName.lastIndexOf(':') != -1 ? elementName
							.substring(0, elementName.indexOf(':'))
							: null;
					NamedNodeMap attributes = tempElement.getAttributes();
					for (int a = 0, n = attributes.getLength(); a < n; a++) {
						Attr attr = (Attr) attributes.item(a);
						String attrName = attr.getNodeName();
						if (attrName.indexOf(':') == -1 && prefix != null)
							attrName = prefix + ':' + attrName;
						if (attrName.startsWith("xmlns:")) {
							String localName = attrName.substring("xmlns:"
									.length());
							Map<String, String> nsMap = BPELUtils
									.getNamespaceMap(extensibleElement);
							if (!nsMap.containsKey(localName)
									|| !attr.getNodeValue().equals(
											nsMap.get(localName))) {
								nsMap.put(localName, attr.getNodeValue());
							}
						} else {
							element.setAttribute(attrName, attr.getNodeValue());
						}
					}
				} else {
					// The extensibility element was serialized into a DOM
					// element, simply
					// add it to the parent DOM element
					// always append the extension element to the
					// begining of the children list
					if (element.getFirstChild() == null)
						element.appendChild(tempElement);
					else
						element.insertBefore(tempElement, element
								.getFirstChild());
				}
			}
		}
	}

	/**
	 * Get process from the resource
	 * @return the Process
	 */
	private Process getProcess() {
		return getResource().getProcess();
	}

	/**
	 * Convert a BPEL ExtensibilityElement to XML
	 */
	protected Element extensibilityElement2XML(
			ExtensibilityElement extensibilityElement) {

		BPELExtensionSerializer serializer = null;
		QName qname = extensibilityElement.getElementType();
		try {
			serializer = (BPELExtensionSerializer) this.extensionRegistry
					.querySerializer(BPELExtensibleElement.class, qname);
		} catch (WSDLException e) {
			return null;
		}

		// Deserialize the DOM element and add the new Extensibility element to
		// the parent
		// BPELExtensibleElement
		DocumentFragment fragment = this.document.createDocumentFragment();
		try {
			serializer
					.marshall(BPELExtensibleElement.class, qname,
							extensibilityElement, fragment, getProcess(),
							this.extensionRegistry, this);
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458
			Element child = getFirstChildElement(fragment);
			return child;
		} catch (WSDLException e) {
			throw new WrappedException(e);
		}
	}
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458

	protected Element createBPELElement(String tagName) {

		String namespaceURI = null;

		if (getResource() != null) {
			namespaceURI = getResource().getNamespaceURI();
		} else {
			namespaceURI = BPELConstants.NAMESPACE;
		}

		if (namespaceURI != null) {
			List<String> prefixes = BPELUtils.getNamespaceMap(
					getProcess()).getReverse(namespaceURI);
			if (!prefixes.isEmpty() && !prefixes.get(0).equals("")) {
				return this.document.createElementNS(namespaceURI, prefixes.get(0)
						+ ":" + tagName);
			}
		}

		return this.document.createElement(tagName);
	}

	/**
	 *
	 * @return the namespace prefix manager.
	 */

	// public NamespacePrefixManager getNamespacePrefixManager() {
	// return bpelNamespacePrefixManager;
	// }
	private void serializePrefixes(EObject eObject, Element context) {
		INamespaceMap<String, String> nsMap = BPELUtils
				.getNamespaceMap(eObject);
		if (!nsMap.isEmpty()) {
			for( Map.Entry<String,String> entry : nsMap.entrySet()) {
				String prefix = entry.getKey();
				String namespace = entry.getValue();
				if (prefix.length() == 0)
					context.setAttributeNS(XSDConstants.XMLNS_URI_2000,
							"xmlns", namespace);
				else
					context.setAttributeNS(XSDConstants.XMLNS_URI_2000,
							"xmlns:" + prefix, namespace);
			}
		}
	}

	private String addNewRootPrefix(String basePrefix, String namespace) {
		INamespaceMap<String, String> nsMap = BPELUtils
				.getNamespaceMap(getProcess());

		List<String> prefixes = nsMap.getReverse(namespace);
		if (prefixes.isEmpty()) {
			int i = 0;
			String prefix = basePrefix;
			while (nsMap.containsKey(prefix)) {
				prefix = basePrefix + i;
				i++;
			}
			nsMap.put(prefix, namespace);
			return prefix;
		} else {
			return prefixes.get(0);
		}
	}

	private String qNameToString(EObject eObject, QName qname) {
		EObject context = eObject;
		List<String> prefixes = null;
		String namespace = qname.getNamespaceURI();

		if (namespace == null || namespace.length() == 0) {
			return qname.getLocalPart();
		}

		// Transform BPEL namespaces to the latest version so that
		// references to the old namespace are not serialized.
		if (BPELConstants.isBPELNamespace(namespace)) {
			namespace = BPELConstants.NAMESPACE;
		}
		while (context != null) {
			INamespaceMap<String, String> prefixNSMap = BPELUtils
					.getNamespaceMap(context);
			prefixes = prefixNSMap.getReverse(namespace);
			if (!prefixes.isEmpty()) {
				String prefix = prefixes.get(0);
				if (!prefix.equals(""))
					return prefix + ":" + qname.getLocalPart();
				else
					return qname.getLocalPart();
			}
			context = context.eContainer();
		}
		// if a prefix is not found for the namespaceURI, create a new
		// prefix
		return addNewRootPrefix("ns", namespace) + ":" + qname.getLocalPart();
	}


	private Element getFirstChildElement(DocumentFragment fragment) {
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=335458
		// first child may be a TEXT Node (e.g. whitespace)
		Node child = fragment.getFirstChild();
		while (child != null && !(child instanceof Element)) {
			child = child.getNextSibling();
		}

		// We are out of the loop: either child is null, or it is an element
		if( child != null )
			return (Element) child;

		throw new IllegalArgumentException("Document Fragment does not contain any Elements");
	}
}
