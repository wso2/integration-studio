
/*
 * Copyright (c) 2015 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.security.utils;

public class SecurityFormConstants {

	public static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_ALIAS = "org.wso2.carbon.security.crypto.alias";
	public static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_TRUSTSTORES = "org.wso2.carbon.security.crypto.truststores";
	public static final String ORG_WSO2_STRATOS_TENANT_ID = "org.wso2.stratos.tenant.id";
	public static final String ORG_WSO2_CARBON_SECURITY_CRYPTO_PRIVATESTORE = "org.wso2.carbon.security.crypto.privatestore";

	// Constants for Rampart Config
	public static final String XML_NS_SEC = "xmlns:sec";
	public static final String XML_NS_SEC_ATTRIBUTE = "http://www.wso2.org/products/carbon/security";
	public static final String WS_POLICY = "wsp:Policy";
	public static final String KERBEROSSIGNANDENCRYPT = "kerberossignandencrypt";
	public static final String RAMPART_CONFIG_USER = "rampart.config.user";
	public static final String RAMPART_CONFIG = "rampart:RampartConfig";
	public static final String RAMPART_USER = "rampart:user";
	public static final String RAMPART_ENCRYPTION_USER = "rampart:encryptionUser";
	public static final String RAMPART_NONCE_LIFE_TIME = "rampart:nonceLifeTime";
	public static final String RAMPART_TOKEN_STORE_CLASS = "rampart:tokenStoreClass";
	public static final String RAMPART_TIMESTAMP_STRICT = "rampart:timestampStrict";
	public static final String RAMPART_TIMESTAMP_MAX_SKEW = "rampart:timestampMaxSkew";
	public static final String RAMPART_TIMESTAMP_TTL = "rampart:timestampTTL";
	public static final String RAMPART_TIMESTAMP_PRECISION_IN_MILLISECONDS = "rampart:timestampPrecisionInMilliseconds";
	public static final String RAMPART_ENCRYPTION_CRYPTO = "rampart:encryptionCrypto";
	public static final String RAMPART_SIGNATURE_CRYPTO = "rampart:signatureCrypto";
	public static final String RAMPART_KERBEROS_CONFIG = "rampart:kerberosConfig";
	public static final String RAMPART_CRYPTO = "rampart:crypto";
	public static final String RAMPART_PROPERTY = "rampart:property";
	public static final String PROPERTY_NAME = "name";
	public static final String USER_ROLE = "User Roles";

	// Rampart default values
	public static final String RAMPART_ENCRYPTION_USER_VALUE = "useReqSigCert";
	public static final String RAMPART_TOKEN_STORE_CLASS_VALUE = "org.wso2.carbon.security.util.SecurityTokenStore";
	public static final String RAMPART_TIME_VALUE = "300";
	public static final String RAMPART_TENANT_VALUE = "-1234";

	// Constants for Carbon Sec Config

	public static final String CARBONSEC_CONFIG = "sec:CarbonSecConfig";
	public static final String CARBONSEC_AUTHORIZATION = "sec:Authorization";
	public static final String CARBONSEC_TRUST = "sec:Trust";
	public static final String CARBON_KEBEROS = "sec:Kerberos";
	public static final String CARBONSEC_PROPERTY = "sec:property";

	public static final String ORG_WSO2_CARBON_SECURITY_ALLOWEDROLES = "org.wso2.carbon.security.allowedroles";
	public static final String SERVICE_PRINCIPAL_PASSWORD = "service.principal.password";
	public static final String SERVICE_PRINCIPAL_NAME = "service.principal.name";

	// public Store Constants
	public static final String WSO2_PRIVATESTORE = "wso2carbon.jks";
	public static final String WSO2_PRIVATESTORE_ALIAS = "wso2carbon";

	// Category Names
	public static final String BASIC_SCENARIOS = "Basic Scenarios";
	public static final String ADVANCED_SCENARIOS = "Advanced Scenarios";
	public static final String ADVANCE_CONFIGURATION = "Advance Configuration(Rampart)";

	// Label Names
	public static final String LABEL_USER = "User :";
	public static final String LABEL_ENCRYPTION_USER = "encryptionUser :";
	public static final String LABEL_PRECISION = "PrecisionInMilliseconds :";
	public static final String LABEL_TIMESTAMP_TTL = "timestampTTL :";
	public static final String LABEL_TIMESTAMP_MAX = "timestampMaxSkew :";
	public static final String LABEL_TIMESTAMP_STRICT = "timestampStrict :";
	public static final String LABEL_TOKEN_STORE_CLASS = "tokenStoreClass :";
	public static final String LABEL_NONCELIFETIME = "nonceLifeTime :";
	public static final String LABEL_SERVICE_PRINCIPAL_NAME = "Service Principal Name";
	public static final String LABEL_SERVICE_PRINCIPAL_PASSWORD = "Service Principal Password";
	public static final String EDITOR_TITLE = "WS-Policy for Service";
	public static final String VALUE_TRUE = "true";
	public static final String VALUE_FALSE = "false";
	public static final String FILE_PREFIX = "scenario";
	public static final String FILE_POSTFIX = "-policy.xml";
	public static final String SANS = "Sans";
	public static final String IMAGE_PREFIX = "scenario";
	public static final String IMAGE_POSTFIX = ".png";

	// Section Names
	public static final String SECTION_SERVICE_INFO = "Service Info";
	public static final String SECTION_SECURITY_SERVICE = "Security for the service";
	public static final String SECTION_RAMPART_CONFIGURATION = "Rampart Configuration";
	public static final String SECTION_ENCRYPTION_PROPERTIES = "Encryption Properties";
	public static final String SECTION_SIGNATURE_PROPOERTIES = "Signature Properties";
	public static final String SECTION_KERBEROS = "Kerberos Properties";

	// Rampart Configs
	public static final String ALIAS = ":Alias";
	public static final String PRIVATESTORE = ":Privatestore";
	public static final String TRUSTSTORES = ":Truststores";
	public static final String TENANT_ID = ":Tenant id";
	public static final String USER = ":User";
	public static final String EN = "en";
	public static final String SIGN = "sign";
	public static final String POLICIES = "policies/";
	public static final String PRIVATESTORE_LABEL = "Privatestore";
	public static final String TRUSTSTORE_LABEL = "Truststores";

	public static final String POLICY_OBJECT_UT = "UTOverTransport";
	public static final String POLICY_UT = "UsernameToken";
	public static final String POLICY_KERBEROS = "Kerberos Authentication - Sign - Sign based on a Kerberos Token";

	//Security Scenario Description Constants
	public static final String PLUGIN_NAME = "org.wso2.developerstudio.eclipse.artifact.security";
	public static final String RELATIVE_FOLDER_PATH = "policies/images/";
	public static final String BACKGROUD_IMAGE_RELAVIVE_PATH = "policies/images/background.png";
	public static final String SHELL_WINDOW_TITLE_PREFIX = "Security Scenario ";
	public static final String SECURITY_SCENARIO_TITLE_SEPARATOR = " : ";
	public static final String SECURITY_SCENARIO_BUTTON_IMAGE_PATH = "icons/view.png";

}
