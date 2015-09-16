/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.artifact.analytics.utils;

import org.eclipse.osgi.util.NLS;

public class AnalyticsConstants extends NLS {

	public static final String BUNDLE_NAME = "analytics_constants";

	// project wizard page properties
	public static String WIZARD_OPTION_ANALYTICS_NAME;
	public static String WIZARD_OPTION_ANALYTICS_LOCATION;
	public static String WIZARD_OPTION_NEW_ANALYTICS_PROJECT;
	public static String WIZARD_OPTION_IMPORT_ANALYTICS_PROJECT;
	public static String ANALYTICS_STREAM_DIR;
	public static String ANALYTICS_EXECUTION_PLAN_DIR;
	public static String ANALYTICS_RECEIVER_DIR;
	public static String ANALYTICS_PUBLISHER_DIR;
	public static String DEPLOYMENT_SERVER_STREAM_DIR;
	public static String DEPLOYMENT_SERVER_EXECUTION_PLAN_DIR;
	public static String DEPLOYMENT_SERVER_RECEIVER_DIR;
	public static String DEPLOYMENT_SERVER_PUBLISHER_DIR;
	public static String ANALYTICS_PROJECT_NATURE;
	public static String WIZARD_WINDOW_TITLE;
	public static String EXTENTION_STREAM;
	public static String EXTENTION_EXECUTION_PLAN;
	public static String EXTENTION_PUBLISHER;
	public static String EXTENTION_RECEIVER;
	public static String ANALYTICS_SERVER_NAME;
	public static String ARTIFACT_TYPE_EXECUTIONPLAN;
	public static String ARTIFACT_TYPE_STREAM;
	public static String ARTIFACT_TYPE_RECEIVER;
	public static String ARTIFACT_TYPE_PUBLISHER;
	public static String TEMPLATE_EXECUTIONPLAN;
	public static String TEMPLATE_PUBLISHER;
	public static String TEMPLATE_RECEIVER;
	public static String TEMPLATE_STREAM;
	public static String NAMETAG_EXECUTIONPLAN_TEMPLATE;
	public static String NAMETAG_PUBLISHER_TEMPLATE;
	public static String NAMETAG_RECEIVER_TEMPLATE;
	public static String NAMETAG_STREAM_TEMPLATE;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, AnalyticsConstants.class);
	}

	public AnalyticsConstants() {

	}
}
