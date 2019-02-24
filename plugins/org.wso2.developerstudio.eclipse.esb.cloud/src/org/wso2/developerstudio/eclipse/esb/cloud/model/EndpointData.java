package org.wso2.developerstudio.eclipse.esb.cloud.model;

import java.util.List;

public class EndpointData {
    List<Endpoint> restEndpoints;
    List<Endpoint> soapEndpoints;
    List<Endpoint> webEndpoints;
    List<Endpoint> swaggerEndpoints;
    
    public List<Endpoint> getRestEndpoints() {
        return restEndpoints;
    }
    public void setRestEndpoints(List<Endpoint> restEndpoints) {
        this.restEndpoints = restEndpoints;
    }
    public List<Endpoint> getSoapEndpoints() {
        return soapEndpoints;
    }
    public void setSoapEndpoints(List<Endpoint> soapEndpoints) {
        this.soapEndpoints = soapEndpoints;
    }
    public List<Endpoint> getWebEndpoints() {
        return webEndpoints;
    }
    public void setWebEndpoints(List<Endpoint> webEndpoints) {
        this.webEndpoints = webEndpoints;
    }
    public List<Endpoint> getSwaggerEndpoints() {
        return swaggerEndpoints;
    }
    public void setSwaggerEndpoints(List<Endpoint> swaggerEndpoints) {
        this.swaggerEndpoints = swaggerEndpoints;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((restEndpoints == null) ? 0 : restEndpoints.hashCode());
        result = prime * result + ((soapEndpoints == null) ? 0 : soapEndpoints.hashCode());
        result = prime * result + ((swaggerEndpoints == null) ? 0 : swaggerEndpoints.hashCode());
        result = prime * result + ((webEndpoints == null) ? 0 : webEndpoints.hashCode());
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
        EndpointData other = (EndpointData) obj;
        if (restEndpoints == null) {
            if (other.restEndpoints != null)
                return false;
        } else if (!restEndpoints.equals(other.restEndpoints))
            return false;
        if (soapEndpoints == null) {
            if (other.soapEndpoints != null)
                return false;
        } else if (!soapEndpoints.equals(other.soapEndpoints))
            return false;
        if (swaggerEndpoints == null) {
            if (other.swaggerEndpoints != null)
                return false;
        } else if (!swaggerEndpoints.equals(other.swaggerEndpoints))
            return false;
        if (webEndpoints == null) {
            if (other.webEndpoints != null)
                return false;
        } else if (!webEndpoints.equals(other.webEndpoints))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "EndpointData [restEndpoints=" + restEndpoints + ", soapEndpoints=" + soapEndpoints + ", webEndpoints="
                + webEndpoints + ", swaggerEndpoints=" + swaggerEndpoints + "]";
    }
    
    
    
}
