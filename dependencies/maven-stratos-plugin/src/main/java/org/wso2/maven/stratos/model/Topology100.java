package org.wso2.maven.stratos.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.wso2.maven.core.model.AbstractXMLDoc;
import org.wso2.maven.stratos.exception.UnsupportedTopologyVersion;
import org.wso2.maven.stratos.interfaces.ITopology;
import org.wso2.maven.stratos.interfaces.ITopologyServer;

public class Topology100 extends AbstractXMLDoc implements ITopology{
	private List<ITopologyServer> servers;
	protected static String topologyVersion="1.0.0";
	
	@Override
	protected void deserialize(OMElement topologyElement) throws Exception {
		String versionAttribute = getAttribute(topologyElement, "version");
		if (versionAttribute==null){
			versionAttribute=topologyVersion;
		}
		
		if (!versionAttribute.equalsIgnoreCase(topologyVersion)){
			throw new UnsupportedTopologyVersion(versionAttribute);
		}
		
		List<OMElement> serversElement = getChildElements(topologyElement, "servers");
		if (serversElement!=null && serversElement.size()>0){
			List<OMElement> serverElements = getChildElements(serversElement.get(0), "server");
			for (OMElement serverElement : serverElements) {
				TopologyServer topologyServer = new TopologyServer();
				topologyServer.deserialize(serverElement);
				addServers(topologyServer);
			}
		}
	}

	@Override
	protected String serialize() throws Exception {
		OMElement rootElement = getDocumentElement();
		OutputStream out=new ByteArrayOutputStream();
		prettify(rootElement, out);
		return out.toString();
	}

	private OMElement getDocumentElement() {
		OMElement rootElement = getElement("topology",null);
		addAttribute(rootElement, "version", topologyVersion);
		OMElement serversElement = getElement("servers",null);
		for (ITopologyServer server : getServers()) {
			serversElement.addChild(server.getDocumentElement());
		}
		rootElement.addChild(serversElement);
		return rootElement;
	}

	@Override
	protected String getDefaultName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopology#addServers(java.util.List)
	 */
	public void addServers(List<ITopologyServer> servers) {
		getServers().addAll(servers);
	}

	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopology#addServers(org.wso2.maven.stratos.model.Server)
	 */
	public void addServers(ITopologyServer...servers) {
		getServers().addAll(Arrays.asList(servers));
	}
	
	/* (non-Javadoc)
	 * @see org.wso2.maven.stratos.model.ITopology#getServers()
	 */
	public List<ITopologyServer> getServers() {
		if (servers==null){
			servers=new ArrayList<ITopologyServer>();
		}
		return servers;
	}

	public String getVersion() {
		return topologyVersion;
	}

	@Override
	public void load(File file) throws Exception {
		deserialize(file);
	}

	@Override
	public void save(File file) throws Exception {
		toFile(file);
	}

}
