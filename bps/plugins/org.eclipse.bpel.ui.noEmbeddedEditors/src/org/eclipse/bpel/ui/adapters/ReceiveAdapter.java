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

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.actions.editpart.SetPartnerLinkAction;
import org.eclipse.bpel.ui.actions.editpart.SetVariableAction;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.wst.wsdl.Operation;


public class ReceiveAdapter extends ActivityAdapter implements IAnnotatedElement {

	/* IEditPartActionContributor */
	
	@Override
	public List getEditPartActions(final EditPart editPart) {
		List actions = super.getEditPartActions(editPart);

		actions.add(new SetPartnerLinkAction(editPart));
		actions.add(new SetVariableAction(editPart, SetVariableAction.REQUEST));

		return actions;
	}

	/* IAnnotatedElement */
	
	public String[] getAnnotation(Object object) {
		PartnerLink pLink = ModelHelper.getPartnerLink(object);
		Operation operation = ModelHelper.getOperation(object);
		Variable inVar = ModelHelper.getVariable(object, ModelHelper.OUTGOING);
		Role myRole = pLink != null ? pLink.getMyRole() : null;
		Role partnerRole = pLink != null ? pLink.getPartnerRole() : null;
		
		return new String[] {
			Messages.PARTNER_LINK, AnnotationHelper.getAnnotation(pLink),
			Messages.OPERATION, AnnotationHelper.getAnnotation(operation),
			Messages.INPUT, AnnotationHelper.getAnnotation(inVar),		
			Messages.MY_ROLE, AnnotationHelper.getAnnotation(myRole),
			Messages.PARTNER_ROLE, AnnotationHelper.getAnnotation(partnerRole)
		};
	}
}
