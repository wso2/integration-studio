package org.wso2.developerstudio.eclipse.registry.base.core;

import javax.net.ssl.X509TrustManager;

public class TrustEverythingTrustManager implements X509TrustManager {
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {   }

    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {   }
}