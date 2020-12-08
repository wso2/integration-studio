
/**
 * ResourceServiceExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Apr 27, 2010 (12:11:11 UTC)
 */

package org.wso2.carbon.registry.resource.services;

public class ResourceServiceExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1283846076552L;
    
    private org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.ResourceServiceExceptionE faultMessage;

    
        public ResourceServiceExceptionException() {
            super("ResourceServiceExceptionException");
        }

        public ResourceServiceExceptionException(java.lang.String s) {
           super(s);
        }

        public ResourceServiceExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ResourceServiceExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.ResourceServiceExceptionE msg){
       faultMessage = msg;
    }
    
    public org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.ResourceServiceExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    