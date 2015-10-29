/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.platform.core.update.manager;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.IRepositoryManager;
import org.osgi.framework.ServiceReference;
import org.wso2.developerstudio.eclipse.platform.core.Activator;

public class UpdateManager {
	
	IProvisioningAgentProvider agentProvider;
	IProvisioningAgent p2Agent;

	public UpdateManager() {
		ServiceReference<IProvisioningAgentProvider> sr = Activator.getDefault().getContext()
				.getServiceReference(IProvisioningAgentProvider.class);
		if(sr != null){
			agentProvider = Activator.getDefault().getContext().getService(sr);
		}
	}

	protected void initProvisioningAgent(){
		if(agentProvider != null){
			try {
				p2Agent = agentProvider.createAgent(new URI("file:/Applications/eclipse36/p2"));
			} catch (ProvisionException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void initRepositoryManager(){
		IRepositoryManager manager = (IRepositoryManager) p2Agent.getService(IRepositoryManager.SERVICE_NAME);
		IMetadataRepository repository = manager.loadRepository(new URI("http://download.eclipse.org/releases/helios"), new NullProgressMonitor());
	}

}
