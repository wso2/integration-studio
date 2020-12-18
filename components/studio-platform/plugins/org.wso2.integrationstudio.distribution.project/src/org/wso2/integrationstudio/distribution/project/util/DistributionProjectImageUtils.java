package org.wso2.integrationstudio.distribution.project.util;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.distribution.project.Activator;
import org.wso2.integrationstudio.utils.ui.ImageUtils;

public class DistributionProjectImageUtils extends ImageUtils{
	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new DistributionProjectImageUtils();
		}
		return instance;
	} 

	public Bundle getBundle(){
		return Platform.getBundle(Activator.PLUGIN_ID);
	}

}
