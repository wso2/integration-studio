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

package org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard;

import org.apache.maven.model.Parent;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

import java.util.ArrayList;
import java.util.List;

public class MvnMultiModuleModel extends ProjectDataModel {
	private List<IProject> selectedProjects = new ArrayList<IProject>();

	private String groupId = "com.example";
	private String artifactId = "MavenParentProject";
	private String version = "1.0.0";
	private boolean requiredParent = false;
	private ISelection currentSelection;
	private Parent parentSelection;
	private String parentGroup;
	private String parentArtifact;
	private String parentVersion;
	private String relativePath;
	private boolean updateMode;

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if ((modelPropertyValue == null) && ("group.id".equals(key))) {
			modelPropertyValue = this.getGroupId();
		} else if ((modelPropertyValue == null) && ("project.name".equals(key))) {
			modelPropertyValue = this.getArtifactId();
		} else if ((modelPropertyValue == null) && ("version.id".equals(key))) {
			modelPropertyValue = this.getVersion();
		} else if (modelPropertyValue == null && key.equals("workspace.project")) {
			modelPropertyValue = selectedProjects.toArray();
		} else if (modelPropertyValue == null && key.equals("required.parent")) {
			modelPropertyValue = isRequiredParent();
		} else if (modelPropertyValue == null && key.equals("parent.list")) {
			modelPropertyValue = getParentSelection();
		} else if (modelPropertyValue == null && key.equals("parent.group")) {
			modelPropertyValue = getParentGroup();
		} else if (modelPropertyValue == null && key.equals("parent.artifact")) {
			modelPropertyValue = getParentArtifact();
		} else if (modelPropertyValue == null && key.equals("parent.version")) {
			modelPropertyValue = getParentVersion();
		} else if (modelPropertyValue == null && key.equals("relative.path")) {
			modelPropertyValue = getRelativePath();
		}

		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if ("group.id".equals(key)) {
			this.setGroupId(data.toString());
		} else if ("project.name".equals(key)) {
			this.setArtifactId(data.toString());
		} else if ("version.id".equals(key)) {
			this.setVersion(data.toString());
		} else if (key.equals("workspace.project")) {
			Object[] selectedPrjs = (Object[]) data;
			selectedProjects.clear();
			for (Object object : selectedPrjs) {
				if (object instanceof IProject) {
					selectedProjects.add((IProject) object);
				}
			}
		} else if ("required.parent".equals(key)) {
			setRequiredParent((Boolean) data);
		} else if ("parent.list".equals(key)) {
			Parent parent = (Parent) data;
			setParentSelection(parent);
			if (parent != null && !updateMode) {
				setParentGroup(parent.getGroupId());
				setParentArtifact(parent.getArtifactId());
				setParentVersion(parent.getVersion());
				setRelativePath(parent.getRelativePath());
			}
		} else if ("parent.group".equals(key)) {
			setParentGroup(data.toString());
		} else if ("parent.artifact".equals(key)) {
			setParentArtifact(data.toString());
		} else if ("parent.version".equals(key)) {
			setParentVersion(data.toString());
		} else if ("relative.path".equals(key)) {
			setRelativePath(data.toString());
		}

		return isUiControlUpdated;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<IProject> getSelectedProjects() {
		return selectedProjects;
	}

	public void setSelectedProjects(List<IProject> selectedProjects) {
		this.selectedProjects = selectedProjects;
	}

	public void setRequiredParent(boolean requiredParent) {
		this.requiredParent = requiredParent;
	}

	public boolean isRequiredParent() {
		return requiredParent;
	}

	public void setCurrentSelection(ISelection currentSelection) {
		this.currentSelection = currentSelection;
	}

	public ISelection getCurrentSelection() {
		return currentSelection;
	}

	public void setParentSelection(Parent parentSelection) {
		this.parentSelection = parentSelection;
	}

	public Parent getParentSelection() {
		return parentSelection;
	}

	public void setParentGroup(String parentGroup) {
		this.parentGroup = parentGroup;
	}

	public String getParentGroup() {
		return parentGroup;
	}

	public void setParentArtifact(String parentArtifact) {
		this.parentArtifact = parentArtifact;
	}

	public String getParentArtifact() {
		return parentArtifact;
	}

	public void setParentVersion(String parentVersion) {
		this.parentVersion = parentVersion;
	}

	public String getParentVersion() {
		return parentVersion;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setUpdateMode(boolean updateMode) {
		this.updateMode = updateMode;
	}

	public boolean isUpdateMode() {
		return updateMode;
	}
}
