package org.wso2.maven.car.artifact.fsm.resolvers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wso2.maven.car.artifact.fsm.IParameterResolver;
import org.wso2.maven.car.artifact.fsm.TopologyFSEngine;
import org.wso2.maven.stratos.interfaces.ITopology;
import org.wso2.maven.stratos.interfaces.ITopologyServer;

public class ServerParameterResolver implements IParameterResolver {
	private TopologyFSEngine engine;
	private HashMap<String, Map<String, URL>> serverRoleMap;
	
	/**
	 * parameter = ${servers.<ServerRole>.<SomeSetting>*}
	 */
	public String resolve(String parameter) {
		String s=parameter.substring(2,parameter.length()-1);
		String[] parameterSections = s.split("\\.");
		
		String key = parameterSections[0];
		List<String> values = removeFirstParameter(parameterSections);
		
		return getParameterValue(key, values);
	}

	public ITopology getTopology() {
		return engine.getTopology();
	}

	public void setTopologyFSEngine(TopologyFSEngine engine) {
		this.engine=engine;
		initialize();
	}

	private String getParameterValue(String key, List<String> values){
		key=key.toLowerCase();
		if (key.equals("servers")){
			return getServersParameter(values.get(0), removeFirstParameter(values));
		}
		return null;
	}
	
	private String getServersParameter(String serverRole, List<String> values){
		if (getServerRoleMap().containsKey(serverRole)){
			String logic1 = values.get(0).toLowerCase();
			if (logic1.equals("url")) {
				Map<String, URL> map = getServerRoleMap().get(serverRole);
				String urlInfo = values.get(1).toLowerCase();
				URL url = map.get(urlInfo);
				if (values.size()==2) {
					return url.toString();
				}else if (values.get(2).equals("host")){
					return url.getHost();
				}else if (values.get(2).equals("port")){
					return String.valueOf(url.getPort());
				}else if (values.get(2).equals("protocol")){
					return url.getProtocol();
				}
			}
		}
		return null;
	}

	private List<String> removeFirstParameter(String...list){
		return removeFirstParameter(Arrays.asList(list));
	}
	
	private List<String> removeFirstParameter(List<String> list){
		List<String> newList = new ArrayList<String>();
		newList.addAll(list);
		newList.remove(0);
		return newList;
	}

	public HashMap<String, Map<String, URL>> getServerRoleMap() {
		if (serverRoleMap==null){
			serverRoleMap=new HashMap<String, Map<String,URL>>();
		}
		return serverRoleMap;
	}
	
	private void initialize(){
		HashMap<String, Map<String, URL>> serverRoleMap = getServerRoleMap();
		List<ITopologyServer> servers = getTopology().getServers();
		for (ITopologyServer server : servers) {
			List<String> serverRoles = server.getServerRoles();
			for (String role : serverRoles) {
				if (!serverRoleMap.containsKey(role)){
					serverRoleMap.put(role, server.getUrls());
				}
			}
		}
	}
}
