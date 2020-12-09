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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.ImageUtils;
import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.common.ui.markers.ModelMarkerUtil;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.policies.LinkConnectionEditPolicy;
import org.eclipse.bpel.ui.editparts.util.OverlayCompositeImageDescriptor;
import org.eclipse.bpel.ui.figures.BPELPolylineConnection;
import org.eclipse.bpel.ui.figures.ManhattanConnectionRouterEx;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.FlowLinkUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.graph.CompoundDirectedGraph;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;


public class LinkEditPart extends AbstractConnectionEditPart {

	private IFigure layer;
	private MultiObjectAdapter adapter;
	private Image decorationImage;
	private IFigure decoration;
	private Image topLeft, topRight, bottomLeft, bottomRight, arrowDown, arrowRight;
	protected AccessibleEditPart acc;
	
	public LinkEditPart() {
		adapter = new MultiObjectAdapter() {
			@Override
			public void notify(Notification n) {
				// TODO: check if we care about this notification
				if (isActive()) handleModelChanged();
				refreshAdapters();
			}
		};
	}
	
	protected void addAllAdapters() {
		Link link = getLink();
		adapter.addToObject(link);
		if (link.eContainer() != null) {
            // Links object
			adapter.addToObject(link.eContainer());
		}
		if (link.getSources().size() > 0) {
			Source source = link.getSources().get(0);
			if (source != null) {
				adapter.addToObject(source);
				Activity sourceActivity = source.getActivity();
				if (sourceActivity != null) {
					adapter.addToObject(sourceActivity);
	 
					EObject sourceParent = sourceActivity.eContainer();
					if (sourceParent != null) {
						adapter.addToObject(sourceParent);
					}
				}
			}
		}
		
		if (link.getTargets().size() > 0) {
			Target target = link.getTargets().get(0);
			if (target != null) {
				adapter.addToObject(target);
				Activity targetActivity = target.getActivity();
				if (targetActivity != null) {
					adapter.addToObject(targetActivity);

					EObject targetParent = targetActivity.eContainer();
					if (targetParent != null) {
						adapter.addToObject(targetParent);
					}				
				}
			}
		}
	}

	protected void removeAllAdapters() {
		adapter.removeFromAll();
	}
	
	protected void refreshAdapters() {
		removeAllAdapters();
		addAllAdapters();
	}
	
	/**
	 * Overriden to change to connection router. That's needed cause ManhattanConnectionRouter
	 * produces bad routing in case of horizontal layout
	 */
	@Override
	public void refresh() {
		super.refresh();
		applyConnectionRouter(getConnectionFigure());
	}
	
	/**
	 * The model has changed. Perform any actions necessary to ensure that the
	 * edit part, model and graphical representation are in sync.
	 * 
	 * Subclasses may override but should call super.
	 */
	protected void handleModelChanged() {
		// refresh connections on the source edit part!
		if (isActive()) {
//			Link link = (Link)getModel();
//			EObject sourceActivity = FlowLinkUtil.getLinkSource(link); 
//			if (sourceActivity != null) {
//				Object editPart = getViewer().getEditPartRegistry().get(sourceActivity);
//				if (editPart instanceof ActivityEditPart) {
//					((ActivityEditPart)editPart).refresh();
//				}
//			}
//			EObject targetActivity = FlowLinkUtil.getLinkTarget(link); 
//			if (targetActivity != null) {
//				Object editPart = getViewer().getEditPartRegistry().get(targetActivity);
//				if (editPart instanceof ActivityEditPart) {
//					((ActivityEditPart)editPart).refresh();
//				}
//			}
			// If property name is children, refresh children.
			// If property name is size or location, refresh visuals.
			refreshVisuals();
		}
	}
	

	@Override
	protected IFigure createFigure() {
		if (getLink() == null) return null;
		BPELUIPlugin plugin = BPELUIPlugin.INSTANCE;

		topLeft = plugin.getImage(IBPELUIConstants.ICON_LINK_TOPLEFT);
		topRight = plugin.getImage(IBPELUIConstants.ICON_LINK_TOPRIGHT);
		bottomLeft = plugin.getImage(IBPELUIConstants.ICON_LINK_BOTTOMLEFT);
		bottomRight = plugin.getImage(IBPELUIConstants.ICON_LINK_BOTTOMRIGHT);
		arrowDown = plugin.getImage(IBPELUIConstants.ICON_LINK_ARROWDOWN);
		arrowRight = plugin.getImage(IBPELUIConstants.ICON_LINK_ARROWRIGHT);
		
		BPELPolylineConnection c = new BPELPolylineConnection(topLeft, topRight, bottomLeft, bottomRight, arrowDown, arrowRight);
		applyConnectionRouter(c);
		return c;
	}
	
	public void contributeToGraph(CompoundDirectedGraph graph, Map map) {
		Node source = (Node) map.get(getSource());
		Node target = (Node) map.get(getTarget());
		Edge e = new Edge(this, source, target);
		graph.edges.add(e);
		map.put(this, e);
	}

	@Override
	public void activate() {
		if (isActive()) return;
		super.activate();
		addAllAdapters();
	}

	@Override
	public void deactivate() {
		if (!isActive()) return;
		removeAllAdapters();
		super.deactivate();

	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new LinkConnectionEditPolicy());
	}

	@Override
	protected void unregisterVisuals() {
		if (decorationImage != null) {
			decorationImage.dispose();
			decorationImage = null;
		}
		// NOTE: arrow images came from shared image registry, don't dispose them
		super.unregisterVisuals();
	}
	
	protected Link getLink() {
		return (Link)getModel();
	}
	/**
	 * Override to be sure we put the figure in the right layer
	 * TODO: yuck..
	 */
	@Override
	protected void activateFigure() {
		this.layer = getLayer(CONNECTION_LAYER);
		this.layer.add(getFigure());
	}
	/**
	 * Override to be sure we remove the figure from the right layer
	 */
	@Override
	protected void deactivateFigure() {
		this.layer.remove(getFigure());
		getConnectionFigure().setSourceAnchor(null);
		getConnectionFigure().setTargetAnchor(null);
	}
	
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshDecorations();
	}

	protected void refreshDecorations() {
		// Refresh any decorations on this edit part
		if (decoration != null) {
			getFigure().remove(decoration);
			decoration = null;
		}
		if (decorationImage != null) {
			decorationImage.dispose();
			decorationImage = null;
		}
		Link link = getLink();
		if (link.eContainer() == null) {
			// Yeesh, the link hasn't even been initialized yet. Return.
			return;
		}
		
		IMarkerHolder markerHolder = BPELUtil.adapt(link, IMarkerHolder.class);
		IMarker[] markers = markerHolder.getMarkers(link);
		IMarker markerToDisplay = null;
		for (int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			// If the marker is not visible, skip it.
			boolean isVisible = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true);
			if (!isVisible) continue;
			if (markerToDisplay != null) {
				// There was already a marker.
				// Find out which one has the highest priority and display that one.
				int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, Integer.MIN_VALUE);
				int existingPriority = markerToDisplay.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, Integer.MIN_VALUE);
				if (priority > existingPriority) {
					markerToDisplay = marker;
				}		
			} else {
				// There was no marker already, put this one in the map.
				markerToDisplay = marker;
			}
		}
		if (markerToDisplay != null) {
			Image temp = getImage(markerToDisplay);
			if (temp == null) return;
			ImageData background = temp.getImageData();
			String uri = markerToDisplay.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGETOPLEFT, ""); //$NON-NLS-1$
			ImageData topLeft = getImageData(uri);
			uri = markerToDisplay.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGETOPRIGHT, ""); //$NON-NLS-1$
			ImageData topRight = getImageData(uri);
			uri = markerToDisplay.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGEBOTTOMLEFT, ""); //$NON-NLS-1$
			ImageData bottomLeft = getImageData(uri);
			uri = markerToDisplay.getAttribute(IBPELUIConstants.MARKER_OVERLAYIMAGEBOTTOMRIGHT, ""); //$NON-NLS-1$
			ImageData bottomRight = getImageData(uri);
			OverlayCompositeImageDescriptor descriptor = new OverlayCompositeImageDescriptor(background, topLeft, topRight, bottomLeft, bottomRight);
			//TODO: can we get into image registry?			
			Image image = descriptor.createImage();
			this.decorationImage = image;
			this.decoration = new Label(this.decorationImage);
			getFigure().add(this.decoration, new ConnectionLocator(getConnectionFigure(), ConnectionLocator.MIDDLE));
		} else {
			if (hasCondition()) {
				Image image = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_LINK_CONDITIONAL);
				this.decorationImage = null;
				this.decoration = new Label(image);
				getFigure().add(this.decoration, new ConnectionLocator(getConnectionFigure(), ConnectionLocator.MIDDLE));
			}
		}
	}

	protected boolean hasCondition() {
		Link link = getLink();
		List<Source> sourcesList = link.getSources();
		if (!sourcesList.isEmpty()) {
			Source source = sourcesList.get(0);
			return source.getTransitionCondition() != null;
		}
		return false;
	}
	
	/** 
	 * Get the image to be drawn for the marker's figure.  This is obtained 
	 * from an IModelMarkerContentProvider that must be implemented by the client. 
	 * If we can't find an image using the content provider we check to see if the
	 * marker is a problem marker and get the correct icon for it.
	 * 
	 * May be overriden by subclasses to change the image.
	 * 
	 * @param marker 
	 * @return an image representing the marker or null if none is available
	 */
	private Image getImage(IMarker marker) {
		Image image = ModelMarkerUtil.getImage(marker);
		if (image == null) {
			try {
				if (marker.isSubtypeOf(IMarker.PROBLEM)) {
					return ImageUtils.getImage(marker);
				}
			} catch (CoreException e) {
				CommonUIPlugin.log(e);
			}
		}
		return image;
	}
	
	private ImageData getImageData(String uri) {
		if (uri.length() == 0) return null;
		URL url = null;
		try {
			url = new URL(uri);
		} catch (MalformedURLException e) {
			return null;
		}
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		return desc.getImageData();
	}	
	
	@Override
	protected AccessibleEditPart getAccessibleEditPart() {
		if (acc == null) acc = createAccessible();
		return acc;
	}
	
	public AccessibleEditPart createAccessible() {
		final GraphicalEditPart thisPart = this;

		// kind of similar but not the same as GEF's AccessibleGraphicalEditPart class
		return new AccessibleGraphicalEditPart() {
			@Override
			public void getName(AccessibleEvent e) {
				String childType = null;
				String displayName = null;
				ILabeledElement labeledElement =
					BPELUtil.adapt(thisPart.getModel(), ILabeledElement.class);
				if (labeledElement != null) {
					childType = labeledElement.getTypeLabel(thisPart.getModel());
					displayName = labeledElement.getLabel(thisPart.getModel());
					// bug 327644
					// prevent possible NPE
					if (childType != null && childType.equals(displayName)) {
						childType = null;
					}
				} else {
					e.result = null;
					return;
				}

				// return something reasonable (type followed by name if any)
				// or nothing at all

				StringBuffer concat = new StringBuffer();
				if (childType != null && childType.length() > 0)
					concat.append(childType);
				if (concat.length() > 0)
					concat.append(" "); //$NON-NLS-1$
				if (displayName != null && displayName.length() > 0)
					concat.append(displayName);
				if (concat.length() > 0)
					e.result = concat.toString();
				else
					e.result = null;
				return;
			}
			@Override
			public void getValue(AccessibleControlEvent e) {
				Link link = (Link)thisPart.getModel();
				Activity source = FlowLinkUtil.getLinkSource(link);
				Activity target = FlowLinkUtil.getLinkTarget(link);
				if (source != null && target != null) {
					ILabeledElement labeledElement1 =
						BPELUtil.adapt(source, ILabeledElement.class);
					ILabeledElement labeledElement2 =
						BPELUtil.adapt(target, ILabeledElement.class);
					if (labeledElement1 != null && labeledElement2 != null) {
						e.result = labeledElement1.getLabel(source) + "-" + labeledElement2.getLabel(target); //$NON-NLS-1$
					}
					
				}
			}
		};
	}
	
	private void applyConnectionRouter(Connection con){
		EditPart conTo = getSource() == null ? getTarget() : getSource();
		if(conTo != null){
			if(ModelHelper.isHorizontalLayout(conTo.getModel()))
				con.setConnectionRouter(new ManhattanConnectionRouterEx(ManhattanConnectionRouterEx.RIGHT, ManhattanConnectionRouterEx.LEFT));
			else
				con.setConnectionRouter(new ManhattanConnectionRouter());
		}
	}
}
