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

import org.eclipse.bpel.ui.details.tree.OperationTreeNode;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;


/**
 * Provides a tree of model objects representing some expansion of the underlying graph
 * of model objects whose roots are the PartnerLinks of a Process. 
 */
public class OperationsTreeContentProvider extends ModelTreeContentProvider {

	private static final Operation[] NO_OPERATIONS = {};

	public OperationsTreeContentProvider (boolean isCondensed) {
		super(isCondensed);
	}

	@Override
	public Object[] primGetElements (Object inputElement) {
		
		Operation list[] = NO_OPERATIONS;
		
		if (inputElement instanceof PortType) {
			PortType pt = (PortType) inputElement;
			list = (Operation[]) pt.getOperations().toArray( list );
		}

		OperationTreeNode nodeList[] = new OperationTreeNode[list.length];
		for(int i=0; i < list.length; i++) {
			nodeList[i] = new OperationTreeNode(list[i],isCondensed);
		}
		return nodeList;
	}
}
