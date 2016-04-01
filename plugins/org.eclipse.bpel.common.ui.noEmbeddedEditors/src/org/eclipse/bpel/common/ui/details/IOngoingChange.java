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
package org.eclipse.bpel.common.ui.details;

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.gef.commands.Command;

/**
 * Represents an ongoing change in the widget(s) of the details section.
 * 
 * Details sections should notify the details area of the ongoing change
 * by calling <code>detailsArea.notifyChangeInProgress()</code>.  They
 * should notify the details area that they think the change must be ended
 * with <code>detailsArea.notifyChangeDone()</code>.  They are not required
 * to know if the change is actually in progress when they call
 * <code>notifyChangeDone()</code>; spurious calls are ignored.
 * 
 * Typically they would call <code>notifyChangeInProgress()</code> when they
 * receive an <code>SWT.Modify</code> or <code>SWT.Selection</code> event 
 * (depending on the type of widget) and call <code>notifyChangeDone()</code>
 * from an <code>SWT.FocusOut<code> listener.
 * 
 * @see ICommandFramework#notifyChangeInProgress
 * @see ICommandFramework#notifyChangeDone
 */
public interface IOngoingChange {

	/**
	 * Returns a label which describes the type of change occurring.
	 * This is used to describe the change in Undo menu items, etc.
	 * After the change is completed, this label will also be used
	 * to describe the Command which did the work for the change.  
	 */
	public String getLabel();

	/**
	 * Called by the details area when this change is ended.
	 * 
	 * If the current state of the widget(s) is valid, this method should
	 * construct a Command which will apply the change to the model, and
	 * return it, otherwise it should return null.
	 * 
	 * If createApplyCommand() returns null, OR if createApplyCommand() returns
	 * a Command which will not immediately be executed, the restoreOldState()
	 * method will be called, giving clients a chance to restore the contents
	 * of their widgets.
	 */
	public Command createApplyCommand();

	/**
	 * Called by the details area in either of two situations:
	 *   (1) createApplyCommand() was just called and it returned null.
	 *   (2) createApplyCommand() was called and it returned a Command, but the
	 *     Command will not be immediately executed.
	 * 
	 * Most clients would normally update their widgets as a side effect
	 * of the Command returned from createApplyCommand() being executed (i.e.
	 * because this fires a listener on something modified by the Command).
	 * 
	 * Those clients should refresh their widgets in their implementation of
	 * this method, since it is called in exactly the situations where the
	 * update won't be accomplished by the execution of a Command.  
	 */
	public void restoreOldState();
}
