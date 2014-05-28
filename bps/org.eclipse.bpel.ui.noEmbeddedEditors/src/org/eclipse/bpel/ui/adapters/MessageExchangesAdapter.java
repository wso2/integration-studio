/**
 * <copyright>
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 */
 
package org.eclipse.bpel.ui.adapters;

import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.MessageExchangesEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.bpel.ui.Messages;

/**
 * 
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 */
public class MessageExchangesAdapter extends ContainerAdapter implements EditPartFactory,
	ILabeledElement, IOutlineEditPartFactory, ITrayEditPartFactory
{

	public MessageExchangesAdapter() {
		super();
	}
	
	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		return new ReferenceContainer(BPELPackage.eINSTANCE.getMessageExchanges_Children());
	}

	/* EditPartFactory */

	public EditPart createEditPart(EditPart context, Object model) {
		MessageExchangesEditPart result = new MessageExchangesEditPart();
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
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_MESSAGEEXCHANGE_16); 
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_MESSAGEEXCHANGE_32); 
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.MessageExchangesAdapter_TypeLabel;
	}	
	
	public String getLabel(Object object) {
		return Messages.MessageExchangesAdapter_Label;
	}

	/* IOutlineEditPartFactory */
	
	public EditPart createOutlineEditPart(EditPart context, final Object model) {
		EditPart result = new OutlineTreeEditPart(){
			@Override
			protected List getModelChildren() {
				MessageExchanges messageExchanges = (MessageExchanges) model;
				List list =  messageExchanges.getChildren(); 
				return list;
			}
		};
		result.setModel(model);
		return result;
	}
}
