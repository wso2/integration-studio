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

import org.eclipse.bpel.ui.BPELLinkCreationFactory;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.util.BPELConnectionCreationTool;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


public class SetCompensateLinkAction extends AbstractAction {
	// TODO: We shouldn't be creating tools all the time.
	private AbstractTool compensateTool = null;

	public SetCompensateLinkAction(EditPart editPart) {
		super(editPart);
	}

	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_COMPENSATE);
	}

	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_COMPENSATE);
	}

	public boolean onButtonPressed() {
		compensateTool = new BPELConnectionCreationTool(new BPELLinkCreationFactory(BPELLinkCreationFactory.CompensateTempLink.class));
		BPELConnectionCreationTool tool = (BPELConnectionCreationTool) compensateTool;
		viewer.getEditDomain().setActiveTool(tool);
		tool.setInitialAnchor(editPart, editPart.getViewer());
		return true;
	}

	public String getToolTip() {
		return Messages.SetCompensateLinkAction_Set_Compensate_1; 
	}
	
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	@Override
	public boolean isEnabled() { return true; }	
}