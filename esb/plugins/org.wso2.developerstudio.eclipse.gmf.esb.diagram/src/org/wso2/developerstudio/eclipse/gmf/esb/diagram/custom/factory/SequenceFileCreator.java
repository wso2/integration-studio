/*
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.factory;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
//import org.wso2.developerstudio.eclipse.artifact.sequence.model.SequenceModel;
//import org.wso2.developerstudio.eclipse.artifact.sequence.ui.wizard.SequenceProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


public class SequenceFileCreator implements IFileCreator{
	private SequenceModel seqModel;
	public SequenceFileCreator (SequenceModel seqModel){
		this.seqModel=seqModel;
	}
	
	public void createSequenceFile(String content) throws Exception{
		SequenceProjectCreationWizard sequenceProjectCreationWizard = new SequenceProjectCreationWizard();
		IProject project = seqModel.getSequenceSaveLocation().getProject();
		sequenceProjectCreationWizard.setProject(project);
		seqModel.setSelectedOption("");
		sequenceProjectCreationWizard.setModel(seqModel);

		if(seqModel.isSaveAsDynamic()){
			sequenceProjectCreationWizard.createDynamicSequenceArtifact(seqModel.getSequenceSaveLocation(),seqModel);
		} else{
			if(sequenceProjectCreationWizard.createSequenceArtifact(project,seqModel)){
		        IContainer location = project.getFolder("src" + File.separator + "main"
						+ File.separator + "synapse-config" + File.separator
						+ "sequences");
		        File destFile = new File(location.getLocation().toFile(),
		        		seqModel.getSequenceName() + ".xml");
		       FileUtils.writeContent(destFile,content);
			}
		}
		
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}
}
*/
