package org.wso2.maven.car.artifact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.maven.capp.model.CAppArtifact;
import org.wso2.maven.capp.model.CAppArtifactDependency;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.car.artifact.utils.FileManagementUtil;
import org.wso2.maven.plugin.synapse.utils.SynapseArtifactBundleCreator;

/**
 * Create a bpel artifact from Maven project
 *
 * @goal car
 * @phase package
 * @description build car artifact
 */
public class CARMojo extends AbstractMojo {

    /**
     * Location target folder
     *
     * @parameter expression="${project.build.directory}"
     */
    private File target;
    
    /**
     * Location archiveLocation folder
     *
     * @parameter expression="${project.build.directory}"
     */
    private File archiveLocation;
    
	/**
	 * finalName to use for the generated capp project if the user wants to override the default name
	 * 
	 * @parameter
	 */
	public String finalName;
    

	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject project;

	/**
	 * Maven ProjectHelper.
	 * 
	 * @component
	 */
	private MavenProjectHelper projectHelper;

    /**
     * @component
     */
    private ArtifactFactory artifactFactory;

    /**
     * @component
     */
    private ArtifactResolver resolver;

    /**
     * @parameter default-value="${localRepository}"
     */
    private ArtifactRepository localRepository;

    /**
     * @parameter default-value="${project.remoteArtifactRepositories}"
     */
    private List<?> remoteRepositories;
    
    /**
	 * Maven ProjectHelper.
	 * 
	 * @parameter
	 */
    private List<artifact> artifacts;

    private void setupMavenRepoObjects(){
    	CAppMavenUtils.setArtifactFactory(artifactFactory);
    	CAppMavenUtils.setResolver(resolver);
    	CAppMavenUtils.setLocalRepository(localRepository);
    	CAppMavenUtils.setRemoteRepositories(remoteRepositories);
    }
	
    private Map<String,CAppArtifactDependency> cAppArtifactDependencies=new HashMap<String, CAppArtifactDependency>();
    
	public void execute() throws MojoExecutionException, MojoFailureException {
		setupMavenRepoObjects();
		CAppArtifact cAppArtifact = new CAppArtifact(project,null);
		collectArtifacts(cAppArtifact, cAppArtifactDependencies);
		try {
			cAppArtifact.setRoot(true);
			cAppArtifact.toFile(new File(getArchiveDir(),"artifacts.xml"));
			for (CAppArtifactDependency cAppDependency : cAppArtifactDependencies.values()) {
				cAppArtifact.setRoot(false);
				createArtifactData(getArchiveDir(), cAppDependency);
			}
			FileManagementUtil.zipFolder(getArchiveDir().toString(), getArchiveFile().toString());
			FileManagementUtil.deleteDirectories(getArchiveDir());
			project.getArtifact().setFile(getArchiveFile());
		} catch (Exception e) {
			throw new MojoExecutionException("",e);
		}
	}

	private void createArtifactData(File baseCARLocation, CAppArtifactDependency cAppArtifactDependency) throws IOException, MojoExecutionException{
		getLog().info("Generating artifact descriptor for artifact: "+cAppArtifactDependency.getName());
		
		File artifactLocation = new File(baseCARLocation,cAppArtifactDependency.getName()+"_"+cAppArtifactDependency.getVersion());
		
		CAppArtifact cAppArtifact = cAppArtifactDependency.getcAppArtifact();
		Dependency mavenArtifact = cAppArtifactDependency.getMavenDependency();
		
		String artifactFinalName = null;
		
		if(artifacts != null){
			for (artifact cappArtifact : artifacts) {
				if(mavenArtifact.getGroupId().equals(cappArtifact.getGroupId()) && 
						mavenArtifact.getArtifactId().equals(cappArtifact.getArtifactId())){
					artifactFinalName = cappArtifact.getFinalName();
					break;
				}
			}
		}
		
		getLog().info("Copying artifact content to target location.");
		File[] cappArtifactFile = cAppArtifactDependency.getCappArtifactFile();
		for (File file : cappArtifactFile) {
			if (file.isDirectory()){
				FileUtils.copyDirectory(file, new File(artifactLocation,file.getName()));
			}else if(artifactFinalName == null){
				FileUtils.copy(file, new File(artifactLocation,file.getName()));
			}else{
				FileUtils.copy(file, new File(artifactLocation,artifactFinalName));
				cAppArtifact.setFile(artifactFinalName);
			}
		}
		
		cAppArtifact.toFile(new File(artifactLocation,"artifact.xml"));
	}
	
	private void collectArtifacts(CAppArtifact cAppArtifact, Map<String,CAppArtifactDependency> cAppArtifacts) throws MojoExecutionException{
		List<CAppArtifactDependency> dependencies = cAppArtifact.getDependencies();
		cAppArtifact.getDependencies().clear();
		for (CAppArtifactDependency artifactDependency : dependencies) {
			if (!cAppArtifacts.containsKey(artifactDependency.getDependencyId())){
				List<CAppArtifactDependency> artifactsToAdd = processArtifactsToAdd(artifactDependency);
				boolean originalDependencyPresent=false;
				for (CAppArtifactDependency cAppArtifactDependency : artifactsToAdd) {
					cAppArtifact.addDependencies(cAppArtifactDependency);
					cAppArtifacts.put(cAppArtifactDependency.getDependencyId(),
							cAppArtifactDependency);
					collectArtifacts(cAppArtifactDependency.getcAppArtifact(),
							cAppArtifacts);	
					originalDependencyPresent=originalDependencyPresent || (artifactDependency.getName().equals(cAppArtifactDependency.getName()) && artifactDependency.getVersion().equals(cAppArtifactDependency.getVersion()));
				}
				if (!originalDependencyPresent){
					cAppArtifact.addIgnoreDependency(artifactDependency);
				}
			}
		}
	}

	private List<CAppArtifactDependency> processArtifactsToAdd(
			CAppArtifactDependency artifactDependency) throws MojoExecutionException{
		List<CAppArtifactDependency> artifactsToAdd =new ArrayList<CAppArtifactDependency>();
		try {
			if (artifactDependency.getcAppArtifact().getProject().getPackaging().equals("synapse/configuration")) {
				SynapseArtifactBundleCreator synapseArtifactBundleCreator = new SynapseArtifactBundleCreator(artifactDependency);
				artifactsToAdd = synapseArtifactBundleCreator.exportDependentArtifacts(artifactDependency.getCappArtifactFile()[0], artifactDependency);
			}else{
				artifactsToAdd.add(artifactDependency);
			}
		} catch (Exception e) {
			throw new MojoExecutionException("Error occured while processing artifact", e);
		}
		return artifactsToAdd;
	}

	public MavenProjectHelper getProjectHelper() {
		return projectHelper;
	}

	public void setTarget(File target) {
		this.target = target;
	}

	public File getTarget() {
		return target;
	}
	
	private File getArchiveDir(){
		File archiveDir = new File(getTarget(),"car");
		if (!archiveDir.exists()){
			archiveDir.mkdirs();
		}
		return archiveDir;
	}

	private File getArchiveFile(){
		File archiveFile = new File(getArchiveLocation(),project.getArtifactId()+"_"+project.getVersion()+".car");
		if(finalName != null && !finalName.trim().equals("")){
			archiveFile=new File(getArchiveLocation(), finalName+".car");
		}
		return archiveFile;
	}
	
	public File getArchiveLocation() {
		return archiveLocation;
	}

	public void setArchiveLocation(File archiveLocation) {
		this.archiveLocation = archiveLocation;
	}
	
}