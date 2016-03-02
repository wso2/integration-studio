package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

public class TransformerUtils {

	public static TransformationInfo cloneTransformationInfo(TransformationInfo info){
		TransformationInfo information=new TransformationInfo();
		information.setCurrentAPI(info.getCurrentAPI());
		information.setCurrentProxy(info.getCurrentProxy());
		information.setCurrentReferredSequence(info.getCurrentReferredSequence());
		information.setMainSequence(info.getMainSequence());
		information.setOriginInSequence(info.getOriginInSequence());
		information.setOriginOutSequence(info.getOriginOutSequence());
		information.setParentSequence(info.getParentSequence());
		information.setPreviousNode(info.getPreviouNode());
		information.setSynapseConfiguration(info.getSynapseConfiguration());
		information.setTraversalDirection(info.getTraversalDirection());	
		
		return information;
	}
	
}
