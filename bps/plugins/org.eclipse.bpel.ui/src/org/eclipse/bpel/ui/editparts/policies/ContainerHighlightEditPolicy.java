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

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;


public class ContainerHighlightEditPolicy extends BPELSelectionEditPolicy {

	private Color revertColor = null;
	private boolean revertOpaque;
	private Color highlightColor = null;
	
	public ContainerHighlightEditPolicy(boolean resizable, boolean movable) {
		super(resizable, movable);
	}
	
	@Override
	public void eraseTargetFeedback(Request request) {
		if (revertColor != null) {
			setContainerBackground(revertColor);
			getContainerFigure().setOpaque(revertOpaque);
			revertColor = null;
		}
	}

	@Override
	public void activate() {
		super.activate();
		if (highlightColor == null) {
			BPELUIPlugin plugin = BPELUIPlugin.INSTANCE;
			ColorRegistry colorRegistry = plugin.getColorRegistry();
			highlightColor = colorRegistry.get(IBPELUIConstants.COLOR_GRADIENT_TO);
		}
	}

	@Override
	public void deactivate() {
		super.deactivate();
		if (highlightColor != null) {
			highlightColor = null;
		}
		
		if (revertColor != null) {
			setContainerBackground(revertColor);
			getContainerFigure().setOpaque(revertOpaque);
			revertColor = null;
		}

	}

	private Color getContainerBackground() {
		return getContainerFigure().getBackgroundColor();
	}

	private IFigure getContainerFigure() {
		return ((GraphicalEditPart) getHost()).getContentPane();
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		return request.getType().equals(RequestConstants.REQ_SELECTION_HOVER) ? getHost() : null;
	}

	private void setContainerBackground(Color c) {
		getContainerFigure().setBackgroundColor(c);
	}

	protected void showHighlight() {
		if (revertColor == null) {
			revertOpaque = getContainerFigure().isOpaque();
			revertColor = getContainerBackground();
			setContainerBackground(highlightColor);
			getContainerFigure().setOpaque(true);		
		}
	}

	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		if (request.getType().equals(RequestConstants.REQ_MOVE)
			|| request.getType().equals(RequestConstants.REQ_ADD)
			|| request.getType().equals(RequestConstants.REQ_CREATE)) {

			if (((BPELEditPart) getHost()).canExecuteRequest(request)) {
				showHighlight();
			}
		}
	}
}