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
package org.eclipse.bpel.ui.adapters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.adapters.AbstractAdapter;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.actions.editpart.CreateProcessEventHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.CreateProcessFaultHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.IEditPartAction;
import org.eclipse.bpel.ui.editparts.StartNodeEditPart;
import org.eclipse.bpel.ui.uiextensionmodel.StartNode;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class StartNodeAdapter extends AbstractAdapter implements EditPartFactory, ILabeledElement, IEditPartActionContributor {

	/* ILabeledElement */
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(
			IBPELUIConstants.ICON_STARTNODE_16_GIF);
	}

	public Image getLargeImage(Object object) {
		// There is no large image for the start node.
		return null;
	}	

	public String getLabel(Object object) {
		return getTypeLabel(object);
	}
	
	public String getTypeLabel(Object object) {
		return Messages.StartNodeAdapter_Start_1; 
	}

	/* EditPartFactory */

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new StartNodeEditPart();
		result.setModel(model);
		return result;
	}
	
	/* IEditPartActionContributor */
	
	public List<IEditPartAction> getEditPartActions(final EditPart editPart) {
		List<IEditPartAction> actions = new ArrayList<IEditPartAction>();
		StartNode startNode = (StartNode)editPart.getModel();
	    Process process = startNode.getProcess();
		
		IFaultHandlerHolder ifh =  BPELUtil.adapt(process, IFaultHandlerHolder.class);
		if (ifh != null && ifh.getFaultHandler(process) == null) {
			actions.add(new CreateProcessFaultHandlerAction(editPart));
		}			
		IEventHandlerHolder ieh = BPELUtil.adapt(process, IEventHandlerHolder.class);
		if (ieh != null && ieh.getEventHandler(process) == null) {
	    	actions.add(new CreateProcessEventHandlerAction(editPart));
		}
		return actions;
	}
}
