package org.wso2.maven.stratos.interfaces;

import java.io.File;
import java.util.List;

public interface ITopology {

	public void addServers(List<ITopologyServer> servers);

	public void addServers(ITopologyServer... servers);

	public List<ITopologyServer> getServers();

	public String getVersion();
	
	public void load(File file) throws Exception;
	
	public void save(File file) throws Exception;
}