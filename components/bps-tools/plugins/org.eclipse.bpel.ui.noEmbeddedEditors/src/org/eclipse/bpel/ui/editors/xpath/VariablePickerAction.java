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
package org.eclipse.bpel.ui.editors.xpath;

import java.util.ResourceBundle;

import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.VariableTreeContentProvider;
import org.eclipse.bpel.ui.dialogs.ElementTreePreviewSelectionDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;


/**
 * Action for jumping to a particular line in the editor's text viewer.
 * The user is requested to enter the line number into an input dialog.
 * The action is initially associated with a text editor via the constructor,
 * but that can be subsequently changed using <code>setEditor</code>.
 * <p>
 * The following keys, prepended by the given option prefix,
 * are used for retrieving resources from the given bundle:
 * <ul>
 *   <li><code>"dialog.invalid_range"</code> - to indicate an invalid line number</li>
 *   <li><code>"dialog.invalid_input"</code> - to indicate an invalid line number format</li>
 *   <li><code>"dialog.title"</code> - the input dialog's title</li>
 *   <li><code>"dialog.message"</code> - the input dialog's message</li>
 * </ul></p>
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 */
public class VariablePickerAction extends TextEditorAction {


	/** This action's resource bundle */
	private ResourceBundle fBundle;
	/** This action's prefix used for accessing the resource bundle */
	private String fPrefix;

	/**
	 * Creates a new action for the given text editor. The action configures its
	 * visual representation from the given resource bundle.
	 *
	 * @param bundle the resource bundle
	 * @param prefix a prefix to be prepended to the various resource keys
	 *   (described in <code>ResourceAction</code> constructor), or
	 *   <code>null</code> if none
	 * @param editor the text editor
	 * @see TextEditorAction#TextEditorAction(ResourceBundle, String, ITextEditor)
	 */
	public VariablePickerAction (ResourceBundle bundle, String prefix, ITextEditor editor) {
		
		super(bundle, prefix, editor);
		fBundle= bundle;
		fPrefix= prefix;
	}

	/**
	 * @see Action#run()
	 */
	
	@Override
	public void run() {
		ITextEditor editor = getTextEditor();

		if (editor == null) {
			return;
		}

		IDocumentProvider docProvider= editor.getDocumentProvider();
		if (docProvider == null) {
			return;
		}

		IDocument document= docProvider.getDocument(editor.getEditorInput());
		if (document == null) {
			return;
		}
		IEditorInput input = editor.getEditorInput();	
		if (input == null) {
			return ;
		}
				
        VariableTreeContentProvider variableContentProvider = new VariableTreeContentProvider(true, false, false);
        
        ElementTreePreviewSelectionDialog dialog = new ElementTreePreviewSelectionDialog (
        		editor.getSite().getShell(), 
        		new ModelTreeLabelProvider(), 
        		variableContentProvider);
        
        
        String title= fBundle.getString(fPrefix + "dialog.title"); //$NON-NLS-1$
		dialog.setTitle( title );
		dialog.setAllowMultiple(false);
		
		EObject eObj = (EObject) input.getAdapter(EObject.class);
		dialog.setInput( eObj );

		if (dialog.open() == Window.OK) {
			
			TextSelection sel = (TextSelection)editor.getSelectionProvider().getSelection();
			int offset = sel.getOffset();
			int length = sel.getLength();
			
			String result = dialog.getPreviewResult();
			
		   try {
		       document.replace(offset, length, result);
		       editor.selectAndReveal(offset + result.length(), 0);		       
		   }
		   catch (BadLocationException ble) {
			   // ignore ?
		   }				
		}
	}
	
}
