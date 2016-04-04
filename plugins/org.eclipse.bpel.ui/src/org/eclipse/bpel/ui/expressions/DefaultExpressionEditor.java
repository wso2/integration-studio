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
package org.eclipse.bpel.ui.expressions;

import org.eclipse.bpel.ui.editors.TextEditor;
import org.eclipse.bpel.ui.editors.TextEditorInput;
import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * When an editor is not found for a given expression language this
 * default editor is used instead.
 * 
 * TODO: reconcile differences between this class and XPathExpressionEditor ?
 */
public class DefaultExpressionEditor extends AbstractExpressionEditor {

	protected Composite editorComposite;
	protected TextEditor editor;
	protected IPropertyListener propertyListener;
	protected String undoRedoLabel;
	protected String fBody;
	protected boolean updating = false;
	protected FocusListener focusListener;
	
	/**
	 * 
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#getEditorContent()
	 */
	
	@Override
	public String getEditorContent() {
		if (editor != null) {
			return editor.getContents();
		}
		return fBody;
	}

	
	/**
	 * 
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.bpel.ui.properties.BPELPropertySection)
	 */
	
	@Override
	public void createControls(Composite parent, FormToolkit toolkit) {
		super.createControls(parent, toolkit);
		createEditor(parent);
	}

	/**
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#setEditorContent(java.lang.String)
	 */
	
	@Override
	public void setEditorContent (String aBody) {
	    this.fBody = aBody;
	    	    
	    try {
	    	updating = true;
	    	
	    	if (editor != null) {
	    		editor.setInput(new TextEditorInput( fBody, getModelObject(), getExprType() ));
	    	}
	    	
	    } finally {
	    	updating = false;
	    }
	}
	
	protected void createEditor(Composite parent) {
		IEditorInput input = new TextEditorInput( fBody, getModelObject(), getExprType() );
		
		
		editorComposite = wf.createComposite(parent, SWT.BORDER);
		editorComposite.setLayout( new FillLayout() );		
		editor = (TextEditor) createEditor(TextEditor.TEXT_EDITOR_ID, 
				input, 
				editorComposite);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#dispose()
	 */
	
	public void dispose() {
		disposeEditor();
	}
	
	protected void disposeEditor() {
		
		if (editor != null) {
			getEditorManager().disposeEditor(editor);
			if (editorComposite != null && !editorComposite.isDisposed()) {				
				editorComposite.dispose();
				editorComposite = null;
			}
			editor = null;
		}
	}

	/**
	 *  About to be Hidden.
	 */
	
	public void aboutToBeHidden() {
		if (editor != null) {
			editor.removePropertyListener(getPropertyListener());
			editor.removeFocusListener(getFocusListener());
		}
	}

	
	/** 
	 * Editor is about to be shown.
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#aboutToBeShown()
	 */
	
	public void aboutToBeShown() {		
		if (editor != null) {
			editor.addPropertyListener(getPropertyListener());
			editor.addFocusListener(getFocusListener());
		}					
	}

	/**
	 * If the editor is dirty it registers an ongoing change.
	 */
	protected IPropertyListener getPropertyListener() {
		
		if (propertyListener == null) {
			propertyListener = new IPropertyListener() {
				public void propertyChanged(Object source, int propId) {
					if (!updating && propId == IEditorPart.PROP_DIRTY && editor.isDirty()) {
						notifyChanged();
					}
				}
			};
		}
		return propertyListener;
	}

	protected FocusListener getFocusListener() {
		if (focusListener == null){
			focusListener = new FocusAdapter(){
			public void focusLost(FocusEvent e) {
				notifyFocusOut();
			}
		};}
		return focusListener;
	}
	
	/**
	 * Get the user context to remember for next invocation.
	 * 
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#getUserContext()
	 */
	public Object getUserContext() {
		return null;
	}

	/**
	 * Restore the user context.
	 * 
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#restoreUserContext(java.lang.Object)
	 */
	
	public void restoreUserContext(Object userContext) {
		editor.setFocus();
	}

	 
	/**
	 * Return the default body for this type of expression. Since the editor is not aware of any syntax
	 * for any particular language, the empty string is returned.
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#getDefaultContent()
	 */
	public String getDefaultContent() {
		return ""; //$NON-NLS-1$
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#gotoTextMarker(org.eclipse.core.resources.IMarker, java.lang.String, java.lang.Object)
	 */
	public void gotoTextMarker(IMarker marker, String codeType, Object modelObject) {
		// TODO: Goto text marker in default text editor.
	}

	
	/** 
	 * Answer true, because a generic text editor will simply do everything.
	 * 
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#supportsExpressionType(java.lang.String)
	 */
	
	public boolean supportsExpressionType( String exprType ) {
		return true;
	}
	
	
	/**
	 * Mark it clean.
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#markAsClean()
	 */
	
	public void markAsClean() {
		if (editor != null) {
			editor.markAsClean();
		}
	}
}
