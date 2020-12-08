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

package org.wso2.developerstudio.eclipse.registry.manager.remote.dragdrop;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import org.wso2.carbon.registry.core.Collection;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

public class DragDropUtils {

	public static final String ACTION_IMPORT = "import";
	public static final String ACTION_EXPORT = "export";
	ArrayList<Object> list = new ArrayList<Object>();

	public ArrayList<Object> getResourceList(String path,
			RegistryResourceNode regResourcePathData) throws InvalidRegistryURLException, UnknownRegistryException{
		Registry registry = regResourcePathData.getConnectionInfo().getRegistry();
		Resource resource = registry.get(path);
		if (resource instanceof Collection) {
			try {
				String[] children = ((Collection) resource).getChildren();
				if (children.length == 0) {
					list.add(resource);
				} else {
					list.add(resource);
				}
				for (int i = 0; i < children.length; i++) {
					getResourceList(children[i], regResourcePathData);
				}
			} catch (RegistryException e) {
				throw new UnknownRegistryException("Error occured while retrieving registry collection children: "+e.getMessage(),e);
			}
		} else {
			list.add(resource);
		}
		return list;
	}

	public Queue retrieveContentsFromRegistry(String targetRegPath,
			RegistryResourceNode regResourcePathData) throws InvalidRegistryURLException, UnknownRegistryException{
		Queue queue = new Queue();
		ArrayList<Object> list = getResourceList(targetRegPath,
				regResourcePathData);
		for (int i = 0; i < list.size(); i++) {
			queue.instert(list.get(i));
		}
		return queue;
	}

	public void writeContentToRegistry(String targetRegPath,
			RegistryResourceNode regResourcePathData,
			SynchronousQueue<Object> queue) throws InvalidRegistryURLException, UnknownRegistryException {
		Registry registry = regResourcePathData.getConnectionInfo().getRegistry();
		for (int i = 0; i < queue.size(); i++) {
			try {
				Resource resource = (Resource) queue.take();
				String resourcePath = targetRegPath + "/" + resource.getPath();
				registry.put(resourcePath, resource);
			} catch (InterruptedException e) {
				throw new UnknownRegistryException("Error occured while running the syncronous thread: "+e.getMessage(),e);
			}
		}

	}
}
