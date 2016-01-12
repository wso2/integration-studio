/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.custom.action;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.datamapper.diagram.Activator;

import org.wso2.developerstudio.datamapper.diagram.custom.persistence.JsonToAvroSchemaTransformer;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;

public class SchemaFromJsonAction extends AbstractActionHandler {

	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String SCHEMA_FROM_JSON_ACTION_ID = "schema-from-json-action-id"; //$NON-NLS-1$
	private static final String FILTER_EXTENSION_TXT = "*.txt"; //$NON-NLS-1$
	private static final String FILTER_EXTENSION_JSON = "*.json"; //$NON-NLS-1$
	private static final String SAMPLE_JSON_FILE = Messages.SchemaFromJsonAction_sampleJsonFile;
	private static final String ERROR_READING_JSON_FROM_FILE = Messages.SchemaFromJsonAction_errorReadingJsonFromFile;
	private static final String MENU_TITLE = Messages.SchemaFromJsonAction_menuTitle;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public SchemaFromJsonAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(SCHEMA_FROM_JSON_ACTION_ID);
		setText(MENU_TITLE);
		setToolTipText(MENU_TITLE);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		selectedEP = getSelectedEditPart();
		// Read json from file
		String jsonInput = openFileBrowser();
		Schema schema;

		if (null != jsonInput) {
			// FIXME handle !jsonInput.isEmpty() after considering
			// transformation of empty string

			// Get the respective avro schema
			JsonToAvroSchemaTransformer transformer = new JsonToAvroSchemaTransformer();
			schema = transformer.transform(jsonInput);
		} else {
			// can be null when fails to read from file
			return;
		}

		// selectedEP can be null when wrong editpart is selected
		// schema can be null when parsing fails
		if (null != selectedEP && null != schema) {
			String selectedInputOutputEditPart = getSelectedInputOutputEditPart();
			if (INPUT_EDITPART.equals(selectedInputOutputEditPart)) {
				InputEditPart iep = (InputEditPart) selectedEP;
				iep.resetInputTreeFromSchema(schema);
			} else {
				OutputEditPart oep = (OutputEditPart) selectedEP;
				oep.resetOutputTreeFromSchema(schema);
			}
		}
	}

	/**
	 * Filters only json and txt files
	 */
	private String openFileBrowser() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		FileDialog fid = new FileDialog(shell);
		fid.setFilterExtensions(new String[] { FILTER_EXTENSION_JSON, FILTER_EXTENSION_TXT });
		fid.setText(SAMPLE_JSON_FILE);
		String filePath = fid.open();

		try {
			return FileUtils.readFileToString(new File(filePath));
		} catch (IOException e) {
			log.error(ERROR_READING_JSON_FROM_FILE, e);
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
			ErrorDialog.openError(Display.getCurrent().getActiveShell(),
					ERROR_READING_JSON_FROM_FILE, null, status);
		}
		return null;
	}

	private String getSelectedInputOutputEditPart() {
		EditPart tempEP = selectedEP;
		while (!(tempEP instanceof InputEditPart) && !(tempEP instanceof OutputEditPart)) {
			tempEP = tempEP.getParent();
		}

		if (tempEP instanceof InputEditPart) {
			return INPUT_EDITPART;
		} else if (tempEP instanceof OutputEditPart) {
			return OUTPUT_EDITPART;
		} else {
			// When the selected editpart is not InputEditPart or OutputEditPart
			return null;
		}
	}

	private EditPart getSelectedEditPart() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedEP = selection.getFirstElement();
			if (selectedEP instanceof EditPart) {
				return (EditPart) selectedEP;
			}
		}
		// In case of selecting the wrong editpart
		return null;
	}

	@Override
	public void refresh() {
		// refresh action. Does not do anything
	}
}
