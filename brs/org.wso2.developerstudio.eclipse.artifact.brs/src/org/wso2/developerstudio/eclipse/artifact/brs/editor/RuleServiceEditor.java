/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.brs.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.carbon.rule.common.exception.RuleConfigurationException;
import org.wso2.developerstudio.eclipse.artifact.brs.Activator;
import org.wso2.developerstudio.eclipse.artifact.brs.utils.RuleServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/* creates the source editor and adds design view page to editor */
public class RuleServiceEditor extends FormEditor {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private RuleServiceEditorPage ruleServiceEditorPage;
	private StructuredTextEditor sourceEditor;
	private boolean designDirty;
	private boolean sourceDirty;
	private int formEditorIndex;
	private int sourceEditorIndex;

	public RuleServiceEditor() {

	}

	@Override
	protected void addPages() {

		ruleServiceEditorPage =
			new RuleServiceEditorPage(this,
					RuleServiceArtifactConstants.RULE_SERVICE_EDITOR_ID,
					RuleServiceArtifactConstants.UI_EDITOR_NAME);


		sourceEditor = new StructuredTextEditor();
		sourceEditor.setEditorPart(this);

		try {
			ruleServiceEditorPage.initContent();
			formEditorIndex = addPage(ruleServiceEditorPage);
			sourceEditorIndex = addPage(sourceEditor, getEditorInput());
			setPageText(sourceEditorIndex, RuleServiceArtifactConstants.TEXT_EDITOR_NAME);
			if (getFile() != null) {

				// the name of the editor is set from here.
				// setTitle(getFile().getName());
				setPartName(getFile().getName());
			}

			getDocument().addDocumentListener(new IDocumentListener() {
				@Override
				public void documentChanged(DocumentEvent event) {
					sourceDirty = true;
					updateDirtyState();
				}

				@Override
				public void documentAboutToBeChanged(DocumentEvent event) {
				}
			});
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
			MessageDialog.openQuestion((Shell) getSite(), "WARNING",
					e.getMessage());
		}

	}

	@Override
	public void doSave(IProgressMonitor arg0) {

		if (designDirty) {
			try {
				updateSourceFromDesign();
				sourceDirty = false;
				designDirty = false;
				updateDirtyState();
			}  catch (Exception e) {
				log.error("An unexpected error has occurred", e);
				MessageDialog.openQuestion((Shell) getSite(), "WARNING",
						e.getMessage());
			}

		} else if (sourceDirty) {

			try {
				sourceDirty = false;
				designDirty = false;
				updateDesignFromSource();
				updateDirtyState();
			}  catch (Exception e) {
				log.error("An unexpected error has occurred", e);
				MessageDialog.openQuestion((Shell) getSite(), "WARNING",
						e.getMessage());
			}
		}
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	protected void pageChange(int newPageIndex) {
		if ((newPageIndex == sourceEditorIndex) && (designDirty)) {
			sourceDirty = false;
			designDirty = false;
			try {
				updateSourceFromDesign();
				updateDirtyState();
			} catch (Exception e) {
				log.error("An unexpected error has occurred", e);
			}

		} else if ((newPageIndex == formEditorIndex) && (sourceDirty)) {
			sourceDirty = false;
			designDirty = false;
			try {
				updateDesignFromSource();
				updateDirtyState();
			} catch (Exception e) {
				log.error("An unexpected error has occurred", e);
			}

		}

		super.pageChange(newPageIndex);
		final IFormPage page = getActivePageInstance();

		if (page != null) {
			page.setFocus();
		}

	}

	private IDocument getDocument() {
		final IDocumentProvider provider = sourceEditor.getDocumentProvider();
		return provider.getDocument(getEditorInput());
	}

	public void updateDirtyState() {
		designDirty = ruleServiceEditorPage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();
	}

	private IFile getFile() {

		// Editor is always associatedwith IeditorInput which is the file we edit.
		final IEditorInput input = getEditorInput();

		if (input instanceof FileEditorInput) {
			return ((FileEditorInput) input).getFile();
		}
		 

		return null;
	}

	private void updateSourceFromDesign() throws
	IOException,
	RuleConfigurationException {

		String content = null;

		ruleServiceEditorPage.saveRSL();
		try {
			content = new Scanner(getFile().getContents()).useDelimiter("\\A").next();
			//content.trim();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDocument().set(content);
	}

	private void updateDesignFromSource() throws CoreException, IOException, XMLStreamException,
	RuleConfigurationException {

		InputStream content = new ByteArrayInputStream(getDocument().get().getBytes());
		getFile().setContents(content, true, true, null);
		content.close();
		ruleServiceEditorPage.refreshForm();
	}

	@Override
	public boolean isDirty() {
		return (designDirty || sourceDirty);
	}

}
