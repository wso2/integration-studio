/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import java.io.*;
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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.axis2.Activator;
import org.wso2.developerstudio.eclipse.artifact.axis2.ui.action.exception.WSDLGenerationException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.wst.Axis2ServiceUtils;

import static org.apache.axis2.description.java2wsdl.Java2WSDLConstants.*;
import static org.eclipse.core.resources.IncrementalProjectBuilder.*;

/**
 * This is an Action class for generating WSDL file for an Axis2 service project created by DevStudio.
 */
public class WSDLGenerationAction implements IActionDelegate {
    private static final IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private IStructuredSelection selection;

    //String constants
    private static final String WSDL_EXTENSION = ".wsdl";
    private static final String SELECT_NAME_AND_LOCATION_MESSAGE = "Select name and location for the WSDL file";
    private static final String DEFAULT_RESOURCES_DIRECTORY = "src" + File.separator + "main" + File.separator + "resources";
    //This is the default Axis2 location in WSO2 Application server used in WSDL file, It can be changed by user later if necessary
    private static final String WSO2_SPECIFIC_AXIS2_LOCATION = "http://localhost:9763/services";

    /**
     * This method will be called when user clicks 'Generate WSDL' option from popup menu.
     * This method is having the logic to create WSDL file for selected Axis2 service project.
     */
    @Override
    public void run(IAction action) {
        if (selection != null && selection.getFirstElement() instanceof IProject) {
            IProject project = (IProject) selection.getFirstElement();
            try {
                generateWSDL(project);
            } catch (WSDLGenerationException e) {
                log.error("Error in generating WSDL file for project : " + project.getName() + " Message : " + e.getMessage(), e);
            } catch (CoreException e) {
                log.error("Error in generating WSDL file for project : " + project.getName(), e);
            }
        } else {
            log.error("Invalid selection for generating WSDL file, Selection : " + selection.getFirstElement().getClass()
                    + ", Expected : " + IProject.class);
        }
    }

    /**
     * This method is for setting current user selection to an instance variable
     */
    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            this.selection = (IStructuredSelection) selection;
        } else {
            log.error("Invalid user selection for generation WSDL file, Selection : " + selection.getClass() + ", Expected : "
                    + IStructuredSelection.class);
        }
    }

    /**
     * This method is for showing a location selector window to user to input the location of WSDL file
     * and for creating WSDL file using Java to WSDL code engine
     *
     * @param project Axis2 project
     * @throws org.wso2.developerstudio.eclipse.artifact.axis2.ui.action.exception.WSDLGenerationException
     * @throws org.eclipse.core.runtime.CoreException
     */
    private void generateWSDL(IProject project) throws WSDLGenerationException, CoreException {
        Shell shell = Display.getDefault().getActiveShell();
        List<File> classpathLocations = new ArrayList<File>();

        project.build(CLEAN_BUILD, null);
        project.build(FULL_BUILD, null);

        IJavaProject javaProject = JavaCore.create(project);
        IPath outputLocation;
        try {
            outputLocation = javaProject.getOutputLocation();
        } catch (JavaModelException e) {
            throw new WSDLGenerationException("Error in getting output location for Java project : " + javaProject, e);
        }
        File classPath = ResourcesPlugin.getWorkspace().getRoot().getFolder(outputLocation).getLocation().toFile();
        try {
            updateClassPathLocations(classPath, classpathLocations, project);
        } catch (JavaModelException e) {
            throw new WSDLGenerationException("Error in updating class path location for project : " + project.getName(), e);
        }

        IFolder resourcesDir = project.getFolder(new Path(DEFAULT_RESOURCES_DIRECTORY));
        String serviceClassName;
        try {
            serviceClassName = Axis2ServiceUtils.getServiceClassNameFromFolder(resourcesDir.getLocation().toOSString());
        } catch (Exception e) {
            throw new WSDLGenerationException("Error in extracting service class name from services.xml file, Location : "
                    + resourcesDir.getLocation().toOSString(), e);
        }
        String serviceName;
        try {
            serviceName = Axis2ServiceUtils.getServiceNameFromFolder(resourcesDir.getLocation().toOSString());
        } catch (Exception e) {
            throw new WSDLGenerationException("Error in extracting service name from services.xml file, Location : "
                    + resourcesDir.getLocation().toOSString(), e);
        }

        String serviceFileName = serviceName.concat(WSDL_EXTENSION);
        IFile defaultFile = resourcesDir.getFile(new Path(serviceFileName));
        IFile userSelectedFile = WorkspaceResourceDialog.openNewFile(shell, "WSDL for "
                        + serviceName, SELECT_NAME_AND_LOCATION_MESSAGE,
                defaultFile.getFullPath(), null);
        if (userSelectedFile == null) {
            return;
        }
        ITemporaryFileTag wsdlTempTag = FileUtils.createNewTempTag();
        File wsdlFile = generateWSDLFromJava2WSDLCodeGenEngine(serviceName, classpathLocations.toArray(new File[]{}), serviceClassName);
        InputStream wsdlFileStream;
        try {
            wsdlFileStream = new FileInputStream(wsdlFile);
        } catch (FileNotFoundException e) {
            throw new WSDLGenerationException("Error in creating input stream for generated WSDL file : " + wsdlFile.getName(), e);
        }
        if (userSelectedFile.exists()) {
            userSelectedFile.setContents(wsdlFileStream, IResource.FORCE, null);
        } else {
            userSelectedFile.create(wsdlFileStream, true, null);
        }

        project.refreshLocal(IResource.DEPTH_INFINITE, null);

        try {
            IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), userSelectedFile);
        } catch (PartInitException e) {
            log.error("Error in opening created WSDL file for Axis2 service : " + serviceName, e);
        } finally {
            wsdlTempTag.clearAndEnd();
        }
    }

    /**
     * This method is for creating WSDL file using Java to WSDL tool provided by apache
     *
     * @param serviceName
     * @param classPathLocations
     * @param serviceClassName
     * @throws org.wso2.developerstudio.eclipse.artifact.axis2.ui.action.exception.WSDLGenerationException
     */
    private File generateWSDLFromJava2WSDLCodeGenEngine(String serviceName, File[] classPathLocations,
                                                        String serviceClassName) throws WSDLGenerationException {
        File file;
        try {
            file = FileUtils.createTempFile();
        } catch (IOException e) {
            throw new WSDLGenerationException("Error in creating a temp file for keeping the contents of WSDL file", e);
        }
        Map<String, Java2WSDLCommandLineOption> map = new HashMap<String, Java2WSDLCommandLineOption>();

        addCommandLineOption(map, OUTPUT_LOCATION_OPTION,
                new String[]{file.getParentFile().toString()});
        addCommandLineOption(map, OUTPUT_FILENAME_OPTION,
                new String[]{file.getName()});
        addCommandLineOption(map, SERVICE_NAME_OPTION,
                new String[]{serviceName});
        addCommandLineOption(map, WSDL_VERSION_OPTION,
                new String[]{WSDL_VERSION_1});

        List<String> classPathListString = new ArrayList<String>();
        for (File classPathLocation : classPathLocations) {
            classPathListString.add(classPathLocation.toString());
        }
        addCommandLineOption(map, CLASSPATH_OPTION,
                classPathListString.toArray(new String[]{}));
        addCommandLineOption(map, CLASSNAME_OPTION,
                new String[]{serviceClassName});
        addCommandLineOption(map, LOCATION_OPTION,
                new String[]{WSO2_SPECIFIC_AXIS2_LOCATION + File.separator + serviceName});

        Java2WSDLCodegenEngine java2wsdlCodegenEngine;
        try {
            java2wsdlCodegenEngine = new Java2WSDLCodegenEngine(map);
            java2wsdlCodegenEngine.generate();
        } catch (Exception e) {
            throw new WSDLGenerationException("Error in generating WSDL file using Java2WSDLCodegenEngine, Option map : " + map, e);
        }
        return file;
    }

    /**
     * Method for adding command line option to a map
     *
     * @param map          Map contains command line options
     * @param option       Option to be added
     * @param optionValues values to be added
     */
    private static void addCommandLineOption(
            Map<String, Java2WSDLCommandLineOption> map, String option, String[] optionValues) {
        map.put(option, new Java2WSDLCommandLineOption(option, optionValues));
    }

    /**
     * Method for adding class path locations to a list
     *
     * @param classpathLocation  output location to be added
     * @param classpathLocations List that contains class path locations
     * @param project            Axis2 service project
     * @throws org.eclipse.jdt.core.JavaModelException
     */
    private void updateClassPathLocations(File classpathLocation,
                                          List<File> classpathLocations,
                                          IProject project)
            throws JavaModelException {
        classpathLocations.add(classpathLocation);
        IPackageFragmentRoot[] referencedLibrariesForProject = JavaUtils.getReferencedLibrariesForProject(project);
        for (IPackageFragmentRoot packageFragmentRoot : referencedLibrariesForProject) {
            IClasspathEntry resolvedClasspathEntry = JavaCore.getResolvedClasspathEntry(packageFragmentRoot.getRawClasspathEntry());
            IPath path = resolvedClasspathEntry.getPath();
            File libPath = path.toFile();
            if (!libPath.exists()) {
                libPath = project.getLocation().append(path.removeFirstSegments(1)).toFile();
            }
            classpathLocations.add(libPath);
        }
    }

}
