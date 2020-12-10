/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.expressions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.bpel.fnmeta.FunctionLibrary;
import org.eclipse.bpel.fnmeta.FunctionRegistry;
import org.eclipse.bpel.fnmeta.model.Function;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 3, 2007
 *
 */
@SuppressWarnings("nls")
public class Functions {
		
	protected Map<String,Function> allFunctions = new HashMap<String,Function>();
			
	static Map<String,Functions> MAP = new HashMap<String,Functions>();
	
	
	private Functions ( String namespace ) {
		
		FunctionRegistry registry = FunctionLibrary.INSTANCE.getRegistryForLanguage( namespace );
		 
		for( Function fn : registry.getRegistry() ) {
			allFunctions.put(fn.getName(), fn);			
		}
	};
	
	
	/**  
	 * @param namespace 
	 * @return Return the singleton
	 */
	
	static public final Functions getInstance ( String namespace ) {
		Functions funcs = MAP.get(namespace);
		if (funcs == null) {
			synchronized (MAP) {
				funcs = new Functions(namespace);
				MAP.put(namespace, funcs);
			}
		}
		return funcs;		
	}
			
	/**
	 * @return all registered functions.
	 * 
	 */
	
	public Map<String,Function> getFunctions() { 
		return allFunctions; 
	}
			
}
