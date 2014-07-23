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

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.bpel.common.BPELResourceSet;
import org.eclipse.bpel.fnmeta.model.Registry;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 4, 2008
 *
 */
public class ClasspathFunctionRegistryLoader implements IFunctionRegistryLoader {

	ClassLoader fLoader = null;	
	ResourceSet fResourceSet = null;
	
	/**
	 * @param obj
	 */
	public ClasspathFunctionRegistryLoader (ResourceSet obj) {
		fLoader = obj.getClass().getClassLoader();
		fResourceSet = obj;
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.fnmeta.IFunctionRegistryLoader#load(org.eclipse.bpel.fnmeta.FunctionRegistry)
	 */
	
	@SuppressWarnings("nls")
	public void load (FunctionRegistry registry) {
		
		 Enumeration<URL> list = null;

		 try {
			 list = fLoader.getResources("fn.fnmeta");			 
			 while (list.hasMoreElements()) {
				 
				 URL url = list.nextElement();
				 URI uri = URI.createURI( url.toExternalForm() ) ;
				 
				 Resource resource = fResourceSet.getResource(uri, true);
				 
				 if (resource.getContents().size() > 0) {
					 Registry r = (Registry) resource.getContents().get(0);			
					 registry.add( r.getFunctions() );
				 }			
			 }
			 
		 } catch (Exception ex) {
			 ex.printStackTrace(System.err);
		 }
		
	}

}
