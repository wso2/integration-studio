/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editors.xpath.templates;

import java.io.IOException;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;

public class XPathEditorTemplateAccess {
	static XPathEditorTemplateAccess templateAccess = null;
	
	/** The template store. */
	private ContributionTemplateStore fStore;
	
	/** The context type registry. */
	private ContributionContextTypeRegistry fRegistry;
	
	public static XPathEditorTemplateAccess getDefault() {
		if (templateAccess == null) {
			templateAccess  = new XPathEditorTemplateAccess();
		}
		
		return templateAccess;
	}
	
	/**
	 * Returns this plug-in's template store.
	 * 
	 * @return the template store of this plug-in instance
	 */
	public ContributionTemplateStore getTemplateStore() {
		if (fStore == null) {
			fStore= new ContributionTemplateStore(//null,
					getContextTypeRegistry(),
					BPELUIPlugin.INSTANCE.getPreferenceStore(), "xpath.editor");
			try {
				fStore.load();
			} catch (IOException e) {
				BPELUIPlugin.log(e);
			}
		}
		return fStore;
	}

	/**
	 * Returns this plug-in's context type registry.
	 * 
	 * @return the context type registry for this plug-in instance
	 */
	public ContributionContextTypeRegistry getContextTypeRegistry() {
		if (fRegistry == null) {
			// create and configure the contexts available in the template editor
			fRegistry= new ContributionContextTypeRegistry();
			fRegistry.addContextType("xpath");
			//fRegistry.addContextType("jscript");

		}
		return fRegistry;
	}

}
