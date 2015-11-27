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

import java.util.ArrayList;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.BPELCopyCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.RestoreSelectionCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


/**
 * @author IBM Original Contribution
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 4, 2007
 *
 */
public class BPELCopyAction extends EditAction {

	public final static String ID = "BPELCopyAction";  //$NON-NLS-1$

	/**
	 * Brand new shiny copy action.
	 *
	 * @param editorPart
	 */
	public BPELCopyAction(IWorkbenchPart editorPart) {
		super(editorPart);
	}


	@Override
	protected void init() {
		super.init();
		setText(Messages.BPELCopyAction_Copy_1);
		setToolTipText(Messages.BPELCopyAction_Copy_2);
		setId(ID);
		setImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_COPY ));
		setDisabledImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_COPY_DISABLED ));
		setEnabled(false);
	}


	/**
	 * @see org.eclipse.bpel.ui.actions.EditAction#getCommand()
	 */
	@Override
	protected Command getCommand() {

		CompoundCommand cmd = new CompoundCommand(Messages.BPELCopyAction_Copy_3);

		final BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();

		// 1. Restore selection
		cmd.add(new RestoreSelectionCommand(bpelEditor.getAdaptingSelectionProvider(), true, true));

		// 2. Copy the selected objects
		BPELCopyCommand copyCmd = new BPELCopyCommand(bpelEditor);
		copyCmd.setObjectList( new ArrayList<EObject>(this.fSelection) );
		cmd.add(copyCmd);


		return cmd;
	}


}
