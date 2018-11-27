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
