/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.localentry.validators;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.artifact.localentry.utils.LocalEntryArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class LocalEntryCreationTypes extends AbstractListDataProvider{

	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> epTypeList = new ArrayList<ListData>();
		epTypeList.add(createListData(LocalEntryArtifactConstants.TYPE_IN_LINE_TEXT_LE, 
				                      LocalEntryArtifactConstants.TYPE_IN_LINE_TEXT_LE));
		epTypeList.add(createListData(LocalEntryArtifactConstants.TYPE_IN_LINE_XML_LE,
									  LocalEntryArtifactConstants.TYPE_IN_LINE_XML_LE));
		epTypeList.add(createListData(LocalEntryArtifactConstants.TYPE_SOURCE_URL_LE,
									  LocalEntryArtifactConstants.TYPE_SOURCE_URL_LE));
		// TODO Auto-generated method stub
		return epTypeList;
	}



}
