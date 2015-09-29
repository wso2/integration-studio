package org.wso2.developerstudio.eclipse.artifact.gadget.template;

import org.wso2.developerstudio.eclipse.artifact.gadget.model.GadgetModel;

public class GadgetTemplate {

	public static String createGadgetXmlTemp(String projectName){
		
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
           buffer.append("<Module>\n");
           buffer.append("<ModulePrefs title=");
           buffer.append("\""+projectName+"\""+" author_email=" + "\"" +"\"" + ">\n");
           buffer.append("</ModulePrefs>\n");
           buffer.append("</Module>\n");
           
         return buffer.toString();  
	}
	
	public static String createGadgetConf(GadgetModel model){
		
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
		   buffer.append("<gadget>\n");
           buffer.append("\t<name>");
           buffer.append(model.getProjectName());
           buffer.append("</name>\n");
           buffer.append("\t<author>");
           buffer.append(model.getAuthor());
           buffer.append("</author>\n");
           buffer.append("\t<path>");
           buffer.append("/registry/resource/_system/config/repository/gadget-server/gadgets/");
           buffer.append(model.getProjectName());
           buffer.append("/");
           buffer.append(model.getGadgetXml().replaceAll(".xml$","").concat(".xml"));
           buffer.append("</path>\n");
           buffer.append("\t<description>");
           buffer.append(model.getDescription().replace("\n","\n\t\t"));
           buffer.append("</description>\n");
           buffer.append("</gadget>");
           
         return buffer.toString();  
	}
	
	
	
}
