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
package org.eclipse.bpel.model.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.Variables;
import org.eclipse.emf.ecore.EObject;


/**
 * Base implementation of VariableResolver. This resolves all variables
 * as defined in the BPEL specifications.
 * 
 * Supply a different variable resolver by implementing VariableResolver
 * and executing:
 * BPELReader.VARIABLE_RESOLVER = new MyVariableResolver();
 */
public class BPELVariableResolver implements VariableResolver {
	
	/**
	 * @see org.eclipse.bpel.model.resource.VariableResolver#getVariable(org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	public Variable getVariable(EObject eObject, String variableName) {
		EObject container = eObject.eContainer();
		while (container != null) {
			if (container instanceof OnEvent) {
				Variable variable = ((OnEvent)container).getVariable();
				if (variable != null && variable.getName().equals(variableName)) {
					return variable;
				}
			} else if (container instanceof Catch) {
				Variable variable = ((Catch)container).getFaultVariable();
				if (variable != null && variable.getName().equals(variableName)) {
					return variable;
				}
			} else if (container instanceof ForEach) {
				Variable variable = ((ForEach)container).getCounterName();
				if (variable != null && variable.getName().equals(variableName)) {
					return variable;
				}
			} else {
				Variables variables = null;
				if (container instanceof Process) 
					variables = ((Process)container).getVariables();				
				else if (container instanceof Scope) 
					variables = ((Scope)container).getVariables();
				
				if (variables != null) {
					
					List<Object> list = new ArrayList<Object>();
					
					// check all BPEL variables if anyone has the correct variable name
					
					list.addAll(variables.getChildren());
					list.addAll(variables.getExtensibilityElements());
					
					for (Object n : list) {
						if (n instanceof Variable) {						
							Variable variable = (Variable) n;
							String name = variable.getName();
							if (name != null && name.equals(variableName)) {
								return variable;
							}
						}
					}
				}
			}
			container = container.eContainer();	
		}	
		
		// System.out.println("Variable: " + variableName + " - not resolved");
		
		return null;	
	}
}
