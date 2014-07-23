/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.ui.perspective;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.appfactory.ui.actions.LoginAction;
import org.wso2.developerstudio.appfactory.ui.utils.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class AppFactoryPerspectiveFactory implements IPerspectiveFactory {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String APPLIST_ID = "org.wso2.developerstudio.appfactory.ui." + //$NON-NLS-1$
			"views.AppfactoryApplicationListView"; //$NON-NLS-1$
	private static final String APPDETILS_ID = "org.wso2.developerstudio.appfactory.ui." + //$NON-NLS-1$
			"views.AppfactoryApplicationDetailsView"; //$NON-NLS-1$
/*	private static final String APPBUILD_ID = "org.wso2.developerstudio.appfactory.ui." + //$NON-NLS-1$
			"views.AppfactoryBuildInfoView"; //$NON-NLS-1$
*/	private static final String PROJECT_EXPOR_VIEW = "org.eclipse.ui.navigator.ProjectExplorer"; //$NON-NLS-1$
	
	private static final String GhostView = "org.wso2.developerstudio.appfactory.ui.views.AppfactoryGhostViewId"; //$NON-NLS-1$
	
	//private static IWebBrowser browser = null;
 
	public void createInitialLayout(IPageLayout appfacLayout) {

		try {
			initAfViewsloadingProcess(appfacLayout);
		} catch (Exception e) {
			log.error("Perspective loading issue", e); //$NON-NLS-1$
		}
	}

	private void initAfViewsloadingProcess(IPageLayout appfacLayout)
			throws InvocationTargetException, InterruptedException {
		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
				Display.getDefault().getActiveShell());
		progressMonitorDialog.create();
		progressMonitorDialog.open();
		progressMonitorDialog.run(true, false,
				new LoadAppFacPerfectiveJob(appfacLayout));
	}
	
	private void addGostView(IPageLayout appfacLayout){
		String editorArea = appfacLayout.getEditorArea();
		IFolderLayout lef = appfacLayout.createFolder("topLeft", //$NON-NLS-1$
				IPageLayout.LEFT, 0.25f, editorArea);
		lef.addView(GhostView);
	}

	private void addViews(IPageLayout appfacLayout) {
		String editorArea = appfacLayout.getEditorArea();
		IFolderLayout lef = appfacLayout.createFolder("topLeft", //$NON-NLS-1$
				IPageLayout.LEFT, 0.25f, editorArea);
		lef.addView(PROJECT_EXPOR_VIEW);

		IFolderLayout applist = appfacLayout.createFolder("topRight", //$NON-NLS-1$
				IPageLayout.RIGHT, 0.70f, editorArea);
		applist.addView(APPLIST_ID);

		IFolderLayout appDetails = appfacLayout.createFolder("BottomRight", //$NON-NLS-1$
				IPageLayout.BOTTOM, 0.60f, "topRight"); //$NON-NLS-1$
		appDetails.addView(APPDETILS_ID);

		IFolderLayout buildInfo = appfacLayout.createFolder("Bottomt", //$NON-NLS-1$
				IPageLayout.BOTTOM, 0.60f, appfacLayout.getEditorArea());
		buildInfo.addView(IConsoleConstants.ID_CONSOLE_VIEW);
	}

	private class LoadAppFacPerfectiveJob implements IRunnableWithProgress {

	//	private LoginAction loginAction;
		private IPageLayout appfacLayout;

		public LoadAppFacPerfectiveJob(IPageLayout appfacLayout) {
			//this.loginAction = loginAction;
			this.appfacLayout = appfacLayout;
		}

		@Override
		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			String operationText = Messages.AppFactoryPerspectiveFactory_LoadAppFacPerfectiveJob_monitor_op_text1;
			monitor.beginTask(operationText, 100);
			monitor.worked(10);
			try {
				AppFactoryPerspectiveManager.val = false;
				operationText = Messages.AppFactoryPerspectiveFactory_LoadAppFacPerfectiveJob_monitor_op_text2;
				monitor.subTask(operationText);
				monitor.worked(50);
				operationText = Messages.AppFactoryPerspectiveFactory_LoadAppFacPerfectiveJob_monitor_op_text3;
				monitor.subTask(operationText);
				addViews(appfacLayout);
				monitor.worked(80);
				operationText = Messages.AppFactoryPerspectiveFactory_LoadAppFacPerfectiveJob_monitor_op_text4;
				monitor.subTask(operationText);
				monitor.worked(100);
			} catch (Exception e) {
				operationText = e.getMessage();
				monitor.subTask(Messages.AppFactoryPerspectiveFactory_LoadAppFacPerfectiveJob_monitor_op_text5+operationText);
				monitor.worked(0);
				monitor.setCanceled(true);
				log.error("updateprocess error", e); //$NON-NLS-1$
			}

			monitor.worked(100);
			monitor.done();
		}
	}
	
	
	
	
}
