package org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeBulkResolver;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class BulkMediaTypeFileNameResolver extends
		AbstractFileNameExtensionMediaTypeResolver implements
		IMediaTypeBulkResolver {
	CustomMediaTypeData currentMediaTypeData;

	public Object[] getAllMediaTypeData() {
		return BulkMediaTypes.getBulkMediaTypes();
	}

	public String getDefaultExtension() {
		return getExtensions().size()>0? getExtensions().get(0):null;
	}

	public List<String> getExtensions() {
		return Arrays.asList(currentMediaTypeData.getExtensions());
	}

	public String getMediaType() {
		return currentMediaTypeData.getMediaType();
	}

	public int getPriority() {
		return currentMediaTypeData.getPriority();
	}

	public boolean isMediaType(InputStream dataStream) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("InputStream media type resolution is not supported in this mediatype resolver");
	}

	public boolean isMediaType(String fileName){
		String[] extensions = currentMediaTypeData.getExtensions();
		for (String extension : extensions) {
			if (hasExtension(fileName, extension)){
				return true;
			}	
		}
		return false;
	}

	public void setMediaTypeData(Object mediaTypeData) {
		currentMediaTypeData=(CustomMediaTypeData) mediaTypeData;
	}

	public boolean isFileNameValidateSupported() {
		return true;
	}

	public boolean isInputStreamValidateSupported() {
		return false;
	}

}
