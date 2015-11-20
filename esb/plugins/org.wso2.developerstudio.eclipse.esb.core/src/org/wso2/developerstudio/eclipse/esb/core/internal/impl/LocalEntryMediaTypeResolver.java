package org.wso2.developerstudio.eclipse.esb.core.internal.impl;

import java.io.InputStream;

import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractXmlDocMediaTypeResolver;

public class LocalEntryMediaTypeResolver extends AbstractXmlDocMediaTypeResolver {
	
	public LocalEntryMediaTypeResolver() {
		
	}

	@Override
	public boolean isMediaType(InputStream dataStream) {
		String tagName = "localEntry";
		return isDocumentTag(dataStream, tagName);
	}
	

}
