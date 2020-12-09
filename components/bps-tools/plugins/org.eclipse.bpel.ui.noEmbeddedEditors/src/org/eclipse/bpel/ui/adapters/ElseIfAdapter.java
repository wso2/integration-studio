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
import org.eclipse.bpel.model.ElseIf;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.ElseIfEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class ElseIfAdapter extends ContainerAdapter implements ILabeledElement,
	EditPartFactory, IOutlineEditPartFactory, IExtensionFactory, IAnnotatedElement
{

	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		// TODO: IfAdapter ensures the ElseIf always has an activity inside it,
		// by creating an ImplicitSequence if the ElseIf was empty.  We then make
		// sure we don't delete the last activity from the ElseIf.
		// See also IfAdapter. Rethink this in the future.
		return new ActivityContainer(BPELPackage.eINSTANCE.getElseIf_Activity());
	}

	/* ILabeledElement */

	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_CASE_16);
	}

	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_CASE_32);
	}

	public String getTypeLabel(Object object) {
		String s = Messages.ElseIfAdapter_ElseIf_1;
		return s;
	}

	public String getLabel(Object object) {
		String s = ModelHelper.getDisplayName(object);
		if (s != null && !("".equals(s))) return s; //$NON-NLS-1$
		return getTypeLabel(object);
	}

	/* EditPartFactory */

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new ElseIfEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */

	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}

	/* IExtensionFactory */

	public EObject createExtension(EObject object) {
		return UiextensionmodelFactory.eINSTANCE.createCaseExtension();
	}

	/* IAnnotatedElement */

	public String[] getAnnotation(Object object) {
		Expression expression = ((ElseIf)object).getCondition();
		return new String[] {
				org.eclipse.bpel.ui.adapters.Messages.CONDITION, AnnotationHelper.getAnnotation(expression)
			};
	}
}
