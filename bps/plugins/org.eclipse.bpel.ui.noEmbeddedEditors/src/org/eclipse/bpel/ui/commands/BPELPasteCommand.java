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
 * This command is used to implement the Paste action for BPEL model objects.
 */
public class BPELPasteCommand extends AutoUndoCommand {

	BPELEditor fBpelEditor;
	
	EObject fTargetObject;
	boolean fReference = false;

	protected List<EObject> fPastedObjects;
	
	
	/**
	 * Brand new shiny paste command.
	 * 
	 * @param bpelEditor the BPEL editor reference.
	 */
	
	public BPELPasteCommand (BPELEditor bpelEditor) {
		// TODO: hack: use process as modelRoot		
		super(bpelEditor.getProcess());		
		this.fBpelEditor = bpelEditor;
	}
	
	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#canDoExecute()
	 */
	@Override
	public boolean canDoExecute() {		
		return fBpelEditor.getTransferBuffer().canCopyTransferBufferTo(fTargetObject,fReference);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		TransferBuffer transferBuffer = fBpelEditor.getTransferBuffer();
		fPastedObjects  = transferBuffer.copyTransferBuffer(fTargetObject, fBpelEditor.getExtensionMap(),fReference );
	}
	
	
	/**
	 * Set the target object to which or around which the paste will happen.
	 * 
	 * @param aTargetObject
	 * @param bReference treat as reference, not potentially as a target (container) itself.
	 */
	
	public void setTargetObject (EObject aTargetObject, boolean bReference) {
		fTargetObject = aTargetObject;
		fReference = bReference;
	}
	
	/**
	 * Return the list of pasted objects.
	 * 
	 * @return the list of pasted objects.
	 */
	
	public List<EObject> getPastedObjects () {
		return fPastedObjects ;
		
	}
}
