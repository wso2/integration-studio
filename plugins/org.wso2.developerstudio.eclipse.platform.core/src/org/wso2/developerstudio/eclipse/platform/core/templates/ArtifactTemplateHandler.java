package org.wso2.developerstudio.eclipse.platform.core.templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;

public class ArtifactTemplateHandler {
	private static final String ESB_ARTIFACT_TEMPLATE_EXTENSION="org.wso2.developerstudio.eclipse.platform.core.artifacttemplates";
	private static List<ArtifactTemplate> templateList;
	
	private static void loadProxyTemplateInfo(){
		templateList=new ArrayList<ArtifactTemplate>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(ESB_ARTIFACT_TEMPLATE_EXTENSION);
		for (IConfigurationElement e : config) {		
			try {
				ArtifactTemplate proxyTemplate = new ArtifactTemplate(e.getAttribute("id"),e.getAttribute("name"));
				proxyTemplate.setId(e.getAttribute("id"));
				proxyTemplate.setName(e.getAttribute("name"));
				String fileName = e.getAttribute("file");
				Bundle bundle = Platform.getBundle(e.getContributor().getName());
				proxyTemplate.setTemplateFileName(fileName);
				proxyTemplate.setTemplateBundle(bundle);
				String isCustom = e.getAttribute("custom");
				if(null!=isCustom){
					proxyTemplate.setCustom(Boolean.valueOf(isCustom));
				}
				proxyTemplate.setMediaType(e.getAttribute("mediaType"));
				proxyTemplate.setDefaultExtension(e.getAttribute("extension"));
				templateList.add(proxyTemplate);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	static {
		loadProxyTemplateInfo();
	}
	
	public static ArtifactTemplate[] getArtifactTemplates(Map<String, List<String>> filters){
		if (filters==null || filters.size()==0 || !DeveloperStudioProviderUtils.isFilterPresent(filters, CSProviderConstants.FILTER_MEDIA_TYPE)){
			return templateList.toArray(new ArtifactTemplate[]{});
		}else{
			List<ArtifactTemplate> filteredTemplateList=new ArrayList<ArtifactTemplate>();
			for (ArtifactTemplate artifactTemplate : templateList) {
				if (artifactTemplate.getMediaType()!=null && DeveloperStudioProviderUtils.isMediaTypeFilterPassed(filters, artifactTemplate.getMediaType())){
					
					filteredTemplateList.add(artifactTemplate);
				}
			}
			return filteredTemplateList.toArray(new ArtifactTemplate[]{});
		}
	}
	
	public static ArtifactTemplate getArtifactTemplates(String id){
			for (ArtifactTemplate artifactTemplate : templateList) {
				if (artifactTemplate.getId().equals(id)){
					return artifactTemplate;
				}
			}
			return null;
	}

}
