package org.wso2.developerstudio.eclipse.webui.core.service;

import org.wso2.developerstudio.eclipse.embedded.tomcat.api.IWebAppManager;
import org.wso2.developerstudio.eclipse.webui.core.WebUICorePlugin;

public class WebAppManagerServiceConsumer {

	
	public void setAppManager(IWebAppManager appManager){
		if (appManager != null) {
			WebUICorePlugin.getDefault().setAppManager(appManager);
		}
	}
	
	public void unsetAppManager(IWebAppManager appManager){
		if (appManager == WebUICorePlugin.getDefault().getAppManager()) {
			WebUICorePlugin.getDefault().setAppManager(null);
		}
	}

}
