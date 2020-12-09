package org.wso2.integrationstudio.eclipse.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.integrationstudio.eclipse.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class SequenceMediaTypeResolver extends AbstractXmlDocMediaTypeResolver{

	public SequenceMediaTypeResolver() {
	}

	public boolean isMediaType(InputStream dataStream) {
		String tagName = "sequence";
		return isDocumentTag(dataStream, tagName);
	}

}
