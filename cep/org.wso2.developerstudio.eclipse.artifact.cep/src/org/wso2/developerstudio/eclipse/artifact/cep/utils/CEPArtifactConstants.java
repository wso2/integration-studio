/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.cep.utils;

import org.eclipse.osgi.util.NLS;

public class CEPArtifactConstants extends NLS {

	public static final String BUNDLE_NAME = "cepartifactconstants";

	// project wizard page properties
	public static String WIZARD_OPTION_BUCKET_NAME;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String WIZARD_OPTION_BUCKET_NAMESPACE;
	public static String WIZARD_OPTION_CEP_ENGINEPROVIDER;
	public static String WIZARD_OPTION_BUCKET_DISCRIPTION;
	public static String WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME;
	public static String WIZARD_OPTION_ESPER_CEP_RUNTIME;
	public static String WIZARD_OPTION_WS_EVENT_BROKER;
	public static String WIZARD_OPTION_LOCAL_BROKER;
	public static String WIZARD_OPTION_INTEGER;
	public static String WIZARD_OPTION_DOUBLE;
	public static String WIZARD_OPTION_STRING;
	public static String WIZARD_OPTION_LONG;
	public static String WIZARD_OPTION_NEW_CEPPROJECT;
	public static String WIZARD_OPTION_IMPORT_CEPPROJECT;
	public static String WIZARD_OPTION_FLOAT;
	public static String WIZARD_OPTION_METADATA;
	public static String WIZARD_OPTION_PAYLOAD;
	public static String WIZARD_OPTION_CORRELATION;
	public static String WIZARD_OPTION_SIDDHI_CEP_RUNTIME;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, CEPArtifactConstants.class);
	}

	public CEPArtifactConstants() {

	}
}
