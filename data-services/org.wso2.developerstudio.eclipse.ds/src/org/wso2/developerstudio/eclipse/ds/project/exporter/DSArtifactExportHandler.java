package org.wso2.developerstudio.eclipse.ds.project.exporter;


import java.util.List;
import java.util.Map;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.distribution.project.export.DefaultArtifactExportHandler;
import org.wso2.developerstudio.eclipse.distribution.project.model.ArtifactData;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;


public class DSArtifactExportHandler extends DefaultArtifactExportHandler {

	DistProjectUtils distProjectUtils = new DistProjectUtils();

	@Override
	public void exportArtifact(List<ArtifactData> artifactList,
			Map<IProject, Map<String, IResource>> graphicalSynapseProjectList,
			IFolder splitESBResources, DependencyData dependencyData,
			Object parent, Object self) throws Exception {
		if (parent instanceof IProject && self instanceof String) {
			IFile file = ((IProject) parent).getFile((String) self);
			ArtifactData artifactData = new ArtifactData();
			artifactData.setDependencyData(dependencyData);
			artifactData.setFile(distProjectUtils.getFileName(dependencyData));
			artifactData.setResource((IResource) file);
			artifactList.add(artifactData);
		}
	}

}
