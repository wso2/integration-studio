package org.wso2.developerstudio.eclipse.artifact.bpel.sample;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.samples.contributor.AbstractSampleContributor;
import org.wso2.developerstudio.eclipse.artifact.bpel.utils.BPELImageUtils;
import org.wso2.developerstudio.eclipse.artifact.bpel.utils.BPELTemplateUtils;



public class BPELSampleContributor extends AbstractSampleContributor{
	static String caption="Hello World Workflow";
	static ImageDescriptor image = BPELImageUtils.getInstance().getImageDescriptor("bpel-sample-16x16.png");
	static String tooltip="Create a bpel workflow depicting hello world process";
	static String bpleSampleProjectName = "HelloWorldWorkFlow";
	static ImageDescriptor wizardImage = BPELImageUtils.getInstance().getImageDescriptor("bpel-wizard.png");
	static String resourceRelativePath = "HelloWorld.bpel";
	
	public void addSampleTo(IProject project) throws Exception {
		super.addSampleTo(project);
	}
	
	protected File getSampleResourceFile() throws IOException {
	    return BPELTemplateUtils.getInstance().getResourceFile("samples/HelloWorld.zip");
    }

    public String getCaption() {
	    return caption;
    }

    public ImageDescriptor getImage() {
	    return image;
    }

    public String getToolTip() {
	    return tooltip;
    }

    public boolean isCustomCreateSample() {
	    return false;
    }
    
    public String getProjectName() {
    	return bpleSampleProjectName;
    }

    public ImageDescriptor getWizardPageImage() {
    	return wizardImage;
    }
    
    public String getResourceRelativePath() {
    	return resourceRelativePath;
    }
}
