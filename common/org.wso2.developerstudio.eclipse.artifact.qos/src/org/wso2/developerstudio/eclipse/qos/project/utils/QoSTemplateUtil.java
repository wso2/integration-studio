package org.wso2.developerstudio.eclipse.qos.project.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import org.wso2.developerstudio.eclipse.qos.Activator;
import org.wso2.developerstudio.eclipse.utils.template.TemplateUtil;

public class QoSTemplateUtil extends TemplateUtil {
private static QoSTemplateUtil instance;
	
	protected Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}
	
	public static QoSTemplateUtil getInstance(){
		if (instance==null){
			instance=new QoSTemplateUtil();
		}
		return instance;
	}
}
