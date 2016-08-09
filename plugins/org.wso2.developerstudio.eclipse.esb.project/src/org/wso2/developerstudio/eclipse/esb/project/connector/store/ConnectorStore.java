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

package org.wso2.developerstudio.eclipse.esb.project.connector.store;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectorStore {

    private static final String ASSETS = "/store/apis/assets/esbconnector";
    //context path to get assets with ES 2.1.0
    private static final String ASSETS_ES210 = "/store/apis/assets?type=esbconnector";

	/**
	 * This will connect to connector store using provided URL and retrieve information for available connectors in the
	 * requested page and return a Object object which can be used to fetch relevant information for a particular
	 * connector.
	 * 
	 * @param url
	 * @return Object
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws IOException
	 * @throws HttpException
	 */
	public static Object getConnectorInfo(HttpClient httpclient, String url, int page)
			throws HttpException, IOException {
		GetMethod get = new GetMethod(url + ASSETS + "?page=" + page);
		int statusCode = 0;
		statusCode = httpclient.executeMethod(get);
		if (statusCode == 200) {
			Reader reader = new InputStreamReader(get.getResponseBodyAsStream());
			Type collectionType = new TypeToken<List<Connector>>() {
			}.getType();
			List<Connector> lcs = (List<Connector>) new Gson().fromJson(reader, collectionType);
			return lcs;
		} else if (statusCode == 404) {
			return getConnectorInfo_es210(httpclient, url, page);
		} else {
			return null;
		}
	}
	
	/**
	 * This will connect to connector store - ES 2.1.0 using provided URL and
	 * retrieve information for available connectors in the requested page and
	 * return a ConnectorData object which can be used to fetch relevant
	 * information for a particular connector.
	 * 
	 * @param url
	 * @return ConnectorData
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws IOException
	 * @throws HttpException
	 */
	public static ConnectorData getConnectorInfo_es210(HttpClient httpclient, String url, int page)
			throws HttpException, IOException {
		GetMethod get = new GetMethod(url + ASSETS_ES210);
		int statusCode = 0;
		statusCode = httpclient.executeMethod(get);
		if (statusCode == 200) {
			Reader reader = new InputStreamReader(get.getResponseBodyAsStream());
			Type collectionType = new TypeToken<ConnectorData>() {
			}.getType();
			ConnectorData lcs = (ConnectorData) new Gson().fromJson(reader, collectionType);
			return lcs;
		} else {
			return null;
		}
	}
}
