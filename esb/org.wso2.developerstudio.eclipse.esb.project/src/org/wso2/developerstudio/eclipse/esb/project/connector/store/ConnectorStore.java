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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConnectorStore {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static String authenticate = "/publisher/apis/authenticate";
	private static String assets = "/publisher/apis/assets?type=esbconnector";

	/**
	 * This will connect to connector store using provided URL and retrieve
	 * information for available connectors and return a ConnectorData object
	 * which can be used to fetch relevant information for a particular
	 * connector.
	 * 
	 * @param url
	 * @return ConnectorData
	 */
	public ConnectorData getConnectorInfo(String url) {
		int statusCode = 0;
		int statusCode2 = 0;
		BufferedReader br = null;
		//TODO we should avoid username/password
		String username = "admin";
		String password = "admin";

		HttpClient httpclient = new HttpClient();
		String authenticationURL = url + authenticate;
		PostMethod post = new PostMethod(authenticationURL);
		try {
			post.setRequestEntity(new StringRequestEntity("username=" + URLEncoder.encode(username, "UTF-8")
					+ "&password=" + URLEncoder.encode(password, "UTF-8"), "application/x-www-form-urlencoded", "UTF-8"));
			try {
				statusCode = httpclient.executeMethod(post);
			} catch (IOException e) {
				log.error("Unable to execute post method for this URL : " + authenticationURL);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("Unable to encode username/password");
		}
		if (statusCode == 200) {
			log.info(username + ", successfully logged in!");
			try {
				if (statusCode == HttpStatus.SC_NOT_IMPLEMENTED) {
					log.error("The Post method is not implemented by this URI");
					post.getResponseBodyAsString();
					return null;
				} else {
					br = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream()));
					Reader reader = new InputStreamReader(post.getResponseBodyAsStream());
					new InputStreamReader(post.getResponseBodyAsStream());
					GsonBuilder gsonBuilder = new GsonBuilder();
					gsonBuilder.setDateFormat("M/d/yy hh:mm a");
					Gson gson = gsonBuilder.create();
					Session session = gson.fromJson(reader, Session.class);
					GetMethod get = new GetMethod(url + assets + "&start=1&count=200");
					// get.getParams().setParameter("JSESSIONID", session.getData().getSessionId());
					statusCode2 = httpclient.executeMethod(get);
					Reader reader2 = new InputStreamReader(get.getResponseBodyAsStream());
					reader2 = new InputStreamReader(get.getResponseBodyAsStream());
					GsonBuilder gsonBuilder2 = new GsonBuilder();
					Gson gson2 = gsonBuilder2.create();
					ConnectorData connectorData = gson2.fromJson(reader2, ConnectorData.class);

					return connectorData;
				}
			} catch (HttpException e) {
				log.error("Error while executing GET method");
			} catch (IOException e) {
				log.error("Error while reading responses");
			} finally {
				post.releaseConnection();
				if (br != null)
					try {
						br.close();
					} catch (Exception exception) {
						log.error("Failed to close the stream ", exception);
					}
			}
		} else {
			log.error("Login failed for user " + username);
			return null;
		}
		return null;
	}
}
