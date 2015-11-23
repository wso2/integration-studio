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

package org.wso2.developerstudio.eclipse.artifact.synapse.api.ui.wizard;

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
import org.wso2.developerstudio.eclipse.artifact.synapse.api.Activator;
import org.wso2.developerstudio.eclipse.artifact.synapse.api.model.APIArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.synapse.api.util.APIImageUtils;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


/**
 * WSO2 ESB API creation wizard class
 */
public class SynapseAPICreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Synapse API";
	private final APIArtifactModel artifactModel;
	private IFile artifactFile;
	private ESBProjectArtifact esbProjectArtifact;
	private IProject esbProject;
	private List<File> fileLst = new ArrayList<File>();

	private String version;
	
	public SynapseAPICreationWizard() {
		artifactModel = new APIArtifactModel();
		setModel(artifactModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(APIImageUtils.getInstance().getImageDescriptor("synapseAPILarge.png"));
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
			IContainer location = esbProject.getFolder("src/main/synapse-config/api");
			File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
			if (!pomfile.exists()) {
				createPOM(pomfile);
			}
			esbProjectArtifact = new ESBProjectArtifact();
			esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
			updatePom();
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			String groupId = getMavenGroupId(pomfile) + ".api";
			if(getModel().getSelectedOption().equals("import.api")){
				IFile api = location.getFile(new Path(getModel().getImportFile().getName()));
				if(api.exists()){
					if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
						return false;	
					}
					isNewArtifact = false;
				} 	
				copyImportFile(location,isNewArtifact,groupId);
			}else{			
			artifactFile = location.getFile(new Path(artifactModel.getName() + ".xml"));
			File destFile = artifactFile.getLocation().toFile();
			FileUtils.createFile(destFile, getTemplateContent());
			fileLst.add(destFile);
			String relativePath = FileUtils.getRelativePath(esbProject.getLocation().toFile(),
					new File(location.getLocation().toFile(), artifactModel.getName() + ".xml"))
					.replaceAll(Pattern.quote(File.separator), "/");
			esbProjectArtifact.addESBArtifact(createArtifact(artifactModel.getName(), groupId,
					version, relativePath));	
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
		content += "<api xmlns=\"";
		content += "http://ws.apache.org/ns/synapse\"";
		content += " context=\"";
		content += artifactModel.getContext();
		content += "\" name=\"";
		content += artifactModel.getName();
		content += "\""; 
		if(artifactModel.getHostname()!=null && artifactModel.getHostname().length()>0){
			content += " hostname=\"";
			content += artifactModel.getHostname();
			content += "\"";
		}
		if(artifactModel.getPort()>0){
			content += " port=\"";
			content += artifactModel.getPort();
			content += "\"";
		}
		content += ">\n";
		content += "<resource methods=\"GET\">";
		content += "<inSequence/>";
		content += "<outSequence/>";
		content += "<faultSequence/>";
		content += "</resource>\n";
		content += "</api>";
		return content;
	}
	
	
	public void copyImportFile(IContainer importLocation,boolean isNewAritfact, String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedAPIsList = ((APIArtifactModel)getModel()).getSelectedAPIsList();
		if(selectedAPIsList != null && selectedAPIsList.size() >0 ){
			for (OMElement element : selectedAPIsList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
				if(isNewAritfact){
					String relativePath = FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
							new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
							Pattern.quote(File.separator), "/");
					esbProjectArtifact.addESBArtifact(createArtifact(name, groupId, version,
							relativePath));
				}
			} 
			
		}else{
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$","");
			if(isNewAritfact){
				String relativePath = FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
						new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
						Pattern.quote(File.separator), "/");
				esbProjectArtifact.addESBArtifact(createArtifact(name, groupId, version,
						relativePath));
			}
		}
		try {
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	private ESBArtifact createArtifact(String name,String groupId,String version,String path){
		ESBArtifact artifact=new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType("synapse/api");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}
	
	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		version = mavenProject.getVersion();

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-api-plugin")) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-api-plugin",
				ESBMavenConstants.WSO2_ESB_API_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("api");

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
	IFile dbsFile  = ResourcesPlugin
	.getWorkspace()
	.getRoot()
	.getFileForLocation(
			Path.fromOSString(file.getAbsolutePath()));
	/*IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile);*/
	String path = dbsFile.getParent().getFullPath()+"/";
	String source = FileUtils.getContentAsString(file);
	Openable openable = ESBGraphicalEditor.getOpenable();
	openable.editorOpen(file.getName(),ArtifactType.API.getLiteral(),path, source);
	}catch(Exception e){
		log.error("Cannot open the editor", e);
	}
}
	
}
