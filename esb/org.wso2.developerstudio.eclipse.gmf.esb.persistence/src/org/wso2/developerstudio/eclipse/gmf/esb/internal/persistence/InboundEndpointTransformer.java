package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.inbound.InboundEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class InboundEndpointTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws Exception {
		Assert.isTrue(subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint,
						"Invalid subject.");
				org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint = (org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint) subject;

		information.getSynapseConfiguration().addInboundEndpoint(visualInboundEndpoint.getName(), create(visualInboundEndpoint));
    }

	public void createSynapseObject(TransformationInfo info, EObject subject,
                                    List<Endpoint> endPoints) throws Exception {
	    // TODO Auto-generated method stub
	    
    }

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
                                        SequenceMediator sequence) throws Exception {
	    // TODO Auto-generated method stub
	    
    }
	/**
	 * User can retrieve associated sequence providing the relevant output connector.    
	 * @param outputConnector
	 * @return
	 */
	private Sequence getSequence(OutputConnector outputConnector) {
		EObject container;
		if (outputConnector != null) {
			EsbLink link = outputConnector.getOutgoingLink();
			if (link != null) {
				container = link.getTarget().eContainer();
				if(container instanceof Sequence){
					return (Sequence)container;
				}
			}
		}
		return null;
	}
	
	/**
	 * Create an org.apache.synapse.inbound.InboundEndpoint object from an 
	 * org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint 
	 * @param visualInboundEndpoint
	 * @return
	 * @throws Exception
	 */
	private InboundEndpoint create(org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint visualInboundEndpoint) throws Exception{
		InboundEndpoint inboundEndpoint= new InboundEndpoint();
		inboundEndpoint.setName(visualInboundEndpoint.getName());	
		Sequence sequence = getSequence(visualInboundEndpoint.getSequenceOutputConnector());
		if(sequence !=null){
			inboundEndpoint.setInjectingSeq(sequence.getName());
		}else {
			throw new Exception();
		}
		Sequence onErrorSequence = getSequence(visualInboundEndpoint.getOnErrorSequenceOutputConnector());
		if(onErrorSequence !=null){
			inboundEndpoint.setOnErrorSeq(onErrorSequence.getName());
		}else {
			throw new Exception();
		}
		inboundEndpoint.setClassImpl("class");
		inboundEndpoint.setFileName("file");				
		inboundEndpoint.setProtocol("http");
		inboundEndpoint.setSuspend(false);
		return inboundEndpoint;
	}

}
