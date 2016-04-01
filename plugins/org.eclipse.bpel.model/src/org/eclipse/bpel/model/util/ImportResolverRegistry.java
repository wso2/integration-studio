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
package org.eclipse.bpel.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Import Resolver Registry.
 * @author IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Feb 27, 2007
 *
 */

public class ImportResolverRegistry
{
    /** The singleton instance of the registry */
    public final static ImportResolverRegistry INSTANCE = new ImportResolverRegistry();
    
    /**
     * Maps from {@link String} import type to a {@link List} of {@link ImportResolver}s.
     */
    Map<String,List<ImportResolver>> registry = new HashMap<String,List<ImportResolver>>();
    
    final static ImportResolver[] EMPTY_RESOLVER_ARRAY = new ImportResolver[] {};
    
    /**
     * Hide the constructor.
     */
    private ImportResolverRegistry() {
        // Register the default resolvers. 
        registerResolver(new XSDImportResolver());
        registerResolver(new WSDLImportResolver());
    }
    
    /**
     * Register a resolver for the given import type
     * @param resolver the resolver
     */
    
    public void registerResolver(ImportResolver resolver)
    {
    	String importType = resolver.getImportType();
        List<ImportResolver> resolvers = registry.get(importType);
        if (resolvers == null) {
            resolvers = new ArrayList<ImportResolver>();
            registry.put(importType, resolvers);
        }
        resolvers.add(resolver);
    }
    
    
    /**
     * Get resolver for a particular import type.
     * @param importType the import type
     * @return the array of resolvers for this import type.
     */
    
    public ImportResolver[] getResolvers(String importType)
    {
        List<ImportResolver> resolvers = registry.get(importType);
        if (resolvers == null) {
            return EMPTY_RESOLVER_ARRAY;
        }
        return resolvers.toArray(EMPTY_RESOLVER_ARRAY);        
    }
}
