package org.wso2.developerstudio.eclipse.artifact.security.utils;

import org.eclipse.osgi.util.NLS;


public class SecurityFormMessageConstants extends NLS {
	
	public static final String BUNDLE_NAME="org.wso2.developerstudio.eclipse.artifact.security.utils.securityformmessageconstants.properties";
	
	public static String MESSAGE_FORM_LOAD_ERROR;
	public static String MESSAGE_POLICYFILE_READ_ERROR;
	public static String MESSAGE_PAGE_LOADING_ERROR;
	public static String MESSAGE_RAMPART_CONFIG_ERROR;
	public static String MESSAGE_SAVE_ERROR;
	public static String MESSAGE_LOAD_UI_ERROR;
	public static String MESSAGE_SERIALIZATION_SAVE_ERROR;
	public static String MESSAGE_UPDATE_SOURCE_ERROR;
	
	static{
		NLS.initializeMessages(BUNDLE_NAME, SecurityFormMessageConstants.class);
	}

	public SecurityFormMessageConstants(){
	}

}
