package org.wso2.developerstudio.eclipse.integration.project.model;

import java.io.File;

import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class IntegrationProjectModel extends ProjectDataModel {	
	private File integrationConfigLocation;
	
	public void setLocation(File location) {
		// TODO Auto-generated method stub
		super.setLocation(location);
	}
	
	public File getLocation() {
		// TODO Auto-generated method stub
		return super.getLocation();
	}
	
 	public Object getModelPropertyValue(String key) {
 		  Object modelPropertyValue = super.getModelPropertyValue(key);
 		  if(key.equals("integrationConfig.location")){
 				modelPropertyValue = getIntegrationConfigLocation();
 			}
 		  return modelPropertyValue;
 		}
	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if("integrationConfig.location".equals(key)){
			setIntegrationConfigLocation(new File(data.toString()));
		}
		return isUiControlUpdated;
	}
	
	public void setIntegrationConfigLocation(File synapseConfigLocation) {
		this.integrationConfigLocation=synapseConfigLocation;
	}	
	public File getIntegrationConfigLocation() {
		return integrationConfigLocation;
	}
}
