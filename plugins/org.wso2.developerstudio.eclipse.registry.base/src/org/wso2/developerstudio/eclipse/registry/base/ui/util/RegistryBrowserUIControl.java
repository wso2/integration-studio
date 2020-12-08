/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.base.ui.util;

import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IFieldControlData;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.IOnAction;
import org.wso2.developerstudio.eclipse.platform.ui.interfaces.UIControl;
import org.wso2.developerstudio.eclipse.platform.ui.utils.WSO2UIToolkit;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.RegistryTreeBrowserDialog;


public class RegistryBrowserUIControl implements UIControl {

	
	private static RegistryResourceNode selectedRegistryResourceNode = null;
	Label regLabel; 
	Button btnRegBrowse; 
	private String[] pathList = new String[]{
			"/",
			"/_system/local",
			"/_system/config",
			"/_system/governance"
	};
	
	public IFieldControlData createUIField(String id, Composite container, int columns,
			Integer verticalIndent, Integer horizontalIndent,
			boolean isTextReadonly,
			final Shell shell,
			final String label, 
			String fileButtonCaption,
			int selectedOption,
			ProjectDataModel model,
			String pathBindingProperty) {
		if (id.equals("registry.browser")){
			regLabel = new Label(container, SWT.None);
			regLabel.setText(label);
			GridData gridData = new GridData();
			if (verticalIndent != null) {
				gridData.verticalIndent = verticalIndent;
			}
			if (horizontalIndent != null) {
				gridData.horizontalIndent = horizontalIndent;
			}
			regLabel.setLayoutData(gridData);
			
			final Text txtValue = new Text(container, SWT.BORDER);
			txtValue.setEditable(!isTextReadonly);
			if (columns != -1) {
				gridData = new GridData();
				gridData.horizontalSpan = columns - 3;
				gridData.grabExcessHorizontalSpace = true;
				gridData.horizontalAlignment = SWT.FILL;
				txtValue.setLayoutData(gridData);
			}
			
			IFieldControlData regControlData =
		        addRegistryBrowseButton(container, shell, label, fileButtonCaption, txtValue,selectedOption,model,pathBindingProperty);
			return regControlData;
		}
		return null;
	}
	
	public IFieldControlData addRegistryBrowseButton(Composite container,
			final Shell shell, String label, String buttonCaption, final Text txtValue,
			final int selectedOption,
			final ProjectDataModel model,
			final String pathBindingProperty) {
		IFieldControlData regFiledControlData =null;

		if(txtValue.getEditable()){
			regFiledControlData = new RegistryTextFieldControlData(txtValue);
		} else{
			regFiledControlData = new RegistryFieldControlData(txtValue);
		}
		
		btnRegBrowse = new Button(container, SWT.None);
		btnRegBrowse.setText(buttonCaption);
		btnRegBrowse.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent event) {
				boolean returnAsString = false;
				int pathID=0;
				try {
					pathID = Integer.parseInt(model.getModelPropertyValue(pathBindingProperty).toString());
					if(pathID<0 || pathID>3){
						pathID=0;
					} else if(pathID>=1 || pathID<=3){
						returnAsString=true;
					}
				} catch (Exception e) {
				/* ignore*/
				}
				
				RegistryTreeBrowserDialog r = new RegistryTreeBrowserDialog(shell,selectedOption,pathID);
				r.create();
				List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore.getInstance().getAllRegistryUrls();
				for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
					registryURLInfo.setPath(pathList[pathID]);
					r.addRegistryNode(registryURLInfo, null);
				}
				if(r.open() == Window.OK){
					if(r.getViewer()!=null){
						switch (selectedOption & r.getViewer().getSelectionState()) {
							case RegistryTreeBrowserDialog.SELECT_REGISTRY_PATH:
								selectedRegistryResourceNode = r.getSelectedRegistryResourceNode();
								break;
							case RegistryTreeBrowserDialog.SELECT_REGISTRY_RESOURCE:
							default:
								selectedRegistryResourceNode = r.getSelectedRegistryResourceNodeResource();
								break;
						}
						if(selectedRegistryResourceNode!=null){
							if(returnAsString){
								String ResourcePath = selectedRegistryResourceNode.getRegistryResourcePath();
								if (ResourcePath.startsWith("/_system/config")) {
									ResourcePath = ResourcePath.replaceFirst("/_system/config","conf:");
								} else if (ResourcePath.startsWith("/_system/governance")) {
									ResourcePath = ResourcePath.replaceFirst(
									"/_system/governance", "gov:");
								} else {
									ResourcePath = ResourcePath.replaceFirst(
											"/_system/local", "local:");
								}
								txtValue.setData(ResourcePath);
								txtValue.setText(ResourcePath);
							} else{
								txtValue.setData(selectedRegistryResourceNode);
								txtValue.setText(selectedRegistryResourceNode.getRegistryResourcePath());
							}
						}	
					}
				}
			}

			
			public void widgetSelected(SelectionEvent event) {
				widgetDefaultSelected(event);
			}
		});
	//	regFiledControlData = new RegistryFieldControlData(txtValue);
//		regFiledControlData.setSelectedRegistryNode(selectedRegistryResourceNode);
		WSO2UIToolkit.propagateControlStatus(txtValue,regLabel,btnRegBrowse);
		return regFiledControlData;
	}

	private static class RegistryFieldControlData implements IFieldControlData{
		//private RegistryResourceNode selectedRegistryNode;
		private Control control;
		private IOnAction onAction;
		
		public Object getData() {
			return  getControl().getData();
		}

		
		public void setData(Object data) {
			if (data!=null){
				if(data instanceof RegistryResourceNode){
					//callback=0;
					//updateModel=true;
					((Text) getControl()).setText(((RegistryResourceNode)data).getRegistryResourcePath());
					getControl().setData(data);
				} else{
					((Text) getControl()).setText(data.toString());
					getControl().setData(null);
				}
			} else{
				((Text) getControl()).setText("");
				getControl().setData(null);
			}
		}

		
		public Control getControl() {
			return this.control;
		}
		
		
		public IOnAction getOnAction(){
			return onAction;
		}

		
		public void setOnAction(IOnAction action) {
			this.onAction = action;
			final Text ctrl = (Text) getControl();
			ctrl.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent evt) {
						getOnAction().onModifyAction();	
				}
			});
			ctrl.addKeyListener(new KeyAdapter() {
				
				public void keyReleased(KeyEvent e) {
					getControl().setData(null);
					//FIXME
				    super.keyReleased(e);
				}
			});

		}
		
		public RegistryFieldControlData(Control control){
			this.control = control;
		} 
		
//		public RegistryFieldControlData(Control control, RegistryResourceNode selectedRegistryNode){
//			this.control = control;
//			this.selectedRegistryNode = selectedRegistryNode;
//		} 

//		public void setSelectedRegistryNode(RegistryResourceNode selectedRegistryNode) {
//			this.selectedRegistryNode = selectedRegistryNode;
//		}
//
//		public RegistryResourceNode getSelectedRegistryNode() {
//			return selectedRegistryNode;
//		}
		
	}
	
	private static class RegistryTextFieldControlData implements IFieldControlData {
		private Control control;
		private IOnAction onAction;

		public Object getData() {
			return getControl().getData();
		}

		public void setData(Object data) {
			if (data != null) {
				if (data instanceof RegistryResourceNode) {
					((Text) getControl()).setText(((RegistryResourceNode) data)
							.getRegistryResourcePath());
					getControl().setData(data);
				} else {
					((Text) getControl()).setText(data.toString());
					getControl().setData(data.toString());
				}
			} else {
				((Text) getControl()).setText("");
				getControl().setData(null);
			}
		}

		public Control getControl() {
			return this.control;
		}

		public IOnAction getOnAction() {
			return onAction;
		}

		public void setOnAction(IOnAction action) {
			this.onAction = action;
			final Text ctrl = (Text) getControl();
			ctrl.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent evt) {
					getControl().setData(ctrl.getText());
					getOnAction().onModifyAction();
				}
			});

		}

		public RegistryTextFieldControlData(Control control) {
			this.control = control;
		}

	}
}

