package org.wso2.developerstudio.eclipse.updater.ui.function;

import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;

public class InstallSelectedFeaturesFunction extends
		AbstractProvisioningWindowFunction {

	public InstallSelectedFeaturesFunction(ProvisioningWindow provisioningWindow) {
		super(provisioningWindow, FunctionNames.INSTALL_SELECTED_FEATURES);
	}
	
	@Override
	public Object function(Object[] arguments) {
		
		UpdateManager manager = provisioningWindow.getUpdateManager();
		provisioningWindow.getShell().dispose();
		manager.installSelectedFeatures(null);
		return Boolean.TRUE.toString();
	}

}
