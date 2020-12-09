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
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.delegates.IndirectContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.editparts.ReferencePartnerLinksEditPart;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class ReferencePartnerLinksAdapter extends ContainerAdapter implements EditPartFactory,
	ILabeledElement, IOutlineEditPartFactory, ITrayEditPartFactory
{

	/* IContainer delegate */
	
	@Override
	public IContainer createContainerDelegate() {
		return new IndirectContainer(BPELPackage.eINSTANCE.getProcess_Activity(), // bogus feature 
			new ReferenceContainer(BPELPackage.eINSTANCE.getPartnerLinks_Children()))
		{
			@Override
			protected EObject getTarget(Object object) {
				return ((ReferencePartnerLinks)object).getPartnerLinks();
			}
		};
	}

	/* EditPartFactory */
	
	public EditPart createEditPart(EditPart context, Object model) {
		ReferencePartnerLinksEditPart result = new ReferencePartnerLinksEditPart();
		result.setLabelProvider(PropertiesLabelProvider.getInstance());
		result.setModel(model);
		return result;
	}
	
	/* ITrayEditPartFactory */
	
	public EditPart createTrayEditPart(EditPart context, Object model) {
		return createEditPart(context, model);
	}
	
	/* ILabeledElement */

	public Image getSmallImage(Object object) {
		String imageName = IBPELUIConstants.ICON_PARTNER_OUT_16;
		return BPELUIPlugin.INSTANCE.getImage(imageName);
	}
	
	public Image getLargeImage(Object object) {
		String imageName = IBPELUIConstants.ICON_PARTNER_OUT_16;
		return BPELUIPlugin.INSTANCE.getImage(imageName);
	}
	
	public String getTypeLabel(Object object) {
		return Messages.PartnerLinksEditPart_Partners_1; 
	}
	
	public String getLabel(Object object) {
		return Messages.ReferencePartnerLinksAdapter_0; 
	}

	/* IOutlineEditPartFactory */
	
	public EditPart createOutlineEditPart(EditPart context, final Object model) {
		EditPart result = new OutlineTreeEditPart() {
			@Override
			protected List getModelChildren() {
				List list = new ArrayList();
				for (Iterator iter = ((ReferencePartnerLinks)model).getPartnerLinks().getChildren().iterator(); iter.hasNext();) {
					PartnerLink	partner = (PartnerLink) iter.next();
					if (ModelHelper.isReferencePartnerLink(partner) && !ModelHelper.isInterfacePartnerLink(partner)) {
						list.add(partner);
					}
				}
				return list;
			}
			@Override
			protected void addAllAdapters() {
				PartnerLinks partnerLinks = ((ReferencePartnerLinks)getModel()).getPartnerLinks();
				adapter.addToObject(partnerLinks);
				if (partnerLinks.eResource() != null) {
					EObject extension = ModelHelper.getExtension(partnerLinks);
					((Notifier)getModel()).eAdapters().add(adapter);
					if (extension != null) adapter.addToObject(extension);
				}
			}
		};
		result.setModel(model);
		return result;
	}
}
