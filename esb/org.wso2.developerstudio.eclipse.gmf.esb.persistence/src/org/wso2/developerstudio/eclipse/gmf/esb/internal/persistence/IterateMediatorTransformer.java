package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map;

import org.apache.synapse.config.xml.AnonymousListMediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.eip.Target;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class IterateMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws Exception {
		information.getParentSequence().addChild(createIterateMediator(information,subject));
		/*
		 *  Transform the property mediator output data flow path.
		 */
		doTransform(information,
				((IterateMediator) subject).getOutputConnector());		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		sequence.addChild(createIterateMediator(information,subject));
		doTransformWithinSequence(information,((IterateMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
	}
	
	private org.apache.synapse.mediators.eip.splitter.IterateMediator createIterateMediator(TransformationInfo information,EsbNode subject) throws Exception{
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof IterateMediator, "Invalid subject.");
		IterateMediator visualIterate = (IterateMediator) subject;

		/*
		 *  Configure Iterate mediator.
		 */
		org.apache.synapse.mediators.eip.splitter.IterateMediator iterateMediator = new org.apache.synapse.mediators.eip.splitter.IterateMediator();
		setCommonProperties(iterateMediator, visualIterate);
		{	
			NamespacedProperty iterateExp = visualIterate.getIterateExpression();
			
			if(iterateExp != null && !iterateExp.getPropertyValue().equals("")){
				
				SynapseXPath xpath = new SynapseXPath(iterateExp.getPropertyValue());
				Map<String, String> nameSpaceMap = iterateExp.getNamespaces();
				
				
				for(String key : nameSpaceMap.keySet()){
					
					xpath.addNamespace(key, nameSpaceMap.get(key));
				}
				
				iterateMediator.setExpression(xpath);
				
			}
			
			if(visualIterate.isPreservePayload()){
				iterateMediator.setPreservePayload(true);
				NamespacedProperty attachedPath = visualIterate.getAttachPath();
				if(attachedPath != null && !attachedPath.getPropertyValue().equals("")){
					SynapseXPath xpath = new SynapseXPath(attachedPath.getPropertyValue());
					Map<String, String> nameSpaceMap = attachedPath.getNamespaces();
					for(String key : nameSpaceMap.keySet()){
						xpath.addNamespace(key, nameSpaceMap.get(key));
					}
					iterateMediator.setAttachPath(xpath);
				}
			} else{
				iterateMediator.setPreservePayload(false);
			}
			
			iterateMediator.setContinueParent(visualIterate.isContinueParent());
			
			iterateMediator.setId(visualIterate.getIterateID());	
			
			Target target = new Target();
			target.setSoapAction(visualIterate.getTarget().getSoapAction());
			target.setToAddress(visualIterate.getTarget().getToAddress());
			
			switch (visualIterate.getSequenceType()) {
			case ANONYMOUS:
				//ListMediator targetList = new AnonymousListMediator();
				SequenceMediator targetSequence=new SequenceMediator();
				
				TransformationInfo newInfo = new TransformationInfo();
				newInfo.setTraversalDirection(information.getTraversalDirection());
				newInfo.setSynapseConfiguration(information.getSynapseConfiguration());
				newInfo.setOriginInSequence(information.getOriginInSequence());
				newInfo.setOriginOutSequence(information.getOriginOutSequence());
				newInfo.setCurrentProxy(information.getCurrentProxy());
				newInfo.setParentSequence(targetSequence);
				doTransform(newInfo,visualIterate.getTargetOutputConnector());
				
				//targetSequence.addAll(targetList.getList());
				target.setSequence(targetSequence);
				break;
				
			case REGISTRY_REFERENCE:
				target.setSequenceRef(visualIterate.getSequenceKey().getKeyValue());
				break;
				
			case NAMED_REFERENCE:
				target.setSequenceRef(visualIterate.getSequenceName());
				break;
			}
			
			if(visualIterate.isSequentialMediation()) {
				target.setAsynchronous(false);
			}
						
			iterateMediator.setTarget(target);

		}
		return iterateMediator;
	}

}
