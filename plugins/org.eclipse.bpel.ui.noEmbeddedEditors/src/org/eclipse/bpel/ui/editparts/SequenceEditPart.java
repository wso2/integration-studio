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

import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.ContainerHighlightEditPolicy;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.ImplicitLinkHandlerConnectionRouter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;


/**
 * @author IBM, Original contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com) 
 */


public class SequenceEditPart extends CollapsableEditPart {
	
	private class SequenceHorizontalBPELOrderedLayoutPolicy extends BPELOrderedLayoutEditPolicy{
		@Override
		protected ArrayList<PolylineConnection> createHorizontalConnections(BPELEditPart parent) {
			ArrayList<PolylineConnection> connections = new ArrayList<PolylineConnection>();
			List children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor = null, targetAnchor = null;

			sourcePart = parent;
			sourceAnchor = sourcePart
					.getConnectionAnchor(CenteredConnectionAnchor.LEFT);

			if (children != null) {
				for (int i = 0; i < children.size(); i++) {
					if (i == 0) {
						// Link from the left border to the first child
						targetPart = (BPELEditPart) children.get(i);
						targetAnchor = targetPart
								.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
						if (sourceAnchor != null && targetAnchor != null)
							connections.add(createConnection(sourceAnchor,
									targetAnchor, arrowColor));
					}
					if (i < children.size() - 1) {
						sourcePart = (BPELEditPart) children.get(i);
						sourceAnchor = sourcePart
								.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);

						targetPart = (BPELEditPart) children.get(i + 1);
						targetAnchor = targetPart
								.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
					} else {
						// Link from the last child to the right border
						sourcePart = (BPELEditPart) children.get(i);
						sourceAnchor = sourcePart
								.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
						targetAnchor = parent
								.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
					}
					if (sourceAnchor != null && targetAnchor != null) {
						PolylineConnection connection = createConnection(
								sourceAnchor, targetAnchor, arrowColor);

						if (sourcePart instanceof StartNodeEditPart
								|| sourcePart instanceof ScopeEditPart
								|| sourcePart instanceof InvokeEditPart) {
							boolean horizontal = ModelHelper.getBPELEditor(
									getHost().getModel()).isHorizontalLayout();
							connection
									.setConnectionRouter(new ImplicitLinkHandlerConnectionRouter(
											horizontal));
						}
						connections.add(connection);
					}
				}
			}
			return connections;
		}
	}
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		// Show the selection rectangle
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ContainerHighlightEditPolicy(false, true) {
			@Override
			protected int getDrawerInset() {
				return DrawerBorder.DRAWER_WIDTH;
			}
			@Override
			protected int getNorthInset() {
				if (isCollapsed()) {
					return 0;
				}
				
				// This one is tricky, it depends on the font size.
				
				return 10 ;
			}
			
			@Override
			protected int getSouthInset() {
				return isCollapsed() ? 8 : 2;
			}
			@Override
			protected int getEastInset() {
				return DrawerBorder.DRAWER_WIDTH ;
			}
			@Override
			protected int getWestInset() {
				return DrawerBorder.DRAWER_WIDTH ;
			}
		});
		
		BPELOrderedLayoutEditPolicy policy = null;
		if(ModelHelper.isHorizontalLayout(getModel()))
			policy = new SequenceHorizontalBPELOrderedLayoutPolicy();
		else
			policy = new BPELOrderedLayoutEditPolicy();
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, policy);
	}
	
	@Override
	protected void configureExpandedFigure(IFigure aFigure) {
		
		FlowLayout layout = new FlowLayout();
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setHorizontal(ModelHelper.isHorizontalLayout(getModel()));
		layout.setMajorSpacing(SPACING);
		layout.setMinorSpacing(SPACING);
		aFigure.setLayoutManager(layout);
	}

	public void switchLayout(boolean horizontal) {
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		EditPolicy newPolicy = null;
		if(horizontal){
			newPolicy = new SequenceHorizontalBPELOrderedLayoutPolicy();
		}else
			newPolicy = new BPELOrderedLayoutEditPolicy();
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, newPolicy);
		((FlowLayout)contentFigure.getLayoutManager()).setHorizontal(horizontal);
	}
	
}
