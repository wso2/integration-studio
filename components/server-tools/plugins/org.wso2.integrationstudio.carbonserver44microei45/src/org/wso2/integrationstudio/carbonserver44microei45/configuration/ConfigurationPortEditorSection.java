/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.integrationstudio.carbonserver44microei45.configuration;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wst.server.core.ServerPort;
import org.wso2.integrationstudio.carbon.server.model.configuration.ConfigurationPortCommonEditorSection;
import org.wso2.integrationstudio.carbon.server.model.util.CarbonServerCommonConstants;
import org.wso2.integrationstudio.carbon.server.model.util.CarbonServerCommonUtils;
import org.wso2.integrationstudio.carbonfeatures.Activator;
import org.wso2.integrationstudio.carbonserver44microei45.util.CarbonServer44eiUtils;
import org.wso2.integrationstudio.server.base.core.ServerController;

public class ConfigurationPortEditorSection extends ConfigurationPortCommonEditorSection {

	private CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();

	protected void changePortNumber(String name, int port) {
		TableItem[] items = ports.getItems();
		int size = items.length;
		for (int i = 0; i < size; i++) {
			ServerPort sp = (ServerPort) items[i].getData();
			if (sp.getName().equals(name)) {
				items[i].setData(new ServerPort(sp.getId(), sp.getName(), port, sp.getProtocol()));
				items[i].setText(1, port + "");
				CarbonServerCommonUtils.setServerConfigMapValue(server.getOriginal(), sp.getId(), port + "");
				carbonServer44eiUtils.updateTransportPorts(server.getOriginal());
				carbonServer44eiUtils.updateAxis2XML(server.getOriginal());
				return;
			}
		}
	}

	/**
	 * Initialize the fields in this editor.
	 */
	protected void initialize() {
		if (ports == null)
			return;

		ports.removeAll();
		CarbonServerCommonUtils.isServerStartBrowserPopup(server.getOriginal());
		ServerPort[] serverPorts = ServerController.getInstance().getServerManager().getServerPorts(server.getOriginal());
		for (ServerPort serverPort : serverPorts) {
			ServerPort port = serverPort;
			TableItem item = new TableItem(ports, SWT.NONE);
			String portStr = "-";
			if (port.getPort() >= 0) {
				portStr = port.getPort() + "";
			}
			String[] s = new String[] { port.getName(), portStr };
			item.setText(s);
			int i = CarbonServerCommonConstants.getPortcaptions(Activator.PLUGIN_ID).indexOf(port.getName());
			if (i != -1) {
				port =
				       new ServerPort(CarbonServerCommonConstants.getPortids(Activator.PLUGIN_ID).get(i),
				                      port.getName(), port.getPort(), port.getProtocol());
			}
			item.setData(port);
		}

		if (readOnly) {
			viewer.setCellEditors(new CellEditor[] { null, null });
			viewer.setCellModifier(null);
		} else {
			setupPortEditors();
		}
	}
}
