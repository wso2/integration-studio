package org.wso2.developerstudio.eclipse.platform.core.interfaces;

import java.io.InputStream;

public interface IMediaTypeFromStreamResolver extends IMediaTypeResolver {
	public boolean isMediaType(InputStream dataStream);
}
