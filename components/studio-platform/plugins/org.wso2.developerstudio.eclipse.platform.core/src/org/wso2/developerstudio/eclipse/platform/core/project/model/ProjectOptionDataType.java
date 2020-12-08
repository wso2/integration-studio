/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.project.model;

public enum ProjectOptionDataType {
	STRING, LABEL, TITLED_LABEL, FILE, DIR, FILE_DIR, INTEGER, REGISTRY, OPTION, CHOICE, LIST, LINK, WORKSPACE_FILE,
	WORKSAPCE_FOLDER, WORKSPACE, COMPOSITE, UNKNOWN, REGISTRY_TEXT, RESOURCE_TEXT, WORKSAPCE_PATH_BROWSER;

	public static ProjectOptionDataType getType(String type) {
		if (type == null) {
			return UNKNOWN;
		}
		type = type.toLowerCase();
		if (type.equals("string")) {
			return STRING;
		} else if (type.equals("file")) {
			return FILE;
		} else if (type.equals("label")) {
			return LABEL;
		} else if (type.equals("titlelabel")) {
			return TITLED_LABEL;
		} else if (type.equals("dir")) {
			return DIR;
		} else if (type.equals("file+dir")) {
			return FILE_DIR;
		} else if (type.equals("registry")) {
			return REGISTRY;
		} else if (type.equals("registry+text")) {
			return REGISTRY_TEXT;
		} else if (type.equals("resource+text")) {
			return RESOURCE_TEXT;
		} else if (type.equals("option")) {
			return OPTION;
		} else if (type.equals("choice")) {
			return CHOICE;
		} else if (type.equals("list")) {
			return LIST;
		} else if (type.equals("link")) {
			return LINK;
		} else if (type.equals("workspace")) {
			return WORKSPACE;
		} else if (type.equals("workspacefile")) {
			return WORKSPACE_FILE;
		} else if (type.equals("workspacefolder")) {
			return WORKSAPCE_FOLDER;
		} else if (type.equals("workspacepathbrowser")) {
			return WORKSAPCE_PATH_BROWSER;
		} else if (type.equals("composite")) {
			return COMPOSITE;
		}
		return UNKNOWN;
	}
}
