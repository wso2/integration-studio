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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.editor;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RegistryInfoEditor extends FormEditor {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private StructuredTextEditor sourceEditor;
	private RegistryInfoEditorPage editorPage;
	private boolean dirty;
	private boolean sourceDirty;
	private int formEditorIndex;
	private int sourceEditorIndex;

    protected void addPages() {
		editorPage = new RegistryInfoEditorPage(
				this,
				"org.wso2.developerstudio.eclipse.artifact.registry.handler.editor.design",
				"Design");
		sourceEditor = new StructuredTextEditor();
		sourceEditor.setEditorPart(this);
	    try {
	    	editorPage.initContent();
	    	formEditorIndex = addPage(editorPage);
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
        } catch (Exception e) {
        	log.error(e);
        }
    }


    public void doSave(IProgressMonitor monitor) {
    	if ((getCurrentPage() == formEditorIndex ) && (dirty)){
			updateSourceFromDesign();
		} else if ((getCurrentPage() == sourceEditorIndex) && (sourceDirty)){
			updateDesignFromSource();
		}
    	sourceDirty = false;
		dirty = false;
    	try {
	        editorPage.save();
	        updateDirtyState();
        } catch (Exception e) {
	        e.printStackTrace();
        }
    }

    public void doSaveAs() {
    	// nothing to do
    }

    public boolean isSaveAsAllowed() {
	    return false;
    }
    
	public IDocument getDocument() {
		final IDocumentProvider provider = sourceEditor.getDocumentProvider();
		return provider.getDocument(getEditorInput());
	}
	
	private void updateSourceFromDesign() {
		try {
			String source = editorPage.getSource();
			getDocument().set(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateDesignFromSource()  {
		try {
			editorPage.refreshContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void pageChange(int newPageIndex) {
		if ((newPageIndex == sourceEditorIndex) && (dirty)){
			updateSourceFromDesign();
		} else if ((newPageIndex == formEditorIndex) && (sourceDirty)){
			updateDesignFromSource();
		}
			
		super.pageChange(newPageIndex);
		
		final IFormPage page = getActivePageInstance();
		if (page != null) {
			page.setFocus();
		}
	}
	
	public void updateDirtyState() {
		dirty = editorPage.isDirty();
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();	    
    }
	
	public boolean isDirty() {
		return (dirty || sourceDirty);
	}
	
	public StructuredTextEditor getSourceEditor() {
		return sourceEditor;
	}

}
