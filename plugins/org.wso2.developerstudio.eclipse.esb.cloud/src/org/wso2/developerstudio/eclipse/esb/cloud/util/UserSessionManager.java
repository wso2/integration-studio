package org.wso2.developerstudio.eclipse.esb.cloud.util;

import org.apache.http.cookie.Cookie;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.model.UserSession;

public class UserSessionManager {
    private static UserSession session;
    private static IntegrationCloudServiceClient client;
    
    private UserSessionManager() {
        
    }
    
    public static void createSession(String username, Cookie cookie) {
        session = new UserSession(username, cookie);
    }
    
    public static UserSession getCurrentSession() {
        // check if session is active
        
        return session;
    }
}
