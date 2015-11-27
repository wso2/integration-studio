/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.contentassist;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.editors.xpath.templates.XPathEditorTemplateAccess;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;

public class XPathTemplateCompletionProcessor extends TemplateCompletionProcessor {
	public static String XPATH_TEMPLATE = "xpath"; //$NON-NLS-1$
	
	/** Template context type */
	TemplateContextType fTemplateContextType;
	
	@Override
	protected TemplateContextType getContextType(ITextViewer viewer,
			IRegion region) {
		if (fTemplateContextType == null) {
			fTemplateContextType = new TemplateContextType (XPATH_TEMPLATE, "XPath templates");  //$NON-NLS-1$
		}
		return fTemplateContextType;	
	}

	@Override
	protected Image getImage(Template template) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PROPERTY_16);
	}

	@Override
	protected Template[] getTemplates(String contextTypeId) {
		if (XPATH_TEMPLATE.compareTo(contextTypeId) == 0) {
			TemplateStore store = XPathEditorTemplateAccess.getDefault().getTemplateStore();
			return (store.getTemplates(XPATH_TEMPLATE));
		}
		return null;
	}

}
