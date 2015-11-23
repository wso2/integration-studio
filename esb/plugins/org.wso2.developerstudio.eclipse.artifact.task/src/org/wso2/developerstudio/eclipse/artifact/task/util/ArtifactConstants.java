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

package org.wso2.developerstudio.eclipse.artifact.task.util;

import org.eclipse.osgi.util.NLS;

public class ArtifactConstants extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.task.util.constants"; //$NON-NLS-1$

	public static String Task_Create_Project;
	public static String Task_Cron;
	public static String Task_Group;
	public static String Task_Implementation;
	public static String Task_Name;
	public static String Task_Pinned_Servers;
	public static String Task_Save_location;
	public static String Task_Trigger_Count;
	public static String Task_Trigger_Interval;
	public static String Task_Trigger_Type;
	
	public static String Err_Msg_Count;
	public static String Err_Msg_Cron;
	public static String Err_Msg_Empty_Group;
	public static String Err_Msg_Empty_Impl;
	public static String Err_Msg_Empty_Path;
	public static String Err_Msg_Interval;
	public static String Err_Msg_Simple_Trigger;
	public static String Err_Msg_Simple_zero_Trigger;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ArtifactConstants.class);
	}

	private ArtifactConstants() {
	}
}
