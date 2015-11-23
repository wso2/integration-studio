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

import java.math.BigInteger;
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
import org.wso2.developerstudio.eclipse.ds.DsFactory;
import org.wso2.developerstudio.eclipse.ds.DsPackage;
import org.wso2.developerstudio.eclipse.ds.ExcelQuery;
import org.wso2.developerstudio.eclipse.ds.GSpreadQuery;
import org.wso2.developerstudio.eclipse.ds.HasHeader;
import org.wso2.developerstudio.eclipse.ds.MaxRowCount;
import org.wso2.developerstudio.eclipse.ds.Query;
import org.wso2.developerstudio.eclipse.ds.QueryProperty;
import org.wso2.developerstudio.eclipse.ds.QueryPropertyList;
import org.wso2.developerstudio.eclipse.ds.StartingRow;
import org.wso2.developerstudio.eclipse.ds.WorkSheetNumber;
import org.wso2.developerstudio.eclipse.ds.impl.ConfigurationPropertyImpl;
import org.wso2.developerstudio.eclipse.ds.impl.DataSourceConfigurationImpl;
import org.wso2.developerstudio.eclipse.ds.provider.DsEditPlugin;

/**
 * Defines the actions under a query element.
 */
public class QueryAction extends StaticSelectionCommandAction {

	/** The selection. */
	private ISelection selection;

	/** The new child descriptors. */
	private Collection<?> newChildDescriptors;

	/** The image url. */
	private String imageURL;

	/** The config. */
	private DataSourceConfigurationImpl config;

	/** The is rdbms query. */
	public boolean isRDBMSQuery = false;

	/** The is spread sheet query. */
	public boolean isSpreadSheetQuery = false;

	/** The is g spread query. */
	public boolean isGSpreadQuery = false;

	/** The is jndi query. */
	public boolean isJNDIQuery = false;

	/** The is carbon query. */
	public boolean isCarbonQuery = false;

	/** The list of query properties. */
	private List<String> listOfQueryProperties;

	/**
	 * Instantiates a new query action.
	 * 
	 * @param selection
	 *            the selection
	 * @param editingDomain
	 *            the editing domain
	 * @param newChildDescriptors
	 *            the new child descriptors
	 * @param config
	 *            the config
	 */
	public QueryAction(ISelection selection, EditingDomain editingDomain,
	                   Collection<?> newChildDescriptors, DataSourceConfigurationImpl config) {

		super(editingDomain);
		this.selection = selection;
		this.newChildDescriptors = newChildDescriptors;
		this.config = config;
		imageURL = "wso2/query";
		configureAction(this.selection);
		this.setText(DSActionConstants.ADD_QUERY_ACTION);
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
	 * Setup query properties.
	 */
	public void setupQueryProperties() {
		listOfQueryProperties = new ArrayList<String>();
		listOfQueryProperties.add(DSActionConstants.QUERY_TIMEOUT);
		listOfQueryProperties.add(DSActionConstants.FETCH_DIRECTION);
		listOfQueryProperties.add(DSActionConstants.FETCH_SIZE);
		listOfQueryProperties.add(DSActionConstants.MAX_FIELD_SIZE);
		listOfQueryProperties.add(DSActionConstants.MAX_ROWS);
	}

	/**
	 * When a config element is right clicked and 'Add Query' is selected this
	 * method will be called.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param collection
	 *            the collection
	 * @return the command
	 */

	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {

		Iterator<ConfigurationProperty> iterator = config.getProperty().iterator();
		while (iterator.hasNext()) {
			String propertyName = ((ConfigurationPropertyImpl) iterator.next()).getName();
			if (propertyName != null) {
				if (propertyName.equals(DSActionConstants.DRIVER_PROPERTY)) {
					isRDBMSQuery = true;
				}
				if (propertyName.equals(DSActionConstants.EXCEL_DATASOURCE_PROPERTY)) {
					isSpreadSheetQuery = true;
				}
				if (propertyName.equals(DSActionConstants.GSPREAD_DATASOURCE_PROPERTY)) {
					isGSpreadQuery = true;
				}
				if (propertyName.equals(DSActionConstants.JNDI_CONTEXT_PROPERTY)) {
					isJNDIQuery = true;
				}
				if (propertyName.equals(DSActionConstants.CARBON_DATASOURCE_NAME_PROPERTY)) {
					isCarbonQuery = true;
				}

				if (collection.size() == 1 && newChildDescriptors != null) {
					// selected element
					Object owner = collection.iterator().next();

					for (Object descriptor : newChildDescriptors) {
						CompoundCommand compoundCmd = new CompoundCommand();
						CommandParameter param = (CommandParameter) descriptor;
						EObject childObj = param.getEValue();
						Command querycmd;
						Query query;

						if (childObj instanceof Query) {

							query = (Query) childObj;
							// set the data source id
							query.setUseConfig(config.getId());

							// Add a query element to the tree
							querycmd =
							           CreateChildCommand.create(editingDomain,
							                                     ((DataSourceConfiguration) owner).eContainer(),
							                                     descriptor, collection);
							compoundCmd.append(querycmd);

							if (isRDBMSQuery || isJNDIQuery || isCarbonQuery) {

								// Set up the query properties
								setupQueryProperties();

								// Generate the properties element
								QueryPropertyList queryPropertyList =
								                                      DsFactory.eINSTANCE.createQueryPropertyList();
								CommandParameter param2 =
								                          new CommandParameter(
								                                               query,
								                                               DsPackage.Literals.QUERY__PROPERTIES,
								                                               queryPropertyList);

								Command cmd2 =
								               CreateChildCommand.create(editingDomain, query,
								                                         param2, collection);

								compoundCmd.append(cmd2);

								// Generate the property elements
								Iterator<String> i = listOfQueryProperties.iterator();

								while (i.hasNext()) {

									QueryProperty queryProperty =
									                              DsFactory.eINSTANCE.createQueryProperty();

									// Edit the query properties

									queryProperty.setName(i.next());
									queryProperty.setValue("");

									CommandParameter param3 =
									                          new CommandParameter(
									                                               queryPropertyList,
									                                               DsPackage.Literals.QUERY_PROPERTY_LIST__PROPERTY,
									                                               queryProperty);
									Command cmd3 =
									               CreateChildCommand.create(editingDomain,
									                                         queryPropertyList,
									                                         param3, collection);

									compoundCmd.append(cmd3);
								}
							}

							if (isSpreadSheetQuery) {
								ExcelQuery excelQuery = DsFactory.eINSTANCE.createExcelQuery();
								HasHeader hasHeader = DsFactory.eINSTANCE.createHasHeader();
								hasHeader.setValue(false);
								excelQuery.setHasheader(hasHeader);

								MaxRowCount mrc = DsFactory.eINSTANCE.createMaxRowCount();
								mrc.setValue(-1);
								excelQuery.setMaxrowcount(mrc);

								StartingRow str = DsFactory.eINSTANCE.createStartingRow();
								str.setValue(1);
								excelQuery.setStartingrow(str);

								CommandParameter param2 =
								                          new CommandParameter(
								                                               query,
								                                               DsPackage.Literals.QUERY__EXCEL,
								                                               excelQuery);
								Command cmd2 =
								               CreateChildCommand.create(editingDomain, query,
								                                         param2, collection);

								compoundCmd.append(cmd2);
								/*
								 * ExcelQuery excelQuery =
								 * DsFactory.eINSTANCE.createExcelQuery();
								 * excelQuery.setHasheader(false);
								 * excelQuery.setMaxrowcount(new
								 * BigInteger("-1"));
								 * excelQuery.setStartingrow(new
								 * BigInteger("1"));
								 * 
								 * CommandParameter param2 = new
								 * CommandParameter(query,
								 * DsPackage.Literals.QUERY__EXCEL, excelQuery);
								 * Command cmd2 =
								 * CreateChildCommand.create(editingDomain,
								 * query, param2,
								 * collection);
								 * 
								 * compoundCmd.append(cmd2);
								 */
							}

							if (isGSpreadQuery) {
								GSpreadQuery gspreadQuery =
								                            DsFactory.eINSTANCE.createGSpreadQuery();

								HasHeader hasHeader = DsFactory.eINSTANCE.createHasHeader();
								hasHeader.setValue(false);
								gspreadQuery.setHasheader(hasHeader);

								WorkSheetNumber wshnum =
								                         DsFactory.eINSTANCE.createWorkSheetNumber();
								wshnum.setValue("1");
								gspreadQuery.setWorksheetnumber(wshnum);

								StartingRow str = DsFactory.eINSTANCE.createStartingRow();
								str.setValue(1);
								gspreadQuery.setStartingrow(str);

								MaxRowCount mrc = DsFactory.eINSTANCE.createMaxRowCount();
								mrc.setValue(1);
								gspreadQuery.setMaxrowcount(mrc);

								CommandParameter param2 =
								                          new CommandParameter(
								                                               query,
								                                               DsPackage.Literals.QUERY__GSPREAD,
								                                               gspreadQuery);
								Command cmd2 =
								               CreateChildCommand.create(editingDomain, query,
								                                         param2, collection);

								compoundCmd.append(cmd2);
								/*
								 * GSpreadQuery gspreadQuery =
								 * DsFactory.eINSTANCE.createGSpreadQuery();
								 * gspreadQuery.setHasheader(false);
								 * gspreadQuery.setWorksheetnumber(new
								 * BigInteger("1"));
								 * gspreadQuery.setStartingrow(new
								 * BigInteger("1"));
								 * gspreadQuery.setMaxrowcount(new
								 * BigInteger("-1"));
								 * 
								 * CommandParameter param2 = new
								 * CommandParameter(query,
								 * DsPackage.Literals.QUERY__GSPREAD,
								 * gspreadQuery);
								 * Command cmd2 =
								 * CreateChildCommand.create(editingDomain,
								 * query, param2,
								 * collection);
								 * 
								 * compoundCmd.append(cmd2);
								 */
							}

							return compoundCmd;
						}
					}
				}
			}
		}

		return UnexecutableCommand.INSTANCE;

	}
}
