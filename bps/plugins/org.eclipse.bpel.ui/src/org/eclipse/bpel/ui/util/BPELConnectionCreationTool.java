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
package org.eclipse.bpel.ui.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.AccessibleAnchorProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.AbstractConnectionCreationTool;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Scrollable;


/**
 * This class allows an EditPart to have initial source anchor for 
 * the ConnectionCreationTool.
 */
public class BPELConnectionCreationTool extends AbstractConnectionCreationTool {

	private EditPartViewer viewer;
	private EditPart source;
	private EditPart proposedTarget;
	private boolean lastProposedTargetConnectable;
	
	public BPELConnectionCreationTool(CreationFactory factory) {
		super(factory);
		setDefaultCursor(Cursors.ARROW); // don't use the plug
//		setDisabledCursor();  TODO: need cursor with arrow and no drop 
		setFactory(factory);
		setUnloadWhenFinished(true);
	}

	@Override
	protected boolean handleKeyDown(KeyEvent event) {
		boolean ret = ourHandleKeyDown(event);
		if (getDomain().getActiveTool() != this) {
			//set.setLockOut(false);
		}
		return ret;
	}

	@Override
	protected void handleFinished() {
		super.handleFinished();
		//set.setLockOut(false);
	}

	public void setInitialAnchor(EditPart part, EditPartViewer curViewer) {
		setViewer(curViewer);
		setTargetEditPart(part);
		updateTargetRequest();
		setConnectionSource(part);
		
		Command command = getCommand();
		((CreateConnectionRequest)getTargetRequest()).setSourceEditPart(part);
		source = part;
		proposedTarget = null;
		lastProposedTargetConnectable = false;
		
		if (command != null) {
			setState(STATE_CONNECTION_STARTED);
			setCurrentCommand(command);
			viewer = getCurrentViewer();
		}
		if (isInState(STATE_CONNECTION_STARTED)) {
			updateTargetRequest();
			updateTargetUnderMouse();
			showSourceFeedback();
			showTargetFeedback();
			setCurrentCommand(getCommand());
		}
		return;
	}

	@Override
	protected boolean handleButtonDown(int button) {
		if (button == 1 && stateTransition(STATE_CONNECTION_STARTED, STATE_TERMINAL)) {
			boolean ret = handleCreateConnection();
			if (getCommand() != null)
				handleFinished();
			return ret;
		}

		if (isInState(STATE_INITIAL) && button == 1) {
			updateTargetRequest();
			updateTargetUnderMouse();
			setConnectionSource(getTargetEditPart());
			Command command = getCommand();
			((CreateConnectionRequest)getTargetRequest()).setSourceEditPart(
				getTargetEditPart());
			if (command != null) {
				setState(STATE_CONNECTION_STARTED);
				setCurrentCommand(command);
				viewer = getCurrentViewer();
			}
		}
	
		if (isInState(STATE_INITIAL) && button != 1) {
			setState(STATE_INVALID);
			handleInvalidInput();
		}
	
		if (isInState(STATE_CONNECTION_STARTED)) {
			//Fake a drag to cause feedback to be displayed immediately on mouse down.
			handleDrag();
		}
		return true;
	}

	@Override
	public void deactivate() {
		viewer = null;
		super.deactivate();
	}

	@Override
	protected boolean handleMove() {
		if (isInState(STATE_CONNECTION_STARTED) && viewer != getCurrentViewer())
			return false;
		if (isInState(STATE_CONNECTION_STARTED | STATE_INITIAL | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			updateTargetRequest();
			updateTargetUnderMouse();
			showSourceFeedback();
			showTargetFeedback();
			setCurrentCommand(getCommand());
		}
		return true;
	}
	
	@Override
	protected boolean updateTargetUnderMouse() {
		if (!isTargetLocked()) {
			Collection exclude = getExclusionSet();
			EditPart editPart = getCurrentViewer().findObjectAtExcluding(
				getLocation(),
				exclude,
				getTargetingConditional());
			if (editPart != null) {
				editPart = editPart.getTargetEditPart(getTargetRequest());
			}
			boolean changed = getTargetEditPart() != editPart;
			setTargetEditPart(editPart);
			return changed;
		}
		return false;
	}
	
	@Override
	protected EditPartViewer.Conditional getTargetingConditional() {
		return new EditPartViewer.Conditional() {
			public boolean evaluate(EditPart editpart) {
				EditPart target = editpart.getTargetEditPart(getTargetRequest());
				if (target == null)
					return false;
				if (target == proposedTarget)
					return lastProposedTargetConnectable; 
				
				if (target.getParent() instanceof FlowEditPart) {
					lastProposedTargetConnectable = ((FlowEditPart)(target.getParent())).detectImpendingCycle(source, target);
				}
				else {
					lastProposedTargetConnectable = true;
				}
				proposedTarget = target;
				return lastProposedTargetConnectable;
			}
		};
	}
	
	boolean acceptConnectionFinish(KeyEvent event) {
		return isInState(STATE_ACCESSIBLE_DRAG_IN_PROGRESS | STATE_CONNECTION_STARTED) && event.character == 13;
	}

	boolean acceptConnectionStart(KeyEvent event) {
		return isInState(STATE_INITIAL) && event.character == 13;
	}

	/**
	 * Cleans up feedback and resets the tool when focus is lost.
	 * @return <code>true</code> if this focus lost event was processed
	 */
	@Override
	protected boolean handleFocusLost() {
		if (isInState(STATE_CONNECTION_STARTED | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)) {
			eraseSourceFeedback();
			eraseTargetFeedback();
			setState(STATE_INVALID);
			handleFinished();
		}
		return super.handleFocusLost();
	}

	
	private boolean ourAcceptArrowKey(KeyEvent e) {
		int key = e.keyCode;
		if (!(isInState(STATE_INITIAL 
		  | STATE_CONNECTION_STARTED  
		  | STATE_ACCESSIBLE_DRAG
		  | STATE_ACCESSIBLE_DRAG_IN_PROGRESS)))
			return false;
		return (key == SWT.ARROW_UP)
			|| (key == SWT.ARROW_RIGHT)
			|| (key == SWT.ARROW_DOWN)
			|| (key == SWT.ARROW_LEFT);
	}
	
	private boolean ourHandleKeyDown(KeyEvent event) {
		if (ourAcceptArrowKey(event)) {
			int direction = 0;
			switch (event.keyCode) {
				case SWT.ARROW_DOWN :
					direction = PositionConstants.SOUTH;
					break;
				case SWT.ARROW_UP:
					direction = PositionConstants.NORTH;
					break;
				case SWT.ARROW_RIGHT:
					direction = PositionConstants.EAST;
					break;
				case SWT.ARROW_LEFT:
					direction = PositionConstants.WEST;
					break;
			}

			boolean consumed = false;
			if (direction != 0 && event.stateMask == 0)
				consumed = navigateNextAnchor(direction);
			if (!consumed) {
				event.stateMask |= SWT.CONTROL;
				event.stateMask &= ~SWT.SHIFT;
				if (getCurrentViewer().getKeyHandler().keyPressed(event)) {
					navigateNextAnchor(0);
					updateTargetRequest();
					updateTargetUnderMouse();
					Command command = getCommand();
					if (command != null)
						setCurrentCommand(command);
					return true;
				}
			}
		}
	
		if (acceptConnectionStart(event)) {
			updateTargetUnderMouse();
			setConnectionSource(getTargetEditPart());
			((CreateConnectionRequest)getTargetRequest())
				.setSourceEditPart(getTargetEditPart());
			setState(STATE_ACCESSIBLE_DRAG_IN_PROGRESS);
			ourPlaceMouseInViewer(getLocation().getTranslated(6, 6));
			return true;
		}
	
		if (acceptConnectionFinish(event)) {
			Command command = getCommand();
			if (command != null && command.canExecute()) {
				setState(STATE_INITIAL);
				ourPlaceMouseInViewer(getLocation().getTranslated(6, 6));
				eraseSourceFeedback();
				eraseTargetFeedback();
				setCurrentCommand(command);
				executeCurrentCommand();
				handleFinished();
			}
			return true;
		}
	
		return super.handleKeyDown(event);
	}

	boolean navigateNextAnchor(int direction) {
		EditPart focus = getCurrentViewer().getFocusEditPart();
		AccessibleAnchorProvider provider;
		provider = (AccessibleAnchorProvider)focus.getAdapter(AccessibleAnchorProvider.class);
		if (provider == null)
			return false;

		List list;
		if (isInState(STATE_ACCESSIBLE_DRAG_IN_PROGRESS))
			list = provider.getTargetAnchorLocations();
		else
			list = provider.getSourceAnchorLocations();

		Point start = getLocation();
		int distance = Integer.MAX_VALUE;
		Point next = null;
		for (int i = 0; i < list.size(); i++) {
			Point p = (Point)list.get(i);
			if (p.equals(start)
				|| (direction != 0
					&& (start.getPosition(p) != direction)))
				continue;
			int d = p.getDistanceOrthogonal(start);
			if (d < distance) {
				distance = d;
				next = p;
			}
		}

		if (next != null) {
			ourPlaceMouseInViewer(next);
			return true;
		}
		return false;	
	}
	
	void ourPlaceMouseInViewer(Point p) {
		if (getCurrentViewer() == null)
			return;
		Control c = getCurrentViewer().getControl();
		Rectangle rect;
		if (c instanceof Scrollable)
			rect = ((Scrollable)c).getClientArea();
		else
			rect = c.getBounds();
		if (p.x > rect.x + rect.width - 1)
			p.x = rect.x + rect.width - 1;
		else if (p.x < rect.x)
			p.x = rect.x;
		if (p.y > rect.y + rect.height - 1)
			p.y = rect.y + rect.height - 1;
		else if (p.y < rect.y)
			p.y = rect.y;
		org.eclipse.swt.graphics.Point swt = new org.eclipse.swt.graphics.Point(p.x, p.y);
		swt = c.toDisplay(swt);
		c.getDisplay().setCursorLocation(swt);
	}
}
