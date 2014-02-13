package org.wso2.developerstudio.eclipse.artifact.dataservice.utils;

import org.eclipse.osgi.util.NLS;


public class DataServiceArtifactConstants extends NLS {

	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.dataservice.utils.dataserviceartifactconstants";
	
	//project wizard page properties
	public static String WIZARD_OPTION_PROJECT_NAME;
	public static String WIZARD_OPTION_SERVICE_NAME;
	public static String WIZARD_OPTION_SERVICE_GROUP;
	public static String WIZARD_OPTION_SERVICE_NS;
	public static String WIZARD_OPTION_SERVICE_DESCRIPTION;
	public static String WIZARD_OPTION_IMPORT_FILE;
	public static String WIZARD_OPTION_NEW_DSPROJECT;
	public static String WIZARD_OPTION_IMPORT_DSPROJECT;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DataServiceArtifactConstants.class);
	}
	
	public DataServiceArtifactConstants() {
		
	}
}
