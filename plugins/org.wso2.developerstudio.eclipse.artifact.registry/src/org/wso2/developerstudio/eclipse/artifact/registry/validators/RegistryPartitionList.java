package org.wso2.developerstudio.eclipse.artifact.registry.validators;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class RegistryPartitionList extends AbstractListDataProvider {

	@Override
	public List<ListData> getListData(String modelProperty,
			ProjectDataModel model) {
		List<ListData> registryPartitions=new ArrayList<ListData>();
		registryPartitions.add(new ListData("gov", "/_system/governance/"));
		registryPartitions.add(new ListData("conf", "/_system/config/"));
		return registryPartitions;
	}

}
