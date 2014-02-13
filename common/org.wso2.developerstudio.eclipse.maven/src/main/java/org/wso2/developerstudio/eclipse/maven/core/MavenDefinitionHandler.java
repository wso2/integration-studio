package org.wso2.developerstudio.eclipse.maven.core;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.Activator;
import org.wso2.developerstudio.eclipse.maven.executor.IMavenArchetypeDefinition;
import org.wso2.developerstudio.eclipse.maven.executor.IMavenCustomExecution;
import org.wso2.developerstudio.eclipse.maven.executor.IMavenDependencyDefinition;
import org.wso2.developerstudio.eclipse.maven.executor.IMavenPluginDefinition;
import org.wso2.developerstudio.eclipse.maven.executor.MavenExecuteMode;
import org.wso2.developerstudio.eclipse.maven.internal.executor.impl.MavenArchetypeDefinition;
import org.wso2.developerstudio.eclipse.maven.internal.executor.impl.MavenDependencyDefinitionImpl;
import org.wso2.developerstudio.eclipse.maven.internal.executor.impl.MavenPluginDefinition;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class MavenDefinitionHandler {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private static final String MAVEN_DEFINITION_HANDLER_EXTENSION = "org.wso2.developerstudio.eclipse.maven.definitions";

	private static Map<String, IMavenArchetypeDefinition> archeTypeDefinitions;
	private static Map<String, IMavenPluginDefinition> pluginDefinitions;
	
	static {
		loadMavenDefinitionExtensionPoint();
	}
	
	
	public static Map<String, IMavenArchetypeDefinition> getArcheTypeDefinitions() {
		if (archeTypeDefinitions == null) {
			archeTypeDefinitions = new HashMap<String, IMavenArchetypeDefinition>();
		}
		return archeTypeDefinitions;
	}
	

	public static Map<String, IMavenPluginDefinition> getPluginDefinitions() {
		if (pluginDefinitions==null){
			pluginDefinitions=new HashMap<String, IMavenPluginDefinition>();
		}
		return pluginDefinitions;
	}
	
	private static void loadMavenDefinitionExtensionPoint() {
		getArcheTypeDefinitions().clear();
		getPluginDefinitions().clear();
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						MAVEN_DEFINITION_HANDLER_EXTENSION);
		for (IConfigurationElement e : config) {
			try {
				if (e.getName().equals("archetype")){
					MavenArchetypeDefinition mavenArchetypeDefinition = new MavenArchetypeDefinition(e.getAttribute("groupId"),e.getAttribute("artifactId"), e.getAttribute("version"));
					String id = e.getAttribute("id");
					String name = e.getAttribute("name");
					if (name!=null){
						mavenArchetypeDefinition.setName(name);
					}
					if (e.getAttribute("class")!=null){
						Object classObj = e.createExecutableExtension("class");
						if (classObj!=null){
							mavenArchetypeDefinition.setCustomExecution((IMavenCustomExecution)classObj);
						}
					}
					String executeModeString = e.getAttribute("executeMode").toLowerCase();
					mavenArchetypeDefinition.setExecuteMode(executeModeString.equals("default")? MavenExecuteMode.DEFAULT:executeModeString.equals("online")? MavenExecuteMode.ONLINE:MavenExecuteMode.OFFLINE);
					String archeTypePluginFileName = e.getAttribute("archeTypePluginFile");
					if (archeTypePluginFileName!=null){
						URL pluginResource = ProjectUtils.getPluginResource(e.getContributor().getName(), archeTypePluginFileName);
						mavenArchetypeDefinition.setArcheTypePluginFile(pluginResource);
					}
					List<IMavenDependencyDefinition> dependencies = retreiveDependencies(e);
					mavenArchetypeDefinition.addArchetypeDependency(dependencies.toArray(new IMavenDependencyDefinition[]{}));
					String templatesString = e.getAttribute("templates");
					if (templatesString !=null){
						String[] templates=templatesString.split(";");
						for (String template : templates) {
							String[] templateData = template.split(":");
							String templateId = null;
							String templateName = null;
							if (templateData.length>0){
								templateId=templateData[0];
								if (templateData.length>1){
									templateName=templateData[1];
								} else {
									templateName=templateId;
								}
							}
							if (templateId!=null) {
								mavenArchetypeDefinition.getTemplateList().put(templateId, templateName);
							}
						}
					}
					getArcheTypeDefinitions().put(id, mavenArchetypeDefinition);
				}else if (e.getName().equals("plugin")){
					MavenPluginDefinition mavenPluginDefinition = new MavenPluginDefinition(e.getAttribute("groupId"),e.getAttribute("artifactId"), e.getAttribute("version"));
					String id = e.getAttribute("id");
					if (e.getAttribute("class")!=null){
						Object classObj = e.createExecutableExtension("class");
						if (classObj!=null){
							mavenPluginDefinition.setCustomExecution((IMavenCustomExecution)classObj);
						}
					}
					String executeModeString = e.getAttribute("executeMode").toLowerCase();
					mavenPluginDefinition.setExecuteMode(executeModeString.equals("default")? MavenExecuteMode.DEFAULT:executeModeString.equals("online")? MavenExecuteMode.ONLINE:MavenExecuteMode.OFFLINE);
					List<IMavenDependencyDefinition> dependencies = retreiveDependencies(e);
					mavenPluginDefinition.addPluginDependency(dependencies.toArray(new IMavenDependencyDefinition[]{}));
					
					getPluginDefinitions().put(id, mavenPluginDefinition);
				}
			} catch (Exception ex) {
				log.error("Error loading extension point element: "+e.getName(), ex);
			}
		}
	}
	private static List<IMavenDependencyDefinition> retreiveDependencies(
			IConfigurationElement e) {
		List<IMavenDependencyDefinition> dependencies=new ArrayList<IMavenDependencyDefinition>();
		IConfigurationElement[] dependencyElements = e.getChildren("dependency");
		if (dependencyElements!=null){
			for (IConfigurationElement dependencyElement : dependencyElements) {
				String groupId = dependencyElement.getAttribute("groupId");
				String artifactId = dependencyElement.getAttribute("artifactId");
				String version = dependencyElement.getAttribute("version");
				MavenDependencyDefinitionImpl mavenArchetypeDependency = new MavenDependencyDefinitionImpl(groupId, artifactId, version);
				String dependencyResource = dependencyElement.getAttribute("resource");
				if (dependencyResource!=null){
					mavenArchetypeDependency.setResource(ProjectUtils.getPluginResource(dependencyElement.getContributor().getName(), dependencyResource));
				}
				dependencies.add(mavenArchetypeDependency);
			}
		}
		return dependencies;
	}
}
