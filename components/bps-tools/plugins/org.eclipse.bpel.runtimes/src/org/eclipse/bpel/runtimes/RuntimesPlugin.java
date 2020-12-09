/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class RuntimesPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.bpel.runtimes"; //$NON-NLS-1$
	
	//The shared instance.
	private static RuntimesPlugin plugin;
	
	private boolean imagesInitialized = false;
	
	/**
	 * The constructor.
	 */
	public RuntimesPlugin() {
		super();
	}

	/**
	 * This method is called upon plug-in activation
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance.
	 */
	public static RuntimesPlugin getPlugin() {
		return plugin;
	}
	
	@Override
	public ImageRegistry getImageRegistry() {
		ImageRegistry result = super.getImageRegistry();
		initialize();
		return result;
	}
	
	/**
	 * Returns the image descriptor for the given image ID.
	 * Returns null if there is no such image.
	 */
	public ImageDescriptor getImageDescriptor(String id) {
		return getImageRegistry().getDescriptor(id);
	}
	
	public Image getImage(String id) {
		return getImageRegistry().get(id);
	}
	
	/**
	 * Creates an image descriptor and places it in the image registry.
	 */
	private void createImageDescriptor(String id, URL baseURL) {
		URL url = null;
		try {
			url = new URL(baseURL, IRuntimesUIConstants.ICON_PATH + id);
		} catch (MalformedURLException e) {
			RuntimesPlugin.log(e);
		}
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		getImageRegistry().put(id, desc);
	}
	
	protected void initialize() {
		if (!imagesInitialized) {
			imagesInitialized = true;
			initializeImages();
		}
	}
	
	/**
	 * Initializes the table of images used in this plugin.
	 */
	private void initializeImages() {
		URL baseURL = getBundle().getEntry("/"); //$NON-NLS-1$

		// TODO make sure you initialize all required icons here
		createImageDescriptor(IRuntimesUIConstants.ICON_NEWPRJ_WIZARD_BANNER, baseURL);
		createImageDescriptor(IRuntimesUIConstants.ICON_BPEL_NEW_PRJ, baseURL);
		createImageDescriptor(IRuntimesUIConstants.ICON_BPEL_PRJ, baseURL);
	}
	
	/**
	 * Utility methods for logging exceptions.
	 */
	public static void log(Exception e, int severity) {
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException)e).getStatus();
		} else {
			String m = e.getMessage();
			status = new Status(severity, PLUGIN_ID, 0, m==null? "<no message>" : m, e); //$NON-NLS-1$
		}
		System.out.println(e.getClass().getName()+": "+status); //$NON-NLS-1$
		RuntimesPlugin.getPlugin().getLog().log(status);
	}
	
	public static void log(Exception e) { 
		log(e, IStatus.ERROR); 
	}
}
