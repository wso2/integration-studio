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

import org.eclipse.ui.IEditorPart;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.util.ListenerList;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.*;

public class CompositeEditorSelectionProvider implements ISelectionProvider {

	/**
	 * Registered selection changed listeners (element type: 
	 * <code>ISelectionChangedListener</code>).
	 */
	private ListenerList listeners = new ListenerList();

	/**
	 * The composite editor.
	 */
	private CompositeEditor compositeEditor;

/**
 * Creates a selection provider for the given composite editor.
 *
 * @param compositeEditor the composite editor
 */
public CompositeEditorSelectionProvider(CompositeEditor compositeEditor) {
	Assert.isNotNull(compositeEditor);
	this.compositeEditor = compositeEditor;
}

/* (non-Javadoc)
 * Method declared on <code>ISelectionProvider</code>.
 */
public void addSelectionChangedListener(ISelectionChangedListener listener) {
	listeners.add(listener);
}

/**
 * Notifies all registered selection changed listeners that the editor's 
 * selection has changed. Only listeners registered at the time this method is
 * called are notified.
 *
 * @param event the selection changed event
 */
public void fireSelectionChanged(final SelectionChangedEvent event) {
	Object[] listeners = this.listeners.getListeners();
	for (int i = 0; i < listeners.length; ++i) {
		final ISelectionChangedListener l = (ISelectionChangedListener)listeners[i];
		
		SafeRunnable.run(new SafeRunnable() {
			public void run() {
				l.selectionChanged(event);
			}
			@Override
			public void handleException(Throwable e) {
				super.handleException(e);
				//If an unexpected exception happens, remove it
				//to make sure the workbench keeps running.
				removeSelectionChangedListener(l);
			}
		});		
	}
}

/* (non-Javadoc)
 * Method declared on <code>ISelectionProvider</code>.
 */
public ISelection getSelection() {
	IEditorPart activeEditor = compositeEditor.getActiveEditor();
	if (activeEditor != null) {
		ISelectionProvider selectionProvider = activeEditor.getSite().getSelectionProvider();
		if (selectionProvider != null)
			return selectionProvider.getSelection();
	}
	return null;
}

/* (non-JavaDoc)
 * Method declaed on <code>ISelectionProvider</code>.
 */
public void removeSelectionChangedListener(ISelectionChangedListener listener) {
	listeners.remove(listener);
}

/* (non-Javadoc)
 * Method declared on <code>ISelectionProvider</code>.
 */
public void setSelection(ISelection selection) {
	IEditorPart activeEditor = compositeEditor.getActiveEditor();
	if (activeEditor != null) {
		ISelectionProvider selectionProvider = activeEditor.getSite().getSelectionProvider();
		if (selectionProvider != null)
			selectionProvider.setSelection(selection);
	}
}
}
