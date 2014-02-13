package org.wso2.developerstudio.eclipse.platform.core.mediatype;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeFromFileNameResolver;

public abstract class AbstractFileNameExtensionMediaTypeResolver  implements IMediaTypeFromFileNameResolver{
	protected boolean hasExtension(String fileName, String extension){
		if (!extension.startsWith(".")){
			extension="."+extension;
		}
		return fileName.toLowerCase().endsWith(extension);
	}
}
