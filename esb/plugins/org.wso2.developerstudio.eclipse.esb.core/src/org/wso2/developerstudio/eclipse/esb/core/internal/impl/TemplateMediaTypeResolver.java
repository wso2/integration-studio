package org.wso2.developerstudio.eclipse.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class TemplateMediaTypeResolver extends AbstractXmlDocMediaTypeResolver {

	public TemplateMediaTypeResolver() {
	}

	public boolean isMediaType(InputStream dataStream) {
		String tagName = "template";
		return isDocumentTag(dataStream, tagName);
	}

}
