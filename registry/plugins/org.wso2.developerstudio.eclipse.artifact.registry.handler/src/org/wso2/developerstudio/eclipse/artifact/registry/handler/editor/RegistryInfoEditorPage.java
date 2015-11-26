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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.editor;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.Activator;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.dialog.ClassNameBrowseDlg;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.dialog.PropertyDialog;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.dialog.ClassNameBrowseDlg.ClassFilter;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.CodeManipulator;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.PropertyData;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

public class RegistryInfoEditorPage extends FormPage {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private Text txtHandlerClass;
	private Text txtFilterClass;
	private Table tblHndMethods;
	private Table tblHndProperties;
	private Table tblFilterCriteria;
	private Button btnFltProAdd; 
	private Button btnFltProRemove;
	private Button btnHndProAdd;
	private Button btnHndProRemove;
	private IType typeHandler;
	private IType typeFilter;
	private Map<String,String[]> methodList;
	private HandlerInfo handlerInfo;
	private IFile handlerInfoFile;
	private boolean pageDirty;
	
	private Map<String, PropertyData> filterProperties;
	private Map<String, PropertyData> handlerProperties;
	private Map<String, PropertyData> handlerpropertiesToBeRemoved;
	List<String> selectedMethods;
	List<String> methodsToBeRemoved;
	private TableEditor propertyValueEditor;
	private TableEditor propertyTypeEditor;
	
	/* 
	 * */
	private String handlerClass = new String();
	private String filterClass = new String();

	
	
	public void setHandlerClass(String handlerClass) {
		this.handlerClass = handlerClass;
	}

	public String getHandlerClass() {
		return handlerClass;
	}

	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}

	public String getFilterClass() {
		return filterClass;
	}

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public RegistryInfoEditorPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public RegistryInfoEditorPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	
	protected void createFormContent(IManagedForm managedForm) {
		managedForm.getForm().setImage(SWTResourceManager.getImage(this.getClass(), "/icons/new-registry-handler-24x24.png"));
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Registry Handler Information");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(null);
		
		Section sctnGeneral = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnGeneral.setBounds(5, 5, 500, 80);
		managedForm.getToolkit().paintBordersFor(sctnGeneral);
		sctnGeneral.setText("Handler");
		
		
		Composite cpsClass = managedForm.getToolkit().createComposite(sctnGeneral);
		managedForm.getToolkit().paintBordersFor(cpsClass);
		sctnGeneral.setClient(cpsClass);
		cpsClass.setLayout(new GridLayout(3, false));
		
		Hyperlink lnkHandlerClass = managedForm.getToolkit().createHyperlink(cpsClass, "Class", SWT.NONE);
		managedForm.getToolkit().paintBordersFor(lnkHandlerClass);
		lnkHandlerClass.addListener(SWT.MouseDown, new Listener() {
			
			
			public void handleEvent(Event evt) {
				try {
	                openJavaEditor(typeHandler,(IJavaElement)typeHandler);
                } catch (Exception e) {
                	log.error(e);
                }
			}
		});
		
		txtHandlerClass = managedForm.getToolkit().createText(cpsClass, getHandlerClass(), SWT.NONE|SWT.READ_ONLY);
		GridData gd_txtHandlerClass = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtHandlerClass.widthHint = 350;
		txtHandlerClass.setLayoutData(gd_txtHandlerClass);
		
		txtHandlerClass.addModifyListener(new ModifyListener() {
			
			
			public void modifyText(ModifyEvent arg0) {
				//TODO:
			}
		});
		
		Button btnBrowse = managedForm.getToolkit().createButton(cpsClass, "Browse..", SWT.NONE);
		btnBrowse.addListener(SWT.MouseDown,new Listener() {
			
			
			public void handleEvent(Event evt) {
				Shell shell = new Shell();
				ClassNameBrowseDlg dialog = new ClassNameBrowseDlg(
				                            shell,
				                            ClassFilter.FILTER_SUPERCLASS,
				                            "Handler");

				if (dialog.open() == Dialog.OK) {
					typeHandler= (IType) dialog.getFirstResult();
					setHandlerClass(typeHandler.getFullyQualifiedName());
					handlerInfo.setHandlerClass(getHandlerClass());
					setPageDirty(true);
					updateDirtyState();

				}
			}
		});
		
		sctnGeneral.setExpanded(true);
		
		Section sctnHandlerMethods = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnHandlerMethods.setBounds(5, 95, 500, 235);
		managedForm.getToolkit().paintBordersFor(sctnHandlerMethods);
		sctnHandlerMethods.setText("Handler Methods");
		
		Composite cpsHandlerMethods = managedForm.getToolkit().createComposite(sctnHandlerMethods, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(cpsHandlerMethods);
		sctnHandlerMethods.setClient(cpsHandlerMethods);
		cpsHandlerMethods.setLayout(new GridLayout(3, false));
		
		tblHndMethods = managedForm.getToolkit().createTable(cpsHandlerMethods, SWT.BORDER | SWT.CHECK);
		tblHndMethods.setHeaderVisible(true);
		GridData gd_tblHndMethods = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_tblHndMethods.heightHint = 144;
		tblHndMethods.setLayoutData(gd_tblHndMethods);
		managedForm.getToolkit().paintBordersFor(tblHndMethods);
		
		TableColumn clmnMethod = new TableColumn(tblHndMethods, SWT.NONE);
		clmnMethod.setWidth(100);
		clmnMethod.setText("Method");
		
		TableColumn clmnDescription = new TableColumn(tblHndMethods, SWT.NONE);
		clmnDescription.setWidth(333);
		clmnDescription.setText("Description");
		
		methodList = HandlerMethodInfo.getMethodInfo();
		for(String method : methodList.keySet()){
			TableItem tableItem= new TableItem(tblHndMethods, SWT.NONE);
			tableItem.setText(0,method );
			tableItem.setText(1,methodList.get(method)[0]);
		}
		
		Button btnSelectAll = managedForm.getToolkit().createButton(cpsHandlerMethods, "Select All", SWT.NONE);
		GridData gd_btnSelectAll = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSelectAll.widthHint = 120;
		btnSelectAll.setLayoutData(gd_btnSelectAll);
		
		btnSelectAll.addListener(SWT.MouseDown, new Listener() {
			
			
			public void handleEvent(Event evt) {
				TableItem[] items = tblHndMethods.getItems();
				for (TableItem item : items) {
					String xmlAttributeValue = HandlerMethodInfo.getXMLAttributeValue(item.getText(0));
					item.setChecked(true);
					if(!selectedMethods.contains(xmlAttributeValue)){
						selectedMethods.add(xmlAttributeValue);
					}
				}
				methodsToBeRemoved = new ArrayList<String>();
				setPageDirty(true);
				updateDirtyState();
			}
		});
		
		Button btnDeselectAll = managedForm.getToolkit().createButton(cpsHandlerMethods, "Deselect All", SWT.NONE);
		GridData gd_btnDeselectAll = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnDeselectAll.widthHint = 120;
		btnDeselectAll.setLayoutData(gd_btnDeselectAll);
		
		btnDeselectAll.addListener(SWT.MouseDown, new Listener() {
			
			
			public void handleEvent(Event evt) {
				TableItem[] items = tblHndMethods.getItems();
				for (TableItem item : items) {
					String methodName = item.getText(0);
					String methodAttributeValue = HandlerMethodInfo.getXMLAttributeValue(methodName);
					item.setChecked(false);
					if(selectedMethods.contains(methodAttributeValue)){
						selectedMethods.remove(methodAttributeValue);
						
					}
					if(!methodsToBeRemoved.contains(methodName)){
						methodsToBeRemoved.add(methodName);
					}
				}
				setPageDirty(true);
				updateDirtyState();
			}
		});
		new Label(cpsHandlerMethods, SWT.NONE);
		
		sctnHandlerMethods.setExpanded(true);
		
		Section sctnHandlerProperties = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnHandlerProperties.setBounds(5, 335, 500, 251);
		managedForm.getToolkit().paintBordersFor(sctnHandlerProperties);
		sctnHandlerProperties.setText("Handler Properties");
		
		Composite cpsHandlerProperties = managedForm.getToolkit().createComposite(sctnHandlerProperties, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(cpsHandlerProperties);
		sctnHandlerProperties.setClient(cpsHandlerProperties);
		cpsHandlerProperties.setLayout(new GridLayout(3, false));
		
		tblHndProperties = managedForm.getToolkit().createTable(cpsHandlerProperties, SWT.NONE);
		tblHndProperties.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		managedForm.getToolkit().paintBordersFor(tblHndProperties);
		tblHndProperties.setHeaderVisible(true);
		tblHndProperties.setLinesVisible(true);
		
		TableColumn clmnPropertyName = new TableColumn(tblHndProperties, SWT.NONE);
		clmnPropertyName.setWidth(100);
		clmnPropertyName.setText("Property Name");
		
		TableColumn clmnValue = new TableColumn(tblHndProperties, SWT.NONE);
		clmnValue.setWidth(269);
		clmnValue.setText("Value");
		
		TableColumn clmnType = new TableColumn(tblHndProperties, SWT.NONE);
		clmnType.setWidth(100);
		clmnType.setText("Type");
		sctnHandlerProperties.setExpanded(true);
		
		btnHndProAdd = managedForm.getToolkit().createButton(cpsHandlerProperties, "Add", SWT.NONE);
		GridData gd_btnHndProAdd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnHndProAdd.widthHint = 80;
		btnHndProAdd.setLayoutData(gd_btnHndProAdd);
		btnHndProAdd.addListener(SWT.MouseDown,new Listener() {
			
			public void handleEvent(Event evt) {
				List<String> items = new ArrayList<String>(handlerProperties.keySet());
				PropertyDialog propertyDialog = new PropertyDialog(getSite().getShell(),items);
				disposeTableEditor();
				if(propertyDialog.open()==Dialog.OK){
					PropertyData propertyData = propertyDialog.getPropertyData();
			        TableItem tableItem= new TableItem(tblHndProperties, SWT.NONE);
					tableItem.setText(0,propertyDialog.getPropertyName());
					tableItem.setText(1,propertyData.data);
					tableItem.setText(2,propertyData.type.toString());
					handlerProperties.put(propertyDialog.getPropertyName(),propertyData);
					if(handlerpropertiesToBeRemoved.containsKey(propertyDialog.getPropertyName())){
						handlerpropertiesToBeRemoved.remove(propertyDialog.getPropertyName());
					}
					tableItem.setData(propertyData);
					setPageDirty(true);
					updateDirtyState();
				}
			}
		});
		
		btnHndProRemove = managedForm.getToolkit().createButton(cpsHandlerProperties, "Remove", SWT.NONE);
		GridData gd_btnHndProRemove = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnHndProRemove.widthHint = 80;
		btnHndProRemove.setLayoutData(gd_btnHndProRemove);
		btnHndProRemove.setEnabled(false);
		
		btnHndProRemove.addListener(SWT.MouseDown, new Listener() {

			public void handleEvent(Event evt) {
				disposeTableEditor();
				if (tblHndProperties.getSelectionIndex() != -1) {
					TableItem tableItem = tblHndProperties.getSelection()[0];
					String key = tableItem.getText(0);
					
					if(!handlerpropertiesToBeRemoved.containsKey(key)){
						handlerpropertiesToBeRemoved.put(key,
						                                 handlerProperties.get(key));
					}
					
					handlerProperties.remove(key);
					tableItem.dispose();
					setPageDirty(true);
					updateDirtyState();
					btnFltProRemove.setEnabled(false);
				}
			}
		});
		
		new Label(cpsHandlerProperties, SWT.NONE);
		
		sctnHandlerProperties.setExpanded(true);
		
		Section sctnFilter = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnFilter.setBounds(520, 5, 500, 80);
		managedForm.getToolkit().paintBordersFor(sctnFilter);
		sctnFilter.setText("Filter");
		
		Composite cpsFilter = managedForm.getToolkit().createComposite(sctnFilter, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(cpsFilter);
		sctnFilter.setClient(cpsFilter);
		cpsFilter.setLayout(new GridLayout(3, false));
		
		Hyperlink lnkFilterClass = managedForm.getToolkit().createHyperlink(cpsFilter, "Class", SWT.NONE);
		managedForm.getToolkit().paintBordersFor(lnkFilterClass);
		lnkFilterClass.addListener(SWT.MouseDown,new Listener() {
			
			
			public void handleEvent(Event evt) {
				try {
	                openJavaEditor(typeFilter,(IJavaElement)typeFilter);
                } catch (Exception e) {
                	log.error(e);
                }
			}
		});
		
		txtFilterClass = new Text(cpsFilter, SWT.NONE|SWT.READ_ONLY);
		txtFilterClass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFilterClass.setText(getFilterClass());
		
		Button btnFilterBrowse = managedForm.getToolkit().createButton(cpsFilter, "Browse..", SWT.NONE);
		btnFilterBrowse.addListener(SWT.MouseDown,new Listener() {
			
			
			public void handleEvent(Event evt) {
				Shell shell = new Shell();
				ClassNameBrowseDlg dialog = new ClassNameBrowseDlg(
				                            shell,
				                            ClassFilter.FILTER_SUPERCLASS,
				                            "Filter");

				if (dialog.open() == Dialog.OK) {
					typeFilter = (IType) dialog.getFirstResult();
					setFilterClass(typeFilter.getFullyQualifiedName());
					handlerInfo.setFilterClass(getFilterClass());
					setPageDirty(true);
					updateDirtyState();
				}
				
			}
		});
		
		sctnFilter.setExpanded(true);
		
		Section sctnFilterCriteria = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnFilterCriteria.setBounds(520, 95, 500, 227);
		managedForm.getToolkit().paintBordersFor(sctnFilterCriteria);
		sctnFilterCriteria.setText("Filter Criteria");
		
		Composite cpsFilterCriteria = managedForm.getToolkit().createComposite(sctnFilterCriteria, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(cpsFilterCriteria);
		sctnFilterCriteria.setClient(cpsFilterCriteria);
		cpsFilterCriteria.setLayout(new GridLayout(3, false));
		
		tblFilterCriteria = managedForm.getToolkit().createTable(cpsFilterCriteria, SWT.NONE);
		tblFilterCriteria.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		managedForm.getToolkit().paintBordersFor(tblFilterCriteria);
		tblFilterCriteria.setHeaderVisible(true);
		tblFilterCriteria.setLinesVisible(true);
		
		TableColumn clmnFilterPropertyName = new TableColumn(tblFilterCriteria, SWT.NONE);
		clmnFilterPropertyName.setWidth(100);
		clmnFilterPropertyName.setText("Property Name");
		
		TableColumn clmnFilterValue = new TableColumn(tblFilterCriteria, SWT.NONE);
		clmnFilterValue.setWidth(269);
		clmnFilterValue.setText("Value");
		
		TableColumn clmnFilterType = new TableColumn(tblFilterCriteria, SWT.NONE);
		clmnFilterType.setWidth(100);
		clmnFilterType.setText("Type");
		
		btnFltProAdd = managedForm.getToolkit().createButton(cpsFilterCriteria, "Add", SWT.NONE);
		GridData gd_btnFltProAdd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnFltProAdd.widthHint = 80;
		btnFltProAdd.setLayoutData(gd_btnFltProAdd);
		btnFltProAdd.addListener(SWT.MouseDown, new Listener() {
			
			
			public void handleEvent(Event evt) {
				List<String> items = new ArrayList<String>(filterProperties.keySet());
				PropertyDialog propertyDialog = new PropertyDialog(getSite().getShell(),items);
				disposeTableEditor();
				if(propertyDialog.open()==Dialog.OK){
					PropertyData propertyData = propertyDialog.getPropertyData();
			        TableItem tableItem= new TableItem(tblFilterCriteria, SWT.NONE);
					tableItem.setText(0,propertyDialog.getPropertyName());
					tableItem.setText(1,propertyData.data);
					tableItem.setText(2,propertyData.type.toString());
					filterProperties.put(propertyDialog.getPropertyName(),propertyData);
					tableItem.setData(propertyData);
					setPageDirty(true);
					updateDirtyState();
				}
				
			}
		});
		
		btnFltProRemove = managedForm.getToolkit().createButton(cpsFilterCriteria, "Remove", SWT.NONE);
		GridData gd_btnFltProRemove = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnFltProRemove.widthHint = 80;
		btnFltProRemove.setLayoutData(gd_btnFltProRemove);
		btnFltProRemove.setEnabled(false);
		
		btnFltProRemove.addListener(SWT.MouseDown,new Listener() {
			
			public void handleEvent(Event evt) {
				disposeTableEditor();
				if(tblFilterCriteria.getSelectionIndex() != -1){
					TableItem tableItem = tblFilterCriteria.getSelection()[0];	
					filterProperties.remove(tableItem.getText(0));
					tableItem.dispose();
					setPageDirty(true);
					updateDirtyState();
					btnFltProRemove.setEnabled(false);
				}
				
			}
		});
		
		new Label(cpsHandlerProperties, SWT.NONE);
		
		sctnFilterCriteria.setExpanded(true);
		
		Listener tblMethodsListener= new Listener() {
			
			
			public void handleEvent(Event evt) {
			TableItem item = (TableItem) evt.item;
			String key = item.getText(0);
			String xmlAttributeValue = HandlerMethodInfo.getXMLAttributeValue(key);
			if(evt.detail==SWT.CHECK){
				boolean checked = item.getChecked();
				if(checked){
					if(!selectedMethods.contains(xmlAttributeValue)){
						selectedMethods.add(xmlAttributeValue);
						setPageDirty(true);
					}
					if(methodsToBeRemoved.contains(key)){
						methodsToBeRemoved.remove(key);
					}
						
				} else{
					if(selectedMethods.contains(xmlAttributeValue)){
						selectedMethods.remove(xmlAttributeValue);
						setPageDirty(true);
					}
					if(!methodsToBeRemoved.contains(key)){
						methodsToBeRemoved.add(key);
					}
				}
			}
			updateDirtyState();
			}
		}; 
		
		Listener tblFilterCriteriaListener = new Listener() {
			
			
			public void handleEvent(Event evt) {
				if(null!=evt.item){
					if(evt.item instanceof TableItem){
						TableItem item = (TableItem)evt.item;
						editItem(item);
						btnFltProRemove.setEnabled(true);
					} else{
						btnFltProRemove.setEnabled(false);
					}
				} else {
					btnFltProRemove.setEnabled(false);
				}
			}
		};
		
		Listener tblPropertiesListener = new Listener() {
			
			
			public void handleEvent(Event evt) {
				if(null!=evt.item){
					if(evt.item instanceof TableItem){
						TableItem item = (TableItem)evt.item;
						editItem(item);
						btnHndProRemove.setEnabled(true);
					} else{
						btnHndProRemove.setEnabled(false);
					}
				} else{
					btnHndProRemove.setEnabled(false);
				}
			}
		};
		
		
		Listener tblHndPropertiesFocusOut = new Listener() {
			
			public void handleEvent(Event evt) {
				uninitTableEditor();
				btnHndProRemove.setEnabled(false);
			}
		};
		
		Listener tblFilterCriteriaFocusOut = new Listener() {
			
			public void handleEvent(Event evt) {
				uninitTableEditor();
				btnFltProRemove.setEnabled(false);
			}
		};
		
		tblHndMethods.addListener(SWT.Selection,tblMethodsListener);
		tblFilterCriteria.addListener(SWT.Selection, tblFilterCriteriaListener);
		tblHndProperties.addListener(SWT.Selection, tblPropertiesListener);
		tblHndProperties.addListener(SWT.FocusOut, tblHndPropertiesFocusOut);
		tblFilterCriteria.addListener(SWT.FocusOut, tblFilterCriteriaFocusOut);
		tblHndMethods.addMouseListener(new MouseAdapter() {
			
			public void mouseDoubleClick(MouseEvent e) {
			if(tblHndMethods.getSelectionIndex()!=-1){
				try {
				TableItem selection = tblHndMethods.getSelection()[0];
				CodeManipulator cm = new CodeManipulator(typeHandler);
		        openJavaEditor(typeHandler,(IJavaElement)cm.getHandlerMethod(selection.getText(0)));
				} catch (Exception ignore) {/* ignore */}
			}
			}
		});
		tblHndProperties.addMouseListener(new MouseAdapter() {
			
			public void mouseDoubleClick(MouseEvent e) {
			if(tblHndProperties.getSelectionIndex()!=-1){
				try {
				TableItem selection = tblHndProperties.getSelection()[0];
				PropertyData data = (PropertyData) selection.getData();
				CodeManipulator cm = new CodeManipulator(typeHandler);
		        openJavaEditor(typeHandler,(IJavaElement)cm.getHandlerProperty(selection.getText(0),data.type)); 
				} catch (Exception ignore) {/* ignore */}
			}
			}
		});
		
		try {
			handlerpropertiesToBeRemoved = new HashMap<String, PropertyData>();
			methodsToBeRemoved = new ArrayList<String>();
	        typeHandler = getType(getHandlerClass());
	        initHandlerMethodContent();
	        initHandlerPropertyContent();
	        initFilterPropertyContent();
	        typeFilter = getType(getFilterClass());
        } catch (Exception e) {
	       log.error(e);
        }
		form.updateToolBar();
		form.reflow(true);
	}
	
	private void editItem(final TableItem item) {
		propertyValueEditor = initTableEditor(propertyValueEditor, item.getParent());
		propertyTypeEditor = initTableEditor(propertyTypeEditor, item.getParent());
		final Text txtPropertyValue = new Text(item.getParent(), SWT.NONE);
		txtPropertyValue.setText(item.getText(1));
		final Combo cmbPropertyType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbPropertyType.setItems(new String[] { "STRING", "XML" });
		cmbPropertyType.setText(item.getText(2));
		final PropertyData propertyData = (PropertyData) item.getData();
		propertyValueEditor.setEditor(txtPropertyValue, item, 1);
		propertyTypeEditor.setEditor(cmbPropertyType, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		txtPropertyValue.addListener(SWT.CHANGED, new Listener() {
			
			public void handleEvent(Event evt) {
				if(propertyData.type == DataType.XML){
					if(!validateXML(txtPropertyValue.getText())){
						evt.doit=false;
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), 
						                          "Property value",
						                          "Property value should be well formatted XML string for Type XML");
						return;
					}
				}
				item.setText(1,txtPropertyValue.getText());
				propertyData.data = txtPropertyValue.getText();
				setPageDirty(true);
				updateDirtyState();
			}
		});
		cmbPropertyType.addListener(SWT.Selection,new Listener() {
			
			public void handleEvent(Event evt) {
				
				if("XML".equals(cmbPropertyType.getText())){
					if(validateXML(item.getText(1))){
						propertyData.type = DataType.XML;
					} else{
						evt.doit=false;
						cmbPropertyType.setText("STRING");
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), 
						                          "Property value",
						                          "Property value should be well formatted XML string for Type XML");
						return;
					}
					
				} else{
					propertyData.type = DataType.STRING;
				}
				item.setText(2,cmbPropertyType.getText());
				setPageDirty(true);
				updateDirtyState();
			}
		});
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
	
	private TableEditor initTableEditor(TableEditor editor, Table table) {
		if (null != editor) {
			Control lastCtrl = editor.getEditor();
			if (null != lastCtrl) {
				lastCtrl.dispose();
			}
		}
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		return editor;
	}
	
	private void uninitTableEditor() {
		if(null==propertyValueEditor)
			return;
		Control text = propertyValueEditor.getEditor();
		if (null != text) {
			Point m = MouseInfo.getPointerInfo().getLocation();
			if(!text.isDisposed()){
			Composite ctrl = text.getParent();
			org.eclipse.swt.graphics.Point p = ctrl.toDisplay(0, 0);
			Rectangle cr = new Rectangle(p.x, p.y, ctrl.getClientArea().width,
			                            ctrl.getClientArea().height);
			Rectangle mr = new Rectangle(m.x, m.y, 1, 1);
			if (!cr.intersects(mr)) {
				disposeTableEditor();
			}
			}
		}
	}
	
	private void disposeTableEditor() {
		if(null==propertyValueEditor || null==propertyTypeEditor)
			return;
		Control text = propertyValueEditor.getEditor();
		Control combo = propertyTypeEditor.getEditor();
		if (null != text && null != combo) {
			
				text.dispose();
				combo.dispose();
		}
	}
	
	private IType getType(String className) throws JavaModelException{
		IProject project = ((FileEditorInput) getEditorInput()).getFile().getProject();
		IJavaProject javaPrj = JavaCore.create(project);
        return javaPrj.findType(className);
	}
	
	private void openJavaEditor(IType type,IJavaElement element) throws Exception{
		if(null!=type){
        ICompilationUnit cu = type.getCompilationUnit();
        IEditorPart javaEditor = JavaUI.openInEditor(cu);
        JavaUI.revealInEditor(javaEditor,element);
		}
	}
	
	public void initContent() throws Exception{
		handlerInfo = new HandlerInfo();
		handlerInfoFile = ((IFileEditorInput)(getEditor().getEditorInput())).getFile();
		handlerInfo.deserialize(handlerInfoFile);
		//TODO:
		setHandlerClass(handlerInfo.getHandlerClass());
		setFilterClass(handlerInfo.getFilterClass());
		
	}
	
	public void refreshContent() throws Exception{
		handlerInfo = new HandlerInfo();
		handlerInfoFile = ((IFileEditorInput)(getEditor().getEditorInput())).getFile();
		String content = ((RegistryInfoEditor)getEditor()).getDocument().get();
		handlerInfo.deserialize(content);
		setHandlerClass(handlerInfo.getHandlerClass());
		setFilterClass(handlerInfo.getFilterClass());
		
		try {
	        typeHandler = getType(getHandlerClass());
	        initHandlerMethodContent();
	        initHandlerPropertyContent();
	        initFilterPropertyContent();
	        typeFilter = getType(getFilterClass());
        } catch (Exception e) {
	       log.error(e);
        }
		
	}
	
	public String getSource() throws Exception{
		return handlerInfo.toString();
	}
	
	public void initHandlerPropertyContent(){
		handlerProperties = handlerInfo.getHandlerProperties();
		tblHndProperties.removeAll();
		for (String element : handlerProperties.keySet()) {
			PropertyData propertyData = handlerProperties.get(element);
	        TableItem tableItem= new TableItem(tblHndProperties, SWT.NONE);
			tableItem.setText(0,element);
			tableItem.setText(1,propertyData.data);
			tableItem.setText(2,propertyData.type.toString());
			tableItem.setData(propertyData);
        }
	}
	
	public void initHandlerMethodContent() throws Exception{
		selectedMethods = handlerInfo.getSelectedMethods();
        for(TableItem item : tblHndMethods.getItems()){
        	boolean contains = selectedMethods.contains(HandlerMethodInfo.getXMLAttributeValue(item.getText(0)));
        	item.setChecked(contains);
        }
	}
	
	public void initFilterPropertyContent(){
		filterProperties = handlerInfo.getFilterProperties();
		tblFilterCriteria.removeAll();
		for (String element : filterProperties.keySet()) {
			PropertyData propertyData = filterProperties.get(element);
	        TableItem tableItem= new TableItem(tblFilterCriteria, SWT.NONE);
			tableItem.setText(0,element);
			tableItem.setText(1,propertyData.data);
			tableItem.setText(2,propertyData.type.toString());
			tableItem.setData(propertyData);
        }
	}
	
	public void save() throws Exception{
		handlerInfoFile = ((IFileEditorInput)(getEditor().getEditorInput())).getFile();
		String content = ((RegistryInfoEditor)getEditor()).getDocument().get();
		handlerInfo.deserialize(content);
		handlerInfo.toFile(handlerInfoFile);
		updateJavaSource();
		setPageDirty(false);
	}
	
	public void updateJavaSource() throws Exception{
		Map<String, PropertyData> properties = handlerInfo.getHandlerProperties();
		List<String> methods = handlerInfo.getSelectedMethods();
		CodeManipulator manipulator = new CodeManipulator(typeHandler);
		for (String key : properties.keySet()) {
			PropertyData propertyData = properties.get(key);
			IMethod handlerProperty = manipulator.getHandlerProperty(key, propertyData.type);
			if(null==handlerProperty){
				manipulator.addHandlerProperty(key, propertyData.type);
			}
        }
		for (String method : methods) {
			String methodName = HandlerMethodInfo.getMethodName(method);
			IMethod handlerMethod = manipulator.getHandlerMethod(methodName);
			if(null==handlerMethod){
				String returnType = HandlerMethodInfo.getReturnType(methodName);
				manipulator.addHandlerMethod(methodName, returnType);
			}
        }
		for(String key: handlerpropertiesToBeRemoved.keySet()){
			manipulator.removeHandlerProperty(key, handlerpropertiesToBeRemoved.get(key).type);
		}
		for(String key:methodsToBeRemoved){
			manipulator.removeHandlerMethod(key);
		}
		handlerpropertiesToBeRemoved = new HashMap<String, PropertyData>();
		methodsToBeRemoved = new ArrayList<String>();
		manipulator.commit();
	}
	
	public boolean isPageDirty(){
		return pageDirty;
	}
	
	public void setPageDirty(boolean isPageDirty){
		this.pageDirty= isPageDirty;
	}
	
	public void updateDirtyState() {
		((RegistryInfoEditor)getEditor()).updateDirtyState();;
	}

	public boolean isDirty() {
		return isPageDirty();
	}
	
	
}
