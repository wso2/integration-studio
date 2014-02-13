package org.wso2.maven.car.artifact.fsm;

import org.wso2.maven.stratos.interfaces.ITopology;

public interface IParameterResolver {
	
	/**
	 * Return the topology
	 * @return
	 */
	public ITopology getTopology();
	
	/**
	 * Resolve the parameter
	 * @param parameter
	 * @return
	 */
	public String resolve(String parameter);
	
	/**
	 * Set the FS engine
	 * @param engine
	 */
	public void setTopologyFSEngine(TopologyFSEngine engine);
}
