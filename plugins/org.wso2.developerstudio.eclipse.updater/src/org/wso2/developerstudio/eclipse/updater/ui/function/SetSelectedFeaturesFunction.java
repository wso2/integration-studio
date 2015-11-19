package org.wso2.developerstudio.eclipse.updater.ui.function;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.updater.model.DevStudioFeature;
import org.wso2.developerstudio.eclipse.updater.ui.ProvisioningWindow;
import org.wso2.developerstudio.eclipse.webui.core.util.ScriptFactory;

import com.google.gson.reflect.TypeToken;

public class SetSelectedFeaturesFunction extends AbstractProvisioningWindowFunction {

	public SetSelectedFeaturesFunction(ProvisioningWindow provisioningWindow) {
		super(provisioningWindow, FunctionNames.SET_SELECTED_FEATURES);
	}
	
	@Override
	public Object function(Object[] arguments) {
		
		String featureListString = (String) arguments[0];
		Type listType = new TypeToken<ArrayList<DevStudioFeature>>() {
        }.getType();
		List<DevStudioFeature> selectedFeatures = ScriptFactory.jsonToPojo(featureListString, listType);
		provisioningWindow.getUpdateManager().setSelectedFeaturesToInstall(selectedFeatures);
		return Boolean.TRUE.toString();
	}

}
