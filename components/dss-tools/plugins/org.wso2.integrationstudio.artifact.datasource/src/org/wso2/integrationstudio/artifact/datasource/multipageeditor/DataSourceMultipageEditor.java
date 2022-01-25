/*
* Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* WSO2 Inc. licenses this file to you under the Apache License,
* Version 2.0 (the "License"); you may not use this file except
* in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.integrationstudio.artifact.datasource.multipageeditor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.ds.wizards.util.DSSEditorUtils;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.xml.sax.SAXException;

/**
 * Represents the multi-page editor of the Data Source
 */
public class DataSourceMultipageEditor extends MultiPageEditorPart implements IResourceChangeListener {
    /**
     * The text editor used in source page.
     */
    private TextEditor textEditor;

    /**
     * The UI editor used in design page.
     */
    private DataSourceVisualEditorPage dssVisualEditorPage;

    /**
     * A variable to contain the XML content of the Datasource configuration
     */
    private String dsXmlContent;

    public static final String PLUGIN_ID = "org.wso2.integrationstudio.artifact.datasource";
    private static final String DS_XSD_PATH = "resources/schema/datasource_schema.xsd";
    private static final String DS_ERROR = "org.wso2.integrationstudio.ds.editor.dsserror";

    public static final int VISUAL_EDITOR_PAGE_INDEX = 0;
    public static final int SOURCE_EDITOR_PAGE_INDEX = 1;

    public static final String CURRENT_PAGE_KEY = "currentpage";
    public static final String CURRENT_PAGE_VAL_DESIGN = "design";
    public static final String CURRENT_PAGE_VAL_SOURCE = "source";
    public static final String XML_SOURCE_VALIDITY_KEY = "xmlvalidity";
    public static final String XML_SOURCE_INVALID = "invalid";
    public static final String XML_SOURCE_VALID = "valid";

    DSSEditorUtils editorUtils = DSSEditorUtils.getInstance();

    private static IIntegrationStudioLog log = Logger.getLog(PLUGIN_ID);

    /**
     * Creates a DSS editor.
     */
    public DataSourceMultipageEditor() {
        super();
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    /**
     * Creates the design editor page.
     */
    void createDesignPage() {
        dssVisualEditorPage = new DataSourceVisualEditorPage(this);
        int index;
        try {
            index = addPage(dssVisualEditorPage, getEditorInput());
            setPageText(index, DataSourceVisualEditorConstants.General.GUI_EDITOR_NAME);
        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(),
                    DataSourceVisualEditorConstants.ErrorMessages.ERROR_CREATING_UI_EDITOR, null, e.getStatus());
        }
    }

    /**
     * Creates the source editor page.
     */
    void createSourcePage() {
        try {
            textEditor = new StructuredTextEditor();
            int index = addPage(textEditor, getEditorInput());
            setPageText(index, DataSourceVisualEditorConstants.General.SOURCE_EDITOR_NAME);

            IEditorInput editorInput = getEditorInput();
            if (editorInput instanceof FileEditorInput) {
                IFile file = ((FileEditorInput) editorInput).getFile();

                try (InputStream inputStream = file.getContents(); Scanner scanner = new Scanner(inputStream)) {
                    setDsXmlContent(scanner.useDelimiter("\\A").next());
                } catch (IOException | CoreException e) {
                    log.error("Error while reading file", e);
                }
            }

        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(),
                    DataSourceVisualEditorConstants.ErrorMessages.ERROR_CREATING_NESTED_TEXT_EDITOR, null,
                    e.getStatus());
        }
    }

    /**
     * Creates the pages of the multi-page editor.
     */
    @Override
    protected void createPages() {
        createDesignPage();
        createSourcePage();
    }

    /**
     * The <code>MultiPageEditorPart</code> implementation of this <code>IWorkbenchPart</code> method disposes all
     * nested editors.
     * Subclasses may extend.
     */
    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        super.dispose();
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        ITextEditor editor = (ITextEditor) getEditor(SOURCE_EDITOR_PAGE_INDEX);
        IDocumentProvider dp = editor.getDocumentProvider();
        IDocument doc = dp.getDocument(editor.getEditorInput());
        String sourceContent = doc.get();
        String validationMsg = validateDatasourceConfig(sourceContent);
        if (validationMsg.equals("valid")) {
            deleteMarkers();
            setDsXmlContent(sourceContent);
            getEditor(1).doSave(monitor);

            ((DataSourceVisualEditorPage) getEditor(VISUAL_EDITOR_PAGE_INDEX)).getBrowser().refresh();
        } else {
            addMarker(validationMsg);
        }

    }

    private void deleteMarkers() {
        // remove markers from temporary xml files
        try {
            IFile file = getFile();
            if (file != null) {
                file.deleteMarkers(DS_ERROR, false, 1);
            }
        } catch (CoreException e) {
            // ignore
        }
    }

    private void addMarker(String error) {
        deleteMarkers();
        try {
            IFile file = getFile();
            if (file != null) {
                IMarker marker = file.createMarker(DS_ERROR);
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
                marker.setAttribute(IMarker.MESSAGE, error);
                MarkerUtilities.setLineNumber(marker, 0);
                marker.setAttribute(IMarker.CHAR_START, 0);
                marker.setAttribute(IMarker.CHAR_END, 2);
            }
        } catch (Exception e) {
            log.error("Error while adding markers", e);
        }
    }

    private IFile getFile() {
        IEditorInput editorInput = getEditorInput();
        if (editorInput instanceof FileEditorInput) {
            return ((FileEditorInput) editorInput).getFile();
        }
        return null;
    }

    public static String validateDatasourceConfig(String dssContent) {

        try {

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Bundle bundle = Platform.getBundle(PLUGIN_ID);
            URL resolvedFileURL = FileLocator.toFileURL(bundle.getEntry(DS_XSD_PATH));
            URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
            Schema schema = factory.newSchema(new File(resolvedURI));
            schema.newValidator().validate(new StreamSource(new StringReader(dssContent)));
        } catch (IOException | SAXException e) {
            String errorMsg = e.getMessage();
            return errorMsg;
        } catch (URISyntaxException e) {
            // ignore the error which occurs when runtime cannot locate the schema files
        }
        return "valid";
    }

    @Override
    public void doSaveAs() {
        IEditorPart editor = getEditor(1);
        editor.doSaveAs();
        setPageText(1, editor.getTitle());
        setInput(editor.getEditorInput());
    }

    /*
     * (non-Javadoc) Method declared on IEditorPart
     */
    public void gotoMarker(IMarker marker) {
        setActivePage(1);
        IDE.gotoMarker(getEditor(1), marker);
    }

    /**
     * The <code>MultiPageEditorExample</code> implementation of this method
     * checks that the input is an instance of <code>IFileEditorInput</code>.
     */
    @Override
    public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
        if (!(editorInput instanceof IFileEditorInput)) {
            throw new PartInitException(
                    DataSourceVisualEditorConstants.ErrorMessages.ERROR_INVALID_INPUT_MUST_BE_IFILE_EDITOR_INPUT);
        }
        super.init(site, editorInput);
        setPartName(editorInput.getName());
        
    }

    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * calls respective JS methods when the pages are switched.
     */
    @Override
    protected void pageChange(int newPageIndex) {

        if (newPageIndex == 0) {
            // Switching in to design view
            ITextEditor editor = (ITextEditor) getEditor(SOURCE_EDITOR_PAGE_INDEX);
            IDocumentProvider dp = editor.getDocumentProvider();
            String sourceContent = dp.getDocument(editor.getEditorInput()).get();
            String validationMsg = validateDatasourceConfig(sourceContent);

            if (!validationMsg.equals("valid")) {
                // XML source code is invalid, stay in source view
                setActivePage(SOURCE_EDITOR_PAGE_INDEX);
                addMarker(validationMsg);
                editorUtils.saveProperty(XML_SOURCE_VALIDITY_KEY, XML_SOURCE_INVALID, null);
            } else {
                // XML source code is valid, save changes and switch to design view and refresh
                deleteMarkers();
                if (isDirty()) {
                    setDsXmlContent(sourceContent);
                    getEditor(1).doSave(new NullProgressMonitor());
                }
                editorUtils.saveProperty(CURRENT_PAGE_KEY, CURRENT_PAGE_VAL_DESIGN, null);
                editorUtils.saveProperty(XML_SOURCE_VALIDITY_KEY, XML_SOURCE_VALID, null);
                ((DataSourceVisualEditorPage) getEditor(VISUAL_EDITOR_PAGE_INDEX)).getBrowser().refresh();
            }

        } else {
            // Switching in to source view
            editorUtils.saveProperty(CURRENT_PAGE_KEY, CURRENT_PAGE_VAL_SOURCE, null);
            ((DataSourceVisualEditorPage) getEditor(VISUAL_EDITOR_PAGE_INDEX)).getBrowser().refresh();
        }

        super.pageChange(newPageIndex);

    }

    /**
     * Closes all project files on project close.
     */
    @Override
    public void resourceChanged(final IResourceChangeEvent event) {
        if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
                    for (IWorkbenchPage page : pages) {
                        if (((FileEditorInput) textEditor.getEditorInput()).getFile().getProject()
                                .equals(event.getResource())) {
                            IEditorPart editorPart = page.findEditor(textEditor.getEditorInput());
                            page.closeEditor(editorPart, true);
                        }
                    }
                }
            });
        }
    }

    public String getDsXmlContent() {
        return this.dsXmlContent;
    }

    public void setDsXmlContent(String dsXmlContent) {
        this.dsXmlContent = dsXmlContent;
    }

    public TextEditor getTextEditor() {
        return textEditor;
    }

    public void setTextEditor(TextEditor textEditor) {
        this.textEditor = textEditor;
    }
}
