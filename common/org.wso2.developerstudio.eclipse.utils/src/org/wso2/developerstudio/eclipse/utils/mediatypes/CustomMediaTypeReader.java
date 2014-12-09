/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.utils.mediatypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.Activator;

public class CustomMediaTypeReader {	
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * method to read the custom media types set by the user
	 * @param regResource to find the media type
	 * @param mimeTypeFileLoc location of the media types configured by user
	 * @return media type
	 * @throws IOException throw in file does not exist
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })//return the map from here for the user
	public Map<String,String> customMimeTypes(String mimeTypeFileLoc) {	
		Map customMediaTypes = new HashMap<String, String>();	
		BufferedReader br = null;
		try {			
			br = new BufferedReader(new FileReader(mimeTypeFileLoc));
			String line;
			while ((line = br.readLine()) != null) {
				String[] mediaTypesTemp = line.split(",");// read file extension and media type
				customMediaTypes.put(mediaTypesTemp[0], mediaTypesTemp[1]);				
			}
		} catch (IOException e) {
			log.error("An IO exception occurred while reading for custom media type file");			
        } finally {
			try {
	            if( br != null) {
	            	br.close();	            	
	            }
            } catch (IOException e) {
	            log.error("An exception occurred while closing the reader for custom media type file reading");
            }
		}			
					
		return customMediaTypes;
	}

}