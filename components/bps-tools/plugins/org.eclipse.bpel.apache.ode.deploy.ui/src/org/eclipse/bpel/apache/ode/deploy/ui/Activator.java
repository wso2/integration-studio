/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Tammo van Lessen (IAAS)
 * @author Simon Moser (IBM)
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.bpel.apache.ode.deploy.ui"; //$NON-NLS-1$
	
	// The editor ID
	public static final String EDITOR_ID = "org.eclipse.bpel.apache.ode.deploy.ui.editors.ODEDeployMultiPageEditor"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	// shared images
	public static final String IMG_ODE = "ode16"; //$NON-NLS-1$
	public static final String IMG_CHECKED = "checked"; //$NON-NLS-1$
	public static final String IMG_UNCHECKED = "unchecked"; //$NON-NLS-1$
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put(IMG_ODE, getImageDescriptor("icons/obj16/ode.gif")); //$NON-NLS-1$
		reg.put(IMG_CHECKED, getImageDescriptor("icons/obj16/checked.gif")); //$NON-NLS-1$
		reg.put(IMG_UNCHECKED, getImageDescriptor("icons/obj16/unchecked.gif")); //$NON-NLS-1$
	}
	
	
}
