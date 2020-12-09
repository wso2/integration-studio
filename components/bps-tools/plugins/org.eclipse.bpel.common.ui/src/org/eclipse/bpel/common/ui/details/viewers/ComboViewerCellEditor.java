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
package org.eclipse.bpel.common.ui.details.viewers;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A ComboBoxCellEditor which is based on a CComboViewer rather than direct
 * interaction with the underlying CCombo.  This allows the use of content
 * and label providers, filters, etc. with ComboViewerCellEditor. 
 */
public class ComboViewerCellEditor extends ComboBoxCellEditor {
	
	CComboViewer viewer;

	public ComboViewerCellEditor() {
		super();
	}

	public ComboViewerCellEditor(Composite parent) {
		super(parent, new String[0]);
	}

	@Override
	protected Object doGetValue() {
		return ((IStructuredSelection)viewer.getSelection()).getFirstElement();
	}

	@Override
	protected void doSetValue(Object value) {
		viewer.refresh();
		String s = ((ILabelProvider)viewer.getLabelProvider()).getText(value);
		viewer.getCCombo().setText(s);
	}

	@Override
	protected Control createControl(Composite parent) {
		CCombo combo = (CCombo)super.createControl(parent);
		viewer = new CComboViewer(combo);
		return combo;
	}

	public CComboViewer getViewer() {
		return viewer;
	}

}
