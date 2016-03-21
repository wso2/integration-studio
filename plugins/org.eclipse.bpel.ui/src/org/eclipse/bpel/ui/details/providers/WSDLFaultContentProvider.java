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

import java.util.List;

import org.eclipse.wst.wsdl.Operation;

/**
 * Content provider for WSDL Faults.
 * 
 * Expects an Operation as input.
 */
public class WSDLFaultContentProvider extends AbstractContentProvider  {

	
	@Override
	public void collectElements (Object input, List list)  {
		
		if (input instanceof Operation) {
			Operation op = (Operation) input;
			list.addAll ( op.getEFaults() );			
		}
		
	}
	
}
