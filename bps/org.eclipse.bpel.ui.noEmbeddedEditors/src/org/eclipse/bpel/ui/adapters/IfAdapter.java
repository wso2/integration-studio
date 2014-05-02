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

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.ui.actions.editpart.CreateElseAction;
import org.eclipse.bpel.ui.actions.editpart.CreateElseIfAction;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.IfEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.gef.EditPart;


public class IfAdapter extends ContainerActivityAdapter implements IAnnotatedElement {

	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ActivityContainer(BPELPackage.eINSTANCE.getIf_Activity()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getIf_ElseIf()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getIf_Else()));
		return omc;
	}

	/* EditPartFactory */

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new IfEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */

	@Override
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}

	/* IEditPartActionContributor */

	@Override
	public List getEditPartActions(final EditPart editPart) {
		List actions = super.getEditPartActions(editPart);
		Object modelObject = editPart.getModel();

		actions.add(new CreateElseIfAction(editPart));

		if (((If)modelObject).getElse() == null) {
			actions.add(new CreateElseAction(editPart));
		}
		return actions;
	}

	/* IAnnotatedElement */

	public String[] getAnnotation(Object object) {
		Expression expression = ((If)object).getCondition();
		return new String[] {
			Messages.CONDITION, AnnotationHelper.getAnnotation(expression)
		};
	}
}
