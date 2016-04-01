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
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.ui.editparts.InvokeEditPart;
import org.eclipse.bpel.ui.editparts.borders.LeafBorder;
import org.eclipse.draw2d.IFigure;

public class InvokeHandlerLinker extends HandlerLinkerAdapter {

	private InvokeEditPart invoke;

	public InvokeHandlerLinker(InvokeEditPart editPart) {
		super(editPart);
		this.invoke = editPart;
	}

	@Override
	protected CompensationHandler getCompensationHandler() {
		return invoke.getCompensationHandler();
	}

	@Override
	protected FaultHandler getFaultHandler() {
		return invoke.getFaultHandler();
	}

	@Override
	protected boolean isShowCH() {
		return invoke.getShowCompensationHandler();
	}

	@Override
	protected boolean isShowFH() {
		return invoke.getShowFaultHandler();
	}

	@Override
	protected int getCHTargetAnchorLoc() {
		if (!isHorizontalLayout()) {
			return getFaultHandler() != null ? CenteredConnectionAnchor.LEFT
					: CenteredConnectionAnchor.TOP;
		}else
			return super.getCHTargetAnchorLoc();
	}

	@Override
	protected IFigure getCHFigure() {
		return ((LeafBorder)invoke.getContentPane().getBorder()).getCompensationImageFigure();
	}


	@Override
	protected IFigure getFHFigure() {
		return ((LeafBorder)invoke.getContentPane().getBorder()).getFaultImageFigure();
	}
}
