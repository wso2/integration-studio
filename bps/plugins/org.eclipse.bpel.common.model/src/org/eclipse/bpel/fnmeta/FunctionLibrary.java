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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function Library collects all the function registries for the given 
 * language in the BPEL context.
 * 
 * Imagine scripting language "foobar". There may be several registries contributing functions
 * to the language "foobar" library. The library is the single lookup point for scripting language
 * and the registry encompasses all the functions for the given language.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 4, 2008
 *
 */

public class FunctionLibrary {
		
	/**
	 * 
	 */
	static public FunctionLibrary INSTANCE = new FunctionLibrary();
	
	/**
	 * Index of all registries, by scripting language namespace name.
	 */
	Map<String,FunctionRegistry> fRegistries = new HashMap<String,FunctionRegistry>();
	
	/**
	 * List of registered loaders for the function library. This way we can do late loading 
	 * of registry information, basically delaying it until needed.
	 */
	List<IFunctionRegistryLoader> fLoaders = new ArrayList<IFunctionRegistryLoader>(); 
	
	
	/**
	 * 
	 * @param language the language.
	 * @return the function registry for the given language.
	 */
	
	public FunctionRegistry getRegistryForLanguage ( String language ) {
		
		FunctionRegistry registry = fRegistries.get(language);
		if (registry != null) {
			return registry;
		}
		
		synchronized (fRegistries) {
			registry = fRegistries.get(language);
			if (registry != null) {
				return registry;
			}
			
			registry = new FunctionRegistry(language);
			
			for(IFunctionRegistryLoader loader : fLoaders) {
				loader.load( registry );
			}
			
			fRegistries.put(language, registry);
		}				
		return registry;
	}
	

	/**
	 * @param registry
	 */
	
	public void add (FunctionRegistry registry) {
		fRegistries.put(registry.getLanguageNS(), registry);
	}
		
	/**
	 * @param loader
	 */
	
	public void registerLoader ( IFunctionRegistryLoader loader ) {
		if (fLoaders.contains(loader)) {
			return ;
		}
		fLoaders.add ( loader );
	}


	/**
	 * @param loader 
	 * 
	 */
	public void unregisterLoader( IFunctionRegistryLoader loader ) {
		fLoaders.remove(loader);		
	}
	
	
}
