/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.esb.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.wso2.integrationstudio.esb.core.ESBMavenConstants;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.utils.file.FileUtils;

public class SynapseUtils {

	private static String ADDITIONAL_FOLDERS = "default";

	public static String[] getSynapseNamespaces() {
		return new String[] { SynapseConstants.NS_1_4, SynapseConstants.NS_2_0 };
	}

	private static String getLocalTagName(SynapseEntryType type) {
		switch (type) {
		case END_POINT:
			return "endpoint";
		case SEQUENCE:
			return "sequence";
		case PROXY_SERVICE:
			return "proxy";
		case LOCAL_ENTRY:
			return "localEntry";
		case TASK:
			return "task";
		case API:
			return "api";
		case TEMPLATE:
			return "template";
		case MESSAGE_STORE:
			return "messageStore";
		case MESSAGE_PROCESSOR:
			return "messageProcessor";	
		case ALL:
			return "";
		default:
			return "";
		}
	}

	public static List<OMElement> synapseConfigFolderContentProcessing(
			String synapseConfigFolderPath) throws XMLStreamException,
			IOException, OMException, Exception {

		List<OMElement> editorList = new ArrayList<OMElement>();
		File rootDir = new File(synapseConfigFolderPath + "/"
				+ ADDITIONAL_FOLDERS);
		
		if(!rootDir.exists()){
			//throw new Exception("Please provide a valid synapse-configs directory");
			rootDir = new File(synapseConfigFolderPath);
		}
		File[] dirs = rootDir.listFiles();
		int dirCount = dirs.length;
		for (int i = 0; i < dirCount; ++i) {
			String name=dirs[i].getName();
			if(name.equals("api")){
				processFiles(editorList, rootDir + "/api", SynapseEntryType.API);
			}else if(name.equals("endpoints")){
				processFiles(editorList, rootDir + "/endpoints",SynapseEntryType.END_POINT);
			}else if(name.equals("local-entries")){
				processFiles(editorList, rootDir + "/local-entries",SynapseEntryType.LOCAL_ENTRY);
			}else if(name.equals("proxy-services")){
				processFiles(editorList, rootDir + "/proxy-services",SynapseEntryType.PROXY_SERVICE);
			}else if(name.equals("sequences")){
				processFiles(editorList, rootDir + "/sequences",SynapseEntryType.SEQUENCE);
			}else if(name.equals("tasks")){
				processFiles(editorList, rootDir + "/tasks", SynapseEntryType.TASK);
			}else if(name.equals("templates")){
				processFiles(editorList, rootDir + "/templates",SynapseEntryType.TEMPLATE);
			} else if(name.equals("message-stores")){
				processFiles(editorList,rootDir + "/message-stores",SynapseEntryType.MESSAGE_STORE);
			} else if(name.equals("message-processors")){
				processFiles(editorList, rootDir + "/message-processors",SynapseEntryType.MESSAGE_PROCESSOR);
			}
		}
		return editorList;
	}

	private static void processFiles(List<OMElement> editorList,
			String dirPath, SynapseEntryType type) throws XMLStreamException,
			IOException, OMException, Exception {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		int fileCount = files.length;
		for (int j = 0; j < fileCount; ++j) {
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(
					files[j])).getDocumentElement();

			String localTagName = getLocalTagName(type);

			String localName = documentElement.getLocalName();
			if (localName.equals(localTagName)) {
				if (!editorList.contains(documentElement)) {
					editorList.add(documentElement);
				}
			}
		}
	}

    public static void createBuildArtifactsModulePom(IProject project, IFolder buildArtifactsFolder) {
        createBuildArtifactsModulePom(project, buildArtifactsFolder, "../pom.xml");
    }

    public static void createBuildArtifactsModulePom(IProject project, IFolder buildArtifactsFolder,
            String parentRelativePath) {

        try {
            File mavenParentProjectPomFile = project.getFile("pom.xml").getLocation().toFile();

            if (!mavenParentProjectPomFile.exists()) {
                return;
            }
            MavenProject mavenParentProject = MavenUtils.getMavenProject(mavenParentProjectPomFile);

            IFile pomFile = buildArtifactsFolder.getFile(new Path("pom.xml"));
            FileUtils.createFile(pomFile.getLocation().toFile(), "");
            File mavenProjectPomLocation = pomFile.getLocation().toFile();

            MavenProject mavenProject = MavenUtils.createMavenProject(mavenParentProject.getGroupId(),
                    mavenParentProject.getArtifactId() + "_module", mavenParentProject.getVersion(), "pom");

            org.apache.maven.model.Parent parent = new org.apache.maven.model.Parent();
            parent.setGroupId(mavenParentProject.getGroupId()); // Set the parent's group ID
            parent.setArtifactId(mavenParentProject.getArtifactId()); // Set the parent's artifact ID
            parent.setVersion(mavenParentProject.getVersion()); // Set the parent's version
            parent.setRelativePath(parentRelativePath);

            Model model = mavenProject.getModel();
            model.setParent(parent);
            MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

            mavenParentProject.getModules().add(SynapseConstants.BUILD_ARTIFACTS_FOLDER);
            MavenUtils.saveMavenProject(mavenParentProject, mavenParentProjectPomFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void createCappArtifactPom(String groupId, String artifactId, String version, String artifactType,
            String targetFolder, String targetParentFolder, IContainer cappArtifactsLocation,
            String parentPomRelativePath, String pluginGroupId, String pluginArtifactId, String pluginVersion,
            String artifactRelativePath) throws IOException, XmlPullParserException {

        if (!cappArtifactsLocation.exists()) {
            return;
        }
        // Initially create an empty pom.xml file for a given artifact
        File mavenProjectPomFile = cappArtifactsLocation
                .getFile(new Path(targetParentFolder + File.separator + targetFolder + File.separator + "pom.xml"))
                .getLocation().toFile();
        FileUtils.createFile(mavenProjectPomFile, "");

        // Create a Maven project
        MavenProject mavenProject = MavenUtils.createMavenProject(groupId, artifactId, version, artifactType);

        // Set plugins to the Maven project
        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, pluginGroupId, pluginArtifactId, pluginVersion,
                true);

        Xpp3Dom configuration = (Xpp3Dom) plugin.getConfiguration();
        Xpp3Dom aritfact = MavenUtils.createXpp3Node(configuration, "artifact");
        aritfact.setValue(artifactRelativePath);

        // Set parent's details
        File mavenParentProjectPomLocation = cappArtifactsLocation.getFile(new Path("pom.xml")).getLocation().toFile();
        MavenProject mavenParentProject = MavenUtils.getMavenProject(mavenParentProjectPomLocation);
        org.apache.maven.model.Parent parent = new org.apache.maven.model.Parent();
        parent.setGroupId(mavenParentProject.getGroupId()); // Set the parent's group ID
        parent.setArtifactId(mavenParentProject.getArtifactId()); // Set the parent's artifact ID
        parent.setVersion(mavenParentProject.getVersion()); // Set the parent's version
        parent.setRelativePath(parentPomRelativePath);
        mavenProject.getModel().setParent(parent);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomFile);

        // Set this capp-artifact pom as a module in the parent pom file
        mavenParentProject.getModules().add(targetParentFolder + "/" + targetFolder);
        MavenUtils.saveMavenProject(mavenParentProject, mavenParentProjectPomLocation);
    }

    public static void createSynapseConfigBuildArtifactPom(String groupId, String artifactId, String version,
            String artifactType, String artifactFileName, String artifactFolderName, IContainer cappArtifactsLocation,
            String relativePathToRealArtifact) throws IOException, XmlPullParserException {

        createCappArtifactPom(groupId, artifactId, version, artifactType, artifactFileName, artifactFolderName,
                cappArtifactsLocation, "../../pom.xml", "org.wso2.maven", "wso2-mi-synapse-plugin",
                ESBMavenConstants.WSO2_MI_SYNAPSE_VERSION, relativePathToRealArtifact);

    }

    public static void createMetadataBuildArtifactPom(String groupId, String artifactId, String version,
            String artifactType, String artifactFileName, String artifactFolderName, IContainer cappArtifactsLocation,
            String relativePathToRealArtifact) throws IOException, XmlPullParserException {

        createCappArtifactPom(groupId, artifactId, version, artifactType, artifactFileName, artifactFolderName,
                cappArtifactsLocation, "../../pom.xml", "org.wso2.maven", "wso2-esb-metadata-plugin",
                ESBMavenConstants.WSO2_ESB_METADATA_VERSION, relativePathToRealArtifact);

    }

    public static void createConnectorBuildArtifactPom(String groupId, String artifactId, String version,
            String artifactType, String connectorFolderName, String connectorName, String connectorFileName,
            IContainer connectorBuildArtifactLocation) throws IOException, XmlPullParserException {

        createCappArtifactPom(groupId, artifactId, version, artifactType, connectorName + "-" + version,
                connectorFolderName, connectorBuildArtifactLocation, "../../pom.xml", "org.wso2.maven",
                "wso2-esb-connector-plugin", ESBMavenConstants.WSO2_ESB_CONNECTOR_VERSION,
                "../../../" + connectorFileName);

    }

    public static void removeConnectorBuildArtifacts(IContainer connectorBuildArtifactLocation,
            String connectorFolderName, String connectorName, String version)
            throws CoreException, XmlPullParserException, IOException {

        removeConnectorBuildArtifacts(connectorBuildArtifactLocation, connectorFolderName,
                connectorName + "-" + version);
    }

    public static void removeConnectorBuildArtifacts(IContainer connectorBuildArtifactLocation,
            String connectorFolderName, String connectorFileName)
            throws CoreException, XmlPullParserException, IOException {
        if (connectorBuildArtifactLocation.exists()) {
            connectorBuildArtifactLocation.getFolder(new Path(connectorFolderName + File.separator + connectorFileName))
                    .delete(true, new NullProgressMonitor());

            File mavenParentProjectPomLocation = connectorBuildArtifactLocation.getFile(new Path("pom.xml"))
                    .getLocation().toFile();
            removeModuleFromPom(mavenParentProjectPomLocation, connectorFolderName + "/" + connectorFileName);
        }
    }

    public static void createDataServiceBuildArtifactPom(String groupId, String artifactId, String version,
            String artifactType, String artifactFileName, String artifactFileNameWithExtension,
            String artifactFolderName, IContainer buildArtifactsLocation) throws IOException, XmlPullParserException {

        createCappArtifactPom(groupId, artifactId, version, artifactType, artifactFileName, artifactFolderName,
                buildArtifactsLocation, "../../pom.xml", "org.wso2.maven", "maven-dataservice-plugin",
                ESBMavenConstants.WSO2_DATA_SERVICE_VERSION, "../../../dataservice/" + artifactFileNameWithExtension);

    }

    public static void createDataSourceBuildArtifactPom(String groupId, String artifactId, String version,
            String artifactType, String artifactFileName, String artifactFileNameWithExtension,
            String artifactFolderName, IContainer buildArtifactsLocation) throws IOException, XmlPullParserException {

        createCappArtifactPom(groupId, artifactId, version, artifactType, artifactFileName, artifactFolderName,
                buildArtifactsLocation, "../../pom.xml", "org.wso2.maven", "maven-datasource-plugin",
                ESBMavenConstants.WSO2_DATA_SOURCE_VERSION, "../../../datasource/" + artifactFileNameWithExtension);

    }

    public static void createRegsitryResourceBuildArtifactPom(String groupId, String artifactId, String version,
            String artifactType, String artifactFileName, String artifactFolderName, IContainer cappArtifactsLocation)
            throws IOException, XmlPullParserException {

        createCappArtifactPom(groupId, artifactId, version, artifactType, artifactFileName, artifactFolderName,
                cappArtifactsLocation, "../../pom.xml", "org.wso2.maven", "wso2-general-project-plugin",
                ESBMavenConstants.WSO2_GENERAL_PROJECT_VERSION, "registry-info.xml");

    }

    public static void removeESBConfigBuildArtifacts(IContainer buildArtifactLocation, String artifactFolderName,
            String artifactFileName) throws CoreException, IOException, XmlPullParserException {
        if (buildArtifactLocation.exists()) {
            buildArtifactLocation.getFolder(new Path(artifactFolderName + File.separator + artifactFileName))
                    .delete(true, new NullProgressMonitor());

            File mavenParentProjectPomLocation = buildArtifactLocation.getFile(new Path("pom.xml")).getLocation()
                    .toFile();
            removeModuleFromPom(mavenParentProjectPomLocation, artifactFolderName + "/" + artifactFileName);
        }
    }

    public static void removeESBMetadataBuildArtifacts(IContainer buildArtifactLocation, String artifactFolderName,
            String artifactFileName) throws CoreException, IOException, XmlPullParserException {
        if (buildArtifactLocation.exists()) {
            buildArtifactLocation.getFolder(new Path(artifactFolderName + File.separator + artifactFileName))
                    .delete(true, new NullProgressMonitor());

            File mavenParentProjectPomLocation = buildArtifactLocation.getFile(new Path("pom.xml")).getLocation()
                    .toFile();
            removeModuleFromPom(mavenParentProjectPomLocation, artifactFolderName + "/" + artifactFileName);
        }
    }

    public static void removeRegsitryResourceBuildArtifacts(IContainer registryResourceBuildArtifactLocation,
            String artifactFolderName, String artifactFileName)
            throws CoreException, IOException, XmlPullParserException {
        if (registryResourceBuildArtifactLocation.exists()) {
            registryResourceBuildArtifactLocation
                    .getFolder(new Path(artifactFolderName + File.separator + artifactFileName))
                    .delete(true, new NullProgressMonitor());

            File mavenParentProjectPomLocation = registryResourceBuildArtifactLocation.getFile(new Path("pom.xml"))
                    .getLocation().toFile();
            removeModuleFromPom(mavenParentProjectPomLocation, artifactFolderName + "/" + artifactFileName);
        }
    }

    public static void removeDataServiceBuildArtifacts(IContainer buildArtifactLocation, String artifactFolderName,
            String artifactFileName) throws CoreException, IOException, XmlPullParserException {
        if (buildArtifactLocation.exists()) {
            buildArtifactLocation.getFolder(new Path(artifactFolderName + File.separator + artifactFileName))
                    .delete(true, new NullProgressMonitor());

            File mavenParentProjectPomLocation = buildArtifactLocation.getFile(new Path("pom.xml")).getLocation()
                    .toFile();
            removeModuleFromPom(mavenParentProjectPomLocation, artifactFolderName + "/" + artifactFileName);
        }
    }

    public static void removeDataSourceBuildArtifacts(IContainer buildArtifactLocation, String artifactFolderName,
            String artifactFileName) throws CoreException, IOException, XmlPullParserException {
        if (buildArtifactLocation.exists()) {
            buildArtifactLocation.getFolder(new Path(artifactFolderName + File.separator + artifactFileName))
                    .delete(true, new NullProgressMonitor());

            File mavenParentProjectPomLocation = buildArtifactLocation.getFile(new Path("pom.xml")).getLocation()
                    .toFile();
            removeModuleFromPom(mavenParentProjectPomLocation, artifactFolderName + "/" + artifactFileName);
        }
    }

    private static void removeModuleFromPom(File mavenParentProjectPomLocation, String module)
            throws IOException, XmlPullParserException {
        MavenProject mavenParentProject = MavenUtils.getMavenProject(mavenParentProjectPomLocation);
        mavenParentProject.getModules().remove(module);
        MavenUtils.saveMavenProject(mavenParentProject, mavenParentProjectPomLocation);
    }

}
