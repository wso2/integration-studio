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

package org.wso2.developerstudio.eclipse.artifact.synapse.validators;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.artifact.synapse.model.SynapseModel;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class EsbArtifactList extends AbstractListDataProvider {

	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		List<OMElement> availablePSList = ((SynapseModel)model).getAvailablePLESList();
		if(availablePSList != null){
			for (OMElement omElement : availablePSList) {
				String qName = omElement.getAttributeValue(new QName("name"));
				if(("".equals(qName))||(qName==null)){
					qName=omElement.getAttributeValue(new QName("key"));
				}
				qName = qName+" ["+omElement.getLocalName()+"]";
				list.add(createListData(qName, omElement));
			}
		}
		return list;
	}

}
