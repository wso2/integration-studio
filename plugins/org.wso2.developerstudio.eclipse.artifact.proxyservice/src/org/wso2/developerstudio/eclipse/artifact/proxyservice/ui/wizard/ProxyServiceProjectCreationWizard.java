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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.Activator;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.model.ProxyServiceModel;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.model.ProxyServiceModel.TargetEPType;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.ProxyServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.PsArtifactConstants;
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

public class ProxyServiceProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private final ProxyServiceModel psModel;
	private IFile proxyServiceFile;
	private ESBProjectArtifact esbProjectArtifact;
	private List<File> fileLst = new ArrayList<File>();
	private IProject esbProject;

	private String version = "1.0.0";

	public ProxyServiceProjectCreationWizard() {
		this.psModel = new ProxyServiceModel();
		setModel(this.psModel);
		setWindowTitle(PsArtifactConstants.PS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(ProxyServiceImageUtils.getInstance().getImageDescriptor("proxy-service-wizard.png"));
	}

	
	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	protected boolean isRequiredWorkingSet() {
		return false;
	}
	
	public boolean performFinish() {
		try {
			boolean isNewArtifact = true;
			String templateContent = "";
			String template = "";
			ProxyServiceModel proxyServiceModel = (ProxyServiceModel) getModel();
			esbProject =  proxyServiceModel.getProxyServiceSaveLocation().getProject();
			IContainer location = esbProject.getFolder("src" + File.separator + "main" +
                                 File.separator +
                                 "synapse-config" +
                                 File.separator +
                                 "proxy-services");
			
			File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
			if(!pomfile.exists()){
				getModel().getMavenInfo().setPackageName("synapse/proxy-service");
				createPOM(pomfile);
			}
			updatePom();
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			String groupId = getMavenGroupId(pomfile) + ".proxy-service";
			
			//Adding the metadata about the proxy service to the metadata store.
			esbProjectArtifact=new ESBProjectArtifact();
			esbProjectArtifact.fromFile(esbProject.getFile("artifact.xml").getLocation().toFile());
			
			if (getModel().getSelectedOption().equals(PsArtifactConstants.WIZARD_OPTION_IMPORT_OPTION)) {
				proxyServiceFile = location.getFile(new Path(getModel().getImportFile().getName()));
				if(proxyServiceFile.exists()){
					if(!MessageDialog.openQuestion(getShell(), "WARNING", "Do you like to override exsiting project in the workspace")){
						return false;	
					}
					isNewArtifact = false;
				} 
				copyImportFile(location,isNewArtifact,groupId);
			} else {
				ArtifactTemplate selectedTemplate = psModel.getSelectedTemplate();
				templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
				if(selectedTemplate.getName().equals(PsArtifactConstants.CUSTOM_PROXY)){
					template = createProxyTemplate(templateContent, PsArtifactConstants.CUSTOM_PROXY);
				}else if(selectedTemplate.getName().equals(PsArtifactConstants.LOGGING_PROXY)){
					template = createProxyTemplate(templateContent, PsArtifactConstants.LOGGING_PROXY);
				}else if(selectedTemplate.getName().equals(PsArtifactConstants.PASS_THROUGH_PROXY)){
					template = createProxyTemplate(templateContent, PsArtifactConstants.PASS_THROUGH_PROXY);
				}else if(selectedTemplate.getName().equals(PsArtifactConstants.SECURE_PROXY)){
					template = createProxyTemplate(templateContent, PsArtifactConstants.SECURE_PROXY);
				}else if(selectedTemplate.getName().equals(PsArtifactConstants.TRANSFORMER_PROXY)){
					template = createProxyTemplate(templateContent, PsArtifactConstants.TRANSFORMER_PROXY);
				}else if(selectedTemplate.getName().equals(PsArtifactConstants.WSDL_BASED_PROXY)){
					template = createProxyTemplate(templateContent, PsArtifactConstants.WSDL_BASED_PROXY);
				}else{
					template = createProxyTemplate(templateContent, "");
				}
			
				proxyServiceFile = location.getFile(new Path(proxyServiceModel.getProxyServiceName() + ".xml"));
				File destFile = proxyServiceFile.getLocation().toFile();
				FileUtils.createFile(destFile, template);
				fileLst.add(destFile);
				String relativePath = FileUtils.getRelativePath(
						esbProject.getLocation().toFile(),
						new File(location.getLocation().toFile(), proxyServiceModel
								.getProxyServiceName() + ".xml")).replaceAll(Pattern.quote(File.separator), "/");
				esbProjectArtifact.addESBArtifact(createArtifact(
						proxyServiceModel.getProxyServiceName(), groupId, version, relativePath));
			}
			
			esbProjectArtifact.toFile();
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			if(fileLst.size()>0){
				openEditor(fileLst.get(0));
			}
			
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}
	
	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		version = mavenProject.getVersion();

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-proxy-plugin")) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-proxy-plugin",
				ESBMavenConstants.WSO2_ESB_PROXY_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("proxy");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	public void copyImportFile(IContainer location,boolean isNewArtifact,String groupId) throws IOException {
		File destFile = null;
		List<OMElement> availablePSList = psModel.getSelectedProxyList();
		String relativePath;
		
		if(availablePSList.size()>0){
			for(OMElement proxy:availablePSList){
				String name = proxy.getAttributeValue(new QName("name"));
				destFile  = new File(location.getLocation().toFile(),  name + ".xml");
				FileUtils.createFile(destFile,  proxy.toString());
				fileLst.add(destFile);
				if(isNewArtifact){
					relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
							new File(location.getLocation().toFile(), name + ".xml")).replaceAll(
							Pattern.quote(File.separator), "/");
					esbProjectArtifact.addESBArtifact(createArtifact(name,groupId,version,relativePath) );
				}
			}			
		}
		else{
			File importFile = getModel().getImportFile();
			String name = importFile.getName().replaceAll(".xml$","");
			proxyServiceFile = location.getFile(new Path(importFile.getName()));
			destFile = proxyServiceFile.getLocation().toFile();
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			if(isNewArtifact){
				relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
						new File(location.getLocation().toFile(), name + ".xml")).replaceAll(
						Pattern.quote(File.separator), "/");
				esbProjectArtifact.addESBArtifact(createArtifact(name,groupId,version,relativePath) );
			}
		}
	}

	
	public IResource getCreatedResource() {
		return proxyServiceFile;
	}
	
	public String createProxyTemplate(String templateContent, String type) throws IOException{
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");

		String newContent= StringUtils.replace(templateContent,"<proxy.name>", psModel.getProxyServiceName());
		
		if(TargetEPType.REGISTRY==psModel.getTargetEPType()){
			newContent = StringUtils.replace(newContent,"<endpoint.key.def>", " endpoint=\"" + psModel.getEndPointkey() + "\"");
			newContent = StringUtils.replace(newContent,"<endpoint.def>","");
		} else if(TargetEPType.PREDEFINED==psModel.getTargetEPType()){
			newContent = StringUtils.replace(newContent,"<endpoint.key.def>", " endpoint=\"" + psModel.getPredefinedEndPoint() + "\"");
			newContent = StringUtils.replace(newContent,"<endpoint.def>","");
		} else{
			String endPointDef = "<endpoint\n";
			endPointDef +="\t\tname=\"endpoint_urn_uuid_";
			endPointDef +=UUID.randomUUID().toString();
			endPointDef +="\">\n\t\t<address uri=\"";
			endPointDef += psModel.getEndPointUrl();
			endPointDef +="\" />\n\t\t</endpoint>";
			newContent = StringUtils.replace(newContent,"<endpoint.key.def>","");
			newContent = StringUtils.replace(newContent,"<endpoint.def>",endPointDef);
		}
		
		if(type.equals(PsArtifactConstants.CUSTOM_PROXY)){
		//TODO: add additional conf
		}else if(type.equals(PsArtifactConstants.LOGGING_PROXY)){
			newContent = StringUtils.replace(newContent,"<reqloglevel>", psModel.getRequestLogLevel());
			newContent = StringUtils.replace(newContent,"<resloglevel>", psModel.getResponseLogLevel());
		}else if(type.equals(PsArtifactConstants.PASS_THROUGH_PROXY)){
		//TODO: add additional conf 
		}else if(type.equals(PsArtifactConstants.SECURE_PROXY)){
			newContent = StringUtils.replace(newContent,"<sec.policy>", psModel.getSecPolicy());
		}else if(type.equals(PsArtifactConstants.TRANSFORMER_PROXY)){
			newContent = StringUtils.replace(newContent,"<xslt.key>", psModel.getRequestXSLT());
			if(psModel.isTransformResponses() && !psModel.getResponseXSLT().equals("")) {
				String responseXSLT = "<xslt key=\"";
				responseXSLT += psModel.getResponseXSLT();
				responseXSLT += "\" />";
				newContent = StringUtils.replace(newContent, "<xsltres.key.def>", responseXSLT);
			} else {
				newContent = StringUtils.replace(newContent, "<xsltres.key.def>", "");
			}
		}else if(type.equals(PsArtifactConstants.WSDL_BASED_PROXY)){
			newContent = StringUtils.replace(newContent,"<wsdl.service>", psModel.getWsdlService());
			newContent = StringUtils.replace(newContent,"<wsdl.port>", psModel.getWsdlPort());
			newContent = StringUtils.replace(newContent,"<wsdl.url>", psModel.getWsdlUri());
		}
        return newContent;
	}
	
	public void openEditor(File file){
		try {
			refreshDistProjects();
	/*		IFile dbsFile  = ResourcesPlugin
			.getWorkspace()
			.getRoot()
			.getFileForLocation(
					Path.fromOSString(file.getAbsolutePath()));
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),dbsFile);*/
			String location = proxyServiceFile.getParent().getFullPath()+"/";
			String source = FileUtils.getContentAsString(file);
			Openable openable = ESBGraphicalEditor.getOpenable();
			openable.editorOpen(file.getName(),ArtifactType.PROXY.getLiteral(),location, source);
		} catch (Exception e) {
                log.error("cannot open the Editor", e);
		}
	}
	
	private ESBArtifact createArtifact(String name,String groupId,String version,String path){
		ESBArtifact artifact=new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType("synapse/proxy-service");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

}
