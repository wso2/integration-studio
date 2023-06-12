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

package org.wso2.integrationstudio.esb.project.ui.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.artifact.connector.model.ConnectorModel;
import org.wso2.integrationstudio.artifact.connector.ui.wizard.ConnectorCreationWizard;
import org.wso2.integrationstudio.esb.project.Activator;
import org.wso2.integrationstudio.esb.project.model.ESBSolutionProjectModel;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.exception.ObserverFailedException;
import org.wso2.integrationstudio.utils.file.FileUtils;

public class ConnectorExporterWizardPage extends WizardPage {
    private IProject selectedProject;

    private static final String DIR_DOT_METADATA = ".metadata";
    private static final String DIR_CONNECTORS = ".Connectors";
    private static final String DIR_DOT_PROJECT = ".project";
    private static final String CONNECTOR_XML = "connector.xml";
    private static final String DIR_ICON = "icon";
    private static final String ICON = "icon-large.gif";
    private static final String ICON_NEW = "icon-large.png";
    private static final String COMBO_CONNECTOR = "combo.connector";

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static ConnectorExporterWizardPage wizard;

    static Map<String, Connector> existingConnectors;
    static Map<String, ConnectorExporter> allExporters;
    private Composite container;
    private Composite scContent;
    private Composite compCombo;
    private List<Combo> exporterCombos;

    private IProject project;
    private IPath projectRootPath;

    protected ConnectorExporterWizardPage(IStructuredSelection selection) {
        super("import");
        setTitle("Select a connector exporter");
        setDescription("Select an existing connector exporter or create a new connector exporter");
        IProject project = getProject(selection);
        if (project != null) {
            setSelectedProject(project);
        }
        wizard = this;
        existingConnectors = new HashMap<String, Connector>();
        allExporters = new HashMap<String, ConnectorExporter>();
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NULL);
        setControl(container);
        container.setLayout(new GridLayout(1, false));

        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window != null) {
            IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof IAdaptable) {
                project = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
            }
        }

        projectRootPath = project.getLocation().removeLastSegments(1);

        getConnectorsInWorkspace(existingConnectors);
        getConnectorExportersInProject(allExporters);

        exporterCombos = new ArrayList<Combo>();

        Label label1 = new Label(container, SWT.TITLE);
        label1.setText("Add newly installed connectors into connector exporter(s)");

        // Create scrolled composite
        final ScrolledComposite sc1 = new ScrolledComposite(container, SWT.H_SCROLL | SWT.V_SCROLL);
        sc1.setSize(container.getSize());

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.verticalAlignment = GridData.FILL;
        gridData.grabExcessVerticalSpace = true;
        gridData.grabExcessHorizontalSpace = true;

        // Content of scrolled composite
        scContent = new Composite(sc1, SWT.BORDER);
        sc1.setContent(scContent);
        scContent.setLayout(new GridLayout(4, false));
        scContent.setLayoutData(gridData);
        sc1.setLayoutData(gridData);
        container.setLayoutData(gridData);

        // Titles
        Label connectorTitle = new Label(scContent, SWT.NONE);
        connectorTitle.setText("Connector");

        Label hSeparator = new Label(scContent, SWT.VERTICAL | SWT.SEPARATOR);
        hSeparator.setLayoutData(new GridData(GridData.FILL_VERTICAL));

        Label exporterTitle = new Label(scContent, SWT.NONE);
        exporterTitle.setText("Connector Exporter(s)");
        GridData exporterTitleData = new GridData(GridData.FILL_HORIZONTAL);
        exporterTitleData.horizontalSpan = 2;
        exporterTitle.setLayoutData(exporterTitleData);

        // Create new connector exporter section
        Label newExporterLabel = new Label(container, SWT.TITLE);
        newExporterLabel.setText("Create new connector exporter project");

        Composite newExporterComposite = new Composite(container, SWT.NONE);
        newExporterComposite.setLayout(new GridLayout(2, false));

        GridData gridData2 = new GridData();
        gridData2.horizontalAlignment = GridData.FILL;
        gridData2.verticalAlignment = GridData.END;
        gridData2.grabExcessHorizontalSpace = true;
        newExporterComposite.setLayoutData(gridData2);

        Label projectNameLabel = new Label(newExporterComposite, SWT.NULL);
        projectNameLabel.setText("Project name:");
        Text projectName = new Text(newExporterComposite, SWT.BORDER);
        projectName.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));

        Button createExporterButton = new Button(container, SWT.PUSH);
        createExporterButton.setText("Create");
        createExporterButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {

                // Open Connector Exporter Creation Wizard
                ConnectorCreationWizard connectorWizard = new ConnectorCreationWizard();
                ConnectorModel connectorModel = new ConnectorModel();
                String connectorProjectName = projectName.getText();
                try {
                    connectorModel.setProjectName(connectorProjectName);
                    connectorModel.setLocation(new File(projectRootPath + File.separator + connectorProjectName));
                    connectorModel.setGroupId("test.group");
                } catch (ObserverFailedException e1) {
                    log.error("Failed to set project name : " + connectorProjectName, e1);
                }
                connectorWizard.setModel(connectorModel);
                connectorWizard.performFinish();
                updateExporterCombos();
            }
        });
        container.setSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    }

    private void getConnectorExportersInProject(Map<String, ConnectorExporter> connectorExporters) {

        File directory = projectRootPath.toFile();
        if (directory.isDirectory()) {
            File[] children = directory.listFiles();
            for (int i = 0; i < children.length; ++i) {
                if (children[i].isDirectory()) {
                    log.info("children:" + i + ":" + children[i]);

                    ConnectorExporter connectorExporter = deserializeConnectorExporterXML(
                            children[i].getAbsolutePath() + File.separator + DIR_DOT_PROJECT);

                    if (connectorExporter != null && connectorExporter.getConnectorExporterName() != null) {
                        connectorExporter.setConnectorExporterFilePath(children[i].getAbsolutePath());
                        connectorExporters.put(connectorExporter.getConnectorExporterName(), connectorExporter);
                    }

                }
            }
        }

    }

    /*
     * List available connectors
     */
    private void getConnectorsInWorkspace(Map<String, Connector> connectors) {

        String connectorDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + File.separator
                + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
        File directory = new File(connectorDirectory);
        if (directory.isDirectory()) {
            File[] children = directory.listFiles();
            for (int i = 0; i < children.length; ++i) {
                if (children[i].isDirectory()) {
                    log.info("children:" + i + ":" + children[i]);
                    Connector connector = deserializeConnectorXML(
                            children[i].getAbsolutePath() + File.separator + CONNECTOR_XML);
                    if (connector != null) {
                        connector.setConnectorFilePath(children[i].getAbsolutePath());
                        connector.setConnectorName(children[i].getName());
                        connectors.put(connector.getConnectorName(), connector);
                    }

                }
            }
        }
    }

    private Connector deserializeConnectorXML(String connectorFileName) {
        Connector connector = null;
        try {
            File artifactsFile = new File(connectorFileName);
            String artifactsContent = FileUtils.getContentAsString(artifactsFile);
            connector = new Connector();
            connector.deserialize(artifactsContent);

        } catch (Exception e) {
            log.error("Error while deserializing connector xml", e);
        }
        return connector;
    }

    private ConnectorExporter deserializeConnectorExporterXML(String connectorFileName) {
        ConnectorExporter connectorExporter = null;
        try {
            File artifactsFile = new File(connectorFileName);
            String artifactsContent = FileUtils.getContentAsString(artifactsFile);
            connectorExporter = new ConnectorExporter();
            connectorExporter.deserialize(artifactsContent);

        } catch (Exception e) {
            log.error("Error while deserializing connector exporter xml", e);
        }
        return connectorExporter;
    }

    public static IProject getProject(Object obj) {
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

    public void loadNewlyInstalledConnectors() {
        Map<String, Connector> newConnectors = new HashMap<String, Connector>();
        getConnectorsInWorkspace(newConnectors);
        for (String key : existingConnectors.keySet()) {
            if (newConnectors.containsKey(key)) {
                newConnectors.remove(key);
            }
        }

        // Entries
        for (Connector connector : newConnectors.values()) {

            Label separator = new Label(scContent, SWT.HORIZONTAL | SWT.SEPARATOR);
            GridData gd = new GridData(GridData.FILL_HORIZONTAL);
            gd.horizontalSpan = 4;
            separator.setLayoutData(gd);

            Label entryLabel = new Label(scContent, SWT.NONE);
            entryLabel.setText(connector.getConnectorName());

            Label hSeparator = new Label(scContent, SWT.VERTICAL | SWT.SEPARATOR);
            hSeparator.setLayoutData(new GridData(GridData.FILL_VERTICAL));

            compCombo = new Composite(scContent, SWT.NONE);
            compCombo.setLayout(new GridLayout(2, false));

            Combo combo = new Combo(compCombo, SWT.NONE);
            exporterCombos.add(combo);
            combo.setData(COMBO_CONNECTOR, connector);
            for (ConnectorExporter ce : allExporters.values()) {
                combo.add(ce.getConnectorExporterName());
            }
            Button removeButton = new Button(compCombo, SWT.PUSH);
            removeButton.setText("x");
            removeButton.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event e) {
                    // Remove combo box
                    exporterCombos.remove(combo);
                    combo.dispose();
                    removeButton.dispose();

                    // reset size of content so children can be seen
                    scContent.setSize(scContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                    scContent.layout();

                }
            });

            Button addButton = new Button(scContent, SWT.PUSH);
            addButton.setText("+");
            addButton.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event e) {
                    // Add new combo box
                    Combo combo = new Combo(compCombo, SWT.CHECK);
                    exporterCombos.add(combo);
                    combo.setData(COMBO_CONNECTOR, connector);
                    String[] a = new String[allExporters.size()];
                    String[] keys = allExporters.keySet().toArray(a);
                    combo.setItems(keys);
                    Button removeButton = new Button(compCombo, SWT.PUSH);
                    removeButton.setText("x");
                    removeButton.addListener(SWT.Selection, new Listener() {
                        public void handleEvent(Event e) {
                            // Remove combo box
                            exporterCombos.remove(combo);
                            combo.dispose();
                            removeButton.dispose();

                            // reset size of content so children can be seen
                            scContent.setSize(scContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                            scContent.layout();

                        }
                    });

                    // reset size of content so children can be seen
                    scContent.setSize(scContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                    scContent.layout();

                }
            });

            // reset size of content so children can be seen
            scContent.setSize(scContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
            scContent.layout();

            existingConnectors.put(connector.getConnectorName(), connector);

        }

        scContent.setSize(scContent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        scContent.layout();

    }

    protected void updateExporterCombos() {
        getConnectorExportersInProject(allExporters);
        String[] a = new String[allExporters.size()];
        String[] keys = allExporters.keySet().toArray(a);

        for (Combo combo : exporterCombos) {
            Object connector = combo.getData(COMBO_CONNECTOR);
            if (connector != null) {
                combo.setItems(keys);
                combo.layout();
            }
        }

    }

    public Map<Connector, List<ConnectorExporter>> getConnectorExporterMap() {
        Map<Connector, List<ConnectorExporter>> map = new HashMap<Connector, List<ConnectorExporter>>();
        for (Combo combo : exporterCombos) {
            Object connectorObj = combo.getData(COMBO_CONNECTOR);
            if (connectorObj != null) {
                Connector connector = (Connector) connectorObj;
                String exporter = combo.getText();
                if (!map.containsKey(connector)) {
                    map.put(connector, new ArrayList<ConnectorExporter>());
                }
                map.get(connector).add(allExporters.get(exporter));
            }
        }
        return map;
    }

    @Override
    public IWizardPage getNextPage() {
        return null;
    }

    public IProject getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(IProject selectedProject) {
        this.selectedProject = selectedProject;
    }
}
