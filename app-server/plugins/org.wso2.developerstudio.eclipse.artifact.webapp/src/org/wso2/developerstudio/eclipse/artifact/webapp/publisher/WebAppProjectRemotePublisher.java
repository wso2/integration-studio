/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.webapp.publisher;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.core.resources.IFile;
import org.wso2.developerstudio.eclipse.artifact.webapp.project.export.WebAppArtfactExportHandler;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerModulePublisher;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICredentials;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.WebAppDeployer;

public class WebAppProjectRemotePublisher implements ICarbonServerModulePublisher{
	
	private WebAppDeployer webappDeployer;
	private static final String WEBAPP_NATURE = "org.wso2.developerstudio.eclipse.webapp.project.nature";

	@Override
	public void publish(IProject project, IServer server, File serverHome,
			File deployLocation) throws Exception {
		
		 if (project.hasNature(WEBAPP_NATURE)){
			 
				URL serverURL = CarbonServerManager.getServerURL(server);
				ICredentials serverCredentials = CarbonServerManager.getServerCredentials(server);
				webappDeployer = new WebAppDeployer();
				WebAppArtfactExportHandler handler=new WebAppArtfactExportHandler();
				List<IResource> exportArtifact = handler.exportArtifact(project);
				File warFile = ((IFile)exportArtifact.get(0)).getLocation().toFile();
				webappDeployer.deployWebApp(serverCredentials.getUsername(), serverCredentials.getPassword(), serverURL.toString(), warFile);
 
		 }		
	}

	@Override
	public void unpublish(IProject project, IServer server, File serverHome,
			File deployLocation) throws Exception {
		
		if(webappDeployer == null){
			webappDeployer = new WebAppDeployer();
		}
		ICredentials serverCredentials = CarbonServerManager.getServerCredentials(server);
		URL serverURL = CarbonServerManager.getServerURL(server);
		webappDeployer.undeployWebApp(serverCredentials.getUsername(), serverCredentials.getPassword(), serverURL.toString(), project.getName());
		
	}

	@Override
	public void hotUpdate(IProject project, IServer server, File serverHome,
			File deployLocation) throws Exception {
		
		unpublish(project, server, serverHome, deployLocation);
		publish(project, server, serverHome, deployLocation);
		
	}

	@Override
	public void setUpdatedResource(IResource updatedResource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResourceChngeKind(int resourceChngeKind) {
		// TODO Auto-generated method stub
		
	}


}
