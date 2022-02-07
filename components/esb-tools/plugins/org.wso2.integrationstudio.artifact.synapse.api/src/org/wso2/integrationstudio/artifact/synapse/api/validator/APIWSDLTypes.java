package org.wso2.integrationstudio.artifact.synapse.api.validator;

import java.util.ArrayList;
import java.util.List;

import org.wso2.integrationstudio.artifact.synapse.api.util.ArtifactConstants;
import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;

public class APIWSDLTypes extends AbstractListDataProvider{
	 @Override
	    public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
	        List<ListData> wsdlTypeList = new ArrayList<ListData>();
	        wsdlTypeList.add(createListData(ArtifactConstants.API_TYPE_WSDL_URL, ArtifactConstants.API_TYPE_WSDL_URL));
	        wsdlTypeList.add(createListData(ArtifactConstants.API_TYPE_WSDL_FILE, ArtifactConstants.API_TYPE_WSDL_FILE));
	        return wsdlTypeList;
	    }

}
