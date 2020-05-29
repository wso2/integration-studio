/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * 
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeGroupValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;

public class ConnectionParameterRenderer {

	HashMap<String, Control> controlList;
	HashMap<String, Composite> compositeList;

	public ConnectionParameterRenderer() {
	}

	public HashMap<String, Control> generate(Composite parent, ConnectorRoot connectorRoot, Map<String, String> updateConfigMap) {
		parent.setBackgroundMode(SWT.INHERIT_FORCE);
		controlList = new HashMap<String, Control>();
		compositeList = new HashMap<String, Composite>();
		
		boolean isFirstTime = true;
		CTabFolder tabFolder = null;
		for (Element elem : connectorRoot.getElements()) {
			if (elem.getType().equals("attribute")) {
				evaluateAttribute((AttributeValue) elem.getValue(), parent);
			} else {
				if (isFirstTime) {
					Group tabSection = createGroup(parent, "");
					tabFolder = new CTabFolder(tabSection, SWT.NONE);
					GridData tableLayoutData = new GridData(GridData.FILL_HORIZONTAL);
					tabFolder.setLayoutData(tableLayoutData);
					tabFolder.setBackground(new Color (Display.getCurrent(), 255, 255, 255));
					isFirstTime = false;
				}
				AttributeGroupValue agv = (AttributeGroupValue) elem.getValue();
				CTabItem tabGeneralSection = new CTabItem(tabFolder, SWT.NULL);
				tabGeneralSection.setText(agv.getGroupName());
				
				Composite tabComposite = new Composite (tabFolder, SWT.NONE );
				GridLayout tabCompositeGroupLayout = new GridLayout();
				tabComposite.setLayout(tabCompositeGroupLayout);
				tabGeneralSection.setControl(tabComposite);
				for (Element ele : agv.getElements()) {
					recursive(ele, tabComposite);
				}
			}
		}
		tabFolder.setSelection(0);
		
		if (updateConfigMap != null && updateConfigMap.size() > 0) {
			for (Map.Entry<String, String> entry : updateConfigMap.entrySet()) {
				if (controlList.containsKey(entry.getKey())) {
					Control control = controlList.get(entry.getKey());
					if (control instanceof Text) {
						((Text) control).setText(entry.getValue()); 
					}
				}
			}
		}
		return controlList;
	}

	public void recursive(Element element, Composite parent) {
		if (element.getType().equals("attribute")) {
			evaluateAttribute((AttributeValue) element.getValue(), parent);
		} else {
			AttributeGroupValue agv = (AttributeGroupValue) element.getValue();
			// Is group Name connection special????
			Group subGroup = createGroup(parent, agv.getGroupName());
			for (Element elem : agv.getElements()) {
				recursive(elem, subGroup);
			}
		}
	}

	public void evaluateAttribute(AttributeValue value, Composite parent) {
		if (AttributeValueType.STRING.equals(value.getType())) {
			createTextBoxField(parent, value.getDisplayName() + ":", value.getName());
		} else if (AttributeValueType.VALUEOREXPRESSION.equals(value.getType())) {
			createTextBoxFieldWithButton(parent, value.getDisplayName() + ":", "FX", value.getName());
		} else if (AttributeValueType.COMBO.equals(value.getType())) {

		}
	}

	public Group createGroup(Composite parent, String label) {
		Group propertiesSection = new Group(parent, SWT.SHADOW_ETCHED_IN);
		propertiesSection.setBackgroundMode(SWT.INHERIT_FORCE);
		propertiesSection.setText(label);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 1;
		propertiesGroupLayout.marginLeft = 10;
		propertiesGroupLayout.marginRight = 10;
		propertiesGroupLayout.horizontalSpacing = 20;
		propertiesGroupLayout.verticalSpacing = 10;
		propertiesSection.setLayout(propertiesGroupLayout);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 2;
		propertiesSection.setLayoutData(propertiesSectionData);
		return propertiesSection;
	}

	private Composite createTextBoxField(Composite parent, String Label, String id) {
		Composite textBoxComposite = createComposite(id, parent, 2, 2);
		Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
		label.setText(Label);
		GridData labelRefData = new GridData();
		labelRefData.widthHint = 120;
		label.setLayoutData(labelRefData);
		setToolTip(label, "This is a generic Tool tip Message of new properties renderer");
		Text configRef = new Text(textBoxComposite, SWT.BORDER);
		controlList.put(id, configRef);
		configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
		configRef.setLayoutData(configRefData);

		configRef.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				// if (e.character == SWT.CR) {
				// ((CallTemplateParameter)configRef.getData()).setParameterValue(configRef.getText());
				// CallTemplateParameter ctp = (CallTemplateParameter)configRef.getData();
				// setParameterType(RuleOptionType.VALUE, ctp);
				// }
			}
		});
		return parent;
	}

	private Composite createTextBoxFieldWithButton(final Composite parent, String Label,
			String buttonText, String id) {
		Composite textBoxComposite = createComposite(id, parent, 3, 3);
		Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
		label.setText(Label);
		GridData labelRefData = new GridData();
		labelRefData.widthHint = 120;
		label.setLayoutData(labelRefData);
		// label.setToolTipText(Label);
		setToolTip(label, "This is a generic Tool tip Message of new properties renderer");
		final Text configRef = new Text(textBoxComposite, SWT.NONE);
		configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		controlList.put(id, configRef);
		GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
		Button configButton = new Button(textBoxComposite, SWT.PUSH);
		configButton.setText(buttonText);
		configRef.setLayoutData(configRefData);
		configButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				CallTemplateParameter ctp = (CallTemplateParameter) configRef.getData();
				setParameterType(RuleOptionType.EXPRESSION, ctp);
				openValueExpressionWidgetNamespacedPropertyEditor(parent, configRef, ctp.getParameterExpression());
			}
		});
		configRef.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				// if (e.character == SWT.CR) {
				// ((CallTemplateParameter)configRef.getData()).setParameterValue(configRef.getText());
				// CallTemplateParameter ctp = (CallTemplateParameter)configRef.getData();
				// ctp.setParameterValue(configRef.getText());
				// setParameterType(RuleOptionType.VALUE, ctp);
				// }
			}
		});
		return parent;
	}

	private Composite createDropDownField(Composite parent, String Label, String[] options,
			String id) {
		Composite textBoxComposite = createComposite(id, parent, 2, 2);
		Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
		label.setText(Label);
		GridData labelRefData = new GridData();
		labelRefData.widthHint = 120;
		label.setLayoutData(labelRefData);
		Combo configRef = new Combo(textBoxComposite, SWT.READ_ONLY | SWT.DROP_DOWN);
		controlList.put(id, configRef);
		configRef.setItems(options);
		configRef.select(0);
		GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
		configRef.setLayoutData(configRefData);
		return parent;
	}

	private Composite createCheckBoxField(FormToolkit widgetFactory, Composite parent, String Label, String[] options,
			String id) {
		Composite textBoxComposite = createComposite(id, parent, options.length + 1, options.length + 1);
		Label label = new Label(textBoxComposite, SWT.NO_BACKGROUND);
		label.setText(Label);
		GridData configRefDatass = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(configRefDatass);
		for (String option : options) {
			Button configRef = widgetFactory.createButton(textBoxComposite, option, SWT.CHECK);
			configRef.setText(option);
			// configRef.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
			GridData configRefData = new GridData(GridData.FILL_HORIZONTAL);
			configRef.setLayoutData(configRefData);
		}
		return parent;
	}

	private Composite createComposite(FormToolkit widgetFactory, Composite parent) {
		Composite composite = widgetFactory.createComposite(parent);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 2;
		propertiesGroupLayout.marginLeft = 15;
		propertiesGroupLayout.horizontalSpacing = 20;
		propertiesGroupLayout.verticalSpacing = 10;
		composite.setLayout(propertiesGroupLayout);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 2;
		composite.setLayoutData(propertiesSectionData);
		return composite;

	}

	private Composite createComposite(String id, Composite parent, int columns, int span) {
		Composite composite = new Composite(parent, SWT.NO_BACKGROUND);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = columns;
		propertiesGroupLayout.marginLeft = 0;
		propertiesGroupLayout.horizontalSpacing = 20;
		propertiesGroupLayout.verticalSpacing = 10;
		composite.setLayout(propertiesGroupLayout);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = span;
		composite.setLayoutData(propertiesSectionData);
		compositeList.put(id, composite);
		return composite;

	}

	public void validate() {
		// Implement enableCondition Logic Here
	}

	private void openValueExpressionWidgetNamespacedPropertyEditor(final Composite parent, Text valueExpressionText,
			NamespacedProperty valueExpression) {
		if (valueExpression == null) {
			valueExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
			((CallTemplateParameter) valueExpressionText.getData()).setParameterExpression(valueExpression);
		}
		EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL,
				valueExpression);
		valueExpression = nspd.open();
		valueExpressionText.setText(valueExpression.getPropertyValue());
	}

	private void setParameterType(RuleOptionType ruleType, CallTemplateParameter ctp) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(ctp);
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				ctp.setTemplateParameterType(ruleType);
			}
		});
	}

	public void setToolTip(Control control, String text) {
		final ToolTip tip = new ToolTip(control.getShell(), SWT.BALLOON);
		tip.setMessage(text);
		tip.setAutoHide(true);
		control.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				Control actionWidget = (Control) e.widget;
				Point loc = actionWidget.toDisplay(actionWidget.getLocation());
				tip.setLocation(loc.x + actionWidget.getSize().x - actionWidget.getBorderWidth(), loc.y);
				tip.setVisible(true);
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
