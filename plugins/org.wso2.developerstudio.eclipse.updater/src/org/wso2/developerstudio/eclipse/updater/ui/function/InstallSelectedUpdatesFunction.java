package org.wso2.developerstudio.eclipse.updater.ui.function;

import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

public class InstallSelectedUpdatesFunction extends
		AbstractProvisioningWindowFunction {

	public InstallSelectedUpdatesFunction(ProvisioningWindow provisioningWindow) {
		super(provisioningWindow, FunctionNames.INSTALL_SELECTED_UPDATES);
	}
	
	@Override
	public Object function(Object[] arguments) {
		
		UpdateManager manager = provisioningWindow.getUpdateManager();
		provisioningWindow.getShell().dispose();
		manager.installSelectedUpdates(null);
		return Boolean.TRUE.toString();
	}

}
