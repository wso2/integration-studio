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

package org.wso2.developerstudio.eclipse.bpel.connector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.developerstudio.eclipse.bpel.core.handler.IBPELHandler;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.wso2.developerstudio.eclipse.bpel.connector.utils.BPELExtensionPointHandler;

public class Activator implements BundleActivator {

	private List<IBPELHandler> handlersList;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		BPELExtensionPointHandler.setBPELArtifactHandlers(getHandlersList());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	}

	public List<IBPELHandler> getHandlersList(){
		if (handlersList==null)
			handlersList=new ArrayList<IBPELHandler>();
	    return handlersList;
	}
}
