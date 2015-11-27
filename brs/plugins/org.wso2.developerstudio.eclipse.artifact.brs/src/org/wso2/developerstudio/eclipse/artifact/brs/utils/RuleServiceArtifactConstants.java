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

package org.wso2.developerstudio.eclipse.artifact.brs.utils;

import org.eclipse.osgi.util.NLS;


public class RuleServiceArtifactConstants extends NLS{

	public static final String BUNDLE_NAME="org.wso2.developerstudio.eclipse.artifact.brs.utils.ruleserviceartifactconstants";
	public static String WIZARD_OPTION_SERVICE_NAME;
	public static String WIZARD_OPTION_SERVICE_NS;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String WIZARD_OPTION_NEW_PROJECT;
	public static String WIZARD_OPTION_IMPORT_PROJECT;
	public static String RULE_SERVICE_EDITOR_ID;
	public static String UI_EDITOR_NAME;
	public static String TEXT_EDITOR_NAME;
	public static String FORM_NAME;
	public static String NEW_LINE;
	public static String ADD_BUTTON_LABEL;
	public static String EDIT_BUTTON_LABEL;
	public static String DELETE_BUTTON_LABEL;
	public static String XML_ENCODING;
	public static String RULE_SERVICE_PROJECT_NATURE_ID;
	public static String WIZARD_MODEL_PROPERTY_PROJECT_NAME;

	static{
		NLS.initializeMessages(BUNDLE_NAME, RuleServiceArtifactConstants.class);
	}

	public RuleServiceArtifactConstants(){
	}

}
