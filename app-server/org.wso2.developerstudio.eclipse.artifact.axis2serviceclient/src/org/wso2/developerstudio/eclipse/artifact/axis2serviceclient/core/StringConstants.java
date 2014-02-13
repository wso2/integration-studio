/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.core;
/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import org.eclipse.osgi.util.NLS;

public final class StringConstants extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.axis2serviceclient.core.stringconstants"; //$NON-NLS-1$
	public static String ARTIFACT_DESCRIPTION;
	public static String ARTIFACT_NAME;
	public static String ARTIFACT_TYPE;
	public static String AXIS2_ARTIFACT_GROUP;
	public static String AXIS2_ICON;
	public static String AXIS2_ICON_12x12;
	public static String AXIS2_ICON_24x24;
	public static String CAPP_ICON;
	public static String JDT_ICON;
	public static String PROJECT_ICON;
	public static String JDT_SOURCE_FOLDER_ICON;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, StringConstants.class);
	}

	private StringConstants() {
	}
}
