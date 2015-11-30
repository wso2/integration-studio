package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.templates;

import java.io.File;

import org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.model.CarbonUiModel;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;


public class CarbonUIbudleTemplate {

	public static String createActivatorClassTemplete(String packgeName,String className) throws Exception{
		 		ITemporaryFileTag carbonUITempTag = FileUtils.createNewTempTag();
				File resourceFile = new CarbonUIBundleTemplateUtils().getResourceFile("templates/Activator.temp");
				String fileContent = FileUtils.getContentAsString(resourceFile);
				
				if(!"".equals(packgeName)){
				fileContent = fileContent.replace("package", "package " + packgeName + ";");
				}else{
					fileContent = fileContent.replace("package","");
				}
				carbonUITempTag.clearAndEnd();
				return fileContent;
	}
	
	public static String createTemplete(String resourceName) throws Exception{
		ITemporaryFileTag carbonUITempTag = FileUtils.createNewTempTag();
		File resourceFile = new CarbonUIBundleTemplateUtils().getResourceFile("templates/" + resourceName);
		String fileContent = FileUtils.getContentAsString(resourceFile);
		carbonUITempTag.clearAndEnd();
		return fileContent;
}

	public static String createComponentXMLTemplate(){
		
		   StringBuffer buffer = new StringBuffer();           
           buffer.append("<?xml version=");
           buffer.append("\"");
           buffer.append("1.0");
           buffer.append("\"");
           buffer.append(" encoding=");
           buffer.append("\"");
           buffer.append("UTF-8");
           buffer.append("\"");
           buffer.append(" ?> \n");
           buffer.append("<component xmlns=");
           buffer.append("\"");
           buffer.append("http://products.wso2.org/carbon");
           buffer.append("\"");
           buffer.append(" > \n");
           buffer.append("</component>");
           
           return buffer.toString();
	}
	
	public static String createManifestFileTemplate(CarbonUiModel uibundleModel){
	
		StringBuffer buffer = new StringBuffer();   
        buffer.append("Manifest-Version: 1.0 \n");
        buffer.append("Bundle-ActivationPolicy: lazy \n");
        buffer.append("Bundle-Name: ");
        buffer.append(uibundleModel.getName());
        buffer.append("\n");
        buffer.append("Bundle-Version: ");
        buffer.append(uibundleModel.getVersion());
        buffer.append("\n");
        buffer.append("Bundle-Activator: ");
        buffer.append(uibundleModel.getActivatorClassName());
        buffer.append("\n");
        buffer.append("Bundle-ManifestVersion: 2");
        buffer.append("\n");
        buffer.append("Carbon-Component: UIBundle");
        buffer.append("\n");
        buffer.append("Import-Package: org.osgi.framework;");
        buffer.append("version=");
        buffer.append("\"");
        buffer.append("1.3.0");
        buffer.append("\"");
        buffer.append("\n");
        buffer.append("Bundle-SymbolicName: ");
        buffer.append(uibundleModel.getId());
        buffer.append(";singleton:=true\n");
        
        return buffer.toString();
	}
}