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

package org.wso2.developerstudio.eclipse.registry.base.ui.controls;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.registry.base.core.MediaTypes;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryURLNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUser;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserManagerContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRole;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRoleContainer;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.ui.image.OverlayImageDescriptor;

public class RegistryTreeLabelProvider implements ILabelProvider {

	/**
	 * get the image for the tree item implementation of method inherited by
	 * interface ILabelProvider
	 * 
	 */

	public Image getImage(Object element) {
		ImageDescriptor descriptor = null;
		boolean connectionValid = true;
		if (element instanceof RegistryURLNode) {
			descriptor = ImageUtils
					.getImageDescriptor(ImageUtils.ACTION_ADD_FOLDER);
		} else if (element instanceof RegistryNode) {
			if (((RegistryNode) element).isEnabled()) {
				descriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ICON_REGISTRY);
			} else {
				descriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ICON_DISCONNECTED_REGISTRY);
			}
		} else if (element instanceof RegistryResourceNode) {
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
			} else if(ele.getResourceType() == RegistryResourceType.SYMLINK){
				connectionValid = ele.getConnectionInfo().isConnectionValid();
				descriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ICON_SYMLINK);
			}else if(ele.getResourceType() == RegistryResourceType.REMOTELINK){
				connectionValid = ele.getConnectionInfo().isConnectionValid();
				descriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ICON_REMOTE_LINK);
			} else {
				connectionValid = ele.getConnectionInfo().isConnectionValid();
				descriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ACTION_ADD_FOLDER);
			}
			if (connectionValid && !ele.hasWritePermissions()) {
				ImageDescriptor readOnlyDescriptor = ImageUtils
						.getImageDescriptor(ImageUtils.ICON_READ_ONLY);
				descriptor = new OverlayImageDescriptor(descriptor,
						readOnlyDescriptor);
			}
		} else if (element instanceof RegistryContentContainer) {
			descriptor = ImageUtils.getImageDescriptor(ImageUtils.ICON_HEAD);
		} else if (element instanceof RegistryUserContainer) {
			descriptor = ImageUtils.getImageDescriptor(ImageUtils.ICON_USERS);
		} else if (element instanceof RegistryUserRoleContainer) {
			descriptor = ImageUtils.getImageDescriptor(ImageUtils.ICON_ROLES);
		} else if (element instanceof RegistryUserRole) {
			descriptor = ImageUtils.getImageDescriptor(ImageUtils.ICON_ROLE);
		} else if (element instanceof RegistryUser) {
			descriptor = ImageUtils.getImageDescriptor(ImageUtils.ICON_USER);
		} else if (element instanceof RegistryUserManagerContainer) {
			descriptor = ImageUtils
					.getImageDescriptor(ImageUtils.ICON_USERS_ROLES);
		} else {

		}

		Image image = null;
		ImageDescriptor newDescriptor;

		if (descriptor != null) {
			if (!connectionValid) {
				newDescriptor = ImageUtils
						.getImageDescriptor(ImageUtils.STATE_LOGIN);
				OverlayImageDescriptor overlayimagedescriptor = new OverlayImageDescriptor(
						descriptor, newDescriptor);
				image = overlayimagedescriptor.createImage();
			} else {
				image = descriptor.createImage();
			}
		}
		return image;
	}

	/**
	 * get the caption for the tree item implementation of method inherited by
	 * interface ILabelProvider
	 */
	public String getText(Object obj) {
		return obj.toString();
	}

	/**
	 * implementation of method inherited by interface ILabelProvider
	 */
	public void addListener(ILabelProviderListener arg0) {

	}

	/**
	 * implementation of method inherited by interface ILabelProvider
	 */
	public void dispose() {

	}

	/**
	 * implementation of method inherited by interface ILabelProvider
	 */
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	/**
	 * implementation of method inherited by interface ILabelProvider
	 */
	public void removeListener(ILabelProviderListener arg0) {

	}
}
