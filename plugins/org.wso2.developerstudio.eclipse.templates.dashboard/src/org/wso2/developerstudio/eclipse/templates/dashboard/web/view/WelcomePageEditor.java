/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.templates.dashboard.web.view;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;


public class WelcomePageEditor extends EditorPart {
	
	private static final String INDEX_HTML = "index.html";
	private static final String WELCOME_PAGE_WEB_SITE_FOLDER = "TemplateDash"; //Folder of the web app
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	protected Browser browser;

	@Override
	public void doSave(IProgressMonitor arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IEditorSite arg0, IEditorInput arg1) throws PartInitException {
		setSite(arg0);
		setInput(arg1);	
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		browser = createBrowser(parent);
		try {
			browser.setUrl(getWelcomePage());
		} catch (URISyntaxException e) {
			log.error("Error while intializing Welcome Page", e);
		} catch (IOException e) {
			log.error("Error while intializing Welcome Page", e);
		}
	}

	private String getWelcomePage() throws URISyntaxException, IOException {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		URL webAppURL = bundle.getEntry(WELCOME_PAGE_WEB_SITE_FOLDER);
		URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
		URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
		File resolvedWebAppFolder = new File(resolvedFolderURI);
		File resolvedWebAppIndex = new File(resolvedWebAppFolder, INDEX_HTML);
		return resolvedWebAppIndex.getAbsolutePath();
	}

	private Browser createBrowser(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);
		Browser browser = new Browser(parent, WebEngineUtils.getBrowserType());
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.horizontalSpan = 1;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		browser.setLayoutData(data);
		setPortValueToJS(browser);
		return browser;
	}

    /**
     * This method sets port value retrieved from preferences to JS script of the page
     * @param browser started browser instance
     */
    private void setPortValueToJS(Browser browser) {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        String port = rootNode.get("portDetails", null);
        browser.execute("var portValue = '" + port + "';");
    }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
