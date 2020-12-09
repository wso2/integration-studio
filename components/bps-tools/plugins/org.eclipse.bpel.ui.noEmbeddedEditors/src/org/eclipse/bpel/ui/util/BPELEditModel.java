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
package org.eclipse.bpel.ui.util;

import org.eclipse.bpel.common.ui.editmodel.EditModel;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * Sharable EditModel, customized for the BPELEditor.
 */
public class BPELEditModel extends EditModel {

	protected IFile extensionsFile;
	protected IFile artifactsFile;
	
	/*
	 * Protected constructor. Use the static factory methods. 
	 */
	protected BPELEditModel(ResourceSet resourceSet,IResource primaryFile) {
		super(resourceSet, primaryFile);
	}

	static class BPELEditModelFactory extends EditModel.Factory {
		@Override
		protected EditModel createEditModel(ResourceSet resourceSet,IResource primaryFile) { 
			return new BPELEditModel(resourceSet, primaryFile);
		}
	}
	
	public static EditModel getEditModel(IResource primaryFile) {
		return getEditModel(primaryFile, new BPELEditModelFactory());
	}
	
	/**
	 * Returns an IFile representing the Extensions file (the .bpelex file).
	 */
	public IFile getExtensionsFile() {
		if (extensionsFile == null) {
			IPath extensionsPath = getPrimaryFile().getFullPath().removeFileExtension().addFileExtension(IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS);
			extensionsFile = ResourcesPlugin.getWorkspace().getRoot().getFile(extensionsPath);
		}
		return extensionsFile;
	}
	
	/**
	 * Returns an IFile representing the Artifacts WSDL for the primaryFile (BPEL file).
	 */
	public IFile getArtifactsFile() {
		if (artifactsFile == null) {
			// TODO: there might be a simpler way to do this.
			IPath artifactsPath = getPrimaryFile().getFullPath().removeFileExtension();
			String shortName = artifactsPath.lastSegment()+"Artifacts"; //$NON-NLS-1$
			artifactsPath = artifactsPath.removeLastSegments(1).append(shortName).addFileExtension(IBPELUIConstants.EXTENSION_WSDL);
			artifactsFile = ResourcesPlugin.getWorkspace().getRoot().getFile(artifactsPath);
		}
		return artifactsFile;
	}	
}
