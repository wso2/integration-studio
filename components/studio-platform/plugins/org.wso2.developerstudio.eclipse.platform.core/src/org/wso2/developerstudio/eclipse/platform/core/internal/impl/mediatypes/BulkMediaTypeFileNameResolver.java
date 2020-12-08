/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeBulkResolver;
import org.wso2.developerstudio.eclipse.platform.core.mediatype.AbstractFileNameExtensionMediaTypeResolver;

public class BulkMediaTypeFileNameResolver extends AbstractFileNameExtensionMediaTypeResolver implements
                                                                                             IMediaTypeBulkResolver {
	CustomMediaTypeData currentMediaTypeData;

	public Object[] getAllMediaTypeData() {
		return BulkMediaTypes.getBulkMediaTypes();
	}

	public String getDefaultExtension() {
		return getExtensions().size() > 0 ? getExtensions().get(0) : null;
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

	public boolean isMediaType(InputStream dataStream) throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
		                                        "InputStream media type resolution is not supported in this mediatype resolver");
	}

	public boolean isMediaType(String fileName) {
		String[] extensions = currentMediaTypeData.getExtensions();
		for (String extension : extensions) {
			if (hasExtension(fileName, extension)) {
				return true;
			}
		}
		return false;
	}

	public void setMediaTypeData(Object mediaTypeData) {
		currentMediaTypeData = (CustomMediaTypeData) mediaTypeData;
	}

	public boolean isFileNameValidateSupported() {
		return true;
	}

	public boolean isInputStreamValidateSupported() {
		return false;
	}

}
