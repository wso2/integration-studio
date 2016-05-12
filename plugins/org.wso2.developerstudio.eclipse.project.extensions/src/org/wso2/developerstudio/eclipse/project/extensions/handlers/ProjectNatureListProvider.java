/*
 * Copyright (c) 2010-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.project.extensions.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

/**
 * This class provides project nature lists
 */
public class ProjectNatureListProvider {

	private static final String EXTENSION_ID = "org.wso2.developerstudio.project.nature.provider";
	private static final String isCappSupported = "iscappsupported";
	String isMultipleArtifcat = "ismultipleartifact";
	String projectNature = "projectnature";

	public List<WSO2ProjectNature> multipleArtifactProjectNatures() {
		ArrayList<WSO2ProjectNature> multipleArtifactProjects = new ArrayList<WSO2ProjectNature>();
		List<WSO2ProjectNature> allprojectNatures = getAllProjectNatures();
		if (allprojectNatures != null && !allprojectNatures.isEmpty()) {
			for (WSO2ProjectNature wso2ProjectNature : allprojectNatures) {
				if (wso2ProjectNature.isMultipleArtifactProject) {
					multipleArtifactProjects.add(wso2ProjectNature);
				}
			}
		}
		return multipleArtifactProjects;
	}

	public List<WSO2ProjectNature> getAllProjectNatures() {
		List<WSO2ProjectNature> allprojectNatures = new ArrayList<WSO2ProjectNature>();
		DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
		IConfigurationElement[] elements = devStudioUtils.getExtensionPointmembers(EXTENSION_ID);
		if (elements != null) {
			for (IConfigurationElement elem : elements) {
				String isMultiple = elem.getAttribute(isMultipleArtifcat);
				String projectNture = elem.getAttribute(projectNature);
				String CappSupported = elem.getAttribute(isCappSupported);
				if (isMultiple != null && projectNture != null && CappSupported != null) {
					WSO2ProjectNature projectNatureItem = new WSO2ProjectNature();
					projectNatureItem.setMultipleArtifactProject(Boolean.valueOf(isMultiple));
					projectNatureItem.setProjectNature(projectNture);
					projectNatureItem.setCappSupported(Boolean.valueOf(CappSupported));
					allprojectNatures.add(projectNatureItem);
				}
			}
		}
		// Adding hard coded multiple artifact projects capp supported
		allprojectNatures.add(createProjectNature(Constants.ESB_PROJECT_NATURE, true, true));
		allprojectNatures.add(createProjectNature(Constants.GENERAL_PROJECT_NATURE, true, true));
		allprojectNatures.add(createProjectNature(Constants.CONNECTOR_PROJECT_NATURE, true, true));
		allprojectNatures.add(createProjectNature(Constants.ANALYTICS_PROJECT_NATURE, true, true));
		// Adding hard coded none multiple artifact artifact projects capp not supported
		allprojectNatures.add(createProjectNature(Constants.DISTRIBUTION_PROJECT_NATURE, false, false));
		allprojectNatures.add(createProjectNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE, false, false));
		// Adding other hard coded single artifact projects
		List<String> natures = Constants.getAllNatures();
		for (String nature : natures) {
			if (nature != Constants.ESB_PROJECT_NATURE && nature != Constants.GENERAL_PROJECT_NATURE
					&& nature != Constants.CONNECTOR_PROJECT_NATURE && nature != Constants.ANALYTICS_PROJECT_NATURE
							&& nature != Constants.DISTRIBUTION_PROJECT_NATURE
									&& nature != Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE) {
				WSO2ProjectNature proNature = createProjectNature(nature, false, true);
				if (!allprojectNatures.contains(proNature)) {
					allprojectNatures.add(proNature);
				}
			}
		}
		return allprojectNatures;
	}

	private WSO2ProjectNature createProjectNature(String projectnature, boolean isMultiple, boolean isCappSup) {
		WSO2ProjectNature wso2ProjectNature = new WSO2ProjectNature();
		wso2ProjectNature.setProjectNature(projectnature);
		wso2ProjectNature.setMultipleArtifactProject(isMultiple);
		wso2ProjectNature.setCappSupported(isCappSup);
		return wso2ProjectNature;
	}

	public boolean isWSO2ProjectType(IProject project) throws CoreException {
		List<WSO2ProjectNature> wso2ProjectNatures = getAllProjectNatures();
		if (wso2ProjectNatures != null && !wso2ProjectNatures.isEmpty()) {
			for (WSO2ProjectNature projectNature : wso2ProjectNatures) {
				if (project.hasNature(projectNature.getProjectNature())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isCappSupported(IProject project) throws CoreException {
		List<WSO2ProjectNature> wso2ProjectNatures = getAllProjectNatures();
		if (wso2ProjectNatures != null && !wso2ProjectNatures.isEmpty()) {
			for (WSO2ProjectNature projectNature : wso2ProjectNatures) {
				if (projectNature.isCappSupported && project.hasNature(projectNature.getProjectNature())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isProjectMultipleArtifact(IProject project) {
		List<WSO2ProjectNature> wso2ProjectNatures = multipleArtifactProjectNatures();
		if (wso2ProjectNatures != null && !wso2ProjectNatures.isEmpty()) {
			for (WSO2ProjectNature projectNature : wso2ProjectNatures) {
				try {
					if (project.hasNature(projectNature.getProjectNature())) {
						return true;
					}
				} catch (CoreException e) {
					return false;
				}
			}
		}
		return false;
	}

}
