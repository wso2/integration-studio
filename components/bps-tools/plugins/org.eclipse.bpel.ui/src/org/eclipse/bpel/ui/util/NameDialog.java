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

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Dialog for the New.. button which creates a variable of the right type.
 * We use a modal dialog to get the name for the new variable so that we
 * don't have to switch contexts in the editor.
 */
public class NameDialog extends InputDialog {

	/**
	 * 
	 * @param parent
	 * @param title
	 * @param message
	 * @param initialValue
	 * @param validator
	 */
	public NameDialog(Shell parent, String title, String message, String initialValue,
		IInputValidator validator)
	{
		super(parent, title, message, initialValue, validator);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Control result = super.createDialogArea(parent);
		getText().setFocus();
		applyDialogFont(result);
		return result;
	}
}
