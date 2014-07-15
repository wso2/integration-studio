package org.wso2.developerstudio.eclipse.general.project.nature;

import java.io.File;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;

public class GeneralProjectNature extends AbstractWSO2ProjectNature {
	private static final String CAPP_TYPE = "bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar";

	
	public void configure() throws CoreException {
//		IFolder parentFolder = getProject().getFolder("resources");
//		parentFolder.create(true, true, new NullProgressMonitor());
//		getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		updatePom();
	}

	private void updatePom() {
		// TODO update the pom with the relavant packaging types & maven pligins
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
			//Adding typrLidt property
			MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
			//Setting the directory
			mavenProject.getBuild().setDirectory("target/capp");
//			Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);
			
			//Adding maven exec plugin entry
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.codehaus.mojo", "exec-maven-plugin", "1.2", true);
	
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId("install");
				pluginExecution.addGoal("exec");
				pluginExecution.setPhase("install");
	
				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, "executable");
				executableNode.setValue("mvn");
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode, "workingDirectory");
				workingDirectoryNode.setValue("${project.build.directory}");
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, "arguments");
				Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, "argument");
				cleanArgumentNode.setValue("clean");
				Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, "argument");
				installArgumentNode.setValue("install");
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, "argument");
				testSkipArgumentNode.setValue("-Dmaven.test.skip=${maven.test.skip}");
				
				pluginExecution.setConfiguration(configurationNode);
				
				plugin.addExecution(pluginExecution);
			}
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId("deploy");
				pluginExecution.addGoal("exec");
				pluginExecution.setPhase("deploy");
	
				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, "executable");
				executableNode.setValue("mvn");
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode, "workingDirectory");
				workingDirectoryNode.setValue("${project.build.directory}");
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, "arguments");
				Xpp3Dom deployArgumentNode = MavenUtils.createXpp3Node(argumentsNode, "argument");
				deployArgumentNode.setValue("deploy");
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, "argument");
				testSkipArgumentNode.setValue("-Dmaven.test.skip=${maven.test.skip}");
				
				pluginExecution.setConfiguration(configurationNode);
				
				plugin.addExecution(pluginExecution);
			}
			MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
			
		} catch (Exception e) {
			// TODO Handle this properly.
			e.printStackTrace();
		}
		
		try {
			getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Handle this properly.
			e.printStackTrace();
		}

	}

	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}
}
