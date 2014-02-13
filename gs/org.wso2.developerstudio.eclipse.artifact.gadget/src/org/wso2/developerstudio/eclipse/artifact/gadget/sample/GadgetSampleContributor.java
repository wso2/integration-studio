package org.wso2.developerstudio.eclipse.artifact.gadget.sample;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.artifact.gadget.utils.GadgetImageUtils;
import org.wso2.developerstudio.eclipse.artifact.gadget.utils.GadgetTemplateUtils;
import org.wso2.developerstudio.eclipse.samples.contributor.AbstractSampleContributor;

public class GadgetSampleContributor extends AbstractSampleContributor{

	static String caption="Acme Product Gadget";
	static ImageDescriptor image=GadgetImageUtils.getInstance().getImageDescriptor("gadget-sample-16x16.png");
	static String tooltip="Create gadgets for viewing product details in Acme Company";
	static String gadgetSampleProject = "AcmeProductGadgetProject";
	static ImageDescriptor wizardImage = GadgetImageUtils.getInstance().getImageDescriptor("Gadget-wizard.png");
	static String resourceRelativePath = "gadget-resources/ProductsChart.xml";
	
	public void addSampleTo(IProject project) throws Exception {
		super.addSampleTo(project);
	}
	
	protected File getSampleResourceFile() throws IOException {
	    return GadgetTemplateUtils.getInstance().getResourceFile("samples/AcmeProductGadget.zip");
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
    	return gadgetSampleProject;
    }
    
    public ImageDescriptor getWizardPageImage() {
    	return wizardImage;
    }
    
	public String getResourceRelativePath() {
		return resourceRelativePath;
	}
}
