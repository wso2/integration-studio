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

import org.eclipse.bpel.ui.*;
import org.eclipse.bpel.ui.commands.BPELCopyCommand;
import org.eclipse.bpel.ui.commands.BPELPasteCommand;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.RestoreSelectionCommand;
import org.eclipse.bpel.ui.commands.SetSelectionCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Create a duplicate entry if item in the process map.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 24, 2007
 *
 */
public class BPELDuplicateAction extends BPELCopyAction implements IEditorActionDelegate {

	/**
	 * The action id.
	 */
	
	public static final String ACTION_ID = BPELDuplicateAction.class.getName();
	
	/**
	 * 
	 */
	public BPELDuplicateAction () {
		super(null);
	}
	
	/**
	 * Duplicate selected objects in the editor.
	 * 
	 * @param editorPart
	 */
	public BPELDuplicateAction(IWorkbenchPart editorPart) {
		super(editorPart);
	}

	@SuppressWarnings("nls")
	@Override
	protected void init() {
		super.init();
		setText(Messages.BPELDuplicateAction_Duplicate_1); 
		setToolTipText(Messages.BPELDuplicateAction_Duplicate_2); 
		
		setId(ACTION_ID);
		
		setImageDescriptor( BPELUIPlugin.INSTANCE.getImageDescriptor( IBPELUIConstants.ICON_DUPLICATE_16_E ));
		setDisabledImageDescriptor ( BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_DUPLICATE_16_D  ) );
		setEnabled(false);
	}


	
	/**
	 * @see org.eclipse.bpel.ui.actions.BPELCopyAction#getCommand()
	 */
	@Override
	protected Command getCommand() {
		
		CompoundCommand cmd = new CompoundCommand(Messages.BPELCopyAction_Copy_3); 
		
		final BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();
		
		// 1. Restore selection
		cmd.add(new RestoreSelectionCommand(bpelEditor.getAdaptingSelectionProvider(), true, true));

		// 2. Copy the objects that are selected.
		BPELCopyCommand copyCmd = new BPELCopyCommand(bpelEditor);
		if (fSelection.isEmpty()) {
		  for (Object o : ((IStructuredSelection) bpelEditor.getSelection()).toList()) {
		    if (o instanceof EObject) {
		      fSelection.add((EObject) o);
		    }
		  }
		}
		if (fSelection.isEmpty()) {
		  return null;
		}
		copyCmd.setObjectList( new ArrayList<EObject>(fSelection) );
		cmd.add(copyCmd);
				
		// 3. Immediately paste them
		BPELPasteCommand pasteCmd = new BPELPasteCommand(bpelEditor) {

			/**
			 * We override the canDoExecute, because the compound command in GEF will 
			 * check both of the commands for canDoExecute() before running the compound command.
			 * Since the copy command is a prerequisite for the paste here, this condition will
			 * never be true unless we just allow it.
			 * 
			 * @see org.eclipse.bpel.ui.commands.BPELPasteCommand#canDoExecute()
			 */
			@Override
			public boolean canDoExecute() {
				return true;
			}
			
		};
		pasteCmd.setTargetObject( fSelection.get(0) , true );
		cmd.add(pasteCmd);
		
		// 4. Add the command to select the pasted elements		
		cmd.add( new SetSelectionCommand(pasteCmd,false) );		
		
		return cmd;
	}


	/**
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction, org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor (IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof BPELMultipageEditorPart) {
		  targetEditor = ((BPELMultipageEditorPart) targetEditor).getActiveEditor();
		}
		if (!(targetEditor instanceof BPELEditor)) {
      targetEditor = null;
		}
		setWorkbenchPart(targetEditor);
		if (targetEditor == null) {
		  action.setEnabled(false);
		}
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run (IAction action) {			
		run();		
	}

	
	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged (IAction action, ISelection selection) {
		setSelection(selection);
	}

	
}
