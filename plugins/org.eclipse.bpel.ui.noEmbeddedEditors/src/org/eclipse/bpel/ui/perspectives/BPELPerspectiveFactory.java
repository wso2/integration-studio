/*
 * Copyright (c) 2010, 2012 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.ui.perspectives;

import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.console.IConsoleConstants;

/*
 * This is the BPEL Perspective layout
 *
 * @see Bugzilla 324163
 * @author Bob Brodt
 * @date Aug 31, 2010
 */
public class BPELPerspectiveFactory implements IPerspectiveFactory {

	private static final String ID_NEW_BPEL_PROJECT_WIZARD="org.eclipse.bpel.runtimes.wizards.newBPELProject";
	private static final String ID_NEW_BPEL_FILE_WIZARD="org.eclipse.bpel.ui.newFile";
	private static final String ID_NEW_BPEL_DEPLOY_WIZARD="org.eclipse.bpel.apache.ode.deploy.ui.wizards.NewODEDeployWizard";
	private static final String ID_PALETTE_VIEW="org.eclipse.gef.ui.palette_view";
	private static final String ID_SERVERS_VIEW="org.eclipse.wst.server.ui.ServersView";
	// TODO: fix this
	//private static final String ID_SERVERS_ACTION_SET="org.jboss.tools.jst.web.ui.server.actionSet";


	public void createInitialLayout(IPageLayout layout) {

 		String editorArea = layout.getEditorArea();

 		// New wizards
 		layout.addNewWizardShortcut(ID_NEW_BPEL_PROJECT_WIZARD);
		layout.addNewWizardShortcut(ID_NEW_BPEL_FILE_WIZARD);
		layout.addNewWizardShortcut(ID_NEW_BPEL_DEPLOY_WIZARD);
		
		// view shortcuts
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(ID_PALETTE_VIEW);
		layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
		layout.addShowViewShortcut(ID_SERVERS_VIEW);
		
		// views
		IFolderLayout leftTop = layout.createFolder("leftTop", IPageLayout.LEFT, 0.2f, editorArea); //$NON-NLS-1$
		leftTop.addView(IPageLayout.ID_PROJECT_EXPLORER);
		leftTop.addPlaceholder(IPageLayout.ID_RES_NAV);

		IFolderLayout leftBottom = layout.createFolder("leftBottom", IPageLayout.BOTTOM, 0.7f, "leftTop"); //$NON-NLS-1$ //$NON-NLS-2$
		leftBottom.addView(ID_SERVERS_VIEW);			

		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.7f, editorArea); //$NON-NLS-1$
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView(IPageLayout.ID_TASK_LIST);
		bottom.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
		
		IFolderLayout rightTop = layout.createFolder("rightTop", IPageLayout.RIGHT, 0.8f, editorArea); //$NON-NLS-1$
		rightTop.addView(IPageLayout.ID_OUTLINE);

		IFolderLayout rightBottom = layout.createFolder("rightBottom", IPageLayout.BOTTOM, 0.4f, "rightTop"); //$NON-NLS-1$ //$NON-NLS-2$
		rightBottom.addView(ID_PALETTE_VIEW);			

		// action sets
		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
		//layout.addActionSet(ID_SERVERS_ACTION_SET);

		
	}
}
