/*
 * Copyright (c) 2011 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.platform.ui.wizard.pages;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.exception.FieldValidationException;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractFieldController;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionDataGroup;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionInfo;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectWizardSettings;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IFieldControlData;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IOnAction;
import org.wso2.developerstudio.eclipse.platform.ui.utils.WSO2UIToolkit;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * This is the wizard page class for providing an api to input project related information for WSO2 DevStudio
 */
public class ProjectOptionsDataPage extends WizardPage implements Observer {

    private static final IDeveloperStudioLog LOG = Logger.getLog(Activator.PLUGIN_ID);

    private ProjectWizardSettings settings;
    private ProjectDataModel model;
    private String currentOptionSelected;
    private Composite projectOptionsSection;
    private int columns;
    private Composite mainSection;
    private GridData gridDataInfo;
    private final List<String> visited = new ArrayList<String>();
    private Map<Control, List<ListData>> listControlData;

    private final Map<String, FieldExecutor> fieldControllers =
            new HashMap<String, FieldExecutor>();

    private final ISelection selectedResource;
    private File saveLocation;
    private boolean requireLocationSection;
    private boolean requiredWorkingSets;
    private boolean worksapceRootRequired;
    private LocationInfoComposite locationInfoComposite;

    /**
     * Create the wizard.
     */
    public ProjectOptionsDataPage(ProjectWizardSettings settings, ProjectDataModel model,
                                  ISelection selectedItem, boolean requireLocationSection, boolean requiredWorkingSet, boolean worksapceRootRequired) {
        super("wizardPage");
        this.selectedResource = selectedItem;
        setWorksapceRootRequired(worksapceRootRequired);
        setSelectedItemLocation();
        setSettings(settings);
        setModel(model);
        model.addObserver(this);
        setCurrentOptionSelected(model.getSelectedOption());
        setRequireLocationSection(requireLocationSection);
        setRequiredWorkingSets(requiredWorkingSet);
    }

    private void updatePageInfo() {
        ProjectOptionInfo projectOptionsInfo = getProjectOptionsInfo();
        if (projectOptionsInfo != null) {
            setTitle(projectOptionsInfo.getTitle());
            setDescription(projectOptionsInfo.getDescription());
        }
    }

    private void addProjectOptionUI() {
        updatePageInfo();
        setupProjectOptionControls(projectOptionsSection, columns);
        try {
            doPageValidation(null);
            setPageComplete(true);
        } catch (FieldValidationException e) {
            //Field validation failed, show proper error message on wizard
            setPageComplete(false);
            if (visited.contains(getCurrentOptionSelected())) {
                setErrorMessage(e.getMessage());
            } else {
                visited.add(getCurrentOptionSelected());
                setErrorMessage(null);
            }
        }
    }

    private ProjectOptionInfo getProjectOptionsInfo() {
        return getSettings().getProjectOptionInfo(getCurrentOptionSelected());
    }

    /**
     * Create contents of the wizard.
     *
     * @param parent
     */
    @Override
    public void createControl(Composite parent) {

        final ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);

        final Composite container = new Composite(scrolledComposite, SWT.NULL);

        setControl(scrolledComposite);
        container.setLayout(new FillLayout(SWT.HORIZONTAL));

        mainSection = new Composite(container, SWT.NONE);
        GridLayout mainLayout = new GridLayout(1, false);
        mainLayout.marginHeight = 5;
        mainLayout.marginWidth = 5;
        mainSection.setLayout(mainLayout);

        projectOptionsSection = new Composite(mainSection, SWT.NONE);
        columns = 10;
        GridLayout gridProjectOptionsSection = new GridLayout(columns, false);
        gridProjectOptionsSection.marginHeight = 10;
        gridProjectOptionsSection.marginWidth = 10;
        projectOptionsSection.setLayout(gridProjectOptionsSection);
        GridData gridData = new GridData();
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;
        projectOptionsSection.setLayoutData(gridData);

        if (!isRequireLocationSection()) {
            getModel().setLocation(getSaveLocation());

        }
        // Create the project options section
        addProjectOptionUI();

        if (isRequireLocationSection()) {
            Composite projectLocationSection = new Composite(mainSection, SWT.NONE);
            projectLocationSection.setLayout(new FillLayout(SWT.HORIZONTAL));
            gridDataInfo = new GridData();
            gridDataInfo.horizontalAlignment = SWT.FILL;
            gridDataInfo.grabExcessHorizontalSpace = true;
            projectLocationSection.setLayoutData(gridDataInfo);

            locationInfoComposite = new LocationInfoComposite(projectLocationSection, SWT.NONE, model, getSaveLocation(), getProjectOptionsInfo(), this);

        }
        if (isRequiredWorkingSets()) {
            Composite workigSetSection = new Composite(mainSection, SWT.NONE);
            workigSetSection.setLayout(new FillLayout(SWT.HORIZONTAL));
            gridDataInfo = new GridData();
            gridDataInfo.horizontalAlignment = SWT.FILL;
            gridDataInfo.grabExcessHorizontalSpace = true;
            workigSetSection.setLayoutData(gridDataInfo);
            new WorkingSetComposite(workigSetSection, SWT.NONE, model);
        }
        TrayDialog.setDialogHelpAvailable(false);

        scrolledComposite.setContent(container);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);
        //TODO: Dynamically resize a scrolledComposite when child resized.
        Point compositeSize = container.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        compositeSize.y += 100;
        scrolledComposite.setMinSize(compositeSize);

    }

    private void setupProjectOptionControls(Composite projectOptionsSection, int columns) {
        ProjectOptionInfo info = getProjectOptionsInfo();
        if ((info != null) && (projectOptionsSection != null)) {
            createNonGroupFields(projectOptionsSection, columns, info);
            createGroupedFeilds(projectOptionsSection, columns, info);
            projectOptionsSection.layout();
            mainSection.layout();
        }
    }

    private void createNonGroupFields(Composite container, int noOfColumns, ProjectOptionInfo info) {
        List<ProjectOptionData> projectOptionsData = info.getProjectOptionsData();
        for (ProjectOptionData optionData : projectOptionsData) {
            addFeild(noOfColumns, container, optionData, null);
        }
    }

    private void createGroupedFeilds(Composite container, int noOfColumns, ProjectOptionInfo info) {
        List<ProjectOptionData> projectOptionsData = info.getProjectOptionsData();
        List<ProjectOptionDataGroup> projectOptionsDataGroup = info.getProjectOptionsDataGroup();
        addSection(container, noOfColumns, projectOptionsData, projectOptionsDataGroup);
    }

    private void addSection(Composite container, int noOfColumns,
                            List<ProjectOptionData> projectOptionsData,
                            List<ProjectOptionDataGroup> projectOptionsDataGroup) {
        for (ProjectOptionDataGroup dataGroup : projectOptionsDataGroup) {
            String title = dataGroup.getTitle();
            Composite childContainer =
                    WSO2UIToolkit.createContainer(container, title, noOfColumns, dataGroup
                                    .isCollapsible(), dataGroup.isExpanded(),
                            dataGroup.getVerticalIndent(), dataGroup
                                    .getHorizontalIndent());
            GridLayout layout = new GridLayout(noOfColumns, false);

            if (dataGroup.getMarginHeight() != null) {
                layout.marginHeight = dataGroup.getMarginHeight();
            }
            if (dataGroup.getMarginWidth() != null) {
                layout.marginWidth = dataGroup.getMarginWidth();
            }
            childContainer.setLayout(layout);

            for (ProjectOptionData optionData : projectOptionsData) {
                addFeild(noOfColumns, childContainer, optionData, dataGroup.getId());
            }
            addSection(childContainer, noOfColumns, projectOptionsData, dataGroup
                    .getProjectOptionsDataGroup());
        }
    }

    private void addFeild(int noOfColumns, Composite container, ProjectOptionData optionData,
                          String groupId) {
        final ProjectOptionData finalOptionData = optionData;
        if (optionData.getGroup() == groupId ||
                (optionData.getGroup() != null && optionData.getGroup().equals(groupId))) {
            switch (optionData.getType()) {
                case STRING:
                    createTypeStringField(container, noOfColumns, finalOptionData);
                    break;
                case FILE:
                    createTypeFileField(container, noOfColumns, finalOptionData);
                    break;
                case TITLED_LABEL:
                    createTypeTitleLabelField(container, noOfColumns, finalOptionData);
                    break;
                case LABEL:
                    createTypeLabelField(container, noOfColumns, finalOptionData);
                    break;
                case DIR:
                    createTypeDirField(container, noOfColumns, finalOptionData);
                    break;
                case FILE_DIR:
                    createTypeDirFileField(container, noOfColumns, finalOptionData);
                    break;
                case LIST:
                    createTypeListField(container, noOfColumns, finalOptionData);
                    break;
                case CHOICE:
                    createTypeChoiceField(container, noOfColumns, finalOptionData);
                    break;
                case LINK:
                    createTypeLinkField(container, noOfColumns, finalOptionData);
                    break;
                case WORKSPACE:
                    createTypeWorkspaceField(container, noOfColumns, finalOptionData);
                    break;
                case WORKSPACE_FILE:
                    createTypeWorkspaceFileField(container, noOfColumns, finalOptionData);
                    break;
                case WORKSAPCE_FOLDER:
                    createTypeWorkspaceFolderField(container, noOfColumns, finalOptionData);
                    break;
                case REGISTRY:
                    createRegistryBrowseField(container, noOfColumns + 1, finalOptionData);
                    break;
                case REGISTRY_TEXT:
                    createRegistryBrowseTextField(container, noOfColumns + 1, finalOptionData);
                    break;
                case RESOURCE_TEXT:
                    createResourceBrowseTextField(container, noOfColumns + 1, finalOptionData);
                    break;
                case OPTION:
                    createTypeOptionField(container, noOfColumns, finalOptionData);
                    break;
                case COMPOSITE:
                    createComposite(container, noOfColumns, finalOptionData);
                    break;

            }
        }
    }

    private void createComposite(Composite container, int noOfColumns,
                                 final ProjectOptionData finalOptionData) {

        final IFieldControlData composite = WSO2UIToolkit.createComposite(container, noOfColumns, finalOptionData.getCompositeProvider(), getModel(), finalOptionData, this);

        FieldExecutor fieldExecutor = new CommonFieldExecutor(finalOptionData, getModel(), composite.getControl()) {

            public void validate() throws FieldValidationException {
                if (finalOptionData.getFieldController() != null) {
                    finalOptionData.getFieldController().validate(finalOptionData.getModelProperty(),
                            composite.getData(), getModel());
                    ((AbstractComposite) composite.getControl()).validate();
                }
            }

            public void setFieldValue(ProjectDataModel model) throws Exception {
                ((AbstractComposite) composite.getControl()).update(model, null);
            }
        };

        composite.setOnAction(new IOnAction() {
            public void onSelectionAction() {
                //Nothing to do with the selection of this component
            }

            public void onModifyAction() {
                String modelProperty = finalOptionData.getModelProperty();
                try {
                    updateField(modelProperty);
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
            }

        });

        fieldControllers.put(finalOptionData.getModelProperty(), fieldExecutor);
        try {
            updateField(finalOptionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createRegistryBrowseField(Composite container,
                                           int noOfColumns,
                                           final ProjectOptionData optionData) {
        boolean readonly =
                (optionData.getFieldController() != null) && (optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel()));
        final IFieldControlData txtReg = WSO2UIToolkit.createRegistryBrowserControl("registry.browser",
                container,
                noOfColumns,
                optionData.getVerticalIndent(),
                optionData.getHorizontalIndent(),
                readonly,
                getControl().getParent().getShell(),
                optionData.getCaption(),
                "Browse...",
                optionData.getRegistyResourceSelectionType(),
                getModel(),
                optionData.getRegistyPathBindingProperty());

        FieldExecutor fieldExecutor =
                new CommonFieldExecutor(optionData, getModel(), txtReg.getControl()) {

                    public void validate() throws FieldValidationException {
                        if (optionData.getFieldController() != null) {
                            optionData.getFieldController().validate(optionData.getModelProperty(),
                                    txtReg.getData(), getModel());
                        }
                    }


                    public void setFieldValue(ProjectDataModel model) throws Exception {
                        String modelPropertyValue = "";
                        Object modelPropertyValueObj = getModelPropertyValue();
                        if (modelPropertyValueObj != null) {
                            modelPropertyValue = modelPropertyValueObj.toString();
                        }
                        txtReg.setData(modelPropertyValue);
                    }
                };
        txtReg.setOnAction(new IOnAction() {

            public void onSelectionAction() {
                //Nothing to do with the selection of this component
            }

            public void onModifyAction() {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            currentModelPropertyValue.toString().equals(txtReg.getData())) {
                        return;
                    }
                    if (getModel().setModelPropertyValue(modelProperty, txtReg.getData())) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }

    }

    private void createRegistryBrowseTextField(Composite container, int noOfColumns,
                                               final ProjectOptionData optionData) {
        final IFieldControlData txtReg = WSO2UIToolkit.createRegistryBrowserControl(
                "registry.browser", container, noOfColumns, optionData.getVerticalIndent(),
                optionData.getHorizontalIndent(), false, getControl().getParent().getShell(),
                optionData.getCaption(), "Browse...", optionData.getRegistyResourceSelectionType(),
                getModel(), optionData.getRegistyPathBindingProperty());

        if (txtReg != null) {
            createBrowserTextfeild(txtReg, container, noOfColumns, optionData);
        }
    }

    private void createResourceBrowseTextField(Composite container, int noOfColumns,
                                               final ProjectOptionData optionData) {

        final IFieldControlData txtReg = WSO2UIToolkit.createResourceBrowserControl(
                "resource.browser", container, noOfColumns, optionData.getVerticalIndent(),
                optionData.getHorizontalIndent(), false, getControl().getParent().getShell(),
                optionData.getCaption(), "Browse...", optionData.getRegistyResourceSelectionType(),
                getModel(), optionData.getRegistyPathBindingProperty());

        if (txtReg != null) {
            createBrowserTextfeild(txtReg, container, noOfColumns, optionData);
        }
    }

    private void createBrowserTextfeild(final IFieldControlData txtReg, Composite container, int noOfColumns,
                                        final ProjectOptionData optionData) {

        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(),
                txtReg.getControl()) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    optionData.getFieldController().validate(optionData.getModelProperty(),
                            txtReg.getData(), getModel());
                }
            }

            public void setFieldValue(ProjectDataModel model) throws Exception {
                String modelPropertyValue = "";
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue = modelPropertyValueObj.toString();
                }
                txtReg.setData(modelPropertyValue);
            }
        };
        txtReg.setOnAction(new IOnAction() {

            public void onSelectionAction() {
            }

            public void onModifyAction() {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue = getModel().getModelPropertyValue(
                            modelProperty);
                    if (currentModelPropertyValue != null
                            && currentModelPropertyValue.toString().equals(txtReg.getData())) {
                        return;
                    }
                    if (getModel().setModelPropertyValue(modelProperty, txtReg.getData())) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }

    }


    private void createTypeWorkspaceFileField(Composite container, int noOfColumns,
                                              final ProjectOptionData optionData) {
        boolean readonly =
                optionData.getFieldController() != null && optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel());
        final Text txtFile =
                WSO2UIToolkit.createWorkspaceFileBrowser(container, getControl().getParent()
                                .getShell(), optionData.getCaption(), readonly, "Browse...", noOfColumns,
                        optionData.getWorkspaceFilter(),
                        optionData.getVerticalIndent(), optionData
                                .getHorizontalIndent());
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), txtFile) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    IFile file = null;
                    try {
                        file =
                                ResourcesPlugin.getWorkspace().getRoot()
                                        .getFile(new Path(txtFile.getText()));
                    } catch (Exception e) {
                        LOG.error("An unexpected error has occurred", e);
                    }
                    optionData.getFieldController().validate(optionData.getModelProperty(), file,
                            model);
                }
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                String modelPropertyValue = "";
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue =
                            ((IFile) modelPropertyValueObj).getFullPath().toPortableString()
                                    .substring(1);
                }
                txtFile.setText(modelPropertyValue);
            }

        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        txtFile.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent arg0) {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            ((IFile) currentModelPropertyValue).getFullPath().toPortableString()
                                    .equals(txtFile.getText())) {
                        return;
                    }
                    IFile file =
                            ResourcesPlugin.getWorkspace().getRoot().getFile(
                                    new Path(txtFile
                                            .getText()));
                    if (getModel().setModelPropertyValue(modelProperty, file)) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeWorkspaceFolderField(Composite container, int noOfColumns,
                                                final ProjectOptionData optionData) {
        boolean readonly =
                optionData.getFieldController() != null && optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel());
        final Text txtFolder =
                WSO2UIToolkit.createWorkspaceFolderBrowser(container, getControl().getParent()
                                .getShell(), optionData.getCaption(), readonly, "Browse...", noOfColumns,
                        optionData.getWorkspaceFilter(),
                        optionData.getVerticalIndent(),
                        optionData.getHorizontalIndent());
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), txtFolder) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    IContainer folder = null;
                    ;
                    try {
                        String text = txtFolder.getText();
                        if (text.split("/").length == 1) {
                            folder = ResourcesPlugin.getWorkspace().getRoot().getProject(text);
                        } else {
                            folder =
                                    ResourcesPlugin.getWorkspace().getRoot()
                                            .getFolder(new Path(text));
                        }
                    } catch (Exception e) {
                        /* ignore, this exception will handle by FieldController*/
                    }
                    optionData.getFieldController().validate(optionData.getModelProperty(), folder,
                            model);
                }
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                String modelPropertyValue = "";
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue =
                            ((IContainer) modelPropertyValueObj).getFullPath().toPortableString()
                                    .substring(1);
                }
                if (!modelPropertyValue.equals("") && modelPropertyValue != null) {
                    txtFolder.setText(modelPropertyValue);
                } else {
                    txtFolder.setText("");
                }

            }

        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        txtFolder.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent arg0) {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            ((IContainer) currentModelPropertyValue).getFullPath().toPortableString()
                                    .equals(txtFolder.getText())) {
                        return;
                    }
                    IContainer folder;
                    if (txtFolder.getText().split("/").length == 1) {
                        folder =
                                ResourcesPlugin.getWorkspace().getRoot()
                                        .getProject(txtFolder.getText());
                    } else {
                        folder =
                                ResourcesPlugin.getWorkspace().getRoot()
                                        .getFolder(new Path(txtFolder.getText()));
                    }
                    if (getModel().setModelPropertyValue(modelProperty, folder)) {
                        updateField(modelProperty);
                    }

                } catch (IllegalArgumentException e) {
              /* ignore, this exception will handle by FieldController*/
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeWorkspaceField(Composite container, int noOfColumns,
                                          ProjectOptionData optionData) {
//    TODO
//    Text txtWorkspace =
//            WSO2UIToolkit.createWorkspaceBrowser(container,
//                                                 getControl().getParent().getShell(),
//                                                 optionData.getCaption(), true, "Browse...",
//                                                 noOfColumns, optionData.getWorkspaceFilter(),
//                                                 optionData.getVerticalIndent(), optionData
//                                                         .getHorizontalIndent());
//    setupFilesystemBrowseField(optionData, txtWorkspace);
    }

    private void createTypeFileField(Composite container, int noOfcolumns,
                                     ProjectOptionData optionData) {
        boolean readonly =
                optionData.getFieldController() != null && optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel());

        IFieldControlData txtFile = WSO2UIToolkit.createFileBrowser(container, getControl().getParent().getShell(),
                optionData.getCaption(), optionData.getFilter(),
                readonly, "Browse...", noOfcolumns, optionData
                        .getVerticalIndent(), optionData
                        .getHorizontalIndent());
        setupFilesystemBrowseField(optionData, txtFile);
    }

    private void setupFilesystemBrowseField(final ProjectOptionData optionData, final IFieldControlData txtFile) {
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), txtFile.getControl()) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    optionData.getFieldController().validate(optionData.getModelProperty(),
                            txtFile.getData(), model);
                }
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                Object modelPropertyValue = "";
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue = modelPropertyValueObj;
                }
                txtFile.setData(modelPropertyValue);
            }

        };
        txtFile.setOnAction(new IOnAction() {

            public void onSelectionAction() {
            }

            public void onModifyAction() {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            currentModelPropertyValue.toString().equals(txtFile.getData().toString())) {
                        return;
                    }
                    if (getModel()
                            .setModelPropertyValue(modelProperty, txtFile.getData())) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);

            }
        });
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeDirField(Composite container, int noOfcolumns,
                                    ProjectOptionData optionData) {
        boolean readonly =
                optionData.getFieldController() != null && optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel());
        IFieldControlData txtDir =
                WSO2UIToolkit.createDirectoryBrowser(container,
                        getControl().getParent().getShell(),
                        optionData.getCaption(), readonly,
                        "Browse...", noOfcolumns, optionData
                                .getVerticalIndent(), optionData
                                .getHorizontalIndent());
        setupFilesystemBrowseField(optionData, txtDir);
    }

    private void createTypeDirFileField(Composite container, int noOfcolumns,
                                        ProjectOptionData optionData) {
        boolean readonly =
                optionData.getFieldController() != null && optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel());
        IFieldControlData txtFileDir =
                WSO2UIToolkit.createFileDirectoryBrowser(container, getControl().getParent()
                                .getShell(), optionData.getCaption(), optionData.getFilter(), readonly,
                        "Browse file...", "Browse folder...",
                        noOfcolumns, optionData
                                .getVerticalIndent(), optionData
                                .getHorizontalIndent());
        setupFilesystemBrowseField(optionData, txtFileDir);
    }

    private void createTypeTitleLabelField(Composite container, int noOfColumns,
                                           final ProjectOptionData optionData) {
        final Label lbl =
                WSO2UIToolkit.createTitleLabel(container, optionData.getCaption(), noOfColumns,
                        optionData.getLabelAlignment(), optionData
                                .getVerticalIndent(), optionData
                                .getHorizontalIndent());
        setupTypeLabelConfigurations(optionData, lbl);
    }

    private void createTypeLabelField(Composite container, int noOfColumns,
                                      final ProjectOptionData optionData) {
        final Label lbl =
                WSO2UIToolkit.createLabel(container, optionData.getCaption(), noOfColumns,
                        optionData.getLabelAlignment(), optionData
                                .getVerticalIndent(), optionData
                                .getHorizontalIndent());
        setupTypeLabelConfigurations(optionData, lbl);
    }

    private void setupTypeLabelConfigurations(final ProjectOptionData optionData, final Label lbl) {
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), lbl) {

            public void validate() throws FieldValidationException {
                // N/A
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                String modelPropertyValue = optionData.getCaption();
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue = modelPropertyValueObj.toString();
                }
                lbl.setText(modelPropertyValue);
            }
        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeLinkField(Composite container, int noOfColumns,
                                     final ProjectOptionData optionData) {
        final Link chkButton =
                WSO2UIToolkit.createLink(container, optionData.getCaption(), noOfColumns,
                        optionData.getLinkAlignment(), optionData
                                .getVerticalIndent(), optionData
                                .getHorizontalIndent());
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), chkButton) {

            public void validate() throws FieldValidationException {
                // N/A
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                String modelPropertyValue = optionData.getCaption();
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue = modelPropertyValueObj.toString();
                }
                chkButton.setText(modelPropertyValue);
            }
        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        chkButton.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent event) {
                try {
                    SelectionListener linkClickedListener = optionData.getLinkClickedListener();
                    if (linkClickedListener != null) {
                        linkClickedListener.widgetSelected(event);
                    } else {
                        String modelProperty = optionData.getModelProperty();
                        if (getModel().setModelPropertyValue(modelProperty, event)) {
                            updateField(modelProperty);
                        }
                    }
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeChoiceField(Composite container, int noOfColumns,
                                       final ProjectOptionData optionData) {
        final Button chkButton =
                WSO2UIToolkit.createChoice(container, optionData.getCaption(), noOfColumns,
                        optionData.getVerticalIndent(), optionData
                                .getHorizontalIndent());
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), chkButton) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    optionData.getFieldController().validate(optionData.getModelProperty(),
                            chkButton.getSelection(), getModel());
                }
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                Boolean modelPropertyValue = false;
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue = (Boolean) modelPropertyValueObj;
                }
                chkButton.setSelection(modelPropertyValue);
            }
        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        chkButton.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            (Boolean) currentModelPropertyValue == chkButton.getSelection()) {
                        return;
                    }
                    if (getModel().setModelPropertyValue(modelProperty, chkButton.getSelection())) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeOptionField(Composite container, int noOfColumns,
                                       final ProjectOptionData optionData) {
        final Button optButton =
                WSO2UIToolkit.createOption(container, optionData.getCaption(), noOfColumns,
                        optionData.getVerticalIndent(), optionData
                                .getHorizontalIndent());
        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), optButton) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    optionData.getFieldController().validate(optionData.getModelProperty(),
                            optButton.getSelection(), getModel());
                }
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                Boolean modelPropertyValue = false;
                Object modelPropertyValueObj = getModelPropertyValue();
                if (modelPropertyValueObj != null) {
                    modelPropertyValue = (Boolean) modelPropertyValueObj;
                }
                optButton.setSelection(modelPropertyValue);
            }
        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        optButton.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent arg0) {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            (Boolean) currentModelPropertyValue == optButton.getSelection()) {
                        return;
                    }
                    if (getModel().setModelPropertyValue(modelProperty, optButton.getSelection())) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeStringField(Composite container, int noOfcolumns,
                                       final ProjectOptionData optionData) {
        boolean readonly =
                optionData.getFieldController() != null && optionData.getFieldController()
                        .isReadOnlyField(optionData.getModelProperty(), getModel());

        final IFieldControlData txt =
                WSO2UIToolkit.createText(container, optionData.getCaption(), noOfcolumns, readonly,
                        optionData.getVerticalIndent(), optionData
                                .getHorizontalIndent(), optionData.isTextMultiline(), optionData.isAddListnner(),
                        (AbstractWSO2ProjectCreationWizard) getWizard(), optionData.getToolTip());
        FieldExecutor fieldExecutor =
                new CommonFieldExecutor(optionData, getModel(), txt.getControl()) {

                    public void validate() throws FieldValidationException {
                        if (optionData.getFieldController() != null) {
                            optionData.getFieldController().validate(optionData.getModelProperty(),
                                    txt.getData(), getModel());
                        }
                    }


                    public void setFieldValue(ProjectDataModel model) throws Exception {
                        String modelPropertyValue = "";
                        Object modelPropertyValueObj = getModelPropertyValue();
                        if (modelPropertyValueObj != null) {
                            modelPropertyValue = modelPropertyValueObj.toString();
                        }
                        txt.setData(modelPropertyValue);
                    }
                };
        txt.setOnAction(new IOnAction() {


            public void onSelectionAction() {
            }


            public void onModifyAction() {
                try {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    if (currentModelPropertyValue != null &&
                            currentModelPropertyValue.toString().equals(txt.getData())) {
                        return;
                    }
                    if (getModel().setModelPropertyValue(modelProperty, txt.getData())) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);
            }
        });
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void createTypeListField(Composite container, int noOfColumns,
                                     final ProjectOptionData optionData) {
        if (optionData.isListMultiSelect()) {
            createTypeListCheckBoxListField(container, noOfColumns, optionData);
        } else {
            createTypeListComboField(container, noOfColumns, optionData);
        }
    }

    public Object[] getDataElements(TableItem... tableItems) {
        List<Object> data = new ArrayList<Object>();
        for (TableItem tableItem : tableItems) {
            data.add(tableItem.getData());
        }
        return data.toArray();
    }

    public TableItem[] getDataElements(Table table, Object... data) {
        List<TableItem> tableItems = new ArrayList<TableItem>();
        List<Object> dataList = Arrays.asList(data);
        for (TableItem tableItem : table.getItems()) {
            if (dataList.contains(tableItem.getData())) {
                tableItems.add(tableItem);
            }
        }
        return tableItems.toArray(new TableItem[]{});
    }

    private void createTypeListCheckBoxListField(Composite container, int noOfColumns,
                                                 final ProjectOptionData optionData) {
        final CheckboxTableViewer combo =
                WSO2UIToolkit.createList(container, optionData.getCaption(), noOfColumns,
                        optionData.getVerticalIndent(), optionData
                                .getHorizontalIndent(), optionData.isSelectAllbtn(), this, optionData);

        FieldExecutor fieldExecutor =
                new CommonFieldExecutor(optionData, getModel(), combo.getTable()) {

                    public void validate() throws FieldValidationException {
                        if (optionData.getFieldController() != null) {
                            optionData.getFieldController().validate(optionData.getModelProperty(),
                                    combo.getCheckedElements(),
                                    getModel());
                        }
                    }


                    public void setFieldValue(ProjectDataModel model) throws Exception {
                        combo.getTable().removeAll();
                        List<ListData> listData =
                                optionData.getListDataProvider()
                                        .getListData(optionData.getModelProperty(), getModel());
                        for (ListData data : listData) {
                            TableItem tableItem = new TableItem(combo.getTable(), SWT.NONE);
                            tableItem.setText(data.getCaption());
                            tableItem.setData(data.getData());
                        }
                        Object[] comboTextValue = new Object[]{};

                        Object modelPropertyValueObj = getModelPropertyValue();
                        if (modelPropertyValueObj != null) {
                            comboTextValue = (Object[]) modelPropertyValueObj;
                        }
                        combo.setCheckedElements(comboTextValue);
                    }
                };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        combo.addCheckStateListener(new ICheckStateListener() {


            public void checkStateChanged(CheckStateChangedEvent arg0) {

                String modelProperty = optionData.getModelProperty();
                Object[] currentModelPropertyValue =
                        (Object[]) getModel().getModelPropertyValue(modelProperty);

                try {
                    Object[] checkedElements = combo.getCheckedElements();
                    if (isEqual(currentModelPropertyValue, checkedElements)) {
                        return;
                    }
                    if (getModel().setModelPropertyValue(modelProperty, checkedElements)) {
                        updateField(modelProperty);
                    }
                } catch (ObserverFailedException e) {
                    LOG.error("ObserverFailed:", e);
                } catch (Exception e) {
                    LOG.error("An unexpected error has occurred", e);
                }
                doPostFieldModificationAction(optionData);

            }

        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    public void updateListCheckBox(ProjectOptionData optionData, Object[] checkedElements) {

        try {
            String modelProperty = optionData.getModelProperty();
            Object[] currentModelPropertyValue =
                    (Object[]) getModel().getModelPropertyValue(modelProperty);

            try {
                if (isEqual(currentModelPropertyValue, checkedElements)) {
                    return;
                }
                if (getModel().setModelPropertyValue(modelProperty, checkedElements)) {
                    updateField(modelProperty);
                }
            } catch (ObserverFailedException e) {
                LOG.error("ObserverFailed:", e);
            } catch (Exception e) {
                LOG.error("An unexpected error has occurred", e);
            }
            doPostFieldModificationAction(optionData);
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private boolean comboBeingModified = false;

    private void createTypeListComboField(Composite container, int noOfColumns,
                                          final ProjectOptionData optionData) {
        final Combo combo =
                WSO2UIToolkit.createCombo(container, optionData.getCaption(), noOfColumns,
                        optionData.isListEditable(), optionData
                                .getVerticalIndent(), optionData
                                .getHorizontalIndent());

        FieldExecutor fieldExecutor = new CommonFieldExecutor(optionData, getModel(), combo) {

            public void validate() throws FieldValidationException {
                if (optionData.getFieldController() != null) {
                    ListData controlListData = getControlListData(combo, combo.getText());
                    if (controlListData != null) {
                        optionData.getFieldController().validate(optionData.getModelProperty(),
                                controlListData.getData(),
                                getModel());
                    } else {
                        optionData.getFieldController().validate(optionData.getModelProperty(),
                                combo.getText(), getModel());
                    }
                }
            }


            public void setFieldValue(ProjectDataModel model) throws Exception {
                Object modelPropertyValueObj = getModelPropertyValue();
                comboBeingModified = true;
                combo.removeAll();
                List<ListData> listData =
                        optionData.getListDataProvider().getListData(optionData.getModelProperty(),
                                getModel());
                getListControlData().put(combo, listData);
                for (ListData data : listData) {
                    combo.add(data.getCaption());
                }
                comboBeingModified = false;
                String comboTextValue = null;
                if (optionData.isListEditable()) {
                    if (modelPropertyValueObj != null) {
                        comboTextValue = modelPropertyValueObj.toString();
                    }
                } else {
                    ListData controlListData = getControlListData(combo, modelPropertyValueObj);
                    if (controlListData != null) {
                        comboTextValue = controlListData.getCaption();
                    }
                }
                if (comboTextValue == null) {
                    if (combo.getItemCount() > 0) {
                        combo.select(0);
                    }
                } else {
                    combo.setText(comboTextValue);
                }
            }
        };
        fieldControllers.put(optionData.getModelProperty(), fieldExecutor);
        combo.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent arg0) {
                if (!comboBeingModified) {
                    String modelProperty = optionData.getModelProperty();
                    Object currentModelPropertyValue =
                            getModel().getModelPropertyValue(modelProperty);
                    try {
                        if (optionData.isListEditable()) {
                            if (currentModelPropertyValue != null &&
                                    currentModelPropertyValue.toString().equals(combo.getText())) {
                                return;
                            }
                            if (getModel().setModelPropertyValue(modelProperty, combo.getText())) {
                                updateField(modelProperty);
                            }
                        } else {
                            ListData controlListData = getControlListData(combo, combo.getText());
                            if (controlListData != null &&
                                    controlListData.equals(currentModelPropertyValue)) {
                                return;
                            }
                            if (controlListData != null && getModel().setModelPropertyValue(modelProperty,
                                    controlListData.getData())) {
                                updateField(modelProperty);
                            }
                        }

                    } catch (ObserverFailedException e) {
                        LOG.error("ObserverFailed:", e);
                    } catch (Exception e) {
                        LOG.error("An unexpected error has occurred", e);
                    }
                    doPostFieldModificationAction(optionData);
                }
            }

        });
        try {
            updateField(optionData.getModelProperty());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    public void setModel(ProjectDataModel model) {
        this.model = model;
    }

    public ProjectDataModel getModel() {
        return model;
    }

    public void setSettings(ProjectWizardSettings settings) {
        this.settings = settings;
    }

    public ProjectWizardSettings getSettings() {
        return settings;
    }

    public void setCurrentOptionSelected(String currentOptionSelected) {
        this.currentOptionSelected = currentOptionSelected;
    }

    public String getCurrentOptionSelected() {
        return currentOptionSelected;
    }


    public void update(Observable o, Object arg) {
        if (o == getModel()) {
            if (getCurrentOptionSelected() == null ||
                    !getCurrentOptionSelected().equals(getModel().getSelectedOption())) {
                setCurrentOptionSelected(getModel().getSelectedOption());
                clearProjectOptionsSection();
                addProjectOptionUI();
            }
        }
    }

    private void clearProjectOptionsSection() {
        if (projectOptionsSection != null) {
            Control[] children = projectOptionsSection.getChildren();
            for (Control control : children) {
                if (!control.isDisposed()) {
                    control.dispose();
                }
            }
            fieldControllers.clear();
            getListControlData().clear();
        }
    }

    private void doPageValidation(final ProjectOptionData finalOptionData)
            throws FieldValidationException {
        for (String modelProperty : fieldControllers.keySet()) {
            if (finalOptionData == null ||
                    !modelProperty.equals(finalOptionData.getModelProperty())) {
                doFieldValidation(modelProperty);
            }
        }
    }

    private void doFieldValidation(String modelProperty) throws FieldValidationException {
        FieldExecutor autoFieldValidator = fieldControllers.get(modelProperty);
        if (null != autoFieldValidator) {
            autoFieldValidator.validate();
        }
    }

    private void setSelectedItemLocation() {
        if (selectedResource != null && (selectedResource instanceof TreeSelection)) {
            TreeSelection tree = (TreeSelection) selectedResource;
            Object firstElement = tree.getFirstElement();
            if (firstElement instanceof IResource) {
                if (firstElement instanceof IFile) {
                    File file = ((IResource) firstElement).getParent().getLocation().toFile();
                    setSaveLocation(file);
                } else {
                    File file = ((IResource) firstElement).getLocation().toFile();
                    setSaveLocation(file);
                }
            } else {
                setSaveLocation(ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile());
            }
        }
        if (getSaveLocation() == null || isWorksapceRootRequired()) {
            setSaveLocation(ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile());
        }
    }

    public void setSaveLocation(File saveLocation) {
        this.saveLocation = saveLocation;
    }

    public File getSaveLocation() {
        return saveLocation;
    }

    public Map<Control, List<ListData>> getListControlData() {
        if (listControlData == null) {
            listControlData = new HashMap<Control, List<ListData>>();
        }
        return listControlData;
    }

    public ListData getControlListData(Control control, String selectedString) {
        if (getListControlData().containsKey(control)) {
            List<ListData> list = getListControlData().get(control);
            for (ListData listData : list) {
                if (listData.getCaption().equals(selectedString)) {
                    return listData;
                }
            }
        }
        return null;
    }

    public ListData getControlListData(Control control, Object selectedData) {
        if (getListControlData().containsKey(control)) {
            List<ListData> list = getListControlData().get(control);
            for (ListData listData : list) {
                if (listData.equals(selectedData)) {
                    return listData;
                }
            }
        }
        return null;
    }

    private void doPostFieldModificationAction(ProjectOptionData optionData) {
        try {
            String modelProperty = optionData.getModelProperty();
            doFieldValidation(modelProperty);
            doControlStatusUpdate(optionData);
            doPageValidation(optionData);

			if (isRequireLocationSection() && locationInfoComposite != null) {
				if (locationInfoComposite.isComplete()) {
                    setPageComplete(true);
                    setErrorMessage(null);
                } else {
                    setPageComplete(false);
                    setErrorMessage(locationInfoComposite.getErrorMessage());
                }
            } else {
                setPageComplete(true);
                setErrorMessage(null);
            }
        } catch (FieldValidationException e) {
            try {
                doControlStatusUpdate(optionData);
            } catch (Exception e1) {
                LOG.error("An unexpected error has occurred", e1);
            }
            setPageComplete(false);
            setErrorMessage(e.getMessage());
        } catch (Exception e) {
            LOG.error("An unexpected error has occurred", e);
        }
    }

    private void doControlStatusUpdate(ProjectOptionData optionData) throws Exception {
        String modelProperty = optionData.getModelProperty();
        AbstractFieldController fieldController = optionData.getFieldController();
        if (fieldController != null) {
            List<String> updateFields = fieldController.getUpdateFields(modelProperty, getModel());
            for (String updateFieldProperty : updateFields) {
                if (fieldControllers.containsKey(updateFieldProperty)) {
                    updateField(updateFieldProperty);
                }
            }
        }
    }

    public void updateField(String modelProperty) throws Exception {
        FieldExecutor fieldExecutor = fieldControllers.get(modelProperty);
        fieldExecutor.setFieldValue(getModel());
        fieldExecutor.setControlEnableState();
        // currently making the controls visible true/false screws things up
        fieldExecutor.setControlVisibleState();
        projectOptionsSection.update();
        WSO2UIToolkit.layout(projectOptionsSection);
    }

    public void setRequireLocationSection(boolean requireLocationSection) {
        this.requireLocationSection = requireLocationSection;
    }

    public void setRequiredWorkingSets(boolean requiredWorkingSets) {
        this.requiredWorkingSets = requiredWorkingSets;
    }

    public boolean isRequiredWorkingSets() {
        return requiredWorkingSets;
    }

    public boolean isRequireLocationSection() {
        return requireLocationSection;
    }

    public boolean isWorksapceRootRequired() {
        return worksapceRootRequired;
    }

    public void setWorksapceRootRequired(boolean worksapceRootRequired) {
        this.worksapceRootRequired = worksapceRootRequired;
    }

    private boolean isEqual(Object[] currentModelPropertyValue, Object[] checkedElements) {
        boolean equal = true;
        if (checkedElements == null && currentModelPropertyValue != null) {
            equal = false;
        } else if (currentModelPropertyValue == null && checkedElements != null) {
            equal = false;
        } else if (currentModelPropertyValue == checkedElements) {
            equal = true;
        } else if (currentModelPropertyValue.length != checkedElements.length) {
            equal = false;
        } else {
            List<Object> currentModelPropertyValueList = Arrays.asList(currentModelPropertyValue);
            for (Object object : checkedElements) {
                if (!currentModelPropertyValueList.contains(object)) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }

    private abstract static class FieldExecutor {
        public abstract void validate() throws FieldValidationException;

        public abstract void setFieldValue(ProjectDataModel model) throws Exception;

        public abstract List<String> getUpdateFields();

        public abstract void setControlEnableState();

        public abstract void setControlVisibleState();

    }

    private abstract static class CommonFieldExecutor extends FieldExecutor {
        protected ProjectOptionData optionData;
        protected ProjectDataModel model;
        protected Control control;

        public CommonFieldExecutor(ProjectOptionData optionData, ProjectDataModel model,
                                   Control control) {
            this.optionData = optionData;
            this.model = model;
            this.control = control;
        }

        public boolean isEnableField() {
            if (optionData.getFieldController() != null) {
                return optionData.getFieldController().isEnableField(optionData.getModelProperty(),
                        model);
            }
            return true;
        }

        public boolean isVisibleField() {
            if (optionData.getFieldController() != null) {
                return optionData.getFieldController()
                        .isVisibleField(optionData.getModelProperty(), model);
            }
            return true;
        }


        public void setControlEnableState() {
            control.setEnabled(isEnableField());
        }


        public void setControlVisibleState() {
            boolean visibleField = isVisibleField();
            Object layoutData = control.getLayoutData();
            if (layoutData == null) {
                layoutData = new GridData();
            }
            if (layoutData instanceof GridData) {
                ((GridData) layoutData).exclude = !visibleField;
                control.setLayoutData(layoutData);
            }
            control.setVisible(visibleField);
            WSO2UIToolkit.updateControlVisibilityStatus(control);
        }


        public List<String> getUpdateFields() {
            if (optionData.getFieldController() != null) {
                return optionData.getFieldController().getUpdateFields(
                        optionData
                                .getModelProperty(),
                        model);
            }
            return new ArrayList<String>();
        }

        protected Object getModelPropertyValue() {
            return model.getModelPropertyValue(optionData.getModelProperty());
        }
    }

}