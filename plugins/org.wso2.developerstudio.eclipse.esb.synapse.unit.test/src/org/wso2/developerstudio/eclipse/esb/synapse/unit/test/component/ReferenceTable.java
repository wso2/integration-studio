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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.component;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

/**
 * Class responsible for creating Reference Table with add and remove buttons.
 */
public class ReferenceTable {

    private final Image NEW_ELEMENT_IMG = EEFRuntimePlugin.getImage(EEFRuntimePlugin.ICONS_16x16 + "Add_16x16.gif");
    private final Image REFRESH_ELEMENT_IMG = SWTResourceManager.getImage(this.getClass(), "/icons/refresh.png");
    private final Image DELETE_ELEMENT_IMG = EEFRuntimePlugin
            .getImage(EEFRuntimePlugin.ICONS_16x16 + "Delete_16x16.gif");

    /**
     * Method of creating table.
     * 
     * @param parent
     *            composite layout
     * @param numerator
     *            style
     * @return Table widget
     */
    public Table createReferenceTable(Composite parent, int numerator) {
        Table table = new Table(parent, SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
        table.setLayout(new FormLayout());
        table.setVisible(true);

        return table;
    }

    /**
     * Method of creating remove button.
     * 
     * @param parent
     *            composite layout
     * @param text
     *            Button text
     * @param style
     *            style as int
     * @return Button widget
     */
    public Button createRemoveButton(Composite parent, String text, int style) {
        Button removeButton = new Button(parent, style);
        removeButton.setText(text);
        removeButton.setVisible(true);
        removeButton.setImage(DELETE_ELEMENT_IMG);
        removeButton.setEnabled(false);
        return removeButton;
    }

    /**
     * Method of creating add button.
     * 
     * @param parent
     *            composite layout
     * @param text
     *            Button text
     * @param style
     *            style as int
     * @return Button widget
     */
    public Button createAddButton(Composite parent, String text, int style) {
        Button addButton = new Button(parent, style);
        addButton.setVisible(true);
        addButton.setImage(NEW_ELEMENT_IMG);
        addButton.setText(text);
        return addButton;
    }
    
    /**
     * Method of creating refresh button.
     * 
     * @param parent
     *            composite layout
     * @param text
     *            Button text
     * @param style
     *            style as int
     * @return Button widget
     */
    public Button createRefreshButton(Composite parent, String text, int style) {
        Button addButton = new Button(parent, style);
        addButton.setVisible(true);
        addButton.setImage(REFRESH_ELEMENT_IMG);
        addButton.setText(text);
        return addButton;
    }

    /**
     * Method of creating Table Viewer.
     * 
     * @param table
     *            reference table
     * @return TableViewer widget
     */
    public TableViewer createTableViewer(Table table) {
        TableViewer tableViewer;
        tableViewer = new TableViewer(table);
        return tableViewer;
    }
}
