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

package org.wso2.developerstudio.eclipse.platform.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeResolver;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IMediaTypeResolverProvider;
import org.wso2.developerstudio.eclipse.platform.core.internal.impl.MediaTypeResolverProviderImpl;

public class CSMediaUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static String MEDIA_TYPE_EXTENSION = "org.wso2.developerstudio.eclipse.platform.core.mediatype";
	private static List<IMediaTypeResolverProvider> mediaTypeResolverList;

	public static IMediaTypeResolverProvider[] getMediaTypeResolver() {
		return mediaTypeResolverList.toArray(new IMediaTypeResolverProvider[] {});
	}

	static {
		mediaTypeResolverList = new ArrayList<IMediaTypeResolverProvider>();
		IConfigurationElement[] config =
		                                 Platform.getExtensionRegistry()
		                                         .getConfigurationElementsFor(MEDIA_TYPE_EXTENSION);
		for (IConfigurationElement e : config) {
			try {
				MediaTypeResolverProviderImpl providers = new MediaTypeResolverProviderImpl();
				providers.setId(e.getAttribute("id"));
				providers.setMediaType(e.getAttribute("mediaType"));
				String extensions = e.getAttribute("extensions");
				if (extensions != null && !extensions.trim().equals("")) {
					providers.addExtensions(extensions.split(","));
				}
				providers.setMediaTypeResolver((IMediaTypeResolver) e.createExecutableExtension("class"));
				String priority = e.getAttribute("priority");
				if (priority != null && !priority.trim().equals("")) {
					try {
						providers.setPriority(Integer.parseInt(priority));
					} catch (Exception e1) {
						log.error("The priority value is invalid for provider " + providers.getId(), e1);
					}
				}
				mediaTypeResolverList.add(providers);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		}
	}
}
