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

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * Workaround for instantiating an EditorPart. 
 */
/* package */ class EditorReference implements IEditorReference {
	public String getFactoryId() {
		return null;
	}
	public String getName() {
		return null;
	}
	public IEditorPart getEditor(boolean restore) {
		return null;
	}
	public boolean isPinned() {
		return false;
	}
	public IWorkbenchPart getPart(boolean restore) {
		return null;
	}
	public IWorkbenchPage getPage() {
		return null;
	}
	public boolean isDirty() {
		return false;
	}
	public String getTitle() {
		return null;
	}
	public Image getTitleImage() {
		return null;
	}
	public String getTitleToolTip() {
		return null;
	}
	public String getId() {
		return null;
	}
	public void addPropertyListener(IPropertyListener listener) {
	}
	public void removePropertyListener(IPropertyListener listener) {
	}
	public String getPartName() {
		return null;
	}
	public String getContentDescription() {
		return null;
	}
	// WDG:
	public IEditorInput getEditorInput() throws PartInitException {
		return null;
	}
	
	/**
	 * @see org.eclipse.ui.IWorkbenchPartReference#addPartPropertyListener(org.eclipse.jface.util.IPropertyChangeListener)
	 */
	public void addPartPropertyListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see org.eclipse.ui.IWorkbenchPartReference#getPartProperty(java.lang.String)
	 */
	public String getPartProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @see org.eclipse.ui.IWorkbenchPartReference#removePartPropertyListener(org.eclipse.jface.util.IPropertyChangeListener)
	 */
	public void removePartPropertyListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
}