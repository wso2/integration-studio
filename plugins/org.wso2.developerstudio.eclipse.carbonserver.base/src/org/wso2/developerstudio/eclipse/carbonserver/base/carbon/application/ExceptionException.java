/**
 * ExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v2 Built on : Sep 04, 2010 (05:02:54
 * UTC)
 */

package org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application;

public class ExceptionException extends java.lang.Exception {

	private static final long serialVersionUID = 1307590314561L;

	private org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE faultMessage;

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

	public void setFaultMessage(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE msg) {
		faultMessage = msg;
	}

	public org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE getFaultMessage() {
		return faultMessage;
	}
}
