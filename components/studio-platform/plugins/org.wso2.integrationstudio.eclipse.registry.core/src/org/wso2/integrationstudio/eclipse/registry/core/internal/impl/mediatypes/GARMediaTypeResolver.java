package org.wso2.integrationstudio.eclipse.registry.core.internal.impl.mediatypes;

import org.wso2.integrationstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class GARMediaTypeResolver extends AbstractFileNameExtensionMediaTypeResolver {

	public boolean isMediaType(String fileName) {
		return hasExtension(fileName,"gar");
	}

}
