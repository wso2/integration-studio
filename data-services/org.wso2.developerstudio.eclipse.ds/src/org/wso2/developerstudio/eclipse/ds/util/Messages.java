package org.wso2.developerstudio.eclipse.ds.util;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.ds.util.messages"; //$NON-NLS-1$
	public static String DataServiceDeleteParticipant_ArtifactXmlDeleteChangeFailed;
	public static String DataServiceDeleteParticipant_DataServiceDelete;
	public static String DataServiceDeleteParticipant_DeleteWarning;
	public static String DataServiceRenameParticipant_ArtifactXmlRenameFailed;
	public static String DataServiceRenameParticipant_DataServiceChange;
	public static String DataServiceRenameParticipant_DataServiceRenameFailed;
	public static String DataServiceRenameParticipant_DuplicateFileName;
	public static String DataServiceRenameParticipant_EqualsToProjectName;
	public static String DataServiceRenameParticipant_InvalidResourceType;
	public static String DataServiceRenameParticipant_MetaDataChange;
	public static String DataServiceRenameParticipant_RenameWarning;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
