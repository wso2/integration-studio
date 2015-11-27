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

import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


/**
 * Filter which selects from a set of PropertyAliases exactly those which are associated with a
 * given Property.
 */
public class PropertyAliasFilter extends ViewerFilter {

	Property property;
	
	public PropertyAliasFilter() {
		property = null;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if ((property != null) && (element instanceof PropertyAlias)) {
			if (((PropertyAlias)element).getPropertyName() == property) return true;
		}
		return false;
	}
}
