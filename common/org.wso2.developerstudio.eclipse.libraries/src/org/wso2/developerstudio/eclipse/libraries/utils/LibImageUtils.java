package org.wso2.developerstudio.eclipse.libraries.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.libraries.Activator;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;

public class LibImageUtils extends ImageUtils {

	private static LibImageUtils instance;
	
//	public ImageDescriptor getJarImage(){
//		return getImageDescriptor("jar_obj.gif");
//	}
	public static LibImageUtils getInstance(){
		if (instance==null){
			instance=new LibImageUtils();
		}
		return instance;
	} 
	
	public Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}

}
