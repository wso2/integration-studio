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

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.ExtensibilityElement;
import org.eclipse.wst.wsdl.WSDLPackage;


public class BPELServicesUtility {
	static public QName getQName(Property property) {
		QName qname;
		Definition def = property.getEnclosingDefinition();
		if (def == null) {
			qname = new QName(property.getName());
		} else {
			qname = new QName(def.getTargetNamespace(), property.getName());
		}
		return qname;
	}
	static public QName getQName(PartnerLinkType plnk) {
		QName qname;
		Definition def = plnk.getEnclosingDefinition();
		if (def == null) {
			qname = new QName(plnk.getName());
		} else {
			qname = new QName(def.getTargetNamespace(), plnk.getName());
		}
		return qname;
	}
//	static public URI getPropertyProxyURI(Property property) {
//		if (property != null && property.eIsProxy()) {
//			// If a property is a proxy, we need to generate a URI for it which identifies a
//			// resource from which it can be located.  We use the resource of the 
//			// extensibility element which references it, since this will either contain
//			// the property, or have an import to the file which contains it.
//			String proxyURI = ((InternalEObject)property).eProxyURI().toString();
//			int idx = proxyURI.lastIndexOf(':');
//			String id = getPropertyId(property, proxyURI.substring(idx+1));
//			if (property.getEnclosingDefinition().eResource() != null) {
//				return property.getEnclosingDefinition().eResource().getURI().appendFragment(id);
//			}
//			return URI.createURI(id);
//		}
//		return null;
//	}
	
	static public String getIdForExtensibilityElement(ExtensibilityElement element, String localName) {
		Definition def = element.getEnclosingDefinition();
		if (def != null) {
			String targetNameSpace = def.getTargetNamespace();
			if (targetNameSpace != null){
				return getId(new QName(targetNameSpace,localName), element);
			}
		}
		return  getId(new QName(":<unknown>:",localName), element);
	}
	
	static public String getIdForNestedNamedObject(String nestingObjectID, EObject nestedObject, String objectName) {
		return nestedObject.eClass().getName()+":"+nestingObjectID+":"+objectName;
	}
	
	static public String getId(QName qName, EObject object) {
		return object.eClass().getName()+":"+qName.getNamespaceURI()+":"+qName.getLocalPart();
	}

	static public String getProxyURI(URI baseURI, QName qname, EObject object) {
		try {
			return getProxyURI(baseURI, getId(qname, object));
		} catch (Exception e) {
			return null;
		}
	}

	static public String getProxyURI(URI baseURI, String id) {
		try {
			return baseURI.appendFragment(id).toString();
		} catch (Exception e) {
			return null;
		}
	}
	
	static public URI getXSDTypeProxyURI(URI baseURI, String namespace, String localPart) {
		return baseURI.appendFragment("XSDType:" + namespace + '#' +localPart);
	}
	
	static public URI getXSDElementProxyURI(URI baseURI, String namespace, String localPart) {
		return baseURI.appendFragment("XSDElement:" + namespace + '#' + localPart);
	}
	
//	static public Resource getResourceForProxy(EObject proxyObject, EObject hostingObject) {
//		Resource resource = proxyObject.eResource();
//		if (resource == null) {
//			resource = hostingObject.eResource(); 
//		}
//		return resource;
//	}
	
//	static public String getNamespaceForProxy(ExtensibilityElement proxyObject, ExtensibilityElement hostingObject, String prefixedName) {
//		String namespace = "";
//		int separator = prefixedName.indexOf(':');
//		if (separator != -1) {
//			String prefix = prefixedName.substring(0,separator);
//			Definition definition = proxyObject.getEnclosingDefinition();
//			if (definition == null) {
//				definition = hostingObject.getEnclosingDefinition();
//			}
//			if (definition != null) {
//				namespace = definition.getNamespace(prefix);
//			}
//		}
//		return namespace;
//	}
	
//	static public String getLocalNameForProxy(String prefixedName) {
//		String localName = "";
//		int separator = prefixedName.indexOf(':');
//		if (separator != -1) {
//			localName = prefixedName.substring(separator+1);
//		}
//		return localName;
//	}
	
	static public URI getProxyURI(Resource contextResource, String prefixedName, String targetClass) {
		int i = prefixedName.indexOf(':');
		String prefix = "";
		String localName = prefixedName;
		if (i != -1) {
			prefix = prefixedName.substring(0,i);
			localName = prefixedName.substring(i+1);
		}
		Definition definition = (Definition)EcoreUtil.getObjectByType(contextResource.getContents(), WSDLPackage.eINSTANCE.getDefinition());
		String namespace = definition.getNamespace(prefix);
		return contextResource.getURI().appendFragment(targetClass+":"+namespace+":"+localName);
	}
	
	static public String getProxyURIString(Resource contextResource, String prefixedName, EClass targetClass) {
		return getProxyURI(contextResource, prefixedName, targetClass.getName()).toString();
	}
	
}
