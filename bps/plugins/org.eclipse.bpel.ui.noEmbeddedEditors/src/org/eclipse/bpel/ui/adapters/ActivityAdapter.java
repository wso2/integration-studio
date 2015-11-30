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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.actions.editpart.CreateCompensationHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.CreateEventHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.CreateFaultHandlerAction;
import org.eclipse.bpel.ui.actions.editpart.CreateFlowLinkAction;
import org.eclipse.bpel.ui.actions.editpart.CreateTerminationHandlerAction;
import org.eclipse.bpel.ui.editparts.LeafEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


/**
 * General activity adapter.
 * 
 * @IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 23, 2007
 *
 */

// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
// https://jira.jboss.org/browse/JBIDE-7526
// push all of the Marker stuff up to MarkerHolderAdapter to avoid duplication
public abstract class ActivityAdapter extends MarkerHolderAdapter implements INamedElement,
	ILabeledElement, EditPartFactory, IOutlineEditPartFactory, IMarkerHolder,
	IEditPartActionContributor, IExtensionFactory, AdapterNotification
{
	
	/**
	 * Helper method for getting an AbstractUIObjectFactory from a model object.
	 */
	protected AbstractUIObjectFactory getUIObjectFactory(Object modelObject) {
	    if (modelObject instanceof EObject) {
	        EClass effectiveClass = BPELUtil.getEClassFor(modelObject);
		    return UIObjectFactoryProvider.getInstance().getFactoryFor(effectiveClass);
	    }
	    return null;
	}
	
	/* INamedElement */

	public String getName (Object modelObject) {
		return ((Activity) modelObject).getName();
	}

	public void setName(Object modelObject, String name) {
		((Activity) modelObject).setName(name);
	}

	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(Activity.class) == BPELPackage.ACTIVITY__NAME);
	}

	/* ILabeledElement */

	public String getLabel(Object object) {
		// TODO: Labels
		String name = getName(object);
		if (name != null)
			return name;
		return getTypeLabel(object);
	}

    public String getTypeLabel(Object object) {
        return getUIObjectFactory(object).getTypeLabel();
    }

    public Image getSmallImage(Object object) {
        return getUIObjectFactory(object).getSmallImage();
    }

    public Image getLargeImage(Object object) {
        return getUIObjectFactory(object).getLargeImage();
    }

	/* EditPartFactory */

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart result = new LeafEditPart();
		result.setModel(model);
		return result;
	}

	/* IOutlineEditPartFactory */

	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}
	

	/* IEditPartActionContributor */
	
	public List<AbstractAction> getEditPartActions(final EditPart editPart) {
		List<AbstractAction> actions = new ArrayList<AbstractAction>();
		Object modelObject = editPart.getModel();
		
		IFaultHandlerHolder ifh =  BPELUtil.adapt(modelObject, IFaultHandlerHolder.class);
		if (ifh != null && ifh.getFaultHandler(modelObject) == null) {
			actions.add(new CreateFaultHandlerAction(editPart));
		}			
		ICompensationHandlerHolder ich = BPELUtil.adapt(modelObject, ICompensationHandlerHolder.class);
		if (ich != null && ich.getCompensationHandler(modelObject) == null) {
    		actions.add(new CreateCompensationHandlerAction(editPart));
		}
		ITerminationHandlerHolder ith = BPELUtil.adapt(modelObject, ITerminationHandlerHolder.class);
		if (ith != null && ith.getTerminationHandler(modelObject) == null) {
    		actions.add(new CreateTerminationHandlerAction(editPart));
		}
		IEventHandlerHolder ieh = BPELUtil.adapt(modelObject, IEventHandlerHolder.class);
		if (ieh != null && ieh.getEventHandler(modelObject) == null) {
	    	actions.add(new CreateEventHandlerAction(editPart));
		}
		if (FlowLinkUtil.hasParentFlow((EObject)modelObject)) {
			actions.add(new CreateFlowLinkAction(editPart));
		}
		
		return actions;
	}

	/* IExtensionFactory */
	
	public EObject createExtension(EObject object) {
		return UiextensionmodelFactory.eINSTANCE.createActivityExtension();
	}
}
