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

public class ProjectOptionDataGroup {
	private String id;
	private String title;

	private String parentGroupId;

	// collapsible section attributes
	private boolean collapsible = false;
	private boolean expanded = true;

	// margin information
	private Integer marginHeight;
	private Integer marginWidth;

	// indent information
	private Integer verticalIndent = 10;
	private Integer horizontalIndent;

	private List<ProjectOptionDataGroup> projectOptionsDataGroup;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCollapsible(boolean collapsible) {
		this.collapsible = collapsible;
	}

	public boolean isCollapsible() {
		return collapsible;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public void setMarginHeight(Integer marginHeight) {
		this.marginHeight = marginHeight;
	}

	public Integer getMarginHeight() {
		return marginHeight;
	}

	public void setMarginWidth(Integer marginWidth) {
		this.marginWidth = marginWidth;
	}

	public Integer getMarginWidth() {
		return marginWidth;
	}

	public void setVerticalIndent(Integer verticalIndent) {
		this.verticalIndent = verticalIndent;
	}

	public Integer getVerticalIndent() {
		return verticalIndent;
	}

	public void setHorizontalIndent(Integer horizontalIndent) {
		this.horizontalIndent = horizontalIndent;
	}

	public Integer getHorizontalIndent() {
		return horizontalIndent;
	}

	public void setParentGroupId(String parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	public String getParentGroupId() {
		return parentGroupId;
	}
}
