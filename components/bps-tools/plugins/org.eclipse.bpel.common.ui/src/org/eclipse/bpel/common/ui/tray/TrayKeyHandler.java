/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.tray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;


public class TrayKeyHandler extends KeyHandler {

	protected EditPartViewer viewer;
	
	public TrayKeyHandler(EditPartViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public boolean keyPressed(KeyEvent event) {
		switch (event.keyCode) {
			case SWT.ARROW_UP:
				return navigateNext(event, PositionConstants.NORTH);
			case SWT.ARROW_DOWN:
				return navigateNext(event, PositionConstants.SOUTH);
			case SWT.HOME:
				return navigateJump(event, PositionConstants.TOP);
			case SWT.END:
				return navigateJump(event, PositionConstants.BOTTOM);
			case SWT.PAGE_DOWN:
				return navigateJump(event, PositionConstants.SOUTH);
			case SWT.PAGE_UP:
				return navigateJump(event, PositionConstants.NORTH);
			case SWT.F2:
				return activateDirectEdit(event);
		}
		// default
		return super.keyPressed(event);
	}
	
	protected boolean navigateNext(KeyEvent event, int direction) {
		GraphicalEditPart currentPart = (GraphicalEditPart)viewer.getFocusEditPart();
		
		// TODO: we should cache this list
		List flatList = new ArrayList();
		buildFlatList(flatList, viewer.getContents());
		
		int currentPosition = flatList.indexOf(currentPart);
		switch (direction) {
			case PositionConstants.NORTH:
				currentPosition--;
				break;
			case PositionConstants.SOUTH:
				currentPosition++;
				break;
		}
		if (currentPosition >= 0 && currentPosition < flatList.size()) {
			currentPart = (GraphicalEditPart) flatList.get(currentPosition);
			navigateTo(currentPart, event);
			return true;
		}
		return false;
	}
	
	protected void buildFlatList(List result, EditPart container) {
		result.add(container);
		for (Iterator iter = container.getChildren().iterator(); iter.hasNext();) {
			EditPart part = (EditPart) iter.next();
			buildFlatList(result, part);
		}
	}

	protected boolean navigateJump(KeyEvent event, int direction) {
		return true;
	}

	protected void navigateTo(GraphicalEditPart part, KeyEvent event) {
		if (part == null) return;
		if ((event.stateMask & SWT.SHIFT) != 0) {
			viewer.appendSelection(part);
			viewer.setFocus(part);
		} else if ((event.stateMask & SWT.CONTROL) != 0) {
			viewer.setFocus(part);
		} else {
			viewer.select(part);
		}
		reveal(part);
	}
	
	protected void reveal(GraphicalEditPart part) {
		// there's no need to scroll to the main edit part because it is always visible
		if (part instanceof MainTrayEditPart) return;

		MainTrayEditPart mainPart = getMainTrayEditPart(part);
		ScrollPane scrollpane = ((MainTrayEditPart.MainTrayContainerFigure)mainPart.getFigure()).getChildrenScrollPane();
		Viewport viewport = scrollpane.getViewport();
		Rectangle partBounds = part.getFigure().getBounds().getCopy();
		Rectangle portBounds = viewport.getBounds();
		if (!portBounds.contains(partBounds)) {
			Point topLocation = partBounds.getTopLeft();
			
			Point currentLocation = viewport.getViewLocation();
			int step = getScrollStep(part);
			if (currentLocation.getPosition(topLocation) == PositionConstants.NORTH) {
				currentLocation.y -= step;
				// ensure that we don't leave things "half-scrolled" at the top
				currentLocation.y = (currentLocation.y < step) ? 0 : currentLocation.y;
			} else {
				currentLocation.y += step;
			}
			viewport.setViewLocation(currentLocation);

			// refreshes the scrollbar so they can disppear if needed 
			ScrollBar scrollbar = scrollpane.getVerticalScrollBar();
			scrollbar.invalidate();
			scrollbar.validate();
		}
	}
	
	protected int getScrollStep(GraphicalEditPart part) {
		if (part instanceof TrayCategoryEntryEditPart) {
			return part.getFigure().getBounds().height;
		}
		if (part instanceof TrayCategoryEditPart) {
			return ((TrayCategoryEditPart)part).getTitleFigure().getBounds().height;
		}
		return 0;
	}
	
	protected MainTrayEditPart getMainTrayEditPart(EditPart part) {
		if (part instanceof MainTrayEditPart) return (MainTrayEditPart)part;
		return getMainTrayEditPart(part.getParent());
	}
	
	protected boolean activateDirectEdit(KeyEvent event) {
		GraphicalEditPart currentPart = (GraphicalEditPart)viewer.getFocusEditPart();
		currentPart.performRequest(new DirectEditRequest());
		return true;
	}
}
