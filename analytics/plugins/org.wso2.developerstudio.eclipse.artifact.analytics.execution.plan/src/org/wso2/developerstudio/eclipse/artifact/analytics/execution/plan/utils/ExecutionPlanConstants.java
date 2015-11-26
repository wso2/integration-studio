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

package org.wso2.developerstudio.eclipse.artifact.analytics.execution.plan.utils;

import org.eclipse.osgi.util.NLS;

public class ExecutionPlanConstants extends NLS {

	public static final String BUNDLE_NAME = "execution_plan_constants";

	// project wizard page properties
	public static String WIZARD_OPTION_EXECUTIONPLAN_NAME;
	public static String WIZARD_OPTION_EXECUTIONPLAN_SAVE_LOCATION;
	public static String WIZARD_OPTION_CREATE_ANALYTICS_PROJECT;
	public static String WIZARD_OPTION_NEW_EXECUTIONPLAN_PROJECT;
	public static String WIZARD_OPTION_IMPORT_EXECUTIONPLAN_PROJECT;
	public static String WIZARD_WINDOW_TITLE;
	public static String WIZARD_OPTION_EXECUTIONPLAN_IMPORT_LOCATION;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ExecutionPlanConstants.class);
	}

	public ExecutionPlanConstants() {

	}
}
