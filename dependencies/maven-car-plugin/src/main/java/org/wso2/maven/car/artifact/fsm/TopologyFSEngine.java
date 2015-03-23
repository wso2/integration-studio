package org.wso2.maven.car.artifact.fsm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.wso2.maven.stratos.interfaces.ITopology;

/**
 * Engine to resolve parameters based on Topology & CAR 
 *
 */
public class TopologyFSEngine {
	private ITopology topology;
	private Map<String,String> parameters;
	private List<IParameterResolver> resolvers;
	
	public TopologyFSEngine(ITopology topology, Map<String,String> parameters) {
		this.setTopology(topology);
		this.setParameters(parameters);
	}

	public void setTopology(ITopology topology) {
		this.topology = topology;
	}

	public ITopology getTopology() {
		return topology;
	}

	public void setParameters(Map<String,String> parameters) {
		this.parameters = parameters;
	}

	public Map<String,String> getParameters() {
		return parameters;
	}
	
	public String[] getParameterNameList(){
		return getParameters().keySet().toArray(new String[]{});
	}
	
	/**
	 * Try to resolve all the parameters
	 */
	public void execute(){
		String[] parameterNameList = getParameterNameList();
		for(String parameter:parameterNameList){
			if (getParameters().get(parameter)==null){
				for (IParameterResolver resolver : getResolvers()) {
					String parameterValue = resolver.resolve(parameter);
					if (parameterValue!=null){
						getParameters().put(parameter, parameterValue);
						break;
					}
				}
			}
		}
	}

	public List<IParameterResolver> getResolvers() {
		if (resolvers==null){
			resolvers=new ArrayList<IParameterResolver>();
		}
		return resolvers;
	}

	/**
	 * Add a resolver to the engine
	 * @param resolver
	 */
	public void registerResolver(IParameterResolver resolver){
		resolver.setTopologyFSEngine(this);
		getResolvers().add(resolver);
	}
	
	/**
	 * Remove a resolver from the engine. This resolver will no longer 
	 * take part in resolving parameters once removed.
	 * @param resolver
	 */
	public void unregisterResolver(IParameterResolver resolver){
		if (getResolvers().contains(resolver)){
			getResolvers().remove(resolver);
		}
	}
}
