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

package org.wso2.integrationstudio.eclipse.esb.project.connector.store;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URLEncoder;
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

    // ES 2.1.0 API endpoints

    // context path to get assets with ES 2.1.0
    private static final String ASSETS_ES210 = "/store/apis/assets?type=esbconnector";
    private static final String ASSETS_ES210_WITH_PAGINATION = ASSETS_ES210 + "&sort=+overview_name&start=%d&count=%d";
    // context path to get assets in Ascending order with ES 2.1.0
    private static final String ASSETS_ES210_ASC = ASSETS_ES210 + "&sort=+overview_name";
    // context path to search assets in ES 2.1.0, sorted in Ascending order
    private static final String ASSETS_ES210_SEARCH = ASSETS_ES210_ASC + "&q=";

    /**
     * This will connect to connector store using provided URL and retrieve information for available connectors in the
     * requested page and return a Object object which can be used to fetch relevant information for a particular
     * connector.
     * 
     * @param httpclient
     * @param url
     * @param page
     * @return
     * @throws HttpException
     * @throws IOException
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
            return getConnectorInfoInAsc(httpclient, url);
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
     * @param httpclient
     * @param url
     * @param start
     * @param end
     * @return
     * @throws HttpException
     * @throws IOException
     */
    public static ConnectorData getConnectorInfo_es210(HttpClient httpclient, String url, int start, int end)
            throws HttpException, IOException {
        GetMethod get = new GetMethod(url + String.format(ASSETS_ES210_WITH_PAGINATION, start, end));
        return getResponse(httpclient, get);
    }

    /**
     * This will connect to connector store - ES 2.1.0 using provided URL and
     * retrieve information for available connectors in ascending order according to
     * asset name
     * 
     * @param httpclient
     * @param url
     * @return
     * @throws HttpException
     * @throws IOException
     */
    public static ConnectorData getConnectorInfoInAsc(HttpClient httpclient, String url)
            throws HttpException, IOException {
        GetMethod get = new GetMethod(url + ASSETS_ES210_ASC);
        return getResponse(httpclient, get);
    }

    /**
     * This will connect to connector store - ES 2.1.0 using provided URL and
     * search for assets that match the given name
     * 
     * @param httpclient
     * @param url
     * @param searchQuery
     * @return
     * @throws HttpException
     * @throws IOException
     */
    public static ConnectorData searchConnector(HttpClient httpclient, String url, String searchQuery)
            throws HttpException, IOException {
        GetMethod get = new GetMethod(url + ASSETS_ES210_SEARCH
                + URLEncoder.encode("\"overview_name\":" + "\"" + searchQuery + "\"", "UTF-8"));
        return getResponse(httpclient, get);
    }

    /**
     * This will send the GET request and maps the response to a ConnectorData object
     * 
     * @param httpclient
     * @param get
     * @return
     * @throws IOException
     * @throws HttpException
     */
    private static ConnectorData getResponse(HttpClient httpclient, GetMethod get) throws IOException, HttpException {
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
