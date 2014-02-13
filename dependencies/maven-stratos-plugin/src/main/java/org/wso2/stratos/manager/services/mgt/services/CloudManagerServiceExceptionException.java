
/**
 * CloudManagerServiceExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Apr 27, 2010 (12:11:11 UTC)
 */

package org.wso2.stratos.manager.services.mgt.services;

public class CloudManagerServiceExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1309766631208L;
    
    private org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.CloudManagerServiceException faultMessage;

    
        public CloudManagerServiceExceptionException() {
            super("CloudManagerServiceExceptionException");
        }

        public CloudManagerServiceExceptionException(java.lang.String s) {
           super(s);
        }

        public CloudManagerServiceExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CloudManagerServiceExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.CloudManagerServiceException msg){
       faultMessage = msg;
    }
    
    public org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.CloudManagerServiceException getFaultMessage(){
       return faultMessage;
    }
}
    