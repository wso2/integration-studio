package org.wso2.developerstudio.eclipse.registry.core.internal.impl.mediatypes;

import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class GARMediaTypeResolver extends AbstractFileNameExtensionMediaTypeResolver {

	public boolean isMediaType(String fileName) {
		return hasExtension(fileName,"gar");
	}

}
