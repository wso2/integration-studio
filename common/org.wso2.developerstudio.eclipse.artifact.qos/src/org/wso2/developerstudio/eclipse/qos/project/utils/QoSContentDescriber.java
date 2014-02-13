package org.wso2.developerstudio.eclipse.qos.project.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.XMLContentDescriber;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.qos.Activator;
import org.wso2.developerstudio.eclipse.qos.project.model.ServiceGroup;

public class QoSContentDescriber extends XMLContentDescriber {

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	@Override
	public int describe(InputStream input, IContentDescription description)throws IOException {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ServiceGroup.class);
			Unmarshaller uUnmarshaller = jaxbContext.createUnmarshaller();
		    ServiceGroup group	=(ServiceGroup) uUnmarshaller.unmarshal(input);
		
				return VALID;
		} catch (Exception e) {
			log.warn(e);
			return INVALID;
		}
		
	}
}
