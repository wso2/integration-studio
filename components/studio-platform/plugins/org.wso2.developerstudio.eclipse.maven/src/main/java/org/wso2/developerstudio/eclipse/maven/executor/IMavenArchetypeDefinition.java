package org.wso2.developerstudio.eclipse.maven.executor;

import java.net.URL;
import java.util.Map;

/**
 * API for defining archetypes support
 * @author saminda
 *
 */
public interface IMavenArchetypeDefinition extends IMavenDefiniton{
	
	public String getArcheTypeCreateGoal();
	public Map<String,String> getArcheTypeCreateProperties();

	public String getEclipseIDEGoal();
	public Map<String,String> getEclipseIDEProperties();
	
	public URL getArchetypePlugin();
	
	public IMavenCustomExecution getCustomExecution();
	
	public IMavenDependencyDefinition[] getArcheTypeDependencies();
	
	public Map<String, String> getTemplateList();
	
	public String getName();
	
}
