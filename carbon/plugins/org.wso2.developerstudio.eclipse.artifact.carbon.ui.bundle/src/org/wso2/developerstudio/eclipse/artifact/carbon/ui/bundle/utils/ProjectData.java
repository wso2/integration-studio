package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.utils;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class ProjectData extends AbstractListDataProvider{
	public static final String PROJECT_NATURE="org.wso2.developerstudio.eclipse.carbon.uibundle.nature";
	
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		   List<ListData> list = new ArrayList<ListData>();
		   IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject prj : projects) {
				try {
		            if (!prj.isOpen() || !prj.hasNature(PROJECT_NATURE) ){
		            	continue;
		            }
	            } catch (CoreException e1) {
		            e1.printStackTrace();
		            continue;
	            }
	            if(!list.contains(prj)){
	            	ListData data = createListData(prj.getName() ,prj);
	      		    list.add(data);
				}
			}
		 return list;
	}	
}
