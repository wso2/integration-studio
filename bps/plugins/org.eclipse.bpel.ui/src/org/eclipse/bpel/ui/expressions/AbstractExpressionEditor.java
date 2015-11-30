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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.composite.EditorInViewManager;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author IBM Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 16, 2007
 *
 */
public abstract class AbstractExpressionEditor implements IExpressionEditor {

	protected List<Listener> listeners = new ArrayList<Listener>();

	protected EditorInViewManager fManager;

	/** The underlying model object */
	private Object fModelObject;
	
	/** a {@link FormToolkit} to use */
	protected FormToolkit wf;
	
	/** The expression type */
	private String fExprType ;

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.bpel.ui.properties.BPELPropertySection)
	 */
	public void createControls(Composite parent, FormToolkit toolkit) {
		this.wf = toolkit;
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#addListener(org.eclipse.bpel.ui.expressions.IExpressionEditor.Listener)
	 */
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#removeListener(org.eclipse.bpel.ui.expressions.IExpressionEditor.Listener)
	 */

	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	protected void notifyChanged() {
		for (Listener next : listeners) {
			next.notifyChanged();
		}
	}
	
	protected void notifyFocusOut() {
		for (Listener next : listeners) {
			next.focusOut();
		}
	}
	
	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#getEditorContent()
	 * 
	 * 
	 */
	public abstract String getEditorContent() ;

	
	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#setEditorContent(java.lang.String)
	 */
	public abstract void setEditorContent (String body) ;

	
	protected void refresh() {

	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#addExtraStoreCommands(org.eclipse.gef.commands.CompoundCommand)
	 */
	public void addExtraStoreCommands(CompoundCommand compoundCommand) {
		// Default is to do nothing.
	}

	protected IEditorPart createEditor(String editorID, IEditorInput input,
			Composite parent) {
		try {
			return getEditorManager().createEditor(editorID, input, parent);
		} catch (CoreException e) {
			BPELUIPlugin.log(e);
		}
		return null;
	}

	protected EditorInViewManager getEditorManager() {
		if (fManager == null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			IViewPart view = page.findView(IBPELUIConstants.PROPERTY_VIEW_ID);
			try {
				if (view == null) {
					view = page.showView(IBPELUIConstants.PROPERTY_VIEW_ID);
				}
				fManager = new EditorInViewManager(view.getViewSite());
			} catch (PartInitException e) {
				BPELUIPlugin.log(e);
			}
		}
		return fManager;
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#setExpressionType(java.lang.String)
	 */

	public void setExpressionType (String exprType ) {
		this.fExprType = exprType;		
	}

	/**
	 * @see org.eclipse.bpel.ui.expressions.IExpressionEditor#setModelObject(java.lang.Object)
	 */
	public void setModelObject(Object modelObject) {
		this.fModelObject = modelObject;
	}


	protected String getExprType() {
		return fExprType;
	}

	protected Object getModelObject() {
		return fModelObject;
	}

}
