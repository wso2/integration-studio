package org.wso2.integrationstudio.registry.core.internal.impl.mediatypes;

import org.wso2.integrationstudio.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class GARMediaTypeResolver extends AbstractFileNameExtensionMediaTypeResolver {

	public boolean isMediaType(String fileName) {
		return hasExtension(fileName,"gar");
	}

}
