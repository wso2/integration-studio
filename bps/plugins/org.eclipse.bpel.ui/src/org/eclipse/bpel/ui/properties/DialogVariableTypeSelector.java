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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.details.IDetailsAreaConstants;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


public class DialogVariableTypeSelector extends VariableTypeSelector {
	public DialogVariableTypeSelector(Composite parent, int style, BPELEditor bpelEditor,
			Shell shell, Callback callback, TabbedPropertySheetWidgetFactory wf) {
		// https://issues.jboss.org/browse/JBIDE-8045
		super(parent, style, bpelEditor, wf, callback);
		this.shell = shell;
	}
	
	@Override
	protected Button createButton(Composite parent, String text, int style) {
		Button button = new Button(parent, style);
		button.setText(text);
		return button;
	}	
	@Override
	protected Composite createComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		return composite;
	}
	@Override
	protected Label createLabel(Composite parent, String text) {
		Label label = new Label(parent, SWT.NULL);
		label.setText(text);
		return label;
	}	
	@Override
	protected Hyperlink createHyperlink(Composite parent, String text, int style) {
		Hyperlink hyperlink = new Hyperlink(parent, style);
		if (text != null)
			hyperlink.setText(text);
		return hyperlink;
	}	
	@Override
	protected CCombo createCCombo(Composite parent) {
		CCombo ccombo = new CCombo(parent, SWT.READ_ONLY|SWT.BORDER);
		ccombo.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		return ccombo;
	}	
	
	@Override
	protected void updateCompositeSelection() {
		interfaceComposite.setVisible(true);
		dataTypeComposite.setVisible(false);
		doChildLayout();
	}
	
	@Override
	protected void createRadioButtonWidgets(Composite composite) {
		// Don't do anything
	}
	
	@Override
	protected void internalSetLayoutData() {
		// TODO: Some of this is redundant.
		FlatFormData data = new FlatFormData();
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(interfaceViewer.getControl(), -1, SWT.TOP);
		data.bottom = new FlatFormAttachment(interfaceViewer.getControl(), +1, SWT.BOTTOM);
		interfaceBrowseButton.setLayoutData(data);	
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(0, 2);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(interfaceLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(interfaceBrowseButton, -IDetailsAreaConstants.HSPACE);
		interfaceViewer.getControl().setLayoutData(data);
		
		data = new FlatFormData();
		data.top = new FlatFormAttachment(interfaceViewer.getControl(), IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(operationLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(interfaceBrowseButton, -IDetailsAreaConstants.HSPACE);
		operationViewer.getControl().setLayoutData(data);		
	
		data = new FlatFormData();
		data.top = new FlatFormAttachment(operationFaultRadio, IDetailsAreaConstants.VSPACE);
		data.left = new FlatFormAttachment(0, BPELUtil.calculateLabelWidth(faultLabel, STANDARD_LABEL_WIDTH_SM));
		data.right = new FlatFormAttachment(interfaceBrowseButton, -IDetailsAreaConstants.HSPACE);
		faultViewer.getCCombo().setLayoutData(data);
	}
}
