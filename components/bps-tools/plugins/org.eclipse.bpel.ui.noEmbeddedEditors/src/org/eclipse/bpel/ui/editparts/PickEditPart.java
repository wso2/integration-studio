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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.ui.editparts.borders.PickBorder;
import org.eclipse.bpel.ui.editparts.figures.CollapsablePickContainerFigure;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;

public class PickEditPart extends SequenceEditPart {
	
	private class PickOrderedLayoutEditPolicy extends BPELOrderedLayoutEditPolicy{
		@Override
		protected ArrayList createVerticalConnections(BPELEditPart parent) {
			ArrayList<PolylineConnection> connections = new ArrayList<PolylineConnection>();
			List children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor, targetAnchor;
			
			sourcePart = parent;
			sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
			
			if (children != null){
				for (int i = 0; i < children.size(); i++) {
					targetPart = (BPELEditPart)children.get(i);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
					connections.add(createConnection(sourceAnchor,targetAnchor,arrowColor));
				}			
			}		
			return connections;
		}
	}
	
	@Override
	protected void createEditPolicies() {
		if(ModelHelper.isHorizontalLayout(getModel()))
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new PickOrderedLayoutEditPolicy());
		else
			super.createEditPolicies();
	}
	
	@Override
	protected void configureExpandedFigure(IFigure figure) {
		super.configureExpandedFigure(figure);
		boolean horizontal = ModelHelper.isHorizontalLayout(getModel());
		FlowLayout layout = (FlowLayout)figure.getLayoutManager();
		layout.setHorizontal(!horizontal);
		layout.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);
		layout.setStretchMinorAxis(true);
		
		// Adjust the border
		((PickBorder)figure.getBorder()).setHorizontal(horizontal);
		
	}
	
	// Overridden to return a PickContainerFigure
	@Override
	protected IFigure getNewContentPane(Layer layer) {
		CollapsablePickContainerFigure fig =  new CollapsablePickContainerFigure(getModel(), image, getLabel());
		fig.addMouseMotionListener(getMouseMotionListener());
		fig.setEditPart(this);
		return fig;
	}
	
	@Override
	public ConnectionAnchor getConnectionAnchor(int location) {
		if(location == CenteredConnectionAnchor.LEFT){
			return new CenteredConnectionAnchor(getContentPane(),CenteredConnectionAnchor.LEFT_INNER,0);
		}
		return super.getConnectionAnchor(location);
	}
	
	/**
	 * Overridden to toggle the horizontal flag for picks, because if 
	 * the layout orientation is horizontal, the children of a pick should
	 * be laid out vertically and the other way around.
	 */
	@Override
	public void switchLayout(boolean horizontal) {
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		
		EditPolicy newPolicy = null;
		if(horizontal)
			newPolicy = new PickOrderedLayoutEditPolicy();
		else
			newPolicy = new BPELOrderedLayoutEditPolicy();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, newPolicy);
		
		((FlowLayout)contentFigure.getLayoutManager()).setHorizontal(!horizontal);
		((PickBorder)contentFigure.getBorder()).setHorizontal(horizontal);
	}
}
