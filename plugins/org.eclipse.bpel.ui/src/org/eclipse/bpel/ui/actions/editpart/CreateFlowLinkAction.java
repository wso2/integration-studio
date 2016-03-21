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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BPELConnectionCreationTool;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


public class CreateFlowLinkAction extends AbstractAction {

	private BPELConnectionCreationTool linkConnectionTool;

	public CreateFlowLinkAction(EditPart editPart) {
		super(editPart);
	}

	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_LINK_16);
	}

	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_LINK_16);
	}

	public boolean onButtonPressed() {
		// TODO: There should be a pre-created factory owned by the
		// editor and passed in to action bars.
		linkConnectionTool = new BPELConnectionCreationTool(
			UIObjectFactoryProvider.getInstance().getFactoryFor(
			BPELPackage.eINSTANCE.getLink()));
		BPELConnectionCreationTool tool = linkConnectionTool;
		viewer.getEditDomain().setActiveTool(tool);
		tool.setInitialAnchor(editPart, viewer);
		return true;
	}

	public String getToolTip() {
		return Messages.CreateFlowLinkAction_Add_Link_0; 
	}
	
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	@Override
	public boolean isEnabled() { return true; }	
}