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

package org.wso2.developerstudio.eclipse.registry.base.usermgt.ui.controls;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.registry.base.core.MediaTypes;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;

/**
 *
 */
public class UserPermissionTreeLabelProvider implements ILabelProvider{

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
     */
    
    public void addListener(ILabelProviderListener arg0) {
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
     */
    
    public void dispose() {
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
     */
    
    public boolean isLabelProperty(Object arg0, String arg1) {
	    return false;
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
     */
    
    public void removeListener(ILabelProviderListener arg0) {
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
     */
    
    public Image getImage(Object element) {
    	ImageDescriptor descriptor = null;
    	boolean connectionValid = true;
    	if (element instanceof RegistryResourceNode) {
			RegistryResourceNode ele = (RegistryResourceNode) element;
			if (ele.getResourceType() == RegistryResourceType.RESOURCE) {
				connectionValid = ele.getConnectionInfo().isConnectionValid();
				if (ele.getMediaType() != null) {
					if (MediaTypes.getAllKeys().contains(ele.getMediaType())) {
						String ext = MediaTypes
								.getDefaultFileExtensionForMediaType(ele
										.getMediaType());
						descriptor = PlatformUI.getWorkbench()
								.getEditorRegistry()
								.getImageDescriptor("test." + ext);
					}
				}
				if (descriptor == null) {
					descriptor = ImageUtils
							.getImageDescriptor(ImageUtils.ICON_RESOURCE);
				}
			} else {
				connectionValid = ele.getConnectionInfo().isConnectionValid();
				descriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ACTION_ADD_FOLDER);
			}
    	}else if (element instanceof RegistryContentContainer) {
			descriptor = ImageUtils.getImageDescriptor(ImageUtils.ICON_HEAD);
		}
    	
	    return null;
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
     */
    
    public String getText(Object arg0) {
	    return arg0.toString();
    }

}
