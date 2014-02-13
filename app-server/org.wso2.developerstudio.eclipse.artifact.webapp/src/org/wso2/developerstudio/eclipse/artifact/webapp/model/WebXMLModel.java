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

package org.wso2.developerstudio.eclipse.artifact.webapp.model;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class WebXMLModel extends AbstractXMLDoc {
	private String displayName;
	private OMElement mainElement;

	
	protected void deserialize(OMElement documentElement) throws Exception {
		setDocumentElement(documentElement);
		OMElement displayNameElement = getDisplayNameElement(documentElement);
		if (displayNameElement != null) {
			setDisplayName(displayNameElement.getText());
		}
	}

	private OMElement getDisplayNameElement(OMElement documentElement) {
		OMElement displayNameElement = null;
		List<OMElement> displayNameElements = getChildElements(documentElement, "display-name");
		if (displayNameElements != null && displayNameElements.size() > 0) {
			displayNameElement = displayNameElements.get(0);
		}
		return displayNameElement;
	}

	
	protected String serialize() {
		OMElement documentElement = getDocumentElement();
		OMElement displayNameElement = getDisplayNameElement(documentElement);
		displayNameElement.setText(getDisplayName() == null ? "" : getDisplayName());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			prettify(documentElement, out);
			return out.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	protected String getDefaultName() {
		return null;
	}

	public void setDocumentElement(OMElement documentElement) {
		this.mainElement = documentElement;
	}

	public OMElement getDocumentElement() {
		return mainElement;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
