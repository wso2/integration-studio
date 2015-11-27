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

import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.bpel.ui.editparts.borders.LeafBorder;
import org.eclipse.bpel.ui.editparts.figures.GradientFigure;
import org.eclipse.bpel.ui.editparts.policies.BPELSelectionEditPolicy;
import org.eclipse.bpel.ui.editparts.util.BPELDecorationLayout;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.marker.BPELEditPartMarkerDecorator;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.graphics.Image;


/**
 * This is the superclass of BPEL activities that are leaves. That is, activities
 * which don't contain other activities. Leaf activities currently are laid out
 * in a horizontal manner with icon and label, with a simple border surrounding.
 */
public class LeafEditPart extends ActivityEditPart {

	protected Image image, topImage, bottomImage;
	protected Label imageLabel, nameLabel;
	protected LeafBorder border;

	// Marker support
	protected IFigure contentFigure;
	protected BPELEditPartMarkerDecorator editPartMarkerDecorator;
		
	/**
	 * 
	 * @author IBM
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date May 23, 2007
	 *
	 */
	public static class LeafDecorationLayout extends BPELDecorationLayout {
		
		@Override
		protected Point calculateLocation(int locationHint, IFigure container, Dimension childDimension) {
			Point result = super.calculateLocation(locationHint, container, childDimension);
			// if it is somewhere on the left we need to add the drawer space
			if ((locationHint & PositionConstants.LEFT) != 0) {
				result.x += DrawerBorder.DRAWER_WIDTH;
			}
			// if it is somewhere on the right we need to remove the drawer space
			if ((locationHint & PositionConstants.RIGHT) != 0) {
				result.x -= DrawerBorder.DRAWER_WIDTH;
			}
			return result;
		}
	}
	
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		// Show the selection rectangle
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new BPELSelectionEditPolicy(false, true) {
			@Override
			protected int getDrawerInset() {
				return DrawerBorder.DRAWER_WIDTH;
			}
			@Override
			protected int getWestInset() {
				return DrawerBorder.DRAWER_WIDTH ;
			}
			@Override
			protected int getEastInset() {
				return DrawerBorder.DRAWER_WIDTH ;
			}
			@Override
			protected int getNorthInset() {
				return 0;
			}
			@Override
			protected int getSouthInset() {
				return 0;
			}
		});
	}
	
	
	@Override
	protected IFigure createFigure() {
		if (image == null) {
			// Create the actual figure for the edit part
			ILabeledElement element = BPELUtil.adapt(getActivity(), ILabeledElement.class);
			image = element.getSmallImage(getActivity());
		}
		IFigure gradient = new GradientFigure(getModel());
		FlowLayout layout = new FlowLayout();
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		gradient.setLayoutManager(layout);
		
		gradient.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_BLACK));

		this.imageLabel = new Label(image);
		gradient.add(imageLabel);
		this.nameLabel = new Label(getLabel());
		gradient.add(nameLabel);
		
		this.contentFigure = gradient;
		
		if (editPartMarkerDecorator == null) {
			editPartMarkerDecorator = new BPELEditPartMarkerDecorator(
				(EObject)getModel(),
				new LeafDecorationLayout()
			);
			editPartMarkerDecorator.addMarkerMotionListener(getMarkerMotionListener());
		}

		IFigure result = editPartMarkerDecorator.createFigure(gradient);
		
		this.border = new LeafBorder(editPartMarkerDecorator.getDecorationLayer());
		this.border.setEditPart(this);
		gradient.setBorder(border);
		gradient.addMouseMotionListener(getMouseMotionListener());
		refreshDrawerImages();
		return result;
	}  
	
	protected void refreshDrawerImages() {
		if (topImage != null) {
			topImage.dispose();
			topImage = null;
		}
		if (bottomImage != null) {
			bottomImage.dispose();
			bottomImage = null;
		}
		
		IMarkerHolder holder = BPELUtil.adapt(getActivity(), IMarkerHolder.class);
		
		int topMarkerPriority = Integer.MIN_VALUE;
		int bottomMarkerPriority = Integer.MIN_VALUE;
		
		IMarker topMarker = null;
		IMarker bottomMarker = null;
		
		for(IMarker marker : holder.getMarkers(getActivity()))  {
			
			if (marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true) == false) {
				continue;
			}
			
			String value = marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR, EMPTY_STRING); 
			
			if (value.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_TOP)) {
				int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, 0);
				if (priority > topMarkerPriority) {
					topMarkerPriority = priority;
					topImage = BPELUtil.getImage(marker);
					topMarker = marker;
				}
			} else if (value.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_BOTTOM)) {
				int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, 0);
				if (priority > bottomMarkerPriority) {
					bottomMarkerPriority = priority;
					bottomImage = BPELUtil.getImage(marker);
					bottomMarker = marker;
				}
			}
		}
		
		border.setTopImage(topImage);
		border.setBottomImage(bottomImage);
		border.setTopMarker(topMarker);
		border.setBottomMarker(bottomMarker);
	}
	
	/**
	 * Overrides for direct edit 
	 */
	@Override
	public Label getLabelFigure() {
		return nameLabel;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.editparts.BPELEditPart#getLabelContent()
	 */
	@Override
	public String getLabelContent() {
		return getLabel();
	}
		
	
	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	public void refreshVisuals() {
		refreshDrawerImages();
		super.refreshVisuals();
		// The name has changed, change the corresponding label
		nameLabel.setText(getLabel());
		editPartMarkerDecorator.refresh();
		// Force a repaint, as the drawer images may have changed.
		getFigure().repaint();
	}
	
	protected String getLabel() {
		ILabeledElement element = BPELUtil.adapt(getActivity(), ILabeledElement.class);
		return element.getLabel(getActivity());
	}
	
	
	@Override
	protected void unregisterVisuals() {
		if (contentFigure != null) {
			contentFigure.removeMouseMotionListener(getMouseMotionListener());
		}
		if (editPartMarkerDecorator != null) {
			editPartMarkerDecorator.removeMarkerMotionListener(markerMotionListener);
		}
		this.image = null;
		this.editPartMarkerDecorator = null;
		this.topImage = null;
		this.bottomImage = null;
		super.unregisterVisuals();
	}
	
	// TODO: Why do we override this?
//	/**
//	 * Returns the connection anchor for the given
//	 * ConnectionEditPart's source. 
//	 *
//	 * @return  ConnectionAnchor.
//	 */
//	@Override
//	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
//		// This may be called when the model is disconnected. If so, return null.
//		if (getActivity().eResource() == null) return null;
//
//		// Leaf nodes can be the source of both implicit and link connections.
//		// However, they both anchor at the same part of the edit part.
//		return new CenteredConnectionAnchor(getMainActivityFigure(), CenteredConnectionAnchor.BOTTOM, 0);
//	}
//	
//	
//
//	/**
//	 * Returns the connection anchor for the given 
//	 * ConnectionEditPart's target.
//	 *
//	 * @return  ConnectionAnchor.
//	 */
//	@Override
//	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
//		// This may be called when the model is disconnected. If so, return null.
//		if (getActivity().eResource() == null) {
//			return null;
//		}
//		
//		ConnectionAnchor anc = null;
//		
//		// Leaf nodes can be the target of both implicit and link connections.
//		// However, they both anchor at the same part of the edit part.
//		if (anc == null)
//			anc = new CenteredConnectionAnchor(getMainActivityFigure(), CenteredConnectionAnchor.TOP, 0);
//		return anc;
//	}
	@Override
	public ConnectionAnchor getConnectionAnchor(int location) {
		switch(location){
		case CenteredConnectionAnchor.LEFT:
			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.LEFT_INNER, 0);
		case CenteredConnectionAnchor.RIGHT:
			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.RIGHT_INNER, 0);
		default:
				return super.getConnectionAnchor(location);
		}
	}
	
	
	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getContentPane()
	 */
	
	@Override
	public IFigure getContentPane() {
		return contentFigure;
	}

	
	@Override
	protected DrawerBorder getDrawerBorder() {
		return border;
	}
}