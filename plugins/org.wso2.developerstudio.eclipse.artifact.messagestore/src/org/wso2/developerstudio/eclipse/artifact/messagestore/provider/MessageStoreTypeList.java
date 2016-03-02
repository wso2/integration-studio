/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.messagestore.provider;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.artifact.messagestore.Constants;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

/**
 * Message-store type data provider class
 */
public class MessageStoreTypeList extends AbstractListDataProvider {

	@Override
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		list.add(createListData(Constants.TXT_JMS, MessageStoreType.JMS));
		list.add(createListData(Constants.TXT_IN_MEMORY, MessageStoreType.IN_MEMORY));
		list.add(createListData(Constants.TXT_CUSTOM, MessageStoreType.CUSTOM));
		list.add(createListData(Constants.TXT_RABBITMQ, MessageStoreType.RABBITMQ));
		list.add(createListData(Constants.TXT_JDBC, MessageStoreType.JDBC));
		return list;
	}
	
	/**
	 * In Memory Message Store, JMS Message Store, Custom Message Store
	 *
	 */
	public enum MessageStoreType{
		IN_MEMORY,
		JMS,
		CUSTOM,
		RABBITMQ,
		JDBC
	}

}
