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

public interface IDeveloperStudioProviderData {
	/**
	 * Get the id for this provider
	 * 
	 * @return
	 */
	public String getId();

	/**
	 * Get the name of this provider
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * get the provider
	 * 
	 * @return
	 */
	public IDeveloperStudioProvider getProvider();

	/**
	 * Get list displayable text
	 * 
	 * @return
	 */
	public String getText();
}
