package org.wso2.developerstudio.eclipse.artifact.ds.validator.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.Activator;
import org.wso2.developerstudio.eclipse.utils.template.TemplateUtil;

public class DSValidatorTemplateUtils extends TemplateUtil{

	private static DSValidatorTemplateUtils instance;
	protected Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}
	public static DSValidatorTemplateUtils getInstance(){
		if (instance==null){
			instance=new DSValidatorTemplateUtils();
		}
		return instance;
	}

}
