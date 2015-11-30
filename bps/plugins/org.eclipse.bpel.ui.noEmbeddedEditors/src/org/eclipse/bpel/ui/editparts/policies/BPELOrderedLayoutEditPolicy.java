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
package org.eclipse.bpel.ui.editparts.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.layouts.AlignedFlowLayout;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.GraphicalBPELRootEditPart;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.ReorderInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.CollapsableEditPart;
import org.eclipse.bpel.ui.editparts.CompositeActivityEditPart;
import org.eclipse.bpel.ui.editparts.ElseIfEditPart;
import org.eclipse.bpel.ui.editparts.IfEditPart;
import org.eclipse.bpel.ui.editparts.InvokeEditPart;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.editparts.StartNodeEditPart;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.ImplicitLinkHandlerConnectionRouter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.swt.graphics.Color;


public class BPELOrderedLayoutEditPolicy extends FlowLayoutEditPolicy {

	protected ArrayList<PolylineConnection> polyLineConnectionList = new ArrayList<PolylineConnection>();

	// colour of the connection lines
	protected Color arrowColor = BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_IMPLICIT_LINK);

	@Override
	protected Command createAddCommand(EditPart child, EditPart before) {
		return new InsertInContainerCommand((EObject)getHost().getModel(), (EObject)child.getModel(),
			(before == null)? null : (EObject)before.getModel());
	}

	@Override
	protected Command createMoveChildCommand(EditPart child, EditPart before) {
		return new ReorderInContainerCommand((EObject)getHost().getModel(), (EObject)child.getModel(),
				(before == null)? null : (EObject)before.getModel());
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {

		CompoundCommand command = null;
		try {
			EditPart before = getInsertionReference(request);
			EObject parent = (EObject) getHost().getModel();
			EObject child = (EObject) request.getNewObject();
			EObject beforeObject = (EObject)(before != null ? before.getModel() : null);

			command = new CompoundCommand();
			command.add(new InsertInContainerCommand(parent, child, beforeObject));
			command.add(new SetNameAndDirectEditCommand(child, getHost().getViewer()));

		} catch( Exception e ) {
			// nothing
		}

		return command;
	}

	@Override
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	/**
	 * Returns the part that we should insert before.
	 * If request is null insert at the end of the list.
	 */
	@Override
	protected EditPart getInsertionReference(Request request) {
		// TODO: what is this for?
		if (request instanceof DropRequest) {
			Point pt = ((DropRequest)request).getLocation();
			if (pt == null)	return null;
			return super.getInsertionReference(request);
		}
		return null;
	}

	public void refreshConnections() {
		// remove connections before redrawing
		clearConnections();

		if (hasChildren() && !isCollapsed()) {
			if (isHorizontal()) {
				this.polyLineConnectionList = createHorizontalConnections((BPELEditPart)getHost());
			} else {
				this.polyLineConnectionList = createVerticalConnections((BPELEditPart)getHost());
			}
		}
	}

	public void clearConnections() {
		for (int i = 0; i < this.polyLineConnectionList.size(); i++) {
			getLayer(LayerConstants.CONNECTION_LAYER).remove((this.polyLineConnectionList.get(i)));
		}
		this.polyLineConnectionList.clear();
	}

	// return implicit links for a Horizontal edit part (e.g. a Switch).
	protected ArrayList<PolylineConnection> createHorizontalConnections(BPELEditPart parent) {
		ArrayList<PolylineConnection> connections = new ArrayList<PolylineConnection>();
		List<BPELEditPart> children = getConnectionChildren(parent);
		BPELEditPart sourcePart, targetPart;
		ConnectionAnchor sourceAnchor, targetAnchor;

		sourcePart = parent;
		sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.TOP_INNER);

		if (children != null){
			for (int i = 0; i < children.size(); i++) {
				targetPart = children.get(i);
				targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.TOP);
				connections.add(createConnection(sourceAnchor,targetAnchor,this.arrowColor));
			}
		}
		return connections;
	}

	// return list of children to create vertical connections for.
	protected List<BPELEditPart> getConnectionChildren(BPELEditPart editPart) {
		return editPart.getChildren();
	}

	// return implicit links for a Vertical edit part (e.g. a Sequence).
	protected ArrayList<PolylineConnection> createVerticalConnections(BPELEditPart parent) {
		ArrayList<PolylineConnection> connections = new ArrayList<PolylineConnection>();
		List<BPELEditPart> children = getConnectionChildren(parent);
		BPELEditPart sourcePart = null, targetPart = null;
		ConnectionAnchor sourceAnchor = null, targetAnchor = null;

		// TODO: Connections misaligned when there are no children
		if (!children.isEmpty()) {
			for (int i = 0; i <= children.size(); i++) {
				if (i == 0) {
					if (hasTopParentLink()) {
						sourcePart = parent;
						sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.TOP_INNER);
					} else {
						sourceAnchor = null;
					}
				} else {
					sourcePart = children.get(i-1);
					sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.BOTTOM);
				}
				if (i == children.size()) {
					if (hasBottomParentLink()) {
						targetPart = parent;
						targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.BOTTOM_INNER);
					} else {
						targetAnchor = null;
					}
				} else {
					targetPart = children.get(i);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.TOP);
				}
				if (sourceAnchor != null && targetAnchor != null) {
					PolylineConnection connection = createConnection(sourceAnchor,targetAnchor,this.arrowColor);

					if(sourcePart instanceof StartNodeEditPart || sourcePart instanceof ScopeEditPart || sourcePart instanceof InvokeEditPart){
						boolean horizontal = ModelHelper.isHorizontalLayout(getHost().getModel());
						connection.setConnectionRouter(new ImplicitLinkHandlerConnectionRouter(horizontal));
					}
					connections.add(connection);
				}
			}
		}

		return connections;
	}

	protected boolean hasTopParentLink() {
		return !(getHost() instanceof ProcessEditPart);
	}

	protected boolean hasBottomParentLink() {
		if (getHost() instanceof ProcessEditPart)
			return false;
		if (getHost() instanceof ElseIfEditPart)
			return false;
		if (getHost() instanceof IfEditPart)
			return false;
		return true;
	}

	protected List getSourceParts(Request request) {
		List<Object> list = new ArrayList<Object>();
		if (request instanceof CreateRequest) {
			list.add(((CreateRequest) request).getNewObject());
		} else if (request instanceof GroupRequest) {
			List<EditPart> l = ((GroupRequest) request).getEditParts();
			for( EditPart editPart : l ) {
				list.add(editPart.getModel());
			}
		}
		return list;
	}

	protected LayoutManager getLayoutManager() {
		if (getHost() instanceof GraphicalEditPart) {
			IFigure figure = ((GraphicalEditPart)getHost()).getContentPane();
			if (figure != null) return figure.getLayoutManager();
		}
		return null;
	}

	protected boolean canShowFeedback() {
		LayoutManager layout = getLayoutManager();
		if (layout == null) return false;
		if (layout instanceof FlowLayout) return true;
		if (layout instanceof AlignedFlowLayout) return true;
		return false;
	}

	@Override
	protected void showLayoutTargetFeedback(Request request) {
		if (!canShowFeedback()) return;

		super.showLayoutTargetFeedback(request);
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		// this policy only works for the BPEL Editor itself, not the outline
		// TODO: we shouldn't even install this for the outline!! (oops)
		if (getHost().getRoot() instanceof GraphicalBPELRootEditPart) {
			return super.getTargetEditPart(request);
		}
		return null;
	}

	/**
	 * override to prevent any child policies from being installed
	 *
	 * TODO: re-think this.
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return null;
	}

	// https://issues.jboss.org/browse/JBIDE-8694
	// isHorizontal() has been deprecated in GEF 3.7
	// See also https://bugs.eclipse.org/bugs/show_bug.cgi?id=88884
	// @Override - eventually
	protected boolean isLayoutHorizontal() {
		return this.isHorizontal();
	}

	@Override
	protected boolean isHorizontal() {
		LayoutManager layout = getLayoutManager();
		if (layout instanceof FlowLayout) return ((FlowLayout)layout).isHorizontal();
		if (layout instanceof AlignedFlowLayout) return ((AlignedFlowLayout)layout).isHorizontal();
		return false;
	}

	protected boolean isCollapsed() {
		if (getHost() instanceof CollapsableEditPart) {
			return ((CollapsableEditPart)getHost()).isCollapsed();
		}
		return false;
	}

	protected PolylineConnection createConnection(ConnectionAnchor sourceAnchor, ConnectionAnchor targetAnchor, Color color) {
		PolylineConnection connection = new PolylineConnection();
		connection.setSourceAnchor(sourceAnchor);
		connection.setTargetAnchor(targetAnchor);
		connection.setForegroundColor(color);
		connection.setBackgroundColor(color);
		connection.setConnectionRouter(new ImplicitLinkHandlerConnectionRouter(ModelHelper.isHorizontalLayout(getHost().getModel())));
		PolygonDecoration arrow = new PolygonDecoration();
		arrow.setTemplate(PolygonDecoration.TRIANGLE_TIP);
		arrow.setScale(5,2.5);
		arrow.setBackgroundColor(this.arrowColor);
		connection.setTargetDecoration(arrow);
		getLayer(LayerConstants.CONNECTION_LAYER).add(connection);
		return connection;
	}

	@Override
	public void showTargetFeedback(Request request) {
        // don't bother if request can't be executed
        if (getHost() instanceof BPELEditPart) {
            if (!((BPELEditPart)getHost()).canExecuteRequest(request)) {
                return;
            }
        }
		super.showTargetFeedback(request);
	}

	/**
	 * Does the edit part have children? If so, implicit connection logic will be
	 * executed. The only edit parts which have children are CompositeActivityEditParts
	 * (Sequence, While, Flow, RepeatUntil, etc.) and ElseElseIfEditPart (Case, OnMessage, OnAlarm).
	 */
	protected boolean hasChildren() {
		EditPart host = getHost();
		if (host instanceof ElseIfEditPart || host instanceof CompositeActivityEditPart || host instanceof ProcessEditPart) {
			return true;
		}
		return false;
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		super.deactivate();
		clearConnections();
	}

	@Override
	public int getFeedbackIndexFor(Request request) {
		// TODO Auto-generated method stub
		return super.getFeedbackIndexFor(request);
	}
}