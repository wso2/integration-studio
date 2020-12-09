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

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.esb.project.connector.store.Connector;
import org.wso2.developerstudio.eclipse.esb.project.servlets.FunctionServerConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ImportCloudConnectorWizardPage extends WizardPage {
    private Text txtConnectorStoreURL;
    private String cloudConnectorPath;
    private IProject selectedProject;
    private List<Connector> connectorList;
    private Table table;
    private Button connectorStore;
    private Button fileSystem;
    private static final String LOAD_CONNECTORS_PAGE = "http://localhost:"
            + FunctionServerConstants.EMBEDDED_SERVER_PORT + "/project/connectors/index.html?nocache=1";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static ImportCloudConnectorWizardPage wizard;

    protected ImportCloudConnectorWizardPage(IStructuredSelection selection) {
        super("import");
        setTitle("Import connector/module");
        setDescription("Import a connector/module from connector-module store or file system.");
        IProject project = getProject(selection);
        if (project != null) {
            setSelectedProject(project);
        }
        connectorList = new ArrayList<>();
        wizard = this;
    }

    @Override
    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NULL);
        setControl(container);
        container.setLayout(new FormLayout());
        FormData data;

        Browser browser = new Browser(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(0,2);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(96);
        data.bottom = new FormAttachment(100, -40);
        data.width = 600;
        data.height = 600;
        browser.setLayoutData(data);
        browser.setUrl(LOAD_CONNECTORS_PAGE);

        fileSystem = new Button(container, SWT.NONE);
        fileSystem.setText("Add from File System");
        data = new FormData();
        data.top = new FormAttachment(browser, 8);
        data.left = new FormAttachment(4);
        fileSystem.setLayoutData(data);
        fileSystem.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                ConnectorFromFileSystemDialog dialog = new ConnectorFromFileSystemDialog(
                        Display.getDefault().getActiveShell(), wizard);
                dialog.create();
                dialog.open();
            }
        });
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

    protected void addConnectorsToTable(int page, File iconCacheDir, IProgressMonitor monitor) {
        int workUnit = (1000 - (25 * page)) / connectorList.size();
        for (Connector connector : connectorList) {
            monitor.subTask("Fetching details of " + connector.getAttributes().getOverview_name() + " connector.");
            String imageLocation = null;
            TableItem item = new TableItem(table, SWT.NONE);
            imageLocation = txtConnectorStoreURL.getText() + connector.getAttributes().getImages_thumbnail();
            String[] segments = imageLocation.split("/");
            String imageFileName = segments[segments.length - 1];
            try {
                String imageFilePath = iconCacheDir + File.separator + imageFileName;
                File imageFile = new File(imageFilePath);
                if (!imageFile.exists()) {
                    // Download the thumbnail image if it is not there in the
                    // filesystem.
                    downloadThumbnailImage(imageLocation, imageFilePath);
                }
                Image image = new Image(Display.getDefault(), imageFilePath);
                Image scaled = new Image(Display.getDefault(), 55, 50);
                GC gc = new GC(scaled);
                gc.setAntialias(SWT.ON);
                gc.setInterpolation(SWT.HIGH);
                gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, 55, 50);
                gc.dispose();
                image.dispose();
                item.setImage(scaled);
            } catch (IOException e) {
                log.error("Error while downloading " + imageFileName, e);
            }
            item.setText(new String[] { connector.getAttributes().getOverview_name(),
                    connector.getAttributes().getOverview_version() });
            item.setData(connector);
            monitor.worked(workUnit);
        }
        monitor.done();
    }

    /*
     * Download the thumbnail image from the provided URL.
     */
    private void downloadThumbnailImage(String location, String file) throws IOException {
        URL url = new URL(location);
        InputStream in = new BufferedInputStream(url.openStream());
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));

        for (int i; (i = in.read()) != -1;) {
            out.write(i);
        }
        in.close();
        out.close();
    }

    @Override
    public IWizardPage getNextPage() {
        return null;
    }

    public String getCloudConnectorPath() {
        return cloudConnectorPath;
    }

    public void setCloudConnectorPath(String cloudConnectorPath) {
        this.cloudConnectorPath = cloudConnectorPath;
    }

    public IProject getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(IProject selectedProject) {
        this.selectedProject = selectedProject;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Button getConnectorStore() {
        return connectorStore;
    }

    public void setConnectorStore(Button connectorStore) {
        this.connectorStore = connectorStore;
    }

    public Button getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(Button fileSystem) {
        this.fileSystem = fileSystem;
    }

    public List<Connector> getConnectorList() {
        return connectorList;
    }

    public void setConnectorList(List<Connector> connectorList) {
        this.connectorList = connectorList;
    }
}
