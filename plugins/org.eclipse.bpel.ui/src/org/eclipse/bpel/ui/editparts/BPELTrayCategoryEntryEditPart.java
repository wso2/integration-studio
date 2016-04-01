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
package org.eclipse.bpel.ui.editparts;

import java.util.List;

import org.eclipse.bpel.common.ui.decorator.EditPartMarkerDecorator;
import org.eclipse.bpel.common.ui.tray.TrayCategoryEntryEditPart;
import org.eclipse.bpel.common.ui.tray.TrayMarkerDecorator;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.IHoverHelperSupport;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.policies.BPELComponentEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELDirectEditPolicy;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;

/**
 * Tray category edit part.
 * 
 * @author IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 23, 2007
 *
 */

public abstract class BPELTrayCategoryEntryEditPart extends TrayCategoryEntryEditPart implements IHoverHelperSupport{
	
	protected MouseMotionListener mouseMotionListener;
	
	// added by Grid.Qian
	// use the variable to hold the root of the editpart
	// because when we delete a correlationSet from scope
	// the editpart parent will be null
	private RootEditPart holdRoot;

	@Override
	protected AccessibleEditPart createAccessible() {
		return new BPELTrayAccessibleEditPart(this);
	}
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		// handles deletions
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new BPELComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new BPELDirectEditPolicy());
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.common.ui.tray.TrayCategoryEntryEditPart#createEditPartMarkerDecorator()
	 */
	
	@Override
	protected EditPartMarkerDecorator createEditPartMarkerDecorator() {

		return new TrayMarkerDecorator((EObject)getModel(), new ToolbarLayout()) {
			@Override
			protected IMarker[] getMarkers () {
				
				IMarkerHolder holder = BPELUtil.adapt(modelObject, IMarkerHolder.class);
				
				if (holder != null) {
					return holder.getMarkers(modelObject);
				}
				
				return super.getMarkers();
			}
		};
		
	}

	
	
	/**
	 * @see org.eclipse.bpel.ui.IHoverHelperSupport#refreshHoverHelp()
	 */
	public void refreshHoverHelp() {
		
		// Refresh the tool-tip if we can find a helper.
		IHoverHelper helper = null; 
		try {
			helper = BPELUIRegistry.getInstance().getHoverHelper();
			if (helper == null) {
				return;				
			}
		} catch (CoreException e) {
			getFigure().setToolTip(null);
			BPELUIPlugin.log(e);
			return ;
		}		
		
		
		IFigure tooltip = helper.getHoverFigure((EObject)getModel());
		getFigure().setToolTip(tooltip);

	}

	protected MouseMotionListener getMouseMotionListener() {
		if (mouseMotionListener == null) {
			this.mouseMotionListener = new MouseMotionListener() {
				public void mouseDragged(MouseEvent me) {
				}
				public void mouseEntered(MouseEvent me) {
				}
				public void mouseExited(MouseEvent me) {
				}
				public void mouseHover(MouseEvent me) {
				}
				public void mouseMoved(MouseEvent me) {
					refreshHoverHelp();
				}
			};
		}
		return mouseMotionListener;
	}
	
	@Override
	protected IFigure createFigure() {
		IFigure fig =  super.createFigure();
		fig.addMouseMotionListener(getMouseMotionListener());
		return fig;
	}
	
	/**
	 * HACK
	 * See comments in org.eclipse.bpel.ui.editparts.BPELTrayCategoryEditPart.selectAnotherEntry()
	 */
	
	@Override
	public void removeNotify() {
		// we only do the following hack if we are dealing with scoped variables
		
		// when we delete a variable from scope, the variables parent will
		// be null, so we need to filter this
		EObject eObj = ((EObject) getParent().getModel()).eContainer();
		if (eObj != null && !(eObj instanceof Scope)) {
			super.removeNotify();
			return;
		}
		if (getSelected() != SELECTED_NONE) {
//			getViewer().deselect(this); 
			// instead of deselecting this entry (which would cause the process to be selected)
			// we should ask the parent edit part to select some other child
			((BPELTrayCategoryEditPart)getParent()).selectAnotherEntry();
		}
		if (hasFocus())
			getViewer().setFocus(null);

		List<EditPart> children = getChildren();
		for (int i = 0; i < children.size(); i++)
			children.get(i).removeNotify();
		unregister();
	}

	/**
	 * Overwrite the method by Grid.Qian to get the viewer 
	 * when the editpart's parent == null
	 */
	public EditPartViewer getViewer() {
		try {
			return super.getViewer();
		} catch (Exception e) {
			return holdRoot.getViewer();
		}

	}

	/**
	 * Overwrite the method by Grid.Qian
	 * Hold the editpart's root editpart
	 */
	public void setParent(EditPart parent) {
		if (this.getParent() == parent)
			return;
		if (parent != null) {
			holdRoot = parent.getRoot();
		}
		super.setParent(parent);
	}
}
