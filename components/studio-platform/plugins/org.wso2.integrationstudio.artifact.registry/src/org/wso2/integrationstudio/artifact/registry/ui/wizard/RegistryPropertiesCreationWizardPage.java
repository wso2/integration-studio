/*
 * Copyright (c) 2021 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.artifact.registry.ui.wizard;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.integrationstudio.artifact.registry.utils.RegistryResourceImageUtils;
import org.wso2.integrationstudio.general.project.artifact.GeneralProjectArtifact;
import org.wso2.integrationstudio.general.project.artifact.RegistryArtifact;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryCollection;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryElement;
import org.wso2.integrationstudio.general.project.artifact.bean.RegistryItem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegistryPropertiesCreationWizardPage extends WizardPage {

    private Group registryPropertiesContainer;
    private Table tblRegistryProperties;
    private Button btnPropertyAdd;
    private Button btnPropertyRemove;
    private Combo comboHeaderTags;

    private String selectedRegistryResourceId;
    private RegistryArtifact selectedRegistryArtifact;
    private Map<String, RegistryArtifact> allExistingRegistryArtifacts = new HashMap<String, RegistryArtifact>();
    private Map<String, String> registryProperties = new HashMap<String, String>();

    /**
     * Create the wizard.
     */
    public RegistryPropertiesCreationWizardPage(GeneralProjectArtifact generalProjectArtifact, String resourcePath) {
        super("wizardPage");
        setTitle("Add/Remove Registry Resource Properties");
        fetchRegistryResourceInfo(generalProjectArtifact);
        if (resourcePath != null) {
            selectedRegistryResourceId = generateRegistryResourceComboId(resourcePath);
            setSelectedRegistryArtifact(selectedRegistryResourceId);
        }
        setImageDescriptor(
                RegistryResourceImageUtils.getInstance().getImageDescriptor("registry-properties-55x55.png"));
    }

    /**
     * Create contents of the wizard.
     *
     * @param parent
     */
    public void createControl(Composite parent) {
        setPageComplete(false);
        Composite container = new Composite(parent, SWT.NULL);
        container.setLayout(new FormLayout());
        FormData data;

        // registry resource selection section
        Label lblDockerProjectName = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(container, 10);
        data.left = new FormAttachment(5);
        data.width = 150;
        lblDockerProjectName.setLayoutData(data);
        lblDockerProjectName.setText("Registry Resource:");

        comboHeaderTags = new Combo(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(container, 5);
        data.left = new FormAttachment(lblDockerProjectName, 0);
        data.right = new FormAttachment(98);
        Set<String> resourceIdSet = allExistingRegistryArtifacts.keySet();
        comboHeaderTags.setItems(resourceIdSet.toArray(new String[resourceIdSet.size()]));
        comboHeaderTags.setLayoutData(data);
        addAutoCompleteFeature(comboHeaderTags);

        registryPropertiesContainer = new Group(container, SWT.BORDER);
        registryPropertiesContainer.setLayout(new FormLayout());

        data = new FormData();
        data.top = new FormAttachment(lblDockerProjectName, 15);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        registryPropertiesContainer.setLayoutData(data);

        // Registry Properties table
        Label lblParameters = new Label(registryPropertiesContainer, SWT.NONE);
        lblParameters.setText("Registry Properties:");
        data = new FormData();
        data.top = new FormAttachment(container, 20);
        data.left = new FormAttachment(2);
        lblParameters.setLayoutData(data);

        // Property add button
        btnPropertyAdd = new Button(registryPropertiesContainer, SWT.NONE);
        data = new FormData();
        data.width = 100;
        data.top = new FormAttachment(lblParameters, 10);
        data.left = new FormAttachment(2);
        btnPropertyAdd.setLayoutData(data);
        btnPropertyAdd.setText("Add");
        btnPropertyAdd.setEnabled(false);
        btnPropertyAdd.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TableItem item = new TableItem(tblRegistryProperties, SWT.NONE);
                item.setText(0, "Key-" + tblRegistryProperties.getItemCount());
                item.setText(1, "value");
                tblRegistryProperties.select(tblRegistryProperties.indexOf(item));
                updateRegistryProperties();
            }
        });

        // Property remove button
        btnPropertyRemove = new Button(registryPropertiesContainer, SWT.NONE);
        data = new FormData();
        data.width = 100;
        data.top = new FormAttachment(lblParameters, 10);
        data.left = new FormAttachment(btnPropertyAdd, 5);
        btnPropertyRemove.setLayoutData(data);
        btnPropertyRemove.setText("Remove");
        btnPropertyRemove.setEnabled(false);
        btnPropertyRemove.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int selectedIndex = tblRegistryProperties.getSelectionIndex();
                if (-1 != selectedIndex) {
                    tblRegistryProperties.remove(selectedIndex);

                    // Select the next available candidate for deletion.
                    if (selectedIndex < tblRegistryProperties.getItemCount()) {
                        tblRegistryProperties.select(selectedIndex);
                    } else {
                        tblRegistryProperties.select(selectedIndex - 1);
                    }
                }
                btnPropertyRemove.setEnabled(tblRegistryProperties.getItemCount() > 0);
                updateRegistryProperties();
            }
        });

        tblRegistryProperties = new Table(registryPropertiesContainer, SWT.BORDER | SWT.FULL_SELECTION);
        data = new FormData();
        data.top = new FormAttachment(btnPropertyAdd, 7);
        data.left = new FormAttachment(2);
        data.right = new FormAttachment(98);
        data.height = 130;
        tblRegistryProperties.setLayoutData(data);
        tblRegistryProperties.setHeaderVisible(true);
        tblRegistryProperties.setLinesVisible(true);

        TableColumn tblclmnName = new TableColumn(tblRegistryProperties, SWT.CENTER);
        tblclmnName.setWidth(270);
        tblclmnName.setText("Key");

        TableColumn tblclmnValue = new TableColumn(tblRegistryProperties, SWT.CENTER);
        tblclmnValue.setWidth(270);
        tblclmnValue.setText("Value");

        tblRegistryProperties.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                btnPropertyRemove.setEnabled(tblRegistryProperties.getItemCount() > 0);
            }
        });

        tblRegistryProperties.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                updateRegistryProperties();
            }
        });

        // Refresh registry properties table with selected artifact
        if (selectedRegistryArtifact != null) {
            comboHeaderTags.setText(selectedRegistryResourceId);
            refreshRegistryPropertiesTable();
            validatePage(selectedRegistryResourceId);
        } else {
            validatePage("");
        }

        comboHeaderTags.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setSelectedRegistryArtifact(comboHeaderTags.getText());
                refreshRegistryPropertiesTable();
                validatePage(comboHeaderTags.getText());
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        comboHeaderTags.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setSelectedRegistryArtifact(comboHeaderTags.getText());
                refreshRegistryPropertiesTable();
                validatePage(comboHeaderTags.getText());
            }
        });

        // In-line editing of properties.
        setupRegistryPropertiesTableEditor(tblRegistryProperties);

        setControl(container);
        TrayDialog.setDialogHelpAvailable(false);
    }

    /**
     * Set up a table editor that allows users to edit cell values in line.
     *
     * @param table against which a table editor is setup.
     */
    private void setupRegistryPropertiesTableEditor(final Table table) {
        final TableEditor cellEditor = new TableEditor(table);
        cellEditor.grabHorizontal = true;
        cellEditor.minimumWidth = 50;
        table.addMouseListener(new MouseAdapter() {
            /**
             * Setup a new cell editor control at double click event.
             */
            public void mouseDoubleClick(MouseEvent e) {
                // Dispose the old editor control (if one is setup).
                Control oldEditorControl = cellEditor.getEditor();
                if (oldEditorControl != null) {
                    oldEditorControl.dispose();
                }
                // Mouse location.
                Point mouseLocation = new Point(e.x, e.y);

                // Grab the selected row.
                TableItem item = (TableItem) table.getItem(mouseLocation);
                if (item == null) {
                    return;
                }
                // Determine which column was selected.
                int selectedColumn = -1;
                for (int i = 0, n = table.getColumnCount(); i < n; i++) {
                    if (item.getBounds(i).contains(mouseLocation)) {
                        selectedColumn = i;
                        break;
                    }
                }

                // Setup a new editor control.
                if (selectedColumn != -1) {
                    Text editorControl = new Text(table, SWT.NONE);
                    final int editorControlColumn = selectedColumn;
                    editorControl.setText(item.getText(selectedColumn));
                    editorControl.addModifyListener(new ModifyListener() {
                        public void modifyText(ModifyEvent e) {
                            Text text = (Text) cellEditor.getEditor();
                            cellEditor.getItem().setText(editorControlColumn, text.getText());
                        }
                    });
                    editorControl.selectAll();
                    editorControl.setFocus();
                    cellEditor.setEditor(editorControl, item, selectedColumn);
                }
            }

            /**
             * Dispose cell editor control at mouse down (otherwise the control keep showing).
             */
            public void mouseDown(MouseEvent e) {
                Control oldEditorControl = cellEditor.getEditor();
                if (null != oldEditorControl) {
                    oldEditorControl.dispose();
                }
                updateRegistryProperties();
            }
        });
    }

    /**
     * Update the Registry Properties map using table items.
     */
    private void updateRegistryProperties() {
        registryProperties.clear();
        for (TableItem item : tblRegistryProperties.getItems()) {
            registryProperties.put(item.getText(0), item.getText(1));
        }
    }

    public Map<String, String> getRegistryProperties() {
        return Collections.unmodifiableMap(registryProperties);
    }

    /**
     * Fetch all the existing registry artifacts that are mentioned in the artifact.xml file.
     *
     * @param generalProjectArtifact instance that represents the artifact.xml file
     */
    public void fetchRegistryResourceInfo(GeneralProjectArtifact generalProjectArtifact) {
        List<RegistryArtifact> resourceList = generalProjectArtifact.getAllArtifacts();
        for (int index = 0; index < resourceList.size(); index++) {
            RegistryElement registryElement = resourceList.get(index).getAllRegistryItems().get(0);
            String key = "";
            if (registryElement instanceof RegistryItem) {
                String file = ((RegistryItem) registryElement).getFile();
                key = generateRegistryResourceComboId(file);

            } else if (registryElement instanceof RegistryCollection) {
                String directory = ((RegistryCollection) registryElement).getDirectory();
                key = generateRegistryResourceComboId(directory);
            }

            if (!key.isEmpty()) {
                allExistingRegistryArtifacts.put(key, resourceList.get(index));
            }
        }
    }

    /**
     * Refresh registry properties table in the wizard page.
     */
    public void refreshRegistryPropertiesTable() {
        registryProperties.clear();
        if (tblRegistryProperties != null) {
            tblRegistryProperties.removeAll();
        }
        if (selectedRegistryArtifact == null) {
            return;
        }
        List<RegistryElement> regElements = selectedRegistryArtifact.getAllRegistryItems();
        if (regElements.isEmpty()) {
            return;
        }
        Map<String, String> existingProperties = regElements.get(0).getProperties();
        for (Map.Entry<String, String> property : existingProperties.entrySet()) {
            TableItem item = new TableItem(tblRegistryProperties, SWT.NONE);
            item.setText(0, property.getKey());
            item.setText(1, property.getValue());
            registryProperties.put(property.getKey(), property.getValue());
        }
    }

    /**
     * Validate the wizard page field data and update the page accordingly.
     */
    private void validatePage(String selectedComboItem) {
        if (selectedRegistryArtifact == null) {
            if (selectedComboItem.isEmpty()) {
                updatePageStatus("Registry resource cannot be null");
            } else {
                updatePageStatus("Registry resource does not exist inside the selected project");
            }
        } else {
            updatePageStatus(null);
        }
    }

    /**
     * Update the page state.
     *
     * @param msg error message
     */
    public void updatePageStatus(String errMsg) {
        setErrorMessage(errMsg);
        setPageComplete(errMsg == null);
        btnPropertyAdd.setEnabled(errMsg == null);
    }

    public RegistryArtifact getSelectedRegistryResource() {
        return this.selectedRegistryArtifact;
    }

    public void setSelectedRegistryArtifact(String resource) {
        this.selectedRegistryArtifact = allExistingRegistryArtifacts.get(resource);
    }

    /**
     * Generate registry resource id to be displayed in the combo items.
     *
     * @param filePath resource's project relative file path
     * @return registry resource id with the format of "resourceFileName [projectReglativePath]"
     */
    public String generateRegistryResourceComboId(String filePath) {
        String key = filePath;
        int lastIndex = filePath.lastIndexOf('/');
        if (lastIndex > 0) {
            String path = filePath.substring(0, lastIndex);
            String fileName = filePath.substring(lastIndex + 1);
            key = fileName + " [" + path + "]";
        }
        return key;
    }

    /**
     * Auto complete the combo item with available items in the combo list when typing.
     *
     * @param combo Combo instance
     */
    public static void addAutoCompleteFeature(Combo combo) {
        // Add a key listener
        combo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent keyEvent) {
                Combo cmb = ((Combo) keyEvent.getSource());
                setClosestMatch(cmb);
            }

            // Move the highlight back by one character for backspace
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.keyCode == SWT.BS) {
                    Combo cmb = ((Combo) keyEvent.getSource());
                    Point pt = cmb.getSelection();
                    cmb.setSelection(new Point(Math.max(0, pt.x - 1), pt.y));
                }
            }

            private void setClosestMatch(Combo combo) {
                String str = combo.getText();
                String[] cItems = combo.getItems();
                // Find Item in Combo Items. If full match returns index
                int index = -1;
                for (int i = 0; i < cItems.length; i++) {
                    if (cItems[i].toLowerCase().startsWith(str.toLowerCase())) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    Point pt = combo.getSelection();
                    combo.select(index);
                    combo.setText(cItems[index]);
                    combo.setSelection(new Point(pt.x, cItems[index].length()));
                }
            }
        });
    }
}
