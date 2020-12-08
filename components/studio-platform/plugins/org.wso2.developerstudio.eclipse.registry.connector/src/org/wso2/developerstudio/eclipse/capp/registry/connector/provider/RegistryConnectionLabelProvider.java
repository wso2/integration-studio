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

package org.wso2.developerstudio.eclipse.capp.registry.connector.provider;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.wso2.developerstudio.eclipse.capp.registry.connector.model.RegistryConnectionNode;
import org.wso2.developerstudio.eclipse.capp.registry.connector.model.RegistryConnectionsNode;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryConnectorImageUtils;

public class RegistryConnectionLabelProvider implements ICommonLabelProvider{

	public void init(ICommonContentExtensionSite arg0) {
		
	}

	public Image getImage(Object obj) {
		if (obj instanceof RegistryConnectionsNode){
			return RegistryConnectorImageUtils.getInstance().getImageDescriptor("reg-connections-16x16.png").createImage();
		}else if (obj instanceof RegistryConnectionNode){
			return RegistryConnectorImageUtils.getInstance().getImageDescriptor("reg-connection-16x16.png").createImage();
		}
		return null;
	}

	public String getText(Object obj) {
		if (obj instanceof RegistryConnectionsNode){
			RegistryConnectionsNode node=(RegistryConnectionsNode)obj;
			return node.getCaption();
		}else if (obj instanceof RegistryConnectionNode){
			RegistryConnectionNode node=(RegistryConnectionNode)obj;
			return node.getCaption();
		}else if (obj instanceof IProject){
			IProject project=(IProject)obj;
			return project.getName();
		}
		return obj.toString();
	}

	public void addListener(ILabelProviderListener arg0) {
		
	}

	public void dispose() {
		
	}

	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	public void removeListener(ILabelProviderListener arg0) {
		
	}

	public void restoreState(IMemento arg0) {
		
	}

	public void saveState(IMemento arg0) {
		
	}

	public String getDescription(Object arg0) {
		return "";
	}

}
