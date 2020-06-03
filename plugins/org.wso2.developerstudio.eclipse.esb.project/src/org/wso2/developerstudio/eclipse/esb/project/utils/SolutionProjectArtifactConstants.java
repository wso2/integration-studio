/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.project.utils;

import org.eclipse.osgi.util.NLS;

public final class SolutionProjectArtifactConstants extends NLS {
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.esb.project.utils.constants";
	
	public static String MMM_PROJECT_NAME;
	public static String MMM_PROJECT_CHOICE;
	public static String ESB_PROJECT_NAME;
	public static String ESB_PROJECT_CHOICE;
	public static String REGISTRY_RESOURCES_PROJECT_NAME;
	public static String CONNECTOR_EXPORTER_PROJECT_NAME;
	public static String COMPOSITE_APPLICATION_PROJECT_NAME;
	public static String DOCKER_EXPORTER_PROJECT_NAME;
	public static String KUBERNETES_EXPORTER_PROJECT_NAME;
	public static String REGISTRY_PROJECT_CHECKED;
	public static String CONNECTOR_EXPORTER_PROJECT_CHECKED;
	public static String CAPP_PROJECT_CHECKED;
	public static String DOCKER_EXPORTER_PROJECT_CHECKED;
	public static String KUBERNETES_EXPORTER_PROJECT_CHECKED;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, SolutionProjectArtifactConstants.class);
	}

	private SolutionProjectArtifactConstants() {

	}
}