package org.wso2.integrationstudio.eclipse.artifact.general.project.exporter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.wso2.integrationstudio.eclipse.distribution.project.export.CappArtifactsListProvider;
import org.wso2.integrationstudio.eclipse.general.project.Activator;
import org.wso2.integrationstudio.eclipse.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.eclipse.logging.core.Logger;

public class RegistryArtifactsProvider extends CappArtifactsListProvider {
	
	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	        
    @Override
    public List<ListData> getArtifactsListForCappExport(IProject project) {
 
                List<ListData> list = new ArrayList<ListData>();
                try {
                        list = super.getArtifactsListForCappExport(project);
                } catch (Exception e) {
                        log.error("Error getting artifacts list from project ", e);
                }
                return list;
        }
}
