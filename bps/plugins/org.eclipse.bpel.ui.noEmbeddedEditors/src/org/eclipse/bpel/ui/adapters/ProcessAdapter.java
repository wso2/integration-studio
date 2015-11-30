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
import java.util.List;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.actions.CreateCorrelationSetAction;
import org.eclipse.bpel.ui.actions.CreateMessageExchangeAction;
import org.eclipse.bpel.ui.actions.CreateVariableAction;
import org.eclipse.bpel.ui.actions.CreatePartnerLinkAction;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.actions.editpart.IEditPartAction;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.adapters.delegates.IndirectContainer;
import org.eclipse.bpel.ui.adapters.delegates.MultiContainer;
import org.eclipse.bpel.ui.adapters.delegates.ReferenceContainer;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.bpel.ui.editparts.ProcessOutlineEditPart;
import org.eclipse.bpel.ui.editparts.ProcessTrayEditPart;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


public class ProcessAdapter extends ContainerAdapter implements INamedElement,
	EditPartFactory, IOutlineEditPartFactory, IFaultHandlerHolder,
	ILabeledElement, IEventHandlerHolder, ITrayEditPartFactory,
	IExtensionFactory, IEditPartActionContributor
{
	
	/* IContainer delegate */

	@Override
	public IContainer createContainerDelegate() {
		MultiContainer omc = new MultiContainer();
		omc.add(new ActivityContainer(BPELPackage.eINSTANCE.getProcess_Activity()));
		omc.add(new IndirectContainer(BPELPackage.eINSTANCE.getProcess_PartnerLinks(),			
			new ReferenceContainer(BPELPackage.eINSTANCE.getPartnerLinks_Children())));
		omc.add(new IndirectContainer(BPELPackage.eINSTANCE.getProcess_CorrelationSets(),			
			new ReferenceContainer(BPELPackage.eINSTANCE.getCorrelationSets_Children())));
		omc.add(new IndirectContainer(BPELPackage.eINSTANCE.getProcess_Variables(),			
			new ReferenceContainer(BPELPackage.eINSTANCE.getVariables_Children())));
		omc.add(new IndirectContainer(BPELPackage.eINSTANCE.getProcess_MessageExchanges(),			
				new ReferenceContainer(BPELPackage.eINSTANCE.getMessageExchanges_Children())));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getProcess_FaultHandlers()));
		omc.add(new ReferenceContainer(BPELPackage.eINSTANCE.getProcess_EventHandlers()));
		return omc;
	}

	/* INamedElement */

	public String getName(Object namedElement) {
		return ((Process)namedElement).getName();
	}

	public void setName(Object namedElement, String name) {
		((Process)namedElement).setName(name);
	}

	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(Process.class) == BPELPackage.PROCESS__NAME);
	}
	
	/* EditPartFactory */
	
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new ProcessEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */
	
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new ProcessOutlineEditPart();
		result.setModel(model);
		return result;
	}
	
	/* ITrayEditPartFactory */
	
	public EditPart createTrayEditPart(EditPart context, Object model) {
		ProcessTrayEditPart result = new ProcessTrayEditPart();
		result.setLabelProvider(PropertiesLabelProvider.getInstance());
		result.setModel(model);
		return result;
	}

	/* IFaultHandlerHolder */
	
	public FaultHandler getFaultHandler(Object object) {
		return ((Process)object).getFaultHandlers();
	}
	
	public void setFaultHandler(Object object, FaultHandler faultHandler) {
		((Process)object).setFaultHandlers(faultHandler);
	}
	
	/* IEventHandlerHolder */

	public EventHandler getEventHandler(Object object) {
		return ((Process)object).getEventHandlers();
	}

	public void setEventHandler(Object object, EventHandler eventHandler) {
		((Process)object).setEventHandlers(eventHandler);
	}		
	
	/* ILabeledElement */

	public String getLabel(Object object) {
		// TODO: Labels
		String name = getName(object);
		if (name != null)
			return name;
		return getTypeLabel(object);
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PROCESS_32);
	}

	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PROCESS_16);
	}

	public String getTypeLabel(Object object) {
		return Messages.ProcessAdapter_Process_1; 
	}


	/* IExtensionFactory */
	
	public EObject createExtension(EObject object) {
		return UiextensionmodelFactory.eINSTANCE.createProcessExtension();
	}

	/*
	 * Overrides the base class actions and appends the declaration actions
	 * @see https://issues.jboss.org/browse/JBIDE-7953
	 */
	@Override
	public List<? extends IEditPartAction> getEditPartActions(EditPart editPart) {
		List<AbstractAction> actions = new ArrayList<AbstractAction>();
		actions.add(new CreatePartnerLinkAction(editPart));
		actions.add(new CreateVariableAction(editPart));
		actions.add(new CreateCorrelationSetAction(editPart));
		actions.add(new CreateMessageExchangeAction(editPart));
		return actions;
	}	
}
