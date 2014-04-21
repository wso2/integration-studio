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

import org.eclipse.bpel.model.Else;
import org.eclipse.bpel.model.If;
import org.eclipse.bpel.ui.editparts.borders.PickBorder;
import org.eclipse.bpel.ui.editparts.policies.BPELOrderedLayoutEditPolicy;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;

public class IfEditPart extends PickEditPart {

	/**
	 * This is a specical EditPart that represents the If node in the top left
	 * corner of an If activity. It looks like an ElseIfEditPart but has no own
	 * model representation.
	 * 
	 * It displays the activity children of the If activty and layouts together
	 * with the other ElseIfEditParts (representing Else and ElseIf).
	 */
	private class IfNodeEditPart extends ElseIfEditPart{

		/**
		 * This EditPart does not have its own children but displays the
		 * activity children of its parent (the IfEditPart). Therefor we return
		 * the parent's children list without the non-activity elements.
		 */
		@Override
		public List getChildren() {
			List<EditPart> children = new ArrayList<EditPart>();
			for (Iterator i = getParent().getChildren().iterator(); i.hasNext();) {
				EditPart child = (EditPart) i.next();
				if (!(child instanceof ElseIfEditPart)) {
					children.add(child);
				}
			}
			return children;
		}
		
		@Override
		protected void handleModelChanged() {
			/*
			 * don't react on model changes - everything is handled by the
			 * hosting IfEditPart
			 */
			return;
		}

		@Override
		protected void refreshChildren() {
			/*
			 * refreshing children is done by the hosting IfEditPart
			 */
			return;
		}

		@Override
		protected void addChildVisual(EditPart childEditPart, int index) {
			super.addChildVisual(childEditPart, index);
		}
		
		@Override
		protected void removeChildVisual(EditPart childEditPart) {
			super.removeChildVisual(childEditPart);
		}
	}

	/**
	 * Modified layout policy for the IfEditPart
	 */
	private class IfOrderedLayoutEditPolicy extends BPELOrderedLayoutEditPolicy {

		/*
		 * This one is tricky - it works together with the overwritten
		 * getConnectionChildren() method below.
		 * 
		 * We create horizontal connections for the connection children of the
		 * IfEditPart - getConnectionChildren() returns all else and elseIf
		 * children AND the "fake" IfNodeEditPart.
		 * 
		 * We create vertical connections for the connection children of the
		 * IfNodeEditPart - getConnectionChildren() returns all activity
		 * (everything except else and elseIf) of the IfEditPart.
		 */
		@SuppressWarnings("unchecked")
		@Override
		public void refreshConnections() {
			// remove connections before redrawing
			clearConnections();

			if (!isCollapsed()) {
				polyLineConnectionList = createHorizontalConnections((BPELEditPart) getHost());
				polyLineConnectionList
						.addAll(createVerticalConnections(getIfNodeEditPart()));
			}
		}

		/*
		 * The IfNodeEditPart's layout policy is responsible for handling the
		 * target feedbacks.
		 */
		@Override
		protected void eraseLayoutTargetFeedback(Request request) {
			EditPolicy policy = ifEditPart
					.getEditPolicy(EditPolicy.LAYOUT_ROLE);
			policy.eraseTargetFeedback(request);
		}

		/**
		 * Returns list of children to create connections for.
		 */
		@SuppressWarnings("unchecked")
		@Override
		protected List getConnectionChildren(BPELEditPart editPart) {
			List<EditPart> children = getChildren();
			List<EditPart> newChildren = new ArrayList<EditPart>();

			if (editPart instanceof ElseIfEditPart) {
				// For the IfNodeEditPart we return all activity children of the
				// IfEditPart.
				for (EditPart child : children) {
					if (!(child instanceof ElseIfEditPart)) {
						newChildren.add(child);
					}
				}
			} else {
				// For the IfEditPart we return all non-activity children...
				for (EditPart child : children) {
					if (child instanceof ElseIfEditPart) {
						newChildren.add(child);
					}
				}
				// ... and additionaly add our "fake" IfNodeEditPart.
				newChildren.add(getIfNodeEditPart());
			}
			return newChildren;
		}

		/*
		 * The IfNodeEditPart's layout policy is responsible for handling the
		 * target feedbacks.
		 */
		@Override
		public int getFeedbackIndexFor(Request request) {
			EditPolicy policy = ifEditPart
					.getEditPolicy(EditPolicy.LAYOUT_ROLE);
			// TODO: Changed the type to BPELOrderedLayoutEditPolicy?
			return ((BPELOrderedLayoutEditPolicy) policy)
					.getFeedbackIndexFor(request);
			
		}

		/*
		 * The IfNodeEditPart's layout policy is responsible for handling the
		 * target feedbacks.
		 */
		@Override
		protected void showLayoutTargetFeedback(Request request) {
			EditPolicy policy = ifEditPart
					.getEditPolicy(EditPolicy.LAYOUT_ROLE);
			policy.showTargetFeedback(request);
		}
	}
	
	/**
	 * Extending the behaviour for horizontal layout
	 * @author ascharf
	 *
	 */
	private class IfOrderedHorizontalLayoutEditPolicy extends IfEditPart.IfOrderedLayoutEditPolicy{
		@Override
		public void refreshConnections() {
			// remove connections before redrawing
			clearConnections();

			if (!isCollapsed()) {
				polyLineConnectionList = createHorizontalConnections((BPELEditPart) getHost());
				polyLineConnectionList.addAll(createVerticalConnections(getIfNodeEditPart()));
			}
		}
		
		@Override
		protected ArrayList createVerticalConnections(BPELEditPart parent) {
			ArrayList connections = new ArrayList();
			List children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor = null, targetAnchor = null;
			
			// The real first child is the IfNodeEditPart, so set the first sourceAnchor 
			// to this
			Label nameLabel = ((IfNodeEditPart)parent).nameLabel;
			sourceAnchor = new CenteredConnectionAnchor(nameLabel, CenteredConnectionAnchor.RIGHT,0);
			
			for(int i=0; i < children.size(); i++){
				if(i==0){
					targetPart = (BPELEditPart)children.get(0);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
				}
				if(i < children.size()-1){
					sourcePart = (BPELEditPart)children.get(i);
					sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.RIGHT);
				
					targetPart = (BPELEditPart)children.get(i+1);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
				}
				if(sourceAnchor != null && targetAnchor != null)
					connections.add(createConnection(sourceAnchor,targetAnchor,arrowColor));
			}
			
			return connections;
		}
		
		@Override
		protected ArrayList createHorizontalConnections(BPELEditPart parent) {
			ArrayList connections = new ArrayList();
			List children = getConnectionChildren(parent);
			BPELEditPart sourcePart, targetPart;
			ConnectionAnchor sourceAnchor, targetAnchor;
			
			sourcePart = parent;
			sourceAnchor = sourcePart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
			
			if (children != null){
				for (int i = 0; i < children.size(); i++) {
					targetPart = (BPELEditPart)children.get(i);
					targetAnchor = targetPart.getConnectionAnchor(CenteredConnectionAnchor.LEFT);
					connections.add(createConnection(sourceAnchor,targetAnchor,arrowColor));
				}			
			}		
			return connections;
		}
	}

	private IfNodeEditPart ifEditPart;

	@Override
	public void activate() {
		super.activate();
		getIfNodeEditPart().activate();
	}

	@Override
	public void deactivate() {
		getIfNodeEditPart().deactivate();
		super.deactivate();
	}

	@Override
	public void refreshVisuals() {
		getIfNodeEditPart().refreshVisuals();
		super.refreshVisuals();
	}

	/**
	 * creates the "fake" IfNodeEditPart that is displayed in the top left
	 * corner of the IfEditPart.
	 * 
	 */
	private void createIfNode() {
		this.ifEditPart = new IfNodeEditPart();
		this.ifEditPart.setModel(getModel());
		this.ifEditPart.setParent(this);
		this.ifEditPart.createEditPolicies();

		// we need a special layout policy since this is only a "fake" node
		this.ifEditPart.installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new BPELOrderedLayoutEditPolicy());
	}

	/**
	 * Checks whether the IfNodeEditPart of the current IfEditPart is present
	 * and creates it if not.
	 * 
	 * @return the IfNodeEditPart of the current IfEditPart
	 */
	private IfNodeEditPart getIfNodeEditPart() {
		if (this.ifEditPart == null) {
			createIfNode();
		}
		return this.ifEditPart;
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof ElseIfEditPart) {
			// add the "nodes" to the IfEditPart
			Object childObject = childEditPart.getModel();
			if (childObject instanceof Else) {
				// Else object visuals always go on the end
				index = -1;
			}
			else if (childObject instanceof If) {
				// If object visuals always go at beginning
				index = 0;
			}
			else {
				// must be an ElseIf - add the visual at the same index as it appears in model
				If thisObject = (If)getModel();
				index = thisObject.getElseIf().indexOf(childObject) + 1;
			}
			super.addChildVisual(childEditPart, index);
		} else {
			// add everything else to the IfNodeEditPart
			getIfNodeEditPart().addChildVisual(childEditPart, index);
		}
	}

	@Override
	protected void configureExpandedFigure(IFigure figure) {
		super.configureExpandedFigure(figure);

		/*
		 * Add the if node as "fake" visual child. Doning this here ensures the
		 * if node is alway present when the IfEditPart is expanded.
		 */
		this.addChildVisual(getIfNodeEditPart(), 0);
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		if(ModelHelper.isHorizontalLayout(getModel()))
			installEditPolicy(EditPolicy.LAYOUT_ROLE,new IfOrderedHorizontalLayoutEditPolicy());
		else
			installEditPolicy(EditPolicy.LAYOUT_ROLE,new IfOrderedLayoutEditPolicy());
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof ElseIfEditPart) {
			// remove the "nodes" form the IfEditPart
			super.removeChildVisual(childEditPart);
		} else {
			// remove everything else from the IfNodeEditPart
			getIfNodeEditPart().removeChildVisual(childEditPart);
		}
	}

	@Override
	protected void unregisterVisuals() {
		getIfNodeEditPart().unregisterVisuals();
		super.unregisterVisuals();
	}

	/**
	 * Overridden to also switch the layout of our fake node
	 */
	@Override
	public void switchLayout(boolean horizontal) {
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		
		EditPolicy newPolicy = null;
		if(horizontal)
			newPolicy = new IfOrderedHorizontalLayoutEditPolicy();
		else
			newPolicy = new IfOrderedLayoutEditPolicy();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, newPolicy);
		
		((FlowLayout)contentFigure.getLayoutManager()).setHorizontal(!horizontal);
		((PickBorder)contentFigure.getBorder()).setHorizontal(horizontal);
		
		getIfNodeEditPart().switchLayout(horizontal);
	}
}
