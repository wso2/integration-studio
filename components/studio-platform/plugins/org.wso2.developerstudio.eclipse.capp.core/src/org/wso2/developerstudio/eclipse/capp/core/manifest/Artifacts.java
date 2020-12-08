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

package org.wso2.developerstudio.eclipse.capp.core.manifest;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class Artifacts extends AbstractXMLDoc{
	private static final String ARTIFACTS_XML = "artifacts.xml";
	private static final String ARTIFACTS = "artifacts";

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private List<Artifact> artifacts=new ArrayList<Artifact>();
	
    protected String getDefaultName() {
	    return ARTIFACTS_XML;
    }

	public void setArtifacts(List<Artifact> artifacts) {
	    this.artifacts = artifacts;
    }

	public List<Artifact> getArtifacts() {
	    return artifacts;
    }

	public OMElement getDocumentElement() {
		OMElement documentElement = getElement(ARTIFACTS, "");
		for(Artifact artifact:getArtifacts()){
			documentElement.addChild(artifact.getDocumentElement());
		}
		return documentElement;
	}
	
	public String serialize() {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			prettify(documentElement, outputStream);
		} catch (XMLStreamException e) {
			log.error(e);
			return null;
		} catch (Exception e) {
	        log.error(e);
			return null;
        }
		result = outputStream.toString();
		return result;
	}

	protected void deserialize(OMElement documentElement) {
	    
    }
}
