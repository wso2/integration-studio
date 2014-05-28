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

public class ExpressionEditorDescriptorLabelProvider extends org.eclipse.jface.viewers.LabelProvider {
	
	@Override
	public String getText(Object element) {
		ExpressionEditorDescriptor descriptor = (ExpressionEditorDescriptor) element;
		String text = descriptor.getLabel();
		return (text != null) ? text : descriptor.getExpressionLanguage();
	}
}
