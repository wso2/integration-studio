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

package org.wso2.developerstudio.eclipse.artifact.endpoint.ui.wizard;

import static org.wso2.developerstudio.eclipse.artifact.endpoint.model.EndpointModel.CONF_REG_ID;
import static org.wso2.developerstudio.eclipse.artifact.endpoint.model.EndpointModel.GOV_REG_ID;
import static org.wso2.developerstudio.eclipse.platform.core.registry.util.Constants.REGISTRY_RESOURCE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
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
import org.eclipse.jface.wizard.IWizardPage;
import org.wso2.developerstudio.eclipse.artifact.endpoint.Activator;
import org.wso2.developerstudio.eclipse.artifact.endpoint.model.EndpointModel;
import org.wso2.developerstudio.eclipse.artifact.endpoint.utils.EndPointImageUtils;
import org.wso2.developerstudio.eclipse.artifact.endpoint.utils.EpArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.endpoint.validators.HttpMethodList.HttpMethodType;
import org.wso2.developerstudio.eclipse.artifact.endpoint.validators.ProjectFilter;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
// import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfo;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfoDoc;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class EndpointProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private EndpointModel epModel;
	private IFile endpointFile;
	private ESBProjectArtifact esbProjectArtifact;
	private List<File> fileLst = new ArrayList<File>();
	private IProject project;
	private String version;

	public EndpointProjectCreationWizard() {
		this.epModel = new EndpointModel();
		setModel(this.epModel);
		setWindowTitle(EpArtifactConstants.EP_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(EndPointImageUtils.getInstance().getImageDescriptor("endpoint-wizard.png"));
	}

	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	protected boolean isRequiredWorkingSet() {
		return false;
	}

	public boolean performFinish() {
		try {
			epModel = (EndpointModel) getModel();
			project = epModel.getEndpointSaveLocation().getProject();
			version = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile()).getVersion();

			if (epModel.getSelectedOption_DynamicEP()) {
				createDynamicEndpointArtifact(epModel.getEndpointSaveLocation(), epModel);
			} else {
				if (!createEndpointArtifact(project, epModel)) {
					return false;
				}
			}

			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			if (fileLst.size() > 0) {
				openEditor(fileLst.get(0));
			}

		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}
		ProjectFilter.setShowGeneralProjects(false);
		return true;
	}

	@Override
	public boolean performCancel() {
		ProjectFilter.setShowGeneralProjects(false);
		return super.performCancel();
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		ProjectFilter.setShowGeneralProjects(false);
		epModel = (EndpointModel) getModel();
		epModel.setSelectedOption_DynamicEP(false);
		return super.getPreviousPage(page);
	}

	private boolean createEndpointArtifact(IProject prj, EndpointModel model) throws Exception {
		boolean isNewArtifact = true;
		String templateContent = "";
		String template = "";
		IContainer location =
		                      project.getFolder("src" + File.separator + "main" + File.separator + "synapse-config" +
		                                        File.separator + "endpoints");

		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("synapse/endpoint");
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}
		updatePom();
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		String groupId = getMavenGroupId(pomfile);
		groupId += ".endpoint";
		// Adding the metadat+a about the endpoint to the metadata store.
		esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

		if (getModel().getSelectedOption().equals(EpArtifactConstants.WIZARD_OPTION_IMPORT_OPTION)) {
			endpointFile = location.getFile(new Path(getModel().getImportFile().getName()));
			if (endpointFile.exists()) {
				if (!MessageDialog.openQuestion(getShell(), "WARNING",
				                                "Do you like to override exsiting project in the workspace")) {
					return false;
				}
				isNewArtifact = false;
			}
			copyImportFile(location, isNewArtifact, groupId);
		} else {
			ArtifactTemplate selectedTemplate = epModel.getSelectedTemplate();
			templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
			if (selectedTemplate.getName().equals(EpArtifactConstants.ADDRESS_EP)) {
				template = createEPTemplate(templateContent, EpArtifactConstants.ADDRESS_EP);

			} else if (selectedTemplate.getName().equals(EpArtifactConstants.WSDL_EP)) {
				template = createEPTemplate(templateContent, EpArtifactConstants.WSDL_EP);

			} else if (selectedTemplate.getName().equals(EpArtifactConstants.TEMPLATE_EP)) {
				template = createEPTemplate(templateContent, EpArtifactConstants.TEMPLATE_EP);

			} else if (selectedTemplate.getName().equals(EpArtifactConstants.HTTP_EP)) {
				template = createEPTemplate(templateContent, EpArtifactConstants.HTTP_EP);

			} else {
				template = createEPTemplate(templateContent, "");

			}

			endpointFile = location.getFile(new Path(epModel.getEpName() + ".xml"));
			File destFile = endpointFile.getLocation().toFile();
			FileUtils.createFile(destFile, template);
			fileLst.add(destFile);

			ESBArtifact artifact = new ESBArtifact();
			artifact.setName(epModel.getEpName());
			artifact.setVersion(version);
			artifact.setType("synapse/endpoint");
			artifact.setServerRole("EnterpriseServiceBus");
			artifact.setGroupId(groupId);
			artifact.setFile(FileUtils.getRelativePath(project.getLocation().toFile(),
			                                           new File(location.getLocation().toFile(), epModel.getEpName() +
			                                                                                     ".xml"))
			                          .replaceAll(Pattern.quote(File.separator), "/"));
			esbProjectArtifact.addESBArtifact(artifact);

		}
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		esbProjectArtifact.toFile();
		return true;
	}

	private void createDynamicEndpointArtifact(IContainer location, EndpointModel model) throws Exception {

		addGeneralProjectPlugin(project);
		File pomLocation = project.getFile("pom.xml").getLocation().toFile();
		String groupId = getMavenGroupId(pomLocation) + ".resource";
		// version = version.replaceAll("-SNAPSHOT$", "");

		String registryPath =
		                      model.getDynamicEpRegistryPath().replaceAll("^conf:", "/_system/config")
		                           .replaceAll("^gov:", "/_system/governance").replaceAll("^local:", "/_system/local");

		if (model.getRegistryPathID().equals(CONF_REG_ID)) {
			if (!registryPath.startsWith("/_system/config")) {
				registryPath = "/_system/config/".concat(registryPath);
			}
		} else if (model.getRegistryPathID().equals(GOV_REG_ID)) {
			if (!registryPath.startsWith("/_system/governance")) {
				registryPath = "/_system/governance/".concat(registryPath);
			}
		}
		String templateContent = "";
		String template = "";
		RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();
		ArtifactTemplate selectedTemplate = epModel.getSelectedTemplate();
		templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
		if (selectedTemplate.getName().equals(EpArtifactConstants.ADDRESS_EP)) {
			template = createEPTemplate(templateContent, EpArtifactConstants.ADDRESS_EP);

		} else if (selectedTemplate.getName().equals(EpArtifactConstants.WSDL_EP)) {
			template = createEPTemplate(templateContent, EpArtifactConstants.WSDL_EP);

		} else if (selectedTemplate.getName().equals(EpArtifactConstants.TEMPLATE_EP)) {
			template = createEPTemplate(templateContent, EpArtifactConstants.TEMPLATE_EP);

		} else if (selectedTemplate.getName().equals(EpArtifactConstants.HTTP_EP)) {
			template = createEPTemplate(templateContent, EpArtifactConstants.HTTP_EP);

		} else {
			template = createEPTemplate(templateContent, "");

		}

		endpointFile = location.getFile(new Path(epModel.getEpName() + ".xml"));
		File destFile = endpointFile.getLocation().toFile();
		FileUtils.createFile(destFile, template);
		fileLst.add(destFile);

		RegistryResourceUtils.createMetaDataForFolder(registryPath, location.getLocation().toFile());
		RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc, project.getLocation().toFile(),
		                                              registryPath);

		GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
		generalProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

		RegistryArtifact artifact = new RegistryArtifact();
		artifact.setName(epModel.getEpName());
		artifact.setVersion(version);
		artifact.setType("registry/resource");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		List<RegistryResourceInfo> registryResources = regResInfoDoc.getRegistryResources();
		for (RegistryResourceInfo registryResourceInfo : registryResources) {
			RegistryElement item = null;
			if (registryResourceInfo.getType() == REGISTRY_RESOURCE) {
				item = new RegistryItem();
				((RegistryItem) item).setFile(registryResourceInfo.getResourceBaseRelativePath());
				((RegistryItem) item).setMediaType(registryResourceInfo.getMediaType());
				item.setPath(registryResourceInfo.getDeployPath().replaceAll("/$", ""));
				artifact.addRegistryElement(item);
			}
		}
		generalProjectArtifact.addArtifact(artifact);
		generalProjectArtifact.toFile();

	}

	private void addGeneralProjectPlugin(IProject project) throws Exception {
		MavenProject mavenProject;

		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		if (!mavenProjectPomLocation.exists()) {
			mavenProject =
			               MavenUtils.createMavenProject("org.wso2.carbon." + project.getName(), project.getName(),
			                                             "1.0.0", "pom");
		} else {
			mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		}

		boolean pluginExists =
		                       MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven",
		                                                      "wso2-general-project-plugin",
		                                                      ESBMavenConstants.WSO2_GENERAL_PROJECT_VERSION);
		if (pluginExists) {
			return;
		}

		Plugin plugin =
		                MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-general-project-plugin",
		                                             ESBMavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);

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

		Repository repo = new Repository();
		repo.setUrl("http://dist.wso2.org/maven2");
		repo.setId("wso2-maven2-repository-1");

		Repository repo1 = new Repository();
		repo1.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo1.setId("wso2-nexus-maven2-repository-1");

		if (!mavenProject.getRepositories().contains(repo)) {
			mavenProject.getModel().addRepository(repo);
			mavenProject.getModel().addPluginRepository(repo);
		}

		if (!mavenProject.getRepositories().contains(repo1)) {
			mavenProject.getModel().addRepository(repo1);
			mavenProject.getModel().addPluginRepository(repo1);
		}

		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-endpoint-plugin")) {
			return;
		}

		Plugin plugin =
		                MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-endpoint-plugin",
		                                             ESBMavenConstants.WSO2_ESB_ENDPOINT_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("endpoint");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	public void copyImportFile(IContainer importLocation, boolean isNewArtifact, String groupId) throws IOException {
		File importFile = getModel().getImportFile();
		EndpointModel endpointModel = (EndpointModel) getModel();
		List<OMElement> selectedEPList = endpointModel.getSelectedEPList();
		File destFile = null;
		if (selectedEPList != null && selectedEPList.size() > 0) {
			for (OMElement element : selectedEPList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
				if (isNewArtifact) {
					String fileLocation =
					                      FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
					                                                new File(importLocation.getLocation().toFile(),
					                                                         name + ".xml"))
					                               .replaceAll(Pattern.quote(File.separator), "/");
					esbProjectArtifact.addESBArtifact(createArtifactxml(fileLocation, name, groupId));
				}
			}

		} else {
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$", "");
			if (isNewArtifact) {
				String fileLocation =
				                      FileUtils.getRelativePath(importLocation.getProject().getLocation().toFile(),
				                                                new File(importLocation.getLocation().toFile(), name +
				                                                                                                ".xml"))
				                               .replaceAll(Pattern.quote(File.separator), "/");
				esbProjectArtifact.addESBArtifact(createArtifactxml(fileLocation, name, groupId));
			}
		}
	}

	private ESBArtifact createArtifactxml(String location, String artifactName, String groupId) {
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(artifactName);
		artifact.setVersion(version);
		artifact.setType("synapse/endpoint");
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(location);
		return artifact;
	}

	public IResource getCreatedResource() {
		return endpointFile;
	}

	public String createEPTemplate(String templateContent, String type) throws IOException {
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		String newContent = StringUtils.replace(templateContent, "<ep.name>", epModel.getEpName());
		if (type.equals(EpArtifactConstants.ADDRESS_EP)) {
			newContent = StringUtils.replace(newContent, "<address.uri>", epModel.getAddressEPURI());
		} else if (type.equals(EpArtifactConstants.WSDL_EP)) {
			newContent = StringUtils.replace(newContent, "<wsdl.uri>", epModel.getWsdlEPURI());
			newContent = StringUtils.replace(newContent, "<service.name>", epModel.getWsdlEPService());
			newContent = StringUtils.replace(newContent, "<service.port>", epModel.getWsdlEPPort());
		} else if (type.equals(EpArtifactConstants.TEMPLATE_EP)) {
			newContent = StringUtils.replace(newContent, "<ep.uri>", epModel.getTemplateEPURI());
			newContent = StringUtils.replace(newContent, "<ep.template>", epModel.getTemplateEPTargetTemp());
		} else if (type.equals(EpArtifactConstants.HTTP_EP)) {
			newContent = StringUtils.replace(newContent, "<http.uritemplate>", epModel.getHttpUriTemplate());
			if (!HttpMethodType.Leave_as_is.name().equals(epModel.getHttpMethod().name())) {
				newContent =
				             StringUtils.replace(newContent, "<http.method>", epModel.getHttpMethod().name()
				                                                                     .toLowerCase());
			} else {
				newContent = StringUtils.replace(newContent, "<http.method>", "");
			}
		}

		return newContent;
	}

	public void openEditor(File file) {
		try {
			refreshDistProjects();
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(file)).getDocumentElement();
			String localName = null;
			String type = "endpoint";
			if (documentElement.getFirstElement() != null) {
				localName = documentElement.getFirstElement().getLocalName();
				if ("address".equals(localName)) {
					type = type + "-1";
				} else if ("wsdl".equals(localName)) {
					type = type + "-2";
				} else if ("loadbalance".equals(localName)) {
					type = type + "-3";
				} else if ("failover".equals(localName)) {
					type = type + "-4";
				} else if ("recipientlist".equals(localName)) {
					type = type + "-5";
				} else if ("http".equals(localName)) {
					type = type + "-7";
				} else {
					type = type + "-0";
				}
			} else {
				Iterator allAttributes = documentElement.getAllAttributes();
				while (allAttributes.hasNext()) {
					OMAttribute object = (OMAttribute) allAttributes.next();
					if (object.getLocalName().equals("template")) {
						type = type + "-6";
						break;
					}
				}
			}

			String location = endpointFile.getParent().getFullPath() + "/";
			String source = FileUtils.getContentAsString(file);
			Openable openable = ESBGraphicalEditor.getOpenable();
			openable.editorOpen(file.getName(), ArtifactType.ENDPOINT.getLiteral(), location, source);
		} catch (Exception e) {
			log.error("Cannot open the editor", e);
		}
	}

}
