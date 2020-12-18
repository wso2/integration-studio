package org.wso2.integrationstudio.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.integrationstudio.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class TemplateMediaTypeResolver extends AbstractXmlDocMediaTypeResolver {

	public TemplateMediaTypeResolver() {
	}

	public boolean isMediaType(InputStream dataStream) {
		String tagName = "template";
		return isDocumentTag(dataStream, tagName);
	}

}
