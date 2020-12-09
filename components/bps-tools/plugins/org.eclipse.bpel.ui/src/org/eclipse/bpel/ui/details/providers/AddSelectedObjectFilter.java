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
package org.eclipse.bpel.ui.details.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Filter which adds a given object to the contents of the viewer.
 * 
 * Useful for ensuring that a value stored in the model actually
 * appears in the widget (even if the content provider doesn't include
 * that model object in its contents).
 */
public class AddSelectedObjectFilter extends ViewerFilter {

	Object selectedObject;
	
	@Override
	public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
		if (selectedObject == null) return elements;
		for (int i = 0; i<elements.length; i++) {
			if (elements[i] == selectedObject) return elements;
		}
		Object[] result = new Object[elements.length + 1];
		result[0] = selectedObject;
		System.arraycopy(elements, 0, result, 1, elements.length);
		return result;
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return true;
	}

	public Object getSelectedObject() {
		return selectedObject;
	}
	
	public void setSelectedObject(Object selectedObject) {
		this.selectedObject = selectedObject;
	}
}
