/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.maven.multi.module.add.other.projects;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.wso2.developerstudio.eclipse.maven.multi.module.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class MMMProjectSelectionWizardPage extends WizardPage {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private TreeEditor editor;
    private Tree trDependencies;
    private boolean isPageDirty;
    private String selectedProjectName;
    private String selectedProjectLoction;

    /**
     * Create the wizard.
     */
    public MMMProjectSelectionWizardPage() {
        super("Select a Maven Multi Module Project");
        setTitle("Select a Maven Multi Module Project");
        setDescription("Select a Maven Multi Module project as a parent project.");
    }

    /**
     * Create contents of the wizard.
     * 
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());
        FormData data = new FormData();

        createResourcesTree(container);

        // Create link to navigate for the creation of composite project
        Link linkCompositeLabel = new Link(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(trDependencies, 20);
        data.right = new FormAttachment(98);
        linkCompositeLabel.setLayoutData(data);
        linkCompositeLabel.setText("<A>" + "Create a Maven Multi Module Project" + "</A>");

        linkCompositeLabel.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry()
                        .findWizard("org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard.MvnMultiModuleWizard");
                try {
                    if (null != descriptor) {
                        IWorkbenchWizard wizard = descriptor.createWizard();
                        wizard.init(PlatformUI.getWorkbench(), null);
                        WizardDialog wd = new WizardDialog(
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                        wd.setTitle(wizard.getWindowTitle());
                        wd.open();
                    }
                } catch (CoreException e) {
                    log.error("Cannot open wizard", e);
                }

                createProjectTreeContent();
                setCheckedElemets();
            }
        });

        setPageDirty(true);
        setPageComplete(false);
    }

    /**
     * Method of creating resource tree view.
     * 
     * @param parent
     *            composite layout
     * @return Tree widget
     */
    public void createResourcesTree(Composite parent) {
        trDependencies = new Tree(parent, SWT.CHECK | SWT.V_SCROLL | SWT.BORDER);
        trDependencies.setHeaderVisible(true);
        FormData data = new FormData();
        data.top = new FormAttachment(5);
        data.left = new FormAttachment(1);
        data.right = new FormAttachment(99);
        data.bottom = new FormAttachment(90);
        trDependencies.setLayoutData(data);

        TreeColumn trclmnArtifact = new TreeColumn(trDependencies, SWT.NONE);
        trclmnArtifact.setWidth(200);
        trclmnArtifact.setText("Maven Multi Module Projects");

        TreeColumn trclmnLocation = new TreeColumn(trDependencies, SWT.NONE);
        trclmnLocation.setWidth(410);
        trclmnLocation.setText("Location");

        editor = new TreeEditor(trDependencies);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;

        createProjectTreeContent();

        trDependencies.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent evt) {
                final TreeItem item = (TreeItem) evt.item;
                if (evt.detail == SWT.CHECK && item != null) {
                    setSelectedProjectName(item.getText(0));
                    setSelectedProjectLoction(item.getText(1));
                    setCheckedElemets();
                    setPageDirty(false);
                    setPageComplete(true);
                }
            }

            public void widgetDefaultSelected(SelectionEvent evt) {

            }
        });
    }

    /**
     * Method of creating tree contents for a projects.
     */
    public void createProjectTreeContent() {
        trDependencies.removeAll();

        try {
            IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            IProject[] projects = workspaceRoot.getProjects();

            for (IProject project : projects) {
                if (project.isOpen() && project.hasNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
                    createParentNode(trDependencies, project);
                }

            }
        } catch (CoreException e) {
            log.error("CoreException while creating nodes in resource tree", e);
        }
    }

    /**
     * Method of creating tree parent items as nodes.
     * 
     * @param parent
     *            parent tree node
     * @param project
     *            parent IProject
     */
    private void createParentNode(Tree parent, IProject project) {
        TreeItem item = new TreeItem(parent, SWT.NONE);

        try {
            item.setText(0, project.getName());
            item.setText(1, project.getLocation().toString());
            item.setImage(0, SWTResourceManager.getImage(this.getClass(), "/icons/mmm-project-16x16-03.png"));

        } catch (Exception e) {
            return;
        }
    }

    /**
     * Method of coloring already selected tree items.
     * 
     * @param dependencyList
     *            already selected item list
     */
    public void setCheckedElemets() {
        for (final TreeItem parentItem : trDependencies.getItems()) {
            parentItem.setChecked(false);
        }

        for (final TreeItem parentItem : trDependencies.getItems()) {
            String itemName = parentItem.getText(0);

            if (itemName.equals(getSelectedProjectName())) {
                parentItem.setChecked(true);
            }
        }
    }

    @Override
    public IWizardPage getNextPage() {
        return super.getNextPage();
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }

    public String getSelectedProjectName() {
        return selectedProjectName;
    }

    public void setSelectedProjectName(String selectedProjectName) {
        this.selectedProjectName = selectedProjectName;
    }

    public String getSelectedProjectLoction() {
        return selectedProjectLoction;
    }

    public void setSelectedProjectLoction(String selectedProjectLoction) {
        this.selectedProjectLoction = selectedProjectLoction;
    }
}
