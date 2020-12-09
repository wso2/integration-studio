/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;

public class CreateMessageExchangeAction extends AbstractDeclarationAction {

	public CreateMessageExchangeAction(EditPart anEditPart) {
		super(anEditPart);
	}

	@Override
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_MESSAGEEXCHANGE_16);
	}

	@Override
	public EObject getParent() {
		EStructuralFeature feature = ((EObject)modelObject).eClass().getEStructuralFeature("messageExchanges");
		if (feature!=null) {
			parent = (EObject) ((EObject)modelObject).eGet(feature);
		}
		return parent;
	}

	@Override
	public EObject getChild() {
		if (child==null)
			child = BPELFactory.eINSTANCE.createMessageExchange();
		return child;
	}
}
