/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class ResourcesLabelProvider implements ILabelProvider {

	
	public void addListener(ILabelProviderListener labelProviderListener) {
		
	}

	
	public void dispose() {
		
	}

	
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	
	public void removeListener(ILabelProviderListener labelProviderListener) {


	}

	
	public Image getImage(Object element) {
		if(element instanceof NavigatorNode){
			return ((NavigatorNode)element).getGetImage();
		} else{
			return SWTResourceManager.getImage(this.getClass(), "/icons/registry_nav.png");
		}
		
	}

	
	public String getText(Object obj) {
		if(obj instanceof NavigatorNode){
			return ((NavigatorNode)obj).getText();
		} else{
			return obj.toString();
		}
	}

}
