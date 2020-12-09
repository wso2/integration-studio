/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
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

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Node;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELReader;

/**
 * This interface should be implemented by classes which deserialize
 * org.w3c.dom.Elements into extension-specific instances of
 * Activity.
 */
public interface BPELActivityDeserializer {
	/**
	 * This method deserializes elements into instances of classes
	 * which implement the Activity interface.
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=334424
	 * Client needs to use the activity if not null
	 */
	public Activity unmarshall(QName elementType, Node node, Activity activity, Process process, Map nsMap, ExtensionRegistry extReg, URI uri, BPELReader bpelReader);	
}
