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

import org.eclipse.bpel.ui.extensions.ExpressionEditorDescriptor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


/**
 * Filters expression language editors.
 * 
 * This is also reused for query languages. In the future we should have
 * a separate extensibility mechanism for query languages.
 */
public class ExpressionLanguageFilter extends ViewerFilter {

	protected String[] exclude;
	
	public ExpressionLanguageFilter(String[] exclude) {
		super();
		this.exclude = exclude;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof ExpressionEditorDescriptor) {
			ExpressionEditorDescriptor descriptor = (ExpressionEditorDescriptor)element;
			if (exclude != null) {
				for (int i = 0; i < exclude.length; i++) {
					if (exclude[i].equals(descriptor.getExpressionLanguage())) return false;
				}
			}
		}
		return true;
	}

}
