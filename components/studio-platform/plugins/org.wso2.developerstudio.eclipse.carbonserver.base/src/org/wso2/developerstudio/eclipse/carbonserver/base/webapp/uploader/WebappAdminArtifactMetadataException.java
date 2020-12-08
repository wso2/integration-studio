/**
 * WebappAdminArtifactMetadataException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v10 Built on : Sep 04, 2013 (02:02:54
 * UTC)
 */

package org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader;

public class WebappAdminArtifactMetadataException extends java.lang.Exception {

	private static final long serialVersionUID = 1432114439142L;

	private org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub.WebappAdminArtifactMetadataException faultMessage;

	public WebappAdminArtifactMetadataException() {
		super("WebappAdminArtifactMetadataException");
	}

	public WebappAdminArtifactMetadataException(java.lang.String s) {
		super(s);
	}

	public WebappAdminArtifactMetadataException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public WebappAdminArtifactMetadataException(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub.WebappAdminArtifactMetadataException msg) {
		faultMessage = msg;
	}

	public org.wso2.developerstudio.eclipse.carbonserver.base.webapp.uploader.WebappAdminStub.WebappAdminArtifactMetadataException getFaultMessage() {
		return faultMessage;
	}
}
