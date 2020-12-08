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

package org.wso2.developerstudio.eclipse.carbon.server.model.util;

import java.io.File;
import java.net.URL;

import javax.xml.namespace.NamespaceContext;

import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;

public interface CarbonServerXUtils {
	String getServerVersion();

	boolean updateTransportPorts(IServer server);

	URL getServerURL(IServer server);

	ServerPort[] getServerPorts(String serverHome);

	String getWebContextRoot(IServer server);

	NamespaceContext getCarbonNamespace();

	void setTrustoreProperties(IServer server);

	ServerPort[] getServerPorts(IServer server);

	String getRepositoryPath(String serverXmlPath);

	boolean updateAndSaveCarbonXml(String serverXmlPath, String repoPath, IServer server);

	String getServerXmlPathFromLocalWorkspaceRepo(String workspaceRepo);

	String getCatelinaXmlPathFromLocalWorkspaceRepo(String workspaceRepo);

	String getConfPathFromLocalWorkspaceRepo(String workspaceRepo);

	String getRepositoryPathFromLocalWorkspaceRepo(String workspaceRepo);

	String getTransportsXmlPathFromLocalWorkspaceRepo(String workspaceRepo);

	String getCarbonXmlPathFromLocalWorkspaceRepo(String workspaceRepo);

	String getAxis2XmlPathFromLocalWorkspaceRepo(String workspaceRepo);

	String resolveProperties(IServer server, String property);

	boolean updateAndSaveAxis2Ports(String axis2Xml, IServer server);

	File getCappMonitorBundle();

	String getPortId(String name);

	void loadServerInstanceProperties(IServer server);

	boolean updateAxis2XML(IServer server);

	boolean updateAndSaveTransportsPorts(String carbonXml, String catelinaXml, IServer server);
}
