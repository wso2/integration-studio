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
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.editparts.SequenceEditPart;
import org.eclipse.gef.EditPart;


public class ForEachAdapter extends ContainerActivityAdapter implements IAnnotatedElement {

	/* IContainer delegate */
	
	@Override
	public IContainer createContainerDelegate() {
		return new ActivityContainer(BPELPackage.eINSTANCE.getForEach_Activity());
	}

	/* EditPartFactory */
	
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new SequenceEditPart();
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

	/* IAnnotatedElement */
	
	public String[] getAnnotation(Object object) {
		ForEach obj = (ForEach)object;
		return new String[] {
			Messages.ForEachAdapter_2, AnnotationHelper.getAnnotation(obj.getCounterName()),
			Messages.ForEachAdapter_0, AnnotationHelper.getAnnotation(obj.getStartCounterValue()),
			Messages.ForEachAdapter_1, AnnotationHelper.getAnnotation(obj.getStartCounterValue()),
			};
	}
	@Override
	public boolean canAddObject(Object object, Object child, Object insertBefore) {
		ForEach forEach = (ForEach)object;
		if (forEach.getActivity()==null && child instanceof Scope) {
			return getContainerDelegate(object).canAddObject(object, child, insertBefore);
		}
		else
			return false;
}

}
