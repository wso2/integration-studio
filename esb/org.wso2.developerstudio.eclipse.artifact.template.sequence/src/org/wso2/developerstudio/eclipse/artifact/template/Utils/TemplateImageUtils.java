package org.wso2.developerstudio.eclipse.artifact.template.Utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.template.Activator;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;

public class TemplateImageUtils extends ImageUtils{

	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new TemplateImageUtils();
		}
		return instance;
	} 

	public Bundle getBundle() {
		return Platform.getBundle(Activator.PLUGIN_ID);
	}
}
 
