/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.dialog;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.PropertyData;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class PropertyDialog extends Dialog {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtPropertyName;
	private Text txtPropertyValue;
	private Combo cmbType;
	private Label lblmsg; 
	private String propertyName;
	private PropertyData propertyData;
	private List<String> items;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public PropertyDialog(Shell parentShell,List<String> items) {
		super(parentShell);
		this.items = items;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	
	protected Control createDialogArea(Composite parent) {
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(1, false));
		//parent.getShell().setText("New Property");
		
		Listener listener = new Listener() {
			
			public void handleEvent(Event evt) {
				String name = txtPropertyName.getText();
				String value = txtPropertyValue.getText();
				if(null==name || name.trim().equals("")){
					showError("The property name cannot be empty");
				} else if(null==value || value.trim().equals("")){
					showError("The property value cannot be empty");
				} 
				else {
					if(items.contains(name)){
						showError("The property name must be unique");
					} else{
						if("XML".equals(cmbType.getText())){
							if(validateXML(value)){
								hideError();
							} else showError("Property value should be well formatted XML string for Type XML");
						} else{
							hideError();
						}
					}
					 
				}
			}
		};
		
		Section sctnSection = formToolkit.createSection(composite, Section.TITLE_BAR);
		GridData gd_sctnSection = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_sctnSection.widthHint = 385;
		gd_sctnSection.heightHint = 160;
		sctnSection.setLayoutData(gd_sctnSection);
		formToolkit.paintBordersFor(sctnSection);
		sctnSection.setText("New Property");
		
		Composite window = formToolkit.createComposite(sctnSection, SWT.NONE);
		formToolkit.paintBordersFor(window);
		sctnSection.setClient(window);
		window.setLayout(new GridLayout(2, false));
		
		Label lblPropertyName = formToolkit.createLabel(window, "Property Name", SWT.NONE);
		
		txtPropertyName = formToolkit.createText(window, "", SWT.BORDER);
		GridData gd_txtPropertyName = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtPropertyName.widthHint = 245;
		txtPropertyName.setLayoutData(gd_txtPropertyName);
		txtPropertyName.addListener(SWT.CHANGED,listener);
		
		Label lblPropertyValue = formToolkit.createLabel(window, "Property Value", SWT.NONE);
		
		txtPropertyValue = formToolkit.createText(window, "", SWT.BORDER);
		GridData gd_txtPropertyValue = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtPropertyValue.widthHint = 245;
		txtPropertyValue.setLayoutData(gd_txtPropertyValue);
		txtPropertyValue.addListener(SWT.CHANGED,listener);
		
		Label lblType = formToolkit.createLabel(window, "Type", SWT.NONE);
		
		cmbType = new Combo(window, SWT.NONE|SWT.READ_ONLY);
		cmbType.setItems(new String[] {"STRING", "XML"});
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_combo.widthHint = 150;
		cmbType.setLayoutData(gd_combo);
		cmbType.select(0);
		cmbType.addListener(SWT.Selection, listener);
		formToolkit.adapt(cmbType);
		formToolkit.paintBordersFor(cmbType);
		
		lblmsg = formToolkit.createLabel(window, "", SWT.NONE);
		lblmsg.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblmsg.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		ControlDecoration controlDecoration = new ControlDecoration(lblmsg, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Some description");
		window.pack();
		
		sctnSection.setEnabled(true);

		return window;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		getButton(IDialogConstants.OK_ID).setEnabled(false); 
	}
	
	
	protected void okPressed() {
		String name = txtPropertyName.getText();
		String value = txtPropertyValue.getText();
		DataType type = "XML".equals(cmbType.getText())? DataType.XML : DataType.STRING;
		propertyData = new PropertyData(type, value);
		setPropertyData(propertyData);
		setPropertyName(name);
	    super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	
	protected Point getInitialSize() {
		return new Point(400, 250);
	}
	
	private boolean validateXML(String xmlString){
		try{
			OMElement root = OMAbstractFactory.getOMFactory().createOMElement(new QName("root"));
			OMElement element = AXIOMUtil.stringToOM(xmlString);
			root.addChild(element);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	private void showError(String msg){
		lblmsg.setText(msg);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
	}
	
	private void hideError(){
		lblmsg.setText("");
		getButton(IDialogConstants.OK_ID).setEnabled(true);
	}
	

	public String getPropertyName() {
	    return propertyName;
    }
	
	public void setPropertyName(String name) {
	    this.propertyName = name;
    }

	public void setPropertyData(PropertyData propertyData) {
	    this.propertyData = propertyData;
    }

	public PropertyData getPropertyData() {
	    return propertyData;
    }

}
