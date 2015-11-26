/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.ds.presentation.md;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.ds.AttributeMapping;
import org.wso2.developerstudio.eclipse.ds.CallQuery;
import org.wso2.developerstudio.eclipse.ds.ConfigurationProperty;
import org.wso2.developerstudio.eclipse.ds.CustomValidator;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DataServiceParameter;
import org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration;
import org.wso2.developerstudio.eclipse.ds.Description;
import org.wso2.developerstudio.eclipse.ds.DoubleRangeValidator;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.ElementMapping;
import org.wso2.developerstudio.eclipse.ds.EventTrigger;
import org.wso2.developerstudio.eclipse.ds.ExcelQuery;
import org.wso2.developerstudio.eclipse.ds.Expression;
import org.wso2.developerstudio.eclipse.ds.GSpreadQuery;
import org.wso2.developerstudio.eclipse.ds.HasHeader;
import org.wso2.developerstudio.eclipse.ds.LengthValidator;
import org.wso2.developerstudio.eclipse.ds.LongRangeValidator;
import org.wso2.developerstudio.eclipse.ds.MaxRowCount;
import org.wso2.developerstudio.eclipse.ds.Operation;
import org.wso2.developerstudio.eclipse.ds.ParameterMapping;
import org.wso2.developerstudio.eclipse.ds.PatternValidator;
import org.wso2.developerstudio.eclipse.ds.Query;
import org.wso2.developerstudio.eclipse.ds.QueryExpression;
import org.wso2.developerstudio.eclipse.ds.QueryParameter;
import org.wso2.developerstudio.eclipse.ds.QueryProperty;
import org.wso2.developerstudio.eclipse.ds.QueryPropertyList;
import org.wso2.developerstudio.eclipse.ds.Resource;
import org.wso2.developerstudio.eclipse.ds.ResultMapping;
import org.wso2.developerstudio.eclipse.ds.Sparql;
import org.wso2.developerstudio.eclipse.ds.Sql;
import org.wso2.developerstudio.eclipse.ds.StartingRow;
import org.wso2.developerstudio.eclipse.ds.Subscription;
import org.wso2.developerstudio.eclipse.ds.TargetTopic;
import org.wso2.developerstudio.eclipse.ds.WorkBookName;
import org.wso2.developerstudio.eclipse.ds.WorkSheetNumber;
import org.wso2.developerstudio.eclipse.ds.actions.DSActionConstants;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;


public class DetailSection {
	
	private FormToolkit toolkit;
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;
	private Composite detailsclient;
	private Object selectedObject;
	private DetailSectionUiUtil sectionUtil;
	private EditingDomain editingDomain;
	private DataService dataService;

	private Combo paramTypeCombo = null;
	private Label queryParamLabel = null;
	private Text queryParamText = null;
	private Label columnLabel = null;
	private Text columnTxt = null;
	private Color gray = new Color(Display.getCurrent(), new RGB(169, 169, 169));
	private Color white = new Color(Display.getCurrent(),
			new RGB(255, 255, 255));

	public DetailSection(FormToolkit toolkit,
			AdapterFactoryItemDelegator adapterFactoryItemDelegator,
			Composite detailsclient, Object input, DsEditor editor) {
		this.toolkit = toolkit;
		this.adapterFactoryItemDelegator = adapterFactoryItemDelegator;
		this.detailsclient = detailsclient;
		this.selectedObject = input;
		this.editingDomain = editor.getEditingDomain();
		this.dataService = editor.getDataService();
		this.sectionUtil = new DetailSectionUiUtil(editor.getDataService(),
				editingDomain);
	}

	private Label labelMaker(String s) {
		Label l = toolkit.createLabel(detailsclient, s, SWT.NONE);
		GridData gd = new GridData();
		l.setLayoutData(gd);
		return l;
	}

	private Label voidMaker() {
		Label l = toolkit.createLabel(detailsclient, "", SWT.NONE);
		GridData gd = new GridData();
		gd.heightHint = 7;
		l.setLayoutData(gd);
		return l;
	}

	public void createSection(final Object input) {

		if (input != null) {

			customizeUibasedOnInput(input, detailsclient);

		} else {

			labelMaker("No data to show in the Detail section");
		}
		toolkit.paintBordersFor(detailsclient);

	}

	private void customizeUibasedOnInput(Object input, Composite detailsclient) {

		// On Data service selection
		if (input instanceof DataService) {
			DataService dataService = (DataService) input;
			dataServiceObjectConfigurator(dataService);

			// On description selection
		} else if (input instanceof Description) {

			Description description = (Description) input;
			voidMaker();
			voidMaker();
			labelMaker(DetailSectionCustomUiConstants.DATA_SERVICE_DESCRIPTION);
			sectionUtil.getAttributeField(detailsclient, toolkit, input,
					description.getValue(),
					DsPackage.eINSTANCE.getDescription_Value(),
					DetailSectionCustomUiConstants.STRING);

			// On Data Source selection
		} else if (input instanceof DataServiceParameter) {

			DataServiceParameter dataServiceParameter = (DataServiceParameter) input;
			voidMaker();
			voidMaker();
			labelMaker(DetailSectionCustomUiConstants.DATA_SERVICE_PARAMETER_ALLOW_ROLES);
			sectionUtil.getAttributeField(detailsclient, toolkit, input,
					dataServiceParameter.getValue(),
					DsPackage.eINSTANCE.getDataServiceParameter_Value(),
					DetailSectionCustomUiConstants.STRING);

			// On Data Source selection
		} else if (input instanceof DataSourceConfiguration) {

			DataSourceConfiguration config = (DataSourceConfiguration) input;
			voidMaker();
			voidMaker();
			labelMaker(DetailSectionCustomUiConstants.DATA_SOURCE_CONFIGURATION_ID);
			sectionUtil.getAttributeField(detailsclient, toolkit, input,
					config.getId(),
					DsPackage.eINSTANCE.getDataSourceConfiguration_Id(),
					DetailSectionCustomUiConstants.STRING);
			if (config != null) {

				EList<ConfigurationProperty> configProperties = config
						.getProperty();

				Iterator<ConfigurationProperty> iterator = configProperties
						.iterator();

				while (iterator.hasNext()) {
					ConfigurationProperty configurationProperty = (ConfigurationProperty) iterator
							.next();
					configurationPropertyObjectConfigurator(configurationProperty);
				}
			}

			// On configuration property selction
		} else if (input instanceof ConfigurationProperty) {

			ConfigurationProperty configProperty = (ConfigurationProperty) input;
			configurationPropertyObjectConfigurator(configProperty);

			// On query selction
		} else if (input instanceof Query) {

			Query query = (Query) input;
			queryObjectConfigurator(query);

		} else if (input instanceof Sql) {

			Sql sql = (Sql) input;

			labelMaker(DetailSectionCustomUiConstants.QUERY_SQL);
			sectionUtil.getMultilineTextFileld(detailsclient, toolkit, input,
					sql.getValue(), DsPackage.eINSTANCE.getSql_Value(),
					DetailSectionCustomUiConstants.STRING);
			voidMaker();
			voidMaker();

		} else if (input instanceof Sparql) {

			Sparql sparql = (Sparql) input;

			labelMaker(DetailSectionCustomUiConstants.QUERY_SPARQL);
			sectionUtil.getMultilineTextFileld(detailsclient, toolkit, input,
					sparql.getValue(), DsPackage.eINSTANCE.getSparql_Value(),
					DetailSectionCustomUiConstants.STRING);
			voidMaker();
			voidMaker();

		} else if (input instanceof QueryExpression) {

			QueryExpression queryExpression = (QueryExpression) input;

			labelMaker(DetailSectionCustomUiConstants.QUERY_EXPRESSION);
			sectionUtil.getMultilineTextFileld(detailsclient, toolkit, input,
					queryExpression.getValue(),
					DsPackage.eINSTANCE.getQueryExpression_Value(),
					DetailSectionCustomUiConstants.STRING);
			voidMaker();
			voidMaker();

		} else if (input instanceof QueryPropertyList) {

			QueryPropertyList propList = (QueryPropertyList) input;

			EList<QueryProperty> queryProperties = propList.getProperty();

			Iterator<QueryProperty> iterator = queryProperties.iterator();

			while (iterator.hasNext()) {

				QueryProperty queryProperty = (QueryProperty) iterator.next();
				queryPropertyObjectConfigurator(queryProperty);
			}

		} else if (input instanceof QueryProperty) {

			QueryProperty property = (QueryProperty) input;
			queryPropertyObjectConfigurator(property);

		} else if (input instanceof ResultMapping) {

			ResultMapping result = (ResultMapping) input;
			resultObjectConfigurator(result);

		} else if (input instanceof ElementMapping) {
			boolean makeItComplex = false;
			ElementMapping element = (ElementMapping) input;
			boolean isComplex = element.isIsComplexType();
			Collection children = editingDomain.getChildren(input);
			if (children.size() > 0 | isComplex) {
				makeItComplex = true;
			}
			elementMappingObjectConfigurator(element, makeItComplex);

		} else if (input instanceof AttributeMapping) {

			AttributeMapping attributeMap = (AttributeMapping) input;
			attributeMappingObjectConfiguretor(attributeMap);

		} else if (input instanceof ExcelQuery) {

			// no attributes to display

		} else if (input instanceof WorkBookName) {

			WorkBookName wrkBook = (WorkBookName) input;
			labelMaker(DetailSectionCustomUiConstants.EXCEL_WORKBOOK_NAME);
			sectionUtil.getAttributeField(detailsclient, toolkit, wrkBook,
					wrkBook.getValue(),
					DsPackage.eINSTANCE.getWorkBookName_Value(),
					DetailSectionCustomUiConstants.STRING);
		} else if (input instanceof HasHeader) {

			HasHeader hasHeader = (HasHeader) input;
			labelMaker(DetailSectionCustomUiConstants.EXCEL_HAS_HEADER);
			sectionUtil.getBooleanComboField(detailsclient, toolkit, hasHeader,
					hasHeader.isValue(),
					DsPackage.eINSTANCE.getHasHeader_Value());

		} else if (input instanceof StartingRow) {

			StartingRow str = (StartingRow) input;
			labelMaker(DetailSectionCustomUiConstants.EXCEL_STARTING_ROW);
			String existingVal = new Long(str.getValue()).toString();
			sectionUtil.getAttributeField(detailsclient, toolkit, str,
					existingVal, DsPackage.eINSTANCE.getStartingRow_Value(),
					DetailSectionCustomUiConstants.LONG);

		} else if (input instanceof MaxRowCount) {

			MaxRowCount mxrc = (MaxRowCount) input;
			labelMaker(DetailSectionCustomUiConstants.EXCEL_MAX_ROW_COUNT);
			String existingVal = new Long(mxrc.getValue()).toString();
			sectionUtil.getAttributeField(detailsclient, toolkit, mxrc,
					existingVal, DsPackage.eINSTANCE.getMaxRowCount_Value(),
					DetailSectionCustomUiConstants.LONG);
		} else if (input instanceof GSpreadQuery) {

			// no attributes to display
		} else if (input instanceof WorkSheetNumber) {

			WorkSheetNumber wrkshtnum = (WorkSheetNumber) input;
			labelMaker(DetailSectionCustomUiConstants.GSPRED_WORK_SHEET_NUM);
			String existingVal = new Long(wrkshtnum.getValue()).toString();
			sectionUtil.getAttributeField(detailsclient, toolkit, wrkshtnum,
					existingVal,
					DsPackage.eINSTANCE.getWorkSheetNumber_Value(),
					DetailSectionCustomUiConstants.LONG);

		} else if (input instanceof QueryParameter) {

			QueryParameter queryParm = (QueryParameter) input;
			queryParamObjectConfigurator(queryParm);

		} else if (input instanceof LongRangeValidator) {

			LongRangeValidator longrval = (LongRangeValidator) input;
			validatorObjectConfigurator(longrval,
					DetailSectionCustomUiConstants.LONG);

		} else if (input instanceof DoubleRangeValidator) {

			DoubleRangeValidator doublerval = (DoubleRangeValidator) input;
			validatorObjectConfigurator(doublerval,
					DetailSectionCustomUiConstants.DOUBLE);

		} else if (input instanceof LengthValidator) {

			LengthValidator lengthaval = (LengthValidator) input;
			validatorObjectConfigurator(lengthaval,
					DetailSectionCustomUiConstants.LONG);

		} else if (input instanceof PatternValidator) {

			voidMaker();
			voidMaker();
			PatternValidator pValiditor = (PatternValidator) input;
			labelMaker(DetailSectionCustomUiConstants.VALIDATOR_PATTORN);
			sectionUtil.getMultilineTextFileld(detailsclient, toolkit,
					pValiditor, pValiditor.getPattern(),
					DsPackage.eINSTANCE.getPatternValidator_Pattern(),
					DetailSectionCustomUiConstants.STRING);

		} else if (input instanceof CustomValidator) {

			voidMaker();
			voidMaker();
			CustomValidator customValidator = (CustomValidator) input;
			labelMaker(DetailSectionCustomUiConstants.VALIDATOR_CUSTOM);
			sectionUtil.getAttributeField(detailsclient, toolkit,
					customValidator, customValidator.getClass_(),
					DsPackage.eINSTANCE.getCustomValidator_Class(),
					DetailSectionCustomUiConstants.STRING);

		} else if (input instanceof EventTrigger) {

			EventTrigger eventTirg = (EventTrigger) input;
			eventTriggerObejecConfigurator(eventTirg);

		} else if (input instanceof Expression) {
			voidMaker();
			voidMaker();
			Expression expr = (Expression) input;
			labelMaker(DetailSectionCustomUiConstants.EVENT_TRIGGER_EXPRESSION);
			sectionUtil.getAttributeField(detailsclient, toolkit, expr,
					expr.getValue(), DsPackage.eINSTANCE.getExpression_Value(),
					DetailSectionCustomUiConstants.STRING);

		} else if (input instanceof TargetTopic) {
			voidMaker();
			voidMaker();
			TargetTopic ttpic = (TargetTopic) input;
			labelMaker(DetailSectionCustomUiConstants.EVENT_TRIGGER_TARGET_TOPIC);
			sectionUtil.getAttributeField(detailsclient, toolkit, ttpic,
					ttpic.getValue(),
					DsPackage.eINSTANCE.getTargetTopic_Value(),
					DetailSectionCustomUiConstants.STRING);

		} else if (input instanceof Subscription) {
			voidMaker();
			voidMaker();
			Subscription subscription = (Subscription) input;
			labelMaker(DetailSectionCustomUiConstants.EVENT_TRIGGER_SUBSCRIPTION);
			sectionUtil.getAttributeField(detailsclient, toolkit, subscription,
					subscription.getValue(),
					DsPackage.eINSTANCE.getSubscription_Value(),
					DetailSectionCustomUiConstants.STRING);

		} else if (input instanceof Operation) {

			Operation operation = (Operation) input;
			operationObjectConfigurator(operation);

		} else if (input instanceof CallQuery && dataService != null) {

			final CallQuery callQuery = (CallQuery) input;

			EList<Query> queryList = dataService.getQuery();

			final Query[] q = queryList.toArray(new Query[0]);

			String[] displayValues = new String[q.length];

			for (int i = 0; i < q.length; i++) {

				displayValues[i] = q[i].getId();
			}

			voidMaker();
			voidMaker();

			labelMaker(DetailSectionCustomUiConstants.CALL_QUERY_LINK);
			final Combo queryCombo = sectionUtil.getCustomComboField(
					detailsclient, toolkit, callQuery, callQuery.getHref(),
					DsPackage.eINSTANCE.getCallQuery_Href(), displayValues);
			queryCombo.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					super.widgetSelected(e);

					EList<ParameterMapping> existingparms = callQuery
							.getWithParam();

					if (existingparms != null && !existingparms.isEmpty()) {

						callQuery.getWithParam().removeAll(existingparms);

					}

					int selectionIndex = queryCombo.getSelectionIndex();

					if (q[selectionIndex] != null
							&& !q[selectionIndex].getId().equals("")) {

						if (q[selectionIndex].getParam() != null) {

							EList<QueryParameter> queryParams = q[selectionIndex]
									.getParam();

							if (!queryParams.isEmpty()) {

								for (QueryParameter param : queryParams) {

									String paramName = param.getName();

									ParameterMapping parammapping = DsFactory.eINSTANCE
											.createParameterMapping();
									parammapping.setName(paramName);
									parammapping.setQueryParam(paramName);

									callQuery.getWithParam().add(parammapping);

								}
							}
						}
					}
				}
			});

		} else if (input instanceof ParameterMapping) {

			ParameterMapping paramMapping = (ParameterMapping) input;
			paramMapObjectConfigurator(paramMapping);

		} else if (input instanceof Resource) {

			Resource resource = (Resource) input;
			resourceObjectConfigurator(resource);
		}

	}

	private void dataServiceObjectConfigurator(DataService dataService) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(dataService);
		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(dataService);
			if (desc.getFeature(dataService) instanceof EAttributeImpl) {

				if (displayName
						.equals(DetailSectionCustomUiConstants.DATA_SERVICE_NAME)) {

					labelMaker(displayName);

					sectionUtil.getAttributeField(detailsclient, toolkit,
							selectedObject, dataService.getName(),
							DsPackage.eINSTANCE.getDataService_Name(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
					// Fixing
					// TOOLS-1008.(org.wso2.developerstudio.eclipse.ds.provider.DataServiceItemProvider
					// also has relevant change)
					Description description = dataService.getDescription();
					if (description != null) {
						labelMaker(DetailSectionCustomUiConstants.DATA_SERVICE_DESCRIPTION);
						sectionUtil.getAttributeField(detailsclient, toolkit,
								description, description.getValue(),
								DsPackage.eINSTANCE.getDescription_Value(),
								DetailSectionCustomUiConstants.STRING);
						voidMaker();
						voidMaker();
					}

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.DATA_SERVICE_GROUP)) {

					labelMaker(displayName);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							selectedObject, dataService.getServiceGroup(),
							DsPackage.eINSTANCE.getDataService_ServiceGroup(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.DATA_SERVICE_NAMESPACE)) {

					labelMaker(displayName);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							selectedObject, dataService.getServiceNamespace(),
							DsPackage.eINSTANCE
									.getDataService_ServiceNamespace(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.DATA_SERVICE_TRANSPORTS)) {

					labelMaker(displayName);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							selectedObject, dataService.getTransports(),
							DsPackage.eINSTANCE.getDataService_Transports(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName.equals(DetailSectionCustomUiConstants.BASE_URI)) {

					labelMaker(displayName);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							selectedObject, dataService.getBaseURI(),
							DsPackage.eINSTANCE.getDataService_BaseURI(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.ENABLE_BATCH_REQUESTS)) {

					labelMaker(displayName);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							selectedObject,
							dataService.isEnableBatchRequests(),
							DsPackage.eINSTANCE
									.getDataService_EnableBatchRequests());
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.ENABLE_BOX_CARRING)) {

					labelMaker(displayName);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							selectedObject, dataService.isEnableBoxcarring(),
							DsPackage.eINSTANCE
									.getDataService_EnableBoxcarring());
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.ENABLE_DTP)) {

					labelMaker(displayName);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							selectedObject, dataService.isEnableDTP(),
							DsPackage.eINSTANCE.getDataService_EnableDTP());
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.DISABLE_STREAMING)) {
					labelMaker(displayName);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							selectedObject, dataService.isDisableStreaming(),
							DsPackage.eINSTANCE
									.getDataService_DisableStreaming());
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.ENABLE_SECURITY)) {
					labelMaker(displayName);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							selectedObject, dataService.isEnableSec(),
							DsPackage.eINSTANCE.getDataService_EnableSec());
					voidMaker();
					voidMaker();

					/*labelMaker(DetailSectionCustomUiConstants.DATA_SERVICE_PARAMETER_ALLOW_ROLES);
					sectionUtil.getUserRoleField(detailsclient, toolkit);
					voidMaker();
					voidMaker();*/
					
				    labelMaker(DetailSectionCustomUiConstants.DATA_SERVICE_POLICY);
					sectionUtil.getPolicyField(detailsclient, toolkit);
					voidMaker();
					voidMaker();
					
				}
			}
		}
	}

	private void configurationPropertyObjectConfigurator(
			ConfigurationProperty configProperty) {
		voidMaker();
		voidMaker();

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.DRIVER_PROPERTY)) {

			labelMaker(DSActionConstants.DRIVER_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.PROTOCOL_PROPERTY)) {

			labelMaker(DSActionConstants.PROTOCOL_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.USER_PROPERTY)) {

			labelMaker(DSActionConstants.USER_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.PASSWORD_PROPERTY)) {

			labelMaker(DSActionConstants.PASSWORD_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.MINPOOLSIZE_PROPERTY)) {

			labelMaker(DSActionConstants.MINPOOLSIZE_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.MAXPOOLSIZE_PROPERTY)) {

			labelMaker(DSActionConstants.MAXPOOLSIZE_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.VALIDATIONQUERY_PROPERTY)) {

			labelMaker(DSActionConstants.VALIDATIONQUERY_DISPLAY);

		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.ENABLE_AUTO_COMMIT)) {

			labelMaker(DSActionConstants.ENABLE_AUTO_COMMIT_DISPLAY);
		}

		// Cassandra type

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.CASSANDRA_SERVER_URL)) {

			labelMaker(DSActionConstants.CASSANDRA_SERVER_URL_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.CASSANDRA_USERNAME)) {

			labelMaker(DSActionConstants.CASSANDRA_USERNAME_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.CASSANDRA_PASSWORD)) {

			labelMaker(DSActionConstants.CASSANDRA_PASSWORD_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.CASSANDRA_DRIVER_CLASS_NAME)) {

			labelMaker(DSActionConstants.CASSANDRA_DRIVER_CLASS_NAME_DISPLAY);
		}

		// CSV constants
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.CSV_DATASOURCE_PROPERTY)) {

			labelMaker(DSActionConstants.CSV_DATASOURCE_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.COLUMN_SEPERATOR_PROPERTY)) {

			labelMaker(DSActionConstants.COLUMN_SEPERATOR_DISPLAY);
		}
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.STARTING_ROW_PROPERTY)) {

			labelMaker(DSActionConstants.STARTING_ROW_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.MAX_ROW_COUNT_PROPERTY)) {

			labelMaker(DSActionConstants.MAX_ROW_COUNT_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.HAS_HEADER_PROPERTY)) {

			labelMaker(DSActionConstants.HAS_HEADER_DISPLAY);
		}

		// Excel

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.EXCEL_DATASOURCE_PROPERTY)) {

			labelMaker(DSActionConstants.EXCEL_DATASOURCE_DISPLAY);
		}

		// JDNI type

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.JNDI_CONTEXT_PROPERTY)) {

			labelMaker(DSActionConstants.JNDI_CONTEXT_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.JNDI_PROVIDER_URL_PROPERTY)) {

			labelMaker(DSActionConstants.JNDI_PROVIDER_URL_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.JNDI_RESOURCE_PROPERTY)) {

			labelMaker(DSActionConstants.JNDI_RESOURCE_DISPLAY);
		}
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.JNDI_PASSWORD_PROPERTY)) {

			labelMaker(DSActionConstants.JNDI_PASSWORD_DISPLAY);
		}

		// Gspread
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.GSPREAD_DATASOURCE_PROPERTY)) {

			labelMaker(DSActionConstants.GSPREAD_DATASOURCE_DISPLAY);
		}
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.GSPREAD_VISIBILITY_PROPERTY)) {

			labelMaker(DSActionConstants.GSPREAD_VISIBILITY_DISPLAY);
		}
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.GSPREAD_USERNAME_PROPERTY)) {

			labelMaker(DSActionConstants.GSPREAD_USERNAME_DISPLAY);
		}
		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.GSPREAD_PASSWORD_PROPERTY)) {

			labelMaker(DSActionConstants.GSPREAD_PASSWORD_DISPLAY);
		}

		// Carbon data Source

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.CARBON_DATASOURCE_NAME_PROPERTY)) {

			labelMaker(DSActionConstants.CARBON_DATASOURCE_NAME_DISPLAY);
		}

		if (configProperty.getName() != null
				&& configProperty.getName().equals(
						DSActionConstants.ENABLE_AUTO_COMMIT)) {

			sectionUtil.getBooleanComboWithStringPersistance(detailsclient,
					toolkit, configProperty, configProperty.getValue(),
					DsPackage.eINSTANCE.getConfigurationProperty_Value());

		} else if (configProperty.getName() != null
				&& (configProperty.getName().equals(
						DSActionConstants.PASSWORD_PROPERTY) || configProperty
						.getName().equals(DSActionConstants.CASSANDRA_PASSWORD))) {

			sectionUtil.getPassWordField(detailsclient, toolkit,
					configProperty, configProperty.getValue(),
					DsPackage.eINSTANCE.getConfigurationProperty_Value(),
					DetailSectionCustomUiConstants.STRING);

		} else {
			sectionUtil.getAttributeField(detailsclient, toolkit,
					configProperty, configProperty.getValue(),
					DsPackage.eINSTANCE.getConfigurationProperty_Value(),
					DetailSectionCustomUiConstants.STRING);
		}

	}

	private void queryObjectConfigurator(Query query) {
		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(query);
		voidMaker();
		voidMaker();
		Text keyColText = null;
		Combo rgkCombo = null;
		Label keyColLabel = null;

		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(query);

			if (desc.getFeature(query) instanceof EAttributeImpl) {

				if (displayName.equals(DetailSectionCustomUiConstants.QUERY_ID)) {

					labelMaker(displayName);

					sectionUtil.getAttributeField(detailsclient, toolkit,
							query, query.getId(),
							DsPackage.eINSTANCE.getQuery_Id(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.QUERY_USE_CONFIG)
						&& dataService != null) {

					EList<DataSourceConfiguration> configList = dataService
							.getConfig();

					DataSourceConfiguration[] confArr = configList
							.toArray(new DataSourceConfiguration[0]);

					String[] displayValues = new String[confArr.length];

					for (int j = 0; j < confArr.length; j++) {

						displayValues[j] = confArr[j].getId();

					}

					labelMaker(displayName);
					sectionUtil.getCustomComboField(detailsclient, toolkit,
							query, query.getUseConfig(),
							DsPackage.eINSTANCE.getQuery_UseConfig(),
							displayValues);

					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.QUERY_INPUT_EVENT_TRIGGER)
						&& dataService != null) {

					EList<EventTrigger> eventList = dataService
							.getEventTrigger();

					EventTrigger[] eventArr = eventList
							.toArray(new EventTrigger[0]);

					String[] displayValues = new String[eventArr.length];

					for (int j = 0; j < eventArr.length; j++) {

						displayValues[j] = eventArr[j].getId();
					}

					labelMaker(displayName);

					sectionUtil.getCustomComboField(detailsclient, toolkit,
							query, query.getInputEventTrigger(),
							DsPackage.eINSTANCE.getQuery_InputEventTrigger(),
							displayValues);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.QUERY_OUTPUT_EVENT_TRIGGER)) {

					EList<EventTrigger> eventList = dataService
							.getEventTrigger();

					EventTrigger[] eventArr = eventList
							.toArray(new EventTrigger[0]);

					String[] displayValues = new String[eventArr.length];

					for (int j = 0; j < eventArr.length; j++) {

						displayValues[j] = eventArr[j].getId();
					}

					labelMaker(displayName);

					sectionUtil.getCustomComboField(detailsclient, toolkit,
							query, query.getOutputEventTrigger(),
							DsPackage.eINSTANCE.getQuery_OutputEventTrigger(),
							displayValues);
					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.QUERY_RETURN_GENERATED_KEYS)) {

					labelMaker(displayName);

					rgkCombo = sectionUtil.getBooleanComboField(detailsclient,
							toolkit, query, query.isReturnGeneratedKeys(),
							DsPackage.eINSTANCE.getQuery_ReturnGeneratedKeys());

					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.QUERY_KEY_COLUMNS)) {

					keyColLabel = labelMaker(displayName);

					keyColText = sectionUtil.getAttributeField(detailsclient,
							toolkit, query, query.getKeyColumns(),
							DsPackage.eINSTANCE.getQuery_KeyColumns(),
							DetailSectionCustomUiConstants.STRING);

					if (rgkCombo != null && rgkCombo.getSelectionIndex() == 1) {

						keyColLabel.setVisible(false);
						keyColText.setVisible(false);

					}

					if (rgkCombo != null && keyColText != null
							&& keyColLabel != null) {
						addSelectionListnerForRgkCombo(rgkCombo, keyColText,
								keyColLabel);
					}
					voidMaker();
					voidMaker();

				}

			}

		}
	}

	private void addSelectionListnerForRgkCombo(final Combo rgkCombo,
			final Text keyColText, final Label keyColLabel) {

		rgkCombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				if (rgkCombo.getSelectionIndex() == 0) {

					keyColText.setVisible(true);
					keyColLabel.setVisible(true);
				} else {

					keyColText.setVisible(false);
					keyColLabel.setVisible(false);
					keyColText.setText("");
				}
			}
		});
	}

	private void queryPropertyObjectConfigurator(QueryProperty queryProperty) {
		voidMaker();
		voidMaker();

		if (queryProperty.getName() != null
				&& queryProperty.getName().equals(
						DetailSectionCustomUiConstants.QUERY_TIMEOUT)) {

			labelMaker(DetailSectionCustomUiConstants.QUERY_TIMEOUT_DISPLAY);
		}

		if (queryProperty.getName() != null
				&& queryProperty.getName().equals(
						DetailSectionCustomUiConstants.FETCH_DIRECTION)) {

			labelMaker(DetailSectionCustomUiConstants.FETCH_DIRECTION_DISPLAY);
		}

		if (queryProperty.getName() != null
				&& queryProperty.getName().equals(
						DetailSectionCustomUiConstants.FETCH_SIZE)) {

			labelMaker(DetailSectionCustomUiConstants.FETCH_SIZE_DISPLAY);
		}

		if (queryProperty.getName() != null
				&& queryProperty.getName().equals(
						DetailSectionCustomUiConstants.MAX_FIELD_SIZE)) {

			labelMaker(DetailSectionCustomUiConstants.MAX_FIELD_SIZE_DISPLAY);
		}

		if (queryProperty.getName() != null
				&& queryProperty.getName().equals(
						DetailSectionCustomUiConstants.MAX_ROWS)) {

			labelMaker(DetailSectionCustomUiConstants.MAX_ROWS_DISPLAY);
		}

		sectionUtil.getAttributeField(detailsclient, toolkit, queryProperty,
				queryProperty.getValue(),
				DsPackage.eINSTANCE.getQueryProperty_Value(),
				DetailSectionCustomUiConstants.STRING);

		// TODO add other properties as well
	}

	private void resultObjectConfigurator(ResultMapping result) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(result);
		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(result);

			if (desc.getFeature(result) instanceof EAttributeImpl) {

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESULT_GROUPED_BY_ELEMENT)) {

					labelMaker(DetailSectionCustomUiConstants.RESULT_GROUPED_BY_ELEMENT);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							result, result.getElementName(),
							DsPackage.eINSTANCE.getResultMapping_ElementName(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESULT_ROW_NAME)) {

					labelMaker(DetailSectionCustomUiConstants.RESULT_ROW_NAME);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							result, result.getRowName(),
							DsPackage.eINSTANCE.getResultMapping_RowName(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESULT_ROW_NAMESPACE)) {

					labelMaker(DetailSectionCustomUiConstants.RESULT_ROW_NAMESPACE);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							result, result.getDefaultNamespace(),
							DsPackage.eINSTANCE
									.getResultMapping_DefaultNamespace(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESULT_XSLT_PATH)) {

					// TODO implement or re-use existing XSLT path confgurator.
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESULT_USE_COLUMN_NUMBERS)) {

					labelMaker(DetailSectionCustomUiConstants.RESULT_USE_COLUMN_NUMBERS);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							result, result.isUseColumnNumbers(),
							DsPackage.eINSTANCE
									.getResultMapping_UseColumnNumbers());
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESULT_ESCAPE_NONPRINTABLE_CHAR)) {

					labelMaker(DetailSectionCustomUiConstants.RESULT_ESCAPE_NONPRINTABLE_CHAR);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							result, result.isEscapeNonPrintableChar(),
							DsPackage.eINSTANCE
									.getResultMapping_EscapeNonPrintableChar());
					voidMaker();
					voidMaker();
				}
				
				if (displayName
                        .equals(DetailSectionCustomUiConstants.RESULT_OUTPUT_TYPE)) {

				    labelMaker(DetailSectionCustomUiConstants.RESULT_OUTPUT_TYPE_LABEL);
				    sectionUtil.getAttributeField(detailsclient, toolkit,
                            result, result.getOutputType(),
                            DsPackage.eINSTANCE.getResultMapping_OutputType(),
                            DetailSectionCustomUiConstants.STRING);
                    voidMaker();
                    voidMaker();
                }

			}
		}
	}

	private void elementMappingObjectConfigurator(final ElementMapping element,
			boolean makeItComplex) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(element);
		// ///////////////////////////////////////////////////
		if (!makeItComplex) {
			String initialVal = "";
			String[] typeCombodisplayValues = {
					DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_0,
					DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_1 };

			if (element.getQueryParam() != null
					&& !element.getQueryParam().equals("")) {

				initialVal = DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_1;
			} else if (element.getColumn() != null
					&& !element.getColumn().equals("")) {

				initialVal = DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_0;
			}

			labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_DATA_SOURCE_TYPE);

			paramTypeCombo = sectionUtil.getCustomComboField(detailsclient,
					toolkit, null, initialVal, null, typeCombodisplayValues);

			paramTypeCombo.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {

					if (paramTypeCombo.getSelectionIndex() == 0) {

						queryParamLabel.setEnabled(false);
						queryParamText.setEnabled(false);
						queryParamText.setBackground(gray);
						queryParamText.setText("");

						if (!columnLabel.isEnabled()) {
							columnLabel.setEnabled(true);
						}
						if (!columnTxt.isEnabled()) {
							columnTxt.setEnabled(true);

							columnTxt.setBackground(white);
						}

						if (element.getQueryParam() != null) {

							EcoreUtil
									.remove(element,
											DsPackage.Literals.ELEMENT_MAPPING__QUERY_PARAM,
											element.getQueryParam());

						}

					} else if (paramTypeCombo.getSelectionIndex() == 1) {

						columnLabel.setEnabled(false);
						columnTxt.setEnabled(false);
						columnTxt.setBackground(gray);
						columnTxt.setText("");

						if (!queryParamLabel.isEnabled()) {
							queryParamLabel.setEnabled(true);
						}
						if (!queryParamText.isEnabled()) {
							queryParamText.setEnabled(true);

							queryParamText.setBackground(white);
						}

						if (element.getColumn() != null) {

							EcoreUtil.remove(element,
									DsPackage.Literals.ELEMENT_MAPPING__COLUMN,
									element.getColumn());
						}

					}

				}
			});
		}
		// ///////////////////////////////////////////
		voidMaker();
		voidMaker();

		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(element);

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OUTPUT_FIELD)) {

				if (!makeItComplex) {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OUTPUT_FIELD);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							element, element.getName(),
							DsPackage.eINSTANCE.getElementMapping_Name(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				} else {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_COMPLEX_NAME);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							element, element.getName(),
							DsPackage.eINSTANCE.getElementMapping_Name(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_COLUMN_NAME)) {

				if (!makeItComplex) {
					// Fixed TOOLS-1012.
					String labelString = DetailSectionCustomUiConstants.ELEMENT_MAPPING_COLUMN_NAME;

					if (element != null) {

						Object result = editingDomain.getParent(element);

						if (result != null
								&& editingDomain.getParent(element) instanceof ResultMapping) {

							ResultMapping resultMapping = (ResultMapping) result;

							if (resultMapping.isUseColumnNumbers()) {

								labelString = DetailSectionCustomUiConstants.ELEMENT_MAPPING_COLUMN_NUMBUR;
							}

						}
					}

					columnLabel = labelMaker(labelString);
					columnTxt = sectionUtil.getAttributeField(detailsclient,
							toolkit, element, element.getColumn(),
							DsPackage.eINSTANCE.getElementMapping_Column(),
							DetailSectionCustomUiConstants.STRING);

					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_QUERY_PARAM)) {
				if (!makeItComplex) {
					queryParamLabel = labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_QUERY_PARAM);
					queryParamText = sectionUtil.getAttributeField(
							detailsclient, toolkit, element,
							element.getQueryParam(),
							DsPackage.eINSTANCE.getElementMapping_QueryParam(),
							DetailSectionCustomUiConstants.STRING);

					if (element.getQueryParam() == null) {

						queryParamLabel.setEnabled(false);
						queryParamText.setEnabled(false);
						queryParamText.setBackground(gray);
					}
					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_EXPORT)) {
				if (!makeItComplex) {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_EXPORT);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							element, element.getExport(),
							DsPackage.eINSTANCE.getElementMapping_Export(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_EXPORT_TYPE)) {
				if (!makeItComplex) {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_EXPORT_TYPE);
					String[] displayValues = { "SCALAR", "ARRAY" };
					sectionUtil.getCustomComboField(detailsclient, toolkit,
							element, element.getExportType(),
							DsPackage.eINSTANCE.getElementMapping_ExportType(),
							displayValues);
					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_SCHEMA_TYPE)) {
				if (!makeItComplex) {
					String[] displayValues = { "xs:string", "xs:integer",
							"xs:boolean", "xs:float", "xs:double",
							"xs:decimal", "xs:dateTime", "xs:time", "xs:date",
							"xs:long", "xs:base64Binary" };
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_SCHEMA_TYPE);
					sectionUtil.getCustomComboField(detailsclient, toolkit,
							element, element.getXsdType(),
							DsPackage.eINSTANCE.getElementMapping_XsdType(),
							displayValues);
					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_DAFAULT_VALUE)) {
				if (!makeItComplex) {

					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_DAFAULT_VALUE);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							element, element.getValue(),
							DsPackage.eINSTANCE.getElementMapping_Value(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPING_ALLOWED_USER_ROLES)) {
				if (!makeItComplex) {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPING_ALLOWED_USER_ROLES);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							element, element.getRequiredRoles(),
							DsPackage.eINSTANCE
									.getElementMapping_RequiredRoles(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_NAMESPACE)) {

				labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_NAMESPACE);
				sectionUtil.getAttributeField(detailsclient, toolkit, element,
						element.getNamespace(),
						DsPackage.eINSTANCE.getElementMapping_Namespace(),
						DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OPTIONAL_PARAM)) {
				if (!makeItComplex) {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OPTIONAL_PARAM);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							element, element.isOptional(),
							DsPackage.eINSTANCE.getElementMapping_Optional());
				}
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_ARRAY_NAME)) {
				if (!makeItComplex) {
					labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_ARRAY_NAME);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							element, element.getArrayName(),
							DsPackage.eINSTANCE.getElementMapping_ArrayName(),
							DetailSectionCustomUiConstants.STRING);
				}
				voidMaker();
				voidMaker();
			}

		}

		if (makeItComplex) {

			EcoreUtil.remove(element,
					DsPackage.Literals.ELEMENT_MAPPING__EXPORT_TYPE,
					element.getExportType());
			EcoreUtil.remove(element,
					DsPackage.Literals.ELEMENT_MAPPING__XSD_TYPE,
					element.getXsdType());

		}

	}

	private void attributeMappingObjectConfiguretor(
			AttributeMapping attributeMapping) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(attributeMapping);
		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(attributeMapping);

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OUTPUT_FIELD)) {

				labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OUTPUT_FIELD);
				sectionUtil.getAttributeField(detailsclient, toolkit,
						attributeMapping, attributeMapping.getName(),
						DsPackage.eINSTANCE.getAttributeMapping_Name(),
						DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_COLUMN_NAME)) {

				// Fixed TOOLS-1012.
				String labelString = DetailSectionCustomUiConstants.ELEMENT_MAPPING_COLUMN_NAME;

				if (attributeMapping != null) {

					Object result = editingDomain.getParent(attributeMapping);

					if (result != null
							&& editingDomain.getParent(attributeMapping) instanceof ResultMapping) {

						ResultMapping resultMapping = (ResultMapping) result;

						if (resultMapping.isUseColumnNumbers()) {

							labelString = DetailSectionCustomUiConstants.ELEMENT_MAPPING_COLUMN_NUMBUR;
						}

					}
				}
				labelMaker(labelString);
				sectionUtil.getAttributeField(detailsclient, toolkit,
						attributeMapping, attributeMapping.getColumn(),
						DsPackage.eINSTANCE.getAttributeMapping_Column(),
						DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_SCHEMA_TYPE)) {

				String[] displayValues = { "xs:string", "xs:integer",
						"xs:boolean", "xs:float", "xs:double", "xs:decimal",
						"xs:dateTime", "xs:time", "xs:date", "xs:long",
						"xs:base64Binary" };
				labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_SCHEMA_TYPE);
				sectionUtil.getCustomComboField(detailsclient, toolkit,
						attributeMapping, attributeMapping.getXsdType(),
						DsPackage.eINSTANCE.getAttributeMapping_XsdType(),
						displayValues);
				voidMaker();
				voidMaker();
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPING_ALLOWED_USER_ROLES)) {

				labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPING_ALLOWED_USER_ROLES);
				sectionUtil
						.getAttributeField(detailsclient, toolkit,
								attributeMapping, attributeMapping
										.getRequiredRoles(),
								DsPackage.eINSTANCE
										.getAttributeMapping_RequiredRoles(),
								DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OPTIONAL_PARAM)) {

				labelMaker(DetailSectionCustomUiConstants.ELEMENT_MAPPING_OPTIONAL_PARAM);
				sectionUtil.getBooleanComboField(detailsclient, toolkit,
						attributeMapping, attributeMapping.isOptional(),
						DsPackage.eINSTANCE.getAttributeMapping_Optional());
			}
		}
	}

	private void queryParamObjectConfigurator(QueryParameter queryParam) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(queryParam);

		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(queryParam);

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_DEFAULT_VAL)) {

				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_DEFAULT_VAL);
				sectionUtil.getAttributeField(detailsclient, toolkit,
						queryParam, queryParam.getDefaultValue(),
						DsPackage.eINSTANCE.getQueryParameter_DefaultValue(),
						DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_MAPPING_NAME)) {

				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_MAPPING_NAME);
				sectionUtil.getAttributeField(detailsclient, toolkit,
						queryParam, queryParam.getName(),
						DsPackage.eINSTANCE.getQueryParameter_Name(),
						DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();
			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_ORDINAL)) {

				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_ORDINAL);
				String ordinal = new Integer(queryParam.getOrdinal())
						.toString();
				sectionUtil.getAttributeField(detailsclient, toolkit,
						queryParam, ordinal,
						DsPackage.eINSTANCE.getQueryParameter_Ordinal(),
						DetailSectionCustomUiConstants.INTEGER);
				voidMaker();
				voidMaker();

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_TYPE)) {

				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_TYPE);
				String[] displayValues = { "SCALAR", "ARRAY" };
				Combo paramTypeCombo = sectionUtil.getCustomComboField(
						detailsclient, toolkit, queryParam,
						queryParam.getParamType(),
						DsPackage.eINSTANCE.getQueryParameter_ParamType(),
						displayValues);
				voidMaker();
				voidMaker();

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_SQL_TYPE)) {

				String[] displayValues = { "STRING", "INTEGER", "REAL",
						"DOUBLE", "NUMERIC", "TINYINT", "SMALLINT", "BIGINT",
						"DATE", "TIME", "TIMESTAMP", "BIT",
						"ORACLE_REF_CURSOR", "BINARY" };
				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_SQL_TYPE);
				Combo sqlTypeCombo = sectionUtil.getCustomComboField(
						detailsclient, toolkit, queryParam,
						queryParam.getSqlType(),
						DsPackage.eINSTANCE.getQueryParameter_SqlType(),
						displayValues);
				voidMaker();
				voidMaker();

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_STRUCT_TYPE)) {

				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_STRUCT_TYPE);
				sectionUtil.getAttributeField(detailsclient, toolkit,
						queryParam, queryParam.getStructType(),
						DsPackage.eINSTANCE.getQueryParameter_StructType(),
						DetailSectionCustomUiConstants.STRING);
				voidMaker();
				voidMaker();

			}

			if (displayName
					.equals(DetailSectionCustomUiConstants.QUERY_PARAM_IN_OUT)) {

				String[] displayValues = { "IN", "OUT" };
				labelMaker(DetailSectionCustomUiConstants.QUERY_PARAM_IN_OUT);
				String intialValue = queryParam.getType();

				sectionUtil.getCustomComboField(detailsclient, toolkit,
						queryParam, intialValue,
						DsPackage.eINSTANCE.getQueryParameter_Type(),
						displayValues);
				voidMaker();
				voidMaker();
			}
		}

	}

	private void validatorObjectConfigurator(Object validatorObject, String type) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(validatorObject);

		voidMaker();
		voidMaker();

		if (validatorObject instanceof LongRangeValidator
				&& type.equals(DetailSectionCustomUiConstants.LONG)) {

			LongRangeValidator lval = (LongRangeValidator) validatorObject;
			for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
					.iterator(); i.hasNext();) {

				ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

				String displayName = desc.getDisplayName(validatorObject);

				if (displayName
						.equals(DetailSectionCustomUiConstants.VALIDATOR_MAXIMUM)) {

					String initVal = new Long(lval.getMaximum()).toString();
					labelMaker(DetailSectionCustomUiConstants.VALIDATOR_MAXIMUM);
					sectionUtil
							.getAttributeField(detailsclient, toolkit, lval,
									initVal, DsPackage.eINSTANCE
											.getLongRangeValidator_Maximum(),
									DetailSectionCustomUiConstants.LONG);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.VALIDATOR_MINIMUM)) {

					String initVal = new Long(lval.getMinimum()).toString();
					labelMaker(DetailSectionCustomUiConstants.VALIDATOR_MINIMUM);
					sectionUtil
							.getAttributeField(detailsclient, toolkit, lval,
									initVal, DsPackage.eINSTANCE
											.getLongRangeValidator_Minimum(),
									DetailSectionCustomUiConstants.LONG);
					voidMaker();
					voidMaker();
				}
			}
		} else if (validatorObject instanceof DoubleRangeValidator
				&& type.equals(DetailSectionCustomUiConstants.DOUBLE)) {

			DoubleRangeValidator dval = (DoubleRangeValidator) validatorObject;
			for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
					.iterator(); i.hasNext();) {

				ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

				String displayName = desc.getDisplayName(validatorObject);

				if (displayName
						.equals(DetailSectionCustomUiConstants.VALIDATOR_MAXIMUM)) {

					String initVal = new Double(dval.getMaximum()).toString();
					labelMaker(DetailSectionCustomUiConstants.VALIDATOR_MAXIMUM);
					sectionUtil.getAttributeField(detailsclient, toolkit, dval,
							initVal, DsPackage.eINSTANCE
									.getDoubleRangeValidator_Maximum(),
							DetailSectionCustomUiConstants.DOUBLE);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.VALIDATOR_MINIMUM)) {

					String initVal = new Double(dval.getMinimum()).toString();
					labelMaker(DetailSectionCustomUiConstants.VALIDATOR_MINIMUM);
					sectionUtil.getAttributeField(detailsclient, toolkit, dval,
							initVal, DsPackage.eINSTANCE
									.getDoubleRangeValidator_Minimum(),
							DetailSectionCustomUiConstants.DOUBLE);
					voidMaker();
					voidMaker();
				}
			}
		} else if (validatorObject instanceof LengthValidator
				&& type.equals(DetailSectionCustomUiConstants.LONG)) {

			LengthValidator lval = (LengthValidator) validatorObject;

			for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
					.iterator(); i.hasNext();) {

				ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

				String displayName = desc.getDisplayName(validatorObject);

				if (displayName
						.equals(DetailSectionCustomUiConstants.VALIDATOR_MAXIMUM)) {

					String initVal = new Long(lval.getMaximum()).toString();
					labelMaker(DetailSectionCustomUiConstants.VALIDATOR_MAXIMUM);
					sectionUtil.getAttributeField(detailsclient, toolkit, lval,
							initVal,
							DsPackage.eINSTANCE.getLengthValidator_Maximum(),
							DetailSectionCustomUiConstants.LONG);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.VALIDATOR_MINIMUM)) {

					String initVal = new Long(lval.getMinimum()).toString();
					labelMaker(DetailSectionCustomUiConstants.VALIDATOR_MINIMUM);
					sectionUtil.getAttributeField(detailsclient, toolkit, lval,
							initVal,
							DsPackage.eINSTANCE.getLengthValidator_Minimum(),
							DetailSectionCustomUiConstants.LONG);
					voidMaker();
					voidMaker();
				}
			}
		}

	}

	private void eventTriggerObejecConfigurator(EventTrigger eventTrigger) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(eventTrigger);
		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(eventTrigger);

			if (desc.getFeature(eventTrigger) instanceof EAttributeImpl) {

				if (displayName
						.equals(DetailSectionCustomUiConstants.EVENT_TRIGGER_ID)) {

					labelMaker(DetailSectionCustomUiConstants.EVENT_TRIGGER_ID);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							eventTrigger, eventTrigger.getId(),
							DsPackage.eINSTANCE.getEventTrigger_Id(),
							DetailSectionCustomUiConstants.STRING);

					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.EVENT_TRIGGER_LANGUAGE)) {

					labelMaker(DetailSectionCustomUiConstants.EVENT_TRIGGER_LANGUAGE);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							eventTrigger, eventTrigger.getLanguage(),
							DsPackage.eINSTANCE.getEventTrigger_Language(),
							DetailSectionCustomUiConstants.STRING);

				}
			}

		}
	}

	private void operationObjectConfigurator(Operation operation) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(operation);
		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(operation);

			if (desc.getFeature(operation) instanceof EAttributeImpl) {

				if (displayName
						.equals(DetailSectionCustomUiConstants.OPERATION_NAME)) {

					labelMaker(DetailSectionCustomUiConstants.OPERATION_NAME);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							operation, operation.getName(),
							DsPackage.eINSTANCE.getOperation_Name(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.OPERATION_DISABLE_STREAMING)) {

					labelMaker(DetailSectionCustomUiConstants.OPERATION_DISABLE_STREAMING);
					sectionUtil
							.getBooleanComboField(detailsclient, toolkit,
									operation, operation.isDisableStreaming(),
									DsPackage.eINSTANCE
											.getOperation_DisableStreaming());
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.OPERATION_RETURN_REQUEST_STATUS)) {

					labelMaker(DetailSectionCustomUiConstants.OPERATION_RETURN_REQUEST_STATUS);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							operation, operation.isReturnRequestStatus(),
							DsPackage.eINSTANCE
									.getOperation_ReturnRequestStatus());

				}
			}
		}
	}

	private void paramMapObjectConfigurator(final ParameterMapping paramMapping) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(paramMapping);
		voidMaker();
		voidMaker();

		String initialVal = "";
		String[] displayValues = {
				DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_0,
				DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_1 };

		if (paramMapping.getQueryParam() != null
				&& !paramMapping.getQueryParam().equals("")) {

			initialVal = DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_1;
		} else if (paramMapping.getColumn() != null
				&& !paramMapping.getColumn().equals("")) {

			initialVal = DetailSectionCustomUiConstants.PARAM_MAPPING_COMBO_VAL_0;
		}

		labelMaker(DetailSectionCustomUiConstants.PARAM_MAPPING_TYPE);

		paramTypeCombo = sectionUtil.getCustomComboField(detailsclient,
				toolkit, null, initialVal, null, displayValues);

		paramTypeCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {

				if (paramTypeCombo.getSelectionIndex() == 0) {

					queryParamLabel.setEnabled(false);
					queryParamText.setEnabled(false);
					queryParamText.setBackground(gray);
					queryParamText.setText("");

					if (!columnLabel.isEnabled()) {
						columnLabel.setEnabled(true);
					}
					if (!columnTxt.isEnabled()) {
						columnTxt.setEnabled(true);

						columnTxt.setBackground(white);
					}

					if (paramMapping.getQueryParam() != null) {

						EcoreUtil
								.remove(paramMapping,
										DsPackage.Literals.PARAMETER_MAPPING__QUERY_PARAM,
										paramMapping.getQueryParam());

					}

				} else if (paramTypeCombo.getSelectionIndex() == 1) {

					columnLabel.setEnabled(false);
					columnTxt.setEnabled(false);
					columnTxt.setBackground(gray);
					columnTxt.setText("");

					if (!queryParamLabel.isEnabled()) {
						queryParamLabel.setEnabled(true);
					}
					if (!queryParamText.isEnabled()) {
						queryParamText.setEnabled(true);

						queryParamText.setBackground(white);
					}

					if (paramMapping.getColumn() != null) {

						EcoreUtil.remove(paramMapping,
								DsPackage.Literals.PARAMETER_MAPPING__COLUMN,
								paramMapping.getColumn());
					}

				}

			}
		});

		voidMaker();
		voidMaker();

		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(paramMapping);

			if (desc.getFeature(paramMapping) instanceof EAttributeImpl) {

				if (displayName
						.equals(DetailSectionCustomUiConstants.PARAM_MAPPING_PARAM_NAME)) {

					labelMaker(DetailSectionCustomUiConstants.PARAM_MAPPING_PARAM_NAME);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							paramMapping, paramMapping.getName(),
							DsPackage.eINSTANCE.getParameterMapping_Name(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.PARAM_MAPPING_PARAM)) {

					queryParamLabel = labelMaker(DetailSectionCustomUiConstants.PARAM_MAPPING_PARAM);
					queryParamText = sectionUtil.getAttributeField(
							detailsclient, toolkit, paramMapping, paramMapping
									.getQueryParam(), DsPackage.eINSTANCE
									.getParameterMapping_QueryParam(),
							DetailSectionCustomUiConstants.STRING);
					if (paramMapping.getQueryParam() == null) {

						queryParamLabel.setEnabled(false);
						queryParamText.setEnabled(false);
						queryParamText.setBackground(gray);
					}
					voidMaker();
					voidMaker();

				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.PARAM_MAPPING_COLUMN)) {

					columnLabel = labelMaker(DetailSectionCustomUiConstants.PARAM_MAPPING_COLUMN);
					columnTxt = sectionUtil.getAttributeField(detailsclient,
							toolkit, paramMapping, paramMapping.getColumn(),
							DsPackage.eINSTANCE.getParameterMapping_Column(),
							DetailSectionCustomUiConstants.STRING);
					if (paramMapping.getColumn() == null) {

						columnLabel.setEnabled(false);
						columnTxt.setEnabled(false);
						columnTxt.setBackground(gray);
					}
					voidMaker();
					voidMaker();

				}
			}
		}

	}

	private void resourceObjectConfigurator(Resource resource) {

		ArrayList<IItemPropertyDescriptor> detailPropertyDescriptors = (ArrayList<IItemPropertyDescriptor>) adapterFactoryItemDelegator
				.getPropertyDescriptors(resource);
		voidMaker();
		voidMaker();
		for (Iterator<IItemPropertyDescriptor> i = detailPropertyDescriptors
				.iterator(); i.hasNext();) {

			ItemPropertyDescriptor desc = (ItemPropertyDescriptor) i.next();

			String displayName = desc.getDisplayName(resource);

			if (desc.getFeature(resource) instanceof EAttributeImpl) {

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESOUCE_PATH)) {

					labelMaker(DetailSectionCustomUiConstants.RESOUCE_PATH);
					sectionUtil.getAttributeField(detailsclient, toolkit,
							resource, resource.getPath(),
							DsPackage.eINSTANCE.getResource_Path(),
							DetailSectionCustomUiConstants.STRING);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESOURCE_METHOD)) {

					String[] displayValues = { "GET", "PUT", "POST", "DELETE" };
					labelMaker(DetailSectionCustomUiConstants.RESOURCE_METHOD);
					sectionUtil.getCustomComboField(detailsclient, toolkit,
							resource, resource.getMethod(),
							DsPackage.eINSTANCE.getResource_Method(),
							displayValues);
					voidMaker();
					voidMaker();
				}

				if (displayName
						.equals(DetailSectionCustomUiConstants.RESOURCE_RETURN_REQUEST_STATUS)) {

					labelMaker(DetailSectionCustomUiConstants.RESOURCE_RETURN_REQUEST_STATUS);
					sectionUtil.getBooleanComboField(detailsclient, toolkit,
							resource, resource.isReturnRequestStatus(),
							DsPackage.eINSTANCE
									.getResource_ReturnRequestStatus());

				}

			}

		}

	}

}
