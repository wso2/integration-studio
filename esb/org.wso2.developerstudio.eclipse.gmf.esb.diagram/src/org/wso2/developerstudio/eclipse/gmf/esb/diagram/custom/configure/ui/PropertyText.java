/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamedEntityDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;

/**
 * Custom SWT control to be used for editing namespaced properties, registryKey
 * properties evaluator expressions.
 * 
 */
public class PropertyText extends Composite {
	private Text textControl;
	private Button actionButton;
	private Combo bindControl=null;
	private boolean bind=false;
	private boolean editable=false;
	private boolean forcefullInlineEditing=false;
	private Object property;
	private Map<Integer,Object> properties;
	
	private GridData gridDataTextControl;
	private GridData gridDataActionButton;
	private List<ModifyListener> modifyListeners;
	
	/**
	 * @param parent
	 * @param style
	 */
	public PropertyText(Composite parent, int style) {
		super(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginLeft=2;
		gridLayout.marginTop=0;
		gridLayout.marginBottom=0;
		gridLayout.marginRight=0;
		gridLayout.marginWidth=0;
		gridLayout.marginHeight=0;
		setLayout(gridLayout);
		
		properties = new HashMap<Integer, Object>();
		modifyListeners = new ArrayList<ModifyListener>();
		textControl = new Text(this,style);
		gridDataTextControl = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gridDataTextControl.heightHint = 22;
		textControl.setLayoutData(gridDataTextControl);
		textControl.setEditable(editable);
		textControl.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				if(editable){
					int index = 0;
					if (bind) {
						index = PropertyText.this.bindControl.getSelectionIndex();
						if (index == -1) {
							index = 0;
						}
					}
					Object object = properties.get(index);
					if(object instanceof String){
						properties.put(index, textControl.getText());
						setProperty(textControl.getText());
					}
				}
				for(ModifyListener modifyListener : modifyListeners){
					modifyListener.modifyText(e);
				}
			}
		});
		
		actionButton = new Button(this, SWT.NONE);
		gridDataActionButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gridDataActionButton.exclude=true;
		gridDataActionButton.heightHint = 22;
		actionButton.setLayoutData(gridDataActionButton);
		actionButton.setText("..");
		actionButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bind) {
					int index = bindControl.getSelectionIndex();
					if(index!=-1){
						openPropertyDialog(index);
					}
				} else {
					openPropertyDialog(0);
				}
			}
		});
		
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				PropertyText.this.widgetDisposed(e);
			}
		});
		
		addControlListener(new ControlAdapter() {
	         public void controlResized(ControlEvent e) {
	        	 PropertyText.this.controlResized(e);
	         }
	     });

	}
	
	/**
	 * 
	 * @param parent
	 * @param style
	 * @param bindControl
	 */
	public PropertyText(Composite parent, int style,Combo bindControl) {
		this(parent,style);
		this.bindControl = bindControl;
		bind=true;
		this.bindControl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = PropertyText.this.bindControl.getSelectionIndex();
					int sel = PropertyText.this.bindControl.getSelectionIndex();
					if (sel != -1) {
						index = sel;
					}
				refresh(index);
			}
		});
	}

	protected void widgetDisposed(DisposeEvent e) {
		this.getParent().layout();
	}

	protected void controlResized(ControlEvent e) {
		layout();
	}
	
	public void addModifyListener(ModifyListener modifyListener){
		modifyListeners.add(modifyListener);
	}
	
	public void removeModifyListener(ModifyListener modifyListener){
		textControl.removeModifyListener(modifyListener);
	}
	
	public void setText(String text){
		if(text!=null){
			textControl.setText(text);
		}
	}
	
	public String getText(){
		return textControl.getText();
	}

	public Object getProperty() {
		return property;
	}
	
	public Object getProperty(int index) {
		return properties.get(index);
	}
	
	private void setProperty(Object property){
		this.property = property;
	}
	
	public void addProperties(Object... properties ) {
		for (Object object : properties) {
			int index = this.properties.size();
			this.properties.put(index,object);
		}
		int index = 0; 
		if (bind) {
			int sel = PropertyText.this.bindControl.getSelectionIndex();
			if (sel != -1) {
				index = sel;
			}
		}
		refresh(index);
		
	}
	
	private void setInlineEditing(boolean enable){
		if (forcefullInlineEditing){
			editable=true;
			gridDataActionButton.exclude=true;
		} else {
			editable=enable;
			gridDataActionButton.exclude=enable;
		}
		textControl.setEditable(editable);
	}
	
	public void setForcefullInlineEditing(boolean enable){
		forcefullInlineEditing=enable;
		setInlineEditing(enable);
		layout();
	}
	
	public void refresh(int index){
		
		Object object = this.properties.get(index);
		if (object instanceof NamespacedProperty){
			setText(((NamespacedProperty)object).getPropertyValue());
			setInlineEditing(false);
		} else if (object instanceof RegistryKeyProperty){
			textControl.setText(((RegistryKeyProperty)object).getKeyValue());
			setInlineEditing(false);
		} else if (object instanceof EvaluatorExpressionProperty){
			setText(((EvaluatorExpressionProperty)object).getEvaluatorValue());
			setInlineEditing(false);
		}else{
			setText(object.toString());
			setInlineEditing(true);
		}
		setProperty(object);
		layout();
	}
	
	private void openPropertyDialog(int index) {
		Object object = properties.get(index);
		if (object instanceof NamespacedProperty) {
			NamespacedProperty namespacedProperty = EsbFactory.eINSTANCE
					.copyNamespacedProperty((NamespacedProperty) object);
			NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(getShell(),
					namespacedProperty);
			dialog.open();
			if (dialog.isSaved()) {
				properties.put(index, namespacedProperty);
				setProperty(namespacedProperty);
				setText(namespacedProperty.getPropertyValue());
			}
		} else if (object instanceof RegistryKeyProperty) {
			RegistryKeyProperty registryKeyProperty = EsbFactory.eINSTANCE
					.copyRegistryKeyProperty((RegistryKeyProperty) object);
			RegistryKeyPropertyEditorDialog dialog = new RegistryKeyPropertyEditorDialog(
					getShell(), SWT.TITLE, registryKeyProperty,
					new ArrayList<NamedEntityDescriptor>());
			dialog.create();
			dialog.getShell().setSize(520, 180);
			dialog.getShell().setText("Resource Key Editor");
			dialog.open();
			if (dialog.getReturnCode() == Window.OK) {
				properties.put(index, registryKeyProperty);
				setProperty(registryKeyProperty);
				setText(registryKeyProperty.getKeyValue());
			}
		} else if (object instanceof EvaluatorExpressionProperty) {
			EvaluatorExpressionProperty expression = EsbFactory.eINSTANCE
					.copyEvaluatorExpressionProperty((EvaluatorExpressionProperty) object);
			EvaluatorExpressionEditorDialog dialog = new EvaluatorExpressionEditorDialog(
					getShell(), expression);
			dialog.create();
			dialog.getShell().setText("Evaluator Expression Editor");
			dialog.open();
			if (dialog.getReturnCode() == Window.OK) {
				properties.put(index, expression);
				setProperty(expression);
				setText(expression.getEvaluatorValue());
			}
		}
	}

}
