/*
* Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbon.server.model.operations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.eclipse.core.runtime.IPath;
import org.eclipse.wst.server.core.IServer;

public abstract class CommonCarbonServerOperations {
	
	public static final String SERVER_PROPERTIES = "resources/server.properties";

	public static String uploadFile(File resourceUrl, String validatorUrl, String url) throws HttpException,
	                                                                                  IOException {
		File f = resourceUrl;
		PostMethod filePost = new PostMethod(url);
		Part part;
		if (validatorUrl == null)
			part = new FilePart(f.getName(), f);
		else
			part = new FilePart(validatorUrl, f.getName(), f);
		filePost.setRequestEntity(new MultipartRequestEntity(new Part[] { part }, filePost.getParams()));
		HttpClient client = new HttpClient();
		int status = client.executeMethod(filePost);
		String resultUUid = null;
		resultUUid = filePost.getResponseBodyAsString();
		filePost.releaseConnection();
		return resultUUid;
	}

	protected abstract String getLocalServerPort(IServer server);
	protected abstract String getAnyFileUploaderUrl(IServer server);
	protected abstract String getToolsUploadUrl(IServer server);
	protected abstract String getValidatorFileUploaderUrl(IServer server);
	protected abstract String getToolsAnyFileUploaderUrl(IServer server);
	protected abstract IPath getWSASHome(IServer server);
}
