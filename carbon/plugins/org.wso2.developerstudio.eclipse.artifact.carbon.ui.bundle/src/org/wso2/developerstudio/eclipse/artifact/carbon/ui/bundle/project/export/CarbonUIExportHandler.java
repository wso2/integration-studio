package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.project.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.storagemanager.StorageManager;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class CarbonUIExportHandler extends ProjectArtifactHandler {
	
	public List<IResource> exportArtifact(IProject project) {

		List<IResource> exportResources = new ArrayList<IResource>();
     	if(!project.isOpen()){
			return exportResources;
		}
	 	
		try{				
			ArchiveManipulator archiveManipulator = new ArchiveManipulator();
			NullProgressMonitor nullProgressMonitor = new NullProgressMonitor();
			//cleaning target directory 
			clearTarget(project);
			project.build(IncrementalProjectBuilder.FULL_BUILD, nullProgressMonitor);
		    IJavaProject javaProject = JavaCore.create(project);

			IPath outPutPath = ResourcesPlugin.getWorkspace().getRoot().getFolder(javaProject.getOutputLocation()).getLocation();
			  //Let's create a temp project 
	        IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(".temp"+System.currentTimeMillis());
	        tempProject.create(nullProgressMonitor);
	        tempProject.open(nullProgressMonitor);
	        tempProject.setHidden(true);  
	        org.eclipse.osgi.storagemanager.StorageManager manager=new StorageManager(tempProject.getLocation().toFile(), "false");
	        IPath resources = project.getFolder("web").getLocation();
	        File webResource = manager.createTempFile("web_resources");
	        webResource.delete();
	        webResource.mkdir();
	        File web = new File(webResource,"web");
	        web.mkdir(); 
	        FileUtils.copyDirectoryContents(outPutPath.toFile(), webResource); // copy binaries 
	        if(resources.toFile().exists()) {
	        	FileUtils.copyDirectoryContents(resources.toFile(), web); // copy web resources
	        }
	        ///////////////////////Create the Bundle*********************************

	        File metainfPath = new File(webResource,"META-INF");
	        metainfPath.mkdir();
	        File metainf = project.getFolder("META-INF").getLocation().toFile();	  
	        FileUtils.copyDirectoryContents(metainf, metainfPath);
               
	        File tmpArchive = new File(tempProject.getLocation().toFile(),project.getName().concat(".jar"));
	        archiveManipulator.archiveDir(tmpArchive.toString(), webResource.toString());
	        IFolder binaries = project.getFolder("target");
	        if(!binaries.exists()) {
	        	binaries.create(true, true, nullProgressMonitor);
	        	binaries.setHidden(true);
	        }
	        IFile serviceArchive = project.getFile("target"+ File.separator +  project.getName().concat(".jar"));
	        FileUtils.copy(tmpArchive, serviceArchive.getLocation().toFile());
	        exportResources.add((IResource)serviceArchive); 
	        //cleaning temp project
	        tempProject.delete(true, nullProgressMonitor);
			
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return exportResources;
	}
	
}
