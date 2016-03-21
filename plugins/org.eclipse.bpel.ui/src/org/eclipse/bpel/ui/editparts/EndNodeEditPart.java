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

import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.figures.CenteredConnectionAnchor;
import org.eclipse.bpel.ui.uiextensionmodel.EndNode;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.swt.graphics.Image;


public class EndNodeEditPart extends BPELEditPart implements NodeEditPart {
	Image image;

	@Override
	protected IFigure createFigure() {
		if (image == null) {
			ILabeledElement element = BPELUtil.adapt(getEndNode(), ILabeledElement.class);
			image = element.getSmallImage(getEndNode());
		}
		ImageFigure imageFigure = new ImageFigure(image);
		return imageFigure;
	}	
	@Override
	public boolean isSelectable() {
		return false;
	}
	public EndNode getEndNode() {
		return (EndNode)getModel();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		// End nodes cannot be the source of a connection.
		return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		// End nodes can be the target of an implicit connection
		// anchored at the top centre of the node.
		return new CenteredConnectionAnchor(getFigure(), CenteredConnectionAnchor.TOP, 0);
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		// TODO: Translate point to figure, call other method
		return getSourceConnectionAnchor((ConnectionEditPart)null);
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		// TODO: Translate point to figure, call other method
		return getTargetConnectionAnchor((ConnectionEditPart)null);
	}	
}
