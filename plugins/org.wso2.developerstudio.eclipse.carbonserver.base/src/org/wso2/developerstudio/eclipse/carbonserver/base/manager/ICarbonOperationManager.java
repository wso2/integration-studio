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

package org.wso2.developerstudio.eclipse.carbonserver.base.manager;

import java.util.Map;

import org.wso2.developerstudio.eclipse.carbonserver.base.exception.NoSuchCarbonOperationDefinedException;

public interface ICarbonOperationManager {

	public static final String PARAMETER_TYPE = "action";
	public static final String PARAMETER_PATH = "path";
	public static final String PARAMETER_SERVER = "server";
	public static final String PARAMETER_RUNTIME = "runtime";
	public static final String PARAMETER_OP_TYPES = "operations";
	public static final String PARAMETER_PROJECT = "project";
	public static final String PARAMETER_WebTempPath = "webTempPath";
	public static final String PARAMETER_SERVICE_NAME = "service_name";
	public static final String PARAMETER_SERVER_PORT = "server_port";

	public static final int OPERATION_SUPPORTED_OPERATIONS = 0;
	public static final int OPERATION_MODULE_ARCHIVE_VALIDATE = 1;
	public static final int OPERATION_MODULE_XML_VALIDATE = 2;
	public static final int OPERATION_SERVICE_ARCHIVE_VALIDATE = 3;
	public static final int OPERATION_SERVICE_XML_VALIDATE = 4;
	public static final int OPERATION_GET_LIBRARY_PATHS = 5;
	public static final int OPERATION_GET_SERVER_HOME = 6;
	public static final int OPERATION_GET_SERVER_PORTS = 7;
	public static final int OPERATION_WSDL_CONVERT_FILE = 8;
	public static final int OPERATION_WSDL_CONVERT_URL = 9;
	public static final int OPERATION_INITIALIZE_SERVER_CONFIGURATIONS = 10;
	public static final int OPERATION_CLEANUP_SERVER_CONFIGURATIONS = 11;
	public static final int OPERATION_PUBLISH_MODULE = 12;
	public static final int OPERATION_UNPUBLISH_MODULE = 13;
	public static final int OPERATION_GET_PUBLISHED_SERVICES = 14;
	public static final int OPERATION_WSDL_TRY_IT_FILE = 15;
	public static final int OPERATION_WSDL_TRY_IT_URL = 16;
	public static final int OPERATION_GET_CODEGEN_LIBRARIES = 17;
	public static final int OPERATION_GET_AXIS2_LIBRARIES = 18;
	public static final int OPERATION_HOT_UPDATE_MODULE = 19;
	public static final int OPERATION_GET_SERVICE_WSDL_URL = 20;
	public static final int OPERATION_GET_SERVICE_TRY_IT_URL = 21;
	public static final int OPERATION_GET_SERVER_CREDENTIALS = 22;
	public static final int OPERATION_GET_SERVER_AUTHENTICATED_COOKIE = 23;
	public static final int OPERATION_REDEPLOY_MODULE = 24;
	public static final int OPERATION_SERVER_URL = 25;
	public static final int OPERATION_SERVER_VERSION = 26;

	public Object executeOperation(Map<String, Object> operation) throws Exception;

	public String getRuntimeId();
}
