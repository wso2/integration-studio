/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.templates.dashboard.web.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;

public class DashboardCategory {
    
    private String name;
    private ImageDescriptor icon;
    private List<DashboardLink> wizards = new ArrayList<DashboardLink>();
    private boolean showTitle;
    private int priority = Integer.MAX_VALUE;
    private String iconAbsoluteURL;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setIcon(ImageDescriptor icon) {
		this.icon = icon;
	}

	public ImageDescriptor getIcon() {
		return icon;
	}

	public List<DashboardLink> getWizards() {
		return wizards;
	}

	public void setShowTitle(boolean showTitle) {
		this.showTitle = showTitle;
	}

	public boolean isShowTitle() {
		return showTitle;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return name + " [" + priority + " ]";
	}

	public String toJson() {
		String links = "[";
		Iterator<DashboardLink> wizardIterator = wizards.iterator();
		while (wizardIterator.hasNext()) {
			DashboardLink next = wizardIterator.next();
			links += next.toJson();
			if (wizardIterator.hasNext()) {
				links += ", ";
			}
		}
		links += "]";
		return "{ \"name\": \"" + name + "\", \"iconURL\":\"" + iconAbsoluteURL + "\", \"wizards\": " + links + "}";
	}

	public String getIconAbsoluteURL() {
		return iconAbsoluteURL;
	}

	public void setIconAbsoluteURL(String iconAbsoluteURL) {
		this.iconAbsoluteURL = iconAbsoluteURL;
	}

}
