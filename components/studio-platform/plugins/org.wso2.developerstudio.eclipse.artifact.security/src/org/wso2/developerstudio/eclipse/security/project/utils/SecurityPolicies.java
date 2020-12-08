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


package org.wso2.developerstudio.eclipse.security.project.utils;

public class SecurityPolicies {
	
	// Basic Scenarios
	public static final String POLICY_TYPE_1 = "UsernameToken";
	public static final String POLICY_TYPE_2 = "Non-repudiation";
	public static final String POLICY_TYPE_3 = "Integrity";
	public static final String POLICY_TYPE_4 = "Confidentiality";
	
	// Advanced Scenarios
	public static final String POLICY_TYPE_5 = "Sign and Encrypt - X509 Authentication";
	public static final String POLICY_TYPE_6 = "Sign and Encrypt - Anonymous clients";
	public static final String POLICY_TYPE_7 = "Encrypt only - Username Token Authentication";
	public static final String POLICY_TYPE_8 = "Sign and Encrypt - Username Token Authentication";
	public static final String POLICY_TYPE_9 = "SecureConversation - Sign only - Service as STS - Bootstrap policy - Sign and Encrypt , X509 Authentication";
	public static final String POLICY_TYPE_10 = "SecureConversation - Encrypt only - Service as STS - Bootstrap policy - Sign and Encrypt , X509 Authentication";
	public static final String POLICY_TYPE_11 = "SecureConversation - Sign and Encrypt - Service as STS - Bootstrap policy - Sign and Encrypt , X509 Authentication";
	public static final String POLICY_TYPE_12 = "SecureConversation - Sign Only - Service as STS - Bootstrap policy - Sign and Encrypt , Anonymous clients";
	public static final String POLICY_TYPE_13 = "SecureConversation - Sign and Encrypt - Service as STS - Bootstrap policy - Sign and Encrypt , Anonymous clients";
	public static final String POLICY_TYPE_14 = "SecureConversation - Encrypt Only - Service as STS - Bootstrap policy - Sign and Encrypt , Username Token Authentication";
	public static final String POLICY_TYPE_15 = "SecureConversation - Sign and Encrypt - Service as STS - Bootstrap policy - Sign and Encrypt , Username Token Authentication";
	public static final String POLICY_TYPE_16 = "Kerberos Authentication - Sign - Sign based on a Kerberos Token";
	public static final String POLICY_TYPE_17 = "Client authenticates with SAML 2.0 protection token. Symmetric Key. X509 Certificate by the Service";
	public static final String POLICY_TYPE_18 = "Client authenticates with SAML 1.1 protection token. Symmetric Key. X509 Certificate by the Service";
	public static final String POLICY_TYPE_19 = "Sign and Encrypt - X509 Authentication - SAML 2.0 Token Required as Supporting";
	public static final String POLICY_TYPE_20 = "Sign and Encrypt - X509 Authentication - SAML 1.1 Token Required as Supporting";
	
	// Policy From Registry
	public static final String POLICY_TYPE_21 = "Policy Path";

}
