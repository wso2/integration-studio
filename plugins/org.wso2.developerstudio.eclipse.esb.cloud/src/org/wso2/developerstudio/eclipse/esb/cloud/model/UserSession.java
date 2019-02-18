package org.wso2.developerstudio.eclipse.esb.cloud.model;

import org.apache.http.cookie.Cookie;

public class UserSession {

    private String username;
    private Cookie cookie;
    
    public UserSession(String username, Cookie cookie) {
        super();
        this.username = username;
        this.cookie = cookie;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Cookie getCookie() {
        return cookie;
    }
    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cookie == null) ? 0 : cookie.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserSession other = (UserSession) obj;
        if (cookie == null) {
            if (other.cookie != null)
                return false;
        } else if (!cookie.equals(other.cookie))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
    
    
}
