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
package org.eclipse.bpel.validator;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * Reads a BPEL file and makes it compatible with the BPEL tooling.
 */
public class BPELReader {

	/** TODO: The inclusion of this here removes the dependency on the UI plugin */
	static final String MODEL_EXTENSIONS_NAMESPACE = "http://org.eclipse.bpel.ui/"; //$NON-NLS-1$
	
	
	static final String EXTENSION_MODEL_EXTENSIONS = "bpelex"; //$NON-NLS-1$
	
	protected Resource processResource;
	protected Resource extensionsResource;
	protected Process process;
	protected ExtensionMap extensionMap;

	
	/**
	 * @param uri
	 * @param resourceSet
	 */
	
	public void read (URI uri, ResourceSet resourceSet) {
	
		processResource = resourceSet.getResource(uri, true);
		
		read(processResource, resourceSet);
		// readExtensions (processResource, resourceSet, modelFile);
	}
	
	/**
	 * Reads the given BPEL file. 
	 * @param modelFile 
	 * @param resourceSet 
	 */
	
	public void read (IFile modelFile, ResourceSet resourceSet ) {
		// TODO: These two lines are a workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=72565
//		EcorePackage instance = EcorePackage.eINSTANCE;
//		instance.eAdapters();

		URI uri = URI.createPlatformResourceURI (modelFile.getFullPath().toString());
			
		processResource = resourceSet.getResource(uri, true);	
		read(processResource, resourceSet);
		
		// readExtensions (processResource, resourceSet, modelFile);
	}
	
	/**
	 * @param file
	 * @param resourceSet
	 */
	public void read (File file, ResourceSet  resourceSet) {		
		URI uri = URI.createFileURI( file.getAbsolutePath() );
		processResource = resourceSet.getResource(uri, true);
		read(processResource , resourceSet );
		
		// readExtensions(processResource,resourceSet, file );
	}
	
	/**
	 * @param file
	 * @param resourceSet
	 */
	public void read (URL file, ResourceSet resourceSet)  {
		URI uri = URI.createURI(file.toString());
		processResource = resourceSet.getResource(uri, true);
		read(processResource , resourceSet );
		
		// readExtensions(processResource,resourceSet, file );		
	}
	/**
	 * Another public method for those who want to get the process resource
	 * by their own means (such as the editor).
	 * @param resource 
	 * @param resourceSet 
	 */
	
	public void read (Resource resource, ResourceSet resourceSet ) {
		
		// TODO: These two lines are a workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=72565
		// EcorePackage instance = EcorePackage.eINSTANCE;
		// instance.eAdapters();
		
		this.processResource = resource;
		this.process = null;
		
		try {
			processResource.load (Collections.EMPTY_MAP);
			EList contents = processResource.getContents();
			if (!contents.isEmpty()) {
				process = (Process) contents.get(0);
			}
			
		} catch (Exception e) {
			// TODO: If a file is empty Resource.load(Map) throws a java.lang.NegativeArraySizeException
			// We should investigate EMF to see if we are supposed to handle this case or if this
			// is a bug in EMF. 
			Activator.log(e);
		}
		
	}
	
	
	
	void readExtensions ( Resource resource, ResourceSet resourceSet, File modelFile) {
		return ;
	}
	
	void readExtensions ( Resource resource, ResourceSet resourceSet, IFile modelFile) {
		
//		IPath extensionsPath = modelFile.getFullPath().removeFileExtension().addFileExtension( EXTENSION_MODEL_EXTENSIONS );
//		URI extensionsUri = URI.createPlatformResourceURI(extensionsPath.toString());
//		IFile extensionsFile = ResourcesPlugin.getWorkspace().getRoot().getFile(extensionsPath);

		
//		try {
//			extensionsResource = resourceSet.getResource(extensionsUri, extensionsFile.exists());
//			if (extensionsResource != null) {
//				extensionMap = ExtensionmodelFactory.eINSTANCE.findExtensionMap(
//					MODEL_EXTENSIONS_NAMESPACE, extensionsResource.getContents());
//			}
//		} catch (Exception e) {
//			Activator.log(e);
//		}
//		
//		
//		if (extensionMap != null) extensionMap.initializeAdapter();
//
//		if (process == null) {
//			process = BPELFactory.eINSTANCE.createProcess();
//			processResource.getContents().add(process);
//		}
//		if (extensionMap == null) {
//			extensionMap = ExtensionmodelFactory.eINSTANCE.createExtensionMap( MODEL_EXTENSIONS_NAMESPACE );
//			if (extensionsResource == null) {
//				extensionsResource = resourceSet.createResource(extensionsUri);
//			}
//			extensionsResource.getContents().clear();
//			extensionsResource.getContents().add(extensionMap);
//		}
//
//			
//		// Make sure each model object has the necessary extensions!
//		TreeIterator it = process.eAllContents();
//		while (it.hasNext()) {
//			Object modelObject = it.next();
//			if (modelObject instanceof EObject) {
//				// ModelHelper.createExtensionIfNecessary(extensionMap, (EObject)modelObject);
//			}
//		}
//		
//		if (extensionMap.get(process) == null) {
//			// ModelHelper.createExtensionIfNecessary(extensionMap, process);
//		}
		
	}
		
	/**
	 * The extension map
	 * @return
	 */
	
	public ExtensionMap getExtensionMap() {
		return extensionMap;
	}
	
	/**
	 * @return the extension resource
	 */
	
	public Resource getExtensionsResource() {
		return extensionsResource;
	}
	
	/**
	 * 
	 * @return the process read or null
	 */
	public Process getProcess() {
		return process;
	}
	
	/**
	 * The process resource.
	 * @return the process resource
	 */
	public Resource getProcessResource() {
		return processResource;
	}
}
