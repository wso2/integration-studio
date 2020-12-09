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
package org.eclipse.bpel.model;

import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.model.adapters.BasicBPELAdapterFactory;
import org.eclipse.core.internal.runtime.RuntimeLog;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Logger;
import org.eclipse.emf.common.util.ResourceLocator;


/**
 * The {@link org.eclipse.core.runtime.Plugin} for the BPEL model.
 * <p>
 * The BPEL model must run 
 * within an Eclipse workbench, 
 * within an Eclipse headless workspace
 * or stand-alone outside of Eclipse.
 * To support this BPELPlugin extends {@link org.eclipse.emf.common.EMFPlugin}.
 */

@SuppressWarnings({ "nls", "boxing" })

public class BPELPlugin extends EMFPlugin 
{
	/**
	 * The singleton instance of the BPEL plugin.
	 */
	public static final BPELPlugin INSTANCE = new BPELPlugin();

	/**
	 * The plugin id.
	 */
	
	public static final String PLUGIN_ID = "org.eclipse.bpel.model"; //$NON-NLS-1$

	/**
	 * The one instance of the Eclipse plugin.  
	 * This is <code>null</code> if Eclipse is not running.
	 */
	private static Implementation plugin;

	/**
	 * 
	 */
	public BPELPlugin()
	{
		super(new ResourceLocator[] {});
		
		/** The basic adapter factory for our EMF objects */
		
		AdapterRegistry.INSTANCE.registerAdapterFactory(				
				BPELPackage.eINSTANCE,
				BasicBPELAdapterFactory.INSTANCE
		);
		
	}

	/** 
	 * @return Returns an Eclipse plugin. 
	 */
	public static Implementation getPlugin()
	{
		return plugin;
	}

	/**
	 * @see org.eclipse.emf.common.EMFPlugin#getPluginResourceLocator()
	 */
	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipsePlugin
	{
		/**
	     * Creates an instance.
	     */
	    public Implementation()
	    {
			// Remember the static instance.
			plugin = this;
		}

		/**
		 * Returns the workspace instance.
		 * @return 
		 */
		public static IWorkspace getWorkspace()
		{
			return ResourcesPlugin.getWorkspace();
		}		
	}

	/**
	 * Utility methods for logging exceptions.
	 * @param message 
	 * @param e 
	 * @param severity 
	 */
	
	public static void logMessage (String message, Throwable e, int severity) {
		
		IStatus status = new Status(severity, PLUGIN_ID, 0, message, e); 
		Logger logger = INSTANCE.getPluginLogger();
		logger.log(status);
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
		Logger logger = INSTANCE.getPluginLogger();
		if (logger != null) {
			logger.log(status);
		} else if (Platform.isRunning()) {
			RuntimeLog.log(status);
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
	
	/** Log a throwable in the error log.
	 * 
	 * @param message
	 * @param e
	 */
	public static void log (String message, Throwable e) 
	{ 
		log (message, e, IStatus.ERROR); 
	}	
	
	
}
