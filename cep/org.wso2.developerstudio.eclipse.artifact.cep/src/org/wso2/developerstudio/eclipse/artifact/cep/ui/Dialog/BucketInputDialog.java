/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.cep.ui.Dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.wso2.carbon.cep.core.XpathDefinition;
import org.wso2.carbon.cep.core.internal.util.CEPConstants;
import org.wso2.carbon.cep.core.mapping.input.Input;
import org.wso2.carbon.cep.core.mapping.input.mapping.MapInputMapping;
import org.wso2.carbon.cep.core.mapping.input.mapping.TupleInputMapping;
import org.wso2.carbon.cep.core.mapping.input.mapping.XMLInputMapping;
import org.wso2.carbon.cep.core.mapping.input.property.MapInputProperty;
import org.wso2.carbon.cep.core.mapping.input.property.TupleInputProperty;
import org.wso2.carbon.cep.core.mapping.input.property.XMLInputProperty;

public class BucketInputDialog extends TitleAreaDialog {
	private String selectedBrokerName = "";
	private String xpathType;
	private String propertyName;
	private String xpath;
	private String type;
	private String prifix;

	private String sNamespace;
	private String iTopic = "";
	private String iStream = "";
	private String mapName = "";
	private String mapType = "";
	private String mapInputName = "";

	private String tupleName = "";
	private String tupleDataType = "";
	private String tupleType = "";
	private String tupleInputName = "";
	private String selectedInputMapping = CEPConstants.CEP_CONF_ELE_XML_MAPPING;

	private Map<String, String> xpathPrefixes = new HashMap<String, String>();
	private Map<String, String> properties = new HashMap<String, String>();
	private Map<String, String> mapProperties = new HashMap<String, String>();
	private Map<String, String> tupleProperties = new HashMap<String, String>();
	private Text topic;
	private Text txtStream;
	private Text cmbBroker;

	private Button add;
	private Button delete;
	private Button edit;
	private Button addproperty;
	private Button editproperty;
	private Button deleteproperty;
	private Button addMap;
	private Button editMap;
	private Button deleteMap;
	private Button addTuple;
	private Button deleteTuple;
	private Button editTuple;

	private Table table;
	private Table tableMapMapping;
	private Table tableTupleMapping;
	private Table TableProperty;
	private TableViewer viewer;
	private TableViewer viewerProperty;
	private TableViewer viewerMapProperty;
	private TableViewer viewerTupleProperty;
	private CTabFolder cTabFolder;
	private CTabItem cTabXMLMapping;
	private CTabItem cTabMapMapping;
	private CTabItem cTabTupleMapping;

	private List<XpathDefinition> xpathList = new ArrayList<XpathDefinition>();
	private List<XMLInputProperty> propertyList = new ArrayList<XMLInputProperty>();
	private List<TupleInputProperty> tuplePropertyList = new ArrayList<TupleInputProperty>();
	private List<MapInputProperty> mapPropertyList = new ArrayList<MapInputProperty>();
	private boolean isPageCanceled = false;
	private Input input;

	public BucketInputDialog(Shell shell, boolean edit) {
		super((Shell) shell);

		XpathDefinition initXpathDefinition = new XpathDefinition();
		XMLInputProperty initXMLProperty = new XMLInputProperty();
		TupleInputProperty initTupleProperty = new TupleInputProperty();
		MapInputProperty initMapProperty = new MapInputProperty();
		initXpathDefinition.setPrefix("");
		initXpathDefinition.setNamespace("");
		initXMLProperty.setName("");
		initXMLProperty.setXpath("");
		initXMLProperty.setType("");
		initTupleProperty.setName("");
		initTupleProperty.setType("");
		initTupleProperty.setInputName("");
		initTupleProperty.setInputDataType("");
		initMapProperty.setName("");
		initMapProperty.setType("");
		initMapProperty.setInputName("");
		xpathList.add(initXpathDefinition);
		xpathList.add(initXpathDefinition);
		xpathList.add(initXpathDefinition);
		xpathList.add(initXpathDefinition);
		propertyList.add(initXMLProperty);
		propertyList.add(initXMLProperty);
		propertyList.add(initXMLProperty);
		propertyList.add(initXMLProperty);
		tuplePropertyList.add(initTupleProperty);
		tuplePropertyList.add(initTupleProperty);
		tuplePropertyList.add(initTupleProperty);
		tuplePropertyList.add(initTupleProperty);
		mapPropertyList.add(initMapProperty);
		mapPropertyList.add(initMapProperty);
		mapPropertyList.add(initMapProperty);
		mapPropertyList.add(initMapProperty);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Input Configuration");
		setMessage("");

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridData grData = null;
		final ScrolledComposite scrolleContainer = new ScrolledComposite(
				parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		scrolleContainer.setMinSize(800, 500);
		scrolleContainer.setExpandHorizontal(true);
		scrolleContainer.setExpandVertical(true);
		scrolleContainer.setAlwaysShowScrollBars(true);
		final Composite container = new Composite(scrolleContainer, SWT.NONE);
		scrolleContainer.setContent(container);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.marginHeight = 10;

		Label lbTopic = new Label(container, SWT.NULL);
		lbTopic.setText("Topic*");
		topic = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		topic.setLayoutData(grData);
		topic.setText(iTopic);
		topic.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {

				if (topic.getText().trim().equals("")
						|| txtStream.getText().trim().equals("")) {

					getButton(OK).setEnabled(false);
				} else {
					getButton(OK).setEnabled(true);
				}

			}
		});
		Label lbBrokerName = new Label(container, SWT.NULL);
		lbBrokerName.setText("Broker Name");
		cmbBroker = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		cmbBroker.setLayoutData(grData);
		cmbBroker.setText(selectedBrokerName);
		Label lbStream = new Label(container, SWT.NULL);
		lbStream.setText("Stream*");
		txtStream = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		txtStream.setLayoutData(grData);
		txtStream.setText(iStream);
		txtStream.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {

				if (topic.getText().trim().equals("")
						|| txtStream.getText().trim().equals("")) {

					getButton(OK).setEnabled(false);
				} else {
					getButton(OK).setEnabled(true);
				}

			}
		});

		Label lbXpathPrefix = new Label(container, SWT.NULL);
		lbXpathPrefix.setText("Input Mapping");
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		cTabFolder = new CTabFolder(container, SWT.NULL);
		cTabFolder.setLayoutData(grData);
		cTabXMLMapping = new CTabItem(cTabFolder, SWT.NULL);
		cTabXMLMapping.setText("XML Mapping");
		cTabTupleMapping = new CTabItem(cTabFolder, SWT.NULL);
		cTabTupleMapping.setText("Tupple Mapping");
		cTabMapMapping = new CTabItem(cTabFolder, SWT.NULL);
		cTabMapMapping.setText("Map Mapping");
		if (getSelectedInputMapping().equals(
				CEPConstants.CEP_CONF_ELE_TUPLE_MAPPING)) {
			cTabFolder.setSelection(cTabTupleMapping);
		} else if (getSelectedInputMapping().equals(
				CEPConstants.CEP_CONF_ELE_XML_MAPPING)) {
			cTabFolder.setSelection(cTabXMLMapping);
		} else if (getSelectedInputMapping().equals(
				CEPConstants.CEP_CONF_ELE_MAP_MAPPING)) {
			cTabFolder.setSelection(cTabMapMapping);
		}
		GridLayout tabLayout = new GridLayout();
		tabLayout.numColumns = 3;
		Composite tabComposite = new Composite(cTabFolder, SWT.BORDER);
		tabComposite.setLayout(tabLayout);
		Composite tabCompositeTuple = new Composite(cTabFolder, SWT.BORDER);
		tabCompositeTuple.setLayout(tabLayout);
		Composite tabCompositeMap = new Composite(cTabFolder, SWT.BORDER);
		tabCompositeMap.setLayout(tabLayout);
		Label lbXpathPrefixes = new Label(tabComposite, SWT.NULL);
		lbXpathPrefixes.setText("Xpath Prefixes");
		Label lbemptyOne = new Label(tabComposite, SWT.NULL);
		lbemptyOne.setText("");

		setInputTable(tabComposite, xpathList);
		add = new Button(tabComposite, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		add.setLayoutData(grData);
		add.setText("Add...");
		add.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				boolean allfilled = false;
				XpathPrefixeDialog xpathPrefix = new XpathPrefixeDialog(
						getParentShell(), false);
				xpathPrefix.create();
				XpathDefinition definition = null;
				if (xpathPrefix.open() == Window.OK) {
					definition = xpathPrefix.getXpathPrefix();

					for (XpathDefinition xpathDefinition : xpathList) {
						if (xpathDefinition.getPrefix().equals(
								definition.getPrefix())) {
							already = true;
						}
					}
					if (!already) {
						setPrifix(definition.getPrefix());
						setSnameSpace(definition.getNamespace());
						xpathPrefixes.put(getPrifix(), getSnameSpace());
						int count = 0;
						for (XpathDefinition xdef : xpathList) {
							count++;
							if (xdef.getPrefix().equals("")) {
								int index = xpathList.indexOf(xdef);
								xpathList.remove(index);
								xpathList.add(index, definition);
								allfilled = false;
								break;
							}
							if (count == xpathList.size()) {
								allfilled = true;
							}
						}
						if (allfilled) {
							xpathList.add(definition);
						}
					}
					viewer.setContentProvider(ArrayContentProvider
							.getInstance());
					viewer.setInput(xpathList.toArray());
					viewer.refresh();
					table.redraw();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		edit = new Button(tabComposite, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		edit.setLayoutData(grData);
		edit.setText("Edit...");
		edit.setEnabled(false);
		edit.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int selectedIndex = table.getSelectionIndex();
				XpathDefinition xpathDefinitionEdit = xpathList
						.get(selectedIndex);
				XpathPrefixeDialog xpath = new XpathPrefixeDialog(getShell(),
						true);
				xpath.initializePage(xpathDefinitionEdit);
				xpath.create();
				if (xpath.open() == Window.OK) {
					xpathPrefixes.remove(xpathDefinitionEdit.getPrefix());
					xpathList.remove(selectedIndex);
					XpathDefinition definiton = xpath.getXpathPrefix();
					xpathList.add(selectedIndex, definiton);
					xpathPrefixes.put(definiton.getPrefix(),
							definiton.getNamespace());
				}
				edit.setEnabled(false);
				delete.setEnabled(false);
				viewer.setContentProvider(ArrayContentProvider.getInstance());
				viewer.setInput(xpathList.toArray());
				viewer.refresh();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		delete = new Button(tabComposite, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		delete.setLayoutData(grData);
		delete.setText("Delete");
		delete.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				xpathPrefixes.remove(xpathList.get(table.getSelectionIndex())
						.getPrefix());
				xpathList.remove(table.getSelectionIndex());
				delete.setEnabled(false);
				viewer.setContentProvider(ArrayContentProvider.getInstance());
				viewer.setInput(xpathList.toArray());
				viewer.refresh();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		delete.setEnabled(false);
		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				delete.setEnabled(true);
				edit.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		Label lbProperties = new Label(tabComposite, SWT.NULL);
		lbProperties.setText("Properties");
		Label lbempty = new Label(tabComposite, SWT.NULL);
		lbempty.setText("");
		setPropertyTable(tabComposite, propertyList);
		addproperty = new Button(tabComposite, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		addproperty.setLayoutData(grData);
		addproperty.setText("Add...");
		addproperty.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				boolean allfilled = false;
				InputPropertyDialog inputProperty = new InputPropertyDialog(
						getParentShell(), false);
				inputProperty.create();
				if (inputProperty.open() == Window.OK) {
					XMLInputProperty xmlProperty = inputProperty
							.getProperties();
					for (int k = 0; k < propertyList.size(); k++) {
						if (propertyList.get(k).getName()
								.equals(xmlProperty.getName())) {
							already = true;
						}
					}
					if (!already) {
						setPropertyName(xmlProperty.getName());
						setXpath(xmlProperty.getXpath());
						setType(xmlProperty.getType());
						String value = getXpath() + "|" + getType();
						properties.put(getPropertyName(), value);
						int count = 0;
						for (XMLInputProperty xProperty : propertyList) {
							count++;
							if (xProperty.getName().equals("")) {
								int index = propertyList.indexOf(xProperty);
								propertyList.remove(index);
								propertyList.add(index, xmlProperty);
								allfilled = false;
								break;
							}
							if (count == xpathList.size()) {
								allfilled = true;
							}
						}
						if (allfilled) {
							propertyList.add(xmlProperty);
						}
					}

				}
				viewerProperty.setContentProvider(ArrayContentProvider
						.getInstance());
				viewerProperty.setInput(propertyList.toArray());
				viewerProperty.refresh();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editproperty = new Button(tabComposite, SWT.NONE);
		editproperty.setText("Edit...");
		editproperty.setEnabled(false);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		editproperty.setLayoutData(grData);
		editproperty.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				int selectedIndex = TableProperty.getSelectionIndex();
				XMLInputProperty property = propertyList.get(selectedIndex);
				InputPropertyDialog dialog = new InputPropertyDialog(
						getParentShell(), true);
				dialog.initialize(property);
				dialog.create();
				if (dialog.open() == Window.OK) {

					properties.remove(property.getName());
					propertyList.remove(TableProperty.getSelectionIndex());

					XMLInputProperty newProperty = dialog.getProperties();
					propertyList.add(selectedIndex, newProperty);
					properties.put(
							newProperty.getName(),
							newProperty.getXpath() + "|"
									+ newProperty.getType());
					editproperty.setEnabled(false);
					deleteproperty.setEnabled(false);
					viewerProperty.setContentProvider(ArrayContentProvider
							.getInstance());
					viewerProperty.setInput(propertyList.toArray());
					viewerProperty.refresh();

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		deleteproperty = new Button(tabComposite, SWT.NONE);
		deleteproperty.setText("Delete");
		grData = new GridData(GridData.FILL_HORIZONTAL);
		deleteproperty.setLayoutData(grData);
		deleteproperty.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				properties.remove(propertyList.get(
						TableProperty.getSelectionIndex()).getName());
				propertyList.remove(TableProperty.getSelectionIndex());
				deleteproperty.setEnabled(false);
				viewerProperty.setContentProvider(ArrayContentProvider
						.getInstance());
				viewerProperty.setInput(propertyList.toArray());
				viewerProperty.refresh();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		deleteproperty.setEnabled(false);
		TableProperty.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				deleteproperty.setEnabled(true);
				editproperty.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		cTabXMLMapping.setControl(tabComposite);
		setMapMappingPropertyTable(tabCompositeMap, mapPropertyList);
		addMap = new Button(tabCompositeMap, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		addMap.setLayoutData(grData);
		addMap.setText("Add...");
		addMap.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				boolean allfilled = false;
				InputMapPropertyDialog inputMapPropertyDialog = new InputMapPropertyDialog(
						getParentShell(), false);
				inputMapPropertyDialog.create();
				MapInputProperty mapProperty = null;
				if (inputMapPropertyDialog.open() == Window.OK) {
					mapProperty = inputMapPropertyDialog.getProperties();

					for (MapInputProperty mapPropertObject : mapPropertyList) {
						if (mapPropertObject.getName().equals(
								mapProperty.getName())) {
							already = true;
						}
					}
					if (!already) {
						setMapName(mapProperty.getName());
						setMapType(mapProperty.getType());
						setMapInputName(mapProperty.getInputName());
						mapProperties.put(getMapName(), getMapType() + "|"
								+ getMapInputName());
						int count = 0;
						for (MapInputProperty mapPropertyObject : mapPropertyList) {
							count++;
							if (mapPropertyObject.getName().equals("")) {
								int index = mapPropertyList
										.indexOf(mapPropertyObject);
								mapPropertyList.remove(index);
								mapPropertyList.add(index, mapProperty);
								allfilled = false;
								break;
							}
							if (count == mapPropertyList.size()) {
								allfilled = true;
							}
						}
						if (allfilled) {
							mapPropertyList.add(mapProperty);
						}
					}
					viewerMapProperty.setContentProvider(ArrayContentProvider
							.getInstance());
					viewerMapProperty.setInput(mapPropertyList.toArray());
					viewerMapProperty.refresh();
					tableMapMapping.redraw();

				}
			}
		});

		editMap = new Button(tabCompositeMap, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		editMap.setLayoutData(grData);
		editMap.setText("Edit...");
		editMap.setEnabled(false);
		editMap.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int selectedIndex = tableMapMapping.getSelectionIndex();
				MapInputProperty mapProperty = mapPropertyList
						.get(selectedIndex);
				InputMapPropertyDialog mapPropertyDialog = new InputMapPropertyDialog(
						getShell(), true);
				mapPropertyDialog.initialize(mapProperty);
				mapPropertyDialog.create();
				if (mapPropertyDialog.open() == Window.OK) {
					mapProperties.remove(mapProperty.getName());
					mapPropertyList.remove(selectedIndex);
					MapInputProperty mProperty = mapPropertyDialog
							.getProperties();
					mapPropertyList.add(selectedIndex, mProperty);
					mapProperties.put(mProperty.getName(), mProperty.getType()
							+ "|" + mProperty.getInputName());
				}
				edit.setEnabled(false);
				delete.setEnabled(false);
				viewerMapProperty.setContentProvider(ArrayContentProvider
						.getInstance());
				viewerMapProperty.setInput(mapPropertyList.toArray());
				viewerMapProperty.refresh();

			}

		});
		deleteMap = new Button(tabCompositeMap, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		deleteMap.setLayoutData(grData);
		deleteMap.setText("Delete");
		deleteMap.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				mapProperties.remove(mapPropertyList.get(
						tableMapMapping.getSelectionIndex()).getName());
				mapPropertyList.remove(tableMapMapping.getSelectionIndex());
				deleteMap.setEnabled(false);
				viewerMapProperty.setContentProvider(ArrayContentProvider
						.getInstance());
				viewerMapProperty.setInput(xpathList.toArray());
				viewerMapProperty.refresh();

			}

		});
		deleteMap.setEnabled(false);
		tableMapMapping.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				deleteMap.setEnabled(true);
				editMap.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		cTabMapMapping.setControl(tabCompositeMap);
		setTupleMappingPropertyTable(tabCompositeTuple, tuplePropertyList);
		addTuple = new Button(tabCompositeTuple, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		addTuple.setLayoutData(grData);
		addTuple.setText("Add...");
		addTuple.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				boolean allfilled = false;
				InputTuplePropertyDialog inputTuplePropertyDialog = new InputTuplePropertyDialog(
						getParentShell(), false);
				inputTuplePropertyDialog.create();
				if (inputTuplePropertyDialog.open() == Window.OK) {
					TupleInputProperty tupleProperty = inputTuplePropertyDialog
							.getProperties();
					for (int k = 0; k < tuplePropertyList.size(); k++) {
						if (tuplePropertyList.get(k).getName()
								.equals(tupleProperty.getName())) {
							already = true;
						}
					}
					if (!already) {
						setTupleName(tupleProperty.getName());
						setTupleDataType(tupleProperty.getInputDataType());
						setTupleType(tupleProperty.getType());
						setTupleInputName(tupleProperty.getInputName());
						String value = getTupleDataType() + "|"
								+ getTupleType() + "|" + getTupleInputName();
						tupleProperties.put(getTupleName(), value);
						int count = 0;
						for (TupleInputProperty tuplePropertyObject : tuplePropertyList) {
							count++;
							if (tuplePropertyObject.getName().equals("")) {
								int index = tuplePropertyList
										.indexOf(tuplePropertyObject);
								tuplePropertyList.remove(index);
								tuplePropertyList.add(index, tupleProperty);
								allfilled = false;
								break;
							}
							if (count == tuplePropertyList.size()) {
								allfilled = true;
							}
						}
						if (allfilled) {
							tuplePropertyList.add(tupleProperty);
						}
					}

				}
				viewerTupleProperty.setContentProvider(ArrayContentProvider
						.getInstance());
				viewerTupleProperty.setInput(tuplePropertyList.toArray());
				viewerTupleProperty.refresh();

			}

		});

		editTuple = new Button(tabCompositeTuple, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		editTuple.setLayoutData(grData);
		editTuple.setText("Edit...");
		editTuple.setEnabled(false);
		editTuple.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int selectedIndex = tableTupleMapping.getSelectionIndex();
				TupleInputProperty tupleProperty = tuplePropertyList
						.get(selectedIndex);
				InputTuplePropertyDialog dialog = new InputTuplePropertyDialog(
						getParentShell(), true);
				dialog.initialize(tupleProperty);
				dialog.create();
				if (dialog.open() == Window.OK) {

					tupleProperties.remove(tupleProperty.getName());
					tuplePropertyList.remove(tableTupleMapping
							.getSelectionIndex());

					TupleInputProperty newTupleProperty = dialog
							.getProperties();
					tuplePropertyList.add(selectedIndex, newTupleProperty);
					tupleProperties.put(newTupleProperty.getName(),
							newTupleProperty.getInputDataType() + "|"
									+ newTupleProperty.getType() + "|"
									+ newTupleProperty.getInputName());
					editTuple.setEnabled(false);
					deleteTuple.setEnabled(false);
					viewerTupleProperty.setContentProvider(ArrayContentProvider
							.getInstance());
					viewerTupleProperty.setInput(tuplePropertyList.toArray());
					viewerTupleProperty.refresh();

				}
			}
		});
		deleteTuple = new Button(tabCompositeTuple, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		deleteTuple.setLayoutData(grData);
		deleteTuple.setText("Delete");
		deleteTuple.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				tupleProperties.remove(tuplePropertyList.get(
						tableTupleMapping.getSelectionIndex()).getName());
				tuplePropertyList.remove(tableTupleMapping.getSelectionIndex());
				deleteTuple.setEnabled(false);
				viewerTupleProperty.setContentProvider(ArrayContentProvider
						.getInstance());
				viewerTupleProperty.setInput(tuplePropertyList.toArray());
				viewerTupleProperty.refresh();

			}

		});
		deleteTuple.setEnabled(false);
		tableTupleMapping.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				deleteTuple.setEnabled(true);
				editTuple.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		cTabTupleMapping.setControl(tabCompositeTuple);

		scrolleContainer.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));
		container.layout();
		return super.createDialogArea(scrolleContainer);

	}

	public boolean finalizePage() {
		boolean ok = true;
		input = new Input();
		input.setTopic(topic.getText().trim());
		input.setBrokerName(cmbBroker.getText().trim());
		if (cTabFolder.getSelection() == cTabXMLMapping) {
			XMLInputMapping xmlMap = new XMLInputMapping();

			xmlMap.setStream(txtStream.getText().trim());
			List<XpathDefinition> xpathDefinitionList = new ArrayList<XpathDefinition>();
			for (String prefix : xpathPrefixes.keySet()) {
				XpathDefinition definition = new XpathDefinition();
				definition.setPrefix(prefix);
				definition.setNamespace(xpathPrefixes.get(prefix));
				xpathDefinitionList.add(definition);
			}
			List<XMLInputProperty> xmlProperty = new ArrayList<XMLInputProperty>();
			for (String pName : properties.keySet()) {
				XMLInputProperty property = new XMLInputProperty();
				property.setName(pName);
				String xpath, type;
				xpath = properties.get(pName).substring(0,
						properties.get(pName).indexOf("|"));
				type = properties.get(pName).substring(
						properties.get(pName).indexOf("|") + 1);
				property.setXpath(xpath);
				property.setType(type);
				xmlProperty.add(property);
			}

			xmlMap.setXpathDefinitionList(xpathDefinitionList);
			xmlMap.setProperties(xmlProperty);

			input.setInputMapping(xmlMap);
		} else if (cTabFolder.getSelection() == cTabMapMapping) {
			MapInputMapping mapInputMapping = new MapInputMapping();
			List<MapInputProperty> mapProperty = new ArrayList<MapInputProperty>();
			for (String name : mapProperties.keySet()) {
				MapInputProperty property = new MapInputProperty();
				property.setName(name);
				String type;
				String inputName;
				type = mapProperties.get(name).substring(0,
						mapProperties.get(name).indexOf("|"));
				inputName = mapProperties.get(name).substring(
						mapProperties.get(name).indexOf("|") + 1);
				property.setType(type);
				property.setInputName(inputName);
				mapProperty.add(property);
			}
			mapInputMapping.setProperties(mapProperty);
			mapInputMapping.setStream(txtStream.getText().trim());
			input.setInputMapping(mapInputMapping);
		} else if (cTabFolder.getSelection() == cTabTupleMapping) {
			TupleInputMapping tupleInputMapping = new TupleInputMapping();
			List<TupleInputProperty> tupleProperty = new ArrayList<TupleInputProperty>();
			for (String name : tupleProperties.keySet()) {
				TupleInputProperty property = new TupleInputProperty();
				property.setName(name);
				String dataType, type, inputName, typeName;
				dataType = tupleProperties.get(name).substring(0,
						tupleProperties.get(name).indexOf("|"));
				typeName = tupleProperties.get(name).substring(
						tupleProperties.get(name).indexOf("|") + 1);
				type = typeName.substring(0, typeName.indexOf("|"));
				inputName = typeName.substring(typeName.indexOf("|") + 1);
				property.setInputDataType(dataType);
				property.setType(type);
				property.setInputName(inputName);
				tupleProperty.add(property);
			}
			tupleInputMapping.setProperties(tupleProperty);
			tupleInputMapping.setStream(txtStream.getText().trim());
			input.setInputMapping(tupleInputMapping);

		}
		if (topic.getText().trim().equals("")
				|| txtStream.getText().trim().equals("")) {
			ok = false;
		}
		return ok;
	}

	public void initiatePage(Input input) {

		setItopic(input.getTopic());
		setSelectedBrokerName(input.getBrokerName());
		if (input.getInputMapping() instanceof XMLInputMapping) {
			setIstream(((XMLInputMapping) input.getInputMapping()).getStream());
		}
		if (input.getInputMapping() instanceof XMLInputMapping) {
			setSelectedInputMapping(CEPConstants.CEP_CONF_ELE_XML_MAPPING);
			if (((XMLInputMapping) input.getInputMapping())
					.getXpathDefinitionList() != null && ((XMLInputMapping) input.getInputMapping())
				.getXpathDefinitionList().size()>0) {
				
				xpathList = ((XMLInputMapping) input.getInputMapping())
						.getXpathDefinitionList();
				for (XpathDefinition xpathdefinition : xpathList) {
					xpathPrefixes.put(xpathdefinition.getPrefix(),
							xpathdefinition.getNamespace());
				}
			  
			}
			if (((XMLInputMapping) input.getInputMapping()).getProperties() != null && ((XMLInputMapping) input.getInputMapping()).getProperties().size()>0) {

				propertyList = ((XMLInputMapping) input.getInputMapping())
						.getProperties();
				for (XMLInputProperty xmlProperty : propertyList) {
					this.properties.put(
							xmlProperty.getName(),
							xmlProperty.getXpath() + "|"
									+ xmlProperty.getType());
				}
			}
		} else if (input.getInputMapping() instanceof MapInputMapping) {
			setSelectedInputMapping(CEPConstants.CEP_CONF_ELE_MAP_MAPPING);
			setIstream(input.getInputMapping().getStream());
			if (((MapInputMapping) input.getInputMapping()).getProperties() != null && ((MapInputMapping) input.getInputMapping()).getProperties().size()>0) {
				mapPropertyList = ((MapInputMapping) input.getInputMapping())
						.getProperties();
				for (MapInputProperty property : mapPropertyList) {
					mapProperties.put(property.getName(), property.getType()
							+ "|" + property.getInputName());
				}
			}
		} else if (input.getInputMapping() instanceof TupleInputMapping) {
			setSelectedInputMapping(CEPConstants.CEP_CONF_ELE_TUPLE_MAPPING);
			setIstream(input.getInputMapping().getStream());
			if (((TupleInputMapping) input.getInputMapping()).getProperties() != null && ((TupleInputMapping) input.getInputMapping()).getProperties().size() >0) {
				tuplePropertyList = ((TupleInputMapping) input
						.getInputMapping()).getProperties();
				for (TupleInputProperty property : tuplePropertyList) {
					tupleProperties.put(
							property.getName(),
							property.getInputDataType() + "|"
									+ property.getType() + "|"
									+ property.getInputName());
				}
			}

		}
	}

	public void setPageCanceld(boolean value) {
		isPageCanceled = value;
	}

	public boolean getPageCanceled() {
		return isPageCanceled;
	}

	public void setStream(String stream) {
		txtStream.setText(stream);
	}

	public Text getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic.setText(topic);
	}

	private void setInputTable(Composite container,
			List<XpathDefinition> xpathlist) {
		viewer = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData grTable = new GridData(GridData.FILL_HORIZONTAL);
		grTable.horizontalSpan = 2;
		grTable.verticalSpan = 3;
		table.setLayoutData(grTable);
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof XpathDefinition) {
					XpathDefinition p = (XpathDefinition) element;
					return p.getPrefix();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.getColumn().setText("prefix");
		TableViewerColumn viewerColumn1 = new TableViewerColumn(viewer,
				SWT.NONE, 1);
		viewerColumn1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof XpathDefinition) {
					XpathDefinition p = (XpathDefinition) element;
					return p.getNamespace();
				} else
					return "";
			}
		});
		viewerColumn1.getColumn().setWidth(200);
		viewerColumn1.getColumn().setText("Namespace");

		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setInput(xpathlist.toArray());

	}

	private void setPropertyTable(Composite container,
			List<XMLInputProperty> propertylist) {
		viewerProperty = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		TableProperty = viewerProperty.getTable();
		TableProperty.setHeaderVisible(true);
		TableProperty.setLinesVisible(true);
		GridData grtab = new GridData(GridData.FILL_HORIZONTAL);
		grtab.horizontalSpan = 2;
		grtab.verticalSpan = 3;
		TableProperty.setLayoutData(grtab);
		TableViewerColumn viewerColumn = new TableViewerColumn(viewerProperty,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof XMLInputProperty) {
					return ((XMLInputProperty) element).getName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.getColumn().setText("Name");

		TableViewerColumn viewerColumnXpath = new TableViewerColumn(
				viewerProperty, SWT.NONE, 1);
		viewerColumnXpath.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof XMLInputProperty) {
					return ((XMLInputProperty) element).getXpath();
				} else
					return "";
			}
		});
		viewerColumnXpath.getColumn().setWidth(200);
		viewerColumnXpath.getColumn().setText("Xpath");
		TableViewerColumn viewerColumnFieldName = new TableViewerColumn(
				viewerProperty, SWT.NONE, 2);
		viewerColumnFieldName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof XMLInputProperty) {
					return ((XMLInputProperty) element).getType();
				} else
					return "";
			}
		});
		viewerColumnFieldName.getColumn().setWidth(200);
		viewerColumnFieldName.getColumn().setText("Type");

		viewerProperty.setContentProvider(ArrayContentProvider.getInstance());
		viewerProperty.setInput(propertylist.toArray());

	}

	private void setMapMappingPropertyTable(Composite container,
			List<MapInputProperty> propertylist) {
		viewerMapProperty = new TableViewer(container, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tableMapMapping = viewerMapProperty.getTable();
		tableMapMapping.setHeaderVisible(true);
		tableMapMapping.setLinesVisible(true);
		GridData grtab = new GridData(GridData.FILL_HORIZONTAL);
		grtab.horizontalSpan = 2;
		grtab.verticalSpan = 3;
		tableMapMapping.setLayoutData(grtab);
		TableViewerColumn viewerColumn = new TableViewerColumn(
				viewerMapProperty, SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof MapInputProperty) {
					return ((MapInputProperty) element).getName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.getColumn().setText("Name");

		TableViewerColumn viewerColumnXpath = new TableViewerColumn(
				viewerMapProperty, SWT.NONE, 1);
		viewerColumnXpath.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof MapInputProperty) {
					return ((MapInputProperty) element).getInputName();
				} else
					return "";
			}
		});
		viewerColumnXpath.getColumn().setWidth(200);
		viewerColumnXpath.getColumn().setText("Input Name");
		TableViewerColumn viewerColumnFieldName = new TableViewerColumn(
				viewerMapProperty, SWT.NONE, 2);
		viewerColumnFieldName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof MapInputProperty) {
					return ((MapInputProperty) element).getType();
				} else
					return "";
			}
		});
		viewerColumnFieldName.getColumn().setWidth(200);
		viewerColumnFieldName.getColumn().setText("Type");

		viewerMapProperty
				.setContentProvider(ArrayContentProvider.getInstance());
		viewerMapProperty.setInput(propertylist.toArray());

	}

	private void setTupleMappingPropertyTable(Composite container,
			List<TupleInputProperty> propertylist) {
		viewerTupleProperty = new TableViewer(container, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tableTupleMapping = viewerTupleProperty.getTable();
		tableTupleMapping.setHeaderVisible(true);
		tableTupleMapping.setLinesVisible(true);
		GridData grtab = new GridData(GridData.FILL_HORIZONTAL);
		grtab.horizontalSpan = 2;
		grtab.verticalSpan = 3;
		tableTupleMapping.setLayoutData(grtab);
		TableViewerColumn viewerColumn = new TableViewerColumn(
				viewerTupleProperty, SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleInputProperty) {
					return ((TupleInputProperty) element).getName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.getColumn().setText("Name");

		TableViewerColumn viewerColumnXpath = new TableViewerColumn(
				viewerTupleProperty, SWT.NONE, 1);
		viewerColumnXpath.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleInputProperty) {
					return ((TupleInputProperty) element).getInputDataType();
				} else
					return "";
			}
		});
		viewerColumnXpath.getColumn().setWidth(200);
		viewerColumnXpath.getColumn().setText("DataType");
		TableViewerColumn viewerColumnInputName = new TableViewerColumn(
				viewerTupleProperty, SWT.NONE, 2);
		viewerColumnInputName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleInputProperty) {
					return ((TupleInputProperty) element).getInputName();
				} else
					return "";
			}
		});
		viewerColumnInputName.getColumn().setWidth(200);
		viewerColumnInputName.getColumn().setText("Input Name");

		TableViewerColumn viewerColumnFieldName = new TableViewerColumn(
				viewerTupleProperty, SWT.NONE, 3);
		viewerColumnFieldName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleInputProperty) {
					return ((TupleInputProperty) element).getType();
				} else
					return "";
			}
		});
		viewerColumnFieldName.getColumn().setWidth(200);
		viewerColumnFieldName.getColumn().setText("Type");

		viewerTupleProperty.setContentProvider(ArrayContentProvider
				.getInstance());
		viewerTupleProperty.setInput(propertylist.toArray());

	}

	@Override
	protected void okPressed() {
		if (finalizePage()) {
			super.okPressed();
		} else {
			getButton(OK).setEnabled(false);
		}

	}

	public String getPrifix() {
		return prifix;
	}

	public void setPrifix(String prifix) {
		this.prifix = prifix;
	}

	public String getSnameSpace() {
		return sNamespace;
	}

	public void setSnameSpace(String snameSpace) {
		sNamespace = snameSpace;
	}

	public String getItopic() {
		return iTopic;
	}

	public void setItopic(String itopic) {
		this.iTopic = itopic;
	}

	public String getIstream() {
		return iStream;
	}

	public void setIstream(String istream) {
		this.iStream = istream;
	}

	public String getSelectedBrokerName() {
		return selectedBrokerName;
	}

	public void setSelectedBrokerName(String selectedBrokerName) {
		this.selectedBrokerName = selectedBrokerName;
	}

	public String getXpathtype() {
		return xpathType;
	}

	public void setXpathtype(String xpathtype) {
		this.xpathType = xpathtype;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, String> getXpathPrefixes() {
		return xpathPrefixes;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public Input getInput() {
		return input;
	}

	public String getSelectedInputMapping() {
		return selectedInputMapping;
	}

	public void setSelectedInputMapping(String selectedInputMapping) {
		this.selectedInputMapping = selectedInputMapping;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public String getTupleName() {
		return tupleName;
	}

	public void setTupleName(String tupleName) {
		this.tupleName = tupleName;
	}

	public String getTupleDataType() {
		return tupleDataType;
	}

	public void setTupleDataType(String tupleDataType) {
		this.tupleDataType = tupleDataType;
	}

	public String getTupleType() {
		return tupleType;
	}

	public void setTupleType(String tupleType) {
		this.tupleType = tupleType;
	}

	public String getMapInputName() {
		return mapInputName;
	}

	public void setMapInputName(String mapInputName) {
		this.mapInputName = mapInputName;
	}

	public String getTupleInputName() {
		return tupleInputName;
	}

	public void setTupleInputName(String tupleInputName) {
		this.tupleInputName = tupleInputName;
	}

}
