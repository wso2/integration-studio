package org.wso2.integrationstudio.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.integrationstudio.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class SmooksMediaTypeResolver extends AbstractXmlDocMediaTypeResolver{

	public boolean isMediaType(InputStream dataStream) {
		String tagName = "smooks-resource-list";
		return isDocumentTag(dataStream, tagName);
	}

}
