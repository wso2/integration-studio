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
package org.eclipse.bpel.ui;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.bpel.ui.editparts.CollapsableEditPart;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;

public class BPELGraphicalKeyHandler extends KeyHandler {
	int counter;

	/**
	 * When navigating through connections, a "Node" EditPart is used as a
	 * reference.
	 */
	private WeakReference<GraphicalEditPart> cachedNode;
	private GraphicalViewer viewer;

	public BPELGraphicalKeyHandler(GraphicalViewer viewer) {
		this.viewer = viewer;
	}

	private boolean acceptConnection(KeyEvent event) {
		return event.character == '/'
			|| event.character == '?'
			|| event.character == '\\'
			|| event.character == '\u001c'
			|| event.character == '|';
	}

	private boolean acceptIntoContainer(KeyEvent event) {
		return ((event.stateMask & SWT.ALT) != 0)
			&& (event.keyCode == SWT.ARROW_DOWN);
	}

	private boolean acceptLeaveConnection(KeyEvent event) {
		int key = event.keyCode;
		if (getFocus() instanceof ConnectionEditPart)
			if ((key == SWT.ARROW_UP)
				|| (key == SWT.ARROW_RIGHT)
				|| (key == SWT.ARROW_DOWN)
				|| (key == SWT.ARROW_LEFT))
				return true;
		return false;
	}

	private boolean acceptLeaveContents(KeyEvent event) {
		int key = event.keyCode;
		return getFocus() == getViewer().getContents()
			&& ((key == SWT.ARROW_UP)
				|| (key == SWT.ARROW_RIGHT)
				|| (key == SWT.ARROW_DOWN)
				|| (key == SWT.ARROW_LEFT));
	}

	private boolean acceptOutOf(KeyEvent event) {
		return ((event.stateMask & SWT.ALT) != 0)
			&& (event.keyCode == SWT.ARROW_UP);
	}

	private ConnectionEditPart findConnection(
		GraphicalEditPart node,
		ConnectionEditPart current,
		boolean forward) {
		List<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>(node.getSourceConnections());
		connections.addAll(node.getTargetConnections());
		if (connections.isEmpty())
			return null;
		if (forward)
			counter++;
		else
			counter--;
		while (counter < 0)
			counter += connections.size();
		counter %= connections.size();
		return connections.get(
			counter % connections.size());
	}

	/*
	 * pStart is a point in absolute coordinates.
	 */
	private GraphicalEditPart findSibling(
		List<GraphicalEditPart> siblings,
		Point pStart,
		int direction,
		EditPart exclude) {
		GraphicalEditPart epCurrent;
		GraphicalEditPart epFinal = null;
		IFigure figure;
		Point pCurrent;
		int distance = Integer.MAX_VALUE;

		Iterator<GraphicalEditPart> iter = siblings.iterator();
		while (iter.hasNext()) {
			epCurrent = iter.next();
			if (epCurrent == exclude || !epCurrent.isSelectable())
				continue;
			figure = epCurrent.getFigure();
			pCurrent = getInterestingPoint(figure);
			figure.translateToAbsolute(pCurrent);
			if (pStart.getPosition(pCurrent) != direction)
				continue;

			int d = pCurrent.getDistanceOrthogonal(pStart);
			if (d < distance) {
				distance = d;
				epFinal = epCurrent;
			}
		}
		return epFinal;
	}

	Point getInterestingPoint(IFigure figure) {
		return figure.getBounds().getCenter();
	}

	/**
	 * Returns the cached node. It is possible that the node is not longer in
	 * the viewer but has not been garbage collected yet.
	 */
	private GraphicalEditPart getCachedNode() {
		if (cachedNode == null)
			return null;
		if (cachedNode.isEnqueued())
			return null;
		return cachedNode.get();
	}

	protected GraphicalEditPart getFocus() {
		return (GraphicalEditPart) getViewer().getFocusEditPart();
	}

	/**
	 * Returns the viewer on which this key handler was created.
	 * 
	 * @return the viewer
	 */
	protected GraphicalViewer getViewer() {
		return viewer;
	}

	/**
	 * Extended to process key events described above.
	 * 
	 * @see org.eclipse.gef.KeyHandler#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	@Override
	public boolean keyPressed(KeyEvent event) {
		if (event.character == ' ') {
			processSelect(event);
			return true;
		} else if (acceptIntoContainer(event)) {
			navigateIntoContainer(event);
			return true;
		} else if (acceptOutOf(event)) {
			navigateOut(event);
			return true;
		} else if (acceptConnection(event)) {
			navigateConnections(event);
			return true;
		} else if (acceptScroll(event)) {
			scrollViewer(event);
			return true;
		} else if (acceptLeaveConnection(event)) {
			navigateOutOfConnection(event);
			return true;
		} else if (acceptLeaveContents(event)) {
			navigateIntoContainer(event);
			return true;
		} else if (event.character == '[') {
			int found = -1;
			List<GraphicalEditPart> list = getProcessNavigationList();
			for (int i = 0; i < list.size(); i++) {
				if (getFocus() == list.get(i)) {
					found = i;
					break;
				}
			}
			if (found >= 0) {
				found--;
			}
			if (found >=0) {
				EditPart navigateTo = list.get(found);
				navigateTo(navigateTo, event);
			}
		} else if (event.character == ']') {
			int found = -1;
			List<GraphicalEditPart> list = getProcessNavigationList();
			for (int i = 0; i < list.size(); i++) {
				if (getFocus() == list.get(i)) {
					found = i;
					break;
				}
			}
			if (found >= 0) {
				found++;
			}
			if (found < list.size()) {
				EditPart navigateTo = list.get(found);
				navigateTo(navigateTo, event);
			}
		} else if (event.character == '+' || event.character == '=') {
			expand(event);
		} else if (event.character == '-') {
			collapse(event);
		}

	

		switch (event.keyCode) {
			case SWT.ARROW_LEFT :
				if (navigateNextSibling(event, PositionConstants.WEST))
					return true;
				break;
			case SWT.ARROW_RIGHT :
				if (navigateNextSibling(event, PositionConstants.EAST))
						return true;
				break;
			case SWT.ARROW_UP :
				if (navigateNextSibling(event, PositionConstants.NORTH))
					return true;
				break;
			case SWT.ARROW_DOWN :
				if (navigateNextSibling(event, PositionConstants.SOUTH))
					return true;
				break;

			case SWT.HOME :
				if (navigateJumpSibling(event, PositionConstants.WEST))
					return true;
				break;
			case SWT.END :
				if (navigateJumpSibling(event, PositionConstants.EAST))
					return true;
				break;
			case SWT.PAGE_DOWN :
				if (navigateJumpSibling(event, PositionConstants.SOUTH))
					return true;
				break;
			case SWT.PAGE_UP :
				if (navigateJumpSibling(event, PositionConstants.NORTH))
					return true;
				break;
			case SWT.TAB :
				return true;
			case SWT.F2:
				activateDirectEdit(event);
				break;
		}
		return super.keyPressed(event);
	}

	private void navigateConnections(KeyEvent event) {
		GraphicalEditPart focus = getFocus();
		ConnectionEditPart current = null;
		GraphicalEditPart node = getCachedNode();
		if (focus instanceof ConnectionEditPart) {
			current = (ConnectionEditPart) focus;
			if (node == null
				|| (node != current.getSource() && node != current.getTarget())) {
				node = (GraphicalEditPart) current.getSource();
				counter = 0;
			}
		} else {
			node = focus;
		}

		setCachedNode(node);
		boolean forward = event.character == '/' || event.character == '?';
		ConnectionEditPart next = findConnection(node, current, forward);
		navigateTo(next, event);
	}

	private void navigateIntoContainer(KeyEvent event) {
		GraphicalEditPart focus = getFocus();
		List<GraphicalEditPart> childList = getNavigationChildren(focus);
		Point tl = focus.getContentPane().getBounds().getTopLeft();

		int minimum = Integer.MAX_VALUE;
		int current;
		GraphicalEditPart closestPart = null;

		for (int i = 0; i < childList.size(); i++) {
			GraphicalEditPart ged = childList.get(i);
			if (!ged.isSelectable())
				continue;
			Rectangle childBounds = ged.getFigure().getBounds();

			current = (childBounds.x - tl.x) + (childBounds.y - tl.y);
			if (current < minimum) {
				minimum = current;
				closestPart = ged;
			}
		}
		if (closestPart != null)
			navigateTo(closestPart, event);
	}

	private boolean navigateJumpSibling(KeyEvent event, int direction) {
		// TODO: Implement navigateJumpSibling() (for PGUP, PGDN, HOME and END
		// key events)
		return false;
	}

	private boolean navigateNextSibling(KeyEvent event, int direction) {
		return navigateNextSibling(event, direction, getNavigationSiblings());
	}

	boolean navigateNextSibling(KeyEvent event, int direction, List<GraphicalEditPart> list) {
		GraphicalEditPart epStart = getFocus();
		IFigure figure = epStart.getFigure();
		Point pStart = getInterestingPoint(figure);
		figure.translateToAbsolute(pStart);
		EditPart next = findSibling(list, pStart, direction, epStart);
		if (next == null)
			return false;
		navigateTo(next, event);
		return true;
	}

	private void navigateOut(KeyEvent event) {
		EditPart parent = getNavigationParent(getFocus());
		if (getFocus() == null || getFocus() == getViewer().getContents() || getFocus().getParent() == getViewer().getContents())
			return;
		navigateTo(parent, event);
	}

	private void navigateOutOfConnection(KeyEvent event) {
		GraphicalEditPart cached = getCachedNode();
		ConnectionEditPart conn = (ConnectionEditPart) getFocus();
		if (cached != null && (cached == conn.getSource() || cached == conn.getTarget()))
			navigateTo(cached, event);
		else
			navigateTo(conn.getSource(), event);
	}

	void navigateTo(EditPart part, KeyEvent event) {
		if (part == null)
			return;
		if ((event.stateMask & SWT.SHIFT) != 0) {
			getViewer().appendSelection(part);
			getViewer().setFocus(part);
		} else if ((event.stateMask & SWT.CONTROL) != 0)
			getViewer().setFocus(part);
		else
			getViewer().select(part);
		getViewer().reveal(part);
	}

	private void processSelect(KeyEvent event) {
		EditPart part = getViewer().getFocusEditPart();
		if ((event.stateMask & SWT.CONTROL) != 0
			&& part.getSelected() != EditPart.SELECTED_NONE)
			getViewer().deselect(part);
		else
			getViewer().appendSelection(part);

		getViewer().setFocus(part);
	}

	private void expand(KeyEvent event) {
		EditPart part = getViewer().getFocusEditPart();
		if (part instanceof CollapsableEditPart) {
			((CollapsableEditPart)part).setCollapsed(false);
		}
	}

	private void collapse(KeyEvent event) {
		EditPart part = getViewer().getFocusEditPart();
		if (part instanceof CollapsableEditPart) {
			((CollapsableEditPart)part).setCollapsed(true);
		}
	}

	private void setCachedNode(GraphicalEditPart node) {
		if (node == null)
			cachedNode = null;
		else
			cachedNode = new WeakReference<GraphicalEditPart>(node);
	}

	/**
	 * handles StartNodeEditPart specific behavior
	 */
	protected List<GraphicalEditPart> getNavigationChildren(EditPart part) {
//		if (part instanceof StartNodeEditPart) {
//			// return the process's children
//			ProcessEditPart proc = (ProcessEditPart) part.getParent();
//			List list = proc.getChildren();
//			list.remove(part);
//			return list;
//		}
//		else
		return part.getChildren();
	}

	protected List<GraphicalEditPart> getNavigationSiblings() {
		EditPart focus = getFocus().getParent();
		return focus.getChildren();
	}
	
	protected EditPart getNavigationParent(EditPart part) {
		EditPart parent = part.getParent();
		if (parent instanceof ProcessEditPart) {
			return null;
		}
		return parent;
	}
	
	protected void addChildren(EditPart part, List<GraphicalEditPart> list) {
		List<GraphicalEditPart> children = part.getChildren();
		for (int i = 0; i < children.size(); i++) {
			list.add(children.get(i));
			addChildren((children.get(i)), list);
		}
		return;
	}
	/* 
	 * as a usability enhancement, we want to navigate to the next activity using the SHIFT left and right arrow, this
	 * allows the user to navigate to every element on the canvas easily
	 */ 
	protected List<GraphicalEditPart> getProcessNavigationList() {
		ProcessEditPart process = (ProcessEditPart)viewer.getContents();
		Vector<GraphicalEditPart> all = new Vector<GraphicalEditPart>();
		addChildren(process,all);
		return all;
	}
	
	protected boolean activateDirectEdit(KeyEvent event) {
		GraphicalEditPart currentPart = (GraphicalEditPart)viewer.getFocusEditPart();
		currentPart.performRequest(new DirectEditRequest());
		return true;
	}

	boolean acceptScroll(KeyEvent event) {
		return ((event.stateMask & SWT.CTRL) != 0 && (event.stateMask & SWT.SHIFT) != 0 
				&& (event.keyCode == SWT.ARROW_DOWN || event.keyCode == SWT.ARROW_LEFT
				|| event.keyCode == SWT.ARROW_RIGHT || event.keyCode == SWT.ARROW_UP));
	}

	void scrollViewer(KeyEvent event) {
		if (!(getViewer().getControl() instanceof FigureCanvas))
			return;
		FigureCanvas figCanvas = (FigureCanvas)getViewer().getControl();
		Point loc = figCanvas.getViewport().getViewLocation();
		Rectangle area = figCanvas.getViewport().getClientArea(Rectangle.SINGLETON).scale(.1); 
		switch (event.keyCode) {
			case SWT.ARROW_DOWN:
				figCanvas.scrollToY(loc.y + area.height);
				break;
			case SWT.ARROW_UP:
				figCanvas.scrollToY(loc.y - area.height);
				break;
			case SWT.ARROW_LEFT:
				figCanvas.scrollToX(loc.x - area.width);
				break;
			case SWT.ARROW_RIGHT:
				figCanvas.scrollToX(loc.x + area.width);
		}
	}
}
