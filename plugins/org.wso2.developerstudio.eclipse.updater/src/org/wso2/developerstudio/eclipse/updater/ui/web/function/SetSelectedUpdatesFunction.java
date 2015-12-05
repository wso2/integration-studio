/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.updater.ui.web.function;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.updater.model.EnhancedFeature;
import org.wso2.developerstudio.eclipse.updater.ui.web.UpdaterWebUI;
import org.wso2.developerstudio.eclipse.webui.core.util.ScriptFactory;

import com.google.gson.reflect.TypeToken;

public class SetSelectedUpdatesFunction extends AbstractProvisioningWindowFunction {

	public SetSelectedUpdatesFunction(UpdaterWebUI provisioningWindow) {
		super(provisioningWindow, FunctionNames.SET_SELECTED_UPDATES);
	}
	
	@Override
	public Object function(Object[] arguments) {
		
		String featureListString = (String) arguments[0];
		Type listType = new TypeToken<ArrayList<EnhancedFeature>>() {
        }.getType();
		List<EnhancedFeature> selectedFeatures = ScriptFactory.jsonToPojo(featureListString, listType);
		provisioningWindow.getUpdateManager().setSelectedUpdates(selectedFeatures);
		return Boolean.TRUE.toString();
	}

}
