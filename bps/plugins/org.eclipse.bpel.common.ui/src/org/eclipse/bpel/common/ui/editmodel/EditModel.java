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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.resource.BPELResourceSetImpl;
import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * EditModel is shared between editor with the same primary file input. It holds
 * on to a command stack, and a resource set.
 * 
 * This class has a reference count cache of EditModels. Once all editors that
 * reference a editModel are closed all resource in the shared resource set are
 * unloaded.
 * 
 * Life-cycle call getEditModel using its primary file. the shared resource set
 * reference count is incremented; call getResourceInfo using any file that need
 * to be loaded the shared resource reference count is incremented; call
 * releaseReference the shared resource reference count is decremented; call
 * release if it is the last reference the shared resource set is disposed
 */
public class EditModel {

	protected static EditModelCache cache = new EditModelCache();

	protected Map<IFile,ResourceInfo> fileToResourceInfo = new HashMap<IFile,ResourceInfo>();

	protected ResourceSet resourceSet;

	protected int referenceCount = 0;

	protected IResource primaryFile;

	protected EditModelCommandStack commandStack;

	private List<IEditModelListener> updateListeners = null;

	

	
	/**
	 * Get the edit model based on the primary resource file.
	 * 
	 * @param primaryFile
	 * @return the edit model
	 */
	
	public static EditModel getEditModel(IResource primaryFile) {
		return cache.getEditModel(primaryFile, new Factory());
	}

	/**
	 * Get the edit model based on the primary resource file.
	 * @param primaryFile primary file (the BPEL resource) 
	 * @param factory factory
	 * @return the editor model
	 * 
	 */
	
	public static EditModel getEditModel(IResource primaryFile, Factory factory) {
		return cache.getEditModel(primaryFile, factory);
	}

	/**
	 * Private constructor. Use the static factory methods.
	 */
	
	protected EditModel(ResourceSet rSet, IResource bpelFile) {
		this.resourceSet = rSet;
		this.primaryFile = bpelFile;		
		this.updateListeners = new ArrayList<IEditModelListener>();
	}

	/**
	 * Add a model listener.
	 * @param listener
	 */
	
	public void addListener (IEditModelListener listener) {
		if (updateListeners.contains(listener)) {
			return;
		}
		updateListeners.add(listener);
	}

	/**
	 * Remove a model listener.
	 * @param listener
	 */
	
	public void removeListener(IEditModelListener listener) {
		updateListeners.remove(listener);
	}

	protected void fireModelDirtyStateChanged(ResourceInfo sr) {
		for (IEditModelListener next : updateListeners ) {
			next.modelDirtyStateChanged(sr);
		}
	}

	protected void fireModelDeleted(ResourceInfo sr) {
		// bugzilla 324006
		// Prevent concurrent list modification exception:
		// When a resource is deleted, the BPEL editor shuts itself down for no
		// apparently good reason (I'm sure it's to avoid some other kinds of disasters
		// that it isn't equipped to deal with!) This causes the editor to remove itself
		// from our update listeners list.
		ArrayList<IEditModelListener> listeners = new ArrayList<IEditModelListener>(updateListeners.size());
		listeners.addAll(updateListeners);
		for (IEditModelListener next : listeners ) {
			next.modelDeleted(sr);
		}
	}
	
	protected void fireModelReloaded(ResourceInfo sr) {
		ArrayList<IEditModelListener> listeners = new ArrayList<IEditModelListener>(updateListeners.size());
		listeners.addAll(updateListeners);
		for (IEditModelListener next : listeners ) {
			next.modelReloaded(sr);
		}
	}

	protected void fireModelLocationChanged(ResourceInfo sr, IFile movedToFile) {
		ArrayList<IEditModelListener> listeners = new ArrayList<IEditModelListener>(updateListeners.size());
		listeners.addAll(updateListeners);
		for (IEditModelListener next : listeners ) {
			next.modelLocationChanged(sr,movedToFile);
		}
	}

	protected void fireModelMarkersChanged (ResourceInfo sr, IMarkerDelta[] markerDelta ) {
		ArrayList<IEditModelListener> listeners = new ArrayList<IEditModelListener>(updateListeners.size());
		listeners.addAll(updateListeners);
		for (IEditModelListener next : listeners ) {
			next.modelMarkersChanged(sr,markerDelta );
		}
	}

	
	/**
	 * Return the resource set associated with this editModel.
	 * @return the resource set used by this Edit Model client.
	 */
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * Returns the cached ResourceInfo for <code>file</code>
	 * 
	 * Creates a new ResourceInfo it is not found in the cache, otherwise
	 * increment the reference count and return it.
	 */
	
	ResourceInfo getResourceInfoForLoadedResource(Resource resource) {
		
		URI uri = resource.getURI();
		IFile file = getIFileForURI(uri);
		if (file == null)
			return null;
		ResourceInfo resourceInfo = fileToResourceInfo.get(file);
		if (resourceInfo == null) {
			resourceInfo = new ResourceInfo(this, file);
			resourceInfo.setResource(resource);
			addResourceInfo(resourceInfo);
			resourceInfo.resourceLoaded();
		}
		if (!resourceInfo.loading)
			resourceInfo.referenceCount++;
		return resourceInfo;
	}

	/**
	 * Returns the cached ResourceInfo for <code>file</code>
	 * 
	 * Creates a new ResourceInfo it is not found in the cache, otherwise
	 * increment the reference count and return it.
	 * 
	 * @param file the file
	 * @return the cached resource info for that file.
	 */
	
	public ResourceInfo getResourceInfo(IFile file) {
		ResourceInfo resourceInfo = fileToResourceInfo.get(file);
		if (resourceInfo == null) {
			resourceInfo = new ResourceInfo(this, file);
			addResourceInfo(resourceInfo);
			try {
				resourceInfo.load();
			} catch (RuntimeException ex) {
				resourceInfo.referenceCount++;
				releaseReference(resourceInfo);
				throw ex;
			}
		}
		resourceInfo.referenceCount++;
		return resourceInfo;
	}

	
	static ResourceInfo [] EMPTY_RESOURCE_ARRAY = {};
	
	/**
	 * 
	 * @return The resource infos
	 * 
	 */
	
	public ResourceInfo[] getResourceInfos() {
		return fileToResourceInfo.values().toArray(EMPTY_RESOURCE_ARRAY);
	}

	
	private void setPrimaryFile(IFile newFile) {
		IResource oldFile = primaryFile;
		primaryFile = newFile;
		cache.updatePrimaryFile(oldFile, newFile);
	}

	/**
	 * @return the primary resource (primary file) for this edit model. 
	 */
	
	public IResource getPrimaryFile() {
		return primaryFile;
	}

	/**
	 * Decrement the reference count for <code>resourceInfo</code> and dispose
	 * if it is the last reference.
	 * @param resourceInfo 
	 */
	public void releaseReference (ResourceInfo resourceInfo) {
		resourceInfo.referenceCount--;
		if (resourceInfo.referenceCount == 0) {
			resourceInfo.dispose();
			removeResourceInfo(resourceInfo);
		}
	}

	/**
	 * Add resourceInfo to the cache
	 */
	
	protected void addResourceInfo(ResourceInfo sr) {
		fileToResourceInfo.put(sr.getFile(), sr);
	}

	/*
	 * Remove the resourceInfo from the cache.
	 */
	protected void removeResourceInfo(ResourceInfo sr) {
		fileToResourceInfo.remove(sr.getFile());
	}

	/**
	 * Dispose this EditModel if there is no other reference to it;
	 */
	public void release() {
		referenceCount--;
		if (referenceCount == 0) {
			cache.remove(this);
			for (ResourceInfo resourceInfo : fileToResourceInfo.values().toArray(EMPTY_RESOURCE_ARRAY) ) {
				resourceInfo.dispose();
			}
			fileToResourceInfo.clear();
		}
		
	}

	public static IFile getIFileForURI(URI uri) {
		String filePath = null;
		String scheme = uri.scheme();
		IFile file = null;
		if ("file".equals(scheme)) { //$NON-NLS-1$
			filePath = uri.toFileString();
			if (filePath == null)
				return null;
			file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
					new Path(filePath));
		} else if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) { //$NON-NLS-1$//$NON-NLS-2$
			StringBuffer platformResourcePath = new StringBuffer();
			for (int i = 1, size = uri.segmentCount(); i < size; ++i) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(i));
			}
			filePath = platformResourcePath.toString();
			if (filePath == null)
				return null;
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(filePath));
		}
		return file;
	}

	/**
	 * Get the command stack.
	 * 
	 * @return the command stack.
	 */
	
	public EditModelCommandStack getCommandStack() {
		return commandStack;
	}

	
	/**
	 * Set the command stack.
	 * 
	 * @param stack the command stack.
	 */
	
	public void setCommandStack(EditModelCommandStack stack) {
		this.commandStack = stack;
	}

	/**
	 * Saves the model
	 * 
	 * @param progressMonitor progress monitor. 
	 * @return if all went OK true, false otherwise.  
	 */
	
	public boolean saveAll(IProgressMonitor progressMonitor) {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor)
					throws InvocationTargetException {
				getCommandStack().markSaveLocation();
				try {
					ResourceInfo[] sResource = getResourceInfos();
					for (int i = 0; i < sResource.length; i++) {
						ResourceInfo resource = sResource[i];
						if (resource.isDirty())
							resource.save();
					}
				} catch (IOException e) {
					throw new InvocationTargetException(e);
				}
			}
		};

		try {
			operation.run(progressMonitor);
		} catch (InvocationTargetException e) {
			return false;
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}

	
	/**
	 * Save primary resource as ...
	 * 
	 * @param resourceInfo
	 * @param savedFile
	 * @param progressMonitor
	 * @return save result (true is OK).
	 */
	
	public boolean savePrimaryResourceAs(final ResourceInfo resourceInfo,
			final IFile savedFile, IProgressMonitor progressMonitor) {
		boolean result = saveResourceAs(resourceInfo, savedFile,
				progressMonitor);
		if (result)
			setPrimaryFile(savedFile);
		return result;
	}

	/**
	 * Save resource as ...
	 * @param resourceInfo
	 * @param savedFile
	 * @param progressMonitor
	 * @return the status of the save ...
	 */
	
	public boolean saveResourceAs(final ResourceInfo resourceInfo,
			final IFile savedFile, IProgressMonitor progressMonitor) {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor)
					throws InvocationTargetException  {
				try {
					getCommandStack().markSaveLocation();
					resourceInfo.saveAs(savedFile);
				} catch (IOException e) {
					throw new InvocationTargetException(e);
				}
			}
		};

		try {
			operation.run(progressMonitor);
		} catch (InvocationTargetException e) {
			return false;
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @author IBM
	 *
	 */
	public static class Factory {
		protected EditModel createEditModel(ResourceSet resourceSet,
				IResource primaryFile) {
			return new EditModel(resourceSet, primaryFile);
		}
	}

	static class EditModelCache {

		protected Map<ResourceSet,EditModel> resourceSetToEditModel = new HashMap<ResourceSet,EditModel>();

		protected Map<IResource,ResourceSet> fileToResourceSet = new HashMap<IResource,ResourceSet>();

		/**
		 * Return a new ResourceSet for the specified file.
		 * @param primaryFile 
		 * @param factory 
		 * @return the edit model.
		 */
		
		public EditModel getEditModel(IResource primaryFile, Factory factory) {
			ResourceSet resourceSet = getResourceSet(primaryFile);
			return getEditModel(resourceSet, primaryFile, factory);
		}

		/**
		 * Return the EditModel for specified resource set.
		 * 
		 * Creates a new EditModel it is not found in the cache, otherwise
		 * increment the reference count and return it.
		 */
		
		@SuppressWarnings("unchecked")
		private EditModel getEditModel(ResourceSet resourceSet,
				IResource primaryFile, Factory factory) {
			EditModel editModel = resourceSetToEditModel.get(resourceSet);
			if (editModel != null) {
				editModel.referenceCount++;
				return editModel;
			}
			editModel = factory.createEditModel(resourceSet, primaryFile);
			editModel.referenceCount++;
			resourceSetToEditModel.put(resourceSet, editModel);
			final EditModel finalEditModel = editModel;
			
			resourceSet.eAdapters().add(new AdapterImpl() {
				
				@Override
				public void notifyChanged(Notification msg) {
					Resource r = (Resource) msg.getNewValue();
					finalEditModel.getResourceInfoForLoadedResource(r);
				}
				
			});
			return editModel;
		}

	/*
	 * Return a new ResourceSet for the specified file.
	 */
	private ResourceSet getResourceSet(IResource primaryFile) {
		ResourceSet resourceSet = fileToResourceSet.get(primaryFile);
		if(resourceSet != null)
			return resourceSet;
		// TODO: Extensibility
		resourceSet = new BPELResourceSetImpl();
		fileToResourceSet.put(primaryFile,resourceSet);
		return resourceSet;	
	}

		/**
		 * 
		 * @param editModel
		 */
		public void remove(EditModel editModel) {
			resourceSetToEditModel.remove(editModel.resourceSet);
			fileToResourceSet.remove(editModel.primaryFile);
		}

		
		void updatePrimaryFile(IResource oldFile, IResource newFile) {
			ResourceSet rs = fileToResourceSet.get(oldFile);
			fileToResourceSet.remove(oldFile);
			fileToResourceSet.put(newFile, rs);
		}
	}
	

	
	static String EXTPT_RESOURCE_SET_PROVIDER = "resourceSetProvider"; //$NON-NLS-1$
	static String ELM_PROVIDER = "provider"; //$NON-NLS-1$
	static String ATT_CLASS = "class"; //$NON-NLS-1$
	
	static private IResourceSetProvider gfResourceSetProvider;
	
	static IResourceSetProvider getResourceSetProvider () {
		if (gfResourceSetProvider != null) {
			return gfResourceSetProvider;
		}
		
		for(IConfigurationElement elm : CommonUIPlugin.getConfigurationElements( EXTPT_RESOURCE_SET_PROVIDER)) {
			
			if (ELM_PROVIDER.equals(elm.getName()) == false) {
				continue;
			}
			
			String clazz = elm.getAttribute(ATT_CLASS);
			if (clazz != null) {
				try {
					gfResourceSetProvider = (IResourceSetProvider) elm.createExecutableExtension(ATT_CLASS);						
				} catch ( CoreException ce ) {
					CommonUIPlugin.getDefault().getLog().log(ce.getStatus());
				}								
			}
			
			if (gfResourceSetProvider != null) {
				break;
			}
		}
		
		if (gfResourceSetProvider == null) {
			gfResourceSetProvider = new IResourceSetProvider () {

				public ResourceSet getResourceSet (IResource resource) {
					return new ResourceSetImpl();
				}				
			};
		}
		return gfResourceSetProvider;
	}
}
