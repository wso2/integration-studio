/*
 * Copyright (c) 2011-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.template.wizards;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.lang.StringUtils;
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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.template.Activator;
import org.wso2.developerstudio.eclipse.artifact.template.model.TemplateModel;
import org.wso2.developerstudio.eclipse.artifact.template.utils.TemplateImageUtils;
import org.wso2.developerstudio.eclipse.artifact.template.validators.HttpMethodList.HttpMethodType;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class TemplateProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Template Artifact";
	private TemplateModel templateModel;
	private ESBProjectArtifact esbProjectArtifact;
	private List<File> fileLst = new ArrayList<File>();
	private IProject project;

	private String version ="1.0.0";

	
	public TemplateProjectCreationWizard() {
		this.templateModel = new TemplateModel();
		setModel(this.templateModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(TemplateImageUtils.getInstance().getImageDescriptor("template.png"));
	}

	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	public boolean performFinish() {
		try {
			project = templateModel.getTemplateSaveLocation().getProject();
			createSequenceArtifact(templateModel);
			if(fileLst.size()>0){
				openEditor(fileLst.get(0));
			}
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		return true;
	}
	
	private boolean createSequenceArtifact(TemplateModel sequenceModel) throws Exception {
        boolean isNewArtifact =true;
        IContainer location = project.getFolder("src" + File.separator + "main"
				+ File.separator + "synapse-config" + File.separator
				+ "templates");
		esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());	
		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("synapse/template");
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}

		updatePom();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		String groupId = getMavenGroupId(pomfile);
		groupId += ".template";

		if (getModel().getSelectedOption().equals("import.template")) {
			IFile sequence = location.getFile(new Path(getModel().getImportFile().getName()));
			if(sequence.exists()){
				if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
					return false;	
				}
				isNewArtifact = false;
			} 	
			copyImportFile(location,isNewArtifact,groupId);
		} else {
			String templateContent ="";
			String template = "";
			ArtifactTemplate selectedTemplate = templateModel.getSelectedTemplate();
			templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
			
			if (selectedTemplate.getName().equals("Address Endpoint Template")) {
				template = createEPTemplate(templateContent,"Address Endpoint Template");
			} else if (selectedTemplate.getName().equals("WSDL Endpoint Template")) {
				template = createEPTemplate(templateContent,"WSDL Endpoint Template");
			} else if (selectedTemplate.getName().equals("Default Endpoint Template")) {
				template = createEPTemplate(templateContent,"Default Endpoint Template");
			}else if (selectedTemplate.getName().equals("Sequence Template")) {
				template = createEPTemplate(templateContent,"Sequence Template");
			}else if (selectedTemplate.getName().equals("HTTP Endpoint Template")){
				template = createEPTemplate(templateContent,"HTTP Endpoint Template");
			}else {
				template = createEPTemplate(templateContent, "");
			}

			File destFile = new File(location.getLocation().toFile(),
					sequenceModel.getTemplateName() + ".xml");
			FileUtils.createFile(destFile, template);
			fileLst.add(destFile);
			ESBArtifact artifact = new ESBArtifact();
			artifact.setName(sequenceModel.getTemplateName());
			artifact.setVersion(version);
			if("Sequence Template".equals(selectedTemplate.getName())){
				artifact.setType("synapse/sequenceTemplate");
			}else{
				artifact.setType("synapse/endpointTemplate");
			}			
			artifact.setServerRole("EnterpriseServiceBus");
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(project.getLocation()
					.toFile(), new File(location.getLocation().toFile(),
					sequenceModel.getTemplateName() + ".xml")).replaceAll(Pattern.quote(File.separator), "/"));
			esbProjectArtifact.addESBArtifact(artifact);
		}
		esbProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		return true;
	}
	
	public String createEPTemplate(String templateContent, String type) throws IOException{
		String newContent="";
		if(type.equals("Sequence Template")){
			newContent=MessageFormat.format(templateContent,templateModel.getTemplateName());
		}else{
			templateContent = templateContent.replaceAll("\\{", "<");
			templateContent = templateContent.replaceAll("\\}", ">");
			newContent = StringUtils.replace(templateContent,"<ep.name>", templateModel.getTemplateName());
			if(type.equals("Address Endpoint Template")){
				newContent = StringUtils.replace(newContent,"<address.uri>", templateModel.getAddressEPURI());
			}else if(type.equals("WSDL Endpoint Template")){
				newContent = StringUtils.replace(newContent,"<wsdl.uri>", templateModel.getWsdlEPURI());
				newContent = StringUtils.replace(newContent,"<service.name>", templateModel.getWsdlEPService());
				newContent = StringUtils.replace(newContent,"<service.port>", templateModel.getWsdlEPPort());
			}else if (type.equals("HTTP Endpoint Template")) {
				newContent = StringUtils.replace(newContent,"<http.uritemplate>", templateModel.getHttpUriTemplate());				
				if(!HttpMethodType.Leave_as_is.name().equals(templateModel.getHttpMethod().name())){
				    newContent = StringUtils.replace(newContent,"<http.method>", templateModel.getHttpMethod().name().toLowerCase());
				} else{
					newContent = StringUtils.replace(newContent,"<http.method>", "");
				}
				
			}
		}
        return newContent;
	}

	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		version = mavenProject.getVersion();

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-template-plugin")) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-template-plugin",
				ESBMavenConstants.WSO2_ESB_TEMPLATE_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("template");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
	
	public void copyImportFile(IContainer importLocation,boolean isNewAritfact, String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedSeqList = ((TemplateModel)getModel()).getSelectedTempSequenceList();
		if(selectedSeqList != null && selectedSeqList.size() >0 ){
			for (OMElement element : selectedSeqList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
				if(isNewAritfact){
					ESBArtifact artifact = new ESBArtifact();
					artifact.setName(name);
					artifact.setVersion(version);
					artifact.setType("synapse/template");
					artifact.setServerRole("EnterpriseServiceBus");
					artifact.setGroupId(groupId);
					artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
							new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
							Pattern.quote(File.separator), "/"));
					esbProjectArtifact.addESBArtifact(artifact);
				}
			} 
		}else{
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$","");
			if(isNewAritfact){
				ESBArtifact artifact = new ESBArtifact();
				artifact.setName(name);
				artifact.setVersion(version);
				artifact.setType("synapse/template");
				artifact.setServerRole("EnterpriseServiceBus");
				artifact.setGroupId(groupId);
				artifact.setFile(FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
						new File(importLocation.getLocation().toFile(), name + ".xml")).replaceAll(
						Pattern.quote(File.separator), "/"));
				esbProjectArtifact.addESBArtifact(artifact);
			}
		}
	}
	
	protected boolean isRequiredWorkingSet() {
		return false;
	}
			
	public void openEditor(File file) {
		try {
			refreshDistProjects();
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(file))
					.getDocumentElement();
			String templateType = "";

			if (documentElement.getChildrenWithName(new QName("endpoint")) != null
					&& documentElement.getChildrenWithName(new QName("endpoint")).hasNext()) {
				// Endpoint template.
				templateType = ArtifactType.TEMPLATE_ENDPOINT.getLiteral();
				OMElement endpoint = (OMElement) documentElement.getChildrenWithName(
						new QName("endpoint")).next();
				String localName = endpoint.getFirstElement().getLocalName();
				if ("address".equals(localName)) {
					// Address endpoint template.
					templateType = ArtifactType.TEMPLATE_ENDPOINT_ADDRESS.getLiteral();
				} else if ("wsdl".equals(localName)) {
					// WSDL endpoint template.
					templateType = ArtifactType.TEMPLATE_ENDPOINT_WSDL.getLiteral();
				} else if ("http".equals(localName)) {
					// HTTP endpoint template.
					templateType = ArtifactType.TEMPLATE_ENDPOINT_HTTP.getLiteral();
				} else {
					// Default endpoint template. 
					templateType = ArtifactType.TEMPLATE_ENDPOINT_DEFAULT.getLiteral();
				}
			} else {
				// Sequence template.
				templateType = ArtifactType.TEMPLATE_SEQUENCE.getLiteral();
			}

			IFile dbsFile = ResourcesPlugin.getWorkspace().getRoot()
					.getFileForLocation(Path.fromOSString(file.getAbsolutePath()));
			String path = dbsFile.getParent().getFullPath() + "/";
			String source = FileUtils.getContentAsString(file);
			Openable openable = ESBGraphicalEditor.getOpenable();
			openable.editorOpen(file.getName(), templateType, path, source);
		} catch (Exception e) {
			log.error("Cannot open the editor", e);
		}
	}

	@Override
	public IResource getCreatedResource() {
		return null;
	} 

}
