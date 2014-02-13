package org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeResolver;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class XSLTMediaTypeResolver extends
		AbstractFileNameExtensionMediaTypeResolver implements
		IMediaTypeResolver {

	public boolean isMediaType(String fileName) {
		return hasExtension(fileName, "xslt");
	}

}
