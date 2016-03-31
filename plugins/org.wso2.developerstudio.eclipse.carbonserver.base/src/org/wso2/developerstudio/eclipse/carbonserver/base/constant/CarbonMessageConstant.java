/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.constant;

public class CarbonMessageConstant {

	// warnings
	public static final String WARNING_WSAS_HEADING = "WSAS Warning Message";
	public static final String WARNING_WSAS_PATH_NOT_SET =
	                                                       "WSAS Runtime location does not point to valid server !! \nPlease set the correct location of the WSAS runtime on WSAS Preferences";
	public static final String WARNING_WSAS_NOT_STARTED =
	                                                      "Configured WSAS instance is not active !! Please Start the server";
	public static final String WARNING_NO_WSAS_SERVER_DEFINED = "There are no WSAS servers defined";

	// errors
	public static final String ERROR_WSAS_ALREADY_RUNNING =
	                                                        "WSO2 Web Services Application Server instance is already running, \n"
	                                                                + "Please Stop the server..";
	public static final String ERROR_WSAS_NOT_RUNNING =
	                                                    "WSO2 Web Services Application Server instance is not active,\n"
	                                                            + "Ignoring Stop server..";

	// WSAS
	public static final String INFO_WSAS_START_SUCCESS =
	                                                     "WSO2 Web Services Application Server instance started successfully";
	public static final String INFO_WSAS_START_FAIL =
	                                                  "Error Occured while starting WSO2 Web Services Application Server instance";
	public static final String INFO_WSAS_STOP_SUCCESS =
	                                                    "WSO2 Web Services Application Server instance stoped successfully";
	public static final String INFO_WSAS_STOP_FAIL =
	                                                 "Error Occured while stopping WSO2 Web Services Application Server instance";
	public static final String INFO_LINUX_SHELL_INIT_FAIL =
	                                                        "The Shell environment initiation failed, \nPlease make sure you have started eclipse with a attached shell environment\n";
	// EndPoints of Services
	public static final String host = "http://localhost:";
	public static final String port = "9763";

	public static final String generalServiceEndPoint = host + port + "/services/GeneralServices";
	public static final String validateServiceEndpoint = host + port + "/services/Service";
	public static final String validateModuleEndpoint = host + port + "/fileupload/aar_mar_validator";
	public static final String wsdlConversionEndpoint = host + port + "/services/WSDLConverterService";

	public static final String serviceXMLEndOperation = "validateServicesXML";
	public static final String moduleXMLEndOperation = "validateModuleXML";
	public static final String archiveEndOperation = "validate";
	public static final String wsdlConversionEndOperation = "convert";

}
