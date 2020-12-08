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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class BulkMediaTypes {
	private static final String BUNDLE_NAME =
	                                          "org.wso2.developerstudio.eclipse.platform.core.internal.impl.mediatypes.mediaTypes";
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	private static List<CustomMediaTypeData> bulkMediaTypes;

	static {
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
		bulkMediaTypes = new ArrayList<CustomMediaTypeData>();
		Enumeration<String> keys = RESOURCE_BUNDLE.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = RESOURCE_BUNDLE.getString(key);
			bulkMediaTypes.add(new CustomMediaTypeData(key, value));
		}
	}

	public static CustomMediaTypeData[] getBulkMediaTypes() {
		return bulkMediaTypes.toArray(new CustomMediaTypeData[] {});
	}
}
