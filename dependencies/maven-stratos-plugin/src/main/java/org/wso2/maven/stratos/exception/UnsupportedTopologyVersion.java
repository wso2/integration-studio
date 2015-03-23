package org.wso2.maven.stratos.exception;

public class UnsupportedTopologyVersion extends Exception {

	private static final long serialVersionUID = 2939423784082276800L;
	private String unsupportedVersion;
	
	public UnsupportedTopologyVersion(String unsupportedVersion) {
		super("Unsupported topology version: "+unsupportedVersion);
		setUnsupportedVersion(unsupportedVersion);
	}

	public void setUnsupportedVersion(String unsupportedVersion) {
		this.unsupportedVersion = unsupportedVersion;
	}

	public String getUnsupportedVersion() {
		return unsupportedVersion;
	}
}
