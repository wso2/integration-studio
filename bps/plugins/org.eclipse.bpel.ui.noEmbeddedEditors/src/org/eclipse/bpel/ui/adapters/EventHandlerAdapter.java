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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.actions.editpart.CreateOnAlarmAction;
import org.eclipse.bpel.ui.actions.editpart.CreateOnEventAction;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.FaultHandlerEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class EventHandlerAdapter extends ContainerAdapter implements ILabeledElement,
	IOutlineEditPartFactory, EditPartFactory, IEditPartActionContributor
{

	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getEventHandler_Events()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getEventHandler_Alarm()));
		return omc;
	}

	/* ILabeledElement */

	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(
				IBPELUIConstants.ICON_EVENTHANDLER_16);
	}

	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(
				IBPELUIConstants.ICON_EVENTHANDLER_32);
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.EventHandlerAdapter_Event_Handlers_1; 
	}	
	
	public String getLabel(Object object){
		return getTypeLabel(object);
	}
	
	/* EditPartFactory */
	
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new FaultHandlerEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */
	
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}

	/* IEditPartActionContributor */
	
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = new ArrayList<AbstractAction>();

		actions.add(new CreateOnEventAction(editPart));
		actions.add(new CreateOnAlarmAction(editPart));
		
		return actions;
	}
}
