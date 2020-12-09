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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component.DependencyTree;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;

/**
 * Class responsible for creation of wizard page for select supportive
 * artifacts.
 */
public class UnitTestSuiteSupportiveArtifactsSelectionPage extends WizardPage {

    private final String SUPPORTIVE_ARTIFACTS_LABEL = "Artifacts to include in the Unit Test Suite";
    private final String SELECT_ALL_BUTTON = "Select All";
    private final String DESELECT_ALL_BUTTON = "Deselect All";
    private DependencyTree resourceTree;
    private Tree trDependencies;
    private SynapseUnitTest unitTestDataHolder;

    /**
     * Class constructor.
     */
    public UnitTestSuiteSupportiveArtifactsSelectionPage(String title, String description,
            SynapseUnitTest unitTestDataHolder) {
        super(title);
        setTitle(title);
        setDescription(description);

        this.unitTestDataHolder = unitTestDataHolder;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        setControl(container);

        container.setLayout(new FormLayout());
        
        FormData fd = new FormData();
        Label supportiveArtifactlblName = new Label(container, SWT.NONE);
        fd = new FormData();
        fd.top = new FormAttachment(2);
        fd.left = new FormAttachment(2);
        supportiveArtifactlblName.setLayoutData(fd);
        supportiveArtifactlblName.setText(SUPPORTIVE_ARTIFACTS_LABEL);

        resourceTree = new DependencyTree(unitTestDataHolder, null, "SUPPORTIVE_ARTIFACTS");
        trDependencies = resourceTree.createResourcesTree(container, "Supportive Artifacts");
        fd = new FormData();
        fd.top = new FormAttachment(supportiveArtifactlblName, 10);
        fd.left = new FormAttachment(1);
        fd.right = new FormAttachment(99);
        fd.height = 200;
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

        setPageComplete(true);
    }

    /**
     * Method for refreshing the mock services resource tree.
     */
    public void refreshSupportiveArtifactTree() {
        resourceTree.createTreeContent();
        resourceTree.expandParentNodes();
    }
}
