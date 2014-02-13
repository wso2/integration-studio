package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class CallMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {		
		org.apache.synapse.mediators.builtin.CallMediator callMediator = createCallMediator(subject);
		if(callMediator!=null){
			information.getParentSequence().addChild(callMediator);
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
		if(((CallMediator) subject).getEndpointType() == CallMediatorEndpointType.INLINE){
			doTransform(tmpInformation, ((CallMediator) subject).getEndpointOutputConnector());  //to transform the mediators inside the mediator
		}
		doTransform(information, ((CallMediator) subject).getOutputConnector()); //continue in normal flow
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		org.apache.synapse.mediators.builtin.CallMediator callMediator = createCallMediator(subject);
		if(callMediator!=null){
			sequence.addChild(callMediator);
		}		
		if(((CallMediator) subject).getEndpointType() == CallMediatorEndpointType.INLINE){
			//to transform the mediators inside the mediator
			doTransformWithinSequence(information,((CallMediator) subject).getEndpointOutputConnector().getOutgoingLink(),sequence);
		}
		// to go in normal flow
		doTransformWithinSequence(information,((CallMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}
	
	private org.apache.synapse.mediators.builtin.CallMediator createCallMediator(EsbNode subject) throws Exception{
		// Check subject.
		Assert.isTrue(subject instanceof CallMediator, "Invalid subject.");
		CallMediator visualCallMediator = (CallMediator) subject;
		
		// Configure call mediator.
		org.apache.synapse.mediators.builtin.CallMediator synapseCallMediator = new org.apache.synapse.mediators.builtin.CallMediator();
		setCommonProperties(synapseCallMediator, visualCallMediator);
		
		if (visualCallMediator.getEndpointType() == CallMediatorEndpointType.XPATH) {
			NamespacedProperty nameSpacedProperty = visualCallMediator.getEndpointXpath();
			Endpoint resolvingEndpoint = getEndpointFromXpath(nameSpacedProperty);
			synapseCallMediator.setEndpoint(null);
			synapseCallMediator.setEndpoint(resolvingEndpoint);
		} else if (visualCallMediator.getEndpointType() == CallMediatorEndpointType.REGISRTYKEY) {
			RegistryKeyProperty regKey = visualCallMediator.getEndpointRegistrykey();
			IndirectEndpoint indirectEndpoint = new IndirectEndpoint();
			indirectEndpoint.setKey(regKey.getKeyValue());
			synapseCallMediator.setEndpoint(null);
			synapseCallMediator.setEndpoint(indirectEndpoint);
		} else {
			synapseCallMediator.setEndpoint(null);
		}
		
		return synapseCallMediator;
	}
	
	public ResolvingEndpoint getEndpointFromXpath(NamespacedProperty nameSpacedProperty) throws Exception {
				
		SynapseXPath synapseXPath = new SynapseXPath(nameSpacedProperty.getPropertyValue());
		for (int i = 0; i < nameSpacedProperty.getNamespaces().keySet().size(); ++i) {
			String prefix = (String) nameSpacedProperty.getNamespaces().keySet().toArray()[i];
			String namespaceUri = nameSpacedProperty.getNamespaces().get(prefix);
			synapseXPath.addNamespace(prefix, namespaceUri);
		}
		ResolvingEndpoint resolvingEndpoint = new ResolvingEndpoint();
		resolvingEndpoint.setKeyExpression(synapseXPath);
		return resolvingEndpoint;
	}

}
