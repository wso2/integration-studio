/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.jaxws.validators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;
import org.wso2.developerstudio.eclipse.artifact.jaxws.Activator;
import org.wso2.developerstudio.eclipse.artifact.jaxws.model.JaxwsModel;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class CXFRuntimeSelectionModeList extends AbstractListDataProvider {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	@Override
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
	
		IServer[] serverList=ServerCore.getServers();
		String serverName= "";
		String cxfRunTimePath="";
		List<ListData> list = new ArrayList<ListData>();
		
		for (IServer iServer : serverList) {
			serverName = iServer.getRuntime().getName();
			if(isCarbonServer(iServer)){
				cxfRunTimePath = iServer.getRuntime().getLocation().toString();
				File carbonXML =new File(iServer.getRuntime().getLocation().toString()+"/repository/conf/carbon.xml");
				try {
					OMElement rootElement = OMXMLBuilderFactory.createOMBuilder(new FileInputStream(carbonXML)).getDocumentElement();
					Iterator<?> it = rootElement.getChildrenWithLocalName("ServerKey");				
					 while (it.hasNext()) {
				            OMElement name = (OMElement) it.next();
				            if(name.getText().equals("AS")){
				            	list.add(createListData(serverName,cxfRunTimePath));
				            }
				    }
				} catch (FileNotFoundException e) {
					log.error("Cannot find carbon.xml", e);
				}	
			}	
		}
		list.add(createListData("Custom CXF Runtime","Custom CXF Runtime"));
		
		if(!cxfRunTimePath.equals("")){	
			((JaxwsModel)model).setCXFRuntime(cxfRunTimePath);
		}

		return list;
	}
	
	public boolean isCarbonServer(IServer iServer) {
		boolean hasAsServers=false;
		if(iServer.getServerType().toString().startsWith("ServerType[org.wso2.developerstudio.eclipse.carbon")){
			hasAsServers=true;
		}
		return hasAsServers;
	}

}
 