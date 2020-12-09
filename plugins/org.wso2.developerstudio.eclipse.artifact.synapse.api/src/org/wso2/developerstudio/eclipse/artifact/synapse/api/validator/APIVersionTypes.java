/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.artifact.synapse.api.validator;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.artifact.synapse.api.util.ArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class APIVersionTypes extends AbstractListDataProvider {

	@Override
	public List<ListData> getListData(String arg0, ProjectDataModel arg1) {
		List<ListData> versionTypeList = new ArrayList<ListData>();

		versionTypeList.add(
				createListData(ArtifactConstants.API_VERSION_TYPE_NONE, ArtifactConstants.API_VERSION_TYPE_NONE));
		versionTypeList.add(
				createListData(ArtifactConstants.API_VERSION_TYPE_CONTEXT, ArtifactConstants.API_VERSION_TYPE_CONTEXT));
		versionTypeList.add(
				createListData(ArtifactConstants.API_VERSION_TYPE_URL, ArtifactConstants.API_VERSION_TYPE_URL));

		return versionTypeList;
	}

}
