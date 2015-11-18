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

package org.wso2.developerstudio.eclipse.artifact.registry.validators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryTemplate;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class RegistryArtifactTemplateList extends AbstractListDataProvider {

	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		for(RegistryTemplate templ :getRegistryTemplates()){
			list.add(createListData(templ.getName(), templ));
		}
		return list;
	}

	
	private static final String REGISTRY_TEMPLATE_EXTENSION="org.wso2.developerstudio.eclipse.platform.core.artifacttemplates";
	private static List<RegistryTemplate> regTemplateList;
	
	private static void loadProxyTemplateInfo(){
		regTemplateList=new ArrayList<RegistryTemplate>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(REGISTRY_TEMPLATE_EXTENSION);
		for (IConfigurationElement e : config) {		
			try {
				RegistryTemplate regTemplate = new RegistryTemplate();
				regTemplate.setId(e.getAttribute("id"));
				regTemplate.setName(e.getAttribute("name"));
				String fileName = e.getAttribute("file");
				Bundle bundle = Platform.getBundle(e.getContributor().getName());
				regTemplate.setTemplateFileName(fileName);
				regTemplate.setTemplateBundle(bundle);
				regTemplateList.add(regTemplate);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	static {
		loadProxyTemplateInfo();
	}
	
	public static RegistryTemplate[] getRegistryTemplates(){
		return regTemplateList.toArray(new RegistryTemplate[]{});
	}
	
}
