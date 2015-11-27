/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.composite;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.INestableKeyBindingService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.internal.EditorSite;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.registry.EditorDescriptor;

/**
 * TODO: do we really want/need to extend EditorSite or do
 * we want to implement our own like the MultiPageEditor does?
 */
public class EditorInViewSite extends EditorSite {

	protected IViewSite parent;
	protected IKeyBindingService keyBindingService;
	private ISelectionProvider selectionProvider;
	private ISelectionChangedListener selectionChangedListener;

	public EditorInViewSite(IViewSite parent, IEditorReference ref, IEditorPart editor, WorkbenchPage page, EditorDescriptor desc) {
		super(ref, editor, page, desc);
		this.parent = parent;
	}

	/**
	 * Returns a CompositeEditorKeybinding for an embedded editor.
	 */
	@Override
	public IKeyBindingService getKeyBindingService() {
		if (keyBindingService == null) {
			INestableKeyBindingService service = (INestableKeyBindingService) parent.getKeyBindingService();
			keyBindingService = service.getKeyBindingService(this);
		}
		return keyBindingService;
	}

	/**
	 * Activate the key bindings for an embedded editor.
	 */
	public void activate() {
		if (keyBindingService == null) {
			return;
		}
		INestableKeyBindingService service = (INestableKeyBindingService) parent.getKeyBindingService();
		service.activateKeyBindingService(this);
		
		// The workbench only calls updateActiveKeyBindingService() when a workbench part
		// becomes active. We have to explicitly call it since for the
		// workbench the active part has not changed. 
		// TODO: find an alternative in Eclipse 3.0 for the following call:
//		 ((Workbench) getWorkbenchWindow().getWorkbench()).updateActiveKeyBindingService();
		// TODO: I've tried the following lines but they seem to be unnecessary since the key bindings are working.
//		IWorkbench workbench = getWorkbenchWindow().getWorkbench();
//      WorkbenchCommandSupport support = (WorkbenchCommandSupport) workbench.getCommandSupport();
//      support.processHandlerSubmissions(true, workbench.getDisplay().getActiveShell());
	}

	/**
	 * Deactivate the key bindings for an embedded editor.
	 */
	public void deactivate() {
		if (keyBindingService == null) {
			return;
		}
		INestableKeyBindingService service = (INestableKeyBindingService) parent.getKeyBindingService();
		service.activateKeyBindingService(null);
	}

	/**
	 * The <code>CompositeEditorSite</code> implementation of this
	 * <code>IWorkbenchPartSite</code> method remembers the selection provider, 
	 * and also hooks a listener on it, which calls <code>handleSelectionChanged</code> 
	 * when a selection changed event occurs.
	 *
	 * @see #handleSelectionChanged
	 */
	@Override
	public void setSelectionProvider(ISelectionProvider provider) {
		ISelectionProvider oldSelectionProvider = selectionProvider;
		selectionProvider = provider;
		if (oldSelectionProvider != null) {
			oldSelectionProvider.removeSelectionChangedListener(getSelectionChangedListener());
		}
		if (selectionProvider != null) {
			selectionProvider.addSelectionChangedListener(getSelectionChangedListener());
		}
	}

	/**
	 * Returns the selection changed listener which listens to the embedded editor's selection
	 * changes, and calls <code>handleSelectionChanged</code>.
	 *
	 * @return the selection changed listener
	 */
	private ISelectionChangedListener getSelectionChangedListener() {
		if (selectionChangedListener == null) {
			selectionChangedListener = new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					EditorInViewSite.this.handleSelectionChanged(event);
				}
			};
		}
		return selectionChangedListener;
	}

	/**
	 * Handles a selection changed event from the embedded editor.
	 * The default implementation gets the selection provider from the
	 * composite editor's site, and calls <code>fireSelectionChanged</code>
	 * on it (only if it is an instance of <code>CompositeEditorSelectionProvider</code>),
	 * passing a new event object.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 *
	 * @param event the event
	 */
	protected void handleSelectionChanged(SelectionChangedEvent event) {
		ISelectionProvider parentProvider = parent.getSelectionProvider();
		if (parentProvider instanceof CompositeEditorSelectionProvider) {
			SelectionChangedEvent newEvent = new SelectionChangedEvent(parentProvider, event.getSelection());
			((CompositeEditorSelectionProvider) parentProvider).fireSelectionChanged(newEvent);
		}
	}

	@Override
	public ISelectionProvider getSelectionProvider() {
		return selectionProvider;
	}

	/**
	 * @return Returns the parent.
	 */
	public IViewSite getParent() {
		return parent;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.internal.PartSite#dispose()
	 */
	@Override
	public void dispose() {
	   deactivate();
	   super.dispose();
	        
	   setSelectionProvider(null);
	   super.setSelectionProvider(null);
       setPart(null);
	}
}
