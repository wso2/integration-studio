package org.wso2.developerstudio.eclipse.artifact.ds.validator.project.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.storagemanager.StorageManager;
import org.wso2.developerstudio.eclipse.platform.core.manifest.BundleManifest;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class DsValidatorExportHandler extends ProjectArtifactHandler {

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

            List<String> exportPac =getExportPackages(javaProject);
		    BundleManifest manifest = new BundleManifest();	   
		    manifest.setBundleName(project.getName());
		    manifest.setBundleSymbolicName(project.getName());
		    manifest.setBundleDescription(project.getName());
		    manifest.setBundleVersion("2.0");
		    manifest.setExportPackagesList(exportPac);
		    // IPath outPutPath = javaProject.getOutputLocation();
			IPath outPutPath = ResourcesPlugin.getWorkspace().getRoot().getFolder(javaProject.getOutputLocation()).getLocation();
			  //Let's create a temp project 
	        IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(".temp"+System.currentTimeMillis());
	        tempProject.create(nullProgressMonitor);
	        tempProject.open(nullProgressMonitor);
	        tempProject.setHidden(true);  
	        org.eclipse.osgi.storagemanager.StorageManager manager=new StorageManager(tempProject.getLocation().toFile(), "false");
	        
	        File validatorResource = manager.createTempFile("validator_resources");
	        validatorResource.delete();
	        validatorResource.mkdir();
	        FileUtils.copyDirectoryContents(outPutPath.toFile(), validatorResource); // copy binaries 
	        
	        ///////////////////////Create the Bundle*********************************

	        File metainfPath = new File(validatorResource,"META-INF");
	        metainfPath.mkdir();
	        File manifestFile=new File(metainfPath,"MANIFEST.MF");
	        FileUtils.createFile(manifestFile, manifest.toString());	               
	        File tmpArchive = new File(tempProject.getLocation().toFile(),project.getName().concat(".jar"));
	        archiveManipulator.archiveDir(tmpArchive.toString(), validatorResource.toString());
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
	
	private List<String> getExportPackages(IJavaProject iJavaProject) throws CoreException,
	JavaModelException, Exception {
	ArrayList<String> exportedPackagesList = new ArrayList<String>();
	IPackageFragment[] packages = iJavaProject.getPackageFragments();
    for (IPackageFragment iPackageFragment : packages) {
		    iPackageFragment.getElementName();
		    if (iPackageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) { 
		    	 if(iPackageFragment.hasChildren()){
				    	exportedPackagesList.add(iPackageFragment.getElementName());
		    	 }
			}
	}
    return exportedPackagesList;
}

//	private void getClassName(IJavaProject iJavaProject) throws JavaModelException{
//		
//		IPackageFragment[] packages = iJavaProject.getPackageFragments();
//	    for (IPackageFragment mypackage : packages) {
//	    	        mypackage.getElementName();
//			    if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) { 
//			    	 if(mypackage.hasChildren()){
//			      //      exportedPackagesList.add(iPackageFragment.getElementName());
//			    		 for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
//			    			  
//			    			   //   unit.
//			    				System.out.println("Source file " + unit.getElementName());
//			    			//	Document doc = new Document(unit.getSource());
//			    			//	System.out
//			    				//		.println("Has number of lines: " + doc.getNumberOfLines());
//			    				//printIMethods(unit);
//
//			    			}			    		 
//			    	 }
//				}
//		  }	
//	}	
		
//	private void printIMethods(ICompilationUnit unit) throws JavaModelException {
//		IType[] allTypes = unit.getAllTypes();
//		for (IType type : allTypes) {
//			  if("".equals(type.getSuperclassName())){}
//			IMethod[] methods = type.getMethods();
//			for (IMethod method : methods) {
//
//				System.out.println("Method name " + method.getElementName());
//				System.out.println("Signature " + method.getSignature());
//				System.out.println("Return Type " + method.getReturnType());
//
//			}
//		}
//	}
	
}
