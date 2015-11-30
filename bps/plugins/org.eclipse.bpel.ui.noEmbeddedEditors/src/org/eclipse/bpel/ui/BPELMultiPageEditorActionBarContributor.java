/*******************************************************************************
 * Copyright (c) 2008, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oleg Danilov, Intel - Initial API and Implementation
 *
 *******************************************************************************/

package org.eclipse.bpel.ui;

import org.eclipse.bpel.ui.actions.BPELCopyAction;
import org.eclipse.bpel.ui.actions.BPELCutAction;
import org.eclipse.bpel.ui.actions.BPELDeleteAction;
import org.eclipse.bpel.ui.actions.BPELPasteAction;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

/**
 * Manages the installation/deinstallation of global actions for multi-page
 * editors. Responsible for the redirection of global actions to the active
 * editor. Multi-page contributor replaces the contributors for the individual
 * editors in the multi-page editor.
 */
public class BPELMultiPageEditorActionBarContributor extends
		MultiPageEditorActionBarContributor {

	private IEditorPart activeEditorPart;
	private BPELEditor bpelEditor;

	/**
	 * Creates a multi-page contributor.
	 */
	public BPELMultiPageEditorActionBarContributor() {
		super();
	}

	/**
	 * Returns the action registered with the given text editor.
	 * 
	 * @return IAction or null if editor is null.
	 */
	protected IAction getAction(ITextEditor editor, String actionID) {
		return (editor == null ? null : editor.getAction(actionID));
	}

	/*
	 * (non-JavaDoc) Method declared in
	 * AbstractMultiPageEditorActionBarContributor.
	 */

	@Override
	public void setActivePage(IEditorPart part) {
		if (activeEditorPart == part)
			return;

		activeEditorPart = part;

		IActionBars actionBars = getActionBars();

		if (activeEditorPart != null && activeEditorPart instanceof ITextEditor) {
			IActionBars siteActionBars = ((IEditorSite)activeEditorPart.getEditorSite()).getActionBars();
			siteActionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO, getAction((ITextEditor)activeEditorPart, ITextEditorActionConstants.UNDO));
			siteActionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO, getAction((ITextEditor)activeEditorPart, ITextEditorActionConstants.REDO));
			siteActionBars.updateActionBars();              
		} else {
			if (part instanceof BPELEditor) {
				bpelEditor = (BPELEditor) part;
			}
			if (bpelEditor != null) {
				Object adapter = bpelEditor.getAdapter(ActionRegistry.class);
				if (adapter instanceof ActionRegistry) {
					ActionRegistry registry = (ActionRegistry) adapter;
					// COPY
					IAction action = registry.getAction(BPELCopyAction.ID);
					actionBars.setGlobalActionHandler(ActionFactory.COPY
							.getId(), action);
					// CUT
					action = registry.getAction(BPELCutAction.ID);
					actionBars.setGlobalActionHandler(
							ActionFactory.CUT.getId(), action);
					// PASTE
					action = registry.getAction(BPELPasteAction.ID);
					actionBars.setGlobalActionHandler(ActionFactory.PASTE
							.getId(), action);
					// DELETE
					action = registry.getAction(BPELDeleteAction.ID);
					actionBars.setGlobalActionHandler(ActionFactory.DELETE
							.getId(), action);
				}
				
				IWorkbenchPartSite site = bpelEditor.getSite();
		        if (site instanceof IEditorSite) 
		        {
		          ITextEditor textEditor = bpelEditor.getMultipageEditor().getTextEditor();
		          IActionBars siteActionBars = ((IEditorSite) site).getActionBars();
		          siteActionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO, getAction(textEditor, ITextEditorActionConstants.UNDO));
		          siteActionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO, getAction(textEditor, ITextEditorActionConstants.REDO));
		          siteActionBars.updateActionBars();              
		        }       
			}
		}

		if (actionBars != null) {
			// update menu bar and tool bar
			actionBars.updateActionBars();
		}

	}
}
