package org.wso2.integrationstudio.artifact.bpel.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.utils.template.TemplateUtil;

public class BPELTemplateUtils extends TemplateUtil{

	private static BPELTemplateUtils instance;
	protected Bundle getBundle() {
		return Platform.getBundle(org.wso2.integrationstudio.artifact.bpel.Activator.PLUGIN_ID);
	}
	
	public static BPELTemplateUtils getInstance(){
		if (instance==null){
			instance=new BPELTemplateUtils();
		}
		return instance;
	}

}
