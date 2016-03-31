/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.samples.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.samples.contributor.IDeveloperStudioSampleCategoryContributor;
import org.wso2.developerstudio.eclipse.samples.contributor.IDeveloperStudioSampleContributor;


public class ExtensionPointHandler {
	private static String SAMPLE_HANDLER_EXTENSION="org.wso2.developerstudio.eclipse.samples";
	
	public static List<IDeveloperStudioSampleContributor> getSamples(){
		List<IDeveloperStudioSampleContributor> samples = new ArrayList<IDeveloperStudioSampleContributor>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(SAMPLE_HANDLER_EXTENSION);
        for (IConfigurationElement e : config) {		
        	try {
        		((IDeveloperStudioSampleContributor)e.createExecutableExtension("class")).setProjectName(e.getAttribute("sampleProjectName"));
        		samples.add((IDeveloperStudioSampleContributor)e.createExecutableExtension("class"));
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	}
        }
        return samples;
	}

	public static List<IDeveloperStudioSampleCategoryContributor> getSampleCategories(){
		List<IDeveloperStudioSampleCategoryContributor> samples = new ArrayList<IDeveloperStudioSampleCategoryContributor>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(SAMPLE_HANDLER_EXTENSION);
        for (IConfigurationElement e : config) {		
        	try {
        		samples.add((IDeveloperStudioSampleCategoryContributor)e.createExecutableExtension("class"));
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	}
        }
        return samples;
	}
	
	public static List<String> getSampleProjectNames(){
		List<String> projectNameList = new ArrayList<String>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(SAMPLE_HANDLER_EXTENSION);
		for (IConfigurationElement e : config) {		
        	try {
        		projectNameList.add(e.getAttribute("sampleProjectName"));
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	}
        }
		return projectNameList;
	}
}
