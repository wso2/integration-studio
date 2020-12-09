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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.resource.ImageDescriptor;


/**
 * @author IBM Original contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 *
 */

public abstract class AbstractAction implements IEditPartAction {
	
	protected final Object modelObject;
	protected final EditPart editPart;
	protected final EditPartViewer viewer;

	/**
	 * Brand new shiny AbstractAction object.
	 * @param anEditPart
	 */
	public AbstractAction(EditPart anEditPart) {
		super();
		this.editPart = anEditPart;
		
		this.modelObject = anEditPart.getModel();		
		this.viewer = anEditPart.getViewer();
	}

	// default implementations for uncommonly-used methods
	
	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#onDispose()
	 */
	public void onDispose() { 		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#onCreate()
	 */
	public void onCreate() { 
		
	}
	
	/** 
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getDisabledIcon()
	 */
	public ImageDescriptor getDisabledIcon() { 
		return ImageDescriptor.getMissingImageDescriptor(); 
	}
	
	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#isEnabled()
	 */
	public boolean isEnabled() { 
		return true; 
	}
	
}