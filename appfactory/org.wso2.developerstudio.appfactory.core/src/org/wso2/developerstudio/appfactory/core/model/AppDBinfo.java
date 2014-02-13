/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.core.model;

import java.util.List;
import java.util.Map;

public class AppDBinfo {
	
private List<Map<String,String>> dbs;

private List<String>usr;
private List<String>templates;


public List<Map<String, String>> getDbs() {
	return dbs;
}

public void setDbs(List<Map<String,String>> dbs) {
	this.dbs = dbs;
}

public String getUsr1() {
	String value ="";
	 if("".equals(value)){
		 for (String name : usr) {
			 if(value!=null){
			 value = value +" , "+name;
			 }else{
				 value =name;
			 }
		}
	}
	return value;
}

public void setUsr(List<String> usr) {
	this.usr = usr;
}

public String getTemplates1() {
	String value ="";
	if(templates!=null){
		 for (String name : templates) {
			 if("".equals(value)){
			 value = value +" , "+name;
			 }else{
				 value =name;
			 }
		}
	}
	return value;
}

public List<String> getUsr() {
	return usr;
}

public List<String> getTemplates() {
	return templates;
}

public void setTemplates(List<String> templates) {
	this.templates = templates;
}

}
