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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * Editor input for TextEditor.
 */
@SuppressWarnings("nls")
public class TextEditorInput implements IEditorInput {

	/** body of the document, the initial value */
	String fBody = "";
	
	/** A context object */
	Object fContext;
	
	// expression context
	String fExpressionContext;

	/**
	 * Create a new Text Editor Input. 
	 * @param text
	 * @param eObject
	 * @param expressionContext 
	 */
	
	public TextEditorInput (String text, Object eObject, String expressionContext) {
		setEditorContent (text,eObject,expressionContext);
		
	}

	
	/**
	 * @return return the expression context, represented by this TextEditor input.
	 */
	
	public String getExpressionContext() {
		return fExpressionContext;
	}
	
	/**
	 * Returns the body from this TextEditorInput. This may include the modified editor
	 * body once the editor has notified us that its content has changed.
	 * 
	 * @return the editor's body.
	 */
	
	public String getEditorContent() {
		return fDocument == null ? fBody : fDocument.get() ;		
	}
	
	/**
	 * Set the body on the document.
	 * 
	 * @param text
	 * @param eObject
	 */
	
	public void setEditorContent (String text, Object eObject, String expressionContext) {
		
		fBody = text;
		fContext = eObject;
		fExpressionContext = expressionContext;
		
		if (fDocument != null) {
			fDocument.set(text);
		}
		
	}

	/** 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	
	public boolean exists() {
		return false;
	}

	/**
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	/**
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	public String getName() {
		return null;
	}

	/** 
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	public IPersistableElement getPersistable() {
		return null;
	}

	/**
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	public String getToolTipText() {
		return "XPath Expressions"; //$NON-NLS-1$
	}

	/**
	 * Adapt to the adapter class.
	 * 
	 * The receiver carries the string input to the editor, so if String.class is passed
	 * we just return that.
	 * 
	 * We also hold a context object. If the context object is of the adapter class we 
	 * return it is. The context object can be anything ... in our case we pass the reference 
	 * to the model object that is "closest" to the expression node. 
	 * @param adapter The adapter class to use.
	 * @return the adapted object ...
	 */
	
	
	
	@SuppressWarnings("unchecked")
	public Object getAdapter (Class adapter) {
		
		if (adapter.isInstance(fContext)) {
			return fContext;
		}
				
		if (adapter.isInstance(fBody)) {
			return getEditorContent() ;
		}

		// hack
		if (adapter == Integer.class) {
			return fExpressionContext;
		}

		return null;
	}

	
	IDocument fDocument;
	
	/**
	 * Set the document that this text editor input manages.
	 * 
	 * @param doc
	 */
	
	public void setDocument ( IDocument doc ) {
		fDocument = doc;
	}
	
}
