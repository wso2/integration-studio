package org.wso2.maven.stratos.model;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.wso2.maven.core.model.AbstractXMLDoc;
import org.wso2.maven.stratos.interfaces.ITopologyServer;

public class TopologyServer extends AbstractXMLDoc implements ITopologyServer{
	private Map<String,URL> urls;
	private List<String> serverRoles;
	private String serverName;
	
	@Override
	protected void deserialize(OMElement serverElement) throws Exception {
		String serverNameAttribute = getAttribute(serverElement, "name");
		setServerName(serverNameAttribute);
		List<OMElement> urlsElement = getChildElements(serverElement, "urls");
		if (urlsElement!=null && urlsElement.size()>0){
			List<OMElement> urlElements = getChildElements(urlsElement.get(0), "url");
			for (OMElement urlElement : urlElements) {
				String typeAttribute = getAttribute(urlElement, "type");
				if (typeAttribute==null){
					typeAttribute="servlet_https";
				}
				addUrls(typeAttribute,new URL(urlElement.getText()));
			}
		}
		List<OMElement> serverRolesElement = getChildElements(serverElement, "serverRoles");
		if (serverRolesElement!=null && serverRolesElement.size()>0){
			List<OMElement> serverRoleElements = getChildElements(serverRolesElement.get(0), "role");
			for (OMElement serverRoleElement : serverRoleElements) {
				addServerRoles(serverRoleElement.getText());
			}
		}
	}
	
	@Override
	protected String serialize() throws Exception {
		OMElement serverElement = getDocumentElement();
		ByteArrayOutputStream xmlStream = new ByteArrayOutputStream();
		prettify(serverElement, xmlStream);
		return xmlStream.toString();
	}

	@Override
	public OMElement getDocumentElement() {
		OMElement serverElement = getElement("server", null);
		if (getServerName()!=null){
			addAttribute(serverElement, "name", getServerName());
		}
		OMElement urlsElement = getElement("urls", null);
		for (String urlType : getUrls().keySet()) {
			URL url = getUrls().get(urlType);
			OMElement urlElement = getElement("url", url.toString());
			addAttribute(urlElement, "type", urlType);
			urlsElement.addChild(urlElement);
		}
		serverElement.addChild(urlsElement);
		
		OMElement serverRolesElement = getElement("serverRoles", null);
		for (String role : getServerRoles()) {
			OMElement roleElement = getElement("role", role);
			serverRolesElement.addChild(roleElement);
		}
		serverElement.addChild(serverRolesElement);
		return serverElement;
	}
	
	@Override
	protected String getDefaultName() {
		return "topology.xml";
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopologyServer#addUrls(java.util.Map)
	 */
	public void addUrls(Map<String,URL> urls) {
		getUrls().putAll(urls);
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopologyServer#addUrls(java.lang.String, java.net.URL)
	 */
	public void addUrls(String type, URL url) {
		getUrls().put(type,url);
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopologyServer#getUrls()
	 */
	public Map<String,URL> getUrls() {
		if (urls==null){
			urls=new HashMap<String, URL>();
		}
		return urls;
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopologyServer#addServerRoles(java.util.List)
	 */
	public void addServerRoles(List<String> serverRoles) {
		getServerRoles().addAll(serverRoles);
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopologyServer#addServerRoles(java.lang.String)
	 */
	public void addServerRoles(String...serverRoles) {
		getServerRoles().addAll(Arrays.asList(serverRoles));
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopologyServer#getServerRoles()
	 */
	public List<String> getServerRoles() {
		if (serverRoles==null){
			serverRoles=new ArrayList<String>();
		}
		return serverRoles;
	}

	@Override
	public String getServerName() {
		return serverName;
	}

	@Override
	public void setServerName(String serverName) {
		this.serverName=serverName;
	}
}
