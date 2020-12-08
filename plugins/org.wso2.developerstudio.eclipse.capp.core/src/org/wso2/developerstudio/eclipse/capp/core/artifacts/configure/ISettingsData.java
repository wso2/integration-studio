/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.capp.core.artifacts.configure;

import java.util.List;

public interface ISettingsData {
	public String getSettingsName();
	public List<ISettingsAttribute> getAttributes();
	public List<ISettingsData> getChildSettings();
	public void addSettingsAttribute(ISettingsAttribute settingsAttribute);
	public void removeSettingsAttribute(ISettingsAttribute settingsAttribute);
	public ISettingsAttribute getSettingsAttribute(String settingsAttributeName);
	public void addChildSettings(ISettingsData settingsData);
	public void removeChildSettings(ISettingsData settingsData);
	public ISettingsData getChildSettings(String childSettingName);
	public List<ISettingsData> getAllChildSettings(String childSettingName);
	public List<ISettingsData> getAllChildSettings(String childSettingName, ISettingsAttribute[] attributes);
	public String getSettingsValue();
	public void setSettingsValue(String value);
}
