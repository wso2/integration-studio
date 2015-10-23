package org.wso2.developerstudio.webeditor.util;

import org.wso2.developerstudio.embedded.tomcat.api.IWebAppManager;
import org.wso2.developerstudio.webeditor.AbstractWebEditorPlugin;

public class WebAppManagerServiceConsumer {

	
	public void setAppManager(IWebAppManager appManager){
		if (appManager != null) {
			AbstractWebEditorPlugin.getDefault().setAppManager(appManager);
		}
	}
	
	public void unsetAppManager(IWebAppManager appManager){
		if (appManager != AbstractWebEditorPlugin.getDefault().getAppManager()) {
			AbstractWebEditorPlugin.getDefault().setAppManager(null);
		}
	}

}
