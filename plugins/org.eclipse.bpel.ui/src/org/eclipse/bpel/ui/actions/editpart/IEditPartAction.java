/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.actions.editpart;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * An edit part action is an action that is executed on the edit part. 
 * 
 * @author IBM Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 *
 */
public interface IEditPartAction {
	/**
	 * Return the icon to show when the action is enabled.
	 * 
	 * @return the enabled icon for this action 
	 */
	
	public ImageDescriptor getIcon();
	
	/**
	 * Return the icon to show when the action is disabled.
	 *  
	 * @return the disabled icon for this action
	 */
	public ImageDescriptor getDisabledIcon();
	
	/** 
	 * The tool tip for the action.
	 * 
	 * @return the tool tip to show
	 */
	public String getToolTip();
	
	/**
	 * Whether the action is enabled or disabled.
	 * @return true if enabled, false otherwise.
	 */
	
	public boolean isEnabled();
	
	/**
	 * When the action is run, this method is called.
	 * @return ?
	 */
	public boolean onButtonPressed();
	
	/**
	 * Internal dispose handler ?
	 * 
	 * TODO: This is not used anywhere ?
	 */
	public void onDispose();
	
	
	/**
	 * Internal onCreate handler ?
	 * 
	 * TODO: Not used anywhere.
	 */
	public void onCreate();
}
