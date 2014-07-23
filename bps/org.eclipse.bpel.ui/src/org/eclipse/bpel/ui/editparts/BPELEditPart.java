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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IHoverHelper;
import org.eclipse.bpel.ui.IHoverHelperSupport;
import org.eclipse.bpel.ui.adapters.AdapterNotification;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.editparts.policies.BPELComponentEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELDirectEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.BPELCellEditorLocator;
import org.eclipse.bpel.ui.util.BPELDirectEditManager;
import org.eclipse.bpel.ui.util.BPELDragEditPartsTracker;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.bpel.ui.util.marker.BPELEditPartMarkerDecorator;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleAnchorProvider;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.viewers.TextCellEditor;


/**
 * The superclass of all BPEL edit parts. Provides a listener on the model
 * which calls the handleModelChanged() method.
 */
@SuppressWarnings("nls")
public abstract class BPELEditPart extends AbstractGraphicalEditPart implements IHoverHelperSupport {

	/**
	 *  The amount of spacing to place between child items. Subclasses
	 */
	public static final int SPACING = 14;
	
	static protected String EMPTY_STRING = "";
	
	protected AccessibleEditPart acc;

	protected MultiObjectAdapter adapter;
	
	protected BPELEditPartMarkerDecorator.MarkerMotionListener markerMotionListener;
	
	// The direct edit manager handles the in-place editing of node names on the graphical canvas.
	private DirectEditManager manager;

	// Mouse motion hover help support
	protected int mouseLocation = 0; // 0 == no marker, 1 == top drawer, 2 == bottom drawer, 3 == marker on main figure
	
	/**
	 * Create a new BPELEditPart.
	 * 
	 * Construct the model adapter.
	 */
	public BPELEditPart() {
		adapter = new MultiObjectAdapter() {
			
			@Override
			public void notify(Notification n) {
				int eventGroup = n.getEventType() / 100;
				if (eventGroup == AdapterNotification.NOTIFICATION_MARKERS_CHANGED_GROUP ) {					
					refreshVisuals();
					return ;
				}
				
				
				// TODO: check if we care about this notification
				if (isActive()) {
					handleModelChanged();
				}
				refreshAdapters();
			}
		};
	}
	
	/**
	 * Default implementation based on IContainer.  Should be sufficient except in
	 * special cases (such as ProcessEditPart?). 
	 */
	@Override
	protected List getModelChildren() {
		IContainer container = BPELUtil.adapt(getModel(), IContainer.class);
		if (container != null) {
			return container.getChildren(getModel());
		}
		return super.getModelChildren();
	}

	protected void addAllAdapters() {
		EObject modelObject = (EObject)getModel();  
		adapter.addToObject(modelObject);
		
		// if the object has an extension, add adapter to that too
		EObject extension = ModelHelper.getExtension(modelObject);
		if (extension != null) adapter.addToObject(extension);
		// if the object contains an implicit sequence, add adapter to that also
		try {
			Activity activity = ModelHelper.getActivity(modelObject);
			if (activity instanceof Sequence) {
				// TODO: perhaps we should check and make sure it's an implicit sequence!
				// for now, don't worry about it.
				adapter.addToObject(activity);
			}
		} catch (IllegalArgumentException e) {
			// it's not a single-activity container.  ignore.
		}
		// ..but we probably don't need an adapter on the implicit sequence...
	}
	
	protected void removeAllAdapters() {
		adapter.removeFromAll();
	}
	
	protected void refreshAdapters() {
		removeAllAdapters();
		addAllAdapters();
	}
	
	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		if (isActive()) {
			return;
		}
		super.activate();
		addAllAdapters();
	}

	/**
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		if (!isActive()) {
			return;		
		}
		removeAllAdapters();
		super.deactivate();
		clearConnections();					
	}

	
	@Override
	protected void createEditPolicies() {
		// The COMPONENT_ROLE policy determines how an edit part is deleted.
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new BPELComponentEditPolicy());

		// The DIRECT_EDIT_ROLE policy determines how in-place editing takes place.
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new BPELDirectEditPolicy());
	}
	
	
	/**
	 * The model has changed. Perform any actions necessary to ensure that the
	 * edit part, model and graphical representation are in sync.
	 * 
	 * Subclasses may override but should call super.
	 */
	protected void handleModelChanged() {
		// If property name is children, refresh children.
		// If property name is size or location, refresh visuals.
		// TODO: refresh connections in there somewhere too!
		refreshChildren();
		refreshVisuals();
		
		refresh();
	}
	
	/**
	 * Get an anchor at the given location for this edit part.
	 * 
	 * This must be called after the figure for this edit part has been created.
	 * @param location 
	 * @return 
	 */
	public ConnectionAnchor getConnectionAnchor(int location) {
		return new CenteredConnectionAnchor(getFigure(), location, 0);
	}

	/**
	 * Return whether or not the edit part can execute the given request.
	 * The answer is determined by asking each edit policy and returning
	 * true if any policy can execute the request.
	 * @param request 
	 * @return 
	 */
	public boolean canExecuteRequest(Request request) {
		EditPolicyIterator i = getEditPolicyIterator();
		while (i.hasNext()) {
			Command cm= i.next().getCommand(request);
			if (cm != null)
				if (cm.canExecute())
					return true;
		}
		return false;
	}

	/**
	 * Override to handle direct edit requests
	 */
	@Override
	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEdit();
		} else {
			super.performRequest(request);
		}
	}

	/**
	 * Return whether the receiver can perform direct edit.
	 */
	public boolean canPerformDirectEdit() {
		return getLabelFigure() != null;
	}
	
	/**
	 * Invoke direct edit on the receiver
	 */
	public void performDirectEdit() {
		if (getLabelFigure() != null) {
			// make sure we can execute it through
			Command cmd = BPELDirectEditPolicy.getFinalizeCommand(this.getModel(), "blahblah"); //$NON-NLS-1$
			if (cmd == null || !cmd.canExecute())
				return;
			
			if (manager == null) {
				manager = new BPELDirectEditManager(this, TextCellEditor.class,
						new BPELCellEditorLocator(getLabelFigure()), getLabelValidator());
			}
			manager.show();
		}
	}
	
	/**
	 * Return the label that should be used for direct edit.
	 * 
	 * The default implementation returns null.
	 * 
	 * Subclasses should override to return the appropriate label.
	 */
	public Label getLabelFigure() {
		return null;
	}

	/**
	 * Return the text to display in the label for the edit part.
	 * 
	 * The default implementation returns null.
	 * 
	 * Subclasses should override to return the appropriate text.
	 */
	public String getLabelContent() {
		return null;
	}
	
	/**
	 * Set the text to display in the label for the edit part.
	 * 
	 * The default implementation does nothing.
	 * 
	 * Subclasses should override to set the label to the given string.
	 */
	public void setLabelContent(String str) {
	}
	
	/**
	 * TODO: visibility increased (from protected) so I could move the edit
	 * policies to a separate package.  In future, we should change it back.
	 */
	
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		refreshHoverHelp();
	}
	
	@Override
	protected void refreshChildren() {		
		super.refreshChildren();
		
		// Not the most logical place to refresh connections, but it
		// needs to be refreshed after the children are refreshed		
		//TODO: May make more sense to put connections into adapter
		// so connections are not refreshed unnecessarily
		refreshConnections();
	}

	protected void refreshConnections(){
		EditPolicy policy = getEditPolicy(EditPolicy.LAYOUT_ROLE);
		if (policy instanceof BPELOrderedLayoutEditPolicy){
			((BPELOrderedLayoutEditPolicy)policy).refreshConnections();
		}
	}
	
	protected void clearConnections(){
		EditPolicy policy = getEditPolicy(EditPolicy.LAYOUT_ROLE);
		if (policy instanceof BPELOrderedLayoutEditPolicy){
			((BPELOrderedLayoutEditPolicy)policy).clearConnections();
		}
	}
	
	@Override
	public Object getAdapter(Class key) {
		if (key.isInstance(getModel())) {
			return getModel();
		}
		
		if (key == AccessibleAnchorProvider.class) {
			return new DefaultAccessibleAnchorProvider() {
				private List<Point> getDefaultLocations() {
					List<Point> list = new ArrayList<Point>();
					Rectangle r = getFigure().getBounds();
					
					// when calculating the target in connection tools, it was targettig
					// the object behind the figure we were interested in, so adding an addition
					// fudge factor to -2 helps make sure we hit the right target
					Point p = r.getTopRight().translate(-r.width / 2, r.height / 3);
					getFigure().translateToAbsolute(p);
					list.add(p);
					return list;
				}
				/**
				 * @see AccessibleAnchorProvider#getSourceAnchorLocations()
				 */
				@Override
				public List<Point> getSourceAnchorLocations() {
					return getDefaultLocations();
				}
				/**
				 * @see AccessibleAnchorProvider#getTargetAnchorLocations()
				 */
				@Override
				public List<Point> getTargetAnchorLocations() {
					return getDefaultLocations();
				}
			};
		}
		return super.getAdapter(key);
	}
	
	public void regenerateVisuals() {
	}
	
	// increase visibility!
	@Override
	public void refreshSourceConnections() { super.refreshSourceConnections(); }
	@Override
	public void refreshTargetConnections() { super.refreshTargetConnections(); }
	
	public void refreshHoverHelp() {
		// Refresh the tooltip if we can find a helper.
		try {
			IHoverHelper helper = BPELUIRegistry.getInstance().getHoverHelper();
			if (helper != null) {
				IFigure tooltip = helper.getHoverFigure((EObject)getModel());
				getFigure().setToolTip(tooltip);
			}
		} catch (CoreException e) {
			getFigure().setToolTip(null);
			BPELUIPlugin.log(e);
		}		
	}
	
	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected AccessibleEditPart getAccessibleEditPart() {
		if (acc == null) acc = createAccessible();
		return acc;
	}
	
	protected AccessibleEditPart createAccessible() {
		return BPELUtil.getAccessibleEditPart(this);
	}

	protected BPELEditPartMarkerDecorator.MarkerMotionListener getMarkerMotionListener() {
		return markerMotionListener = new BPELEditPartMarkerDecorator.MarkerMotionListener() {
			public void markerEntered(IMarker marker) {
				// refresh the hover help for this marker.
				mouseLocation = 3;
				refreshHoverHelp();
			}
		};	
	}
	
	@Override
	public DragTracker getDragTracker(Request request) {
		return new BPELDragEditPartsTracker(this);
	}
	
	/**
	 * Returns the label validator for this part or <code>null</code> if not applicable. The
	 * default behavior is to return <code>null</code>. Subclasses may override this method.
	 */
	protected IInputValidator getLabelValidator() {
		return null;
	}
}
