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
import java.util.Collections;
import java.util.List;

import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.GraphicalBPELRootEditPart;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.bpel.ui.editparts.policies.BPELGraphicalEditPolicy;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;


/**
 * ActivityEditPart is the graphical GEF edit part representing a BPEL Activity.
 * It implements NodeEditPart because activities can be the source and the target of
 * connections in the graph. These connections include flow links as well as implicit
 * control flow connections, often determined by the node's parent.
 */
public abstract class ActivityEditPart extends BPELEditPart implements NodeEditPart {

	private MouseMotionListener mouseMotionListener;
	
	/**
	 * Brand new shiny ActivityEditPart.
	 */
	public ActivityEditPart() {
		super();
	}

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		
		Sources sources = getActivity().getSources();
		
		
		if (sources != null) {
			adapter.addToObject(sources);
			for(Source source : sources.getChildren()) {
				adapter.addToObject(source);
			}
//			
//			for (Iterator it = sources.getChildren().iterator(); it.hasNext(); ) {
//				Source source = (Source)it.next();
//				// also include the link, if there is one (since we indirectly
//				// control the activation of the LinkEditPart)
//				if (source.getLink() != null) adapter.addToObject(source.getLink());
//
//				// Okay--the real problem here, is that the Activity might be
//				// referred to by a Source object, but the Activity is not going
//				// to find out about the creation of a new Sources that references
//				// it.  Therefore, our model listeners don't know what to do!
//				
//				// TODO: temporarily hacked around in FlowEditPart.FlowContentAdapter.
//				
//				// TODO: also include any parent flows, and the Links object of
//				// any parent flows that have one.  !
//				// TODO: in future, use a global listener to handle refreshing the
//				// correct source editpart.
//			}			
		}

		Targets targets = getActivity().getTargets();
		if (targets != null) {
			adapter.addToObject(targets);
			for( Target target : targets.getChildren()) {
				adapter.addToObject(target);
			}						
		}
	}
	
	/**
	 * Install the BPELGraphicalEditPolicy as GRAPHICAL_NODE_ROLE. This policy allows
	 * the graphical creation of flow links between activities.
	 */
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new BPELGraphicalEditPolicy());
	}

	/**
	 * The model is the source of the following connections:
	 * - Any flow links that the model is the source of
	 * - Any other connections that the model's parent determines the model is the source of
	 */	
	@Override
	protected List<Link> getModelSourceConnections() {
		Sources sources = getActivity().getSources();
		if (sources == null) {
			return Collections.emptyList();
		}
		List<Link> result = new ArrayList<Link>();
		for(Source source : sources.getChildren()) {
			if (source.getLink() != null) {
				result.add(source.getLink());
			}
		}
		return result;
	}

	/**
	 * The model is the target of the following connections:
	 * - Any flow links that the model is the target of
	 * - Any other connections that the model's parent determines the model is the target of
	 */
	@Override
	protected List<Link> getModelTargetConnections() {
		Targets targets = getActivity().getTargets();
		if (targets == null) {
			return Collections.emptyList();
		}
		List<Link> result = new ArrayList<Link>();
		for(Target target : targets.getChildren()) {
			if (target.getLink() != null) {
				result.add(target.getLink());
			}				
		}
		return result;
	}
	
	/**
	 * Returns the connection anchor of a source connection which
	 * is at the given point.
	 * 
	 * @return  ConnectionAnchor.
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		// TODO: Translate point to figure, call other method
		return getSourceConnectionAnchor((ConnectionEditPart)null);
	}
	
	/**
	 * Returns the connection anchor of a target connection which
	 * is at the given point.
	 *
	 * @return  ConnectionAnchor.
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		// TODO: Translate point to figure, call other method
		return getTargetConnectionAnchor((ConnectionEditPart)null);
	}
	
	/**
	 * Because ActivityEditPart implements NodeEditPart, there may be connections
	 * to or from this node that are affected by model changes. Refresh the
	 * connections now.
	 * 
	 * If the model change involves the addition of an ActivityExtension, add an adapter
	 * to that extension.
	 */
	@Override
	protected void handleModelChanged() {
		super.handleModelChanged();
		refreshSourceConnections();
		refreshTargetConnections();
	}
	
	/**
	 * Convenience method to get the model as a BPEL Activity
	 * @return the model as a BPEL activity
	 */
	public Activity getActivity() {
		return (Activity) getModel();
	}
	
	/** 
	 * Override so we can set the constraint for every XY placed object
	 */
	
	@Override
	public void refreshVisuals() {
		Rectangle r = null;
		
		if (this.getParent() instanceof FlowEditPart) {
			EditPart root = getRoot();
			if (root instanceof GraphicalBPELRootEditPart) {
				Point p = ModelHelper.getLocation(getActivity());
				if (p.x == Integer.MIN_VALUE) {
					// HACK: We don't know its position, pretend it's at 0, 0.  This should only
					// be necessary during brief edge-case situations (like during startup before
					// we've done auto-layout on flows without metadata)..
					p = new Point(0, 0);
				}
				Dimension s = new Dimension(-1, -1);
				r = new Rectangle(p, s);
			}
		}

		if (r != null) {
			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), r);
		}
		super.refreshVisuals();
	}

	public ConnectionAnchor getTargetConnectionAnchorForTargetChild(ConnectionEditPart connEditPart) {
		return null;
	}
	
	protected void refreshDrawerHoverHelp() {
		
		IHoverHelper helper = null;
		
		try {
			helper = BPELUIRegistry.getInstance().getHoverHelper();
			if (helper == null) {
				return ;
			}
		}  catch (CoreException ce) {
			getFigure().setToolTip(null);
			BPELUIPlugin.log(ce);
			return ;
		}
		
	
		// Get the marker and pass it to the hover helper
		ArrayList<IMarker> listOfMarkers = new ArrayList<IMarker>();
		
		IMarkerHolder holder = BPELUtil.adapt(getActivity(), IMarkerHolder.class);
		
		for (IMarker m : holder.getMarkers(getActivity()) ) {
			
			// if we can't see it, then we will not look at it
			if (m.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true) == false) {
				continue;
			}
			
			String where = m.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR,EMPTY_STRING); 
			
			if (mouseLocation == 1) {
				// Top drawer
				if (where.equals( IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_TOP )) {
					listOfMarkers.add(m);
				}
								
			} else {
				// bottom drawer
				if (where.equals( IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_BOTTOM )) {
					listOfMarkers.add(m);
				}
			}			
		}
		
		if (listOfMarkers.size() == 0) {
			return;
		}
		String text = null;
		
		if (listOfMarkers.size() == 1) {
			text = helper.getHoverHelp( listOfMarkers.get(0) );
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("There are ").append(listOfMarkers.size()).append(" issues here:\n");
			for(IMarker m : listOfMarkers) {
				String t = helper.getHoverHelp (m) ;
				sb.append("o ").append(t).append("\n");
			}
			text = sb.toString();
		}
				
		if (text == null || text.length() < 1) {
			getFigure().setToolTip(null);
		} else {
			getFigure().setToolTip(new Label(text));
		}
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
					DrawerBorder border = getDrawerBorder();
					if (border == null) return;
					int inTop = border.isPointInTopDrawer(me.x, me.y) ? 1 : 0;
					int inBottom = border.isPointInBottomDrawer(me.x, me.y) ? 2 : 0;
					// If mouse stayed in the same place it was in last time, do nothing
					int newLocation = inTop | inBottom;
					if (newLocation == mouseLocation) return;
					mouseLocation = newLocation;
					refreshHoverHelp();
				}
			};
		}
		return mouseMotionListener;
	}
	protected abstract DrawerBorder getDrawerBorder();
	
	/**
	 * Override the refreshHoverHelp method from BPELEditPart. This method
	 * will refresh either the regular hover help, or the drawer hover help
	 * if that is what is currently being displayed.
	 */
	
	@Override
	public void refreshHoverHelp() {
		switch (mouseLocation) {
			case 1:
				refreshDrawerHoverHelp();
				return;
			case 2:
				refreshDrawerHoverHelp();
				return;
		}
		super.refreshHoverHelp();
	}
	
	public IFigure getMainActivityFigure() {
		return getFigure();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		// Provide default anchor for Links.
		if (connEditPart == null || connEditPart instanceof LinkEditPart) {
			if(ModelHelper.isHorizontalLayout(getModel())){
				return new CenteredConnectionAnchor(getMainActivityFigure(), CenteredConnectionAnchor.RIGHT_INNER, 0);
			}else
				return new CenteredConnectionAnchor(getMainActivityFigure(), CenteredConnectionAnchor.BOTTOM, 0);
		}
		return null;
	}
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		// Provide default anchor for Links.
		if (connEditPart == null || connEditPart instanceof LinkEditPart) {
			if(ModelHelper.isHorizontalLayout(getModel())){
				return new CenteredConnectionAnchor(getMainActivityFigure(), CenteredConnectionAnchor.LEFT_INNER, 0);
			}else
				return new CenteredConnectionAnchor(getMainActivityFigure(), CenteredConnectionAnchor.TOP, 0);
		}
		return null;
	}
	
}
