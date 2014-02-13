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
import org.wso2.carbon.cep.core.Expression;
import org.wso2.carbon.cep.core.Query;
import org.wso2.carbon.cep.core.internal.util.CEPConstants;
import org.wso2.carbon.cep.core.mapping.output.Output;

import org.wso2.carbon.cep.core.mapping.output.mapping.MapOutputMapping;
import org.wso2.carbon.cep.core.mapping.output.mapping.TextOutputMapping;
import org.wso2.carbon.cep.core.mapping.output.mapping.TupleOutputMapping;
import org.wso2.carbon.cep.core.mapping.output.mapping.XMLOutputMapping;
import org.wso2.carbon.cep.core.mapping.output.property.MapOutputProperty;
import org.wso2.carbon.cep.core.mapping.output.property.TupleOutputProperty;

public class QueryDialog extends TitleAreaDialog {
	private String qname = "";

	private String queryBroker = "";
	private String selectedMethod = "";
	private String qExpression = "";

	private String oTopic = "";
	private String sXMLMapping = "";
	private String sTextMapping = "";
	private String mapName = "";
	private String valueOf = "";
	private String selectedXMLFieldType = CEPConstants.CEP_CONF_XML_FIELD_TYPE_ELEMENT;
	private String xmlFieldName = "";

	private String[] methods = { CEPConstants.CEP_CONF_ELE_XML_MAPPING,
			CEPConstants.CEP_CONF_ELE_MAP_MAPPING,
			CEPConstants.CEP_CONF_ELE_TUPLE_MAPPING,
			CEPConstants.CEP_CONF_ELE_TEXT_MAPPING };
	private String[] xmlFieldTypes = {
			CEPConstants.CEP_CONF_XML_FIELD_TYPE_ELEMENT,
			CEPConstants.CEP_CONF_XML_FIELD_TYPE_ATTRIBUTE };
	private boolean editPage = false;
	private boolean exceedCount = false;
	private boolean exceedCountMedtadata = false;
	private boolean exceedCountCorrelationData = false;
	private boolean exceedCountPayloadData = false;
	private boolean isPageCanceled = false;

	private int count;
	private int countMetadata;
	private int countCorrelationData;
	private int countPayloadData;
	private List<MapOutputProperty> mapProperty = new ArrayList<MapOutputProperty>();
	private List<TupleOutputProperty> tupleMetadataProperty = new ArrayList<TupleOutputProperty>();
	private List<TupleOutputProperty> tupleCorrelationProperty = new ArrayList<TupleOutputProperty>();
	private List<TupleOutputProperty> tuplePayloadProperty = new ArrayList<TupleOutputProperty>();
	private Map<String, String> mapQuery = new HashMap<String, String>();
	private Map<String, String> mapMetadata = new HashMap<String, String>();
	private Map<String, String> mapCorrelationdata = new HashMap<String, String>();
	private Map<String, String> mapPayloaddata = new HashMap<String, String>();
	private Text name;
	private Text expression;

	private Text topic;

	private Text xmlMapping;
	private Text textMapping;
	private Text brokerName;

	private CTabFolder tabFolder;
	private CTabItem tXMLMap;
	private CTabItem tText;
	private CTabItem tMap;
	private CTabItem tTuple;
	private TableViewer tableQuery;
	private TableViewer tableTupleMetadata;
	private TableViewer tableTupleCorrelationdata;
	private TableViewer tableTuplePayloaddata;

	private Table table;
	private Table tableMetadata;
	private Table tableCorrelationdata;
	private Table tablePayloaddata;

	private Button edit;
	private Button add;
	private Button delete;
	private Button editMetadata;
	private Button addMetadata;
	private Button deleteMetadata;
	private Button editCorreltaionData;
	private Button addCorrelationData;
	private Button deleteCorrelationData;
	private Button editPayloadData;
	private Button addPayloadData;
	private Button deletePayloadData;
	private Query query;

	@Override
	public void create() {

		super.create();
		setTitle("Query Configuration");
		setMessage("");
	}

	public QueryDialog(Shell parentShell, boolean edit) {
		super(parentShell);
		editPage = edit;
		MapOutputProperty empty = new MapOutputProperty("", "");
		TupleOutputProperty emptyOut = new TupleOutputProperty("", "", "");
		tupleMetadataProperty.add(emptyOut);
		tupleMetadataProperty.add(emptyOut);
		tupleCorrelationProperty.add(emptyOut);
		tupleCorrelationProperty.add(emptyOut);
		tuplePayloadProperty.add(emptyOut);
		tuplePayloadProperty.add(emptyOut);
		mapProperty.add(empty);
		mapProperty.add(empty);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridData grData = null;
		final Composite containerInit = (Composite) super
				.createDialogArea(parent);
		GridLayout layoutInit = new GridLayout();
		containerInit.setLayout(layoutInit);

		final ScrolledComposite scrolledContainer = new ScrolledComposite(
				containerInit, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);

		scrolledContainer.setMinSize(800, 500);
		scrolledContainer.setExpandHorizontal(true);
		scrolledContainer.setExpandVertical(true);
		scrolledContainer.setAlwaysShowScrollBars(true);

		final Composite container = new Composite(scrolledContainer,
				SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		scrolledContainer.setContent(container);
		grData = new GridData();
		grData.grabExcessHorizontalSpace = true;
		grData.grabExcessVerticalSpace = true;
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		container.setLayoutData(grData);
		layout.numColumns = 2;
		layout.marginHeight = 10;

		Label lbName = new Label(container, SWT.NULL);
		lbName.setText("Name*");
		name = new Text(container, SWT.BORDER | SWT.SINGLE);
		name.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		name.setText(qname);
		name.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				if (name.getText().trim().equals("")) {
					getButton(OK).setEnabled(false);
				} else {
					getButton(OK).setEnabled(true);
				}
			}
		});

		final Label lblExpression = new Label(container, SWT.NULL);
		lblExpression.setText("Expression");
		expression = new Text(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		expression.setLayoutData(new GridData(GridData.FILL_HORIZONTAL, 100));
		expression.setText(qExpression);

		Label lbTopic = new Label(container, SWT.NULL);
		lbTopic.setText("Output Topic");
		topic = new Text(container, SWT.BORDER | SWT.SINGLE);
		topic.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		topic.setText(oTopic);
		Label lbBrokerName = new Label(container, SWT.NULL);
		lbBrokerName.setText("Broker Name");
		brokerName = new Text(container, SWT.BORDER | SWT.SINGLE);
		brokerName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		brokerName.setText(queryBroker);
		Label lbMethod = new Label(container, SWT.NULL);
		lbMethod.setText("Output Mapping");

		tabFolder = new CTabFolder(container, SWT.NULL);
		tabFolder.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		tXMLMap = new CTabItem(tabFolder, SWT.NULL);
		tXMLMap.setText("XML Mapping");
		xmlMapping = new Text(tabFolder, SWT.BORDER | SWT.MULTI);
		tXMLMap.setControl(xmlMapping);
		xmlMapping.setLayoutData(new GridData(GridData.FILL_HORIZONTAL, 200));
		xmlMapping.setText(sXMLMapping);
		
		tText = new CTabItem(tabFolder, SWT.NULL);
		tText.setText("Text Mapping");
		textMapping = new Text(tabFolder, SWT.BORDER | SWT.MULTI);
		tText.setControl(textMapping);
		textMapping.setLayoutData(new GridData(GridData.FILL_HORIZONTAL, 200));
		textMapping.setText(sTextMapping);
		
		tMap = new CTabItem(tabFolder, SWT.NULL);
		tMap.setText("Map Mapping");
		tTuple = new CTabItem(tabFolder, SWT.NULL);
		tTuple.setText("Tuple Mapping");
		tabFolder.setSelection(tTuple);

		if (getSelectedMethod().equals(CEPConstants.CEP_CONF_ELE_XML_MAPPING)) {
			tabFolder.setSelection(tXMLMap);
		} else if (getSelectedMethod().equals(
				CEPConstants.CEP_CONF_ELE_MAP_MAPPING)) {
			tabFolder.setSelection(tMap);
		} else if (getSelectedMethod().equals(
				CEPConstants.CEP_CONF_ELE_TEXT_MAPPING)) {
			tabFolder.setSelection(tText);
		} else if (getSelectedMethod().equals(
				CEPConstants.CEP_CONF_ELE_TUPLE_MAPPING)) {
			tabFolder.setSelection(tTuple);
		}

		GridLayout tabLayout = new GridLayout();
		tabLayout.numColumns = 3;
		Composite tabComposite = new Composite(tabFolder, SWT.BORDER);
		tabComposite.setLayout(tabLayout);
		tableQuery = new TableViewer(tabComposite, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		table = tableQuery.getTable();
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		grData.verticalSpan = 3;
		table.setLayoutData(grData);

		add = new Button(tabComposite, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		add.setLayoutData(grData);
		edit = new Button(tabComposite, SWT.NONE);
		edit.setLayoutData(grData);
		delete = new Button(tabComposite, SWT.NONE);
		delete.setLayoutData(grData);

		add.setText("Add...");
		add.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				QueryMapPropertyDialog dialog = new QueryMapPropertyDialog(
						getParentShell());
				dialog.create();
				if (dialog.open() == Window.OK) {
					MapOutputProperty property = dialog.getProperty();
					setMapName(property.getName());

					for (int k = 0; k < mapProperty.size(); k++) {
						if (mapProperty.get(k).getName().equals(getMapName())) {
							already = true;
						}
					}
					setValueOf(property.getValueOf());

					if (!editPage && !already) {
						if (count < 2 && !exceedCount) {
							mapProperty.remove(count);

							mapProperty.add(count, property);
							mapQuery.put(getMapName(), getValueOf());
							count++;
						} else {

							mapProperty.add(property);
							mapQuery.put(getMapName(), getValueOf());

						}
					} else if (editPage && !already) {
						int counting = 0;
						if (mapProperty.size() > 0) {
							while (mapProperty.get(0).getName().equals("")) {
								counting++;
								mapProperty.remove(0);
								if (counting == 2) {
									break;
								}
							}

						}

						mapProperty.add(property);
						mapQuery.put(getMapName(), getValueOf());

					}

					tableQuery.setContentProvider(ArrayContentProvider
							.getInstance());
					tableQuery.setInput(mapProperty.toArray());
					tableQuery.refresh();

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		setQueryTable(tabComposite, mapProperty);
		tMap.setControl(tabComposite);
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
		edit.setText("Edit...");
		edit.setEnabled(false);
		edit.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				int selectedIndex = table.getSelectionIndex();
				MapOutputProperty property = mapProperty.get(selectedIndex);
				QueryMapPropertyDialog dialog = new QueryMapPropertyDialog(
						getParentShell());
				dialog.initializePage(property);
				dialog.create();
				if (dialog.open() == Window.OK) {
					MapOutputProperty newProperty = dialog.getProperty();
					mapProperty.remove(selectedIndex);
					mapQuery.put(newProperty.getName(),
							newProperty.getValueOf());
					mapProperty.add(selectedIndex, newProperty);
					tableQuery.setContentProvider(ArrayContentProvider
							.getInstance());
					tableQuery.setInput(mapProperty.toArray());
					tableQuery.refresh();
					edit.setEnabled(false);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		delete.setText("Delete");
		delete.setEnabled(false);
		delete.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (count < 2 && !exceedCount && !editPage) {
					mapProperty.remove(0);
				}
				exceedCount = true;

				mapQuery.remove(mapProperty.get(table.getSelectionIndex())
						.getName());
				mapProperty.remove(table.getSelectionIndex());
				tableQuery.setContentProvider(ArrayContentProvider
						.getInstance());
				tableQuery.setInput(mapProperty.toArray());
				tableQuery.refresh();

				delete.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		GridLayout tabLayoutTuple = new GridLayout();
		tabLayoutTuple.numColumns = 3;
		Composite tabCompositeTuple = new Composite(tabFolder, SWT.BORDER);

		tabCompositeTuple.setLayout(tabLayoutTuple);
		Label lbMetadata = new Label(tabCompositeTuple, SWT.NULL);
		lbMetadata.setText("Meta Data");

		GridData grDataOne = new GridData(GridData.FILL_HORIZONTAL);
		grDataOne.verticalSpan = 3;
		lbMetadata.setLayoutData(grDataOne);
		tableTupleMetadata = new TableViewer(tabCompositeTuple, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tableMetadata = tableTupleMetadata.getTable();
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		grData.verticalSpan = 3;
		tableMetadata.setLayoutData(grData);

		addMetadata = new Button(tabCompositeTuple, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		addMetadata.setLayoutData(grData);

		editMetadata = new Button(tabCompositeTuple, SWT.NONE);
		editMetadata.setLayoutData(grData);
		deleteMetadata = new Button(tabCompositeTuple, SWT.NONE);
		deleteMetadata.setLayoutData(grData);

		addMetadata.setText("Add...");
		addMetadata.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				QueryTuplePropertyDialog dialog = new QueryTuplePropertyDialog(
						getParentShell(), "Metadata Configuration");
				dialog.create();
				if (dialog.open() == Window.OK) {
					TupleOutputProperty property = dialog.getProperty();

					for (TupleOutputProperty tuple : tupleMetadataProperty) {
						if (tuple.getName().equals(property.getName())) {
							already = true;
						}
					}

					if (!editPage && !already) {
						if (countMetadata < 2 && !exceedCountMedtadata) {
							tupleMetadataProperty.remove(countMetadata);

							tupleMetadataProperty.add(countMetadata, property);
							mapMetadata.put(
									property.getName(),
									property.getValueOf() + "|"
											+ property.getType());
							countMetadata++;
						} else {

							tupleMetadataProperty.add(property);
							mapMetadata.put(
									property.getName(),
									property.getValueOf() + "|"
											+ property.getType());

						}
					} else if (editPage && !already) {
						int counting = 0;
						if (tupleMetadataProperty.size() > 0) {
							while (tupleMetadataProperty.get(0).getName()
									.equals("")) {
								counting++;
								tupleMetadataProperty.remove(0);
								if (counting == 2) {
									break;
								}
							}

						}

						tupleMetadataProperty.add(property);
						mapMetadata.put(
								property.getName(),
								property.getValueOf() + "|"
										+ property.getType());

					}

					tableTupleMetadata.setContentProvider(ArrayContentProvider
							.getInstance());
					tableTupleMetadata.setInput(tupleMetadataProperty.toArray());
					tableTupleMetadata.refresh();

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		setTuplePropertyTable(tabCompositeTuple, tupleMetadataProperty,
				tableMetadata, tableTupleMetadata);
		tTuple.setControl(tabCompositeTuple);
		tableMetadata.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				deleteMetadata.setEnabled(true);
				editMetadata.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editMetadata.setText("Edit...");
		editMetadata.setEnabled(false);
		editMetadata.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				int selectedIndex = tableMetadata.getSelectionIndex();
				TupleOutputProperty property = tupleMetadataProperty
						.get(selectedIndex);
				QueryTuplePropertyDialog dialog = new QueryTuplePropertyDialog(
						getParentShell(), "Metadata Configuration");
				dialog.initializePage(property);
				dialog.create();
				if (dialog.open() == Window.OK) {
					TupleOutputProperty newProperty = dialog.getProperty();
					tupleMetadataProperty.remove(selectedIndex);
					mapMetadata.put(
							newProperty.getName(),
							newProperty.getValueOf() + "|"
									+ newProperty.getType());
					tupleMetadataProperty.add(selectedIndex, newProperty);
					tableTupleMetadata.setContentProvider(ArrayContentProvider
							.getInstance());
					tableTupleMetadata.setInput(tupleMetadataProperty.toArray());
					tableTupleMetadata.refresh();
					editMetadata.setEnabled(false);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		deleteMetadata.setText("Delete");
		deleteMetadata.setEnabled(false);
		deleteMetadata.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (countMetadata < 2 && !exceedCountMedtadata && !editPage) {
					tupleMetadataProperty.remove(0);
				}
				exceedCountMedtadata = true;

				mapMetadata.remove(tupleMetadataProperty.get(
						tableMetadata.getSelectionIndex()).getName());
				tupleMetadataProperty.remove(tableMetadata.getSelectionIndex());
				tableTupleMetadata.setContentProvider(ArrayContentProvider
						.getInstance());
				tableTupleMetadata.setInput(tupleMetadataProperty.toArray());
				tableTupleMetadata.refresh();

				deleteMetadata.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		Label lbCorrelation = new Label(tabCompositeTuple, SWT.NULL);
		lbCorrelation.setText("Correlation");

		lbCorrelation.setLayoutData(grDataOne);
		tableTupleCorrelationdata = new TableViewer(tabCompositeTuple,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
						| SWT.BORDER);
		tableCorrelationdata = tableTupleCorrelationdata.getTable();
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		grData.verticalSpan = 3;
		tableCorrelationdata.setLayoutData(grData);

		addCorrelationData = new Button(tabCompositeTuple, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		addCorrelationData.setLayoutData(grData);
		editCorreltaionData = new Button(tabCompositeTuple, SWT.NONE);
		editCorreltaionData.setLayoutData(grData);
		deleteCorrelationData = new Button(tabCompositeTuple, SWT.NONE);
		deleteCorrelationData.setLayoutData(grData);

		addCorrelationData.setText("Add...");
		addCorrelationData.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				QueryTuplePropertyDialog dialog = new QueryTuplePropertyDialog(
						getParentShell(), "Correlation Data Configuration");
				dialog.create();
				if (dialog.open() == Window.OK) {
					TupleOutputProperty property = dialog.getProperty();

					for (TupleOutputProperty tuple : tupleCorrelationProperty) {
						if (tuple.getName().equals(property.getName())) {
							already = true;
						}
					}

					if (!editPage && !already) {
						if (countCorrelationData < 2
								&& !exceedCountCorrelationData) {
							tupleCorrelationProperty
									.remove(countCorrelationData);

							tupleCorrelationProperty.add(countCorrelationData,
									property);
							mapCorrelationdata.put(
									property.getName(),
									property.getValueOf() + "|"
											+ property.getType());
							countCorrelationData++;
						} else {

							tupleCorrelationProperty.add(property);
							mapCorrelationdata.put(
									property.getName(),
									property.getValueOf() + "|"
											+ property.getType());

						}
					} else if (editPage && !already) {
						int counting = 0;
						if (tupleCorrelationProperty.size() > 0) {
							while (tupleCorrelationProperty.get(0).getName()
									.equals("")) {
								counting++;
								tupleCorrelationProperty.remove(0);
								if (counting == 2) {
									break;
								}
							}

						}

						tupleCorrelationProperty.add(property);
						mapCorrelationdata.put(
								property.getName(),
								property.getValueOf() + "|"
										+ property.getType());

					}

					tableTupleCorrelationdata
							.setContentProvider(ArrayContentProvider
									.getInstance());
					tableTupleCorrelationdata.setInput(tupleCorrelationProperty
							.toArray());
					tableTupleCorrelationdata.refresh();

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		setTuplePropertyTable(tabCompositeTuple, tupleCorrelationProperty,
				tableCorrelationdata, tableTupleCorrelationdata);
		tTuple.setControl(tabCompositeTuple);
		tableCorrelationdata.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				deleteCorrelationData.setEnabled(true);
				editCorreltaionData.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editCorreltaionData.setText("Edit...");
		editCorreltaionData.setEnabled(false);
		editCorreltaionData.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				int selectedIndex = tableCorrelationdata.getSelectionIndex();
				TupleOutputProperty property = tupleCorrelationProperty
						.get(selectedIndex);
				QueryTuplePropertyDialog dialog = new QueryTuplePropertyDialog(
						getParentShell(), "Correlation Data Configuration");
				dialog.initializePage(property);
				dialog.create();
				if (dialog.open() == Window.OK) {
					TupleOutputProperty newProperty = dialog.getProperty();
					tupleCorrelationProperty.remove(selectedIndex);
					mapCorrelationdata.put(
							newProperty.getName(),
							newProperty.getValueOf() + "|"
									+ newProperty.getType());
					tupleCorrelationProperty.add(selectedIndex, newProperty);
					tableTupleCorrelationdata
							.setContentProvider(ArrayContentProvider
									.getInstance());
					tableTupleCorrelationdata.setInput(tupleCorrelationProperty
							.toArray());
					tableTupleCorrelationdata.refresh();
					editCorreltaionData.setEnabled(false);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		deleteCorrelationData.setText("Delete");
		deleteCorrelationData.setEnabled(false);
		deleteCorrelationData.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (countCorrelationData < 2 && !exceedCountCorrelationData
						&& !editPage) {
					tupleCorrelationProperty.remove(0);
				}
				exceedCountCorrelationData = true;

				mapCorrelationdata.remove(tupleCorrelationProperty.get(
						tableCorrelationdata.getSelectionIndex()).getName());
				tupleCorrelationProperty.remove(tableCorrelationdata
						.getSelectionIndex());
				tableTupleCorrelationdata
						.setContentProvider(ArrayContentProvider.getInstance());
				tableTupleCorrelationdata.setInput(tupleCorrelationProperty
						.toArray());
				tableTupleCorrelationdata.refresh();

				deleteCorrelationData.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		Label lbPayload = new Label(tabCompositeTuple, SWT.NULL);
		lbPayload.setText("Payload Data");

		lbPayload.setLayoutData(grDataOne);
		tableTuplePayloaddata = new TableViewer(tabCompositeTuple, SWT.MULTI
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tablePayloaddata = tableTuplePayloaddata.getTable();
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 1;
		grData.verticalSpan = 3;
		tablePayloaddata.setLayoutData(grData);

		addPayloadData = new Button(tabCompositeTuple, SWT.NONE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		addPayloadData.setLayoutData(grData);
		editPayloadData = new Button(tabCompositeTuple, SWT.NONE);
		editPayloadData.setLayoutData(grData);
		deletePayloadData = new Button(tabCompositeTuple, SWT.NONE);
		deletePayloadData.setLayoutData(grData);

		addPayloadData.setText("Add...");
		addPayloadData.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean already = false;
				QueryTuplePropertyDialog dialog = new QueryTuplePropertyDialog(
						getParentShell(), "Payload Data Configuration");
				dialog.create();
				if (dialog.open() == Window.OK) {
					TupleOutputProperty property = dialog.getProperty();

					for (TupleOutputProperty tuple : tuplePayloadProperty) {
						if (tuple.getName().equals(property.getName())) {
							already = true;
						}
					}

					if (!editPage && !already) {
						if (countPayloadData < 2 && !exceedCountPayloadData) {
							tuplePayloadProperty.remove(countPayloadData);

							tuplePayloadProperty
									.add(countPayloadData, property);
							mapPayloaddata.put(
									property.getName(),
									property.getValueOf() + "|"
											+ property.getType());
							countPayloadData++;
						} else {

							tuplePayloadProperty.add(property);
							mapPayloaddata.put(
									property.getName(),
									property.getValueOf() + "|"
											+ property.getType());

						}
					} else if (editPage && !already) {
						int counting = 0;
						if (tuplePayloadProperty.size() > 0) {
							while (tuplePayloadProperty.get(0).getName()
									.equals("")) {
								counting++;
								tuplePayloadProperty.remove(0);
								if (counting == 2) {
									break;
								}
							}

						}

						tuplePayloadProperty.add(property);
						mapPayloaddata.put(
								property.getName(),
								property.getValueOf() + "|"
										+ property.getType());

					}

					tableTuplePayloaddata
							.setContentProvider(ArrayContentProvider
									.getInstance());
					tableTuplePayloaddata.setInput(tuplePayloadProperty
							.toArray());
					tableTuplePayloaddata.refresh();

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		setTuplePropertyTable(tabCompositeTuple, tuplePayloadProperty,
				tablePayloaddata, tableTuplePayloaddata);
		tTuple.setControl(tabCompositeTuple);
		tablePayloaddata.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				deletePayloadData.setEnabled(true);
				editPayloadData.setEnabled(true);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editPayloadData.setText("Edit...");
		editPayloadData.setEnabled(false);
		editPayloadData.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				int selectedIndex = tablePayloaddata.getSelectionIndex();
				TupleOutputProperty property = tuplePayloadProperty
						.get(selectedIndex);
				QueryTuplePropertyDialog dialog = new QueryTuplePropertyDialog(
						getParentShell(), "Payload Data Configuration");
				dialog.initializePage(property);
				dialog.create();
				if (dialog.open() == Window.OK) {
					TupleOutputProperty newProperty = dialog.getProperty();
					tuplePayloadProperty.remove(selectedIndex);
					mapPayloaddata.put(
							newProperty.getName(),
							newProperty.getValueOf() + "|"
									+ newProperty.getType());
					tuplePayloadProperty.add(selectedIndex, newProperty);
					tableTuplePayloaddata
							.setContentProvider(ArrayContentProvider
									.getInstance());
					tableTuplePayloaddata.setInput(tuplePayloadProperty
							.toArray());
					tableTuplePayloaddata.refresh();
					editPayloadData.setEnabled(false);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

		});

		deletePayloadData.setText("Delete");
		deletePayloadData.setEnabled(false);
		deletePayloadData.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (countPayloadData < 2 && !exceedCountPayloadData
						&& !editPage) {
					tuplePayloadProperty.remove(0);
				}
				exceedCountPayloadData = true;

				mapPayloaddata.remove(tuplePayloadProperty.get(
						tablePayloaddata.getSelectionIndex()).getName());
				tuplePayloadProperty.remove(tablePayloaddata
						.getSelectionIndex());
				tableTuplePayloaddata.setContentProvider(ArrayContentProvider
						.getInstance());
				tableTuplePayloaddata.setInput(tuplePayloadProperty.toArray());
				tableTuplePayloaddata.refresh();

				deletePayloadData.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		scrolledContainer.setMinSize(container.computeSize(SWT.SCROLL_PAGE,
				SWT.SCROLL_PAGE));
		container.layout();

		return containerInit;
	}

	private void setQueryTable(Composite container,
			List<MapOutputProperty> propertylist) {

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn viewerColumn = new TableViewerColumn(tableQuery,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof MapOutputProperty) {
					return ((MapOutputProperty) element).getName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.getColumn().setText("Name");

		TableViewerColumn viewerColumnFieldName = new TableViewerColumn(
				tableQuery, SWT.NONE, 1);
		viewerColumnFieldName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof MapOutputProperty) {
					return ((MapOutputProperty) element).getValueOf();
				} else
					return "";
			}
		});
		viewerColumnFieldName.getColumn().setWidth(200);
		viewerColumnFieldName.getColumn().setText("Value Of");

		tableQuery.setContentProvider(ArrayContentProvider.getInstance());
		tableQuery.setInput(propertylist.toArray());
		tableQuery.refresh();
	}

	private void setTuplePropertyTable(Composite container,
			List<TupleOutputProperty> propertyList, Table table,
			TableViewer tableViewer) {
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleOutputProperty) {
					return ((TupleOutputProperty) element).getName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(200);
		viewerColumn.getColumn().setText("Name");

		TableViewerColumn viewerColumnFieldName = new TableViewerColumn(
				tableViewer, SWT.NONE, 1);
		viewerColumnFieldName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleOutputProperty) {
					return ((TupleOutputProperty) element).getValueOf();
				} else
					return "";
			}
		});
		viewerColumnFieldName.getColumn().setWidth(200);
		viewerColumnFieldName.getColumn().setText("Value Of");
		TableViewerColumn viewerColumnType = new TableViewerColumn(tableViewer,
				SWT.NONE, 2);
		viewerColumnType.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof TupleOutputProperty) {
					return ((TupleOutputProperty) element).getType();
				} else
					return "";
			}
		});
		viewerColumnType.getColumn().setWidth(200);
		viewerColumnType.getColumn().setText("Type");

		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(propertyList.toArray());
		tableViewer.refresh();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	public boolean finalizePage() {
		boolean ok = true;
		query = new Query();
		query.setName(name.getText().trim());
		Expression expressionObject = new Expression();

		expressionObject.setText(expression.getText().trim());

		Output out = new Output();
		out.setTopic(topic.getText().trim());

		out.setBrokerName(brokerName.getText().trim());

		if (tabFolder.getSelection() == tXMLMap) {
			XMLOutputMapping xmlout = new XMLOutputMapping();
			xmlout.setMappingXMLText(xmlMapping.getText().trim());
			out.setOutputMapping(xmlout);
		} else if (tabFolder.getSelection() == tText) {
			TextOutputMapping textOut = new TextOutputMapping();
			textOut.setMappingText(textMapping.getText().trim());
			out.setOutputMapping(textOut);
		} else if (tabFolder.getSelection() == tMap) {
			MapOutputMapping mapMapping = new MapOutputMapping();

			List<MapOutputProperty> mapPropertList = new ArrayList<MapOutputProperty>();
			for (String key : mapQuery.keySet()) {
				MapOutputProperty mappop = new MapOutputProperty(key,
						mapQuery.get(key));

				mapPropertList.add(mappop);
			}
			if (mapPropertList.size() > 0) {
				mapMapping.setPropertyList(mapPropertList);

			}
			out.setOutputMapping(mapMapping);
		} else if (tabFolder.getSelection() == tTuple) {
			TupleOutputMapping tupleMapping = new TupleOutputMapping();
			List<TupleOutputProperty> metadataPropertList = new ArrayList<TupleOutputProperty>();
			for (String key : mapMetadata.keySet()) {
				String metaValueOf, metaType;
				metaValueOf = mapMetadata.get(key).substring(0,
						mapMetadata.get(key).indexOf("|"));
				metaType = mapMetadata.get(key).substring(
						mapMetadata.get(key).indexOf("|") + 1);
				TupleOutputProperty metaProperty = new TupleOutputProperty(key,
						metaValueOf, metaType);

				metadataPropertList.add(metaProperty);
			}
			List<TupleOutputProperty> correlationPropertList = new ArrayList<TupleOutputProperty>();
			for (String key : mapCorrelationdata.keySet()) {
				String metaValueOf, metaType;
				metaValueOf = mapCorrelationdata.get(key).substring(0,
						mapCorrelationdata.get(key).indexOf("|"));
				metaType = mapCorrelationdata.get(key).substring(
						mapCorrelationdata.get(key).indexOf("|") + 1);
				TupleOutputProperty metaProperty = new TupleOutputProperty(key,
						metaValueOf, metaType);

				correlationPropertList.add(metaProperty);
			}
			List<TupleOutputProperty> payLoadPropertList = new ArrayList<TupleOutputProperty>();
			for (String key : mapPayloaddata.keySet()) {
				String metaValueOf, metaType;
				metaValueOf = mapPayloaddata.get(key).substring(0,
						mapPayloaddata.get(key).indexOf("|"));
				metaType = mapPayloaddata.get(key).substring(
						mapPayloaddata.get(key).indexOf("|") + 1);
				TupleOutputProperty metaProperty = new TupleOutputProperty(key,
						metaValueOf, metaType);

				payLoadPropertList.add(metaProperty);
			}
			if (correlationPropertList.size() > 0
					|| metadataPropertList.size() > 0
					|| payLoadPropertList.size() > 0) {
				tupleMapping
						.setCorrelationDataProperties(correlationPropertList);
				tupleMapping.setMetaDataProperties(metadataPropertList);
				tupleMapping.setPayloadDataProperties(payLoadPropertList);

			}
			out.setOutputMapping(tupleMapping);
		}

		query.setOutput(out);
		query.setExpression(expressionObject);
		if (name.getText().trim().equals("")) {
			ok = false;
		}
		return ok;
	}

	public void initializePage(Query query) {

		setQname(query.getName());
		setQexpression(query.getExpression().getText());

		// There might be instances where an output mapping is not defined
		if (query.getOutput() != null) {
			setOtopic(query.getOutput().getTopic());
			setQueryBroker(query.getOutput().getBrokerName());

			if (query.getOutput().getOutputMapping() instanceof XMLOutputMapping) {
				setSelectedMethod(CEPConstants.CEP_CONF_ELE_XML_MAPPING);
				setSXMLMapping(((XMLOutputMapping) query.getOutput()
						.getOutputMapping()).getMappingXMLText());
			} else if (query.getOutput().getOutputMapping() instanceof TextOutputMapping) {
				setSelectedMethod(CEPConstants.CEP_CONF_ELE_TEXT_MAPPING);
				setsTextMapping(((TextOutputMapping) query.getOutput()
						.getOutputMapping()).getMappingText());
			} else if (query.getOutput().getOutputMapping() instanceof MapOutputMapping) {
				setSelectedMethod(CEPConstants.CEP_CONF_ELE_MAP_MAPPING);
				if (((MapOutputMapping) query.getOutput().getOutputMapping())
						.getPropertyList() != null) {
					mapProperty.remove(0);
					mapProperty.remove(0);
					List<MapOutputProperty> mapPropertyList = ((MapOutputMapping) query
							.getOutput().getOutputMapping()).getPropertyList();

					for (MapOutputProperty mapproperty : mapPropertyList) {

						mapProperty.add(mapproperty);
						mapQuery.put(mapproperty.getName(),
								mapproperty.getValueOf());
					}
				}
			} else if (query.getOutput().getOutputMapping() instanceof TupleOutputMapping) {
				setSelectedMethod(CEPConstants.CEP_CONF_ELE_TUPLE_MAPPING);
				if (((TupleOutputMapping) query.getOutput().getOutputMapping())
						.getMetaDataProperties() != null) {
					tupleMetadataProperty.remove(0);
					tupleMetadataProperty.remove(0);
					List<TupleOutputProperty> metadataPropertyList = ((TupleOutputMapping) query
							.getOutput().getOutputMapping())
							.getMetaDataProperties();
					for (TupleOutputProperty metaproperty : metadataPropertyList) {

						tupleMetadataProperty.add(metaproperty);
						mapMetadata.put(
								metaproperty.getName(),
								metaproperty.getValueOf() + "|"
										+ metaproperty.getType());
					}
				}

				if (((TupleOutputMapping) query.getOutput().getOutputMapping())
						.getCorrelationDataProperties() != null) {
					tupleCorrelationProperty.remove(0);
					tupleCorrelationProperty.remove(0);
					List<TupleOutputProperty> corrleationdataPropertyList = ((TupleOutputMapping) query
							.getOutput().getOutputMapping())
							.getCorrelationDataProperties();
					for (TupleOutputProperty metaproperty : corrleationdataPropertyList) {

						tupleCorrelationProperty.add(metaproperty);
						mapCorrelationdata.put(
								metaproperty.getName(),
								metaproperty.getValueOf() + "|"
										+ metaproperty.getType());
					}

				}

				if (((TupleOutputMapping) query.getOutput().getOutputMapping())
						.getPayloadDataProperties() != null) {
					tuplePayloadProperty.remove(0);
					tuplePayloadProperty.remove(0);
					List<TupleOutputProperty> payLoaddataPropertyList = ((TupleOutputMapping) query
							.getOutput().getOutputMapping())
							.getPayloadDataProperties();
					for (TupleOutputProperty metaproperty : payLoaddataPropertyList) {

						tuplePayloadProperty.add(metaproperty);
						mapPayloaddata.put(
								metaproperty.getName(),
								metaproperty.getValueOf() + "|"
										+ metaproperty.getType());
					}
				}

			}
		}

	}

	public String getQueryBroker() {
		return queryBroker;
	}

	public void setQueryBroker(String queryBroker) {
		this.queryBroker = queryBroker;
	}

	@Override
	protected void okPressed() {
		if (finalizePage()) {
			super.okPressed();
		} else {
			getButton(OK).setEnabled(false);

		}
	}

	public boolean isPageCanceled() {
		return isPageCanceled;
	}

	public void setPageCanceled(boolean isPageCanceled) {
		this.isPageCanceled = isPageCanceled;
	}

	public String getSelectedMethod() {
		return selectedMethod;
	}

	public void setSelectedMethod(String selectedMethod) {
		this.selectedMethod = selectedMethod;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	// TODO Refactor setters and getters to proper convention .. eg.
	// getQExpression()
	public String getQexpression() {
		return qExpression;
	}

	// TODO Refactor method name...
	public void setQexpression(String qexpression) {
		this.qExpression = qexpression;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String propertyName) {
		this.mapName = propertyName;
	}

	public String getSelectedXMLFieldType() {
		return selectedXMLFieldType;
	}

	public void setSelectedXMLFieldType(String selectedXMLFieldType) {
		this.selectedXMLFieldType = selectedXMLFieldType;
	}

	public String getXmlFieldName() {
		return xmlFieldName;
	}

	public void setXmlFieldName(String xmlFieldName) {
		this.xmlFieldName = xmlFieldName;
	}

	public String[] getMethods() {
		return methods;
	}

	public void setMethods(String[] methods) {
		this.methods = methods;
	}

	public String[] getXmlFieldTypes() {
		return xmlFieldTypes;
	}

	public void setXmlFieldTypes(String[] xmlFieldTypes) {
		this.xmlFieldTypes = xmlFieldTypes;
	}

	public String getOtopic() {
		return oTopic;
	}

	public void setOtopic(String otopic) {
		this.oTopic = otopic;
	}

	public String getSXMLMapping() {
		return sXMLMapping;
	}

	public void setSXMLMapping(String sXMLMapping) {
		this.sXMLMapping = sXMLMapping;
	}

	public Query getQueryObject() {
		return query;
	}

	public String getValueOf() {
		return valueOf;
	}

	public void setValueOf(String valueOf) {
		this.valueOf = valueOf;
	}

	public void setsTextMapping(String sTextMapping) {
		this.sTextMapping = sTextMapping;
	}

	public String getsTextMapping() {
		return sTextMapping;
	}
}
