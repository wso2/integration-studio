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

package org.wso2.developerstudio.eclipse.platform.core.event;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.osgi.framework.Bundle;
import org.osgi.service.event.EventHandler;

public class EsbEditorEvent {
	private static IEventBroker iEventBroker;
	public static final String EVENT_TOPIC_SAVE_EDITORS = "SAVE_APIM_DATA";

	public static void CreateBroker(String pluginId) {

		Bundle bundle = Platform.getBundle(pluginId);
		IEclipseContext eclipseContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		eclipseContext.set(org.eclipse.e4.core.services.log.Logger.class, null);
		iEventBroker = eclipseContext.get(IEventBroker.class);
	}

	public static void subscribe(EventHandler eventHandler) {
		iEventBroker.subscribe(EVENT_TOPIC_SAVE_EDITORS, eventHandler);
	}

	public static IEventBroker getiEventBroker() {
		return iEventBroker;
	}

}
