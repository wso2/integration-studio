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

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * A sorter which alphabetically sorts model objects based on the labels provided for them
 * by the viewer's installed label provider.
 */
public class ModelViewerSorter extends ViewerSorter {

	// clients should call getInstance()
	protected ModelViewerSorter() { }
	protected static ModelViewerSorter instance = new ModelViewerSorter();

	public static ModelViewerSorter getInstance() { return instance; }  
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 == null && e2 != null) return -1;
		if (e1 != null && e2 == null) return +1;
		ILabelProvider labelProvider = (ILabelProvider)((ContentViewer)viewer).getLabelProvider();
		String property1 = labelProvider.getText(e1);
		String property2 = labelProvider.getText(e2);
		return collator.compare(property1, property2);
	}
}
