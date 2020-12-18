package org.wso2.integrationstudio.artifact.bpel.validators;

import java.util.ArrayList;
import java.util.List;

import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;
import org.wso2.integrationstudio.artifact.bpel.utils.BPELArtifactConstants;

public class BPELTemplateList extends AbstractListDataProvider{
	
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		List<ListData> bpelTemplates = new ArrayList<ListData>();
		bpelTemplates.add(createListData(BPELArtifactConstants.ASYNCHRONOUS_BPEL_PROCESS, 
									BPELArtifactConstants.ASYNCHRONOUS_BPEL_PROCESS));
		bpelTemplates.add(createListData(BPELArtifactConstants.SYNCHRONOUS_BPEL_PROCESS,
										BPELArtifactConstants.SYNCHRONOUS_BPEL_PROCESS));
		bpelTemplates.add(createListData(BPELArtifactConstants.EMPTY_BPEL_PROCESS,
											BPELArtifactConstants.EMPTY_BPEL_PROCESS));
		return bpelTemplates;
	}


}
