/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.axis2.ui.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ws.java2wsdl.Java2WSDLCodegenEngine;
import org.apache.ws.java2wsdl.utils.Java2WSDLCommandLineOption;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import static org.eclipse.core.resources.IncrementalProjectBuilder.*;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.axis2.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.wst.Axis2ServiceUtils;

import static org.apache.axis2.description.java2wsdl.Java2WSDLConstants.*;

public class WSDLGenerationAction  implements IActionDelegate {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	IStructuredSelection selection;
	
	
	public void run(IAction action) {
		if (selection != null) {
			 try {
				 IProject project = (IProject)selection.getFirstElement();
				 generateWSDL(project);
			} catch (Exception e) {
				log.error("unable to generate WSDL ", e);
			}
		}
	}

	
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		}	
	}
	
	public void generateWSDL(IProject project) throws Exception {
		Shell shell = Display.getDefault().getActiveShell();
		List<File> classpathLocations=new ArrayList<File>();
		project.build(CLEAN_BUILD, null);
		project.build(FULL_BUILD, null);
		IJavaProject javaProject = JavaCore.create(project);
		File classPath = ResourcesPlugin.getWorkspace().getRoot().getFolder(javaProject.getOutputLocation()).getLocation().toFile();
		IFolder resourcesDir = project.getFolder(new Path("src" + File.separator + "main" + File.separator+ "resources"));
		String serviceClassName =  Axis2ServiceUtils.getServiceClassNameFromFolder(resourcesDir.getLocation().toOSString());
		String serviceName = Axis2ServiceUtils.getServiceNameFromFolder(resourcesDir.getLocation().toOSString());
		getClassPathLocationsList(classPath,classpathLocations, project);
		String serviceFileName = serviceName.concat(".wsdl");
		IFile openNewFile  = resourcesDir.getFile(new Path(serviceFileName));
		openNewFile = WorkspaceResourceDialog.openNewFile(shell, "WSDL for "
				+ serviceName, "Select name and location for the WSDL file",
				openNewFile.getFullPath(), null);
		if (openNewFile == null) {
			return;
		}
		ITemporaryFileTag wsdlTempTag = FileUtils.createNewTempTag();
		File wsdlFile = generateWSDLFromJavaClass(serviceName,classpathLocations.toArray(new File[]{}),serviceClassName);
		if (openNewFile.exists()){
			openNewFile.setContents(new FileInputStream(wsdlFile), IResource.FORCE, null);
		}else{
			openNewFile.create(new FileInputStream(wsdlFile), true, null);
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		try {
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),openNewFile);
		} catch (Exception e) { /* ignore */
			
		}finally{
			wsdlTempTag.clearAndEnd();
		}
	}
	
	public File generateWSDLFromJavaClass(String serviceName, File[] classpathLocations,
	        String serviceClassName) throws Exception {
		File file = FileUtils.createTempFile();
		Map<String, Java2WSDLCommandLineOption> map =
		        new HashMap<String, Java2WSDLCommandLineOption>();
		addCommandLineOption(map, OUTPUT_LOCATION_OPTION,
		                     new String[] { file.getParentFile().toString() });
		addCommandLineOption(map, SERVICE_NAME_OPTION,
		                     new String[] { serviceName });
		addCommandLineOption(map, WSDL_VERSION_OPTION,
		                     new String[] { WSDL_VERSION_1 });
		addCommandLineOption(map, OUTPUT_FILENAME_OPTION,
		                     new String[] { file.getName() });
		List<String> classPathListString=new ArrayList<String>();
		for (File classPathLocation : classpathLocations) {
			classPathListString.add(classPathLocation.toString());
		}
		addCommandLineOption(map, CLASSPATH_OPTION,
				(String[])classPathListString.toArray(new String[] {}));
		addCommandLineOption(map, CLASSNAME_OPTION,
		                     new String[] { serviceClassName });
		Java2WSDLCodegenEngine java2wsdlCodegenEngine = new Java2WSDLCodegenEngine(map);
		java2wsdlCodegenEngine.generate();
		return file;
	}
	
	private static Java2WSDLCommandLineOption addCommandLineOption(
	        Map<String, Java2WSDLCommandLineOption> map, String option, String[] optionValues) {
		return map.put(option, new Java2WSDLCommandLineOption(option, optionValues));
	}
	


	public void getClassPathLocationsList(File classpathLocation,
										  List<File> classpathLocations, 
										  IProject project)
										  throws JavaModelException {
		classpathLocations.add(classpathLocation);
		IPackageFragmentRoot[] referencedLibrariesForProject = JavaUtils.getReferencedLibrariesForProject(project);
		for (IPackageFragmentRoot packageFragmentRoot : referencedLibrariesForProject) {
			IClasspathEntry resolvedClasspathEntry = JavaCore.getResolvedClasspathEntry(packageFragmentRoot.getRawClasspathEntry());
			IPath path = resolvedClasspathEntry.getPath();
			File libPath = path.toFile();
			if (!libPath.exists()){
				libPath=project.getLocation().append(path.removeFirstSegments(1)).toFile();
			}
			classpathLocations.add(classpathLocation);
		}
	}	

}
