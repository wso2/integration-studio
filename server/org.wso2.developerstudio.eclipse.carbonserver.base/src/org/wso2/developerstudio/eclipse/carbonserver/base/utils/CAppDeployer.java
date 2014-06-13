package org.wso2.developerstudio.eclipse.carbonserver.base.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

import javax.activation.DataHandler;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub;
import org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadedFileItem;
import org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.ClientTrustStorePreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.utils.SSLUtils;

public class CAppDeployer {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private static IPreferencesService preferenceStore;
	
	/**
	 * This method is used to upload car files in to your carbon server instances and to a tanent in the cloud platform.
	 * @param username Username to access your server/tanent
	 * @param pwd Password to access your server/tanent
	 * @param url URL of the server/tanent
	 * @param carFile File reference to the actual Car File.
	 * @throws Exception
	 */
	public void deployCApp(String username, String pwd, String url, File carFile) throws Exception{
		CarbonAppUploaderStub carbonAppUploaderStub = getCarbonAppUploaderStub(username, pwd, url);
		UploadedFileItem uploadedFileItem = new UploadedFileItem();
		DataHandler param=new DataHandler(carFile.toURI().toURL());
		uploadedFileItem.setDataHandler(param);
		uploadedFileItem.setFileName(carFile.getName());
		uploadedFileItem.setFileType("jar");
		UploadedFileItem[] fileItems=new UploadedFileItem[]{uploadedFileItem};
		carbonAppUploaderStub.uploadApp(fileItems);
	}

	private CarbonAppUploaderStub getCarbonAppUploaderStub(String username,
			String pwd, String url) throws Exception, AxisFault,
			MalformedURLException {
		String sessionCookie = CarbonServerUtils.createSessionCookie(url, username, pwd);
		CarbonAppUploaderStub carbonAppUploaderStub = new CarbonAppUploaderStub(CarbonServerUtils.getURL(url) + "/services/CarbonAppUploader");
		SSLUtils.setSSLProtocolHandler(carbonAppUploaderStub);
		carbonAppUploaderStub._getServiceClient().getOptions().setManageSession(true);
		carbonAppUploaderStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return carbonAppUploaderStub;
	}
	
	static {
		preferenceStore = Platform.getPreferencesService();
		
		String clientTrustStoreLocation = preferenceStore
				.getString("org.wso2.developerstudio.eclipse.platform.ui",
						ClientTrustStorePreferencePage.TRUST_STORE_LOCATION,
						null, null);
		String clientTrustStoreType = preferenceStore.getString(
				"org.wso2.developerstudio.eclipse.platform.ui",
				ClientTrustStorePreferencePage.TRUST_STORE_TYPE, null, null);
		String clientTrustStorePassword = preferenceStore
				.getString("org.wso2.developerstudio.eclipse.platform.ui",
						ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD,
						null, null);

		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		if (clientTrustStoreLocation != null
				&& clientTrustStorePassword != null
				&& clientTrustStoreLocation.endsWith(".jks")
				&& !clientTrustStorePassword.equals("")) {
			System.setProperty("javax.net.ssl.trustStore",
					clientTrustStoreLocation);
			System.setProperty("javax.net.ssl.trustStorePassword",
					clientTrustStorePassword);
		} else {
			System.setProperty("javax.net.ssl.trustStore", getJKSPath());
			System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
		}
	}

	private static String getJKSPath() {
		extractFilesToLocation("resources/security",
				new File(getMetaDataPath()));
		String path = getMetaDataPath() + File.separator + "security"
				+ File.separator + "wso2carbon.jks";
		return path;
	}

	public static void extractFilesToLocation(String resourcePath,
			File destination) {
		URL resource = Activator.getDefault().getBundle().getResource(
				resourcePath);
		if (isResourceFolder(resource)) {
			Enumeration confFolder = Activator.getDefault().getBundle()
					.getEntryPaths(resourcePath);
			String[] filePath = resource.getFile().split("/");
			File newDestinationPath = new File(destination,
					filePath[filePath.length - 1]);
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
		File destinationFile = new File(destination,
				filePath[filePath.length - 1]);

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
	
	/**
	 * This method is used to remove car files from your carbon server instances and from tanent in the cloud platform.
	 * @param serverURL Server instance URI or the tanent url
	 * @param username Username
	 * @param pwd Password
	 * @param carName Car file name without extension.
	 * @throws Exception
	 */
	public static void unDeployCAR(String serverURL, String username, String pwd, String carName) throws Exception{
		ApplicationAdminStub appAdminStub = getApplicationAdminStub(serverURL, username, pwd);
		try{
            appAdminStub.deleteApplication(carName);
        }catch(Exception e){
        	log.error(e);
        }
	}

	private static ApplicationAdminStub getApplicationAdminStub(
			String serverURL, String username, String pwd) throws Exception,
			AxisFault, MalformedURLException {
		String sessionCookie = CarbonServerUtils.createSessionCookie(serverURL, username, pwd);
		ApplicationAdminStub appAdminStub = new ApplicationAdminStub(CarbonServerUtils.getURL(serverURL) + "/services/ApplicationAdmin");
		SSLUtils.setSSLProtocolHandler(appAdminStub);
		appAdminStub._getServiceClient().getOptions().setManageSession(true);
		appAdminStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return appAdminStub;
	}
}
