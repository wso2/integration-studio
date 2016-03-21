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

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;

/**
 * Content provider for CorrelationSets.
 * 
 * Expects a Process or a Scope as input.
 */
public class CorrelationSetContentProvider extends AbstractContentProvider  {

	
	@Override
	public void collectElements (Object input, List list) {
		
		if (input instanceof Process) {
			Process process = (Process) input;
			if (process.getCorrelationSets() != null) {
				list.addAll ( process.getCorrelationSets().getChildren() );				
			}
						
		} else if (input instanceof Scope) {
			Scope scope = (Scope) input;
			if (scope.getCorrelationSets() != null) {
				list.addAll ( scope.getCorrelationSets().getChildren() );
			}
		}
		
		// TODO: fix this to return all visible correlation sets?
		// see BPELUtil.getVisiblePartnerLinks() etc.				
	}
}
