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
package org.eclipse.bpel.ui.commands.util;

import java.util.List;

public interface IAutoUndoRecorder {

	// These methods are used by AutoUndoCommandStack and AutoUndoCompoundCommand.
	
	public void startChanges(List<Object> modelRoots);
	
	public List<Object> finishChanges();
	
	public void addModelRoots(List<Object> modelRoots);
	
	public void insertUndoHandler(IUndoHandler undoHandler);
	
	/**
	 * Is the recorder currently recording changes.
	 * @return true if yes, false if no
	 */
	public boolean isRecordingChanges();
	
	// These methods are used by AutoUndoCommand.
	
	/**
	 * Undo the list of changes. The changes list consists of IUndoHandler and Notification objects.
	 * 
	 * @param changes
	 */
	public void undo(List<Object> changes);
	
	/**
	 * Redo the list of changes. The changes list consists of IUndoHandler and Notification objects.
	 * 
	 * @param changes
	 */
	
	public void redo(List<Object> changes);	
}
