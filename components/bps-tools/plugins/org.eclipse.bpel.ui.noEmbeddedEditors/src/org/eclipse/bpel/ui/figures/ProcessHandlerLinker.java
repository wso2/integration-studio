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

import java.util.List;

import org.eclipse.bpel.model.EventHandler;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.bpel.ui.editparts.StartNodeEditPart;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.gef.EditPart;

public class ProcessHandlerLinker extends HandlerLinkerAdapter {
	
	private ProcessEditPart process;
	
	private StartNodeEditPart snep;
	
	public ProcessHandlerLinker(ProcessEditPart processEditPart) {
		super(processEditPart);
		this.process = processEditPart;
	}

	@Override
	protected EventHandler getEventHandler() {
		return process.getEventHandler();
	}

	@Override
	protected FaultHandler getFaultHandler() {
		return process.getFaultHandler();
	}

	@Override
	protected int getEHTargetAnchorLoc() {
		return CenteredConnectionAnchor.LEFT;
	}

	@Override
	protected boolean isShowEH() {
		return process.isShowEH();
	}

	@Override
	protected boolean isShowFH() {
		return process.isShowFH();
	}
	
	private StartNodeEditPart getStartNodeEditPart(){
		if(snep == null){
			// Search for the StartNodeEditPart
			List<EditPart> children = process.getChildren();
			for (EditPart child : children) {
				if (child instanceof StartNodeEditPart) {
					snep = (StartNodeEditPart) child;
				}
			}
		}
		return snep;
	}

	/**
	 * Overridden to always return LEFT direction
	 */
	@Override
	protected Ray getEHRoutingEndConstraint() {
		return ManhattanConnectionRouterEx.LEFT;
	}

	@Override
	protected IFigure getEHFigure() {
		return getStartNodeEditPart().getEventImageFigure();
	}

	@Override
	protected IFigure getFHFigure() {
		return getStartNodeEditPart().getFaultImageFigure();
	}
}
