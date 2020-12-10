
/**
 * ExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Apr 27, 2010 (12:11:11 UTC)
 */

package org.wso2.carbon.registry.resource.services;

public class ExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1283846076531L;
    
    private org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.ExceptionE faultMessage;

    
        public ExceptionException() {
            super("ExceptionException");
        }

        public ExceptionException(java.lang.String s) {
           super(s);
        }

        public ExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.ExceptionE msg){
       faultMessage = msg;
    }
    
    public org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.ExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    