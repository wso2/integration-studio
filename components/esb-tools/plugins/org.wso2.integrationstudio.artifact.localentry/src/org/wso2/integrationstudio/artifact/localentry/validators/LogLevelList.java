/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.localentry.validators;

import java.util.ArrayList;
import java.util.List;

import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;

public class LogLevelList extends AbstractListDataProvider {

	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		list.add(createListData("None","none"));
		list.add(createListData("Full","full"));
		list.add(createListData("Simple","simple"));
		return list;
	}

}
