/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.maven.multi.module.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Scanner;

import javax.xml.bind.ValidationException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.multi.module.Activator;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Refreshable;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * This class represents the Maven Multi Module POM Editor.
 */
public class DistProjectEditor extends FormEditor implements Refreshable {
    
    private static final String PARSER_CLASS = "org.apache.xerces.parsers.SAXParser";
    private static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private DistProjectEditorPage distProjectEditorPage;
    private StructuredTextEditor sourceEditor;
    private boolean dirty;
    private boolean sourceDirty;
    private int formEditorIndex;
    private int sourceEditorIndex;

    @Override
    protected void addPages() {
        distProjectEditorPage = new DistProjectEditorPage(this,
                "org.wso2.developerstudio.eclipse.maven.multi.module.editor.design", "Design");
        sourceEditor = new StructuredTextEditor();
        sourceEditor.setEditorPart(this);

        try {
            distProjectEditorPage.initContent();
            formEditorIndex = addPage(distProjectEditorPage);
            sourceEditorIndex = addPage(sourceEditor, getEditorInput());
            setPageText(sourceEditorIndex, "Source");
            getDocument().addDocumentListener(new IDocumentListener() {
                public void documentAboutToBeChanged(final DocumentEvent event) {
                }

                public void documentChanged(final DocumentEvent event) {
                    sourceDirty = true;
                    updateDirtyState();
                }
            });
            
            if (getFile() != null) {
                setTitle(getFile().toString().replaceFirst("^L/", ""));
            }
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            workspace.addResourceChangeListener(distProjectEditorPage);
        } catch (CoreException | IOException | XmlPullParserException e) {
            log.error("Page init error has occurred", e);
        }
    }

    @Override
    public void doSave(IProgressMonitor pm) {
        if (dirty) {
            updateSourceFromDesign();
            sourceDirty = false;
            dirty = false;
            updateDirtyState();
        } else if (sourceDirty) {
            if (updateDesignFromSource()) {
                sourceDirty = false;
                dirty = false;
                updateDirtyState();
            }
        }
    }

    /**
     * This method returns the document in the source editor.
     * 
     * @return source document
     */
    private IDocument getDocument() {
        final IDocumentProvider provider = sourceEditor.getDocumentProvider();
        return provider.getDocument(getEditorInput());
    }

    @Override
    protected void pageChange(int newPageIndex) {
        if ((newPageIndex == sourceEditorIndex) && (dirty)) {
            sourceDirty = false;
            dirty = false;
            updateSourceFromDesign();
            updateDirtyState();
        } else if ((newPageIndex == formEditorIndex) && (sourceDirty)) {
            if (updateDesignFromSource()) {
                sourceDirty = false;
                dirty = false;
                updateDirtyState();
            }
        }
        super.pageChange(newPageIndex);
        final IFormPage page = getActivePageInstance();
        if (page != null) {
            page.setFocus();
        }
    }

    /**
     * This method update the source view from the data of design view.
     */
    private void updateSourceFromDesign() {
        String content;
        try (InputStream inputStream = getFile().getContents(); Scanner scanner = new Scanner(inputStream);) {
            distProjectEditorPage.savePOM();
            content = scanner.useDelimiter("\\A").next();
            getDocument().set(content);
        } catch (IOException | CoreException e) {
            log.error("An unexpected error has occurred", e);
        }
    }

    /**
     * This method update the design view from the data of source view.
     * 
     * @return true if update operation can be carried out, otherwise false
     */
    private boolean updateDesignFromSource() {
        try {
            InputStream content = new ByteArrayInputStream(getDocument().get().getBytes());
            if (!isValidateXMLContent(getDocument().get())) {
                return false;
            }
            getFile().setContents(content, true, true, null);
            try {
                content.close();
            } catch (IOException e) {
                log.error("An unexpected error has occurred", e);
            }
            distProjectEditorPage.refreshForm();
        } catch (CoreException | IOException | XmlPullParserException e) {
            log.error("An unexpected error has occurred", e);
        }
        return true;
    }

    /**
     * This method returns the file belongs to the editor.
     * 
     * @return file
     */
    private IFile getFile() {
        final IEditorInput input = getEditorInput();
        if (input instanceof FileEditorInput)
            return ((FileEditorInput) input).getFile();
        return null;
    }

    /**
     * This method returns the editor of the source page.
     * 
     * @return editor of the source page
     */
    public StructuredTextEditor getSourceEditor() {
        return sourceEditor;
    }

    @Override
    public void doSaveAs() {
    }

    /**
     * This method update the dirty state of the editor from the editor page.
     */
    public void updateDirtyState() {
        dirty = distProjectEditorPage.isDirty();
        firePropertyChange(PROP_DIRTY);
        editorDirtyStateChanged();
    }

    @Override
    public boolean isDirty() {
        return (dirty || sourceDirty);
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void refresh() {
        if (distProjectEditorPage != null) {
            distProjectEditorPage.getRefreshAction().run();
        }
    }

    /**
     * Validate for the xml parser errors in the source content.
     * 
     * @param xmlContent source view content
     * @return Source error
     * @throws ValidationException
     */
    public boolean isValidateXMLContent(String xmlContent) {
        MyErrorHandler myErrorHandler = new MyErrorHandler();
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader(PARSER_CLASS);
            xmlReader.setFeature(VALIDATION_FEATURE, true);
            xmlReader.setErrorHandler(myErrorHandler);
            InputSource inputSource = new InputSource(new StringReader(xmlContent));
            xmlReader.parse(inputSource);
        } catch (SAXException e) {
            log.error("Error while parsing the xml file.", myErrorHandler.getException());
        } catch (IOException e) {
            log.error("Error while processing the xml content.", myErrorHandler.getException());
        }

        if (myErrorHandler.getLineNumber() > 0) {
            log.error("Error while saving the diagram", myErrorHandler.getException());
            String errorMsgHeader = "Save failed. Following error(s) have been detected."
                    + " Please see the error log for more details.";
            String message = myErrorHandler.getErrorMessage();
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message);
            ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error", errorMsgHeader, editorStatus);
            return false;
        }
        return true;
    }

    /**
     * Set xml parser errors for the MyErrorHandler object.
     */
    private static class MyErrorHandler extends DefaultHandler {
        private String errorMsg = "";
        private int lineNumber = -1;
        private SAXParseException exception;
        private static final String SPACE = " ";

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            errorMsg = errorMsg + SPACE + e.getMessage();
            lineNumber = e.getLineNumber();
            exception = e;
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            errorMsg = errorMsg + SPACE + e.getMessage();
            exception = e;
        }

        /**
         * This method returns the error message.
         * 
         * @return error message
         */
        public String getErrorMessage() {
            return errorMsg;
        }

        /**
         * Returns the line in which error occurred.
         * 
         * @return the line in which error occurred
         */
        public int getLineNumber() {
            return lineNumber;
        }

        /**
         * Returns the exception.
         * 
         * @return the exception
         */
        public Exception getException() {
            return exception;
        }
    }
}
