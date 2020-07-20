/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.esb.core.utils.SynapseUtils;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.esb.project.model.ESBProjectModel;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBImageUtils;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class ESBProjectWizard extends AbstractWSO2ProjectCreationWizard {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String ESB_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.esb.project.nature";
	private IProject project;
	private ESBProjectModel esbProjectModel;
	private File pomfile;
	private Map<File,String> fileList = new HashMap<File,String>();

	public ESBProjectWizard() {
		setEsbProjectModel(new ESBProjectModel());
		setModel(esbProjectModel);
		setDefaultPageImageDescriptor(ESBImageUtils.getInstance().getImageDescriptor("esb-project-wizard.png"));
	}
	
	public boolean performFinish() {
		try {
			List<OMElement> esbArtiList = null; 
			if (esbProjectModel.getSelectedOption() != null && esbProjectModel.getSelectedOption().equals("new.esb.synapseConfig")) {
				esbArtiList =SynapseUtils.synapseConfigFolderContentProcessing(esbProjectModel.getSynapseConfigLocation().getPath());
			}
//			setProjectNature(ESB_PROJECT_NATURE);
			project = createNewProject();
			pomfile = project.getFile("pom.xml").getLocation().toFile();
			createPOM(pomfile,"pom");
			ProjectUtils.addNatureToProject(project,
											false,
			                                ESB_PROJECT_NATURE);
			MavenUtils
			.updateWithMavenEclipsePlugin(
					pomfile,
					new String[] { },
					new String[] { ESB_PROJECT_NATURE });
			
            // Adding Synapse unit testing framework client plugin to the ESB solution
            // project pom file.
            createSynapseUnitTestPlugin(pomfile);
			
			//Creating the metadata file artifact.xml while creating the ESB project. It will be hidden and users won't be able to see it via Eclipse.
			ESBProjectArtifact artifact=new ESBProjectArtifact();
			IFile file = project.getFile("artifact.xml");
			artifact.setSource(file.getLocation().toFile());
			artifact.toFile();
			getModel().addToWorkingSet(project);
			//Refresh the project to show the changes. But still won't see the newly created project.
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			refreshDistProjects();
			//Setting the created file to be hidden so that users won't see it.
			if(file.exists()){
				file.setHidden(true);
			}
			String groupId = getMavenGroupId(pomfile);
			if (esbProjectModel.getSelectedOption() != null && esbProjectModel.getSelectedOption().equals("new.esb.synapseConfig")) {				
				ESBProjectUtils.createESBArtifacts(esbArtiList,project,pomfile,fileList,groupId);
				
				ESBProjectUtils.updatePom(project);
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				refreshDistProjects();
				if (!fileList.isEmpty()) {
		            if (MessageDialog.openQuestion(getShell(), "Open file(s) in the Editor",
		                                           "Do you like to open the file(s) in Developer Studio?")) {
			            for (File f : fileList.keySet()) {
			            	openEditor(f,fileList);
			            }
		            }
	            }
			}
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error while creating the project",
                    e.getMessage());
			return false;

		}
		return true;
	}
	
	public File getPomFile() {
		return pomfile;
	}
	
	public static void openEditor(File file,Map<File,String> fileList){
		try {
			String type = fileList.get(file);
			IFile dbsFile  = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
					Path.fromOSString(file.getAbsolutePath()));
			if ("synConfig".equals(type)) {
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile);
			} else {
				String path = dbsFile.getParent().getFullPath()+"/";
				String source = FileUtils.getContentAsString(file);
				Openable openable = ESBGraphicalEditor.getOpenable();
				openable.editorOpen(file.getName(),type,path+type+"_", source);
			}

		} catch (Exception e) { 
			log.error("cannot open editor",e);
		}
	}

	public ESBProjectModel getEsbProjectModel() {
		return esbProjectModel;
	}

	public void setEsbProjectModel(ESBProjectModel esbProjectModel) {
		this.esbProjectModel = esbProjectModel;
	}
	
	public IResource getCreatedResource() {
		return project;
	}
	
	public void setCurrentSelection(ISelection currentSelection) {
		// TODO Auto-generated method stub
		super.setCurrentSelection(currentSelection);
	}
	
    private void createSynapseUnitTestPlugin(File pomFile) {
        try {
            MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
            Plugin unitTestPlugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven",
                    "synapse-unit-test-maven-plugin", "5.2.27", false);

            PluginExecution pluginExecution = new PluginExecution();
            pluginExecution.addGoal("synapse-unit-test");
            pluginExecution.setPhase("test");
            pluginExecution.setId("synapse-unit-test");
            unitTestPlugin.addExecution(pluginExecution);

            // adding plugin configuration
            Xpp3Dom unitTestConfElement = MavenUtils.createMainConfigurationNode(unitTestPlugin);
            Xpp3Dom serverDetails = MavenUtils.createXpp3Node(unitTestConfElement, "server");
            Xpp3Dom testServerType = MavenUtils.createXpp3Node(serverDetails, "testServerType");
            testServerType.setValue("${testServerType}");
            Xpp3Dom testServerHost = MavenUtils.createXpp3Node(serverDetails, "testServerHost");
            testServerHost.setValue("${testServerHost}");
            Xpp3Dom testServerPort = MavenUtils.createXpp3Node(serverDetails, "testServerPort");
            testServerPort.setValue("${testServerPort}");
            Xpp3Dom testServerPath = MavenUtils.createXpp3Node(serverDetails, "testServerPath");
            testServerPath.setValue("${testServerPath}");
            Xpp3Dom testCasesFilePath = MavenUtils.createXpp3Node(unitTestConfElement, "testCasesFilePath");
            testCasesFilePath.setValue("${project.basedir}" + File.separator + "test" + File.separator + "${testFile}");
            Xpp3Dom testSkip = MavenUtils.createXpp3Node(unitTestConfElement, "mavenTestSkip");
            testSkip.setValue("${maven.test.skip}");

            // save the pom with plugin configuration
            MavenUtils.saveMavenProject(mavenProject, pomfile);

        } catch (XmlPullParserException e) {
            log.error("Cannot parse the pom file", e);
        } catch (IOException e) {
            log.error("Error while saving the pom file", e);
        }
    }
}
