package org.wso2.maven.car.artifact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.car.artifact.fsm.TopologyFSEngine;
import org.wso2.maven.car.artifact.fsm.resolvers.ServerParameterResolver;
import org.wso2.maven.car.artifact.utils.FileManagementUtil;
import org.wso2.maven.stratos.exception.UnsupportedTopologyVersion;
import org.wso2.maven.stratos.interfaces.ITopology;
import org.wso2.maven.stratos.model.TopologyFactory;

/**
 * Create a bpel artifact from Maven project
 *
 * @goal regen-car
 * @phase package
 * @description rebuild car artifact with filtering
 */
public class CARMojo2 extends AbstractMojo {

    /**
     * CAR artifact
     *
     * @required
     * @parameter
     */
    private CARMavenArtifact car;
    
    /**
     * Topology artifact
     *
     * @required
     * @parameter
     */
    private CARMavenArtifact topology;
    

    /**
     * CAR artifact
     *
     * @parameter
     */
    private Boolean failOnMissingParameters;
    
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
    

    private static String[] scanExtensions=new String[]{"xml","txt","properties","wsdl"};
	private Map<String,String> parameters=new HashMap<String, String>();
	private Map<File,List<String>> fileParameters=new HashMap<File, List<String>>();
	private List<File> scanedFiles=new ArrayList<File>();
	
    private void setupMavenRepoObjects(){
    	CAppMavenUtils.setArtifactFactory(artifactFactory);
    	CAppMavenUtils.setResolver(resolver);
    	CAppMavenUtils.setLocalRepository(localRepository);
    	CAppMavenUtils.setRemoteRepositories(remoteRepositories);
    }
    
	public void execute() throws MojoExecutionException, MojoFailureException {
		setupMavenRepoObjects();
		File carFile = getCARFile();
		File topologyFile = getTopologyFile();
		try {
			File tempCARDirectory = extractCAR(carFile);
			retrieveParameters(tempCARDirectory);
			resolveParameters(topologyFile);
			updateFiles(tempCARDirectory);
			File rebuiltCARFile = rebuildCAR(tempCARDirectory);
			project.getArtifact().setFile(rebuiltCARFile);
			lineBreak();
		} catch (Exception e) {
			throw new MojoExecutionException("Error trying to rebuild the CAR:"+e.getLocalizedMessage(), e); 
		}
	}

	private File extractCAR(File carFile) throws IOException {
		File tempCARDirectory = new File(project.getBuild().getDirectory(),"car.tmp");
		new ArchiveManipulator().extract(carFile, tempCARDirectory);
		return tempCARDirectory;
	}

	private File rebuildCAR(File tempCARDirectory) {
		lineBreak();
		getLog().info("Building the new CAR...");
		File rebuiltCARFile = new File(project.getBuild().getDirectory(),project.getArtifactId()+".car");
		rebuiltCARFile.getParentFile().mkdirs();
		FileManagementUtil.zipFolder(tempCARDirectory.toString(),rebuiltCARFile.toString());
		getProjectHelper().attachArtifact(project, "car", rebuiltCARFile);
		return rebuiltCARFile;
	}

	private void updateFiles(File tempCARDirectory) throws IOException {
		lineBreak();
		getLog().info("Replacing parameters...");
		for (File scannedFile : scanedFiles) {
			List<String> fileParameterList = getFileParameters(scannedFile);
			if (fileParameterList.size()>0){
				getLog().info("\t"+FileUtils.getRelativePath(tempCARDirectory, scannedFile));
				String content = FileUtils.getContentAsString(scannedFile);
				content=replaceParameters(content, fileParameterList, parameters);
				FileUtils.writeContent(scannedFile, content);
			}
		}
	}

	private void retrieveParameters(File tempCARDirectory) throws IOException {
		lineBreak();
		getLog().info("Scanning the carbon application archive");
		getLog().info("\tmatching file...");
		scanForFiles(tempCARDirectory, scanedFiles);
		getLog().info("\tparameters...");
		checkForParametes(scanedFiles);
	}

	private void resolveParameters(File topologyFile)
			throws UnsupportedTopologyVersion, MojoExecutionException {
		lineBreak();
		getLog().info("Resolving parameters...");
		ITopology topology = TopologyFactory.createNewTopology(topologyFile);
		TopologyFSEngine engine = new TopologyFSEngine(topology, getParameters());
		registerResolvers(engine);
		engine.execute();
		setParameters(engine.getParameters());
		processUnresolvedParameters();
	}

	private void registerResolvers(TopologyFSEngine engine) {
		engine.registerResolver(new ServerParameterResolver());
	}

	private void lineBreak() {
		getLog().info("");
	}

	private void processUnresolvedParameters() throws MojoExecutionException {
		boolean missingFound=false;
		for (String parameter : parameters.keySet()) {
			if (parameters.get(parameter)==null){
				missingFound=true;
				String paraMissingMsg = "\tUnable to resolve parameter '"+parameter+"'";
				if (isFailOnMissingParameters()){
					getLog().error(paraMissingMsg);
				}else{
					getLog().warn(paraMissingMsg);
				}
			}
		}
		if (isFailOnMissingParameters() && missingFound){
			throw new MojoExecutionException("Not all parameters were resolved");
		}
	}

	private File getCARFile() throws MojoExecutionException {
		Artifact carArtifact = CAppMavenUtils.getResolvedArtifact(getCar().getGroupId(), getCar().getArtifactId(), getCar().getVersion(), "car", null);
		File carFile = carArtifact.getFile();
		return carFile;
	}

	private File getTopologyFile() throws MojoExecutionException {
		Artifact topologyArtifact = CAppMavenUtils.getResolvedArtifact(getTopology().getGroupId(), getTopology().getArtifactId(), getTopology().getVersion(), "xml", null);
		File topologyFile = topologyArtifact.getFile();
		return topologyFile;
	}

	private String replaceParameters(String content, List<String> parametersPresent, Map<String,String> allParameters){
		for (String parameter : parametersPresent) {
			if (allParameters.containsKey(parameter)){
				String parameterValue=allParameters.get(parameter);
				if (parameterValue==null){
					getLog().warn("\t\t"+parameter+" NOT RESOLVED");
				}else{
					getLog().info("\t\t"+parameter+" - "+parameterValue);
					String parameterRegEx = Pattern.quote(parameter);
					Pattern compile = Pattern.compile(parameterRegEx);
					Matcher matcher = compile.matcher(content);
					while(matcher.find()){
						content=matcher.replaceAll(parameterValue);
					}
				}
			}
		}
		return content;
	}
	
	private void checkForParametes(List<File> scanedFiles) throws IOException {
		String parameterRegEx = Pattern.quote("${")+"[^"+Pattern.quote("$")+"]*"+Pattern.quote("}");
		Pattern compile = Pattern.compile(parameterRegEx);
		for (File scannedFile : scanedFiles) {
			String content = FileUtils.getContentAsString(scannedFile);
			Matcher matcher = compile.matcher(content);
			List<String> fileParametersList = getFileParameters(scannedFile);
			while(matcher.find()){
				MatchResult matchResult = matcher.toMatchResult();
				if (!fileParametersList.contains(matchResult.group())){
					fileParametersList.add(matchResult.group());
					getParameters().put(matchResult.group(),null);
				}
			}
		}
	}

	private void scanForFiles(File tempCARDirectory, List<File> scanedFiles) {
		File[] files = tempCARDirectory.listFiles();
		for (File candiate : files) {
			if (candiate.isFile() && containsExtension(candiate)){
				scanedFiles.add(candiate);
			}else{
				if (candiate.isDirectory()){
					scanForFiles(candiate, scanedFiles);
				}
			}
		}
	}

	private boolean containsExtension(File candiate) {
		boolean isType=false;
		for(String extension:getScanExtensions()){
			if (candiate.getName().toLowerCase().endsWith("."+extension)){
				isType=true;
				break;
			}
		}
		return isType;
	}

	public MavenProjectHelper getProjectHelper() {
		return projectHelper;
	}

	public static String[] getScanExtensions() {
		return scanExtensions;
	}

	public void setFileParameters(Map<File,List<String>> fileParameters) {
		this.fileParameters = fileParameters;
	}

	public Map<File,List<String>> getFileParameters() {
		return fileParameters;
	}

	public List<String> getFileParameters(File file) {
		if (!getFileParameters().containsKey(file)){
			getFileParameters().put(file, new ArrayList<String>());
		}
		return getFileParameters().get(file);
	}

	
	public void setParameters(Map<String,String> parameters) {
		this.parameters = parameters;
	}

	public Map<String,String> getParameters() {
		return parameters;
	}

	public void setCar(CARMavenArtifact car) {
		this.car = car;
	}

	public CARMavenArtifact getCar() {
		return car;
	}

	public void setTopology(CARMavenArtifact topology) {
		this.topology = topology;
	}

	public CARMavenArtifact getTopology() {
		return topology;
	}

	public boolean isFailOnMissingParameters() {
		if (failOnMissingParameters==null){
			if (System.getProperty("failOnMissingParameters")!=null){
				failOnMissingParameters=System.getProperty("failOnMissingParameters").toLowerCase().equals("true");
			}else{
				failOnMissingParameters=false;
			}
		}
		return failOnMissingParameters;
	}
	
	
}