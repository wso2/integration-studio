package org.wso2.developerstudio.eclipse.platform.core.templates;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ArtifactTemplate {

	private String name;
	private String id;
	private String templateFileName;
	private Bundle templateBundle;
	private String mediaType;
	private String defaultExtension;
	private boolean custom;
	
	public ArtifactTemplate(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTemplateBundle(Bundle templateBundle) {
		this.templateBundle = templateBundle;
	}
	public Bundle getTemplateBundle() {
		return templateBundle;
	}
	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}
	public String getTemplateFileName() {
		return templateFileName;
	}
	
	public InputStream getTemplateDataStream() throws IOException{
		URL resource = getTemplateUrl();
		return resource.openStream();
	}
	public URL getTemplateUrl() {
		return getTemplateBundle().getResource(getTemplateFileName());
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setDefaultExtension(String defaultExtension) {
		this.defaultExtension = defaultExtension;
	}
	public String getDefaultExtension() {
		if (defaultExtension==null){
			String[] filenamePath = getTemplateFileName().split("/");
			if (filenamePath==null || filenamePath.length<2){
				defaultExtension=FileUtils.getResourceFileNameExtension(getTemplateFileName());
			}else{
				defaultExtension=FileUtils.getResourceFileNameExtension(filenamePath[filenamePath.length-1]);
			}
		}
		return defaultExtension;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public boolean isCustom() {
		return custom;
	}
	
}
