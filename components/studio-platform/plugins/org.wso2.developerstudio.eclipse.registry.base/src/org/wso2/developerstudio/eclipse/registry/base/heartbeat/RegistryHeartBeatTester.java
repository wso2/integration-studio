/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.base.heartbeat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.util.Utils;

public class RegistryHeartBeatTester implements Runnable {
	private RegistryURLNode urlNodeList;
	private boolean stop=false;
	private Map<RegistryNode,Boolean> originalState=new HashMap<RegistryNode, Boolean>();;
	private static final int HEARTBEAT_RATE=5000;
	private RegistryUrlStore urlStore;
	
	public RegistryHeartBeatTester(RegistryURLNode urlNodeList) {
		setUrlNodeList(urlNodeList);
		urlStore=RegistryUrlStore.getInstance();
	}
	
	public void run() {
		while(!isStop()){
			List<RegistryNode> urlInfoList = urlNodeList.getUrlInfoList();
			boolean registryEnabledStateChanged=false;
			int index=0;
			while (index<urlInfoList.size()) {
				if (validateRegistryNode(urlInfoList.get(index)) && !registryEnabledStateChanged) {
					registryEnabledStateChanged = true;
				}
				index++;
			}
//			for (RegistryNode registryNode : urlInfoList) {
//				registryEnabledStateChanged = registryEnabledStateChanged || validateRegistryNode(registryNode);
//			}
			if (registryEnabledStateChanged) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						urlNodeList.refreshViewer(true);
					}
				});
			}
			try {
				Thread.sleep(HEARTBEAT_RATE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean validateRegistryNode(RegistryNode registryNode) {
		boolean registryEnabledStateChanged=false;
		boolean previousEnableState = false;
		if (registryNode.isEnabled()) {
			previousEnableState=true;
		}
		if(registryNode.isUserEnabled()){
		if (previousEnableState || !originalState.containsKey(registryNode)){
			originalState.put(registryNode, previousEnableState);
		}
		if (!Utils.isValidServerURL(registryNode.getServerUrl())){
			registryNode.setEnabled(false);
			List<RegistryURLInfo> allRegistryUrls = urlStore.getAllRegistryUrls();
			int indexOf = allRegistryUrls.indexOf(registryNode.getRegistryUrlInfo());
			RegistryURLInfo registryURLInfo = allRegistryUrls.get(indexOf);
			registryURLInfo.setEnabled(false);
			registryNode.getRegistryUrlInfo().setEnabled(false);
			urlStore.persist();
			registryNode.getRegistry().clearSessionProperties();
		}else{
			if (!registryNode.getRegistryUrlInfo().isEnabled()){
				registryNode.setEnabled(true);
				List<RegistryURLInfo> allRegistryUrls = urlStore.getAllRegistryUrls();
				int indexOf = allRegistryUrls.indexOf(registryNode.getRegistryUrlInfo());
				RegistryURLInfo registryURLInfo = allRegistryUrls.get(indexOf);
				registryURLInfo.setEnabled(true);
				urlStore.persist();
			}
		}
		if (previousEnableState != registryNode.isEnabled()){
			if (registryNode.isEnabled()){
				registryNode.setIterativeRefresh(true);
			}
			registryEnabledStateChanged=true;
		}
		
		}
		return registryEnabledStateChanged;
	}

	public void setUrlNodeList(RegistryURLNode urlNodeList) {
		this.urlNodeList = urlNodeList;
	}

	public RegistryURLNode getUrlNodeList() {
		return urlNodeList;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isStop() {
		return stop;
	}

}
