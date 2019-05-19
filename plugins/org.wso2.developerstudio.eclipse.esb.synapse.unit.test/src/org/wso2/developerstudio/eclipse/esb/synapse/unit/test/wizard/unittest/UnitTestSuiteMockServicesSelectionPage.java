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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.unittest;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.DependencyTree;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.mockservice.MockServiceSuiteCreationWizard;

/**
 * Class responsible for creation of wizard page for select mock services.
 */
public class UnitTestSuiteMockServicesSelectionPage extends WizardPage {

    private final String MOCK_SERVICES_LABEL = "Mock Services to include in the Unit Test Suite";
    private final String SELECT_ALL_BUTTON = "Select All";
    private final String DESELECT_ALL_BUTTON = "Deselect All";
    private DependencyTree resourceTree;
    private Tree trDependencies;
    private SynapseUnitTest unitTestDataHolder;
    private IStructuredSelection selectionEvent;

    /**
     * Class constructor.
     */
    public UnitTestSuiteMockServicesSelectionPage(String title, String description, IStructuredSelection selection,
            SynapseUnitTest unitTestDataHolder) {
        super(title);
        setTitle(title);
        setDescription(description);
        this.unitTestDataHolder = unitTestDataHolder;
        this.selectionEvent = selection;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        setControl(container);

        container.setLayout(new FormLayout());

        Label mockServiceArtifactlblName = new Label(container, SWT.NONE);
        FormData fd = new FormData();
        fd.top = new FormAttachment(5);
        fd.left = new FormAttachment(2);
        mockServiceArtifactlblName.setLayoutData(fd);
        mockServiceArtifactlblName.setText(MOCK_SERVICES_LABEL);

        resourceTree = new DependencyTree(unitTestDataHolder, null, "MOCK_SERVICE");
        trDependencies = resourceTree.createResourcesTree(container, "Mock Services");
        fd = new FormData();
        fd.top = new FormAttachment(mockServiceArtifactlblName, 10);
        fd.left = new FormAttachment(1);
        fd.right = new FormAttachment(99);
        fd.bottom = new FormAttachment(90);
        trDependencies.setLayoutData(fd);

        trDependencies.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent evt) {
                final TreeItem item = (TreeItem) evt.item;
                if (evt.detail == SWT.CHECK && item != null) {
                    resourceTree.handleTreeItemChecked(item);
                }
            }

            public void widgetDefaultSelected(SelectionEvent evt) {

            }
        });

        Button btnSelectAll = new Button(container, SWT.NONE);
        btnSelectAll.setText(SELECT_ALL_BUTTON);
        fd = new FormData();
        fd.top = new FormAttachment(trDependencies, 10);
        fd.left = new FormAttachment(1);
        btnSelectAll.setLayoutData(fd);

        btnSelectAll.addListener(SWT.MouseDown, new Listener() {
            public void handleEvent(Event evt) {
                TreeItem[] items = trDependencies.getItems();
                for (TreeItem item : items) {
                    if (!item.getChecked() || item.getGrayed()) {
                        item.setChecked(true);
                        resourceTree.handleTreeItemChecked(item);
                    }
                }
            }
        });

        Button btnDeselectAll = new Button(container, SWT.NONE);
        btnDeselectAll.setText(DESELECT_ALL_BUTTON);
        fd = new FormData();
        fd.top = new FormAttachment(trDependencies, 10);
        fd.left = new FormAttachment(btnSelectAll, 2);
        btnDeselectAll.setLayoutData(fd);

        btnDeselectAll.addListener(SWT.MouseDown, new Listener() {
            public void handleEvent(Event evt) {
                TreeItem[] items = trDependencies.getItems();
                for (TreeItem item : items) {
                    item.setChecked(false);
                    resourceTree.handleTreeItemChecked(item);
                }
            }
        });

        // Create link to navigate for the creation of mock service
        Link linkMockLabel = new Link(container, SWT.NONE);
        fd = new FormData();
        fd.top = new FormAttachment(trDependencies, 20);
        fd.right = new FormAttachment(98);
        linkMockLabel.setLayoutData(fd);
        linkMockLabel.setText("<A>" + "Create a New Mock Service" + "</A>");

        linkMockLabel.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                MockServiceSuiteCreationWizard wizard = new MockServiceSuiteCreationWizard();
                wizard.init(PlatformUI.getWorkbench(), selectionEvent);
                WizardDialog exportWizardDialog = new WizardDialog(getShell(), wizard);
                exportWizardDialog.setHelpAvailable(false);
                exportWizardDialog.open();

                resourceTree.createTreeContent();
                resourceTree.expandParentNodes();
            }
        });

        setPageComplete(true);
    }
}
