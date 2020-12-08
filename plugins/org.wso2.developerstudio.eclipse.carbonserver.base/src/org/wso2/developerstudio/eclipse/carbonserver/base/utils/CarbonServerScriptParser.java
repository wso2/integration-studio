/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarbonServerScriptParser {
	private static final String OS_NAME_PROPERTY = "os.name";
	public static final String MIN_MEMORY_STRING = "-Xms";
	public static final String MAX_MEMORY_STRING = "-Xmx";
	public static final String MAX_PERM_SIZE_STRING = "-XX:MaxPermSize";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private String serverLocation;

	public CarbonServerScriptParser(String serverLocation) {
		this.serverLocation = serverLocation;
	}

	public Map<String, String> getVMParamaters() {
		File scriptFile = getScriptFile();
		Map<String, String> vmParams = new Hashtable<String, String>();

		try {
			FileReader fileReader = new FileReader(scriptFile);
			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();
			while (line != null) {
				if (line.contains(MIN_MEMORY_STRING)) {
					String[] array = line.split(" ");
					for (String string : array) {
						if (string.contains(MIN_MEMORY_STRING)) {
							vmParams.put(MIN_MEMORY_STRING, string.trim().substring(MIN_MEMORY_STRING.length()));
						}
					}
				}

				if (line.contains(MAX_MEMORY_STRING)) {
					String[] array = line.split(" ");
					for (String string : array) {
						if (string.contains(MAX_MEMORY_STRING)) {
							vmParams.put(MAX_MEMORY_STRING, string.trim().substring(MAX_MEMORY_STRING.length()));
						}
					}
				}

				if (line.contains(MAX_PERM_SIZE_STRING)) {
					String[] array = line.split(" ");
					for (String string : array) {
						if (string.contains(MAX_PERM_SIZE_STRING)) {
							vmParams.put(MAX_PERM_SIZE_STRING,
							             string.trim().substring(MAX_PERM_SIZE_STRING.length() + 1));
						}
					}
				}
				line = reader.readLine();
			}
			fileReader.close();
			reader.close();
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		return vmParams;

	}

	private File getScriptFile() {
		File scriptFile = null;
		String osNameProperty = System.getProperty(OS_NAME_PROPERTY);

		if (!osNameProperty.startsWith("Windows")) {
			scriptFile = new File(serverLocation + File.separator + "bin" + File.separator + "wso2server.sh");
		} else {
			scriptFile = new File(serverLocation + File.separator + "bin" + File.separator + "wso2server.bat");
		}

		return scriptFile;
	}

	public static void main(String[] args) {
		CarbonServerScriptParser p = new CarbonServerScriptParser("/media/Data/WSO2/DSS/wso2dataservices-2.6.2");
		p.getVMParamaters();
	}

}
