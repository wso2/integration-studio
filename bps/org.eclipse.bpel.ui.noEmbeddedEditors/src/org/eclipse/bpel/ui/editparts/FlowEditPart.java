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
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.model.Links;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetConstraintCommand;
import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.bpel.ui.editparts.borders.FlowBorder;
import org.eclipse.bpel.ui.editparts.figures.GradientFigure;
import org.eclipse.bpel.ui.editparts.policies.FlowHighlightEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.FlowResizeEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.FlowXYLayoutEditPolicy;
import org.eclipse.bpel.ui.editparts.util.BPELDecorationLayout;
import org.eclipse.bpel.ui.editparts.util.GraphAnimation;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.FlowXYLayout;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.NonclippingXYLayout;
import org.eclipse.bpel.ui.util.RowColumnLayout;
import org.eclipse.bpel.ui.util.marker.BPELEditPartMarkerDecorator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.DirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CommandStackListener;

public class FlowEditPart extends CollapsableEditPart {

	private FlowBorder flowBorder;

	private EContentAdapter flowContentAdapter;

	private BatchedMultiObjectAdapter flowBatchedAdapter;

	protected boolean smoothLayout = false;

	protected FlowHighlightEditPolicy flowHighlightEditPolicy;

	@Override
	protected void addAllAdapters() {
		super.addAllAdapters();
		Links links = ((Flow) getActivity()).getLinks();
		if (links != null) {
			adapter.addToObject(links);
		}
	}

	// TODO: this looks strange.. what is it really doing??
	CommandStackListener stackListener = new CommandStackListener() {
		public void commandStackChanged(EventObject event) {
			if (!isSmoothLayout())
				return;

			setSmoothLayout(false);

			if (!GraphAnimation.captureLayout(getFigure()))
				return;

			while (GraphAnimation.step())
				getFigure().getUpdateManager().performUpdate();
			GraphAnimation.end();

		}
	};

	class FlowDecorationLayout extends BPELDecorationLayout {
		@Override
		protected Point calculateLocation(int locationHint, IFigure container,
				Dimension childDimension) {
			Rectangle area = container.getClientArea();
			switch (locationHint) {
				case PositionConstants.CENTER:
					// Center
					return new Point(area.x + area.width / 2
							- childDimension.width / 2, area.y + area.height
							/ 2 - childDimension.height / 2);
				case PositionConstants.TOP:
					// Top Center
					return new Point(area.x + area.width / 2
							- childDimension.width / 2, area.y
							+ FlowBorder.LINE_WIDTH);
				case PositionConstants.BOTTOM:
					// Bottom Center
					return new Point(area.x + area.width / 2
							- childDimension.width / 2, area.y + area.height
							- childDimension.height - FlowBorder.LINE_WIDTH);
				case PositionConstants.LEFT: {
					// Center Left
					int x = area.x + DrawerBorder.DRAWER_WIDTH;
					int y = area.y;
					if (isCollapsed()) {
						y += container.getBounds().height / 2;
					} else {
						y += area.height / 2 - childDimension.width / 2;
					}
					return new Point(x, y);
				}
				case PositionConstants.RIGHT: {
					// Center Right
					int x = area.x + area.width - DrawerBorder.DRAWER_WIDTH
							- childDimension.width;
					int y = area.y;
					if (isCollapsed()) {
						y += container.getBounds().height / 2;
					} else {
						y += area.height / 2 - childDimension.width / 2;
					}
					return new Point(x, y);
				}
				case PositionConstants.TOP | PositionConstants.LEFT: {
					// Top Left
					int x = area.x + DrawerBorder.DRAWER_WIDTH;
					int y = area.y;
					if (isCollapsed()) {
						y += image.getBounds().height / 2;
					}
					return new Point(x, y);
				}
				case PositionConstants.TOP | PositionConstants.RIGHT: {
					// Top Right
					int x = area.x + area.width - DrawerBorder.DRAWER_WIDTH
							- childDimension.width;
					int y = area.y;
					if (isCollapsed()) {
						y += image.getBounds().height / 2;
					}
					return new Point(x, y);
				}
				case PositionConstants.BOTTOM | PositionConstants.LEFT: {
					// Bottom Left
					int x = area.x + DrawerBorder.DRAWER_WIDTH;
					int y = area.y + area.height
							- (image.getBounds().height / 2);
					return new Point(x, y);
				}
				case PositionConstants.BOTTOM | PositionConstants.RIGHT: {
					// Bottom Right
					int x = area.x + area.width - DrawerBorder.DRAWER_WIDTH
							- childDimension.width;
					int y = area.y + area.height
							- (image.getBounds().height / 2);
					return new Point(x, y);
				}
				default:
					return new Point(area.x, area.y);
			}
		}
	}

	public FlowEditPart() {
		super();

		// in order to create a batched EContentAdapter we
		// basically delegate the notifications to a real
		// batched adapter
		flowContentAdapter = new EContentAdapter() {
			@Override
			public void notifyChanged(Notification n) {
				switch (n.getEventType()) {
					case Notification.ADD_MANY:
					case Notification.REMOVE_MANY:
					case Notification.ADD:
					case Notification.REMOVE:
					case Notification.SET:
					case Notification.UNSET:
					case Notification.MOVE:
						flowBatchedAdapter.notifyChanged(n);
				}
				super.notifyChanged(n);
			}
		};
		// do not add this adapter to model objects - it is called
		// from the flow content adapter
		flowBatchedAdapter = new BatchedMultiObjectAdapter() {
			protected boolean refreshLayout = false;

			@Override
			public void finish() {
				if (refreshLayout) {
					if (getAutoLayout())
						doAutoLayout(false);
				}
				refreshLayout = false;
			}

			@Override
			public void notify(Notification n) {
				if (isActive()) {
					refreshLayout = true;
				}
			}
		};
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		getContentPane().add(child,
				getFigure().getLayoutManager().getConstraint(child), index);
		// Bugzilla 319215
		// addChildVisual() is also called by reorderChild() to rearrange the order of children.
		// This causes auto layout to reference a child object with a model that has no parent.
		// The right place to auto arrange Flow children if no *.bpelex exists yet, is in
		// BPELEditor.arrangeEditParts() after the model is loaded
//		if (getShowFreeformFlow() && getAutoLayout())
//			doAutoLayout(false);
	}

	protected void setFlowEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FlowXYLayoutEditPolicy());
		flowHighlightEditPolicy = new FlowHighlightEditPolicy(!collapsed) {
			@Override
			protected int getDrawerInset() {
				return DrawerBorder.DRAWER_WIDTH;
			}

			@Override
			protected int getNorthInset() {
				if (isCollapsed()) {
					return 2;
				} else {
					return 2;
				}
			}

			@Override
			protected int getSouthInset() {
				return 0;
			}

			@Override
			protected int getEastInset() {
				return DrawerBorder.DRAWER_WIDTH;
			}

			@Override
			protected int getWestInset() {
				return DrawerBorder.DRAWER_WIDTH + 2;
			}
		};
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
				flowHighlightEditPolicy);
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		// installEditPolicy(EditPolicy.NODE_ROLE, null);
		setFlowEditPolicies();
		installEditPolicy("childFlowResize", new FlowResizeEditPolicy()); //$NON-NLS-1$
	}

	@Override
	public Label getLabelFigure() {
		if (isCollapsed())
			return super.getLabelFigure();
		return null;
	}

	@Override
	public void setCollapsed(boolean collapsed) {
		if (collapsed != this.collapsed) {
			if (flowHighlightEditPolicy != null) {
				flowHighlightEditPolicy.setResizable(!collapsed);
			}
		}
		super.setCollapsed(collapsed);
	}

	@Override
	protected IFigure createFigure() {
		createEditPolicies(); // reset the edit policies based on flow display
								// mode
		initializeLabels();

		editPartMarkerDecorator = new BPELEditPartMarkerDecorator(
				(EObject) getModel(), new FlowDecorationLayout());
		editPartMarkerDecorator
				.addMarkerMotionListener(getMarkerMotionListener());

		IFigure figure = new GradientFigure(getModel());
		if (collapsed) {
			addCollapsedContents(figure);
		} else {
			configureExpandedFigure(figure);
		}
		this.contentFigure = figure;

		return editPartMarkerDecorator.createFigure(figure);
	}

	@Override
	protected void configureExpandedFigure(IFigure figure) {
		LayoutManager layout;

		if (!getShowFreeformFlow()) {
			layout = new RowColumnLayout();
		} else {
			FlowXYLayout xylayout = new FlowXYLayout(this);
			Dimension d = ModelHelper.getSize(getFlow());
			if (d.height != 0 && d.width != 0)
				xylayout.setSize(d);
			layout = xylayout;
		}

		figure.setLayoutManager(layout);

		if (!(figure.getBorder() instanceof FlowBorder)) {
			flowBorder = new FlowBorder(figure);
			figure.setBorder(this.flowBorder);
			this.flowBorder.setEditPart(this);
		}
		figure.addMouseMotionListener(getMouseMotionListener());
		this.flowBorder.setEditPart(this);
	}

	protected Flow getFlow() {
		return (Flow) getModel();
	}

	@Override
	protected boolean isCollapsable() {
		return true;
	}

	@Override
	public void deactivate() {
		if (!isActive())
			return;
		super.deactivate();
		((Notifier) getModel()).eAdapters().remove(flowContentAdapter);

		getViewer().getEditDomain().getCommandStack()
				.removeCommandStackListener(stackListener);
	}

	private boolean getShowFreeformFlow() {
		return BPELUIPlugin.INSTANCE.getPreferenceStore().getBoolean(
				IBPELUIConstants.PREF_SHOW_FREEFORM_FLOW);
	}

	private boolean getAutoLayout() {
		return BPELUIPlugin.INSTANCE.getPreferenceStore().getBoolean(
				IBPELUIConstants.PREF_AUTO_FLOW_LAYOUT);
	}

	@Override
	public IFigure getContentPane() {
		return contentFigure;
	}

	public boolean isShowFreeform() {
		return (getContentPane().getLayoutManager() instanceof NonclippingXYLayout);
	}

	@Override
	public void regenerateVisuals() {
		if (collapsed) {
			addCollapsedContents(this.contentFigure);
		} else {
			configureExpandedFigure(this.contentFigure);
		}
		setFlowEditPolicies();
		// This is necessary because..we may have replaced the border!
		refreshDrawerImages();

		if (getShowFreeformFlow() && getAutoLayout())
			doAutoLayout(false);
	}

	public DirectedGraph computeAutoLayoutGraph(Map partsToNodes) {
		DirectedGraph graph = new DirectedGraph();
		graph.setDefaultPadding(new Insets(8, 8, 10, 8));
		Node top = new Node(null);
		graph.nodes.add(top);
		top.width = top.height = 0;
		top.setPadding(new Insets(-8, 0, 0, 0));

		List nodesWithoutPreds = new ArrayList();

		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof BPELEditPart) {
				BPELEditPart editPart = (BPELEditPart) object;
				Node n = new Node(editPart);
				n.width = editPart.getFigure().getPreferredSize().width;
				n.height = editPart.getFigure().getPreferredSize().height;
				n.sortValue = getFigure().getBounds().x;
				graph.nodes.add(n);
				partsToNodes.put(editPart, n);
				nodesWithoutPreds.add(n);
				// TODO: pre-sort node list based on x-coords of existing
				// constraints?
			} else {
				// System.out.println(object);
			}
		}
		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof BPELEditPart) {
				Node target = (Node) partsToNodes.get(object);
				if (target == null)
					continue;

				for (Iterator it2 = ((BPELEditPart) object)
						.getTargetConnections().iterator(); it2.hasNext();) {
					Object object2 = it2.next();
					if (object2 instanceof LinkEditPart) {
						LinkEditPart link = (LinkEditPart) object2;
						Node source = (Node) partsToNodes.get(link.getSource());
						if (source != null) {
							graph.edges.add(new Edge(source, target));
							nodesWithoutPreds.remove(target);
						}
					}
				}
			}
		}
		for (Iterator it = nodesWithoutPreds.iterator(); it.hasNext();) {
			graph.edges.add(new Edge(top, (Node) it.next()));
		}

		new DirectedGraphLayout().visit(graph);

		return graph;
	}

	public void doImmediateAutoLayout() {
		Map<BPELEditPart, Node> partsToNodes = new HashMap<BPELEditPart, Node>();
		if (BPELUIPlugin.INSTANCE.getPreferenceStore().getBoolean(
				IBPELUIConstants.PREF_USE_ANIMATION)) {
			setSmoothLayout(true);
		}
		computeAutoLayoutGraph(partsToNodes);

		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof BPELEditPart) {
				BPELEditPart editPart = (BPELEditPart) object;

				Node n = partsToNodes.get(editPart);
				Point loc = new Point(n.x, n.y);
				// TODO: I think this is wrong
				// getFigure().translateToRelative(loc);

				ModelHelper.setLocation((Activity) editPart.getModel(), loc);
			}
		}
	}

	public void doAutoLayout() {
		doAutoLayout(true);
	}

	public void doAutoLayout(boolean withCommand) {
		Map<BPELEditPart, Node> partsToNodes = new HashMap<BPELEditPart, Node>();
		this.getFigure().invalidateTree();
		if (BPELUIPlugin.INSTANCE.getPreferenceStore().getBoolean(
				IBPELUIConstants.PREF_USE_ANIMATION)) {
			setSmoothLayout(true);
		}
		computeAutoLayoutGraph(partsToNodes);

		CompoundCommand cmd = new CompoundCommand();
		cmd.setLabel(IBPELUIConstants.CMD_AUTO_ARRANGE);

		BPELEditor bpelEditor = ModelHelper.getBPELEditor(getModel());

		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof BPELEditPart) {
				BPELEditPart editPart = (BPELEditPart) object;

				Node n = partsToNodes.get(editPart);
				Point loc = new Point(n.x, n.y);
				// TODO: I think this is wrong
				// getFigure().translateToRelative(loc);

				SetConstraintCommand cmd2 = new SetConstraintCommand(
						(Activity) editPart.getModel(), loc, null);
				if (withCommand) {
					cmd.add(cmd2);
				} else {
					cmd2.execute();
				}
			}
		}
		if (withCommand) {
			regenerateVisuals();
			bpelEditor.getCommandStack().execute(cmd);
		}
	}

	@Override
	protected void handleModelChanged() {
		// The size of the flow may have changed. Rebuild the edit part.

		// move this line to top of function, must call refreshChildren() to
		// make sure the gef is in sync with model before we regenerate visuals
		// and do an autolayout
		refreshChildren();

		super.handleModelChanged();
		regenerateVisuals();
	}

	@Override
	public void activate() {
		super.activate();
		((Notifier) getModel()).eAdapters().add(flowContentAdapter);

		getViewer().getEditDomain().getCommandStack().addCommandStackListener(
				stackListener);
	}

	public boolean isSmoothLayout() {
		return smoothLayout;
	}

	public void setSmoothLayout(boolean smoothLayout) {
		this.smoothLayout = smoothLayout;
	}

	/* a couple of utility classes for use in the cycle detection code */

	/** represents an edge connection for an editpart * */

	private class EditPartEdge {
		private EditPartNode source, dest;

		public EditPartEdge(EditPartNode source, EditPartNode dest) {
			this.source = source;
			this.dest = dest;
		}

		public EditPartNode getDest() {
			return dest;
		}

		public EditPartNode getSource() {
			return source;
		}
	}

	/**
	 * represents an node in a graph The main feature is a visit function which
	 * marks the visited node and returns false if cycle detected
	 */

	private class EditPartNode {
		public static final int VISITING = 1, VISITED = 2, NOTVISITED = 0;

		private EditPart part;

		private List edges = new ArrayList();

		public int visited = NOTVISITED;

		public EditPartNode(EditPart part) {
			this.part = part;
		}

		public EditPart getPart() {
			return part;
		}

		public int getVisited() {
			return visited;
		}

		public void addEdge(EditPartEdge edge) {
			edges.add(edge);
		}

		/** returns false if cycle detected * */
		public boolean visit() {
			EditPartEdge e;
			if (visited == VISITING) {
				return false;
			}
			if (visited == VISITED)
				return true;
			visited = VISITING;
			for (Iterator it = edges.iterator(); it.hasNext();) {
				e = (EditPartEdge) it.next();
				// if (e.getSource() == this)
				if (e.getDest().visit() == false)
					return false;
			}
			visited = VISITED;
			return true;
		}
	}

	/**
	 * checks if a new connection joining sourceNode and potentialDest will
	 * result in a cycle *
	 */

	public boolean detectImpendingCycle(EditPart sourceNode,
			EditPart potentialDest) {
		List<EditPartNode> nodes = new ArrayList<EditPartNode>();

		Map<BPELEditPart, EditPartNode> partsToNodes = new HashMap<BPELEditPart, EditPartNode>();

		// strategy: we'll build up a separate parallel graph that we can
		// traverse to detect cycles.
		// We are essentially duplicating the Flow's
		// graph structure, but this is easiest since we don't have a way of
		// "simulating a link between
		// for the proposed link, and we don't want to pollute the editparts
		// extraneous methods and fields
		// just for cycle detection logic, this will have to do for now.

		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof BPELEditPart) {
				BPELEditPart editPart = (BPELEditPart) object;
				EditPartNode n = new EditPartNode(editPart);
				nodes.add(n);
				partsToNodes.put(editPart, n);
			}
		}

		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof BPELEditPart) {
				EditPartNode source = partsToNodes.get(object);
				if (source == null)
					continue;

				for (Iterator it2 = ((BPELEditPart) object)
						.getSourceConnections().iterator(); it2.hasNext();) {
					Object targetObject = it2.next();
					if (targetObject instanceof LinkEditPart) {
						LinkEditPart linkEditPart = (LinkEditPart) targetObject;
						EditPartNode target = partsToNodes
								.get(linkEditPart.getTarget());
						if (target != null) {
							source.addEdge(new EditPartEdge(source, target));
						}
					}
				}
			}
		}

		// add the proposed edge
		EditPartNode source = partsToNodes.get(sourceNode);
		if (source != null) {
			EditPartNode target = partsToNodes
					.get(potentialDest);
			if (target != null) {
				source.addEdge(new EditPartEdge(source, target));
			}
		}

		/* visit each node checking if a cycle will result */
		for (Iterator<EditPartNode> it = nodes.iterator(); it.hasNext();) {
			EditPartNode v = it.next();
			if (v.getVisited() == EditPartNode.NOTVISITED)
				if (v.visit() == false)
					return false;
		}

		return true;
	}

	public void switchLayout(boolean horizontal) {
		// Actually does nothing
	}
}