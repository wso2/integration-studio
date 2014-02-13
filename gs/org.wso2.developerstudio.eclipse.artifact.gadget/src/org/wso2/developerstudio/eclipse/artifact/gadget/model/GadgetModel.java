package org.wso2.developerstudio.eclipse.artifact.gadget.model;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class GadgetModel extends ProjectDataModel {

     private IProject gadgetProject;
	 private String gadgetXml="gadget";
	 private String resourceDir;
	 private String author="WSO2";
	 private String description= new String() ;
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if((modelPropertyValue == null)&&("gadgetxml.name".equals(key))){
			  modelPropertyValue = this.getGadgetXml();
		  } else if((modelPropertyValue == null)&&("import.dir".equals(key))){
			  modelPropertyValue = this.getResourceDir();
		  } else if((modelPropertyValue == null)&&("author".equals(key))) {
			  modelPropertyValue = getAuthor();
		  } else if((modelPropertyValue == null)&&("description".equals(key))) {
			  modelPropertyValue = getDescription();
		  }
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if ("gadgetxml.name".equals(key)) {
			this.setGadgetXml(data.toString());
		} else if ("import.dir".equals(key)) {
			this.setResourceDir(data.toString());
		} else if ("author".equals(key)) {
			setAuthor(data.toString());
		} else if ("description".equals(key)) {
		 	setDescription(data.toString());
		}
		return isUiControlUpdated;
	}

	public void setGadgetProject(IProject project){
		gadgetProject = project;
	}
	
	public IProject getGadgetProject() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setGadgetXml(String gadgetXml) {
		this.gadgetXml = gadgetXml;
	}

	public String getGadgetXml() {
		return gadgetXml;
	}

	public void setResourceDir(String resourceDir) {
		this.resourceDir = resourceDir;
	}

	public String getResourceDir() {
		return resourceDir;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
