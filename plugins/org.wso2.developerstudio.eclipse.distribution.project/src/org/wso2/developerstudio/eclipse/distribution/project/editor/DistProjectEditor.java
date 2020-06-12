/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.distribution.project.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Refreshable;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Editor page for docker project type.
 */
public class DistProjectEditor extends FormEditor implements Refreshable {
 private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
 
 private static final String PARSER_CLASS = "org.apache.xerces.parsers.SAXParser";
 private static final String VALIDATION_FEATURE = "http://xml.org/sax/features/validation";
 
 private DistProjectEditorPage distProjectEditorPage;
 private StructuredTextEditor sourceEditor;
 private boolean dirty;
 private boolean sourceDirty;
 private int formEditorIndex;
 private int sourceEditorIndex;

 	
	protected void addPages() {
		distProjectEditorPage = new DistProjectEditorPage(
				this,
				"org.wso2.developerstudio.eclipse.distribution.project.editor.design",
				"Design");
		sourceEditor = new StructuredTextEditor();
		sourceEditor.setEditorPart(this);
		
		try {
			distProjectEditorPage.initContent();
			formEditorIndex = addPage(distProjectEditorPage);
			sourceEditorIndex = addPage(sourceEditor,getEditorInput());
			setPageText(sourceEditorIndex, "Source");
			
			getDocument().addDocumentListener(new IDocumentListener() {  
				    
	            public void documentAboutToBeChanged(final DocumentEvent event) {  
	                // nothing to do  
	            }  
	   
	            public void documentChanged(final DocumentEvent event) {  
	                sourceDirty = true; 
	                updateDirtyState();
	            }  
	        });  
			
			if(getFile()!=null){
				setTitle(getFile().toString().replaceFirst("^L/",""));
			}	

			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(distProjectEditorPage);

		} catch (PartInitException e) {
			log.error("Page init error has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		
	}

	public void doSave(IProgressMonitor pm) {
		if(dirty){
			try {
				updateSourceFromDesign();
				sourceDirty = false;
				dirty = false;
				updateDirtyState();
			} catch (Exception e) {
				log.error("An unexpected error has occurred", e);
			}
		} else if (sourceDirty){
			if (updateDesignFromSource()) {
				sourceDirty = false;
				dirty = false;
				updateDirtyState();
			}
			
		}
	}

	private IDocument getDocument() {
		final IDocumentProvider provider = sourceEditor.getDocumentProvider();
		return provider.getDocument(getEditorInput());
	}
	

	protected void pageChange(int newPageIndex) {
		if ((newPageIndex == sourceEditorIndex) && (dirty)){
			sourceDirty = false;
			dirty = false;
			updateSourceFromDesign();
			updateDirtyState();
			
		} else if ((newPageIndex == formEditorIndex) && (sourceDirty)){
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
	
	private void updateSourceFromDesign() {
		String content;
        try (InputStream inputStream = getFile().getContents(); Scanner scanner = new Scanner(inputStream);) {
            distProjectEditorPage.savePOM();
            content = scanner.useDelimiter("\\A").next();
			getDocument().set(content);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
	}

	private boolean updateDesignFromSource()  {
		try {
			InputStream content = new ByteArrayInputStream(getDocument().get().getBytes());
			
			if (!isValidateXMLContent(getDocument().get())) {
				return false;
			}
			
			getFile().setContents(content, true, true, null);
			try {
				content.close();
	        } catch (IOException e) {
	        	// ignore, stream is already closed
	        }
			distProjectEditorPage.refreshForm();
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		
		return true;
	}

	private IFile getFile() {
		final IEditorInput input = getEditorInput();
		if (input instanceof FileEditorInput)
			return ((FileEditorInput) input).getFile();
		return null;
	}

	public StructuredTextEditor getSourceEditor() {
		return sourceEditor;
	}
	
	public void doSaveAs() {
		// nothing to do 
	}

	public void updateDirtyState() {
		dirty = distProjectEditorPage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();	    
    }
	
	public boolean isDirty() {
		return (dirty || sourceDirty);
	}
	
	public boolean isSaveAsAllowed() {
		return false;
	}
	
	public void refresh() {
		if (distProjectEditorPage != null) {
			distProjectEditorPage.getRefreshAction().run();
		}
	}
	
	/**
	 * Validate for the xml parser errors in the source content
	 * 
	 * @param xmlContent
	 *            source view content
	 * @return Source error
	 * @throws ValidationException
	 */
	public boolean isValidateXMLContent(String xmlContent) {

		MyErrorHandler myErrorHandler = new MyErrorHandler();
		try {

			XMLReader r = XMLReaderFactory.createXMLReader(PARSER_CLASS);
			r.setFeature(VALIDATION_FEATURE, true);
			r.setErrorHandler(myErrorHandler);
			InputSource inputSource = new InputSource(new StringReader(xmlContent));
			r.parse(inputSource);

		} catch (SAXException e) {
			// ignore
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

		public void fatalError(SAXParseException e) throws SAXException {
			errorMsg = errorMsg + " " + e.getMessage();
			lineNumber = e.getLineNumber();
			exception = e;
		}

		public void error(SAXParseException e) throws SAXException {
			errorMsg = errorMsg + " " + e.getMessage();
			exception = e;
		}

		public String getErrorMessage() {
			return errorMsg;
		}

		public int getLineNumber() {
			return lineNumber;
		}

		public Exception getException() {
			return exception;
		}
	}
}
