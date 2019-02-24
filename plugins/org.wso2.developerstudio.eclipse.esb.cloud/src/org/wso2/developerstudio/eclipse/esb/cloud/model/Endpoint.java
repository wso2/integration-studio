package org.wso2.developerstudio.eclipse.esb.cloud.model;

public class Endpoint {
    private String name;
    private String wsdl;
    private String url;
    private String context;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWsdl() {
        return wsdl;
    }
    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((context == null) ? 0 : context.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        result = prime * result + ((wsdl == null) ? 0 : wsdl.hashCode());
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
        Endpoint other = (Endpoint) obj;
        if (context == null) {
            if (other.context != null)
                return false;
        } else if (!context.equals(other.context))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        if (wsdl == null) {
            if (other.wsdl != null)
                return false;
        } else if (!wsdl.equals(other.wsdl))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Endpoint [name=" + name + ", wsdl=" + wsdl + ", url=" + url + ", context=" + context + "]";
    }
    
    
}
