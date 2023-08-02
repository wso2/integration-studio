package org.wso2.integrationstudio.general.project.nature;

import java.io.File;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.nature.AbstractWSO2ProjectNature;

public class GeneralProjectNature extends AbstractWSO2ProjectNature {
	private static final String CAPP_TYPE = "bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,event/stream=json,event/publisher=xml,event/receiver=xml,event/execution-plan=siddhiql,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar,synapse/metadata=yaml";

	
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
//			Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);

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
