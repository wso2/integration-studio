/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.eclipse.platform.ui.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.wso2.integrationstudio.eclipse.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.eclipse.logging.core.Logger;
import org.wso2.integrationstudio.eclipse.platform.core.interfaces.IIntegrationStudioProviderData;
import org.wso2.integrationstudio.eclipse.platform.ui.Activator;

public class EvaluateExtentionHandler {
	private static final String ExtentionPoint_ID = "org.wso2.integrationstudio.platfom.ui.resourceManger";
	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private IIntegrationStudioProviderData[] type;

	public void execute(IExtensionRegistry registry) {
		IConfigurationElement[] config = registry.getConfigurationElementsFor(ExtentionPoint_ID);
		try {
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof IResourceManager) {
					executeExtension(o);
				}
			}
		} catch (CoreException ex) {
			log.error("Error while finding " + ExtentionPoint_ID, ex);
		}
	}

	private void executeExtension(final Object o) {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				log.error("Error in the " + ExtentionPoint_ID, e);
			}

			@Override
			public void run() throws Exception {
				setType(((IResourceManager) o).getIIntegrationStudioResourceProviders(true));
			}
		};
		SafeRunner.run(runnable);
	}

	public IIntegrationStudioProviderData[] getType() {
		return type;
	}

	public void setType(IIntegrationStudioProviderData[] iIntegrationStudioProviderDatas) {
		this.type = iIntegrationStudioProviderDatas;
	}
}
