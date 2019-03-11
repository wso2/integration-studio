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

package org.wso2.developerstudio.eclipse.store.web.function.server;

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
import org.apache.commons.httpclient.HttpException;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorData;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.ConnectorStore;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.GMFPluginDetails;
import org.wso2.developerstudio.eclipse.esb.project.control.graphicalproject.IUpdateGMFPlugin;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;

import com.google.gson.Gson;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * Handles functions related to connectors
 */
public class ConnectorFunctionServletUtil {
    
    private static final int BUFFER_SIZE = 4096;
    private static final String DIR_DOT_METADATA = ".metadata";
    private static final String DIR_CONNECTORS = ".Connectors";
    
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
     * Retrieves all connectors from WSO2 store
     * 
     * @return connector objects
     */
    public String getConnectorsList() {
        int page = 1;
        List<Connector> connectorList = new ArrayList<>();
        Object connectorInfo;
        try {
            connectorInfo = ConnectorStore.getConnectorInfo(getHttpClient(),
                    "https://store.wso2.com", page);
            if (connectorInfo instanceof List<?>) {
                List<Connector> tmpList = (List<Connector>) connectorInfo;
                while (tmpList != null && !tmpList.isEmpty()) {
                    connectorList.addAll(tmpList);
                    ++page;
                    tmpList = (List<Connector>) ConnectorStore.getConnectorInfo(getHttpClient(),
                            "https://store.wso2.com", page);
                }
            } else if (connectorInfo instanceof ConnectorData) {
                List<Connector> tmpList = ((ConnectorData) connectorInfo).getConnector();
                connectorList.addAll(tmpList);
            }
        } catch (KeyManagementException | IOException | NoSuchAlgorithmException e) {
            log.error("Error while listing connectors : ", e);
        }
        
        return new Gson().toJson(connectorList);
    }
    
    private HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        HttpClient httpclient = new HttpClient();
        httpclient.getParams().setIntParameter("http.socket.timeout", 180000);
        SSLContext ctx;
        ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
        SSLContext.setDefault(ctx);
        return httpclient;
    }
    
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
    
    public boolean downloadConnectorAndUpdateProjects(String downloadLink) {
        String zipDestination = null;
        System.out.println("Download Link");
        System.out.println(downloadLink);
        try {
            URL url = new URL(downloadLink);
            String[] segments = downloadLink.split("/");
            String zipFileName = segments[segments.length - 1];
            String parentDirectoryPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString()
                    + File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
            System.out.println("Parent Directory Path");
            System.out.println(parentDirectoryPath);
            File parentDirectory = new File(parentDirectoryPath);
            if (!parentDirectory.exists()) {
                parentDirectory.mkdir();
            }
            zipDestination = parentDirectoryPath + File.separator + zipFileName;
            InputStream is = url.openStream();
            File targetFile = new File(zipDestination);
            targetFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(targetFile);
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            is.close();
            updateProjects(zipDestination);
            return true;
        } catch (ZipException e) {
            log.error("Error while extracting the connector zip : " + zipDestination, e);
        } catch (CoreException e) {
            log.error("Cannot refresh the project", e);
        } catch (MalformedURLException malformedURLException) {
            log.error("Malformed connector URL provided : " + downloadLink, malformedURLException);
        } catch (IOException e) {
            log.error("Error while downloading connector : " + downloadLink, e);
        }
        return false;
    }

    private void updateProjects(String source) throws ZipException, CoreException {
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
        /*
         * Refresh the project.
         */
        // storeWizardPage.getSelectedProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    }
}
