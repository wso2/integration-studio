/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.util.AddNewFieldDialog;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.ElementEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class EditAttributeAction extends AbstractActionHandler {
	private EditPart selectedEP;
	private static final String OUTPUT_EDITPART = "Output"; //$NON-NLS-1$
	private static final String INPUT_EDITPART = "Input"; //$NON-NLS-1$
	private static final String RENAME_ACTION_ID = "rename-field-action-id"; //$NON-NLS-1$
	private static final String RENAME_FIELD = Messages.EditActions_editAttribute;

	private String name;
	private String schemaType;
	private String defaultValue;
	private String namespace;

	private static final String NAME = "name";
	private static final String DOC = "doc";
	private static final String DEFAULT_VALUE = "defaultValue";
	private static final String SCHEMATYPE = "schemaType";
	private static final String PREFIX = "attr_";

	public EditAttributeAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);

		setId(RENAME_ACTION_ID);
		setText(RENAME_FIELD);
		setToolTipText(RENAME_FIELD);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {

		selectedEP = getSelectedEditPart();

		if (null != selectedEP) {
			// Returns the TreeNodeImpl object respective to selectedEP
			EObject object = ((Node) selectedEP.getModel()).getElement();
			// Used to identify the selected resource of the model
			Element selectedElem = (Element) object;

			String value = null;
			name = selectedElem.getName();
			String newName = null;
			if (name.startsWith(PREFIX)) {
				String[] fullName = name.split(PREFIX);
				newName = fullName[1];
			} else {
				newName = name;
			}
			schemaType = selectedElem.getSchemaDataType().toString();
			namespace = selectedElem.getDoc();
			defaultValue = selectedElem.getDefault();
			if (StringUtils.isNotEmpty(defaultValue)) {
				value = defaultValue.replace("\"", "");
			}

			openEditFieldDialog(selectedElem,newName, schemaType, namespace, value);
		}
	}

	/**
	 * Reflects the changes in the tree view
	 * @param selectedElem
	 * @param map
	 */
	private void reflectChanges(Element selectedElem, HashMap<String, String> map) {
		executeCommand(selectedElem, DataMapperPackage.Literals.ELEMENT__NAME, map.get(NAME));

		if (StringUtils.isNotEmpty(map.get(NAME))) {
			// Sets the name with prefix in the tree view
			if (getSelectedEditPart() instanceof ElementEditPart) {
				((ElementEditPart) getSelectedEditPart()).renameElementItem(map.get(NAME));
			}
		}
		executeCommand(selectedElem, DataMapperPackage.Literals.ELEMENT__DOC, map.get(DOC));
		executeCommand(selectedElem, DataMapperPackage.Literals.ELEMENT__DEFAULT, map.get(DEFAULT_VALUE));
		SchemaDataType schmaType = getSchemaType(map.get(SCHEMATYPE));
		/**
		 * Serialize the schema type
		 */
		SetCommand renameComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedElem,
				DataMapperPackage.Literals.ELEMENT__SCHEMA_DATA_TYPE, schmaType);
		if (renameComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(renameComd);
		}
	}

	/**
	 * Gets the schema type
	 * 
	 * @param schema
	 * @return
	 */
	private SchemaDataType getSchemaType(String schema) {

		SchemaDataType type = null;
		if (StringUtils.isNotEmpty(schema)) {

			switch (schema) {
			case "STRING":
				type = SchemaDataType.STRING;
				break;
			case "INT":
				type = SchemaDataType.INT;
				break;
			case "ARRAY":
				type = SchemaDataType.ARRAY;
				break;
			case "BOOLEAN":
				type = SchemaDataType.BOOLEAN;
				break;
			case "BYTES":
				type = SchemaDataType.BYTES;
				break;
			case "DOUBLE":
				type = SchemaDataType.DOUBLE;
				break;
			case "ENUM":
				type = SchemaDataType.ENUM;
				break;
			case "FIXED":
				type = SchemaDataType.FIXED;
				break;
			case "FLOAT":
				type = SchemaDataType.FLOAT;
				break;
			case "LONG":
				type = SchemaDataType.LONG;
				break;
			case "MAP":
				type = SchemaDataType.MAP;
				break;
			case "RECORD":
				type = SchemaDataType.RECORD;
				break;
			case "UNION":
				type = SchemaDataType.UNION;
				break;
			case "NULL":
				type = SchemaDataType.NULL;
				break;
			default:
				break;
			}
		}
		return type;

	}

	/**
	 * Save edited values into the model
	 * 
	 * @param selectedElem
	 * @param feature
	 * @param value
	 */
	private void executeCommand(Element selectedElem, EStructuralFeature feature, String value) {
		SetCommand renameComd = new SetCommand(((GraphicalEditPart) selectedEP).getEditingDomain(), selectedElem,
				feature, value);
		if (renameComd.canExecute()) {
			((GraphicalEditPart) selectedEP).getEditingDomain().getCommandStack().execute(renameComd);
		}
	}

	/**
	 * Opens the dialog
	 * @param selectedElem 
	 * 
	 * @param editFieldDialog
	 * @param name
	 *            name
	 * @param prefix
	 *            prefix
	 * @param schemaType
	 *            schemaType
	 * @param namespace
	 *            namespace
	 * @param aliases
	 *            aliases
	 * @return map
	 */
	private void openEditFieldDialog(Element selectedElem, String name, String schemaType, String namespace,
			String defaultValue) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AddNewFieldDialog editFieldDialog = new AddNewFieldDialog(shell, new Class[] { IRegistryFile.class });

		editFieldDialog.create();
		editFieldDialog.setValues(name, schemaType, namespace, defaultValue);
		editFieldDialog.open();
		
		if(editFieldDialog.getOkValue()){
		HashMap<String, String> valueMap = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(editFieldDialog.getName())) {
			if (editFieldDialog.getName().startsWith(PREFIX)) {
				valueMap.put(NAME, editFieldDialog.getName());
			} else {
				valueMap.put(NAME, PREFIX + editFieldDialog.getName());
			}

		}
		valueMap.put(SCHEMATYPE, editFieldDialog.getSchemaType());
		valueMap.put(DOC, editFieldDialog.getDoc());
		if (editFieldDialog.getDefault() != null) {
			valueMap.put(DEFAULT_VALUE, editFieldDialog.getDefault().toString().replace("\"", ""));
		}
		
		reflectChanges(selectedElem, valueMap);
		}
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
