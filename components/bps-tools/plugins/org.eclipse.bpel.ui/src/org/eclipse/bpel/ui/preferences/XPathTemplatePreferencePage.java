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
package org.eclipse.bpel.ui.preferences;

import org.eclipse.swt.graphics.Font;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.bpel.ui.BPELUIPlugin;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.bpel.ui.editors.xpath.ColorManager;
import org.eclipse.bpel.ui.editors.xpath.XPathSourceViewerConfiguration;
import org.eclipse.bpel.ui.editors.xpath.templates.XPathEditorTemplateAccess;

/*
 * Preference page for defining templates used by the XPath Expression Editor
 * within BPEL.
 */
public class XPathTemplatePreferencePage extends TemplatePreferencePage	implements IWorkbenchPreferencePage {
	private ColorManager colorManager;
	
	public XPathTemplatePreferencePage() {
        setPreferenceStore(BPELUIPlugin.INSTANCE.getPreferenceStore());
        setContextTypeRegistry(XPathEditorTemplateAccess.getDefault().getContextTypeRegistry());
        //XPathEditorTemplateAccess.getDefault().getContextTypeRegistry().addContextType("xpath");
        //XPathEditorTemplateAccess.getDefault().getContextTypeRegistry().addContextType("jscript");
        setTemplateStore(XPathEditorTemplateAccess.getDefault().getTemplateStore());
        colorManager = null;
	}

	@Override
	protected SourceViewer createViewer(Composite parent) {
		SourceViewer viewer = new SourceViewer(parent, null, null, false, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		Font font= JFaceResources.getFont(JFaceResources.TEXT_FONT);
		viewer.getTextWidget().setFont(font);  
		
		colorManager = new ColorManager();
		XPathSourceViewerConfiguration configuration = new XPathSourceViewerConfiguration(colorManager); 
	
		viewer.configure(configuration);
		IDocument document= new Document();
		viewer.setDocument(document);
		return viewer;
	}

    /* (non-Javadoc)
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     */
    @Override
	public boolean performOk() {
	  boolean ok = super.performOk();
	  BPELUIPlugin.INSTANCE.savePluginPreferences();
	  if (colorManager != null)
		  colorManager.dispose();
	  return ok;
    }

	@Override
	public boolean performCancel() {
		boolean cancel = super.performCancel();
		if (colorManager != null)
			colorManager.dispose();
		return cancel;
	}
    
    
}