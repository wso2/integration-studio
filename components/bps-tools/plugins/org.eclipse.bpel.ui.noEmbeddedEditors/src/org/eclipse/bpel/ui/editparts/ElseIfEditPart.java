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

import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.borders.ElseElseIfBorder;
import org.eclipse.bpel.ui.editparts.policies.BPELContainerEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.ElseHighlightEditPolicy;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.figures.ILayoutAware;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Image;


public class ElseIfEditPart extends BPELEditPart implements NodeEditPart, ILayoutAware{

	private Image image;
	public Label nameLabel;
	private IFigure childFigure;
	private ElseElseIfBorder border;
	
	private class ElseIfOrderedHorizontalLayoutEditPolicy extends BPELOrderedLayoutEditPolicy{
		@Override
		protected ArrayList<PolylineConnection> createHorizontalConnections(BPELEditPart parent) {
			ArrayList<PolylineConnection> connections = new ArrayList<PolylineConnection>();
			List<BPELEditPart> children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor = null, targetAnchor = null;
			
			// The real first child is the nameLabel, so set the first sourceAnchor 
			// to this label
			
			sourceAnchor = new CenteredConnectionAnchor(nameLabel, CenteredConnectionAnchor.RIGHT,0);
			
			
			for(int i=0; i < children.size(); i++){
				if(i==0){
					targetPart = children.get(i);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
				}
				if(i < children.size()-1){
					if(i>0){
						sourcePart = children.get(i);
						sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
					}
					targetPart = children.get(i+1);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
				}
				if(sourceAnchor != null && targetAnchor != null)
					connections.add(createConnection(sourceAnchor,targetAnchor,arrowColor));
			}
			
			return connections;
		}
	}
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		// Show the selection rectangle
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ElseHighlightEditPolicy(false, true));
		
		// The case must lay out its child activity
		if(ModelHelper.isHorizontalLayout(getModel()))
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ElseIfOrderedHorizontalLayoutEditPolicy());
		else 
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new BPELOrderedLayoutEditPolicy());
			
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new BPELContainerEditPolicy());
	}

	// Called by CaseResizeHandle
	public Label getNameLabel() {
		return nameLabel;
	}
	
	@Override
	public Label getLabelFigure() {
		return null;
	}
	
	@Override
	public String getLabelContent() {
		ILabeledElement element = BPELUtil.adapt(getModel(), ILabeledElement.class);
		return element.getLabel(getModel());
	}

	
	@Override
	protected IFigure createFigure() {
		ILabeledElement element = BPELUtil.adapt(getModel(), ILabeledElement.class);
		if (element == null) return null;
		
		boolean horizontal = ModelHelper.isHorizontalLayout(getModel());
		
		IFigure figure = new Figure();
		ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
		figure.setForegroundColor(registry.get(IBPELUIConstants.COLOR_BLACK));	
		FlowLayout layout = new FlowLayout();
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setHorizontal(horizontal);
		layout.setMajorSpacing(SPACING);
		layout.setMinorSpacing(SPACING);
		layout.setHorizontal(horizontal);
		
		figure.setLayoutManager(layout);
		
		nameLabel = new Label(element.getLabel(getModel()));
		this.border = new ElseElseIfBorder();
		border.setColor(registry.get(IBPELUIConstants.COLOR_ACTIVITY_BORDER));
		nameLabel.setBorder(border);
		figure.add(nameLabel);
		
		this.childFigure = new Figure();
		childFigure.setForegroundColor(registry.get(IBPELUIConstants.COLOR_BLACK));		
		layout = new FlowLayout();
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setMajorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setMajorSpacing(SPACING);
		layout.setMinorSpacing(SPACING);		
		layout.setHorizontal(horizontal);
		childFigure.setLayoutManager(layout);
		figure.add(childFigure);
		
		if(!horizontal){
			// TODO: This is a temporary hack until Case/OnMessage look and feel is determined
			// See also SwitchBorder.getInsets()
			figure.setBorder(new MarginBorder(0, 0, 6, 0));
		}
		return figure;
	}

	@Override
	protected void unregisterVisuals() {
		if (this.image != null) {
			this.image.dispose();
			this.image = null;
		}
		super.unregisterVisuals();
	}
	
	@Override
	protected void handleModelChanged() {
		ILabeledElement element = BPELUtil.adapt(getModel(), ILabeledElement.class);
		nameLabel.setText(element.getLabel(getModel()));
		
		super.handleModelChanged();
		refreshTargetConnections();
		refreshSourceConnections();
	}

	/**
	 * Returns the connection anchor for the given
	 * ConnectionEditPart's source. 
	 *
	 * @return  ConnectionAnchor.
	 */
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		// Collapsable edit parts can be the source of both implicit connections.
		// The anchor is in the interior at the top, underneath the label.
		// If the link is to a child element or to self, use the interior top anchor.
		// If it isn't, use the bottom exterior anchor.

		// TODO: this code is broken!
//		Activity activity = getCase().getActivity();
//		Object target = ((ImplicitConnectionEditPart)connEditPart).getImplicitConnection().getTarget();
//		if (target == activity || target == BPELUtil.getOuterModelObject(activity) || target == getCase()) {
//			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.TOP, getTopAnchorOffset());
//		}
		
		// TODO: The -6 is a temporary hack until ElseIf/OnMessage look and feel is determined
		// See createFigure() and SwitchBorder.getInsets()
		return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.BOTTOM, /*HACK*/6);
	}

	@Override
	public ConnectionAnchor getConnectionAnchor(int location) {
		//hack to ensure case connection anchors appear properly
		if (location == CenteredConnectionAnchor.TOP_INNER){
			return new CenteredConnectionAnchor(getFigure(), location, 17);
		}else if (location == CenteredConnectionAnchor.BOTTOM_INNER){
			return new CenteredConnectionAnchor(getFigure(), location, -16);
		}else if (location == CenteredConnectionAnchor.LEFT){
			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.LEFT, 0);
		}
		return new CenteredConnectionAnchor(getFigure(), location, 0);
	}
	
	/**
	 * Returns the connection anchor for the given 
	 * ConnectionEditPart's target.
	 *
	 * @return  ConnectionAnchor.
	 */
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		// Case edit parts can be the target of implicit connections.
		// Implicit connections where the source is ourself attach to the interior at the bottom.
		// Implicit connections where the source is the parent attach to the interior at the top.

		// TODO: this code is broken!
//		Activity activity = getCase().getActivity();
//		Object source = ((ImplicitConnectionEditPart)connEditPart).getImplicitConnection().getSource();
//		if (source == activity || source == BPELUtil.getOuterModelObject(activity) || source == getCase()) {
//			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.BOTTOM, getBottomAnchorOffset());
//		}
		return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.TOP, 0);
	}
	
	/**
	 * Returns the connection anchor of a source connection which
	 * is at the given point.
	 * 
	 * @return  ConnectionAnchor.
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		// TODO: Translate point to figure, call other method
		return null;
	}
	
	/**
	 * Returns the connection anchor of a target connection which
	 * is at the given point.
	 *
	 * @return  ConnectionAnchor.
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		// TODO: Translate point to figure, call other method
		return null;
	}	
	
	/**
	 * We override this method to tell the edit part in which figure to
	 * place its children.
	 */
	@Override
	public IFigure getContentPane() {
		return childFigure;
	}
	
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		refreshMarkerImages();
		// Force a repaint, as the drawer images may have changed.
		getFigure().repaint();
	}
	
	protected void refreshMarkerImages() {
		if (image != null) {
			image.dispose();
			image = null;
		}
		IMarkerHolder holder = BPELUtil.adapt(getModel(), IMarkerHolder.class);
		if (holder != null) {
			IMarker[] markers = holder.getMarkers(getModel());
			int markerPriority = Integer.MIN_VALUE;
			for (int i = 0; i < markers.length; i++) {
				IMarker marker = markers[i];
				int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, Integer.MIN_VALUE);
				if (priority > markerPriority) {
					markerPriority = priority;
					image = BPELUtil.getImage(marker);
				}
			}
		}
		border.setImage(image);
	}

	public void switchLayout(boolean horizontal) {
		// Layout of the mainFigure
		((FlowLayout)figure.getLayoutManager()).setHorizontal(horizontal);
		
		// Configure the childFigure
		((FlowLayout)childFigure.getLayoutManager()).setHorizontal(horizontal);
		
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		
		EditPolicy newPolicy = null;
		
		if(horizontal){
			newPolicy = new ElseIfOrderedHorizontalLayoutEditPolicy();
			figure.setBorder(null);
		}else{
			newPolicy = new BPELOrderedLayoutEditPolicy();
			// TODO: This is a temporary hack until Case/OnMessage look and feel is determined
			// See also SwitchBorder.getInsets()
			figure.setBorder(new MarginBorder(0, 0, 6, 0));
		}
		installEditPolicy(EditPolicy.LAYOUT_ROLE, newPolicy);
	}
}
