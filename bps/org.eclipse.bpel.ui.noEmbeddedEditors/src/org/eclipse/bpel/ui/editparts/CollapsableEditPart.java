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

import java.util.Collections;
import java.util.List;

import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.editparts.borders.ContainerBorder;
import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.bpel.ui.editparts.borders.LeafBorder;
import org.eclipse.bpel.ui.editparts.figures.CollapsableContainerFigure;
import org.eclipse.bpel.ui.editparts.util.BPELDecorationLayout;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.figures.ILayoutAware;
import org.eclipse.bpel.ui.util.BPELDragEditPartsTracker;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.marker.BPELEditPartMarkerDecorator;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.swt.graphics.Image;


/**
 * Subclasses of CollapsableEditPart represent BPEL activities which
 * can be graphically represented in an expanded or collapsed manner.
 * 
 * In the collapsed state, this class will render the node. In the
 * expanded state, the subclass will be expected to render the node.
 */
public abstract class CollapsableEditPart extends CompositeActivityEditPart implements ILayoutAware {
	
	// Whether or not the edit part is collapsed
	protected boolean collapsed;
	
	// The primary image for the edit part
	protected Image image;
	
	// The images in the top and bottom drawer, if any
	protected Image topImage, bottomImage;
	
	// The label to display when collapsed. Subclasses may also use it
	// when expanded if desired.
	protected Label collapsedLabel;
	
	// Marker support
	protected IFigure contentFigure;
	protected BPELEditPartMarkerDecorator editPartMarkerDecorator;

	protected Adapter childrenAdapter;

	public class CollapsableDecorationLayout extends BPELDecorationLayout {
		private int borderImageWidth;
		public CollapsableDecorationLayout(int borderImageWidth) {
			this.borderImageWidth = borderImageWidth;
		}
		@Override
		protected Point calculateLocation(int locationHint, IFigure container, Dimension childDimension) {
			Rectangle area = container.getClientArea();
			switch (locationHint) {
				case PositionConstants.CENTER:
					// Center
					return new Point(area.x + area.width / 2 - childDimension.width / 2, area.y + area.height / 2 - childDimension.height / 2);
				case PositionConstants.TOP:
					// Top Center
					return new Point(area.x + area.width / 2 - childDimension.width / 2, area.y + borderImageWidth / 2);
				case PositionConstants.BOTTOM:
					// Bottom Center
					return new Point(area.x + area.width / 2 - childDimension.width / 2, area.y + area.height - childDimension.height);
				case PositionConstants.LEFT: {
					// Center Left
					int x = area.x + DrawerBorder.DRAWER_WIDTH;
					int y = area.y + (area.height / 2) - (childDimension.width / 2);
					if (!isCollapsed()) {
						y += DrawerBorder.DRAWER_HALF_HEIGHT / 2;
					}
					return new Point(x, y);
				}
				case PositionConstants.RIGHT: {
					// Center Right
					int x = area.x + area.width - childDimension.width - DrawerBorder.DRAWER_WIDTH;
					int y = area.y + (area.height / 2) - (childDimension.width / 2);
					if (!isCollapsed()) {
						y += DrawerBorder.DRAWER_HALF_HEIGHT / 2;
					}
					return new Point(x, y);
				}
				case PositionConstants.TOP | PositionConstants.LEFT: {
					// Top Left
					int x = area.x + DrawerBorder.DRAWER_WIDTH;
					int y = area.y + (borderImageWidth / 2);
					if (!isCollapsed()) {
						y += (collapsedLabel.getSize().height / 2) - (IBPELUIConstants.ARC_WIDTH / 2);
					}
					return new Point(x, y);
				}
				case PositionConstants.TOP | PositionConstants.RIGHT: {
					// Top Right
					int x = area.x + area.width - childDimension.width - DrawerBorder.DRAWER_WIDTH;
					int y = area.y + (borderImageWidth / 2);
					if (!isCollapsed()) {
						y += (collapsedLabel.getSize().height / 2) - (IBPELUIConstants.ARC_WIDTH / 2);
					} else {
						x -= 1; // 1 is a magic number
					}
					return new Point(x, y);
				}
				case PositionConstants.BOTTOM | PositionConstants.LEFT: {
					// Bottom Left
					int x = area.x + DrawerBorder.DRAWER_WIDTH;
					int y = area.y + area.height - IBPELUIConstants.ARC_WIDTH;
					if (!isCollapsed()) {
						y -= DrawerBorder.DRAWER_HALF_HEIGHT / 2;
					} else {
						y -= DrawerBorder.DRAWER_HALF_HEIGHT;
					}
					return new Point(x, y);
				}
				case PositionConstants.BOTTOM | PositionConstants.RIGHT: {
					// Bottom Right
					int x = area.x + area.width - childDimension.width - DrawerBorder.DRAWER_WIDTH;
					int y = area.y + area.height - IBPELUIConstants.ARC_WIDTH;
					if (!isCollapsed()) {
						y -= DrawerBorder.DRAWER_HALF_HEIGHT / 2;
					} else {
						y -= DrawerBorder.DRAWER_HALF_HEIGHT;
						x -= 1; // 1 is a magic number
					}
					return new Point(x, y);
				}
				default:
					return new Point(area.x, area.y);
			}
		}
	}

	public CollapsableEditPart() {
		this(false);
	}
	public CollapsableEditPart(boolean collapsed) {
		this.collapsed = collapsed;
	}
	protected void initializeLabels() {
		this.collapsedLabel = new Label(getLabel());
		
		// Get Image from registry
		this.image = getImg();
	}
	
	private boolean isGenericContainerBorder() {
		Border border = this.getContentPane().getBorder();
		return (border != null && border instanceof ContainerBorder);
	}
		
	@Override
	protected DrawerBorder getDrawerBorder() {
		Border border = getContentPane().getBorder();
		if (border instanceof DrawerBorder) return (DrawerBorder)border;
		return null;
	}
	
	@Override
	public Label getLabelFigure() {
		if (isGenericContainerBorder()) {
			ContainerBorder border = (ContainerBorder)(this.getContentPane().getBorder());
			return border.getLabel();
		}
		return collapsedLabel;
	}

	@Override
	protected IFigure createFigure() {		
		initializeLabels();
		editPartMarkerDecorator = new BPELEditPartMarkerDecorator(
			(EObject)getModel(),
			new CollapsableDecorationLayout(image.getBounds().width)
		);
		editPartMarkerDecorator.addMarkerMotionListener(getMarkerMotionListener());
		
		IFigure figure = getNewContentPane(editPartMarkerDecorator.getDecorationLayer());
		this.contentFigure = figure;
		
		figure.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_BLACK));		
		if (isCollapsed()) {
			addCollapsedContents(figure);
		} else {
			configureExpandedFigure(figure);
		}
		
		return editPartMarkerDecorator.createFigure(figure);
	}
	
	protected IFigure getNewContentPane(Layer layer) {
		CollapsableContainerFigure fig =  new CollapsableContainerFigure(getModel(), image, getLabel());
		fig.addMouseMotionListener(getMouseMotionListener());
		fig.setEditPart(this);
		return fig;
	}
	
	protected CollapsableContainerFigure getContentFigure() {
		return (CollapsableContainerFigure)this.contentFigure;
	}
	
	// subclasses can override this to change edit policies, etc.
	protected void notifyCollapsed(boolean collapsed) { }
	
	public void setCollapsed(boolean collapsed) {
		if (!isCollapsable()) return;

		if (isCollapsed() == collapsed) return;
		this.collapsed = collapsed;
		if (isGenericContainerBorder())
			getContentFigure().setCollapsed(collapsed);
		
		notifyCollapsed(collapsed);
		
		IFigure figure = getContentPane();
		if (isCollapsed()) {
			// First refresh children, which removes all model children's 
			// figures
			refreshChildren();
			
			
			// changed by Grid.Qian
			// when use figure.remove() to remove the children element
			// we will change the list of figure.getChildren()
			// so we will get the a error.
			int size = figure.getChildren().size();
			for(int i = 0; i < size; i++){
				figure.remove((IFigure)figure.getChildren().get(0));
			}
			
			/*// Manually remove the rest of the children
			for (Object o : figure.getChildren()) {
				figure.remove((IFigure)o);
			}*/
			
			
			// Now restore the collapsed children, border and layout
			addCollapsedContents(figure);
		} else {
			
			// changed by Grid.Qian
			// when use figure.remove() to remove the children element
			// we will change the list of figure.getChildren()
			// so we will get the a error.
			int size = figure.getChildren().size();
			for(int i = 0; i < size; i++){
				figure.remove((IFigure)figure.getChildren().get(0));
			}
			
			/*// Manually remove the children
			for (Object o : figure.getChildren()) {
				figure.remove((IFigure)o);
			}*/
			
			// Now restore the expanded children, border and layout
			configureExpandedFigure(figure);
			refreshChildren();
		}
		
		refreshSourceConnections();
		refreshTargetConnections();
		
		// Switching collapsed states may have changed the border, which is
		// responsible for drawing the drawer markers. Refresh these markers
		// now.
		refreshDrawerImages();
		// Force a repaint, as the drawer images may have changed.
		getFigure().repaint();
	}
	
	public boolean isCollapsed() {
		if (isGenericContainerBorder())
			return getContentFigure().isCollapsed();
		return collapsed;
	}
	
	protected boolean isCollapsable() {
		return true;
	}

	@Override
	protected void unregisterVisuals() {
		this.image = null;
		this.editPartMarkerDecorator = null;
		this.topImage = null;
		this.bottomImage = null;
		super.unregisterVisuals();
	}

	protected void addCollapsedContents(IFigure figure) {
		figure.setLayoutManager(new FlowLayout());
		
		if (!isGenericContainerBorder()) {
			LeafBorder lBorder = new LeafBorder(figure);
			// FIX: We have to set the editpart!
			lBorder.setEditPart(this);
			figure.setBorder(lBorder);
			figure.addMouseMotionListener(getMouseMotionListener());
			figure.add(collapsedLabel);
		}
	}
	@Override
	protected List getModelChildren() {
		if (isCollapsed()) return Collections.EMPTY_LIST;

		return getExpandedChildren();
	}
	
	protected boolean isPointInCollapseIcon(Point point) {
		if (isGenericContainerBorder()) {
			return getContentFigure().isPointInCollapseImage(point.x, point.y);
		}
		return true;
	}
	
	@Override
	public DragTracker getDragTracker(Request request) {
		return new BPELDragEditPartsTracker(this) {
			@Override
			protected boolean handleDoubleClick(int button) {
				if (!isGenericContainerBorder()) 
					setCollapsed(!isCollapsed());
				return true;
			}
			
			@Override
			protected boolean handleButtonDown(int button) {
				if (isGenericContainerBorder()) {
					if (isPointInCollapseIcon(getLocation())) {
						setCollapsed(!isCollapsed());
						return true;
					}
				}
				return super.handleButtonDown(button);
			}
		};	
	}
	
	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		// The name has changed, change the corresponding label
		if (!isGenericContainerBorder()) {
			collapsedLabel.setText(getLabel());
		} else {
			getContentFigure().setName(getLabel());
			getContentFigure().revalidate();
		}
		// Refresh any decorations on this edit part
		editPartMarkerDecorator.refresh();
		refreshDrawerImages();
		// Force a repaint, as the drawer images may have changed.
		getFigure().repaint();
	}
	/**
	 * Return the image that was created for the receiver. This image corresponds
	 * to the image descriptor which the subclass provided in getImageDescriptor().
	 * 
	 * This image may be used by subclasses for the lifetime of this edit part.
	 * TODO: Get rid of this. Subclasses should handle the lifecycle.
	 */	
	protected Image getImage() {
		return image;
	}
	/**
	 * Return an image which should be displayed in this node while
	 * collapsed. Subclasses may override.
	 */
	protected Image getImg() {
		ILabeledElement element = BPELUtil.adapt(getActivity(), ILabeledElement.class);
		if (element != null) {
			return element.getSmallImage(getActivity());
		}
		return null;
	}
	
	/**
	 * Return a string which should be displayed in this node while collapsed.
	 */
	protected String getLabel() {
		ILabeledElement element = BPELUtil.adapt(getActivity(), ILabeledElement.class);
		if (element != null) {
			return element.getLabel(getActivity());
		}
		return null;
	}
	
	/**
	 * Return a list of the model children that should be displayed while
	 * the node is in expanded mode. Subclasses may override.
	 */
	protected List getExpandedChildren() {
		return super.getModelChildren();
	}
	/**
	 * Configure the given figure for expanded mode. Subclasses should do work
	 * in here to set border and layout information for expanded mode.
	 */
	protected abstract void configureExpandedFigure(IFigure figure);
	
	/**
	 * A CollapsableEditPart has extra responsibilities for source and target connections,
	 * because it must show flow links for any activities which are inside it but not
	 * visible (in the case that the CollapsableEditPart is collapsed).
	 */	
	@Override
	protected List<Link> getModelSourceConnections() {
		final List<Link> result = super.getModelSourceConnections();
//		if (isCollapsed()) {
//			BPELUtil.visitModelDepthFirst(getActivity(), new IModelVisitor() {
//				public boolean visit(Object modelObject) {
//					if (modelObject instanceof Activity) {
//						List sources = ((Activity)modelObject).getSources();
//						Iterator it = sources.iterator();
//						while (it.hasNext()) {
//							Source source = (Source)it.next();
//							Target target = source.getLink().getTarget();
//							Activity targetActivity = target.getActivity();
//							// If the target is not contained in this model object, add the 
//							// connection.
//							if (!containsModel(targetActivity)) {
//								result.add(source.getLink());
//							}
//						}
//					}
//					return true;
//				}
//			});
//		}
		return result;
	}

	/**
	 * A CollapsableEditPart has extra responsibilities for source and target connections,
	 * because it must show flow links for any activities which are inside it but not
	 * visible (in the case that the CollapsableEditPart is collapsed).
	 */
	@Override
	protected List<Link> getModelTargetConnections() {
		final List<Link> result = super.getModelTargetConnections();
//		if (isCollapsed()) {
//			BPELUtil.visitModelDepthFirst(getActivity(), new IModelVisitor() {
//				public boolean visit(Object modelObject) {
//					if (modelObject instanceof Activity) {
//						List targets = ((Activity)modelObject).getTargets();
//						Iterator it = targets.iterator();
//						while (it.hasNext()) {
//							Target target = (Target)it.next();
//							Source source = target.getLink().getSource();
//							Activity sourceActivity = source.getActivity();
//							// If the source is not contained in this model object, add the 
//							// connection.
//							if (!containsModel(sourceActivity)) {
//								result.add(target.getLink());
//							}
//						}
//					}
//					return true;
//				}
//			});
//		}
		return result;
	}
	
	@Override
	public IFigure getContentPane() {
		return contentFigure;
	}

	public Label getCollapsedLabel() {
		return collapsedLabel;
	}

	protected void refreshDrawerImages() {
		DrawerBorder border = (DrawerBorder)getContentPane().getBorder();
		
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
		
		for (IMarker marker : holder.getMarkers(getActivity())) {
			
			if (marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true) == false) {
				continue;
			}
			
			String value = marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR,EMPTY_STRING);  
			
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
	 * Get an anchor at the given location for this edit part.
	 * 
	 * This must be called after the figure for this edit part has been created.
	 */
	@Override
	public ConnectionAnchor getConnectionAnchor(int location) {
		switch(location){
		case CenteredConnectionAnchor.TOP_INNER:
			return new CenteredConnectionAnchor(getFigure(), location, 30);
		case CenteredConnectionAnchor.LEFT:
			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.LEFT_INNER, 0);
		case CenteredConnectionAnchor.RIGHT:
			return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.RIGHT_INNER, 0);
		default:
				return super.getConnectionAnchor(location);
		}
	}
}
