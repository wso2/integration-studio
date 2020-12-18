package org.wso2.integrationstudio.artifact.endpoint.validators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.wso2.integrationstudio.artifact.endpoint.Activator;
import org.wso2.integrationstudio.esb.project.artifact.ESBArtifact;
import org.wso2.integrationstudio.esb.project.artifact.ESBProjectArtifact;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;


public class AvailableTemplateList extends AbstractListDataProvider{

	private static IIntegrationStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		
		List<ListData> availableStoreList = new ArrayList<ListData>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		
		
		for (IProject workspaceProject : projects) {
		
				try {
					if (workspaceProject.isOpen() && workspaceProject.hasNature("org.wso2.developerstudio.eclipse.esb.project.nature")) {
						
						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						try {
							esbProjectArtifact.fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
							List<ESBArtifact> allESBArtifacts = esbProjectArtifact.getAllESBArtifacts();
							for (ESBArtifact esbArtifact : allESBArtifacts) {
								if(esbArtifact.getType().equals("synapse/endpointTemplate")){
									String relativeFilePath = esbArtifact.getFile().replaceAll("/", (File.separatorChar=='/')?"/":"\\\\");
									String fileName = new File((relativeFilePath)).getName().replaceAll(".xml$", "");
									availableStoreList.add(createListData(fileName,fileName));
								}
							}
						} catch (Exception e) {
							log.error("Error occured while scanning the workspace for Message-Store artifacts", e);
						}
					}
					else {
						
					}
				} catch (Exception e) {
					log.error("Error occured while scanning the workspace for Message-Store artifacts", e);
				} 
		}
	
		
		return availableStoreList;
	}
}

