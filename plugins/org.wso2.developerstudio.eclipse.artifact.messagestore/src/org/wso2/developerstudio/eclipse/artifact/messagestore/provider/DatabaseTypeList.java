/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.messagestore.provider;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.artifact.messagestore.Constants;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

/**
 * Message-store pre-configured database type data provider class
 */
public class DatabaseTypeList extends AbstractListDataProvider {
    
    @Override
    public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
        List<ListData> list = new ArrayList<ListData>();
        list.add(createListData(Constants.TXT_DATABASE_TYPE_OTHER, DatabaseType.OTHER));
        list.add(createListData(Constants.TXT_DATABASE_TYPE_MYSQL, DatabaseType.MYSQL));
        list.add(createListData(Constants.TXT_DATABASE_TYPE_ORACLE, DatabaseType.ORACLE));
        list.add(createListData(Constants.TXT_DATABASE_TYPE_MSSQL, DatabaseType.MSSQL));
        list.add(createListData(Constants.TXT_DATABASE_TYPE_POSTGRESQL, DatabaseType.POSTGRESQL));
        return list;
    }
    
    /**
     * Message store pre-configured database type
     *
     */
    public enum DatabaseType {
        OTHER,
        MYSQL,
        ORACLE,
        MSSQL,
        POSTGRESQL
    }

}
