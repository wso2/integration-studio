package org.wso2.integrationstudio.carbonserver.base.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Enumeration;

import javax.activation.DataHandler;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.wso2.integrationstudio.carbonserver.base.Activator;
import org.wso2.integrationstudio.carbonserver.base.capp.uploader.CarbonAppUploaderStub;
import org.wso2.integrationstudio.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadedFileItem;
import org.wso2.integrationstudio.carbonserver.base.carbon.application.ApplicationAdminStub;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.ui.preferences.ClientTrustStorePreferencePage;
import org.wso2.integrationstudio.platform.ui.utils.SSLUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CAppDeployer {

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static IPreferencesService preferenceStore;
	private static final String MI_LOGIN_RESOURCE = "login";
	private static final String MI_CAPP_RESOURCE = "applications";
	
    public void deployCApp(String username, String pwd, String url, File carFile, String serverType) throws Exception {
        if (serverType == null || "ei".equals(serverType)) {
            deployCApp(username, pwd, url, carFile);
        } else if ("mi".equals(serverType)) {
            String accessToken = getAccessToken(url, username, pwd);
            if (accessToken != null) {
                uploadCAppToMI(url, carFile, accessToken);
            }
        }
    }
	
    /**
     * Upload a CAPP to micro integrator via the management API
     * 
     * @param url MI management API URL
     * @param carFile CAPP to be uploaded
     * @param token Access token to management API
     * @throws Exception 
     */
    private void uploadCAppToMI(String apiUrl, File carFile, String token) throws Exception {
        String uploadURL = apiUrl.endsWith("/") ? apiUrl.concat(MI_CAPP_RESOURCE)
                : apiUrl.concat("/").concat(MI_CAPP_RESOURCE);

        String boundary = "------------------------" + Long.toHexString(System.currentTimeMillis());
        // Generate some unique random value.
        String CRLF = "\r\n"; // Line separator required by multipart/form-data.
        HttpsURLConnection connection = (HttpsURLConnection) new URL(uploadURL).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Authorization", "Bearer ".concat(token));
        connection.setHostnameVerifier(getHostnameVerifier());

        OutputStream output = connection.getOutputStream();

        // Send binary file - part
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8), true);
        writer.append("--").append(boundary).append(CRLF);
        writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"").append(carFile.getName())
                .append("\"").append(CRLF);
        writer.append("Content-Type: application/octet-stream").append(CRLF);
        writer.append(CRLF).flush();

        // File data
        Files.copy(carFile.toPath(), output);
        output.flush();

        writer.append(CRLF);

        // End of multipart/form-data.
        writer.append(CRLF).append("--").append(boundary).append("--").flush();

        StringBuilder response = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Error occurred while uploading the CAPP to MI");
        }
        String strCurrentLine;
        while ((strCurrentLine = br.readLine()) != null) {
            response.append(strCurrentLine);
        }
        br.close();
        System.out.println(response);
    }
    
    /**
     * Disabling the hostname verification.
     *
     * @return true for all the host names.
     */
    private static HostnameVerifier getHostnameVerifier() {
        return (s, sslSession) -> true;
    }
    
    /**
     * Get access token to MI management API
     * 
     * @param url Management API URL
     * @param username username
     * @param pwd password
     * @return Access token for MI, null if error occurs
     */
    private String getAccessToken(String url, String username, String pwd) {
        String logginURL = url.endsWith("/") ? url.concat(MI_LOGIN_RESOURCE)
                : url.concat("/").concat(MI_LOGIN_RESOURCE);
        try {
            URL serverURL = new URL(logginURL);
            HttpURLConnection connection = (HttpURLConnection) serverURL.openConnection();
            connection.setRequestMethod("GET");
            String credentials = username + ":" + pwd;
            String encodedCredentials = Base64.getEncoder()
                    .encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);

            int responseCode = connection.getResponseCode();
            if (200 == responseCode) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                JsonObject jsonResponse = new Gson().fromJson(response.toString(), JsonObject.class);
                if (jsonResponse.has("AccessToken")) {
                    return jsonResponse.get("AccessToken").getAsString();
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            return null;
        }
        return null;
    }
    
	/**
	 * This method is used to upload car files in to your carbon server
	 * instances and to a tanent in the cloud platform.
	 * 
	 * @param username
	 *            Username to access your server/tanent
	 * @param pwd
	 *            Password to access your server/tanent
	 * @param url
	 *            URL of the server/tanent
	 * @param carFile
	 *            File reference to the actual Car File.
	 * @throws Exception
	 */
	public void deployCApp(String username, String pwd, String url, File carFile) throws Exception {
		CarbonAppUploaderStub carbonAppUploaderStub = getCarbonAppUploaderStub(username, pwd, url);
		Options options = carbonAppUploaderStub._getServiceClient().getOptions();
		options.setProperty(Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);
		UploadedFileItem uploadedFileItem = new UploadedFileItem();
		DataHandler param = new DataHandler(carFile.toURI().toURL());
		uploadedFileItem.setDataHandler(param);
		uploadedFileItem.setFileName(carFile.getName());
		uploadedFileItem.setFileType("jar");
		UploadedFileItem[] fileItems = new UploadedFileItem[] { uploadedFileItem };
		carbonAppUploaderStub.uploadApp(fileItems);
	}

	private CarbonAppUploaderStub getCarbonAppUploaderStub(String username, String pwd, String url) throws Exception,
	                                                                                               AxisFault,
	                                                                                               MalformedURLException {
		String sessionCookie = CarbonServerUtils.createSessionCookie(url, username, pwd);
		CarbonAppUploaderStub carbonAppUploaderStub =
		                                              new CarbonAppUploaderStub(CarbonServerUtils.getURL(url) + "/" +
		                                                                        CarbonServerUtils.getServicePath() +
		                                                                        "/CarbonAppUploader");
		SSLUtils.setSSLProtocolHandler(carbonAppUploaderStub);
		carbonAppUploaderStub._getServiceClient().getOptions().setManageSession(true);
		carbonAppUploaderStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return carbonAppUploaderStub;
	}

	static {
		preferenceStore = Platform.getPreferencesService();

		String clientTrustStoreLocation =
		                                  preferenceStore.getString("org.wso2.integrationstudio.platform.ui",
		                                                            ClientTrustStorePreferencePage.TRUST_STORE_LOCATION,
		                                                            null, null);
		String clientTrustStoreType =
		                              preferenceStore.getString("org.wso2.integrationstudio.platform.ui",
		                                                        ClientTrustStorePreferencePage.TRUST_STORE_TYPE, null,
		                                                        null);
		String clientTrustStorePassword =
		                                  preferenceStore.getString("org.wso2.integrationstudio.platform.ui",
		                                                            ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD,
		                                                            null, null);

		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		if (clientTrustStoreLocation != null && clientTrustStorePassword != null &&
		    clientTrustStoreLocation.endsWith(".jks") && !clientTrustStorePassword.equals("")) {
			System.setProperty("javax.net.ssl.trustStore", clientTrustStoreLocation);
			System.setProperty("javax.net.ssl.trustStorePassword", clientTrustStorePassword);
		} else {
			System.setProperty("javax.net.ssl.trustStore", getJKSPath());
			System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
		}
	}

	private static String getJKSPath() {
		extractFilesToLocation("resources/security", new File(getMetaDataPath()));
		String path = getMetaDataPath() + File.separator + "security" + File.separator + "wso2carbon.jks";
		return path;
	}

	public static void extractFilesToLocation(String resourcePath, File destination) {
		URL resource = Activator.getDefault().getBundle().getResource(resourcePath);
		if (isResourceFolder(resource)) {
			Enumeration confFolder = Activator.getDefault().getBundle().getEntryPaths(resourcePath);
			String[] filePath = resource.getFile().split("/");
			File newDestinationPath = new File(destination, filePath[filePath.length - 1]);
			newDestinationPath.mkdirs();
			while (confFolder != null && confFolder.hasMoreElements()) {
				String newResourcefile = confFolder.nextElement().toString();
				extractFilesToLocation(newResourcefile, newDestinationPath);
			}

		} else {
			copyResourceToDestination(resource, destination);
		}
	}

	private static boolean isResourceFolder(URL url) {
		boolean result = true;
		try {
			InputStream openStream = url.openStream();
			if (openStream.available() > 0)
				result = false;
			openStream.close();
		} catch (IOException e) {
			// error
		}
		return result;
	}

	private static void copyResourceToDestination(URL url, File destination) {
		String[] filePath = url.getFile().split("/");
		File destinationFile = new File(destination, filePath[filePath.length - 1]);

		InputStream confOpenStream;
		try {
			confOpenStream = url.openStream();
			BufferedInputStream confBufferedInStream = null;
			confBufferedInStream = new BufferedInputStream(confOpenStream);
			FileOutputStream out = new FileOutputStream(destinationFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = confBufferedInStream.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			confOpenStream.close();
			out.close();
		} catch (IOException e) {
			log.error(e);
		}
	}

	public static String getMetaDataPath() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath location = root.getLocation();
		String metadataPath = location.toOSString() + File.separator + ".metadata";
		return metadataPath;
	}

    public void unDeployCAR(String serverURL, String username, String pwd, String carName, String serverType)
            throws Exception {
        if (serverType == null || "ei".equals(serverType)) {
            unDeployCAR(serverURL, username, pwd, carName);
        } else if ("mi".equals(serverType)) {
            String accessToken = getAccessToken(serverURL, username, pwd);
            if (accessToken != null) {
                undeployCAppFromMI(serverURL, carName, accessToken);
            }
        }
    }

    private void undeployCAppFromMI(String apiUrl, String carFileName, String token) throws Exception {
        String apiURL = apiUrl.endsWith("/") ? apiUrl.concat(MI_CAPP_RESOURCE)
                : apiUrl.concat("/").concat(MI_CAPP_RESOURCE);
        String deleteURL = apiURL.concat("/").concat(carFileName);
        HttpsURLConnection connection = (HttpsURLConnection) new URL(deleteURL).openConnection();
        connection.setDoOutput(true);
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Authorization", "Bearer ".concat(token));
        connection.setHostnameVerifier(getHostnameVerifier());
        connection.setRequestMethod("DELETE");
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Error occurred while deleting the CAPP from MI");
        }
    }
	/**
	 * This method is used to remove car files from your carbon server instances
	 * and from tanent in the cloud platform.
	 * 
	 * @param serverURL
	 *            Server instance URI or the tanent url
	 * @param username
	 *            Username
	 * @param pwd
	 *            Password
	 * @param carName
	 *            Car file name without extension.
	 * @throws Exception
	 */
	public static void unDeployCAR(String serverURL, String username, String pwd, String carName) throws Exception {
		ApplicationAdminStub appAdminStub = getApplicationAdminStub(serverURL, username, pwd);
		try {
			appAdminStub.deleteApplication(carName);
		} catch (Exception e) {
			log.error(e);
		}
	}

	private static ApplicationAdminStub getApplicationAdminStub(String serverURL, String username, String pwd)
	                                                                                                          throws Exception,
	                                                                                                          AxisFault,
	                                                                                                          MalformedURLException {
		String sessionCookie = CarbonServerUtils.createSessionCookie(serverURL, username, pwd);
		ApplicationAdminStub appAdminStub =
		                                    new ApplicationAdminStub(CarbonServerUtils.getURL(serverURL) + "/" +
		                                                             CarbonServerUtils.getServicePath() +
		                                                             "/ApplicationAdmin");
		SSLUtils.setSSLProtocolHandler(appAdminStub);
		appAdminStub._getServiceClient().getOptions().setManageSession(true);
		appAdminStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return appAdminStub;
	}
}
