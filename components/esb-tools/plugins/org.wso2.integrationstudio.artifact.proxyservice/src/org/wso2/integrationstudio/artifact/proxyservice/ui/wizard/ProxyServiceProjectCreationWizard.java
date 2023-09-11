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

package org.wso2.integrationstudio.artifact.proxyservice.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.wsdl.Definition;
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.apache.synapse.config.xml.ProxyServiceSerializer;
import org.apache.synapse.core.axis2.ProxyService;
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
import org.wso2.integrationstudio.artifact.proxyservice.Activator;
import org.wso2.integrationstudio.artifact.proxyservice.model.ProxyServiceModel;
import org.wso2.integrationstudio.artifact.proxyservice.model.ProxyServiceModel.TargetEPType;
import org.wso2.integrationstudio.artifact.proxyservice.utils.ProxyServiceImageUtils;
import org.wso2.integrationstudio.artifact.proxyservice.utils.PsArtifactConstants;
import org.wso2.integrationstudio.artifact.proxyservice.wsdl.ProxyGenerator;
import org.wso2.integrationstudio.artifact.proxyservice.wsdl.WSDL2Java;
import org.wso2.integrationstudio.artifact.synapse.api.util.MetadataUtils;
import org.wso2.integrationstudio.esb.core.ESBMavenConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.project.extensions.templates.ArtifactTemplate;
import org.wso2.integrationstudio.platform.ui.editor.Openable;
import org.wso2.integrationstudio.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.integrationstudio.utils.file.FileUtils;

public class ProxyServiceProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {
	private static IIntegrationStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private final ProxyServiceModel psModel;
	private IFile proxyServiceFile;
	private ESBProjectArtifact esbProjectArtifact;
	private List<File> fileLst = new ArrayList<File>();
	private IProject esbProject;
	private static final String METADATA_TYPE = SynapseConstants.METADATA_TYPE;

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
			IContainer metadataLocation = esbProject.getFolder("src/main/resources/metadata");
			// no medatadata folder-> old project structure
			boolean meadataEnabled = metadataLocation.exists();
			IContainer location = esbProject.getFolder("src" + File.separator + "main" +
                                 File.separator +
                                 "synapse-config" +
                                 File.separator +
                                 "proxy-services");
			
			File pomfile = esbProject.getFile("pom.xml").getLocation().toFile();
			if(!pomfile.exists()){
				getModel().getMavenInfo().setPackageName(SynapseConstants.PROXY_SERVICE_CONFIG_TYPE);
				createPOM(pomfile);
			}
            MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
            version = mavenProject.getVersion().replace("-SNAPSHOT", "");
            if (!esbProject.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER).exists()) {
                updatePom();
            }
			esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			String mavenGroupId = getMavenGroupId(pomfile);
			String groupId = mavenGroupId + ".proxy-service";
			String metadataGroupId = mavenGroupId + ".metadata";
			
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
                copyImportFile(location, isNewArtifact, groupId, meadataEnabled, metadataLocation, metadataGroupId);
            } else if (getModel().getSelectedOption().equals(PsArtifactConstants.WIZARD_OPTION_WSDL_OPTION)) {
                try {
                    String wsdlUrl;
                    if (proxyServiceModel.getProxyWSDLType().equals(PsArtifactConstants.TYPE_WSDL_FILE)) {
                        wsdlUrl = proxyServiceModel.getProxyWSDLFile().toURI().toString();
                    } else {
                        wsdlUrl = proxyServiceModel.getProxyWSDLurl();
                    }
                    Definition definitions = WSDL2Java.readWSDL(wsdlUrl);
                    List<String> soapActions = WSDL2Java.getBindingSoapActions(definitions);
                    ProxyService proxyService = ProxyGenerator.generateProxyWithOperations(
                            proxyServiceModel.getProxyWSDLSelectedName(), soapActions, wsdlUrl);
                    template = ProxyServiceSerializer.serializeProxy(null, proxyService).toString();
                    proxyServiceFile = location.getFile(new Path(proxyServiceModel.getProxyServiceName() + ".xml"));
                    File destFile = proxyServiceFile.getLocation().toFile();
                    FileUtils.createFile(destFile, template);
                    fileLst.add(destFile);
                    addESBArtifactDetails(location, proxyServiceModel.getProxyServiceName(), groupId, version,
                            proxyServiceModel.getProxyServiceName(), esbProjectArtifact);
					if (meadataEnabled) {
						// Create the metadata file and update the artifact.xml file
						MetadataUtils.createMedataFileForProxyServices(metadataLocation,
								proxyServiceModel.getProxyServiceName());
						createMetadataArtifactEntry(metadataLocation, proxyServiceModel.getProxyServiceName(),
								metadataGroupId);
					}
                } catch (Exception e) {
                    log.error("Error occured while generating Poxy from given WSDL", e);
                    MessageDialog.openError(getShell(), "Error while creating the Proxy from given WSDL file",
                            "Unable to generate the Proxy service from the given URL " + e.getMessage());
                }
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
                addESBArtifactDetails(location, proxyServiceModel.getProxyServiceName(), groupId, version,
                        proxyServiceModel.getProxyServiceName(), esbProjectArtifact);
				if (meadataEnabled) {
					// Create the metadata file and update the artifact.xml file
					MetadataUtils.createMedataFileForProxyServices(metadataLocation,
							proxyServiceModel.getProxyServiceName());
					createMetadataArtifactEntry(metadataLocation, proxyServiceModel.getProxyServiceName(),
							metadataGroupId);
				}
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

        boolean metaPluginExists = MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven",
                "wso2-esb-metadata-plugin");
        if (!metaPluginExists) {
            Plugin plugin2 = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-metadata-plugin",
                    ESBMavenConstants.WSO2_ESB_METADATA_VERSION, true);
            PluginExecution pluginExecution2 = new PluginExecution();
            pluginExecution2.addGoal("pom-gen");
            pluginExecution2.setPhase("process-resources");
            pluginExecution2.setId("metadata");
            Xpp3Dom configurationNode2 = MavenUtils.createMainConfigurationNode();
            Xpp3Dom artifactLocationNode2 = MavenUtils.createXpp3Node(configurationNode2, "artifactLocation");
            artifactLocationNode2.setValue(".");
            Xpp3Dom typeListNode2 = MavenUtils.createXpp3Node(configurationNode2, "typeList");
            typeListNode2.setValue("${artifact.types}");
            pluginExecution2.setConfiguration(configurationNode2);
            plugin2.addExecution(pluginExecution2);
        }

        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

	private void createMetadataArtifactEntry(IContainer metadataLocation, String proxyName, String metadataGroupId)
			throws Exception {
		String filePathPostfix = getFilePathPostFix();
		String namePostfix = getNamePostFix();
		String metaRelativePath = FileUtils
				.getRelativePath(esbProject.getLocation().toFile(),
						new File(metadataLocation.getLocation().toFile(), proxyName + filePathPostfix))
				.replaceAll(Pattern.quote(File.separator), "/");
		esbProjectArtifact.addESBArtifact(
				createArtifact(proxyName + namePostfix, metadataGroupId, version, metaRelativePath, METADATA_TYPE));
		String artifactName = proxyName + namePostfix;
		createMetadataArtifactPom(metadataGroupId, artifactName, version, metaRelativePath);
	}

    private void addESBArtifactDetails(IContainer location, String proxyServiceName, String groupId, String version,
            String proxyServiceFileName, ESBProjectArtifact esbProjectArtifact) throws Exception {

        String relativePath = FileUtils
                .getRelativePath(location.getProject().getLocation().toFile(),
                        new File(location.getLocation().toFile(), proxyServiceName + ".xml"))
                .replaceAll(Pattern.quote(File.separator), "/");
        esbProjectArtifact.addESBArtifact(createArtifact(proxyServiceName, groupId, version, relativePath));

        IContainer buildArtifactsLocation = esbProject.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
        SynapseUtils.createSynapseConfigBuildArtifactPom(groupId, proxyServiceName, version,
                SynapseConstants.PROXY_SERVICE_CONFIG_TYPE, proxyServiceFileName, SynapseConstants.PROXY_SERVICE_FOLDER,
                buildArtifactsLocation, "../../../" + relativePath);
    }

    private void createMetadataArtifactPom(String groupId, String artifactName, String artifactVersion,
            String metaRelativePath) throws IOException, XmlPullParserException {

        IContainer buildArtifactsLocation = esbProject.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
        SynapseUtils.createMetadataBuildArtifactPom(groupId, artifactName, artifactVersion, METADATA_TYPE, artifactName,
                SynapseConstants.METADATA_FOLDER, buildArtifactsLocation, "../../../" + metaRelativePath);
    }
	
	private String getFilePathPostFix() {
	    return "_proxy_metadata.yaml";
	}
	
	private String getNamePostFix() {
	    return "_proxy_metadata";
	}

	public void copyImportFile(IContainer location,boolean isNewArtifact, String groupId, boolean medataEnabled,
							   IContainer metadataLocation, String metadataGroupId) throws Exception {
		File destFile = null;
		List<OMElement> availablePSList = psModel.getSelectedProxyList();
		String relativePath;
		
		if(availablePSList.size()>0){
			for(OMElement proxy:availablePSList){
				String name = proxy.getAttributeValue(new QName("name"));
				destFile  = new File(location.getLocation().toFile(),  name + ".xml");
				FileUtils.createFile(destFile,  proxy.toString());
				fileLst.add(destFile);
                if (isNewArtifact) {
                    addESBArtifactDetails(location, name, groupId, version, name, esbProjectArtifact);
                    if (medataEnabled) {
                        // Create the metadata file and update the artifact.xml file
                        MetadataUtils.createMedataFileForProxyServices(metadataLocation, name);
                        createMetadataArtifactEntry(metadataLocation, name, metadataGroupId);
                    }
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
            if (isNewArtifact) {
                addESBArtifactDetails(location, name, groupId, version, name, esbProjectArtifact);
                if (medataEnabled) {
                    // Create the metadata file and update the artifact.xml file
                    MetadataUtils.createMedataFileForProxyServices(metadataLocation, name);
                    createMetadataArtifactEntry(metadataLocation, name, metadataGroupId);
                }
            }
		}
	}

	
	public IResource getCreatedResource() {
		return proxyServiceFile;
	}
	
	public String createProxyTemplate(String templateContent, String type) throws IOException{
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");

		String newContent = StringUtils.replace(templateContent,"<proxy.name>", psModel.getProxyServiceName());
		List<String> selectedTransports = psModel.getTransports();
		String transports;
		if (selectedTransports.size() == 0) {
			transports = "http,https";
		} else {
		    transports = selectedTransports.toString().substring(1, selectedTransports.toString().length() - 1);
		}
		newContent = StringUtils.replace(newContent, "<proxy.transports>", transports);
		
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
	
	private ESBArtifact createArtifact(String name, String groupId, String version, String path, String type) {
		ESBArtifact artifact = createArtifact(name, groupId, version, path);
		if (!StringUtils.isEmpty(type)) {
			artifact.setType(type);
		}
		return artifact;
	}
	
	private ESBArtifact createArtifact(String name,String groupId,String version,String path){
		ESBArtifact artifact=new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(SynapseConstants.PROXY_SERVICE_CONFIG_TYPE);
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

}
