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

package org.wso2.developerstudio.eclipse.esb.docker.wizard;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.docker.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Wizard page for CAR file generation.
 *
 */
public class CarExportDetailsWizardPage extends WizardPage {

    private static final String BROWSE_LABEL_TEXT = "Browse";
    private static final String EXPORT_DESTINATION_LABEL_TEXT = "Export Destination";
    private static final String FILE_VERSION_LABEL_TEXT = "Application version";
    private static final String FILE_NAME_LABEL_TEXT = "Name of the application";
    private static final String DOCKER_IMAGE_NAME_LABEL_TEXT = "Name of the Docker Image";
    private static final String DOCKER_IMAGE_TAG_LABEL_TEXT = "Docker Image Tag";
    private static final String DIALOG_TITLE = "WSO2 Platform Distribution - Generate Docker Image";
    private static final String EMPTY_STRING = "";

    private Text txtExportPath;
    private Text txtName;
    private Text txtVersion;
    private Text txtImageName;
    private Text txtImageTag;
    
    private String name = EMPTY_STRING;
    private String version = EMPTY_STRING;
    private String imageName = EMPTY_STRING;
    private String imageTag = EMPTY_STRING;
    private String initialName = EMPTY_STRING;
    private String initialVersion = EMPTY_STRING;
    private String initialImageName = EMPTY_STRING;
    private String initialImageTag = EMPTY_STRING;
    private String exportPath = EMPTY_STRING;
    
    private IProject selectedProject;
    private boolean isPageDirty = false;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    protected CarExportDetailsWizardPage() {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
    }

    protected CarExportDetailsWizardPage(IWorkbench wb, IStructuredSelection selection) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);

        try {
            IProject project = getProject(selection);
            if (project != null) {
                setSelectedProject(project);
                exportPath = (String) getSelectedProject()
                        .getSessionProperty(new QualifiedName(EMPTY_STRING, getSelectedProject().getName()));
                imageName = (String) getSelectedProject()
                        .getSessionProperty(new QualifiedName(EMPTY_STRING, getSelectedProject().getName()
                                + ExportAndGenerateDockerImageWizard.DOCKER_IMAGE_NAME_SESSION_PROPERTY_SUFFIX));
                imageTag = (String) getSelectedProject()
                        .getSessionProperty(new QualifiedName(EMPTY_STRING, getSelectedProject().getName()
                                + ExportAndGenerateDockerImageWizard.DOCKER_IMAGE_TAG_SESSION_PROPERTY_SUFFIX));
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
        container.setLayout(new GridLayout(3, false));

        Label lblName = new Label(container, SWT.NONE);
        GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblNameGridData.widthHint = 140;
        lblName.setLayoutData(lblNameGridData);
        lblName.setText(FILE_NAME_LABEL_TEXT);

        txtName = new Text(container, SWT.BORDER);
        GridData txtNameGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
        txtNameGridData.widthHint = 253;
        txtName.setLayoutData(txtNameGridData);
        initialName = getName();
        txtName.setText(initialName);

        txtName.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setName(txtName.getText());
                validate();
            }

        });

        Label lblVersion = new Label(container, SWT.NONE);
        lblVersion.setText(FILE_VERSION_LABEL_TEXT);

        txtVersion = new Text(container, SWT.BORDER);
        GridData txtVersionGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
        txtVersionGridData.widthHint = 253;
        initialVersion = getVersion();
        txtVersion.setText(initialVersion);
        txtVersion.setLayoutData(txtVersionGridData);

        txtVersion.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setVersion(txtVersion.getText());
                validate();
            }

        });

        Label lblImageName = new Label(container, SWT.NONE);
        GridData lblImageNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblImageNameGridData.widthHint = 170;
        lblImageName.setLayoutData(lblImageNameGridData);
        lblImageName.setText(DOCKER_IMAGE_NAME_LABEL_TEXT);

        txtImageName = new Text(container, SWT.BORDER);
        GridData txtImageNameGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
        txtImageNameGridData.widthHint = 253;
        txtImageName.setLayoutData(txtImageNameGridData);
        initialImageName = getImageName();
        
        if (initialImageName != null) {
            txtImageName.setText(initialImageName);
        } else {
            setPageComplete(false);
        }
        
        txtImageName.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setImageName(txtImageName.getText());
                validate();
            }

        });

        Label lblImageTag = new Label(container, SWT.NONE);
        GridData lblImageTagGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        lblImageTagGridData.widthHint = 170;
        lblImageTag.setLayoutData(lblImageTagGridData);
        lblImageTag.setText(DOCKER_IMAGE_TAG_LABEL_TEXT);

        txtImageTag = new Text(container, SWT.BORDER);
        GridData txtImageTagGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
        txtImageTagGridData.widthHint = 253;
        txtImageTag.setLayoutData(txtImageTagGridData);
        initialImageTag = getImageTag();
        
        if (initialImageTag != null) {
            txtImageTag.setText(initialImageTag);
        } else {
            setPageComplete(false);
        }
        
        txtImageTag.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setImageTag(txtImageTag.getText());
                validate();
            }

        });

        Label lblExportDestination = new Label(container, SWT.NONE);
        lblExportDestination.setText(EXPORT_DESTINATION_LABEL_TEXT);

        txtExportPath = new Text(container, SWT.BORDER);
        GridData txtExportPathGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        txtExportPathGridData.widthHint = 499;
        txtExportPath.setLayoutData(txtExportPathGridData);

        txtExportPath.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent evt) {
                setExportPath(txtExportPath.getText());
                validate();
            }
            
        });

        if (exportPath != null) {
            txtExportPath.setText(exportPath);
        } else {
            setPageComplete(false);
        }

        Button btnBrowse = new Button(container, SWT.NONE);
        btnBrowse.setText(BROWSE_LABEL_TEXT);

        btnBrowse.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dirDlg = new DirectoryDialog(getShell());
                String dirName = dirDlg.open();
                if (dirName != null) {
                    txtExportPath.setText(dirName);
                }
                validate();
            }

        });
    }

    private void validate() {
        if ((getName() == null || getName().equals(EMPTY_STRING)) || getVersion() == null
                || getVersion().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify a name and version to .car file.");
            setPageComplete(false);
            return;
        } else if (getImageName() == null || getImageName().equals(EMPTY_STRING)) {
            setErrorMessage("Please specify an image name.");
            setPageComplete(false);
            return;
        } else if (isUpperCasePresent(getImageName())) {
        	setErrorMessage("Uppercase characters are not allowed in the image name");
            setPageComplete(false);
            return;
        } else if (!getImageName().matches("[a-zA-Z0-9][a-zA-Z0-9_.-]+")) {
            setErrorMessage("The image name format is invalid.");
            setPageComplete(false);
            return;
        } else if (!getName().matches("[_a-zA-Z0-9\\-\\.]+")) {
            setErrorMessage("Could not create CAR files with special characters");
            setPageComplete(false);
            return;
        } else if ((getExportPath() == null || getExportPath().equals(EMPTY_STRING))) {
            setErrorMessage("Please specify the docker image export destination");
            setPageComplete(false);
            return;
        } else {
            String version = txtVersion.getText();
            String[] versionParts = version.split("\\.");
            if (version.endsWith(".")) {
                setErrorMessage("File version cannot end with period.");
                setPageComplete(false);
                return;
            }
            if (versionParts.length > 4) {
                setErrorMessage("File version should be in the standared format.");
                setPageComplete(false);
                return;
            }
            if (!Character.isDigit(version.charAt(0))) {
                setErrorMessage("File version should start with a numeric value.");
                setPageComplete(false);
                return;
            }
            if (!(new File(getExportPath())).exists()) {
                setErrorMessage("Export destination must be a valid path.");
                setPageComplete(false);
                return;
            }
            if (getImageTag() != null && !getImageTag().equals(EMPTY_STRING)) {
                if (!getImageTag().matches("[\\w][\\w.-]{0,127}")) {
                    setErrorMessage("The image tag is invalid.");
                    setPageComplete(false);
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
    
    private boolean isUpperCasePresent(String str) {
    	boolean isUpperCasePresent = false;
    	char currentCharacter;
    	
    	if (null != str) {
        	for (int i = 0; i < str.length(); i++) {
                currentCharacter = str.charAt(i);
                if (Character.isUpperCase(currentCharacter)) {
                	isUpperCasePresent = true;
                }
        	}
    	}
    	
    	return isUpperCasePresent;
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

    public String getExportPath() {
        return exportPath;
    }

    public void setExportPath(String path) {
        this.exportPath = path;
    }

    public Text getTxtExportPathText() {
        return txtExportPath;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }
}
