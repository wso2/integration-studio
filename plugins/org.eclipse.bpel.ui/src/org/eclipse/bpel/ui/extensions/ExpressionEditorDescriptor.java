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
package org.eclipse.bpel.ui.extensions;

import org.eclipse.bpel.ui.expressions.IExpressionEditor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;


public class ExpressionEditorDescriptor {

	protected String language;
	protected String label;
	protected IConfigurationElement element;

	public IExpressionEditor createEditor() throws CoreException {
		return (IExpressionEditor) element.createExecutableExtension(BPELUIRegistry.ATT_CLASS);
	}

	IConfigurationElement getElement() {
		return element;
	}

	void setElement(IConfigurationElement element) {
		this.element = element;
	}

	void setLabel(String label) {
		this.label = label;
	}

	public String getExpressionLanguage() {
		return language;
	}

	public String getLabel() {
		return label;
	}

	void setExpressionLanguage(String language) {
		this.language = language;
	}

}
