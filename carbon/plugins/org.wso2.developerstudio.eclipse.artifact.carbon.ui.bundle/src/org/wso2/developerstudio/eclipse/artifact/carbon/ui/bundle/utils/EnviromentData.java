package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.utils;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider.ListData;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class EnviromentData extends AbstractListDataProvider{

	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		  List<ListData> list = new ArrayList<ListData>();
		  ListData data = createListData("JAVA SE 6","JAVA SE 6");
		  list.add(data);
		return list;
	}

}
