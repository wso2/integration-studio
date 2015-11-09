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

package org.wso2.developerstudio.eclipse.carbonserver.base.service.util;

import java.io.IOException;
import java.util.HashMap;

import javax.activation.DataHandler;
// import javax.xml.soap.SOAPConnection;
// import javax.xml.soap.SOAPFactory;

import org.apache.commons.httpclient.HttpException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.command.WTPInternalBrowserCommand;
import org.wso2.developerstudio.eclipse.carbonserver.base.exception.UserOperationCancelledException;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.ICarbonOperationManager;
import org.wso2.developerstudio.eclipse.server.base.core.IServerManager;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;

public final class CarbonUploadServiceRequestUtil {

	private static CarbonUploadServiceRequestUtil instance;

	private DataHandler dh;
	private boolean isXml;
	private boolean isArchive;
	private boolean isService;
	private boolean isModule;
	private boolean isWSDL;
	private boolean alredyInit;
	private String anyFileUploaderUrl = "http://localhost:9763/fileupload/*";

	// Private constructor
	private CarbonUploadServiceRequestUtil() {
	}

	public static CarbonUploadServiceRequestUtil getInstance() {
		if (instance == null) {
			instance = new CarbonUploadServiceRequestUtil();
		}
		return instance;
	}

	public String requestValidate(String resourceFile, String serverId, Shell shell) throws HttpException, IOException,
	                                                                                Exception {
		String returnUUID = null;
		IServer server = CarbonServerManager.getServer(serverId);
		if (server.getServerState() != IServer.STATE_STARTED) {
			boolean serverResult = ServerController.getInstance().getServerManager().startServer(serverId, shell);
			if (!serverResult)
				throw new UserOperationCancelledException();;
		}
		// IServer runningServer = WSASServerManager.getRunningServer();
		// if (runningServer==null)
		// throw new WSASServerNotRunningException();
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		HashMap<String, Object> operationParameters = new HashMap<String, Object>();
		int action = 0;
		if (isService) {
			if (isXml) {
				action = ICarbonOperationManager.OPERATION_SERVICE_XML_VALIDATE;

			} else {
				action = ICarbonOperationManager.OPERATION_SERVICE_ARCHIVE_VALIDATE;
			}
		} else if (isModule) {
			if (isXml) {
				action = ICarbonOperationManager.OPERATION_MODULE_XML_VALIDATE;
			} else {
				action = ICarbonOperationManager.OPERATION_MODULE_ARCHIVE_VALIDATE;
			}
		} else if (isWSDL) {
			if (resourceFile.toLowerCase().startsWith("http"))
				action = ICarbonOperationManager.OPERATION_WSDL_CONVERT_URL;
			else
				action = ICarbonOperationManager.OPERATION_WSDL_CONVERT_FILE;
		}
		operationParameters.put(ICarbonOperationManager.PARAMETER_TYPE, action);
		operationParameters.put(ICarbonOperationManager.PARAMETER_PATH, resourceFile);
		returnUUID = wsasServerManager.executeOperationOnServer(server, operationParameters).toString();// getWSDLConversionResultUrl(resourceFile);
		return returnUUID;
	}

	public String sendRequestToServer(int action, String serverId, HashMap<String, Object> operationParameters,
	                                  Shell shell) throws Exception {
		String returnUUID = null;
		IServer server = CarbonServerManager.getServer(serverId);
		prepareServer(serverId, shell);
		IServerManager wsasServerManager = ServerController.getInstance().getServerManager();
		returnUUID = wsasServerManager.executeOperationOnServer(server, operationParameters).toString();// getWSDLConversionResultUrl(resourceFile);
		return returnUUID;
	}

	public void prepareServer(String serverId, Shell shell) throws UserOperationCancelledException {
		IServer server = CarbonServerManager.getServer(serverId);
		if (server.getServerState() != IServer.STATE_STARTED) {
			boolean serverResult = ServerController.getInstance().getServerManager().startServer(serverId, shell);
			if (!serverResult)
				throw new UserOperationCancelledException();;
		}

	}

	public void popupInternalBrowser(String url) {
		WTPInternalBrowserCommand.popUpInrernalBrouwser(url);
	}

	public void popupExternalBrowser(String url) {
		WTPInternalBrowserCommand.popUpExternalBrouwser(url);
	}

	public void setXml(boolean isXml) {
		this.isXml = isXml;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	public void setService(boolean isService) {
		this.isService = isService;
	}

	public void setModule(boolean isModule) {
		this.isModule = isModule;
	}

	public void reset() {
		this.isModule = false;
		this.isService = false;
		this.isXml = false;
		this.isArchive = false;
		this.isWSDL = false;
	}

	public void setWSDL(boolean isWSDL) {
		this.isWSDL = isWSDL;
	}

}
