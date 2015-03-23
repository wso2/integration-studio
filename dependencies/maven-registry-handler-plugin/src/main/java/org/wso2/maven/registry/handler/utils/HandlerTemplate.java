package org.wso2.maven.registry.handler.utils;

import org.wso2.maven.core.utils.TemplateUtil;

public class HandlerTemplate extends TemplateUtil {
	private static HandlerTemplate INSTANCE;
	public static HandlerTemplate getInstance(){
		if (INSTANCE==null){
			INSTANCE=new HandlerTemplate();
		}
		return INSTANCE;
	}
	protected Class<?> getTemplateClass() {
		return HandlerTemplate.class;
	}
}
