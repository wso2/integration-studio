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

package org.wso2.developerstudio.eclipse.artifact.cep.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMException;
import org.apache.commons.io.IOUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.apache.commons.io.FilenameUtils;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.artifact.cep.Activator;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.cep.ui.wizard.CEPProjectCreationWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class CEPProjectUtils {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private static String ADDITIONAL_FOLDERS1 = "src/main";
	private static String ADDITIONAL_FOLDERS2 = "server";
	
	public static IProject createCEPProject(Shell shell,File location){
		IWizardDescriptor wizardDesc = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard("org.wso2.developerstudio.eclipse.artifact.newcepartifact");
		if (wizardDesc!=null) {
			try {
				IProject cepProject = null;
				CEPProjectCreationWizard cepProjectWizard = (CEPProjectCreationWizard) wizardDesc.createWizard();
				IStructuredSelection selection = (IStructuredSelection) PlatformUI
												.getWorkbench().getActiveWorkbenchWindow()
												.getSelectionService().getSelection();
				cepProjectWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, cepProjectWizard);
				cepProjectWizard.getModel().setLocation(location);
				dialog.create();
				if(dialog.open() ==Dialog.OK){
					String projectName = cepProjectWizard.getCepProjectModel().getAnalyticsName();
					cepProject = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(projectName);
				}
				return cepProject;
			} catch (CoreException e) {
				log.error("CoreException has occurred",e);
			}
		}
		return null;
	}
	
	
	public static boolean artifactExists(IProject project, String artifactName) throws Exception {
		CEPProjectArtifact cepProjectArtifact = new CEPProjectArtifact();
		cepProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
		List<CEPArtifact> allArtifacts = cepProjectArtifact.getAllCEPArtifacts();
		for (CEPArtifact artifact : allArtifacts) {
			if (artifactName.equalsIgnoreCase(artifact.getName()))
				return true;
		}
		return false;
	}
	
	public static Map<File,String> cepProjectFolderContentProcessing(
			String cepProjectFolderPath) throws XMLStreamException,
			IOException, OMException, Exception {

		Map<File,String> editorList = new HashMap<File,String>();	
		
		File rootDir1 = new File(cepProjectFolderPath + "/"
				+ ADDITIONAL_FOLDERS1);
		File rootDir2 = new File(cepProjectFolderPath + "/"
				+ ADDITIONAL_FOLDERS2);

		if(rootDir1.exists()){
			File[] dirs = rootDir1.listFiles();
			int dirCount = dirs.length;
			for (int i = 0; i < dirCount; ++i) {
				String name=dirs[i].getName();
				if(name.equals("execution-plan")){
					processFiles(editorList, rootDir1 + "/execution-plan");
				}else if(name.equals("stream")){
					processFiles(editorList, rootDir1 + "/stream");
				}else if(name.equals("receiver")){
					processFiles(editorList, rootDir1 + "/receiver");
				}else if(name.equals("publisher")){
					processFiles(editorList, rootDir1 + "/publisher");
				}
			} 
		}else if(rootDir2.exists()){
			File[] dirs = rootDir2.listFiles();
			int dirCount = dirs.length;
			for (int i = 0; i < dirCount; ++i) {
				String name=dirs[i].getName();
				if(name.equals("executionplans")){
					processFiles(editorList, rootDir2 + "/executionplans");
				}else if(name.equals("eventstreams")){
					processFiles(editorList, rootDir2 + "/eventstreams");
				}else if(name.equals("eventreceivers")){
					processFiles(editorList, rootDir2 + "/eventreceivers");
				}else if(name.equals("eventpublishers")){
					processFiles(editorList, rootDir2 + "/eventpublishers");
				}
			} 
		}else{
			throw new Exception("Please provide a valid directory");
		}
		return editorList;
	}
	
	//select multiple files from project folder after validation of the project artifact
	private static void processFiles(Map<File,String> editorList,
			String dirPath) throws IOException{
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		int fileCount = files.length;
		for (int j = 0; j < fileCount; ++j) {

			FileReader fileReader = new FileReader(files[j]);
			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();
			
			//String originalName = files[j].getName().substring(0, files[j].getName().lastIndexOf('.'));
			String originalName = FilenameUtils.getBaseName(files[j].getAbsolutePath());
					
			String regStream = "\"(name)\"\\s*?:\\s*\"("+originalName+")\"";
			String regExecutionplan = "\\@(Plan:name)\\('("+originalName+")'\\)";
			String regPublisher = "(eventPublisher)\\s*?(name)\\s*=\\s*?\"("+originalName+")\"";
			String regReceiver = "(eventReceiver)\\s*?(name)\\s*=\\s*?\"("+originalName+")\"";
			
			
			Pattern patternStream = Pattern.compile(regStream);
			Pattern patternExecutionplan = Pattern.compile(regExecutionplan);
			Pattern patternPublisher = Pattern.compile(regPublisher);
			Pattern patternReceiver = Pattern.compile(regReceiver);
			
			while (line != null) {

				Matcher matcherStream = patternStream.matcher(line);
				Matcher matcherExecutionplan = patternExecutionplan.matcher(line);
				Matcher matcherPublisher = patternPublisher.matcher(line);	
				Matcher matcherReceiver = patternReceiver.matcher(line);
				
				if(matcherStream.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,"stream");
					break;
				}else if(matcherExecutionplan.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,"execution-plan");
					break;
				}else if(matcherPublisher.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,"publisher");
					break;
				}else if(matcherReceiver.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,"receiver");
					break;
				}

				line = reader.readLine();
			}
			fileReader.close();
			reader.close();
		}	
	}
	
	/*
	private static void processXmlFiles(List<OMElement> editorList,
			String dirPath, CEPEntryType type) throws XMLStreamException,
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
	}*/
	
	public static void createCEPArtifacts(Map<File,String> selectedFilesList,IProject project,File pomfile,Map<File,String> fileList,
	     String groupId) throws FactoryConfigurationError, Exception {
			
		if (!selectedFilesList.isEmpty()) {
		    for (File file : selectedFilesList.keySet()) {
		    	
		    	//cepProjectModel.setName(qName);
				String commonCEPPath = "src" + File.separator + "main"
						+ File.separator;
				
				String localName = selectedFilesList.get(file);
				String qName = FilenameUtils.getBaseName(file.getAbsolutePath());
				String fileContents = null;
				
				FileInputStream inputStream = new FileInputStream(file);
				try {
				    	fileContents = IOUtils.toString(inputStream);
				} finally {
				    inputStream.close();
				}
				
				if (localName.equalsIgnoreCase("stream")) {
					File baseDir = project
							.getFolder(commonCEPPath + "stream")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".json");
					FileUtils.createFile(destFile, fileContents);
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-cep-stream-plugin",
							MavenConstants.WSO2_CEP_STREAM_VERSION,
							"stream");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					
					// Fixing TOOLS-1981.
					if (qName != null && qName.equalsIgnoreCase("main")) {
						fileList.put(destFile, "main_stream");
					} else {
						fileList.put(destFile, "stream");
					}
					createArtifactMetaDataEntry(qName, "event/stream",
							baseDir, groupId + ".stream",project,".json");
				} else if (localName.equalsIgnoreCase("publisher")) {
					File baseDir = project
							.getFolder(commonCEPPath + "publisher")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, fileContents);
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-publisher-plugin",
							MavenConstants.WSO2_CEP_PUBLISHER_VERSION,
							"publisher");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "publisher");
					createArtifactMetaDataEntry(qName, "event/publisher",
							baseDir, groupId + ".publisher",project,".xml");
				} else if (localName.equalsIgnoreCase("receiver")) {
					File baseDir = project
							.getFolder(commonCEPPath + "receiver")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".xml");
					FileUtils.createFile(destFile, fileContents);
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-reciever-plugin",
							MavenConstants.WSO2_CEP_RECIEVER_VERSION, "receiver");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "receiver");
					createArtifactMetaDataEntry(qName, "event/receiver",
							baseDir, groupId + ".receiver",project,".xml");
				} else if (localName.equalsIgnoreCase("execution-plan")) {
					File baseDir = project
							.getFolder(commonCEPPath + "execution-plan")
							.getLocation().toFile();
					File destFile = new File(baseDir, qName + ".siddhiql");
					FileUtils.createFile(destFile, fileContents);
					MavenProject mavenProject = MavenUtils
							.getMavenProject(pomfile);
					addPluginEntry(mavenProject, "org.wso2.maven",
							"wso2-esb-execution-plan-plugin",
							MavenConstants.WSO2_CEP_EXECUTIONPLAN_VERSION,
							"execution-plan");
					MavenUtils.saveMavenProject(mavenProject, pomfile);
					fileList.put(destFile, "execution-plan");
					createArtifactMetaDataEntry(qName, "event/execution-plan",
							baseDir, groupId + ".execution-plan",project,".siddhiql");
					
				}      	   	
		    }
	    }
    }

	
	public static void addPluginEntry(MavenProject mavenProject, String groupId, String artifactId, String version, String Id) {
	    List<Plugin> plugins = mavenProject.getBuild().getPlugins();
		for (Plugin plg : plugins) {
			if (plg.getGroupId().equalsIgnoreCase(groupId) && plg.getArtifactId().equalsIgnoreCase(artifactId) && plg.getVersion().equalsIgnoreCase(version) ) {
				return;
			}
		}
		
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, groupId, artifactId, version, true);
		
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId(Id);
		
		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		
		plugin.addExecution(pluginExecution);
		Repository repo = new Repository();
		repo.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
		repo.setId("wso2-nexus");
		
		RepositoryPolicy releasePolicy=new RepositoryPolicy();
		releasePolicy.setEnabled(true);
		releasePolicy.setUpdatePolicy("daily");
		releasePolicy.setChecksumPolicy("ignore");
		
		repo.setReleases(releasePolicy);
		
		if (!mavenProject.getRepositories().contains(repo)) {
	        mavenProject.getModel().addRepository(repo);
	        mavenProject.getModel().addPluginRepository(repo);
        }
    }
	
	public static void createArtifactMetaDataEntry(String name, String type,
			File baseDir, String groupId,IProject project, String extension) throws FactoryConfigurationError,
			Exception {
		CEPProjectArtifact esbProjectArtifact = new CEPProjectArtifact();
		esbProjectArtifact.fromFile(project.getFile("artifact.xml")
				.getLocation().toFile());
		CEPArtifact artifact = new CEPArtifact();
		artifact.setName(name);
		artifact.setVersion("1.0.0");
		artifact.setType(type);
		artifact.setServerRole("ComplexEventProcessor");
		artifact.setGroupId(groupId);
		artifact.setFile(FileUtils.getRelativePath(
				project.getLocation().toFile(),
				new File(baseDir, name + extension)).replaceAll(
				Pattern.quote(File.separator), "/"));
		esbProjectArtifact.addCEPArtifact(artifact);
		esbProjectArtifact.toFile();
	}
	
	public static void updatePom(IProject project) throws Exception {

		File mavenProjectPomLocation = project.getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		addPluginEntry(mavenProject, "org.wso2.maven","wso2-cep-plugin", MavenConstants.WSO2_CEP_VERSION,"cep");
		
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	
	}	
}
