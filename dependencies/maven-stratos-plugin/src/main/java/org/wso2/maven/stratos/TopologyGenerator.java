package org.wso2.maven.stratos;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.wso2.maven.stratos.interfaces.ITopology;
import org.wso2.maven.stratos.interfaces.ITopologyServer;
import org.wso2.maven.stratos.model.TopologyFactory;
import org.wso2.maven.stratos.utils.CarbonServerUtils;
import org.wso2.maven.stratos.utils.StratosUtils;
import org.wso2.stratos.manager.services.mgt.services.CloudManagerServiceStub.CloudService;


/**
 * Create a topology artifact from stratos url
 *
 * @goal topology-gen
 * @phase package
 * @description create the topology.xml
 */
public class TopologyGenerator extends AbstractMojo {
	
	/**
	 * @parameter
	 * @required
	 */
	private URL url;
	
	/**
	 * @parameter default-value=false
	 */
	private boolean allowInvalidCertificates;
	
	
	/**
	 * @parameter
	 */
	private String tenantUsername;
	
	/**
	 * @parameter
	 */
	private String tenantPassword;

	/**
	 * @parameter default-value="${project}"
	 */
	private MavenProject mavenProject;

	public void execute() throws MojoExecutionException, MojoFailureException {
		validCredentialAvailability();
		try {
			File TARGET_DIR=new File(mavenProject.getBuild().getDirectory());
			getLog().info("Stratos manager - "+getUrl().toString());
			getLog().info("\tAuthenticating with user '"+getTenantUsername()+"'"+"...");
			String stratosAutheticatedSessionCookie = CarbonServerUtils.getAutheticatedSessionCookie(getUrl(), getTenantUsername(), getTenantPassword(),isAllowInvalidCertificates());
			if (stratosAutheticatedSessionCookie==null){
				throw new MojoExecutionException("Authentication failed");
			}
			getLog().info("\tRetrieving cloud service list"+"...");
			CloudService[] cloudServices = StratosUtils.getCloudServices(getUrl(), stratosAutheticatedSessionCookie,isAllowInvalidCertificates());
			ITopology topology = TopologyFactory.createNewTopology("1.0.0");
			getLog().info("\tProcessing cloud service list"+"...");
			for (CloudService cloudService : cloudServices) {
				getLog().info("\t\t"+cloudService.getName()+" - "+cloudService.getLink());
				Map<String, URL> urlMap = new HashMap<String, URL>();
				URL carbonServerUrl = new URL(cloudService.getLink());
				urlMap.put("https", carbonServerUrl);
				String autheticatedSessionCookie = CarbonServerUtils.getAutheticatedSessionCookie(carbonServerUrl, getTenantUsername(), getTenantPassword(),isAllowInvalidCertificates());
				if (autheticatedSessionCookie==null){
					throw new MojoExecutionException("Authentication failed for cloud service '"+cloudService.getName()+"' at "+cloudService.getLink());
				}
				String[] serverRoles = CarbonServerUtils.getServerRoles(carbonServerUrl, autheticatedSessionCookie,isAllowInvalidCertificates());
				ITopologyServer topologyServer = TopologyFactory.createNewTopologyServer(urlMap, serverRoles, cloudService.getName());
				topology.addServers(topologyServer);
			}
			getLog().info("Generating topology...");
			File topologyFile = new File(TARGET_DIR,"topology.xml");
			topology.save(topologyFile);
			mavenProject.getArtifact().setFile(topologyFile);
		} catch (Exception e) {
			throw new MojoExecutionException("Error occured while collecting topology information: "+e.getMessage(), e);
		}
		

	}

	private void validCredentialAvailability() throws MojoExecutionException {
		if (getTenantUsername()==null || getTenantUsername().trim().equals("")){
			throw new MojoExecutionException("Tenant username is not specified. Update the maven configuration '<tenantUsername>USERNAME</tenantUsername>' or command-line parameter -Dtenant.username=USERNAME");
		}
		if (getTenantPassword()==null || getTenantPassword().trim().equals("")){
			throw new MojoExecutionException("Tenant password is not specified. Update the maven configuration '<tenantPassword>PASSWORD</tenantPassword>' or command-line parameter -Dtenant.password=PASSWORD");
		}
	}

	public String getTenantUsername() {
		if (tenantUsername==null){
			tenantUsername=System.getProperty("tenant.username");
		}
		return tenantUsername;
	}

	public String getTenantPassword() {
		if (tenantPassword==null){
			tenantPassword=System.getProperty("tenant.password");
		}
		return tenantPassword;
	}

	public URL getUrl() {
		return url;
	}

	public void setAllowInvalidCertificates(boolean allowInvalidCertificates) {
		this.allowInvalidCertificates = allowInvalidCertificates;
	}

	public boolean isAllowInvalidCertificates() {
		return allowInvalidCertificates;
	}

}