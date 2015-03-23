package org.wso2.maven.registry.handler.mojo;

import java.io.File;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.MessageFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.ClassUtils;
import org.wso2.maven.capp.bundleartifact.AbstractBundlePOMGenMojo;
import org.wso2.maven.capp.model.Artifact;
import org.wso2.maven.capp.model.BundlesDataInfo;
import org.wso2.maven.capp.utils.CAppMavenUtils;
import org.wso2.maven.core.utils.MavenUtils;
import org.wso2.maven.registry.handler.model.HandlerInfo;
import org.wso2.maven.registry.handler.model.HandlerInfo.DataType;
import org.wso2.maven.registry.handler.model.HandlerInfo.PropertyData;
import org.wso2.maven.registry.handler.utils.HandlerTemplate;

/**
 * This is the Maven Mojo used for generating a pom for a registry handler artifact 
 * from the old CApp project structure
 * 
 * @goal pom-gen
 * 
 */
public class RegistryHandlerPOMGenMojo extends AbstractBundlePOMGenMojo {
	/**
	 * @parameter default-value="${project}"
	 */
	public MavenProject project;

	/**
	 * Maven ProjectHelper.
	 * 
	 * @component
	 */
	public MavenProjectHelper projectHelper;

	/**
	 * The path of the location to output the pom
	 * 
	 * @parameter expression="${project.build.directory}/artifacts"
	 */
	public File outputLocation;

	/**
	 * The resulting extension of the file
	 * 
	 * @parameter
	 */
	public File artifactLocation;
	
	/**
	 * POM location for the module project
	 * 
	 * @parameter expression="${project.build.directory}/pom.xml"
	 */
	public File moduleProject;
	
	/**
	 * Group id to use for the generated pom
	 * 
	 * @parameter
	 */
	public String groupId;

	/**
	 * Comma separated list of "artifact_type=extension" to be used when creating dependencies for other capp artifacts
	 * 
	 * @parameter
	 */
	public String typeList;

	/**
	 * A list of projects in eclipse workspace which can be referred using maven groupid, artifactid, version
	 * 
	 * @parameter
	 */
	private List<String> projects;

    /**
     * @component
     */
    public ArtifactFactory artifactFactory;

    /**
     * @component
     */
    public ArtifactResolver resolver;

    /**
     * @parameter default-value="${localRepository}"
     */
    public ArtifactRepository localRepository;

    /**
     * @parameter default-value="${project.remoteArtifactRepositories}"
     */
    public List<?> remoteRepositories;

	/**
	 * A list of projects in eclipse workspace which is refered to by the registry handler configuration
	 * 
	 * @parameter
	 */
    private List<String> artifactProjects;
    
	private static final String ARTIFACT_TYPE="lib/registry/handlers";

	private BundlesDataInfo bundlesDataInfo;
	
	protected String getArtifactType() {
		return ARTIFACT_TYPE;
	}

	protected List<String> getProjectMapStrings() {
		return projects;
	}

	public ArtifactFactory getArtifactFactory() {
		return artifactFactory;
	}

	public ArtifactResolver getResolver() {
		return resolver;
	}

	public ArtifactRepository getLocalRepository() {
		return localRepository;
	}

	public List<?> getRemoteRepositories() {
		return remoteRepositories;
	}

	protected BundlesDataInfo getBundlesDataInfo(File targetProjectLocation, Artifact artifact)throws FactoryConfigurationError {
		if (bundlesDataInfo==null) {
			try {
				bundlesDataInfo = new BundlesDataInfo();
				bundlesDataInfo.setProjects(getProjectMappings());
				List<String> artifactProjects = getArtifactProjects();
				for (String artifactProject : artifactProjects) {
					String[] artifactProjectData = artifactProject.split(":");
					if (artifactProjectData.length==2 && artifactProjectData[0].equals(artifact.getName())){
						String[] projectNames = artifactProjectData[1].split(",");
						for (String projectName : projectNames) {
							bundlesDataInfo.addProjectToList(projectName, null);
						}
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bundlesDataInfo;
	}

	public List<String> getArtifactProjects() {
		if (artifactProjects==null){
			artifactProjects=new ArrayList<String>();
		}
		return artifactProjects;
	}

	protected String getBundleActivatorClass(Artifact artifact) {
		return BUNDLE_ACTIVATOR_NAME;
	}

	private final String BUNDLE_ACTIVATOR_NAME = "org.wso2.custom.internal.registry.handler.Activator";
	private static final String HANDLER_VAR_NAME="handler";
	private static final String FILTER_VAR_NAME="filter";
	
	private HandlerInfo getHandlerInfo(Artifact artifact){
		try {
			HandlerInfo handlerInfo=new HandlerInfo();
			handlerInfo.deserialize(artifact.getFile());
			return handlerInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected void copyResources(MavenProject project, File projectLocation,
			Artifact artifact) throws IOException {
		super.copyResources(project, projectLocation, artifact);
		HandlerInfo handlerInfo = getHandlerInfo(artifact);
		if (handlerInfo!=null){
			File sourceContentLocation = new File(projectLocation,"src"+File.separator+"main"+File.separator+"java");
			createActivatorJavaClass(sourceContentLocation, handlerInfo);
		}
	}
	
	protected void addDependencies(MavenProject artifactMavenProject,
			Artifact artifact, File projectLocation) {
		super.addDependencies(artifactMavenProject, artifact, projectLocation);
		Dependency osgiBundleDependency = CAppMavenUtils.createDependency("org.eclipse.osgi", "org.eclipse.osgi", "3.5.0.v20090520");
		Dependency registryCoreBundleDependency = CAppMavenUtils.createDependency("org.wso2.carbon", "org.wso2.carbon.registry.core", "3.0.1");
		Dependency axiomBundleDependency = CAppMavenUtils.createDependency("org.apache.ws.commons.axiom.wso2", "axiom", "1.2.9-wso2v1");
		Dependency geranimoStAXBundleDependency = CAppMavenUtils.createDependency("org.apache.geronimo.specs.wso2", "geronimo-stax-api_1.0_spec", "1.0.1.wso2v1");
		MavenUtils.addMavenDependency(artifactMavenProject, osgiBundleDependency,registryCoreBundleDependency,axiomBundleDependency,geranimoStAXBundleDependency);
	}
	
	private static String backlashDoubler(String myStr){
	    final StringBuilder result = new StringBuilder();
	    final StringCharacterIterator iterator = new StringCharacterIterator(myStr);
	    char character =  iterator.current();
	    while (character != CharacterIterator.DONE ){
	     
	      if (character == '\\') {
	         result.append("\\\\");
	      }
	       else {
	        result.append(character);
	      }

	      
	      character = iterator.next();
	    }
	    return result.toString();
	  }
	public static String getSetMethod(String methodName) {
		methodName=methodName.substring(0,1).toUpperCase()+methodName.substring(1);
		String e = "set"+methodName;
		return e;
	}
	private void addPropertySetMethods(List<String> propertySetMethodCallList,
			String objectVarName, Map<String, PropertyData> filterProperties) {
		boolean omVarCreated=false;
		boolean varCreated=false;
		for (String propertyName : filterProperties.keySet()) {
			PropertyData propertyData = filterProperties.get(propertyName);

			String methodCall = objectVarName + "." + getSetMethod(propertyName);
			String dataVar;
			String data = backlashDoubler(propertyData.data).replaceAll("\"", "\\\\\"").replaceAll("\\n", "\\\\n\"+\n\t\t\"");
			if (propertyData.type==DataType.STRING){
				dataVar = objectVarName+"PropertyData";
				String variableToAssign=(!varCreated? "String ":"")+dataVar;
				propertySetMethodCallList.add(variableToAssign+" = \""+data+"\";");
				varCreated=true;
			}else{
				dataVar = objectVarName+"PropertyDataOMElement";
				String variableToAssign=(!omVarCreated? "OMElement ":"")+dataVar;
				propertySetMethodCallList.add(variableToAssign+" = getElement(\""+data+"\");");
				omVarCreated=true;
			}
			propertySetMethodCallList.add(methodCall + "(" + dataVar + ");");
		}
	}
	
	private List<String> getPropertySetMethodCallList(HandlerInfo handlerInfo) {
		List<String> propertySetMethodCallList=new ArrayList<String>();
		
		String objectVarName = FILTER_VAR_NAME;
		Map<String, PropertyData> filterProperties = handlerInfo.getFilterProperties();
		addPropertySetMethods(propertySetMethodCallList, objectVarName,
				filterProperties);
		objectVarName = HANDLER_VAR_NAME;
		Map<String, PropertyData> handlerProperties = handlerInfo.getHandlerProperties();
		addPropertySetMethods(propertySetMethodCallList, objectVarName,
				handlerProperties);
		return propertySetMethodCallList;
	}
	
	private File createActivatorJavaClass(File sourceContentLocation,HandlerInfo handlerInfo) throws IOException {
		String handlerFileContent = HandlerTemplate.getInstance().getResourceString("templates/Activator.java");
		List<String> propertySetMethodCallList = getPropertySetMethodCallList(handlerInfo);
		StringBuffer sb=new StringBuffer();
		sb.append("\n");
		for (String methodCall : propertySetMethodCallList) {
			sb.append(methodCall).append("\n");
		}
		handlerFileContent = MessageFormat
				.format(
						handlerFileContent,
						new Object[] {
								handlerInfo.getHandlerClass(),
								ClassUtils.getClassName(handlerInfo.getHandlerClass()),
								handlerInfo.getFilterClass(),
								ClassUtils.getClassName(handlerInfo.getFilterClass()),
								filterMethodList((String[]) handlerInfo.getSelectedMethods().toArray(new String[] {})),
								sb.toString(),
								"{",
								"}",
								HANDLER_VAR_NAME,
								FILTER_VAR_NAME});
		String packagePath = BUNDLE_ACTIVATOR_NAME.replaceAll("\\.",File.separator)+".java";
		File activatorClass = new File(sourceContentLocation, packagePath);
		FileUtils.writeContent(activatorClass, handlerFileContent);
		return activatorClass;
	}
	
	private static String filterMethodList(String[] methodsList) {
		if (methodsList.length>0){
			StringBuffer sb=new StringBuffer();
			sb.append(" Filter.").append(methodsList[0]);
			for (int i = 1; i < methodsList.length; i++) {
				sb.append(", Filter.").append(methodsList[i]);
			}
			return sb.toString();
		}else{
			return "";
		}
	}
	
	protected void addPlugins(MavenProject artifactMavenProject,Artifact artifact) {
		addMavenBundlePlugin(artifactMavenProject, artifact);
	}
}
