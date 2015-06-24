/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.esb.project.connector.store;

public class Attributes {
	private String overview_name;
	private String overview_version;
	private String overview_downloadlink;
	private String images_thumbnail;

	public String getImages_thumbnail() {
		return images_thumbnail;
	}

	public void setImages_thumbnail(String images_thumbnail) {
		this.images_thumbnail = images_thumbnail;
	}

	public String getOverview_name() {
		return overview_name;
	}

	public void setOverview_name(String overview_name) {
		this.overview_name = overview_name;
	}

	public String getOverview_version() {
		return overview_version;
	}

	public void setOverview_version(String overview_version) {
		this.overview_version = overview_version;
	}

	public String getOverview_downloadlink() {
		return overview_downloadlink;
	}

	public void setOverview_downloadlink(String overview_downloadlink) {
		this.overview_downloadlink = overview_downloadlink;
	}

}
