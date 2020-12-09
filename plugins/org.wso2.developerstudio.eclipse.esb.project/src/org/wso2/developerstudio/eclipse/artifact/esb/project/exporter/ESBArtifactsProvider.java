package org.wso2.developerstudio.eclipse.artifact.esb.project.exporter;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.distribution.project.export.CappArtifactsListProvider;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ESBArtifactsProvider extends CappArtifactsListProvider {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public List<ListData> getArtifactsListForCappExport(IProject project) {

	List<ListData> list = new ArrayList<ListData>();
	try {

	    list = getValidArtifacts(project, super.getArtifactsListForCappExport(project));

	} catch (Exception e) {
	    log.error("Error getting artifacts list from project ", e);
	}
	return list;
    }

    /**
     * Validate the iFile using the error markers added at
     * org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.FileDecorator
     * while validating the synapse configuration.
     * 
     * @param project	ESB config project
     * @param list      List of all artifacts
     * @return List of valid artifacts
     */
    private List<ListData> getValidArtifacts(IProject project, List<ListData> list) {

	List<ListData> validArtifacts = new ArrayList<ListData>();
	try {
	    list.forEach(lD -> {
		if (lD.getData() instanceof DependencyData) {
		    DependencyData dependencyData = (DependencyData) lD.getData();
		    String path = dependencyData.getSelf().toString();
		    IFile iFile = project.getFile(path);

		    try {
    			IMarker[] markers = iFile.findMarkers("CAPP_NOT_ALLOWED", false, 1);
    			if (markers.length == 0) {
    			    validArtifacts.add(lD);
    			}
		    } catch (CoreException e) {
		        // ignore
		    }
		}
	    });
	} catch (Exception e) {
	    // ignore
	}
	return validArtifacts;
    }

}
