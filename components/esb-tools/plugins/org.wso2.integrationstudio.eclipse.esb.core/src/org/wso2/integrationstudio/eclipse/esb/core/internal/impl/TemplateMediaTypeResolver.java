package org.wso2.integrationstudio.eclipse.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.integrationstudio.eclipse.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class TemplateMediaTypeResolver extends AbstractXmlDocMediaTypeResolver {

	public TemplateMediaTypeResolver() {
	}

	public boolean isMediaType(InputStream dataStream) {
		String tagName = "template";
		return isDocumentTag(dataStream, tagName);
	}

}
