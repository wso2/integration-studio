package org.wso2.developerstudio.eclipse.artifact.axis2.sample;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.Axis2TemplateUtils;
import org.wso2.developerstudio.eclipse.capp.maven.sample.AbstractMavenSampleContributor;

public class Axis2SampleContributor extends AbstractMavenSampleContributor{
	static String caption="Axis2 Account Service ";
	static ImageDescriptor image=Axis2ImageUtils.getInstance().getImageDescriptor("axis-sample-16x16.png");
	static String tooltip="Create a project containing a axis2 service";
	static String axis2SampleProjectName = "AccountServiceSampleProject";
	static ImageDescriptor wizardImage=Axis2ImageUtils.getInstance().getImageDescriptor("axis2-wizard.png");
	static String resourceRelativePath = "src/main/java/service/AccountService.java"; 
	
	public void addSampleTo(IProject project) throws Exception {
	    super.addSampleTo(project,false);
//	    IFile file = CAppEnvironment.getcAppManager().getCAppArtifactsLocation(project).getFolder("services").getFolder("axis2").getFolder("AccountService").getFile("AccountService.service");
//	    updateWithParameterData(file.getLocation().toFile(), project.getName());
//	    project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	    //Regenarate poms.
//	    generateMavenPOMForSample(project);
        project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}
	
    public String getCaption() {
	    return caption;
    }

	
    public String getToolTip() {
	    return tooltip;
    }

	
    public ImageDescriptor getImage() {
	    return image;
    }

	
    protected File getSampleResourceFile() throws IOException {
    	 return Axis2TemplateUtils.getInstance().getResourceFile("samples/AccountServiceSample.zip");
    }
    
    public String getProjectName() {
    	return axis2SampleProjectName;
    }
    
    public ImageDescriptor getWizardPageImage() {
    	return wizardImage;
    }

	public String getResourceRelativePath() {
		return resourceRelativePath;
	}

}
