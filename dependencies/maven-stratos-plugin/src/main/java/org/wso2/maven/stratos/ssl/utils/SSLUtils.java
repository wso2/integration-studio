package org.wso2.maven.stratos.ssl.utils;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import org.apache.axis2.client.Stub;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.wso2.maven.stratos.ssl.CustomSSLProtocolSocketFactory;
import org.wso2.maven.stratos.ssl.CustomTrustAllTrustManager;

/**
 * Contains utilities to manage SSL related operations
 *
 */
public class SSLUtils {
	
	private static SSLContext sslCtx;
	
	/**
	 * Set the custom trust manager as the ssl protocol handler for the stub
	 * @param stub
	 * @throws Exception
	 */
	public static void setSSLProtocolHandler(Stub stub) throws Exception{
		init();
		stub._getServiceClient().getOptions().setProperty(HTTPConstants.CUSTOM_PROTOCOL_HANDLER,
		          new Protocol("https",(ProtocolSocketFactory)new CustomSSLProtocolSocketFactory(sslCtx),443));
	}

	/**
	 * Initialize the ssl context with the custom trust manager 
	 *   1. setup https access to the created ssl context
	 *   2. setup hostname verifier
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static void init() throws NoSuchAlgorithmException,
			KeyManagementException {
		if (sslCtx==null) {
			sslCtx = SSLContext.getInstance("SSL");
			sslCtx.init(null,new TrustManager[] { getCustomTrustManager() }, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(sslCtx.getSocketFactory());
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		}
	}

	/**
	 * Return customized trust manager
	 * @return
	 */
	private static TrustManager getCustomTrustManager() {
		return new CustomTrustAllTrustManager();
	}
}
