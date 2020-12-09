/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.cloud.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.esb.cloud.client.IntegrationCloudServiceClient;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Application;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Runtime;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Version;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudDeploymentWizardConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Wizard Page to enter application details
 *
 */
public class AppDetailsWizardPage extends WizardPage {

    // Dialog string values
    private static final String DIALOG_TITLE = "WSO2 Integration Cloud - Create new application";

    // Text field labels
    private static final String APPLICATION_VERSION_LABEL_TEXT = "Application version *";
    private static final String APPLICATION_NAME_LABEL_TEXT = "Application name *";
    private static final String APPLICATION_RUNTIME_LABEL_TEXT = "Application runtime *";
    private static final String DESCRIPTION_LABEL_TEXT = "Description";
    private static final String APP_ICON_LABEL_TEXT = "Icon";
    private static final String TAGS_LABEL_TEXT = "Tags";

    // Button / Radio Button Strings
    private static final String BROWSE_LABEL_TEXT = "Browse";
    private static final String CREATE_NEW_APPLICATION_TEXT = "Create New Application";
    private static final String CREATE_NEW_VERSION_TEXT = "Create New Version";

    private static final String EMPTY_STRING = "";

    private static final String[] FILTER_NAMES = { "Images(*.jpg)", "Images(*.jpeg)", "Images(*.png)" };

    // These filter extensions are used to filter which files are displayed.
    private static final String[] FILTER_EXTS = { "*.jpg", "*.jpeg", "*.png" };

    // Elements
    private Button btnNewApplication;
    private Button btnExistingApplication;
    private Combo appNames;
    private Text newVersion;
    Combo createAppRuntimeCombo = null;
    Combo createVersionRuntimeCombo = null;

    // Application values
    private String name = EMPTY_STRING;
    private String version = EMPTY_STRING;
    private String description = EMPTY_STRING;
    private String appIcon = EMPTY_STRING;
    private List<Map<String, String>> tags = new ArrayList<>();
    private boolean isNewVersion;
    private int runtime;

    private String initialName = EMPTY_STRING;
    private String initialVersion = EMPTY_STRING;
    private String initialDescription = EMPTY_STRING;
    private String initialappIcon = EMPTY_STRING;

    private String fontName;
    private int fontStyle;

    private IProject selectedProject;
    private boolean isPageDirty = false;

    private String[] applicationNames;
    private List<Application> applicationList;
    public List<Runtime> runtimeList;

    private IntegrationCloudServiceClient client;

    private String[] runtimeNames;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    protected AppDetailsWizardPage() {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        client = IntegrationCloudServiceClient.getInstance();
        runtimeList = new ArrayList<>();
        runtimeNames = new String[] { "" };
    }

    protected AppDetailsWizardPage(IWorkbench wb, IStructuredSelection selection) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        runtimeList = new ArrayList<>();

        try {
            IProject project = getProject(selection);
            if (project != null) {
                setSelectedProject(project);
            }
        } catch (CoreException e) {
            log.error("Error getting session properties", e);
        } catch (Exception e) {
            log.error("Error reading project", e);
        }
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new GridLayout(1, false));

        // Application Type Options

        Group appTypeGroup = new Group(container, SWT.NONE);
        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        rowLayout.marginLeft = 10;
        rowLayout.marginRight = 130;
        rowLayout.marginBottom = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 200;

        appTypeGroup.setLayout(rowLayout);

        btnNewApplication = new Button(appTypeGroup, SWT.RADIO);
        btnNewApplication.setText(CREATE_NEW_APPLICATION_TEXT);
        btnNewApplication.setSelection(true);

        btnExistingApplication = new Button(appTypeGroup, SWT.RADIO);
        btnExistingApplication.setText(CREATE_NEW_VERSION_TEXT);

        // =========== Create new Application container ======================
        Composite newAppContainer = new Composite(container, SWT.NULL);

        GridData newAppGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        newAppGridData.exclude = false;
        newAppContainer.setLayoutData(newAppGridData);

        setControl(newAppContainer);
        newAppContainer.setLayout(new GridLayout(3, false));
        newAppContainer.setVisible(true);

        // Application Name
        createNameInput(parent, newAppContainer);

        // Application Version
        createVersionInput(parent, newAppContainer);

        // Application Description
        createDescriptionInput(newAppContainer);
        
        // Application Runtimes
        createRuntimeSelectInputForCreateApp(parent, newAppContainer);

        // Application Icon
        createApplicationIconInput(newAppContainer);

        // Tags
        createTagsInput(newAppContainer);

        // ============== Update existing application container ===============
        Composite existingAppContainer = new Composite(container, SWT.NULL);
        GridData existingAppData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        existingAppData.exclude = true;
        existingAppContainer.setLayoutData(existingAppData);

        setControl(existingAppContainer);
        existingAppContainer.setLayout(new GridLayout(3, false));
        existingAppContainer.setVisible(false);

        setDescription(initialDescription);
        setAppIcon(initialappIcon);
        this.tags = new ArrayList<>();

        // Create new application radio button listener
        btnNewApplication.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();

                if (source.getSelection()) {
                    newAppGridData.exclude = false;
                    existingAppData.exclude = true;
                    newAppContainer.setVisible(true);
                    existingAppContainer.setVisible(false);
                    newAppContainer.getParent().pack();

                    setNewVersion(false);
                    setName(getInitialName());
                    setVersion(getInitialVersion());
                }
                
                validate();
            }

        });

        // Create new version radio button listener
        btnExistingApplication.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                Button source = (Button) e.getSource();

                if (source.getSelection()) {
                    newAppGridData.exclude = true;
                    existingAppData.exclude = false;
                    newAppContainer.setVisible(false);
                    existingAppContainer.setVisible(true);
                    existingAppContainer.getParent().pack();

                }

                setNewVersion(true);

                // Retrieve applicationlist

                if (null == applicationNames) {
                    try {
                        applicationList = client.getApplicationList();
                        applicationNames = getApplicationNames(applicationList);
                        appNames.setItems(applicationNames);

                    } catch (CloudDeploymentException | InvalidTokenException | HttpClientException ex) {
                        log.error(
                                CloudDeploymentWizardConstants.ErrorMessages.APPLICATION_LIST_RETRIEVAL_FAILED_MESSAGE,
                                ex);
                        setErrorMessage(
                                CloudDeploymentWizardConstants.ErrorMessages.APPLICATION_LIST_RETRIEVAL_FAILED_MESSAGE);
                        setPageComplete(false);
                    } catch (NetworkUnavailableException ex) {
                        log.error(CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE, ex);
                        setErrorMessage(CloudDeploymentWizardConstants.ErrorMessages.NO_INTERNET_CONNECTION_MESSAGE);
                        setPageComplete(false);
                    }
                }

                validate();
            }
        });

        // Application Name
        createNameSelectInput(parent, existingAppContainer);

        // Application Version
        newVersion = createVersionInput(parent, existingAppContainer);
        
        // Application Runtimes
        createRuntimeSelectInputForVersionCreation(parent, existingAppContainer);

        // Tags
        createTagsInput(existingAppContainer);

    }

    /**
     * Retrieve the application names from a list of Application objects
     * 
     * @param applications
     * @return
     */
    private String[] getApplicationNames(List<Application> applications) {
        String[] applicationNames = new String[applications.size()];
        for (int i = 0; i < applications.size(); i++) {
            applicationNames[i] = applications.get(i).getApplicationName();
        }
        return applicationNames;
    }

    /**
     * Create the tag table
     * 
     * @param newAppContainer
     */
    private void createTagsInput(Composite newAppContainer) {
        Label lblTags = new Label(newAppContainer, SWT.NONE);
        lblTags.setText(TAGS_LABEL_TEXT);
        GridData lblTagsGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblTags.setLayoutData(lblTagsGridData);

        new Label(newAppContainer, SWT.NONE);
        new Label(newAppContainer, SWT.NONE);

        // Tag table

        Composite tagsContainer = new Composite(newAppContainer, SWT.NULL);

        GridData tagsContainerGridData = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
        tagsContainerGridData.exclude = false;
        tagsContainer.setLayoutData(tagsContainerGridData);

        setControl(tagsContainer);
        tagsContainer.setLayout(new GridLayout(2, false));
        tagsContainer.setVisible(true);

        Table tblTags = new Table(tagsContainer, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
        GridData tableGridData = new GridData(SWT.LEFT, SWT.TOP, true, false, 1, 1);
        tableGridData.heightHint = 200;
        tblTags.setLayoutData(tableGridData);
        tblTags.setHeaderVisible(true);

        TableColumn column = new TableColumn(tblTags, SWT.NONE);
        column.setText("Key");
        column.setWidth(300);
        column.setResizable(false);

        TableColumn column2 = new TableColumn(tblTags, SWT.NONE);
        column2.setText("Value");
        column2.setWidth(300);
        column2.setResizable(false);

        final TableEditor editor = new TableEditor(tblTags);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        tblTags.addListener(SWT.MouseDown, event -> {
            Rectangle clientArea = tblTags.getClientArea();
            Point pt = new Point(event.x, event.y);
            int index = tblTags.getTopIndex();
            while (index < tblTags.getItemCount()) {
                boolean visible = false;
                final TableItem tblitem = tblTags.getItem(index);
                tblitem.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
                for (int i = 0; i < tblTags.getColumnCount(); i++) {
                    Rectangle rect = tblitem.getBounds(i);
                    if (rect.contains(pt)) {
                        final int tblcolumn = i;
                        final Text text = new Text(tblTags, SWT.NONE);
                        Listener textListener = e -> {
                            switch (e.type) {
                            case SWT.FocusOut:
                                tblitem.setText(tblcolumn, text.getText());
                                text.dispose();
                                break;
                            case SWT.Traverse:
                                switch (e.detail) {
                                case SWT.TRAVERSE_RETURN:
                                    tblitem.setText(tblcolumn, text.getText());
                                    // FALL THROUGH
                                case SWT.TRAVERSE_ESCAPE:
                                    text.dispose();
                                    e.doit = false;
                                }
                                break;
                            case SWT.Modify:
                                tblitem.setText(tblcolumn, text.getText());
                                saveTags(tblTags);
                                break;
                            }
                        };
                        text.addListener(SWT.FocusOut, textListener);
                        text.addListener(SWT.Traverse, textListener);
                        text.addListener(SWT.Modify, textListener);

                        editor.setEditor(text, tblitem, i);
                        text.setText(tblitem.getText(i));
                        text.selectAll();
                        text.setFocus();

                        return;
                    }
                    if (!visible && rect.intersects(clientArea)) {
                        visible = true;
                    }
                }
                if (!visible)
                    return;
                index++;
            }
        });

        Group btnGroup = new Group(tagsContainer, SWT.NONE);
        RowLayout btnRowLayout = new RowLayout(SWT.VERTICAL);

        btnGroup.setLayout(btnRowLayout);

        Button btnAdd = new Button(btnGroup, SWT.NONE);
        btnAdd.setText("+");

        Button btnRemove = new Button(btnGroup, SWT.NONE);
        btnRemove.setText("-");

        btnAdd.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                TableItem item = new TableItem(tblTags, SWT.BORDER);
                item.setBackground(new Color(Display.getCurrent(), 44, 96, 218));
            }

        });

        btnRemove.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                int item = tblTags.getSelectionIndex();
                tblTags.remove(item);
            }

        });
    }

    /**
     * Create an input for application icon
     * 
     * @param newAppContainer
     */
    private void createApplicationIconInput(Composite newAppContainer) {
        Label lblAppIcon = new Label(newAppContainer, SWT.NONE);
        lblAppIcon.setText(APP_ICON_LABEL_TEXT);
        GridData lblAppIconGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblAppIcon.setLayoutData(lblAppIconGridData);

        Composite appIconContainer = new Composite(newAppContainer, SWT.NULL);

        GridData appIconGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        appIconGridData.exclude = false;
        appIconContainer.setLayoutData(appIconGridData);

        setControl(appIconContainer);
        GridLayout browseLayout = new GridLayout(2, false);
        browseLayout.marginLeft = 0;
        browseLayout.marginHeight = 0;
        browseLayout.marginWidth = 0;
        browseLayout.marginRight = 0;
        appIconContainer.setLayout(browseLayout);
        appIconContainer.setVisible(true);

        Text txtBrowse = new Text(appIconContainer, SWT.BORDER);
        GridData txtBrowseGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        txtBrowseGridData.widthHint = 400;
        txtBrowse.setLayoutData(txtBrowseGridData);

        txtBrowse.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setAppIcon(txtBrowse.getText());
                validate();
            }

        });

        Button btnBrowse = new Button(appIconContainer, SWT.NONE);
        btnBrowse.setText(BROWSE_LABEL_TEXT);

        btnBrowse.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
                dialog.setFilterNames(FILTER_NAMES);
                dialog.setFilterExtensions(FILTER_EXTS);
                String result = dialog.open();
                if (result != null) {
                    txtBrowse.setText(result);
                }
                validate();
            }

        });
        new Label(newAppContainer, SWT.NONE);
    }

    /**
     * Create an input for description
     * 
     * @param newAppContainer
     */
    private void createDescriptionInput(Composite newAppContainer) {
        Label lblDescription = new Label(newAppContainer, SWT.NONE);
        GridData lblDescriptionGridData = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
        lblDescription.setLayoutData(lblDescriptionGridData);
        lblDescription.setText(DESCRIPTION_LABEL_TEXT);

        Text txtDescription = new Text(newAppContainer, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
        GridData txtDescriptionGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        txtDescriptionGridData.widthHint = 465;
        txtDescriptionGridData.heightHint = 80;
        txtDescription.setLayoutData(txtDescriptionGridData);

        txtDescription.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setDescription(txtDescription.getText());
                validate();
            }

        });
    }

    /**
     * Create an input for version
     * 
     * @param parent
     * @param newAppContainer
     */
    private Text createVersionInput(Composite parent, Composite newAppContainer) {
        StyledText lblVersion = new StyledText(newAppContainer, SWT.NONE);
        lblVersion.setText(APPLICATION_VERSION_LABEL_TEXT);

        StyleRange versionRange = new StyleRange(lblVersion.getCharCount() - 1, 1,
                CloudDeploymentWizardConstants.Colors.red, null);
        lblVersion.setStyleRange(versionRange);
        lblVersion.setFont(new Font(parent.getDisplay(), fontName, 12, fontStyle));

        Text txtVersion = new Text(newAppContainer, SWT.BORDER);
        GridData txtVersionGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        txtVersionGridData.widthHint = 480;
        initialVersion = getVersion();
        txtVersion.setText(initialVersion);
        txtVersion.setLayoutData(txtVersionGridData);

        txtVersion.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setVersion(txtVersion.getText());
                validate();
            }

        });
        return txtVersion;
    }

    /**
     * Create an input for name
     * 
     * @param parent
     * @param container
     */
    private Text createNameInput(Composite parent, Composite container) {
        StyledText lblName = new StyledText(container, SWT.NONE);
        FontData data = lblName.getFont().getFontData()[0];
        fontName = data.getName();
        fontStyle = data.getStyle();

        GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblName.setLayoutData(lblNameGridData);
        lblName.setText(APPLICATION_NAME_LABEL_TEXT);

        StyleRange appNameRange = new StyleRange(lblName.getCharCount() - 1, 1,
                CloudDeploymentWizardConstants.Colors.red, null);
        lblName.setStyleRange(appNameRange);
        lblName.setFont(new Font(parent.getDisplay(), fontName, 12, fontStyle));

        Text txtName = new Text(container, SWT.BORDER);
        GridData txtNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        txtNameGridData.widthHint = 480;
        txtName.setLayoutData(txtNameGridData);
        initialName = getName();
        txtName.setText(initialName);

        txtName.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setName(txtName.getText());
                validate();
            }

        });
        return txtName;
    }

    /**
     * Create a select input for runtimes for app creation
     * 
     * @param parent
     * @param container
     */
    private void createRuntimeSelectInputForCreateApp(Composite parent, Composite container) {
        StyledText lblName = new StyledText(container, SWT.NONE);
        FontData data = lblName.getFont().getFontData()[0];
        fontName = data.getName();
        fontStyle = data.getStyle();

        GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblName.setLayoutData(lblNameGridData);
        lblName.setText(APPLICATION_RUNTIME_LABEL_TEXT);

        StyleRange appNameRange = new StyleRange(lblName.getCharCount() - 1, 1,
                CloudDeploymentWizardConstants.Colors.red, null);
        lblName.setStyleRange(appNameRange);
        lblName.setFont(new Font(parent.getDisplay(), fontName, 12, fontStyle));

        createAppRuntimeCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);

        String[] items = runtimeNames;

        createAppRuntimeCombo.setItems(items);
        selectDefaultRuntime(createAppRuntimeCombo);

        GridData txtNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        txtNameGridData.widthHint = 480;
        createAppRuntimeCombo.setLayoutData(txtNameGridData);

        createAppRuntimeCombo.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int idx = createAppRuntimeCombo.getSelectionIndex();
                String runtime = createAppRuntimeCombo.getItem(idx);
                setRuntime(getRuntimeId(runtime));
                validate();
            }
        });
    }
    
    /**
     * Create a select input for runtimes for version creation
     * 
     * @param parent
     * @param container
     */
    private void createRuntimeSelectInputForVersionCreation(Composite parent, Composite container) {
        StyledText lblName = new StyledText(container, SWT.NONE);
        FontData data = lblName.getFont().getFontData()[0];
        fontName = data.getName();
        fontStyle = data.getStyle();

        GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblName.setLayoutData(lblNameGridData);
        lblName.setText(APPLICATION_RUNTIME_LABEL_TEXT);

        StyleRange appNameRange = new StyleRange(lblName.getCharCount() - 1, 1,
                CloudDeploymentWizardConstants.Colors.red, null);
        lblName.setStyleRange(appNameRange);
        lblName.setFont(new Font(parent.getDisplay(), fontName, 12, fontStyle));

        createVersionRuntimeCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);

        String[] items = runtimeNames;

        createVersionRuntimeCombo.setItems(items);
        selectDefaultRuntime(createVersionRuntimeCombo);
        
        GridData txtNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        txtNameGridData.widthHint = 480;
        createVersionRuntimeCombo.setLayoutData(txtNameGridData);

        createVersionRuntimeCombo.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int idx = createVersionRuntimeCombo.getSelectionIndex();
                String runtime = createVersionRuntimeCombo.getItem(idx);
                setRuntime(getRuntimeId(runtime));
                validate();
            }
        });
    }

    private int getRuntimeId(String runtimeName) {
        for (Runtime runtime : runtimeList) {
            if (runtime.getRuntimeName().equals(runtimeName)) {
                return runtime.getId();
            }
        }
        return -1;
    }

    /**
     * Create a select input for exisiting applications
     * 
     * @param parent
     * @param container
     */
    private void createNameSelectInput(Composite parent, Composite container) {
        StyledText lblName = new StyledText(container, SWT.NONE);
        FontData data = lblName.getFont().getFontData()[0];
        fontName = data.getName();
        fontStyle = data.getStyle();

        GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblName.setLayoutData(lblNameGridData);
        lblName.setText(APPLICATION_NAME_LABEL_TEXT);

        StyleRange appNameRange = new StyleRange(lblName.getCharCount() - 1, 1,
                CloudDeploymentWizardConstants.Colors.red, null);
        lblName.setStyleRange(appNameRange);
        lblName.setFont(new Font(parent.getDisplay(), fontName, 12, fontStyle));

        appNames = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);

        String[] items = new String[] { "" };

        appNames.setItems(items);

        GridData txtNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
        txtNameGridData.widthHint = 480;
        appNames.setLayoutData(txtNameGridData);

        appNames.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int idx = appNames.getSelectionIndex();
                String application = appNames.getItem(idx);
                setName(application);
                validate();
            }
        });
    }
    
    /**
     * Selects and sets the default runtime value
     * 
     * @param combo
     */
    public void selectDefaultRuntime(Combo combo) {
        combo.select(0);
        String runtime = combo.getItem(0);
        setRuntime(getRuntimeId(runtime));
    }

    /**
     * Saves tags as user updates them
     * 
     * @param tblTags
     */
    public void saveTags(Table tblTags) {
        List<Map<String, String>> tags = new ArrayList<>();
        TableItem[] items = tblTags.getItems();
        if (items != null && items.length > 0) {
            for (TableItem item : items) {
                Map<String, String> tag = new HashMap<>();

                if (null != item.getText(0) && !item.getText(0).equals(EMPTY_STRING) && null != item.getText(1)
                        && !item.getText(1).equals(EMPTY_STRING)) {
                    // Retrieve key and value column values from the table
                    tag.put("key", item.getText(0));
                    tag.put("value", item.getText(1));
                    tags.add(tag);
                }
            }
        }
        this.tags = tags;
    }

    public List<Map<String, String>> getTags() {
        return this.tags;
    }

    /**
     * Validates text field values
     */
    private void validate() {
        setPageComplete(false);
        if (!isNewVersion) {
            if ((getName() == null || getName().equals(EMPTY_STRING)) || getVersion() == null
                    || getVersion().equals(EMPTY_STRING)) {
                setErrorMessage("Please specify a name and version to .car file.");
                return;
            } else if (getRuntime() == 0) {
                setErrorMessage("Please select a runtime.");
                return;
            } else {
                String version = getVersion();
                String[] versionParts = version.split("\\.");
                if (version.endsWith(".")) {
                    setErrorMessage("Application version cannot end with period.");
                    return;
                }
                if (versionParts.length > 4) {
                    setErrorMessage("Application version should be in the standared format.");
                    return;
                }
                if (!Character.isDigit(version.charAt(0))) {
                    setErrorMessage("Application version should start with a numeric value.");
                    return;
                }
            }
        } else {
            if (appNames.getText() == null || appNames.getText().equals(EMPTY_STRING)) {
                setErrorMessage("Please select an application.");
                return;
            } else if (getRuntime() == 0) {
                setErrorMessage("Please select a runtime.");
                return;
            } else {
                String version = newVersion.getText();
                String[] versionParts = version.split("\\.");
                if (version.endsWith(".")) {
                    setErrorMessage("Application version cannot end with period.");
                    return;
                }
                if (versionParts.length > 4) {
                    setErrorMessage("Application version should be in the standared format.");
                    return;
                }
                if (!Character.isDigit(version.charAt(0))) {
                    setErrorMessage("Application version should start with a numeric value.");
                    return;
                }
            }
        }

        setPageDirtyState();
        setErrorMessage(null);
        setPageComplete(true);
    }

    private void setPageDirtyState() {
        if (getName().equals(initialName) && getVersion().equals(initialVersion)) {
            isPageDirty = false;
        } else {
            isPageDirty = true;
        }
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public static IProject getProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }

    public void setSelectedProject(IProject selectedProject) {
        this.selectedProject = selectedProject;
    }

    public IProject getSelectedProject() {
        return selectedProject;
    }

    public void setName(String carName) {
        this.name = carName;
    }

    public String getName() {
        return name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public boolean isNewVersion() {
        return isNewVersion;
    }

    public void setNewVersion(boolean isNewVersion) {
        this.isNewVersion = isNewVersion;
    }

    public void setInitialName(String carName) {
        this.initialName = carName;
    }

    public String getInitialName() {
        return initialName;
    }

    public void setInitialVersion(String version) {
        this.initialVersion = version;
    }

    public String getInitialVersion() {
        return initialVersion;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Combo getCreateAppRuntimeCombo() {
        return createAppRuntimeCombo;
    }
    
    public Combo getCreateVersionRuntimeCombo() {
        return createVersionRuntimeCombo;
    }

    public void setRuntimes(String[] runtimeNames) {
        this.runtimeNames = runtimeNames;
    }

}
