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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.editparts.policies.BPELComponentEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELContainerEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELDirectEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.OutlineTreeEditPolicy;
import org.eclipse.bpel.ui.editparts.util.OutlineTreePartFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;



/**
 * 
 * OutlineTreeEditPart is the edit part that is present in the outline (tree) view of the process.
 * @author IBM
 *  
 */


public class OutlineTreeEditPart extends AbstractTreeEditPart {

	protected MultiObjectAdapter adapter;
	protected Image outlineImage = null;
	
	/**
	 * Brand new shiny OutlineTreeEdit part.
	 */
	
	public OutlineTreeEditPart() {
		adapter = new BatchedMultiObjectAdapter() {
			boolean needRefresh = false;
			
			@Override
			public void notify(Notification notification) {				
				needRefresh = true;
				refreshAdapters();
			}
			
			@Override
			public void finish() {
				if (isActive() && needRefresh) handleModelChanged();
				needRefresh = false;
			}
		};
	}
	
	protected void addAllAdapters() {
		EObject modelObject = (EObject)getModel();  
		adapter.addToObject(modelObject);
		
		// if the object has an extension, add adapter to that too
		EObject extension = ModelHelper.getExtension(modelObject);
		if (extension != null) adapter.addToObject(extension);
		// if the object contains an implicit sequence, add adapter to that also
		try {
			Activity activity = ModelHelper.getActivity(modelObject);
			if (activity instanceof Sequence) {
				// TODO: perhaps we should check and make sure it's an implicit sequence!
				// for now, don't worry about it.
				adapter.addToObject(activity);
			}
		} catch (IllegalArgumentException e) {
			// it's not a single-activity container.  ignore.
		}
		// ..but we probably don't need an adapter on the implicit sequence...
	}

	protected void removeAllAdapters() {
		adapter.removeFromAll();
	}
	
	protected void refreshAdapters() {
		removeAllAdapters();
		addAllAdapters();
	}
	
	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#activate()
	 */
	@Override
	public void activate() {
		if (isActive()) {
			return;
		}
		
		super.activate();
		addAllAdapters();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		if (!isActive()) {
			return;
		}
		removeAllAdapters();
		super.deactivate();		
	}

	
	@Override
	protected void unregisterVisuals() {
		if (outlineImage != null) {
			outlineImage = null;
		}
		super.unregisterVisuals();
	}

	/**
	 * Refreshes the Widget of this based on the property
	 * given to update. All major properties are updated
	 * irrespective of the property input.
	 *
	 * @param property  Property to be refreshed.
	 */
	
	@Override
	protected void refreshVisuals() {
		if (getWidget() instanceof Tree)
			return;
		super.refreshVisuals();
		Image is = getSmallImg();
		if (is != null) {
			if (outlineImage != null) {
				outlineImage = null;
			}
			outlineImage = is;		
			TreeItem item = (TreeItem)getWidget();
			if (outlineImage != null)
			outlineImage.setBackground(item.getParent().getBackground());
			setWidgetImage(outlineImage);
		}

		String name = getLabel();	
		setWidgetText(name);
	}
	
	private Image getSmallImg() {
		Object model = getModel();
		ILabeledElement element = BPELUtil.adapt(model, ILabeledElement.class);
		if (element != null) {
			return element.getSmallImage(model);
		}
		return null;
	}
	
	private String getLabel() {
		Object model = getModel();
		ILabeledElement element = BPELUtil.adapt(model, ILabeledElement.class);
		if (element != null) {
			return element.getLabel(model);
		}
		return null;
	}

	@Override
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new BPELComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BPELOrderedLayoutEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new OutlineTreeEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new BPELDirectEditPolicy());
		
		if (BPELUtil.adapt(getModel(), IContainer.class) != null) {
			installEditPolicy(EditPolicy.CONTAINER_ROLE, new BPELContainerEditPolicy());
		}
	}
	
	@Override
	protected List getModelChildren() {	
		return OutlineTreePartFactory.getModelChildren(this.getModel());
	}
		
	
	/**
	 * Handle model changed notifications.
	 *  
	 */
	
	public void handleModelChanged() {
		refreshChildren();
		refreshVisuals();
	}

	
	@Override
	protected void reorderChild(EditPart editpart, int index) {
		
		boolean expanded = false;
		boolean resetState = false;
		TreeEditPart treeEditPart = (TreeEditPart)editpart;
		Widget wid = treeEditPart.getWidget();
		if (wid != null) {
			if (wid instanceof TreeItem) {
				TreeItem ti = (TreeItem)wid;
				expanded = ti.getExpanded();	
				resetState = true;
			}
		}
		
		removeChildVisual(editpart);
		List<EditPart> children = getChildren();
		children.remove(editpart);
		children.add(index, editpart);
		addChildVisual(editpart, index);
		
		// reset the expanded state if the part was previously so
		if (resetState) {
			TreeItem ti = (TreeItem)treeEditPart.getWidget();
			if (ti != null) 
				ti.setExpanded(expanded);
		}
		editpart.refresh();
	}
}