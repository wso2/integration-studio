/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.tray;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.widgets.Text;


public class TrayCategoryEntryEditPartDirectEditManager extends DirectEditManager {

	public TrayCategoryEntryEditPartDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator) {
		super(source, editorType, locator);
	}

	@Override
	protected void initCellEditor() {
		Text text = (Text) getCellEditor().getControl();
		TrayEditPart part = (TrayEditPart) getEditPart();
		String initialLabelText = part.getDirectEditLabel().getText();
		getCellEditor().setValue(initialLabelText);
		text.selectAll();
	}
}
