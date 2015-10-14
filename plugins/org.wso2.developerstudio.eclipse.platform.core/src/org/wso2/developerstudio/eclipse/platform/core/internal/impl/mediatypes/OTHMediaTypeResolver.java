package org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes;

import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class OTHMediaTypeResolver extends AbstractFileNameExtensionMediaTypeResolver {

	public boolean isMediaType(String fileName) {
		return hasExtension(fileName,"oth");
	}

}
