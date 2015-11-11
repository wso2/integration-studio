/**
 * AuthenticationExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1 Built on : Apr 27, 2010 (12:11:11
 * UTC)
 */

package org.wso2.developerstudio.eclipse.carbonserver.base.authentication;

public class AuthenticationExceptionException extends java.lang.Exception {

	private static final long serialVersionUID = 1283846904326L;

	private org.wso2.developerstudio.eclipse.carbonserver.base.authentication.AuthenticationAdminStub.AuthenticationExceptionE faultMessage;

	public AuthenticationExceptionException() {
		super("AuthenticationExceptionException");
	}

	public AuthenticationExceptionException(java.lang.String s) {
		super(s);
	}

	public AuthenticationExceptionException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public AuthenticationExceptionException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(org.wso2.developerstudio.eclipse.carbonserver.base.authentication.AuthenticationAdminStub.AuthenticationExceptionE msg) {
		faultMessage = msg;
	}

	public org.wso2.developerstudio.eclipse.carbonserver.base.authentication.AuthenticationAdminStub.AuthenticationExceptionE getFaultMessage() {
		return faultMessage;
	}
}
