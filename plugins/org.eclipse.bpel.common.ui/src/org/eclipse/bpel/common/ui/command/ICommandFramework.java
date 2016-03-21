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

import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.gef.commands.Command;


/**
 * This interface captures command-related functionality (and other miscellaneous
 * functionality of DetailsArea which is not supported by xtools.common.ui.properties).
 * 
 * It will be a base interface of the old IDetailsArea, and editors porting to the xtools
 * TabbedPropertySheet stuff can also use it directly.
 */
public interface ICommandFramework {

	/**
	 * This is meant to be called by details sections, e.g. in response to
	 * an SWT.Modify event.
	 * 
	 * Notifies the details area that some part of ongoingChange is occurring.
	 * If the currentChange is ongoingChange already, this method has no effect.
	 * Otherwise, the currentChange (if any) is applied and ongoingChange is
	 * set as the new currentChange. 
	 */
	public void notifyChangeInProgress(IOngoingChange ongoingChange);

	/**
	 * This is meant to be called by details sections, e.g. in response to
	 * an SWT.FocusOut event.
	 * 
	 * Notifies the details area that the provider of ongoingChange thinks it
	 * should be ended.  If the currentChange is ongoingChange, it is applied.
	 * 
	 * Otherwise (i.e. if the currentChange is NOT ongoingChange), then
	 * ongoingChange must already be ended, or perhaps it was never started.
	 * In either case, this method has no effect.
	 * 
	 */
	public void notifyChangeDone(IOngoingChange ongoingChange);

	/**
	 * Cause the currentChange, if any, to be applied.  This is meant to be
	 * called by external actions (such as Save) which are not Commands.
	 */
	public void applyCurrentChange();

	/**
	 * Cause the currentChange, if any, to be aborted.  This is meant to be
	 * called by the Undo action.
	 */
	public void abortCurrentChange();

	/**
	 * Executes a Command on the details editor's CommandStack.  Details sections should
	 * use this method rather than calling Command.execute() themselves, so the Command
	 * can participate in the Undo/Redo process.
	 */
	public void execute(Command command);
}