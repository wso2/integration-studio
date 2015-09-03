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

package org.wso2.developerstudio.eclipse.artifact.registry.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.artifact.registry.Activator;
import org.wso2.developerstudio.eclipse.artifact.registry.model.RegistryArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryResourceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryTemplate;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryCollection;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryDump;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.greg.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.greg.manager.local.utils.RegistryCheckInClientUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfo;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfoDoc;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsPage;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RegistryResourceCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static final String REGISTRY_EDITOR_ID = "org.wso2.developerstudio.eclipse.artifact.registry.editor";
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String PROJECT_WIZARD_WINDOW_TITLE = "New Registry Resource";
	private final RegistryArtifactModel regModel;
	private IFile resourceFile;
	
	public RegistryResourceCreationWizard() {
		regModel = new RegistryArtifactModel();
		setModel(regModel);
		setWindowTitle(PROJECT_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(RegistryResourceImageUtils.getInstance().getImageDescriptor("registry-artifact-wizard.png"));
	}
	
	
	public IResource getCreatedResource() {
		return null;
	}
	
	public boolean performFinish() {
		try {
			File destFile = null;
			String templateContent = "";
			String template = "";
			RegistryArtifactModel regModel = (RegistryArtifactModel) getModel();
			IContainer resLocation = regModel.getResourceSaveLocation();
			IProject project =  resLocation.getProject();
//			File registryInfoFile = project.getFile(REGISTRY_INFO_FILE)
//					.getLocation().toFile();
			RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();
			if (getModel().getSelectedOption().equals(RegistryArtifactConstants.OPTION_NEW_RESOURCE)) {

				RegistryTemplate selectedTemplate = regModel.getSelectedTemplate();
				templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
				template = createTemplate(templateContent,selectedTemplate.getId());
				
				resourceFile= resLocation.getFile(new Path(regModel.getResourceName() + "." + selectedTemplate.getTemplateFileName().substring(selectedTemplate.getTemplateFileName().lastIndexOf(".")+1)));
				destFile = resourceFile.getLocation().toFile();
				FileUtils.createFile(destFile, template);
				RegistryResourceUtils.createMetaDataForFolder(regModel.getCompleteRegistryPath(), resLocation.getLocation().toFile());
				RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,project.getLocation().toFile(),regModel.getCompleteRegistryPath());
				
			} else if (getModel().getSelectedOption().equals(RegistryArtifactConstants.OPTION_IMPORT_RESOURCE)) {
				File importFile = getModel().getImportFile();
				if(importFile.isDirectory()){
					if (regModel.getCopyContent()) {
						FileUtils.copyDirectoryContents(importFile, resLocation.getLocation().toFile());
						RegistryResourceUtils.createMetaDataForFolder(regModel.getCompleteRegistryPath(), resLocation.getLocation().toFile());
						File[] listFiles = importFile.listFiles();
						for (File res : listFiles) {
							File distFile = new File(resLocation.getLocation().toFile(),res.getName());
							RegistryResourceUtils.addRegistryResourceInfo(distFile,
									regResInfoDoc, project.getLocation().toFile(),
									regModel.getCompleteRegistryPath());
						}
					} else {
						File folder = new File(resLocation.getLocation().toFile() , importFile.getName()); 
//						IFolder folder = resLocation.getProject().getFolder(getModel().getImportFile().getName());
						FileUtils.copyDirectoryContents(importFile, folder);
						
						RegistryResourceUtils.createMetaDataForFolder(regModel.getCompleteRegistryPath(), folder);
						RegistryResourceUtils.addRegistryResourceInfo(folder, regResInfoDoc,project.getLocation().toFile(),regModel.getCompleteRegistryPath());
					}
				} else{
					resourceFile = resLocation.getFile(new Path(importFile.getName()));
					destFile = resourceFile.getLocation().toFile();
					FileUtils.copy(importFile, destFile);
					RegistryResourceUtils.createMetaDataForFolder(regModel.getCompleteRegistryPath(), destFile.getParentFile());
					RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,project.getLocation().toFile(),regModel.getCompleteRegistryPath());
				}
				
			} else if (getModel().getSelectedOption().equals(RegistryArtifactConstants.OPTION_IMPORT_DUMP)){
				File importFile = getModel().getImportFile();
				resourceFile = resLocation.getFile(new Path(importFile.getName()));
				destFile = resourceFile.getLocation().toFile();
				FileUtils.copy(importFile, destFile);
				//RegistryResourceUtils.createMetaDataForFolder(regModel.getRegistryPath(), destFile.getParentFile());
				RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,project.getLocation().toFile(),regModel.getCompleteRegistryPath(),RegistryArtifactConstants.REGISTRY_DUMP);
			} else if (getModel().getSelectedOption().equals(RegistryArtifactConstants.OPTION_CHECKOUT_PATH)){
				RegistryResourceNode checkoutPath = regModel.getCheckoutPath();
				RegistryNode connectionInfo = checkoutPath.getConnectionInfo();
				String registryResourcePath = checkoutPath.getRegistryResourcePath();
				String resourceName = !checkoutPath.getCaption().equals("/")?checkoutPath.getCaption():"root";
				resourceFile = resLocation.getFile(new Path(resourceName));
				destFile = resourceFile.getLocation().toFile();
				regModel.setResourceName(resourceName);
				if(checkoutPath.getResourceType()==RegistryResourceType.COLLECTION){
					RegistryCheckInClientUtils.checkout(connectionInfo.getUsername(), connectionInfo.getPassword(), destFile.toString(), connectionInfo.getUrl().toString().concat("/"), registryResourcePath);
					RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,project.getLocation().toFile(),regModel.getCompleteRegistryPath());
				} else{
					RegistryCheckInClientUtils.download(connectionInfo.getUsername(), connectionInfo.getPassword(), destFile.toString(), connectionInfo.getUrl().toString().concat("/"), registryResourcePath);
					RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,project.getLocation().toFile(),regModel.getCompleteRegistryPath());
				}
				
			}
			
			//STOPPed serializing the reg-info.xml file to avoid generating the file but keep the process since we need to entries in the reg-info.xml file
//			regResInfoDoc.toFile(registryInfoFile);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			getModel().getMavenInfo().setPackageName("registry/resource");
			updatePOM(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			File pomLocation = project.getFile("pom.xml").getLocation().toFile();
			String groupId = getMavenGroupId(pomLocation);
			groupId += ".resource";
			MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
			String version = mavenProject.getVersion();
			//Adding the metadata about the endpoint to the metadata store.
			GeneralProjectArtifact generalProjectArtifact=new GeneralProjectArtifact();
			generalProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
			
			RegistryArtifact artifact=new RegistryArtifact();
			artifact.setName(regModel.getArtifactName());
			artifact.setVersion(version);
			artifact.setType("registry/resource");
			artifact.setServerRole("GovernanceRegistry");
			artifact.setGroupId(groupId);
			List<RegistryResourceInfo> registryResources = regResInfoDoc.getRegistryResources();
			for (RegistryResourceInfo registryResourceInfo : registryResources) {
				RegistryElement item = null;
				// item.setFile("resources"+File.separator+registryResourceInfo.getResourceBaseRelativePath());
				if (registryResourceInfo.getType() == RegistryArtifactConstants.REGISTRY_RESOURCE) {
					item = new RegistryItem();
					((RegistryItem) item).setFile(registryResourceInfo.getResourceBaseRelativePath().replaceAll(Pattern.quote(File.separator), "/"));
					((RegistryItem)item).setMediaType(registryResourceInfo.getMediaType());
				} else if (registryResourceInfo.getType() == RegistryArtifactConstants.REGISTRY_COLLECTION) {
					item = new RegistryCollection();
					((RegistryCollection) item).setDirectory(registryResourceInfo.getResourceBaseRelativePath().replaceAll(Pattern.quote(File.separator), "/"));
				} else if (registryResourceInfo.getType() == RegistryArtifactConstants.REGISTRY_DUMP) {
					item = new RegistryDump();
					((RegistryDump) item).setFile(registryResourceInfo.getResourceBaseRelativePath().replaceAll(Pattern.quote(File.separator), "/"));
				} 
				if (item != null) {
					item.setPath(registryResourceInfo.getDeployPath()
							.replaceAll("/$", ""));
					artifact.addRegistryElement(item);
				}
            }
			
			generalProjectArtifact.addArtifact(artifact);
			
			generalProjectArtifact.toFile();
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			openEditor(project);
			
		} catch (Exception e) {
			log.error("cannot create resource ", e);
		}
		return true;
	}
	
	private void updatePOM(IProject project) throws IOException, XmlPullParserException {
		MavenProject mavenProject;
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		if (!mavenProjectPomLocation.exists()) {
			mavenProject = MavenUtils.createMavenProject("org.wso2.carbon." + project.getName(), project.getName(),
					"1.0.0", "pom");
		} else {
			mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		}

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin")) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin",
				MavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);
		PluginExecution pluginExecution;
		pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("registry");
		plugin.addExecution(pluginExecution);

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
	
	public String createTemplate(String templateContent, String type) throws IOException{
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		String endPointDef = "<endpoint\n";
		endPointDef +="\t\tname=\"endpoint_urn_uuid_";
		endPointDef +=UUID.randomUUID().toString();
		endPointDef +="\">\n\t\t<address uri=\"";
		endPointDef += "https://localhost";
		endPointDef +="\" />\n\t\t</endpoint>";
		
		String newContent = templateContent;
		if(type.equals(RegistryArtifactConstants.SEQUENCE_TEMPL_ID)){
			newContent = newContent.replaceAll("<0>", regModel.getResourceName());
			newContent = newContent.replaceAll("<1>", "");
		} else if(type.equals(RegistryArtifactConstants.DEFAULT_EP_TEMPL_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName()); 
		} else if(type.equals(RegistryArtifactConstants.DEFAULT_EP_TEMPLATE_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
		} else if(type.equals(RegistryArtifactConstants.ADDRESS_EP_TEMPL_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<address.uri>", "https://localhost");
		} else if(type.equals(RegistryArtifactConstants.ADDRESS_EP_TEMPLATE_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<address.uri>", Matcher.quoteReplacement("$uri"));
		} else if(type.equals(RegistryArtifactConstants.WSDL_EP_TEMPL_ID)){
	    	newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName()); 
	    	newContent = newContent.replaceAll("<wsdl.uri>", "http://localhost:9000/services/SimpleStockQuoteService?wsdl");
			newContent = newContent.replaceAll("<service.name>", "SimpleStockQuoteService");
			newContent = newContent.replaceAll("<service.port>", "SimpleStockQuoteServiceHttpSoap11Endpoint");
		} else if(type.equals(RegistryArtifactConstants.WSDL_EP_TEMPLATE_ID)){
	    	newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName()); 
	    	newContent = newContent.replaceAll("<wsdl.uri>", "http://localhost:9000/services/SimpleStockQuoteService?wsdl");
			newContent = newContent.replaceAll("<service.name>", "SimpleStockQuoteService");
			newContent = newContent.replaceAll("<service.port>", "SimpleStockQuoteServiceHttpSoap11Endpoint");
		} else if(type.equals(RegistryArtifactConstants.FAIL_OVER_ENDPOINT_TEMPL_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());		
		} else if(type.equals(RegistryArtifactConstants.LB_ENDPOINT_TEMPL_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());		
		} else if (type.equals(RegistryArtifactConstants.HTTP_EP_TEMPL_ID)) {
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<http.uritemplate>", "https://localhost");
			newContent = newContent.replaceAll("<http.method>", "get");
		} else if (type.equals(RegistryArtifactConstants.HTTP_EP_TEMPLATE_ID)) {
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<http.uritemplate>", "https://localhost");
			newContent = newContent.replaceAll("<http.method>", "get");
		} else if (type.equals(RegistryArtifactConstants.RECIPIENTLIST_EP_TEMPL_ID)) {
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
		} else if(type.equals(RegistryArtifactConstants.TEMPLATE_ENDPOINT_TEMPL_ID)){
			newContent = newContent.replaceAll("<ep.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<ep.uri>", "https://localhost"); 
			newContent = newContent.replaceAll("<ep.template>", "");
		} else if(type.equals(RegistryArtifactConstants.TEMPLATE_SEQUENCE_TEMPL_ID)){
			newContent = newContent.replaceAll("<0>", regModel.getResourceName());
			newContent = newContent.replaceAll("<1>", "");
		} else if(type.equals(RegistryArtifactConstants.LOCAL_ENTRY_TEMPL_ID)){
			newContent = newContent.replaceAll("<localentry-name>", regModel.getResourceName());
		} else if(type.equals(RegistryArtifactConstants.SMOOKS_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.TRANSFORMER_PROXY_TEMPL_ID)){
			newContent= newContent.replaceAll("<proxy.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<endpoint.key.def>","");
			newContent = newContent.replaceAll("<endpoint.def>",endPointDef);
			newContent = newContent.replaceAll("<xslt.key>", "conf:/repository/esb/configuration");
			// Removing XSLT Response option
			newContent = newContent.replace("<xsltres.key.def>", "");
		} else if(type.equals(RegistryArtifactConstants.LOGGING_PROXY_TEMPL_ID)){
			newContent= newContent.replaceAll("<proxy.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<endpoint.key.def>","");
			newContent = newContent.replaceAll("<endpoint.def>",endPointDef);
			newContent = newContent.replaceAll("<reqloglevel>", "full");
			newContent = newContent.replaceAll("<resloglevel>", "full");
		} else if(type.equals(RegistryArtifactConstants.PASS_THROUGH_PROXY_TEMPL_ID)){
			newContent= newContent.replaceAll("<proxy.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<endpoint.key.def>","");
			newContent = newContent.replaceAll("<endpoint.def>",endPointDef);		
		} else if(type.equals(RegistryArtifactConstants.WSDL_BASED_PROXY_TEMPL_ID)){
			newContent= newContent.replaceAll("<proxy.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<wsdl.service>", "SimpleStockQuoteService");
			newContent = newContent.replaceAll("<wsdl.port>", "SimpleStockQuoteServiceHttpSoap11Endpoint");
			newContent = newContent.replaceAll("<wsdl.url>", "http://localhost:9000/services/SimpleStockQuoteService?wsdl");
		} else if(type.equals(RegistryArtifactConstants.SECURE_PROXY_TEMPL_ID)){
			newContent= newContent.replaceAll("<proxy.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<sec.policy>", "");
			newContent = newContent.replaceAll("<endpoint.key.def>","");
			newContent = newContent.replaceAll("<endpoint.def>",endPointDef);		
		} else if(type.equals(RegistryArtifactConstants.CUSTOM_PROXY_TEMPL_ID)){
			newContent= newContent.replaceAll("<proxy.name>", regModel.getResourceName());
			newContent = newContent.replaceAll("<endpoint.key.def>","");
			newContent = newContent.replaceAll("<endpoint.def>",endPointDef);		
		} else if(type.equals(RegistryArtifactConstants.CSS_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.HTML_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.JS_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.SQL_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.XSL_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.XSLT_TEMPL_ID)){
			newContent=templateContent;		
		} else if(type.equals(RegistryArtifactConstants.WSDL_TEMPL_ID)){
			newContent=templateContent;	
			newContent = newContent.replaceAll("<0>", regModel.getResourceName());
		}     
		return newContent;
	}
	
	
	protected boolean isRequireProjectLocationSection() {
		return false;
	}
	
	public void openEditor(IProject project){
		try {
			 refreshDistProjects();
			 IFile arifactXml = project.getFile("artifact.xml");
		     IWorkbenchWindow window=PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	         IWorkbenchPage page = window.getActivePage();
	         List<IEditorReference> openEditors = new ArrayList<IEditorReference>();
	         IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
	         
	         for (IEditorReference iEditorReference : editorReferences) {
				if(REGISTRY_EDITOR_ID.equals(iEditorReference.getId())){
					openEditors.add(iEditorReference);
				}
			}
	         page.closeEditors(openEditors.toArray(new IEditorReference[]{}), false);
	         page.openEditor(new FileEditorInput(arifactXml), REGISTRY_EDITOR_ID); 
		} catch (Exception e) { /* ignore */}
	}
	
	public IWizardPage getPreviousPage(IWizardPage page) {
		if(page instanceof ProjectOptionsPage){
			regModel.setImportFile(new File(""));
			regModel.setResourceName(null);
		}
	    return super.getPreviousPage(page);
	}
	
}
