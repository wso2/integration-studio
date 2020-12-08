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

public class CustomMediaTypeData {
	private String mediaType;
	private String[] extensions;
	private int priority;
	private String name;

	public CustomMediaTypeData(String mediaType, String value) {
		String[] split = value.split("\\|");
		setMediaType(mediaType);
		setName(split[0]);
		setPriority(Integer.parseInt(split[1]));
		setExtensions(split[2].split(","));
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setExtensions(String[] extensions) {
		this.extensions = extensions;
	}

	public String[] getExtensions() {
		return extensions;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
