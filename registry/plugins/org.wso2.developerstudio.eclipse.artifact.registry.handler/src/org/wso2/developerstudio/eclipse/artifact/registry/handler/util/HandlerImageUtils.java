package org.wso2.developerstudio.eclipse.artifact.registry.handler.util;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;

public class HandlerImageUtils extends ImageUtils{
	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new HandlerImageUtils();
		}
		return instance;
	} 

	public Bundle getBundle(){
		return Platform.getBundle(Activator.PLUGIN_ID);
	}

}
