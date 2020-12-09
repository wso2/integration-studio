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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.FaultHandlerEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class TerminationHandlerAdapter extends ContainerAdapter implements ILabeledElement,
	IOutlineEditPartFactory, EditPartFactory
{

	/* ILabeledElement */

	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_TERMINATIONHANDLER_16);
	}

	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_TERMINATIONHANDLER_32);
	}


	public String getTypeLabel(Object object) {
		return Messages.TerminationHandlerAdapter_Termination_Handlers_1;
	}

	public String getLabel(Object object){
		return getTypeLabel(object);
	}

	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		return new ActivityContainer(BPELPackage.eINSTANCE.getTerminationHandler_Activity());
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
}
