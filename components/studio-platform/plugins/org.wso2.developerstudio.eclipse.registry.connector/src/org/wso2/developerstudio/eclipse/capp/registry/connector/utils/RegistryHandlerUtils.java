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

package org.wso2.developerstudio.eclipse.capp.registry.connector.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ICAppProjectSettings;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ISettingsAttribute;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.configure.ISettingsData;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.data.SettingsAttribute;
import org.wso2.developerstudio.eclipse.capp.core.data.SettingsData;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.capp.core.utils.Constants;
import org.wso2.developerstudio.eclipse.capp.registry.connector.Activator;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RegistryHandlerUtils {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static List<IRegistryConnection> getRegistryConnections(IProject project){
		List<IRegistryConnection> registryConnections= new ArrayList<IRegistryConnection>();
		if (CAppEnvironment.getcAppManager()==null){
			return registryConnections;
		}
		ICAppProjectSettings projectSettings = CAppEnvironment.getcAppManager().getProjectSettings(project);
		ISettingsData settings = projectSettings.getSettings(Constants.ID);
		if (settings!=null){
			ISettingsData registryConnectionsSettings = settings.getChildSettings(Constants.REGISTRY_CONNECTIONS_ID);
			if (registryConnectionsSettings!=null){
				List<ISettingsData> children = registryConnectionsSettings.getAllChildSettings(Constants.REGISTRY_CONNECTION_ID);
				for (ISettingsData data : children) {
					String id = data.getSettingsAttribute("id").getAttributeValue();
					String url = data.getSettingsValue();
					String path = data.getSettingsAttribute("path").getAttributeValue();
					ISettingsAttribute settingsAttribute = data.getSettingsAttribute("name");
					String name = settingsAttribute==null ? "<NO_NAME>":settingsAttribute.getAttributeValue();
					try {
						RegistryConnection registryConnection = new RegistryConnection();
						registryConnection.setId(id);
						registryConnection.setConnectionName(name);
	                    registryConnection.setURL(new URL(url));
	                    registryConnection.setPath(path);
	                    registryConnections.add(registryConnection);
                    } catch (MalformedURLException e) {
	                    log.error(e);
                    }
                }
			}
		}
		return registryConnections;
	}
	
	public static void addNewRegistryConnection(IProject project, IRegistryConnection connection) {
	    boolean urlAvailable = false;
		ICAppProjectSettings projectSettings = CAppEnvironment.getcAppManager().getProjectSettings(project);
		ISettingsData settings = projectSettings.getSettings(Constants.ID);
		if (settings==null){
			settings=new SettingsData(Constants.ID);
		}
		ISettingsData connections = settings.getChildSettings(Constants.REGISTRY_CONNECTIONS_ID);
		if (connections==null){
			connections=new SettingsData(Constants.REGISTRY_CONNECTIONS_ID);
			settings.addChildSettings(connections);
		}
		
		SettingsData settingsData = new SettingsData(Constants.REGISTRY_CONNECTION_ID);
		settingsData.addSettingsAttribute(new SettingsAttribute("name",connection.getConnectionName()));
		settingsData.addSettingsAttribute(new SettingsAttribute("path",connection.getPath()));
		settingsData.addSettingsAttribute(new SettingsAttribute("id",connection.getId()));
		settingsData.setSettingsValue(connection.getURL().toString());

		connections.addChildSettings(settingsData);
		projectSettings.setSettings(Constants.ID, settings);
		
		RegistryUrlStore regURLStore = RegistryUrlStore.getInstance();
		List<RegistryURLInfo> allRegistryUrls = regURLStore.getAllRegistryUrls();
		String connectionString=connection.getURL().toString().trim();
		if(!connectionString.endsWith("/")){
			connectionString=connectionString.concat("/");
		}
		for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
			
			String registryURLInfoString = registryURLInfo.getUrl().toString().trim();
			if(!registryURLInfoString.endsWith("/")){
				registryURLInfoString=registryURLInfoString.concat("/");
			}
			if(registryURLInfoString.equalsIgnoreCase(connectionString) &&
					registryURLInfo.getPath().equals(connection.getPath())){
				urlAvailable = true;
				return;
			}
		}
		if(!urlAvailable){
			regURLStore.addRegistryUrl(connection.getURL(), connection.getUsername(), connection.getPath(),false);
		}
    }

	public static void removeRegistryConnection(IProject project, IRegistryConnection connection) {
		String id = connection.getId();
	    removeRegistryConnection(project, id);
    }

	public static void removeRegistryConnection(IProject project, String id) {
		
	    ICAppProjectSettings projectSettings = CAppEnvironment.getcAppManager().getProjectSettings(project);
		ISettingsData settings = projectSettings.getSettings(Constants.ID);
		if (settings==null){
			settings=new SettingsData(Constants.ID);
		}
		ISettingsData connections = settings.getChildSettings(Constants.REGISTRY_CONNECTIONS_ID);
		if (connections==null){
			connections=new SettingsData(Constants.REGISTRY_CONNECTIONS_ID);
			settings.addChildSettings(connections);
		}
		
		List<ISettingsData> allChildSettings = connections.getAllChildSettings(Constants.REGISTRY_CONNECTION_ID, new ISettingsAttribute[]{new SettingsAttribute("id",id)});
		for (ISettingsData data : allChildSettings) {
	        connections.removeChildSettings(data);
        }
		projectSettings.setSettings(Constants.ID, settings);
    }
}
