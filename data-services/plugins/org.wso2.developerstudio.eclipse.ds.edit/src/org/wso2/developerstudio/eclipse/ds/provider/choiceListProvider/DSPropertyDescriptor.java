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
package org.wso2.developerstudio.eclipse.ds.provider.choiceListProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration;
import org.wso2.developerstudio.eclipse.ds.EventTrigger;
import org.wso2.developerstudio.eclipse.ds.Query;

import com.google.common.collect.Iterators;

public class DSPropertyDescriptor extends ItemPropertyDescriptor {

	public static final int sqlType = 1;
	public static final int inOutType = 2;
	public static final int paramType = 3;
	public static final int outputType = 4;
	public static final int xsdType = 5;
	public static final int resourceMethod = 6;
	public static final int configId = 7;
	public static final int queryId = 8;
	public static final int eventId = 9;
	private int selection;
	private static Object rootObject;
	private static List<String> configList;
	private static List<String> queryList;
	private static List<String> eventTriggerList;

	public DSPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator,
	                            String displayName, String description, EStructuralFeature feature,
	                            boolean isSettable, boolean multiLine, boolean sortChoices,
	                            Object staticImage, String category, String[] filterFlags,
	                            int selection) {
		super(adapterFactory, resourceLocator, displayName, description, feature, isSettable,
		      multiLine, sortChoices, staticImage, category, filterFlags);
		this.selection = selection;
	}

	public Collection<?> getChoiceOfValues(Object object) {
		List<String> list = new ArrayList<String>();
		if (selection == sqlType) {
			list.add("STRING");
			list.add("INTEGER");
			list.add("REAL");
			list.add("DOUBLE");
			list.add("NUMERIC");
			list.add("TINYINT");
			list.add("SMALLINT");
			list.add("BIGINT");
			list.add("DATE[yyyy-mm-dd]");
			list.add("TIME[hh:mm:ss]");
			list.add("TIMESTAMP");
			list.add("BIT");
			list.add("ORACLE REF CURSOR");
			list.add("BINARY");
		}

		if (selection == inOutType) {
			list.add("IN");
			list.add("OUT");
			list.add("IN/OUT");
		}

		if (selection == paramType) {
			list.add("SCALAR");
			list.add("ARRAY");
		}

		if (selection == outputType) {
			list.add("xml");
			list.add("rdf");
		}

		if (selection == xsdType) {
			list.add("xs:string");
			list.add("xs:integer");
			list.add("xs:boolean");
			list.add("xs:float");
			list.add("xs:double");
			list.add("xs:decimal");
			list.add("xs:dateTime");
			list.add("xs:time");
			list.add("xs:date");
			list.add("xs:long");
			list.add("xs:base64Binary");
		}

		if (selection == resourceMethod) {
			list.add("GET");
			list.add("PUT");
			list.add("POST");
			list.add("DELETE");
		}

		if (selection == configId) {
			if (configList != null) {
				Iterator<String> i = configList.iterator();
				while (i.hasNext()) {
					String id = i.next();
					if (id != null && !id.equals("")) {
						list.add(id);
					}
				}
			}
		}

		if (selection == queryId) {
			if (queryList != null) {
				Iterator<String> i = queryList.iterator();
				while (i.hasNext()) {
					String id = i.next();
					if (id != null && !id.equals("")) {
						list.add(id);
					}
				}
			}
		}

		if (selection == eventId) {
			list.add(""); // The user may not want to select an event trigger ID
			if (eventTriggerList != null) {
				Iterator<String> i = eventTriggerList.iterator();
				while (i.hasNext()) {
					String id = i.next();
					if (id != null && !id.equals("")) {
						list.add(id);
					}
				}
			}
		}

		return list;
	}

	public static void populateIds(Object object) {
		populateConfigIds(object);
		populateQueryIds(object);
		populateEventTriggerIds(object);
	}

	public static boolean isReferredConfiguration(Object object) {
		rootObject = EcoreUtil.getRootContainer((EObject) object);
		// Get the Query elements in the tree
		Iterator<Query> queryIterator =
		                                Iterators.filter(((EObject) rootObject).eAllContents(),
		                                                 Query.class);
		DataSourceConfiguration configuration = (DataSourceConfiguration) object;
		while (queryIterator.hasNext()) {
			try {
				Query query = queryIterator.next();
				if ((configuration.getId()).equals(query.getUseConfig())) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return false;

	}

	private static void populateConfigIds(Object object) {
		if (object instanceof EObject) {
			rootObject = EcoreUtil.getRootContainer((EObject) object);

			// Get the DataSourceConfiguration elements in the tree
			Iterator<DataSourceConfiguration> configIterator =
			                                                   Iterators.filter(((EObject) rootObject).eAllContents(),
			                                                                    DataSourceConfiguration.class);
			configList = new ArrayList<String>();
			while (configIterator.hasNext()) {
				DataSourceConfiguration config = configIterator.next();
				configList.add(config.getId());
			}
		}
	}

	private static void populateQueryIds(Object object) {
		if (object instanceof EObject) {
			rootObject = EcoreUtil.getRootContainer((EObject) object);

			// Get the Query elements in the tree
			Iterator<Query> queryIterator =
			                                Iterators.filter(((EObject) rootObject).eAllContents(),
			                                                 Query.class);
			queryList = new ArrayList<String>();
			while (queryIterator.hasNext()) {
				Query query = queryIterator.next();
				queryList.add(query.getId());
			}
		}
	}

	private static void populateEventTriggerIds(Object object) {
		if (object instanceof EObject) {
			rootObject = EcoreUtil.getRootContainer((EObject) object);

			// Get the EventTrigger elements in the tree
			Iterator<EventTrigger> eventIterator =
			                                       Iterators.filter(((EObject) rootObject).eAllContents(),
			                                                        EventTrigger.class);
			eventTriggerList = new ArrayList<String>();
			while (eventIterator.hasNext()) {
				EventTrigger event = eventIterator.next();
				eventTriggerList.add(event.getId());
			}
		}
	}

}
