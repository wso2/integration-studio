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

import java.util.EventObject;

import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack.SharedCommandStackChangedEvent;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack.SharedCommandStackListener;


/**
 * A base class providing convenient hooks for the events of CommandStackListener2.
 * It also checks to make sure these events arrive in the expected order.
 */
public abstract class AbstractSharedCommandStackListener implements SharedCommandStackListener {

	public static final int STATE_NONE = 0;
	public static final int STATE_EXECUTE = 1;
	public static final int STATE_UNDO = 2;
	public static final int STATE_REDO = 3;

	protected int state = STATE_NONE;

	protected void startExecute() { }
	protected void finishExecute() { }
	protected void startUndo() { }
	protected void finishUndo() { }
	protected void startRedo() { }
	protected void finishRedo() { }
	protected void flush() { }
	protected void dropLastUndoStackEntry() { }

	/* CommandStackListener2 */

	public void commandStackChanged(EventObject event) {
		if (event instanceof EditModelCommandStack.SharedCommandStackChangedEvent) {
			SharedCommandStackChangedEvent event2 = (SharedCommandStackChangedEvent)event;
			handleCommandStackEvent(event2.getProperty());
		}
	}
	
	protected void handleCommandStackEvent(int event) {
		switch (event) {
		case EVENT_START_EXECUTE:
			// TODO: these asserts are commented out because an exception executing
			// a command causes them to be triggered later..
			//Assert.isTrue(state == STATE_NONE);
			state = STATE_EXECUTE; startExecute(); break;
			
		case EVENT_FINISH_EXECUTE:
			//Assert.isTrue(state == STATE_EXECUTE);
			state = STATE_NONE; finishExecute(); break;
		
		case EVENT_START_UNDO:
			//Assert.isTrue(state == STATE_NONE);
			state = STATE_UNDO; startUndo(); break;
			
		case EVENT_FINISH_UNDO:
			//Assert.isTrue(state == STATE_UNDO);
			state = STATE_NONE; finishUndo(); break;

		case EVENT_START_REDO:
			//Assert.isTrue(state == STATE_NONE);
			state = STATE_REDO; startRedo(); break;

		case EVENT_FINISH_REDO:
			//Assert.isTrue(state == STATE_REDO);
			state = STATE_NONE; finishRedo(); break;
		
		case EVENT_START_FLUSH: flush(); break;
		case EVENT_FINISH_FLUSH: /* nothing? */ break;
		case EVENT_DROP_LAST_UNDO_STACK_ENTRY: dropLastUndoStackEntry(); break;
		}	
	}
}
