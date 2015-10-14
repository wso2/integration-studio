/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.maven.internal.executor.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Parent;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.Activator;
import org.wso2.developerstudio.eclipse.maven.core.MavenDefinitionHandler;
import org.wso2.developerstudio.eclipse.maven.executor.IMavenArchetypeDefinition;
import org.wso2.developerstudio.eclipse.maven.executor.IMavenExecutor;
import org.wso2.developerstudio.eclipse.maven.executor.MavenEnv;
import org.wso2.developerstudio.eclipse.maven.types.MavenArcheType;
import org.wso2.developerstudio.eclipse.maven.types.MavenProjectType;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * This class is intended to execute maven tasks programmatically. This class
 * can be used to run maven goals against a maven managed project and this can
 * be used to create new Java projects using the maven archetypes.
 * 
 * @since 1.1.0
 * 
 */
public final class MavenExecutorImpl implements IMavenExecutor {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static final String ENABLE_BATCH_MODE = "-B";

	private static final String ARCHETYPE_GENERATE_GOAL = "archetype:generate";

	private static final String PACKAGE = "-Dpackage=";

	private static final String VERSION = "-Dversion=";

	private static final String ARTIFACT_ID = "-DartifactId=";

	private static final String GROUP_ID = "-DgroupId=";

	private static final String ARCHETYPE_VERSION = "-DarchetypeVersion=";

	private static final String ARCHETYPE_ARTIFACT_ID = "-DarchetypeArtifactId=";

	private static final String SINGLE_SPACE = " ";

	private static final String ARCHETYPE_GROUP_ID = "-DarchetypeGroupId=";

	private static final String POM_FILE_NAME = "pom.xml";
	public static final String POM_XML = POM_FILE_NAME;
	private static final String INSTALL_GOAL = "install";
	private static final String CLEAN_GOAL = "clean";
	
	private static MavenExecutorImpl instance;
	
	private MavenExecutorImpl() {
	}

	public static MavenExecutorImpl getInstance(){
		if (instance==null){
			instance=new MavenExecutorImpl();
		}
		return instance;
	}
	
	public boolean executeMavenGoal(File projectPath, List<String> goals,
			boolean isOffline) {
		InvocationRequest request = new DefaultInvocationRequest();

		if (!projectPath.exists()) {
			projectPath.mkdirs();
		}

		request.setPomFile(new File(projectPath, POM_XML));

		if (goals == null) {
			goals = getDefaultMavenGoals();
		}
		request.setGoals(goals);
		Invoker invoker = new DefaultInvoker();
		request.setOffline(isOffline);

		try {
			InvocationResult result = invoker.execute(request);
			if (result.getExecutionException() == null) {
				if (result.getExitCode() != 0) {
					request.setOffline(!isOffline);
					result = invoker.execute(request);
					if (result.getExitCode() == 0) {
						return true;
					} else {
						final String errorMessage = "No maven Project found at "
								+ projectPath;
						log.error(errorMessage);
						throw new MavenInvocationException(errorMessage);
					}
				}
				return true;
			}
		} catch (MavenInvocationException e) {
			log.error("Maven invocation failed", e);
		}
		return false;
	}

	public static List<String> getDefaultMavenGoals() {
		List<String> goalsList = new ArrayList<String>();
		goalsList.add(CLEAN_GOAL);
		goalsList.add(INSTALL_GOAL);
		return goalsList;
	}

	/**
	 * This method is used to create a new project using a given maven
	 * archetype.
	 * 
	 * @param isOffline
	 *            Whether the project creation to be run in the online/offline
	 *            mode.
	 * @param isBatchMode
	 *            Whether the project creation to be run in Batch mode.
	 * @param archeTypeParameter
	 *            This object contains the maven archetype related parameters to
	 *            such as groupId, etc.
	 * @param generatedProjectParameter
	 *            This object contains the parameter related to the newly
	 *            creating project including project name, groupId, etc.
	 * @return Returns true if the project generation is successful. False
	 *         otherwise.
	 * @throws IOException 
	 */
	public boolean createArcheType(boolean isOffline, boolean isBatchMode,
			MavenArcheType archeTypeParameter,
			MavenProjectType generatedProjectParameter, File location, File parentPomLocation) throws Exception {
		File tempDir = FileUtils.createTempDirectory();
		List<String> goals = new ArrayList<String>();
		goals.add(prepareMavenArcheTypeRequest(isBatchMode, archeTypeParameter,
				generatedProjectParameter));
		boolean executeMavenGoal = executeMavenGoal(tempDir, goals, isOffline);
		if (executeMavenGoal){
			FileUtils.copyDirectoryContents(new File(tempDir,generatedProjectParameter.getArtifactId()), location);
			if (parentPomLocation!=null){
				setMavenParent(location,parentPomLocation.getParentFile());
			}
		}
		return executeMavenGoal;
	}

	public boolean createArcheType(String archetypeId,
			MavenProjectType generatedProjectParameter, File location, File parentPomLocation)
			throws Exception {
		Map<String, IMavenArchetypeDefinition> archeTypeDefinitions = MavenDefinitionHandler.getArcheTypeDefinitions();
		if (archeTypeDefinitions.containsKey(archetypeId)) {
			IMavenArchetypeDefinition definition = archeTypeDefinitions
					.get(archetypeId);
			// TODO do custom executions
			// TODO setup maven artifacts in repo
			return createArcheType(MavenEnv
					.isMavenExecutionModeOffline(definition.getExecuteMode()),
					true,
					new MavenArcheType(definition.getGroupId(), definition
							.getArtifactId(), definition.getVersion()),
					generatedProjectParameter, location, parentPomLocation);
		} else {
			return false;
		}
	}

	/**
	 * This method creates the maven request for the project generation.
	 * 
	 * @param archeTypeParameter
	 * @param generatedProjectParameter
	 * @return
	 */
	private String prepareMavenArcheTypeRequest(boolean isBatchMode,
			MavenArcheType archeTypeParameter,
			MavenProjectType generatedProjectParameter) {
		StringBuilder builder = new StringBuilder();

		// Maven Goal specification
		builder.append(ARCHETYPE_GENERATE_GOAL).append(SINGLE_SPACE);

		// Enabling/Disabling batch mode
		if (isBatchMode) {
			builder.append(ENABLE_BATCH_MODE).append(SINGLE_SPACE);
		}

		// Adding Archetype info
		builder.append(ARCHETYPE_GROUP_ID).append(
				archeTypeParameter.getGroupId()).append(SINGLE_SPACE);
		builder.append(ARCHETYPE_ARTIFACT_ID).append(
				archeTypeParameter.getArtifactId()).append(SINGLE_SPACE);
		builder.append(ARCHETYPE_VERSION).append(
				archeTypeParameter.getVersion()).append(SINGLE_SPACE);

		// Adding project info
		builder.append(GROUP_ID).append(generatedProjectParameter.getGroupId())
				.append(SINGLE_SPACE);
		builder.append(ARTIFACT_ID).append(
				generatedProjectParameter.getArtifactId()).append(SINGLE_SPACE);
		builder.append(VERSION).append(generatedProjectParameter.getVersion())
				.append(SINGLE_SPACE);
		builder.append(PACKAGE).append(
				generatedProjectParameter.getPackageName())
				.append(SINGLE_SPACE);

		return builder.toString();
	}


	public boolean createEclipseIDESettings(String archetypeId,
			File mavenProjectLocation) throws Exception {
		Map<String, IMavenArchetypeDefinition> archeTypeDefinitions = MavenDefinitionHandler.getArcheTypeDefinitions();
		if (archeTypeDefinitions.containsKey(archetypeId)) {
			IMavenArchetypeDefinition definition = archeTypeDefinitions
					.get(archetypeId);
			// TODO add IDE properties list also
			return executeMavenGoal(mavenProjectLocation, Arrays
					.asList(new String[] { definition.getEclipseIDEGoal() }),
					MavenEnv.isMavenExecutionModeOffline(definition
							.getExecuteMode()));
		}
		return false;
	}

	public boolean createArcheType(boolean isOffline, boolean isBatchMode,
			MavenArcheType archeTypeParameter,
			MavenProjectType generatedProjectParameter, File location)
			throws Exception {
		return createArcheType(isOffline, isBatchMode, archeTypeParameter, generatedProjectParameter, location, null);
	}

	public boolean createArcheType(String archetypeId,
			MavenProjectType generatedProjectParameter, File location)
			throws Exception {
		return createArcheType(archetypeId, generatedProjectParameter, location, null);
	}

	public boolean setMavenParent(File mavenProjectLocation,
			MavenProjectType parentMavenProject) throws Exception {
		File childPomFile = new File(mavenProjectLocation,"pom.xml");
		MavenProject childMavenProject = MavenUtils.getMavenProject(childPomFile);
		Parent parent=null;
		if (parentMavenProject!=null){
			parent=new Parent();
			parent.setGroupId(parentMavenProject.getGroupId());
			parent.setArtifactId(parentMavenProject.getArtifactId());
			parent.setVersion(parentMavenProject.getVersion());
			if (parentMavenProject.getRelativePath()!=null){
				parent.setRelativePath(parentMavenProject.getRelativePath());
			}
		}
		childMavenProject.getModel().setParent(parent);
		MavenUtils.saveMavenProject(childMavenProject, childPomFile);
		return true;
	}

	public boolean setMavenParent(File mavenProjectLocation,
			File parentMavenProjectLocation) throws Exception {
		if (parentMavenProjectLocation==null){
			setMavenParent(mavenProjectLocation, (MavenProjectType)null);
		}else{
			File parentProjectPomFile = new File(parentMavenProjectLocation,"pom.xml");
			MavenProject parentProject = MavenUtils.getMavenProject(parentProjectPomFile);
			String relativeLocation = FileUtils.getRelativePath(parentMavenProjectLocation,mavenProjectLocation);
			if (!parentProject.getModules().contains(relativeLocation)){
				parentProject.getModules().add(relativeLocation);
			}
			MavenUtils.saveMavenProject(parentProject, parentProjectPomFile);
			MavenProjectType parentMavenProject=new MavenProjectType(parentProject.getGroupId(),parentProject.getArtifactId(),parentProject.getVersion());
			String relativePath = FileUtils.getRelativePath(mavenProjectLocation, parentProjectPomFile).replace('\\', '/');
			parentMavenProject.setRelativePath(relativePath);
			setMavenParent(mavenProjectLocation, parentMavenProject);
		}
		return true;
	}

	public boolean removeMavenParent(File mavenProjectLocation)
			throws Exception {
		return setMavenParent(mavenProjectLocation, (MavenProjectType)null);
	}

	public IMavenArchetypeDefinition getMavenArcheTypeDefinition(
			String archeTypeId) {
		return MavenDefinitionHandler.getArcheTypeDefinitions().get(archeTypeId);
	}
}
