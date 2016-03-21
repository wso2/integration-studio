/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.providers;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.bpel.ui.details.tree.PartTreeNode;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;

/**
 * Provides a tree of model objects representing some expansion of the underlying graph
 * of model objects whose roots are the Parts of a Message type. 
 */
public class PartTreeContentProvider extends ModelTreeContentProvider {

	public PartTreeContentProvider(boolean isCondensed) {
		super(isCondensed);
	}

	@Override
	public Object[] primGetElements(Object inputElement) {
		Vector v = new Vector();
		if (inputElement instanceof Message) {
			for (Iterator it = ((Message)inputElement).getEParts().iterator(); it.hasNext(); ) {
				v.add(new PartTreeNode((Part)it.next(), false));
			}
		}
		return v.toArray();
	}
}
