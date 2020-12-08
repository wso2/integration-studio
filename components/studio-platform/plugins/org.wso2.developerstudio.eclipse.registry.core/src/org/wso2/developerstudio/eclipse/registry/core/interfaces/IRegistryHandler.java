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

package org.wso2.developerstudio.eclipse.registry.core.interfaces;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

public interface IRegistryHandler {
	public static final int SELECTED_NONE = 1;
	public static final int SELECTED_REGISTRY = 2;
	public static final int SELECTED_REGISTRY_PATH = 4;
	public static final int SELECTED_REGISTRY_RESOURCE = 8;
	
	public IRegistryData selectRegistryPath(IRegistryConnection[] registryConnections,String title, String message,int type);
	public void importRegistryPathToFileSystem(IRegistryData registryData,File toPath);
	public void importRegistryResourceToFileSystem(IRegistryData registryData,File toFile) throws Exception;
	public List<IRegistryConnection> getRegistryConnections(IProject project);
	public IRegistryConnection createNewRegistryConnection(IProject project, boolean createRegistryConnectionAtTheFinish);
	public void createNewRegistryConnection(IProject project, IRegistryConnection registryConnection);
	public void openRegistryBrowserView(IRegistryData registryData);
	public boolean isRegistryConnectionPresent(IProject project, String connectionName);
	public boolean isRegistryConnectionPresent(IProject project, IRegistryConnection connection);
	public void createMetaDataForFolder(String checkoutPath, File fromPath);
	public String[] getFilterMethods();
	public void hideRegistryBrowserView(String url, String path);
	public File getRegistryCoreLibraryPath();
	public void createArtifact(IProject project, String name, String deployPathToRegistry,String server,boolean openResource, File...resources) throws IOException, CoreException, Exception;
	public IRegistryConnection[] getRegistryConnections();
	
}
