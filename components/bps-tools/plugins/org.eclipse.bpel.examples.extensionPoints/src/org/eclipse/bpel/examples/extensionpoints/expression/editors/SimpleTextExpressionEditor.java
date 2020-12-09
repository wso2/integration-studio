/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.examples.extensionpoints.expression.editors;


import org.eclipse.bpel.ui.expressions.AbstractExpressionEditor;
import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Simple text editor used as an expression editor.
 * 
 * This example shows the use of the eclipse default text editor as an expression
 * editor for the expression language set in the extension point.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 17, 2007
 */

@SuppressWarnings("nls")
public class SimpleTextExpressionEditor extends AbstractExpressionEditor {

	protected Composite fEditorComposite;
	protected IEditorPart fEditorPart;
	protected IPropertyListener fPropertyListener;	
	protected String fBody = "";
	protected boolean updating = false;
	protected TextEditorInput fInput;
	
	/**
	 * 
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#getEditorContent()
	 */
	
	@Override
	public String getEditorContent() {
		if (fEditorPart != null) {		
			return (String) fEditorPart.getEditorInput().getAdapter(String.class);			
		}
		return fBody;
	}

	
	protected String getTextEditorId () {
		return SimpleTextEditor.TEXT_EDITOR_ID;
	}
	
	/**
	 * 
	 * @see org.eclipse.bpel.ui.expressions.AbstractExpressionEditor#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.bpel.ui.properties.BPELPropertySection)
	 */
	
	@Override
	public void createControls (Composite parent, FormToolkit toolkit) {
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
	    	
	    	if (fInput != null) {	    		
	    		fInput.setEditorContent( fBody, getModelObject(), getExprType() );
	    	}
	    	
	    } finally {
	    	updating = false;
	    }
	}
	
	@SuppressWarnings("nls")
	
	protected void createEditor (Composite parent) {
	
		fInput = new TextEditorInput( fBody, getModelObject(), getExprType() );
		
		fEditorComposite = wf.createComposite(parent, SWT.BORDER);
		fEditorComposite.setLayout( new FillLayout() );	
		
		fEditorPart = createEditor(	getTextEditorId() ,	fInput,	fEditorComposite );
	}

	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#dispose()
	 */
	
	public void dispose() {
		disposeEditor();
	}
	
	protected void disposeEditor() {
		
		if (fEditorPart != null) {
			getEditorManager().disposeEditor(fEditorPart);
			if (fEditorComposite != null && !fEditorComposite.isDisposed()) {				
				fEditorComposite.dispose();
				fEditorComposite = null;
			}
			fEditorPart = null;
		}
	}

	/**
	 *  About to be Hidden.
	 */
	
	public void aboutToBeHidden() {
		if (fEditorPart != null) {
			fEditorPart.removePropertyListener(getPropertyListener());
		}
	}

	
	/** 
	 * Editor is about to be shown.
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#aboutToBeShown()
	 */
	
	public void aboutToBeShown() {		
		if (fEditorPart != null) {
			fEditorPart.addPropertyListener(getPropertyListener());
		}					
	}

	/**
	 * If the editor is dirty it registers an ongoing change.
	 */
	protected IPropertyListener getPropertyListener() {
		
		if (fPropertyListener == null) {
			fPropertyListener = new IPropertyListener() {
				@SuppressWarnings("synthetic-access")
				public void propertyChanged(Object source, int propId) {
					if (!updating && propId == IEditorPart.PROP_DIRTY && fEditorPart.isDirty()) { 
						notifyChanged();
					}
				}
			};
		}
		return fPropertyListener;
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
		fEditorPart.setFocus();
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
		if (fEditorPart != null) {
			fEditorPart.doSave(null);			
		}
	}
	

}
