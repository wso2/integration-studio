package org.wso2.developerstudio.eclipse.artifact.bpel.utils;

import org.eclipse.osgi.util.NLS;


public class BPELMessageConstants extends NLS {
	
	public static final String BUNDLE_NAME="org.wso2.developerstudio.eclipse.artifact.bpel.utils.bpelmessageconstants";
	
	public static String ERROR_UPDATING_SERVICE_XML;
	public static String ERROR_PARSING_SERVICE_XML;
	public static String ERROR_PROCESSING_SERVICE_XML;
	public static String IO_EXCEPTION_PARSING_SERVICE_XML;
	public static String ERROR_TRANSFORMING_XML;
	
	
	static{
		NLS.initializeMessages(BUNDLE_NAME, BPELMessageConstants.class);
	}

	public BPELMessageConstants(){
	}

}
