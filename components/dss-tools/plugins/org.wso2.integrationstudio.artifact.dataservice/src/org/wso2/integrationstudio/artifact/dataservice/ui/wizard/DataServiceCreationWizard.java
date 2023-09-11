/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.dataservice.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.wso2.integrationstudio.artifact.dataservice.Activator;
import org.wso2.integrationstudio.artifact.dataservice.artifact.DSSArtifact;
import org.wso2.integrationstudio.artifact.dataservice.artifact.DSSProjectArtifact;
import org.wso2.integrationstudio.artifact.dataservice.model.DataServiceModel;
import org.wso2.integrationstudio.artifact.dataservice.model.GenerateDataServiceModel;
import org.wso2.integrationstudio.artifact.dataservice.ui.wizard.GenerateDataServicesUtils.Methods;
import org.wso2.integrationstudio.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.integrationstudio.artifact.dataservice.utils.DataServiceImageUtils;
import org.wso2.integrationstudio.artifact.dataservice.utils.DataServiceTemplateUtils;
import org.wso2.integrationstudio.capp.maven.utils.MavenConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.project.presentation.ProjectPresentation;
import org.wso2.integrationstudio.platform.core.utils.XMLUtil;
import org.wso2.integrationstudio.platform.ui.validator.CommonFieldValidator;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.integrationstudio.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.integrationstudio.platform.ui.wizard.pages.ProjectOptionsPage;
import org.wso2.integrationstudio.utils.data.ITemporaryFileTag;
import org.wso2.integrationstudio.utils.file.FileUtils;
import org.wso2.integrationstudio.utils.ide.FileExtensionResourcevisitor;
import org.wso2.integrationstudio.utils.project.ProjectUtils;

public class DataServiceCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.ds.project.nature";
	private static final String IMPORT_OPTION = "import.ds";
	private static final String NEW_OPTION = "new.ds";
	private static final String GENERATE_OPTION = "generate.ds";
	private static final String POM_FILE = "pom.xml";
	private static final String GROUP_ID = "org.wso2.maven";
	private static final String ARTIFACT_ID = "maven-dataservice-plugin";
	private static final String ARTIFACT_FILE = "artifact.xml";
	private static final String DBS_EXTENSION = ".dbs";
	private static final String TYPE = SynapseConstants.DATA_SERVICE_TYPE;
	private static final String SERVER_ROLE = "DataServicesServer";
	private static final String LINE_SEPERATOR = "line.separator";
	private static final String DATASERVICE_TEMPLATE = "templates/Dataservice1.dbs";
	private static final String DATASERVICE_TEMPLATE_SECRETALIAS = "templates/Dataservice2.dbs";
	private String version = "1.0.0";
	private static final String DSS_PERSPECTIVE = "org.wso2.integrationstudio.ds.presentation.custom.perspective";
	
	private static final String SINGLE_SERVICE_DESCRIPTION = "single service for whole database";
	private static final String MUTLIPLE_SERVICE_DESCRIPTION = "multiple services per each table";
	private static final String WSO2_DS_NAMESPACE = "http://ws.wso2.org/dataservice";
	private static final String COLUMN_NAME = "COLUMN_NAME";
	private static final String DATA_TYPE = "DATA_TYPE";
	private static final String AUTOINCREMENT_COLUMN = "IS_AUTOINCREMENT";
	private static final String IDENTITY_COLUMN = "Identity";
	private static final String IS_AUTOINCREMENT = "YES";


	private final DataServiceModel dsModel;
	private DSSProjectArtifact dssProjectArtifact;
	private IProject project;
	private IWizardPage[] pages;
	private GenerateDataServicesWizardPage generateDataServiceWizard;
	private GenerateDataServiceModel generateDataServiceModel;

	public DataServiceCreationWizard() {
		this.dsModel = new DataServiceModel();
		setModel(this.dsModel);
		setWindowTitle(DataServiceArtifactConstants.DS_WIZARD_WINDOW_TITLE);
		
		generateDataServiceModel = new GenerateDataServiceModel();
		generateDataServiceWizard = new GenerateDataServicesWizardPage(generateDataServiceModel);
		setDefaultPageImageDescriptor(DataServiceImageUtils.getInstance().getImageDescriptor("ds-wizard.png"));
	}

	public boolean performFinish() {
		try {
			
			if (getModel().getSelectedOption().equals(IMPORT_OPTION)) {
			    File openFile = null;
				if (dsModel.getDataServiceSaveLocation() != null) {
					project = dsModel.getDataServiceSaveLocation().getProject();
				} else {
					project = createNewProject();
					createDSSProjectStructure(project);
				}
				// gets the import file from the file location
				File importFile = dsModel.getImportFile();
				// gets the imported file from workspace location
				openFile = saveImportFileToWorkspace(project, importFile);
				/*
				 * FIXME When importing an already included .dbs then the
				 * project wizard is not getting closed
				 */
				if (openFile.exists()) {
					if (!MessageDialog
							.openQuestion(getShell(), "WARNING", DataServiceArtifactConstants.WARNING_MESSAGE)) {
						return true;
					}
				}
				FileUtils.copy(importFile, openFile);
				createServiceArtifacts(openFile);
			}

			if (getModel().getSelectedOption().equals(NEW_OPTION)) {
			    File openFile = null;
				if (dsModel.getDataServiceSaveLocation() != null) {

					if (dsModel.getDataServiceSaveLocation().getProject().getLocation() != null) {
						project = dsModel.getDataServiceSaveLocation().getProject();
					} else {
						project = createNewDSSProject(dsModel.getDataServiceSaveLocation().getProject().getName());
						createDSSProjectStructure(project);
					}
				}

				openFile = addDSTemplate(project);
				createServiceArtifacts(openFile);
			}
			
			if (getModel().getSelectedOption().equals(GENERATE_OPTION)) {
			    if (generateDataServiceModel.getDatasource() != null) {
			        if (dsModel.getDataServiceSaveLocation().getProject().getLocation() != null) {
			            project = dsModel.getDataServiceSaveLocation().getProject();
			        } else {
			            project = createNewDSSProject(dsModel.getDataServiceSaveLocation().getProject().getName());
			            createDSSProjectStructure(project);
			        }
			        if (generateDataServiceModel.isGenerateSingleService()) {
			            File openFile = generateSingleDataService(project);
			            createServiceArtifacts(openFile);
                    } else {
                        Map<String, EnumSet<Methods>> tables = generateDataServiceModel.getTables();
                        for (Map.Entry<String, EnumSet<Methods>> entry : tables.entrySet()) {
                            File openFile = generatePerTableDataService(project, entry.getKey(), entry.getValue());
                            createServiceArtifacts(openFile);
                        }
                    }                            
                }               
            }			
		} catch (CoreException e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		} catch (Exception e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_UNEXPECTED_ERROR, e);
		}

		return true;
	}
	
    private void createServiceArtifacts(File openFile) throws FactoryConfigurationError, CoreException, Exception {
        getModel().addToWorkingSet(project);
        File mavenProjectPom = project.getFile(POM_FILE).getLocation().toFile();
        if (!project.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER).exists()) {
            updateDSSPlugin(openFile, mavenProjectPom);
        }
        String groupId = getMavenGroupId(mavenProjectPom) + ".dataservice";
        String relativePath = FileUtils.getRelativePath(project.getLocation().toFile(), openFile)
                .replaceAll(Pattern.quote(File.separator), "/");

        // adds meta data about the data service
        addMetaData(openFile, groupId, relativePath);
        try {
            refreshDistProjects();
            IFile dbsFile = ResourcesPlugin.getWorkspace().getRoot()
                    .getFileForLocation(Path.fromOSString(openFile.getAbsolutePath()));
            IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), dbsFile);
        } catch (Exception e) {
            log.error(DataServiceArtifactConstants.ERROR_MESSAGE_FILE_OPEN, e);
        }
        try {
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            PlatformUI.getWorkbench().showPerspective(DSS_PERSPECTIVE, window);
            ProjectPresentation.setHierarchicalProjectPresentation();
        } catch (Exception e) {
            log.error(DataServiceArtifactConstants.ERROR_MESSAGE_FILE_OPEN, e);
        }
    }

	/**
	 * Adds meta data
	 * 
	 * @param openFile
	 *            data service file
	 * @param groupId
	 *            group ID
	 * @param relativePath
	 *            relative path
	 * @throws FactoryConfigurationError
	 * @throws Exception
	 * @throws CoreException
	 */
	private void addMetaData(File openFile, String groupId, String relativePath) throws FactoryConfigurationError,
			Exception, CoreException {
		dssProjectArtifact = new DSSProjectArtifact();
		dssProjectArtifact.fromFile(project.getFile(ARTIFACT_FILE).getLocation().toFile());

		String servieName = FilenameUtils.removeExtension(openFile.getName());
		dssProjectArtifact.addDSSArtifact(createArtifact(servieName, groupId, version, relativePath));
		dssProjectArtifact.toFile();
		SynapseUtils.createDataServiceBuildArtifactPom(groupId, servieName, version, TYPE, servieName,
				openFile.getName(), SynapseConstants.DATA_SERVICE_FOLDER,
				project.getFolder(SynapseConstants.BUILD_ARTIFACTS_FOLDER));
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	/**
	 * Creates artifact
	 * 
	 * @param name
	 *            artifact name
	 * @param groupId
	 *            group ID
	 * @param version
	 *            version
	 * @param path
	 *            path
	 * @return artifact
	 */
	private DSSArtifact createArtifact(String name, String groupId, String version, String path) {
		DSSArtifact artifact = new DSSArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(TYPE);
		artifact.setServerRole(SERVER_ROLE);
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

    /**
     * Updates the pom file
     * 
     * @param openFile
     *            current .dbs file
     * @throws Exception
     */
    public void updateDSSPlugin(File openFile, File mavenProjectPom) throws IOException, XmlPullParserException {
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPom);

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID)) {
            return;
        }

        Plugin pluginEntry = MavenUtils.createPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
                MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("dataservice");

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        pluginEntry.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPom);
    }

	/**
	 * Creates a new DSS project
	 * 
	 * @param projectName
	 *            project name
	 * @return project
	 */
	private IProject createNewDSSProject(String projectName) {
		String name = projectName;
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);

		try {
			project.create(progressMonitor);
			project.open(progressMonitor);
		} catch (CoreException e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		}

		return project;
	}

	/**
	 * Gets the .dbs file
	 * 
	 * @return data service resource file
	 * @throws CoreException
	 */
	private IFile getDBSFile() throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		FileExtensionResourcevisitor fileExtensionResourceVisitor = new FileExtensionResourcevisitor(DBS_EXTENSION,
				IResource.FILE);
		project.accept(fileExtensionResourceVisitor);
		List<IResource> resources = fileExtensionResourceVisitor.getResourceList();
		return resources.size() == 0 ? null : (IFile) resources.get(0);
	}

	/**
	 * Gets the dss plugin if it is already available
	 * 
	 * @param project
	 *            maven project
	 * @param groupId
	 *            group ID
	 * @param artifactId
	 *            artufact ID
	 * @param version
	 *            version
	 * @return dss plugin
	 */
	private Plugin getExistingPlugin(MavenProject project, String groupId, String artifactId, String version) {
		List<Plugin> plugins = project.getBuild().getPlugins();
		Iterator<Plugin> iterator = plugins.iterator();
		Plugin dssPlugin = null;
		while (iterator.hasNext()) {
			Plugin plugin = iterator.next();
			if (plugin.getGroupId().equals(groupId) && plugin.getArtifactId().equals(artifactId)) {
				dssPlugin = plugin;
			}
		}
		return dssPlugin;
	}

	/**
	 * Adds import file to the workspace project
	 * 
	 * @param importProject
	 *            project
	 * @param importFile
	 *            import .dbs
	 * @return new .dbs file
	 * @throws IOException
	 */
	public File saveImportFileToWorkspace(IProject importProject, File importFile) throws IOException {

		IFolder dsResourceFolder = ProjectUtils.getWorkspaceFolder(importProject,
				DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File dsResourceFile = new File(dsResourceFolder.getLocation().toFile(), importFile.getName());
		return dsResourceFile;
	}

	/**
	 * Creates a new DSS project
	 * 
	 * @return
	 */
	private void createDSSProjectStructure(IProject project) {
		try {
			// createDSSProjectStructure(project);
			IFolder dsfolder = ProjectUtils.getWorkspaceFolder(project,
					DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
			if (!dsfolder.exists()) {
				// creates the template
				ProjectUtils.createFolder(dsfolder);
			}
			File pomfile = project.getFile(POM_FILE).getLocation().toFile();
			getModel().getMavenInfo().setPackageName(TYPE);
			// creates the pom file
			createPOM(pomfile);
			// updates pom file with data service plugin
			// updatePOMWithDSSPlugin(pomfile);

			ProjectUtils.addNatureToProject(project, false, DS_PROJECT_NATURE);
			MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {}, new String[] { DS_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			// creates the artifact.xml file
			createArtifactXMLFile();
		} catch (CoreException e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		} catch (Exception e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_UNEXPECTED_ERROR, e);
		}

	}

	/**
	 * Creating the metadata file artifact.xml while creating the DSS project.
	 * It will be hidden and users won't be able to see it via Eclipse.
	 * 
	 * @throws Exception
	 * @throws CoreException
	 */
	private void createArtifactXMLFile() throws Exception, CoreException {
		DSSProjectArtifact artifact = new DSSProjectArtifact();
		IFile file = project.getFile(ARTIFACT_FILE);
		artifact.setSource(file.getLocation().toFile());
		artifact.toFile();
		getModel().addToWorkingSet(project);
		/*
		 * Refresh the project to show the changes. But still won't see the
		 * newly created project.
		 */
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		refreshDistProjects();
		// Setting the created file to be hidden so that users won't see it.
//		if (file.exists()) {
//			file.setHidden(true);
//		}
	}

	/**
	 * Updates the pom file
	 * 
	 * @param openFile
	 *            current .dbs file
	 * @throws Exception
	 */
	public void updatePOMWithDSSPlugin(File mavenProjectPomLocation) throws Exception {
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
				MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION);

		if (!pluginExists) {
			MavenUtils.createPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
					MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION, true);
		}

		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	/**
	 * Copies the import file
	 * 
	 * @param importProject
	 *            project
	 * @return .dbs file
	 * @throws IOException
	 */
	public File copyImportFile(IProject importProject) throws IOException {
		File importFile = getModel().getImportFile();
		IFolder dsResourceFolder = ProjectUtils.getWorkspaceFolder(importProject,
				DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File dsResourceFile = new File(dsResourceFolder.getLocation().toFile(), importFile.getName());
		FileUtils.copy(importFile, dsResourceFile);
		return dsResourceFile;
	}

	/**
	 * Adds the template
	 * 
	 * @param project
	 *            project
	 * @return .dbs file
	 * @throws Exception
	 */
	private File addDSTemplate(IProject project) throws Exception {
		String eol = System.getProperty(LINE_SEPERATOR);
		ITemporaryFileTag dsTempTag = FileUtils.createNewTempTag();
		StringBuffer sb = new StringBuffer();
		File dsTemplateFile;
		boolean isSecretAliasEnabled = dsModel.isEnableSecretAlias();
		if (!isSecretAliasEnabled) {
		    dsTemplateFile = new DataServiceTemplateUtils().getResourceFile(DATASERVICE_TEMPLATE);
		} else {
		    dsTemplateFile = new DataServiceTemplateUtils().getResourceFile(DATASERVICE_TEMPLATE_SECRETALIAS);
		}
		String templateContent = FileUtils.getContentAsString(dsTemplateFile);
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		templateContent = templateContent.replaceAll("<service.name>", dsModel.getServiceName());
		templateContent = templateContent.replaceAll("<service.group>", dsModel.getServiceGroup());
		templateContent = templateContent.replaceAll("<service.NS>", dsModel.getServiceNS());
		templateContent = templateContent.replaceAll("<service.description>", dsModel.getServiceDescription());

		//Set transport property values
		List<String> selectedTransports = dsModel.getTransports();
		String delimeter = " ";
		String transports = String.join(delimeter, selectedTransports);
		templateContent = templateContent.replaceAll("<service.transports>", transports);

		IFolder dsfolder = project.getFolder(DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File template = new File(dsfolder.getLocation().toFile(), dsModel.getServiceName() + DBS_EXTENSION);
		templateContent = XMLUtil.prettify(templateContent);
		templateContent = templateContent.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		templateContent = templateContent.replaceAll("^" + eol, "");
		FileUtils.createFile(template, templateContent);
		dsTempTag.clearAndEnd();
		return template;
	}
	
    /**
     * Adds the template
     * 
     * @param project
     *            project
     * @return .dbs file
     * @throws Exception
     */
    private File generateSingleDataService(IProject project) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element dataElement = generateDataElement(doc, generateDataServiceModel.getServiceName());

        Element descriptionEle = doc.createElement("description");
        descriptionEle.setTextContent(SINGLE_SERVICE_DESCRIPTION);
        dataElement.appendChild(descriptionEle);

        Element configEle = generateConfigElement(doc);
        dataElement.appendChild(configEle);
        
        Map<String, EnumSet<Methods>> tables = generateDataServiceModel.getTables();
        DatabaseMetaData metadata = generateDataServiceModel.getMetadata();
        for (Map.Entry<String, EnumSet<Methods>> entry : tables.entrySet()) {
            Map<String, String> columnsList = new HashMap<String, String>();
            Map<String, String> primaryKeys = new HashMap<String, String>();
            Map<String, String> autoIncrementFeilds = new HashMap<String, String>();
            String columnNameString = "";
            int i = 0;
            String table = entry.getKey();
            try (ResultSet rs = metadata.getColumns(null, null, table, null)) {
                while (rs.next()) {
                    String name = rs.getString(COLUMN_NAME);
                    int type = rs.getInt(DATA_TYPE);
                    String sqlType = getSQLType(type);
                    if (this.isAutoIncrementField(rs)) {
                        autoIncrementFeilds.put(name, sqlType);
                        continue;
                    }
                    columnsList.put(name, sqlType);
                    if (i == 0) {
                        columnNameString = " " + name;
                    } else {
                        columnNameString = columnNameString + ", " + name;
                    }
                    i++;
                }
            }
            try (ResultSet rs = metadata.getPrimaryKeys(null, null, table)) {
                while (rs.next()) {
                    String name = rs.getString(COLUMN_NAME);
                    String sqlType = columnsList.get(name);
                    if (sqlType == null) {
                        sqlType = autoIncrementFeilds.get(name);
                    }
                    primaryKeys.put(name, sqlType);
                }
            }
            EnumSet<Methods> methods = entry.getValue();
            if (methods.contains(Methods.GET)) {
                generateSelectAllDefinition(doc, dataElement, table, columnNameString, columnsList);
            }
            if (methods.contains(Methods.POST)) {
                generateInsertDefinition(doc, dataElement, table, columnsList);
            }
            if (methods.contains(Methods.PUT)) {
                generateUpdateDefinition(doc, dataElement, table, columnsList, primaryKeys);
            }
            if (methods.contains(Methods.DELETE)) {
                generateDeleteDefinition(doc, dataElement, table, columnsList, primaryKeys);
            }
        }

        doc.appendChild(dataElement);
        return generateServiceFromDoc(doc, generateDataServiceModel.getServiceName());
    }
    
    private boolean isAutoIncrementField(ResultSet columnNames) {
        try {
            String autoIncrString = columnNames.getString(AUTOINCREMENT_COLUMN);
            if (IS_AUTOINCREMENT.equalsIgnoreCase(autoIncrString)) {
                return true;
            }
            Boolean identity = columnNames.getBoolean(IDENTITY_COLUMN);
            if (identity != null) {
                return identity;
            }
        } catch (SQLException ignore) {
            // ignore
        }       
        return false;
    }
    
    /**
     * Adds the template
     * 
     * @param project
     *            project
     * @return .dbs file
     * @throws Exception
     */
    private File generatePerTableDataService(IProject project, String table, EnumSet<Methods> methods) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element dataElement = generateDataElement(doc, table + "_DataService");
        
        Element descriptionEle = doc.createElement("description");
        descriptionEle.setTextContent(MUTLIPLE_SERVICE_DESCRIPTION);
        dataElement.appendChild(descriptionEle);
    
        Element configEle = generateConfigElement(doc);
        dataElement.appendChild(configEle);
        
        DatabaseMetaData metadata = generateDataServiceModel.getMetadata();
        Map<String, String> columnsList = new HashMap<String, String>();
        Map<String, String> primaryKeys = new HashMap<String, String>();
        Map<String, String> autoIncrementFeilds = new HashMap<String, String>();
        String columnNameString = "";
        int i = 0;
        try (ResultSet rs = metadata.getColumns(null, null, table, null)) {
            while (rs.next()) {
                String name = rs.getString(COLUMN_NAME);
                int type = rs.getInt(DATA_TYPE);
                String sqlType = getSQLType(type);
                if (this.isAutoIncrementField(rs)) {
                    autoIncrementFeilds.put(name, sqlType);
                    continue;
                }
                columnsList.put(name, sqlType);
                if (i == 0) {
                    columnNameString = " " + name;
                } else {
                    columnNameString = columnNameString + ", " + name;
                }
                i++;
            }
        }
        try (ResultSet rs = metadata.getPrimaryKeys(null, null, table)) {
            while (rs.next()) {
                String name = rs.getString(COLUMN_NAME);
                String sqlType = columnsList.get(name);
                if (sqlType == null) {
                    sqlType = autoIncrementFeilds.get(name);
                }
                primaryKeys.put(name, sqlType);
            }
        }
        if (methods.contains(Methods.GET)) {
            generateSelectAllDefinition(doc, dataElement, table, columnNameString, columnsList);
        }
        if (methods.contains(Methods.POST)) {
            generateInsertDefinition(doc, dataElement, table, columnsList);
        }
        if (methods.contains(Methods.PUT)) {
            generateUpdateDefinition(doc, dataElement, table, columnsList, primaryKeys);
        }
        if (methods.contains(Methods.DELETE)) {
            generateDeleteDefinition(doc, dataElement, table, columnsList, primaryKeys);
        }
        doc.appendChild(dataElement);       
        return generateServiceFromDoc(doc, table + "_DataService");
    }
    
    private String getSQLType(int type) {
        if ((-1 == type) || (-16 == type) || (-15 == type)
                || (2009 == type) || (1111 == type)) {
            type = 1;
        }
        return GenerateDataServicesUtils.getDefinedTypes().get(type);
    }
    
    private Element generateDataElement(Document doc, String name) {
        Element dataElement = doc.createElement("data");
        dataElement.setAttribute("name", name);
        dataElement.setAttribute("disableLegacyBoxcarringMode", "false");
        dataElement.setAttribute("enableBatchRequests", "false");
        dataElement.setAttribute("enableBoxcarring", "false");
        dataElement.setAttribute("serviceNamespace", WSO2_DS_NAMESPACE);
        dataElement.setAttribute("serviceStatus", "active");
        dataElement.setAttribute("transports", "http https");
        return dataElement;
    }
    
    private Element generateConfigElement(Document doc) {
        Element configEle = doc.createElement("config");
        configEle.setAttribute("id", "default");
        Element configPropEle = doc.createElement("property");
        configPropEle.setAttribute("name", "carbon_datasource_name");
        configPropEle.setTextContent(generateDataServiceModel.getDatasource());
        configEle.appendChild(configPropEle);
        return configEle;
    }

    private void generateSelectAllDefinition(Document doc, Element dataElement, String table, String columnNameString,
            Map<String, String> columnsList) {
        Element queryEle = doc.createElement("query");
        queryEle.setAttribute("id", "select_all_" + table + "_query");
        queryEle.setAttribute("useConfig", "default");
        String query = GenerateDataServicesUtils.getSelectAll(table, "", columnNameString);
        Element sqlEle = doc.createElement("sql");
        sqlEle.setTextContent(query);
        queryEle.appendChild(sqlEle);

        Element resultEle = doc.createElement("result");
        resultEle.setAttribute("element", table + "Collection");
        resultEle.setAttribute("rowName", table);

        for (Map.Entry<String, String> column : columnsList.entrySet()) {
            Element columnEle = doc.createElement("element");
            columnEle.setAttribute("column", column.getKey());
            columnEle.setAttribute("name", column.getKey());
            columnEle.setAttribute("xsdType", "xs:" + column.getValue().toLowerCase());
            resultEle.appendChild(columnEle);
        }
        queryEle.appendChild(resultEle);

        Element resourceEle = doc.createElement("resource");
        resourceEle.setAttribute("method", "GET");
        resourceEle.setAttribute("path", table);
        Element callQueryEle = doc.createElement("call-query");
        callQueryEle.setAttribute("href", "select_all_" + table + "_query");
        resourceEle.appendChild(callQueryEle);

        dataElement.appendChild(queryEle);
        dataElement.appendChild(resourceEle);
    }

    private void generateInsertDefinition(Document doc, Element dataElement, String table,
            Map<String, String> columnsList) {
        Element queryEle = doc.createElement("query");
        queryEle.setAttribute("id", "insert_" + table + "_query");
        queryEle.setAttribute("useConfig", "default");
        String query = GenerateDataServicesUtils.getInsertStatement(table, "",
                columnsList.keySet().stream().collect(Collectors.toList()));
        Element sqlEle = doc.createElement("sql");
        sqlEle.setTextContent(query);
        queryEle.appendChild(sqlEle);

        Element callQueryEle = doc.createElement("call-query");
        callQueryEle.setAttribute("href", "insert_" + table + "_query");

        int i = 1;
        for (Map.Entry<String, String> column : columnsList.entrySet()) {
            Element paramEle = doc.createElement("param");
            paramEle.setAttribute("name", column.getKey());
            paramEle.setAttribute("ordinal", "" + i);
            paramEle.setAttribute("paramType", "SCALAR");
            paramEle.setAttribute("sqlType", column.getValue());
            paramEle.setAttribute("type", "IN");
            queryEle.appendChild(paramEle);

            Element withParamEle = doc.createElement("with-param");
            withParamEle.setAttribute("name", column.getKey());
            withParamEle.setAttribute("query-param", column.getKey());
            callQueryEle.appendChild(withParamEle);
            i++;
        }
        Element resourceEle = doc.createElement("resource");
        resourceEle.setAttribute("method", "POST");
        resourceEle.setAttribute("path", table);
        resourceEle.appendChild(callQueryEle);

        dataElement.appendChild(queryEle);
        dataElement.appendChild(resourceEle);
    }

    private void generateUpdateDefinition(Document doc, Element dataElement, String table,
            Map<String, String> columnsList, Map<String, String> primaryKeys) {
        Element queryEle = doc.createElement("query");
        queryEle.setAttribute("id", "update_" + table + "_query");
        queryEle.setAttribute("useConfig", "default");
        String query = GenerateDataServicesUtils.getUpdateStatement(table, "",
                columnsList.keySet().stream().collect(Collectors.toList()),
                primaryKeys.keySet().stream().collect(Collectors.toList()));
        Element sqlEle = doc.createElement("sql");
        sqlEle.setTextContent(query);
        queryEle.appendChild(sqlEle);

        Element callQueryEle = doc.createElement("call-query");
        callQueryEle.setAttribute("href", "update_" + table + "_query");

        int i = 1;
        for (Map.Entry<String, String> column : columnsList.entrySet()) {
            if (primaryKeys.containsKey(column.getKey())) {
                continue;
            }
            Element paramEle = doc.createElement("param");
            paramEle.setAttribute("name", column.getKey());
            paramEle.setAttribute("ordinal", "" + i);
            paramEle.setAttribute("paramType", "SCALAR");
            paramEle.setAttribute("sqlType", column.getValue());
            paramEle.setAttribute("type", "IN");
            queryEle.appendChild(paramEle);

            Element withParamEle = doc.createElement("with-param");
            withParamEle.setAttribute("name", column.getKey());
            withParamEle.setAttribute("query-param", column.getKey());
            callQueryEle.appendChild(withParamEle);
            i++;
        }
        for (Map.Entry<String, String> primaryKey : primaryKeys.entrySet()) {
            Element paramEle = doc.createElement("param");
            paramEle.setAttribute("name", primaryKey.getKey());
            paramEle.setAttribute("ordinal", "" + i);
            paramEle.setAttribute("paramType", "SCALAR");
            paramEle.setAttribute("sqlType", primaryKey.getValue());
            paramEle.setAttribute("type", "IN");
            queryEle.appendChild(paramEle);

            Element withParamEle = doc.createElement("with-param");
            withParamEle.setAttribute("name", primaryKey.getKey());
            withParamEle.setAttribute("query-param", primaryKey.getKey());
            callQueryEle.appendChild(withParamEle);
            i++;
        }

        Element resourceEle = doc.createElement("resource");
        resourceEle.setAttribute("method", "PUT");
        resourceEle.setAttribute("path", table);
        resourceEle.appendChild(callQueryEle);

        dataElement.appendChild(queryEle);
        dataElement.appendChild(resourceEle);

    }

    private void generateDeleteDefinition(Document doc, Element dataElement, String table,
            Map<String, String> columnsList, Map<String, String> primaryKeys) {
        Element queryEle = doc.createElement("query");
        queryEle.setAttribute("id", "delete_" + table + "_query");
        queryEle.setAttribute("useConfig", "default");
        String query = GenerateDataServicesUtils.getDeleteStatement(table, "",
                primaryKeys.keySet().stream().collect(Collectors.toList()));
        Element sqlEle = doc.createElement("sql");
        sqlEle.setTextContent(query);
        queryEle.appendChild(sqlEle);

        Element callQueryEle = doc.createElement("call-query");
        callQueryEle.setAttribute("href", "delete_" + table + "_query");

        int i = 1;
        for (Map.Entry<String, String> column : primaryKeys.entrySet()) {
            Element paramEle = doc.createElement("param");
            paramEle.setAttribute("name", column.getKey());
            paramEle.setAttribute("ordinal", "" + i);
            paramEle.setAttribute("paramType", "SCALAR");
            paramEle.setAttribute("sqlType", column.getValue());
            paramEle.setAttribute("type", "IN");
            queryEle.appendChild(paramEle);

            Element withParamEle = doc.createElement("with-param");
            withParamEle.setAttribute("name", column.getKey());
            withParamEle.setAttribute("query-param", column.getKey());
            callQueryEle.appendChild(withParamEle);
            i++;
        }

        Element resourceEle = doc.createElement("resource");
        resourceEle.setAttribute("method", "DELETE");
        resourceEle.setAttribute("path", table);
        resourceEle.appendChild(callQueryEle);

        dataElement.appendChild(queryEle);
        dataElement.appendChild(resourceEle);

    }
    
    private File generateServiceFromDoc(Document doc, String name) throws TransformerException, IOException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        StringWriter sw = new StringWriter();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        trans.transform(new DOMSource(doc), new StreamResult(sw));

        IFolder dsfolder = project.getFolder(DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
        File template = new File(dsfolder.getLocation().toFile(), name + DBS_EXTENSION);
        String templateContent = sw.toString();
        templateContent = templateContent.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>", "");
        FileUtils.createFile(template, templateContent);
        return template;
    }
    
	public IResource getCreatedResource() {
		return project;
	}

	protected boolean isRequireProjectLocationSection() {
		return false;
	}

	public void addPages() {
		super.addPages();
		pages = getPages();
		generateDataServiceModel.setLocation(dsModel.getLocation());
		addPage(generateDataServiceWizard);
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (page instanceof ProjectOptionsDataPage) {
			if (getModel().getSelectedOption().equalsIgnoreCase(NEW_OPTION)) {
				nextPage = null;
			} else {
				nextPage = null;
			}
		} else if (dsModel.isGenerateDataService()) {
		    IWizardPage currentPage = getContainer().getCurrentPage();
		    if (currentPage instanceof GenerateDataServicesWizardPage) {
		        nextPage = null;
		    } else {
		        nextPage = generateDataServiceWizard;
		    }
		} 
		return nextPage;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getNextPage(page);
		if (page instanceof ProjectOptionsPage) {
		    return null;
		}
		return previousPage;
	}

	public boolean canFinish() {
	    IWizardPage page = getContainer().getCurrentPage();
		if (page instanceof ProjectOptionsDataPage) {
			if (getModel().getSelectedOption().equalsIgnoreCase(NEW_OPTION)) {
                if (getModel() instanceof DataServiceModel
                        && !((DataServiceModel) getModel()).getServiceName().isEmpty()
                        && ((DataServiceModel) getModel()).getServiceName() != null
                        && !(((DataServiceModel) getModel()).getServiceName().indexOf(0x20) != -1)
                        && CommonFieldValidator.isValidArtifactName(((DataServiceModel) getModel()).getServiceName())
                        && !(new File(getModel().getLocation().getAbsolutePath() + File.separator
                                + ((DataServiceModel) getModel()).getServiceName() + ".dbs").exists())) {
                    return true;
                }
                return false;
			} else {
				return dsModel.getImportFile().exists();
			}
		} else if (page instanceof ProjectOptionsPage) {
		    return false;
		} else if (page instanceof GenerateDataServicesWizardPage) {
            if (generateDataServiceModel.getDatasource() != null
                    && generateDataServiceModel.getTables() != null
                    && generateDataServiceModel.getTables().size() > 0
                    && !(new File(getModel().getLocation().getAbsolutePath() + File.separator
                            + "dataservice" + File.separator + 
                            generateDataServiceModel.getServiceName() + ".dbs").exists())) {
                return true;
            }
            return false;
		}
	    return true;
	}

}
