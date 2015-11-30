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
package org.eclipse.bpel.common.ui.command;

import java.util.EventObject;

import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack;
import org.eclipse.bpel.common.ui.editmodel.PlaceHolderCommand;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack.SharedCommandStackChangedEvent;
import org.eclipse.bpel.common.ui.editmodel.EditModelCommandStack.SharedCommandStackListener;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;


/**
 * Support for using IOngoingChange with the EditModel framework.
 */
public class EditModelCommandFramework implements ICommandFramework {

	IOngoingChange fCurrentChange;
	
	CommandStack fCommandStack;
	
	boolean fIgnoreEvents = false;
	
	/**
	 * @param editModelCommandStack
	 */
	
	public EditModelCommandFramework (EditModelCommandStack editModelCommandStack) {
		
		fCommandStack = editModelCommandStack;
		
		editModelCommandStack.addCommandStackListener(new CommandStackListener() {
			
			public void commandStackChanged(EventObject event) {
				
				if (fIgnoreEvents || event instanceof SharedCommandStackChangedEvent == false) {
					return;
				}

				/** 
				 * The most important thing to consider here is that we may have pending 
				 * change through the ChangeHelper mechanism being played on the the stack.
				 * If we are about to execute a new command or undo the last command, we 
				 * have to apply any current change (that is execute the new command) before
				 * either execute or undo is called.
				 */
				SharedCommandStackChangedEvent e = (SharedCommandStackChangedEvent) event;
				
				/**
				 * The use case here is that we are about to run a command on the stack and 
				 * have some pending changes to do. We have to finish the current change first.
				 * 
				 */
				if (e.getProperty() == SharedCommandStackListener.EVENT_START_EXECUTE) {
					applyCurrentChange();
				} 
				
				
				/** 
				 * The use case for applying the currently pending edit is simply that a 
				 * pending edit may not be applied but an undo is called. 
				 * In this case, we have to apply the pending command, then undo it.
				 * 
				 */
				
				if(e.getProperty() == SharedCommandStackListener.EVENT_START_UNDO) {
					applyCurrentChange();
				}
				
				// FIXME: what about redo?
				
			}
		});
		
	}
	
	/**
	 * Forward these to the implementation.
	 * 
	 * @see org.eclipse.bpel.common.ui.command.ICommandFramework#abortCurrentChange()
	 */
	public void abortCurrentChange() {
		finishCurrentChange(true);
	}
	
	/**
	 * @see org.eclipse.bpel.common.ui.command.ICommandFramework#applyCurrentChange()
	 */
	
	public void applyCurrentChange() {
		finishCurrentChange(false);
	}
	
	/**
	 * @see org.eclipse.bpel.common.ui.command.ICommandFramework#notifyChangeInProgress(org.eclipse.bpel.common.ui.details.IOngoingChange)
	 */
	public void notifyChangeInProgress(IOngoingChange ongoingChange) {
		
		if (fCurrentChange != ongoingChange) {
			applyCurrentChange();
			
			if (fCommandStack.getUndoCommand() instanceof PlaceHolderCommand) {
				throw new IllegalStateException();
			}
			
			PlaceHolderCommand placeholderCommand = new PlaceHolderCommand(ongoingChange.getLabel());
			
			fIgnoreEvents = true;
			try {
				fCommandStack.execute(placeholderCommand);
			} finally {
				fIgnoreEvents = false;
			}
			
			fCurrentChange = ongoingChange;
		}
	}
	
	/**
	 * @see org.eclipse.bpel.common.ui.command.ICommandFramework#notifyChangeDone(org.eclipse.bpel.common.ui.details.IOngoingChange)
	 */
	
	public void notifyChangeDone(IOngoingChange ongoingChange) {
		if (fCurrentChange == ongoingChange) {
			applyCurrentChange();
		}
	}
	
	/**
	 * @see org.eclipse.bpel.common.ui.command.ICommandFramework#execute(org.eclipse.gef.commands.Command)
	 */
	public void execute(Command command) {
		fCommandStack.execute(command);
	}
	
	protected void finishCurrentChange(boolean changeUndone) {
		
		if (fCurrentChange == null) {
			return;
		}
		
		IOngoingChange change = fCurrentChange;
		
		// Null out the current change. This is important !!
		fCurrentChange = null;
		
		// Make sure there's a placeholder on the stack.
		if (fIgnoreEvents) {
			throw new IllegalStateException();
		}
		
		if (!(fCommandStack.getUndoCommand() instanceof PlaceHolderCommand)) {
			throw new IllegalStateException();
		}
		
		fIgnoreEvents = true;
		try {
			fCommandStack.undo(); // Remove placeholder.
		} finally {
			fIgnoreEvents = false;
		}
		
		Command cmd = change.createApplyCommand();
		if (cmd != null) {
			cmd.setLabel(change.getLabel());
			if (changeUndone) {
				change.restoreOldState();
			} else {
				// TODO: if the command is not actually executable, should we call
				// restoreOldState() instead?  I'm inclined not to because we've been
				// using !canExecute() to elide no-op commands.  But maybe we should
				// rethink that (especially since IOngoingChange makes it much less
				// common, and maybe confusing, to elide a command in that way?).

				// TODO: above comment is obsolete.  Now that no-ops are handled in
				// a different way by EditModelCommandStack, we should consider calling
				// restoreOldState() if canExecute() fails.
				fCommandStack.execute(cmd);
			}
		} else {
			change.restoreOldState();
		}
	}
}
