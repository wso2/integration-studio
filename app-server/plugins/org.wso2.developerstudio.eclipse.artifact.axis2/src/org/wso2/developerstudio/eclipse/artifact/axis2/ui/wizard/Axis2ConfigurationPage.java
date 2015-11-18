/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.axis2.ui.wizard;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.xml.namespace.QName;

import org.apache.axis2.util.URLProcessor;
import org.apache.woden.types.NamespaceDeclaration;
import org.apache.woden.wsdl20.Description;
import org.apache.woden.wsdl20.Endpoint;
import org.apache.woden.wsdl20.Service;
import org.apache.woden.wsdl20.xml.DescriptionElement;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.axis2.Activator;
import org.wso2.developerstudio.eclipse.artifact.axis2.model.DataModel;
import org.wso2.developerstudio.eclipse.artifact.axis2.utils.WSDL2Utils;
import org.wso2.developerstudio.eclipse.libraries.utils.WSDLUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class Axis2ConfigurationPage extends WizardPage {
	private Table namespace2packageTable;
	private Combo serviceNameCombo;
	private Combo portNameCombo;
	private Combo databindingTypeCombo;
	private Text packageText;
	private Button syncAndAsyncRadioButton;
	private Button syncOnlyRadioButton;
	private Button asyncOnlyRadioButton;
	private Button unpackClassesCheckBoxButton;
	private Button unwrapClassesCheckBoxButton;
	private Button testCaseCheckBoxButton;
	private Button generateAllCheckBoxButton;
	private Button noBuildXmlCheckBoxButton;

//	private WSASEmitterContext context;
	private Definition reader;
	private List<QName> serviceQNameList = null;
	private DataModel model;
	private static IDeveloperStudioLog log = Logger
			.getLog(Activator.PLUGIN_ID);
	private boolean isDataPopulated = false;
	private boolean isWSDL20;

	public boolean isDataPopulated() {
		return isDataPopulated;
	}

	protected Axis2ConfigurationPage(String pageName, DataModel model) {
		// Configuration
		super(pageName);
		setTitle(pageName);
		this.model = model;
	}
	

	public void createControl(Composite parent) {

//		context = WebServiceWSASCorePlugin.getDefault().getWSASEmitterContext();

		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 102, 17);
		lblNewLabel.setText("Service Name");

		Label lblPortName = new Label(container, SWT.NONE);
		lblPortName.setText("Port Name");
		lblPortName.setBounds(10, 43, 102, 17);

		Label lblDatabindingName = new Label(container, SWT.NONE);
		lblDatabindingName.setText("Databinding Name");
		lblDatabindingName.setBounds(10, 76, 152, 17);

		Label lblCustomPackageName = new Label(container, SWT.NONE);
		lblCustomPackageName.setText("Custom Package Name");
		lblCustomPackageName.setBounds(10, 112, 170, 17);

		serviceNameCombo = new Combo(container, SWT.READ_ONLY);
		serviceNameCombo.setBounds(194, 5, 461, 27);
		serviceNameCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setServiceName(serviceNameCombo.getText());
				if (isWSDL20) {
					loadEndPointNames();
				} else {
					loadPortNames();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		portNameCombo = new Combo(container, SWT.READ_ONLY);
		portNameCombo.setBounds(194, 38, 461, 27);
		portNameCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (portNameCombo.getSelectionIndex() == 0)
					model.setPortName(null);
				else
					model.setPortName(portNameCombo.getText());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		databindingTypeCombo = new Combo(container, SWT.READ_ONLY);
		databindingTypeCombo.setBounds(194, 71, 461, 27);
		fillDatabinderCombo();
		databindingTypeCombo.select(0);
		databindingTypeCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setDatabindingType(databindingTypeCombo.getText());
			};

			public void widgetDefaultSelected(SelectionEvent e) {
			};
		});

		packageText = new Text(container, SWT.BORDER);
		packageText.setBounds(195, 107, 460, 27);
		packageText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				model.setPackageName(packageText.getText());
			}
		});

		syncAndAsyncRadioButton = new Button(container, SWT.RADIO);
		syncAndAsyncRadioButton.setBounds(10, 154, 226, 20);
		syncAndAsyncRadioButton.setText("Generate both sync and async");
		syncAndAsyncRadioButton.setSelection(false);
		syncAndAsyncRadioButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				// Because default setting in Axis2 to be both false in thie
				// case
				// File a JIRA to fix this.
				model.setGenerateSyncCode(!syncAndAsyncRadioButton.getSelection());
				model.setGenerateAsyncCode(!syncAndAsyncRadioButton.getSelection());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		syncOnlyRadioButton = new Button(container, SWT.RADIO);
		syncOnlyRadioButton.setText("Generate sync style only");
		syncOnlyRadioButton.setBounds(242, 154, 192, 20);
		syncOnlyRadioButton.setSelection(true);
		syncOnlyRadioButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setGenerateSyncCode(syncOnlyRadioButton.getSelection());
				model.setGenerateAsyncCode(!syncOnlyRadioButton.getSelection());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		asyncOnlyRadioButton = new Button(container, SWT.RADIO);
		asyncOnlyRadioButton.setText("Generate async style only");
		asyncOnlyRadioButton.setBounds(440, 154, 192, 20);
		asyncOnlyRadioButton.setSelection(false);
		asyncOnlyRadioButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setGenerateAsyncCode(asyncOnlyRadioButton.getSelection());
				model.setGenerateSyncCode(!asyncOnlyRadioButton.getSelection());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Set the sync async to default
		model.setGenerateSyncCode(syncAndAsyncRadioButton.getSelection() || syncOnlyRadioButton.getSelection());
		model.setGenerateAsyncCode(syncAndAsyncRadioButton.getSelection() || asyncOnlyRadioButton.getSelection());

		// unpack classes
		unpackClassesCheckBoxButton = new Button(container, SWT.CHECK);
		unpackClassesCheckBoxButton.setBounds(10, 180, 501, 20);
		unpackClassesCheckBoxButton
				.setText("Unpack classes and generate seperate classes for the databinders");
		unpackClassesCheckBoxButton.setSelection(false);
		unpackClassesCheckBoxButton
				.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent e) {
						model.setUnpack(unpackClassesCheckBoxButton
								.getSelection());
					}

					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});

		// unwrap classes
		unwrapClassesCheckBoxButton = new Button(container, SWT.CHECK);
		unwrapClassesCheckBoxButton.setText("Switch on un-wrapping");
		unwrapClassesCheckBoxButton.setBounds(10, 206, 254, 20);
		unwrapClassesCheckBoxButton.setSelection(true);
		unwrapClassesCheckBoxButton
				.addSelectionListener(new SelectionListener() {
					public void widgetSelected(SelectionEvent e) {
						model.setUnwrap(unwrapClassesCheckBoxButton
								.getSelection());
					}

					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});

		// generate test case option
		testCaseCheckBoxButton = new Button(container, SWT.CHECK);
		testCaseCheckBoxButton
				.setText("Generate test case to test the service");
		testCaseCheckBoxButton.setBounds(10, 232, 275, 20);
		testCaseCheckBoxButton.setSelection(false);
		model.setGenerateTestCase(testCaseCheckBoxButton.getSelection());
		testCaseCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setGenerateTestCase(testCaseCheckBoxButton.getSelection());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// generate all
		generateAllCheckBoxButton = new Button(container, SWT.CHECK);
		generateAllCheckBoxButton
				.setText("Generate all types for all elements referred by schemas");
		generateAllCheckBoxButton.setBounds(10, 258, 399, 20);
		generateAllCheckBoxButton.setSelection(false);
		generateAllCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setGenerateAllCode(generateAllCheckBoxButton
						.getSelection());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// no build xml
		noBuildXmlCheckBoxButton = new Button(container, SWT.CHECK);
		noBuildXmlCheckBoxButton
				.setText("Don't generate the build.xml in the output directory");
		noBuildXmlCheckBoxButton.setBounds(10, 284, 371, 20);
		noBuildXmlCheckBoxButton.setSelection(true);
		noBuildXmlCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setNoBuildXml(noBuildXmlCheckBoxButton.getSelection());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		namespace2packageTable = new Table(container, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.V_SCROLL);
		namespace2packageTable.setBounds(10, 310, 645, 106);
		namespace2packageTable.setHeaderVisible(true);
		namespace2packageTable.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(namespace2packageTable,
				SWT.NONE);
		tblclmnNewColumn.setWidth(380);
		tblclmnNewColumn.setText("Namespace");

		TableColumn tblclmnNewColumn_1 = new TableColumn(
				namespace2packageTable, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Package");

		// add the table editor
		final TableEditor editor = new TableEditor(namespace2packageTable);
		
		editor.setColumn(1);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;

		namespace2packageTable.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = namespace2packageTable.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = namespace2packageTable.getTopIndex();
				while (index < namespace2packageTable.getItemCount()) {
					boolean visible = false;
					final TableItem item = namespace2packageTable
							.getItem(index);
					for (int i = 0; i < namespace2packageTable.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							final int column = i;
							final Text text = new Text(namespace2packageTable,
									SWT.NONE);
							Listener textListener = new Listener() {
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, text.getText());
										text.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, text.getText());
											// FALL THROUGH
										case SWT.TRAVERSE_ESCAPE:
											text.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};
							text.addListener(SWT.FocusOut, textListener);
							text.addListener(SWT.Traverse, textListener);
							editor.setEditor(text, item, i);
							text.setText(item.getText(i));
							text.selectAll();
							text.setFocus();
							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
				model.setNamespaseToPackageMapping(getNs2PkgMapping());
			}
		});

		namespace2packageTable.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				model.setNamespaseToPackageMapping(getNs2PkgMapping());
			}
		});

		// ***********************************************************************************************************************
		// Moved this to observable method
		// populateParamsFromWSDL();
		// populateModel();
	}

	// /**
	// * A util method to create a new column
	// *
	// * @param table
	// * @param width
	// * @param colName
	// */
	// private void declareColumn(Table table, int width, String colName) {
	// TableColumn column = new TableColumn(table, SWT.NONE);
	// column.setWidth(width);
	// column.setText(colName);
	// }

	/**
	 * get the package to namespace mappings
	 *
	 * @return
	 */
	public String getNs2PkgMapping() {
		StringBuffer sb=new StringBuffer();
		TableItem[] items = namespace2packageTable.getItems();
		String packageValue;
		for (int i = 0; i < items.length; i++) {
			packageValue = items[i].getText(1);
			if (packageValue != null && !"".equals(packageValue)) {
				sb.append(("".equals(sb.toString()) ? "" : ",")).append(items[i].getText(0)).append("=").append(packageValue);
			}

		}
		return "".equals(sb.toString()) ? null : sb.toString();
	}

	private void populateModel() {
		model.setServiceName(serviceNameCombo.getText());
		if (portNameCombo.getSelectionIndex() == 0){
			model.setPortName(null);
		}else{
			model.setPortName(portNameCombo.getText());
		}
		model.setPackageName(packageText.getText());
		model.setDatabindingType(databindingTypeCombo.getText());
		// model.setASync(asyncOnlyRadioButton.getSelection());
		// model.setSync(syncOnlyRadioButton.getSelection());
		if (syncAndAsyncRadioButton.getSelection()) {
			model.setGenerateAsyncCode(!syncAndAsyncRadioButton.getSelection());
			model.setGenerateSyncCode(!syncAndAsyncRadioButton.getSelection());
		}
		model.setGenerateAllCode(generateAllCheckBoxButton.getSelection());
		model.setGenerateTestCase(testCaseCheckBoxButton.getSelection());
		model.setNamespaseToPackageMapping(getNs2PkgMapping());
		model.setUnpack(unpackClassesCheckBoxButton.getSelection());
		model.setWsdlVersion((isWSDL20)?"2.0":"1.1");
	}

	/**
	 * Fill the combo with proper databinding names
	 */
	private void fillDatabinderCombo() {
		databindingTypeCombo.add("ADB".toLowerCase());
		databindingTypeCombo.add("XMLBEANS".toLowerCase());
		databindingTypeCombo.add("JIBX".toLowerCase());
		databindingTypeCombo.add("NONE".toLowerCase());
		databindingTypeCombo.select(0);
	}

	/**
	 * populate the service and the port from the WSDL this needs to be public
	 * since the WSDLselection page may call this
	 */
	public void populateParamsFromWSDL() {
		try {
			String lname = model.getWsdlURI();
			int wsdlVersion = WSDL2Utils.getWSDLVersion(lname);
			if(wsdlVersion==WSDL2Utils.WSDL_VERSION_11){
			isWSDL20=false;
			if (!"".equals(lname.trim())) {
				if (reader == null){
					reader = WSDLUtils.readWSDL((new File(lname)).toURI().toURL());
				}

				this.serviceQNameList = WSDLUtils.getServiceList(reader);
				if (!serviceQNameList.isEmpty()) {
					serviceNameCombo.removeAll();
					for (int i = 0; i < serviceQNameList.size(); i++) {
						// add the local part of the
						QName serviceQnameInstance = serviceQNameList.get(0);
						serviceNameCombo.add(serviceQnameInstance
								.getLocalPart());
					}
					;
					// select the first one as the default
					serviceNameCombo.select(0);

					// load the ports
					loadPortNames();

				} else {
					// service name list being empty means we are switching to
					// the interface mode
					if (serviceNameCombo != null)
						serviceNameCombo.removeAll();
					if (portNameCombo != null)
						portNameCombo.removeAll();

				}

				populatePackageName();
				loadNamespaces(WSDLUtils.getDefinitionNamespaceMap(reader));
			}
            }
			else if (wsdlVersion == WSDL2Utils.WSDL_VERSION_20) {
				isWSDL20 = true;
				populateParamsFromWSDL2(lname);
			}
			setErrorMessage(null);
			setPageComplete(true);
		} catch (Exception e) {
			setErrorMessage("Invalid wsdl file");
			setPageComplete(false);
		}
	}

	/**
	 * get the default package derived by the targetNamespace
	 */
	public String packageFromTargetNamespace(Definition definition){
			return URLProcessor.makePackageName(definition.getTargetNamespace());
	}
	private void populatePackageName() {
		this.packageText.setText(packageFromTargetNamespace(reader));
	}

	private void loadPortNames() {
		int selectionIndex = serviceNameCombo.getSelectionIndex();
		if (selectionIndex != -1) {
			List<String> ports = WSDLUtils.getPortNameList(reader,serviceQNameList
					.get(selectionIndex));
			if (!ports.isEmpty()) {
				portNameCombo.removeAll();
				portNameCombo.add("Generate all");
				for (int i = 0; i < ports.size(); i++) {
					// add the local part of the
					portNameCombo.add(ports.get(i).toString());
				}
				portNameCombo.select(0);
			} else {
				// error no ports found
			}
		}
	}

	/**
	 * Loads the namespaces
	 *
	 * @param namespaceMap
	 */
	private void loadNamespaces(Map namespaceMap) {
		Iterator namespaces = namespaceMap.values().iterator();
		namespace2packageTable.removeAll();
		TableItem[] items = new TableItem[namespaceMap.size()]; // An item for
																// each field

		int i = 0;
		while (namespaces.hasNext()) {

			items[i] = new TableItem(namespace2packageTable, SWT.NULL);
			String namespace = (String) namespaces.next();
			items[i].setText(0, namespace);
			items[i].setText(1, getPackageFromNamespace(namespace));
			i++;
		}

		namespace2packageTable.setVisible(true);

	}

	/**
	 * get the package derived by Namespace
	 */
	public String getPackageFromNamespace(String namespace) {
		String stringReturn = null;
		try {
			stringReturn = URLProcessor.makePackageName(namespace);
		} catch (SecurityException e) {
			log.error(e);
		}
		return stringReturn;

	}

	public void update() {
		if(!isDataPopulated){
			populateParamsFromWSDL();
			populateModel();
			isDataPopulated = true;
		}
	}
	
	public void populateParamsFromWSDL2(String url) throws Exception{
		Map<String,String> namespaces = new HashMap<String, String>();
		Description description = WSDL2Utils.getDescription(url);
		DescriptionElement desElement = (DescriptionElement)description;
		NamespaceDeclaration[] declaredNamespaces = desElement.getDeclaredNamespaces();
		for (NamespaceDeclaration ns : declaredNamespaces) {
			namespaces.put(ns.getPrefix(), ns.getNamespaceURI().toString());
		}
		Service[] services = description.getServices();
		serviceNameCombo.removeAll();
		for (int i = 0; i < services.length; i++) {
			Service service = services[i];
			String localPart = service.getName().getLocalPart();
			serviceNameCombo.add(localPart,i);
			serviceNameCombo.setData(localPart, service);
			
		}
		serviceNameCombo.select(0);
		loadEndPointNames(); 
		packageText.setText(URLProcessor.makePackageName(desElement
				.getTargetNamespace().toString()));
		loadNamespaces(namespaces);
		populateModel();
	}
	
	private void loadEndPointNames() {
		int selectionIndex = serviceNameCombo.getSelectionIndex();
		if (selectionIndex != -1) {
			portNameCombo.removeAll();
			portNameCombo.add("Generate all");
			Object obj = serviceNameCombo.getData(serviceNameCombo.getItem(selectionIndex));
			if(obj instanceof Service){
				Service service = (Service) obj;
				Endpoint[] endpoints = service.getEndpoints();
		        for(Endpoint ePoint:endpoints){
		        	portNameCombo.add(ePoint.getName().toString());
		        }
			}
			portNameCombo.select(0);
		}
	}

	
	public boolean canFlipToNextPage() {
		
		return false;
	}
}
