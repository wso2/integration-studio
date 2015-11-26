package org.wso2.developerstudio.eclipse.artifact.ds.validator.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.ds.validator.Activator;
import org.wso2.developerstudio.eclipse.utils.ui.ImageUtils;

public class DSValidatorImageUtils extends ImageUtils{

	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new DSValidatorImageUtils();
		}
		return instance;
	} 

	public Bundle getBundle(){
		return Platform.getBundle(Activator.PLUGIN_ID);
	}

}
