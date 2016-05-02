/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.humantaskeditor.editors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

/**
 * Web based Human Task Editor for eclipse
 * <ul>
 * <li>page 0 contains Human Task GUI Editor
 * <li>page 1 contians nested text editor
 * </ul>
 */
public class HumanTaskMultiPageEditor extends MultiPageEditorPart implements IResourceChangeListener {

    /** The text editor used in page 1. */
    private TextEditor textEditor;

    /** The UI editor used in page 0. */
    private HumanTaskUIEditor humanTaskUIEditor;

    /**
     * Creates a humantask editor.
     */
    public HumanTaskMultiPageEditor() {
        super();
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    /**
     * Creates page 0 of the multi-page editor, which contains human task GUI
     * editor font used in page 2.
     */
    void createPage0() {

        humanTaskUIEditor = new HumanTaskUIEditor();

        int index;
        try {
            index = addPage(humanTaskUIEditor, getEditorInput());
            setPageText(index, HumantaskEditorConstants.GUI_EDITOR_NAME);
            humanTaskUIEditor.setEditorFunctionExecutor(new EditorContentFunction());
        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(), HumantaskEditorConstants.ERROR_CREATING_UI_EDITOR, null,
                    e.getStatus());
        }
    }

    /**
     * Creates page 1 of the multi-page editor, which contains a text editor.
     */
    void createPage1() {
        try {
            textEditor = new StructuredTextEditor();
            int index = addPage(textEditor, getEditorInput());
            setPageText(index, textEditor.getTitle());
            EditorContentFunction.setProjectName(((FileEditorInput) textEditor.getEditorInput()).getFile().getProject()
                    .getName());
        } catch (PartInitException e) {
            ErrorDialog.openError(getSite().getShell(), HumantaskEditorConstants.ERROR_CREATING_NESTED_TEXT_EDITOR,
                    null, e.getStatus());
        }
    }

    /**
     * Creates the pages of the multi-page editor.
     */
    @Override
    protected void createPages() {

        createPage0();
        createPage1();
        // createPage2();
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

    /**
     * Saves the multi-page editor's document. while calling js functions to save and sync
     */
    @Override
    public void doSave(IProgressMonitor monitor) {
        getEditor(1).doSave(monitor);
        if (getActivePage() == 0) {
            humanTaskUIEditor.getBrowser().execute(HumantaskEditorConstants.JS_FUNC_MAKE_UN_DIRTY);
        } else if (getActivePage() == 1) {
            humanTaskUIEditor.getBrowser().execute(HumantaskEditorConstants.JS_FUNC_LOAD_MODEL);
            humanTaskUIEditor.getBrowser().execute(HumantaskEditorConstants.JS_FUNC_IDESETDIRTY_FALSE);
        }
        /*
         * ITextEditor editor = (ITextEditor)getEditor(1); IDocumentProvider dp
         * = editor.getDocumentProvider(); IDocument doc =
         * dp.getDocument(editor.getEditorInput()); doc.set("Testing One");
         */
    }

    /**
     * Saves the multi-page editor's document as another file. Also updates the
     * text for page 0's tab, and updates this multi-page editor's input to
     * correspond to the nested editor's.
     */
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
            throw new PartInitException(HumantaskEditorConstants.ERROR_INVALID_INPUT_MUST_BE_IFILE_EDITOR_INPUT);
        }
        super.init(site, editorInput);
    }

    /*
     * (non-Javadoc) Method declared on IEditorPart.
     */
    @Override
    public boolean isSaveAsAllowed() {
        return true;
    }

    /**
     * calls respective JS methods when the pages are switched.
     */
    @Override
    protected void pageChange(int newPageIndex) {
        super.pageChange(newPageIndex);
        ITextEditor editor = (ITextEditor) getEditor(1);
        IDocumentProvider dp = editor.getDocumentProvider();
        IDocument doc = dp.getDocument(editor.getEditorInput());
        if (newPageIndex == 1) {
            humanTaskUIEditor.getBrowser().execute(HumantaskEditorConstants.JS_FUNC_SAVE_SOURCE);
            if (humanTaskUIEditor.isDirty()) {
                doc.set(EditorContentFunction.getText());
            }
        } else if (newPageIndex == 0) {
            EditorContentFunction.setText(doc.get());
            humanTaskUIEditor.getBrowser().execute(HumantaskEditorConstants.JS_FUNC_LOAD_MODEL_WITH_TEXT);
            humanTaskUIEditor.getBrowser().execute(HumantaskEditorConstants.JS_FUNC_PROCESS);
        }
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
}
