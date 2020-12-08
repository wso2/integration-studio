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

import java.util.ArrayList;
import java.util.List;

public class ProjectOptionInfo {
	private String optionId;
	private String title;
	private String description;
	private List<ProjectOptionData> projectOptionsData;
	private List<ProjectOptionDataGroup> projectOptionsDataGroup;
	private List<String> projectNatures;

	public List<ProjectOptionDataGroup> getProjectOptionsDataGroup() {
		if (projectOptionsDataGroup == null) {
			projectOptionsDataGroup = new ArrayList<ProjectOptionDataGroup>();
		}
		return projectOptionsDataGroup;
	}

	public ProjectOptionDataGroup getProjectOptionsDataGroup(String groupId) {
		for (ProjectOptionDataGroup group : getProjectOptionsDataGroup()) {
			if (group.getId().equals(groupId)) {
				return group;
			}
		}
		return null;
	}

	public List<ProjectOptionData> getProjectOptionsData() {
		if (projectOptionsData == null) {
			projectOptionsData = new ArrayList<ProjectOptionData>();
		}
		return projectOptionsData;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getProjectNatures() {
		if (projectNatures == null) {
			projectNatures = new ArrayList<String>();
		}
		return projectNatures;
	}

}
