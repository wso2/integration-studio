package org.wso2.integrationstudio.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.integrationstudio.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class SequenceMediaTypeResolver extends AbstractXmlDocMediaTypeResolver{

	public SequenceMediaTypeResolver() {
	}

	public boolean isMediaType(InputStream dataStream) {
		String tagName = "sequence";
		return isDocumentTag(dataStream, tagName);
	}

}
