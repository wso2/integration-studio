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
package org.eclipse.bpel.ui.commands;

import java.util.List;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.TransferBuffer;
import org.eclipse.emf.ecore.EObject;


/**
 * This command is used to implement the Cut and Copy actions for BPEL model objects.
 */
public class BPELCopyCommand extends AutoUndoCommand {

	TransferBuffer.Contents undo, redo;
	BPELEditor fBpelEditor;
	
	List<EObject> fOriginalObjects;
	
	/**
	 * Brand new shiny copy command.
	 * 
	 * @param bpelEditor
	 */
	
	public BPELCopyCommand (BPELEditor bpelEditor) {
		// TODO: hack: use process as modelRoot
		super(bpelEditor.getProcess());
		this.fBpelEditor = bpelEditor;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#canDoExecute()
	 */
	@Override
	public boolean canDoExecute() {
		return fOriginalObjects != null && fOriginalObjects.size() > 0;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		TransferBuffer transferBuffer = fBpelEditor.getTransferBuffer();
		undo = transferBuffer.getContents();
		transferBuffer.copyObjectsToTransferBuffer(fOriginalObjects, fBpelEditor.getExtensionMap());
		redo = transferBuffer.getContents();
	}
	
	/**
	 * Set the list of objects to copy.
	 * 
	 * @param copyList the list of objects to copy.
	 */
	
	public void setObjectList(List<EObject> copyList) {
		this.fOriginalObjects = copyList;
	}
}
