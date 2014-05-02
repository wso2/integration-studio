/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.ui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddFactory;
import org.eclipse.bpel.model.Process;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.ModuleCoreNature;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

/**
 * @author Simon Moser (IBM)
 * @author Tammo van Lessen (IAAS)
 */
public class DeployUtils {

	public static final String URL_PREFIX_FILE = "file"; //$NON-NLS-1$
	public static final String URL_PREFIX_PLATFORM = "platform"; //$NON-NLS-1$
	public static final String URL_PREFIX_RESOURCE = "resource"; //$NON-NLS-1$
	public static final String NONE_STRING = "-- none -- "; //$NON-NLS-1$
	public static final String BPEL_CONTENT_TYPE = "org.eclipse.bpel.contenttype"; //$NON-NLS-1$

	
	public static ProcessType findProcessTypeInDD(org.eclipse.bpel.model.Process process, TDeployment dd) {
		for (ProcessType pt : dd.getProcess()) {
			if (   pt.getName().getLocalPart().equals(process.getName())
				&& pt.getName().getNamespaceURI().equals(process.getTargetNamespace())) {
				return pt;
			}
		}
		return null;
	}

	public static ProcessType createProcessStub(org.eclipse.bpel.model.Process process) {
		ProcessType pt = ddFactory.eINSTANCE.createProcessType();
		QName processQName = new QName(process.getTargetNamespace(),process.getName() );
		pt.setName(processQName);
		return pt;
	}

	public static QName getQNameFromSerialzedForm(String qNameAsString) {
		
		int pos = qNameAsString.lastIndexOf("}"); //$NON-NLS-1$
		
		String ns = qNameAsString.substring(1, pos);
		String name = qNameAsString.substring(pos+1, qNameAsString.length());
		
		QName qName = new QName(ns, name);
		
		return qName;
	}
	
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	public static Port findPortByName(String name, IProject bpelProject, ResourceSet resourceSet){
	
		List serviceList = new ArrayList();
		List portList = new ArrayList();
		
		List<Definition> wsdlDefs = DeployUtils.loadAllWSDLFromProject(bpelProject, resourceSet);
		//Assemble All Services from WSDL's 
		for (Iterator<Definition> iterator = wsdlDefs.iterator(); iterator.hasNext();) {
			Definition current = (Definition) iterator.next();
			Map services = current.getServices();
			if (!services.isEmpty()){
				Collection values = services.values();	
				for (Iterator iterator2 = values.iterator(); iterator2.hasNext();) {
					Service name2 =(Service) iterator2.next();
					serviceList.add(name2);					
				}
			}
		}
		
		//now we have all services in a List .. get All Ports from these services
		for (Iterator iterator = serviceList.iterator(); iterator.hasNext();) {
			Service currentService = (Service) iterator.next();
			Map portMap = currentService.getPorts();
			Collection ports = portMap.values();
			portList.addAll(ports);
		}
		
		for (Iterator iterator = portList.iterator(); iterator.hasNext();) {
			Port currentPort = (Port) iterator.next();
			if (currentPort.getName().equals(name)){
				return currentPort;
			}
		}
		
		return null;
		
	}
	
	public static Process loadBPEL(IFile bpelFile, ResourceSet resourceSet) {

		IPath fullProcessPath = bpelFile.getFullPath();
		URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
		Resource bpelResource = resourceSet.getResource(uri, true);

		EcorePackage instance = EcorePackage.eINSTANCE;
		instance.eAdapters();

		try {
			if (bpelResource.isLoaded()) {
				bpelResource.unload();
			}
			bpelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = bpelResource.getContents();
			if (!contents.isEmpty()) {
				return (Process) contents.get(0);
			}
		} catch (Exception e) {
			//swallow exception
		}

		return null;
	}
	
	public static Definition loadWSDL(IFile wsdlFile, ResourceSet resourceSet) {

		IPath fullProcessPath = wsdlFile.getFullPath();
		URI uri = URI.createPlatformResourceURI(fullProcessPath.toString(), false);
		Resource wsdlResource = resourceSet.getResource(uri, true);

		EcorePackage instance = EcorePackage.eINSTANCE;
		instance.eAdapters();

		try {
			wsdlResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = wsdlResource.getContents();
			if (!contents.isEmpty()) {
				return (Definition) contents.get(0);
			}
		} catch (Exception e) {
			//swallow exception
		}

		return null;
	}
	
	public static List<Definition> loadAllWSDLFromProject(IProject project, ResourceSet resourceSet) 
	{
		List<Definition> wsdlFiles = new ArrayList<Definition>();
		
		List<IFile> allFiles = DeployUtils.getAllFilesInProject(project);
		
		for (IFile file : allFiles) {

			// Bugzilla 320545: oops! I think we meant to say it like this instead:
			if ("wsdl".equalsIgnoreCase(file.getFileExtension())) { //$NON-NLS-1$
//			if (file.getFileExtension().equalsIgnoreCase("wsdl")) {				 //$NON-NLS-1$
//				load it 
				Definition currentDef = loadWSDL(file, resourceSet);
//				stuff it in wsdlFiles
				wsdlFiles.add(currentDef);				
			}
		}
		
		// Bugzilla 324164
		// Add WSDLs that were resolved as imports, to the list
		for (Resource res : resourceSet.getResources())
		{
			// fix a dumb mistake: XSDs don't have Definitions
			// and will cause this to throw a class cast exception
			EList<EObject>contents = res.getContents();
			if (contents!=null && !contents.isEmpty()) {
				Object obj = contents.get(0);
				if (obj instanceof Definition)
				{
					Definition def = (Definition)obj;
					if (!wsdlFiles.contains(def))
						wsdlFiles.add(def);
				}
			}
		}
		return wsdlFiles;
	}
	
	public static List<Process> loadAllBPELFromProject(IProject project, ResourceSet resourceSet) 
	{
		List<Process> bpelFiles = new ArrayList<Process>();
		
		List<IFile> allFiles = DeployUtils.getAllFilesInProject(project);
		
		for (IFile file : allFiles) {

			// Bugzilla 320545:
			if (DeployUtils.isBPELFile(file)) {
//				load it 
				Process currentProcess = loadBPEL(file, resourceSet);
//				stuff it in bpelFiles
				// Bug 330396 -  Can't create ODE Deployment Descriptor
				// make sure the BPEL is valid
				if (currentProcess!=null)
					bpelFiles.add(currentProcess);				
			}
		}
		
		return bpelFiles;
	}
	
	
	public static List<IFile> getAllFilesInProject(IProject project) {
		final List<IFile> files = new ArrayList<IFile>();
		IResourceVisitor visitor = new IResourceVisitor() {
			public boolean visit(org.eclipse.core.resources.IResource resource) throws org.eclipse.core.runtime.CoreException {
				if (resource.getType() == IResource.FILE) {
					files.add((IFile)resource);
				}
				return true;
			}
		};
		try {
			IResource[] reses = project.getFolder(getWebContentRootPath(project)).members();
			for (IResource res : reses) {
				res.accept(visitor);

			}
		} 
		catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return files;
	}

	public static IFile getIFileForURI(URI uri) {

		if(uri == null) return null; 
		
	    String filePath = null;
		String scheme = uri.scheme();

		if (URL_PREFIX_FILE.equals(scheme)) {
			filePath = uri.toFileString();
		} else if (URL_PREFIX_PLATFORM.equals(scheme) && uri.segmentCount() > 1 && URL_PREFIX_RESOURCE.equals(uri.segment(0))) {
			StringBuffer platformResourcePath = new StringBuffer();
			for (int i = 1, size = uri.segmentCount(); i < size; ++i) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(i));
			}
			filePath = URI.decode(platformResourcePath.toString()); 
		}

		if (filePath == null)
			return null;

		IFile file = null;

		if (URL_PREFIX_FILE.equals(scheme)){ //44110
			if(uri.device()!= null){
				filePath = filePath.substring(filePath.indexOf(uri.device()));
			}
			file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(filePath));
		}else
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePath));

		return file; 
	}
	
	// Bugzilla 320545:
	public static boolean isBPELFile(IResource res)
	{
		try
		{
			if (res.getType() == IResource.FILE) {
				// check if file was recognized by eclipse BPEL editor
				IContentDescription desc = ((IFile) res).getContentDescription();
				if (desc != null) {
					IContentType type = desc.getContentType();
					if (type.getId().equals(BPEL_CONTENT_TYPE))
						return true;
				}
				
				// this causes all kinds of nasty stack traces - see https://jira.jboss.org/browse/JBIDE-6093
				// since this version of the ODE deployment editor is part of the same feature as the BPEL editor
				// plugin, we'll go on the assumption that they will always be installed together. You'd have to
				// something pretty dangerous to install one without the other.
				// maybe the eclipse BPEL editor is not installed?
				// fall back to using '.bpel' file extension
				//if ("bpel".equals(((IFile)res).getFileExtension()))
				//	return true;
			}
		}
		catch(Exception ex)
		{
		}
		return false;	
	}
	
	
	public static IPath getWebContentRootPath(IProject project) {
		if (project == null)
			return null;

		if (!ModuleCoreNature.isFlexibleProject(project))
			return null;

		IPath path = null;
		IVirtualComponent component = ComponentCore.createComponent(project);
		if (component != null && component.exists()) {
			path = component.getRootFolder().getProjectRelativePath();
		}
		return path;
	}	
}
