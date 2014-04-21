/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.ExtensionmodelFactory;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.validator.Builder;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


/**
 * Listens to changes to the BPEL file and reacts accordingly.
 */
public class BPELResourceChangeListener implements IResourceChangeListener {
	class ResourceDeltaVisitor implements IResourceDeltaVisitor {

		public boolean visit(final IResourceDelta delta) throws CoreException {
			IResource target = delta.getResource();
			// Bugzilla 320545:
			if (Builder.isBPELFile(target)) {
				handleBPEL(delta);
			}
			return true;
		}

		private void handleBPEL(final IResourceDelta delta)
			throws CoreException {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor)
					throws CoreException {
					IFile target = (IFile) delta.getResource();
					switch (delta.getKind()) {
						case IResourceDelta.REMOVED :
							{
								int flags = delta.getFlags();
								if ((flags & IResourceDelta.MOVED_TO) != 0) {
									fileMoved(target, delta.getMovedToPath());
								} else {
									fileDeleted(target, monitor);
								}
								break;
							}
					}
				}
			};
			ResourcesPlugin.getWorkspace().run(runnable, null);
		}
	}

	protected IResourceDeltaVisitor visitor;
	protected List<IFileChangeListener> listeners;

	public BPELResourceChangeListener() {
		listeners = new ArrayList<IFileChangeListener>();
	}

	/**
	 * Objects like the BPELEditor can add listeners so they can be
	 * notified and react when BPEL files change.
	 */
	public void addListener(IFileChangeListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Removed the listener.
	 */
	public void removeListener(IFileChangeListener listener) {
		listeners.remove(listener);
	}

	public void resourceChanged(IResourceChangeEvent event) {
		try {
			event.getDelta().accept(getResourceDeltaVisitor());
		} catch (CoreException e) {
			BPELUIPlugin.log(e);
		}
	}

	protected IResourceDeltaVisitor getResourceDeltaVisitor() {
		if (visitor == null) {
			visitor = new ResourceDeltaVisitor();
		}
		return visitor;
	}

	/**
	 * Calculate and return all related files to this BPEL file.
	 * Currently this list includes the .bpelex file and the
	 * artifacts WSDL.
	 */
	protected static IFile[] getRelatedFiles(IFile bpelFile) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath bpelPath = bpelFile.getFullPath();
		IFile bpelexFile = root.getFile(bpelPath.removeFileExtension().addFileExtension(IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS));
		String baseName = bpelPath.removeFileExtension().lastSegment();
		IPath artifactsPath = bpelPath.removeFileExtension().removeLastSegments(1).append(baseName+"Artifacts").addFileExtension(IBPELUIConstants.EXTENSION_WSDL); //$NON-NLS-1$
		IFile artifactsFile = root.getFile(artifactsPath);
		return new IFile[] { bpelexFile, artifactsFile }; 
	}
	
	/**
	 * Calculate a new name for the given related file, based on
	 * the old file and the new base name. Need a clause in here
	 * to recognize each of the files calculated in getRelatedFiles().
	 */
	protected static String getNewRelatedFileName(IFile oldFile, String newBaseName) {
		if (IBPELUIConstants.EXTENSION_WSDL.equals(oldFile.getFileExtension())) {
			return newBaseName + "Artifacts" + IBPELUIConstants.EXTENSION_DOT_WSDL; //$NON-NLS-1$
		} else if (IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS.equals(oldFile.getFileExtension())) {
			return newBaseName + "." + IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS; //$NON-NLS-1$
		}
		return null;
	}
	
	/**
	 * If the BPEL file has moved we have to move related files (e.g. .bpelex).
	 */
	protected void fileMoved(IFile oldBPELFile, IPath newBPELFilePath)
		throws CoreException {
		IFile[] relatedFiles = getRelatedFiles(oldBPELFile);
		for (int i = 0; i < relatedFiles.length; i++) {
			move(relatedFiles[i], newBPELFilePath);
		}

		// Fix the bpelex file - it contains a file reference to the bpel
		// file in each extension, which is incorrect now.
		fixBPELExtensionFile(oldBPELFile, newBPELFilePath);
		
		// notify listeners
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile newBPELFile = root.getFile(newBPELFilePath);
		for (Iterator<IFileChangeListener> iter = listeners.iterator(); iter.hasNext();) {
			IFileChangeListener listener = iter.next();
			listener.moved(oldBPELFile, newBPELFile);
		}
	}

	protected void fixBPELExtensionFile(IFile oldBPELFile, IPath newBPELFilePath) {
		// Find the path of the new bpelex file
		URI bpelURI = URI.createPlatformResourceURI(newBPELFilePath.toString() + "#/"); //$NON-NLS-1$
		IPath newBPELEXFilePath = newBPELFilePath.removeFileExtension().addFileExtension(IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS);
		URI extensionsURI = URI.createPlatformResourceURI(newBPELEXFilePath.toString());

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource extensionsResource = resourceSet.getResource(extensionsURI, true);
		try {
			extensionsResource.load(Collections.EMPTY_MAP);
			EList extensionContents = extensionsResource.getContents();
			ExtensionMap extensionMap = ExtensionmodelFactory.eINSTANCE.findExtensionMap(
					IBPELUIConstants.MODEL_EXTENSIONS_NAMESPACE, extensionContents);
			for (EObject next : extensionMap.keySet()) {
				if (next.eIsProxy()) {
					((InternalEObject) next).eSetProxyURI(bpelURI);
				}
			}
			extensionsResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Used to move files derived from a given source file. Moves the oldRelatedFile
	 * into the folder containing newBpelPath.
	 */
	protected void move(IFile oldRelatedFile, IPath newBpelPath) throws CoreException {
		if (oldRelatedFile.exists()) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFile newBpelFile = root.getFile(newBpelPath);
			IContainer folder = newBpelFile.getParent();
			String newBaseName = newBpelFile.getFullPath().removeFileExtension().lastSegment();
			String newName = getNewRelatedFileName(oldRelatedFile, newBaseName);
			IPath newRelatedFilePath = folder.getFullPath().append(newName);
			oldRelatedFile.move(newRelatedFilePath, true, null);
		}
	}

	/**
	 * If the BPEL file has been deleted we have to delete related files (e.g. .bpelex).
	 */
	protected void fileDeleted(IFile oldBPELFile, IProgressMonitor monitor) throws CoreException {
		// notify listeners
		for (IFileChangeListener listener : listeners) {
			listener.deleted(oldBPELFile);
		}
		// Delete bpelex file
		IFile bpelex = BPELUtil.getBPELEXFile(oldBPELFile);
		try {
			bpelex.delete(true, monitor);
		} catch (CoreException e) {
			BPELUIPlugin.log(e);
		}
	}
}
