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

package org.wso2.developerstudio.eclipse.platform.core.registry.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class RegistryResourceInfoDoc extends AbstractXMLDoc {

	private List<RegistryResourceInfo> registryResources = new ArrayList<RegistryResourceInfo>();
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public void addRegistryResourceInfoDoc(String path, File inputFile, int type, File base, String relativePath) {
		if (type == Constants.REGISTRY_COLLECTION && Constants.getStaticPath().contains(path)) {
			File[] listFiles = inputFile.listFiles();
			for (File file : listFiles) {
				StringBuffer sb = new StringBuffer();
				sb.append(path);
				if (!file.isFile()) {
					sb.append("/").append(file.getName());
				}
				// XXX: Be watchful whether this fix has broken the
				// functionality due to string pointers
				path = sb.toString();
				addRegistryResourceInfoDoc(sb.toString(), file, file.isFile() ? Constants.REGISTRY_RESOURCE
				                                                             : Constants.REGISTRY_COLLECTION, base,
				                           relativePath);
			}
		} else {
			RegistryResourceInfo info = new RegistryResourceInfo(path, inputFile, type, base, relativePath);
			info.setMediaType(MediaManager.getMediaType(inputFile));
			getRegistryResources().add(info);
		}
	}

	protected String getDefaultName() {
		return null;
	}

	protected void deserialize(OMElement documentElement) {
		List<OMElement> childElements = getChildElements(documentElement, null);
		for (OMElement element : childElements) {
			RegistryResourceInfo registryResourceInfo = new RegistryResourceInfo();
			registryResourceInfo.deserialize(element);
			getRegistryResources().add(registryResourceInfo);
		}
	}

	protected String serialize() {
		OMElement documentElement = getElement("resources", "");
		for (RegistryResourceInfo info : getRegistryResources()) {
			try {
				documentElement.addChild(getElement(info.serialize()));
			} catch (XMLStreamException e) {
				log.error(e);
				return null;
			}
		}
		String pretifiedString;
		try {
			pretifiedString = getPretifiedString(documentElement);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		return pretifiedString;
	}

	public List<RegistryResourceInfo> getRegistryResources() {
		return registryResources;
	}
}
