/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.webui.core.composite;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.wso2.developerstudio.eclipse.embedded.tomcat.api.IWebAppManager;
import org.wso2.developerstudio.eclipse.embedded.tomcat.exception.EmbeddedTomcatException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.webui.core.WebUICorePlugin;
import org.wso2.developerstudio.eclipse.webui.core.composite.function.DisposeCompositeCallback;
import org.wso2.developerstudio.eclipse.webui.core.composite.function.ResizeCompositeCallback;
import org.wso2.developerstudio.eclipse.webui.core.exception.WebUIException;
import org.wso2.developerstudio.eclipse.webui.core.model.BrowserScript;

public class WebComposite extends Composite {

	protected Browser browser;
	protected String appID;
	protected String appContext;
	protected URL appURL;

	protected static IDeveloperStudioLog log = Logger
			.getLog(WebUICorePlugin.PLUGIN_ID);

	public WebComposite(String appID, Composite parent, int style)
			throws WebUIException {
		super(parent, style);
		this.appID = appID;
		setLayout(new FillLayout(SWT.HORIZONTAL));
		init();
	}

	public WebComposite(String appID, String appContext, Composite parent,
			int style) throws WebUIException {
		super(parent, style);
		this.appID = appID;
		this.appContext = appContext;
		setLayout(new FillLayout(SWT.HORIZONTAL));
		init();
	}

	public WebComposite(URL appURL, Composite parent, int style)
			throws WebUIException {
		super(parent, style);
		this.appURL = appURL;
		setLayout(new FillLayout(SWT.HORIZONTAL));
		init();
	}

	protected void onLoadComplete() {

	}

	protected String getURL() throws WebUIException {
		if (appURL != null) {
			return appURL.toString();
		}
		IWebAppManager appManagerRef = WebUICorePlugin.getDefault()
				.getAppManager();
		if (appManagerRef != null) {
			try {
				String appURL = appManagerRef.getAppURL(appID);
				if (appContext != null) {
					appURL += appContext;
				}
				return appURL;
			} catch (EmbeddedTomcatException e) {
				throw new WebUIException("Error while fetching web app URL"
						+ " from WebAppManager service.", e);
			}
		}
		throw new WebUIException("Error fetching web app URL "
				+ "from WebAppManager service. Service reference is null.");
	}

	public void executeScript(BrowserScript script) throws WebUIException {
		if (browser != null) {
			boolean success = browser.execute(script.getScript());
			if (!success) {
				throw new WebUIException("Error executing Script:"
						+ script.getScriptName()
						+ " Browser returned execution failed status.");
			}
		} else {
			throw new WebUIException("Error executing Script:"
					+ script.getScriptName() + ". Browser instance not found.");
		}
	}

	private void init() throws WebUIException {
		browser = new Browser(this, SWT.NONE);
		browser.setLayout(new FillLayout(SWT.HORIZONTAL));
		browser.setUrl(getURL());
		browser.addProgressListener(new ProgressListener() {

			@Override
			public void completed(ProgressEvent arg0) {
				onLoadComplete();
			}

			@Override
			public void changed(ProgressEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		browser.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		this.pack();
		injectCallbacks();
	}

	private void injectCallbacks() {
		new DisposeCompositeCallback(this);
		new ResizeCompositeCallback(this);
	}

	public Browser getBrowser() {
		return browser;
	}

}
