/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.wso2plugin.sample.ui.wizard;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.wso2.developerstudio.eclipse.wso2plugin.sample.ui.elements.WSO2PluginElementList;

public class PluginContentProvider extends ArrayContentProvider {

	private static PluginContentProvider instance;

	public static PluginContentProvider getInstance() {
		synchronized (ArrayContentProvider.class) {
			if (instance == null) {
				instance = new PluginContentProvider();
			}
			return instance;
		}
	}

	/**
	 * Returns the elements in the input, which must be either an array or a
	 * <code>Collection</code>.
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof WSO2PluginElementList) {
			return (Object[]) ((WSO2PluginElementList) inputElement)
					.getChildren();
		}

		return new Object[0];
	}
}
