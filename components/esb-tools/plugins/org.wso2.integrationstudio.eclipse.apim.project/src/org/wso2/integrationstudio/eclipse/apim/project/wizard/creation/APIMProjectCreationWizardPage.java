/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.integrationstudio.eclipse.apim.project.wizard.creation;

import java.io.File;
import java.net.URL;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.eclipse.apim.project.constant.APIMConstant;
import org.wso2.integrationstudio.eclipse.platform.core.utils.Validator;

public class APIMProjectCreationWizardPage extends WizardPage {

    private static final String DIALOG_TITLE = "Create New APIM Project";
    private static final String DESCRIPTION = "Create new APIM project with an API definition";

    private Text txtProjectName;
    private Text txtProjectLocation;
    private Text txtProjectDefinitionPath;
    private Text txtProjectOASPath;
    private Button defaultCheckButton;
    private Button locationBrowseButton;
    private Button definitionBrowseButton;
    private Button oasBrowseButton;

    private String projectName;
    private String projectLocation;
    private String projectDefinitionPath;
    private String projectOASPath;
    private boolean defaultCheckButtonSelected;

    /**
     * Class constructor.
     */
    public APIMProjectCreationWizardPage() {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DESCRIPTION);
        Bundle bundle = Platform.getBundle(APIMConstant.APIM_BUNDLE_PLUGIN);
        final URL imagePathInString = FileLocator.find(bundle, new Path(APIMConstant.APIM_PROJECT_ICON), null);
        setImageDescriptor(ImageDescriptor.createFromURL(imagePathInString));
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;

        // project name enter section
        Composite projectContainer = new Composite(container, SWT.NULL);
        projectContainer.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(1);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        projectContainer.setLayoutData(data);

        Label lblAPIMProjectName = new Label(projectContainer, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(container, 10);
        data.left = new FormAttachment(2);
        data.width = 200;
        lblAPIMProjectName.setLayoutData(data);
        lblAPIMProjectName.setText("APIM Project Name:");

        txtProjectName = new Text(projectContainer, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(container, 10);
        data.left = new FormAttachment(lblAPIMProjectName, 0);
        data.right = new FormAttachment(97);
        txtProjectName.setLayoutData(data);
        txtProjectName.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setProjectName(txtProjectName.getText());
                pageValidator();
            }
        });

        // Create a horizontal separator
        Label separator = new Label(projectContainer, SWT.HORIZONTAL | SWT.SEPARATOR);
        data = new FormData();
        data.top = new FormAttachment(lblAPIMProjectName, 25);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        separator.setLayoutData(data);

        // project location
        Group locationSelectorGroup = new Group(projectContainer, SWT.NONE);
        locationSelectorGroup.setText(APIMConstant.PROJECT_LOCATION);
        locationSelectorGroup.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(separator, 10);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        locationSelectorGroup.setLayoutData(data);

        defaultCheckButton = new Button(locationSelectorGroup, SWT.CHECK);
        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(2);
        defaultCheckButton.setLayoutData(data);
        defaultCheckButton.setText(APIMConstant.USE_DEFAULT_LOCATION);
        defaultCheckButton.setSelection(true);
        defaultCheckButtonSelected = defaultCheckButton.getSelection();

        Label locationLabel = new Label(locationSelectorGroup, SWT.NONE);
        locationLabel.setText(APIMConstant.PROJECT_LOCATION);
        data = new FormData();
        data.top = new FormAttachment(defaultCheckButton, 11);
        data.left = new FormAttachment(2);
        locationLabel.setLayoutData(data);

        txtProjectLocation = new Text(locationSelectorGroup, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(defaultCheckButton, 10);
        data.left = new FormAttachment(locationLabel, 5);
        data.right = new FormAttachment(85);
        data.width = 314;
        txtProjectLocation.setLayoutData(data);
        txtProjectLocation.setText(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
        setProjectLocation(txtProjectLocation.getText());
        txtProjectLocation.setEnabled(false);

        locationBrowseButton = new Button(locationSelectorGroup, SWT.NONE);
        locationBrowseButton.setText(APIMConstant.BROWSE);
        locationBrowseButton.setEnabled(false);
        data = new FormData();
        data.top = new FormAttachment(defaultCheckButton, 6);
        data.left = new FormAttachment(txtProjectLocation, 5);
        data.right = new FormAttachment(98);
        locationBrowseButton.setLayoutData(data);

        // Adding a selection listener to 'defaultCheckButton' check box
        defaultCheckButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent event) {
                defaultCheckButtonSelected = defaultCheckButton.getSelection();
                txtProjectLocation.setEnabled(!defaultCheckButtonSelected);
                locationBrowseButton.setEnabled(!defaultCheckButtonSelected);
                if (defaultCheckButtonSelected) {
                    txtProjectLocation.setText(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
                    setProjectLocation(txtProjectLocation.getText());
                }
                pageValidator();
            }

            public void widgetDefaultSelected(SelectionEvent arg0) {
                // No implementation, because need to handle only user selected
                // values, not the platform specific default selections
            }

        });

        txtProjectLocation.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setProjectLocation(txtProjectLocation.getText());
                pageValidator();
            }
        });

        // Adding a selection listener to browse button
        locationBrowseButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                String fileName = getUserSelectedLocation();
                if (fileName != null) {
                    txtProjectLocation.setText(fileName);
                    setProjectLocation(txtProjectLocation.getText());
                    pageValidator();
                }
            }

            public void widgetDefaultSelected(SelectionEvent arg0) {
                // No implementation, because need to handle only user selected
                // values, not the platform specific default selections
            }
        });

        // API definition
        Group definitionSelectorGroup = new Group(projectContainer, SWT.NONE);
        definitionSelectorGroup.setText(APIMConstant.API_DEFINITION_GROUP);
        definitionSelectorGroup.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(locationSelectorGroup, 15);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        definitionSelectorGroup.setLayoutData(data);

        Label definitionLabel = new Label(definitionSelectorGroup, SWT.NONE);
        definitionLabel.setText(APIMConstant.API_DEFINITION);
        data = new FormData();
        data.top = new FormAttachment(25);
        data.left = new FormAttachment(2);
        data.width = 100;
        definitionLabel.setLayoutData(data);

        txtProjectDefinitionPath = new Text(definitionSelectorGroup, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(25);
        data.left = new FormAttachment(definitionLabel, 5);
        data.right = new FormAttachment(85);
        data.width = 314;
        txtProjectDefinitionPath.setLayoutData(data);

        definitionBrowseButton = new Button(definitionSelectorGroup, SWT.NONE);
        definitionBrowseButton.setText(APIMConstant.BROWSE);
        data = new FormData();
        data.top = new FormAttachment(16);
        data.left = new FormAttachment(txtProjectDefinitionPath, 5);
        data.right = new FormAttachment(98);
        definitionBrowseButton.setLayoutData(data);

        txtProjectDefinitionPath.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setProjectDefinitionPath(txtProjectDefinitionPath.getText());
                pageValidator();
            }
        });

        // Adding a selection listener to browse button
        definitionBrowseButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                String fileName = getUserSelectedFile();
                if (fileName != null) {
                    txtProjectDefinitionPath.setText(fileName);
                    setProjectDefinitionPath(txtProjectDefinitionPath.getText());
                    pageValidator();
                }
            }

            public void widgetDefaultSelected(SelectionEvent arg0) {
                // No implementation, because need to handle only user selected
                // values, not the platform specific default selections
            }
        });

        // OAS definition
        Group oasSelectorGroup = new Group(projectContainer, SWT.NONE);
        oasSelectorGroup.setText(APIMConstant.API_OAS_GROUP);
        oasSelectorGroup.setLayout(new FormLayout());
        data = new FormData();
        data.top = new FormAttachment(definitionSelectorGroup, 15);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        oasSelectorGroup.setLayoutData(data);

        Label oasLabel = new Label(oasSelectorGroup, SWT.NONE);
        oasLabel.setText(APIMConstant.API_OAS);
        data = new FormData();
        data.top = new FormAttachment(25);
        data.left = new FormAttachment(2);
        data.width = 100;
        oasLabel.setLayoutData(data);

        txtProjectOASPath = new Text(oasSelectorGroup, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(25);
        data.left = new FormAttachment(oasLabel, 5);
        data.right = new FormAttachment(85);
        data.width = 314;
        txtProjectOASPath.setLayoutData(data);

        oasBrowseButton = new Button(oasSelectorGroup, SWT.NONE);
        oasBrowseButton.setText(APIMConstant.BROWSE);
        data = new FormData();
        data.top = new FormAttachment(16);
        data.left = new FormAttachment(txtProjectOASPath, 5);
        data.right = new FormAttachment(98);
        oasBrowseButton.setLayoutData(data);

        txtProjectOASPath.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setProjectOASPath(txtProjectOASPath.getText());
                pageValidator();
            }
        });

        // Adding a selection listener to browse button
        oasBrowseButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent arg0) {
                String fileName = getUserSelectedFile();
                if (fileName != null) {
                    txtProjectOASPath.setText(fileName);
                    setProjectOASPath(txtProjectOASPath.getText());
                    pageValidator();
                }
            }

            public void widgetDefaultSelected(SelectionEvent arg0) {
                // No implementation, because need to handle only user selected
                // values, not the platform specific default selections
            }
        });

        pageValidator();
    }

    /**
     * This is for getting user selected path string from directory dialog box.
     * 
     * @return selected location in string
     */
    private String getUserSelectedLocation() {
        String fileName = null;

        // FileDialog
        DirectoryDialog fld = new DirectoryDialog(this.getShell(), SWT.OPEN);
        boolean done = false;

        while (!done) {
            // Open the File Dialog
            fileName = fld.open();
            if (fileName == null) {
                // User has cancelled, so quit and return
                done = true;
            } else {
                // User has selected a file; see if it already exists
                File file = new File(fileName);
                if (file.exists()) {
                    done = true;
                } else {
                    // File does not exist, so drop out
                    done = false;
                }
            }
        }

        return fileName;
    }
    
    /**
     * This is for getting user selected file path string from directory dialog box.
     * 
     * @return selected file path in string
     */
    private String getUserSelectedFile() {
        String fileName = null;

        // FileDialog
        FileDialog fld = new FileDialog(getShell());
        String[] filterExt = { "*.yaml;*.YAML;*.json;*.JSON;*.yml;*.YML" };
        fld.setFilterExtensions(filterExt);
        boolean done = false;
        
        while (!done) {
            // Open the File Dialog
            fileName = fld.open();
            if (fileName == null) {
                // User has cancelled, so quit and return
                done = true;
            } else {
                // User has selected a file; see if it already exists
                File file = new File(fileName);
                if (file.exists()) {
                    done = true;
                } else {
                    // File does not exist, so drop out
                    done = false;
                }
            }
        }

        return fileName;
    }

    /**
     * Validate the wizard page field data and update the page when the validate is
     * failed.
     */
    private void pageValidator() {
        String projectName = getProjectName();
        String inValidReason = Validator.validateProjectName(projectName);
        if (inValidReason != null) {
            updatePageStatus(inValidReason);
            return;
        }
        if (getProjectName() == null || getProjectName().isEmpty()) {
            updatePageStatus(APIMConstant.NO_PROJECT_NAME);
            return;
        }
        if (getProjectLocation() == null || getProjectLocation().isEmpty()) {
            updatePageStatus(APIMConstant.NO_PROJECT_LOCATION);
            return;
        }
        if (!(new File(getProjectLocation()).exists())) {
            updatePageStatus(APIMConstant.NO_PROJECT_LOCATION_EXISTS);
            return;
        }
        updatePageStatus(null);
    }

    /**
     * Update the page state.
     *
     * @param msg error message
     */
    private void updatePageStatus(String msg) {
        setErrorMessage(msg);
        setPageComplete(msg == null);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getProjectDefinitionPath() {
        return projectDefinitionPath;
    }

    public void setProjectDefinitionPath(String projectDefinitionPath) {
        this.projectDefinitionPath = projectDefinitionPath;
    }

    public String getProjectOASPath() {
        return projectOASPath;
    }

    public void setProjectOASPath(String projectOASPath) {
        this.projectOASPath = projectOASPath;
    }
}
