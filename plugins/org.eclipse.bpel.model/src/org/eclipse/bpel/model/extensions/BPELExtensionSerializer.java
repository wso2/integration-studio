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

import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.w3c.dom.Node;


/**
 * This interface should be implemented by classes which serialize
 * extension-specific instances of ExtensibilityElement into a DOM
 * element.
 */
public interface BPELExtensionSerializer extends javax.wsdl.extensions.ExtensionSerializer {

	/**
	 * This method serializes extension-specific instances of
	 * ExtensibilityElement into the given parent element.
	 */
	public void marshall(Class parentType, QName elementType, ExtensibilityElement extension, Node parentNode, Process process, ExtensionRegistry extReg, BPELWriter bpelWriter) throws WSDLException;
}