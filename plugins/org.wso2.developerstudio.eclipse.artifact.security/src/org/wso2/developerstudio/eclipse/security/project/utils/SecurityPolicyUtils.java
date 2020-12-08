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

import java.util.ArrayList;
import java.util.List;

public class SecurityPolicyUtils {

	private static SecurityPolicyUtils instance = null;

	private SecurityPolicyUtils() {

	}

	public static SecurityPolicyUtils getInstance() {
		if (instance == null) {
			instance = new SecurityPolicyUtils();
		}
		return instance;
	}

	public String[] getBasicSecurityScenarios() {
		String[] basicSecurityScenarios = new String[] { SecurityPolicies.POLICY_TYPE_1,
				SecurityPolicies.POLICY_TYPE_2, SecurityPolicies.POLICY_TYPE_3,
				SecurityPolicies.POLICY_TYPE_4 };

		return basicSecurityScenarios;
	}

	public String[] getAdvancedSecurityScenarios() {
		String[] advancedSecurityScenarios = new String[] { SecurityPolicies.POLICY_TYPE_5,
				SecurityPolicies.POLICY_TYPE_6, SecurityPolicies.POLICY_TYPE_7,
				SecurityPolicies.POLICY_TYPE_8, SecurityPolicies.POLICY_TYPE_9,
				SecurityPolicies.POLICY_TYPE_10, SecurityPolicies.POLICY_TYPE_11,
				SecurityPolicies.POLICY_TYPE_12, SecurityPolicies.POLICY_TYPE_13,
				SecurityPolicies.POLICY_TYPE_14, SecurityPolicies.POLICY_TYPE_15,
				SecurityPolicies.POLICY_TYPE_16, SecurityPolicies.POLICY_TYPE_17,
				SecurityPolicies.POLICY_TYPE_18, SecurityPolicies.POLICY_TYPE_19,
				SecurityPolicies.POLICY_TYPE_20 };

		return advancedSecurityScenarios;
	}

	public List<String> getUserRoleRequiredSecurityScenarios() {
		List<String> policies = new ArrayList<String>();

		policies.add(SecurityPolicies.POLICY_TYPE_1);
		policies.add(SecurityPolicies.POLICY_TYPE_7);
		policies.add(SecurityPolicies.POLICY_TYPE_8);
		policies.add(SecurityPolicies.POLICY_TYPE_14);
		policies.add(SecurityPolicies.POLICY_TYPE_15);

		return policies;
	}

	public List<String> getSecurityTrustRequiredSecurityScenarios() {
		List<String> policies = new ArrayList<String>();

		policies.add(SecurityPolicies.POLICY_TYPE_9);
		policies.add(SecurityPolicies.POLICY_TYPE_10);
		policies.add(SecurityPolicies.POLICY_TYPE_11);
		policies.add(SecurityPolicies.POLICY_TYPE_12);
		policies.add(SecurityPolicies.POLICY_TYPE_13);
		policies.add(SecurityPolicies.POLICY_TYPE_14);
		policies.add(SecurityPolicies.POLICY_TYPE_15);
		policies.add(SecurityPolicies.POLICY_TYPE_17);
		policies.add(SecurityPolicies.POLICY_TYPE_18);
		policies.add(SecurityPolicies.POLICY_TYPE_19);
		policies.add(SecurityPolicies.POLICY_TYPE_20);

		return policies;
	}

	public String[] getRegistrySecurityScenarios() {
		String[] registrySecurityScenarios = new String[] { SecurityPolicies.POLICY_TYPE_21 };

		return registrySecurityScenarios;
	}
	
	public String getPolicyTypeFromPolicyUUID(String policyUUID) {
		String policyType = null;
		if (policyUUID.equals("UTOverTransport")) {
			policyType = SecurityPolicies.POLICY_TYPE_1;
		} else if (policyUUID.equals("SigOnly")) {
			policyType = SecurityPolicies.POLICY_TYPE_2;
		} else if (policyUUID.equals("SgnOnlyAnonymous")) {
			policyType = SecurityPolicies.POLICY_TYPE_3;
		} else if (policyUUID.equals("EncrOnlyAnonymous")) {
			policyType = SecurityPolicies.POLICY_TYPE_4;
		} else if (policyUUID.equals("SigEncr")) {
			policyType = SecurityPolicies.POLICY_TYPE_5;
		} else if (policyUUID.equals("SgnEncrAnonymous")) {
			policyType = SecurityPolicies.POLICY_TYPE_6;
		} else if (policyUUID.equals("EncrOnlyUsername")) {
			policyType = SecurityPolicies.POLICY_TYPE_7;
		} else if (policyUUID.equals("SgnEncrUsername")) {
			policyType = SecurityPolicies.POLICY_TYPE_8;
		} else if (policyUUID.equals("SecConSignOnly")) {
			policyType = SecurityPolicies.POLICY_TYPE_9;
		} else if (policyUUID.equals("SecConEncrOnly")) {
			policyType = SecurityPolicies.POLICY_TYPE_10;
		} else if (policyUUID.equals("SecConSgnEncr")) {
			policyType = SecurityPolicies.POLICY_TYPE_11;
		} else if (policyUUID.equals("SecConSignOnlyAnonymous")) {
			policyType = SecurityPolicies.POLICY_TYPE_12;
		} else if (policyUUID.equals("SecConEncrOnlyAnonymous")) {
			policyType = SecurityPolicies.POLICY_TYPE_13;
		} else if (policyUUID.equals("SecConEncrUsername")) {
			policyType = SecurityPolicies.POLICY_TYPE_14;
		} else if (policyUUID.equals("SecConSgnEncrUsername")) {
			policyType = SecurityPolicies.POLICY_TYPE_15;
		} else if (policyUUID.equals("kerberossignandencrypt")) {
			policyType = SecurityPolicies.POLICY_TYPE_16;
		} else if (policyUUID.equals("SAML2HoKProtection31")) {
			policyType = SecurityPolicies.POLICY_TYPE_17;
		} else if (policyUUID.equals("SAML11HoKProtection32")) {
			policyType = SecurityPolicies.POLICY_TYPE_18;
		} else if (policyUUID.equals("SigEncrSAML20Supporting33")) {
			policyType = SecurityPolicies.POLICY_TYPE_19;
		} else if (policyUUID.equals("SigEncrSAML11Supporting34")) {
			policyType = SecurityPolicies.POLICY_TYPE_20;
		} else if (policyUUID.equals("policyFromRegistry")) {
			policyType = SecurityPolicies.POLICY_TYPE_21;
		}
		
		return policyType;
	}
}
