/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.greg.manager.remote.views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.greg.apim.action.Login;
import org.wso2.developerstudio.eclipse.greg.manager.remote.Activator;


/**
 * 
 * This class can be used to implement APIManager specific features , right now I haven't add any specific features 
 *
 */
public class ApiMangerRegistryBrowserView extends RegistryBrowserView {

	private static final String APIM_CUSTOMSEQUENCES_PATH = "/_system/governance/apimgt/customsequences";

public ApiMangerRegistryBrowserView() {
	super();
	setApiManagerview(true);	
	try {
		setApimRegPath(new Login().getRegpath());
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		IEclipseContext eclipseContext = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		eclipseContext.set(org.eclipse.e4.core.services.log.Logger.class, null);
		IEventBroker iEventBroker = eclipseContext.get(IEventBroker.class);
		iEventBroker.subscribe(EVENT_TOPIC_EXPAND_TREE,getTreeExpandHandler() );
		iEventBroker.subscribe(EVENT_TOPIC_POPULATE_NODE_DATA, getTreeNodeSelctionHandler());
		setBroker(iEventBroker);
	} catch (Exception e) {
		setApimRegPath(APIM_CUSTOMSEQUENCES_PATH);	 
	}
	
}


@Override
public void dispose() {
	IEventBroker broker = getBroker();
	if(broker!=null){
		broker.unsubscribe(getTreeExpandHandler());
		broker.unsubscribe(getTreeNodeSelctionHandler());
	}
	super.dispose();
}

public static boolean isAPIMperspective(){
	 IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	 IPerspectiveDescriptor perspective = workbenchWindow.getActivePage().getPerspective();
	
	if ("org.wso2.developerstudio.registry.remote.registry.apim.pespective".equals(perspective.getId())){
		return true;
	}
	return false;
}
}
