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

package org.wso2.developerstudio.eclipse.capp.core.data;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ISettingsAttribute;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ISettingsData;

public class SettingsData implements ISettingsData {

	private List<ISettingsAttribute> settingsAttributes;
	private List<ISettingsData> childSettings;
	private String name;
	private String value;
	
	public SettingsData(String name) {
	    this.name=name;
    }
	
	public void addChildSettings(ISettingsData settingsData) {
		if (!getChildSettings().contains(settingsData)){
			getChildSettings().add(settingsData);
		}
	}

	public void addSettingsAttribute(ISettingsAttribute settingsAttribute) {
		if (!getAttributes().contains(settingsAttribute)){
			getAttributes().add(settingsAttribute);
		}
	}

	public List<ISettingsAttribute> getAttributes() {
		if (settingsAttributes==null){
			settingsAttributes=new ArrayList<ISettingsAttribute>();
		}
		return settingsAttributes;
	}

	public List<ISettingsData> getChildSettings() {
		if (childSettings==null){
			childSettings=new ArrayList<ISettingsData>();
		}
		return childSettings;
	}

	public ISettingsData getChildSettings(String childSettingName) {
		for(ISettingsData settingsData:getChildSettings()){
			if (settingsData.getSettingsName().equals(childSettingName)){
				return settingsData;
			}
		}
		return null;
	}

	public ISettingsAttribute getSettingsAttribute(String settingsAttributeName) {
		for(ISettingsAttribute settingsAttribute:getAttributes()){
			if (settingsAttribute.getAttributeName().equals(settingsAttributeName)){
				return settingsAttribute;
			}
		}
		return null;
	}

	public String getSettingsName() {
		return name;
	}

	public void removeChildSettings(ISettingsData settingsData) {
		if (getChildSettings().contains(settingsData)){
			getChildSettings().remove(settingsData);
		}
	}

	public void removeSettingsAttribute(ISettingsAttribute settingsAttribute) {
		if (getAttributes().contains(settingsAttribute)){
			getAttributes().remove(settingsAttribute);
		}
	}

    public String getSettingsValue() {
	    return value;
    }

    public void setSettingsValue(String value) {
    	this.value=value;
    }

    public List<ISettingsData> getAllChildSettings(String childSettingName) {
    	List<ISettingsData> result=new ArrayList<ISettingsData>();
		for(ISettingsData settingsData:getChildSettings()){
			if (settingsData.getSettingsName().equals(childSettingName)){
				result.add(settingsData);
			}
		}
		return result;
    }

    public List<ISettingsData> getAllChildSettings(String childSettingName,
                                             ISettingsAttribute[] attributes) {
    	List<ISettingsData> result=new ArrayList<ISettingsData>();
    	List<ISettingsData> allChildSettings = getAllChildSettings(childSettingName);
    	for (ISettingsData data : allChildSettings) {
	        boolean valid=true;
	        for(ISettingsAttribute attribute:attributes){
	        	ISettingsAttribute settingsAttribute = data.getSettingsAttribute(attribute.getAttributeName());
	        	if (settingsAttribute==null || !settingsAttribute.getAttributeValue().equals(attribute.getAttributeValue())){
	        		valid=false;
	        	}
	        }
	        if (valid){
	        	result.add(data);
	        }
        }
	    return result;
    }

}
