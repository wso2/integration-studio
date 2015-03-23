package org.wso2.maven.stratos.model;

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;

import org.wso2.maven.stratos.exception.UnsupportedTopologyVersion;
import org.wso2.maven.stratos.interfaces.ITopology;
import org.wso2.maven.stratos.interfaces.ITopologyServer;

public class TopologyFactory {
	
	public static ITopology createNewTopology(File topologyFile) throws UnsupportedTopologyVersion{
		Topology100 topology = new Topology100();
		try {
			topology.deserialize(topologyFile);
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (UnsupportedTopologyVersion e){
			//try the other impls
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topology;
	}
	public static ITopology createNewTopology(String topologyVersion) throws UnsupportedTopologyVersion{
		if (Topology100.topologyVersion.equals(topologyVersion)){
			return new Topology100();
		}
		throw new UnsupportedTopologyVersion(topologyVersion);
	}

	public static ITopologyServer createNewTopologyServer(Map<String,URL> urlMap, String[] serverRoles, String serverName){
		TopologyServer topologyServer = new TopologyServer();
		topologyServer.addUrls(urlMap);
		topologyServer.addServerRoles(serverRoles);
		topologyServer.setServerName(serverName);
		return topologyServer;
	}
}
