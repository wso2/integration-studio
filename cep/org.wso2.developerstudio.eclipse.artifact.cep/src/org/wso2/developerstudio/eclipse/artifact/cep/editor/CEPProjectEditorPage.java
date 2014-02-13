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

package org.wso2.developerstudio.eclipse.artifact.cep.editor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.w3c.dom.Document;
import org.wso2.carbon.cep.core.Bucket;
import org.wso2.carbon.cep.core.Query;
import org.wso2.carbon.cep.core.exception.CEPConfigurationException;
import org.wso2.carbon.cep.core.internal.config.BucketHelper;
import org.wso2.carbon.cep.core.mapping.input.Input;
import org.wso2.developerstudio.eclipse.artifact.cep.Activator;
import org.wso2.developerstudio.eclipse.artifact.cep.model.EngineProviderPropertyModel;
import org.wso2.developerstudio.eclipse.artifact.cep.ui.Dialog.BucketInputDialog;
import org.wso2.developerstudio.eclipse.artifact.cep.ui.Dialog.EngineProviderConfigurationDialog;
import org.wso2.developerstudio.eclipse.artifact.cep.ui.Dialog.QueryDialog;
import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifactConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CEPProjectEditorPage extends FormPage {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private String outputfileLocation;
	public static String bucketProjectName;
	public static String initialFileLocation;
	public static boolean isNewProject = true;
	public static boolean isCreatedProject = true;
	private IFile pomFileRes;

	private FormToolkit toolkit;
	private ScrolledForm form;
	private Composite body;
	private Text txtBucketName;
	private Text txtDescription;

	private boolean pageDirty;

	private TableViewer viewer;
	private TableViewer viewerQuery;
	private TableViewer viewerProperty;

	private List<EngineProviderPropertyModel> propertyList = new ArrayList<EngineProviderPropertyModel>();
	private List<Input> inputList = new ArrayList<Input>();
	private List<Query> queryList = new ArrayList<Query>();

	private Table inputTable;
	private Table queryTable;
	private Table propertyTable;
	private Properties engineProperty;
	private int selectedIndex;
	private int selectedIndexQuery;
	private int selectedIndexProperty;
	private Bucket bucket;
	private String bucketName;
	private String bucketDescription;
	private String bucketNameSpace;
	private String bucketEngineProvider;

	private Button deleteButtonProperty, addButtonproperty, editButtonProperty,
			addButton, editButton, deleteButton, addButtonQuery,
			editButtonQuery, deleteButtonQuery;

	private String[] arrayCEPEngine = {
			CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME,
			CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME,
			CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME };

	private Combo engineCombo;
	private File cepTemplateFile;

	public CEPProjectEditorPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		bucket = new Bucket();

	}

	public void initContent() throws Exception {
		pomFileRes = ((IFileEditorInput) (getEditor().getEditorInput()))
				.getFile();
		pomFileRes.getLocation().toFile();
		outputfileLocation = pomFileRes.getLocation().toFile()
				.getAbsolutePath();
		cepTemplateFile = new File(outputfileLocation);
	}

	public void saveConfigurationFile() throws Exception {
		bucket = new Bucket();
		bucket.setName(getBucketName());
		bucket.setDescription(getBucketDescription());
		bucket.setEngineProvider(getBucketEngineProvider());

		bucket.setInputs(inputList);
		engineProperty = new Properties();
		for (EngineProviderPropertyModel model : propertyList) {
			engineProperty.setProperty(model.getPropertyName(),
					model.getPropertyValue());
		}
		bucket.setProviderConfigurationProperties(engineProperty);

		for (Query query : queryList) {
			query.setQueryIndex(queryList.indexOf(query));
		}
		bucket.setQueries(queryList);
		writeTOFile(bucket);
		setPageDirty(false);
		pomFileRes.getProject().refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
	}

	protected void createFormContent(final IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm();
		body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new GridLayout(2, false));
		managedForm.getToolkit().createLabel(managedForm.getForm().getBody(),
				"Bucket Name", SWT.NONE);
		txtBucketName = managedForm.getToolkit().createText(
				managedForm.getForm().getBody(),
				CEPProjectEditorPage.bucketProjectName, SWT.NONE);
		setBucketName(CEPProjectEditorPage.bucketProjectName);
		GridData gd_txtGroupId = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);

		gd_txtGroupId.widthHint = 180;
		txtBucketName.setLayoutData(gd_txtGroupId);
		txtBucketName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				setBucketName(txtBucketName.getText().trim());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		Label lblDescription = managedForm.getToolkit()
				.createLabel(managedForm.getForm().getBody(),
						"Bucket Description", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));
		txtDescription = managedForm.getToolkit().createText(
				managedForm.getForm().getBody(), "",
				SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);

		GridData gd_txtDescription = new GridData(SWT.NONE, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 80;
		gd_txtDescription.widthHint = 850;
		txtDescription.setLayoutData(gd_txtDescription);
		setBucketDescription(txtDescription.getText().trim());//
		txtDescription.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {

				setBucketDescription(txtDescription.getText().trim());
				setPageDirty(true);
				updateDirtyState();
			}
		});

		Label lblCepRuntime = managedForm.getToolkit().createLabel(
				managedForm.getForm().getBody(), "CEP Engine Provider",
				SWT.NONE);
		lblCepRuntime.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false,
				false, 1, 1));

		engineCombo = new Combo(managedForm.getForm().getBody(), SWT.DROP_DOWN
				| SWT.READ_ONLY);
		toolkit.adapt(engineCombo);
		toolkit.paintBordersFor(managedForm.getForm().getBody());
		engineCombo.setItems(arrayCEPEngine);
		engineCombo
				.setText(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
		setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
		engineCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (arrayCEPEngine[engineCombo.getSelectionIndex()]
						.equals(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME)) {
					setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME);
					setPageDirty(true);
					updateDirtyState();

				} else if (arrayCEPEngine[engineCombo.getSelectionIndex()]
						.equals(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME)) {
					setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME);
					setPageDirty(true);
					updateDirtyState();

				} else if (arrayCEPEngine[engineCombo.getSelectionIndex()]
						.equals(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME)) {
					setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
					setPageDirty(true);
					updateDirtyState();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		Section engineProperties = managedForm.getToolkit().createSection(
				managedForm.getForm().getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_properties = new GridData(SWT.NONE, SWT.CENTER, true,
				false, 2, 1);
		engineProperties.setText("Engine Configuraton Properties");
		engineProperties.setLayoutData(gd_properties);
		engineProperties.setExpanded(true);
		final Composite compositeProperty = managedForm.getToolkit()
				.createComposite(engineProperties, SWT.NONE);
		engineProperties.setClient(compositeProperty);
		compositeProperty.setLayout(new GridLayout(3, false));
		if (!isNewProject) {
			try {
				bucket = readFromFile(initialFileLocation);

			} catch (Exception e) {
				log.warn("Failed to read file", e);
			}
			txtBucketName.setText(bucket.getName());
			setBucketName(bucket.getName());
			txtDescription.setText(bucket.getDescription());
			setBucketDescription(bucket.getDescription());
			setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME);
			if (bucket
					.getEngineProvider()
					.equals(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME)) {
				engineCombo
						.setText(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME);
				setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME);
			} else if (bucket.getEngineProvider().equals(
					CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME)) {
				engineCombo
						.setText(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME);
				setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME);
			} else if (bucket.getEngineProvider().equals(
					CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME)) {
				engineCombo
						.setText(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
				setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
			}

			if (bucket.getInputs() != null) {
				inputList = bucket.getInputs();
			}
			if (bucket.getQueries() != null) {
				queryList = bucket.getQueries();
			}
			List<EngineProviderPropertyModel> propertyListTemp = new ArrayList<EngineProviderPropertyModel>();
			if (bucket.getProviderConfigurationProperties() != null) {
				for (Object key : bucket.getProviderConfigurationProperties()
						.keySet()) {

					propertyListTemp.add(new EngineProviderPropertyModel(
							(String) key, (String) bucket
									.getProviderConfigurationProperties().get(
											(String) key)));
				}
			}
			propertyList = propertyListTemp;
		}
		initPropertyTable(compositeProperty, managedForm);

		GridData gdBtnProperty = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gdBtnProperty.widthHint = 100;
		addButtonproperty = managedForm.getToolkit().createButton(
				compositeProperty, "Add...", SWT.PUSH);
		addButtonproperty.setLayoutData(gdBtnProperty);

		addButtonproperty.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Shell temp = managedForm.getForm().getBody().getShell();
				GridLayout layout = new GridLayout();
				layout.marginHeight = 2;
				layout.marginBottom = 2;

				temp.setLayout(layout);
				EngineProviderConfigurationDialog dialog = new EngineProviderConfigurationDialog(
						temp);
				dialog.create();
				if (dialog.open() == Window.OK) {
					EngineProviderPropertyModel p = dialog.getPropertModel();
					updatePropertyTable(p, false);
				}
				setPageDirty(true);
				updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editButtonProperty = managedForm.getToolkit().createButton(
				compositeProperty, "Edit...", SWT.PUSH);
		addButtonproperty.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		editButtonProperty.setEnabled(false);

		editButtonProperty.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedIndexProperty = propertyTable.getSelectionIndex();
				EngineProviderPropertyModel p = propertyList.get(propertyTable
						.getSelectionIndex());

				EngineProviderConfigurationDialog dialog = new EngineProviderConfigurationDialog(
						managedForm.getForm().getBody().getShell());
				dialog.initializePage(p);
				dialog.create();
				if (dialog.open() == Window.OK) {
					EngineProviderPropertyModel propertyTemp = dialog
							.getPropertModel();
					updatePropertyTable(propertyTemp, true);
				}
				setPageDirty(true);
				updateDirtyState();
				editButtonProperty.setEnabled(false);
				deleteButtonProperty.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		deleteButtonProperty = managedForm.getToolkit().createButton(
				compositeProperty, "Delete", SWT.PUSH);
		editButtonProperty.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		deleteButtonProperty.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		deleteButtonProperty.setEnabled(false);
		deleteButtonProperty.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedIndexProperty = propertyTable.getSelectionIndex();
				propertyList.remove(selectedIndexProperty);
				viewerProperty.setInput(propertyList.toArray());
				viewerProperty.refresh();
				setPageDirty(true);
				updateDirtyState();
				deleteButtonProperty.setEnabled(false);
				editButtonProperty.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		propertyTable.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (propertyList.size() > 0) {
					editButtonProperty.setEnabled(true);
					deleteButtonProperty.setEnabled(true);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		Section bucketInputs = managedForm.getToolkit().createSection(
				managedForm.getForm().getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_inputs = new GridData(SWT.NONE, SWT.CENTER, true, false, 2,
				1);
		bucketInputs.setText("Inputs");
		bucketInputs.setLayoutData(gd_inputs);
		bucketInputs.setExpanded(true);
		final Composite compositeone = managedForm.getToolkit()
				.createComposite(bucketInputs, SWT.NONE);
		bucketInputs.setClient(compositeone);
		compositeone.setLayout(new GridLayout(3, false));

		initInputTable(compositeone, managedForm);

		GridData gdBtn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdBtn.widthHint = 100;
		addButton = managedForm.getToolkit().createButton(compositeone,
				"Add...", SWT.PUSH);
		addButton.setLayoutData(gdBtn);

		addButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				BucketInputDialog dialog = new BucketInputDialog(managedForm
						.getForm().getBody().getShell(), false);
				dialog.create();
				if (dialog.open() == Window.OK) {
					Input p = dialog.getInput();
					updateInputTable(p, false);
				}
				setPageDirty(true);
				updateDirtyState();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editButton = managedForm.getToolkit().createButton(compositeone,
				"Edit...", SWT.PUSH);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		editButton.setEnabled(false);
		editButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedIndex = inputTable.getSelectionIndex();
				Input p = inputList.get(inputTable.getSelectionIndex());

				BucketInputDialog dialog = new BucketInputDialog(managedForm
						.getForm().getBody().getShell(), false);
				dialog.initiatePage(p);
				dialog.create();
				if (dialog.open() == Window.OK) {
					Input inp = dialog.getInput();
					updateInputTable(inp, true);
				}
				setPageDirty(true);
				updateDirtyState();
				editButton.setEnabled(false);
				deleteButton.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		deleteButton = managedForm.getToolkit().createButton(compositeone,
				"Delete", SWT.PUSH);
		editButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		deleteButton.setEnabled(false);
		deleteButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedIndex = inputTable.getSelectionIndex();
				inputList.remove(selectedIndex);
				viewer.setInput(inputList.toArray());
				viewer.refresh();
				setPageDirty(true);
				updateDirtyState();
				deleteButton.setEnabled(false);
				editButton.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		inputTable.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (inputList.size() > 0) {
					editButton.setEnabled(true);
					deleteButton.setEnabled(true);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		Section bucketQueries = managedForm.getToolkit().createSection(
				managedForm.getForm().getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_queries = new GridData(SWT.NONE, SWT.CENTER, true, false,
				2, 1);
		bucketQueries.setText("Queries");
		bucketQueries.setLayoutData(gd_queries);
		bucketQueries.setExpanded(true);
		final Composite compositetwo = managedForm.getToolkit()
				.createComposite(bucketQueries, SWT.NONE);
		bucketQueries.setClient(compositetwo);
		compositetwo.setLayout(new GridLayout(3, false));
		initQueryTable(compositetwo, managedForm);
		gdBtn.widthHint = 100;
		addButtonQuery = managedForm.getToolkit().createButton(compositetwo,
				"Add...", SWT.PUSH);
		addButtonQuery.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		addButtonQuery.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				QueryDialog dialog = new QueryDialog(managedForm.getForm()
						.getBody().getShell(), false);
				dialog.create();
				if (dialog.open() == Window.OK) {
					Query query = dialog.getQueryObject();
					updateQueryTable(query, false);
					setPageDirty(true);
					updateDirtyState();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		editButtonQuery = managedForm.getToolkit().createButton(compositetwo,
				"Edit...", SWT.PUSH);
		editButtonQuery.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		editButtonQuery.setEnabled(false);
		editButtonQuery.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedIndexQuery = queryTable.getSelectionIndex();
				Query queryTemp = queryList.get(queryTable.getSelectionIndex());
				QueryDialog dialog = new QueryDialog(managedForm.getForm()
						.getBody().getShell(), true);
				dialog.initializePage(queryTemp);
				dialog.create();
				if (dialog.open() == Window.OK) {
					Query query = dialog.getQueryObject();
					updateQueryTable(query, true);
				}
				setPageDirty(true);
				updateDirtyState();
				editButtonQuery.setEnabled(false);
				deleteButtonQuery.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		deleteButtonQuery = managedForm.getToolkit().createButton(compositetwo,
				"Delete", SWT.PUSH);
		deleteButtonQuery.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		deleteButtonQuery.setEnabled(false);
		deleteButtonQuery.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				selectedIndexQuery = queryTable.getSelectionIndex();
				queryList.remove(selectedIndexQuery);
				viewerQuery.setInput(queryList.toArray());
				viewerQuery.refresh();
				setPageDirty(true);
				updateDirtyState();
				deleteButtonQuery.setEnabled(false);
				editButtonQuery.setEnabled(false);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

		queryTable.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (queryList.size() > 0) {
					editButtonQuery.setEnabled(true);
					deleteButtonQuery.setEnabled(true);
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		engineProperties.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {

				if (propertyTable.getItemCount() == 0) {
					propertyTable.setItemCount(3);
				}
			}

			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {

			}

		});

		bucketInputs.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {

				if (inputTable.getItemCount() == 0) {
					inputTable.setItemCount(3);
				}
			}

			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {

			}

		});

		bucketQueries.addExpansionListener(new IExpansionListener() {

			@Override
			public void expansionStateChanged(ExpansionEvent arg0) {

				if (queryTable.getItemCount() == 0) {
					queryTable.setItemCount(3);
				}
			}

			@Override
			public void expansionStateChanging(ExpansionEvent arg0) {

			}

		});

		if (isCreatedProject == true || isNewProject == true) {
			try {
				updateDesignChanges(readFromFile(outputfileLocation));
			} catch (Exception e) {

			}
		}

		form.updateToolBar();
		form.reflow(true);
	}

	private void initPropertyTable(Composite composite, IManagedForm managedForm) {

		final Table table = managedForm.getToolkit().createTable(
				composite,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
						| SWT.BORDER | SWT.VIRTUAL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		propertyTable = table;
		viewerProperty = new TableViewer(table);
		GridData db = new GridData(SWT.NONE, SWT.TOP, true, true, 4, 10);
		db.horizontalSpan = 2;
		table.setLayoutData(db);
		TableViewerColumn viewerColumn = new TableViewerColumn(viewerProperty,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				EngineProviderPropertyModel p = (EngineProviderPropertyModel) element;
				if (p != null) {
					return p.getPropertyName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(300);
		viewerColumn.getColumn().setText("Name");
		TableViewerColumn viewerColumnBrokerName = new TableViewerColumn(
				viewerProperty, SWT.NONE, 1);
		viewerColumnBrokerName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				EngineProviderPropertyModel p = (EngineProviderPropertyModel) element;
				if (p != null) {
					return p.getPropertyValue();
				} else
					return "";
			}

		});
		viewerColumnBrokerName.getColumn().setWidth(300);
		viewerColumnBrokerName.getColumn().setText("Value");
		viewerProperty.setContentProvider(new ArrayContentProvider());
		viewerProperty.setInput(propertyList.toArray());
		table.setItemCount(3);
		table.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event event) {

			}

		});

		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

	}

	private void updatePropertyTable(EngineProviderPropertyModel model,
			boolean edit) {
		if (!edit) {
			propertyList.add(model);
		} else if (edit) {
			propertyList.remove(selectedIndex);
			propertyList.add(selectedIndex, model);
		}
		if (propertyList.size() > 0) {
			viewerProperty.setInput(propertyList.toArray());
			viewerProperty.refresh();
		}
	}

	private void updateInputTable(Input input, boolean edit) {
		Input m = input;

		if (!edit) {
			inputList.add(m);
		} else if (edit) {
			inputList.remove(selectedIndex);
			inputList.add(selectedIndex, m);
		}
		if (inputList.size() > 0) {
			viewer.setInput(inputList.toArray());
			viewer.refresh();
		}

	}

	private void initInputTable(Composite composite, IManagedForm managedForm) {
		final Table table = managedForm.getToolkit().createTable(
				composite,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
						| SWT.BORDER | SWT.VIRTUAL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		inputTable = table;
		viewer = new TableViewer(table);
		GridData db = new GridData(SWT.NONE, SWT.TOP, true, true, 4, 10);
		db.horizontalSpan = 2;
		table.setLayoutData(db);
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Input p = (Input) element;
				if (p != null) {
					return p.getTopic();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(300);
		viewerColumn.getColumn().setText("Topic");
		TableViewerColumn viewerColumnBrokerName = new TableViewerColumn(
				viewer, SWT.NONE, 1);
		viewerColumnBrokerName.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Input p = (Input) element;
				if (p != null) {
					return p.getBrokerName();
				} else
					return "";
			}

		});
		viewerColumnBrokerName.getColumn().setWidth(300);
		viewerColumnBrokerName.getColumn().setText("Broker Name");
		TableViewerColumn viewerColumnStream = new TableViewerColumn(viewer,
				SWT.NONE, 2);
		viewerColumnStream.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Input p = (Input) element;
				if (p != null) {
					return p.getInputMapping().getStream();
				} else
					return "";
			}
		});
		viewerColumnStream.getColumn().setWidth(300);
		viewerColumnStream.getColumn().setText("Stream");
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(inputList.toArray());
		table.setItemCount(3);
		table.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event event) {

			}

		});

		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

	}

	private void initQueryTable(Composite composite, IManagedForm managedForm) {
		final Table table = managedForm.getToolkit().createTable(
				composite,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
						| SWT.BORDER | SWT.VIRTUAL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		queryTable = table;
		viewerQuery = new TableViewer(table);
		GridData dbone = new GridData(SWT.NONE, SWT.TOP, true, true, 4, 10);
		dbone.horizontalSpan = 2;
		table.setLayoutData(dbone);
		TableViewerColumn viewerColumn = new TableViewerColumn(viewerQuery,
				SWT.NONE, 0);
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Query q = (Query) element;
				if (q != null) {
					return q.getName();
				} else
					return "";
			}
		});
		viewerColumn.getColumn().setWidth(300);
		viewerColumn.getColumn().setText("Query Name");
		TableViewerColumn viewerColumnType = new TableViewerColumn(viewerQuery,
				SWT.NONE, 1);
		viewerColumnType.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Query q = (Query) element;
				if (q != null) {
					return "type";
				} else
					return "";

			}

		});
		viewerColumnType.getColumn().setWidth(300);
		viewerColumnType.getColumn().setText("Expression Type");
		TableViewerColumn viewerColumnTopic = new TableViewerColumn(
				viewerQuery, SWT.NONE, 2);
		viewerColumnTopic.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Query q = (Query) element;
				if (q != null && q.getOutput() != null) {
					return q.getOutput().getTopic();
				} else
					return "";

			}
		});
		viewerColumnTopic.getColumn().setWidth(300);
		viewerColumnTopic.getColumn().setText("OutPut Topic");
		viewerQuery.setContentProvider(new ArrayContentProvider());
		viewerQuery.setInput(queryList.toArray());
		table.setItemCount(3);
		table.addListener(SWT.SetData, new Listener() {
			public void handleEvent(Event event) {

			}

		});

		table.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

	}

	private void updateQueryTable(Query query, boolean edit) {
		if (!edit) {
			queryList.add(query);
		} else if (edit) {
			queryList.remove(selectedIndexQuery);
			queryList.add(selectedIndexQuery, query);
		}
		viewerQuery.setInput(queryList.toArray());
		viewerQuery.refresh();
	}

	private void writeTOFile(Bucket bucket) throws IOException,
			XMLStreamException {
		String templateContent = BucketHelper.bucketToOM(bucket).toString();
		templateContent = format(templateContent);
		templateContent = templateContent.replace(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		templateContent = templateContent.trim();
		templateContent = templateContent.replaceAll("&gt;", ">");
		templateContent = templateContent.replaceAll("&lt;", "<");
		FileUtils.writeContent(cepTemplateFile, templateContent);
	}

	private Bucket readFromFile(String path) throws XMLStreamException,
			FactoryConfigurationError, CEPConfigurationException, IOException {
		File bucketFile = new File(path);
		BufferedInputStream inputStream = null;
		OMElement bucketElement = null;
		inputStream = new BufferedInputStream(new FileInputStream(bucketFile));
		XMLStreamReader parser = XMLInputFactory.newInstance()
				.createXMLStreamReader(inputStream);
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		bucketElement = builder.getDocumentElement();
		bucketElement.build();
		inputStream.close();
		Bucket bucket = BucketHelper.fromOM(bucketElement);
		return bucket;
	}

	private void updateDesignChanges(Bucket bucket) {
		String name = bucket.getName();
		String description = bucket.getDescription();
		String engineProvider = bucket.getEngineProvider();
		List<Input> input = bucket.getInputs();
		List<Query> query = bucket.getQueries();
		List<EngineProviderPropertyModel> property = new ArrayList<EngineProviderPropertyModel>();
		Properties properties = bucket.getProviderConfigurationProperties();
		if (properties != null && properties.size() > 0) {
			for (Object key : properties.keySet()) {
				property.add(new EngineProviderPropertyModel((String) key,
						(String) properties.get(key)));
			}
		}

		txtBucketName.setText(name);
		setBucketName(name);
		txtDescription.setText(description);
		setBucketDescription(description);

		if (engineProvider
				.equals(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME)) {
			engineCombo
					.setText(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME);
			setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_DROOLS_FUSION_CEP_RUNTIME);

		} else if (engineProvider
				.equals(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME)) {
			engineCombo
					.setText(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME);
			setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_ESPER_CEP_RUNTIME);
		} else if (engineProvider
				.equals(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME)) {
			engineCombo
					.setText(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
			setBucketEngineProvider(CEPArtifactConstants.WIZARD_OPTION_SIDDHI_CEP_RUNTIME);
		}
		if (property != null) {
			propertyList = property;
			viewerProperty.setInput(propertyList.toArray());
			viewerProperty.refresh();
		}

		if (input != null) {
			inputList = input;
			viewer.setInput(inputList.toArray());
			viewer.refresh();
		}
		if (query != null) {

			queryList = query;

			viewerQuery.setInput(queryList.toArray());
			viewerQuery.refresh();
		}
		if (inputTable.getItemCount() == 0) {
			inputTable.setItemCount(3);
		}
		if (queryTable.getItemCount() == 0) {
			queryTable.setItemCount(3);
		}
		if (propertyTable.getItemCount() == 0) {
			propertyTable.setItemCount(3);
		}

	}

	private Document parseXmlFile(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return (Document) db.parse(is);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	private String format(String unformattedXml) {

		try {
			final Document document = parseXmlFile(unformattedXml);

			OutputFormat format = new OutputFormat(document);
			format.setLineWidth(65);
			format.setIndenting(true);
			format.setIndent(2);
			Writer out = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);

			return out.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isPageDirty() {
		return pageDirty;
	}

	public void setPageDirty(boolean isPageDirty) {
		this.pageDirty = isPageDirty;
	}

	public void updateDirtyState() {
		((CEPProjectEditor) getEditor()).updateDirtyState();
		;
	}

	public boolean isDirty() {
		return isPageDirty();
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketDescription() {
		return bucketDescription;
	}

	public void setBucketDescription(String bucketDescription) {
		this.bucketDescription = bucketDescription;
	}

	public String getBucketNameSpace() {
		return bucketNameSpace;
	}

	public void setBucketNameSpace(String bucketNameSpace) {
		this.bucketNameSpace = bucketNameSpace;
	}

	public String getBucketEngineProvider() {
		return bucketEngineProvider;
	}

	public void setBucketEngineProvider(String bucketEngineProvider) {
		this.bucketEngineProvider = bucketEngineProvider;
	}

	public void refreshForm() throws Exception {
		initContent();
		updateDesignChanges(readFromFile(outputfileLocation));

	}

}
