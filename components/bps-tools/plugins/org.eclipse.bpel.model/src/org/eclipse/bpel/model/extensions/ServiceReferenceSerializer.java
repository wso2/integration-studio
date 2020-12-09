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

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Node;



public interface ServiceReferenceSerializer {

	void marshall(Object target, Node parentNode, Process process, EObject parent, BPELWriter writer);
}
