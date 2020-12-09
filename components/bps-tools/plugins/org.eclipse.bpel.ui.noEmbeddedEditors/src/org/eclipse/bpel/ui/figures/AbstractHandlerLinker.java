/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.figures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.FaultHandlerEditPart;
import org.eclipse.bpel.ui.editparts.borders.RoundRectangleBorderWithDecoration;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;

public abstract class AbstractHandlerLinker {

	/**
	 * List of all connections handled by this handlerLinker. This
	 * list has to be maintained during the creation of the handlerLinks.
	 */
	private List<PolylineConnection> handlerConnectionsList = new ArrayList<PolylineConnection>();

	/**
	 * The editPart to which this handler belongs to
	 */
	private BPELEditPart editPart;

	/**
	 * Reference to the GEF connectionLayer
	 */
	private IFigure connLayer;

	public AbstractHandlerLinker(BPELEditPart editPart) {
		this.editPart = editPart;
		connLayer = ((LayerManager) editPart.getViewer().getEditPartRegistry()
				.get(LayerManager.ID))
				.getLayer(LayerConstants.CONNECTION_LAYER);
	}

	/**
	 * Refreshes all handlerLinks
	 */
	public void refreshHandlerLinks() {
		clearHandlerConnections();

		ConnectionAnchor source = null;
		ConnectionAnchor target = null;

		BPELEditor editor = ModelHelper.getBPELEditor(editPart.getModel());

		if (editor == null)
			return;

		Map reg = editor.getGraphicalViewer().getEditPartRegistry();

		FaultHandlerEditPart fhEditPart = (FaultHandlerEditPart) reg
				.get(getFaultHandler());
		FaultHandlerEditPart ehEditPart = (FaultHandlerEditPart) reg
				.get(getEventHandler());
		FaultHandlerEditPart chEditPart = (FaultHandlerEditPart) reg
				.get(getCompensationHandler());
		FaultHandlerEditPart thEditPart = (FaultHandlerEditPart) reg
				.get(getTerminationHandler());

		if (isShowFH()) {
			if (fhEditPart == null)
				// not yet initialized
				return;

			source = new CenteredConnectionAnchor(getFHFigure(),getFHSourceAnchorLoc(),0);

			target = new CenteredConnectionAnchor(getFHHandlerFigure(fhEditPart),getFHTargetAnchorLoc(),0);

			PolylineConnection conn = new PolylineConnection();
			conn.setSourceAnchor(source);
			conn.setTargetAnchor(target);
			conn.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry()
					.get(IBPELUIConstants.COLOR_HANDLER_LINK_FH));
			// conn.setConnectionRouter(new HandlerConnectionRouter());
			conn
					.setConnectionRouter(new ManhattanConnectionRouterEx(
							getFHRoutingStartConstraint(),
							getFHRoutingEndConstraint()));
			handlerConnectionsList.add(conn);
			connLayer.add(conn);

		}
		if (isShowEH()) {
			if (ehEditPart == null)
				// not yet initialized
				return;

			source = new CenteredConnectionAnchor(getEHFigure(),getEHSourceAnchorLoc(),0);

			target = new CenteredConnectionAnchor(getFHHandlerFigure(ehEditPart),getEHTargetAnchorLoc(),0);

			PolylineConnection conn = new PolylineConnection();
			conn.setSourceAnchor(source);
			conn.setTargetAnchor(target);
			conn.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry()
					.get(IBPELUIConstants.COLOR_HANDLER_LINK_EH));
			// conn.setConnectionRouter(new HandlerConnectionRouter());
			conn
					.setConnectionRouter(new ManhattanConnectionRouterEx(
							getEHRoutingStartConstraint(),
							getEHRoutingEndConstraint()));
			handlerConnectionsList.add(conn);
			connLayer.add(conn);
		}
		if (isShowCH()) {
			if (chEditPart == null)
				// not yet initialized
				return;

			source = new CenteredConnectionAnchor(getCHFigure(),getCHSourceAnchorLoc(),0);
			
			target = new CenteredConnectionAnchor(getFHHandlerFigure(chEditPart),getCHTargetAnchorLoc(),0);

			PolylineConnection conn = new PolylineConnection();
			conn.setSourceAnchor(source);
			conn.setTargetAnchor(target);
			conn.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry()
					.get(IBPELUIConstants.COLOR_HANDLER_LINK_CH));
			// conn.setConnectionRouter(new HandlerConnectionRouter());
			conn
					.setConnectionRouter(new ManhattanConnectionRouterEx(
							getCHRoutingStartConstraint(),
							getCHRoutingEndConstraint()));
			handlerConnectionsList.add(conn);
			connLayer.add(conn);
		}
		if (isShowTH()) {
			if (thEditPart == null)
				// not yet initialized
				return;

			source = new CenteredConnectionAnchor(getTHFigure(),getTHSourceAnchorLoc(),0);
			
			target = new CenteredConnectionAnchor(getFHHandlerFigure(thEditPart),getTHTargetAnchorLoc(),0);

			PolylineConnection conn = new PolylineConnection();
			conn.setSourceAnchor(source);
			conn.setTargetAnchor(target);
			conn.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry()
					.get(IBPELUIConstants.COLOR_HANDLER_LINK_TH));
			// conn.setConnectionRouter(new HandlerConnectionRouter());
			conn
					.setConnectionRouter(new ManhattanConnectionRouterEx(
							getTHRoutingStartConstraint(),
							getTHRoutingEndConstraint()));
			handlerConnectionsList.add(conn);
			connLayer.add(conn);
		}
	}

	/**
	 * Removes all connections which are handled by this handlerLinker
	 * from the connectionLayer
	 */
	public void clearHandlerConnections() {
		if (handlerConnectionsList.size() > 0) {
			for (PolylineConnection p : handlerConnectionsList) {
				connLayer.remove(p);
			}
			handlerConnectionsList.clear();
		}
	}

	/**
	 * Gets the faultHandler model
	 * @return
	 */
	protected abstract FaultHandler getFaultHandler();

	/**
	 * Gets the eventHandler model
	 * @return
	 */
	protected abstract EventHandler getEventHandler();

	/**
	 * Gets the compensationHandler model
	 * @return
	 */
	protected abstract CompensationHandler getCompensationHandler();

	/**
	 * Gets the terminationHandler model
	 * @return
	 */
	protected abstract TerminationHandler getTerminationHandler();

	/**
	 * Returns if the compensationHandler is shown
	 * @return
	 */
	protected abstract boolean isShowCH();

	/**
	 * Returns if the eventHandler is shown
	 * @return
	 */
	protected abstract boolean isShowEH();

	/**
	 * Returns if the faultHandler is shown
	 * @return
	 */
	protected abstract boolean isShowFH();

	/**
	 * Returns if the terminationHandler is shown
	 * @return
	 */
	protected abstract boolean isShowTH();

	/**
	 * Gets the position of the connectionAnchor of an faultHandler.
	 * By default this is HandlerConnectionAnchor.LEFT in case of a horizontal 
	 * layout and HandlerConnectionAnchor.TOP if layout orientation is vertical.
	 * @return
	 */
	protected int getFHTargetAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.LEFT
				: CenteredConnectionAnchor.TOP;
	}

	/**
	 * Gets the position of the connectionAnchor of an eventHandler.
	 * By default this is HandlerConnectionAnchor.LEFT in case of a horizontal 
	 * layout and HandlerConnectionAnchor.TOP if layout orientation is vertical.
	 * @return
	 */
	protected int getEHTargetAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.LEFT
				: CenteredConnectionAnchor.TOP;
	}

	/**
	 * Gets the position of the connectionAnchor of a compensationHandler.
	 * By default this is HandlerConnectionAnchor.LEFT in case of a horizontal 
	 * layout and HandlerConnectionAnchor.TOP if layout orientation is vertical.
	 * @return
	 */
	protected int getCHTargetAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.LEFT
				: CenteredConnectionAnchor.TOP;
	}

	/**
	 * Gets the position of the connectionAnchor of a terminationHandler.
	 * By default this is HandlerConnectionAnchor.LEFT in case of a horizontal 
	 * layout and HandlerConnectionAnchor.TOP if layout orientation is vertical.
	 * @return
	 */
	protected int getTHTargetAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.LEFT
				: CenteredConnectionAnchor.TOP;
	}

	/**
	 * Gets the direction in which the first segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getFHRoutingStartConstraint(){
		switch (getFHSourceAnchorLoc()) {
		case CenteredConnectionAnchor.BOTTOM:
			return ManhattanConnectionRouterEx.DOWN;
		default:
			return ManhattanConnectionRouterEx.RIGHT;
		}
	}

	/**
	 * Gets the direction in which the last segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getFHRoutingEndConstraint(){
		switch (getFHTargetAnchorLoc()) {
		case CenteredConnectionAnchor.TOP:
			return ManhattanConnectionRouterEx.UP;
		default:
			return ManhattanConnectionRouterEx.LEFT;
		}
	}

	/**
	 * Gets the direction in which the first segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getEHRoutingStartConstraint(){
		switch (getEHSourceAnchorLoc()) {
		case CenteredConnectionAnchor.BOTTOM:
			return ManhattanConnectionRouterEx.DOWN;
		default:
			return ManhattanConnectionRouterEx.RIGHT;
		}
	}

	/**
	 * Gets the direction in which the last segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getEHRoutingEndConstraint(){
		switch (getEHTargetAnchorLoc()) {
		case CenteredConnectionAnchor.TOP:
			return ManhattanConnectionRouterEx.UP;
		default:
			return ManhattanConnectionRouterEx.LEFT;
		}
	}

	/**
	 * Gets the direction in which the first segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getCHRoutingStartConstraint(){
		switch (getCHSourceAnchorLoc()) {
		case CenteredConnectionAnchor.BOTTOM:
			return ManhattanConnectionRouterEx.DOWN;
		default:
			return ManhattanConnectionRouterEx.RIGHT;
		}
	}

	/**
	 * Gets the direction in which the last segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getCHRoutingEndConstraint(){
		switch (getCHTargetAnchorLoc()) {
		case CenteredConnectionAnchor.TOP:
			return ManhattanConnectionRouterEx.UP;
		default:
			return ManhattanConnectionRouterEx.LEFT;
		}
	}

	/**
	 * Gets the direction in which the first segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getTHRoutingStartConstraint(){
		switch (getTHSourceAnchorLoc()) {
		case CenteredConnectionAnchor.BOTTOM:
			return ManhattanConnectionRouterEx.DOWN;
		default:
			return ManhattanConnectionRouterEx.RIGHT;
		}
	}

	/**
	 * Gets the direction in which the last segment of the connection
	 * should point
	 * @return
	 */
	protected Ray getTHRoutingEndConstraint(){
		switch (getCHTargetAnchorLoc()) {
		case CenteredConnectionAnchor.TOP:
			return ManhattanConnectionRouterEx.UP;
		default:
			return ManhattanConnectionRouterEx.LEFT;
		}
	}
	
	/**
	 * Gets the faultHandlerFigure from the editPart
	 * @return
	 */
	protected abstract IFigure getFHFigure();
	
	/**
	 * Gets the compensationHandlerFigure from the editPart
	 * @return
	 */
	protected abstract IFigure getCHFigure();
	
	/**
	 * Gets the terminationHandlerFigure from the editPart
	 * @return
	 */
	protected abstract IFigure getTHFigure();
	
	/**
	 * Gets the eventHandlerFigure from the editPart
	 * @return
	 */
	protected abstract IFigure getEHFigure();
	
	/**
	 * Gets the location of the source connectionAnchor of the faultHandlerIcon 
	 * @return
	 */
	protected int getFHSourceAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.BOTTOM : CenteredConnectionAnchor.RIGHT;
	}
	
	/**
	 * Gets the location of the source connectionAnchor of the compensationHandlerIcon 
	 * @return
	 */
	protected int getCHSourceAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.BOTTOM : CenteredConnectionAnchor.RIGHT;
	}
	
	/**
	 * Gets the location of the source connectionAnchor of the terminationHandlerIcon 
	 * @return
	 */
	protected int getTHSourceAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.BOTTOM : CenteredConnectionAnchor.RIGHT;
	}
	
	/**
	 * Gets the location of the source connectionAnchor of the eventHandlerIcon 
	 * @return
	 */
	protected int getEHSourceAnchorLoc(){
		return isHorizontalLayout() ? CenteredConnectionAnchor.BOTTOM : CenteredConnectionAnchor.RIGHT;
	}

	/**
	 * Convenience method which gets the orientation property from the editor
	 * 
	 * @return True if the orientation is horizontal, false if it is vertical
	 */
	protected boolean isHorizontalLayout() {
		return ModelHelper.getBPELEditor(editPart.getModel())
				.isHorizontalLayout();
	}
	
	/**
	 * Convienience method which gets the HandlerIconFigure from a FaultHandler.
	 * @return
	 */
	protected IFigure getFHHandlerFigure(FaultHandlerEditPart fhEditPart){
		return ((RoundRectangleBorderWithDecoration)fhEditPart.getContentPane().getBorder()).getDecorationFigure();
	}

}
