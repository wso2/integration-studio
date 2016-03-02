package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class HeaderMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence().addChild(createHeaderMediator(subject));
			/* 
			 * Transform the Header mediator output data flow path.
			 */
			doTransform(information,((HeaderMediator) subject).getOutputConnector());
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild(createHeaderMediator(subject));
			doTransformWithinSequence(information,((HeaderMediator) subject).getOutputConnector().getOutgoingLink(),sequence);	
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}	
	}
	
	private org.apache.synapse.mediators.transform.HeaderMediator createHeaderMediator(EsbNode subject) throws JaxenException{
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof HeaderMediator, "Invalid subject.");
		HeaderMediator visualHeader = (HeaderMediator) subject;
		/* 
		 * Configure Header mediator.
		 */
		org.apache.synapse.mediators.transform.HeaderMediator headerMediator = new org.apache.synapse.mediators.transform.HeaderMediator();	
		setCommonProperties(headerMediator, visualHeader);
		{
			if (visualHeader.getValueType().getValue()!=2) {
				if (!visualHeader.getHeaderName().getNamespaces().keySet()
						.isEmpty()) {
					String prefix = (String) visualHeader.getHeaderName()
							.getNamespaces().keySet().toArray()[0];
					String namespaceUri = visualHeader
							.getHeaderName()
							.getNamespaces()
							.get(visualHeader.getHeaderName().getNamespaces()
									.keySet().toArray()[0]);
					String localPart = visualHeader.getHeaderName()
							.getPropertyValue();
					headerMediator.setQName(new QName(namespaceUri, localPart,
							prefix));
				} else {
					headerMediator.setQName(new QName(visualHeader
							.getHeaderName().getPropertyValue()));
				}
			}
			headerMediator.setAction(visualHeader.getHeaderAction().getValue());
			headerMediator.setScope(visualHeader.getScope().toString());
			
			if(visualHeader.getValueType().getValue()==0){
				headerMediator.setValue(visualHeader.getValueLiteral());
			}else if(visualHeader.getValueType().getValue()==2){
				try{
					StringBuilder builder = new StringBuilder();
					builder.append("<root>");
					builder.append(visualHeader.getValueInline());
					builder.append("</root>");
					       OMElement stringToOM = AXIOMUtil.stringToOM(builder.toString());
					       Iterator<OMElement> childElements = stringToOM.getChildElements();
					       while(childElements.hasNext()){
					    	   OMElement next = childElements.next();
					    	   headerMediator.addEmbeddedXml(next);
					       }
				}catch(Exception ex){
					/*Ignored if user body is not in the xml format*/
				}
			}else{
				SynapseXPath synapseXPath=new SynapseXPath(visualHeader.getValueExpression().getPropertyValue());
				for(int i=0;i<visualHeader.getValueExpression().getNamespaces().keySet().size();++i){				
					String prefix=(String)visualHeader.getValueExpression().getNamespaces().keySet().toArray()[i];
					String namespaceUri=visualHeader.getValueExpression().getNamespaces().get(prefix);
					synapseXPath.addNamespace(prefix, namespaceUri);
				}
				headerMediator.setExpression(synapseXPath);
			}
		}		
		return headerMediator;
	}
	
}
