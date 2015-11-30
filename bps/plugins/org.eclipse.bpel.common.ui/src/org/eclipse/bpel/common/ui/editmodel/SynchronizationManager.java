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

import java.io.File;
import java.io.IOException;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;



/**
 * Implements an activation listener and hooks it to an editor.
 * 
 * Calls the API in ISynchonizationHandler when needed to refresh
 * the model, close the editor, and to save the model.
 */
class SynchronizationManager {
	
	/** */
	private ActivationListener partListener;
		
public SynchronizationManager(IEditorPart editor,EditModel editModel,SynchronizationHandler handler) {
	partListener = new ActivationListener(this,editor,handler,editModel);
	editor.getSite().getWorkbenchWindow().getPartService().addPartListener(partListener);
	PlatformUI.getWorkbench().addWindowListener(partListener);
}
protected void dispose() {
	if (partListener.editor == null) 
		throw new IllegalArgumentException("editor cannot be null");  //$NON-NLS-1$
	partListener.editor.getSite().getWorkbenchWindow().getPartService().removePartListener(partListener);
	PlatformUI.getWorkbench().removeWindowListener(partListener);		
}
private static class ActivationListener implements IPartListener, IWindowListener {
	/** */
	private boolean handlingActivation = false;
	/** */
	private IWorkbenchPart activePart = null;
	/** */
	private SynchronizationManager manager;
	/** */
	private IEditorPart editor;
	/** */
	private SynchronizationHandler handler;
	/** */
	private EditModel editModel;

ActivationListener(SynchronizationManager manager,IEditorPart editor,SynchronizationHandler handler,EditModel editModel) {
	this.editModel = editModel;
	this.manager = manager;
	this.editor = editor;
	this.handler = handler;
}
	
/* (non-Javadoc)
 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
 */
public void partActivated(IWorkbenchPart part) {
	activePart = part;		
	handleActivated();
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
 */
public void partBroughtToTop(IWorkbenchPart part) {
}

/**
 * When a WorkbenchPart is closed, check if that part is
 * an editor using the model provided by the ResourceInfo object.
 * If it is, remove that editor from the editor list.
 */
public void partClosed(IWorkbenchPart part) {
	if (part instanceof IEditorPart) {
		if(editor == part)
			manager.dispose();
	}
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
 */
public void partDeactivated(IWorkbenchPart part) {
	activePart = null;
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
 */
public void partOpened(IWorkbenchPart part) {		
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IWindowListener#windowActivated(org.eclipse.ui.IWorkbenchWindow)
 */
public void windowActivated(IWorkbenchWindow window) {		
	if (!handlingActivation)
		handleActivated();
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IWindowListener#windowDeactivated(org.eclipse.ui.IWorkbenchWindow)
 */
public void windowDeactivated(IWorkbenchWindow window) {
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IWindowListener#windowClosed(org.eclipse.ui.IWorkbenchWindow)
 */
public void windowClosed(IWorkbenchWindow window) {
	if (editor.getSite().getWorkbenchWindow() == window) {
		manager.dispose();
	}
}

/* (non-Javadoc)
 * @see org.eclipse.ui.IWindowListener#windowOpened(org.eclipse.ui.IWorkbenchWindow)
 */
public void windowOpened(IWorkbenchWindow window) {
}
/**
 * Handles when the specified AbstractRulesEditor becomes active.
 * The handler first checks to see if the editor input has been
 * deleted, then refreshes the workspace cache of the input to 
 * allow the ResourceChangeListener to handle any updates to the 
 * file.
 */
void handleActivated() {
	if (editor == activePart) {
		handlingActivation = true;

		try {
			ResourceInfo[] resourceInfos = editModel.getResourceInfos();
			for (int i = 0; i < resourceInfos.length; i++) {
				handleActivated(resourceInfos[i]);
			}
		} catch (CoreException e) {
			CommonUIPlugin.log(e);
		} catch (IOException e) {
			CommonUIPlugin.log(e);
		}
		handlingActivation = false;
	}
}
void handleActivated(ResourceInfo resourceInfo) throws CoreException, IOException {
	boolean exists = false;
	long lastModified = 0;
	IPath location = resourceInfo.getFile().getLocation();
	if(location != null) {
		File localFile = location.toFile();
		exists = localFile.exists();
		lastModified = localFile.lastModified();
	}
	
	// Careful: avoid using editor.getFileInput().exists() since it causes
	// the file cache to be updated and fires the resource change listener.
	// This prevents us from prompting the user for action if the editor is
	// visible.
	if (resourceInfo.getFileExists() && !exists) { //File was deleted
		String[] buttons = { Messages.SynchronizationManager_saveButtonLabel, IDialogConstants.CLOSE_LABEL }; 
		
		// Bugzilla 330513
		// avoid using activeWindow to get a shell - there are cases where these
		// error dialogs are opened before the active window has been created
		// (e.g. resource load failures during editor startup)
		while (true) {   
			MessageDialog dialog = new MessageDialog(
				editor.getEditorSite().getShell(),
				Messages.SynchronizationManager_deleted_title, 
				null, // accept the default windowing system icon
				Messages.SynchronizationManager_deleted_message, 
				MessageDialog.QUESTION,
				buttons,
				0);
				
			if (dialog.open() == Window.OK) {
				SaveAsDialog saveAsDialog = new SaveAsDialog(editor.getEditorSite().getShell());
				saveAsDialog.setOriginalFile(resourceInfo.getFile());
				saveAsDialog.open();
				
				IPath path = saveAsDialog.getResult();
				if (path != null) {
					boolean saveSuccess = handler.saveFileAs(
							resourceInfo,
							ResourcesPlugin.getWorkspace().getRoot().getFile(path));
					if (saveSuccess) {
						resourceInfo.resetSynchronizeStamp();
						break;
					}
				}
			} else {
				handler.closeEditor();
				break;
			}
		}
	} else if (lastModified != resourceInfo.getSynchronizeStamp()) {
		String msg = NLS.bind(Messages.SynchronizationManager_refresh_message, (new String[]{ resourceInfo.getFile().toString()})); 
		boolean refresh = MessageDialog.openQuestion(
				editor.getEditorSite().getShell(), 
				Messages.SynchronizationManager_refresh_title,  
				msg);
				
		if (refresh) {
			handler.refresh(resourceInfo);
			resourceInfo.resetSynchronizeStamp();
		} else {
			/* 
			 * Update Synchronize Stamp so further editor activations
			 * will not display prompt to refresh. 
			 */
			resourceInfo.resetSynchronizeStamp();
		}
	}
	IFile file = resourceInfo.getFile();
	if (file.exists() && (!file.isLocal(IResource.DEPTH_ZERO) || !resourceInfo.getFile().isSynchronized(IResource.DEPTH_ZERO)))
		file.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
}
}
}
