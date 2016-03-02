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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class Component extends AbstractXMLDoc{
	
	private List<SubComponents> subComponents=new ArrayList<SubComponents>();

	public List<SubComponents> getSubComponents() {
		return subComponents;
	}

	public void setSubComponents(List<SubComponents> subComponents) {
		this.subComponents = subComponents;
	}

	@Override
	protected void deserialize(OMElement documentElement) throws Exception {
		List<OMElement> artifactsElements = getChildElements(documentElement, "subComponents");
		for (OMElement omElement : artifactsElements) {
			List<OMElement> artifactElements = getChildElements(omElement, "component");			
			for (OMElement omElement2 : artifactElements) {		
				OMElement fileElement= (OMElement) omElement2.getChildrenWithLocalName("file").next();
				SubComponents artifactDependency=new SubComponents(omElement2.getAttributeValue(new QName("name")),fileElement.getText().split(".xml")[0]); 
				subComponents.add(artifactDependency);
			}
        }
		
	}

	@Override
	protected String serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDefaultName() {
		// TODO Auto-generated method stub
		return null;
	}

}
