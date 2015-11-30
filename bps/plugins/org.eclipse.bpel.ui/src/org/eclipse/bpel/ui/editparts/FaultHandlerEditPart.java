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

import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.editparts.borders.RoundRectangleBorderWithDecoration;
import org.eclipse.bpel.ui.editparts.policies.BPELContainerEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.ContainerHighlightEditPolicy;
import org.eclipse.bpel.ui.figures.ILayoutAware;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.graphics.Image;


public class FaultHandlerEditPart extends BPELEditPart implements ILayoutAware{

	private Image image;
	
	private IFigure contentPane;
	
	private Border containerBorder;
	
	public static final int LEFT_MARGIN = 30;
		
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		// Show the selection rectangle
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ContainerHighlightEditPolicy(false, false));

		installEditPolicy(EditPolicy.CONTAINER_ROLE, new BPELContainerEditPolicy());
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BPELOrderedLayoutEditPolicy());
	}

	@Override
	protected IFigure createFigure() {
		IFigure figure = new Figure();
		FlowLayout layout = new FlowLayout();
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		boolean vertical = (getModel() instanceof CompensationHandler) || (getModel() instanceof TerminationHandler);
		boolean horizontalLayout = ModelHelper.isHorizontalLayout(getModel());
		layout.setHorizontal(horizontalLayout ? vertical : !vertical);
		figure.setLayoutManager(layout);
		if (image == null) {
			// Get Image from registry
			if (getModel() instanceof EventHandler) {
				image = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_EVENT_INDICATOR);
			} else if (getModel() instanceof CompensationHandler) {
				image = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_COMPENSATION_INDICATOR);
			} else if (getModel() instanceof TerminationHandler) {
				image = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_TERMINATION_INDICATOR);
			} else {
				image = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_FAULT_INDICATOR);
			}		
		}
		figure.setBorder(new RoundRectangleBorderWithDecoration(figure, image, new Insets(20, 10, 20, 10)));
		figure.setOpaque(true);
		
		this.contentPane = figure;
		
		int topMargin = calcTopMargin(horizontalLayout);
		int leftMargin = calcLeftMargin(horizontalLayout);
		
		IFigure container = new Figure();
		this.containerBorder = new MarginBorder(topMargin,leftMargin,0,0);
		container.setBorder(containerBorder);
		container.add(figure);
		layout = new FlowLayout();
		layout.setHorizontal(false);
		container.setLayoutManager(layout);
		return container;
	}

	@Override
	public void deactivate() {
		if (!isActive()) return;
		super.deactivate();
		if (this.image != null) {
			//this.image.dispose();
			this.image = null;
		}
	
	}	
	
	@Override
	public IFigure getContentPane() {
		return contentPane;
	}
	
	public void switchLayout(boolean horizontal) {
		boolean vertical = (getModel() instanceof CompensationHandler) || (getModel() instanceof TerminationHandler);
		boolean horizontalLayout = ModelHelper.isHorizontalLayout(getModel());
		
		((FlowLayout)getContentPane().getLayoutManager()).setHorizontal(horizontalLayout ? vertical : !vertical);
		
		int leftMargin = calcLeftMargin(horizontal);
		int topMargin = calcTopMargin(horizontal);
		getFigure().setBorder(new MarginBorder(topMargin,leftMargin,0,0));
	}
	
	/**
	 * Calculates the top margin regarding the layout orientation
	 * @return
	 */
	private int calcTopMargin(boolean horizontal){
		int topMargin = 0;
		if(horizontal){
			topMargin = 2;
		}else{
			if(getParent() instanceof ScopeEditPart){
				// Four possible handlers
				topMargin = 42;
			}else if(getParent() instanceof InvokeEditPart){
				// Standard offset
				topMargin = 17;
			}else
				topMargin = 16;
		}
		return topMargin;
	}

	/**
	 * Calculates the left margin regarding the layout orientation
	 * @return
	 */
	private int calcLeftMargin(boolean horizontal){
		int leftMargin = 0;
		if(horizontal && getParent() instanceof ProcessEditPart){
			leftMargin = LEFT_MARGIN;
		}
			
		return leftMargin;
	}
}
