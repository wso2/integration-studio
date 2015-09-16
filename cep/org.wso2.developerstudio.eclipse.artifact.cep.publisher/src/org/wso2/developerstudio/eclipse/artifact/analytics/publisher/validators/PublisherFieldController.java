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

package org.wso2.developerstudio.eclipse.artifact.analytics.publisher.validators;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.artifact.analytics.publisher.model.PublisherModel;
import org.wso2.developerstudio.eclipse.artifact.analytics.publisher.utils.PublisherConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectArtifactCreator;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsArtifactModel;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

import java.util.List;

public class PublisherFieldController extends AbstractFieldController {

	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		if (modelProperty.equals(PublisherConstants.WIZARD_OPTION_PUBLISHER_NAME)) {
		     CommonFieldValidator.validateArtifactName(value);
		     if (value != null) {
				String resource = value.toString();
				PublisherModel publisherModel = (PublisherModel) model;
				if (publisherModel != null) {
					IContainer resLocation = publisherModel.getPublisherSaveLocation();
					if (resLocation != null) {
						IProject project = resLocation.getProject();
						AnalyticsProjectArtifactCreator analyticsProjectArtifact = new AnalyticsProjectArtifactCreator();
						try {
							analyticsProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
							List<AnalyticsArtifactModel> allArtifacts = analyticsProjectArtifact.getAllAnalyticsArtifacts();
							for (AnalyticsArtifactModel artifact : allArtifacts) {
								if (resource.equals(artifact.getName())) {
									throw new FieldValidationException("");
								}
							}

						} catch (Exception e) {
							throw new FieldValidationException("Artifact name already exsits");
						}
					}
				}		 	 
			}     
		} else if (modelProperty.equals(PublisherConstants.WIZARD_OPTION_PUBLISHER_IMPORT_LOCATION)) {
			 CommonFieldValidator.validateImportFile(value);
		}  else if (modelProperty.equals(PublisherConstants.WIZARD_OPTION_PUBLISHER_SAVE_LOCATION)) {
			IResource resource = (IResource)value;
			if(null== resource || !resource.exists())	
				throw new FieldValidationException("Specified project or path doesn't exist");
		}

	}
	
	public boolean isReadOnlyField(String modelProperty, ProjectDataModel model) {
		boolean readOnlyField = super.isReadOnlyField(modelProperty, model);
		if (modelProperty.equals(PublisherConstants.WIZARD_OPTION_PUBLISHER_SAVE_LOCATION)) {
			readOnlyField = true;
		}
	    return readOnlyField;
	}

}
