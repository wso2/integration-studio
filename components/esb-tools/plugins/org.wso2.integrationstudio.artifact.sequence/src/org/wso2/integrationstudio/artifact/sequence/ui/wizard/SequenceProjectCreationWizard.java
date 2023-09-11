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

package org.wso2.integrationstudio.artifact.sequence.ui.wizard;

import static org.wso2.integrationstudio.artifact.sequence.model.SequenceModel.CONF_REG_ID;
import static org.wso2.integrationstudio.artifact.sequence.model.SequenceModel.GOV_REG_ID;
import static org.wso2.integrationstudio.registry.core.utils.Constants.REGISTRY_RESOURCE;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.wso2.integrationstudio.artifact.sequence.Activator;
import org.wso2.integrationstudio.artifact.sequence.model.SequenceModel;
import org.wso2.integrationstudio.artifact.sequence.utils.SequenceImageUtils;
import org.wso2.integrationstudio.artifact.sequence.validators.ProjectFilter;
import org.wso2.integrationstudio.esb.core.ESBMavenConstants;
import org.wso2.integrationstudio.esb.core.exceptions.BuildArtifactCreationException;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.general.project.artifact.GeneralProjectArtifact;
import org.wso2.integrationstudio.general.project.artifact.RegistryArtifact;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryItem;
import org.wso2.integrationstudio.gmf.esb.ArtifactType;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;
import org.wso2.integrationstudio.project.extensions.templates.ArtifactTemplate;
import org.wso2.integrationstudio.project.extensions.templates.ArtifactTemplateHandler;
import org.wso2.integrationstudio.platform.ui.editor.Openable;
import org.wso2.integrationstudio.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.integrationstudio.registry.core.utils.RegistryResourceInfo;
import org.wso2.integrationstudio.registry.core.utils.RegistryResourceInfoDoc;
import org.wso2.integrationstudio.registry.core.utils.RegistryResourceUtils;
import org.wso2.integrationstudio.utils.file.FileUtils;

public class SequenceProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private SequenceModel seqModel;
	private static final String SEQ_WIZARD_WINDOW_TITLE = "New Sequence Artifact";
	private ESBProjectArtifact esbProjectArtifact;
	private List<File> fileLst = new ArrayList<File>();
	private IProject project;

	private String version = "1.0.0";

	public void setProject(IProject project) {
		this.project = project;
	}

	public void setModel(ProjectDataModel model) {
		super.setModel(model);
	}

	public SequenceProjectCreationWizard() {
		this.seqModel = new SequenceModel();
		setModel(this.seqModel);
		setWindowTitle(SEQ_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(SequenceImageUtils.getInstance().getImageDescriptor("seq-wizard.png"));
	}

	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	protected boolean isRequiredWorkingSet() {
		return false;
	}

	public boolean performFinish() {
		try {
			seqModel = (SequenceModel) getModel();
			project = seqModel.getSequenceSaveLocation().getProject();
			if (seqModel.isSaveAsDynamic()) {
				createDynamicSequenceArtifact(seqModel.getSequenceSaveLocation(), seqModel);
			} else {
				if (!createSequenceArtifact(project, seqModel)) {
					return false;
				}
			}

			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			File pomfile = project.getFile("pom.xml").getLocation().toFile();
			String groupId = getMavenGroupId(pomfile) + ".sequence";

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
        return super.getPreviousPage(page);
    }

    public void updatePom() throws IOException, XmlPullParserException {
        File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-sequence-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-sequence-plugin",
                ESBMavenConstants.WSO2_ESB_SEQUENCE_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("sequence");

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }
	public boolean createSequenceArtifact(IProject prj, SequenceModel sequenceModel) throws Exception {
		boolean isNewArtifact = true;
		IContainer location =
		                      project.getFolder("src" + File.separator + "main" + File.separator + "synapse-config" +
		                                        File.separator + "sequences");

		// Adding the metadata about the sequence to the metadata store.
		esbProjectArtifact = new ESBProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

		File pomfile = project.getFile("pom.xml").getLocation().toFile();
		getModel().getMavenInfo().setPackageName("synapse/sequence");
		if (!pomfile.exists()) {
			createPOM(pomfile);
		}
        MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
        version = mavenProject.getVersion().replace("-SNAPSHOT", "");

        if (!project.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER).exists()) {
            updatePom();
        }
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		String groupId = getMavenGroupId(pomfile);
		groupId += ".sequence";

		if (getModel().getSelectedOption().equals("import.sequence")) {
			IFile sequence = location.getFile(new Path(getModel().getImportFile().getName()));
			if (sequence.exists()) {
				if (!MessageDialog.openQuestion(getShell(), "WARNING",
				                                "Do you like to override exsiting project in the workspace")) {
					return false;
				}
				isNewArtifact = false;
			}
			copyImportFile(location, isNewArtifact, groupId);
		} else {
			// Map<String,List<String>> filters=new HashMap<String,List<String>>
			// ();
			// IntegrationStudioProviderUtils.addFilter(filters,
			// CSProviderConstants.FILTER_MEDIA_TYPE,
			// ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
			ArtifactTemplate selectedTemplate =
			                                    ArtifactTemplateHandler.getArtifactTemplates("org.wso2.integrationstudio.esb.sequence");
			String templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
			String content = createSequenceTemplate(templateContent);
			File destFile = new File(location.getLocation().toFile(), sequenceModel.getSequenceName() + ".xml");
			FileUtils.createFile(destFile, content);
			fileLst.add(destFile);

            addESBArtifactDetails(location, sequenceModel.getSequenceName(), groupId, version,
                    sequenceModel.getSequenceName(), esbProjectArtifact);
		}
		esbProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		return true;
	}

	public void createDynamicSequenceArtifact(IContainer location, SequenceModel sequenceModel) throws Exception {

		addGeneralProjectPlugin(project);
		File pomLocation = project.getFile("pom.xml").getLocation().toFile();
		String groupId = getMavenGroupId(pomLocation) + ".resource";
		MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
		String version = mavenProject.getVersion().replace("-SNAPSHOT", "");

		String registryPath =
		                      sequenceModel.getDynamicSeqRegistryPath().replaceAll("^conf:", "/_system/config")
		                                   .replaceAll("^gov:", "/_system/governance")
		                                   .replaceAll("^local:", "/_system/local");

		if (sequenceModel.getRegistryPathID().equals(CONF_REG_ID)) {
			if (!registryPath.startsWith("/_system/config")) {
				registryPath = "/_system/config/".concat(registryPath);
			}
		} else if (sequenceModel.getRegistryPathID().equals(GOV_REG_ID)) {
			if (!registryPath.startsWith("/_system/governance")) {
				registryPath = "/_system/governance/".concat(registryPath);
			}
		}

		RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();

		ArtifactTemplate selectedTemplate =
		                                    ArtifactTemplateHandler.getArtifactTemplates("org.wso2.integrationstudio.esb.sequence");
		String templateContent = FileUtils.getContentAsString(selectedTemplate.getTemplateDataStream());
		String content = createSequenceTemplate(templateContent);
		File destFile = location.getFile(new Path(sequenceModel.getSequenceName() + ".xml")).getLocation().toFile();
		FileUtils.createFile(destFile, content);
		fileLst.add(destFile);
		RegistryResourceUtils.createMetaDataForFolder(registryPath, location.getLocation().toFile());
		RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc, project.getLocation().toFile(),
		                                              registryPath);

		GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
		generalProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());

		RegistryArtifact artifact = new RegistryArtifact();
		artifact.setName(sequenceModel.getSequenceName());
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
			}
			item.setPath(registryResourceInfo.getDeployPath().replaceAll("/$", ""));
			artifact.addRegistryElement(item);
		}
		generalProjectArtifact.addArtifact(artifact);
		generalProjectArtifact.toFile();

		SynapseUtils.createRegsitryResourceBuildArtifactPom(groupId, sequenceModel.getSequenceName(), version,
				SynapseConstants.REGISTRY_RESOURCE_TYPE, sequenceModel.getSequenceName(),
				SynapseConstants.REGISTRY_RESOURCE_FOLDER, project.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER));
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
		pluginExecution.addGoal("copy-registry-dependencies");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("registry");
		plugin.addExecution(pluginExecution);

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		Xpp3Dom outputLocationNode = MavenUtils.createXpp3Node(configurationNode, "outputLocation");
		outputLocationNode.setValue(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
		pluginExecution.setConfiguration(configurationNode);

		Repository repo = new Repository();
		repo.setUrl("https://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-maven2-repository-1");

		Repository repo1 = new Repository();
		repo1.setUrl("https://maven.wso2.org/nexus/content/groups/wso2-public/");
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

	public void copyImportFile(IContainer importLocation, boolean isNewAritfact, String groupId) throws Exception {
		File importFile = getModel().getImportFile();
		File destFile = null;
		List<OMElement> selectedSeqList = ((SequenceModel) getModel()).getSelectedSeqList();
		if (selectedSeqList != null && selectedSeqList.size() > 0) {
			for (OMElement element : selectedSeqList) {
				String name = element.getAttributeValue(new QName("name"));
				destFile = new File(importLocation.getLocation().toFile(), name + ".xml");
				FileUtils.createFile(destFile, element.toString());
				fileLst.add(destFile);
                if (isNewAritfact) {
                    addESBArtifactDetails(importLocation, name, groupId, version, name, esbProjectArtifact);
                }
			}

		} else {
			destFile = new File(importLocation.getLocation().toFile(), importFile.getName());
			FileUtils.copy(importFile, destFile);
			fileLst.add(destFile);
			String name = importFile.getName().replaceAll(".xml$", "");
            if (isNewAritfact) {
                addESBArtifactDetails(importLocation, name, groupId, version, name, esbProjectArtifact);
            }
		}
	}

    private ESBArtifact createArtifact(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType(SynapseConstants.SEQUENCE_CONFIG_TYPE);
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    private void addESBArtifactDetails(IContainer location, String sequenceName, String groupId, String version,
            String sequenceFileName, ESBProjectArtifact esbProjectArtifact) throws Exception {

        String relativeLocation = FileUtils
                .getRelativePath(project.getLocation().toFile(),
                        new File(location.getLocation().toFile(), sequenceName + ".xml"))
                .replaceAll(Pattern.quote(File.separator), "/");
        esbProjectArtifact.addESBArtifact(createArtifact(sequenceName, groupId, version, relativeLocation));
        createSequenceBuildArtifactPom(groupId, sequenceName, version, sequenceFileName, relativeLocation);
    }

    private void createSequenceBuildArtifactPom(String groupId, String artifactId, String version,
            String sequenceFileName, String relativePathToRealArtifact) throws BuildArtifactCreationException {

        IContainer buildArtifactsLocation = project.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
        try {
            SynapseUtils.createSynapseConfigBuildArtifactPom(groupId, artifactId, version,
                    SynapseConstants.SEQUENCE_CONFIG_TYPE, sequenceFileName, SynapseConstants.SEQUECE_FOLDER,
                    buildArtifactsLocation, "../../../" + relativePathToRealArtifact);
        } catch (IOException | XmlPullParserException e) {
            throw new BuildArtifactCreationException("Error while creating the build artifacts for Local Entry config "
                    + sequenceFileName + " at " + buildArtifactsLocation.getFullPath());
        }
    }

	public String createSequenceTemplate(String templateContent) throws IOException {
		// String defaultNS = ESBPreferenceData.getDefaultNamesapce();
		// if(defaultNS.equals("") || defaultNS == null){
		// defaultNS = SynapseConstants.NS_1_4;
		// }
		String content = "";
		templateContent = templateContent.replaceFirst("name=", "{1} name=");
		if (!seqModel.getSelectedEP().equals("")) {
			String contentWithoutClosingTag = templateContent.substring(0, templateContent.length() - 2);
			contentWithoutClosingTag = contentWithoutClosingTag.concat(seqModel.getSelectedEP());

			content =
			          MessageFormat.format(contentWithoutClosingTag, seqModel.getSequenceName(),
			                               seqModel.getOnErrorSequence());
		} else {
			content = MessageFormat.format(templateContent, seqModel.getSequenceName(), seqModel.getOnErrorSequence());
		}
		return content;
	}

	public IResource getCreatedResource() {
		// TODO Auto-generated method stub
		return null;
	}

	public void openEditor(File file) {
		try {
			refreshDistProjects();
			IFile dbsFile =
			                ResourcesPlugin.getWorkspace().getRoot()
			                               .getFileForLocation(Path.fromOSString(file.getAbsolutePath()));
			/*
			 * IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow(
			 * ).getActivePage(),dbsFile);
			 */
			String path = dbsFile.getParent().getFullPath() + "/";
			String source = FileUtils.getContentAsString(file);
			Openable openable = ESBGraphicalEditor.getOpenable();
			String type = ArtifactType.SEQUENCE.getLiteral();
			if ("main.xml".equals(file.getName())) {
				type = ArtifactType.MAIN_SEQUENCE.getLiteral();
			}
			openable.editorOpen(file.getName(), type, path, source);
		} catch (Exception e) {
			log.error("Cannot open the editor", e);
		}
	}

}
