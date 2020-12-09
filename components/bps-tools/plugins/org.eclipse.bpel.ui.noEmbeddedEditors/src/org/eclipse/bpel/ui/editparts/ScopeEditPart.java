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
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.layouts.AlignedFlowLayout;
import org.eclipse.bpel.common.ui.markers.IModelMarkerConstants;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.ICompensationHandlerHolder;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.IEventHandlerHolder;
import org.eclipse.bpel.ui.adapters.IFaultHandlerHolder;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.adapters.IMarkerHolder;
import org.eclipse.bpel.ui.adapters.ITerminationHandlerHolder;
import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.bpel.ui.editparts.borders.ScopeBorder;
import org.eclipse.bpel.ui.editparts.figures.CollapsableContainerFigure;
import org.eclipse.bpel.ui.editparts.figures.CollapsableScopeContainerFigure;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.ContainerHighlightEditPolicy;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.figures.ScopeHandlerLinker;
import org.eclipse.bpel.ui.util.BPELDragEditPartsTracker;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.marker.BPELEditPartMarkerDecorator;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.swt.graphics.Image;


/**
 * Needs refactoring. Has the following responsibilities:
 * -Knows whether or not FH/EH/CH/TH are showing
 * -Marker decorator works when expanded and collapsed
 * -Has a ScopeBorder which knows about FH/EH/CH/TH decorations
 */
public class ScopeEditPart extends CollapsableEditPart {
	// The amount of spacing to place between child items. Subclasses
	// may use this value when creating a flow layout
	// TODO: Fix this magic value
	public static final int SPACING = 19;
	
	// Whether to show each of the handlers.
	// TODO: Initialize these from the preferences store
	private boolean showFH = false, showEH = false, showCH = false, showTH = false;

	// The images for the top and bottom drawer, if any.
	private Image topImage, bottomImage;
	
	// The figure which holds contentFigure and auxilaryFigure as children
	private IFigure parentFigure;
	
	// The figure which holds fault handler, compensation handler and event handler
	private AuxiliaryFigure auxilaryFigure;
	
	// The figure which holds the activity
	private CollapsableScopeContainerFigure contentFigure;
	
	// The Handler which handles the drawing of links to the handlers.
	private ScopeHandlerLinker handlerLinker;

	// The text and image labels to show when collapsed.
	private Image collapsedImage;
	private Label collapsedNameLabel, collapsedImageLabel;
	
	public class ScopeOrderedLayoutEditPolicy extends BPELOrderedLayoutEditPolicy {
		// return list of children to create vertical connections for.
		@Override
		protected List getConnectionChildren(BPELEditPart editPart) {
			List originalChildren = getChildren();
			List newChildren = new ArrayList();
			Iterator it = originalChildren.iterator();
			while (it.hasNext()) {
				Object next = it.next();
				if (next instanceof FaultHandlerEditPart) {
					continue;
				}
				newChildren.add(next);
			}
			return newChildren;
		}		
	}
	
	/**
	 * A special figure which can be informed of a figureMoved event
	 * via a FigureListener. 
	 * @author ascharf
	 *
	 */
	private class AuxiliaryFigure extends Figure implements FigureListener{

		public void figureMoved(IFigure source) {
			refreshMargin();
		}
		
		private void refreshMargin(){
			if(ModelHelper.isHorizontalLayout(getModel()))
				setBorder(new MarginBorder(contentFigure.getPreferredSize().height+10,0,0,0));
			else
				setBorder(null);
		}
	}
	
	private class ScopeOrderedHorizontalLayoutEditPolicy extends ScopeEditPart.ScopeOrderedLayoutEditPolicy{
		@Override
		protected ArrayList<PolylineConnection> createHorizontalConnections(BPELEditPart parent) {
			ArrayList<PolylineConnection> connections = new ArrayList<PolylineConnection>();
			List children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor = null, targetAnchor = null;
			
			sourcePart = parent;
			sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
			
			if (children != null){
				for (int i = 0; i < children.size(); i++) {
					if(i == 0){
						targetPart = (BPELEditPart)children.get(i);
						targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
						if(sourceAnchor != null && targetAnchor != null)
							connections.add(createConnection(sourceAnchor,targetAnchor,arrowColor));
					}
					if(i < children.size()-1){
						if(i>0){
							sourcePart = (BPELEditPart)children.get(i);
							sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
						}
						targetPart = (BPELEditPart)children.get(i+1);
						targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
					}else{
						// Link from the last child to the right border
						sourcePart = (BPELEditPart)children.get(i);
						sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
						targetAnchor = parent.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
					}
					if(sourceAnchor != null && targetAnchor != null)
						connections.add(createConnection(sourceAnchor,targetAnchor,arrowColor));
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
				return 0;
			}
			@Override
			protected int getSouthInset() {
				return 3;
			}
			@Override
			protected int getEastInset() {
				return DrawerBorder.DRAWER_WIDTH;
			}
			@Override
			protected int getWestInset() {
				return DrawerBorder.DRAWER_WIDTH;
			}			
		});
		if(ModelHelper.isHorizontalLayout(getModel()))
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ScopeOrderedHorizontalLayoutEditPolicy());
		else
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ScopeOrderedLayoutEditPolicy());
	}

	@Override
	protected DrawerBorder getDrawerBorder() {
		Border border = getContentPane().getBorder();
		if (border instanceof DrawerBorder) return (DrawerBorder)border;
		return null;
	}
	
	/**
	 * The label figure to return for direct editing
	 * TODO: Enable this
	 */
	@Override
	public Label getLabelFigure() {
		return null;
	}

	@Override
	protected IFigure createFigure() {
		// TODO: Shouldn't have to initialize labels in each subclass.
		initializeLabels();
		if (collapsedImage == null) {
			// Create the actual figure for the collapsed edit part
			ILabeledElement element = BPELUtil.adapt(getActivity(), ILabeledElement.class);
			collapsedImage = element.getSmallImage(getActivity());
		}
		this.collapsedImageLabel = new Label(collapsedImage);
		this.collapsedNameLabel = new Label(getLabel());

		// TODO: Shouldn't have to set the decorator in each subclass.
		editPartMarkerDecorator = new BPELEditPartMarkerDecorator((EObject)getModel(), 
				new CollapsableDecorationLayout(/*collapsedImage.getBounds().width*/0));
		editPartMarkerDecorator.addMarkerMotionListener(getMarkerMotionListener());
		
		this.parentFigure = new Figure();
		AlignedFlowLayout layout = new AlignedFlowLayout();
		layout.setHorizontal(true);
		layout.setHorizontalSpacing(0);
		layout.setVerticalSpacing(0);
		parentFigure.setLayoutManager(layout);
		
		this.contentFigure = new CollapsableScopeContainerFigure(getModel(), getImage(), getLabel());
		contentFigure.addMouseMotionListener(getMouseMotionListener());
		contentFigure.setEditPart(this);
		contentFigure.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_BLACK));
		parentFigure.add(contentFigure);
		
		// Configure the border and contents based on collapsed state
		if (isCollapsed()) {
			configureCollapsedFigure(contentFigure);
		} else {
			configureExpandedFigure(contentFigure);
		}
		
		boolean isHorizontal = ModelHelper.isHorizontalLayout(getModel());
		
		this.auxilaryFigure = new AuxiliaryFigure();
		layout = new AlignedFlowLayout();
		layout.setHorizontal(!isHorizontal);
		auxilaryFigure.setLayoutManager(layout);
		contentFigure.addFigureListener(auxilaryFigure);
		
		parentFigure.add(auxilaryFigure);
		
		ScopeBorder border = getScopeBorder();
		border.setShowFault(getFaultHandler() != null);
		border.setShowCompensation(getCompensationHandler() != null);
		border.setShowTermination(getTerminationHandler() != null);
		border.setShowEvent(getEventHandler() != null);
		
		return editPartMarkerDecorator.createFigure(parentFigure);
	}
		
	@Override
	protected CollapsableContainerFigure getContentFigure() {
		return this.contentFigure;
	}
	
	@Override
	protected void unregisterVisuals() {
		super.unregisterVisuals();
		this.editPartMarkerDecorator = null;
		this.topImage = null;
		this.bottomImage = null;
	}

	@Override
	protected List getModelChildren() {
		return getModelChildren(!isCollapsed());
	}
	
	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	public void refreshVisuals() {
		refreshDrawerImages();
		super.refreshVisuals();
		// Refresh any decorations on this edit part
		editPartMarkerDecorator.refresh();
		ScopeBorder border = getScopeBorder();
		border.setShowFault(getFaultHandler() != null);
		border.setShowCompensation(getCompensationHandler() != null);
		border.setShowTermination(getTerminationHandler() != null);
		border.setShowEvent(getEventHandler() != null);
		
		auxilaryFigure.refreshMargin();
		
		// Force a repaint, as the drawer images may have changed.
		getFigure().repaint();
	}
	
	/**
	 * Return a string which should be displayed in this node while collapsed.
	 */
	@Override
	protected String getLabel() {
		ILabeledElement element = BPELUtil.adapt(getActivity(), ILabeledElement.class);
		if (element != null) {
			return element.getLabel(getActivity());
		}
		return null;
	}
		
	/**
	 * Make sure the images in the drawers are up to date. Recalculate them and
	 * inform the border of any changes.
	 */
	@Override
	protected void refreshDrawerImages() {
		ScopeBorder border = getScopeBorder();
		
		if (topImage != null) {
			topImage.dispose();
			topImage = null;
		}
		if (bottomImage != null) {
			bottomImage.dispose();
			bottomImage = null;
		}
		IMarkerHolder holder = BPELUtil.adapt(getActivity(), IMarkerHolder.class);
		IMarker[] markers = holder.getMarkers(getActivity());
		int topMarkerPriority = Integer.MIN_VALUE;
		int bottomMarkerPriority = Integer.MIN_VALUE;
		IMarker topMarker = null;
		IMarker bottomMarker = null;
		for (int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			String value = marker.getAttribute(IModelMarkerConstants.DECORATION_GRAPHICAL_MARKER_ANCHOR_POINT_ATTR, ""); //$NON-NLS-1$
			if (value.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_TOP)) {
				if (marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true)) {
					int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, Integer.MIN_VALUE);
					if (priority > topMarkerPriority) {
						topMarkerPriority = priority;
						topImage = BPELUtil.getImage(marker);
						topMarker = marker;
					}
				}
			} else if (value.equals(IBPELUIConstants.MARKER_ANCHORPOINT_DRAWER_BOTTOM)) {
				if (marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_VISIBLE_ATTR, true)) {
					int priority = marker.getAttribute(IModelMarkerConstants.DECORATION_MARKER_PRIORITY_ATTR, Integer.MIN_VALUE);
					if (priority > bottomMarkerPriority) {
						bottomMarkerPriority = priority;
						bottomImage = BPELUtil.getImage(marker);
						bottomMarker = marker;
					}
				}
			}
		}
		border.setTopImage(topImage);
		border.setBottomImage(bottomImage);
		border.setTopMarker(topMarker);
		border.setBottomMarker(bottomMarker);
	}
	
	/**
	 * Return a list of the model children that should be displayed. 
	 * This includes activities (if includeActivity is true), fault handlers,
	 * compensation handlers and event handlers.
	 */
	protected List<EObject> getModelChildren(boolean includeActivity) {
    	ArrayList<EObject> children = new ArrayList<EObject>();
    	if (includeActivity) {
	    	// Use IContainer here for implicit sequence handling
			IContainer container = BPELUtil.adapt(getModel(), IContainer.class);
			for (Iterator<EObject> it = container.getChildren(getModel()).iterator(); it.hasNext(); ) {
				EObject child = it.next();
				if (child instanceof Activity) children.add(child);
			}
    	}

    	if (showFH) {
			FaultHandler faultHandler = this.getFaultHandler();
	    	if (faultHandler != null) children.add(children.size(), faultHandler);
    	}

    	if (showCH) {
	    	CompensationHandler compensationHandler = this.getCompensationHandler();
	    	if (compensationHandler != null) children.add(children.size(), compensationHandler);
    	}

    	if (showTH) {
	    	TerminationHandler terminationHandler = this.getTerminationHandler();
	    	if (terminationHandler != null) children.add(children.size(), terminationHandler);
    	}

    	if (showEH) {
	    	EventHandler eventHandler = this.getEventHandler();
	    	if (eventHandler != null) children.add(children.size(), eventHandler);
    	}

    	return children;
    }
	
	/**
	 * The top inner implicit connection needs an offset of eight to compensate for
	 * the expansion icon. All other connections are centered on the contentFigure
	 * with an offset of 0.
	 */
	@Override
	public ConnectionAnchor getConnectionAnchor(int location) {
		switch(location){
		case CenteredConnectionAnchor.TOP_INNER:
			return new CenteredConnectionAnchor(contentFigure, location, 8);
		case CenteredConnectionAnchor.LEFT:
			return new CenteredConnectionAnchor(contentFigure, CenteredConnectionAnchor.LEFT_INNER, 0);
		case CenteredConnectionAnchor.RIGHT:
			return new CenteredConnectionAnchor(contentFigure, CenteredConnectionAnchor.RIGHT_INNER, 0);
		default:
				return new CenteredConnectionAnchor(contentFigure, location, 0);
		}
	}	
	
	/**
	 * Override addChildVisual so that it adds the childEditPart to the correct
	 * figure. FH/EH/CH go in a different figure than the activity does.
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart)childEditPart).getFigure();
		IFigure content = getContentPane(childEditPart);
		if (content != null) {
			if (childEditPart instanceof ActivityEditPart) {
				content.add(child, index);
			}  else {
				// We want to have a kind of sorting, so get the
				// correct index
				content.add(child, getIndexForChild(content, childEditPart));
			}
		}
	}	
	
	/**
	 * Gets the index for the given <code>child</code> which should be
	 * inserted into the <code>container</code> afterwards. This method
	 * does a kind of really simple sorting.
	 * @param container	The container where the child will be inserted.
	 * @param child		The child to get the index for
	 * @return 			The index for inserting the child into the container
	 */
	private int getIndexForChild(IFigure container, EditPart child) {
		int result = 0;
		Object model = child.getModel();
		if(model instanceof TerminationHandler){
			if(showEH)
				result++;
		}else if(model instanceof CompensationHandler){
			if(showEH)
				result++;
			if(showTH)
				result++;
		}else if(model instanceof FaultHandler){
			if(showEH)
				result++;
			if(showTH)
				result++;
			if(showCH)
				result++;
		}
		return result;
	}

	/**
	 * Override removeChildVisual so that it removes the childEditPart from
	 * the correct figure. FH/EH/CH live in a different figure than the
	 * activity does.
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		IFigure child = ((GraphicalEditPart)childEditPart).getFigure();
		getContentPane(childEditPart).remove(child);
	}
	
	/**
	 * Also overridden to call getContentPane(child) in the appropriate place.
	 */
	@Override
	protected void reorderChild(EditPart child, int index) {
		// Save the constraint of the child so that it does not
		// get lost during the remove and re-add.
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		LayoutManager layout = getContentPane(child).getLayoutManager();
		Object constraint = null;
		if (layout != null)
			constraint = layout.getConstraint(childFigure);

		removeChildVisual(child);
		List children = getChildren();
		children.remove(child);
		children.add(index, child);
		addChildVisual(child, index);
		
		setLayoutConstraint(child, childFigure, constraint);
	}

	/**
	 * Yet Another Overridden Method.
	 */
	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		getContentPane(child).setConstraint(childFigure, constraint);
	}

	/**
	 * This method hopefully shouldn't be called, in favour of getContentPane(EditPart).
	 */
	@Override
	public IFigure getContentPane() {
		return contentFigure;
	}

	/**
	 * Return the appropriate content pane into which the given child
	 * should be inserted. For faultHandler, compensationHandler and
	 * eventHandler, the answer is auxilaryFigure; for activities it
	 * is the contentFigure.
	 */
	protected IFigure getContentPane(EditPart childEditPart) {
		Object model = childEditPart.getModel();
		if (model instanceof FaultHandler) {
			return auxilaryFigure;
		} else if (model instanceof CompensationHandler) {
			return auxilaryFigure;
		} else if (model instanceof TerminationHandler) {
			return auxilaryFigure;
		} else if (model instanceof EventHandler) {
			return auxilaryFigure;
		} else if (model instanceof Activity) {
			return contentFigure;
		}
		return contentFigure;
	}
	
	// Support for collapsability
	
	@Override
	public DragTracker getDragTracker(Request request) {
		return new BPELDragEditPartsTracker(this) {
			@Override
			protected boolean handleDoubleClick(int button) {
				//if (isCollapsed()) setCollapsed(false);
				setCollapsed(!isCollapsed());
				return true;
			}
			
			@Override
			protected boolean handleButtonDown(int button) {
				Point point = getLocation();
				ScopeBorder border = getScopeBorder();
				if (border.isPointInFaultImage(point.x, point.y)) {
					setShowFaultHandler(!showFH);
					return true;
				}
				if (border.isPointInCompensationImage(point.x, point.y)) {
					setShowCompensationHandler(!showCH);
					return true;
				}
				if (border.isPointInTerminationImage(point.x, point.y)) {
					setShowTerminationHandler(!showTH);
					return true;
				}
				if (border.isPointInEventImage(point.x, point.y)) {
				    setShowEventHandler(!showEH);
				    return true;
				}
				if (isPointInCollapseIcon(getLocation())) {
					setCollapsed(!isCollapsed());
					return true;
				}
				return super.handleButtonDown(button);
			}
		};	
	}

	@Override
	protected boolean isPointInCollapseIcon(Point point) {
		return getContentFigure().isPointInCollapseImage(point.x, point.y);
	}

	@Override
	public boolean isCollapsed() {
		return getContentFigure().isCollapsed();
	}
	
	@Override
	public void setCollapsed(boolean collapsed) {
		if (isCollapsed() == collapsed) return;
		getContentFigure().setCollapsed(collapsed);
			
		IFigure figure = getContentPane();
		if (isCollapsed()) {
			// First refresh children, which removes all model children's figures
			refreshChildren();
			
			// Manually remove the rest of the children
			IFigure[] children = (IFigure[])figure.getChildren().toArray(new IFigure[0]);
			for (int i = 0; i < children.length; i++) {
				figure.remove(children[i]);
			}
			
			// Now restore the collapsed children, border and layout
			configureCollapsedFigure(figure);
		} else {
			// Manually remove the children
			IFigure[] children = (IFigure[])figure.getChildren().toArray(new IFigure[0]);
			for (int i = 0; i < children.length; i++) {
				figure.remove(children[i]);
			}

			// Now restore the expanded children, border and layout
			configureExpandedFigure(figure);
			refreshChildren();
		}
		
//		refreshSourceConnections();
//		refreshTargetConnections();
//		
//		// Switching collapsed states may have changed the border, which is
//		// responsible for drawing the drawer markers. Refresh these markers
//		// now.
//		// TODO: This isn't necessary anymore
//		refreshDrawerImages();
//		// Force a repaint, as the drawer images may have changed.
//		getFigure().repaint();

		// Instead of manually calling all refresh methods,
		// a call to refreshVisuals should be enough
		refreshVisuals();
	}
	
	protected void configureCollapsedFigure(IFigure figure) {
		figure.setLayoutManager(new FlowLayout());
		figure.addMouseMotionListener(getMouseMotionListener());
		figure.add(collapsedImageLabel);
		figure.add(collapsedNameLabel);
	}
	
	/**
	 * Set the layout of the figure for expanded state.
	 */
	@Override
	protected void configureExpandedFigure(IFigure figure) {
		FlowLayout layout = new FlowLayout();
		layout.setMajorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setHorizontal(ModelHelper.isHorizontalLayout(getModel()));
		layout.setMajorSpacing(SPACING);
		layout.setMinorSpacing(SPACING);
		figure.setLayoutManager(layout);
	}	
	
	private ScopeBorder getScopeBorder() {
		return (ScopeBorder)getContentPane().getBorder();		
	}

	public void setShowFaultHandler(boolean showFaultHandler) {
		this.showFH = showFaultHandler;
		// Call refresh so that both refreshVisuals and refreshChildren will be called.
		refresh();
	}

	public void setShowCompensationHandler(boolean showCompensationHandler) {
		this.showCH = showCompensationHandler;
		// Call refresh so that both refreshVisuals and refreshChildren will be called.
		refresh();
	}

	public void setShowTerminationHandler(boolean showTerminationHandler) {
		this.showTH = showTerminationHandler;
		// Call refresh so that both refreshVisuals and refreshChildren will be called.
		refresh();
	}

	public void setShowEventHandler(boolean showEventHandler) {
		this.showEH = showEventHandler;
		// Call refresh so that both refreshVisuals and refreshChildren will be called.
		refresh();
	}
		
	public boolean getShowFaultHandler() {
		return showFH;
	}
	
	public boolean getShowEventHandler() {
		return showEH;
	}
	
	public boolean getShowCompensationHandler() {
		return showCH;
	}

	public boolean getShowTerminationHandler() {
		return showTH;
	}

	public FaultHandler getFaultHandler() {
		IFaultHandlerHolder holder = BPELUtil.adapt(getActivity(), IFaultHandlerHolder.class);
		if (holder != null) {
			return holder.getFaultHandler(getActivity());
		}
		return null;
	}
	
	public CompensationHandler getCompensationHandler() {
		ICompensationHandlerHolder holder = BPELUtil.adapt(getActivity(), ICompensationHandlerHolder.class);
		if (holder != null) {
			return holder.getCompensationHandler(getActivity());
		}
		return null;
	}

	public TerminationHandler getTerminationHandler() {
		ITerminationHandlerHolder holder = BPELUtil.adapt(getActivity(), ITerminationHandlerHolder.class);
		if (holder != null) {
			return holder.getTerminationHandler(getActivity());
		}
		return null;
	}

	public EventHandler getEventHandler() {
		IEventHandlerHolder holder = BPELUtil.adapt(getActivity(), IEventHandlerHolder.class);
		if (holder != null) {
			return holder.getEventHandler(getActivity());
		}
		return null;
	}
	
	@Override
	public IFigure getMainActivityFigure() {
		return contentFigure;
	}

	public void switchLayout(boolean horizontal) {
		((FlowLayout)contentFigure.getLayoutManager()).setHorizontal(horizontal);
		((AlignedFlowLayout)auxilaryFigure.getLayoutManager()).setHorizontal(!horizontal);
		
		this.removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		
		if(horizontal){
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ScopeOrderedHorizontalLayoutEditPolicy());
		}else{
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ScopeOrderedLayoutEditPolicy());
		}
			
				
	}
	
	/**
	 * Overridden to refresh the handlerLinks as needed.
	 */
	@Override
	public void refresh() {
		super.refresh();
		getHandlerLinker().refreshHandlerLinks();
		
		
	}
	
	@Override
	protected void clearConnections() {
		super.clearConnections();
		getHandlerLinker().clearHandlerConnections();
	}
	
	private ScopeHandlerLinker getHandlerLinker() {
		if(handlerLinker == null)
			handlerLinker = new ScopeHandlerLinker(this);
		return handlerLinker;
	}
	
	@Override
	protected void handleModelChanged() {
		super.handleModelChanged();
		
		this.showCH = getCompensationHandler() != null ? true : false;
		this.showFH = getFaultHandler() != null ? true : false;
		this.showEH = getEventHandler() != null ? true : false;
		this.showTH = getTerminationHandler() != null ? true : false;
		
		
		
		refresh();
	}

}
