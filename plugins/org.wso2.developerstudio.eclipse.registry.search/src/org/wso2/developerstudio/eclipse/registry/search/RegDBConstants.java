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

public class RegDBConstants {
	public static final String TABLE_REG_RESOURCE = "REG_RESOURCE";
	public static final String COLUMN_REG_PATH_ID = "REG_PATH_ID";
	public static final String COLUMN_REG_NAME = "REG_NAME";
	public static final String COLUMN_REG_VERSION = "REG_VERSION";
	public static final String COLUMN_REG_MEDIA_TYPE = "REG_MEDIA_TYPE";
	public static final String COLUMN_REG_CREATOR = "REG_CREATOR";
	public static final String COLUMN_REG_CREATED_TIME = "REG_CREATED_TIME";
	public static final String COLUMN_REG_LAST_UPDATOR = "REG_LAST_UPDATOR";
	public static final String COLUMN_REG_LAST_UPDATED_TIME = "REG_LAST_UPDATED_TIME";
	public static final String COLUMN_REG_DESCRIPTION = "REG_DESCRIPTION";
	public static final String COLUMN_REG_CONTENT_ID = "REG_CONTENT_ID";

	public static final String TABLE_REG_PROPERTY = "REG_PROPERTY";
	public static final String COLUMN_REG_PROPERTY_ID = "REG_ID";
	public static final String COLUMN_REG_PROPERTY_NAME = "REG_NAME";
	public static final String COLUMN_REG_PROPERTY_VALUE = "REG_VALUE";

	public static final String TABLE_REG_RESOURCE_PROPERTY = "REG_RESOURCE_PROPERTY";
	public static final String COLUMN_REG_RESOURCE_PROPERTY_PROPERTY_ID = "REG_PROPERTY_ID";
	public static final String COLUMN_REG_RESOURCE_PROPERTY_VERSION = "REG_VERSION";
	public static final String COLUMN_REG_RESOURCE_PROPERTY_PATH_ID = "REG_PATH_ID";
	public static final String COLUMN_REG_RESOURCE_PROPERTY_RESOURCE_NAME = "REG_RESOURCE_NAME";

	public static final String TABLE_REG_TAG = "REG_TAG";
	public static final String COLUMN_REG_TAG_ID = "REG_ID";
	public static final String COLUMN_REG_TAG_TAG_NAME = "REG_TAG_NAME";
	public static final String COLUMN_REG_TAG_USER_ID = "REG_USER_ID";
	public static final String COLUMN_REG_TAG_TAGGED_TIME = "REG_TAGGED_TIME";

	public static final String TABLE_REG_RESOURCE_TAG = "REG_RESOURCE_TAG";
	public static final String COLUMN_REG_RESOURCE_TAG_TAG_ID = "REG_TAG_ID";
	public static final String COLUMN_REG_RESOURCE_TAG_VERSION = "REG_VERSION";
	public static final String COLUMN_REG_RESOURCE_TAG_PATH_ID = "REG_PATH_ID";
	public static final String COLUMN_REG_RESOURCE_TAG_RESOURCE_NAME = "REG_RESOURCE_NAME";

	public static final String TABLE_REG_COMMENT = "REG_COMMENT";
	public static final String COLUMN_REG_COMMENT_ID = "REG_ID";
	public static final String COLUMN_REG_COMMENT_COMMENT_TEXT = "REG_COMMENT_TEXT";
	public static final String COLUMN_REG_COMMENT_USER_ID = "REG_USER_ID";
	public static final String COLUMN_REG_COMMENT_COMMENT_TIME = "REG_COMMENT_TIME";

	public static final String TABLE_REG_RESOURCE_COMMENT = "REG_RESOURCE_COMMENT";
	public static final String COLUMN_REG_RESOURCE_COMMENT_COMMENT_ID = "REG_COMMENT_ID";
	public static final String COLUMN_REG_RESOURCE_COMMENT_VERSION = "REG_VERSION";
	public static final String COLUMN_REG_RESOURCE_COMMENT_PATH_ID = "REG_PATH_ID";
	public static final String COLUMN_REG_RESOURCE_COMMENT_RESOURCE_NAME = "REG_RESOURCE_NAME";

	public static final String TABLE_REG_PATH = "REG_PATH";
	public static final String COLUMN_REG_PATH_REG_PATH_ID = "REG_PATH_ID";
	public static final String COLUMN_REG_PATH_VALUE = "REG_PATH_VALUE";

}
