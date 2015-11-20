package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.text.Element;
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.wso2.carbon.relay.mediators.builder.xml.BuilderMediatorFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BuilderMediatorExt;

public class BuilderMediatorExtFactory extends BuilderMediatorFactory {

	public Mediator createSpecificMediator(OMElement elem, Properties properties) {
		
		BuilderMediatorExt builderExt = new BuilderMediatorExt();
		
		List<MessageBuilder> msgBuilderList =  new ArrayList<MessageBuilder>();
		
		for(@SuppressWarnings("unchecked")
		Iterator<Element> it = elem.getChildrenWithLocalName("messageBuilder"); it.hasNext();){
			
			OMElement msgBuild  =  (OMElement) it.next();
			
			MessageBuilder msgBuilder = EsbFactory.eINSTANCE.createMessageBuilder();
			
			OMAttribute contentType = msgBuild.getAttribute(new QName("contentType"));
			
			OMAttribute builderClazz = msgBuild.getAttribute(new QName("class"));
			
			OMAttribute formatterClass = msgBuild.getAttribute(new QName("formatterClass"));
			
			if(contentType != null && contentType.getAttributeValue() != null){
			msgBuilder.setContentType(contentType.getAttributeValue());
			}
			if(builderClazz != null && builderClazz.getAttributeValue() != null){
			msgBuilder.setBuilderClass(builderClazz.getAttributeValue());
			}
			if(formatterClass != null && formatterClass.getAttributeValue() != null){
			msgBuilder.setFormatterClass(formatterClass.getAttributeValue());
			}
			
			msgBuilderList.add(msgBuilder);
		}
		
		builderExt.setMessageBuilderList(msgBuilderList);
		
		return builderExt;
		
	}
}
