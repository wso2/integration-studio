/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.gmf.esb.diagram.part;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import javax.xml.stream.FactoryConfigurationError;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import org.wso2.integrationstudio.gmf.esb.diagram.Activator;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

public class HideConnectorWizardPage extends WizardPage {

    private static final String HIDE_CONNECTOR_MODULE_TITLE = "Show or Hide Connectors/Modules";
    private static final String HIDE_CONNECTOR_MODULE_DESC = "Select the connectors you want shown on the workspace";

    private TableViewer tblLibraryInfoViewer;
    private Table table;
    private Button selectAllButton;
    private Button deselectAllButton;
    private static final String DIR_DOT_METADATA = ".metadata";
    public static final String connectorPathFromWorkspace = DIR_DOT_METADATA + File.separator + ".Connectors";
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public HideConnectorWizardPage(boolean existingProject) {
        super("wizardPage");
        setTitle(HIDE_CONNECTOR_MODULE_TITLE);
        setDescription(HIDE_CONNECTOR_MODULE_DESC);
    }

    /*
     * Hide/Show connectors wizard
     */
    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NULL);
        setControl(container);
        container.setLayout(new GridLayout(1, false));
        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.verticalAlignment = GridData.FILL;
        gridData.grabExcessVerticalSpace = true;
        gridData.grabExcessHorizontalSpace = true;
        gridData.heightHint = 260;
        gridData.widthHint = 300;
        table = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        table.setEnabled(true);
        TableColumn tc1 = new TableColumn(table, SWT.LEFT);
        tc1.setText("Connector/Module");
        tc1.setWidth(200);
        table.setHeaderVisible(true);
        table.setLayoutData(gridData);
        table.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                for (TableItem item : table.getItems()) {
                    if (item.getChecked()) {
                        break;
                    }
                }
            }
        });

        // composite for "select all" & "deselect all" buttons
        final Composite buttonContainer = new Composite(container, SWT.NULL);
        buttonContainer.setLayout(new GridLayout(2, false));

        // select all button
        selectAllButton = new Button(buttonContainer, SWT.PUSH);
        selectAllButton.setText("Select All");

        // select all button listener
        selectAllButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                for (TableItem item : table.getItems()) {
                    item.setChecked(true);
                }
            }
        });

        // deselect all button
        deselectAllButton = new Button(buttonContainer, SWT.PUSH);
        deselectAllButton.setText("Deselect All");

        // deselect all button listener
        deselectAllButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                for (TableItem item : table.getItems()) {
                    item.setChecked(false);
                }
            }
        });

        try {
            listConnectors(table);
        } catch (FactoryConfigurationError e1) {
            log.error("Error while listing connectors ", e1);
            MessageDialog.openError(getShell(), "Error while listing connectors ", e1.getMessage());
        } catch (Exception e1) {
            log.error("Error while listing connectors ", e1);
            MessageDialog.openError(getShell(), "Error while listing connectors ", e1.getMessage());
        }
    }

    /*
     * List available connectors on the Hide/Show Connectors Wizard
     */
    private void listConnectors(Table table) throws FactoryConfigurationError, Exception {
        String connectorsFile;
        String[] checkedConnectors = null;
        String connectorPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator
                + connectorPathFromWorkspace;
        File directory = new File(connectorPath);
        String[] names = directory.list();
        Boolean exist = Files.exists(Paths.get(connectorPath + File.separator + "checkedConnectors.txt"),
                LinkOption.NOFOLLOW_LINKS);

        if (exist) {
            connectorsFile = new String(
                    Files.readAllBytes(Paths.get(connectorPath + File.separator + "checkedConnectors.txt")));
            checkedConnectors = connectorsFile.split(", ");
            for (String name : names) {
                // Does not add .zip or .txt files to list
                if (!((name.contains(".zip")) || (name.contains(".txt")))) {
                    TableItem tableItem = new TableItem(table, SWT.NONE);
                    name = name.substring(0, 1).toUpperCase() + name.substring(1).replaceAll("\\-(.*)", " Connector");
                    if (checkedConnectors != null) {
                        for (String checkedConnector : checkedConnectors) {
                            if (checkedConnector.equals(name)) {
                                // Ticks the check box
                                tableItem.setChecked(true);
                            }
                        }
                    }
                    tableItem.setText(name);
                    tableItem.setData(name);
                }
            }
        }
    }

    public boolean isValid() {
        if (tblLibraryInfoViewer.getTable().getItemCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
