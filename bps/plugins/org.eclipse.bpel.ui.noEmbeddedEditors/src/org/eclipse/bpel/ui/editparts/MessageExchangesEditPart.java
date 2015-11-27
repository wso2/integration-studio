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
 
package org.eclipse.bpel.ui.editparts;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.MessageExchanges;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;

/**
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 */

public class MessageExchangesEditPart extends BPELTrayCategoryEditPart {

	@Override
	protected CreationFactory getCreationFactory() {
		return UIObjectFactoryProvider.getInstance().getFactoryFor(BPELPackage.eINSTANCE.getMessageExchange());
	}
	

	@Override
	protected EList<MessageExchange> getModelChildren() {
		return getMessageExchanges().getChildren();
	}

	protected MessageExchanges getMessageExchanges() {
		return (MessageExchanges)getModel();
	}
	
	protected EObject getContainer() {
		return getMessageExchanges().eContainer();
	}

	protected BPELEditor getBPELEditor() {
		return ModelHelper.getBPELEditor(getContainer());
	}

	@Override
	protected IFigure getAddToolTip() {
	    return new Label(Messages.MessageExchangesEditPart_Add_Message_Exchange_1); 
	}
	
	@Override
	protected IFigure getRemoveToolTip() {
	    return new Label(Messages.MessageExchangesEditPart_Remove_Message_Exchange_1); 
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
