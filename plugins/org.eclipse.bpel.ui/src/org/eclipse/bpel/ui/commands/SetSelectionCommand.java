/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 1, 2007
 *
 */
public class SetSelectionCommand extends AbstractEditModelCommand {

	protected EObject fTarget;
	
	protected boolean fOnUndo = false;
	
	private BPELPasteCommand fPasteCommand;
	
	/**
	 * @param eObj
	 * @param onUndo
	 */
	
	public SetSelectionCommand ( EObject eObj , boolean onUndo) {
		fTarget = eObj;
		fOnUndo = onUndo;
	}
	
	
	/**
	 * Brand new shiny SetSelection command that will select
	 * the result of the last paste operation.
	 * 
	 * @param cmd the paste command.
	 * @param onUndo whether to select on undo
	 */
	
	public SetSelectionCommand ( BPELPasteCommand cmd , boolean onUndo) {
		fPasteCommand = cmd ;
		fOnUndo = onUndo;		
	}
	
	
	protected void select () {
		
		if (fPasteCommand == null) {
			
			BPELEditor editor = ModelHelper.getBPELEditor(fTarget);
			if (editor != null) {
				editor.selectModelObject(fTarget);
			}
			
		} else if (fPasteCommand != null ) {
			
			fPasteCommand.fBpelEditor.getAdaptingSelectionProvider().setSelection( 
					new StructuredSelection( fPasteCommand.getPastedObjects() )  ) ;
			
		}
	}
	
	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		if (fOnUndo == false) {
			select();
		}
		
	}

	
	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if (fOnUndo) {
			select();
		}
	}

	/**
	 * @see org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand#getResources()
	 */
	
	@Override
	public Resource[] getResources() {
		return EMPTY_RESOURCE_ARRAY;
	}
	

}
