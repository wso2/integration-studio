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
 * Filter which adds null to the beginning of the list of objects.  This is used to show
 * a "none" placeholder in combo boxes.
 * 
 * TODO: this might be incompatible with filters that aren't expecting null to appear as
 * a model object.  We don't use any filters yet though.
 */
public class AddNullFilter extends ViewerFilter {

	// note: clients should use AddNullFilter.getInstance()
	protected AddNullFilter() {
	}
	
	@Override
	public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
		Object[] result = new Object[elements.length + 1];
		result[0] = null;
		System.arraycopy(elements, 0, result, 1, elements.length);
		return result;
	}
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return true;
	}

	protected static AddNullFilter instance;
	public static AddNullFilter getInstance() {
		if (instance == null)  instance = new AddNullFilter();
		return instance;
	}
}
