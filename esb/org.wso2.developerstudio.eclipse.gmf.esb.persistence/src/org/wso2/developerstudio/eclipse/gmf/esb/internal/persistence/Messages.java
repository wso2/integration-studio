package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.messages"; //$NON-NLS-1$
	public static String BAMMediatorTransformer_Server_Profile_Name_Required_Error_Message;
	public static String BAMMediatorTransformer_Stream_Name_Required_Error_Message;
	public static String BAMMediatorTransformer_Stream_Version_Required_Error_Message;
	public static String OAuthMediatorTransformer_Password_Required_Error_Message;
	public static String OAuthMediatorTransformer_Remote_Server_Url_Required_Error_Message;
	public static String OAuthMediatorTransformer_Username_Required_Error_Message;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
