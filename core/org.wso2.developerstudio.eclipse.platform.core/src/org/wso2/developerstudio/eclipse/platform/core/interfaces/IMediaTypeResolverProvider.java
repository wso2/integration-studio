package org.wso2.developerstudio.eclipse.platform.core.interfaces;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;


public interface IMediaTypeResolverProvider {
	public String getId();
	public String getMediaType();
	public boolean isMediaType(File file);
	public boolean isMediaType(URL url);
	public boolean isMediaType(String fileName);
	public boolean isMediaType(InputStream dataStream);
	public int getPriority();
	public List<String> getExtensions();
	public String getDefaultExtension();
	public boolean isMultipleProviders();
	public Object[] getMutipleProviderData();
	public IMediaTypeResolverProvider getProvider(Object mutipleProviderData);
}
