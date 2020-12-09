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
package org.eclipse.bpel.model.extensions;

import java.util.Map;

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.UnknownExtensionDeserializer;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.UnknownExtensibilityAttribute;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.wst.wsdl.UnknownExtensibilityElement;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.ibm.wsdl.Constants;
import com.ibm.wsdl.util.xml.DOMUtils;

public class BPELUnknownExtensionDeserializer extends UnknownExtensionDeserializer implements BPELExtensionDeserializer {

	public ExtensibilityElement unmarshall(Class parentType, QName elementType, Node node, Process process, Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader) throws WSDLException {
		if (node instanceof Element) {			
			if (elementType.getLocalPart().equals("extensibilityAttributes")) {
				UnknownExtensibilityAttribute unknownExt = BPELFactory.eINSTANCE.createUnknownExtensibilityAttribute();
				String requiredStr = DOMUtils.getAttributeNS((Element)node, Constants.NS_URI_WSDL, Constants.ATTR_REQUIRED);
				
				unknownExt.setElementType(elementType);
				
				if (requiredStr != null) {
					unknownExt.setRequired( Boolean.valueOf( requiredStr ));
				}
	
// (DO): Disabled to avoid <extensibilityAttributes> in sourceTab
//				unknownExt.setElement((Element)node);
				
				return unknownExt;
			} else {
				UnknownExtensibilityElement unknownExt = WSDLFactory.eINSTANCE.createUnknownExtensibilityElement();
				String requiredStr = DOMUtils.getAttributeNS((Element)node, Constants.NS_URI_WSDL, Constants.ATTR_REQUIRED);
				
				unknownExt.setElementType(elementType);
				
				if (requiredStr != null) {
					unknownExt.setRequired( Boolean.valueOf( requiredStr ));
				}
	
				unknownExt.setElement((Element)node);
				
				return unknownExt;			
			}
		}
		return null;
	}
}
