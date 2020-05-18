/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.apim.project.wizard.creation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.apim.project.Activator;
import org.wso2.developerstudio.eclipse.apim.project.constant.APIMConstant;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class APIMProjectCreationWizard extends Wizard implements INewWizard, IExportWizard  {
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private final String WINDOW_TITLE = "New APIM Project";
    
    private APIMProjectCreationWizardPage creationPage;
    
	@Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        
        creationPage = new APIMProjectCreationWizardPage();
	}
	
	@Override
    public boolean canFinish() {
		if (creationPage.isPageComplete()) {
			return true;
		}
		return false;
    }
	
	@Override
    public boolean performFinish() {
        String projectName = creationPage.getProjectName();
        String projectLocation = creationPage.getProjectLocation();
        String projectAPIDefinition = creationPage.getProjectDefinitionPath();
        String projectAPIOAS = creationPage.getProjectOASPath();
        String locationWithProjectName = projectLocation + File.separator + projectName;
        String apiControllerPath = getAPIControllerPath();

        // execute local unit test server by given path and port
        Process processor = null;
        try {
            if (projectAPIDefinition == null && projectAPIOAS == null) {
                String[] cmd = { apiControllerPath, "init", locationWithProjectName };
                processor = Runtime.getRuntime().exec(cmd);
            } else if (projectAPIDefinition != null && projectAPIOAS == null) {
                String[] cmd = { apiControllerPath, "init", locationWithProjectName, "--definition",
                        projectAPIDefinition };
                processor = Runtime.getRuntime().exec(cmd);
            } else if (projectAPIDefinition == null && projectAPIOAS != null) {
                String[] cmd = { apiControllerPath, "init", locationWithProjectName, "--oas", projectAPIOAS };
                processor = Runtime.getRuntime().exec(cmd);
            } else {
                String[] cmd = { apiControllerPath, "init", locationWithProjectName, "--definition",
                        projectAPIDefinition, "--oas", projectAPIOAS };
                processor = Runtime.getRuntime().exec(cmd);
            }
            
            //log the apictl output
            BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(processor.getInputStream()));
            String line = null;
            while ((line = inputBuffer.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            log.error("IOException while creating APIM project using API Controller", e);
        } finally {
            if (processor != null) {
                processor.destroyForcibly();
            }
        }
        
        //create .project file inside the APIM project created
        createDotProjectFileGivenLocation(new File(locationWithProjectName));

        //open created project
        IProgressMonitor monitor = new NullProgressMonitor();
        try {
            final IWorkspace workspace = ResourcesPlugin.getWorkspace();
            final IProject project = workspace.getRoot().getProject(projectName);
            IProjectDescription newAPIMProjectDescription = project.getWorkspace().newProjectDescription(projectName);
            File subProjectFile = new File(locationWithProjectName);
            URI subProjectURI = subProjectFile.toURI();
            newAPIMProjectDescription.setLocationURI(subProjectURI);
            String[] subNatureIds = { Constants.APIM_PROJECT_NATURE };
            newAPIMProjectDescription.setNatureIds(subNatureIds);
            
            monitor.beginTask(APIMConstant.CREATING_APIM_PROJECT, 100);
            project.create(newAPIMProjectDescription, new SubProgressMonitor(monitor, 30));
            project.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 70));
            project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
        } catch (CoreException e) {
            log.error("CoreException while opening the created APIM project", e);
        } finally {
            monitor.done();
        }
        
        return true;
    }
	
    /**
     * Method of getting apictl path based on the OS type.
     * 
     * @return apictl path
     */
    private String getAPIControllerPath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(APIMConstant.TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = APIMConstant.TOOLING_PATH_MAC + File.separator + APIMConstant.APICTL_FOLDER + File.separator + "apictl";
            } else {
                java.nio.file.Path path = Paths.get(APIMConstant.EMPTY_STRING);
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + APIMConstant.APICTL_FOLDER + File.separator + "apictl";
            }
        } else {
            java.nio.file.Path path = Paths.get(APIMConstant.EMPTY_STRING);
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + APIMConstant.APICTL_FOLDER + File.separator + "apictl.exe";
        }
        return microInteratorPath;
    }
    
    /**
     * Create .project file with APIM project nature.
     * 
     * @param directory
     *            directory location
     */
    private void createDotProjectFileGivenLocation(File directory) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<projectDescription>\n" + "    <name>"
                + directory.getName() + "</name>\n" + "    <comment></comment>\n" + "    <projects>\n"
                + "    </projects>\n" + "    <buildSpec>\n" + "    </buildSpec>\n" + "    <natures>\n"
                + "        <nature>org.wso2.developerstudio.eclipse.apim.project.nature</nature>\n" + "    </natures>\n"
                + "</projectDescription>");

        try {
            // Parse the given input
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(stringBuilder.toString())));

            // Write the parsed document to an .project file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(
                    new File(directory.getAbsoluteFile() + File.separator + IProjectDescription.DESCRIPTION_FILE_NAME));
            transformer.transform(source, result);
        } catch (SAXException e) {
            log.error("SAXException while creating .project file inside APIM project", e);
        } catch (ParserConfigurationException e) {
            log.error("ParserConfigurationException while creating .project file inside APIM project", e);
        } catch (TransformerException e) {
            log.error("TransformerException while creating .project file inside APIM project", e);
        } catch (IOException e) {
            log.error("IOException while creating .project file inside APIM project", e);
        }
    }
	
	public void addPages() {
		addPage(creationPage);
        super.addPages();
    }
}
