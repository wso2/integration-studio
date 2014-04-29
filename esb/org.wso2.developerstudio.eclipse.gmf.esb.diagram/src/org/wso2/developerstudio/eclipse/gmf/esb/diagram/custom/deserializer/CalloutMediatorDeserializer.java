package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutPayloadType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityPolicies;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutSecurityType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class CalloutMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CalloutMediator>{

	public CalloutMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.CalloutMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.builtin.CalloutMediator calloutMediator = (org.apache.synapse.mediators.builtin.CalloutMediator)mediator;
		
		CalloutMediator visualCalloutMediator = (CalloutMediator) DeserializerUtils.createNode(part, EsbElementTypes.CalloutMediator_3520);
		setElementToEdit(visualCalloutMediator);	
		setCommonProperties(calloutMediator, visualCalloutMediator);
		
		if(calloutMediator.getServiceURL()!=null){
			executeSetValueCommand(CALLOUT_MEDIATOR__SERVICE_URL, calloutMediator.getServiceURL());
			executeSetValueCommand(CALLOUT_MEDIATOR__ENDPOINT_TYPE, CalloutEndpointType.URL);
		}else if (StringUtils.isNotBlank(calloutMediator.getEndpointKey())){
			RegistryKeyProperty keyProperty=EsbFactory.eINSTANCE.createRegistryKeyProperty();
			keyProperty.setKeyValue(calloutMediator.getEndpointKey());
	        executeSetValueCommand(CALLOUT_MEDIATOR__ADDRESS_ENDPOINT, keyProperty);
	        executeSetValueCommand(CALLOUT_MEDIATOR__ENDPOINT_TYPE, CalloutEndpointType.ADDRESS_ENDPOINT);
		}
		
		
		executeSetValueCommand(CALLOUT_MEDIATOR__SOAP_ACTION, calloutMediator.getAction());
		executeSetValueCommand(CALLOUT_MEDIATOR__INIT_AXIS2_CLIENT_OPTIONS, calloutMediator.getInitClientOptions());
		
		if(calloutMediator.getRequestXPath()!=null){
			executeSetValueCommand(CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH, createNamespacedProperty(calloutMediator.getRequestXPath()));
			executeSetValueCommand(CALLOUT_MEDIATOR__PAYLOAD_TYPE, CalloutPayloadType.XPATH);
		}else if(calloutMediator.getRequestKey()!=null){
			executeSetValueCommand(CALLOUT_MEDIATOR__PAYLOAD_PROPERTY, calloutMediator.getRequestKey());
			executeSetValueCommand(CALLOUT_MEDIATOR__PAYLOAD_TYPE, CalloutPayloadType.PROPERTY);
		}else if(calloutMediator.isUseEnvelopeAsSource()){
			executeSetValueCommand(CALLOUT_MEDIATOR__PAYLOAD_TYPE, CalloutPayloadType.ENVELOPE);
		}
		
		if(calloutMediator.getTargetXPath()!=null){
			executeSetValueCommand(CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH, createNamespacedProperty(calloutMediator.getTargetXPath()));
			executeSetValueCommand(CALLOUT_MEDIATOR__RESULT_TYPE, CalloutResultType.XPATH);
		}else{
			executeSetValueCommand(CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY, calloutMediator.getTargetKey());
			executeSetValueCommand(CALLOUT_MEDIATOR__RESULT_TYPE, CalloutResultType.PROPERTY);
		}
		
		if(calloutMediator.getClientRepository()!=null){
			executeSetValueCommand(CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY,calloutMediator.getClientRepository());
		}
		if(calloutMediator.getAxis2xml()!=null){
			executeSetValueCommand(CALLOUT_MEDIATOR__PATH_TO_AXIS2XML, calloutMediator.getAxis2xml());
		}
		
		if(calloutMediator.isSecurityOn()){
			executeSetValueCommand(CALLOUT_MEDIATOR__SECURITY_TYPE, CalloutSecurityType.TRUE);
			if(calloutMediator.getWsSecPolicyKey()!=null){
				RegistryKeyProperty keyProperty=EsbFactory.eINSTANCE.createRegistryKeyProperty();
				keyProperty.setKeyValue(calloutMediator.getWsSecPolicyKey());
				executeSetValueCommand(CALLOUT_MEDIATOR__POLICY_KEY,keyProperty);
			}else{
				executeSetValueCommand(CALLOUT_MEDIATOR__POLICIES, CalloutSecurityPolicies.TRUE);
				if(calloutMediator.getInboundWsSecPolicyKey()!=null){
					RegistryKeyProperty keyProperty=EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(calloutMediator.getInboundWsSecPolicyKey());
					executeSetValueCommand(CALLOUT_MEDIATOR__INBOUND_POLICY_KEY,keyProperty);
				}
				if(calloutMediator.getOutboundWsSecPolicyKey()!=null){
					RegistryKeyProperty keyProperty=EsbFactory.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(calloutMediator.getOutboundWsSecPolicyKey());
					executeSetValueCommand(CALLOUT_MEDIATOR__OUTBOUND_POLICY_KEY,keyProperty);
				}
			}
		}
		return visualCalloutMediator;
	}
}
