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
package org.eclipse.bpel.common.extension.model;

import org.eclipse.bpel.common.BPELResourceSet;
import org.eclipse.bpel.fnmeta.FunctionLibrary;
import org.eclipse.bpel.fnmeta.FunctionRegistry;
import org.eclipse.bpel.fnmeta.IFunctionRegistryLoader;
import org.eclipse.bpel.fnmeta.model.Registry;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class Activator extends Plugin implements IFunctionRegistryLoader {

	/**
	 * The plugin id.
	 */
	
	public static final String PLUGIN_ID = "org.eclipse.bpel.common.model"; //$NON-NLS-1$
	
	/** The shared instance. */
	static public  Activator INSTANCE;
	
	static String FUNCTION_REGISTRY = "functionRegistry";
	static String AT_REGISTRY_NAME_SPACE = "namespace";
	static String AT_URI = "uri";
	
	/**
	 * The constructor.
	 */
	public Activator() {
		// nothing
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		FunctionLibrary.INSTANCE.registerLoader( this );
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		FunctionLibrary.INSTANCE.unregisterLoader( this );
		INSTANCE = null;
	}


	/**
	 * Utility methods for logging exceptions.
	 * @param message 
	 * @param e 
	 * @param severity 
	 */
	public static void log (String message, Throwable e, int severity) {
		
		IStatus status = null;
		
		if (e instanceof CoreException) {
			status = ((CoreException)e).getStatus();
		} else {
			String m = e != null ? e.getMessage() : null;
			
            if (message == null) {
            	if (m == null) {
            		m = "<no message>";
            	}            	
            } else {
            	if (m == null) {
            		m = message;
            	} else {
            		m = message + "[" + m + "]";
            	}
            }
					
			status = new Status(severity, PLUGIN_ID, 0, m, e); //$NON-NLS-1$
		}		
		
		if (Platform.isRunning()) {
			INSTANCE.getLog().log(status);
		} else {
			String msg = java.text.MessageFormat.format(
					"{1,choice,0#msg|1#Info|2#Warning|4#Error}@{0}: {3}",
					status.getPlugin(), 
					status.getSeverity(),
					status.getCode(), 
					status.getMessage() );
			
			System.err.println(msg);
			
			if (status.getException() != null) {
				status.getException().printStackTrace(System.err);
			}
		}		
	}
	
	
	/**
	 * The configuration elements for our extension points
	 * 
	 * @param extensionPointId our extension points 
	 * 
	 * @return the configuration elements.
	 * 
	 */
	
	public IConfigurationElement[] getConfigurationElements (String extensionPointId) {
		String id = getBundle().getSymbolicName();
		
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(id, extensionPointId);
		if (extensionPoint == null) {
			return new IConfigurationElement[] {} ;
		}
		return extensionPoint.getConfigurationElements();
	}
	

	/**
	 * @see org.eclipse.bpel.fnmeta.IFunctionRegistryLoader#load(org.eclipse.bpel.fnmeta.FunctionRegistry)
	 */
	public void load (FunctionRegistry registry) {
		
		for (IConfigurationElement elm : getConfigurationElements( FUNCTION_REGISTRY )) {
			String ns = registry.getLanguageNS();
			if (ns == null || ns.equals(elm.getAttribute(AT_REGISTRY_NAME_SPACE)) == false) {
				continue;					
			}
			
			String location = elm.getAttribute(AT_URI);
			URI uri = URI.createURI( location ) ;
		
			BPELResourceSet rs = new BPELResourceSet();
			Resource resource = rs.getResource(uri, true, "fnmeta");
			
			if (resource.getContents().size() > 0) {
				Registry r = (Registry) resource.getContents().get(0);			
				registry.add( r.getFunctions() );				
			}			
		}		
	}
	
	
}
