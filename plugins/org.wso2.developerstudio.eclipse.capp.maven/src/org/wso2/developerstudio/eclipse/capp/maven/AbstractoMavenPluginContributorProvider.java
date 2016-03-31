package org.wso2.developerstudio.eclipse.capp.maven;

import java.util.List;
import java.util.Map;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public abstract class AbstractoMavenPluginContributorProvider implements
		IMavenPluginContributorProvider {

	private static final String EMPTY_STRING = "";
	private static final String ARTIFACT_TYPES = "artifact.types";
	private static final String TYPE_LIST = "typeList";
	private static final String GROUP_ID = "groupId";
	private static final String ORG_APACHE_MAVEN_PLUGINS = "org.apache.maven.plugins";
	private static final String CONFIGURATION = "configuration";
	
	public boolean addMavenPlugin(MavenProject mavenProject,
			IProject eclipseProject, Map<String, String> artifactTypeExtensionMap) {
	
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, getPluginGroupID(), getPluginArtifactID(), getPluginVersion(), false);
		PluginExecution pluginExecution = new PluginExecution();
		plugin.getExecutions().add(pluginExecution);
		pluginExecution.setPhase(getPluginExecutionPhase());
		pluginExecution.addGoal(getGoal());
		Xpp3Dom config = MavenUtils.createXpp3Node(CONFIGURATION);
		pluginExecution.setConfiguration(config);
		addConfigurations(mavenProject,eclipseProject,config);
		addTypeList(mavenProject, artifactTypeExtensionMap, config);
		return true;
	}

	public boolean updateMavenPlugin(MavenProject mavenProject, IProject eclipseProject, Map<String,String> artifactTypeExtensionMap){
		List<Plugin> plugins = mavenProject.getModel().getBuild().getPlugins();
		for (Plugin plugin : plugins) {
			String groupId = plugin.getGroupId();
			if (groupId == null ){
				groupId = ORG_APACHE_MAVEN_PLUGINS;
			}
			if (groupId.equals(getPluginGroupID()) && plugin.getArtifactId().equals(getPluginArtifactID())){
				return updateMavenPlugin(plugin, mavenProject, eclipseProject, artifactTypeExtensionMap);
			}
		}
		return true;
	}
	
	protected void addGroupId(MavenProject mavenProject, Xpp3Dom config) {
		Xpp3Dom groupIDNode = MavenUtils.createXpp3Node(config, GROUP_ID);
		groupIDNode.setValue(mavenProject.getGroupId());
	}

	protected void addTypeList(MavenProject mavenProject, Map<String, String> artifactTypeExtensionMap,
			Xpp3Dom config) {
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(config, TYPE_LIST);
		StringBuffer sb=new StringBuffer();
		for (String artifactType : artifactTypeExtensionMap.keySet()) {
			if (artifactType!=null && !artifactType.trim().equals(EMPTY_STRING)) {
				if (EMPTY_STRING.equalsIgnoreCase(sb.toString())) {
					sb.append(artifactType).append("=").append(artifactTypeExtensionMap.get(artifactType));
				} else {
					sb.append(",").append(artifactType).append("=").append(artifactTypeExtensionMap.get(artifactType));
				}
			}
		}
		String artifactTypesVariable = ARTIFACT_TYPES;
		if (!mavenProject.getProperties().containsKey(artifactTypesVariable)){
			mavenProject.getProperties().put(artifactTypesVariable, sb.toString());
		}
		typeListNode.setValue("${"+artifactTypesVariable+"}");
		
	}

	protected abstract boolean updateMavenPlugin(Plugin plugin, MavenProject mavenProject,IProject eclipseProject, Map<String, String> artifactTypeExtensionMap);
	protected abstract void addConfigurations(MavenProject mavenProject, IProject eclipseProject, Xpp3Dom config);
	protected abstract String getPluginGroupID();
	protected abstract String getPluginArtifactID();
	protected abstract String getPluginVersion();
	protected abstract String getPluginExecutionPhase();
	protected abstract String getGoal();
}
