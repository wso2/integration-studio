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
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.EditorPart;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.templates.dashboard.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server.FunctionServerConstants;


public class WelcomePageEditor extends EditorPart {
	
	private static final String INDEX_HTML = "index.html";
	private static final String WELCOME_PAGE_WEB_SITE_FOLDER = "WelcomeDashboard"; //Folder of the web app
	
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
	    String port = getPortValueForJS();
	    browser.setUrl("http://127.0.0.1:" + port + "/welcome?port=" + port + "&nocache=1");
	     
	    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    try {
	        PlatformUI.getWorkbench().showPerspective("WELCOME_PERSPECTIVE", window);
	    } catch (WorkbenchException e) {
	        log.error("Could not load the perspective.", e);
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
		return browser;
	}

    /**
     * This method gets port value retrieved from preferences
     * @param browser started browser instance
     */
    private String getPortValueForJS() {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        return rootNode.get("portDetails", String.valueOf(FunctionServerConstants.EMBEDDED_SERVER_PORT));
    }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
