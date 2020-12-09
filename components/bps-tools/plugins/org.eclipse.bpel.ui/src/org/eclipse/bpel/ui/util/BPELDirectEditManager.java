/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

/**
 * Adds an input validator to the direct edit manager.
 */
public class BPELDirectEditManager extends DirectEditManager {

	/** Validates user input. Provided by ctor. */
	private IInputValidator validator;

	public BPELDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator, IInputValidator validator) {
		super(source, editorType, locator);
		this.validator = validator;
	}

	@Override
	protected void commit() {
		if (validator != null) {
			Text text = (Text) getCellEditor().getControl();
			String newValue = text.getText();
			String validationMessage = validator.isValid(newValue);
			if (validationMessage != null) {
				MessageBox dialog = new MessageBox(text.getShell(), SWT.ICON_ERROR | SWT.OK);
				String message = Messages.BPELEditManager_RenameError; 
				dialog.setText(message);
				message = NLS.bind(Messages.BPELEditManager_RenameErrorMessage, (new Object[] {message, validationMessage})); 
				dialog.setMessage(message);
				dialog.open();
				bringDown();
				return;
			}
		}
		super.commit();
	}

	@Override
	protected void initCellEditor() {
		getEditPart().getFigure().validate();
		Object model = getEditPart().getModel();
		ILabeledElement labeledElement = BPELUtil.adapt(model, ILabeledElement.class);
		String initialLabelText = labeledElement.getLabel(model);
		getCellEditor().setValue(initialLabelText);
		Text text = (Text) getCellEditor().getControl();
		text.selectAll();
	}
}
