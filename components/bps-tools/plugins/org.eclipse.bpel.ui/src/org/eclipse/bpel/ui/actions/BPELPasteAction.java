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
package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.BPELPasteCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.RestoreSelectionCommand;
import org.eclipse.bpel.ui.commands.SetSelectionCommand;
import org.eclipse.bpel.ui.util.TransferBuffer;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @author IBM, Original Contribution.
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 4, 2007
 *
 */
public class BPELPasteAction extends EditAction {

	public final static String ID = "BPELPasteAction";  //$NON-NLS-1$

	/**
	 * Brand new BPELPaste action.
	 * @param editorPart
	 */
	public BPELPasteAction(IWorkbenchPart editorPart) {
		super(editorPart);
	}

	@Override
	protected void init() {
		super.init();
		setText(Messages.BPELPasteAction_Paste_1);
		setToolTipText(Messages.BPELPasteAction_Paste_2);
		setId(ID);
		setImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(	ISharedImages.IMG_TOOL_PASTE ));
		setDisabledImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_PASTE_DISABLED ));
		setEnabled(false);
	}


	/**
	 * @see org.eclipse.bpel.ui.actions.EditAction#getCommand()
	 */

	@Override
	protected Command getCommand() {

		CompoundCommand cmd = new CompoundCommand(Messages.BPELPasteAction_Paste_3);

		final BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();

		// 1. Restore selection
		cmd.add(new RestoreSelectionCommand(bpelEditor.getAdaptingSelectionProvider(), true, true));

		// 2. Paste Command
		BPELPasteCommand cmdPaste = new BPELPasteCommand(bpelEditor);
		cmdPaste.setTargetObject( this.fSelection.get(0) , false );
		cmd.add(cmdPaste);

		// 3. Add the command to select the pasted elements
		cmd.add( new SetSelectionCommand(cmdPaste,false) );

		return cmd;
	}


	@Override
	protected boolean calculateEnabled() {

		boolean bEnabled = super.calculateEnabled() && this.fSelection.size() == 1;

		if (!bEnabled) {
			return bEnabled;
		}

		BPELEditor bpelEditor = (BPELEditor)getWorkbenchPart();
		TransferBuffer tb = bpelEditor.getTransferBuffer();

		if (tb == null) {
			return false;
		}

		return tb.canCopyTransferBufferTo( this.fSelection.get(0) , false );
	}




}
