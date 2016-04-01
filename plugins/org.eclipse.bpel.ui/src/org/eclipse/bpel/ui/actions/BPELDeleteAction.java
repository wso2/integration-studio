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

/*******************************************************************************
 * A newer version of DeleteAction
 *
 * This version customizes the selection behavior after the delete has happened
 * For example, we want to select a sibling after a particular object has been
 * deleted as a usability enhancement.
 *
 * This version customizes the label behavior of the DeleteAction.
 *
 *******************************************************************************/

import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.DeleteChildCommand;
import org.eclipse.bpel.ui.commands.DeleteLinkCommand;
import org.eclipse.bpel.ui.commands.RestoreSelectionCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * An action to delete selected objects.
 */
public class BPELDeleteAction extends EditAction {

	public final static String ID = "BPELDeleteAction";  //$NON-NLS-1$

	/**
	 * Brand new Delete Action.
	 * @param editor
	 */

	public BPELDeleteAction(IWorkbenchPart editor) {
		super(editor);
	}

	/**
	 * Brand new DeleteAction.
	 *
	 * @param editor
	 * @param label
	 */

	public BPELDeleteAction(IWorkbenchPart editor, String label) {
		super(editor);
		setText(label);
	}

	@Override
	protected void init() {
		super.init();
		setText(Messages.DeleteSelectedAction_Delete_1);
		setToolTipText(Messages.DeleteSelectedAction_Delete_2);
		setId(ID);
		setImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_DELETE ));
		setDisabledImageDescriptor( PlatformUI.getWorkbench().getSharedImages().getImageDescriptor( ISharedImages.IMG_TOOL_DELETE_DISABLED ));
		setEnabled(false);
	}


	@SuppressWarnings("boxing")
	@Override
	protected Command getCommand () {

		if (this.fSelection.isEmpty()) {
			return null ;
		}

		final BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();

		CompoundCommand cmd = new CompoundCommand(Messages.DeleteSelectedAction_Delete_3);

		// 1. Restore selection on undo/redo
		cmd.add(new RestoreSelectionCommand(bpelEditor.getAdaptingSelectionProvider(), true, true));

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

		// 2. The delete commands.
		 for(EObject next : this.fSelection) {

			if (next instanceof Link) {
				cmd.add(new DeleteLinkCommand((Link)next));
			} else {
				cmd.add(new DeleteChildCommand(next));
			}
		}

		int count = this.fSelection.size();

		// override default label
		if (count == 1) {
			cmd.setLabel(cmd.getLabel());
		} else if (count > 1) {
			cmd.setLabel(NLS.bind(Messages.DeleteSelectedAction_Delete_Items_3, count));
		} else {
			// commandCount is 0
			return UnexecutableCommand.INSTANCE;
		}
		return cmd;
	}


	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		this.fSelection = trimSelection (this.fSelection);

		Command cmd = getCommand();
		if (cmd == null) {
			return ;
		}

		EObject modelObject = this.fSelection.get(0);

		EObject parent = modelObject.eContainer();
		Object  sibling = null;
		IContainer<EObject> container = BPELUtil.adapt(parent, IContainer.class);
		if (container != null) {
			sibling = container.getNextSiblingChild(parent, modelObject);
		}

		execute( cmd );

		BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();

		// TODO: make sure setFocus() hack makes it into RestoreSelectionCommand
		bpelEditor.setFocus();
		if (sibling == null) {
			bpelEditor.getAdaptingSelectionProvider().setSelection(StructuredSelection.EMPTY);
		} else {
			bpelEditor.getAdaptingSelectionProvider().setSelection(new StructuredSelection(sibling));
		}
	}

}
