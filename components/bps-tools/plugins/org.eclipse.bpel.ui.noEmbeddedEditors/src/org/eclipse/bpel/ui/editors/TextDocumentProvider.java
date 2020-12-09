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
package org.eclipse.bpel.ui.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.AbstractDocumentProvider;

/**
 * Document provider for TextEditor.
 */
public class TextDocumentProvider extends AbstractDocumentProvider {

	@Override
	protected IDocument createDocument (Object element) {
		
		if (element instanceof TextEditorInput) {
			
			TextEditorInput input = (TextEditorInput) element;
			Document doc = new Document( input.getEditorContent() );
			input.setDocument ( doc );
			
			return doc;
		}		
		return null;
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) {
		return null;
	}

	/**
	 * Does not do anything. For this editor we do not have a save concept. All the changes
	 * are stored in a certain model object and saved in a model file.
	 * 
	 */
	
	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) {
		
	}

	/**
	 * @see org.eclipse.ui.texteditor.AbstractDocumentProvider#isReadOnly(java.lang.Object)
	 */
	@Override
	public boolean isReadOnly(Object element) {
		return false;
	}

	
	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractDocumentProvider#isModifiable(java.lang.Object)
	 */
	@Override
	public boolean isModifiable(Object element) {
		return true;
	}

	
	@Override
	protected IRunnableContext getOperationRunner (IProgressMonitor monitor) {
		// TODO: Need to implement for 6.0
		return null;
	}
}
