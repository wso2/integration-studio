package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CalloutMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence()
					.addChild(createCalloutMediator(subject));
			/*
			 * Transform the property mediator output data flow path.
			 */
			doTransform(information,
					((CalloutMediator) subject).getOutputConnector());
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
			sequence.addChild(createCalloutMediator(subject));
			doTransformWithinSequence(information, ((CalloutMediator) subject)
					.getOutputConnector().getOutgoingLink(), sequence);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private org.apache.synapse.mediators.builtin.CalloutMediator createCalloutMediator(
			EsbNode subject) throws TransformerException, JaxenException {
		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof CalloutMediator, "Invalid subject.");
		CalloutMediator visualCallout = (CalloutMediator) subject;
		/*
		 * Configure Callout mediator.
		 */
		org.apache.synapse.mediators.builtin.CalloutMediator calloutMediator = new org.apache.synapse.mediators.builtin.CalloutMediator();
		setCommonProperties(calloutMediator, visualCallout);
		
		       // Fixing TOOLS-2636
				if (visualCallout.getEndpointType().getValue() == CalloutEndpointType.URL_VALUE) {		
					if (StringUtils.isNotEmpty(visualCallout.getServiceURL())) {
						calloutMediator.setServiceURL(visualCallout.getServiceURL());
					}
				} else if (visualCallout.getEndpointType().getValue() == CalloutEndpointType.ADDRESS_ENDPOINT_VALUE) {
						if (visualCallout.getAddressEndpoint() != null && StringUtils.isNotBlank(visualCallout.getAddressEndpoint().getKeyValue())) {
							calloutMediator.setEndpointKey(visualCallout.getAddressEndpoint().getKeyValue());
			             }
		            }
			
			if (visualCallout.getSoapAction()!=null && !visualCallout.getSoapAction().isEmpty()) {
				calloutMediator.setAction(visualCallout.getSoapAction());
			}
				
			calloutMediator.setInitClientOptions(visualCallout.isInitAxis2ClientOptions());
			
			if (visualCallout.getPayloadType().getValue() == 0) {

				NamespacedProperty payLoadExp = visualCallout
						.getPayloadMessageXpath();
				if (payLoadExp != null
						&& !payLoadExp.getPropertyValue().equals("")) {

					SynapseXPath xpath = new SynapseXPath(
							payLoadExp.getPropertyValue());
					Map<String, String> nameSpaceMap = payLoadExp
							.getNamespaces();

					for (String key : nameSpaceMap.keySet()) {

						xpath.addNamespace(key, nameSpaceMap.get(key));
					}

					calloutMediator.setRequestXPath(xpath);
				}

			} else if(visualCallout.getPayloadType().getValue()==CalloutPayloadType.ENVELOPE_VALUE){
				  calloutMediator.setUseEnvelopeAsSource(true);
			} else {
				if (visualCallout.getPayloadProperty() != null) {
					// Fixing TOOLS-2637
					if (StringUtils.isNotEmpty(visualCallout.getPayloadProperty())) {
						calloutMediator.setRequestKey(visualCallout.getPayloadProperty());
					}
				}
			}

			if (visualCallout.getResultType().getValue() == 0) {

				NamespacedProperty resultExp = visualCallout
						.getResultMessageXpath();
				if (resultExp != null
						&& !resultExp.getPropertyValue().equals("")) {

					SynapseXPath resultXPath = new SynapseXPath(
							resultExp.getPropertyValue());
					Map<String, String> nameSpaceMap = resultExp
							.getNamespaces();

					for (String key : nameSpaceMap.keySet()) {

						resultXPath.addNamespace(key, nameSpaceMap.get(key));
					}

					calloutMediator.setTargetXPath(resultXPath);
				}

			} else {
				// Fixing TOOLS-2598
				if (StringUtils.isNotEmpty(visualCallout.getResultContextProperty())) {
					calloutMediator.setTargetKey(visualCallout.getResultContextProperty());
				}
			}
			// Fixing TOOLS-2598
			if (StringUtils.isNotEmpty(visualCallout.getPathToAxis2Repository())) {
				calloutMediator.setClientRepository(visualCallout.getPathToAxis2Repository());
			}
			// Fixing TOOLS-2598
			if (StringUtils.isNotEmpty(visualCallout.getPathToAxis2xml())) {
				calloutMediator.setAxis2xml(visualCallout.getPathToAxis2xml());
			}
			if(visualCallout.getSecurityType().getValue()==CalloutSecurityType.TRUE_VALUE){
				calloutMediator.setSecurityOn(true);
		        if(visualCallout.getPolicies().getValue()==CalloutSecurityPolicies.TRUE_VALUE){
		        	if((visualCallout.getInboundPolicyKey()!=null)){
		        	calloutMediator.setInboundWsSecPolicyKey(visualCallout.getInboundPolicyKey().getKeyValue());
		        	}
		        	if((visualCallout.getOutboundPolicyKey()!=null)){
		        	calloutMediator.setOutboundWsSecPolicyKey(visualCallout.getOutboundPolicyKey().getKeyValue());
		        	}
		        }else{
		        	if(visualCallout.getPolicyKey()!=null){
		        	calloutMediator.setWsSecPolicyKey(visualCallout.getPolicyKey().getKeyValue());
		        	}
		        }
		        
			}
		return calloutMediator;
	}
}
