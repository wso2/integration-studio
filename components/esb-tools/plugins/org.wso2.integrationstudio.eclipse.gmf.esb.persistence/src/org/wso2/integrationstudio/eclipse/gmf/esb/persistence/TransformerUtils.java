package org.wso2.integrationstudio.eclipse.gmf.esb.persistence;

import org.apache.synapse.endpoints.Endpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.AddressEndPointImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.FailoverEndPointImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.TemplateEndpointImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.AddressEndPointTransformer;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.FailoverEndPointTransformer;
import org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence.TemplateEndPointTransformer;

public class TransformerUtils {

    public static TransformationInfo cloneTransformationInfo(TransformationInfo info) {
        TransformationInfo information = new TransformationInfo();
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
    
    public static Endpoint getSynapseEndpoint(org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint viEndpoint)
            throws TransformerException {
        Endpoint endpoint = null;
        if (viEndpoint instanceof AddressEndPointImpl) {
            AddressEndPointTransformer transformer = new AddressEndPointTransformer();
            endpoint = transformer.create((AddressEndPoint) viEndpoint, "");

        } else if (viEndpoint instanceof TemplateEndpointImpl) {
        	TemplateEndPointTransformer transformer = new TemplateEndPointTransformer();
        	endpoint = transformer.create((TemplateEndpoint) viEndpoint, "");
        	
        } else if (viEndpoint instanceof FailoverEndPointImpl) {
        	FailoverEndPointTransformer transformer = new FailoverEndPointTransformer();
        	endpoint = transformer.create(null, (FailoverEndPoint) viEndpoint, "", null);
        }
        
        return endpoint;
    }

}
