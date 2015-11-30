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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;


/**
 * Show view action. This action attempts to show the given view.
 * 
 * @author IBM
 * 
 */

public class ShowViewAction extends Action {

	protected IWorkbenchPage page;

	protected String viewID;

	protected ImageDescriptor enabledImage;

	protected ImageDescriptor disabledImage;

	/**
	 *  
	 */
	public ShowViewAction() {
		super();
	}

	/**
	 * @param text
	 */
	public ShowViewAction(String text) {
		super(text);
	}

	/**
	 * @param text
	 * @param image
	 */
	public ShowViewAction(String text, ImageDescriptor image) {
		super(text, image);
	}

	/**
	 * @param text
	 * @param image
	 * @param aPage -
	 *            workbench page to open view on
	 * @param aViewId -
	 *            ID of the view to open
	 */
	public ShowViewAction(String text, ImageDescriptor image, IWorkbenchPage aPage, String aViewId) {
		super(text, image);
		setPage(aPage);
		setViewID(aViewId);
	}

	/**
	 * @param text
	 * @param aPage -
	 *            workbench page to open view on
	 * @param aViewID -
	 *            ID of the view to open
	 */
	public ShowViewAction(String text, IWorkbenchPage aPage, String aViewID) {
		super(text);
		setPage(aPage);
		setViewID(aViewID);
	}

	/**
	 * @param text
	 * @param style
	 */
	public ShowViewAction(String text, int style) {
		super(text, style);
	}

	/**
	 * @return Returns the page.
	 */
	public IWorkbenchPage getPage() {
		return page;
	}

	/**
	 * @param aPage
	 *            The page to set.
	 */
	public void setPage(IWorkbenchPage aPage) {
		this.page = aPage;
	}

	/**
	 * @return Returns the viewID.
	 */
	public String getViewID() {
		return viewID;
	}

	/**
	 * @param aViewID
	 *            The viewID to set.
	 */
	public void setViewID(String aViewID) {
		this.viewID = aViewID;
	}

	/** 
	 * 
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	
	@Override
	public void run() {
		if (page == null || viewID == null) {
			return ;
		}
				
		try {
			for(IViewReference reference : page.getViewReferences() ) {
				if (viewID.equals( reference.getId() ) ) {
					// that's our view.
					page.showView(viewID,null,IWorkbenchPage.VIEW_ACTIVATE);
					return ;
				}
			}

			page.showView(viewID, null, IWorkbenchPage.VIEW_CREATE);
			page.showView(viewID, null,  IWorkbenchPage.VIEW_ACTIVATE);
			
		} catch (PartInitException pie) {
			CommonUIPlugin.log(pie);
		}
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}
	
	
	
}
