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

import org.eclipse.bpel.ui.BPELMultipageEditorPart;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;


public class RevertAction extends EditorPartAction {

	public RevertAction(IEditorPart editor) {
		super(editor);
	}
	
	@Override
	protected boolean calculateEnabled() {
		// Disable revert for now
		//return getEditorPart().isDirty();
		return false;
	}
	
	@Override
	protected void init(){
		setText(Messages.RevertAction_0); 
		setId(ActionFactory.REVERT.getId());
	}
	
	@Override
	public void run() {
		((BPELMultipageEditorPart)getEditorPart()).doRevertToSaved(new NullProgressMonitor());
		getEditorPart().setFocus();
	}
}