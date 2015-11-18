package org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util;


import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.Activator;

public class PluginImageUtils extends ImageUtils{

	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new PluginImageUtils();
		}
		return instance;
	}
	
	public Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}
}
