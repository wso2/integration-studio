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

import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;


public class FlowHighlightEditPolicy extends ContainerHighlightEditPolicy {

	private Polyline insertionLine = null;
	private Polyline insertionLine2 = null;
	private IFigure feedbackfig = null;
	private Point translatedPt;

	public FlowHighlightEditPolicy(boolean resizable) {
		super(resizable, true);
	}
	
	private Point translateToRelativePoint(Point pt) {
		Point newpt = pt.getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(newpt);
		((GraphicalEditPart)getHost().getRoot()).getFigure().translateToAbsolute(newpt);
		return newpt;
	}
	
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if (insertionLine != null) {
			// JM: Don't use the crosshairs.
//			removeFeedback(insertionLine2);
//			removeFeedback(insertionLine);
			insertionLine = null;
			insertionLine2 = null;
		}
		
		if (feedbackfig != null) {
			removeFeedback(feedbackfig);
			feedbackfig = null;
		}
		
	}

	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		if (request.getType().equals(RequestConstants.REQ_ADD)
			|| request.getType().equals(RequestConstants.REQ_CREATE)) {

			if (((BPELEditPart) getHost()).canExecuteRequest(request)) {
				showHighlight(request);
			}
		}
	}
	
	protected void showHighlight(Request request) {
		final int WIDTH = 25;
		Point p = null;
		if (request instanceof ChangeBoundsRequest) {
			p = ((ChangeBoundsRequest)request).getLocation().getCopy();
		}
		else if (request instanceof CreateRequest) { 
			p = ((CreateRequest)request).getLocation().getCopy();
		}

		if (p != null) {
			if (insertionLine != null) {
				// JM: Don't use the crosshairs.
//				removeFeedback(insertionLine2);
//				removeFeedback(insertionLine);
			}

			IFigure oldfeedback = feedbackfig;
			if (feedbackfig != null) 
				removeFeedback(feedbackfig);
			if (request instanceof CreateRequest && feedbackfig != null) {
				oldfeedback.translate(-translatedPt.x, -translatedPt.y);
			}	
			
			insertionLine = new Polyline();
			insertionLine.setLineWidth(1);
			insertionLine.setOutlineXOR(true);
			insertionLine.setForegroundColor(ColorConstants.darkGray);
			
			insertionLine2 = new Polyline();
			insertionLine2.setLineWidth(1);
			insertionLine2.setOutlineXOR(true);
			insertionLine2.setForegroundColor(ColorConstants.darkGray);

			insertionLine.addPoint(translateToRelativePoint(new Point(p.x, p.y - WIDTH)));
			insertionLine.addPoint(translateToRelativePoint(new Point(p.x, p.y + WIDTH)));
			insertionLine2.addPoint(translateToRelativePoint(new Point(p.x - WIDTH, p.y)));
			insertionLine2.addPoint(translateToRelativePoint(new Point(p.x + WIDTH, p.y)));
			// JM: Don't use the crosshairs.
//			addFeedback(insertionLine);
//			addFeedback(insertionLine2);
			
			if (request instanceof CreateRequest) {
				
				if (feedbackfig != null) {
					translatedPt = translateToRelativePoint(new Point(p.x, p.y));
					oldfeedback.translate(translatedPt.x, translatedPt.y);
					addFeedback(oldfeedback);
				} else {
					// JM: Don't show the new activity node as part of the feedback. This causes
					// problems with the new decorator code, which assumes that the model of the
					// edit part is actually a real model, not a dummy object as below.
//					CreateRequest createreq = (CreateRequest)request;
//					Object newobj = createreq.getNewObject();
//					GraphicalEditPart gep = (GraphicalEditPart)getHost().getRoot().getViewer().getEditPartFactory().createEditPart(getHost(), newobj);
//					feedbackfig = gep.getFigure();
//					translatedPt = translateToRelativePoint(new Point(p.x, p.y));
//					feedbackfig.translate(translatedPt.x, translatedPt.y);
//					addFeedback(feedbackfig);					
				}
			}
			
		}
	}
	
	protected int selectedState = -1;
	
	@Override
	protected void setSelectedState(int type) {
		selectedState = type;
		super.setSelectedState(type);
	}
	
	// make this visible so the editpart can poke it when the collapsed state changes
	public void setResizable(boolean resizable) {
		this.fResizable = resizable;
		if (selectedState != -1) {
			// force selection handles to be refreshed.
			int previousState = selectedState;
			setSelectedState(-1);
			setSelectedState(previousState);
		}
	}
}
