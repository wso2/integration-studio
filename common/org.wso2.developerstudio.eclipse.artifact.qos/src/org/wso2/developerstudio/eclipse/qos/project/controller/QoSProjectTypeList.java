package org.wso2.developerstudio.eclipse.qos.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class QoSProjectTypeList extends AbstractListDataProvider {

	private static List<String> serviceNames;

	public static List<String> getServiceNames() {
		return serviceNames;
	}

	public static void setServiceNames(List<String> serviceNames) {
		QoSProjectTypeList.serviceNames = serviceNames;
	}

	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		List<ListData> data = new ArrayList<ListData>();

		if (modelProperty.equals("ps.type")){
			for (String name : serviceNames) {
				data.add(new ListData(name, name));
			}
		}
		return data;
	}
}
