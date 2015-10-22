/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.base.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.editor.IFormPage;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.IRegistryFormEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.interfaces.RegistryInformationEditorObservable;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.AssociationEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.CollectionEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.CommentsEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.DependencyEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.PropertiesEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.ResourceEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.ui.editor.pages.TagsEditorPage;
import org.wso2.developerstudio.eclipse.registry.base.util.EditorConstants;


public class RegistryResourceEditor extends FormEditor {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private boolean dirty = false;
	private CollectionEditorPage collectionEditorPage;
	private ResourceEditorPage resourceEditorPage;
	private PropertiesEditorPage propertyEditorPage;
	private AssociationEditorPage associationEditorPage;
	private DependencyEditorPage depEditorPage;
	private CommentsEditorPage commentsPage;
	private TagsEditorPage tagsPage;
	private List<IRegistryFormEditorPage> formPages;
	private ResourceEditorInput editorInput;
	private RegistryInformationEditorObservable regInforChangeObservable;

	/**
	 * add a new editor page
	 * @param editorInput
	 * @throws PartInitException
	 */
	private void addNewPage(ResourceEditorInput editorInput) throws PartInitException{
		//check whether the selected item is a collection
		if(editorInput.isCollection()){
			collectionEditorPage = new CollectionEditorPage(this, 
					EditorConstants.COLLECTION_PAGE_ID,
					EditorConstants.COLLECTION_PAGE_TITLE);
			addPage(collectionEditorPage);
		}else{
			resourceEditorPage = new ResourceEditorPage(this,
					EditorConstants.RESOURCE_PAGE_ID,
					EditorConstants.RESOURCE_PAGE_TITLE);
			addPage(resourceEditorPage);
		}
	}
	
	/**
	 * update the existing editor page according to user input
	 * @param editorInput
	 * @throws PartInitException
	 */
	private void updateExistingPage(ResourceEditorInput editorInput) throws PartInitException{
		//check whether the selected item is a collection
		if(editorInput.isCollection()){
			collectionEditorPage = new CollectionEditorPage(this,
															EditorConstants.COLLECTION_PAGE_ID,
															EditorConstants.COLLECTION_PAGE_TITLE);
			addPage(collectionEditorPage);
		}else{
			resourceEditorPage = new ResourceEditorPage(this,
														EditorConstants.RESOURCE_PAGE_ID,
														EditorConstants.RESOURCE_PAGE_TITLE);
			addPage(resourceEditorPage);
		}
		addCommonPages();
	}
	
	/**
	 * add new page or update existing editor page according to user preference
	 */
	protected void addPages() {
		try {
			editorInput = (ResourceEditorInput) getEditorInput();
			//if new resource or collection added
			if(editorInput.getResource()==null){
				addNewPage(editorInput);
			}else{
				updateExistingPage(editorInput);
			}
			//update the title of the editor page
			updateTitle();

		} catch (PartInitException e) {
			log.error(e);
		}
	}

	protected void createPages() {
		super.createPages();
		
		//if this is a new resource
		if (getPageCount() == 1 && getContainer() instanceof CTabFolder) {
			//TODO
		}
	}

	/**
	 * validate the content of pages
	 * @return 
	 * @throws Exception
	 */
	private boolean validatePages() throws Exception{
		
		for (IRegistryFormEditorPage page : getFormPages()) {
			//if there is any updates to the page, validate the page
			if (page.isPageDirty()){
				page.validate();
			}
		}
		return true;
	}
	
	/**
	 * save page content in to remote registry
	 */
	public void doSave(IProgressMonitor arg0) {
		try {
			if (editorInput.getResource() == null) {
				if (editorInput.isCollection()) {
					collectionEditorPage.validate();
					collectionEditorPage.doFinish();
				} else {
					resourceEditorPage.validate();
					resourceEditorPage.doFinish();
				}
				if (validatePages()) {
					doFinishPages();
					if(editorInput.getResource()!= null){
						editorInput.getResource().setEditorInput(editorInput);
					}
					addCommonPages();				
				}

			} else {
				if (validatePages()) {
					doFinishPages();
				}
			}
		} catch (Exception e) {
			if(editorInput.isCollection()){
				MessageDialog.openError(getContainer().getShell(), "Collection",
						"Error adding collection: " + e.getMessage());
			}else{
				MessageDialog.openError(getContainer().getShell(), "Resource",
						"Error adding resource: " + e.getMessage());
			}
			
			log.error(e);
		}
		updateTitle();
		getRegInforChangeObservable().setLastEvent(RegistryInformationEditorObservable.EVENT_SAVED);
		getRegInforChangeObservable().triggerObservers();
	}

	/**
	 * save all the pages
	 * @throws Exception
	 */
	private void doFinishPages() throws Exception {
		for (IRegistryFormEditorPage page : getFormPages()) {
			if (page.isPageDirty())
				page.doFinish();
		}
	}

	public void doSaveAs() {

	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * when any kind of modification has been done to an editor page, set page to dirty state
	 */
	public void updateDirtyState() {
		dirty = false;
		for (IRegistryFormEditorPage page : getFormPages()) {
			dirty = page.isPageDirty();
			if (dirty) {
				break;
			}
		}
		firePropertyChange(PROP_DIRTY);
		editorDirtyStateChanged();
	}

	/**
	 * 
	 */
	public boolean isDirty() {
		return dirty;
	}

	/**
	 * update the title of the page
	 */
	private void updateTitle() {
		String name;
		if (editorInput.isCollection()){
			collectionEditorPage.updateFormName();
			name = collectionEditorPage.getCurrentResourceName() == null ? "WSO2 Registry"
					: collectionEditorPage.getCurrentResourceName()
							+ " - WSO2 Registry";
		}else{
			resourceEditorPage.updateFormName();
			name = resourceEditorPage.getCurrentResourceName() == null ? "WSO2 Registry"
					: resourceEditorPage.getCurrentResourceName()
							+ " - WSO2 Registry";
		}
		setPartName(name);
	}

	/**
	 * add common pages to both resource and collection
	 * @throws PartInitException
	 */
	public void addCommonPages() throws PartInitException {
		propertyEditorPage = new PropertiesEditorPage(this,
													  EditorConstants.PROPERTY_PAGE_ID,
													  EditorConstants.PROPERTY_PAGE_TITLE);
//		propertyEditorPage.setIndex(index)
		associationEditorPage = new AssociationEditorPage(this,
														  EditorConstants.ASSOCIATION_PAGE_ID,
														  EditorConstants.ASSOCIATION_PAGE_TITLE);
		depEditorPage = new DependencyEditorPage(this,
												EditorConstants.DEPENDENCY_PAGE_ID,
												EditorConstants.DEPENDENCY_PAGE_TITLE);
		commentsPage = new CommentsEditorPage(this,
											 EditorConstants.COMMENTS_PAGE_ID,
											 EditorConstants.COMMENTS_PAGE_TITLE);
		tagsPage = new TagsEditorPage(this, 
									  EditorConstants.TAGS_PAGE_ID,
									  EditorConstants.TAGS_PAGE_TITLE);
		addPage(propertyEditorPage);
		addPage(associationEditorPage);
		addPage(depEditorPage);
		addPage(commentsPage);
		addPage(tagsPage);
	}

	public void setFormPages(List<IRegistryFormEditorPage> formPages) {
		this.formPages = formPages;
	}

	/**
	 * keep the collection of all the pages
	 * @return
	 */
	public List<IRegistryFormEditorPage> getFormPages() {
		if (formPages == null)
			formPages = new ArrayList<IRegistryFormEditorPage>();
		return formPages;
	}

	/**
	 * add a new form editor
	 */
	public int addPage(IFormPage formPage) throws PartInitException {
		if (formPage instanceof IRegistryFormEditorPage)
			getFormPages().add((IRegistryFormEditorPage) formPage);
		return super.addPage(formPage);
	}

	/**
	 * 
	 * @param pageId
	 * @param actionId
	 * @param data
	 */
	public void performAction(int pageId, int actionId, Object data) {
		for (IRegistryFormEditorPage page : getFormPages()) {
			if (page.getPageType() == pageId) {
				FormPage page2 = (FormPage) page;
				setActivePage(page2.getId(), getEditorInput());
				page.executeAction(actionId, data);
			}
			dirty = dirty || page.isPageDirty();
		}
	}

	public RegistryInformationEditorObservable getRegInforChangeObservable() {
		if (regInforChangeObservable==null){
			regInforChangeObservable=new RegistryInformationEditorObservable();
			regInforChangeObservable.setRegResourceNode(editorInput.getResource());
		}
		return regInforChangeObservable;
	}
}

