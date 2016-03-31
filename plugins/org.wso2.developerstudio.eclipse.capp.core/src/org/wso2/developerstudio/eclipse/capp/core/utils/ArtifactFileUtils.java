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

package org.wso2.developerstudio.eclipse.capp.core.utils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArtifactFileUtils {

	//file select options
	public static final int ERROR_OPTION=0;
	public static final int OPTION_TEMPLATE=1;
	public static final int OPTION_NEW = 2;
	public static final int OPTION_IMPORT_FS = 3;
	public static final int OPTION_IMPORT_REG = 4;
	public static final int OPTION_IMPORT_RESOURCE_FROM_FS = 5;
	public static final int OPTION_IMPORT_COLLECTION_FROM_FS = 6;
	public static final int OPTION_SPLIT_SYNAPSE = 7;
	public static final int OPTION_IMPORT_WS = 8;
	
	//endpoint types
	public static final int ADDRESS_EP = 10;
	public static final int WSDL_EP = 11;
	public static final int FO_EP = 12;
	public static final int LB_EP = 13;
	public static final int DEFAULT_EP = 14;
	
	//proxy types
	public static final int PASS_THROUGH_PROXY = 20;
	public static final int SECURE_PROXY = 21;
	public static final int WSDL_PROXY = 22;
	public static final int LOG_FORWARD_PROXY = 23;
	public static final int TRANSFORMER_PROXY = 24;
	public static final int CUSTOM_PROXY = 25;
	
	//new local entry types
	public static final int IN_LINE_TEXT = 30;
	public static final int IN_LINE_XML = 31;
	
	//local entry source types
	public static final int OPTION_SOURCE_URL = 32;
	
	
    public static boolean isSpecialCharactersExist(String str){
    	Pattern p = Pattern.compile("[^a-zA-Z0-9_-]");
    	Matcher m = p.matcher(str);
    	String test = m.replaceAll("%");
    	if(test.contains("%")){
    		return true;
    	}else{
    		return false;
    		
    	}
    }
    
    public static String getFileNameWithoutExtension(String filePath){
		StringBuffer sb = new StringBuffer();
		String[] fileInfo = filePath.split(Pattern.quote(File.separator));
//		if(fileInfo[fileInfo.length - 1].contains("\\.")){
		String[] splitByPeriod = fileInfo[fileInfo.length - 1].split("\\.");
		for (int i=0; i< splitByPeriod.length -1 ; i++) {
			sb.append(splitByPeriod[i]);
		}
		
		return sb.toString();
		
    }

}
