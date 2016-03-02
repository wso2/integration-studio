package org.wso2.developerstudio.eclipse.artifact.proxyservice.validators;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class RegOptionsList extends AbstractListDataProvider{

	public static final String CONST_CONFIG = "Configuration";
	public static final String CONST_GOVERNANCE = "Governance";

	
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		list.add(createListData(CONST_GOVERNANCE, CONST_GOVERNANCE));
		list.add(createListData(CONST_CONFIG, CONST_CONFIG));
		return list;
	}

}
