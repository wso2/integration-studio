/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.task.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.integrationstudio.artifact.task.Activator;
import org.wso2.integrationstudio.artifact.task.model.TaskModel;
import org.wso2.integrationstudio.artifact.task.util.TaskImageUtils;
import org.wso2.integrationstudio.artifact.task.validator.TriggerTypeList.TriggerType;
import org.wso2.integrationstudio.esb.core.ESBMavenConstants;
import org.wso2.integrationstudio.esb.core.exceptions.BuildArtifactCreationException;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.ui.editor.Openable;
import org.wso2.integrationstudio.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.integrationstudio.utils.file.FileUtils;

/**
 * WSO2 ESB task creation wizard class
 */
public class TaskCreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static IIntegrationStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Scheduled Task";
	private final TaskModel artifactModel;
	private IFile artifactFile;
	private ESBProjectArtifact esbProjectArtifact;
	private IProject esbProject;
	private List<File> fileLst = new ArrayList<File>();

	private String version = "1.0.0";
	public TaskCreationWizard() {
		artifactModel = new TaskModel();
		setModel(artifactModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(TaskImageUtils.getInstance().getImageDescriptor("taskLarge.png"));
	}

	@Override
	public IResource getCreatedResource() {
		return artifactFile;
	}

	@Override
	public boolean performFinish() {
		try {
			boolean isNewArtifact =true;
			esbProject = artifactModel.getSaveLocation().getProject();
			IContainer location = esbProject.getFolder("src/main/synapse-config/tasks");
			File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
			if (!pomfile.exists()) {
				createPOM(pomfile);
            }
            MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
            version = mavenProject.getVersion().replace("-SNAPSHOT", "");
			esbProjectArtifact = new ESBProjectArtifact();
			esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
            if (!esbProject.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER).exists()) {
                updatePom();
            }
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			String groupId = getMavenGroupId(pomfile) + ".task";
            if(getModel().getSelectedOption().equals("import.task")){
            	IFile task = location.getFile(new Path(getModel().getImportFile().getName()));
				if(task.exists()){
					if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
						return false;	
					}
					isNewArtifact = false;
				} 	
				copyImportFile(location,isNewArtifact,groupId);
            } else {
                artifactFile = location.getFile(new Path(artifactModel.getName() + ".xml"));
                File destFile = artifactFile.getLocation().toFile();
                FileUtils.createFile(destFile, getTemplateContent());
                fileLst.add(destFile);

                addESBArtifactDetails(location, artifactModel.getName(), groupId, version, artifactModel.getName(),
                        esbProjectArtifact);

                esbProjectArtifact.toFile();
            }
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            
			for (File file : fileLst) {
				if (file.exists()) {
					openEditor(file);
				}
			}
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		return true;
	}
	
	public void copyImportFile(IContainer importLocation,boolean isNewAritfact, String groupId) throws Exception {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedList = ((TaskModel)getModel()).getSelectedTasksList();
		if(selectedList != null && selectedList.size() >0 ){
			for (OMElement element : selectedList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
                if (isNewAritfact) {
                    addESBArtifactDetails(importLocation, name, groupId, version, name, esbProjectArtifact);
                }
			} 
			
		}else{
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$","");
            if (isNewAritfact) {
                addESBArtifactDetails(importLocation, name, groupId, version, name, esbProjectArtifact);
            }
		}
		try {
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

    private void addESBArtifactDetails(IContainer location, String taskName, String groupId, String version,
            String taskFileName, ESBProjectArtifact esbProjectArtifact) throws Exception {

        String relativeLocation = FileUtils
                .getRelativePath(esbProject.getLocation().toFile(),
                        new File(location.getLocation().toFile(), taskName + ".xml"))
                .replaceAll(Pattern.quote(File.separator), "/");
        esbProjectArtifact.addESBArtifact(createArtifact(taskName, groupId, version, relativeLocation));
        createTaskBuildArtifactPom(groupId, taskName, version, taskFileName, relativeLocation);
    }

    private void createTaskBuildArtifactPom(String groupId, String artifactId, String version, String taskFileName,
            String relativePathToRealArtifact) throws BuildArtifactCreationException {

        IContainer buildArtifactsLocation = esbProject.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
        try {
            SynapseUtils.createSynapseConfigBuildArtifactPom(groupId, artifactId, version,
                    SynapseConstants.TASK_CONFIG_TYPE, taskFileName, SynapseConstants.TASK_FOLDER,
                    buildArtifactsLocation, "../../../" + relativePathToRealArtifact);
        } catch (IOException | XmlPullParserException e) {
            throw new BuildArtifactCreationException("Error while creating the build artifacts for Task: "
                    + taskFileName + " at " + buildArtifactsLocation.getFullPath());
        }
    }
	
	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	protected boolean isRequiredWorkingSet() {
		return false;
	}
	
	private String getTemplateContent(){
		String content = new String();
		/*
		 * FIXME: use template extension-point instead of hard-coding template
		 * content
		 */
		content += "<task xmlns=\"";
		content += "http://ws.apache.org/ns/synapse\"";
		content += " name=\"";
		content += artifactModel.getName();
		content += "\" class=\"";
		content += artifactModel.getTaskImplementation();
		content += "\" group=\"";
		content += artifactModel.getGroup();
		if (artifactModel.getPinnedServers() != null
				&& artifactModel.getPinnedServers().length() > 0) {
			content += "\" pinnedServers=\"";
			content += artifactModel.getPinnedServers();
		}
		content += "\">\n"; 
		if(artifactModel.getTriggerType() ==TriggerType.CRON){
			content += "<trigger cron=\"" + artifactModel.getCron() + "\"/>";
		} else{
			if (artifactModel.getCount() == 1 && artifactModel.getInterval() == 0) {
				content += "<trigger once=\"true\"/>";
			} else{
				content += "<trigger count=\"" + artifactModel.getCount() + "\" interval=\""
						+ artifactModel.getInterval() + "\"/>";
			}
		}
		content += "\n</task>";
		return content;
	}
	
	
	private ESBArtifact createArtifact(String name,String groupId,String version,String path){
		ESBArtifact artifact=new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(SynapseConstants.TASK_CONFIG_TYPE);
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

    public void updatePom() throws IOException, XmlPullParserException {
        File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-task-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-task-plugin",
                ESBMavenConstants.WSO2_ESB_TASK_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("task");

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

	@Override
		public void openEditor(File file) {
		try{
		refreshDistProjects();
		IFile resource  = ResourcesPlugin
		.getWorkspace()
		.getRoot()
		.getFileForLocation(
				Path.fromOSString(file.getAbsolutePath()));
		/*IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),resource);*/
		String path = resource.getParent().getFullPath()+"/";
		String source = FileUtils.getContentAsString(file);
		Openable openable = ESBGraphicalEditor.getOpenable();
		openable.editorOpen(file.getName(),ArtifactType.TASK.getLiteral(),path, source);
		}catch(Exception e){
			log.error("Cannot open the editor", e);
		}
	}
}
