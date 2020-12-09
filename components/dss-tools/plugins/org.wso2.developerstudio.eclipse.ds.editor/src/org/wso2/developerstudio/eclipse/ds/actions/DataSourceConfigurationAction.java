/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.ds.actions;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.wso2.developerstudio.eclipse.ds.ConfigurationProperty;
import org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration;
import org.wso2.developerstudio.eclipse.ds.Description;
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.presentation.DsActionBarContributor;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;
import org.wso2.developerstudio.eclipse.ds.provider.DsEditPlugin;

/**
 * Defines the actions under a config element.
 */
public class DataSourceConfigurationAction extends StaticSelectionCommandAction {

	/** The main type. */
	protected String mainType;

	/** The data source type. */
	public String dataSourceType;

	/** The driver value. */
	protected String driverValue;

	/** The protocol value. */
	protected String protocolValue;

	/** The selection. */
	protected ISelection selection;

	/** The new child descriptors. */
	protected Collection<?> newChildDescriptors;

	/** The list of properties. */
	protected List<String> listOfProperties;

	/** The list of values. */
	protected List<String> listOfValues;

	/** The image url. */
	protected String imageURL;

	/**
	 * Instantiates a new data source configuration action.
	 * 
	 * @param selection
	 *            the selection
	 * @param editingDomain
	 *            the editing domain
	 * @param newChildDescriptors
	 *            the new child descriptors
	 * @param mainType
	 *            the main type
	 * @param dataSourceType
	 *            the data source type
	 * @param driverValue
	 *            the driver value
	 * @param protocolValue
	 *            the protocol value
	 */
	public DataSourceConfigurationAction(ISelection selection, EditingDomain editingDomain,
	                                     Collection<?> newChildDescriptors, String mainType,
	                                     String dataSourceType, String driverValue,
	                                     String protocolValue) {
		super(editingDomain);
		this.selection = selection;
		this.newChildDescriptors = newChildDescriptors;
		this.mainType = mainType;
		this.dataSourceType = dataSourceType;
		this.driverValue = driverValue;
		this.protocolValue = protocolValue;

		// If the main type is RDBMS set text to the RDBMS data type e.g. -
		// MySQL, Oracle
		// else the main type is set e.g. - CSV, Excel
		if (mainType.equals(DSActionConstants.RDBMS_TYPE)) {
			this.setText(dataSourceType);
		} else {
			this.setText(mainType);
		}
		setupConfigProperties();
		configureAction(this.selection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction#
	 * getDefaultImageDescriptor()
	 */

	protected ImageDescriptor getDefaultImageDescriptor() {
		URL url = (URL) DsEditPlugin.INSTANCE.getImage(imageURL);
		return ImageDescriptor.createFromURL(url);
	}

	/**
	 * Setup config properties.
	 */
	public void setupConfigProperties() {
		// Different config elements in a data service have different property
		// elements under them.
		// The image icon for each config element is set depending on the type
		// of data source they belong to.

		if (mainType.equals(DSActionConstants.RDBMS_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.USER_PROPERTY);
			listOfProperties.add(DSActionConstants.PASSWORD_PROPERTY);
			listOfProperties.add(DSActionConstants.PROTOCOL_PROPERTY);
			listOfProperties.add(DSActionConstants.DRIVER_PROPERTY);
			listOfProperties.add(DSActionConstants.MINPOOLSIZE_PROPERTY);
			listOfProperties.add(DSActionConstants.MAXPOOLSIZE_PROPERTY);
			listOfProperties.add(DSActionConstants.VALIDATIONQUERY_PROPERTY);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add(protocolValue);
			listOfValues.add(driverValue);
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");

			imageURL = "wso2/rdbms-datatypes";
		}
		
		if (mainType.equals(DSActionConstants.CASSANDRA_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.CASSANDRA_SERVER_URL);
			listOfProperties.add(DSActionConstants.CASSANDRA_USERNAME);
			listOfProperties.add(DSActionConstants.CASSANDRA_PASSWORD);
			listOfProperties.add(DSActionConstants.CASSANDRA_DRIVER_CLASS_NAME);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add(driverValue);

			imageURL = "wso2/cassandra-datasource";
		}

		if (mainType.equals(DSActionConstants.CSV_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.CSV_DATASOURCE_PROPERTY);
			listOfProperties.add(DSActionConstants.COLUMN_SEPERATOR_PROPERTY);
			listOfProperties.add(DSActionConstants.STARTING_ROW_PROPERTY);
			listOfProperties.add(DSActionConstants.MAX_ROW_COUNT_PROPERTY);
			listOfProperties.add(DSActionConstants.HAS_HEADER_PROPERTY);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");

			imageURL = "wso2/csv";
		}

		if (mainType.equals(DSActionConstants.SPREADSHEET_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.EXCEL_DATASOURCE_PROPERTY);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");

			imageURL = "wso2/excel";
		}

		if (mainType.equals(DSActionConstants.JNDI_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.JNDI_CONTEXT_PROPERTY);
			listOfProperties.add(DSActionConstants.JNDI_PROVIDER_URL_PROPERTY);
			listOfProperties.add(DSActionConstants.JNDI_RESOURCE_PROPERTY);
			listOfProperties.add(DSActionConstants.JNDI_PASSWORD_PROPERTY);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");

			imageURL = "wso2/jndi-datasource";
		}

		if (mainType.equals(DSActionConstants.GSPREAD_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.GSPREAD_DATASOURCE_PROPERTY);
			listOfProperties.add(DSActionConstants.GSPREAD_VISIBILITY_PROPERTY);
			listOfProperties.add(DSActionConstants.GSPREAD_USERNAME_PROPERTY);
			listOfProperties.add(DSActionConstants.GSPREAD_PASSWORD_PROPERTY);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");
			listOfValues.add("");

			imageURL = "wso2/gspread";
		}

		if (mainType.equals(DSActionConstants.CARBON_DATASOURCE_TYPE)) {
			listOfProperties = new ArrayList<String>();
			listOfProperties.add(DSActionConstants.CARBON_DATASOURCE_NAME_PROPERTY);

			listOfValues = new ArrayList<String>();
			listOfValues.add("");

			imageURL = "wso2/carbon-datasource";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction#
	 * createActionCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * java.util.Collection)
	 */

	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {

		if (collection.size() == 1 && newChildDescriptors != null) {

			// owner is the DataService element that was selected
			Object owner = collection.iterator().next();
			for (Object descriptor : newChildDescriptors) {

				CommandParameter compar = (CommandParameter) descriptor;
				// ensure that only the DataSourceconfiguration elements are
				// empowerd
				if (compar.getValue() instanceof DataSourceConfiguration) {

					// A compound command can execute several commands at once.
					// A
					// config element and corresponding property elements need
					// to be
					// added, hence a compound command is used.
					CompoundCommand compoundCmd = new CompoundCommand(dataSourceType);

					// configCmd is used to add a config element to the tree
					Command configCmd =
					                    CreateChildCommand.create(editingDomain, owner, descriptor,
					                                              collection);
					CommandParameter param = (CommandParameter) descriptor;

					EObject childObj = param.getEValue();

					// Add the config command to the compound command
					compoundCmd.append(configCmd);

					// From the list of children a Data Source can create, check
					// if
					// childObj is an instance of DataSourceConfiguration.
					if (childObj instanceof DataSourceConfiguration) {

						DataSourceConfiguration child = (DataSourceConfiguration) childObj;
						child.setId("New Data Source");

						// generate the properties
						Iterator<String> i = listOfProperties.iterator();
						Iterator<String> j = listOfValues.iterator();

						while (i.hasNext() && j.hasNext()) {

							// Create a configuration property
							ConfigurationProperty configProperty =
							                                       DsFactory.eINSTANCE.createConfigurationProperty();

							// Set the name and value for the property element
							configProperty.setName(i.next());
							configProperty.setValue(j.next());

							CommandParameter param2 =
							                          new CommandParameter(
							                                               child,
							                                               DsPackage.Literals.DATA_SOURCE_CONFIGURATION__PROPERTY,
							                                               configProperty);
							Command propertyCmd =
							                      CreateChildCommand.create(editingDomain, child,
							                                                param2, collection);

							// Add the property command to the compound command
							compoundCmd.append(propertyCmd);
						}

					}

					return compoundCmd;
				}
			}
		}

		// return a command that cannot be executed
		return UnexecutableCommand.INSTANCE;
	}
}
