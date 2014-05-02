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
package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.ICommonUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;


/**
 * Show the properties view in the current perspective.
 */

public class ShowPropertiesViewAction extends ShowViewAction {

	/**
	 * The action ID.
	 */
	
	public static final String ACTION_ID = "org.eclipse.bpel.common.ui.actions.ShowPropertiesAction"; //$NON-NLS-1$
	
	/** 
	 * The view ID.
	 */
	
	public static final String VIEW_ID = "org.eclipse.ui.views.PropertySheet"; //$NON-NLS-1$
	
	/**
	 * Brand new shiny Show Properties View action.
	 */
	
	public ShowPropertiesViewAction() {
		super();
		setPage(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
		setViewID(VIEW_ID);
		setId(ACTION_ID);
		setText(Messages.ShowPropertiesViewAction_actionText); 
		setToolTipText(getText());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.IAction#getDisabledImageDescriptor()
	 */
	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		if (disabledImage == null) {
			disabledImage = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_SHOW_PROP_VIEW_D);
		}
		return disabledImage;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.IAction#getImageDescriptor()
	 */
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		if (enabledImage == null) {
			enabledImage = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_SHOW_PROP_VIEW_E);
		}

		return enabledImage;
	}

}
