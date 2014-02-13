/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.maven.car.artifact;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;
import org.wso2.carbon.stub.ApplicationAdminStub;
import org.wso2.carbon.stub.AuthenticationAdminStub;
import org.wso2.carbon.stub.CarbonAppUploaderStub;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.activation.DataHandler;

/**
 * Deploy the generated CAR file to a Remote Server
 *
 * @goal deploy-car
 * @phase deploy
 * @description Deploy CAR Artifact
 */
public class DeployCarMojo extends AbstractMojo {
	
	/**
     * Location Trust Store folder
     * @required
     * @parameter expression="${trustStorePath}" default-value="${basedir}/src/main/resources/security/wso2carbon.jks"
     */
	private String trustStorePath;
	
	/**
     * Location Trust Store folder
     * @required
     * @parameter expression="${trustStorePassword}" default-value="wso2carbon"
     */
	private String trustStorePassword;
	
	/**
     * Type of Trust Store
     * @required
     * @parameter expression="${trustStoreType}" default-value="JKS"
     */	
	private String trustStoreType;
	
	/**
     * Server URL
     * @required
     * @parameter expression="${serverUrl}" default-value="https://localhost:9443"
     */	
	private String serverUrl;
	
	/**
     * Server URL
     * @required
     * @parameter expression="${userName}" default-value="admin"
     */	
	private String userName;
	
	
	/**
     * Server URL
     * @required
     * @parameter expression="${password}" default-value="admin"
     */	
	private String password;
	
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
     * @parameter expression="${operation}" default-value="deploy"
     */
    private String operation;
    
    /**
	 * Maven ProjectHelper.
	 * 
	 * @parameter
	 */
    private List<CarbonServer> carbonServers;
    
	/**
	 * Set this to 'false' to enable C-App artifact deploy
	 * 
	 * @parameter expression="${maven.car.deploy.skip}" default-value="true"
	 */
    private boolean skip;     
    

	public void execute() throws MojoExecutionException, MojoFailureException {
		if (skip) {
			getLog().info("Skipping CAR artifact deployment to Carbon Server(s).");
			return;
		}
		
		if(carbonServers==null){
			deployCAR();
		}else if(carbonServers!= null && carbonServers.isEmpty()){
			deployCAR();
		}else{
			for (CarbonServer server : carbonServers) {
				getLog().info("Deploying to Server...");
				getLog().info("TSPath="+server.getTrustStorePath());
				if(server.getTrustStorePath()!=null){
					trustStorePath=server.getTrustStorePath();
				}
				getLog().info("TSPWD="+server.getTrustStorePassword());
				if(server.getTrustStorePassword()!=null){
					trustStorePassword=server.getTrustStorePassword();
				}
				getLog().info("TSType="+server.getTrustStoreType());
				if(server.getTrustStoreType()!=null){
					trustStoreType=server.getTrustStoreType();
				}
				getLog().info("Server URL="+server.getServerUrl());
				if(server.getServerUrl()!=null){
					serverUrl=server.getServerUrl();
				}
				getLog().info("UserName="+server.getUserName());
				if(server.getUserName()!=null){
					userName=server.getUserName();
				}
				getLog().info("Password="+server.getPassword());
				if(server.getPassword()!=null){
					password=server.getPassword();
				}
				getLog().info("Operation="+server.getOperation());
				if(server.getOperation()!=null){
					operation=server.getOperation();
				}
				
				deployCAR();
			}
		}
    }

	private void deployCAR() throws MojoExecutionException {
		setSystemProperties();
		
		List<Plugin> buildPlugins = project.getBuildPlugins();
		
		for (Plugin plugin : buildPlugins) {
			String artifactId = plugin.getArtifactId();
			if(artifactId.equals("maven-car-plugin")){
				Xpp3Dom configurationNode = (Xpp3Dom)plugin.getConfiguration();
				Xpp3Dom finalNameNode = configurationNode.getChild("finalName");
				if (finalNameNode != null) {
					finalName = finalNameNode.getValue();
					getLog().info("Final Name of C-App: "+finalName+".car");
				}
				break;
			}
		}
		
	    File carFile = null;
		if (finalName == null) {
			carFile = new File(target + "/" + project.getArtifactId() + "_"
					+ project.getVersion() + ".car");
		}else{
			carFile = new File(target + "/" + finalName + ".car");
		}
		
	    if(operation.equalsIgnoreCase("deploy")){
		    try {
				deployCApp(userName, password, serverUrl, carFile);
				getLog().info("Uploading "+carFile.getName()+" to "+serverUrl+ " completed successfully.");
			} catch (Exception e) {
				getLog().error("Uploading "+carFile.getName()+" to "+serverUrl+ " Failed.", e);
				throw new MojoExecutionException("Deploying "+carFile.getName()+" to "+serverUrl+ " Failed.", e);
			}
	    }else{
	    	 try {
	 			unDeployCAR(userName, password, serverUrl);
	 			getLog().info("Deleting "+carFile.getName()+" to "+serverUrl+ " completed successfully.");
	 		} catch (Exception e) {
	 			getLog().error("Deleting "+carFile.getName()+" to "+serverUrl+ " Failed.", e);
	 			throw new MojoExecutionException("Deleting "+carFile.getName()+" to "+serverUrl+ " Failed.", e);
	 		}
	    }
	}
	
	@SuppressWarnings("unused")
	private void printParams(){
		if(!carbonServers.isEmpty()){
			for (CarbonServer server : carbonServers) {
				getLog().info("Server:");
				getLog().info("TSPath="+server.getTrustStorePath());
				getLog().info("TSPWD="+server.getTrustStorePassword());
				getLog().info("TSType="+server.getTrustStoreType());
				getLog().info("Server URL="+server.getServerUrl());
				getLog().info("UserName="+server.getUserName());
				getLog().info("Password="+server.getPassword());
				getLog().info("Operation="+server.getOperation());
				
				if(server.getUserName()==null){
					getLog().info("HIT THE GROUNDS!");
				}
			}
		}
	}
	
	private void setSystemProperties(){
		System.setProperty("javax.net.ssl.trustStore", trustStorePath);
		System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
		System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);
	}
	
	private String createSessionCookie(String serverURL, String username, String pwd) throws Exception{
		AuthenticationAdminStub authenticationStub;
		URL url = new URL(serverURL);
		authenticationStub = new AuthenticationAdminStub(serverURL+ "/services/AuthenticationAdmin");
		authenticationStub._getServiceClient().getOptions().setManageSession(true);
		if (authenticationStub.login(username, pwd, url.getHost())){
			ServiceContext serviceContext = authenticationStub._getServiceClient().getLastOperationContext().getServiceContext();
			String sessionCookie = (String) serviceContext.getProperty(HTTPConstants.COOKIE_STRING);
			getLog().info("Authentication to "+serverURL+" successful.");
			return sessionCookie;
		}else{
			return null;
		}
	}
	
	private CarbonAppUploaderStub getCarbonAppUploaderStub(String username,
			String pwd, String url) throws Exception, AxisFault,
			MalformedURLException {
		String sessionCookie = createSessionCookie(url, username, pwd);
		CarbonAppUploaderStub carbonAppUploaderStub = new CarbonAppUploaderStub(serverUrl + "/services/CarbonAppUploader");
		carbonAppUploaderStub._getServiceClient().getOptions().setManageSession(true);
		carbonAppUploaderStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return carbonAppUploaderStub;
	}
	
	public void deployCApp(String username, String pwd, String url, File carFile) throws Exception{
		CarbonAppUploaderStub carbonAppUploaderStub = getCarbonAppUploaderStub(username, pwd, url);
		UploadedFileItem uploadedFileItem = new UploadedFileItem();
		DataHandler param=new DataHandler(carFile.toURI().toURL());
		uploadedFileItem.setDataHandler(param);
		uploadedFileItem.setFileName(carFile.getName());
		uploadedFileItem.setFileType("jar");
		UploadedFileItem[] fileItems=new UploadedFileItem[]{uploadedFileItem};
		getLog().info("Uploading "+carFile.getName()+" to "+serverUrl+ "...");
		carbonAppUploaderStub.uploadApp(fileItems);
	}

	public void unDeployCAR(String username, String pwd,String serverURL) throws Exception{
		ApplicationAdminStub appAdminStub = getApplicationAdminStub(serverURL, username, pwd);
		String[] existingApplications = appAdminStub.listAllApplications();
		if (existingApplications!=null && Arrays.asList(existingApplications).contains(project.getArtifactId())){
			appAdminStub.deleteApplication(project.getArtifactId());
		}
	}

	private ApplicationAdminStub getApplicationAdminStub(String serverURL, String username, String pwd) throws Exception,
			AxisFault, MalformedURLException {
		String sessionCookie = createSessionCookie(serverURL, username, pwd);
		ApplicationAdminStub appAdminStub = new ApplicationAdminStub(serverUrl + "/services/ApplicationAdmin");
		appAdminStub._getServiceClient().getOptions().setManageSession(true);
		appAdminStub._getServiceClient().getOptions().setProperty(HTTPConstants.COOKIE_STRING, sessionCookie);
		return appAdminStub;
	}
}
