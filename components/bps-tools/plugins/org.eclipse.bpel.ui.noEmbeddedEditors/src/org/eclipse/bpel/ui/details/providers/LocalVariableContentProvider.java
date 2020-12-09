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
import java.util.List;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Variable;


/**
 * Content provider for variables.
 * 
 * Expects a Process or a Scope as input.
 */
public class LocalVariableContentProvider extends AbstractContentProvider  {

	protected boolean needValidMessage; // if true, shows ONLY variables with valid messages
	
	/**
	 * @param needValidMessage if true, shows ONLY variables with valid messages
	 */
	public LocalVariableContentProvider(boolean needValidMessage) {
		this.needValidMessage = needValidMessage;
	}
	
	public LocalVariableContentProvider() {
		this.needValidMessage = false;
	}
	
	@Override
	public void collectElements(Object input, List list)  {
		
		if (input instanceof Process) {			
			Process process = (Process) input;			
			if (!needValidMessage) {
				list.addAll ( process.getVariables().getChildren() );
				return;
			}

			Iterator it = process.getVariables().getChildren().iterator();
			while (it.hasNext()) {
				Variable var = (Variable) it.next();
				if (var.getMessageType() != null) {
					list.add(var);
				}
			}
						
		} else 	if (input instanceof Scope) {
			
			Scope scope = (Scope) input;
			
			if (scope.getVariables() == null) {
				return ;
			}
			
			Iterator it = scope.getVariables().getChildren().iterator();
			while (it.hasNext()) {
				Variable var = (Variable) it.next();
				if (var.getMessageType() != null || var.getType() != null)
					list.add(var);
			}			
		}	
		
	}

}
