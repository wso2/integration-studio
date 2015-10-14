package org.wso2.developerstudio.eclipse.maven.executor;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 * API for defining archetypes support
 * @author saminda
 *
 */
public interface IMavenPluginDefinition extends IMavenDefiniton {
	
	public String[] getGoals();

	public URL getPlugin() throws FileNotFoundException;
	
	public IMavenCustomExecution getCustomExecution();
	
	public IMavenDependencyDefinition[] getPluginDependencies();

}
