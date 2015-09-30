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

package org.wso2.developerstudio.eclipse.artifact.analytics.validators;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;

public class AnalyticsProjectFieldController extends AbstractFieldController {
	
	private final static Pattern ADDITIONAL_FOLDERS_PATTERN = Pattern.compile("([\\/\\\\]repository[\\/\\\\]deployment[\\/\\\\]server)$");
	
	public void validate(String modelProperty, Object value, ProjectDataModel model)
	        throws FieldValidationException {
		if (modelProperty.equals(AnalyticsConstants.WIZARD_OPTION_ANALYTICS_NAME)) {
			CommonFieldValidator.validateProjectField(value);
		}else if (modelProperty.equals(AnalyticsConstants.WIZARD_OPTION_ANALYTICS_LOCATION)){
			if (value == null) {
				throw new FieldValidationException("Specified folder location is invalid");
			}
			String name = value.toString();
			Matcher additionlFolderMatcher = ADDITIONAL_FOLDERS_PATTERN.matcher(name);
			if (name.trim().equals("")||!additionlFolderMatcher.find()) {
				throw new FieldValidationException("Specified folder location is invalid");
			} else{
				File folderLocation = (File) value;
				if (!folderLocation.exists()||!folderLocation.isDirectory()) {
					throw new FieldValidationException("Specified folder doesn't exist");
				}	
			}
		}
	}
}