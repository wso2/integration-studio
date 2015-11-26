/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.utils;

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
import org.wso2.developerstudio.eclipse.artifact.analytics.Activator;
import org.wso2.developerstudio.eclipse.artifact.analytics.ui.wizard.AnalyticsProjectCreationWizard;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsArtifactModel;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectArtifactCreator;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class AnalyticsProjectUtils {

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private final static String ADDITIONAL_FOLDERS =File.separator+"repository"+
			File.separator+"deployment"+File.separator+"server";
	private final static String PROJECT_PATH = "src" + File.separator + "main" + File.separator;

	public static IProject createAnalyticsProject(Shell shell,File location){
		IWizardDescriptor wizardDesc = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard("org.wso2.developerstudio.eclipse.artifact.newAnalyticsProject");
		if (wizardDesc!=null) {
			try {
				IProject analyticsProject = null;
				AnalyticsProjectCreationWizard analyticsProjectWizard = (AnalyticsProjectCreationWizard) wizardDesc.createWizard();
				IStructuredSelection selection = (IStructuredSelection) PlatformUI
												.getWorkbench().getActiveWorkbenchWindow()
												.getSelectionService().getSelection();
				analyticsProjectWizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, analyticsProjectWizard);
				analyticsProjectWizard.getModel().setLocation(location);
				dialog.create();
				if(dialog.open() == Dialog.OK){
					String analyticsProjectName = analyticsProjectWizard.getAnalyticsProjectModel().getAnalyticsProjectName();
					analyticsProject = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(analyticsProjectName);
				}
				return analyticsProject;
			} catch (CoreException e) {
				log.error("CoreException has occurred",e);
			}
		}
		return null;
	}


	public static boolean artifactExists(IProject project, String artifactName) throws Exception {
		AnalyticsProjectArtifactCreator analyticsProjectArtifact = new AnalyticsProjectArtifactCreator();
		analyticsProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
		List<AnalyticsArtifactModel> allArtifacts = analyticsProjectArtifact.getAllAnalyticsArtifacts();
		for (AnalyticsArtifactModel artifact : allArtifacts) {
			if (artifactName.equalsIgnoreCase(artifact.getName()))
				return true;
		}
		return false;
	}

	public static Map<File,AnalyticsEntryTypes> deploymentServerContentProcessing(
			String deploymentServerFolderPath) throws IOException,Exception {

		Map<File,AnalyticsEntryTypes> editorList = new HashMap<File,AnalyticsEntryTypes>();

		File rootDir = new File(deploymentServerFolderPath);

		if(rootDir.exists() && rootDir.getPath().endsWith(ADDITIONAL_FOLDERS)){
			File[] dirs = rootDir.listFiles();
			int dirCount = dirs.length;
			for (int i = 0; i < dirCount; ++i) {
				String name=dirs[i].getName();
				if(name.equals(AnalyticsConstants.DEPLOYMENT_SERVER_EXECUTION_PLAN_DIR)){
					processFiles(editorList, rootDir + File.separator+AnalyticsConstants.DEPLOYMENT_SERVER_EXECUTION_PLAN_DIR);
				}else if(name.equals(AnalyticsConstants.DEPLOYMENT_SERVER_PUBLISHER_DIR)){
					processFiles(editorList, rootDir + File.separator+AnalyticsConstants.DEPLOYMENT_SERVER_PUBLISHER_DIR);
				}else if(name.equals(AnalyticsConstants.DEPLOYMENT_SERVER_RECEIVER_DIR)){
					processFiles(editorList, rootDir + File.separator+AnalyticsConstants.DEPLOYMENT_SERVER_RECEIVER_DIR);
				}else if(name.equals(AnalyticsConstants.DEPLOYMENT_SERVER_STREAM_DIR)){
					processFiles(editorList, rootDir + File.separator+AnalyticsConstants.DEPLOYMENT_SERVER_STREAM_DIR);
				}
			}
		}else{
			throw new Exception("Please provide a valid directory");
		}
		return editorList;
	}

	//select multiple files from project folder after validation of the project artifact
	private static void processFiles(Map<File,AnalyticsEntryTypes> editorList,
			String dirPath) throws IOException{
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		int fileCount = files.length;
		for (int j = 0; j < fileCount; ++j) {

			FileReader fileReader = new FileReader(files[j]);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();

			//artifact name extract from file name.
			String originalName = extractArtifactFileName(files[j]);

			//These patterns check file name with file content name.
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
					editorList.put(selectedFile,AnalyticsEntryTypes.STREAM);
					break;
				}else if(matcherExecutionplan.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,AnalyticsEntryTypes.EXECUTIONPLAN);
					break;
				}else if(matcherPublisher.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,AnalyticsEntryTypes.PUBLISHER);
					break;
				}else if(matcherReceiver.find()){
					File selectedFile = files[j];
					editorList.put(selectedFile,AnalyticsEntryTypes.RECEIVER);
					break;
				}

				line = reader.readLine();
			}
			fileReader.close();
			reader.close();
		}
	}

	//artifact name extract from file name, if include any version part remove it. streamName_1.0.0.json -> streamName.json
	private static String extractArtifactFileName(File file){
		String extention = FilenameUtils.getExtension((file.getAbsolutePath()));
		String fileName = FilenameUtils.getBaseName(file.getAbsolutePath());
		if(extention.equals(AnalyticsConstants.EXTENTION_STREAM)){
			Pattern pattern = Pattern.compile("(.*)_([0-9]\\.[0-9]\\.[0-9])");
			Matcher matcher = pattern.matcher(fileName);
			if (matcher.find()) {
				fileName = matcher.group(1);
			}
		}
		return fileName;
	}

	public static void createAnalyticsArtifacts(Map<File,AnalyticsEntryTypes> selectedFilesList,IProject project,File pomfile,
			Map<File,AnalyticsEntryTypes> fileList,String groupId) throws FactoryConfigurationError, Exception {

		if (!selectedFilesList.isEmpty()) {
		    for (File file : selectedFilesList.keySet()) {
				String dirName =null;
				switch (selectedFilesList.get(file)) {

		            case STREAM:
		            	dirName = AnalyticsConstants.ANALYTICS_STREAM_DIR;
		                artifactGenerator(file ,project,pomfile,fileList,dirName,groupId,"analytics-stream-maven-plugin", AnalyticsMavenConstants.WSO2_ANALYTICS_STREAM_VERSION,
		                		dirName,AnalyticsConstants.EXTENTION_STREAM, AnalyticsEntryTypes.STREAM );
		                break;

		            case PUBLISHER:
		            	dirName = AnalyticsConstants.ANALYTICS_PUBLISHER_DIR;
		                artifactGenerator(file ,project,pomfile,fileList,dirName,groupId,"analytics-publisher-maven-plugin", AnalyticsMavenConstants.WSO2_ANALYTICS_PUBLISHER_VERSION,
		                		dirName,AnalyticsConstants.EXTENTION_PUBLISHER, AnalyticsEntryTypes.PUBLISHER );
		                break;

		            case RECEIVER:
		            	dirName = AnalyticsConstants.ANALYTICS_RECEIVER_DIR;
		                artifactGenerator(file ,project,pomfile,fileList,dirName,groupId,"analytics-receiver-maven-plugin", AnalyticsMavenConstants.WSO2_ANALYTICS_RECEIVER_VERSION,
		                		dirName,AnalyticsConstants.EXTENTION_RECEIVER, AnalyticsEntryTypes.RECEIVER );
		                break;

		            case EXECUTIONPLAN:
		            	dirName = AnalyticsConstants.ANALYTICS_EXECUTION_PLAN_DIR;
		                artifactGenerator(file ,project,pomfile,fileList,dirName,groupId,"analytics-execution-plan-maven-plugin", AnalyticsMavenConstants.WSO2_ANALYTICS_EXECUTIONPLAN_VERSION,
		                		dirName,AnalyticsConstants.EXTENTION_EXECUTION_PLAN, AnalyticsEntryTypes.EXECUTIONPLAN);
		                break;

				}
		    }
	    }
    }

	private static void artifactGenerator(File file , IProject project, File pomfile,Map<File,AnalyticsEntryTypes> fileList,
			String dirName, String groupId,String artifactId,String version,String id, String extention, AnalyticsEntryTypes entryType )throws FactoryConfigurationError, Exception{

		String fileContents = null;
		FileInputStream inputStream = new FileInputStream(file);
		try {
		    fileContents = IOUtils.toString(inputStream);
		} finally {
		    inputStream.close();
		}
		//artifact name extract from file name.
		String artifactName = extractArtifactFileName(file);
		File baseDir = project.getFolder(PROJECT_PATH + dirName).getLocation().toFile();
    	File destFile = new File(baseDir, artifactName + "." + extention);
    	FileUtils.createFile(destFile, fileContents);
    	MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
    	addPluginEntry(mavenProject,"org.wso2.maven",artifactId,version,id);
    	MavenUtils.saveMavenProject(mavenProject, pomfile);
    	fileList.put(destFile, entryType);
    	createArtifactMetaDataEntry(artifactName,version,"event/"+id,baseDir, groupId + "." +id,project,"." + extention);
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

	public static void createArtifactMetaDataEntry(String name,String version, String type,
			File baseDir, String groupId,IProject project, String extension) throws FactoryConfigurationError,
			Exception {
		AnalyticsProjectArtifactCreator analyticsProjectArtifact = new AnalyticsProjectArtifactCreator();
		analyticsProjectArtifact.fromFile(project.getFile("artifact.xml")
				.getLocation().toFile());
		AnalyticsArtifactModel artifact = new AnalyticsArtifactModel();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(type);
		artifact.setServerRole(AnalyticsConstants.ANALYTICS_SERVER_NAME);
		artifact.setGroupId(groupId);
		artifact.setFile(FileUtils.getRelativePath(
				project.getLocation().toFile(),
				new File(baseDir, name + extension)).replaceAll(
				Pattern.quote(File.separator), "/"));
		analyticsProjectArtifact.addAnalyticsArtifact(artifact);
		analyticsProjectArtifact.toFile();
	}
}
