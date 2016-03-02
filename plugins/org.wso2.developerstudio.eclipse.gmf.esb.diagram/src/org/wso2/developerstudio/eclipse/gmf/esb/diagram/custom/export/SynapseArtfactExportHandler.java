package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.export;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbObjectSourceEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.EsbModelTransformer;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.*;

public class SynapseArtfactExportHandler extends ProjectArtifactHandler {

	public List<IResource> exportArtifact(IProject project) throws Exception {
		List<IResource> exportResources = new ArrayList<IResource>();
		NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();

		clearTarget(project);
		List<IResource> esbMembers = new ArrayList<IResource>();
		/*TODO: list artifacts by reading artifact.xml instead of file system scan */
		IResource[] synapseMembers = project.getFolder(SYNAPSE_RESOURCE_DIR).members();
		IResource[] sequenceMembers = project.getFolder(SEQUENCE_RESOURCE_DIR).members();
		IResource[] members = new IResource[synapseMembers.length+sequenceMembers.length];
		if(synapseMembers.length>0)
			System.arraycopy(synapseMembers, 0, members, 0, synapseMembers.length);
		if(sequenceMembers.length>0)
			System.arraycopy(sequenceMembers, 0, members, synapseMembers.length, sequenceMembers.length);
		
		for (int i = 0; i < members.length; ++i) {
			if (members[i].toString().matches(".*esb_diagram")) {

				esbMembers.add(members[i]);
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = null;
				File f = new File(((IResource) members[i]).getLocationURI()
						.getPath());
				URI uri = URI.createFileURI(f.getAbsolutePath());
				resource = resourceSet.getResource(uri, true);

				IFolder binaries = project.getFolder("target");
				if (!binaries.exists()) {
					binaries.create(true, true, nullProgressMonitor);
					binaries.setHidden(true);
				}

				IFile dummyFile = project.getFile("target" + File.separator
						+ "synapse_"
						+ members[i].getName().split(".esb_diagram")[0]
						+ ".xml");

				EsbObjectSourceEditor sourceEditor = new EsbObjectSourceEditor(
						dummyFile);

				EsbDiagram diagram = (EsbDiagram) ((org.eclipse.gmf.runtime.notation.impl.DiagramImpl) resource
						.getContents().get(0)).getElement();
				EsbServer server = diagram.getServer();

				String newSource = null;
				try {
					newSource = EsbModelTransformer.instance
							.designToSource(server);
				} catch (Exception e) {
					e.printStackTrace();
				}

				InputStream is = new ByteArrayInputStream(newSource.getBytes());
				try {
					dummyFile.delete(true, null);
					dummyFile.create(is, true, null);

				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
				exportResources.add(dummyFile);
			}
		}
		return exportResources;
	}

}
