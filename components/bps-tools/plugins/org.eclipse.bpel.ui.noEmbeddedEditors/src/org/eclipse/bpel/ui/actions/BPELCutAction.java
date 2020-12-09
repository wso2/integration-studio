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

import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.BPELCopyCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.DeleteChildCommand;
import org.eclipse.bpel.ui.commands.DeleteLinkCommand;
import org.eclipse.bpel.ui.commands.RestoreSelectionCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 1, 2007
 *
 */
public class BPELCutAction extends BPELDeleteAction {

	public final static String ID = "BPELCutAction";  //$NON-NLS-1$

	/**
	 * @param editorPart
	 */
	public BPELCutAction(IWorkbenchPart editorPart) {
		super(editorPart);
	}

	@Override
	protected void init() {
		super.init();

		setText(Messages.BPELCutAction_Cut_1);
		setToolTipText(Messages.BPELCutAction_Cut_2);
		setId(ID);
		setImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_CUT ));
		setDisabledImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_CUT_DISABLED ));
		setEnabled(false);
	}

	@Override
	protected Command getCommand () {

		if (this.fSelection.isEmpty()) {
			return null ;
		}

		final BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();

		CompoundCommand cmd = new CompoundCommand(Messages.BPELCutAction_Cut_3);

		// 1. Restore selection on undo/redo
		cmd.add(new RestoreSelectionCommand(bpelEditor.getAdaptingSelectionProvider(), true, true));

		// 2. Actually copy the elements.
		BPELCopyCommand copyCmd = new BPELCopyCommand(  (BPELEditor)getWorkbenchPart() );
		copyCmd.setObjectList( new ArrayList<EObject> ( this.fSelection ) ) ;
		cmd.add(copyCmd);


//		// workaround: deselect all the objects first,
//		// avoiding the untimely notification which leads to an NPE.
//		// TODO: is this still needed?  might not be, with batched adapters
//		cmd.add(new AbstractEditModelCommand() {
//			public void execute() { bpelEditor.getAdaptingSelectionProvider().setSelection(StructuredSelection.EMPTY); }
//			public Resource[] getResources() { return EMPTY_RESOURCE_ARRAY; }
//			public Resource[] getModifiedResources() { return EMPTY_RESOURCE_ARRAY; }
//		});
//
//
		// 3. The delete commands
		for(EObject next : this.fSelection) {
			if (next instanceof Link) {
				cmd.add(new DeleteLinkCommand((Link)next));
			} else {
				cmd.add(new DeleteChildCommand(next));
			}
		}

		return cmd;
	}

}
