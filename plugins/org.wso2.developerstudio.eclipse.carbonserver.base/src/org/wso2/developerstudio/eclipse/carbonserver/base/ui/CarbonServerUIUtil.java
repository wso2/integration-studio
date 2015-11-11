/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.ui;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerInformation;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarbonServerUIUtil {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public static void createWSASServerCombo(Composite container, int cols, int[] supportOperations,
	                                         CarbonServerInformation wsasServerInformation) {
		try {
			final Combo wsasCombo;
			Label label;
			label = new Label(container, SWT.NONE);
			label.setText("WSAS Server");
			GridData gd = new GridData();
			int col = Math.round(cols / 2) + 1;
			gd.horizontalSpan = col;
			label.setLayoutData(gd);

			wsasCombo = new Combo(container, SWT.READ_ONLY);
			gd = new GridData();
			gd.horizontalSpan = cols - col;
			wsasCombo.setLayoutData(gd);
			WSASModifyListener modifyListener = new WSASModifyListener();
			modifyListener.wsasCombo = wsasCombo;
			modifyListener.wsasServerInformation = wsasServerInformation;
			wsasCombo.addModifyListener(modifyListener);

			IServer[] serverList = getServerList();
			for (IServer server : serverList) {
				if (isServerSupports(server, supportOperations))
					wsasCombo.add(server.getId());
			}
			if (wsasCombo.getItemCount() > 0)
				wsasCombo.select(0);

			label = new Label(container, SWT.HORIZONTAL | SWT.SEPARATOR);
			label.setText("WSAS Server");
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = cols;
			label.setLayoutData(gd);

			label = new Label(container, SWT.NULL);
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = cols;
			label.setLayoutData(gd);
		} catch (Exception e) {
			log.error(e);
		}

	}

	private static IServer[] getServerList() {
		List<IServer> servers = CarbonServerManager.getServers();
		return servers.toArray(new IServer[] {});
	}

	private static boolean isServerSupports(IServer server, int[] operations) {
		if (operations == null)
			return true;
		boolean isSupport = false;
		for (int operation : operations) {
			try {
				isSupport = CarbonServerManager.isOperationSupported(server, operation);
			} catch (Exception e) {
				log.error(e);
			}
			if (isSupport)
				break;
		}
		return isSupport;
	}

	public static class WSASModifyListener implements ModifyListener {
		public CarbonServerInformation wsasServerInformation;
		public Combo wsasCombo;

		public void modifyText(ModifyEvent e) {
			wsasServerInformation.setServerId(wsasCombo.getText());
		}
	}
}
