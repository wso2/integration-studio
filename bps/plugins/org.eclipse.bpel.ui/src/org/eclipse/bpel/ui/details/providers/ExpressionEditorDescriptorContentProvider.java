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

import java.util.List;

import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.extensions.ExpressionEditorDescriptor;


/**
 * @author IBM Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 16, 2007
 *
 */
public class ExpressionEditorDescriptorContentProvider extends AbstractContentProvider {
	
	/**
	 * Brand new shiny ExpressionEditorContentProvider.
	 */
	public ExpressionEditorDescriptorContentProvider() {
		super();
	}
	
	/**
	 * @see org.eclipse.bpel.ui.details.providers.AbstractContentProvider#collectElements(java.lang.Object, java.util.List)
	 */
	@Override
	public void collectElements (Object input, List<Object> list) {
						
		for (ExpressionEditorDescriptor next : BPELUIRegistry.getInstance().getExpressionEditorDescriptors() ) {
			list.add(next);
		}
	}	
}
