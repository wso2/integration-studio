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

import org.eclipse.bpel.ui.Messages;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;


/**
 * A label provider which handles null while delegating non-null objects to another
 * label provider.  Might be useful in conjunction with AddNullFilter.
 */
public class NullHandlingLabelProvider implements ILabelProvider {
	
	ILabelProvider inner;
	
	public NullHandlingLabelProvider(ILabelProvider inner) {
		this.inner = inner;
	}
	
	public void addListener(ILabelProviderListener listener) {
		inner.addListener(listener);
	}

	public void dispose() {
		inner.dispose();
	}

	public Image getImage(Object element) {
		if (element == null)  return null;
		return inner.getImage(element);
	}

	public String getText(Object element) {
		if (element == null)  return Messages.NullHandlingLabelProvider____None____1; 
		return inner.getText(element);
	}

	public boolean isLabelProperty(Object element, String property) {
		if (element == null)  return false;
		return inner.isLabelProperty(element, property);
	}

	public void removeListener(ILabelProviderListener listener) {
		inner.removeListener(listener);
	}

	@Override
	public String toString() {
		return "NullHandlingLabelProvider("+inner.toString()+")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
