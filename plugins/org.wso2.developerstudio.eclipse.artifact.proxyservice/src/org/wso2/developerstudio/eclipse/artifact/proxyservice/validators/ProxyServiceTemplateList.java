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

package org.wso2.developerstudio.eclipse.artifact.proxyservice.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

public class ProxyServiceTemplateList extends AbstractListDataProvider{

	private static ArtifactTemplate[] artifactTemplates;

	static {
		Map<String,List<String>> filters=new HashMap<String,List<String>> ();
		DeveloperStudioProviderUtils.addFilter(filters,CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_PROXY);
		setArtifactTemplates(ArtifactTemplateHandler.getArtifactTemplates(filters));
	}
	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> data = new ArrayList<ListData>();

		if (modelProperty.equals("ps.type")){
			for (ArtifactTemplate template : getArtifactTemplates()) {
				data.add(new ProxyServiceListData(template.getName(), template));
			}
		}
		return data;
	}

	public static void setArtifactTemplates(ArtifactTemplate[] artifactTemplates) {
		ProxyServiceTemplateList.artifactTemplates = artifactTemplates;
	}

	public static ArtifactTemplate[] getArtifactTemplates() {
		return artifactTemplates;
	}

	public class ProxyServiceListData extends ListData{

		public ProxyServiceListData(String caption, Object data) {
			super(caption, data);
		}

		
		public boolean equals(Object data) {
			if (data==getData()){
				return true;
			}else if (data==null){
				return false;
			}else if (getData()==null){
				return false;
			}else{
				return ((ArtifactTemplate)data).getId().equals(((ArtifactTemplate)getArtifactTemplate()).getId());
			}
		}

		public ArtifactTemplate getArtifactTemplate(){
			return (ArtifactTemplate)getData();
		}
	}

}
