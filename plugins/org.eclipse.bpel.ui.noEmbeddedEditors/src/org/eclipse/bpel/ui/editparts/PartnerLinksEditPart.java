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
package org.eclipse.bpel.ui.editparts;

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;

/**
 * Interface Partners.
 */
public class PartnerLinksEditPart extends BPELTrayCategoryEditPart {
	
	/**
	 * Only add inbound partners.
	 */
	@Override
	protected List<PartnerLink> getModelChildren() {
		return getPartnerLinks().getChildren();
//		
//		List result = new ArrayList();
//		for (Iterator iter = getPartnerLinks().getChildren().iterator(); iter.hasNext();) {
//			PartnerLink	partner = (PartnerLink) iter.next();
//			if (ModelHelper.isInterfacePartnerLink(partner)) {
//				result.add(partner);
//			}
//		}
//		return result;
	}

//	protected Object addEntry() {		
//		CompoundCommand compound = new CompoundCommand();
//		EObject parent = getPartnerLinks();
//		final PartnerLink partner = (PartnerLink) getCreationFactory().getNewObject();
//		compound.add(new InsertInContainerCommand(parent, partner, null));
//		Definition artifactsDefinition = getBPELEditor().getArtifactsDefinition();
//		PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
//		Process process = ModelHelper.getProcess(parent);
//		compound.add(ModelHelper.getCreatePartnerLinkTypeCommand(process, partner, plt, artifactsDefinition, getRoleKind()));
//		getCommandStack().execute(compound);
//		// direct edit
//		getViewer().getControl().getDisplay().asyncExec(new Runnable() {
//			public void run() {
//				EditPart part = selectEditPart(partner);
//				part.performRequest(new DirectEditRequest());
//			}
//		});
//		return partner;
//	}
	
	protected int getRoleKind() {
		return ModelHelper.MY_ROLE;
	}
	
	protected PartnerLinks getPartnerLinks() {
		return (PartnerLinks)getModel();
	}
	
	protected EObject getContainer() {
		return getPartnerLinks().eContainer();
	}

	protected BPELEditor getBPELEditor() {
		return ModelHelper.getBPELEditor(getContainer());
	}
	
	@Override
	protected CreationFactory getCreationFactory() {
		return UIObjectFactoryProvider.getInstance().getFactoryFor(BPELPackage.eINSTANCE.getPartnerLink());
	}
	
	@Override
	protected IFigure getAddToolTip() {
	    return new Label(Messages.PartnerLinksEditPart_0); 
	}
	
	@Override
	protected IFigure getRemoveToolTip() {
	    return new Label(Messages.PartnerLinksEditPart_1); 
	}

	@Override
	protected Adapter createAdapter() {
		return new BatchedMultiObjectAdapter() {
			@Override
			public void finish() {
				refresh();
			}
			@Override
			public void notify(Notification n) {
			}
		};
	}
	
}
