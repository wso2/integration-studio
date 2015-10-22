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
