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

package org.wso2.developerstudio.eclipse.platform.core.model;

import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

import java.util.List;

public abstract class AbstractListDataProvider {
	public abstract List<ListData> getListData(String modelProperty, ProjectDataModel model);

	protected ListData createListData(String caption, Object data) {
		return new ListData(caption, data);
	}

	public static class ListData {
		private String caption;
		private Object data;

		public ListData(String caption, Object data) {
			setCaption(caption);
			setData(data);
		}

		public void setCaption(String caption) {
			this.caption = caption;
		}

		public String getCaption() {
			return caption;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public boolean equals(Object data) {
			if (data == getData()) {
				return true;
			} else if (data == null) {
				return false;
			} else if (getData() == null) {
				return false;
			} else {
				return data.toString().equals(getData().toString());
			}
		}
	}
}
