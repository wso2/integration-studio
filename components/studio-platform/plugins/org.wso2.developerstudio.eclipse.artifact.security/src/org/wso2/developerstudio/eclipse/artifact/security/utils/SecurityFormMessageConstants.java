/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.security.utils;

import org.eclipse.osgi.util.NLS;


public class SecurityFormMessageConstants extends NLS {
	
	public static final String BUNDLE_NAME="org.wso2.developerstudio.eclipse.artifact.security.utils.securityformmessageconstants";
	
	public static String MESSAGE_FORM_LOAD_ERROR;
	public static String MESSAGE_POLICYFILE_READ_ERROR;
	public static String MESSAGE_PAGE_LOADING_ERROR;
	public static String MESSAGE_RAMPART_CONFIG_ERROR;
	public static String MESSAGE_SAVE_ERROR;
	public static String MESSAGE_LOAD_UI_ERROR;
	public static String MESSAGE_SERIALIZATION_SAVE_ERROR;
	public static String USER_ROLES_NOT_SET_ERROR;
	public static String SERVER_CONNECTION_FAILURE_MESSAGE;
	public static String MESSAGE_UPDATE_SOURCE_ERROR;
	public static String MESSAGE_READ_POLICY;
	public static String MESSAGE_LOAD_PAGE;
	public static String MESSAGE_SAVE;
	public static String MESSAGE_XML_ERROR;
	public static String MESSAGE_INITIALIZE_ERROR;
	public static String MESSAGE_KERBEROS_NAME;
	public static String MESSAGE_KERBEROS_PASSWORD;
	public static String MESSAGE_KERBEROS_PROPERTIES;
	public static String MESSAGE_PRIVATESTORE_EN;
	public static String MESSAGE_TRUSTSTORE_EN;
	public static String MESSAGE_EN_PROPERTIES;
	public static String MESSAGE_PRIVATESTORE_SIGN;
	public static String MESSAGE_TRUSTSTORE_SIGN;
	public static String MESSAGE_SIGN_PROPERTIES;
	public static String MESSAGE_DIFFERENT_KERBEROS_PRINCIPAL_NAMES;

	static{
		NLS.initializeMessages(BUNDLE_NAME, SecurityFormMessageConstants.class);
	}

	public SecurityFormMessageConstants(){
	}

}
