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

import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.editparts.borders.ScopeBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Ray;

public class ScopeHandlerLinker extends HandlerLinkerAdapter {

	private ScopeEditPart scope;

	public ScopeHandlerLinker(ScopeEditPart scopeEditPart) {
		super(scopeEditPart);
		this.scope = scopeEditPart;
	}

	@Override
	protected CompensationHandler getCompensationHandler() {
		return scope.getCompensationHandler();
	}

	@Override
	protected EventHandler getEventHandler() {
		return scope.getEventHandler();
	}

	@Override
	protected FaultHandler getFaultHandler() {
		return scope.getFaultHandler();
	}

	/**
	 * Overridden to provide different connectionAnchors for an eventHandler
	 */
	@Override
	protected int getEHTargetAnchorLoc() {
		if(!isHorizontalLayout()){
			if (getFaultHandler() != null && getCompensationHandler() != null
					&& getTerminationHandler() != null)
				return CenteredConnectionAnchor.LEFT;
			else
				return CenteredConnectionAnchor.TOP;
		}else
			return super.getEHTargetAnchorLoc();
	}

	@Override
	protected boolean isShowCH() {
		return scope.getShowCompensationHandler();
	}

	@Override
	protected boolean isShowEH() {
		return scope.getShowEventHandler();
	}

	@Override
	protected boolean isShowFH() {
		return scope.getShowFaultHandler();
	}

	@Override
	protected int getTHTargetAnchorLoc() {
		return isHorizontalLayout() ? CenteredConnectionAnchor.LEFT
				: CenteredConnectionAnchor.TOP;
	}

	@Override
	protected TerminationHandler getTerminationHandler() {
		return scope.getTerminationHandler();
	}

	@Override
	protected boolean isShowTH() {
		return scope.getShowTerminationHandler();
	}

	@Override
	protected Ray getTHRoutingEndConstraint() {
		return isHorizontalLayout() ? ManhattanConnectionRouterEx.LEFT
				: ManhattanConnectionRouterEx.UP;
	}

	@Override
	protected IFigure getCHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getCompensationImageFigure();
	}

	@Override
	protected IFigure getEHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getEventImageFigure();
	}

	@Override
	protected IFigure getFHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getFaultImageFigure();
	}

	@Override
	protected IFigure getTHFigure() {
		return ((ScopeBorder)scope.getContentPane().getBorder()).getTerminationImageFigure();
	}
	
}
