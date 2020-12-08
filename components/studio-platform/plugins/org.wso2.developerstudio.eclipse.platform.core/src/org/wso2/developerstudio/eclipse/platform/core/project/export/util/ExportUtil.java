/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.core.project.export.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;

/**
 * Carbon application export utility
 *
 */
public class ExportUtil {
	private static final String EXT_POINT_ID = "org.wso2.developerstudio.eclipse.project.export.handler";
	private static Map<String, IConfigurationElement> handlers = new HashMap<String, IConfigurationElement>();
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	static {
		try {
			IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_POINT_ID);
			for (IConfigurationElement handlerConf : config) {
				String type = handlerConf.getAttribute("type");
				if (null != type) {
					if (!handlers.containsKey(type)) { // ignoring multiple
													   // handlers with same
													   // CApp type
						handlers.put(type, handlerConf);
					} else {
						log.warn("CApp type \"" + type + "\" is already registered with another handler");
					}
				} else {
					log.warn("Ignoring export-handler with CApp type unknown");
				}
			}
		} catch (Exception e) {
			log.error("Error obtaining export-handler extensions configuration", e);
		}
	}

	/**
	 * @return the handlers
	 */
	public static Map<String, IConfigurationElement> getHandlers() {
		return handlers;
	}

	/**
	 * builds project
	 * 
	 * @param project
	 * @param cAppType
	 * @return List<IResource>
	 * @throws Exception
	 */
	public static List<IResource> buildProject(final IProject project, final String cAppType) throws Exception {
		final List<IResource> exportResources = new ArrayList<IResource>();
		if (project.isOpen()) {
			if (getHandlers().containsKey(cAppType)) {
				IConfigurationElement handlerConf = getHandlers().get(cAppType);
				final Object o = handlerConf.createExecutableExtension("class");
				if (o instanceof ProjectArtifactHandler) {
					exportResources.addAll(((ProjectArtifactHandler) o).exportArtifact(project));
				}
			} else {
				throw new Exception("Can't find export handler for " + cAppType);
			}
		} else {
			throw new Exception("\"" + project.getName() + "\" project is not open!");
		}

		return exportResources;
	}

	/**
	 * Carbon application builder
	 * 
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public static IResource buildCAppProject(IProject project) throws Exception {
		List<IResource> buildProject = new ArrayList<IResource>();
		if (!project.isOpen()) {
			throw new Exception("\"" + project.getName() + "\" project is not open!");
		}
		if (project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")) {
			buildProject = ExportUtil.buildProject(project, "carbon/application");
		} else {
			throw new Exception("\"" + project.getName() + "\" project is not a carbon application project");
		}
		return buildProject.get(0);
	}

}
