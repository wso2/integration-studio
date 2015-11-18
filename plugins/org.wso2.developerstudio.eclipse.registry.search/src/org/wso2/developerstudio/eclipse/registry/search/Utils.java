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

package org.wso2.developerstudio.eclipse.registry.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.wso2.carbon.registry.app.RemoteRegistry;
import org.wso2.carbon.registry.core.RegistryConstants;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;

public class Utils {
	public static String createSql(SearchQueryData searchQueryData) {
		String SQL = null;
		Map<String, String> tableMapping = getDatabaseTablesNeeded(searchQueryData);
		List<String> selectList = getSelectList(searchQueryData, tableMapping);
		List<String> fromList = getFromList(searchQueryData, tableMapping);
		List<String> whereList = getWhereList(searchQueryData, tableMapping);
		String selectString = null;
		String fromString = null;
		String whereString = null;
		for (String select : selectList) {
			if (selectString == null)
				selectString = select;
			else
				selectString = selectString + ", " + select;
		}
		for (String from : fromList) {
			if (fromString == null)
				fromString = from;
			else
				fromString = fromString + ", " + from;
		}
		for (String where : whereList) {
			String logic = "(" + where + ")";
			if (whereString == null)
				whereString = logic;
			else
				whereString = whereString + " AND " + logic;
		}
		SQL = "SELECT " + selectString + " FROM " + fromString + " WHERE "
				+ whereString;
		searchQueryData.setSQL(SQL);
		return SQL;
	}

	private static List<String> getSelectList(SearchQueryData searchQueryData,
			Map<String, String> tableMapping) {
		List<String> selectList = new ArrayList<String>();
		String resTblName = tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE)
				+ ".";
		selectList.add(resTblName + RegDBConstants.COLUMN_REG_PATH_ID);
		selectList.add(resTblName + RegDBConstants.COLUMN_REG_NAME);
		return selectList;
	}

	private static List<String> getFromList(SearchQueryData searchQueryData,
			Map<String, String> tableMapping) {
		List<String> fromList = new ArrayList<String>();
		for (String dbName : tableMapping.keySet()) {
			fromList.add(dbName + " " + tableMapping.get(dbName));
		}
		return fromList;
	}

	private static List<String> getWhereList(SearchQueryData searchQueryData,
			Map<String, String> tableMapping) {
		List<String> whereList = new ArrayList<String>();
		List<String> parameterValues = null;// new ArrayList<String>();
		if (isProvided(searchQueryData.getResourceName())) {
			String resourceMatch = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_NAME
					+ " LIKE "
					+ s(searchQueryData.getResourceName(), parameterValues);
			String collectionMatch = "("
					+ tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_NAME
					+ " IS NULL) AND ("
					+ tableMapping.get(RegDBConstants.TABLE_REG_PATH)
					+ "."
					+ RegDBConstants.COLUMN_REG_PATH_VALUE
					+ " LIKE "
					+ s(searchQueryData.getResourceName(), parameterValues,
							true) + ") AND ("
					+ tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE) + "."
					+ RegDBConstants.COLUMN_REG_PATH_ID + "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_PATH) + "."
					+ RegDBConstants.COLUMN_REG_PATH_REG_PATH_ID + ")";
			whereList.add("(" + resourceMatch + ") OR (" + collectionMatch
					+ ")");
		}
		if (isProvided(searchQueryData.getMediaType()))
			whereList.add(tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "." + RegDBConstants.COLUMN_REG_MEDIA_TYPE + " LIKE "
					+ s(searchQueryData.getMediaType(), parameterValues));
		if (isProvided(searchQueryData.getDescription()))
			whereList.add(tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "." + RegDBConstants.COLUMN_REG_DESCRIPTION + " LIKE "
					+ s(searchQueryData.getDescription(), parameterValues));

		// for property table
		if (isProvided(searchQueryData.getPropertyName()))
			whereList.add(tableMapping.get(RegDBConstants.TABLE_REG_PROPERTY)
					+ "." + RegDBConstants.COLUMN_REG_PROPERTY_NAME + " LIKE "
					+ s(searchQueryData.getPropertyName(), parameterValues));

		if (isProvided(searchQueryData.getPropertyValue()))
			whereList.add(tableMapping.get(RegDBConstants.TABLE_REG_PROPERTY)
					+ "." + RegDBConstants.COLUMN_REG_PROPERTY_VALUE + " LIKE "
					+ s(searchQueryData.getPropertyValue(), parameterValues));

		if (isProvided(searchQueryData.getPropertyName())
				|| isProvided(searchQueryData.getPropertyValue())) {

			String pathIdTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_PATH_ID
					+ "="
					+ tableMapping
							.get(RegDBConstants.TABLE_REG_RESOURCE_PROPERTY)
					+ "." + RegDBConstants.COLUMN_REG_RESOURCE_PROPERTY_PATH_ID;
			String resourceNameTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_NAME
					+ "="
					+ tableMapping
							.get(RegDBConstants.TABLE_REG_RESOURCE_PROPERTY)
					+ "."
					+ RegDBConstants.COLUMN_REG_RESOURCE_PROPERTY_RESOURCE_NAME;
			String versionTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_VERSION
					+ "="
					+ tableMapping
							.get(RegDBConstants.TABLE_REG_RESOURCE_PROPERTY)
					+ "." + RegDBConstants.COLUMN_REG_RESOURCE_PROPERTY_VERSION;
			String completeLogic = "(" + pathIdTest + " AND "
					+ resourceNameTest + ") OR " + versionTest;
			whereList.add(completeLogic);

			whereList.add(tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE_PROPERTY)
					+ "."
					+ RegDBConstants.COLUMN_REG_RESOURCE_PROPERTY_PROPERTY_ID
					+ "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_PROPERTY)
					+ "." + RegDBConstants.COLUMN_REG_PROPERTY_ID);
		}

		// for tag table
		if (isProvided(searchQueryData.getTags())) {
			String[] tags = searchQueryData.getTags().split(",");
			String tagString = null;
			for (String tag : tags) {
				if (isProvided(tag)) {
					if (tagString == null)
						tagString = tableMapping
								.get(RegDBConstants.TABLE_REG_TAG)
								+ "."
								+ RegDBConstants.COLUMN_REG_TAG_TAG_NAME
								+ " LIKE " + s(tag, parameterValues);
					else
						tagString = tagString
								+ " OR "
								+ tableMapping
										.get(RegDBConstants.TABLE_REG_TAG)
								+ "." + RegDBConstants.COLUMN_REG_TAG_TAG_NAME
								+ " LIKE " + s(tag, parameterValues);
				}
			}
			whereList.add(tagString);
			String pathIdTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_PATH_ID
					+ "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE_TAG)
					+ "." + RegDBConstants.COLUMN_REG_RESOURCE_TAG_PATH_ID;
			String resourceNameTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_NAME
					+ "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE_TAG)
					+ "."
					+ RegDBConstants.COLUMN_REG_RESOURCE_TAG_RESOURCE_NAME;
			String versionTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_VERSION
					+ "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_RESOURCE_TAG)
					+ "." + RegDBConstants.COLUMN_REG_RESOURCE_TAG_VERSION;
			String completeLogic = "(" + pathIdTest + " AND "
					+ resourceNameTest + ") OR " + versionTest;
			whereList.add(completeLogic);
			whereList.add(tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE_TAG)
					+ "."
					+ RegDBConstants.COLUMN_REG_RESOURCE_TAG_TAG_ID
					+ "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_TAG)
					+ "."
					+ RegDBConstants.COLUMN_REG_TAG_ID);
		}

		// for comment table
		if (isProvided(searchQueryData.getComment())) {
			whereList.add(tableMapping.get(RegDBConstants.TABLE_REG_COMMENT)
					+ "." + RegDBConstants.COLUMN_REG_COMMENT_COMMENT_TEXT
					+ " LIKE "
					+ s(searchQueryData.getComment(), parameterValues));
			String pathIdTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_PATH_ID
					+ "="
					+ tableMapping
							.get(RegDBConstants.TABLE_REG_RESOURCE_COMMENT)
					+ "." + RegDBConstants.COLUMN_REG_RESOURCE_COMMENT_PATH_ID;
			String resourceNameTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_NAME
					+ "="
					+ tableMapping
							.get(RegDBConstants.TABLE_REG_RESOURCE_COMMENT)
					+ "."
					+ RegDBConstants.COLUMN_REG_RESOURCE_COMMENT_RESOURCE_NAME;
			String versionTest = tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE)
					+ "."
					+ RegDBConstants.COLUMN_REG_VERSION
					+ "="
					+ tableMapping
							.get(RegDBConstants.TABLE_REG_RESOURCE_COMMENT)
					+ "." + RegDBConstants.COLUMN_REG_RESOURCE_COMMENT_VERSION;
			String completeLogic = "(" + pathIdTest + " AND "
					+ resourceNameTest + ") OR " + versionTest;
			whereList.add(completeLogic);
			whereList.add(tableMapping
					.get(RegDBConstants.TABLE_REG_RESOURCE_COMMENT)
					+ "."
					+ RegDBConstants.COLUMN_REG_RESOURCE_COMMENT_COMMENT_ID
					+ "="
					+ tableMapping.get(RegDBConstants.TABLE_REG_COMMENT)
					+ "." + RegDBConstants.COLUMN_REG_COMMENT_ID);
		}
		searchQueryData.setParameters(parameterValues);
		return whereList;
	}

	private static Map<String, String> getDatabaseTablesNeeded(
			SearchQueryData searchQueryData) {
		Map<String, String> tableList = new HashMap<String, String>();
		int letter = 65;
		tableList.put(RegDBConstants.TABLE_REG_RESOURCE, String
				.valueOf((char) letter++));
		tableList.put(RegDBConstants.TABLE_REG_PATH, String
				.valueOf((char) letter++));

		if (isProvided(searchQueryData.getPropertyName())
				|| isProvided(searchQueryData.getPropertyValue())) {
			tableList.put(RegDBConstants.TABLE_REG_PROPERTY, String
					.valueOf((char) letter++));
			tableList.put(RegDBConstants.TABLE_REG_RESOURCE_PROPERTY, String
					.valueOf((char) letter++));
		}

		if (isProvided(searchQueryData.getTags())) {
			tableList.put(RegDBConstants.TABLE_REG_TAG, String
					.valueOf((char) letter++));
			tableList.put(RegDBConstants.TABLE_REG_RESOURCE_TAG, String
					.valueOf((char) letter++));
		}

		if (isProvided(searchQueryData.getComment())) {
			tableList.put(RegDBConstants.TABLE_REG_COMMENT, String
					.valueOf((char) letter++));
			tableList.put(RegDBConstants.TABLE_REG_RESOURCE_COMMENT, String
					.valueOf((char) letter++));
		}

		return tableList;
	}

	public static boolean isProvided(Object value) {
		return (value != null && !value.toString().equals(""));
	}

	private static String s(String value, List<String> parameterValues) {
		String finalParameterValue = value.replaceAll(Pattern.quote("*"), "%");
		if (parameterValues == null)
			return "'" + finalParameterValue + "'";
		else {
			parameterValues.add(finalParameterValue);
			return "?";
		}
	}

	private static String s(String value, List<String> parameterValues,
			boolean appendWildCardToBegining) {
		if (appendWildCardToBegining)
			return s("*" + value, parameterValues);
		else
			return s(value, parameterValues);
	}

	public static String[] getResults(SearchQueryData searchQueryData,
			RegistryURLInfo registryURLInfo, Credentials credentials,
			String path) throws RegistryException {
		createSql(searchQueryData);

		String sql1 = searchQueryData.getSQL();

		RemoteRegistry registry = new RemoteRegistry(registryURLInfo.getUrl(),
				credentials.getUsername(), credentials.getPassword());
		Resource q1 = registry.newResource();

		q1.setContent(sql1);

		q1.setMediaType(RegistryConstants.SQL_QUERY_MEDIA_TYPE);

		q1.addProperty(RegistryConstants.RESULT_TYPE_PROPERTY_NAME,

		RegistryConstants.RESOURCES_RESULT_TYPE);

		registry.put("/custom-queries", q1);

		// then you should give the parameters and the query location you just
		// put

		Map parameters = new HashMap();

		// parameters.put("1", "%coll%ctio%");

		Resource result = registry.executeQuery("/custom-queries", parameters);

		String[] paths = (String[]) result.getContent();
		return paths;
	}
}
