/*
*  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.esb.project.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorData;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorStore;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.GMFPluginDetails;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.IUpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.esb.project.exception.ConnectorException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

import com.google.gson.Gson;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * Handles functions related to connectors
 */
public class ConnectorServletUtil {

    private static final int BUFFER_SIZE = 4096;
    private static final String DIR_DOT_METADATA = ".metadata";
    private static final String DIR_CONNECTORS = ".Connectors";
    private static final String STORE_URL = "https://store.wso2.com";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Retrieves all connectors from WSO2 store
     * 
     * @return connector objects
     */
    public static String getConnectorsList(int start, int count) {
        List<Connector> connectorList = new ArrayList<>();
        Object connectorInfo;
        try {
            connectorInfo = ConnectorStore.getConnectorInfo_es210(getHttpClient(), STORE_URL, start, count);
            if (connectorInfo instanceof List<?>) {
                connectorList.addAll((List<Connector>) connectorInfo);
            } else if (connectorInfo instanceof ConnectorData) {
                connectorList.addAll(((ConnectorData) connectorInfo).getConnector());
            }
        } catch (KeyManagementException | IOException | NoSuchAlgorithmException e) {
            log.error("Error while listing connectors : ", e);
        }

        return new Gson().toJson(connectorList);
    }
    
    /**
     * Search for the connectors that match the query string
     * 
     * @return connector objects
     */
    public static String searchConnectors(String queryString) {
        List<Connector> connectorList = new ArrayList<>();
        Object connectorInfo;
        try {
            connectorInfo = ConnectorStore.searchConnector(getHttpClient(), STORE_URL, queryString);
            if (connectorInfo instanceof List<?>) {
                connectorList.addAll((List<Connector>) connectorInfo);
            } else if (connectorInfo instanceof ConnectorData) {
                connectorList.addAll(((ConnectorData) connectorInfo).getConnector());
            }
        } catch (KeyManagementException | IOException | NoSuchAlgorithmException e) {
            log.error("Error while listing connectors : ", e);
        }

        return new Gson().toJson(connectorList);
    }

    /**
     * Download the specified connector and update the project
     * 
     * @param downloadLink - where to locate the connector
     * @return true if the connector was successfully downloaded and false if not
     * @throws ConnectorException 
     * 
     */
    public static boolean downloadConnectorAndUpdateProjects(String downloadLink) throws ConnectorException {
        String zipDestination = null;
        try {
            URL url = new URL(downloadLink);
            String[] segments = downloadLink.split("/");
            String zipFileName = segments[segments.length - 1];
            String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                    + File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
            File parentDirectory = new File(parentDirectoryPath);
            if (!parentDirectory.exists()) {
                parentDirectory.mkdir();
            }
            zipDestination = parentDirectoryPath + File.separator + zipFileName;
            try (InputStream is = url.openStream()) {
                File targetFile = new File(zipDestination);
                targetFile.createNewFile();
                try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
                    int bytesRead = -1;
                    byte[] buffer = new byte[BUFFER_SIZE];
                    while ((bytesRead = is.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    updateProjects(zipDestination);
                    return true;
                }
            } catch (IOException e) {
                log.error("Error while downloading connector : " + downloadLink, e);
                throw new ConnectorException("Error while downloading connector : " + downloadLink, e);
            }
        } catch (ZipException e) {
            log.error("Error while extracting the connector zip : " + zipDestination, e);
            throw new ConnectorException("Error while extracting the connector zip : " + zipDestination, e);
        } catch (CoreException e) {
            log.error("Cannot refresh the project", e);
            throw new ConnectorException("Cannot refresh the project", e);
        } catch (MalformedURLException malformedURLException) {
            log.error("Malformed connector URL provided : " + downloadLink, malformedURLException);
            throw new ConnectorException("Malformed connector URL provided : " + downloadLink, malformedURLException);
        } 
    }

    /**
     * Extract the connector and update the project
     * 
     * @param source
     * @throws ZipException
     * @throws CoreException
     */
    private static void updateProjects(String source) throws ZipException, CoreException {
        ZipFile zipFile = new ZipFile(source);
        String[] segments = source.split(Pattern.quote(File.separator));
        String zipFileName = segments[segments.length - 1].split(".zip")[0];
        String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                + File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
        File parentDirectory = new File(parentDirectoryPath);
        if (!parentDirectory.exists()) {
            parentDirectory.mkdir();
        }
        String zipDestination = parentDirectoryPath + File.separator + zipFileName;
        zipFile.getFile();
        zipFile.extractAll(zipDestination);
        IUpdateGMFPlugin updateGMFPlugin = GMFPluginDetails.getiUpdateGMFPlugin();
        if (updateGMFPlugin != null) {
            updateGMFPlugin.updateOpenedEditors();
        }
    }

    /**
     * Get HTTP Client instance
     * 
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private static HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        HttpClient httpclient = new HttpClient();
        httpclient.getParams().setIntParameter("http.socket.timeout", 180000);
        SSLContext ctx;
        ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
        SSLContext.setDefault(ctx);
        return httpclient;
    }

    /**
     * Trust Manager class
     */
    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

}
