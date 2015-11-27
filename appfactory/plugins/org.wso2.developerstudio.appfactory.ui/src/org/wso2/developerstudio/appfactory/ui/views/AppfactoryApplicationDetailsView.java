/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.ui.views;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.appfactory.core.model.AppUserInfo;
import org.wso2.developerstudio.appfactory.core.model.AppVersionInfo;
import org.wso2.developerstudio.appfactory.core.model.ApplicationInfo;
import org.wso2.developerstudio.appfactory.core.model.DataSource;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.appfactory.ui.utils.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
public class AppfactoryApplicationDetailsView extends ViewPart {

    private static final int USERNAME_COULMN_INDEX = 2;
    private static final int DATASOURCE_URL_COLUMN_INDEX = 1;
    public static final String ID = "org.wso2.developerstudio.appfactory.ui.views.AppfactoryView";
	public static final String DS_WIZARD_ID = "org.eclipse.datatools.connectivity.internal.ui.wizards.newconnectionprofile";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String APPINFO_TAB_ITEM_NAME = "Application Info";
	private static final String CURRENT_STATUS_TAB_ITEM_NAME = "Build Status";
	private static final String TEAM_TAB_ITEM_NAME = "Team Details";
	private static final String DATA_SOURCES_TAB_ITEM_NAME = "Data Sources";
	private static final String DEFAULT_VALUE = "Not Available";
	private static final String BUILD_NULL_MSG = "build null null";
    private static final String NULL_MSG = "null";
    private static final String NOT_AVAILABLE_MSG = "N/A";

	private Table currentStatusTable;
	private Table teamDetailsTable;
	private Table dataSourcesTable;
	private TableEditor datasourceTableEditor;
	private Button dsConfigWizard;
	
	private Composite appTypeComposite;
	private Composite appOwnerComposite;
	private Composite descriptionComposite;
/*	private Composite databaseInfoComposite;
	private Composite databaseUsersComposite;
	private Composite databaseTemplatesComposite;*/
	private TabFolder tabFolder;
	private TabItem appInfoTabItem;
	private TabItem currentStatusTabItem;
	private TabItem teamTabItem;
	private TabItem dataSourcesTabItem;
    private TableEditor dbColumnEditor;
    private TableEditor userNameColumnEditor;

	public AppfactoryApplicationDetailsView() {
		AppfactoryApplicationListView.setAppDetailView(this);
	}

	public static Label createLabel(Composite parent, int style, String text, Object layoutData,
			Color backColor, Font font) {
		Label lbl = new Label(parent, style);
		if (font != null) {
			lbl.setFont(font);
		}
		if (backColor != null) {
			lbl.setBackground(backColor);
		}
		lbl.setText(text);
		if (layoutData != null) {
			// lbl.setLayoutData(layoutData);
		}
		return lbl;
	}

	private GridData getGridData() {
		GridData gd = new GridData();
		gd.minimumWidth = 50;
		gd.widthHint = GridData.FILL_HORIZONTAL;
		gd.grabExcessHorizontalSpace = true;
		return gd;
	}

	public void createPartControl(Composite parent) {
		tabFolder = new TabFolder(parent, SWT.BORDER);
		tabFolder.setBackground(tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		createToolbar();
		createTabPages();

		/*
		 * tabFolder.addSelectionListener(new SelectionListener() {
		 * 
		 * public void widgetDefaultSelected(SelectionEvent arg0) {
		 * updatePageContent(); }
		 * 
		 * public void widgetSelected(SelectionEvent arg0) {
		 * updatePageContent(); }
		 * 
		 * });
		 */
	}

	/**
	 * @param composite
	 */
	private void createCompositeLabel(Composite composite, String label) {
		createLabel(composite, SWT.NONE, label, new GridData(), composite.getBackground(),
				new Font(null, "", 11, SWT.BOLD));
	}

	public void updateView(ApplicationInfo applicationInfo) {
		// Updating the Application info
		updateAppInfo(applicationInfo);

		// Updating the version info table
		updateBuildStatus(applicationInfo);

		// Updating the team details
		updateTeamDetails(applicationInfo);

		// Updating the data sources details
		updateDataSources(applicationInfo);
	}
	
	/**
	 * Clear details view.
	 */
	public void clear(){
		
		// Clear Application Info Tab
		removeChildControls(appTypeComposite);
		removeChildControls(appOwnerComposite);
		removeChildControls(descriptionComposite);
        Control oldDBEditor = dbColumnEditor.getEditor();
        if (oldDBEditor != null) {
            oldDBEditor.dispose();
        }
        Control oldUNEditor = userNameColumnEditor.getEditor();
        if (oldUNEditor != null) {
            oldUNEditor.dispose();
        }
		currentStatusTable.removeAll();
		dataSourcesTable.clearAll();	
		teamDetailsTable.removeAll();
		
	}

	private void removeChildControls(Composite composite) {
		Control[] children = composite.getChildren();

		for (Control control : children) {
			control.dispose();
		}
	}

	@Override
	public void setFocus() {

		// Testing only
		// updateView();
	}

	/**
	 * Create tabs
	 */
	private void createTabPages() {
		appInfoTabItem = new TabItem(tabFolder, SWT.NULL);
		appInfoTabItem.setText(APPINFO_TAB_ITEM_NAME);

		currentStatusTabItem = new TabItem(tabFolder, SWT.NULL);
		currentStatusTabItem.setText(CURRENT_STATUS_TAB_ITEM_NAME);

		teamTabItem = new TabItem(tabFolder, SWT.NULL);
		teamTabItem.setText(TEAM_TAB_ITEM_NAME);

		dataSourcesTabItem = new TabItem(tabFolder, SWT.NULL);
		dataSourcesTabItem.setText(DATA_SOURCES_TAB_ITEM_NAME);

		createAppInfoPage();
		createCurrentStatusPage();
		createTeamDetailsPage();
		//createDbInfoPage();
		createDataSourcesPage();
	}

	/**
	 * Update page content on based on the selected tab
	 */
	/*private void updatePageContent() {
		int selectionIndex = tabFolder.getSelectionIndex();
		TabItem item = tabFolder.getItem(selectionIndex);

		if (item == appInfoTabItem) {
			// App Info tab
		} else if (item == currentStatusTabItem) {
			// Current Status tab
		} else if (item == teamTabItem) {
			// Team tab
		}
	}
*/
	/**
	 * Create application information tab page
	 */
	private void createAppInfoPage() {
		ScrolledComposite scroller = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		scroller.setBackground(tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		// scroller.setExpandVertical(true);
		scroller.setExpandHorizontal(true);
		Composite composite = new Composite(scroller, SWT.NULL);
		FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
		fillLayout.marginWidth = 20;
        composite.setLayout(fillLayout);
		composite.setBackground(tabFolder.getBackground());
		scroller.setContent(composite);
		scroller.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		String[] names = new String[] { "Application Type","Application Owner",
				"Description", "Version", "Repository URL" };

		createLabel(composite, SWT.NONE, "", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		createCompositeLabel(composite, names[0]);
		appTypeComposite = new Composite(composite, SWT.NONE);
		appTypeComposite.setBackground(tabFolder.getBackground());
		GridLayout appTypeGridLayout = new GridLayout(1, false);
		appTypeGridLayout.marginWidth = 20;
		appTypeComposite.setLayout(appTypeGridLayout);

		createLabel(composite, SWT.NONE, "", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		createCompositeLabel(composite, names[1]);
		appOwnerComposite = new Composite(composite, SWT.NONE);
		appOwnerComposite.setBackground(tabFolder.getBackground());
		GridLayout appOwnerGridLayout = new GridLayout(1, false);
		appOwnerGridLayout.marginWidth = 20;
		appOwnerComposite.setLayout(appOwnerGridLayout);

		createLabel(composite, SWT.NONE, "", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		createCompositeLabel(composite, names[2]);
		descriptionComposite = new Composite(composite, SWT.NONE);
		descriptionComposite.setBackground(tabFolder.getBackground());
		GridLayout descriptionGridLayout = new GridLayout(1, false);
		descriptionGridLayout.marginWidth = 20;
		descriptionComposite.setLayout(descriptionGridLayout);

		createLabel(composite, SWT.NONE, "", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		appInfoTabItem.setControl(scroller);
		composite.pack();
		composite.layout();
	}
	
	/*private void createDbInfoPage() {
		ScrolledComposite scroller = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		scroller.setBackground(tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		// scroller.setExpandVertical(true);
		scroller.setExpandHorizontal(true);
		Composite composite = new Composite(scroller, SWT.NULL);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		composite.setBackground(tabFolder.getBackground());
		scroller.setContent(composite);
		scroller.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		String[] names = new String[] { "Database Urls", "DB users", "DB Templates"};

		createLabel(composite, SWT.NONE, "adadad", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		createCompositeLabel(composite, names[0]);
		databaseInfoComposite = new Composite(composite, SWT.NONE);
		databaseInfoComposite.setBackground(tabFolder.getBackground());
		GridLayout appTypeGridLayout = new GridLayout(1, false);
		appTypeGridLayout.marginWidth = 20;
		databaseInfoComposite.setLayout(appTypeGridLayout);

		createLabel(composite, SWT.NONE, "adadad", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		createCompositeLabel(composite, names[1]);
		databaseUsersComposite = new Composite(composite, SWT.NONE);
		databaseUsersComposite.setBackground(tabFolder.getBackground());
		GridLayout repoTypeGridLayout = new GridLayout(1, false);
		repoTypeGridLayout.marginWidth = 20;
		databaseUsersComposite.setLayout(repoTypeGridLayout);

		createLabel(composite, SWT.NONE, "asdadadad", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));

		createCompositeLabel(composite, names[2]);
		databaseTemplatesComposite = new Composite(composite, SWT.NONE);
		databaseTemplatesComposite.setBackground(tabFolder.getBackground());
		GridLayout appOwnerGridLayout = new GridLayout(1, false);
		appOwnerGridLayout.marginWidth = 20;
		databaseTemplatesComposite.setLayout(appOwnerGridLayout);

		createLabel(composite, SWT.NONE, "adadadd", new GridData(), scroller.getBackground(), new Font(
				null, "", 15, SWT.BOLD));
		composite.pack();
		composite.layout();
	}*/

	/**
	 * Create current status tab page
	 */
	private void createCurrentStatusPage() {
		ScrolledComposite scroller = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		scroller.setBackground(tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		scroller.setExpandVertical(true);
		scroller.setExpandHorizontal(true);
		Composite composite = new Composite(scroller, SWT.NULL);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		scroller.setContent(composite);
		scroller.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		currentStatusTable = new Table(composite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		currentStatusTable.setLinesVisible(true);
		currentStatusTable.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		currentStatusTable.setLayoutData(data);

		String[] titles = { "Version", "Last Build Status", "Repository" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(currentStatusTable, SWT.BOLD);
			column.setText(titles[i]);
			column.pack();
		}

		currentStatusTabItem.setControl(scroller);
		// composite.pack();
	}

	/**
	 * Create team details tab page
	 */
	private void createTeamDetailsPage() {
		ScrolledComposite scroller = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		scroller.setBackground(tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		scroller.setExpandVertical(true);
		scroller.setExpandHorizontal(true);
		Composite composite = new Composite(scroller, SWT.NULL);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		composite.setBackground(tabFolder.getBackground());
		scroller.setContent(composite);
		scroller.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		teamDetailsTable = new Table(composite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		teamDetailsTable.setLinesVisible(true);
		teamDetailsTable.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		teamDetailsTable.setLayoutData(data);

		String[] titles = { "Name", "E-mail", "Role" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(teamDetailsTable, SWT.BOLD);
			column.setText(titles[i]);
			column.pack();
		}

		teamTabItem.setControl(scroller);
	}

	/**
	 * Create data sources tab page
	 */
	private void createDataSourcesPage() {
		ScrolledComposite scroller = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		scroller.setBackground(tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		scroller.setExpandVertical(true);
		scroller.setExpandHorizontal(true);
		Composite composite = new Composite(scroller, SWT.NULL);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		composite.setBackground(tabFolder.getBackground());
		scroller.setContent(composite);
		scroller.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		dataSourcesTable = new Table(composite, SWT.MULTI | SWT.BORDER	| SWT.FULL_SELECTION);
		dataSourcesTable.setLinesVisible(true);
		dataSourcesTable.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		dataSourcesTable.setLayoutData(data);
		
		datasourceTableEditor = new TableEditor(dataSourcesTable);
		datasourceTableEditor.grabHorizontal = true;

		dsConfigWizard = new Button(dataSourcesTable, SWT.PUSH);
		dsConfigWizard.setText("config wizard");
		dsConfigWizard.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				openDSSettingsWizard();
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
				widgetSelected(arg0);
			}
		});


		String[] titles = { "Name","DB URL","User"};
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(dataSourcesTable, SWT.BOLD);
			column.setText(titles[i]);
			column.pack();
		}
		dbColumnEditor = new TableEditor(dataSourcesTable);
		dbColumnEditor.horizontalAlignment = SWT.LEFT;
		dbColumnEditor.grabHorizontal = true;
        
        userNameColumnEditor = new TableEditor(dataSourcesTable);
        userNameColumnEditor.horizontalAlignment = SWT.LEFT;
        userNameColumnEditor.grabHorizontal = true;

		dataSourcesTable.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// Clean up any previous editor control
			    Control oldDBEditor = dbColumnEditor.getEditor();
		        if (oldDBEditor != null) {
		            oldDBEditor.dispose();
		        }
		        Control oldUNEditor = userNameColumnEditor.getEditor();
		        if (oldUNEditor != null) {
		            oldUNEditor.dispose();
		        }
				// Identify the selected row
				TableItem item = (TableItem) e.item;
				if (item == null)
					return;

				Text uRLEditor = new Text(dataSourcesTable, SWT.NONE);
				uRLEditor.setText(item.getText(DATASOURCE_URL_COLUMN_INDEX));
				uRLEditor.setEditable(false);
				uRLEditor.selectAll();
				uRLEditor.setFocus();
				dbColumnEditor.setEditor(uRLEditor, item, DATASOURCE_URL_COLUMN_INDEX);
				
                Text userNameEditor = new Text(dataSourcesTable, SWT.NONE);
                userNameEditor.setText(item.getText(USERNAME_COULMN_INDEX));
                userNameEditor.setEditable(false);
                userNameColumnEditor.setEditor(userNameEditor, item, USERNAME_COULMN_INDEX);
			}
		});

		dataSourcesTabItem.setControl(scroller);
	}

	/**
	 * Display application info of the selected application
	 * 
	 * @param applicationInfo
	 */
	private void updateAppInfo(ApplicationInfo applicationInfo) {
		try {
			removeChildControls(appTypeComposite);
			if (applicationInfo.getType() != null && !applicationInfo.getType().equals("")) {
				createLabel(appTypeComposite, SWT.NONE, applicationInfo.getType(), getGridData(),
						tabFolder.getBackground(), null);
			} else {
				createLabel(appTypeComposite, SWT.NONE, DEFAULT_VALUE, getGridData(),
						tabFolder.getBackground(), null);
			}
			appTypeComposite.pack();
			appTypeComposite.layout();
			removeChildControls(appOwnerComposite);
			if (applicationInfo.getApplicationOwner() != null
					&& !applicationInfo.getApplicationOwner().equals("")) {
				createLabel(appOwnerComposite, SWT.NONE, applicationInfo.getApplicationOwner(),
						getGridData(), tabFolder.getBackground(), null);
			} else {
				createLabel(appOwnerComposite, SWT.NONE, DEFAULT_VALUE, getGridData(),
						tabFolder.getBackground(), null);
			}
			appOwnerComposite.pack();
			appOwnerComposite.layout();
			removeChildControls(descriptionComposite);
			if (applicationInfo.getDescription() != null
					&& !applicationInfo.getDescription().equals("")) {
				createLabel(descriptionComposite, SWT.NONE, applicationInfo.getDescription(),
						getGridData(), tabFolder.getBackground(), null);
			} else {
				createLabel(descriptionComposite, SWT.NONE, DEFAULT_VALUE, getGridData(),
						tabFolder.getBackground(), null);
			}
			descriptionComposite.pack();
			descriptionComposite.layout();
		} catch (Exception e) {
          log.error("App Info loading issue", e);
		}
	}

	/**
	 * Display current status of the selected application
	 * 
	 * @param applicationInfo
	 */
	private void updateBuildStatus(ApplicationInfo applicationInfo) {
		try {
			// Remove existing
			currentStatusTable.removeAll();

			// Add new
			List<AppVersionInfo> version = applicationInfo.getappVersionList();
			for (AppVersionInfo appVersionInfo : version) {
				TableItem item = new TableItem(currentStatusTable, SWT.NONE);
				item.setText(0, appVersionInfo.getVersion());
                if (BUILD_NULL_MSG.equals(appVersionInfo.getLastBuildResult().trim())
                        || NULL_MSG.equals(appVersionInfo.getLastBuildResult().trim())) {
                    item.setText(1, NOT_AVAILABLE_MSG); //$NON-NLS-1$
                } else {
                    item.setText(1, appVersionInfo.getLastBuildResult());
                }
				item.setText(2, appVersionInfo.getRepoURL());
				 
			}

			// Pack the new one to table
			for (int i = 0; i < currentStatusTable.getColumnCount(); i++) {
				currentStatusTable.getColumn(i).pack();
			}
		} catch (Exception e) {
			log.error("BuildStatus loading issue", e);
		}
	}

	/**
	 * Display team details of the selected application
	 * 
	 * @param applicationInfo
	 */
	private void updateTeamDetails(ApplicationInfo applicationInfo) {
		try {
			teamDetailsTable.removeAll();
			List<AppUserInfo> appUsers = applicationInfo.getApplicationDevelopers();
			for (AppUserInfo appUser : appUsers) {
				TableItem item = new TableItem(teamDetailsTable, SWT.NONE);
				item.setText(0, appUser.getDisplayName());
				item.setText(1, appUser.getEmail());
				item.setText(2, appUser.getDisplayRolesAsString());
			}

			// Pack the new one to table
			for (int i = 0; i < teamDetailsTable.getColumnCount(); i++) {
				teamDetailsTable.getColumn(i).pack();
			}
		} catch (Exception e) {
			log.error("TeamDetails loading issue", e);
		}
	}

	/**
	 * Display data sources information of the selected application.
	 * 
	 * @param applicationInfo
	 */
	private void updateDataSources(ApplicationInfo applicationInfo) {
		
		try {
			dataSourcesTable.removeAll();			 
			List<DataSource> dataSources = applicationInfo.getDatasources();
			if(dataSources!=null && !dataSources.isEmpty()){
			   for (DataSource ds : dataSources) {
				   TableItem item = new TableItem(dataSourcesTable, SWT.NONE);
				   item.setText(0, ds.getName());
				   item.setText(1, ds.getConfig().get("url"));
				   item.setText(2, ds.getConfig().get("username"));
				  // datasourceTableEditor.setEditor(dsConfigWizard, item, 4);
				   
			   }
			   for (int i = 0; i < dataSourcesTable.getColumnCount(); i++) {
				   dataSourcesTable.getColumn(i).pack();
				}
			}
		} catch (Exception e) {
           log.error("Data source loading issue", e);
		} 
	}	
	
	private void openDSSettingsWizard() {

		IWizardDescriptor descriptor = PlatformUI.getWorkbench()
				.getNewWizardRegistry().findWizard(DS_WIZARD_ID);
		if (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getImportWizardRegistry()
					.findWizard(DS_WIZARD_ID);
		}
		if (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getExportWizardRegistry()
					.findWizard(DS_WIZARD_ID);
		}
		try {
			if (descriptor != null) {
				IWizard wizard = descriptor.createWizard();
				WizardDialog wd = new WizardDialog(dataSourcesTable.getShell(), wizard);
				wd.setTitle(wizard.getWindowTitle());
				wd.open();
			}
		} catch (Exception e) {
			 log.error("Wizard invoke error", e);
		}
	}
	
	 private void createToolbar() {
         IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
         mgr.add(new Action() {
        	 @Override
        	public void run() {
        		
        		 openDSSettingsWizard();
        	}
        	 
        	 @Override
 			public ImageDescriptor getImageDescriptor() {
 				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
 						 "/icons/repository_rep.gif"); //$NON-NLS-1$
 				return  imageDescriptorFromPlugin;
 			}
        	 
        	 @Override
        	public String getToolTipText() {
        		return Messages.AppfactoryApplicationDetailsView_createToolbar_refresh_menu;  
        	}
        	 
        	 
			});
      }
	
	
}
