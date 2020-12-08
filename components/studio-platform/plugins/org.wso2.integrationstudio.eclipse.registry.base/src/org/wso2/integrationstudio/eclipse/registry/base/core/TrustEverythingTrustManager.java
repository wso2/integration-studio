/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
/**
 * This trust manager is written to prevent requiring a trust store on remote registry connections 
 * using abdera client.
 */
package org.wso2.integrationstudio.eclipse.registry.base.core;

import javax.net.ssl.X509TrustManager;

public class TrustEverythingTrustManager implements X509TrustManager {
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {   }

    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {   }
}