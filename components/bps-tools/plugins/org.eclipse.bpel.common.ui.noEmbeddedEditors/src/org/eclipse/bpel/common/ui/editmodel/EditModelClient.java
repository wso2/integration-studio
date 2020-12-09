/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.editmodel;

import java.io.IOException;
import java.util.Map;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorPart;

public class EditModelClient {
		
	/** */
	private ResourceInfo primaryResourceInfo;
	/** */
	private EditModel editModel;
	/** */
	private IEditModelListener modelListener;
	/** */
	private SynchronizationManager manager;
	/** */
	private IEditorPart editor;
	

/**
 * Creates a new EditModelClient
 * 
 * @param editor the editor that is using this model manager
 * @param file the editor's input
 * @param modelListener the listener which is used to communicate back to the editor.
 * @param loadOptions a Map of EMF load/save options. May be empty.
 */
public EditModelClient(IEditorPart editor,IEditModelListener modelListener) {
	this.editor = editor;
	this.modelListener = modelListener;
}

// Bugzilla 330513
// separated this from constructor
public void loadPrimaryResource(IFile file, Map loadOptions) throws RuntimeException {
	editModel = getSharedResourceSet(file);
	((BPELResourceSetImpl)editModel.getResourceSet()).setLoadOptions(loadOptions);
	try {
		SynchronizationHandler handler = new Synchronizer();
		if(getCommandStack() == null) {
			EditModelCommandStack commandStack = createCommandStack();
			editModel.setCommandStack(commandStack);
		}
		primaryResourceInfo = editModel.getResourceInfo(file);
		if(loadOptions != null)
			primaryResourceInfo.setLoadOptions(loadOptions);
		getEditModel().addListener(modelListener);
		manager = new SynchronizationManager(editor,editModel,handler);
	} catch (RuntimeException ex) {
		if(editModel != null)
			editModel.release();
		throw ex;
	}
}
protected EditModel getSharedResourceSet(IFile file) {
	return EditModel.getEditModel(file);
}
/**
 * Creates and returns a command stack to be used by this
 * model manager and the editor.
 */
protected EditModelCommandStack createCommandStack() {
	return new EditModelCommandStack();
}
/**
 * Returns the command stack to be used by this
 * model manager and the editor.
 */
public EditModelCommandStack getCommandStack() {
	return editModel.getCommandStack();
}
/**
 * Returns the EMFModel editModel used by this model manager.
 * The EditModel is a model reference count cache.
 */
public EditModel getEditModel() {
	return editModel;
}
/**
 * Returns the ResourceInfo which is used by the EditModel
 * and counts the reference for each model cached in the model
 * editModel.
 */
public ResourceInfo getPrimaryResourceInfo() {
	return primaryResourceInfo;
}
/**
 * Disposes this model manager, its command stack, and 
 * its model editModel.
 */
public void dispose() {
	getEditModel().removeListener(modelListener);
	editModel.releaseReference(primaryResourceInfo);
	editModel.release();
}
/**
 * Saves the model
 */
public boolean saveAll(IProgressMonitor progressMonitor) {
	return editModel.saveAll(progressMonitor);
}

/**
 * Saves the model with a new name
 */
public boolean savePrimaryResourceAs(IFile savedFile, IProgressMonitor progressMonitor) {
	return editModel.savePrimaryResourceAs(primaryResourceInfo,savedFile,progressMonitor);
}
void close() {
	editor.getSite().getPage().closeEditor(editor, false);
}
private class Synchronizer implements SynchronizationHandler {
	public void closeEditor() {
		EditModelClient.this.close();
	}
	public boolean saveFileAs(ResourceInfo resourceInfo,IFile file) throws CoreException, IOException {
		if (resourceInfo.equals(primaryResourceInfo))
			return savePrimaryResourceAs(file, null);
		else {
			resourceInfo.saveAs(file);
			return true;
		}
	}
	public void refresh(ResourceInfo resourceInfo) {
		try {
		resourceInfo.refresh();
		}
		catch (Exception e) {
			CommonUIPlugin.log(e);
		}
		getCommandStack().flush();
	}
}
}
