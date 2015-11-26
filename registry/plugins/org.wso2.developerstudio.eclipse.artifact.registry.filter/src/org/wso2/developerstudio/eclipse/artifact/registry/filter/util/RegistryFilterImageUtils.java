package org.wso2.developerstudio.eclipse.artifact.registry.filter.util;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.registry.filter.Activator;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;

public class RegistryFilterImageUtils extends ImageUtils{
	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new RegistryFilterImageUtils();
		}
		return instance;
	} 

	public Bundle getBundle(){
		return Platform.getBundle(Activator.PLUGIN_ID);
	}
}
