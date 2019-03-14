/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.cloud.util;

import org.apache.http.cookie.Cookie;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.developerstudio.eclipse.esb.cloud.model.UserSession;

/**
 * Manages the sessions. In this scenario, we will always maintain only one session
 *
 */
public class UserSessionManager {
    private static UserSession session;
    private static IntegrationCloudServiceClient client;

    private UserSessionManager() {

    }

    public static void createSession(String username, Cookie cookie) {
        session = new UserSession(username, cookie);
    }

    public static UserSession getCurrentSession() throws NetworkUnavailableException, HttpClientException {
        // check if session is active
        try {
            if (null == client) {
                client = IntegrationCloudServiceClient.getInstance();
            }
            // To check if the token is valid, we call this endpoint
            // If it returns unauthorized, it is considered as an expired token
            // This method will throw an InvalidTokenException if the user token is invalid
            client.getApplicationList();
            return session;
        } catch (CloudDeploymentException | InvalidTokenException e) {
            // When user token is invalid
            return null;
        }
    }
}
