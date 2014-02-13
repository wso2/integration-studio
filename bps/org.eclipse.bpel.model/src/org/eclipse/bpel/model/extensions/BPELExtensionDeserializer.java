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
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Node;


/**
 * This interface should be implemented by classes which deserialize
 * org.w3c.dom.Elements into extension-specific instances of
 * ExtensibilityElement.
 */
public interface BPELExtensionDeserializer extends javax.wsdl.extensions.ExtensionDeserializer {

	/**
	 * This method deserializes elements into instances of classes
	 * which implement the ExtensibilityElement interface. The
	 * return value should be explicitly cast to the more-specific
	 * implementing type.
	 */
	public ExtensibilityElement unmarshall(Class parentType, QName elementType, Node node, Process process, Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader) throws WSDLException;
	
}