/*
 * Copyright (c) 2019 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software He   
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.wso2.developerstudio.eclipse.docker.distribution.editor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class KubernetesArtifactsGenerationWizardPage extends WizardPage {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String WINDOW_TITLE = "Generate Kubernetes Artifacts Wizard";
    private static final String TITLE = "Generate Kubernetes Artifacts";
    private static final String WINDOW_DESCRIPTION = "Select a method to proceed Kubernetes artifact generation";
    private static final String CREATE_PROJECT_LABLE = "Create a new Kubernetes Exporter Project";
    private static final String RUN_EXISTING_PROJECT_LABLE = "Generate Kubernetes Artifacts with an Existing Project";
    private static final String CREATE_NEW_DESCRIPTION = "This option facilitates you to create a new Kubernetes Exporter project which is "
            + "capable to update the configuration of the base image, add libraries, add multiple CApps to the image, etc. Recommends for "
            + "the Kubernetes based deployments in CI/CD flow.";

    private boolean isCreateNewProjectChecked = true;
    private boolean isUseExistingProjectChecked = false;
    private String selectedK8sProjectPath;
    private Label lblCreateProject;
    private Group grpCreateNewProjectData;
    private Group grpK8sProjectList;
    private Button useExistingProjectBtn;
    private List<Button> k8sProjectList;

    public KubernetesArtifactsGenerationWizardPage(IWorkbench wb, IStructuredSelection selection) {
        super(WINDOW_TITLE);
        setTitle(TITLE);
        setDescription(WINDOW_DESCRIPTION);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;

        // Create new project group
        Button createNewBtn = new Button(container, SWT.RADIO);
        createNewBtn.setSelection(true);
        data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(3);
        createNewBtn.setLayoutData(data);
        createNewBtn.setText(CREATE_PROJECT_LABLE);

        createNewBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    setCreateNewProjectChecked(true);
                    setUseExistingProjectChecked(false);
                    disableEnableGroupData();
                }
            }
        });

        grpCreateNewProjectData = new Group(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(createNewBtn, 5);
        data.left = new FormAttachment(4);
        data.right = new FormAttachment(96);
        grpCreateNewProjectData.setLayoutData(data);
        grpCreateNewProjectData.setLayout(new FormLayout());

        lblCreateProject = new Label(grpCreateNewProjectData, SWT.WRAP);
        data = new FormData();
        data.top = new FormAttachment(grpCreateNewProjectData, 3);
        data.left = new FormAttachment(1);
        data.width = 600;
        lblCreateProject.setLayoutData(data);
        lblCreateProject.setText(CREATE_NEW_DESCRIPTION);

        // Use existing docker project group
        useExistingProjectBtn = new Button(container, SWT.RADIO);
        data = new FormData();
        data.top = new FormAttachment(grpCreateNewProjectData, 20);
        data.left = new FormAttachment(3);
        useExistingProjectBtn.setLayoutData(data);
        useExistingProjectBtn.setText(RUN_EXISTING_PROJECT_LABLE);

        useExistingProjectBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Button source = (Button) e.getSource();
                if (source.getSelection()) {
                    setCreateNewProjectChecked(false);
                    setUseExistingProjectChecked(true);
                    disableEnableGroupData();
                }
            }
        });

        grpK8sProjectList = new Group(container, SWT.SHADOW_IN);
        data = new FormData();
        data.top = new FormAttachment(useExistingProjectBtn, 5);
        data.left = new FormAttachment(4);
        data.right = new FormAttachment(96);
        grpK8sProjectList.setLayoutData(data);
        grpK8sProjectList.setLayout(new FormLayout());

        ScrolledComposite scrollComposite = new ScrolledComposite(grpK8sProjectList, SWT.V_SCROLL);
        data = new FormData();
        data.top = new FormAttachment(useExistingProjectBtn, 5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.height = 100;
        scrollComposite.setLayout(new FormLayout());
        scrollComposite.setLayoutData(data);

        Composite composite = new Composite(scrollComposite, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(scrollComposite, 5);
        composite.setLayout(new FormLayout());
        composite.setLayoutData(data);

        IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
        IProject[] allProjects = wroot.getProjects();
        List<String> k8sProjects = new ArrayList<>();
        for (IProject project : allProjects) {
            try {
                if (project.hasNature(Constants.KUBERNETES_EXPORTER_PROJECT_NATURE)) {
                    k8sProjects.add(project.getName());
                }
            } catch (CoreException e) {
                log.error("Exception while processing the workspace for find Kubernetes projects", e);
            }
        }
        int iterator = 0;
        k8sProjectList = new ArrayList<>();
        for (String projectPath : k8sProjects) {
            Button dockerProjectBtn = new Button(composite, SWT.RADIO);
            data = new FormData();
            data.top = new FormAttachment(composite, 25 * iterator);
            data.left = new FormAttachment(1);
            dockerProjectBtn.setLayoutData(data);
            dockerProjectBtn.setText(projectPath);
            k8sProjectList.add(dockerProjectBtn);

            dockerProjectBtn.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    Button source = (Button) e.getSource();
                    if (source.getSelection()) {
                        setSelectedK8sProjectPath(source.getText());
                    }
                }
            });
            iterator++;
        }

        scrollComposite.setContent(composite);
        scrollComposite.setExpandVertical(true);
        scrollComposite.setExpandHorizontal(true);
        scrollComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        disableEnableGroupData();
        setControl(container);
    }

    private void disableEnableGroupData() {
        Color disableColor = new Color(null, 181, 181, 183);
        Color enableColor = new Color(null, 0, 0, 0);

        if (isCreateNewProjectChecked) {
            lblCreateProject.setForeground(enableColor);
            grpCreateNewProjectData.setEnabled(true);
            grpK8sProjectList.setEnabled(false);
        } else {
            lblCreateProject.setForeground(disableColor);
            grpCreateNewProjectData.setEnabled(false);
            grpK8sProjectList.setEnabled(true);
        }
        
        disableEnableDockerProjectList();
    }
    
    private void disableEnableDockerProjectList() {
        if (k8sProjectList.size() > 0) {
            useExistingProjectBtn.setEnabled(true);
            if (isCreateNewProjectChecked) {
                for (Button dockerBtn : k8sProjectList) {
                    dockerBtn.setEnabled(false);
                }
            } else {
                k8sProjectList.get(0).setSelection(true);
                setSelectedK8sProjectPath(k8sProjectList.get(0).getText());
                for (Button dockerBtn : k8sProjectList) {
                    dockerBtn.setEnabled(true);
                }
            } 
        } else {
            useExistingProjectBtn.setEnabled(false);
        }
    }

    public boolean isCreateNewProjectChecked() {
        return isCreateNewProjectChecked;
    }

    public void setCreateNewProjectChecked(boolean isCreateNewProjectChecked) {
        this.isCreateNewProjectChecked = isCreateNewProjectChecked;
    }

    public boolean isUseExistingProjectChecked() {
        return isUseExistingProjectChecked;
    }

    public void setUseExistingProjectChecked(boolean isUseExistingProjectChecked) {
        this.isUseExistingProjectChecked = isUseExistingProjectChecked;
    }

    public String getSelectedK8sProjectPath() {
        return selectedK8sProjectPath;
    }

    public void setSelectedK8sProjectPath(String selectedK8sProjectPath) {
        this.selectedK8sProjectPath = selectedK8sProjectPath;
    }
}
