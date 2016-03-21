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
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.actions.editpart.SetPartnerLinkAction;
import org.eclipse.bpel.ui.actions.editpart.SetVariableAction;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.InvokeEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.wst.wsdl.Operation;


public class InvokeAdapter extends ContainerActivityAdapter implements EditPartFactory,
	IOutlineEditPartFactory, IFaultHandlerHolder, ICompensationHandlerHolder, IAnnotatedElement
{

	/* IContainer delegate */
	
	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getInvoke_FaultHandler()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getInvoke_CompensationHandler()));
		return omc;
	}

	/* IOutlineEditPartFactory */
	
	@Override
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}
	
	/* IFaultHandlerHolder */

	public FaultHandler getFaultHandler(Object object) {
		return ((Invoke)object).getFaultHandler();
	}
	
	public void setFaultHandler(Object object, FaultHandler faultHandler) {
		((Invoke)object).setFaultHandler(faultHandler);
	}
	
	/* ICompensationHandlerHolder */

	public CompensationHandler getCompensationHandler(Object object) {
		return ((Invoke)object).getCompensationHandler();
	}

	public void setCompensationHandler(Object object, CompensationHandler compensationHandler) {
		((Invoke)object).setCompensationHandler(compensationHandler);
	}
	
	/* IEditPartActionContributor */
	
	@Override
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = super.getEditPartActions(editPart);
		actions.add(new SetPartnerLinkAction(editPart));
		actions.add(new SetVariableAction(editPart, SetVariableAction.REQUEST));
		actions.add(new SetVariableAction(editPart, SetVariableAction.RESPONSE));
		return actions;
	}
	
	/* EditPartFactory */

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new InvokeEditPart();
		result.setModel(model);
		return result;
	}

	/* IAnnotatedElement */
	
	public String[] getAnnotation(Object object) {
		PartnerLink pLink = ModelHelper.getPartnerLink(object);
		Operation operation = ModelHelper.getOperation(object);
		Variable inVar = ModelHelper.getVariable(object, ModelHelper.OUTGOING);
		Variable outVar = ModelHelper.getVariable(object, ModelHelper.INCOMING);
		Role myRole = pLink != null ? pLink.getMyRole() : null;
		Role partnerRole = pLink != null ? pLink.getPartnerRole() : null;
		
		return new String[] {
			Messages.PARTNER_LINK, AnnotationHelper.getAnnotation(pLink),
			Messages.OPERATION, AnnotationHelper.getAnnotation(operation),
			Messages.INPUT, AnnotationHelper.getAnnotation(inVar),		
			Messages.OUTPUT, AnnotationHelper.getAnnotation(outVar),
			Messages.MY_ROLE, AnnotationHelper.getAnnotation(myRole),
			Messages.PARTNER_ROLE, AnnotationHelper.getAnnotation(partnerRole)
		};
	}
}
