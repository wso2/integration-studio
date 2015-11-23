/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.proxyservice.sample;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.ProxyServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.proxyservice.utils.ProxyServiceTemplateUtils;
import org.wso2.developerstudio.eclipse.samples.contributor.AbstractSampleContributor;

public class ProxyServiceSampleContributor extends AbstractSampleContributor{
	static String caption="Stock Quote Proxy Service";
	static ImageDescriptor image=ProxyServiceImageUtils.getInstance().getImageDescriptor("proxy-sample-16x16.png");
	static String tooltip="Create a carbon application project containing a proxy service artifact";
	static String proxySampleProject = "SimpleStockQuoteSample";
	static ImageDescriptor wizardImage = ProxyServiceImageUtils.getInstance().getImageDescriptor("proxy-service-wizard.png");
	static String resourceRelativePath = "src/main/synapse-config/proxy-services/StockQuoteProxy.xml";
	
	public void addSampleTo(IProject project) throws Exception {
		super.addSampleTo(project);
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
	      return ProxyServiceTemplateUtils.getInstance().getResourceFile("samples/SimpleStockQuoteESBSample.zip");
    }
    
    public String getProjectName() {
    	return proxySampleProject;
    }

    public ImageDescriptor getWizardPageImage() {
    	return wizardImage;
    }
    
    public String getResourceRelativePath() {
		return resourceRelativePath;
	}
}
