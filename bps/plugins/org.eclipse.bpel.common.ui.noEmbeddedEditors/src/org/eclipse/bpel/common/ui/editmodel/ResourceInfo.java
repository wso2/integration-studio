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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Resource Info holds the information about the resource, the edit model it represents, and it listens
 * on the resource modifications notifications from the workbench. Once the EMF resource is loaded,
 * ResourceInfo will listen on any updates from it and propagate to the EditoModel as well.
 * 
 * @author IBM
 */

public class ResourceInfo {

	/** The edit model */
	EditModel editModel;

	/** The emf resource */
	Resource resource;

	/** The workbench IFile that the resource came from */
	IFile file;

	/** Resource listener, notifications from workbench */
	ResourceListener resourceListener;

	/** The adapter on the EMF resource */
	Adapter resourceAdapter;

	/** Last synchronization stamp */
	long synchronizeStamp = 0;

	/** Load options */
	Map loadOptions = new HashMap();

	
	protected int referenceCount = 0;

	protected boolean loading = false;

	protected boolean fileExists = false;

	
	/**
	 * Brand new shiny ResourceInfo object.
	 *  
	 * @param editModel
	 * @param file
	 */
	
	ResourceInfo (EditModel anEditModel, IFile aFile) {
		this.editModel = anEditModel;
		this.file = aFile;
		
		resetSynchronizeStamp();
		resourceListener = new ResourceListener(this, this.file);
		ResourcesPlugin.getWorkspace().addResourceChangeListener (resourceListener);
		
		resourceAdapter = new AdapterImpl() {
			
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getEventType() == Notification.SET)
						&& (resource != null && msg.getNotifier() == resource)) {
					if (msg.getFeatureID(Resource.class) == Resource.RESOURCE__IS_MODIFIED) {
						ResourceInfo.this.editModel
								.fireModelDirtyStateChanged(ResourceInfo.this);
					}
				}
			}
		};
	}

	/**
	 * 
	 * @return the file which represents this resource in the workspace.
	 */
	
	public IFile getFile() {
		return file;
	}

	
	protected boolean getFileExists() {		
		return fileExists;
	}

	/**
	 * Answer if dirty.
	 * 
	 * @return  true if dirty, false if clean.
	 */
	
	public boolean isDirty() {
		if (resource == null) {
			return false;
		}
		return resource.isModified();
	}

	
	/**
	 * Return the EMF resource that this resource info is holding onto.
	 * 
	 * @return the EMF resource.
	 */
	
	public Resource getResource() {
		return resource;
	}

	/**
	 * Set the EMF resource that this resource is holding onto.
	 * 
	 * @param aResource the EMF resource.
	 */
	
	protected void setResource (Resource aResource) {
		this.resource = aResource;
	}

	/**
	 * Return the EMF load options.
	 * 
	 * @return the EMF resource load options.
	 */
	
	public Map getLoadOptions() {
		return loadOptions;
	}

	
	/**
	 * Set the EMF load options.
	 * 
	 * @param loadOptions
	 */
	public void setLoadOptions(Map loadOptions) {
		
		this.loadOptions = loadOptions;
	}

	/**
	 * The listener has notified us that the resource has moved in the Eclipse workbench. 
	 * We need to take appropriate cover.
	 * 
	 * @param movedToFile the moved to file.
	 */
	
	protected void move(IFile movedToFile) {
		editModel.removeResourceInfo(this);
		file = movedToFile;
		resource.setURI(URI.createPlatformResourceURI(file.getFullPath().toString()));
		resetSynchronizeStamp();
		
		resourceListener.setFile(movedToFile);
		editModel.addResourceInfo(this);
		editModel.fireModelLocationChanged(this, movedToFile);
	}

	/** 
	 * The listener has notified us that the resource has been deleted in the Eclipse workbench.
	 */
	protected void deleted() {
		if (editModel == null) {
			return;
		}
		editModel.fireModelDeleted(this);
	}

	/**
	 * The listener has notified us that the resource has had markers updated.
	 * We need to let the edit model know about about this.
	 * 
	 */
	
	protected void markersChanged ( IMarkerDelta [] markerDelta ) {
		if (editModel == null) {
			return ;
		}
		editModel.fireModelMarkersChanged ( this, markerDelta );
	}
	
	
	/**
	 * 
	 * Should not be used by clients
	 * 
	 */
	
	public void refresh() {		
		if (getSynchronizeStamp() == getCurrentFileModified()) {
			return;
		}
		load();
		editModel.fireModelReloaded(this);
	}

	
	
	protected void dispose() {
		if (editModel == null) {
			return;
		}
		if (resource != null) {
			resource.eAdapters().clear();			
		}
		editModel.removeResourceInfo(this);
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
		if (resource != null) {
			resource.unload();
		}
		editModel = null;
		resource = null;
		resourceListener = null;
	}

	
	protected void load() {
		if (resource != null) {
			resource.unload();
		}
		try {
			loading = true;
			resource = editModel.getResourceSet().getResource(
					URI
							.createPlatformResourceURI(file.getFullPath()
									.toString()), true);
		} finally {
			loading = false;
		}
		resourceLoaded();
	}

	
	protected void resourceLoaded() {
		
		if (loading) {
			return;
		}
		
		resetSynchronizeStamp();
		resource.eAdapters().add(resourceAdapter);
		fileExists = file.exists();
	}

	/**
	 * Should not be used by clients
	 * 
	 * @throws IOException 
	 */
	
	public void save() throws IOException {
		
		getResource().save(getLoadOptions());
		fileExists = true;
		resetSynchronizeStamp();
	}

	/**
	 * Should not be used by clients
	 * @param savedFile 
	 * @throws IOException 
	 */
	
	public void saveAs(IFile savedFile) throws IOException {
		// TODO Revert to old file name if save fails
		move(savedFile);
		save();
	}

	/**
	 * Resets the synchronization stamp. Should not be used by clients
	 */
	
	public void resetSynchronizeStamp() {
		synchronizeStamp = getCurrentFileModified();
	}

	/**
	 * Returns the last synchronization stamp. Should not be used by clients
	 * @return the last synchronization stamp.
	 */
	
	public long getSynchronizeStamp() {
		return synchronizeStamp;
	}

	/*
	 * Returns the resource current modified time.
	 */
	private long getCurrentFileModified() {
		return file.getLocation().toFile().lastModified();
	}
}
