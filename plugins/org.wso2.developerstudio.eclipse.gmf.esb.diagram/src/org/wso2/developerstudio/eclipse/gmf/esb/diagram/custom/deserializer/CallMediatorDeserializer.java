package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.END_POINT__REVERSED;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_REGISTRYKEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT_XPATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENDPOINT;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.CALL_MEDIATOR__ENABLE_BLOCKING_CALLS;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.IndirectEndpoint;
import org.apache.synapse.endpoints.ResolvingEndpoint;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class CallMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, CallMediator> {

	public CallMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.CallMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.builtin.CallMediator callMediator = (org.apache.synapse.mediators.builtin.CallMediator)mediator;
		
		CallMediator visualCallMediator = (CallMediator) DeserializerUtils.createNode(part, EsbElementTypes.CallMediator_3742);
		setElementToEdit(visualCallMediator);
		setCommonProperties(callMediator, visualCallMediator);
		
		refreshEditPartMap();
		EditPart mediatorFlow=getEditpart(visualCallMediator.getMediatorFlow());
	
		Endpoint endPoint = callMediator.getEndpoint();
		CallMediatorEndpointType endPointType = getEndpointType(endPoint);
		executeSetValueCommand(CALL_MEDIATOR__ENDPOINT_TYPE, endPointType);
		executeSetValueCommand(CALL_MEDIATOR__ENABLE_BLOCKING_CALLS, callMediator.isBlocking());
		if(endPoint!=null){
			@SuppressWarnings("rawtypes")
			IEsbNodeDeserializer deserializer = EsbDeserializerRegistry.getInstance().getDeserializer(endPoint);
			@SuppressWarnings("unchecked")
			//EndPoint visualEndPoint = (EndPoint) deserializer.createNode(getRootCompartment(), endpoint);
			EndPoint visualEndPoint = (EndPoint) deserializer.createNode((IGraphicalEditPart) mediatorFlow.getChildren().get(0), endPoint);
			if(isReversed()){
				executeSetValueCommand(visualEndPoint,END_POINT__REVERSED,true);
			}
			//visualCallMediator.setNextNode(visualEndPoint);
			
			if(endPointType == CallMediatorEndpointType.REGISRTYKEY){
				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				IndirectEndpoint indeirectEP = (IndirectEndpoint)endPoint;
				regkey.setKeyValue(indeirectEP.getKey());
				executeSetValueCommand(CALL_MEDIATOR__ENDPOINT_REGISTRYKEY, regkey);
			} else if(endPointType == CallMediatorEndpointType.XPATH){
				ResolvingEndpoint resolvingEndpoint = (ResolvingEndpoint)endPoint;
				SynapseXPath xpath = resolvingEndpoint.getKeyExpression();
				NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
				executeSetValueCommand(CALL_MEDIATOR__ENDPOINT_XPATH, namespaceProp);
			}
		} 
		
		executeSetValueCommand(CALL_MEDIATOR__ENDPOINT, endPoint);
		
		return visualCallMediator;
	}

	private CallMediatorEndpointType getEndpointType(Endpoint endPoint) {
		CallMediatorEndpointType endPointType = CallMediatorEndpointType.INLINE;
		if (endPoint == null) {
			//endPointType = CallMediatorEndpointType.NONE; //- Fixing TOOLS-3286
		} else if (endPoint instanceof IndirectEndpoint) {
			endPointType = CallMediatorEndpointType.REGISRTYKEY;
		} else if (endPoint instanceof ResolvingEndpoint) {
			endPointType = CallMediatorEndpointType.XPATH;
		}
		return endPointType;
	}
	
	
}