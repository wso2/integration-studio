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

package org.wso2.developerstudio.eclipse.artifact.synapse.template;

import java.io.File;

import org.wso2.developerstudio.eclipse.artifact.synapse.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class SynapseClassTemplate {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static String getSimpleTemplete() {
		try {
			StringBuffer buffer = new StringBuffer();
			// <definitions xmlns="http://ws.apache.org/ns/synapse"/>
			buffer.append("<definitions xmlns=");
			buffer.append("\"");
			buffer.append("http://ws.apache.org/ns/synapse");
			buffer.append("\" ");
			buffer.append("xmlns:xsi=");
			buffer.append("\"");
			buffer.append("http://www.w3.org/2001/XMLSchema-instance");
			buffer.append("\" ");
			buffer.append("xsi:schemaLocation=");
			buffer.append("\"");
			buffer.append("http://ws.apache.org/ns/synapse http://synapse.apache.org/ns/2010/04/configuration/synapse_config.xsd");
			buffer.append("\"");
			buffer.append(" />");

			return buffer.toString();
		} catch (Exception e) {
			log.error("Error reading templete", e);
			return "";
		}
	}

	public static String getRichTemplate() {
		try {
			ITemporaryFileTag mediatorTempTag = FileUtils.createNewTempTag();
			File resourceFile = new SynapseTemplateUtils()
					.getResourceFile("template/synapseConfig.temp");
			String fileContent = FileUtils.getContentAsString(resourceFile);
			mediatorTempTag.clearAndEnd();
			return fileContent;
		} catch (Exception e) {
			log.error("Error reading templete", e);
			return "";
		}
	}
}