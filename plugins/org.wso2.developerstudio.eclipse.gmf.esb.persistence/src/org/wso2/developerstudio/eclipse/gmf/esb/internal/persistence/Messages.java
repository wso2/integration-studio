/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.messages"; //$NON-NLS-1$
	public static String BAMMediatorTransformer_InvalidSubjectErrorMessage;
	public static String BAMMediatorTransformer_Server_Profile_Name_Required_Error_Message;
	public static String BAMMediatorTransformer_Stream_Name_Required_Error_Message;
	public static String BAMMediatorTransformer_Stream_Version_Required_Error_Message;
	public static String OAuthMediatorTransformer_InvalidSubjectErrorMessage;
	public static String OAuthMediatorTransformer_Password_Required_Error_Message;
	public static String OAuthMediatorTransformer_Remote_Server_Url_Required_Error_Message;
	public static String OAuthMediatorTransformer_Username_Required_Error_Message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
