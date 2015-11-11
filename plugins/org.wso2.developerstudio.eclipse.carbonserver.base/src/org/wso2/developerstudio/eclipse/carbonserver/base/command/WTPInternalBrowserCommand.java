/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.carbonserver.base.command;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.internal.browser.DefaultWebBrowser;
import org.wso2.developerstudio.eclipse.carbonserver.base.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class WTPInternalBrowserCommand {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static IWebBrowser browser = null;

	public static void popUpInrernalBrouwser(String inURL) {

		try {
			IWorkbenchBrowserSupport browserSupport = Activator.getDefault().getWorkbench().getBrowserSupport();

			browser = browserSupport.createBrowser(IWorkbenchBrowserSupport.LOCATION_BAR, null, null, null);
			URL url = new URL(inURL);
			browser.openURL(url);
		} catch (PartInitException e) {
			log.error(e);
		} catch (MalformedURLException e) {
			log.error(e);
		}
	}

	public static void popUpExternalBrouwser(String inURL) {

		try {
			IWorkbenchBrowserSupport browserSupport = Activator.getDefault().getWorkbench().getBrowserSupport();
			DefaultWebBrowser browser = new DefaultWebBrowser(null, "test");
			// browser =
			// browserSupport.createBrowser(IWorkbenchBrowserSupport.AS_EDITOR,null,
			// null, null);
			URL url = new URL(inURL);
			browser.openURL(url);
		} catch (PartInitException e) {
			log.error(e);
		} catch (MalformedURLException e) {
			log.error(e);
		}
	}

	public static void closeUpInrernalBrouwser() {
		browser.close();
	}

}
