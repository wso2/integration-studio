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
package org.eclipse.bpel.common.ui.figures;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.ResizeHandle;


/**
 * Override the normal ResizeHandle to provide a custom handle
 * locator. This is required to move the handles out of the absolute
 * corners and closer to the actual figure outline.
 */
public class InsetResizeHandle extends ResizeHandle {
	
	protected int fDirection;	
	
	/**
	 * 
	 * @param owner
	 * @param direction
	 * @param verticalInset
	 * @param horizontalInset
	 */
	public InsetResizeHandle(GraphicalEditPart owner, int direction, int verticalInset, int horizontalInset) {
		
		super (owner, direction);
		this.fDirection = direction;
		setLocator(new InsetRelativeHandleLocator(owner.getContentPane(), direction, verticalInset, horizontalInset));
		
//		selectionColor = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_SELECTION);
//		ColorRegistry registry = CommonUIPlugin.getDefault().getColorRegistry();
//		selectionCornerColor = registry.get(ICommonUIConstants.COLOR_SELECTION_HANDLE_CORNER);
	}
	
}
