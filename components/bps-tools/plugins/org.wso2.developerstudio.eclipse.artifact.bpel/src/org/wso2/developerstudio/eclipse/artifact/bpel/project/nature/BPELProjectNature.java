package org.wso2.developerstudio.eclipse.artifact.bpel.project.nature;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaModelException;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;

public class BPELProjectNature extends AbstractWSO2ProjectNature{
	
//	private IProject selectedProject;
	
	
	public void configure() throws CoreException, JavaModelException {
		try {
			updatePom();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub
		
	}

//	
//	public IProject getProject() {
//		return selectedProject;
//	}
//
//	
//	public void setProject(IProject project) {
//		this.selectedProject = project;
//	}
	
	public void updatePom() throws Exception{
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		MavenUtils.updateMavenProjectWithBpelBuilderPlugin(getProject(), mavenProject, mavenProjectPomLocation);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}
	


}
