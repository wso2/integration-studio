package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class SendMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {		
		org.apache.synapse.mediators.builtin.SendMediator sendMediator = createSendMediator(subject);
		if(sendMediator!=null){
			information.getParentSequence().addChild(sendMediator);
		}
		
		TransformationInfo tmpInformation = new TransformationInfo();
		tmpInformation.setParentSequence(information.getParentSequence());
		tmpInformation.setTraversalDirection(information.getTraversalDirection());
		tmpInformation.setOriginInSequence(information.getOriginInSequence());
		tmpInformation.setOriginOutSequence(information.getOriginOutSequence());
		tmpInformation.setPreviousNode(information.getPreviouNode());
		tmpInformation.setSynapseConfiguration(information.getSynapseConfiguration());
		tmpInformation.setCurrentAPI(information.getCurrentAPI());
		tmpInformation.setCurrentProxy(information.getCurrentProxy());
		tmpInformation.setCurrentReferredSequence(information.getCurrentReferredSequence());
		tmpInformation.setMainSequence(information.getMainSequence());
		doTransform(tmpInformation,
					((SendMediator) subject).getEndpointOutputConnector());
		
/*		doTransform(information,
				((SendMediator) subject).getOutputConnector());*/
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		org.apache.synapse.mediators.builtin.SendMediator sendMediator = createSendMediator(subject);
		if(sendMediator!=null){
			sequence.addChild(sendMediator);
		}
		doTransformWithinSequence(information,((SendMediator) subject).getEndpointOutputConnector().getOutgoingLink(),sequence);
		//doTransformWithinSequence(information,((SendMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
		
	}
	
	private org.apache.synapse.mediators.builtin.SendMediator createSendMediator(EsbNode subject) throws Exception{
		// Check subject.
		Assert.isTrue(subject instanceof SendMediator, "Invalid subject.");
		SendMediator visualSend = (SendMediator) subject;
		
		if(visualSend.isSkipSerialization()){
			return null;
		}

		// Configure send mediator.
		org.apache.synapse.mediators.builtin.SendMediator sendMediator = new org.apache.synapse.mediators.builtin.SendMediator();
		setCommonProperties(sendMediator, visualSend);
		{
			if (visualSend.getReceivingSequenceType().getLiteral()
					.equals("Static")) {

				if (visualSend.getStaticReceivingSequence() != null
						&& visualSend.getStaticReceivingSequence()
								.getKeyValue() != null) {

					Value receivingSequence = new Value(visualSend
							.getStaticReceivingSequence().getKeyValue());
					sendMediator.setReceivingSequence(receivingSequence);
				}

			}

			if (visualSend.getReceivingSequenceType().getLiteral()
					.equals("Dynamic")) {

				if (visualSend.getDynamicReceivingSequence() != null
						&& visualSend.getDynamicReceivingSequence()
								.getPropertyValue() != null) {

					SynapseXPath expression = new SynapseXPath(visualSend
							.getDynamicReceivingSequence().getPropertyValue());

					if (visualSend.getDynamicReceivingSequence()
							.getNamespaces() != null) {

						Map<String, String> map = visualSend
								.getDynamicReceivingSequence().getNamespaces();
						Iterator<Map.Entry<String, String>> entries = map
								.entrySet().iterator();

						while (entries.hasNext()) {
							Map.Entry<String, String> entry = entries.next();
							expression.addNamespace(entry.getKey(),
									entry.getValue());
						}

						Value receivingSequence = new Value(expression);
						sendMediator.setReceivingSequence(receivingSequence);
					}
				}

			}
			
			if (visualSend.isBuildMessageBeforeSending()) {
				sendMediator.setBuildMessage(visualSend.isBuildMessageBeforeSending());
			}
			
			return sendMediator;
		}
	}

}
