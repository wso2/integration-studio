package org.wso2.maven.axis2;

import java.net.URL;

public class NamespacePackage {
	
    /**
     * Specify the namespaces 
     * 
     * @parameter
     * @required
     */private URL namespaces;
	
     /**
      * Specify a custom package name for the given namespaces
      * 
      * @parameter
      * @required
      */private String packageName;

	public void setNamespaces(URL namespaces) {
		this.namespaces = namespaces;
	}

	public URL getNamespaces() {
		return namespaces;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}
}
