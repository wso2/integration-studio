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
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.BPELEditDomain;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.adapters.IEventHandlerHolder;
import org.eclipse.bpel.ui.adapters.IFaultHandlerHolder;
import org.eclipse.bpel.ui.adapters.delegates.ActivityContainer;
import org.eclipse.bpel.ui.editparts.policies.BPELContainerEditPolicy;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.figures.ILayoutAware;
import org.eclipse.bpel.ui.figures.ProcessHandlerLinker;
import org.eclipse.bpel.ui.uiextensionmodel.impl.StartNodeImpl;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ImplicitLinkHandlerConnectionRouter;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.MarqueeDragTracker;
import org.eclipse.jface.viewers.StructuredSelection;


public class ProcessEditPart extends BPELEditPart implements ILayoutAware{

	private IFigure layeredPane;
	private IFigure activityAndHandlerHolder;
	private IFigure activityHolder;
	private IFigure handlerHolder;
	private Layer activityLayer;
	
	// Whether to show each of the actual handlers.
	// TODO: Initialize these from the preferences store
	private boolean showFH = false, showEH = false;
	
	// The Handler which handles the drawing of links to the handlers.
	private ProcessHandlerLinker handlerLinker;
	
	private class ProcessOrderedHorizontalLayoutEditPolicy extends ProcessEditPart.ProcessOrderedLayoutEditPolicy{
		@Override
		protected ArrayList createHorizontalConnections(BPELEditPart parent) {
			ArrayList connections = new ArrayList();
			List children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor, targetAnchor;
			
			for(int i=0; i < children.size(); i++){
				if(i != children.size()-1){
					sourcePart = (BPELEditPart)children.get(i);
					targetPart = (BPELEditPart)children.get(i+1);
					
					sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
					
					PolylineConnection connection = createConnection(sourceAnchor,targetAnchor,arrowColor);
					
					
					if(sourcePart instanceof StartNodeEditPart){
						boolean horizontal = ModelHelper.isHorizontalLayout(getHost().getModel());
						connection.setConnectionRouter(new ImplicitLinkHandlerConnectionRouter(horizontal));
					}
					
					connections.add(connection);
				}
			}
			
			return connections;
		}
	}

	public class ProcessOrderedLayoutEditPolicy extends BPELOrderedLayoutEditPolicy {
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

		@Override
		protected Command getCreateCommand(CreateRequest request) {
			EditPart insertBefore = getInsertionReference(request);
			if (insertBefore == null) return null;
			if (insertBefore instanceof StartNodeEditPart) return null;
			return super.getCreateCommand(request);
		}
	}
		
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();

		// Override the component policy, as you can't delete the process
		installEditPolicy(EditPolicy.COMPONENT_ROLE, null);

		installEditPolicy(EditPolicy.CONTAINER_ROLE, new BPELContainerEditPolicy());

		// The process must lay out its child activity
		if(ModelHelper.isHorizontalLayout(getModel()))
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ProcessOrderedHorizontalLayoutEditPolicy());
		else
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ProcessOrderedLayoutEditPolicy());
	}

	
	@Override
	protected IFigure createFigure() {
		LayeredPane result = new LayeredPane();
		this.layeredPane = result;
		
		Layer layer2 = new Layer();
		this.activityLayer = layer2;
		activityLayer.setLayoutManager(new ToolbarLayout());
		activityLayer.setOpaque(true);
		result.add(layer2, "activityLayer", 0); //$NON-NLS-1$
		
		this.activityAndHandlerHolder = new Figure();
		AlignedFlowLayout layout = new AlignedFlowLayout();
		layout.setHorizontalAlignment(AlignedFlowLayout.ALIGN_CENTER);
		layout.setVerticalAlignment(AlignedFlowLayout.ALIGN_BEGIN);
		layout.setSecondaryAlignment(AlignedFlowLayout.ALIGN_CENTER);
		this.activityAndHandlerHolder.setLayoutManager(layout);
		
		this.handlerHolder = new Figure();
		layout = new AlignedFlowLayout(true);
		layout.setHorizontalAlignment(AlignedFlowLayout.ALIGN_BEGIN);;
		this.handlerHolder.setLayoutManager(layout);
		
		this.activityHolder = new Figure();
		layout = new AlignedFlowLayout();
		layout.setHorizontalAlignment(AlignedFlowLayout.ALIGN_CENTER);
		layout.setVerticalAlignment(AlignedFlowLayout.ALIGN_BEGIN);
		layout.setSecondaryAlignment(AlignedFlowLayout.ALIGN_CENTER);
		layout.setVerticalSpacing(SPACING);
		activityHolder.setLayoutManager(layout);
		activityHolder.setOpaque(true);
		activityAndHandlerHolder.add(handlerHolder);
		activityAndHandlerHolder.add(activityHolder);
		layer2.add(activityAndHandlerHolder);
		
		// It's not a reals switch - just apply all layout setting here
		// to avoid duplicate code
		switchLayout(ModelHelper.isHorizontalLayout(getModel()));
		
		return layeredPane;
	}

	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		getContentPane(child).setConstraint(childFigure, constraint);
	}
	
	protected IFigure getContentPane(EditPart childEditPart) {
		if (childEditPart instanceof StartNodeEditPart) {
			return handlerHolder;
		} else if (childEditPart instanceof FaultHandlerEditPart) {
			return handlerHolder;
		}
		return activityHolder;
	}
	
	@Override
	public IFigure getContentPane() {
        return activityHolder;
    }

	/**
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	protected List getModelChildren() {
		Process process = getProcess();
		BPELEditDomain domain = (BPELEditDomain)getViewer().getEditDomain();
		List list = new ArrayList();
		
		/* NOTE: The layoutEditPolicy relies on this order to identify the
		 * area the user is mousing over. Do not change the order in which these
		 * children are added unless you change the layoutEditPolicy too!!!!!!!!!!!!!!!!!!!!
		 */

		// TODO: this is way too magic.  can we get rid of this?
		
		list.add(domain.getStartNode());
		IContainer container = new ActivityContainer(BPELPackage.eINSTANCE.getProcess_Activity());
		list.addAll(container.getChildren(process));
		list.add(domain.getEndNode());
		
		/* END OF NOTE */
		
		if (showFH) {
			FaultHandler faultHandler = process.getFaultHandlers();
			if (faultHandler != null) list.add(faultHandler);
		}
		if (showEH) {
			EventHandler eventHandler = process.getEventHandlers();
			if (eventHandler != null) list.add(eventHandler);
		}
    	
		return list;
	}
	
	public boolean isShowFH() {
		return showFH;
	}

	public boolean isShowEH() {
		return showEH;
	}
	
	public FaultHandler getFaultHandler() {
		IFaultHandlerHolder holder = BPELUtil.adapt(getModel(), IFaultHandlerHolder.class);
		if (holder != null) {
			return holder.getFaultHandler(getModel());
		}
		return null;
	}
	
	public EventHandler getEventHandler() {
		IEventHandlerHolder holder = BPELUtil.adapt(getModel(), IEventHandlerHolder.class);
		if (holder != null) {
			return holder.getEventHandler(getModel());
		}
		return null;
	}

	protected Process getProcess() {
		return (Process)getModel();
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		IFigure content = getContentPane(childEditPart);
		if (content != null) {
			if (content == activityHolder) {
				// The index includes the start node, which isn't in this
				// content pane. Subtract one.
				content.add(child, index - 1);
			} else if(content == handlerHolder){
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
		if(!(child.getModel() instanceof StartNodeImpl)){
			int i = container.getChildren().size();
			if (i <= 1 || child.getModel() instanceof FaultHandler) {
				if (i > 1)
					result = 2;
				else
					result = 1;
			}else
				result = 1;
		}
		
		return result;
	}
	
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
		IFigure content = getContentPane(childEditPart);
		if (content != null)
			content.remove(child);
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
	 * Override to handle direct edit requests
	 */
	@Override
	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			// let's not activate the rename or direct edit functionality because it's annoying when
			// the user clicks on the canvas and the rename box comes up.
			//	performDirectEdit();
			return;
		}
		super.performRequest(request);
	}
	
	public void setShowFaultHandler(boolean showFaultHandler) {
		this.showFH = showFaultHandler;
		// Call refresh so that both refreshVisuals and refreshChildren will be called.
		refresh();
	}

	public void setShowEventHandler(boolean showEventHandler) {
		this.showEH = showEventHandler;
		// Call refresh so that both refreshVisuals and refreshChildren will be called.
		refresh();
	}
	
	@Override
	public DragTracker getDragTracker(Request request) {
		return new MarqueeDragTracker() {
			@Override
			protected void handleFinished() {
				if (getViewer().getSelection().isEmpty()) {
					// if nothing has been select we should select the process
					getViewer().setSelection(new StructuredSelection(ProcessEditPart.this));
				}
			}
		};
	}


	public void switchLayout(boolean horizontal) {
		AlignedFlowLayout handlerLayout = (AlignedFlowLayout)handlerHolder.getLayoutManager();
		handlerLayout.setHorizontal(!horizontal);
		
		// Adjust the layout of the activityAndHandlerHolder
		((AlignedFlowLayout)activityAndHandlerHolder.getLayoutManager()).setHorizontal(horizontal);
		
		// Adjust the layout of the activityHolder
		((AlignedFlowLayout)activityHolder.getLayoutManager()).setHorizontal(horizontal);
		
		// Remove the LayoutPolicy which is responsible for creating the implicit links
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		
		if(horizontal){
			// Handler Holder layout
			handlerLayout.setSecondaryAlignment(AlignedFlowLayout.ALIGN_BEGIN);
			
			// If we are in horizontal mode we add a top margin 
			activityAndHandlerHolder.setBorder( new MarginBorder(20,20,0,20));
			
			this.handlerHolder.setBorder(new MarginBorder(0,20,0,0));

			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ProcessOrderedHorizontalLayoutEditPolicy());
		}else{
			// Handler Holder layout
			handlerLayout.setSecondaryAlignment(AlignedFlowLayout.ALIGN_BEGIN);
			
			// If we are in horizontal mode we remove the border 
			activityAndHandlerHolder.setBorder(null);
			
			this.handlerHolder.setBorder(new AbstractBorder() {
				public Insets getInsets(IFigure arg0) {
					return new Insets(20, 0, 10, 0);
				}
				public void paint(IFigure arg0, Graphics arg1, Insets arg2) {
				}
			});
			
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new ProcessOrderedLayoutEditPolicy());
		}
	}
	
	@Override
	protected void clearConnections() {
		super.clearConnections();
		getHandlerLinker().clearHandlerConnections();
	}
	
	/**
	 * Overridden to refresh the handlerLinks as needed.
	 */
	@Override
	public void refresh() {
		super.refresh();
		getHandlerLinker().refreshHandlerLinks();
	}
	
	private ProcessHandlerLinker getHandlerLinker() {
		if(handlerLinker == null)
			handlerLinker = new ProcessHandlerLinker(this);
		return handlerLinker;
	}
	
	@Override
	protected void handleModelChanged() {
		super.handleModelChanged();
		
		this.showFH = getFaultHandler() != null ? true : false;
		this.showEH = getEventHandler() != null ? true : false;
		
		refresh();
	}
}
