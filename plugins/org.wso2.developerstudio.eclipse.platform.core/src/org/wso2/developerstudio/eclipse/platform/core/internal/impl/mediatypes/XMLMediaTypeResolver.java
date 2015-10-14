package org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes;

import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class XMLMediaTypeResolver extends AbstractFileNameExtensionMediaTypeResolver {

	public boolean isMediaType(String fileName) {
		return hasExtension(fileName,"xml");
	}

}
