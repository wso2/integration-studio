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
package org.eclipse.bpel.examples.extensionpoints.expression.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

/**
 * Text editor for IText objects.
 */

@SuppressWarnings("nls")
public class SimpleTextEditor extends AbstractDecoratedTextEditor {

	/** The Editor ID */
	public static final String TEXT_EDITOR_ID = "org.eclipse.bpel.examples.extensionPoints.textEditor";

	/**
	 * 
	 */
	public SimpleTextEditor() {
		super();
		setDocumentProvider(new TextDocumentProvider());
		
	}

	/**
	 * Remove unnecessary actions.
	 */
	@Override
	protected void createActions() {
		super.createActions();
		setAction(ITextEditorActionConstants.PRINT, null);
		setAction(ITextEditorActionConstants.SAVE, null);
		setAction(ITextEditorActionConstants.REVERT_TO_SAVED, null);
	}

	/**
	 * Returns the current contents of this editor.
	 * @return the contents of the editor
	 */
	
	public String getContents() {
		IEditorInput input = getEditorInput();
		IDocument doc = getDocumentProvider().getDocument(input);
		return doc.get();
	}

	/**
	 * Removes the dirty state.
	 */
	public void markAsClean() {
		// this is almost a no-op
		doSave(null);
	}
	
	
	@Override
	protected boolean isOverviewRulerVisible() {    	
	   	return false;
	}

}