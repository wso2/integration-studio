/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.utils.file;

import org.apache.commons.io.FileUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TempFileUtils {
	private static IDeveloperStudioLog log=Logger.getLog(org.wso2.developerstudio.eclipse.utils.Activator.PLUGIN_ID);
	
	private static List<File> tempFiles=new ArrayList<File>();

	/**
	 * This method will create a Temporary File in the given location by
	 * directory
	 * 
	 * @param prefix
	 *            - Prefix to be used
	 * @param suffix
	 *            - Suffix to be used
	 * @param directory
	 *            - Directory where the Temp file need to be created. If this is
	 *            null Temp File will be created in the default System Temp
	 *            location
	 * @return Temp File created. Null if the creation fails
	 */
	public static File createTempFile(String prefix, String suffix, File directory) {
		File tempFile = null;
        try {
	        tempFile = File.createTempFile(prefix, suffix, directory);
	        tempFile.deleteOnExit();
	        
	        if (!tempFiles.contains(tempFile) && !tempFiles.contains(tempFile.getParentFile())) {
	            tempFiles.add(tempFile);
            }
        } catch (IOException e) {
        	log.error("Failed to create the Temp file.", e);
        }
		return tempFile;
	}
	
	public static void cleanUp(){
		for (Iterator iterator = tempFiles.iterator(); iterator.hasNext();) {
	        File file = (File) iterator.next();
	        if(file.exists()){
				FileUtils.deleteQuietly(file);
			}
        }
	}

}
