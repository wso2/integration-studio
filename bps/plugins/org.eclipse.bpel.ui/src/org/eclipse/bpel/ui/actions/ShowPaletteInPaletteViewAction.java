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
import org.eclipse.gef.ui.views.palette.PaletteView;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.PlatformUI;


/**
 * Show the properties view in the current perspective.
 */

public class ShowPaletteInPaletteViewAction extends ShowViewAction {

	/**
	 * The action ID.
	 */
	
	public static final String ACTION_ID = ShowPaletteInPaletteViewAction.class.getName();
	
	
	/**
	 * Brand new shiny Show Properties View action.
	 */
	
	public ShowPaletteInPaletteViewAction() {
		super();
		setPage(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage());
		setViewID(PaletteView.ID );
		setId(ACTION_ID);
		setText(Messages.ShowPaletteInPaletteViewAction_actionText); 
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
			disabledImage = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_SHOW_PALETTE_VIEW_D);
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
			enabledImage = CommonUIPlugin.getDefault().getImageRegistry().getDescriptor(ICommonUIConstants.ICON_SHOW_PALETTE_VIEW_E);
		}

		return enabledImage;
	}

}
