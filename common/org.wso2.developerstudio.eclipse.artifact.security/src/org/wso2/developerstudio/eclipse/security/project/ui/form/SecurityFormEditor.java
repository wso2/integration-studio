/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.security.project.ui.form;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.artifact.security.utils.SecurityFormMessageConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.security.Activator;

import javax.xml.transform.TransformerException;

public class SecurityFormEditor extends FormEditor {

    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String SECURITY_DESIGN_VIEW = "Design";
    private static final String SECURITY_SOURCE_VIEW = "Source";

    private SecurityFormPage formPage;
    private File policyFile;
    private IProject project;
    private boolean isSourceDirty;
    private StructuredTextEditor sourceEditor;
    private int formEditorIndex;
    private int sourceEditorIndex;
    private Display display;

    /**
     * Initializes the security form editor
     *
     * @throws PartInitException
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);

        policyFile = getPolicyFile().getLocation().toFile();
        project = getPolicyFile().getProject();
        setPartName(getPolicyFile().getName());
        display = Display.getCurrent();
    }

    @Override
    protected void addPages() {
        formPage = new SecurityFormPage(this, Activator.PLUGIN_ID, SECURITY_DESIGN_VIEW, project, policyFile, display);
        sourceEditor = new StructuredTextEditor();
        sourceEditor.setEditorPart(this);

        try {
            formEditorIndex = addPage(formPage);
            sourceEditorIndex = addPage(sourceEditor, getEditorInput());
        } catch (PartInitException e) {
            log.error("Cannot initialize SecurityDashboard page", e);
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_FORM_LOAD_ERROR);
            msg.open();
        }

        setPageText(sourceEditorIndex, SECURITY_SOURCE_VIEW);
        getDocument().addDocumentListener(new IDocumentListener() {
            public void documentAboutToBeChanged(final DocumentEvent event) {
            }

            public void documentChanged(final DocumentEvent event) {
                isSourceDirty = true;
                updateDirtyState();
            }
        });
    }

    @Override
    public void doSave(IProgressMonitor pm) {
        //get the active page and save the contents of that.
        if (getActivePage() == sourceEditorIndex) {
            InputStream content = new ByteArrayInputStream(getDocument().get().getBytes());
            try {
                getPolicyFile().setContents(content, true, true, null);
                content.close();
                //getPolicyFile().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            } catch (CoreException | IOException e) {
                log.error("Error in loading the Editor when de-serializing", e);
                MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
                msg.setMessage(SecurityFormMessageConstants.MESSAGE_LOAD_UI_ERROR);
                msg.open();
            }
            formPage.updateUI(getDocument().get());
        } else {
            boolean saveStatus = formPage.doPageSave();
            //If saving failed terminate the process
            if (!saveStatus) {
                return;
            }
            String content;
            try {
                content = formPage.getUpdatedContent();
            } catch (TransformerException | ClassNotFoundException | InstantiationException | IllegalAccessException
                    e) {
                log.error("Error while getting updated source content", e);
                MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
                msg.setMessage(SecurityFormMessageConstants.MESSAGE_LOAD_UI_ERROR);
                msg.open();
                return;
            }
            getDocument().set(content);
        }
        //Update the dirty states
        isSourceDirty = false;
        formPage.setDirty(false);
        updateDirtyState();
    }

    @Override
    protected void pageChange(int newPageIndex) {
        if ((newPageIndex == sourceEditorIndex) && formPage.isDirty()) {
            String content = formPage.updateSource();
            getDocument().set(content);
            formPage.setDirty(false);
        } else if ((newPageIndex == formEditorIndex) && isSourceDirty) {
            String xmlSource = getDocument().get();
            formPage.updateUI(xmlSource);
            isSourceDirty = false;
            formPage.setDirty(true);
        }
        super.pageChange(newPageIndex);
        final IFormPage page = getActivePageInstance();
        if (page != null) {
            page.setFocus();
        }
    }

    @Override
    public void doSaveAs() {
        //No logic is here since Save-As operation is not supported
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    public boolean isDirty() {
        return formPage.isDirty() || isSourceDirty;
    }

    public void updateDirtyState() {
        firePropertyChange(PROP_DIRTY);
        editorDirtyStateChanged();
    }

    private IDocument getDocument() {
        final IDocumentProvider provider = sourceEditor.getDocumentProvider();
        return provider.getDocument(getEditorInput());
    }

    private IFile getPolicyFile() throws PartInitException {
        final IEditorInput input = getEditorInput();
        if (input instanceof FileEditorInput) {
            return ((FileEditorInput) input).getFile();
        } else {
            log.error("Security form editor initiated for an invalid resource type");
            MessageBox msg = new MessageBox(getSite().getShell(), SWT.ICON_ERROR);
            msg.setMessage(SecurityFormMessageConstants.MESSAGE_LOAD_UI_ERROR);
            msg.open();
            throw new PartInitException("Security form editor initiated for an invalid resource type");
        }
    }
}