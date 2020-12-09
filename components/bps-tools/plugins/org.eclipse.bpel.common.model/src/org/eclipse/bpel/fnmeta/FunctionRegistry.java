/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.fnmeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.fnmeta.model.Function;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 3, 2007 
 */

@SuppressWarnings("nls")
public class FunctionRegistry {
	
	Map<String,Function> fRegistryIndex = new HashMap<String,Function>();
	
	String fLanguageNamespace  ;
	
	/**
	 * @param languageNamespace
	 */
	
	public FunctionRegistry ( String languageNamespace ) {
		fLanguageNamespace = languageNamespace;
	}
	
	/**
	 *   
	 * @return the registry for our scripting language 
	 */
	
	public Collection<Function> getRegistry () {		
		return Collections.unmodifiableCollection( fRegistryIndex.values() );				
	}
	
	
	

	/**
	 * 
	 * @param ns
	 * @param name
	 * @return the function for the given namespace and name
	 *  
	 */
	
	public Function lookupFunction (String ns, String name) {		
		return fRegistryIndex.get( key(ns,name) );
	}
	
	
	/**
	 * @param list
	 */
	
	public void add (List<Function> list) {
		
		for ( Function fn :  list ) {
			add(fn);
		}
	}

	/**
	 * @param fn
	 */
	
	public void add (Function fn ) {
		String aKey = key(fn);
		Function previous = fRegistryIndex.get( aKey );
		if (previous != null) {
			// overwrite ? nope.
			return ;
		}
		fRegistryIndex.put(aKey , fn);			
	}
	
	
	String key (Function fn) {
		return key(fn.getNamespace(), fn.getName());
	}
	
	String key (String ns, String name) {
		StringBuilder sb = new StringBuilder();
		return sb.append(ns).append(";").append(name).toString() ;
	}
	
	
	/**
	 * @return the language namespace for this function registry
	 */
	public String getLanguageNS () {
		return fLanguageNamespace;
	}
	
}
