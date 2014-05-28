package org.wso2.developerstudio.datamapper.diagram.custom.persistence;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.wso2.developerstudio.datamapper.diagram.custom.persistence.messages"; //$NON-NLS-1$
	public static String JsonToAvroSchemaTransformer_errorParsingJsonInput;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
