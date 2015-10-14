package org.wso2.developerstudio.eclipse.platform.core.interfaces;

import java.io.InputStream;
import java.util.List;

public interface IMediaTypeBulkResolver extends IMediaTypeResolver{
	public boolean isInputStreamValidateSupported();
	public boolean isMediaType(InputStream dataStream) throws UnsupportedOperationException;
	public boolean isFileNameValidateSupported();
	public boolean isMediaType(String fileName) throws UnsupportedOperationException;
	public Object[] getAllMediaTypeData();
	public void setMediaTypeData(Object mediaTypeData);
	public String getMediaType();
	public int getPriority();
	public List<String> getExtensions();
	public String getDefaultExtension();
}
