/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver31.util;

import java.util.Arrays;
import java.util.List;

public class CarbonServerConstants {
	public static final String[] AXIS2_CODEGEN_LIB_PREFIXES = {							//$NON-NLS-1$
	};
	public static final String[] AXIS2_UTIL_LIB_PREFIXES = {							//$NON-NLS-1$
		"axiom-1.2.10",
		"axis2-transport-base-1.0.0",
		"axis2-1.6.0",
		"axis2-transport-jms-1.0.0",
		"axis2-jibx-1.5.0",
		"commons-httpclient-3.1.0",
		"commons-logging-1.1.1",
		"commons-fileupload-1.2.0",
		"commons-lang-1.0",
		"commons-pool-1.3.0",
		"commons-codec-1.3.0",
		"commons-el-1.0",
		"commons-cli-1.0",
		"commons-dbcp-1.2.2",
		"commons-modeler-1.1",
		"neethi-2.0.4",
		"geronimo-stax-api_1.0_spec-1.0.1",
		"wsdl4j-1.6.2",
		"XmlSchema-1.4.2",
		"woden_1.0.0.M8-wso2v1",
		"backport-util-concurrent-3.1.0",
		"org.wso2.carbon.logging-2.0.0",
		"xmlbeans-2.3.0",
		"axis2-jaxbri-1.5.0",
		"jibx-1.2.1",
		"axis2-jibx-1.5.0",
		"backport-util-concurrent-3.1.0",
		"commons-codec-1.3.0",
		"geronimo-jaxws_2.1_spec-1.0.0"
	};
	
	public static final List<String> PORT_CAPTIONS=Arrays.asList(new String[]{"Carbon service port (HTTP)",
																			 "Carbon web console port (HTTPS)",
																			 "Synapse transport HTTP port(change only if applicable)",
            																 "Synapse transport HTTPS port(change only if applicable)"});
	public static final List<String> PORT_IDS=Arrays.asList(new String[]{"carbon.http","carbon.https",
	                                                       "synapse.transport.http",
	                                                       "synapse.transport.https"});
	
	public static final String ESB_TRANSPORT_HTTP="esb.transport.http";
	public static final String ESB_TRANSPORT_HTTPS="esb.transport.https";
	public static final String ESB_CONSOLE_HTTPS="esb.https";
	
	//If the following 3 final variables are changed, please update the 
	//esb.definition.xml <port><name> tag also in parallel with the same values
	public static final String ESB_TRANSPORT_HTTP_DESC="ESB transport http";
	public static final String ESB_TRANSPORT_HTTPS_DESC="ESB transport https";
	public static final String ESB_CONSOLE_HTTPS_DESC="ESB console port";
	
	public static final String ESB_ORIGINAL_TRANSPORT_HTTP="esb.original.transport.http";
	public static final String ESB_ORIGINAL_TRANSPORT_HTTPS="esb.original.transport.https";
	
	public static final String ESB_USERNAME="esb.username";
	public static final String ESB_PASSWORD="esb.password";

}
