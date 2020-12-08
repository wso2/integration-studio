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

package org.wso2.developerstudio.eclipse.registry.base.ui.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.registry.base.Activator;

public class ImageUtils {

	private static Map<String, ImageDescriptor> icons;

	public static final String ACTION_CHECK_OUT_MENU = "checkout_menu.png";
	public static final String STATE_NORMAL = "checkout_file.png";
	public static final String STATE_MODIFIED = "edited.png";
	public static final String STATE_NEW = "newresource.png";
	public static final String STATE_CONFLICT = "conflict.png";
	public static final String STATE_LOGIN = "login.png";
	public static final String STATE_DELETED = "deleted.png";
	public static final String STATE_ADDED = "added.png";
	public static final String STATE_CONFILCTED_LOCAL_COPY = "conflictedLocalCopy.png";
	public static final String STATE_CONFILCTED_LOCAL_COPY_RESOLVED = "conflictedLocalCopyResolve.png";
	public static final String STATE_CONFILCTED_SERVER_COPY = "conflictedServerVersions.png";
	public static final String STATE_CONFILCTED_SERVER_COPY_RESOLVED = "conflictedServerVersionsResolve.png";

	public static final String ACTION_ADD_COLLECTION = "addCollection.png";

	public static final String ACTION_ADD_RESOURCE = "addNewResource.png";
	public static final String ACTION_ADD_REGSISTY = "addRegistry.png";
	public static final String ACTION_ADD_RESOURCE_FROM_LOCAL = "addResourceFromLocalMedia.png";
	public static final String ACTION_ADD_TO_REGSITRY = "addToWso2Registry.png";

	public static final String ACTION_ADD_ASSOCIATION = "association.png";
	public static final String ACTION_ADD_COMMENT = "comment.png";
	public static final String ACTION_COMMIT = "commit.png";
	public static final String ACTION_COMMIT_AS_USER = "commitAsUser.png";
	public static final String ACTION_COMMUNITY_FEATURES = "community.png";
	public static final String ACTION_COMPAIR_CONFLICTS = "compareConflicts.png";
	public static final String ACTION_DELETE_COLLECTION = "deleteCollection.png";
	public static final String ACTION_DELETE_REGISTRY = "deleteRegistry.png";
	public static final String ACTION_DELETE_RESOURCE = "deleteResource.png";
	public static final String ACTION_ADD_DEPENDENCY = "dependency.png";
	public static final String ACTION_DISCONNECT_REGISTRY = "disconnectRegistry.png";
	public static final String ACTION_ADD_FILE = "file.png";
	public static final String ACTION_ADD_FOLDER = "folder.png";
	public static final String ACTION_ADD_LIFECYCLE = "lifecycle.png";
	public static final String ACTION_ADD_METADATA = "metadata.png";
	public static final String ACTION_ADD_PROPERTIES = "properties.png";
	public static final String ACTION_RECONNECT_REGISTRY = "reconnectRegistry.png";
	public static final String ACTION_REFERESH = "refresh.png";
	public static final String ACTION_TOGGLE_SHOW_IN_REGISTRY_VIEW = "toggle2.png";

	public static final String ACTION_ADD_TAGS = "tags.png";
	public static final String ACTION_UPDATE = "update.png";
	public static final String ACTION_ADD_MULTIPLE_FILES = "multipleFiles.png";
	public static final String ACTION_IMPORT_TO_REGISTRY = "import_wiz.png";
	public static final String ACTION_EXPORT_TO_REGISTRY = "export_wiz.png";

	public static final String ACTION_MODIFY_PERMISSION_ROLE = "modify-permission-role.gif";
	public static final String ACTION_MODIFY_PERMISSION_RESOURCE = "modify-permission-resource.gif";

	public static final String ACTION_SELECT_RESOURCES = "select-resources.gif";

	public static final String WIZARD_ICON_SPECIFY_PERMISSION = "specify-permission.gif";
	public static final String ICON_ROLE = "role.gif";
	public static final String ICON_ROLES = "roles.gif";
	public static final String ICON_USER = "user.gif";
	public static final String ICON_USERS = "users.gif";
	public static final String ICON_USERS_ROLES = "users-roles.gif";
	public static final String ICON_HEAD = "head.gif";

	public static final String RATINGS_STAR0 = "star0.png";
	public static final String RATINGS_STAR1 = "star1.png";
	public static final String RATINGS_STAR2 = "star2.png";
	public static final String RATINGS_STAR3 = "star3.png";
	public static final String RATINGS_STAR4 = "star4.png";

	public static final String ICON_REGISTRY = "registryWithServer.png";
	public static final String ICON_REGISTRY_SEARCH = "registry-search.png";
	public static final String ICON_RESOURCE = "resource.png";
	public static final String ICON_SYMLINK = "resource-extn.gif";
	public static final String ICON_REMOTE_LINK = "resource-extn-mounted.gif";
	public static final String ICON_INFORMATION = "registryProperties.png";
	public static final String ICON_DISCONNECTED_REGISTRY = "registry_disconnected.png";
	public static final String ICON_VERSIONS = "versions.gif";
	public static final String ICON_VERSION = "version.gif";
	public static final String ICON_VERSION_VIEW = "details.gif";
	public static final String ICON_VERSION_RESTORE = "restore.gif";
	public static final String ICON_READ_ONLY = "padlock.gif";
	
	public static final String ICON_COPY = "cp.png";
	public static final String ICON_PASTE = "paste.png";

	public static final String ICON_RENAME = "rename.png";
	public static final String ICON_SEQ = "seq.png";
	/**
	 * create ImageDescriptor 
	 * @param imgName
	 * @return
	 */
	private static ImageDescriptor createImageDescriptor(String imgName) {
		if (imgName == null)
			return null;
		ImageDescriptor imageDescriptor = null;
		IPath path = new Path("icons/" + imgName);
		URL gifImageURL = FileLocator.find(Platform	.getBundle(Activator.PLUGIN_ID), path, null);
		if (gifImageURL != null){
			imageDescriptor = ImageDescriptor.createFromURL(gifImageURL);
		}
		return imageDescriptor;
	}

	/**
	 * get image descriptor
	 * @param key
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		if (icons == null) {
			icons = new HashMap<String, ImageDescriptor>();
		}
		if (!icons.containsKey(key)){
			icons.put(key, createImageDescriptor(key));
		}
		return icons.get(key);
	}
}
