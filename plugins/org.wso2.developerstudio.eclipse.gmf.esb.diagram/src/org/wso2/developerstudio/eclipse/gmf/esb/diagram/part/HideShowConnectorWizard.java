/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

public class HideShowConnectorWizard extends AbstractWSO2ProjectCreationWizard {

	private HideConnectorWizardPage hideWizardPage;
	private static final String DIR_DOT_METADATA = ".metadata";
	public static final String connectorPathFromWorkspace = DIR_DOT_METADATA + File.separator + ".Connectors";

	public HideShowConnectorWizard() throws Exception {
		super();
		hideWizardPage = new HideConnectorWizardPage(true);
		init();
	}

	public void init() {
		hideWizardPage = new HideConnectorWizardPage(true);
		setWindowTitle("Show or Hide Connectors/Modules from Palette");
	}

	@Override
	public void addPages() {
		addPage(hideWizardPage);
	}

	public boolean performFinish() {
		String connectorPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator
				+ connectorPathFromWorkspace;
		Boolean exist = Files.exists(Paths.get(connectorPath + File.separator + "checkedConnectors.txt"),
				LinkOption.NOFOLLOW_LINKS);
		FileWriter fileWriter = null;

		if (!exist) {
			try {
				Files.createFile(Paths.get(connectorPath + File.separator + "checkedConnectors.txt"));
			} catch (IOException e) {
				MessageDialog.openError(getShell(), "Error while creating file ", e.getMessage());
			}
		}

		try {
			fileWriter = new FileWriter(connectorPath + File.separator + "checkedConnectors.txt");
		} catch (IOException e) {
			MessageDialog.openError(getShell(), "Error while creating file ", e.getMessage());
		}

		List<String> checkedList = new ArrayList();
		for (TableItem tableItem : hideWizardPage.getTable().getItems()) {
			if ((tableItem.getChecked())) {
				checkedList.add((String) tableItem.getData());
				updateConnectorVisibility((String) tableItem.getData(), true);
			} else if (!(tableItem.getChecked())) {
				checkedList.remove((String) tableItem.getData());
				updateConnectorVisibility((String) tableItem.getData(), false);
			}
		}

		for (String checked : checkedList) {
			try {
				fileWriter.write(checked + ", ");
			} catch (IOException e) {
				MessageDialog.openError(getShell(), "Error while writing to file ", e.getMessage());
			}
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			MessageDialog.openError(getShell(), "Error while closing file ", e.getMessage());
		}
		return true;
	}

	/**
	 * Change the visibility of Connectors in palette based on the checked box
	 * 
	 * @param paletteContainer
	 * @param visible
	 */
	private void updateConnectorVisibility(String connectorName, boolean visible) {
		EsbMultiPageEditor esbMultiPageEditor = (EsbMultiPageEditor) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		esbMultiPageEditor.getDiagramEditDomain();
		PaletteViewer paletteViewer = ((DiagramEditDomain) esbMultiPageEditor.getDiagramEditDomain())
				.getPaletteViewer();
		List children = paletteViewer.getPaletteRoot().getChildren();
		for (Object child : children) {
			if (((PaletteContainer) child).getId().contains("CloudConnector")) {
				String connectorId = ((PaletteContainer) child).getId().replaceAll("CloudConnector-", "");
				connectorId = connectorId.substring(0, 1).toUpperCase() + connectorId.substring(1) + " Connector";
				if (connectorId.equals(connectorName)) {
					((PaletteContainer) child).setVisible(visible);
				}
			}

		}
	}

	@Override
	public IResource getCreatedResource() {
		return null;
	}

	public HideConnectorWizardPage getHideWizardPage() {
		return hideWizardPage;
	}

	public void setHideWizardPage(HideConnectorWizardPage hideWizardPage) {
		this.hideWizardPage = hideWizardPage;
	}

}