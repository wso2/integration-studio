package org.wso2.maven.stratos.interfaces;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;

public interface ITopologyServer {

	public void addUrls(Map<String, URL> urls);

	public void addUrls(String type, URL url);

	public Map<String, URL> getUrls();

	public void addServerRoles(List<String> serverRoles);

	public void addServerRoles(String... serverRoles);

	public List<String> getServerRoles();

	public abstract OMElement getDocumentElement();

	public String getServerName();
	
	public void setServerName(String serverName);
}