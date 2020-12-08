package org.wso2.developerstudio.eclipse.maven.executor;

import java.io.File;
import java.util.List;

import org.wso2.developerstudio.eclipse.maven.types.MavenArcheType;
import org.wso2.developerstudio.eclipse.maven.types.MavenProjectType;

public interface IMavenExecutor {

	public boolean executeMavenGoal(File projectPath, List<String> goals,
			boolean isOffline);

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
	 * @throws Exception
	 */
	public boolean createArcheType(boolean isOffline, boolean isBatchMode,
			MavenArcheType archeTypeParameter,
			MavenProjectType generatedProjectParameter, File location)
			throws Exception;

	public boolean createArcheType(boolean isOffline, boolean isBatchMode,
			MavenArcheType archeTypeParameter,
			MavenProjectType generatedProjectParameter, File location,
			File parentPomLocation) throws Exception;

	public boolean createArcheType(String archetypeId,
			MavenProjectType generatedProjectParameter, File location)
			throws Exception;

	public boolean createArcheType(String archetypeId,
			MavenProjectType generatedProjectParameter, File location,
			File parentPomLocation) throws Exception;

	public boolean createEclipseIDESettings(String archetypeId,
			File mavenProjectLocation) throws Exception;

	public boolean setMavenParent(File mavenProjectLocation,
			MavenProjectType parentMavenProject) throws Exception;
	
	public boolean setMavenParent(File mavenProjectLocation,
			File parentMavenProjectLocation) throws Exception;
	
	public boolean removeMavenParent(File mavenProjectLocation) throws Exception;
	
	public IMavenArchetypeDefinition getMavenArcheTypeDefinition(String archeTypeId);
}